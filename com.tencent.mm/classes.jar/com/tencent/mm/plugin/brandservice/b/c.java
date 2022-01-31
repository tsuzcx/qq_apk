package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.d;
import com.tencent.mm.cg.h;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.t;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
  implements f
{
  public LinkedList<c.a> jSL;
  private boolean jSM;
  private List<me> jSN;
  private List<me> jSO;
  
  public c()
  {
    AppMethodBeat.i(13829);
    this.jSL = new LinkedList();
    this.jSM = false;
    this.jSN = new LinkedList();
    this.jSO = new LinkedList();
    g.Rc().a(387, this);
    g.Rc().a(new e(), 0);
    AppMethodBeat.o(13829);
  }
  
  public final void init()
  {
    AppMethodBeat.i(13830);
    long l1 = System.currentTimeMillis();
    this.jSN.clear();
    this.jSO.clear();
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
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ad.dwB()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    ((StringBuilder)localObject1).append(" order by showHead asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" upper(quanPin) asc, ");
    ((StringBuilder)localObject1).append(" upper(nickname) asc");
    localObject1 = ((StringBuilder)localObject1).toString();
    ab.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[] { localObject1 });
    g.RM();
    Object localObject2 = g.RL().eHS.a((String)localObject1, null, 2);
    localObject1 = new HashMap();
    Object localObject3;
    Object localObject4;
    if (localObject2 != null)
    {
      int i = 0;
      while (((Cursor)localObject2).moveToNext())
      {
        int j = i + 1;
        localObject3 = new ad();
        ((ad)localObject3).convertFrom((Cursor)localObject2);
        localObject4 = new d();
        ((d)localObject4).convertFrom((Cursor)localObject2);
        i = j;
        if (!((aq)localObject3).field_username.equals("gh_43f2581f6fd6"))
        {
          me localme = new me();
          localme.userName = ((aq)localObject3).field_username;
          localme.contact = ((ad)localObject3);
          localme.pyd = ((d)localObject4);
          i = j;
          if (!t.og(localme.userName))
          {
            ((Map)localObject1).put(localme.userName, localme);
            i = j;
            if (localme.pyd.field_type != 3) {
              if (localme.pyd.field_type == 2)
              {
                this.jSN.add(localme);
                i = j;
              }
              else if (localme.pyd.field_type != 1)
              {
                i = j;
                if (localme.pyd.field_type != 0) {}
              }
              else
              {
                this.jSO.add(localme);
                i = j;
              }
            }
          }
        }
      }
      ab.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[] { Integer.valueOf(i) });
      ((Cursor)localObject2).close();
    }
    long l2 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username");
    ((StringBuilder)localObject2).append(" from rcontact");
    ((StringBuilder)localObject2).append(" where (verifyFlag & ").append(ad.dwB()).append(") != 0 ");
    ((StringBuilder)localObject2).append(" and (type & 1) != 0 ");
    localObject2 = ((StringBuilder)localObject2).toString();
    ab.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[] { localObject2 });
    g.RM();
    localObject2 = g.RL().eHS.a((String)localObject2, null, 0);
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
      ab.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), localObject3 });
      if (!((ArrayList)localObject3).isEmpty())
      {
        g.RM();
        long l3 = g.RL().eHS.kr(Thread.currentThread().getId());
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          ao.a.flI.am((String)localObject2, "");
        }
        g.RM();
        g.RL().eHS.nY(l3);
      }
    }
    ab.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    ab.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[] { Integer.valueOf(this.jSO.size()), Integer.valueOf(this.jSN.size()) });
    ab.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    AppMethodBeat.o(13830);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(13832);
    ab.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(13832);
      return;
    }
    if (paramm.getType() == 387)
    {
      paramString = ((e)paramm).jSP;
      if (paramString == null)
      {
        ab.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
        AppMethodBeat.o(13832);
        return;
      }
      if ((this.jSN == null) || (this.jSO == null))
      {
        ab.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
        AppMethodBeat.o(13832);
        return;
      }
      if (paramString.size() != this.jSN.size() + this.jSO.size()) {
        paramInt1 = 1;
      }
    }
    label309:
    for (;;)
    {
      if (paramInt1 != 0)
      {
        init();
        paramString = this.jSL.iterator();
        for (;;)
        {
          if (paramString.hasNext())
          {
            ((c.a)paramString.next()).onChange();
            continue;
            paramm = this.jSN.iterator();
            me localme;
            do
            {
              paramInt1 = i;
              if (!paramm.hasNext()) {
                break;
              }
              localme = (me)paramm.next();
            } while ((localme != null) && (paramString.contains(localme.userName)));
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label309;
            }
            paramm = this.jSO.iterator();
            do
            {
              if (!paramm.hasNext()) {
                break;
              }
              localme = (me)paramm.next();
            } while ((localme != null) && (paramString.contains(localme.userName)));
            paramInt1 = 1;
            break;
          }
        }
      }
      AppMethodBeat.o(13832);
      return;
    }
  }
  
  public final List<me> rW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jSO;
    }
    return this.jSN;
  }
  
  public final void release()
  {
    AppMethodBeat.i(13831);
    g.Rc().b(387, this);
    if (this.jSM)
    {
      ArrayList localArrayList = new ArrayList(this.jSN.size() + this.jSO.size());
      Iterator localIterator = this.jSN.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((me)localIterator.next());
      }
      localIterator = this.jSO.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((me)localIterator.next());
      }
      g.Rc().a(new j(localArrayList), 0);
    }
    AppMethodBeat.o(13831);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */