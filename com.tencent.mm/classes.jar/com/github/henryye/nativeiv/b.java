package com.github.henryye.nativeiv;

import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private static final Object aux;
  public com.github.henryye.nativeiv.a.b auA;
  public a auB;
  public BitmapType auy;
  public IBitmap auz;
  
  static
  {
    AppMethodBeat.i(115749);
    aux = new Object();
    AppMethodBeat.o(115749);
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(115747);
    this.auy = null;
    this.auz = new b.a();
    this.auB = parama;
    AppMethodBeat.o(115747);
  }
  
  final BitmapType mu()
  {
    AppMethodBeat.i(115748);
    if (this.auz != null)
    {
      localBitmapType = this.auz.getType();
      AppMethodBeat.o(115748);
      return localBitmapType;
    }
    BitmapType localBitmapType = BitmapType.Undefined;
    AppMethodBeat.o(115748);
    return localBitmapType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.github.henryye.nativeiv.b
 * JD-Core Version:    0.7.0.1
 */