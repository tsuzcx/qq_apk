package com.tencent.mm.media.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/globject/GLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final String TAG;
  public static final c nAB;
  private static final HashMap<Integer, WeakReference<d>> nAC;
  private static final HashMap<Integer, WeakReference<a>> nAD;
  
  static
  {
    AppMethodBeat.i(93698);
    nAB = new c();
    TAG = "MicroMsg.GLObjectFactory";
    nAC = new HashMap();
    nAD = new HashMap();
    AppMethodBeat.o(93698);
  }
  
  public static final d d(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93694);
    d locald = new d(paramBoolean, paramLong);
    ((Map)nAC).put(Integer.valueOf(locald.hashCode()), new WeakReference(locald));
    AppMethodBeat.o(93694);
    return locald;
  }
  
  public static a hX(long paramLong)
  {
    AppMethodBeat.i(93696);
    a locala = new a(paramLong);
    ((Map)nAD).put(Integer.valueOf(locala.hashCode()), new WeakReference(locala));
    AppMethodBeat.o(93696);
    return locala;
  }
  
  public final void bpx()
  {
    Object localObject2;
    Integer localInteger;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93697);
        Log.i(TAG, "--------printAllocatedGLObjectInfo, current allocated tex size:" + nAC.size() + ", frameBuffer size:" + nAD.size() + " calledStack:" + com.tencent.matrix.trace.f.c.getStack());
        Log.i(TAG, "--------------------------------------------");
        Iterator localIterator1 = ((Map)new HashMap((Map)nAC)).entrySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator1.next();
        localInteger = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (d)((WeakReference)((Map.Entry)localObject2).getValue()).get();
        if (localObject2 == null) {
          break label281;
        }
        if (!((d)localObject2).nAx)
        {
          Log.i(TAG, localInteger + " tex leak, texId:" + ((d)localObject2).nAF + ", external:" + ((d)localObject2).bpA() + ", allocatedTid:" + ((d)localObject2).tid);
          continue;
        }
        nAC.remove(localInteger);
      }
      finally {}
      Log.i(TAG, localInteger + " tex released, texId:" + ((d)localObject2).nAF + ", external:" + ((d)localObject2).bpA() + ", allocatedTid:" + ((d)localObject2).tid);
      continue;
      label281:
      Log.i(TAG, localInteger + " tex recycled");
      nAC.remove(localInteger);
    }
    Iterator localIterator2 = ((Map)new HashMap((Map)nAD)).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Map.Entry)localIterator2.next();
      localInteger = (Integer)((Map.Entry)localObject2).getKey();
      localObject2 = (a)((WeakReference)((Map.Entry)localObject2).getValue()).get();
      if (localObject2 != null)
      {
        if (!((a)localObject2).nAx)
        {
          Log.i(TAG, localInteger + " fbo leak, fbo:" + ((a)localObject2).nAy + ", allocatedTid:" + ((a)localObject2).tid);
        }
        else
        {
          nAD.remove(localInteger);
          Log.i(TAG, localInteger + " fbo released, fbo:" + ((a)localObject2).nAy + ", allocatedTid:" + ((a)localObject2).tid);
        }
      }
      else
      {
        Log.i(TAG, localInteger + " fbo recycled");
        nAD.remove(localInteger);
      }
    }
    Log.i(TAG, "--------finish printAllocatedGLObjectInfo--------");
    AppMethodBeat.o(93697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.g.c
 * JD-Core Version:    0.7.0.1
 */