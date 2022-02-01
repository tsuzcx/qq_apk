package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;

public class WXPreloadMiniProgram
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgram.Req";
    public String extData;
    public int miniprogramType;
    public String path;
    public String userName;
    
    public Req()
    {
      AppMethodBeat.i(243025);
      this.path = "";
      this.miniprogramType = 0;
      this.extData = "";
      AppMethodBeat.o(243025);
    }
    
    public final boolean checkArgs()
    {
      AppMethodBeat.i(3929);
      if (b.b(this.userName))
      {
        Log.e("MicroMsg.SDK.WXPreloadMiniProgram.Req", "userName is null");
        AppMethodBeat.o(3929);
        return false;
      }
      int i = this.miniprogramType;
      if ((i >= 0) && (i <= 2))
      {
        AppMethodBeat.o(3929);
        return true;
      }
      Log.e("MicroMsg.SDK.WXPreloadMiniProgram.Req", "miniprogram type should between MINIPTOGRAM_TYPE_RELEASE and MINIPROGRAM_TYPE_PREVIEW");
      AppMethodBeat.o(3929);
      return false;
    }
    
    public final int getType()
    {
      return 28;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3930);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_username", this.userName);
      paramBundle.putString("_launch_wxminiprogram_path", this.path);
      paramBundle.putString("_launch_wxminiprogram_extData", this.extData);
      paramBundle.putInt("_launch_wxminiprogram_type", this.miniprogramType);
      AppMethodBeat.o(3930);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public String extMsg;
    
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3923);
      fromBundle(paramBundle);
      AppMethodBeat.o(3923);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3924);
      super.fromBundle(paramBundle);
      this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
      AppMethodBeat.o(3924);
    }
    
    public final int getType()
    {
      return 28;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3925);
      super.toBundle(paramBundle);
      paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
      AppMethodBeat.o(3925);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram
 * JD-Core Version:    0.7.0.1
 */