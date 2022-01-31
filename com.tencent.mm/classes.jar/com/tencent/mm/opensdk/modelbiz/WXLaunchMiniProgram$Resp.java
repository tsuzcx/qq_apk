package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public final class WXLaunchMiniProgram$Resp
  extends BaseResp
{
  public String extMsg;
  
  public WXLaunchMiniProgram$Resp() {}
  
  public WXLaunchMiniProgram$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128215);
    fromBundle(paramBundle);
    AppMethodBeat.o(128215);
  }
  
  public final boolean checkArgs()
  {
    return true;
  }
  
  public final void fromBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128216);
    super.fromBundle(paramBundle);
    this.extMsg = paramBundle.getString("_launch_wxminiprogram_ext_msg");
    AppMethodBeat.o(128216);
  }
  
  public final int getType()
  {
    return 19;
  }
  
  public final void toBundle(Bundle paramBundle)
  {
    AppMethodBeat.i(128217);
    super.toBundle(paramBundle);
    paramBundle.putString("_launch_wxminiprogram_ext_msg", this.extMsg);
    AppMethodBeat.o(128217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Resp
 * JD-Core Version:    0.7.0.1
 */