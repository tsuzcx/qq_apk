package a.b;

public final class d
{
  public static final int aB(int paramInt1, int paramInt2, int paramInt3)
  {
    return gs(gs(paramInt1, paramInt3) - gs(paramInt2, paramInt3), paramInt3);
  }
  
  private static final int gs(int paramInt1, int paramInt2)
  {
    paramInt1 %= paramInt2;
    if (paramInt1 >= 0) {
      return paramInt1;
    }
    return paramInt1 + paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.b.d
 * JD-Core Version:    0.7.0.1
 */