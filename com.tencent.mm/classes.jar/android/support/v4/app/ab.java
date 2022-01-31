package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

public final class ab
  implements Iterable<Intent>
{
  public final ArrayList<Intent> zx = new ArrayList();
  public final Context zy;
  
  private ab(Context paramContext)
  {
    this.zy = paramContext;
  }
  
  public static ab M(Context paramContext)
  {
    return new ab(paramContext);
  }
  
  public final ab a(ComponentName paramComponentName)
  {
    int i = this.zx.size();
    try
    {
      for (paramComponentName = q.a(this.zy, paramComponentName); paramComponentName != null; paramComponentName = q.a(this.zy, paramComponentName.getComponent())) {
        this.zx.add(i, paramComponentName);
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
    return this.zx.iterator();
  }
  
  public static abstract interface a
  {
    public abstract Intent getSupportParentActivityIntent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.app.ab
 * JD-Core Version:    0.7.0.1
 */