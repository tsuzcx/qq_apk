package androidx.core.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class e
{
  public static final d bsp;
  public static final d bsq;
  public static final d bsr;
  public static final d bss;
  public static final d bst;
  public static final d bsu;
  
  static
  {
    AppMethodBeat.i(195469);
    bsp = new e(null, false);
    bsq = new e(null, true);
    bsr = new e(b.bsx, false);
    bss = new e(b.bsx, true);
    bst = new e(a.bsw, false);
    bsu = f.bsA;
    AppMethodBeat.o(195469);
  }
  
  static int ej(int paramInt)
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
  
  static int ek(int paramInt)
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
    static final a bsw;
    private final boolean bsv = true;
    
    static
    {
      AppMethodBeat.i(195496);
      bsw = new a();
      AppMethodBeat.o(195496);
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      AppMethodBeat.i(195508);
      int j = 0;
      int i = 0;
      if (j < paramInt + 0)
      {
        switch (e.ej(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        }
        for (;;)
        {
          j += 1;
          break;
          if (this.bsv)
          {
            AppMethodBeat.o(195508);
            return 0;
          }
          i = 1;
          continue;
          if (!this.bsv)
          {
            AppMethodBeat.o(195508);
            return 1;
          }
          i = 1;
        }
      }
      if (i != 0)
      {
        if (this.bsv)
        {
          AppMethodBeat.o(195508);
          return 1;
        }
        AppMethodBeat.o(195508);
        return 0;
      }
      AppMethodBeat.o(195508);
      return 2;
    }
  }
  
  static final class b
    implements e.c
  {
    static final b bsx;
    
    static
    {
      AppMethodBeat.i(195495);
      bsx = new b();
      AppMethodBeat.o(195495);
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      AppMethodBeat.i(195502);
      int i = 0;
      int j = 2;
      while ((i < paramInt + 0) && (j == 2))
      {
        j = e.ek(Character.getDirectionality(paramCharSequence.charAt(i)));
        i += 1;
      }
      AppMethodBeat.o(195502);
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
    private final e.c bsy;
    
    d(e.c paramc)
    {
      this.bsy = paramc;
    }
    
    protected abstract boolean Ec();
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.bsy == null) {
        return Ec();
      }
      switch (this.bsy.b(paramCharSequence, paramInt))
      {
      default: 
        return Ec();
      case 0: 
        return true;
      }
      return false;
    }
  }
  
  static final class e
    extends e.d
  {
    private final boolean bsz;
    
    e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.bsz = paramBoolean;
    }
    
    protected final boolean Ec()
    {
      return this.bsz;
    }
  }
  
  static final class f
    extends e.d
  {
    static final f bsA;
    
    static
    {
      AppMethodBeat.i(195478);
      bsA = new f();
      AppMethodBeat.o(195478);
    }
    
    f()
    {
      super();
    }
    
    protected final boolean Ec()
    {
      AppMethodBeat.i(195486);
      if (f.d(Locale.getDefault()) == 1)
      {
        AppMethodBeat.o(195486);
        return true;
      }
      AppMethodBeat.o(195486);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.e.e
 * JD-Core Version:    0.7.0.1
 */