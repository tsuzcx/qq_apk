package com.tencent.mm.compatible.deviceinfo;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class z$1
  implements Runnable
{
  z$1(z paramz) {}
  
  public final void run()
  {
    AppMethodBeat.i(213382);
    Toast.makeText(ak.getContext(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(213382);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.z.1
 * JD-Core Version:    0.7.0.1
 */