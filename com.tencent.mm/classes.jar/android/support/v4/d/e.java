package android.support.v4.d;

import java.util.Locale;

public final class e
{
  public static final d Oq = new e(null, false);
  public static final d Or = new e(null, true);
  public static final d Os = new e(b.Oz, false);
  public static final d Ot = new e(b.Oz, true);
  public static final d Ou = new e(a.Ox, false);
  public static final d Ov = f.OC;
  
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
    static final a Ox = new a(true);
    static final a Oy = new a(false);
    private final boolean Ow;
    
    private a(boolean paramBoolean)
    {
      this.Ow = paramBoolean;
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
            if (this.Ow) {
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
        } while (!this.Ow);
        i = 1;
        break;
        if (i == 0) {
          break label108;
        }
        i = k;
      } while (this.Ow);
      return 0;
      label108:
      return 2;
    }
  }
  
  static final class b
    implements e.c
  {
    static final b Oz = new b();
    
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
    private final e.c OA;
    
    d(e.c paramc)
    {
      this.OA = paramc;
    }
    
    public final boolean a(CharSequence paramCharSequence, int paramInt)
    {
      if ((paramCharSequence == null) || (paramInt < 0) || (paramCharSequence.length() - paramInt < 0)) {
        throw new IllegalArgumentException();
      }
      if (this.OA == null) {
        return fq();
      }
      switch (this.OA.b(paramCharSequence, paramInt))
      {
      default: 
        return fq();
      case 0: 
        return true;
      }
      return false;
    }
    
    protected abstract boolean fq();
  }
  
  static final class e
    extends e.d
  {
    private final boolean OB;
    
    e(e.c paramc, boolean paramBoolean)
    {
      super();
      this.OB = paramBoolean;
    }
    
    protected final boolean fq()
    {
      return this.OB;
    }
  }
  
  static final class f
    extends e.d
  {
    static final f OC = new f();
    
    f()
    {
      super();
    }
    
    protected final boolean fq()
    {
      return f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.d.e
 * JD-Core Version:    0.7.0.1
 */