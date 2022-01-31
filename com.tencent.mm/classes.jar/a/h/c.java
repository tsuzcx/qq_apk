package a.h;

public class c
  extends b
{
  public static final boolean a(char paramChar1, char paramChar2, boolean paramBoolean)
  {
    if (paramChar1 == paramChar2) {}
    do
    {
      return true;
      if (!paramBoolean) {
        return false;
      }
    } while ((Character.toUpperCase(paramChar1) == Character.toUpperCase(paramChar2)) || (Character.toLowerCase(paramChar1) == Character.toLowerCase(paramChar2)));
    return false;
  }
  
  public static final boolean isSurrogate(char paramChar)
  {
    if (55296 > paramChar) {}
    while (57343 < paramChar) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.h.c
 * JD-Core Version:    0.7.0.1
 */