package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

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

class JsApiLaunchApplicationForNative$LaunchApplicationTask
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
    AppMethodBeat.i(45846);
    CREATOR = new JsApiLaunchApplicationForNative.LaunchApplicationTask.2();
    AppMethodBeat.o(45846);
  }
  
  public JsApiLaunchApplicationForNative$LaunchApplicationTask(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private JsApiLaunchApplicationForNative$LaunchApplicationTask(Parcel paramParcel)
  {
    AppMethodBeat.i(45845);
    h(paramParcel);
    AppMethodBeat.o(45845);
  }
  
  public final void a(Context paramContext, final AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(45841);
    JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
    {
      public final void C(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45839);
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplicationForNative.LaunchApplicationTask.this.success = true;
          parama.cpu();
          AppMethodBeat.o(45839);
          return;
        }
        JsApiLaunchApplicationForNative.LaunchApplicationTask.this.success = false;
        parama.cpu();
        AppMethodBeat.o(45839);
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
      Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
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
        AppMethodBeat.o(45841);
        return;
        label367:
        parama = ((Intent)localObject).getPackage();
        break;
        label376:
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void bQr()
  {
    AppMethodBeat.i(45842);
    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess");
    if (this.rxj != null)
    {
      Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess asyncCallback != null");
      this.rxj.run();
    }
    AppMethodBeat.o(45842);
  }
  
  public final void h(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45843);
    this.hAN = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.ryF = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.hDf = paramParcel.readBundle();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(45843);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45844);
    paramParcel.writeInt(this.hAN);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ryF);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.hDf);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45844);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */