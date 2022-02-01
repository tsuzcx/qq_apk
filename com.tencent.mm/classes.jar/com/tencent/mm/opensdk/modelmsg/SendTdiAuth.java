package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SendTdiAuth
{
  public static final class Resp
    extends SendAuth.Resp
  {
    private static final String KEY_AUTH_BUFFER = "_wxapi_sendauth_resp_tdi_buffer";
    private static final String TAG = "MicroMsg.SDK.SendTdiAuth.Resp";
    public byte[] tdiAuthBuffer;
    
    public Resp(Bundle paramBundle)
    {
      super();
    }
    
    public final boolean checkArgs()
    {
      return true;
    }
    
    public final void fromBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(194117);
      super.fromBundle(paramBundle);
      this.tdiAuthBuffer = paramBundle.getByteArray("_wxapi_sendauth_resp_tdi_buffer");
      AppMethodBeat.o(194117);
    }
    
    public final int getType()
    {
      return 31;
    }
    
    public final void toBundle(Bundle paramBundle)
    {
      AppMethodBeat.i(194118);
      super.toBundle(paramBundle);
      paramBundle.putByteArray("_wxapi_sendauth_resp_tdi_buffer", this.tdiAuthBuffer);
      AppMethodBeat.o(194118);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.SendTdiAuth
 * JD-Core Version:    0.7.0.1
 */