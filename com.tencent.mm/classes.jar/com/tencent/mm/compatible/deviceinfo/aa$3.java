package com.tencent.mm.compatible.deviceinfo;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class aa$3
  implements Runnable
{
  aa$3(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(240859);
    Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy dequeueOutputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(240859);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa.3
 * JD-Core Version:    0.7.0.1
 */