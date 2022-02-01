package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V>
  extends a<String, V, V, com.tencent.mm.memory.a.a.a>
{
  private static ConcurrentHashMap<Class<?>, a> heN;
  String heL;
  f<String, Object> heM;
  private f.b<String, com.tencent.mm.memory.a.a.a> heO;
  private f.c<String, com.tencent.mm.memory.a.a.a> heP;
  
  static
  {
    AppMethodBeat.i(156488);
    heN = new ConcurrentHashMap();
    a(Bitmap.class, new a() {});
    a(WeakReference.class, new a() {});
    AppMethodBeat.o(156488);
  }
  
  private b(int paramInt, f.b<String, V> paramb, com.tencent.mm.memory.a.a.a.a parama, Class<?> paramClass)
  {
    super(paramInt, paramb, parama);
    AppMethodBeat.i(156471);
    this.heL = "";
    this.heM = null;
    this.heO = new f.b() {};
    this.heP = new f.c() {};
    an(paramClass);
    AppMethodBeat.o(156471);
  }
  
  public b(int paramInt, f.b<String, V> paramb, Class<?> paramClass)
  {
    this(paramInt, paramb, com.tencent.mm.memory.a.a.a.a.awh(), paramClass);
    AppMethodBeat.i(156470);
    an(paramClass);
    AppMethodBeat.o(156470);
  }
  
  public b(int paramInt, Class<?> paramClass)
  {
    this(paramInt, null, paramClass);
    AppMethodBeat.i(156469);
    an(paramClass);
    AppMethodBeat.o(156469);
  }
  
  public static void a(Class<?> paramClass, a parama)
  {
    AppMethodBeat.i(156468);
    heN.put(paramClass, parama);
    AppMethodBeat.o(156468);
  }
  
  private void an(Class<?> paramClass)
  {
    AppMethodBeat.i(156472);
    this.heL = paramClass.getSimpleName();
    this.heM = com.tencent.mm.memory.a.a.b.d(this.hfn);
    AppMethodBeat.o(156472);
  }
  
  private int bM(V paramV)
  {
    AppMethodBeat.i(156474);
    if (paramV != null)
    {
      a locala = (a)heN.get(paramV.getClass());
      if (locala != null)
      {
        i = locala.bM(paramV);
        AppMethodBeat.o(156474);
        return i;
      }
    }
    int i = this.hfs.sizeOf("", paramV);
    AppMethodBeat.o(156474);
    return i;
  }
  
  private boolean bO(V paramV)
  {
    AppMethodBeat.i(156477);
    if (bM(paramV) * 2 >= com.tencent.mm.memory.a.a.b.e(this.hfn))
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
  
  public final V bN(V paramV)
  {
    return paramV;
  }
  
  public final V get(String paramString)
  {
    AppMethodBeat.i(156479);
    Object localObject = this.hfs.get(paramString);
    if ((localObject == null) && (this.heM != null)) {
      localObject = this.heM.get(paramString);
    }
    for (;;)
    {
      com.tencent.mm.memory.a.a.a locala = null;
      if (this.hft != null) {
        locala = (com.tencent.mm.memory.a.a.a)this.hft.w(this.heL, paramString);
      }
      if (com.tencent.mm.memory.a.a.a.a.hfg) {
        ac.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", new Object[] { paramString, localObject, locala, bs.eWi().toString() });
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
    if ((bO(paramV)) && (this.heM != null))
    {
      this.heM.put(paramString, paramV);
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
    if (this.heM != null) {
      this.heM.remove(paramString);
    }
    paramString = super.remove(paramString);
    AppMethodBeat.o(156478);
    return paramString;
  }
  
  public final Map<String, V> snapshot()
  {
    AppMethodBeat.i(156476);
    Map localMap = this.hfs.snapshot();
    AppMethodBeat.o(156476);
    return localMap;
  }
  
  public static abstract interface a<T>
  {
    public abstract int bM(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.b
 * JD-Core Version:    0.7.0.1
 */