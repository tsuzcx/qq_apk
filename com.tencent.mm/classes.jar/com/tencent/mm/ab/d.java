package com.tencent.mm.ab;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap kao;
  private float kap;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    p.k(paramBitmap, "preBitmap");
    a locala = a.jUw;
    this.kao = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.kap);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    p.k(paramCanvas, "canvas");
    p.k(paramBitmap, "preBitmap");
    Log.i(this.TAG, "draw cacheColorWeight " + this.kap + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.kao);
    if ((this.kao == null) || (paramFloat != this.kap))
    {
      this.kap = paramFloat;
      x(paramBitmap);
    }
    paramBitmap = this.kao;
    if (paramBitmap == null) {
      p.iCn();
    }
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    Log.i(this.TAG, "lxl item draw");
    AppMethodBeat.o(163165);
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(163167);
    Object localObject = super.clone();
    AppMethodBeat.o(163167);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ab.d
 * JD-Core Version:    0.7.0.1
 */