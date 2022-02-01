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
import com.tencent.mm.plugin.appbrand.ui.r;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.protocal.protobuf.bik;
import com.tencent.mm.protocal.protobuf.bil;
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
      paramJSONObject = paramJSONObject.jzm;
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
        locala.gUU = new bik();
        locala.gUV = new bil();
        locala.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
        locala.funcId = 1125;
        bik localbik = (bik)locala.atI().gUS.gUX;
        localbik.dlB = str9;
        localbik.DGa = str1;
        localbik.scene = ((o)paramq.getRuntime()).DZ().cfo.scene;
        localbik.url = paramJSONObject;
        localbik.DGb = str2;
        localbik.nTM = i;
        localbik.DGc = 1;
        localbik.DGd = j;
        localbik.DGe = str6;
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", new Object[] { str9, str1, Integer.valueOf(localbik.scene), localbik.url, localbik.DGb, Integer.valueOf(localbik.nTM), Integer.valueOf(localbik.DGd) });
        IPCRunCgi.a(locala.atI(), new JsApiLaunchApplicationDirectly.1(this, paramq, paramInt, str5, str6, str1, str8, str7, str2, localBundle, str3, str4));
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
    private int bZo;
    private q iDy;
    private m jxX;
    private String jxY;
    private String jxZ;
    private String jya;
    private String jyb;
    private long jyc;
    private String jyd;
    private String jye;
    private boolean jyf;
    private String jyg;
    private long jyh;
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
      this.jxX = paramm;
      this.iDy = paramq;
      this.bZo = paramInt;
      this.jxY = paramJSONObject.optString("taskName");
      this.jxZ = paramJSONObject.optString("taskUrl");
      this.jya = paramJSONObject.optString("fileMd5");
      this.jyb = paramJSONObject.optString("alternativeUrl");
      this.jyc = paramJSONObject.optInt("taskSize", 0);
      this.jyd = paramJSONObject.optString("extInfo");
      this.jye = paramJSONObject.optString("fileType");
      this.mAppId = paramJSONObject.optString("appId");
      this.mPackageName = paramJSONObject.optString("packageName");
      this.jyf = true;
      AppMethodBeat.o(45520);
    }
    
    public final void aEA()
    {
      AppMethodBeat.i(45523);
      if (this.jyf)
      {
        if (bt.isNullOrNil(this.jyg)) {}
        for (localObject = "fail";; localObject = String.format("fail:%s", new Object[] { this.jyg }))
        {
          this.iDy.h(this.bZo, this.jxX.e((String)localObject, null));
          AppMethodBeat.o(45523);
          return;
        }
      }
      Object localObject = new HashMap();
      ((Map)localObject).put("downloadId", Long.valueOf(this.jyh));
      this.iDy.h(this.bZo, this.jxX.k("ok", (Map)localObject));
      AppMethodBeat.o(45523);
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(45522);
      com.tencent.mm.kernel.g.afC();
      if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable()) {
        this.jyg = "fail_sdcard_not_ready";
      }
      for (;;)
      {
        aXw();
        AppMethodBeat.o(45522);
        return;
        if ((this.jyc > 0L) && (!com.tencent.mm.compatible.util.e.lo(this.jyc)))
        {
          this.jyg = "fail_sdcard_has_not_enough_space";
        }
        else if (bt.isNullOrNil(this.jxZ))
        {
          this.jyg = "fail_invalid_url";
        }
        else
        {
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", new Object[] { this.jxZ, this.jya });
          Object localObject = new g.a();
          ((g.a)localObject).Sr(this.jxZ);
          ((g.a)localObject).Ss(this.jyb);
          ((g.a)localObject).oy(this.jyc);
          ((g.a)localObject).St(this.jxY);
          ((g.a)localObject).Su(this.jya);
          ((g.a)localObject).setAppId(this.mAppId);
          ((g.a)localObject).eI(this.mPackageName);
          ((g.a)localObject).jc(true);
          ((g.a)localObject).zO(bt.getInt(this.jye, 1));
          ((g.a)localObject).setScene(6001);
          ((g.a)localObject).Sv(this.jyd);
          localObject = ((g.a)localObject).ofF;
          long l = f.bQt().a((com.tencent.mm.plugin.downloader.model.g)localObject);
          ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(l)));
          if (l <= 0L)
          {
            ad.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(l)));
            this.jyg = "";
          }
          else
          {
            this.jyf = false;
            this.jyh = l;
          }
        }
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(45524);
      this.jxY = paramParcel.readString();
      this.jxZ = paramParcel.readString();
      this.jya = paramParcel.readString();
      this.jyb = paramParcel.readString();
      this.jyc = paramParcel.readLong();
      this.jyd = paramParcel.readString();
      this.jye = paramParcel.readString();
      this.mAppId = paramParcel.readString();
      this.mPackageName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.jyf = bool;
        this.jyg = paramParcel.readString();
        this.jyh = paramParcel.readLong();
        AppMethodBeat.o(45524);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45525);
      paramParcel.writeString(this.jxY);
      paramParcel.writeString(this.jxZ);
      paramParcel.writeString(this.jya);
      paramParcel.writeString(this.jyb);
      paramParcel.writeLong(this.jyc);
      paramParcel.writeString(this.jyd);
      paramParcel.writeString(this.jye);
      paramParcel.writeString(this.mAppId);
      paramParcel.writeString(this.mPackageName);
      if (this.jyf) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jyg);
        paramParcel.writeLong(this.jyh);
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