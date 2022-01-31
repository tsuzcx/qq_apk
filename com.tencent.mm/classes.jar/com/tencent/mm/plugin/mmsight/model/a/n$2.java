package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class n$2
  extends ak
{
  n$2(n paramn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(76630);
    ab.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
    if (paramMessage.what == 1)
    {
      paramMessage = (byte[])paramMessage.obj;
      if ((paramMessage != null) && (this.oJA.oJw != null)) {
        n.a(this.oJA, paramMessage);
      }
    }
    AppMethodBeat.o(76630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.2
 * JD-Core Version:    0.7.0.1
 */