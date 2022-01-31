package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.h.a.iw;
import com.tencent.mm.h.a.iw.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.a;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

class JsApiLaunchApplication$LaunchApplicationTask
  extends AppBrandProxyTransparentUIProcessTask
{
  public static final Parcelable.Creator<LaunchApplicationTask> CREATOR = new JsApiLaunchApplication.LaunchApplicationTask.2();
  public String appId;
  public Bundle bIo;
  public String extInfo;
  public Runnable gfD;
  public String ggn;
  public int showType;
  public boolean success;
  
  private JsApiLaunchApplication$LaunchApplicationTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiLaunchApplication$LaunchApplicationTask(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
  }
  
  public final void Zv()
  {
    y.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess");
    if (this.gfD != null)
    {
      y.i("MicroMsg.JsApiLaunchApplication", "runInClientProcess asyncCallback != null");
      this.gfD.run();
    }
  }
  
  public final void a(Context paramContext, AppBrandProxyTransparentUIProcessTask.a parama)
  {
    JsApiLaunchApplication.a locala = new JsApiLaunchApplication.a(new JsApiLaunchApplication.LaunchApplicationTask.1(this, parama));
    parama = new WXAppExtendObject();
    parama.extInfo = this.extInfo;
    parama = new WXMediaMessage(parama);
    parama.sdkVer = 620824064;
    parama.messageExt = this.extInfo;
    Object localObject = new iw();
    ((iw)localObject).bRb.bRd = parama;
    ((iw)localObject).bRb.appId = this.appId;
    ((iw)localObject).bRb.showType = this.showType;
    ((iw)localObject).bRb.context = paramContext;
    ((iw)localObject).bRb.bIo = this.bIo;
    ((iw)localObject).bRb.bRe = locala;
    a.udP.m((b)localObject);
    boolean bool = ((iw)localObject).bRc.bRf;
    if (!bool)
    {
      parama = this.appId + "://" + this.ggn;
      localObject = new Intent("android.intent.action.VIEW", Uri.parse(parama));
      y.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { parama });
      ((Intent)localObject).addFlags(268435456);
      parama = bk.A(paramContext, (Intent)localObject);
      if ((parama != null) && (!parama.isEmpty())) {
        if ((TextUtils.isEmpty(((Intent)localObject).getPackage())) && (parama.size() == 1))
        {
          parama = g.b((ResolveInfo)parama.get(0));
          if (bk.pm(ae.getPackageName()).equals(parama)) {
            break label342;
          }
          locala.edU = false;
          locala.ggq = false;
          locala.ggr = false;
          locala.bRf = false;
          bool = g.a(paramContext, (Intent)localObject, null, locala, this.bIo);
        }
      }
    }
    label342:
    for (;;)
    {
      locala.cX(bool);
      return;
      parama = ((Intent)localObject).getPackage();
      break;
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.showType = paramParcel.readInt();
    this.appId = paramParcel.readString();
    this.ggn = paramParcel.readString();
    this.extInfo = paramParcel.readString();
    this.bIo = paramParcel.readBundle();
    if (paramParcel.readByte() == 1) {}
    for (;;)
    {
      this.success = bool;
      return;
      bool = false;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.showType);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.ggn);
    paramParcel.writeString(this.extInfo);
    paramParcel.writeBundle(this.bIo);
    if (this.success) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication.LaunchApplicationTask
 * JD-Core Version:    0.7.0.1
 */