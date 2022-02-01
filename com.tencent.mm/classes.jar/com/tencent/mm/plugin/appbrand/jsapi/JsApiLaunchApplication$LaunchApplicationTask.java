package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.nm;
import com.tencent.mm.autogen.a.nm.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public String extInfo;
  public int hAN;
  public Bundle hDf;
  public Runnable rxj;
  public String ryF;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(45506);
    CREATOR = new JsApiLaunchApplication.LaunchApplicationTask.2();
    AppMethodBeat.o(45506);
  }
  
  public JsApiLaunchApplication$LaunchApplicationTask(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private JsApiLaunchApplication$LaunchApplicationTask(Parcel paramParcel)
  {
    AppMethodBeat.i(45505);
    h(paramParcel);
    AppMethodBeat.o(45505);
  }
  
  public final void a(Context paramContext, final AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(45501);
    JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.a.a()
    {
      public final void C(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45499);
        Log.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplication.LaunchApplicationTask.this.success = true;
          parama.cpu();
          AppMethodBeat.o(45499);
          return;
        }
        JsApiLaunchApplication.LaunchApplicationTask.this.success = false;
        parama.cpu();
        AppMethodBeat.o(45499);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 638058496;
    parama.messageExt = this.extInfo;
    Object localObject = new nm();
    ((nm)localObject).hPP.hzF = parama;
    ((nm)localObject).hPP.appId = this.appId;
    ((nm)localObject).hPP.hAN = this.hAN;
    ((nm)localObject).hPP.context = paramContext;
    ((nm)localObject).hPP.hDf = this.hDf;
    ((nm)localObject).hPP.hPR = locala;
    ((nm)localObject).publish();
    boolean bool1 = ((nm)localObject).hPQ.hPS;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((Util.isNullOrNil(this.appId)) || (Util.isNullOrNil(this.ryF))) {
        break label376;
      }
      parama = this.appId + "://" + this.ryF;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = Util.queryIntentActivities(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label389;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label367;
      }
      parama = h.b((ResolveInfo)parama.get(0));
      if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(parama)) {
        break label389;
      }
      locala.ouJ = false;
      locala.ryI = false;
      locala.ryJ = false;
      locala.hPS = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.hDf);
    }
    label389:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.iY(bool2);
        AppMethodBeat.o(45501);
        return;
        label367:
        parama = ((Intent)localObject).getPackage();
        break;
        label376:
        Log.i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(45502);
    Log.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
    if (this.rxj != null)
    {
      Log.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
      this.rxj.run();
    }
    AppMethodBeat.o(45502);
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45503);
    this.hAN = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.ryF = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.hDf = paramParcel.readBundle();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(45503);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45504);
    paramParcel.writeInt(this.hAN);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ryF);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.hDf);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */