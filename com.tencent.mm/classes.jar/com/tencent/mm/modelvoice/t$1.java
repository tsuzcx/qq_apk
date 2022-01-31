package com.tencent.mm.modelvoice;

import com.tencent.mm.ah.j.a;
import com.tencent.mm.f.b.b;
import com.tencent.mm.f.b.b.a;
import com.tencent.mm.sdk.platformtools.y;

final class t$1
  implements b.a
{
  t$1(t paramt) {}
  
  public final void onError()
  {
    if (t.a(this.eLl) != null) {
      t.a(this.eLl).onError();
    }
    try
    {
      t.b(this.eLl).release();
      t.c(this.eLl);
      return;
    }
    catch (Exception localException)
    {
      y.e("VoiceRecorder", "setErrorListener File[" + this.eLl.fileName + "] ErrMsg[" + localException.getStackTrace() + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.t.1
 * JD-Core Version:    0.7.0.1
 */