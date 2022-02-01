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
import com.tencent.mm.g.a.kz;
import com.tencent.mm.g.a.kz.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.List;

class JsApiLaunchApplicationDirectly$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public int dmr;
  public Bundle doz;
  public String extInfo;
  public Runnable kuv;
  public String kvR;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(45534);
    CREATOR = new JsApiLaunchApplicationDirectly.LaunchApplicationTask.2();
    AppMethodBeat.o(45534);
  }
  
  public JsApiLaunchApplicationDirectly$LaunchApplicationTask(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private JsApiLaunchApplicationDirectly$LaunchApplicationTask(Parcel paramParcel)
  {
    AppMethodBeat.i(45533);
    e(paramParcel);
    AppMethodBeat.o(45533);
  }
  
  public final void a(Context paramContext, final AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(45529);
    JsApiLaunchApplicationDirectly.a locala = new JsApiLaunchApplicationDirectly.a(new JsApiLaunchApplicationDirectly.a.a()
    {
      public final void u(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45527);
        ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplicationDirectly.LaunchApplicationTask.this.success = true;
          parama.biu();
          AppMethodBeat.o(45527);
          return;
        }
        JsApiLaunchApplicationDirectly.LaunchApplicationTask.this.success = false;
        parama.biu();
        AppMethodBeat.o(45527);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 637928960;
    parama.messageExt = this.extInfo;
    Object localObject = new kz();
    ((kz)localObject).dzg.dve = parama;
    ((kz)localObject).dzg.appId = this.appId;
    ((kz)localObject).dzg.dmr = this.dmr;
    ((kz)localObject).dzg.context = paramContext;
    ((kz)localObject).dzg.doz = this.doz;
    ((kz)localObject).dzg.dzi = locala;
    a.IvT.l((b)localObject);
    boolean bool1 = ((kz)localObject).dzh.dzj;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((bu.isNullOrNil(this.appId)) || (bu.isNullOrNil(this.kvR))) {
        break label379;
      }
      parama = this.appId + "://" + this.kvR;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bu.ac(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label392;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label370;
      }
      parama = h.b((ResolveInfo)parama.get(0));
      if (bu.nullAsNil(ak.getPackageName()).equals(parama)) {
        break label392;
      }
      locala.hRI = false;
      locala.kvU = false;
      locala.kvV = false;
      locala.dzj = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.doz);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.gm(bool2);
        AppMethodBeat.o(45529);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void aOY()
  {
    AppMethodBeat.i(45530);
    ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess");
    if (this.kuv != null)
    {
      ae.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess asyncCallback != null");
      this.kuv.run();
    }
    AppMethodBeat.o(45530);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45531);
    this.dmr = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.kvR = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.doz = paramParcel.readBundle();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(45531);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(45532);
    paramParcel.writeInt(this.dmr);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.kvR);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.doz);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45532);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */