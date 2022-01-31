package com.tencent.mm.plugin.mmsight.model.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class n$2
  extends ah
{
  n$2(n paramn, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    y.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "carson：writeYuvData ");
    if (paramMessage.what == 1)
    {
      paramMessage = (byte[])paramMessage.obj;
      if ((paramMessage != null) && (this.mkk.mkb != null)) {
        n.a(this.mkk, paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.model.a.n.2
 * JD-Core Version:    0.7.0.1
 */