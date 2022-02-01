package com.tencent.mm.compatible.deviceinfo;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class z$2
  implements Runnable
{
  z$2(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(213383);
    Toast.makeText(ak.getContext(), String.format("MediaCodecProxy dequeueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(213383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z.2
 * JD-Core Version:    0.7.0.1
 */