package android.support.v4.d;

final class d$a
  implements d.c
{
  static final a EA = new a(false);
  static final a Ez = new a(true);
  private final boolean Ey;
  
  private d$a(boolean paramBoolean)
  {
    this.Ey = paramBoolean;
  }
  
  public final int b(CharSequence paramCharSequence, int paramInt)
  {
    int k = 1;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < paramInt + 0) {
        switch (d.am(Character.getDirectionality(paramCharSequence.charAt(j))))
        {
        default: 
          j += 1;
          break;
        case 0: 
          if (this.Ey) {
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
      } while (!this.Ey);
      i = 1;
      break;
      if (i == 0) {
        break label108;
      }
      i = k;
    } while (this.Ey);
    return 0;
    label108:
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.d.d.a
 * JD-Core Version:    0.7.0.1
 */