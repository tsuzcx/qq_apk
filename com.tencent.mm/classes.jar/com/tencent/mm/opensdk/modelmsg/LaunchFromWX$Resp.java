package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class LaunchFromWX$Resp
  extends BaseResp
{
  public LaunchFromWX$Resp() {}
  
  public LaunchFromWX$Resp(Bundle paramBundle)
  {
    AppMethodBeat.i(128262);
    fromBundle(paramBundle);
    AppMethodBeat.o(128262);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public int getType()
  {
    return 6;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.LaunchFromWX.Resp
 * JD-Core Version:    0.7.0.1
 */