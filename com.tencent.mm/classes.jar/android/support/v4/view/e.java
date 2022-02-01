package android.support.v4.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class e
{
  private static boolean MR = false;
  private static Method MS = null;
  private static boolean MT = false;
  private static Field MU = null;
  
  private static DialogInterface.OnKeyListener a(Dialog paramDialog)
  {
    if (!MT) {}
    try
    {
      Field localField = Dialog.class.getDeclaredField("mOnKeyListener");
      MU = localField;
      localField.setAccessible(true);
      label23:
      MT = true;
      if (MU != null) {
        try
        {
          paramDialog = (DialogInterface.OnKeyListener)MU.get(paramDialog);
          return paramDialog;
        }
        catch (IllegalAccessException paramDialog) {}
      }
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    if (!MR) {}
    try
    {
      MS = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label27:
      MR = true;
      if (MS != null) {}
      try
      {
        boolean bool = ((Boolean)MS.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        return bool;
      }
      catch (InvocationTargetException paramActionBar)
      {
        return false;
      }
      catch (IllegalAccessException paramActionBar)
      {
        label62:
        break label62;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  public static boolean a(a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (parama == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 28) {
      return parama.superDispatchKeyEvent(paramKeyEvent);
    }
    if ((paramCallback instanceof Activity))
    {
      paramView = (Activity)paramCallback;
      paramView.onUserInteraction();
      parama = paramView.getWindow();
      if (parama.hasFeature(8))
      {
        paramCallback = paramView.getActionBar();
        if ((paramKeyEvent.getKeyCode() == 82) && (paramCallback != null) && (a(paramCallback, paramKeyEvent))) {
          return true;
        }
      }
      if (parama.superDispatchKeyEvent(paramKeyEvent)) {
        return true;
      }
      paramCallback = parama.getDecorView();
      if (t.c(paramCallback, paramKeyEvent)) {
        return true;
      }
      parama = localObject1;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      return paramKeyEvent.dispatch(paramView, parama, paramView);
    }
    if ((paramCallback instanceof Dialog))
    {
      paramView = (Dialog)paramCallback;
      parama = a(paramView);
      if ((parama != null) && (parama.onKey(paramView, paramKeyEvent.getKeyCode(), paramKeyEvent))) {
        return true;
      }
      parama = paramView.getWindow();
      if (parama.superDispatchKeyEvent(paramKeyEvent)) {
        return true;
      }
      paramCallback = parama.getDecorView();
      if (t.c(paramCallback, paramKeyEvent)) {
        return true;
      }
      parama = localObject2;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      return paramKeyEvent.dispatch(paramView, parama, paramView);
    }
    return ((paramView != null) && (t.c(paramView, paramKeyEvent))) || (parama.superDispatchKeyEvent(paramKeyEvent));
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    return t.b(paramView, paramKeyEvent);
  }
  
  public static abstract interface a
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.e
 * JD-Core Version:    0.7.0.1
 */