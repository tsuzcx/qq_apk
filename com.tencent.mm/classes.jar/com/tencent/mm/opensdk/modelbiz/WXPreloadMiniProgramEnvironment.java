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
      AppMethodBeat.i(190430);
      this.extData = "";
      AppMethodBeat.o(190430);
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
      AppMethodBeat.i(190431);
      super.toBundle(paramBundle);
      paramBundle.putString("_preload_wxminiprogram_environment_extData", this.extData);
      AppMethodBeat.o(190431);
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(190404);
      fromBundle(paramBundle);
      AppMethodBeat.o(190404);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(190405);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(190405);
    }
    
    public final int getType()
    {
      return 32;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(190406);
      super.toBundle(paramBundle);
      AppMethodBeat.o(190406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgramEnvironment
 * JD-Core Version:    0.7.0.1
 */