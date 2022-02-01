package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Modifier;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final d mGa;
  private ConcurrentHashMap<Class<? extends a>, c> mFY;
  private a mFZ;
  
  static
  {
    AppMethodBeat.i(157489);
    mGa = new d();
    AppMethodBeat.o(157489);
  }
  
  public d()
  {
    AppMethodBeat.i(157484);
    this.mFY = new ConcurrentHashMap();
    this.mFZ = null;
    AppMethodBeat.o(157484);
  }
  
  public void a(a parama)
  {
    this.mFZ = parama;
  }
  
  public final <T extends a> T aH(Class<T> paramClass)
  {
    AppMethodBeat.i(157485);
    Object localObject = (c)this.mFY.get(paramClass);
    if ((!paramClass.isInterface()) && (Modifier.isAbstract(paramClass.getModifiers()))) {
      Log.w("MicroMsg.ServiceHub", "Did you call service by using the service implementation class ?? Use interface class instead!! Carl is warning u!");
    }
    for (int i = 1;; i = 0)
    {
      if (localObject != null) {}
      for (localObject = ((c)localObject).bbD();; localObject = null)
      {
        if (this.mFZ != null) {
          this.mFZ.a(paramClass, (a)localObject);
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
  
  public final void ay(Class<? extends a> paramClass)
  {
    AppMethodBeat.i(157488);
    c localc = (c)this.mFY.remove(paramClass);
    if ((localc instanceof b)) {
      ((b)localc).bbC();
    }
    if (this.mFZ != null) {
      this.mFZ.b(paramClass, localc);
    }
    AppMethodBeat.o(157488);
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
    this.mFY.put(paramClass, paramc);
    if ((paramc instanceof b)) {
      ((b)paramc).bbB();
    }
    if (this.mFZ != null) {
      this.mFZ.a(paramClass, paramc);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.kernel.c.d
 * JD-Core Version:    0.7.0.1
 */