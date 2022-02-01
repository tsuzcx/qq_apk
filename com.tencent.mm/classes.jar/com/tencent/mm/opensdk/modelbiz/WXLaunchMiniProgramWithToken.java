package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXLaunchMiniProgramWithToken
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req";
    public String token;
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3869);
      if (b.b(this.token))
      {
        Log.e("MicroMsg.SDK.WXLaunchMiniProgramWithToken.Req", "token is null");
        AppMethodBeat.o(3869);
        return false;
      }
      AppMethodBeat.o(3869);
      return true;
    }
    
    public final int getType()
    {
      return 29;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3870);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_token", this.token);
      AppMethodBeat.o(3870);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public static final int ERR_INVALID_TOKEN = -1000;
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3913);
      fromBundle(paramBundle);
      AppMethodBeat.o(3913);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3914);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
      AppMethodBeat.o(3914);
    }
    
    public final int getType()
    {
      return 29;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3915);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
      AppMethodBeat.o(3915);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken
 * JD-Core Version:    0.7.0.1
 */