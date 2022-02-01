package sm;

import android.util.Log;

public final class ax
{
  private static boolean a = false;
  private static aw b = new bc();
  
  public static void a(String paramString, Object paramObject)
  {
    if (paramObject == null)
    {
      Log.e(paramString, "log message is null");
      return;
    }
    b.a(paramString, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     sm.ax
 * JD-Core Version:    0.7.0.1
 */