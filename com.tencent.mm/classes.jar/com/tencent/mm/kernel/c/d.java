package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d eKM;
  private ConcurrentHashMap<Class<? extends a>, c> eKK;
  private a eKL;
  
  static
  {
    AppMethodBeat.i(51936);
    eKM = new d();
    AppMethodBeat.o(51936);
  }
  
  public d()
  {
    AppMethodBeat.i(51931);
    this.eKK = new ConcurrentHashMap();
    this.eKL = null;
    AppMethodBeat.o(51931);
  }
  
  public final void F(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(51935);
    c localc = (c)this.eKK.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).xN();
    }
    if (this.eKL != null) {
      this.eKL.b(paramClass, localc);
    }
    AppMethodBeat.o(51935);
  }
  
  public final <T extends a> T O(Class<T> paramClass)
  {
    AppMethodBeat.i(51932);
    Object localObject = (c)this.eKK.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      ab.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localObject != null) {}
      for (localObject = ((c)localObject).SE();; localObject = null)
      {
        if (this.eKL != null) {
          this.eKL.a(paramClass, (a)localObject);
        }
        AppMethodBeat.o(51932);
        return localObject;
        ab.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
        if (i != 0) {
          ab.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
        }
      }
    }
  }
  
  public void a(a parama)
  {
    this.eKL = parama;
  }
  
  public final <T extends a, N extends T> void b(Class<T> paramClass, N paramN)
  {
    AppMethodBeat.i(51933);
    c(paramClass, new e(paramN));
    AppMethodBeat.o(51933);
  }
  
  public final <T extends a, N extends T> void c(Class<T> paramClass, c<N> paramc)
  {
    AppMethodBeat.i(51934);
    this.eKK.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).xM();
    }
    if (this.eKL != null) {
      this.eKL.a(paramClass, paramc);
    }
    ab.i("MicroMsg.ServiceHub", "register service %s %s", new Object[] { paramClass, paramc });
    AppMethodBeat.o(51934);
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