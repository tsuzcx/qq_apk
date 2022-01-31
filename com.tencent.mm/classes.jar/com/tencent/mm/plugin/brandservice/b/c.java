package com.tencent.mm.plugin.brandservice.b;

import android.database.Cursor;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.ai.d;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.s;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.y;
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
  public LinkedList<c.a> ibV = new LinkedList();
  public boolean ibW = false;
  public List<jt> ibX = new LinkedList();
  public List<jt> ibY = new LinkedList();
  
  public c()
  {
    g.Dk().a(387, this);
    g.Dk().a(new e(), 0);
  }
  
  public final void init()
  {
    long l1 = System.currentTimeMillis();
    this.ibX.clear();
    this.ibY.clear();
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
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ad.cuc()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    ((StringBuilder)localObject1).append(" order by showHead asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" case when length(conRemark) > 0 then upper(conRemark) ");
    ((StringBuilder)localObject1).append(" else upper(quanPin) end asc, ");
    ((StringBuilder)localObject1).append(" upper(quanPin) asc, ");
    ((StringBuilder)localObject1).append(" upper(nickname) asc");
    localObject1 = ((StringBuilder)localObject1).toString();
    y.d("MicroMsg.BrandService.BrandServiceMgr", "sql %s", new Object[] { localObject1 });
    g.DQ();
    Object localObject2 = g.DP().dKu.a((String)localObject1, null, 2);
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
        ((ad)localObject3).d((Cursor)localObject2);
        localObject4 = new d();
        ((d)localObject4).d((Cursor)localObject2);
        i = j;
        if (!((ao)localObject3).field_username.equals("gh_43f2581f6fd6"))
        {
          jt localjt = new jt();
          localjt.userName = ((ao)localObject3).field_username;
          localjt.dnp = ((ad)localObject3);
          localjt.mVy = ((d)localObject4);
          i = j;
          if (!s.hx(localjt.userName))
          {
            ((Map)localObject1).put(localjt.userName, localjt);
            i = j;
            if (localjt.mVy.field_type != 3) {
              if (localjt.mVy.field_type == 2)
              {
                this.ibX.add(localjt);
                i = j;
              }
              else if (localjt.mVy.field_type != 1)
              {
                i = j;
                if (localjt.mVy.field_type != 0) {}
              }
              else
              {
                this.ibY.add(localjt);
                i = j;
              }
            }
          }
        }
      }
      y.d("MicroMsg.BrandService.BrandServiceMgr", "biz contact count %d", new Object[] { Integer.valueOf(i) });
      ((Cursor)localObject2).close();
    }
    long l2 = System.currentTimeMillis();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select username");
    ((StringBuilder)localObject2).append(" from rcontact");
    ((StringBuilder)localObject2).append(" where (verifyFlag & ").append(ad.cuc()).append(") != 0 ");
    ((StringBuilder)localObject2).append(" and (type & 1) != 0 ");
    localObject2 = ((StringBuilder)localObject2).toString();
    y.d("MicroMsg.BrandService.BrandServiceMgr", "sql check %s", new Object[] { localObject2 });
    g.DQ();
    localObject2 = g.DP().dKu.a((String)localObject2, null, 0);
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
      y.i("MicroMsg.BrandService.BrandServiceMgr", "need update list size is %d, {%s}", new Object[] { Integer.valueOf(((ArrayList)localObject3).size()), localObject3 });
      if (!((ArrayList)localObject3).isEmpty())
      {
        g.DQ();
        long l3 = g.DP().dKu.eV(Thread.currentThread().getId());
        localObject1 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          am.a.dVy.V((String)localObject2, "");
        }
        g.DQ();
        g.DP().dKu.hI(l3);
      }
    }
    y.d("MicroMsg.BrandService.BrandServiceMgr", "check use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l2) });
    y.d("MicroMsg.BrandService.BrandServiceMgr", "service add subscribe count:%d, enterpriseFather count:%d", new Object[] { Integer.valueOf(this.ibY.size()), Integer.valueOf(this.ibX.size()) });
    y.d("MicroMsg.BrandService.BrandServiceMgr", "init time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    y.w("MicroMsg.BrandService.BrandServiceMgr", "on scene end code(%d, %d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 != 0) || (paramInt2 != 0)) {}
    label279:
    for (;;)
    {
      return;
      if (paramm.getType() == 387)
      {
        paramString = ((e)paramm).ibZ;
        if (paramString == null)
        {
          y.e("MicroMsg.BrandService.BrandServiceMgr", "nameList is null.");
          return;
        }
        if ((this.ibX == null) || (this.ibY == null))
        {
          y.e("MicroMsg.BrandService.BrandServiceMgr", "enterpriseItemList or subscribeAndServiceItemList is null.");
          return;
        }
        if (paramString.size() != this.ibX.size() + this.ibY.size()) {
          paramInt1 = 1;
        }
        for (;;)
        {
          if (paramInt1 == 0) {
            break label279;
          }
          init();
          paramString = this.ibV.iterator();
          while (paramString.hasNext()) {
            ((c.a)paramString.next()).axs();
          }
          break;
          paramm = this.ibX.iterator();
          jt localjt;
          do
          {
            paramInt1 = i;
            if (!paramm.hasNext()) {
              break;
            }
            localjt = (jt)paramm.next();
          } while ((localjt != null) && (paramString.contains(localjt.userName)));
          paramInt1 = 1;
          if (paramInt1 == 0)
          {
            paramm = this.ibY.iterator();
            for (;;)
            {
              if (paramm.hasNext())
              {
                localjt = (jt)paramm.next();
                if ((localjt == null) || (!paramString.contains(localjt.userName)))
                {
                  paramInt1 = 1;
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.b.c
 * JD-Core Version:    0.7.0.1
 */