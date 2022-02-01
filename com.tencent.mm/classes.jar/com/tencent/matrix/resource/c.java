package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

public class c
  extends com.tencent.matrix.d.b
{
  public final com.tencent.matrix.resource.b.a daP;
  public com.tencent.matrix.resource.f.b daQ = null;
  
  public c(com.tencent.matrix.resource.b.a parama)
  {
    this.daP = parama;
  }
  
  public static void d(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.f.a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        long l = System.currentTimeMillis();
        Object localObject1;
        int i;
        if (paramAnonymousActivity != null)
        {
          localObject1 = (InputMethodManager)paramAnonymousActivity.getSystemService("input_method");
          if (localObject1 != null) {
            i = 0;
          }
        }
        for (;;)
        {
          Object localObject2;
          if (i < 3) {
            localObject2 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
          }
          try
          {
            localObject2 = localObject1.getClass().getDeclaredField((String)localObject2);
            if (!((Field)localObject2).isAccessible()) {
              ((Field)localObject2).setAccessible(true);
            }
            Object localObject3 = ((Field)localObject2).get(localObject1);
            if ((localObject3 instanceof View))
            {
              localObject3 = (View)localObject3;
              if (((View)localObject3).getContext() == paramAnonymousActivity)
              {
                ((Field)localObject2).set(localObject1, null);
              }
              else
              {
                com.tencent.matrix.e.c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + ((View)localObject3).getContext() + " dest_context=" + paramAnonymousActivity, new Object[0]);
                com.tencent.matrix.e.c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                l = System.currentTimeMillis();
                if ((paramAnonymousActivity != null) && (paramAnonymousActivity.getWindow() != null) && (paramAnonymousActivity.getWindow().peekDecorView() != null)) {
                  localObject1 = paramAnonymousActivity.getWindow().peekDecorView().getRootView();
                }
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              try
              {
                a.cA((View)localObject1);
                if ((localObject1 instanceof ViewGroup)) {
                  ((ViewGroup)localObject1).removeAllViews();
                }
                com.tencent.matrix.e.c.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                a.bu(paramAnonymousActivity);
                return;
                localThrowable2 = localThrowable2;
                com.tencent.matrix.e.c.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", new Object[] { localThrowable2.toString() });
              }
              catch (Throwable localThrowable1)
              {
                com.tencent.matrix.e.c.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", new Object[] { localThrowable1 });
                continue;
              }
              com.tencent.matrix.e.c.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
            }
            i += 1;
          }
        }
      }
    });
  }
  
  public void destroy()
  {
    super.destroy();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin destroy, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    com.tencent.matrix.resource.f.b localb = this.daQ;
    localb.dee.XV();
    localb.mHandlerThread.quitSafely();
    localb.dej.onDestroy();
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is destroyed.", new Object[0]);
  }
  
  public String getTag()
  {
    return "memory";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.d.c paramc)
  {
    super.init(paramApplication, paramc);
    if (Build.VERSION.SDK_INT < 14)
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
      unSupportPlugin();
      return;
    }
    this.daQ = new com.tencent.matrix.resource.f.b(paramApplication, this);
  }
  
  public void onForeground(boolean paramBoolean)
  {
    com.tencent.matrix.e.c.d("Matrix.ResourcePlugin", "onForeground: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.matrix.resource.f.b localb;
    if ((isPluginStarted()) && (this.daQ != null))
    {
      localb = this.daQ;
      if (paramBoolean)
      {
        com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "we are in foreground, modify scan time[%sms].", new Object[] { Long.valueOf(localb.deh) });
        localb.dee.XV();
        localb.dee.deq = localb.deh;
        localb.dee.a(localb.del, 0);
      }
    }
    else
    {
      return;
    }
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "we are in background, modify scan time[%sms].", new Object[] { Long.valueOf(localb.deg) });
    localb.dee.deq = localb.deg;
  }
  
  public void start()
  {
    super.start();
    if (!isSupported()) {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }
    com.tencent.matrix.resource.f.b localb;
    Application localApplication;
    do
    {
      return;
      localb = this.daQ;
      localb.XR();
      localApplication = localb.ded.getApplication();
    } while (localApplication == null);
    localApplication.registerActivityLifecycleCallbacks(localb.dek);
    localb.dee.a(localb.del, 0);
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
  }
  
  public void stop()
  {
    super.stop();
    if (!isSupported())
    {
      com.tencent.matrix.e.c.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    this.daQ.XR();
    com.tencent.matrix.e.c.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.resource.c
 * JD-Core Version:    0.7.0.1
 */