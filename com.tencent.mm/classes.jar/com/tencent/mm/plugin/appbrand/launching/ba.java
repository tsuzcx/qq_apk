package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.a.c;
import com.tencent.mm.plugin.appbrand.launching.a.f;
import com.tencent.mm.plugin.appbrand.permission.appidABTest.AppRuntimeAppidABTestPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ba
  extends aw<Pair<HashMap<String, AppRuntimeAppidABTestPermissionBundle>, Boolean>>
{
  final String appId;
  final boolean ekt;
  final WxaAttributes.WxaVersionInfo epa;
  final int euz;
  final QualitySession qYm;
  final String sXS;
  List<f> tbZ;
  
  ba(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(320736);
    this.tbZ = new LinkedList();
    this.appId = paramString1;
    this.euz = paramInt;
    this.ekt = paramBoolean;
    this.sXS = paramString2;
    this.epa = paramWxaVersionInfo;
    this.qYm = paramQualitySession;
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(320736);
  }
  
  private LinkedList<f> b(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(320739);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      Object localObject = new f();
      ((f)localObject).appId = this.appId;
      ((f)localObject).appType = 1;
      ((f)localObject).euz = this.euz;
      localLinkedList.add(localObject);
      paramWxaVersionInfo = paramWxaVersionInfo.oVI;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(320739);
        return localLinkedList;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        localObject = ((WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next()).rcG;
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          label139:
          f localf;
          if (((Iterator)localObject).hasNext())
          {
            WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject).next();
            localf = new f();
            localf.appId = localWxaPluginCodeInfo.provider;
            localf.appType = 2;
            if (!Util.isNullOrNil(localWxaPluginCodeInfo.qGf)) {
              break label228;
            }
          }
          label228:
          for (int i = f.tdi;; i = f.tdj)
          {
            localf.euz = i;
            if (localLinkedList.contains(localf)) {
              break label139;
            }
            localLinkedList.add(localf);
            break label139;
            break;
          }
        }
      }
    }
    AppMethodBeat.o(320739);
    return localLinkedList;
  }
  
  private boolean g(HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(320750);
    Object localObject = n.cfd();
    ao localao = n.cfg();
    if ((localObject == null) || (localao == null))
    {
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "needSyncCheckAppidPermission storage null!");
      AppMethodBeat.o(320750);
      return false;
    }
    if ((this.tbZ != null) && (this.tbZ.size() > 0))
    {
      Iterator localIterator = this.tbZ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (f)localIterator.next();
        String str = ((f)localObject).appId;
        int i = ((f)localObject).appType;
        int j = ((f)localObject).euz;
        Log.i("MicroMsg.LaunchWxaAppidABTestInfoStorage", "get, appId:%s , appType :%d, versionType: %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        localObject = new an();
        ((an)localObject).field_appId = str;
        ((an)localObject).field_appType = i;
        ((an)localObject).field_versionType = j;
        if (localao.get((IAutoDBItem)localObject, new String[0])) {}
        for (localObject = ((an)localObject).field_permissionBytes; localObject == null; localObject = null)
        {
          Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "needSyncCheckAppidPermission appidABTestInfoStorage not include appId:%s ,appType:%d!", new Object[] { str, Integer.valueOf(i) });
          AppMethodBeat.o(320750);
          return true;
        }
        paramHashMap.put(c.X(str, i, j), new AppRuntimeAppidABTestPermissionBundle((byte[])localObject));
      }
    }
    AppMethodBeat.o(320750);
    return false;
  }
  
  void cdc() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ba
 * JD-Core Version:    0.7.0.1
 */