package com.tencent.liteav;

import android.os.Bundle;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

class e$6
  implements Runnable
{
  e$6(e parame, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    AppMethodBeat.i(67358);
    b.a(this.c.d, this.a, this.b);
    if ((this.a == 2103) && (e.g(this.c) != null)) {
      e.g(this.c).restartDecoder();
    }
    AppMethodBeat.o(67358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteav.e.6
 * JD-Core Version:    0.7.0.1
 */