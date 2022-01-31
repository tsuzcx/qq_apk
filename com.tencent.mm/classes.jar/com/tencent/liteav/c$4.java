package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.util.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class c$4
  implements Runnable
{
  c$4(c paramc, Bitmap paramBitmap, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer) {}
  
  public void run()
  {
    AppMethodBeat.i(67767);
    try
    {
      int i = this.a.getWidth();
      int j = this.a.getHeight();
      a locala = b.a(i, j, this.b, this.c);
      c.h(this.e).a(locala);
      c.h(this.e).b(false);
      c.h(this.e).a(this.b, this.c);
      c.h(this.e).a(0);
      c.h(this.e).a(this.d.array(), i, j, 0, 2, 0);
      AppMethodBeat.o(67767);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(67767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.c.4
 * JD-Core Version:    0.7.0.1
 */