package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
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
  
  public final void a(s params, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45537);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      params.i(paramInt, h("fail:data is null", null));
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
    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { str1, str2, str4, str3 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
    {
      Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
      params.i(paramInt, h("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str9 = params.getAppId();
    paramJSONObject = params.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.lBI;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label243:
        localBundle.putString("current_page_appid", str9);
        d.a locala = new d.a();
        locala.iLN = new cea();
        locala.iLO = new ceb();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        cea localcea = (cea)locala.aXF().iLK.iLR;
        localcea.dNI = str9;
        localcea.MjD = str1;
        localcea.scene = ((q)params.getRuntime()).ON().cyA.scene;
        localcea.url = paramJSONObject;
        localcea.MjE = str2;
        localcea.qwp = i;
        localcea.LEg = 1;
        localcea.MjF = j;
        localcea.MjG = str6;
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(localcea.scene), localcea.url, localcea.MjE, Integer.valueOf(localcea.qwp), Integer.valueOf(localcea.MjF) });
        IPCRunCgi.a(locala.aXF(), new JsApiLaunchApplicationDirectly.1(this, params, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(45537);
        return;
        Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label243;
      }
    }
  }
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int csv;
    private s kAr;
    private p lAi;
    private String lAj;
    private String lAk;
    private String lAl;
    private String lAm;
    private long lAn;
    private String lAo;
    private String lAp;
    private boolean lAq;
    private String lAr;
    private long lAs;
    private String mAppId;
    private String mPackageName;
    
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
    
    public AddDownloadTaskStraightTask(p paramp, s params, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45520);
      this.lAi = paramp;
      this.kAr = params;
      this.csv = paramInt;
      this.lAj = paramJSONObject.optString("taskName");
      this.lAk = paramJSONObject.optString("taskUrl");
      this.lAl = paramJSONObject.optString("fileMd5");
      this.lAm = paramJSONObject.optString("alternativeUrl");
      this.lAn = paramJSONObject.optInt("taskSize", 0);
      this.lAo = paramJSONObject.optString("extInfo");
      this.lAp = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.lAq = true;
      AppMethodBeat.o(45520);
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45522);
      com.tencent.mm.kernel.g.aAi();
      if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable()) {
        this.lAr = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bDU();
        AppMethodBeat.o(45522);
        return;
        if ((this.lAn > 0L) && (!com.tencent.mm.compatible.util.e.yV(this.lAn)))
        {
          this.lAr = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.lAk))
        {
          this.lAr = "fail_invalid_url";
        }
        else
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.lAk, this.lAl });
          Object localObject = new g.a();
          ((g.a)localObject).alj(this.lAk);
          ((g.a)localObject).alk(this.lAm);
          ((g.a)localObject).setFileSize(this.lAn);
          ((g.a)localObject).all(this.lAj);
          ((g.a)localObject).setFileMD5(this.lAl);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).gm(this.mPackageName);
          ((g.a)localObject).kS(true);
          ((g.a)localObject).Fl(Util.getInt(this.lAp, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Rv(this.lAo);
          localObject = ((g.a)localObject).qIY;
          long l = f.cBv().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.lAr = "";
          }
          else
          {
            this.lAq = false;
            this.lAs = l;
          }
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45523);
      if (this.lAq)
      {
        if (Util.isNullOrNil(this.lAr)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.lAr }))
        {
          this.kAr.i(this.csv, this.lAi.h((String)localObject, null));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.lAs));
      this.kAr.i(this.csv, this.lAi.n("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.lAj = paramParcel.readString();
      this.lAk = paramParcel.readString();
      this.lAl = paramParcel.readString();
      this.lAm = paramParcel.readString();
      this.lAn = paramParcel.readLong();
      this.lAo = paramParcel.readString();
      this.lAp = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.lAq = bool;
        this.lAr = paramParcel.readString();
        this.lAs = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.lAj);
      paramParcel.writeString(this.lAk);
      paramParcel.writeString(this.lAl);
      paramParcel.writeString(this.lAm);
      paramParcel.writeLong(this.lAn);
      paramParcel.writeString(this.lAo);
      paramParcel.writeString(this.lAp);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.lAq) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.lAr);
        paramParcel.writeLong(this.lAs);
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