package midas.x;

public class i
{
  public static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return 0;
  }
  
  public static String a(int paramInt)
  {
    return String.valueOf(paramInt);
  }
  
  public static long b(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return 0L;
  }
  
  public static float c(String paramString)
  {
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.i
 * JD-Core Version:    0.7.0.1
 */