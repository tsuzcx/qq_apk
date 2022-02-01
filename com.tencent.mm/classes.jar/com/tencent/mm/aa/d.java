package com.tencent.mm.aa;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.a;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap gaL;
  private float gaM;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    k.h(paramBitmap, "preBitmap");
    a locala = a.fVL;
    this.gaL = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.gaM);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    k.h(paramCanvas, "canvas");
    k.h(paramBitmap, "preBitmap");
    ad.i(this.TAG, "draw cacheColorWeight " + this.gaM + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.gaL);
    if ((this.gaL == null) || (paramFloat != this.gaM))
    {
      this.gaM = paramFloat;
      x(paramBitmap);
    }
    paramBitmap = this.gaL;
    if (paramBitmap == null) {
      k.fvU();
    }
    paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    ad.i(this.TAG, "lxl item draw");
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
 * Qualified Name:     com.tencent.mm.aa.d
 * JD-Core Version:    0.7.0.1
 */