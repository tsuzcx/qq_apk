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
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class JsApiNavigateBackApplication
  extends a<r>
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
      AppMethodBeat.i(130500);
      CREATOR = new JsApiNavigateBackApplication.NavigateBackAppTask.1();
      AppMethodBeat.o(130500);
    }
    
    public NavigateBackAppTask() {}
    
    public NavigateBackAppTask(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.appId = paramString1;
      this.data = paramString2;
      this.businessType = paramString3;
      this.errCode = paramInt;
    }
    
    private static void a(Bundle paramBundle, BaseResp paramBaseResp, f paramf)
    {
      AppMethodBeat.i(130497);
      paramBaseResp.toBundle(paramBundle);
      paramBaseResp = new MMessageActV2.Args();
      paramBaseResp.targetPkgName = paramf.field_packageName;
      paramBaseResp.bundle = paramBundle;
      p.aC(paramBundle);
      p.aD(paramBundle);
      MMessageActV2.send(ah.getContext(), paramBaseResp);
      AppMethodBeat.o(130497);
    }
    
    public final void ata()
    {
      AppMethodBeat.i(130496);
      f localf = g.ca(this.appId, true);
      ab.i("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appid %s", new Object[] { this.appId });
      if (localf == null)
      {
        ab.w("MicroMsg.JsApiNavigateBackApplication", "NavigateBackAppTask appinfo is null");
        AppMethodBeat.o(130496);
        return;
      }
      Bundle localBundle = new Bundle();
      if (bo.isNullOrNil(this.businessType))
      {
        localObject = new WXLaunchMiniProgram.Resp(localBundle);
        ((WXLaunchMiniProgram.Resp)localObject).extMsg = this.data;
        ((WXLaunchMiniProgram.Resp)localObject).openId = localf.field_openId;
        a(localBundle, (BaseResp)localObject, localf);
        AppMethodBeat.o(130496);
        return;
      }
      Object localObject = new WXOpenBusinessView.Resp(localBundle);
      ((WXOpenBusinessView.Resp)localObject).extMsg = this.data;
      ((WXOpenBusinessView.Resp)localObject).openId = localf.field_openId;
      ((WXOpenBusinessView.Resp)localObject).errCode = this.errCode;
      ((WXOpenBusinessView.Resp)localObject).businessType = this.businessType;
      a(localBundle, (BaseResp)localObject, localf);
      AppMethodBeat.o(130496);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(130499);
      this.appId = paramParcel.readString();
      this.data = paramParcel.readString();
      this.businessType = paramParcel.readString();
      this.errCode = paramParcel.readInt();
      AppMethodBeat.o(130499);
    }
    
    public final void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(130498);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.data);
      paramParcel.writeString(this.businessType);
      paramParcel.writeInt(this.errCode);
      AppMethodBeat.o(130498);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiNavigateBackApplication
 * JD-Core Version:    0.7.0.1
 */