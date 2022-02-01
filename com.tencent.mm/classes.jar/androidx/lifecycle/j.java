package androidx.lifecycle;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReference;

public abstract class j
{
  AtomicReference<Object> mInternalScopeRef = new AtomicReference();
  
  public abstract void addObserver(p paramp);
  
  public abstract b getCurrentState();
  
  public abstract void removeObserver(p paramp);
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(194482);
      ON_CREATE = new a("ON_CREATE", 0);
      ON_START = new a("ON_START", 1);
      ON_RESUME = new a("ON_RESUME", 2);
      ON_PAUSE = new a("ON_PAUSE", 3);
      ON_STOP = new a("ON_STOP", 4);
      ON_DESTROY = new a("ON_DESTROY", 5);
      ON_ANY = new a("ON_ANY", 6);
      $VALUES = new a[] { ON_CREATE, ON_START, ON_RESUME, ON_PAUSE, ON_STOP, ON_DESTROY, ON_ANY };
      AppMethodBeat.o(194482);
    }
    
    private a() {}
    
    public static a a(j.b paramb)
    {
      AppMethodBeat.i(194446);
      switch (j.1.bDA[paramb.ordinal()])
      {
      default: 
        AppMethodBeat.o(194446);
        return null;
      case 1: 
        paramb = ON_DESTROY;
        AppMethodBeat.o(194446);
        return paramb;
      case 2: 
        paramb = ON_STOP;
        AppMethodBeat.o(194446);
        return paramb;
      }
      paramb = ON_PAUSE;
      AppMethodBeat.o(194446);
      return paramb;
    }
    
    public static a b(j.b paramb)
    {
      AppMethodBeat.i(194458);
      switch (j.1.bDA[paramb.ordinal()])
      {
      case 3: 
      case 4: 
      default: 
        AppMethodBeat.o(194458);
        return null;
      case 5: 
        paramb = ON_CREATE;
        AppMethodBeat.o(194458);
        return paramb;
      case 1: 
        paramb = ON_START;
        AppMethodBeat.o(194458);
        return paramb;
      }
      paramb = ON_RESUME;
      AppMethodBeat.o(194458);
      return paramb;
    }
    
    public static a c(j.b paramb)
    {
      AppMethodBeat.i(194468);
      switch (j.1.bDA[paramb.ordinal()])
      {
      default: 
        AppMethodBeat.o(194468);
        return null;
      case 1: 
        paramb = ON_CREATE;
        AppMethodBeat.o(194468);
        return paramb;
      case 2: 
        paramb = ON_START;
        AppMethodBeat.o(194468);
        return paramb;
      }
      paramb = ON_RESUME;
      AppMethodBeat.o(194468);
      return paramb;
    }
    
    public final j.b Hg()
    {
      AppMethodBeat.i(194495);
      switch (j.1.bHf[ordinal()])
      {
      default: 
        localObject = new IllegalArgumentException(this + " has no target state");
        AppMethodBeat.o(194495);
        throw ((Throwable)localObject);
      case 1: 
      case 2: 
        localObject = j.b.bHi;
        AppMethodBeat.o(194495);
        return localObject;
      case 3: 
      case 4: 
        localObject = j.b.bHj;
        AppMethodBeat.o(194495);
        return localObject;
      case 5: 
        localObject = j.b.bHk;
        AppMethodBeat.o(194495);
        return localObject;
      }
      Object localObject = j.b.bHg;
      AppMethodBeat.o(194495);
      return localObject;
    }
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(194437);
      bHg = new b("DESTROYED", 0);
      bHh = new b("INITIALIZED", 1);
      bHi = new b("CREATED", 2);
      bHj = new b("STARTED", 3);
      bHk = new b("RESUMED", 4);
      bHl = new b[] { bHg, bHh, bHi, bHj, bHk };
      AppMethodBeat.o(194437);
    }
    
    private b() {}
    
    public final boolean d(b paramb)
    {
      AppMethodBeat.i(194451);
      if (compareTo(paramb) >= 0)
      {
        AppMethodBeat.o(194451);
        return true;
      }
      AppMethodBeat.o(194451);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.j
 * JD-Core Version:    0.7.0.1
 */