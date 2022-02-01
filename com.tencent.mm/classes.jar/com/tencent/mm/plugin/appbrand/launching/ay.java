package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
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

public class ay
  extends au<Pair<HashMap<String, AppRuntimeAppidABTestPermissionBundle>, Boolean>>
{
  final String appId;
  final int cBU;
  final boolean csz;
  final WxaAttributes.WxaVersionInfo cwY;
  final QualitySession nYk;
  final String pST;
  List<f> pXj;
  
  ay(String paramString1, int paramInt, boolean paramBoolean, String paramString2, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(267178);
    this.pXj = new LinkedList();
    this.appId = paramString1;
    this.cBU = paramInt;
    this.csz = paramBoolean;
    this.pST = paramString2;
    this.cwY = paramWxaVersionInfo;
    this.nYk = paramQualitySession;
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(267178);
  }
  
  private LinkedList<f> b(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(267179);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      Object localObject = new f();
      ((f)localObject).appId = this.appId;
      ((f)localObject).appType = 1;
      ((f)localObject).cBU = this.cBU;
      localLinkedList.add(localObject);
      paramWxaVersionInfo = paramWxaVersionInfo.mcN;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(267179);
        return localLinkedList;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        localObject = ((WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next()).obS;
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
            if (!Util.isNullOrNil(localWxaPluginCodeInfo.nGm)) {
              break label228;
            }
          }
          label228:
          for (int i = f.pYr;; i = f.pYs)
          {
            localf.cBU = i;
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
    AppMethodBeat.o(267179);
    return localLinkedList;
  }
  
  private boolean f(HashMap<String, AppRuntimeAppidABTestPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(267180);
    Object localObject = m.bFG();
    an localan = m.bFJ();
    if ((localObject == null) || (localan == null))
    {
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "needSyncCheckAppidPermission storage null!");
      AppMethodBeat.o(267180);
      return false;
    }
    if ((this.pXj != null) && (this.pXj.size() > 0))
    {
      Iterator localIterator = this.pXj.iterator();
      while (localIterator.hasNext())
      {
        localObject = (f)localIterator.next();
        String str = ((f)localObject).appId;
        int i = ((f)localObject).appType;
        int j = ((f)localObject).cBU;
        Log.i("MicroMsg.LaunchWxaAppidABTestInfoStorage", "get, appId:%s , appType :%d, versionType: %d", new Object[] { str, Integer.valueOf(i), Integer.valueOf(j) });
        localObject = new am();
        ((am)localObject).field_appId = str;
        ((am)localObject).field_appType = i;
        ((am)localObject).field_versionType = j;
        if (localan.get((IAutoDBItem)localObject, new String[0])) {}
        for (localObject = ((am)localObject).field_permissionBytes; localObject == null; localObject = null)
        {
          Log.i("MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo", "needSyncCheckAppidPermission appidABTestInfoStorage not include appId:%s ,appType:%d!", new Object[] { str, Integer.valueOf(i) });
          AppMethodBeat.o(267180);
          return true;
        }
        paramHashMap.put(c.T(str, i, j), new AppRuntimeAppidABTestPermissionBundle((byte[])localObject));
      }
    }
    AppMethodBeat.o(267180);
    return false;
  }
  
  void bDP() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppidABTestPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */