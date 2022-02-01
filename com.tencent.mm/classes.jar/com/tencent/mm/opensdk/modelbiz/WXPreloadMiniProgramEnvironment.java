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
      AppMethodBeat.i(197003);
      this.extData = "";
      AppMethodBeat.o(197003);
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
      AppMethodBeat.i(197004);
      super.toBundle(paramBundle);
      paramBundle.putString("_preload_wxminiprogram_environment_extData", this.extData);
      AppMethodBeat.o(197004);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(196980);
      fromBundle(paramBundle);
      AppMethodBeat.o(196980);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(196981);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(196981);
    }
    
    public final int getType()
    {
      return 32;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(196982);
      super.toBundle(paramBundle);
      AppMethodBeat.o(196982);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment
 * JD-Core Version:    0.7.0.1
 */