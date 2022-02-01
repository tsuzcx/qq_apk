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
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
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

class JsApiLaunchApplicationDirectly$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public int dcz;
  public Bundle deG;
  public String extInfo;
  public Runnable jwt;
  public String jxJ;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(45534);
    CREATOR = new Parcelable.Creator() {};
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
      public final void t(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2)
      {
        AppMethodBeat.i(45527);
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", new Object[] { Boolean.valueOf(paramAnonymousBoolean1), Boolean.valueOf(paramAnonymousBoolean2) });
        if (paramAnonymousBoolean1)
        {
          JsApiLaunchApplicationDirectly.LaunchApplicationTask.this.success = true;
          parama.aXk();
          AppMethodBeat.o(45527);
          return;
        }
        JsApiLaunchApplicationDirectly.LaunchApplicationTask.this.success = false;
        parama.aXk();
        AppMethodBeat.o(45527);
      }
    });
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 637927424;
    parama.messageExt = this.extInfo;
    Object localObject = new kh();
    ((kh)localObject).doE.doG = parama;
    ((kh)localObject).doE.appId = this.appId;
    ((kh)localObject).doE.dcz = this.dcz;
    ((kh)localObject).doE.context = paramContext;
    ((kh)localObject).doE.deG = this.deG;
    ((kh)localObject).doE.doH = locala;
    a.ESL.l((b)localObject);
    boolean bool1 = ((kh)localObject).doF.doI;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((bt.isNullOrNil(this.appId)) || (bt.isNullOrNil(this.jxJ))) {
        break label379;
      }
      parama = this.appId + "://" + this.jxJ;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bt.M(paramContext, (Intent)localObject);
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
      locala.gWb = false;
      locala.jxM = false;
      locala.jxN = false;
      locala.doI = false;
      bool1 = h.a(paramContext, (Intent)localObject, null, locala, this.deG);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.fN(bool2);
        AppMethodBeat.o(45529);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void aEA()
  {
    AppMethodBeat.i(45530);
    ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess");
    if (this.jwt != null)
    {
      ad.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess asyncCallback != null");
      this.jwt.run();
    }
    AppMethodBeat.o(45530);
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(45531);
    this.dcz = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.jxJ = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.deG = paramParcel.readBundle();
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
    paramParcel.writeInt(this.dcz);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.jxJ);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.deG);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(45532);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */