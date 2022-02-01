package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.s;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.bqn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  public final void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(45537);
    if (paramJSONObject == null)
    {
      ad.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      paramq.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = bt.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bt.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("installSchemeUrl");
    String str7 = paramJSONObject.optString("fileMd5");
    String str8 = paramJSONObject.optString("taskName");
    ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { str1, str2, str4, str3 });
    if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
    {
      ad.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
      paramq.h(paramInt, e("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str9 = paramq.getAppId();
    paramJSONObject = paramq.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.kuf;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!bt.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label243:
        localBundle.putString("current_page_appid", str9);
        b.a locala = new b.a();
        locala.hNM = new bqm();
        locala.hNN = new bqn();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        bqm localbqm = (bqm)locala.aDC().hNK.hNQ;
        localbqm.duW = str9;
        localbqm.GKT = str1;
        localbqm.scene = ((o)paramq.getRuntime()).Fb().cmC.scene;
        localbqm.url = paramJSONObject;
        localbqm.GKU = str2;
        localbqm.paC = i;
        localbqm.GKV = 1;
        localbqm.GKW = j;
        localbqm.GKX = str6;
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(localbqm.scene), localbqm.url, localbqm.GKU, Integer.valueOf(localbqm.paC), Integer.valueOf(localbqm.GKW) });
        IPCRunCgi.a(locala.aDC(), new JsApiLaunchApplicationDirectly.1(this, paramq, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(45537);
        return;
        ad.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
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
    private int cgA;
    private q jwH;
    private m ksO;
    private String ksP;
    private String ksQ;
    private String ksR;
    private String ksS;
    private long ksT;
    private String ksU;
    private String ksV;
    private boolean ksW;
    private String ksX;
    private long ksY;
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
      e(paramParcel);
      AppMethodBeat.o(45521);
    }
    
    public AddDownloadTaskStraightTask(m paramm, q paramq, int paramInt, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(45520);
      this.ksO = paramm;
      this.jwH = paramq;
      this.cgA = paramInt;
      this.ksP = paramJSONObject.optString("taskName");
      this.ksQ = paramJSONObject.optString("taskUrl");
      this.ksR = paramJSONObject.optString("fileMd5");
      this.ksS = paramJSONObject.optString("alternativeUrl");
      this.ksT = paramJSONObject.optInt("taskSize", 0);
      this.ksU = paramJSONObject.optString("extInfo");
      this.ksV = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.ksW = true;
      AppMethodBeat.o(45520);
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45522);
      com.tencent.mm.kernel.g.ajD();
      if (!com.tencent.mm.kernel.g.ajC().isSDCardAvailable()) {
        this.ksX = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bhX();
        AppMethodBeat.o(45522);
        return;
        if ((this.ksT > 0L) && (!com.tencent.mm.compatible.util.e.qR(this.ksT)))
        {
          this.ksX = "fail_sdcard_has_not_enough_space";
        }
        else if (bt.isNullOrNil(this.ksQ))
        {
          this.ksX = "fail_invalid_url";
        }
        else
        {
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.ksQ, this.ksR });
          Object localObject = new g.a();
          ((g.a)localObject).aak(this.ksQ);
          ((g.a)localObject).aal(this.ksS);
          ((g.a)localObject).ui(this.ksT);
          ((g.a)localObject).aam(this.ksP);
          ((g.a)localObject).aan(this.ksR);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ft(this.mPackageName);
          ((g.a)localObject).jQ(true);
          ((g.a)localObject).Bp(bt.getInt(this.ksV, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).aao(this.ksU);
          localObject = ((g.a)localObject).pmN;
          long l = f.ccl().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ad.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.ksX = "";
          }
          else
          {
            this.ksW = false;
            this.ksY = l;
          }
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45523);
      if (this.ksW)
      {
        if (bt.isNullOrNil(this.ksX)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.ksX }))
        {
          this.jwH.h(this.cgA, this.ksO.e((String)localObject, null));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.ksY));
      this.jwH.h(this.cgA, this.ksO.m("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.ksP = paramParcel.readString();
      this.ksQ = paramParcel.readString();
      this.ksR = paramParcel.readString();
      this.ksS = paramParcel.readString();
      this.ksT = paramParcel.readLong();
      this.ksU = paramParcel.readString();
      this.ksV = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.ksW = bool;
        this.ksX = paramParcel.readString();
        this.ksY = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.ksP);
      paramParcel.writeString(this.ksQ);
      paramParcel.writeString(this.ksR);
      paramParcel.writeString(this.ksS);
      paramParcel.writeLong(this.ksT);
      paramParcel.writeString(this.ksU);
      paramParcel.writeString(this.ksV);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.ksW) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ksX);
        paramParcel.writeLong(this.ksY);
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