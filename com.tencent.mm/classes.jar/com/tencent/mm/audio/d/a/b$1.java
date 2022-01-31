package com.tencent.mm.audio.d.a;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(140648);
    b localb = this.clv;
    localb.cjM = new byte[localb.cls];
    while (localb.mIsRecording)
    {
      int i = localb.cjC.read(localb.cjM, 0, localb.cls);
      if (i > 0) {
        localb.clu.w(localb.cjM, i);
      }
    }
    AppMethodBeat.o(140648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.d.a.b.1
 * JD-Core Version:    0.7.0.1
 */