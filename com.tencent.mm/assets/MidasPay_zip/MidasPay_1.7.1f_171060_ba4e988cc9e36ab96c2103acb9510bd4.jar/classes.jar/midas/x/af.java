package midas.x;

public class af
{
  private static af a;
  private static int b;
  
  public static int a()
  {
    try
    {
      int i = b;
      b = i + 1;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(int paramInt)
  {
    try
    {
      b = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.af
 * JD-Core Version:    0.7.0.1
 */