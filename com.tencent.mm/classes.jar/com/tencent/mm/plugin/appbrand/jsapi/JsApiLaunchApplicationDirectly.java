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
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.bmc;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
      ac.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
      paramq.h(paramInt, e("fail:data is null", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str1 = paramJSONObject.optString("appId");
    String str2 = paramJSONObject.optString("schemeUrl");
    String str3 = paramJSONObject.optString("parameter");
    int i = bs.getInt(paramJSONObject.optString("alertType"), 0);
    int j = bs.getInt(paramJSONObject.optString("operateDirectly"), 0);
    String str4 = paramJSONObject.optString("extInfo");
    String str5 = paramJSONObject.optString("packageName");
    String str6 = paramJSONObject.optString("installSchemeUrl");
    String str7 = paramJSONObject.optString("fileMd5");
    String str8 = paramJSONObject.optString("taskName");
    ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", new Object[] { str1, str2, str4, str3 });
    if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)))
    {
      ac.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
      paramq.h(paramInt, e("fail:appid and scheme is null or nil", null));
      AppMethodBeat.o(45537);
      return;
    }
    String str9 = paramq.getAppId();
    paramJSONObject = paramq.getCurrentPageView();
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.jZJ;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      if (!bs.isNullOrNil(paramJSONObject)) {}
      try
      {
        localBundle.putString("current_page_url", URLEncoder.encode(paramJSONObject, "UTF-8"));
        label243:
        localBundle.putString("current_page_appid", str9);
        b.a locala = new b.a();
        locala.hvt = new bmc();
        locala.hvu = new bmd();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        bmc localbmc = (bmc)locala.aAz().hvr.hvw;
        localbmc.djj = str9;
        localbmc.Fbu = str1;
        localbmc.scene = ((o)paramq.getRuntime()).DC().ccl.scene;
        localbmc.url = paramJSONObject;
        localbmc.Fbv = str2;
        localbmc.oxh = i;
        localbmc.Fbw = 1;
        localbmc.Fbx = j;
        localbmc.Fby = str6;
        ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(localbmc.scene), localbmc.url, localbmc.Fbv, Integer.valueOf(localbmc.oxh), Integer.valueOf(localbmc.Fbx) });
        IPCRunCgi.a(locala.aAz(), new JsApiLaunchApplicationDirectly.1(this, paramq, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
        AppMethodBeat.o(45537);
        return;
        ac.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
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
    private int bWl;
    private boolean jYA;
    private String jYB;
    private long jYC;
    private m jYs;
    private String jYt;
    private String jYu;
    private String jYv;
    private String jYw;
    private long jYx;
    private String jYy;
    private String jYz;
    private q jdy;
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
      this.jYs = paramm;
      this.jdy = paramq;
      this.bWl = paramInt;
      this.jYt = paramJSONObject.optString("taskName");
      this.jYu = paramJSONObject.optString("taskUrl");
      this.jYv = paramJSONObject.optString("fileMd5");
      this.jYw = paramJSONObject.optString("alternativeUrl");
      this.jYx = paramJSONObject.optInt("taskSize", 0);
      this.jYy = paramJSONObject.optString("extInfo");
      this.jYz = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jYA = true;
      AppMethodBeat.o(45520);
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45522);
      com.tencent.mm.kernel.g.agS();
      if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable()) {
        this.jYB = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        bet();
        AppMethodBeat.o(45522);
        return;
        if ((this.jYx > 0L) && (!com.tencent.mm.compatible.util.e.oR(this.jYx)))
        {
          this.jYB = "fail_sdcard_has_not_enough_space";
        }
        else if (bs.isNullOrNil(this.jYu))
        {
          this.jYB = "fail_invalid_url";
        }
        else
        {
          ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jYu, this.jYv });
          Object localObject = new g.a();
          ((g.a)localObject).WD(this.jYu);
          ((g.a)localObject).WE(this.jYw);
          ((g.a)localObject).sk(this.jYx);
          ((g.a)localObject).WF(this.jYt);
          ((g.a)localObject).WG(this.jYv);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).ey(this.mPackageName);
          ((g.a)localObject).jF(true);
          ((g.a)localObject).AG(bs.getInt(this.jYz, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).WH(this.jYy);
          localObject = ((g.a)localObject).oJg;
          long l = f.bXJ().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ac.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ac.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jYB = "";
          }
          else
          {
            this.jYA = false;
            this.jYC = l;
          }
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(45523);
      if (this.jYA)
      {
        if (bs.isNullOrNil(this.jYB)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jYB }))
        {
          this.jdy.h(this.bWl, this.jYs.e((String)localObject, null));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jYC));
      this.jdy.h(this.bWl, this.jYs.k("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.jYt = paramParcel.readString();
      this.jYu = paramParcel.readString();
      this.jYv = paramParcel.readString();
      this.jYw = paramParcel.readString();
      this.jYx = paramParcel.readLong();
      this.jYy = paramParcel.readString();
      this.jYz = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jYA = bool;
        this.jYB = paramParcel.readString();
        this.jYC = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.jYt);
      paramParcel.writeString(this.jYu);
      paramParcel.writeString(this.jYv);
      paramParcel.writeString(this.jYw);
      paramParcel.writeLong(this.jYx);
      paramParcel.writeString(this.jYy);
      paramParcel.writeString(this.jYz);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jYA) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jYB);
        paramParcel.writeLong(this.jYC);
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