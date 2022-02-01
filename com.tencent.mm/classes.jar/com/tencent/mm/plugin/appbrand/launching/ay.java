package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.luggage.sdk.launching.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaPluginCodeInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaWidgetInfo;
import com.tencent.mm.plugin.appbrand.launching.a.g;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ay
  extends aw<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>>
{
  final String appId;
  final boolean ekt;
  final int enterScene;
  final WxaAttributes.WxaVersionInfo epa;
  final e epm;
  final int euz;
  final QualitySession qYm;
  final String sXS;
  List<g> tbS;
  
  ay(String paramString1, int paramInt1, boolean paramBoolean, WxaAttributes.WxaVersionInfo paramWxaVersionInfo, int paramInt2, String paramString2, QualitySession paramQualitySession, e parame)
  {
    AppMethodBeat.i(320713);
    this.tbS = new LinkedList();
    this.appId = paramString1;
    this.euz = paramInt1;
    this.ekt = paramBoolean;
    this.enterScene = paramInt2;
    this.epa = paramWxaVersionInfo;
    this.sXS = paramString2;
    this.qYm = paramQualitySession;
    this.epm = parame;
    Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b,enterScene:%d, wxaColdStartMode:%s", new Object[] { Integer.valueOf(hashCode()), paramString1, Integer.valueOf(paramInt1), Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt2), parame });
    AppMethodBeat.o(320713);
  }
  
  private LinkedList<g> a(WxaAttributes.WxaVersionInfo paramWxaVersionInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(320724);
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yLi, true);
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        Log.i("MicroMsg.PkgABTest", "openGameIsolatedPluginPermissionCheck exp:%d", new Object[] { Integer.valueOf(i) });
        if (!bool) {
          break label270;
        }
        paramWxaVersionInfo = paramWxaVersionInfo.oVI;
        if ((paramWxaVersionInfo != null) && (paramWxaVersionInfo.size() > 0)) {
          break;
        }
        AppMethodBeat.o(320724);
        return null;
      }
      paramWxaVersionInfo = paramWxaVersionInfo.iterator();
      while (paramWxaVersionInfo.hasNext())
      {
        localObject1 = (WxaAttributes.WxaWidgetInfo)paramWxaVersionInfo.next();
        if (((WxaAttributes.WxaWidgetInfo)localObject1).hDq == 22)
        {
          localObject1 = ((WxaAttributes.WxaWidgetInfo)localObject1).rcG;
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (WxaAttributes.WxaPluginCodeInfo)((Iterator)localObject1).next();
              Iterator localIterator = ((WxaAttributes.WxaPluginCodeInfo)localObject2).contexts.iterator();
              while (localIterator.hasNext()) {
                if (((Integer)localIterator.next()).intValue() == 3)
                {
                  g localg = new g();
                  localg.appId = ((WxaAttributes.WxaPluginCodeInfo)localObject2).provider;
                  localg.appType = 2;
                  localLinkedList.add(localg);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(320724);
      return localLinkedList;
    }
    label270:
    if (!paramBoolean)
    {
      if (BuildInfo.DEBUG) {
        paramBoolean = true;
      }
      while (paramBoolean) {
        if (TextUtils.isEmpty(paramWxaVersionInfo.rcs))
        {
          AppMethodBeat.o(320724);
          return null;
          paramBoolean = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yPg, false);
        }
        else
        {
          try
          {
            paramWxaVersionInfo = new JSONObject(paramWxaVersionInfo.rcs);
            paramWxaVersionInfo = paramWxaVersionInfo.optJSONArray("call_plugin_info");
            if ((paramWxaVersionInfo == null) || (paramWxaVersionInfo.length() <= 0))
            {
              AppMethodBeat.o(320724);
              return null;
            }
          }
          catch (JSONException paramWxaVersionInfo)
          {
            Log.e("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "getTodoCheckAppJsApiList(), parse json failed for miniprogram, appId:%s, exception:%s", new Object[] { this.appId, paramWxaVersionInfo });
            AppMethodBeat.o(320724);
            return null;
          }
          localObject1 = new HashSet();
          com.tencent.luggage.sdk.h.c.a(paramWxaVersionInfo, new ay.1(this, (Set)localObject1));
          if (!((Set)localObject1).isEmpty())
          {
            paramWxaVersionInfo = ((Set)localObject1).iterator();
            while (paramWxaVersionInfo.hasNext())
            {
              localObject1 = (String)paramWxaVersionInfo.next();
              localObject2 = new g();
              ((g)localObject2).appId = ((String)localObject1);
              ((g)localObject2).appType = 2;
              localLinkedList.add(localObject2);
            }
          }
        }
      }
    }
    AppMethodBeat.o(320724);
    return localLinkedList;
  }
  
  private boolean f(HashMap<String, AppRuntimeApiPermissionBundle> paramHashMap)
  {
    AppMethodBeat.i(320734);
    aj localaj = n.cfd();
    aq localaq = n.cff();
    if ((localaj == null) || (localaq == null))
    {
      Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
      AppMethodBeat.o(320734);
      return false;
    }
    if ((this.tbS != null) && (this.tbS.size() > 0))
    {
      Iterator localIterator = this.tbS.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (g)localIterator.next();
        String str = ((g)localObject).appId;
        int i = ((g)localObject).appType;
        if (i == 2)
        {
          localObject = localaq.adg(str);
          if (localObject == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", new Object[] { str });
            AppMethodBeat.o(320734);
            return true;
          }
          if (((aat)localObject).Zjj == null)
          {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", new Object[] { str });
            AppMethodBeat.o(320734);
            return true;
          }
          paramHashMap.put(str, new AppRuntimeApiPermissionBundle((aat)localObject));
        }
        else if (i == 1)
        {
          localObject = new ak();
          ((ak)localObject).field_appId = str;
          if (!localaj.a((ak)localObject, new String[] { "appId" }))
          {
            AppMethodBeat.o(320734);
            return true;
          }
          if (((ak)localObject).field_jsapiInfo == null)
          {
            AppMethodBeat.o(320734);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(320734);
    return false;
  }
  
  void cdb() {}
  
  final String getTag()
  {
    return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.ay
 * JD-Core Version:    0.7.0.1
 */