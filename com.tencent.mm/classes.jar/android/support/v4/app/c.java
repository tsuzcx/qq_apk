package android.support.v4.app;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

public final class c
{
  public static void a(Bundle paramBundle, String paramString, IBinder paramIBinder)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramBundle.putBinder(paramString, paramIBinder);
      return;
    }
    c.a.a(paramBundle, paramString, paramIBinder);
  }
  
  public static IBinder c(Bundle paramBundle, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramBundle.getBinder(paramString);
    }
    return c.a.c(paramBundle, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v4.app.c
 * JD-Core Version:    0.7.0.1
 */