package com.tencent.mm.ab;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.y.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/items/FilterItem;", "", "type", "", "(I)V", "TAG", "", "cacheColorWeight", "", "getCacheColorWeight", "()F", "setCacheColorWeight", "(F)V", "cacheFilteredBitmap", "Landroid/graphics/Bitmap;", "getCacheFilteredBitmap", "()Landroid/graphics/Bitmap;", "setCacheFilteredBitmap", "(Landroid/graphics/Bitmap;)V", "getType", "()I", "draw", "", "canvas", "Landroid/graphics/Canvas;", "preBitmap", "colorWeight", "filterBitmap", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements Cloneable
{
  private final String TAG;
  private Bitmap mAr;
  private float mAs;
  private final int type;
  
  public d(int paramInt)
  {
    this.type = paramInt;
    this.TAG = "MicroMsg.FilterItem";
  }
  
  private void F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(163166);
    s.u(paramBitmap, "preBitmap");
    a locala = a.muK;
    this.mAr = a.a(paramBitmap, this.type, paramBitmap.getWidth(), paramBitmap.getHeight(), this.mAs);
    AppMethodBeat.o(163166);
  }
  
  public final void a(Canvas paramCanvas, Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(163165);
    s.u(paramCanvas, "canvas");
    s.u(paramBitmap, "preBitmap");
    Log.i(this.TAG, "draw cacheColorWeight " + this.mAs + ", colorWeight:" + paramFloat + ", cacheFilteredBitmap:" + this.mAr);
    if (this.mAr != null) {
      if (paramFloat != this.mAs) {
        break label130;
      }
    }
    label130:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.mAs = paramFloat;
        F(paramBitmap);
      }
      paramBitmap = this.mAr;
      s.checkNotNull(paramBitmap);
      paramCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
      Log.i(this.TAG, "lxl item draw");
      AppMethodBeat.o(163165);
      return;
    }
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