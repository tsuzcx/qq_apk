package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXPreloadMiniProgramEnvironment
{
  public static final class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXPreloadMiniProgramEnvironment.Req";
    public String extData;
    
    public Req()
    {
      AppMethodBeat.i(255241);
      this.extData = "";
      AppMethodBeat.o(255241);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final int getType()
    {
      return 32;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(255243);
      super.toBundle(paramBundle);
      paramBundle.putString("_preload_wxminiprogram_environment_extData", this.extData);
      AppMethodBeat.o(255243);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(255037);
      fromBundle(paramBundle);
      AppMethodBeat.o(255037);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(255038);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(255038);
    }
    
    public final int getType()
    {
      return 32;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(255040);
      super.toBundle(paramBundle);
      AppMethodBeat.o(255040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment
 * JD-Core Version:    0.7.0.1
 */