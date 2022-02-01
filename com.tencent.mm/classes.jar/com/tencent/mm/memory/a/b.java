package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V>
  extends a<String, V, V, com.tencent.mm.memory.a.a.a>
{
  private static ConcurrentHashMap<Class<?>, a> nNK;
  String nNI;
  f<String, Object> nNJ;
  private f.b<String, com.tencent.mm.memory.a.a.a> nNL;
  private f.c<String, com.tencent.mm.memory.a.a.a> nNM;
  
  static
  {
    AppMethodBeat.i(156488);
    nNK = new ConcurrentHashMap();
    a(Bitmap.class, new a() {});
    a(WeakReference.class, new a() {});
    AppMethodBeat.o(156488);
  }
  
  private b(int paramInt, f.b<String, V> paramb, com.tencent.mm.memory.a.a.a.a parama, Class<?> paramClass)
  {
    super(paramInt, paramb, parama);
    AppMethodBeat.i(156471);
    this.nNI = "";
    this.nNJ = null;
    this.nNL = new f.b() {};
    this.nNM = new f.c() {};
    aJ(paramClass);
    AppMethodBeat.o(156471);
  }
  
  public b(int paramInt, f.b<String, V> paramb, Class<?> paramClass)
  {
    this(paramInt, paramb, com.tencent.mm.memory.a.a.a.a.bwh(), paramClass);
    AppMethodBeat.i(156470);
    aJ(paramClass);
    AppMethodBeat.o(156470);
  }
  
  public b(int paramInt, Class<?> paramClass)
  {
    this(paramInt, null, paramClass);
    AppMethodBeat.i(156469);
    aJ(paramClass);
    AppMethodBeat.o(156469);
  }
  
  public static void a(Class<?> paramClass, a parama)
  {
    AppMethodBeat.i(156468);
    nNK.put(paramClass, parama);
    AppMethodBeat.o(156468);
  }
  
  private void aJ(Class<?> paramClass)
  {
    AppMethodBeat.i(156472);
    this.nNI = paramClass.getSimpleName();
    this.nNJ = com.tencent.mm.memory.a.a.b.d(this.nOk);
    AppMethodBeat.o(156472);
  }
  
  private int dq(V paramV)
  {
    AppMethodBeat.i(156474);
    if (paramV != null)
    {
      a locala = (a)nNK.get(paramV.getClass());
      if (locala != null)
      {
        i = locala.dq(paramV);
        AppMethodBeat.o(156474);
        return i;
      }
    }
    int i = this.nOp.sizeOf("", paramV);
    AppMethodBeat.o(156474);
    return i;
  }
  
  private boolean ds(V paramV)
  {
    AppMethodBeat.i(156477);
    if (dq(paramV) * 2 >= com.tencent.mm.memory.a.a.b.e(this.nOk))
    {
      AppMethodBeat.o(156477);
      return true;
    }
    AppMethodBeat.o(156477);
    return false;
  }
  
  public final d<String, com.tencent.mm.memory.a.a.a> a(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(156475);
    parama = com.tencent.mm.memory.a.a.b.c(parama);
    AppMethodBeat.o(156475);
    return parama;
  }
  
  public final V dr(V paramV)
  {
    return paramV;
  }
  
  public final V get(String paramString)
  {
    AppMethodBeat.i(156479);
    Object localObject = this.nOp.get(paramString);
    if ((localObject == null) && (this.nNJ != null)) {
      localObject = this.nNJ.get(paramString);
    }
    for (;;)
    {
      com.tencent.mm.memory.a.a.a locala = null;
      if (this.nOq != null) {
        locala = (com.tencent.mm.memory.a.a.a)this.nOq.J(this.nNI, paramString);
      }
      if (com.tencent.mm.memory.a.a.a.a.nOd) {
        Log.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", new Object[] { paramString, localObject, locala, Util.getStack().toString() });
      }
      AppMethodBeat.o(156479);
      return localObject;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(156473);
    super.init();
    AppMethodBeat.o(156473);
  }
  
  public final V put(String paramString, V paramV)
  {
    AppMethodBeat.i(156480);
    if ((ds(paramV)) && (this.nNJ != null))
    {
      this.nNJ.put(paramString, paramV);
      AppMethodBeat.o(156480);
      return null;
    }
    paramString = super.put(paramString, paramV);
    AppMethodBeat.o(156480);
    return paramString;
  }
  
  public final V remove(String paramString)
  {
    AppMethodBeat.i(156478);
    if (this.nNJ != null) {
      this.nNJ.remove(paramString);
    }
    paramString = super.remove(paramString);
    AppMethodBeat.o(156478);
    return paramString;
  }
  
  public final Map<String, V> snapshot()
  {
    AppMethodBeat.i(156476);
    Map localMap = this.nOp.snapshot();
    AppMethodBeat.o(156476);
    return localMap;
  }
  
  public final Collection<V> values()
  {
    AppMethodBeat.i(238983);
    Collection localCollection = this.nOp.values();
    AppMethodBeat.o(238983);
    return localCollection;
  }
  
  public static abstract interface a<T>
  {
    public abstract int dq(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.b
 * JD-Core Version:    0.7.0.1
 */