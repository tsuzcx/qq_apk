package com.google.b;

final class ay
  implements bv
{
  private static final ay bXU = new ay();
  
  public static ay HR()
  {
    return bXU;
  }
  
  public final boolean A(Class<?> paramClass)
  {
    return az.class.isAssignableFrom(paramClass);
  }
  
  public final bu B(Class<?> paramClass)
  {
    if (!az.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    try
    {
      bu localbu = (bu)az.D(paramClass.asSubclass(az.class)).HU();
      return localbu;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to get message info for " + paramClass.getName(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.ay
 * JD-Core Version:    0.7.0.1
 */