package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.al.f
{
  public LinkedList<a> nWG;
  private boolean nWH;
  private List<pt> nWI;
  private List<pt> nWJ;
  
  public f()
  {
    AppMethodBeat.i(5570);
    this.nWG = new LinkedList();
    this.nWH = false;
    this.nWI = new LinkedList();
    this.nWJ = new LinkedList();
    g.aiU().a(387, this);
    g.aiU().a(new i(), 0);
    AppMethodBeat.o(5570);
  }
  
  public final void init()
  {
    AppMethodBeat.i(5571);
    long l1 = System.currentTimeMillis();
    this.nWI.clear();
    this.nWJ.clear();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.brandIconURL");
    ((StringBuilder)localObject1).append(", bizinfo.type");
    ((StringBuilder)localObject1).append(", bizinfo.status");
    ((StringBuilder)localObject1).append(", rcontact.username");
    ((StringBuilder)localObject1).append(", rcontact.conRemark");
    ((StringBuilder)localObject1).append(", rcontact.nickname");
    ((StringBuilder)localObject1).append(", rcontact.alias");
    ((StringBuilder)localObject1).append(", rcontact.conRemarkPYFull");
    ((StringBuilder)localObject1).append(", rcontact.conRemarkPYShort");
    ((StringBuilder)localObject1).append(", rcontact.showHead");
    ((StringBuilder)localObject1).append(", rcontact.pyInitial");
    ((StringBuilder)localObject1).append(", rcontact.quanPin");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(am.fqj()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    ((StringBuilder)localObject1).append(" order by showHead asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" upper(quanPin) asc, ");
    ((StringBuilder)localObject1).append(" upper(nickname) asc");
    localObject1 = ((StringBuilder)localObject1).toString();
    ad.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[] { localObject1 });
    g.ajD();
    Object localObject2 = g.ajC().gBq.a((String)localObject1, null, 2);
    localObject1 = new HashMap();
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      int i = 0;
      while (((Cursor)localObject2).moveToNext())
      {
        int j = i + 1;
        localObject3 = new am();
        ((am)localObject3).convertFrom((Cursor)localObject2);
        localObject4 = new c();
        ((c)localObject4).convertFrom((Cursor)localObject2);
        i = j;
        if (!((aw)localObject3).field_username.equals("gh_43f2581f6fd6"))
        {
          i = j;
          if (!((aw)localObject3).field_username.equals("gh_3dfda90e39d6"))
          {
            i = j;
            if (!((aw)localObject3).field_username.equals("gh_f0a92aa7146c"))
            {
              pt localpt = new pt();
              localpt.userName = ((aw)localObject3).field_username;
              localpt.contact = ((am)localObject3);
              localpt.wPN = ((c)localObject4);
              i = j;
              if (!w.zQ(localpt.userName))
              {
                ((Map)localObject1).put(localpt.userName, localpt);
                i = j;
                if (localpt.wPN.field_type != 3) {
                  if (localpt.wPN.field_type == 2)
                  {
                    this.nWI.add(localpt);
                    i = j;
                  }
                  else if (localpt.wPN.field_type != 1)
                  {
                    i = j;
                    if (localpt.wPN.field_type != 0) {}
                  }
                  else
                  {
                    this.nWJ.add(localpt);
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
      ad.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[] { Integer.valueOf(i) });
      ((Cursor)localObject2).close();
    }
    long l2 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username");
    ((StringBuilder)localObject2).append(" from rcontact");
    ((StringBuilder)localObject2).append(" where (verifyFlag & ").append(am.fqj()).append(") != 0 ");
    ((StringBuilder)localObject2).append(" and (type & 1) != 0 ");
    localObject2 = ((StringBuilder)localObject2).toString();
    ad.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[] { localObject2 });
    g.ajD();
    localObject2 = g.ajC().gBq.a((String)localObject2, null, 0);
    if (localObject2 != null)
    {
      localObject3 = new ArrayList();
      while (((Cursor)localObject2).moveToNext())
      {
        localObject4 = ((Cursor)localObject2).getString(0);
        if (!((Map)localObject1).containsKey(localObject4)) {
          ((ArrayList)localObject3).add(localObject4);
        }
      }
      ((Cursor)localObject2).close();
      ad.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), localObject3 });
      if (!((ArrayList)localObject3).isEmpty())
      {
        g.ajD();
        long l3 = g.ajC().gBq.xO(Thread.currentThread().getId());
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          as.a.hFO.aI((String)localObject2, "");
        }
        g.ajD();
        g.ajC().gBq.sJ(l3);
      }
    }
    ad.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    ad.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[] { Integer.valueOf(this.nWJ.size()), Integer.valueOf(this.nWI.size()) });
    ad.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(5571);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(5573);
    ad.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(5573);
      return;
    }
    if (paramn.getType() == 387)
    {
      paramString = ((i)paramn).nWX;
      if (paramString == null)
      {
        ad.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if ((this.nWI == null) || (this.nWJ == null))
      {
        ad.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if (paramString.size() != this.nWI.size() + this.nWJ.size()) {
        paramInt1 = 1;
      }
    }
    label309:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        init();
        paramString = this.nWG.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((a)paramString.next()).onChange();
            continue;
            paramn = this.nWI.iterator();
            pt localpt;
            do
            {
              paramInt1 = i;
              if (!paramn.hasNext()) {
                break;
              }
              localpt = (pt)paramn.next();
            } while ((localpt != null) && (paramString.contains(localpt.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label309;
            }
            paramn = this.nWJ.iterator();
            do
            {
              if (!paramn.hasNext()) {
                break;
              }
              localpt = (pt)paramn.next();
            } while ((localpt != null) && (paramString.contains(localpt.userName)));
            paramInt1 = 1;
            break;
          }
        }
      }
      AppMethodBeat.o(5573);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(5572);
    g.aiU().b(387, this);
    if (this.nWH)
    {
      ArrayList localArrayList = new ArrayList(this.nWI.size() + this.nWJ.size());
      Iterator localIterator = this.nWI.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((pt)localIterator.next());
      }
      localIterator = this.nWJ.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((pt)localIterator.next());
      }
      g.aiU().a(new n(localArrayList), 0);
    }
    AppMethodBeat.o(5572);
  }
  
  public final List<pt> zh(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.nWJ;
    }
    return this.nWI;
  }
  
  public static abstract interface a
  {
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.f
 * JD-Core Version:    0.7.0.1
 */