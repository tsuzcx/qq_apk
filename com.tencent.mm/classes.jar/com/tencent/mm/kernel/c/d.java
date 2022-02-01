package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d gEk;
  private ConcurrentHashMap<Class<? extends a>, c> gEi;
  private a gEj;
  
  static
  {
    AppMethodBeat.i(157489);
    gEk = new d();
    AppMethodBeat.o(157489);
  }
  
  public d()
  {
    AppMethodBeat.i(157484);
    this.gEi = new ConcurrentHashMap();
    this.gEj = null;
    AppMethodBeat.o(157484);
  }
  
  public void a(a parama)
  {
    this.gEj = parama;
  }
  
  public final void ac(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(157488);
    c localc = (c)this.gEi.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).aky();
    }
    if (this.gEj != null) {
      this.gEj.b(paramClass, localc);
    }
    AppMethodBeat.o(157488);
  }
  
  public final <T extends a> T al(Class<T> paramClass)
  {
    AppMethodBeat.i(157485);
    Object localObject = (c)this.gEi.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      ad.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localObject != null) {}
      for (localObject = ((c)localObject).akz();; localObject = null)
      {
        if (this.gEj != null) {
          this.gEj.a(paramClass, (a)localObject);
        }
        AppMethodBeat.o(157485);
        return localObject;
        ad.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
        if (i != 0) {
          ad.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
        }
      }
    }
  }
  
  public final <T extends a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(157486);
    c(paramClass, new e(paramN));
    AppMethodBeat.o(157486);
  }
  
  public final <T extends a, N extends T> void c(Class<T> paramClass, c<N> paramc)
  {
    AppMethodBeat.i(157487);
    this.gEi.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).akx();
    }
    if (this.gEj != null) {
      this.gEj.a(paramClass, paramc);
    }
    ad.i("MicroMsg.ServiceHub", "register service %s %s", new Object[] { paramClass, paramc });
    AppMethodBeat.o(157487);
  }
  
  public static abstract interface a
  {
    public abstract void a(Class<? extends a> paramClass, a parama);
    
    public abstract void a(Class<? extends a> paramClass, c paramc);
    
    public abstract void b(Class<? extends a> paramClass, c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.kernel.c.d
 * JD-Core Version:    0.7.0.1
 */