package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import java.nio.ByteBuffer;

class d$4
  implements Runnable
{
  d$4(d paramd, ByteBuffer paramByteBuffer, Bitmap paramBitmap, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.a.position(0);
    this.b.copyPixelsFromBuffer(this.a);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(1.0F, -1.0F);
    localObject = Bitmap.createBitmap(this.b, 0, 0, this.c, this.d, (Matrix)localObject, false);
    if (d.b(this.e) != null)
    {
      d.b(this.e).onTakePhotoComplete((Bitmap)localObject);
      d.a(this.e, null);
    }
    this.b.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.renderer.d.4
 * JD-Core Version:    0.7.0.1
 */