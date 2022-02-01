package com.tencent.matrix.resource;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.matrix.resource.e.e;

public class b
  extends com.tencent.matrix.e.b
{
  public final com.tencent.matrix.resource.b.a cGr;
  public com.tencent.matrix.resource.e.b cGs = null;
  
  public b(com.tencent.matrix.resource.b.a parama)
  {
    this.cGr = parama;
  }
  
  public static void b(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new b.1());
  }
  
  public void destroy()
  {
    super.destroy();
    if (!isSupported())
    {
      com.tencent.matrix.g.c.e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    this.cGs.cJh.IY();
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
  }
  
  public String getTag()
  {
    return "memory";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    super.init(paramApplication, paramc);
    if (Build.VERSION.SDK_INT < 14)
    {
      com.tencent.matrix.g.c.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.cGs = new com.tencent.matrix.resource.e.b(paramApplication, this);
  }
  
  public void start()
  {
    super.start();
    if (!isSupported()) {
      com.tencent.matrix.g.c.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }
    com.tencent.matrix.resource.e.b localb;
    Application localApplication;
    do
    {
      return;
      localb = this.cGs;
      localb.IR();
      localApplication = localb.cJg.getApplication();
    } while (localApplication == null);
    localApplication.registerActivityLifecycleCallbacks(localb.cJq);
    com.tencent.matrix.a.cBz.a(localb);
    localb.cJh.a(localb.cJr, 0);
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
  }
  
  public void stop()
  {
    super.stop();
    if (!isSupported())
    {
      com.tencent.matrix.g.c.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    this.cGs.IR();
    com.tencent.matrix.g.c.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.b
 * JD-Core Version:    0.7.0.1
 */