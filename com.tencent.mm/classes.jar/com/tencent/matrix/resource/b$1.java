package com.tencent.matrix.resource;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.g.c;
import java.lang.reflect.Field;

final class b$1
  extends com.tencent.matrix.resource.e.a
{
  public final void onActivityDestroyed(Activity paramActivity)
  {
    long l = System.currentTimeMillis();
    InputMethodManager localInputMethodManager;
    int i;
    if (paramActivity != null)
    {
      localInputMethodManager = (InputMethodManager)paramActivity.getSystemService("input_method");
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
          if (((View)localObject2).getContext() == paramActivity)
          {
            ((Field)localObject1).set(localInputMethodManager, null);
          }
          else
          {
            c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + ((View)localObject2).getContext() + " dest_context=" + paramActivity, new Object[0]);
            c.i("Matrix.ActivityLeakFixer", "fixInputMethodManagerLeak done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            l = System.currentTimeMillis();
            if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().peekDecorView() != null)) {
              paramActivity = paramActivity.getWindow().peekDecorView().getRootView();
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
            a.cs(paramActivity);
            if ((paramActivity instanceof ViewGroup)) {
              ((ViewGroup)paramActivity).removeAllViews();
            }
            c.i("Matrix.ActivityLeakFixer", "unbindDrawables done, cost: %s ms.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            return;
            localThrowable = localThrowable;
            c.e("Matrix.ActivityLeakFixer", "failed to fix InputMethodManagerLeak, %s", new Object[] { localThrowable.toString() });
          }
          catch (Throwable paramActivity)
          {
            c.w("Matrix.ActivityLeakFixer", "caught unexpected exception when unbind drawables.", new Object[] { paramActivity });
            continue;
          }
          c.i("Matrix.ActivityLeakFixer", "unbindDrawables, ui or ui's window is null, skip rest works.", new Object[0]);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.resource.b.1
 * JD-Core Version:    0.7.0.1
 */