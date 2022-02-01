package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.x.a;
import com.tencent.mm.x.a.a;
import com.tencent.mm.z.d;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/cache/FilterCache;", "Lcom/tencent/mm/cache/IBaseArtistCache;", "Lcom/tencent/mm/items/FilterItem;", "()V", "curColorWeight", "", "getCurColorWeight", "()F", "setCurColorWeight", "(F)V", "curSeletedTypeIndex", "", "getCurSeletedTypeIndex", "()I", "setCurSeletedTypeIndex", "(I)V", "effects", "", "getEffects", "()Ljava/util/List;", "preBitmap", "Landroid/graphics/Bitmap;", "getPreBitmap", "()Landroid/graphics/Bitmap;", "setPreBitmap", "(Landroid/graphics/Bitmap;)V", "add", "", "item", "clear", "clone", "", "getCacheFromLocal", "getUndoCount", "isUndoEnable", "", "onCreate", "onDestroy", "onDrawCache", "canvas", "Landroid/graphics/Canvas;", "isOverDraw", "onFinalGenerate", "onRestore", "isExit", "onSave", "peek", "pop", "saveCacheToLocal", "bitmap", "size", "isAlive", "undo", "plugin-photoedit-sdk_release"})
public final class e
  implements f<d>
{
  private final List<d> effects;
  public int fKo;
  public float fKp;
  public Bitmap fKq;
  
  public e()
  {
    AppMethodBeat.i(163146);
    Object localObject1 = a.gvJ;
    Object localObject2 = (Iterable)a.agV();
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new d(((a.a)((Iterator)localObject2).next()).type));
    }
    this.effects = ((List)localObject1);
    AppMethodBeat.o(163146);
  }
  
  public final void NO() {}
  
  public final void XP() {}
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(163142);
    p.h(paramCanvas, "canvas");
    Bitmap localBitmap = this.fKq;
    if (localBitmap != null)
    {
      ((d)this.effects.get(this.fKo)).a(paramCanvas, localBitmap, this.fKp);
      AppMethodBeat.o(163142);
      return;
    }
    AppMethodBeat.o(163142);
  }
  
  public final int aj(boolean paramBoolean)
  {
    return 0;
  }
  
  public final void cC(boolean paramBoolean)
  {
    this.fKo = 0;
    this.fKp = 0.0F;
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
    p.h(paramCanvas, "canvas");
    Bitmap localBitmap = this.fKq;
    if (localBitmap != null)
    {
      ((d)this.effects.get(this.fKo)).a(paramCanvas, localBitmap, this.fKp);
      AppMethodBeat.o(163143);
      return;
    }
    AppMethodBeat.o(163143);
  }
  
  public final void onCreate() {}
  
  public final void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cache.e
 * JD-Core Version:    0.7.0.1
 */