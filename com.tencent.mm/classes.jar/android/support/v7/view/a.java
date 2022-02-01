package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class a
{
  public Context mContext;
  
  private a(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static a aa(Context paramContext)
  {
    return new a(paramContext);
  }
  
  public final int hs()
  {
    Configuration localConfiguration = this.mContext.getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((localConfiguration.smallestScreenWidthDp > 600) || (i > 600) || ((i > 960) && (j > 720)) || ((i > 720) && (j > 960))) {
      return 5;
    }
    if ((i >= 500) || ((i > 640) && (j > 480)) || ((i > 480) && (j > 640))) {
      return 4;
    }
    if (i >= 360) {
      return 3;
    }
    return 2;
  }
  
  public final boolean ht()
  {
    return this.mContext.getResources().getBoolean(2131034112);
  }
  
  public final boolean hu()
  {
    return this.mContext.getApplicationInfo().targetSdkVersion < 14;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.a
 * JD-Core Version:    0.7.0.1
 */