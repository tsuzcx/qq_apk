package com.tencent.mm.compatible.deviceinfo;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class z$3
  implements Runnable
{
  z$3(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(201271);
    Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(201271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z.3
 * JD-Core Version:    0.7.0.1
 */