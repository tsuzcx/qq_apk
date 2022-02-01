package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.a.e;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ay
  extends aw<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
  implements aa
{
  final String appId;
  final boolean cuy;
  final WxaAttributes.WxaVersionInfo cyv;
  final b cyz;
  final int enterScene;
  final int iOo;
  final QualitySession ldW;
  final String mRZ;
  List<e> mWM;
  
  ay(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession, b paramb)
  {
    AppMethodBeat.i(227098);
    this.mWM = new LinkedList();
    this.appId = paramString1;
    this.iOo = paramInt1;
    this.cuy = paramBoolean;
    this.enterScene = paramInt2;
    this.cyv = paramWxaVersionInfo;
    this.mRZ = paramString2;
    this.ldW = paramQualitySession;
    this.cyz = paramb;
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b,enterScene:%d, wxaColdStartMode:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), paramb });
    AppMethodBeat.o(227098);
  }
  
  private static LinkedList<e> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(227099);
    LinkedList localLinkedList = new LinkedList();
    if (paramBoolean)
    {
      paramWxaVersionInfo = paramWxaVersionInfo.jmL;
      if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.size() <= 0))
      {
        AppMethodBeat.o(227099);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        Object localObject = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject).packageType == 22)
        {
          localObject = ((WxaAttributes.WxaWidgetInfo)localObject).lhk;
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
      AppMethodBeat.o(227099);
      return localLinkedList;
    }
    AppMethodBeat.o(227099);
    return localLinkedList;
  }
  
  private boolean f(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(227100);
    ao localao = n.buD();
    at localat = n.buF();
    if ((localao == null) || (localat == null))
    {
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(227100);
      return false;
    }
    if ((this.mWM != null) && (this.mWM.size() > 0))
    {
      Iterator localIterator = this.mWM.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (e)localIterator.next();
        String str = ((e)localObject).appId;
        int i = ((e)localObject).appType;
        if (i == 2)
        {
          localObject = localat.ach(str);
          if (localObject == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(227100);
            return true;
          }
          if (((ys)localObject).LjS == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(227100);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((ys)localObject));
        }
        else if (i == 1)
        {
          localObject = new ap();
          ((ap)localObject).field_appId = str;
          if (!localao.a((ap)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(227100);
            return true;
          }
          if (((ap)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(227100);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(227100);
    return false;
  }
  
  void bsR() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */