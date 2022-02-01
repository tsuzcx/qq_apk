package com.tencent.mm.media.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/globject/GLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.GLObjectFactory";
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, WeakReference<d>> kVg;
  private static final HashMap<Integer, WeakReference<a>> kVh;
  public static final c kVi;
  
  static
  {
    AppMethodBeat.i(93698);
    kVi = new c();
    TAG = "MicroMsg.GLObjectFactory";
    kVg = new HashMap();
    kVh = new HashMap();
    AppMethodBeat.o(93698);
  }
  
  public static a FP(long paramLong)
  {
    AppMethodBeat.i(93696);
    a locala = new a(paramLong);
    ((Map)kVh).put(Integer.valueOf(locala.hashCode()), new WeakReference(locala));
    AppMethodBeat.o(93696);
    return locala;
  }
  
  public static final d a(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93694);
    d locald = new d(paramBoolean, paramLong);
    ((Map)kVg).put(Integer.valueOf(locald.hashCode()), new WeakReference(locald));
    AppMethodBeat.o(93694);
    return locald;
  }
  
  public final void aUQ()
  {
    Object localObject2;
    Integer localInteger;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93697);
        Log.i(TAG, "--------printAllocatedGLObjectInfo, current allocated tex size:" + kVg.size() + ", frameBuffer size:" + kVh.size() + " calledStack:" + b.getStack());
        Log.i(TAG, "--------------------------------------------");
        Iterator localIterator1 = ((Map)new HashMap((Map)kVg)).entrySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator1.next();
        localInteger = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (d)((WeakReference)((Map.Entry)localObject2).getValue()).get();
        if (localObject2 == null) {
          break label281;
        }
        if (!((d)localObject2).kVb)
        {
          Log.i(TAG, localInteger + " tex leak, texId:" + ((d)localObject2).kVj + ", external:" + ((d)localObject2).aUT() + ", allocatedTid:" + ((d)localObject2).tid);
          continue;
        }
        kVg.remove(localInteger);
      }
      finally {}
      Log.i(TAG, localInteger + " tex released, texId:" + ((d)localObject2).kVj + ", external:" + ((d)localObject2).aUT() + ", allocatedTid:" + ((d)localObject2).tid);
      continue;
      label281:
      Log.i(TAG, localInteger + " tex recycled");
      kVg.remove(localInteger);
    }
    Iterator localIterator2 = ((Map)new HashMap((Map)kVh)).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Map.Entry)localIterator2.next();
      localInteger = (Integer)((Map.Entry)localObject2).getKey();
      localObject2 = (a)((WeakReference)((Map.Entry)localObject2).getValue()).get();
      if (localObject2 != null)
      {
        if (!((a)localObject2).kVb)
        {
          Log.i(TAG, localInteger + " fbo leak, fbo:" + ((a)localObject2).kVc + ", allocatedTid:" + ((a)localObject2).tid);
        }
        else
        {
          kVh.remove(localInteger);
          Log.i(TAG, localInteger + " fbo released, fbo:" + ((a)localObject2).kVc + ", allocatedTid:" + ((a)localObject2).tid);
        }
      }
      else
      {
        Log.i(TAG, localInteger + " fbo recycled");
        kVh.remove(localInteger);
      }
    }
    Log.i(TAG, "--------finish printAllocatedGLObjectInfo--------");
    AppMethodBeat.o(93697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.g.c
 * JD-Core Version:    0.7.0.1
 */