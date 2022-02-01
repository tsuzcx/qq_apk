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
import com.tencent.mm.protocal.protobuf.vg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bd
  extends bb<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
{
  final String appId;
  final boolean bYk;
  final WxaAttributes.WxaVersionInfo cch;
  final int enterScene;
  final int hxM;
  final QualitySession jDH;
  final String liG;
  List<e> lnJ;
  
  bd(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(186844);
    this.lnJ = new LinkedList();
    this.appId = paramString1;
    this.hxM = paramInt1;
    this.bYk = paramBoolean;
    this.enterScene = paramInt2;
    this.cch = paramWxaVersionInfo;
    this.liG = paramString2;
    this.jDH = paramQualitySession;
    ac.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "appId:%s,versionType:%d,isGame:%b,enterScene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(186844);
  }
  
  private static LinkedList<e> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(186845);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      paramWxaVersionInfo = paramWxaVersionInfo.hVm;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(186845);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).dcj == 22)
        {
          localObject = ((WxaAttributes.WxaWidgetInfo)localObject).jGf;
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
      AppMethodBeat.o(186845);
      return localLinkedList;
    }
    AppMethodBeat.o(186845);
    return localLinkedList;
  }
  
  private boolean e(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(186846);
    at localat = j.aVv();
    ay localay = j.aVx();
    if ((localat == null) || (localay == null))
    {
      ac.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(186846);
      return false;
    }
    if ((this.lnJ != null) && (this.lnJ.size() > 0))
    {
      Iterator localIterator = this.lnJ.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (e)localIterator.next();
        String str = ((e)localObject).appId;
        int i = ((e)localObject).appType;
        if (i == 2)
        {
          localObject = localay.Ou(str);
          if (localObject == null)
          {
            ac.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(186846);
            return true;
          }
          if (((vg)localObject).Epw == null)
          {
            ac.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(186846);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((vg)localObject));
        }
        else if (i == 1)
        {
          localObject = new au();
          ((au)localObject).field_appId = str;
          if (!localat.a((au)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(186846);
            return true;
          }
          if (((au)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(186846);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(186846);
    return false;
  }
  
  void aUh() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bd
 * JD-Core Version:    0.7.0.1
 */