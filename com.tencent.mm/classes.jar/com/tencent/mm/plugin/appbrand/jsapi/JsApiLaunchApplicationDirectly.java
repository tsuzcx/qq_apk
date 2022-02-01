package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.cmu;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLaunchApplicationDirectly
  extends JsApiLaunchApplication
{
  private static final int CTRL_INDEX = 620;
  private static final String NAME = "launchApplicationDirectly";
  
  public final void a(v paramv, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45537);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      paramv.j(paramInt, h("fail:data is null", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = Util.getInt(paramJSONObject.optString("alertType"), 0);
    int j = Util.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("installSchemeUrl");
    String str7 = paramJSONObject.optString("fileMd5");
    String str8 = paramJSONObject.optString("taskName");
    Object localObject1 = paramJSONObject.optString("sourceInfo");
    Object localObject2 = paramJSONObject.optString("bizInfo");
    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { str1, str2, str4, str3 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
    {
      Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
      paramv.j(paramInt, h("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str9 = paramv.getAppId();
    paramJSONObject = paramv.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.oxe;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label259:
        localBundle.putString("current_page_appid", str9);
        localBundle.putString("current_page_biz_info", (String)localObject2);
        localBundle.putString("current_page_source_info", (String)localObject1);
        localObject1 = new d.a();
        ((d.a)localObject1).lBU = new cmu();
        ((d.a)localObject1).lBV = new cmv();
        ((d.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        ((d.a)localObject1).funcId = 1125;
        localObject2 = (cmu)d.b.b(((d.a)localObject1).bgN().lBR);
        ((cmu)localObject2).appid = str9;
        ((cmu)localObject2).Tur = str1;
        ((cmu)localObject2).scene = ((t)paramv.getRuntime()).Sk().cxf.scene;
        ((cmu)localObject2).url = paramJSONObject;
        ((cmu)localObject2).Tus = str2;
        ((cmu)localObject2).tVq = i;
        ((cmu)localObject2).SEl = 1;
        ((cmu)localObject2).Tut = j;
        ((cmu)localObject2).Tuu = str6;
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(((cmu)localObject2).scene), ((cmu)localObject2).url, ((cmu)localObject2).Tus, Integer.valueOf(((cmu)localObject2).tVq), Integer.valueOf(((cmu)localObject2).Tut) });
        IPCRunCgi.a(((d.a)localObject1).bgN(), new JsApiLaunchApplicationDirectly.1(this, paramv, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(45537);
        return;
        Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label259;
      }
    }
  }
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int cqA;
    private String mAppId;
    private String mPackageName;
    private v ntA;
    private String ovA;
    private String ovB;
    private String ovC;
    private String ovD;
    private long ovE;
    private String ovF;
    private String ovG;
    private boolean ovH;
    private String ovI;
    private long ovJ;
    private o ovz;
    
    static
    {
      AppMethodBeat.i(45526);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45526);
    }
    
    public AddDownloadTaskStraightTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45521);
      f(paramParcel);
      AppMethodBeat.o(45521);
    }
    
    public AddDownloadTaskStraightTask(o paramo, v paramv, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45520);
      this.ovz = paramo;
      this.ntA = paramv;
      this.cqA = paramInt;
      this.ovA = paramJSONObject.optString("taskName");
      this.ovB = paramJSONObject.optString("taskUrl");
      this.ovC = paramJSONObject.optString("fileMd5");
      this.ovD = paramJSONObject.optString("alternativeUrl");
      this.ovE = paramJSONObject.optInt("taskSize", 0);
      this.ovF = paramJSONObject.optString("extInfo");
      this.ovG = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.ovH = true;
      AppMethodBeat.o(45520);
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45522);
      h.aHH();
      if (!h.aHG().isSDCardAvailable()) {
        this.ovI = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(45522);
        return;
        if ((this.ovE > 0L) && (!e.EY(this.ovE)))
        {
          this.ovI = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.ovB))
        {
          this.ovI = "fail_invalid_url";
        }
        else
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ovB, this.ovC });
          Object localObject = new g.a();
          ((g.a)localObject).atc(this.ovB);
          ((g.a)localObject).atd(this.ovD);
          ((g.a)localObject).setFileSize(this.ovE);
          ((g.a)localObject).ate(this.ovA);
          ((g.a)localObject).setFileMD5(this.ovC);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).me(true);
          ((g.a)localObject).IS(Util.getInt(this.ovG, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).YS(this.ovF);
          localObject = ((g.a)localObject).uhY;
          long l = com.tencent.mm.plugin.downloader.model.f.cPZ().a((g)localObject);
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ovI = "";
          }
          else
          {
            this.ovH = false;
            this.ovJ = l;
          }
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(45523);
      if (this.ovH)
      {
        if (Util.isNullOrNil(this.ovI)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ovI }))
        {
          this.ntA.j(this.cqA, this.ovz.h((String)localObject, null));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ovJ));
      this.ntA.j(this.cqA, this.ovz.m("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.ovA = paramParcel.readString();
      this.ovB = paramParcel.readString();
      this.ovC = paramParcel.readString();
      this.ovD = paramParcel.readString();
      this.ovE = paramParcel.readLong();
      this.ovF = paramParcel.readString();
      this.ovG = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ovH = bool;
        this.ovI = paramParcel.readString();
        this.ovJ = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.ovA);
      paramParcel.writeString(this.ovB);
      paramParcel.writeString(this.ovC);
      paramParcel.writeString(this.ovD);
      paramParcel.writeLong(this.ovE);
      paramParcel.writeString(this.ovF);
      paramParcel.writeString(this.ovG);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.ovH) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ovI);
        paramParcel.writeLong(this.ovJ);
        AppMethodBeat.o(45525);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly
 * JD-Core Version:    0.7.0.1
 */