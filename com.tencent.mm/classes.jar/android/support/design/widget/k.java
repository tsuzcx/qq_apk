package android.support.design.widget;

public final class k
{
  private static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (float)Math.hypot(paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
  }
  
  public static float c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return d(b(paramFloat1, paramFloat2, 0.0F, 0.0F), b(paramFloat1, paramFloat2, paramFloat3, 0.0F), b(paramFloat1, paramFloat2, paramFloat3, paramFloat4), b(paramFloat1, paramFloat2, 0.0F, paramFloat4));
  }
  
  private static float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((paramFloat1 > paramFloat2) && (paramFloat1 > paramFloat3) && (paramFloat1 > paramFloat4)) {
      return paramFloat1;
    }
    if ((paramFloat2 > paramFloat3) && (paramFloat2 > paramFloat4)) {
      return paramFloat2;
    }
    if (paramFloat3 > paramFloat4) {
      return paramFloat3;
    }
    return paramFloat4;
  }
  
  public static boolean e(float paramFloat1, float paramFloat2)
  {
    return 1.0E-004F + paramFloat1 >= paramFloat2;
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat3 * paramFloat2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.k
 * JD-Core Version:    0.7.0.1
 */