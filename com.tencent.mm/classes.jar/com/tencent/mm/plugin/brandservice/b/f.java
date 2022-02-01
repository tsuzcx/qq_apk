package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.w;
import com.tencent.mm.protocal.protobuf.oo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f
  implements com.tencent.mm.ak.g
{
  public LinkedList<a> nvi;
  private boolean nvj;
  private List<oo> nvk;
  private List<oo> nvl;
  
  public f()
  {
    AppMethodBeat.i(5570);
    this.nvi = new LinkedList();
    this.nvj = false;
    this.nvk = new LinkedList();
    this.nvl = new LinkedList();
    com.tencent.mm.kernel.g.agi().a(387, this);
    com.tencent.mm.kernel.g.agi().a(new i(), 0);
    AppMethodBeat.o(5570);
  }
  
  public final void init()
  {
    AppMethodBeat.i(5571);
    long l1 = System.currentTimeMillis();
    this.nvk.clear();
    this.nvl.clear();
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
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ai.fag()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    ((StringBuilder)localObject1).append(" order by showHead asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" upper(quanPin) asc, ");
    ((StringBuilder)localObject1).append(" upper(nickname) asc");
    localObject1 = ((StringBuilder)localObject1).toString();
    ac.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[] { localObject1 });
    com.tencent.mm.kernel.g.agS();
    Object localObject2 = com.tencent.mm.kernel.g.agR().ghG.a((String)localObject1, null, 2);
    localObject1 = new HashMap();
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      int i = 0;
      while (((Cursor)localObject2).moveToNext())
      {
        int j = i + 1;
        localObject3 = new ai();
        ((ai)localObject3).convertFrom((Cursor)localObject2);
        localObject4 = new c();
        ((c)localObject4).convertFrom((Cursor)localObject2);
        i = j;
        if (!((av)localObject3).field_username.equals("gh_43f2581f6fd6"))
        {
          i = j;
          if (!((av)localObject3).field_username.equals("gh_3dfda90e39d6"))
          {
            i = j;
            if (!((av)localObject3).field_username.equals("gh_f0a92aa7146c"))
            {
              oo localoo = new oo();
              localoo.userName = ((av)localObject3).field_username;
              localoo.contact = ((ai)localObject3);
              localoo.vIG = ((c)localObject4);
              i = j;
              if (!w.wT(localoo.userName))
              {
                ((Map)localObject1).put(localoo.userName, localoo);
                i = j;
                if (localoo.vIG.field_type != 3) {
                  if (localoo.vIG.field_type == 2)
                  {
                    this.nvk.add(localoo);
                    i = j;
                  }
                  else if (localoo.vIG.field_type != 1)
                  {
                    i = j;
                    if (localoo.vIG.field_type != 0) {}
                  }
                  else
                  {
                    this.nvl.add(localoo);
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
      ac.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[] { Integer.valueOf(i) });
      ((Cursor)localObject2).close();
    }
    long l2 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username");
    ((StringBuilder)localObject2).append(" from rcontact");
    ((StringBuilder)localObject2).append(" where (verifyFlag & ").append(ai.fag()).append(") != 0 ");
    ((StringBuilder)localObject2).append(" and (type & 1) != 0 ");
    localObject2 = ((StringBuilder)localObject2).toString();
    ac.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[] { localObject2 });
    com.tencent.mm.kernel.g.agS();
    localObject2 = com.tencent.mm.kernel.g.agR().ghG.a((String)localObject2, null, 0);
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
      ac.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), localObject3 });
      if (!((ArrayList)localObject3).isEmpty())
      {
        com.tencent.mm.kernel.g.agS();
        long l3 = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ar.a.hnw.aJ((String)localObject2, "");
        }
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agR().ghG.qL(l3);
      }
    }
    ac.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    ac.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[] { Integer.valueOf(this.nvl.size()), Integer.valueOf(this.nvk.size()) });
    ac.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(5571);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 0;
    AppMethodBeat.i(5573);
    ac.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(5573);
      return;
    }
    if (paramn.getType() == 387)
    {
      paramString = ((i)paramn).nvz;
      if (paramString == null)
      {
        ac.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if ((this.nvk == null) || (this.nvl == null))
      {
        ac.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(5573);
        return;
      }
      if (paramString.size() != this.nvk.size() + this.nvl.size()) {
        paramInt1 = 1;
      }
    }
    label309:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        init();
        paramString = this.nvi.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((a)paramString.next()).onChange();
            continue;
            paramn = this.nvk.iterator();
            oo localoo;
            do
            {
              paramInt1 = i;
              if (!paramn.hasNext()) {
                break;
              }
              localoo = (oo)paramn.next();
            } while ((localoo != null) && (paramString.contains(localoo.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label309;
            }
            paramn = this.nvl.iterator();
            do
            {
              if (!paramn.hasNext()) {
                break;
              }
              localoo = (oo)paramn.next();
            } while ((localoo != null) && (paramString.contains(localoo.userName)));
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
    com.tencent.mm.kernel.g.agi().b(387, this);
    if (this.nvj)
    {
      ArrayList localArrayList = new ArrayList(this.nvk.size() + this.nvl.size());
      Iterator localIterator = this.nvk.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((oo)localIterator.next());
      }
      localIterator = this.nvl.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((oo)localIterator.next());
      }
      com.tencent.mm.kernel.g.agi().a(new n(localArrayList), 0);
    }
    AppMethodBeat.o(5572);
  }
  
  public final List<oo> yx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.nvl;
    }
    return this.nvk;
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