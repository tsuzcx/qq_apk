package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d gkA;
  private ConcurrentHashMap<Class<? extends a>, c> gky;
  private a gkz;
  
  static
  {
    AppMethodBeat.i(157489);
    gkA = new d();
    AppMethodBeat.o(157489);
  }
  
  public d()
  {
    AppMethodBeat.i(157484);
    this.gky = new ConcurrentHashMap();
    this.gkz = null;
    AppMethodBeat.o(157484);
  }
  
  public void a(a parama)
  {
    this.gkz = parama;
  }
  
  public final void ac(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(157488);
    c localc = (c)this.gky.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).ahN();
    }
    if (this.gkz != null) {
      this.gkz.b(paramClass, localc);
    }
    AppMethodBeat.o(157488);
  }
  
  public final <T extends a> T al(Class<T> paramClass)
  {
    AppMethodBeat.i(157485);
    Object localObject = (c)this.gky.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      ac.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localObject != null) {}
      for (localObject = ((c)localObject).ahO();; localObject = null)
      {
        if (this.gkz != null) {
          this.gkz.a(paramClass, (a)localObject);
        }
        AppMethodBeat.o(157485);
        return localObject;
        ac.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
        if (i != 0) {
          ac.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
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
    this.gky.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).ahM();
    }
    if (this.gkz != null) {
      this.gkz.a(paramClass, paramc);
    }
    ac.i("MicroMsg.ServiceHub", "register service %s %s", new Object[] { paramClass, paramc });
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