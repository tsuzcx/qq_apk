package com.google.a;

final class aa
  implements av
{
  private static final aa bVW = new aa();
  
  public static aa Gl()
  {
    return bVW;
  }
  
  public final boolean C(Class<?> paramClass)
  {
    return ab.class.isAssignableFrom(paramClass);
  }
  
  public final au D(Class<?> paramClass)
  {
    if (!ab.class.isAssignableFrom(paramClass)) {
      throw new IllegalArgumentException("Unsupported message type: " + paramClass.getName());
    }
    try
    {
      au localau = (au)ab.F(paramClass.asSubclass(ab.class)).Gq();
      return localau;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("Unable to get message info for " + paramClass.getName(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.aa
 * JD-Core Version:    0.7.0.1
 */