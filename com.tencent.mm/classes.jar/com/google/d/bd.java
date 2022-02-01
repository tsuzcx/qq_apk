package com.google.d;

final class bd
  implements cd
{
  private static final bd dRH = new bd();
  
  public static bd ahV()
  {
    return dRH;
  }
  
  public final boolean J(Class<?> paramClass)
  {
    return be.class.isAssignableFrom(paramClass);
  }
  
  public final cc K(Class<?> paramClass)
  {
    if (!be.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    try
    {
      cc localcc = (cc)be.M(paramClass.asSubclass(be.class)).ahZ();
      return localcc;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to get message info for " + paramClass.getName(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.bd
 * JD-Core Version:    0.7.0.1
 */