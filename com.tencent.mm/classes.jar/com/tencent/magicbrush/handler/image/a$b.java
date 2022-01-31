package com.tencent.magicbrush.handler.image;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.magicbrush.engine.d;

final class a$b
  implements Runnable
{
  private String bmf;
  private IBitmap<NativeBitmapStruct> bmg;
  volatile boolean bmh = false;
  
  private a$b(String paramString, IBitmap<NativeBitmapStruct> paramIBitmap)
  {
    this.bmf = paramString;
    this.bmg = paramIBitmap;
  }
  
  public final void run()
  {
    if (this.bmh)
    {
      this.bmg.recycle();
      return;
    }
    d.a(this.bmf, this.bmg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.b
 * JD-Core Version:    0.7.0.1
 */