package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import java.util.Map;

public final class b
{
  private final Object ask = new Object();
  public BitmapType asl = null;
  public IBitmap asm = new b.a();
  public com.github.henryye.nativeiv.a.a asn;
  
  public static void a(com.github.henryye.nativeiv.bitmap.a<NativeBitmapStruct> parama)
  {
    a locala = a.asf;
    BitmapType localBitmapType = BitmapType.Native;
    locala.asg.put(localBitmapType, parama);
  }
  
  final BitmapType kn()
  {
    if (this.asm != null) {
      return this.asm.getType();
    }
    return BitmapType.Undefined;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.github.henryye.nativeiv.b
 * JD-Core Version:    0.7.0.1
 */