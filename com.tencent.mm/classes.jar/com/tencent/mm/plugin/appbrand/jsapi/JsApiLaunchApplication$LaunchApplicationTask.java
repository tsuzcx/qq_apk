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
import com.tencent.mm.g.a.ky;
import com.tencent.mm.g.a.ky.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public int dlp;
  public Bundle dnx;
  public String extInfo;
  public Runnable krg;
  public String ksB;
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
    e(paramParcel);
    AppMethodBeat.o(45505);
  }
  
  public final void a(Context paramContext, final AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(45501);
    JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.a.a()
    {
      public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45499);
        ad.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplication.LaunchApplicationTask.this.success = true;
          parama.bhL();
          AppMethodBeat.o(45499);
          return;
        }
        JsApiLaunchApplication.LaunchApplicationTask.this.success = false;
        parama.bhL();
        AppMethodBeat.o(45499);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 637928960;
    parama.messageExt = this.extInfo;
    Object localObject = new ky();
    ((ky)localObject).dyb.dtZ = parama;
    ((ky)localObject).dyb.appId = this.appId;
    ((ky)localObject).dyb.dlp = this.dlp;
    ((ky)localObject).dyb.context = paramContext;
    ((ky)localObject).dyb.dnx = this.dnx;
    ((ky)localObject).dyb.dyd = locala;
    a.IbL.l((b)localObject);
    boolean bool1 = ((ky)localObject).dyc.dye;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((bt.isNullOrNil(this.appId)) || (bt.isNullOrNil(this.ksB))) {
        break label379;
      }
      parama = this.appId + "://" + this.ksB;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bt.ac(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label392;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label370;
      }
      parama = h.b((ResolveInfo)parama.get(0));
      if (bt.nullAsNil(aj.getPackageName()).equals(parama)) {
        break label392;
      }
      locala.hOP = false;
      locala.ksE = false;
      locala.ksF = false;
      locala.dye = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.dnx);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.go(bool2);
        AppMethodBeat.o(45501);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        ad.i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void aOB()
  {
    AppMethodBeat.i(45502);
    ad.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
    if (this.krg != null)
    {
      ad.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
      this.krg.run();
    }
    AppMethodBeat.o(45502);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45503);
    this.dlp = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.ksB = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.dnx = paramParcel.readBundle();
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
    paramParcel.writeInt(this.dlp);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ksB);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.dnx);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */