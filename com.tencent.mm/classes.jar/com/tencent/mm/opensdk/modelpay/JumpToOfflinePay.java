package com.tencent.mm.opensdk.modelpay;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class JumpToOfflinePay
{
  public static class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.JumpToOfflinePay.Req";
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3840);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(3840);
    }
    
    public int getType()
    {
      return 24;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3839);
      super.toBundle(paramBundle);
      AppMethodBeat.o(3839);
    }
  }
  
  public static class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(3836);
      fromBundle(paramBundle);
      AppMethodBeat.o(3836);
    }
    
    public boolean checkArgs()
    {
      return true;
    }
    
    public void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3838);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(3838);
    }
    
    public int getType()
    {
      return 24;
    }
    
    public void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(3837);
      super.toBundle(paramBundle);
      AppMethodBeat.o(3837);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelpay.JumpToOfflinePay
 * JD-Core Version:    0.7.0.1
 */