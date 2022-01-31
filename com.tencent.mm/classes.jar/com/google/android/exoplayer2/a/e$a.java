package com.google.android.exoplayer2.a;

import android.os.Handler;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.i.a;

public final class e$a
{
  final e avZ;
  final Handler handler;
  
  public e$a(Handler paramHandler, e parame)
  {
    if (parame != null) {}
    for (paramHandler = (Handler)a.E(paramHandler);; paramHandler = null)
    {
      this.handler = paramHandler;
      this.avZ = parame;
      return;
    }
  }
  
  public final void e(d paramd)
  {
    if (this.avZ != null) {
      this.handler.post(new e.a.5(this, paramd));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.e.a
 * JD-Core Version:    0.7.0.1
 */