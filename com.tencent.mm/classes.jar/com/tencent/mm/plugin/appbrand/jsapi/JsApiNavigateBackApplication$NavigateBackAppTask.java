package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ae;

final class JsApiNavigateBackApplication$NavigateBackAppTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<NavigateBackAppTask> CREATOR = new JsApiNavigateBackApplication.NavigateBackAppTask.1();
  public String appId;
  public String data;
  
  public JsApiNavigateBackApplication$NavigateBackAppTask() {}
  
  public JsApiNavigateBackApplication$NavigateBackAppTask(String paramString1, String paramString2)
  {
    this.appId = paramString1;
    this.data = paramString2;
  }
  
  public final void Zu()
  {
    f localf = g.by(this.appId, true);
    if (localf == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    WXLaunchMiniProgram.Resp localResp = new WXLaunchMiniProgram.Resp(localBundle);
    localResp.extMsg = this.data;
    localResp.openId = localf.field_openId;
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = localf.field_packageName;
    localResp.toBundle(localBundle);
    localArgs.bundle = localBundle;
    p.ak(localBundle);
    p.al(localBundle);
    MMessageActV2.send(ae.getContext(), localArgs);
  }
  
  public final void e(Parcel paramParcel)
  {
    this.appId = paramParcel.readString();
    this.data = paramParcel.readString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.data);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication.NavigateBackAppTask
 * JD-Core Version:    0.7.0.1
 */