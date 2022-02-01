package com.tencent.tencentmap.mapsdk.a;

public class d
{
  private static d b;
  private int a = 0;
  
  public static d a()
  {
    if (b == null) {
      b = new d();
    }
    return b;
  }
  
  public static int b()
  {
    return a().a;
  }
  
  public static boolean c()
  {
    return b() == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.d
 * JD-Core Version:    0.7.0.1
 */