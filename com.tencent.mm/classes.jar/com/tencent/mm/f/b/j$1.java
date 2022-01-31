package com.tencent.mm.f.b;

import com.tencent.mm.sdk.platformtools.y;

final class j$1
  implements b.a
{
  j$1(j paramj) {}
  
  public final void onError()
  {
    j.a(this.bEm).zE();
    if (j.b(this.bEm) != null) {
      j.b(this.bEm).onError();
    }
    try
    {
      j.c(this.bEm).release();
      j.d(this.bEm);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SimpleVoiceRecorder", "setErrorListener File[" + this.bEm.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.j.1
 * JD-Core Version:    0.7.0.1
 */