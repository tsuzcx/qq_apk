package com.tencent.mm.memory.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.f.b;
import com.tencent.mm.a.f.c;
import com.tencent.mm.memory.a.a.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b<V>
  extends a<String, V, V, com.tencent.mm.memory.a.a.a>
{
  private static ConcurrentHashMap<Class<?>, a> feb;
  String fdZ;
  f<String, Object> fea;
  private f.b<String, com.tencent.mm.memory.a.a.a> fec;
  private f.c<String, com.tencent.mm.memory.a.a.a> fed;
  
  static
  {
    AppMethodBeat.i(115442);
    feb = new ConcurrentHashMap();
    a(Bitmap.class, new b.1());
    a(WeakReference.class, new b.2());
    AppMethodBeat.o(115442);
  }
  
  private b(int paramInt, f.b<String, V> paramb, com.tencent.mm.memory.a.a.a.a parama, Class<?> paramClass)
  {
    super(paramInt, paramb, parama);
    AppMethodBeat.i(115425);
    this.fdZ = "";
    this.fea = null;
    this.fec = new b.4(this);
    this.fed = new b.5(this);
    Q(paramClass);
    AppMethodBeat.o(115425);
  }
  
  public b(int paramInt, f.b<String, V> paramb, Class<?> paramClass)
  {
    this(paramInt, paramb, com.tencent.mm.memory.a.a.a.a.Yh(), paramClass);
    AppMethodBeat.i(115424);
    Q(paramClass);
    AppMethodBeat.o(115424);
  }
  
  public b(int paramInt, Class<?> paramClass)
  {
    this(paramInt, null, paramClass);
    AppMethodBeat.i(115423);
    Q(paramClass);
    AppMethodBeat.o(115423);
  }
  
  private void Q(Class<?> paramClass)
  {
    AppMethodBeat.i(115426);
    this.fdZ = paramClass.getSimpleName();
    this.fea = com.tencent.mm.memory.a.a.b.d(this.feC);
    AppMethodBeat.o(115426);
  }
  
  public static void a(Class<?> paramClass, a parama)
  {
    AppMethodBeat.i(115422);
    feb.put(paramClass, parama);
    AppMethodBeat.o(115422);
  }
  
  private int aJ(V paramV)
  {
    AppMethodBeat.i(115428);
    if (paramV != null)
    {
      a locala = (a)feb.get(paramV.getClass());
      if (locala != null)
      {
        i = locala.aJ(paramV);
        AppMethodBeat.o(115428);
        return i;
      }
    }
    int i = this.feH.sizeOf("", paramV);
    AppMethodBeat.o(115428);
    return i;
  }
  
  private boolean aL(V paramV)
  {
    AppMethodBeat.i(115431);
    if (aJ(paramV) * 2 >= com.tencent.mm.memory.a.a.b.e(this.feC))
    {
      AppMethodBeat.o(115431);
      return true;
    }
    AppMethodBeat.o(115431);
    return false;
  }
  
  public final d<String, com.tencent.mm.memory.a.a.a> a(com.tencent.mm.memory.a.a.a.a parama)
  {
    AppMethodBeat.i(115429);
    parama = com.tencent.mm.memory.a.a.b.c(parama);
    AppMethodBeat.o(115429);
    return parama;
  }
  
  public final V aK(V paramV)
  {
    return paramV;
  }
  
  public final V get(String paramString)
  {
    AppMethodBeat.i(115433);
    Object localObject = this.feH.get(paramString);
    if ((localObject == null) && (this.fea != null)) {
      localObject = this.fea.get(paramString);
    }
    for (;;)
    {
      com.tencent.mm.memory.a.a.a locala = null;
      if (this.feI != null) {
        locala = (com.tencent.mm.memory.a.a.a)this.feI.o(this.fdZ, paramString);
      }
      if (com.tencent.mm.memory.a.a.a.a.feu) {
        ab.v("MicroMsg.BitmapResource", "bitmap get key %s value %s bbvalue %s stack [%s]", new Object[] { paramString, localObject, locala, bo.dtY().toString() });
      }
      AppMethodBeat.o(115433);
      return localObject;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(115427);
    super.init();
    AppMethodBeat.o(115427);
  }
  
  public final V put(String paramString, V paramV)
  {
    AppMethodBeat.i(115434);
    if ((aL(paramV)) && (this.fea != null))
    {
      this.fea.put(paramString, paramV);
      AppMethodBeat.o(115434);
      return null;
    }
    paramString = super.put(paramString, paramV);
    AppMethodBeat.o(115434);
    return paramString;
  }
  
  public final V remove(String paramString)
  {
    AppMethodBeat.i(115432);
    if (this.fea != null) {
      this.fea.remove(paramString);
    }
    paramString = super.remove(paramString);
    AppMethodBeat.o(115432);
    return paramString;
  }
  
  public final Map<String, V> snapshot()
  {
    AppMethodBeat.i(115430);
    Map localMap = this.feH.snapshot();
    AppMethodBeat.o(115430);
    return localMap;
  }
  
  public static abstract interface a<T>
  {
    public abstract int aJ(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.memory.a.b
 * JD-Core Version:    0.7.0.1
 */