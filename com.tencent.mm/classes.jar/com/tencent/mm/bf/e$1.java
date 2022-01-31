package com.tencent.mm.bf;

import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.az;

final class e$1
  extends j.a
{
  e$1(e parame) {}
  
  public final void onAppBackground(String paramString)
  {
    AppMethodBeat.i(145803);
    paramString = this.fRn;
    Looper.myQueue().addIdleHandler(new e.2(paramString));
    AppMethodBeat.o(145803);
  }
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(145802);
    paramString = this.fRn;
    ab.d("MicroMsg.SpeexUploadCore", "now pause speex uploader");
    paramString.fBI.pL(true);
    AppMethodBeat.o(145802);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bf.e.1
 * JD-Core Version:    0.7.0.1
 */