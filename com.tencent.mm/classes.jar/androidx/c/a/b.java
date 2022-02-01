package androidx.c.a;

import com.google.b.b.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class b
{
  public static <T> f<T> a(c<T> paramc)
  {
    AppMethodBeat.i(195275);
    a locala = new a();
    locald = new d(locala);
    locala.bfV = locald;
    locala.tag = paramc.getClass();
    try
    {
      paramc = paramc.attachCompleter(locala);
      if (paramc != null) {
        locala.tag = paramc;
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        locald.h(paramc);
      }
    }
    AppMethodBeat.o(195275);
    return locald;
  }
  
  public static final class a<T>
  {
    public b.d<T> bfV;
    e<Void> bfW;
    public boolean bfX;
    Object tag;
    
    a()
    {
      AppMethodBeat.i(195317);
      this.bfW = e.Cq();
      AppMethodBeat.o(195317);
    }
    
    public final void Cp()
    {
      this.tag = null;
      this.bfV = null;
      this.bfW = null;
    }
    
    public final boolean ap(T paramT)
    {
      boolean bool = true;
      AppMethodBeat.i(195324);
      this.bfX = true;
      b.d locald = this.bfV;
      if ((locald != null) && (locald.ap(paramT))) {}
      for (;;)
      {
        if (bool) {
          Cp();
        }
        AppMethodBeat.o(195324);
        return bool;
        bool = false;
      }
    }
    
    public final void c(Runnable paramRunnable, Executor paramExecutor)
    {
      AppMethodBeat.i(195337);
      e locale = this.bfW;
      if (locale != null) {
        locale.a(paramRunnable, paramExecutor);
      }
      AppMethodBeat.o(195337);
    }
    
    protected final void finalize()
    {
      AppMethodBeat.i(195349);
      Object localObject = this.bfV;
      if ((localObject != null) && (!((b.d)localObject).isDone())) {
        ((b.d)localObject).h(new b.b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.tag));
      }
      if (!this.bfX)
      {
        localObject = this.bfW;
        if (localObject != null) {
          ((e)localObject).ap(null);
        }
      }
      AppMethodBeat.o(195349);
    }
    
    public final boolean h(Throwable paramThrowable)
    {
      boolean bool = true;
      AppMethodBeat.i(195330);
      this.bfX = true;
      b.d locald = this.bfV;
      if ((locald != null) && (locald.h(paramThrowable))) {}
      for (;;)
      {
        if (bool) {
          Cp();
        }
        AppMethodBeat.o(195330);
        return bool;
        bool = false;
      }
    }
  }
  
  static final class b
    extends Throwable
  {
    b(String paramString)
    {
      super();
    }
    
    public final Throwable fillInStackTrace()
    {
      return this;
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract Object attachCompleter(b.a<T> parama);
  }
  
  public static final class d<T>
    implements f<T>
  {
    final WeakReference<b.a<T>> bfY;
    public final a<T> bfZ;
    
    d(b.a<T> parama)
    {
      AppMethodBeat.i(195318);
      this.bfZ = new a()
      {
        protected final String Cn()
        {
          AppMethodBeat.i(195278);
          Object localObject = (b.a)b.d.this.bfY.get();
          if (localObject == null)
          {
            AppMethodBeat.o(195278);
            return "Completer object has been garbage collected, future will fail soon";
          }
          localObject = "tag=[" + ((b.a)localObject).tag + "]";
          AppMethodBeat.o(195278);
          return localObject;
        }
      };
      this.bfY = new WeakReference(parama);
      AppMethodBeat.o(195318);
    }
    
    public final void a(Runnable paramRunnable, Executor paramExecutor)
    {
      AppMethodBeat.i(195360);
      this.bfZ.a(paramRunnable, paramExecutor);
      AppMethodBeat.o(195360);
    }
    
    final boolean ap(T paramT)
    {
      AppMethodBeat.i(195328);
      boolean bool = this.bfZ.ap(paramT);
      AppMethodBeat.o(195328);
      return bool;
    }
    
    public final boolean cancel(boolean paramBoolean)
    {
      AppMethodBeat.i(195321);
      b.a locala = (b.a)this.bfY.get();
      paramBoolean = this.bfZ.cancel(paramBoolean);
      if ((paramBoolean) && (locala != null))
      {
        locala.tag = null;
        locala.bfV = null;
        locala.bfW.ap(null);
      }
      AppMethodBeat.o(195321);
      return paramBoolean;
    }
    
    public final T get()
    {
      AppMethodBeat.i(195351);
      Object localObject = this.bfZ.get();
      AppMethodBeat.o(195351);
      return localObject;
    }
    
    public final T get(long paramLong, TimeUnit paramTimeUnit)
    {
      AppMethodBeat.i(195356);
      paramTimeUnit = this.bfZ.get(paramLong, paramTimeUnit);
      AppMethodBeat.o(195356);
      return paramTimeUnit;
    }
    
    final boolean h(Throwable paramThrowable)
    {
      AppMethodBeat.i(195334);
      boolean bool = this.bfZ.h(paramThrowable);
      AppMethodBeat.o(195334);
      return bool;
    }
    
    public final boolean isCancelled()
    {
      AppMethodBeat.i(195338);
      boolean bool = this.bfZ.isCancelled();
      AppMethodBeat.o(195338);
      return bool;
    }
    
    public final boolean isDone()
    {
      AppMethodBeat.i(195343);
      boolean bool = this.bfZ.isDone();
      AppMethodBeat.o(195343);
      return bool;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(195365);
      String str = this.bfZ.toString();
      AppMethodBeat.o(195365);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.c.a.b
 * JD-Core Version:    0.7.0.1
 */