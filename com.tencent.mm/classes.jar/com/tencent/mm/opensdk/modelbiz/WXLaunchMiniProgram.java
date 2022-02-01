package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXLaunchMiniProgram
{
  public static final class Req
    extends BaseReq
  {
    public static final int MINIPROGRAM_TYPE_PREVIEW = 2;
    public static final int MINIPROGRAM_TYPE_TEST = 1;
    public static final int MINIPTOGRAM_TYPE_RELEASE = 0;
    private static final String TAG = "MicroMsg.SDK.WXLaunchMiniProgram.Req";
    public String extData;
    public int miniprogramType;
    public String path;
    public String userName;
    
    public Req()
    {
      AppMethodBeat.i(254790);
      this.path = "";
      this.miniprogramType = 0;
      this.extData = "";
      AppMethodBeat.o(254790);
    }
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3886);
      if (b.b(this.userName))
      {
        Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "userName is null");
        AppMethodBeat.o(3886);
        return false;
      }
      int i = this.miniprogramType;
      if ((i >= 0) && (i <= 2))
      {
        AppMethodBeat.o(3886);
        return true;
      }
      Log.e("MicroMsg.SDK.WXLaunchMiniProgram.Req", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      AppMethodBeat.o(3886);
      return false;
    }
    
    public final int getType()
    {
      return 19;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3887);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_username", this.userName);
      paramBundle.putString("_launch_wxminiprogram_path", this.path);
      paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
      paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
      AppMethodBeat.o(3887);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3907);
      fromBundle(paramBundle);
      AppMethodBeat.o(3907);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3908);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
      AppMethodBeat.o(3908);
    }
    
    public final int getType()
    {
      return 19;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3909);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
      AppMethodBeat.o(3909);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram
 * JD-Core Version:    0.7.0.1
 */