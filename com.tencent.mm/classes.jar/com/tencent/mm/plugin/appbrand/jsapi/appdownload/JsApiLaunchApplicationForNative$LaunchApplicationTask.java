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
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.lp.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;

class JsApiLaunchApplicationForNative$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public int dDG;
  public Bundle dFP;
  public String extInfo;
  public Runnable lyv;
  public String lzV;
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
    f(paramParcel);
    AppMethodBeat.o(45845);
  }
  
  public final void a(Context paramContext, final AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(45841);
    JsApiLaunchApplicationForNative.a locala = new JsApiLaunchApplicationForNative.a(new JsApiLaunchApplicationForNative.a.a()
    {
      public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45839);
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplicationForNative.LaunchApplicationTask.this.success = true;
          parama.bDH();
          AppMethodBeat.o(45839);
          return;
        }
        JsApiLaunchApplicationForNative.LaunchApplicationTask.this.success = false;
        parama.bDH();
        AppMethodBeat.o(45839);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 637928960;
    parama.messageExt = this.extInfo;
    Object localObject = new lp();
    ((lp)localObject).dQT.dCE = parama;
    ((lp)localObject).dQT.appId = this.appId;
    ((lp)localObject).dQT.dDG = this.dDG;
    ((lp)localObject).dQT.context = paramContext;
    ((lp)localObject).dQT.dFP = this.dFP;
    ((lp)localObject).dQT.dQV = locala;
    EventCenter.instance.publish((IEvent)localObject);
    boolean bool1 = ((lp)localObject).dQU.dQW;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((Util.isNullOrNil(this.appId)) || (Util.isNullOrNil(this.lzV))) {
        break label379;
      }
      parama = this.appId + "://" + this.lzV;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = Util.queryIntentActivities(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label392;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label370;
      }
      parama = h.b((ResolveInfo)parama.get(0));
      if (Util.nullAsNil(MMApplicationContext.getPackageName()).equals(parama)) {
        break label392;
      }
      locala.iMQ = false;
      locala.lzY = false;
      locala.lzZ = false;
      locala.dQW = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.dFP);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.hj(bool2);
        AppMethodBeat.o(45841);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void bjk()
  {
    AppMethodBeat.i(45842);
    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess");
    if (this.lyv != null)
    {
      Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess asyncCallback != null");
      this.lyv.run();
    }
    AppMethodBeat.o(45842);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45843);
    this.dDG = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.lzV = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.dFP = paramParcel.readBundle();
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
    paramParcel.writeInt(this.dDG);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.lzV);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.dFP);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45844);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */