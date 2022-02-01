package com.tencent.mm.compatible.deviceinfo;

import android.os.Process;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class aa$1
  implements Runnable
{
  aa$1(aa paramaa) {}
  
  public final void run()
  {
    AppMethodBeat.i(240857);
    Toast.makeText(MMApplicationContext.getContext(), String.format("MediaCodecProxy queueInputBuffer, thread:[%s]", new Object[] { Integer.valueOf(Process.myTid()) }), 1).show();
    AppMethodBeat.o(240857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.aa.1
 * JD-Core Version:    0.7.0.1
 */