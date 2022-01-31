package com.tencent.mm.plugin.appbrand.appcache.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig.WeAppSyncVersionSetting;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.iy;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends com.tencent.mm.ai.a<iz>
{
  private final b rr;
  
  private a(List<cjb> paramList)
  {
    AppMethodBeat.i(129443);
    b.a locala = new b.a();
    iy localiy = new iy();
    localiy.wuG.addAll(paramList);
    locala.fsX = localiy;
    locala.fsY = new iz();
    locala.funcId = 2763;
    locala.uri = "/cgi-bin/mmbiz-bin/wxasync/wxabatchsyncversion";
    paramList = locala.ado();
    this.rr = paramList;
    this.rr = paramList;
    AppMethodBeat.o(129443);
  }
  
  static List<cjb> awl()
  {
    AppMethodBeat.i(129444);
    Object localObject1;
    long l1;
    Object localObject2;
    if (!((Boolean)com.tencent.mm.kernel.g.RL().Ru().get(ac.a.yDm, Boolean.TRUE)).booleanValue())
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = (k)com.tencent.mm.plugin.appbrand.app.g.w(k.class);
        l1 = bo.aox();
        long l2 = AppBrandGlobalSystemConfig.ayt().hhX.hit;
        i = AppBrandGlobalSystemConfig.ayt().hhX.hiu;
        localObject2 = "select distinct username,updateTime from AppBrandLocalUsageRecord where updateTime >= " + (l1 - l2) + " order by updateTime desc limit " + i + " offset 0 ";
        localObject2 = ((k)localObject1).gVl.rawQuery((String)localObject2, null);
        if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
          break label267;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.RL().Ru().set(ac.a.yDm, Boolean.TRUE);
      localObject1 = com.tencent.mm.plugin.appbrand.app.g.auB();
      i = AppBrandGlobalSystemConfig.ayt().hhX.hiu;
      l1 = bo.aox() - AppBrandGlobalSystemConfig.ayt().hhX.hit;
      ab.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList with minUpdateTime( %s )", new Object[] { bo.nU(l1) });
      localObject2 = ((com.tencent.mm.cg.h)localObject1).a("select distinct WxaAttributesTable.username,WxaAttributesTable.appId,WxaAttributesTable.versionInfo from AppBrandAppLaunchUsernameDuplicateRecord left outer join WxaAttributesTable on AppBrandAppLaunchUsernameDuplicateRecord.username=WxaAttributesTable.username where AppBrandAppLaunchUsernameDuplicateRecord.updateTime >= " + l1 + " order by AppBrandAppLaunchUsernameDuplicateRecord.updateTime desc limit " + i + " offset 0", null, 2);
      if ((localObject2 != null) && (!((Cursor)localObject2).isClosed())) {
        break label319;
      }
      localObject1 = Collections.emptyList();
      AppMethodBeat.o(129444);
      return localObject1;
      i = 0;
      break;
      label267:
      if (((Cursor)localObject2).moveToLast()) {
        do
        {
          ((k)localObject1).E(((Cursor)localObject2).getString(0), ((Cursor)localObject2).getLong(1));
        } while (((Cursor)localObject2).moveToPrevious());
      }
      ((Cursor)localObject2).close();
    }
    label319:
    LinkedList localLinkedList = new LinkedList();
    Object localObject3;
    cjb localcjb;
    if (((Cursor)localObject2).moveToFirst())
    {
      WxaAttributes localWxaAttributes = new WxaAttributes();
      localObject3 = ((Cursor)localObject2).getString(0);
      if (!bo.isNullOrNil((String)localObject3))
      {
        localWxaAttributes.convertFrom((Cursor)localObject2);
        localcjb = new cjb();
        localcjb.xTl = ((String)localObject3);
        if (localWxaAttributes.ayE() != null) {
          localcjb.xTm = localWxaAttributes.ayE().bDc;
        }
        if (!bo.isNullOrNil(localWxaAttributes.field_appId))
        {
          localObject3 = com.tencent.mm.plugin.appbrand.launching.h.bl(localWxaAttributes.field_appId, 0);
          if (localObject3 == null) {
            break label532;
          }
        }
      }
    }
    label532:
    for (int i = ((WxaPkgWrappingInfo)localObject3).gXf;; i = 0)
    {
      localcjb.xTn = i;
      localLinkedList.add(localcjb);
      if (((Cursor)localObject2).moveToNext()) {
        break;
      }
      ((Cursor)localObject2).close();
      i = ((com.tencent.mm.cg.h)localObject1).delete("AppBrandAppLaunchUsernameDuplicateRecord", "updateTime < ?", new String[] { String.valueOf(l1) });
      ab.i("MicroMsg.AppBrand.CgiBatchSyncPkgVersion", "collectReqInfoList, delete records updateTime < %s, count %d", new Object[] { bo.nU(l1), Integer.valueOf(i) });
      AppMethodBeat.o(129444);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.a
 * JD-Core Version:    0.7.0.1
 */