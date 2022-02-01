package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class LaunchFromWX
{
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3962);
      fromBundle(paramBundle);
      AppMethodBeat.o(3962);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.LaunchFromWX
 * JD-Core Version:    0.7.0.1
 */