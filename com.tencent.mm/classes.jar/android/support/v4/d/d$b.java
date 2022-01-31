package android.support.v4.d;

final class d$b
  implements d.c
{
  static final b EB = new b();
  
  public final int b(CharSequence paramCharSequence, int paramInt)
  {
    int i = 0;
    int j = 2;
    while ((i < paramInt + 0) && (j == 2))
    {
      j = d.an(Character.getDirectionality(paramCharSequence.charAt(i)));
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v4.d.d.b
 * JD-Core Version:    0.7.0.1
 */