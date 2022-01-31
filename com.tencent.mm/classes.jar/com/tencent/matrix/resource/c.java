package com.tencent.matrix.resource;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.resource.e.e;
import java.lang.reflect.Field;

public class c
  extends com.tencent.matrix.b.b
{
  public final com.tencent.matrix.resource.b.a boO;
  private com.tencent.matrix.resource.e.b boP = null;
  
  public c(com.tencent.matrix.resource.b.a parama)
  {
    this.boO = parama;
  }
  
  public static void a(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(new com.tencent.matrix.resource.e.a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        long l = System.currentTimeMillis();
        InputMethodManager localInputMethodManager;
        int i;
        if (paramAnonymousActivity != null)
        {
          localInputMethodManager = (InputMethodManager)paramAnonymousActivity.getSystemService("input_method");
          if (localInputMethodManager != null) {
            i = 0;
          }
        }
        for (;;)
        {
          Object localObject1;
          if (i < 3) {
            localObject1 = new String[] { "mCurRootView", "mServedView", "mNextServedView" }[i];
          }
          try
          {
            localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
            if (!((Field)localObject1).isAccessible()) {
              ((Field)localObject1).setAccessible(true);
            }
            Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
            if ((localObject2 instanceof View))
            {
              localObject2 = (View)localObject2;
              if (((View)localObject2).getContext() == paramAnonymousActivity)
              {
                ((Field)localObject1).set(localInputMethodManager, null);
              }
              else
              {
                com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + ((View)localObject2).getContext() + " dest_context=" + paramAnonymousActivity, new Object[0]);
                com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                l = System.currentTimeMillis();
                if ((paramAnonymousActivity != null) && (paramAnonymousActivity.getWindow() != null) && (paramAnonymousActivity.getWindow().peekDecorView() != null)) {
                  paramAnonymousActivity = paramAnonymousActivity.getWindow().peekDecorView().getRootView();
                }
              }
            }
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              try
              {
                a.bJ(paramAnonymousActivity);
                if ((paramAnonymousActivity instanceof ViewGroup)) {
                  ((ViewGroup)paramAnonymousActivity).removeAllViews();
                }
                com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
                return;
                localThrowable = localThrowable;
                com.tencent.matrix.d.b.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", new Object[] { localThrowable.toString() });
              }
              catch (Throwable paramAnonymousActivity)
              {
                com.tencent.matrix.d.b.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", new Object[] { paramAnonymousActivity });
                continue;
              }
              com.tencent.matrix.d.b.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
            }
            i += 1;
          }
        }
      }
    });
  }
  
  public final void a(Application paramApplication, com.tencent.matrix.b.c paramc)
  {
    super.a(paramApplication, paramc);
    if (Build.VERSION.SDK_INT < 14)
    {
      com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "API is low Build.VERSION_CODES.ICE_CREAM_SANDWICH(14), ResourcePlugin is not supported", new Object[0]);
      this.boE = false;
      return;
    }
    this.boP = new com.tencent.matrix.resource.e.b(paramApplication, this);
  }
  
  public final String getTag()
  {
    return "memory";
  }
  
  public final void start()
  {
    super.start();
    if (!this.boE) {
      com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "ResourcePlugin start, ResourcePlugin is not supported, just return", new Object[0]);
    }
    com.tencent.matrix.resource.e.b localb;
    Application localApplication;
    do
    {
      return;
      localb = this.boP;
      localb.ri();
      localApplication = localb.bpR.application;
    } while (localApplication == null);
    localApplication.registerActivityLifecycleCallbacks(localb.bpY);
    localb.bpS.a(localb.bpZ, 0);
    com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "watcher is started.", new Object[0]);
  }
  
  public final void stop()
  {
    super.stop();
    if (!this.boE)
    {
      com.tencent.matrix.d.b.e("Matrix.ResourcePlugin", "ResourcePlugin stop, ResourcePlugin is not supported, just return", new Object[0]);
      return;
    }
    this.boP.ri();
    com.tencent.matrix.d.b.i("Matrix.ActivityRefWatcher", "watcher is stopped.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.resource.c
 * JD-Core Version:    0.7.0.1
 */