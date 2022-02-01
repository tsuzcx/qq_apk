package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.m;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.a.g;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class aw
  extends au<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
{
  final String appId;
  final int cBU;
  final boolean csz;
  final WxaAttributes.WxaVersionInfo cwY;
  final b cxe;
  final int enterScene;
  final QualitySession nYk;
  final String pST;
  List<g> pXe;
  
  aw(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession, b paramb)
  {
    AppMethodBeat.i(270030);
    this.pXe = new LinkedList();
    this.appId = paramString1;
    this.cBU = paramInt1;
    this.csz = paramBoolean;
    this.enterScene = paramInt2;
    this.cwY = paramWxaVersionInfo;
    this.pST = paramString2;
    this.nYk = paramQualitySession;
    this.cxe = paramb;
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b,enterScene:%d, wxaColdStartMode:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramb });
    AppMethodBeat.o(270030);
  }
  
  private static LinkedList<g> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(270032);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      paramWxaVersionInfo = paramWxaVersionInfo.mcN;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(270032);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).fyH == 22)
        {
          localObject = ((WxaAttributes.WxaWidgetInfo)localObject).obS;
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
                  g localg = new g();
                  localg.appId = localWxaPluginCodeInfo.provider;
                  localg.appType = 2;
                  localLinkedList.add(localg);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(270032);
      return localLinkedList;
    }
    AppMethodBeat.o(270032);
    return localLinkedList;
  }
  
  private boolean e(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(270033);
    ai localai = m.bFG();
    ap localap = m.bFI();
    if ((localai == null) || (localap == null))
    {
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(270033);
      return false;
    }
    if ((this.pXe != null) && (this.pXe.size() > 0))
    {
      Iterator localIterator = this.pXe.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (g)localIterator.next();
        String str = ((g)localObject).appId;
        int i = ((g)localObject).appType;
        if (i == 2)
        {
          localObject = localap.akb(str);
          if (localObject == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(270033);
            return true;
          }
          if (((yw)localObject).SkZ == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(270033);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((yw)localObject));
        }
        else if (i == 1)
        {
          localObject = new aj();
          ((aj)localObject).field_appId = str;
          if (!localai.a((aj)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(270033);
            return true;
          }
          if (((aj)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(270033);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(270033);
    return false;
  }
  
  void bDO() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.aw
 * JD-Core Version:    0.7.0.1
 */