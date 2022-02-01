package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.d;
import com.tencent.mm.y.a;
import com.tencent.mm.y.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/cache/FilterCache;", "Lcom/tencent/mm/cache/IBaseArtistCache;", "Lcom/tencent/mm/items/FilterItem;", "()V", "curColorWeight", "", "getCurColorWeight", "()F", "setCurColorWeight", "(F)V", "curSeletedTypeIndex", "", "getCurSeletedTypeIndex", "()I", "setCurSeletedTypeIndex", "(I)V", "effects", "", "getEffects", "()Ljava/util/List;", "preBitmap", "Landroid/graphics/Bitmap;", "getPreBitmap", "()Landroid/graphics/Bitmap;", "setPreBitmap", "(Landroid/graphics/Bitmap;)V", "add", "", "item", "clear", "clone", "", "getCacheFromLocal", "getUndoCount", "isUndoEnable", "", "onCreate", "onDestroy", "onDrawCache", "canvas", "Landroid/graphics/Canvas;", "isOverDraw", "onFinalGenerate", "onRestore", "isExit", "onSave", "peek", "pop", "saveCacheToLocal", "bitmap", "size", "isAlive", "undo", "plugin-photoedit-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements f<d>
{
  private final List<d> effects;
  public int lvQ;
  public float lvR;
  public Bitmap lvS;
  
  public e()
  {
    AppMethodBeat.i(163146);
    Object localObject1 = a.muK;
    Object localObject2 = (Iterable)a.aXH();
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new d(((a.a)((Iterator)localObject2).next()).type));
    }
    this.effects = ((List)localObject1);
    AppMethodBeat.o(163146);
  }
  
  public final void aEG() {}
  
  public final void aLx() {}
  
  public final int aR(boolean paramBoolean)
  {
    return 0;
  }
  
  public final void b(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(163142);
    s.u(paramCanvas, "canvas");
    Bitmap localBitmap = this.lvS;
    if (localBitmap != null) {
      ((d)this.effects.get(this.lvQ)).a(paramCanvas, localBitmap, this.lvR);
    }
    AppMethodBeat.o(163142);
  }
  
  public final void clear() {}
  
  public final Object clone()
  {
    AppMethodBeat.i(163145);
    Object localObject = new Object();
    AppMethodBeat.o(163145);
    return localObject;
  }
  
  public final void ex(boolean paramBoolean)
  {
    this.lvQ = 0;
    this.lvR = 0.0F;
  }
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(163143);
    s.u(paramCanvas, "canvas");
    Bitmap localBitmap = this.lvS;
    if (localBitmap != null) {
      ((d)this.effects.get(this.lvQ)).a(paramCanvas, localBitmap, this.lvR);
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