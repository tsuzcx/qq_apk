package android.support.v4.d;

import java.util.Locale;

public final class e
{
  public static final d Lr = new e(null, false);
  public static final d Ls = new e(null, true);
  public static final d Lt = new e(b.LA, false);
  public static final d Lu = new e(b.LA, true);
  public static final d Lv = new e(a.Ly, false);
  public static final d Lw = f.LD;
  
  static int aE(int paramInt)
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
  
  static int aF(int paramInt)
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
    static final a Ly = new a(true);
    static final a Lz = new a(false);
    private final boolean Lx;
    
    private a(boolean paramBoolean)
    {
      this.Lx = paramBoolean;
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      int k = 1;
      int j = 0;
      int i = 0;
      for (;;)
      {
        if (j < paramInt + 0) {
          switch (e.aE(Character.getDirectionality(paramCharSequence.charAt(j))))
          {
          default: 
            j += 1;
            break;
          case 0: 
            if (this.Lx) {
              i = 0;
            }
            break;
          }
        }
      }
      do
      {
        do
        {
          return i;
          i = 1;
          break;
          i = k;
        } while (!this.Lx);
        i = 1;
        break;
        if (i == 0) {
          break label108;
        }
        i = k;
      } while (this.Lx);
      return 0;
      label108:
      return 2;
    }
  }
  
  static final class b
    implements e.c
  {
    static final b LA = new b();
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      int i = 0;
      int j = 2;
      while ((i < paramInt + 0) && (j == 2))
      {
        j = e.aF(Character.getDirectionality(paramCharSequence.charAt(i)));
        i += 1;
      }
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
    private final e.c LB;
    
    d(e.c paramc)
    {
      this.LB = paramc;
    }
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.LB == null) {
        return eL();
      }
      switch (this.LB.b(paramCharSequence, paramInt))
      {
      default: 
        return eL();
      case 0: 
        return true;
      }
      return false;
    }
    
    protected abstract boolean eL();
  }
  
  static final class e
    extends e.d
  {
    private final boolean LC;
    
    e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.LC = paramBoolean;
    }
    
    protected final boolean eL()
    {
      return this.LC;
    }
  }
  
  static final class f
    extends e.d
  {
    static final f LD = new f();
    
    f()
    {
      super();
    }
    
    protected final boolean eL()
    {
      return f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.d.e
 * JD-Core Version:    0.7.0.1
 */