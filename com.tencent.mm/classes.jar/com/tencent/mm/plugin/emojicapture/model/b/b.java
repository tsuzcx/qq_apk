package com.tencent.mm.plugin.emojicapture.model.b;

import a.d.b.g;
import android.graphics.Bitmap;

public final class b
{
  final Bitmap bitmap;
  final long jkI;
  
  public b(Bitmap paramBitmap, long paramLong)
  {
    this.bitmap = paramBitmap;
    this.jkI = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this != paramObject)
    {
      bool1 = bool2;
      if (!(paramObject instanceof b)) {
        break label63;
      }
      paramObject = (b)paramObject;
      bool1 = bool2;
      if (!g.e(this.bitmap, paramObject.bitmap)) {
        break label63;
      }
      if (this.jkI != paramObject.jkI) {
        break label65;
      }
    }
    label63:
    label65:
    for (int i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final int hashCode()
  {
    Bitmap localBitmap = this.bitmap;
    if (localBitmap != null) {}
    for (int i = localBitmap.hashCode();; i = 0)
    {
      long l = this.jkI;
      return i * 31 + (int)(l ^ l >>> 32);
    }
  }
  
  public final String toString()
  {
    return "EmojiFrameInfo(bitmap=" + this.bitmap + ", frameDuration=" + this.jkI + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.b.b
 * JD-Core Version:    0.7.0.1
 */