package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jf.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR;
  public String appId;
  public Bundle cpJ;
  public String extInfo;
  public Runnable hxp;
  public String hym;
  public int showType;
  public boolean success;
  
  static
  {
    AppMethodBeat.i(130447);
    CREATOR = new JsApiLaunchApplication.LaunchApplicationTask.2();
    AppMethodBeat.o(130447);
  }
  
  private JsApiLaunchApplication$LaunchApplicationTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130446);
    f(paramParcel);
    AppMethodBeat.o(130446);
  }
  
  public JsApiLaunchApplication$LaunchApplicationTask(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama)
  {
    AppMethodBeat.i(130442);
    JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.LaunchApplicationTask.1(this, parama));
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 620954624;
    parama.messageExt = this.extInfo;
    Object localObject = new jf();
    ((jf)localObject).cyD.cyF = parama;
    ((jf)localObject).cyD.appId = this.appId;
    ((jf)localObject).cyD.showType = this.showType;
    ((jf)localObject).cyD.context = paramContext;
    ((jf)localObject).cyD.cpJ = this.cpJ;
    ((jf)localObject).cyD.cyG = locala;
    a.ymk.l((b)localObject);
    boolean bool1 = ((jf)localObject).cyE.cyH;
    boolean bool2 = bool1;
    if (!bool1)
    {
      if ((bo.isNullOrNil(this.appId)) || (bo.isNullOrNil(this.hym))) {
        break label379;
      }
      parama = this.appId + "://" + this.hym;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bo.H(paramContext, (Intent)localObject);
      if ((parama == null) || (parama.isEmpty())) {
        break label392;
      }
      if ((!TextUtils.isEmpty(((Intent)localObject).getPackage())) || (parama.size() != 1)) {
        break label370;
      }
      parama = g.b((ResolveInfo)parama.get(0));
      if (bo.nullAsNil(ah.getPackageName()).equals(parama)) {
        break label392;
      }
      locala.ftW = false;
      locala.hyp = false;
      locala.hyq = false;
      locala.cyH = false;
      bool1 = g.a(paramContext, (Intent)localObject, null, locala, this.cpJ);
    }
    label392:
    for (;;)
    {
      for (bool2 = bool1;; bool2 = bool1)
      {
        locala.ea(bool2);
        AppMethodBeat.o(130442);
        return;
        label370:
        parama = ((Intent)localObject).getPackage();
        break;
        label379:
        ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication nil appId or parameter.");
      }
    }
  }
  
  public final void atb()
  {
    AppMethodBeat.i(130443);
    ab.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
    if (this.hxp != null)
    {
      ab.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
      this.hxp.run();
    }
    AppMethodBeat.o(130443);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(130444);
    this.showType = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.hym = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.cpJ = paramParcel.readBundle();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      AppMethodBeat.o(130444);
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130445);
    paramParcel.writeInt(this.showType);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hym);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.cpJ);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      AppMethodBeat.o(130445);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */