package com.tencent.liteav.basic.d;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class d$2
  implements Runnable
{
  d$2(d paramd, ByteBuffer paramByteBuffer, Bitmap paramBitmap, int paramInt1, int paramInt2, n paramn) {}
  
  public void run()
  {
    AppMethodBeat.i(146549);
    this.a.position(0);
    this.b.copyPixelsFromBuffer(this.a);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    localObject = Bitmap.createBitmap(this.b, 0, 0, this.c, this.d, (Matrix)localObject, false);
    this.e.onTakePhotoComplete((Bitmap)localObject);
    this.b.recycle();
    AppMethodBeat.o(146549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.basic.d.d.2
 * JD-Core Version:    0.7.0.1
 */