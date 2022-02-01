package com.tencent.mm.opensdk.modelbiz;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;

public class WXQRCodePay
{
  public static class Req
    extends BaseReq
  {
    private static final String TAG = "MicroMsg.SDK.WXQRCodePayReq.Req";
    public String codeContent;
    public String extraMsg;
    
    public boolean checkArgs()
    {
      AppMethodBeat.i(243077);
      boolean bool = TextUtils.isEmpty(this.codeContent);
      AppMethodBeat.o(243077);
      return bool ^ true;
    }
    
    public int getType()
    {
      return 38;
    }
  }
  
  public static final class Resp
    extends BaseResp
  {
    public Resp() {}
    
    public Resp(Bundle paramBundle)
    {
      AppMethodBeat.i(243089);
      fromBundle(paramBundle);
      AppMethodBeat.o(243089);
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243092);
      super.fromBundle(paramBundle);
      AppMethodBeat.o(243092);
    }
    
    public final int getType()
    {
      return 38;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(243095);
      super.toBundle(paramBundle);
      AppMethodBeat.o(243095);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelbiz.WXQRCodePay
 * JD-Core Version:    0.7.0.1
 */