package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.a.e;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bd
  extends bb<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
{
  final String appId;
  final boolean cbn;
  final WxaAttributes.WxaVersionInfo cfl;
  final int enterScene;
  final int gXn;
  final QualitySession jdu;
  final String kHm;
  List<e> kMm;
  
  bd(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(196020);
    this.kMm = new LinkedList();
    this.appId = paramString1;
    this.gXn = paramInt1;
    this.cbn = paramBoolean;
    this.enterScene = paramInt2;
    this.cfl = paramWxaVersionInfo;
    this.kHm = paramString2;
    this.jdu = paramQualitySession;
    ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "appId:%s,versionType:%d,isGame:%b,enterScene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(196020);
  }
  
  private static LinkedList<e> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(196021);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      paramWxaVersionInfo = paramWxaVersionInfo.huK;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(196021);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).deP == 22)
        {
          localObject = ((WxaAttributes.WxaWidgetInfo)localObject).jfQ;
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              WxaAttributes.WxaPluginCodeInfo localWxaPluginCodeInfo = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject).next();
              Iterator localIterator = localWxaPluginCodeInfo.contexts.iterator();
              while (localIterator.hasNext()) {
                if (((Integer)localIterator.next()).intValue() == 3)
                {
                  e locale = new e();
                  locale.appId = localWxaPluginCodeInfo.provider;
                  locale.appType = 2;
                  localLinkedList.add(locale);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(196021);
      return localLinkedList;
    }
    AppMethodBeat.o(196021);
    return localLinkedList;
  }
  
  private boolean e(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(196022);
    at localat = j.aOD();
    ay localay = j.aOF();
    if ((localat == null) || (localay == null))
    {
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(196022);
      return false;
    }
    if ((this.kMm != null) && (this.kMm.size() > 0))
    {
      Iterator localIterator = this.kMm.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (e)localIterator.next();
        String str = ((e)localObject).appId;
        int i = ((e)localObject).appType;
        if (i == 2)
        {
          localObject = localay.Kn(str);
          if (localObject == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(196022);
            return true;
          }
          if (((uw)localObject).CWN == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(196022);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((uw)localObject));
        }
        else if (i == 1)
        {
          localObject = new au();
          ((au)localObject).field_appId = str;
          if (!localat.a((au)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(196022);
            return true;
          }
          if (((au)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(196022);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(196022);
    return false;
  }
  
  void aNr() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bd
 * JD-Core Version:    0.7.0.1
 */