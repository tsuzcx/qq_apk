package com.tencent.mm.plugin.appbrand.appcache.b;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.ck.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.protocal.c.bws;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a$1
  implements Runnable
{
  private void ap(List<bws> paramList)
  {
    com.tencent.mm.plugin.appbrand.appcache.b.c.a locala = com.tencent.mm.plugin.appbrand.appcache.b.c.a.fFB;
    com.tencent.mm.plugin.appbrand.appcache.b.c.a.s(0L, 0L);
    new a(paramList, (byte)0).Km().h(new a.1.1(this));
  }
  
  public final void run()
  {
    if ((!g.DN().dJH) || (com.tencent.mm.plugin.appbrand.app.e.aaO() == null) || (com.tencent.mm.plugin.appbrand.app.e.abb() == null)) {}
    label75:
    label123:
    Object localObject1;
    label373:
    label375:
    label380:
    int j;
    label432:
    label460:
    do
    {
      return;
      long l1 = ((Long)g.DP().Dz().get(ac.a.utj, Long.valueOf(0L))).longValue();
      long l2 = AppBrandGlobalSystemConfig.aec().fOX.fPm;
      long l3 = bk.UX();
      Object localObject2;
      if (l3 >= l1 + l2)
      {
        i = 1;
        if (i == 0) {
          break label373;
        }
        g.DP().Dz().c(ac.a.utj, Long.valueOf(l3));
        if (((Boolean)g.DP().Dz().get(ac.a.utk, Boolean.valueOf(true))).booleanValue()) {
          break label375;
        }
        i = 1;
        if (i != 0)
        {
          localObject1 = (k)com.tencent.mm.plugin.appbrand.app.e.G(k.class);
          l1 = bk.UX();
          l2 = AppBrandGlobalSystemConfig.aec().fOX.fPn;
          i = AppBrandGlobalSystemConfig.aec().fOX.fPo;
          localObject2 = "select distinct username,updateTime from AppBrandLocalUsageRecord where updateTime >= " + (l1 - l2) + " order by updateTime desc limit " + i + " offset 0 ";
          localObject2 = ((k)localObject1).fCV.rawQuery((String)localObject2, null);
          if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
            break label380;
          }
        }
      }
      Cursor localCursor;
      for (;;)
      {
        g.DP().Dz().c(ac.a.utk, Boolean.valueOf(true));
        localObject2 = com.tencent.mm.plugin.appbrand.app.e.aaO();
        i = AppBrandGlobalSystemConfig.aec().fOX.fPo;
        l1 = bk.UX() - AppBrandGlobalSystemConfig.aec().fOX.fPn;
        y.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList with minUpdateTime( %s )", new Object[] { bk.hs(l1) });
        localCursor = ((h)localObject2).a("select distinct WxaAttributesTable.username,WxaAttributesTable.appId,WxaAttributesTable.versionInfo from AppBrandAppLaunchUsernameDuplicateRecord left outer join WxaAttributesTable on AppBrandAppLaunchUsernameDuplicateRecord.username=WxaAttributesTable.username where AppBrandAppLaunchUsernameDuplicateRecord.updateTime >= " + l1 + " order by AppBrandAppLaunchUsernameDuplicateRecord.updateTime desc limit " + i + " offset 0", null, 2);
        if ((localCursor != null) && (!localCursor.isClosed())) {
          break label432;
        }
        localObject1 = Collections.emptyList();
        if (!bk.dk((List)localObject1)) {
          break label647;
        }
        y.e("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "pullIfExceedLimit, empty list");
        return;
        i = 0;
        break label75;
        break;
        i = 0;
        break label123;
        if (((Cursor)localObject2).moveToLast()) {
          do
          {
            ((k)localObject1).v(((Cursor)localObject2).getString(0), ((Cursor)localObject2).getLong(1));
          } while (((Cursor)localObject2).moveToPrevious());
        }
        ((Cursor)localObject2).close();
      }
      localObject1 = new LinkedList();
      Object localObject3;
      bws localbws;
      if (localCursor.moveToFirst())
      {
        WxaAttributes localWxaAttributes = new WxaAttributes();
        localObject3 = localCursor.getString(0);
        if (!bk.bl((String)localObject3))
        {
          localWxaAttributes.d(localCursor);
          localbws = new bws();
          localbws.tMY = ((String)localObject3);
          if (localWxaAttributes.aep() != null) {
            localbws.tMZ = localWxaAttributes.aep().cau;
          }
          if (!bk.bl(localWxaAttributes.field_appId))
          {
            localObject3 = com.tencent.mm.plugin.appbrand.launching.e.aU(localWxaAttributes.field_appId, 0);
            if (localObject3 == null) {
              break label642;
            }
          }
        }
      }
      for (int i = ((WxaPkgWrappingInfo)localObject3).fEN;; i = 0)
      {
        localbws.tNa = i;
        ((List)localObject1).add(localbws);
        if (localCursor.moveToNext()) {
          break label460;
        }
        localCursor.close();
        i = ((h)localObject2).delete("AppBrandAppLaunchUsernameDuplicateRecord", "updateTime < ?", new String[] { String.valueOf(l1) });
        y.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList, delete records updateTime < %s, count %d", new Object[] { bk.hs(l1), Integer.valueOf(i) });
        break;
      }
      int k = AppBrandGlobalSystemConfig.aec().fOX.fPp;
      i = 0;
      j = 0;
      while (i < ((List)localObject1).size() / k)
      {
        int m = i * k;
        j = m + k;
        ap(((List)localObject1).subList(m, j));
        i += 1;
      }
    } while (j >= ((List)localObject1).size());
    label642:
    label647:
    ap(((List)localObject1).subList(j, ((List)localObject1).size()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.a.1
 * JD-Core Version:    0.7.0.1
 */