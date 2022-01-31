package com.tencent.magicbrush.handler.image;

import com.github.henryye.nativeiv.bitmap.IBitmap;

final class a$c
  implements Runnable
{
  private String bmf;
  private boolean bmh = false;
  private a.b bmi;
  
  private a$c(a parama, String paramString)
  {
    this.bmf = paramString;
  }
  
  public final void run()
  {
    IBitmap localIBitmap = this.bmj.loadBitmapSync(this.bmf);
    try
    {
      if (this.bmh) {
        return;
      }
      this.bmi = new a.b(this.bmf, localIBitmap, (byte)0);
      this.bmj.blW.g(this.bmi);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.magicbrush.handler.image.a.c
 * JD-Core Version:    0.7.0.1
 */