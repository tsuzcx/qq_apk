package com.github.henryye.nativeiv.comm;

import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.github.henryye.nativeiv.bitmap.a;

public class b
  implements a<NativeBitmapStruct>
{
  public boolean a(com.github.henryye.nativeiv.bitmap.b paramb)
  {
    return (paramb == com.github.henryye.nativeiv.bitmap.b.asu) || (paramb == com.github.henryye.nativeiv.bitmap.b.ast);
  }
  
  public final IBitmap<NativeBitmapStruct> km()
  {
    return new NativeImage();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.github.henryye.nativeiv.comm.b
 * JD-Core Version:    0.7.0.1
 */