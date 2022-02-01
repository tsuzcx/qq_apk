package com.tencent.mm.plugin.finder.live.ui.post;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.ead;
import com.tencent.mm.protocal.protobuf.ehy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/post/SdkShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "TAG", "", "fromAppId", "getFromAppId", "()Ljava/lang/String;", "setFromAppId", "(Ljava/lang/String;)V", "miaojianExtInfo", "getMiaojianExtInfo", "setMiaojianExtInfo", "paramsJson", "getParamsJson", "setParamsJson", "remoteUrl", "getRemoteUrl", "setRemoteUrl", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "videoSource", "", "getVideoSource", "()I", "setVideoSource", "(I)V", "getShareAppId", "getShareType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class e
  extends UIComponent
{
  public static final int yPx = 1;
  public static final int yPy = 2;
  public static final a yPz;
  private final String TAG;
  private int videoSource;
  private ehy xSl;
  public String xaL;
  public String xaM;
  public String yPv;
  public String yPw;
  
  static
  {
    AppMethodBeat.i(221944);
    yPz = new a((byte)0);
    yPx = 1;
    yPy = 2;
    AppMethodBeat.o(221944);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(221942);
    this.TAG = "Finder.SdkShareUIC";
    this.yPv = "";
    this.xaL = "";
    this.xaM = "";
    this.videoSource = 4;
    this.yPw = "";
    AppMethodBeat.o(221942);
  }
  
  public final String dEn()
  {
    Object localObject = this.xSl;
    if (localObject != null)
    {
      localObject = ((ehy)localObject).UjV;
      if (localObject != null)
      {
        String str = ((ead)localObject).appid;
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
    AppMethodBeat.i(221939);
    super.onCreate(paramBundle);
    paramBundle = (a)new ehy();
    Object localObject = getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE");
    try
    {
      paramBundle.parseFrom((byte[])localObject);
      this.xSl = ((ehy)paramBundle);
      this.yPv = dEn();
      localObject = getIntent().getStringExtra("KEY_POST_REMOTE_URL");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.xaL = paramBundle;
      localObject = getIntent().getStringExtra("KEY_POST_FROM_APP_PARAMJSON");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.xaM = paramBundle;
      this.videoSource = getIntent().getIntExtra("KEY_SHARE_VIDEO_SOURCE", 4);
      if (!Util.isNullOrNil(this.yPv))
      {
        paramBundle = k.zWs;
        k.Pv(this.videoSource);
        paramBundle = k.zWs;
        k.aDZ(this.yPv);
      }
      localObject = getIntent().getStringExtra("KEY_MIAOJIAN_EXTINFO");
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      this.yPw = paramBundle;
      Log.i(this.TAG, "sdkshare, fromAppId:" + this.yPv + ", remoteUrl:" + this.xaL + ", paramsJson:" + this.xaM + ", miaojianExtInfo:" + this.yPw);
      AppMethodBeat.o(221939);
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/ui/post/SdkShareUIC$Companion;", "", "()V", "SDK_POST_TYPE_NORMAL", "", "getSDK_POST_TYPE_NORMAL", "()I", "SDK_POST_TYPE_REMOTE_URL", "getSDK_POST_TYPE_REMOTE_URL", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.ui.post.e
 * JD-Core Version:    0.7.0.1
 */