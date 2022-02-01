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
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class bg
  extends be<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
{
  final String appId;
  final boolean ciC;
  final WxaAttributes.WxaVersionInfo cmy;
  final int enterScene;
  final int hQh;
  final QualitySession jXD;
  final String lFL;
  List<e> lLb;
  
  bg(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession)
  {
    AppMethodBeat.i(188625);
    this.lLb = new LinkedList();
    this.appId = paramString1;
    this.hQh = paramInt1;
    this.ciC = paramBoolean;
    this.enterScene = paramInt2;
    this.cmy = paramWxaVersionInfo;
    this.lFL = paramString2;
    this.jXD = paramQualitySession;
    ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "appId:%s,versionType:%d,isGame:%b,enterScene:%d", new Object[] { paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(188625);
  }
  
  private static LinkedList<e> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(188626);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      paramWxaVersionInfo = paramWxaVersionInfo.ioH;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(188626);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).dnF == 22)
        {
          localObject = ((WxaAttributes.WxaWidgetInfo)localObject).kao;
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
      AppMethodBeat.o(188626);
      return localLinkedList;
    }
    AppMethodBeat.o(188626);
    return localLinkedList;
  }
  
  private boolean e(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(188627);
    aw localaw = j.aYQ();
    bb localbb = j.aYS();
    if ((localaw == null) || (localbb == null))
    {
      ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(188627);
      return false;
    }
    if ((this.lLb != null) && (this.lLb.size() > 0))
    {
      Iterator localIterator = this.lLb.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (e)localIterator.next();
        String str = ((e)localObject).appId;
        int i = ((e)localObject).appType;
        if (i == 2)
        {
          localObject = localbb.RU(str);
          if (localObject == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(188627);
            return true;
          }
          if (((xf)localObject).FWI == null)
          {
            ad.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(188627);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((xf)localObject));
        }
        else if (i == 1)
        {
          localObject = new ax();
          ((ax)localObject).field_appId = str;
          if (!localaw.a((ax)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(188627);
            return true;
          }
          if (((ax)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(188627);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(188627);
    return false;
  }
  
  void aXp() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.bg
 * JD-Core Version:    0.7.0.1
 */