package com.tencent.mm.plugin.facedetect.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.bo;

final class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(546);
    long l = bo.yB();
    a.m(this.mnN.mnI).connect(new a.3.1.1(this, l));
    AppMethodBeat.o(546);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.e.a.3.1
 * JD-Core Version:    0.7.0.1
 */