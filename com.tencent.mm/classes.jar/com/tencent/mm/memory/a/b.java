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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V>
  extends a<String, V, V, com.tencent.mm.memory.a.a.a>
{
  private static ConcurrentHashMap<Class<?>, b.a> itQ;
  String itO;
  f<String, Object> itP;
  private f.b<String, com.tencent.mm.memory.a.a.a> itR;
  private f.c<String, com.tencent.mm.memory.a.a.a> itS;
  
  static
  {
    AppMethodBeat.i(156488);
    itQ = new ConcurrentHashMap();
    a(Bitmap.class, new b.1());
    a(WeakReference.class, new b.2());
    AppMethodBeat.o(156488);
  }
  
  private b(int paramInt, f.b<String, V> paramb, com.tencent.mm.memory.a.a.a.a parama, Class<?> paramClass)
  {
    super(paramInt, paramb, parama);
    AppMethodBeat.i(156471);
    this.itO = "";
    this.itP = null;
    this.itR = new f.b() {};
    this.itS = new f.c() {};
    ar(paramClass);
    AppMethodBeat.o(156471);
  }
  
  public b(int paramInt, f.b<String, V> paramb, Class<?> paramClass)
  {
    this(paramInt, paramb, com.tencent.mm.memory.a.a.a.a.aSp(), paramClass);
    AppMethodBeat.i(156470);
    ar(paramClass);
    AppMethodBeat.o(156470);
  }
  
  public b(int paramInt, Class<?> paramClass)
  {
    this(paramInt, null, paramClass);
    AppMethodBeat.i(156469);
    ar(paramClass);
    AppMethodBeat.o(156469);
  }
  
  public static void a(Class<?> paramClass, b.a parama)
  {
    AppMethodBeat.i(156468);
    itQ.put(paramClass, parama);
    AppMethodBeat.o(156468);
  }
  
  private void ar(Class<?> paramClass)
  {
    AppMethodBeat.i(156472);
    this.itO = paramClass.getSimpleName();
    this.itP = com.tencent.mm.memory.a.a.b.d(this.iuq);
    AppMethodBeat.o(156472);
  }
  
  private int bX(V paramV)
  {
    AppMethodBeat.i(156474);
    if (paramV != null)
    {
      b.a locala = (b.a)itQ.get(paramV.getClass());
      if (locala != null)
      {
        i = locala.bX(paramV);
        AppMethodBeat.o(156474);
        return i;
      }
    }
    int i = this.iuv.sizeOf("", paramV);
    AppMethodBeat.o(156474);
    return i;
  }
  
  private boolean bZ(V paramV)
  {
    AppMethodBeat.i(156477);
    if (bX(paramV) * 2 >= com.tencent.mm.memory.a.a.b.e(this.iuq))
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
  
  public final V bY(V paramV)
  {
    return paramV;
  }
  
  public final V get(String paramString)
  {
    AppMethodBeat.i(156479);
    Object localObject = this.iuv.get(paramString);
    if ((localObject == null) && (this.itP != null)) {
      localObject = this.itP.get(paramString);
    }
    for (;;)
    {
      com.tencent.mm.memory.a.a.a locala = null;
      if (this.iuw != null) {
        locala = (com.tencent.mm.memory.a.a.a)this.iuw.F(this.itO, paramString);
      }
      if (com.tencent.mm.memory.a.a.a.a.iuj) {
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
    if ((bZ(paramV)) && (this.itP != null))
    {
      this.itP.put(paramString, paramV);
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
    if (this.itP != null) {
      this.itP.remove(paramString);
    }
    paramString = super.remove(paramString);
    AppMethodBeat.o(156478);
    return paramString;
  }
  
  public final Map<String, V> snapshot()
  {
    AppMethodBeat.i(156476);
    Map localMap = this.iuv.snapshot();
    AppMethodBeat.o(156476);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.memory.a.b
 * JD-Core Version:    0.7.0.1
 */