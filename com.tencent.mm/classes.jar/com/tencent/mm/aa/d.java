package com.tencent.mm.aa;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.y.a;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"})
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap gzb;
  private float gzc;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void x(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    p.h(paramBitmap, "preBitmap");
    a locala = a.gtc;
    this.gzb = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.gzc);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    p.h(paramCanvas, "canvas");
    p.h(paramBitmap, "preBitmap");
    ad.i(this.TAG, "draw cacheColorWeight " + this.gzc + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.gzb);
    if ((this.gzb == null) || (paramFloat != this.gzc))
    {
      this.gzc = paramFloat;
      x(paramBitmap);
    }
    paramBitmap = this.gzb;
    if (paramBitmap == null) {
      p.gfZ();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aa.d
 * JD-Core Version:    0.7.0.1
 */