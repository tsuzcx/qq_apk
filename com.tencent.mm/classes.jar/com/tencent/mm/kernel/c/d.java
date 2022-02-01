package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d kfC;
  private ConcurrentHashMap<Class<? extends a>, c> kfA;
  private a kfB;
  
  static
  {
    AppMethodBeat.i(157489);
    kfC = new d();
    AppMethodBeat.o(157489);
  }
  
  public d()
  {
    AppMethodBeat.i(157484);
    this.kfA = new ConcurrentHashMap();
    this.kfB = null;
    AppMethodBeat.o(157484);
  }
  
  public void a(a parama)
  {
    this.kfB = parama;
  }
  
  public final void af(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(157488);
    c localc = (c)this.kfA.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).aIG();
    }
    if (this.kfB != null) {
      this.kfB.b(paramClass, localc);
    }
    AppMethodBeat.o(157488);
  }
  
  public final <T extends a> T ao(Class<T> paramClass)
  {
    AppMethodBeat.i(157485);
    Object localObject = (c)this.kfA.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      Log.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localObject != null) {}
      for (localObject = ((c)localObject).aIH();; localObject = null)
      {
        if (this.kfB != null) {
          this.kfB.a(paramClass, (a)localObject);
        }
        AppMethodBeat.o(157485);
        return localObject;
        Log.e("MicroMsg.ServiceHub", "Service(%s) not found!!! ", new Object[] { paramClass });
        if (i != 0) {
          Log.e("MicroMsg.ServiceHub", "This error must cause by using implementation class to call service! Use interface instead! Understand?");
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
    this.kfA.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).aIF();
    }
    if (this.kfB != null) {
      this.kfB.a(paramClass, paramc);
    }
    Log.i("MicroMsg.ServiceHub", "register service %s %s", new Object[] { paramClass, paramc });
    AppMethodBeat.o(157487);
  }
  
  public static abstract interface a
  {
    public abstract void a(Class<? extends a> paramClass, a parama);
    
    public abstract void a(Class<? extends a> paramClass, c paramc);
    
    public abstract void b(Class<? extends a> paramClass, c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.kernel.c.d
 * JD-Core Version:    0.7.0.1
 */