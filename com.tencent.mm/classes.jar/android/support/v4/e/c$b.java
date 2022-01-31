package android.support.v4.e;

final class c$b
  implements c.c
{
  static final b DM = new b();
  
  public final int b(CharSequence paramCharSequence, int paramInt)
  {
    int i = 0;
    int j = 2;
    while ((i < paramInt + 0) && (j == 2))
    {
      j = c.ap(Character.getDirectionality(paramCharSequence.charAt(i)));
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.e.c.b
 * JD-Core Version:    0.7.0.1
 */