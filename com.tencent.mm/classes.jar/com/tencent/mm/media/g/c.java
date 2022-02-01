package com.tencent.mm.media.g;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/media/globject/GLObjectFactory;", "", "()V", "TAG", "", "allocatedFramebuffer", "Ljava/util/HashMap;", "", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/media/globject/GLFrameBufferObject;", "Lkotlin/collections/HashMap;", "allocatedTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "newFrameBuffer", "scene", "", "newTexture", "sampler2D", "", "printAllocatedGLObjectInfo", "", "plugin-mediaeditor_release"})
public final class c
{
  private static final String TAG = "MicroMsg.GLObjectFactory";
  @SuppressLint({"UseSparseArrays"})
  private static final HashMap<Integer, WeakReference<d>> hmZ;
  private static final HashMap<Integer, WeakReference<a>> hna;
  public static final c hnb;
  
  static
  {
    AppMethodBeat.i(93698);
    hnb = new c();
    TAG = "MicroMsg.GLObjectFactory";
    hmZ = new HashMap();
    hna = new HashMap();
    AppMethodBeat.o(93698);
  }
  
  public static final d a(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(93694);
    d locald = new d(paramBoolean, paramLong);
    ((Map)hmZ).put(Integer.valueOf(locald.hashCode()), new WeakReference(locald));
    AppMethodBeat.o(93694);
    return locald;
  }
  
  public static a rD(long paramLong)
  {
    AppMethodBeat.i(93696);
    a locala = new a(paramLong);
    ((Map)hna).put(Integer.valueOf(locala.hashCode()), new WeakReference(locala));
    AppMethodBeat.o(93696);
    return locala;
  }
  
  public final void atY()
  {
    Object localObject2;
    Integer localInteger;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(93697);
        ae.i(TAG, "--------printAllocatedGLObjectInfo, current allocated tex size:" + hmZ.size() + ", frameBuffer size:" + hna.size() + " calledStack:" + b.getStack());
        ae.i(TAG, "--------------------------------------------");
        Iterator localIterator1 = ((Map)new HashMap((Map)hmZ)).entrySet().iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)localIterator1.next();
        localInteger = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (d)((WeakReference)((Map.Entry)localObject2).getValue()).get();
        if (localObject2 == null) {
          break label281;
        }
        if (!((d)localObject2).hmU)
        {
          ae.i(TAG, localInteger + " tex leak, texId:" + ((d)localObject2).hnc + ", external:" + ((d)localObject2).aub() + ", allocatedTid:" + ((d)localObject2).tid);
          continue;
        }
        hmZ.remove(localInteger);
      }
      finally {}
      ae.i(TAG, localInteger + " tex released, texId:" + ((d)localObject2).hnc + ", external:" + ((d)localObject2).aub() + ", allocatedTid:" + ((d)localObject2).tid);
      continue;
      label281:
      ae.i(TAG, localInteger + " tex recycled");
      hmZ.remove(localInteger);
    }
    Iterator localIterator2 = ((Map)new HashMap((Map)hna)).entrySet().iterator();
    while (localIterator2.hasNext())
    {
      localObject2 = (Map.Entry)localIterator2.next();
      localInteger = (Integer)((Map.Entry)localObject2).getKey();
      localObject2 = (a)((WeakReference)((Map.Entry)localObject2).getValue()).get();
      if (localObject2 != null)
      {
        if (!((a)localObject2).hmU)
        {
          ae.i(TAG, localInteger + " fbo leak, fbo:" + ((a)localObject2).hmV + ", allocatedTid:" + ((a)localObject2).tid);
        }
        else
        {
          hna.remove(localInteger);
          ae.i(TAG, localInteger + " fbo released, fbo:" + ((a)localObject2).hmV + ", allocatedTid:" + ((a)localObject2).tid);
        }
      }
      else
      {
        ae.i(TAG, localInteger + " fbo recycled");
        hna.remove(localInteger);
      }
    }
    ae.i(TAG, "--------finish printAllocatedGLObjectInfo--------");
    AppMethodBeat.o(93697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.g.c
 * JD-Core Version:    0.7.0.1
 */