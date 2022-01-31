package android.support.v4.e;

public final class c
{
  public static final b DD = new c.e(null, false);
  public static final b DE = new c.e(null, true);
  public static final b DF = new c.e(c.b.DM, false);
  public static final b DG = new c.e(c.b.DM, true);
  public static final b DH = new c.e(a.DK, false);
  public static final b DI = c.f.DP;
  
  static int ao(int paramInt)
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
  
  static int ap(int paramInt)
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
  
  private static final class a
    implements c.c
  {
    static final a DK = new a(true);
    static final a DL = new a(false);
    private final boolean DJ;
    
    private a(boolean paramBoolean)
    {
      this.DJ = paramBoolean;
    }
    
    public final int b(CharSequence paramCharSequence, int paramInt)
    {
      int k = 1;
      int j = 0;
      int i = 0;
      for (;;)
      {
        if (j < paramInt + 0) {
          switch (c.ao(Character.getDirectionality(paramCharSequence.charAt(j))))
          {
          default: 
            j += 1;
            break;
          case 0: 
            if (this.DJ) {
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
        } while (!this.DJ);
        i = 1;
        break;
        if (i == 0) {
          break label108;
        }
        i = k;
      } while (this.DJ);
      return 0;
      label108:
      return 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.e.c
 * JD-Core Version:    0.7.0.1
 */