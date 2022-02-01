package android.support.v4.d;

import java.util.Locale;

public final class e
{
  public static final d Mm = new e(null, false);
  public static final d Mn = new e(null, true);
  public static final d Mo = new e(b.Mv, false);
  public static final d Mp = new e(b.Mv, true);
  public static final d Mq = new e(a.Mt, false);
  public static final d Mr = f.My;
  
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
    static final a Mt = new a(true);
    static final a Mu = new a(false);
    private final boolean Ms;
    
    private a(boolean paramBoolean)
    {
      this.Ms = paramBoolean;
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
            if (this.Ms) {
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
        } while (!this.Ms);
        i = 1;
        break;
        if (i == 0) {
          break label108;
        }
        i = k;
      } while (this.Ms);
      return 0;
      label108:
      return 2;
    }
  }
  
  static final class b
    implements e.c
  {
    static final b Mv = new b();
    
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
    private final e.c Mw;
    
    d(e.c paramc)
    {
      this.Mw = paramc;
    }
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.Mw == null) {
        return eT();
      }
      switch (this.Mw.b(paramCharSequence, paramInt))
      {
      default: 
        return eT();
      case 0: 
        return true;
      }
      return false;
    }
    
    protected abstract boolean eT();
  }
  
  static final class e
    extends e.d
  {
    private final boolean Mx;
    
    e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.Mx = paramBoolean;
    }
    
    protected final boolean eT()
    {
      return this.Mx;
    }
  }
  
  static final class f
    extends e.d
  {
    static final f My = new f();
    
    f()
    {
      super();
    }
    
    protected final boolean eT()
    {
      return f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.d.e
 * JD-Core Version:    0.7.0.1
 */