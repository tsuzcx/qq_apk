package androidx.core.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class e
{
  public static final d Mk;
  public static final d Ml;
  public static final d Mm;
  public static final d Mn;
  public static final d Mo;
  public static final d Mp;
  
  static
  {
    AppMethodBeat.i(251302);
    Mk = new e(null, false);
    Ml = new e(null, true);
    Mm = new e(b.Ms, false);
    Mn = new e(b.Ms, true);
    Mo = new e(a.Mr, false);
    Mp = f.Mv;
    AppMethodBeat.o(251302);
  }
  
  static int bt(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
      return 1;
    }
    return 0;
  }
  
  static int bu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2;
    case 0: 
    case 14: 
    case 15: 
      return 1;
    }
    return 0;
  }
  
  static final class a
    implements e.c
  {
    static final a Mr;
    private final boolean Mq = true;
    
    static
    {
      AppMethodBeat.i(251283);
      Mr = new a();
      AppMethodBeat.o(251283);
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      AppMethodBeat.i(251282);
      int j = 0;
      int i = 0;
      if (j < paramInt + 0)
      {
        switch (e.bt(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        }
        for (;;)
        {
          j += 1;
          break;
          if (this.Mq)
          {
            AppMethodBeat.o(251282);
            return 0;
          }
          i = 1;
          continue;
          if (!this.Mq)
          {
            AppMethodBeat.o(251282);
            return 1;
          }
          i = 1;
        }
      }
      if (i != 0)
      {
        if (this.Mq)
        {
          AppMethodBeat.o(251282);
          return 1;
        }
        AppMethodBeat.o(251282);
        return 0;
      }
      AppMethodBeat.o(251282);
      return 2;
    }
  }
  
  static final class b
    implements e.c
  {
    static final b Ms;
    
    static
    {
      AppMethodBeat.i(251288);
      Ms = new b();
      AppMethodBeat.o(251288);
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      AppMethodBeat.i(251287);
      int i = 0;
      int j = 2;
      while ((i < paramInt + 0) && (j == 2))
      {
        j = e.bu(Character.getDirectionality(paramCharSequence.charAt(i)));
        i += 1;
      }
      AppMethodBeat.o(251287);
      return j;
    }
  }
  
  static abstract interface c
  {
    public abstract int b(CharSequence paramCharSequence, int paramInt);
  }
  
  static abstract class d
    implements d
  {
    private final e.c Mt;
    
    d(e.c paramc)
    {
      this.Mt = paramc;
    }
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.Mt == null) {
        return gT();
      }
      switch (this.Mt.b(paramCharSequence, paramInt))
      {
      default: 
        return gT();
      case 0: 
        return true;
      }
      return false;
    }
    
    protected abstract boolean gT();
  }
  
  static final class e
    extends e.d
  {
    private final boolean Mu;
    
    e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.Mu = paramBoolean;
    }
    
    protected final boolean gT()
    {
      return this.Mu;
    }
  }
  
  static final class f
    extends e.d
  {
    static final f Mv;
    
    static
    {
      AppMethodBeat.i(251300);
      Mv = new f();
      AppMethodBeat.o(251300);
    }
    
    f()
    {
      super();
    }
    
    protected final boolean gT()
    {
      AppMethodBeat.i(251298);
      if (f.d(Locale.getDefault()) == 1)
      {
        AppMethodBeat.o(251298);
        return true;
      }
      AppMethodBeat.o(251298);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.e.e
 * JD-Core Version:    0.7.0.1
 */