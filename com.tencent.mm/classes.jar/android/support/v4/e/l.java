package android.support.v4.e;

public final class l
{
  public static int at(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException();
    }
    return paramInt;
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT == null) {
      throw new NullPointerException();
    }
    return paramT;
  }
  
  public static <T> T checkNotNull(T paramT, Object paramObject)
  {
    if (paramT == null) {
      throw new NullPointerException(String.valueOf(paramObject));
    }
    return paramT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.l
 * JD-Core Version:    0.7.0.1
 */