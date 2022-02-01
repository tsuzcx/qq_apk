package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.ddi;
import com.tencent.mm.protocal.protobuf.ddj;
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
  
  public final void a(y paramy, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45537);
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      paramy.callback(paramInt, ZP("fail:data is null"));
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
      paramy.callback(paramInt, ZP("fail:appid and scheme is null or nil"));
      AppMethodBeat.o(45537);
      return;
    }
    String str9 = paramy.getAppId();
    paramJSONObject = paramy.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.cgR();
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!Util.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label257:
        localBundle.putString("current_page_appid", str9);
        localBundle.putString("current_page_biz_info", (String)localObject2);
        localBundle.putString("current_page_source_info", (String)localObject1);
        localObject1 = new c.a();
        ((c.a)localObject1).otE = new ddi();
        ((c.a)localObject1).otF = new ddj();
        ((c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        ((c.a)localObject1).funcId = 1125;
        localObject2 = (ddi)c.b.b(((c.a)localObject1).bEF().otB);
        ((ddi)localObject2).appid = str9;
        ((ddi)localObject2).aaIV = str1;
        ((ddi)localObject2).scene = ((w)paramy.getRuntime()).asA().epn.scene;
        ((ddi)localObject2).url = paramJSONObject;
        ((ddi)localObject2).aaIW = str2;
        ((ddi)localObject2).wYK = i;
        ((ddi)localObject2).ZFJ = 1;
        ((ddi)localObject2).aaIX = j;
        ((ddi)localObject2).aaIY = str6;
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(((ddi)localObject2).scene), ((ddi)localObject2).url, ((ddi)localObject2).aaIW, Integer.valueOf(((ddi)localObject2).wYK), Integer.valueOf(((ddi)localObject2).aaIX) });
        IPCRunCgi.a(((c.a)localObject1).bEF(), new JsApiLaunchApplicationDirectly.1(this, paramy, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(45537);
        return;
        Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
        paramJSONObject = null;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label257;
      }
    }
  }
  
  static class AddDownloadTaskStraightTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR;
    private int eit;
    private String mAppId;
    private String mPackageName;
    private y qsi;
    private p ryT;
    private String ryU;
    private String ryV;
    private String ryW;
    private String ryX;
    private long ryY;
    private String ryZ;
    private String rza;
    private boolean rzb;
    private String rzc;
    private long rzd;
    
    static
    {
      AppMethodBeat.i(45526);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45526);
    }
    
    public AddDownloadTaskStraightTask(Parcel paramParcel)
    {
      AppMethodBeat.i(45521);
      h(paramParcel);
      AppMethodBeat.o(45521);
    }
    
    public AddDownloadTaskStraightTask(p paramp, y paramy, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45520);
      this.ryT = paramp;
      this.qsi = paramy;
      this.eit = paramInt;
      this.ryU = paramJSONObject.optString("taskName");
      this.ryV = paramJSONObject.optString("taskUrl");
      this.ryW = paramJSONObject.optString("fileMd5");
      this.ryX = paramJSONObject.optString("alternativeUrl");
      this.ryY = paramJSONObject.optInt("taskSize", 0);
      this.ryZ = paramJSONObject.optString("extInfo");
      this.rza = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.rzb = true;
      AppMethodBeat.o(45520);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45522);
      h.baF();
      if (!h.baE().isSDCardAvailable()) {
        this.rzc = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(45522);
        return;
        if ((this.ryY > 0L) && (!e.hq(this.ryY)))
        {
          this.rzc = "fail_sdcard_has_not_enough_space";
        }
        else if (Util.isNullOrNil(this.ryV))
        {
          this.rzc = "fail_invalid_url";
        }
        else
        {
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ryV, this.ryW });
          Object localObject = new g.a();
          ((g.a)localObject).amR(this.ryV);
          ((g.a)localObject).amS(this.ryX);
          ((g.a)localObject).setFileSize(this.ryY);
          ((g.a)localObject).amT(this.ryU);
          ((g.a)localObject).setFileMD5(this.ryW);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).setPackageName(this.mPackageName);
          ((g.a)localObject).nA(true);
          ((g.a)localObject).JA(Util.getInt(this.rza, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).QX(this.ryZ);
          localObject = ((g.a)localObject).xoe;
          long l = com.tencent.mm.plugin.downloader.model.f.duv().a((g)localObject);
          Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.rzc = "";
          }
          else
          {
            this.rzb = false;
            this.rzd = l;
          }
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(45523);
      if (this.rzb)
      {
        if (Util.isNullOrNil(this.rzc)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.rzc }))
        {
          this.qsi.callback(this.eit, this.ryT.ZP((String)localObject));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.rzd));
      this.qsi.callback(this.eit, this.ryT.m("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.ryU = paramParcel.readString();
      this.ryV = paramParcel.readString();
      this.ryW = paramParcel.readString();
      this.ryX = paramParcel.readString();
      this.ryY = paramParcel.readLong();
      this.ryZ = paramParcel.readString();
      this.rza = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rzb = bool;
        this.rzc = paramParcel.readString();
        this.rzd = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.ryU);
      paramParcel.writeString(this.ryV);
      paramParcel.writeString(this.ryW);
      paramParcel.writeString(this.ryX);
      paramParcel.writeLong(this.ryY);
      paramParcel.writeString(this.ryZ);
      paramParcel.writeString(this.rza);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.rzb) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.rzc);
        paramParcel.writeLong(this.rzd);
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