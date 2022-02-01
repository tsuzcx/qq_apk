package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;

@Keep
class CommNativeBitmapStruct
  extends NativeBitmapStruct
{
  @Keep
  private int nConfig = -1;
  @Keep
  private boolean premultiplyAlpha;
  
  public CommNativeBitmapStruct convertToCommonStruct()
  {
    int j = 0;
    int k = 5121;
    int m = this.nConfig;
    int i;
    if (m == 4)
    {
      i = k;
      this.glType = i;
      k = this.nConfig;
      if (k != 4) {
        break label67;
      }
      i = 6408;
    }
    for (;;)
    {
      this.glFormat = i;
      return this;
      i = k;
      if (m == 3) {
        break;
      }
      i = k;
      if (m == 2) {
        break;
      }
      i = 0;
      break;
      label67:
      if (k == 3)
      {
        i = 6407;
      }
      else
      {
        i = j;
        if (k == 2) {
          i = 6406;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.CommNativeBitmapStruct
 * JD-Core Version:    0.7.0.1
 */