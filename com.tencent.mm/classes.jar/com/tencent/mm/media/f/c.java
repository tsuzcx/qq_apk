package com.tencent.mm.media.f;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/media/globject/GLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.GLObjectFactory";
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, WeakReference<d>> grl;
  private static final HashMap<Integer, WeakReference<a>> grm;
  public static final c grn;
  
  static
  {
    AppMethodBeat.i(93698);
    grn = new c();
    TAG = "MicroMsg.GLObjectFactory";
    grl = new HashMap();
    grm = new HashMap();
    AppMethodBeat.o(93698);
  }
  
  public static final d a(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93694);
    d locald = new d(paramBoolean, paramLong);
    ((Map)grl).put(Integer.valueOf(locald.hashCode()), new WeakReference(locald));
    AppMethodBeat.o(93694);
    return locald;
  }
  
  public static a lC(long paramLong)
  {
    AppMethodBeat.i(93696);
    a locala = new a(paramLong);
    ((Map)grm).put(Integer.valueOf(locala.hashCode()), new WeakReference(locala));
    AppMethodBeat.o(93696);
    return locala;
  }
  
  public final void ajW()
  {
    Object localObject2;
    Integer localInteger;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93697);
        ad.i(TAG, "--------printAllocatedGLObjectInfo, current allocated tex size:" + grl.size() + ", frameBuffer size:" + grm.size() + " calledStack:" + b.getStack());
        ad.i(TAG, "--------------------------------------------");
        Iterator localIterator1 = ((Map)new HashMap((Map)grl)).entrySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator1.next();
        localInteger = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (d)((WeakReference)((Map.Entry)localObject2).getValue()).get();
        if (localObject2 == null) {
          break label281;
        }
        if (!((d)localObject2).grg)
        {
          ad.i(TAG, localInteger + " tex leak, texId:" + ((d)localObject2).gro + ", external:" + ((d)localObject2).ajZ() + ", allocatedTid:" + ((d)localObject2).tid);
          continue;
        }
        grl.remove(localInteger);
      }
      finally {}
      ad.i(TAG, localInteger + " tex released, texId:" + ((d)localObject2).gro + ", external:" + ((d)localObject2).ajZ() + ", allocatedTid:" + ((d)localObject2).tid);
      continue;
      label281:
      ad.i(TAG, localInteger + " tex recycled");
      grl.remove(localInteger);
    }
    Iterator localIterator2 = ((Map)new HashMap((Map)grm)).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Map.Entry)localIterator2.next();
      localInteger = (Integer)((Map.Entry)localObject2).getKey();
      localObject2 = (a)((WeakReference)((Map.Entry)localObject2).getValue()).get();
      if (localObject2 != null)
      {
        if (!((a)localObject2).grg)
        {
          ad.i(TAG, localInteger + " fbo leak, fbo:" + ((a)localObject2).grh + ", allocatedTid:" + ((a)localObject2).tid);
        }
        else
        {
          grm.remove(localInteger);
          ad.i(TAG, localInteger + " fbo released, fbo:" + ((a)localObject2).grh + ", allocatedTid:" + ((a)localObject2).tid);
        }
      }
      else
      {
        ad.i(TAG, localInteger + " fbo recycled");
        grm.remove(localInteger);
      }
    }
    ad.i(TAG, "--------finish printAllocatedGLObjectInfo--------");
    AppMethodBeat.o(93697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.media.f.c
 * JD-Core Version:    0.7.0.1
 */