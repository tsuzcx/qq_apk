package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView.Resp;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public final class JsApiNavigateBackApplication
  extends c<com.tencent.mm.plugin.appbrand.g>
{
  private static final int CTRL_INDEX = 288;
  public static final String NAME = "navigateBackApplication";
  
  public static final class NavigateBackAppTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<NavigateBackAppTask> CREATOR;
    public String appId;
    public String businessType;
    public String data;
    public int errCode;
    
    static
    {
      AppMethodBeat.i(45558);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45558);
    }
    
    public NavigateBackAppTask() {}
    
    public NavigateBackAppTask(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.appId = paramString1;
      this.data = paramString2;
      this.businessType = paramString3;
      this.errCode = paramInt;
    }
    
    private static void a(Bundle paramBundle, BaseResp paramBaseResp, com.tencent.mm.pluginsdk.model.app.g paramg)
    {
      AppMethodBeat.i(45555);
      paramBaseResp.toBundle(paramBundle);
      paramBaseResp = new MMessageActV2.Args();
      paramBaseResp.targetPkgName = paramg.field_packageName;
      paramBaseResp.bundle = paramBundle;
      u.bS(paramBundle);
      u.bT(paramBundle);
      MMessageActV2.send(MMApplicationContext.getContext(), paramBaseResp);
      AppMethodBeat.o(45555);
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45554);
      com.tencent.mm.pluginsdk.model.app.g localg = h.s(this.appId, true, true);
      Log.i("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appid %s", new Object[] { this.appId });
      if (localg == null)
      {
        Log.w("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appinfo is null");
        AppMethodBeat.o(45554);
        return;
      }
      if (!h.i(localg))
      {
        Log.e("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask packageName invalid");
        AppMethodBeat.o(45554);
        return;
      }
      Bundle localBundle = new Bundle();
      if (Util.isNullOrNil(this.businessType))
      {
        localObject = new WXLaunchMiniProgram.Resp(localBundle);
        ((WXLaunchMiniProgram.Resp)localObject).extMsg = this.data;
        ((WXLaunchMiniProgram.Resp)localObject).openId = localg.field_openId;
        a(localBundle, (BaseResp)localObject, localg);
        AppMethodBeat.o(45554);
        return;
      }
      Object localObject = new WXOpenBusinessView.Resp(localBundle);
      ((WXOpenBusinessView.Resp)localObject).extMsg = this.data;
      ((WXOpenBusinessView.Resp)localObject).openId = localg.field_openId;
      ((WXOpenBusinessView.Resp)localObject).errCode = this.errCode;
      ((WXOpenBusinessView.Resp)localObject).businessType = this.businessType;
      ((WXOpenBusinessView.Resp)localObject).transaction = n.YtV;
      a(localBundle, (BaseResp)localObject, localg);
      AppMethodBeat.o(45554);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45557);
      this.appId = paramParcel.readString();
      this.data = paramParcel.readString();
      this.businessType = paramParcel.readString();
      this.errCode = paramParcel.readInt();
      AppMethodBeat.o(45557);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45556);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.data);
      paramParcel.writeString(this.businessType);
      paramParcel.writeInt(this.errCode);
      AppMethodBeat.o(45556);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication
 * JD-Core Version:    0.7.0.1
 */