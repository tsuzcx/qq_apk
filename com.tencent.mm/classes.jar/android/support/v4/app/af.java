package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class af
  implements Iterable<Intent>
{
  private static final c yR = new c();
  public final ArrayList<Intent> yS = new ArrayList();
  public final Context yT;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      yR = new b();
      return;
    }
  }
  
  private af(Context paramContext)
  {
    this.yT = paramContext;
  }
  
  public static af N(Context paramContext)
  {
    return new af(paramContext);
  }
  
  public final af a(ComponentName paramComponentName)
  {
    int i = this.yS.size();
    try
    {
      for (paramComponentName = v.a(this.yT, paramComponentName); paramComponentName != null; paramComponentName = v.a(this.yT, paramComponentName.getComponent())) {
        this.yS.add(i, paramComponentName);
      }
      return this;
    }
    catch (PackageManager.NameNotFoundException paramComponentName)
    {
      throw new IllegalArgumentException(paramComponentName);
    }
  }
  
  @Deprecated
  public final Iterator<Intent> iterator()
  {
    return this.yS.iterator();
  }
  
  public static abstract interface a
  {
    public abstract Intent getSupportParentActivityIntent();
  }
  
  static final class b
    extends af.c
  {}
  
  static class c {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.af
 * JD-Core Version:    0.7.0.1
 */