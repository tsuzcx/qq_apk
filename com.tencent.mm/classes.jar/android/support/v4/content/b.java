package android.support.v4.content;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.TypedValue;
import java.io.File;

public class b
{
  private static final Object sLock = new Object();
  private static TypedValue yX;
  
  public static File[] O(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(null);
    }
    return new File[] { paramContext.getExternalFilesDir(null) };
  }
  
  public static File[] P(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  public static boolean a(Context paramContext, Intent[] paramArrayOfIntent)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      paramContext.startActivities(paramArrayOfIntent, null);
    }
    for (;;)
    {
      return true;
      paramContext.startActivities(paramArrayOfIntent);
    }
  }
  
  public static int checkSelfPermission(Context paramContext, String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("permission is null");
    }
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
  }
  
  public static Drawable g(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return paramContext.getDrawable(paramInt);
    }
    if (Build.VERSION.SDK_INT >= 16) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    synchronized (sLock)
    {
      if (yX == null) {
        yX = new TypedValue();
      }
      paramContext.getResources().getValue(paramInt, yX, true);
      paramInt = yX.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    }
  }
  
  public static ColorStateList h(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    return paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static int i(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColor(paramInt);
    }
    return paramContext.getResources().getColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.b
 * JD-Core Version:    0.7.0.1
 */