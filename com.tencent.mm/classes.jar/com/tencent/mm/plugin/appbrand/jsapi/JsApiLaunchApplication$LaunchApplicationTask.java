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
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public int cZX;
  public Bundle dcb;
  public String extInfo;
  public Runnable jWP;
  public String jYf;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(45506);
    CREATOR = new Parcelable.Creator() {};
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
        ac.i("MicroMsg.JsApiLaunchApplication", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplication.LaunchApplicationTask.this.success = true;
          parama.beh();
          AppMethodBeat.o(45499);
          return;
        }
        JsApiLaunchApplication.LaunchApplicationTask.this.success = false;
        parama.beh();
        AppMethodBeat.o(45499);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 637927424;
    parama.messageExt = this.extInfo;
    Object localObject = new kp();
    ((kp)localObject).dmn.dis = parama;
    ((kp)localObject).dmn.appId = this.appId;
    ((kp)localObject).dmn.cZX = this.cZX;
    ((kp)localObject).dmn.context = paramContext;
    ((kp)localObject).dmn.dcb = this.dcb;
    ((kp)localObject).dmn.dmp = locala;
    a.GpY.l((b)localObject);
    boolean bool1 = ((kp)localObject).dmo.dmq;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((bs.isNullOrNil(this.appId)) || (bs.isNullOrNil(this.jYf))) {
        break label379;
      }
      parama = this.appId + "://" + this.jYf;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      ac.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bs.aa(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label392;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label370;
      }
      parama = h.b((ResolveInfo)parama.get(0));
      if (bs.nullAsNil(ai.getPackageName()).equals(parama)) {
        break label392;
      }
      locala.hwA = false;
      locala.jYi = false;
      locala.jYj = false;
      locala.dmq = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.dcb);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.gj(bool2);
        AppMethodBeat.o(45501);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        ac.i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void aLr()
  {
    AppMethodBeat.i(45502);
    ac.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
    if (this.jWP != null)
    {
      ac.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
      this.jWP.run();
    }
    AppMethodBeat.o(45502);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45503);
    this.cZX = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.jYf = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.dcb = paramParcel.readBundle();
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
    paramParcel.writeInt(this.cZX);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.jYf);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.dcb);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45504);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */