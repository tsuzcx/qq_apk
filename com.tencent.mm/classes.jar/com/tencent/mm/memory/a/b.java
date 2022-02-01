package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.b.f.b;
import com.tencent.mm.b.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V>
  extends a<String, V, V, com.tencent.mm.memory.a.a.a>
{
  private static ConcurrentHashMap<Class<?>, b.a> hzJ;
  String hzH;
  f<String, Object> hzI;
  private f.b<String, com.tencent.mm.memory.a.a.a> hzK;
  private f.c<String, com.tencent.mm.memory.a.a.a> hzL;
  
  static
  {
    AppMethodBeat.i(156488);
    hzJ = new ConcurrentHashMap();
    a(Bitmap.class, new b.1());
    a(WeakReference.class, new b.2());
    AppMethodBeat.o(156488);
  }
  
  private b(int paramInt, f.b<String, V> paramb, com.tencent.mm.memory.a.a.a.a parama, Class<?> paramClass)
  {
    super(paramInt, paramb, parama);
    AppMethodBeat.i(156471);
    this.hzH = "";
    this.hzI = null;
    this.hzK = new f.b() {};
    this.hzL = new f.c() {};
    an(paramClass);
    AppMethodBeat.o(156471);
  }
  
  public b(int paramInt, f.b<String, V> paramb, Class<?> paramClass)
  {
    this(paramInt, paramb, com.tencent.mm.memory.a.a.a.a.azj(), paramClass);
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
  
  public static void a(Class<?> paramClass, b.a parama)
  {
    AppMethodBeat.i(156468);
    hzJ.put(paramClass, parama);
    AppMethodBeat.o(156468);
  }
  
  private void an(Class<?> paramClass)
  {
    AppMethodBeat.i(156472);
    this.hzH = paramClass.getSimpleName();
    this.hzI = com.tencent.mm.memory.a.a.b.d(this.hAj);
    AppMethodBeat.o(156472);
  }
  
  private int bO(V paramV)
  {
    AppMethodBeat.i(156474);
    if (paramV != null)
    {
      b.a locala = (b.a)hzJ.get(paramV.getClass());
      if (locala != null)
      {
        i = locala.bO(paramV);
        AppMethodBeat.o(156474);
        return i;
      }
    }
    int i = this.hAo.sizeOf("", paramV);
    AppMethodBeat.o(156474);
    return i;
  }
  
  private boolean bQ(V paramV)
  {
    AppMethodBeat.i(156477);
    if (bO(paramV) * 2 >= com.tencent.mm.memory.a.a.b.e(this.hAj))
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
  
  public final V bP(V paramV)
  {
    return paramV;
  }
  
  public final V get(String paramString)
  {
    AppMethodBeat.i(156479);
    Object localObject = this.hAo.get(paramString);
    if ((localObject == null) && (this.hzI != null)) {
      localObject = this.hzI.get(paramString);
    }
    for (;;)
    {
      com.tencent.mm.memory.a.a.a locala = null;
      if (this.hAp != null) {
        locala = (com.tencent.mm.memory.a.a.a)this.hAp.y(this.hzH, paramString);
      }
      if (com.tencent.mm.memory.a.a.a.a.hAc) {
        ae.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", new Object[] { paramString, localObject, locala, bu.fpN().toString() });
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
    if ((bQ(paramV)) && (this.hzI != null))
    {
      this.hzI.put(paramString, paramV);
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
    if (this.hzI != null) {
      this.hzI.remove(paramString);
    }
    paramString = super.remove(paramString);
    AppMethodBeat.o(156478);
    return paramString;
  }
  
  public final Map<String, V> snapshot()
  {
    AppMethodBeat.i(156476);
    Map localMap = this.hAo.snapshot();
    AppMethodBeat.o(156476);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.memory.a.b
 * JD-Core Version:    0.7.0.1
 */