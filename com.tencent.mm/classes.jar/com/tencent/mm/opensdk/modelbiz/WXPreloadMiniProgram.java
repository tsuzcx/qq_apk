package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXPreloadMiniProgram
{
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