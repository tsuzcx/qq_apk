package com.tencent.mm.plugin.finder.ui.post;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "fromAppId", "getFromAppId", "()Ljava/lang/String;", "setFromAppId", "(Ljava/lang/String;)V", "paramsJson", "getParamsJson", "setParamsJson", "remoteUrl", "getRemoteUrl", "setRemoteUrl", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "videoSource", "", "getVideoSource", "()I", "setVideoSource", "(I)V", "getShareAppId", "getShareType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class SdkShareUIC
  extends UIComponent
{
  public static final int vRA = 1;
  public static final int vRB = 2;
  public static final a vRC;
  private final String TAG;
  public String tsW;
  public String tsX;
  private dxx ueI;
  public String vRz;
  private int videoSource;
  
  static
  {
    AppMethodBeat.i(253017);
    vRC = new a((byte)0);
    vRA = 1;
    vRB = 2;
    AppMethodBeat.o(253017);
  }
  
  public SdkShareUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(253016);
    this.TAG = "Finder.SdkShareUIC";
    this.vRz = "";
    this.tsW = "";
    this.tsX = "";
    this.videoSource = 4;
    AppMethodBeat.o(253016);
  }
  
  public final String dAO()
  {
    Object localObject = this.ueI;
    if (localObject != null)
    {
      localObject = ((dxx)localObject).MXA;
      if (localObject != null)
      {
        String str = ((dqh)localObject).dNI;
        localObject = str;
        if (str != null) {
          return localObject;
        }
      }
    }
    localObject = "";
    return localObject;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(253015);
    super.onCreate(paramBundle);
    paramBundle = (a)new dxx();
    Object localObject = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.ueI = ((dxx)paramBundle);
      this.vRz = dAO();
      localObject = getIntent().getStringExtra("KEY_POST_REMOTE_URL");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.tsW = paramBundle;
      localObject = getIntent().getStringExtra("KEY_POST_FROM_APP_PARAMJSON");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.tsX = paramBundle;
      this.videoSource = getIntent().getIntExtra("KEY_SHARE_VIDEO_SOURCE", 4);
      if (!Util.isNullOrNil(this.vRz))
      {
        paramBundle = i.vfo;
        i.Kr(this.videoSource);
        paramBundle = i.vfo;
        i.auG(this.vRz);
      }
      Log.i(this.TAG, "sdkshare, fromAppId:" + this.vRz + ", remoteUrl:" + this.tsW + ", paramsJson:" + this.tsX);
      AppMethodBeat.o(253015);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC$Companion;", "", "()V", "SDK_POST_TYPE_NORMAL", "", "getSDK_POST_TYPE_NORMAL", "()I", "SDK_POST_TYPE_REMOTE_URL", "getSDK_POST_TYPE_REMOTE_URL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.post.SdkShareUIC
 * JD-Core Version:    0.7.0.1
 */