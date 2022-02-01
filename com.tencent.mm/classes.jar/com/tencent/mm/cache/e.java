package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.d;
import com.tencent.mm.y.a;
import com.tencent.mm.y.a.a;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/cache/FilterCache;", "Lcom/tencent/mm/cache/IBaseArtistCache;", "Lcom/tencent/mm/items/FilterItem;", "()V", "curColorWeight", "", "getCurColorWeight", "()F", "setCurColorWeight", "(F)V", "curSeletedTypeIndex", "", "getCurSeletedTypeIndex", "()I", "setCurSeletedTypeIndex", "(I)V", "effects", "", "getEffects", "()Ljava/util/List;", "preBitmap", "Landroid/graphics/Bitmap;", "getPreBitmap", "()Landroid/graphics/Bitmap;", "setPreBitmap", "(Landroid/graphics/Bitmap;)V", "add", "", "item", "clear", "clone", "", "getCacheFromLocal", "getUndoCount", "isUndoEnable", "", "onCreate", "onDestroy", "onDrawCache", "canvas", "Landroid/graphics/Canvas;", "isOverDraw", "onFinalGenerate", "onRestore", "isExit", "onSave", "peek", "pop", "saveCacheToLocal", "bitmap", "size", "isAlive", "undo", "plugin-photoedit-sdk_release"})
public final class e
  implements f<d>
{
  private final List<d> effects;
  public int fmI;
  public float fmJ;
  public Bitmap fmL;
  
  public e()
  {
    AppMethodBeat.i(163146);
    Object localObject1 = a.fVL;
    Object localObject2 = (Iterable)a.acV();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new d(((a.a)((Iterator)localObject2).next()).type));
    }
    this.effects = ((List)localObject1);
    AppMethodBeat.o(163146);
  }
  
  public final void Mj() {}
  
  public final void Ut() {}
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(163142);
    k.h(paramCanvas, "canvas");
    Bitmap localBitmap = this.fmL;
    if (localBitmap != null)
    {
      ((d)this.effects.get(this.fmI)).a(paramCanvas, localBitmap, this.fmJ);
      AppMethodBeat.o(163142);
      return;
    }
    AppMethodBeat.o(163142);
  }
  
  public final int aj(boolean paramBoolean)
  {
    return 0;
  }
  
  public final void cA(boolean paramBoolean)
  {
    this.fmI = 0;
    this.fmJ = 0.0F;
  }
  
  public final Object clone()
  {
    AppMethodBeat.i(163145);
    Object localObject = new Object();
    AppMethodBeat.o(163145);
    return localObject;
  }
  
  public final void e(Canvas paramCanvas)
  {
    AppMethodBeat.i(163143);
    k.h(paramCanvas, "canvas");
    Bitmap localBitmap = this.fmL;
    if (localBitmap != null)
    {
      ((d)this.effects.get(this.fmI)).a(paramCanvas, localBitmap, this.fmJ);
      AppMethodBeat.o(163143);
      return;
    }
    AppMethodBeat.o(163143);
  }
  
  public final void onCreate() {}
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.cache.e
 * JD-Core Version:    0.7.0.1
 */