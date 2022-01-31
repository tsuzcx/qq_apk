package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;

public final class WXLaunchMiniProgram$Req
  extends BaseReq
{
  public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
  public static final int MINIPROGRAM_TYPE_TEST = 1;
  public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
  private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
  public String extData = "";
  public int miniprogramType = 0;
  public String path = "";
  public String userName;
  
  public final boolean checkArgs()
  {
    AppMethodBeat.i(128194);
    if (d.b(this.userName))
    {
      Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "userName is null");
      AppMethodBeat.o(128194);
      return false;
    }
    if ((this.miniprogramType < 0) || (this.miniprogramType > 2))
    {
      Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      AppMethodBeat.o(128194);
      return false;
    }
    AppMethodBeat.o(128194);
    return true;
  }
  
  public final int getType()
  {
    return 19;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128195);
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_username", this.userName);
    paramBundle.putString("_launch_wxminiprogram_path", this.path);
    paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
    paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
    AppMethodBeat.o(128195);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req
 * JD-Core Version:    0.7.0.1
 */