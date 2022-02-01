package androidx.core.g;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnKeyListener;
import android.os.Build.VERSION;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class f
{
  private static boolean Ng = false;
  private static Method Nh = null;
  private static boolean Ni = false;
  private static Field Nj = null;
  
  private static DialogInterface.OnKeyListener a(Dialog paramDialog)
  {
    AppMethodBeat.i(251447);
    if (!Ni) {}
    try
    {
      Field localField = Dialog.class.getDeclaredField("mOnKeyListener");
      Nj = localField;
      localField.setAccessible(true);
      label28:
      Ni = true;
      if (Nj != null) {
        try
        {
          paramDialog = (DialogInterface.OnKeyListener)Nj.get(paramDialog);
          AppMethodBeat.o(251447);
          return paramDialog;
        }
        catch (IllegalAccessException paramDialog) {}
      }
      AppMethodBeat.o(251447);
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label28;
    }
  }
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(251446);
    if (!Ng) {}
    try
    {
      Nh = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label32:
      Ng = true;
      if (Nh != null) {}
      try
      {
        boolean bool = ((Boolean)Nh.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        AppMethodBeat.o(251446);
        return bool;
      }
      catch (InvocationTargetException paramActionBar)
      {
        AppMethodBeat.o(251446);
        return false;
      }
      catch (IllegalAccessException paramActionBar)
      {
        label72:
        break label72;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
  
  public static boolean a(View paramView, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(251444);
    boolean bool = w.b(paramView, paramKeyEvent);
    AppMethodBeat.o(251444);
    return bool;
  }
  
  public static boolean a(a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(251445);
    if (parama == null)
    {
      AppMethodBeat.o(251445);
      return false;
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28)
    {
      bool = parama.superDispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(251445);
      return bool;
    }
    if ((paramCallback instanceof Activity))
    {
      paramView = (Activity)paramCallback;
      paramView.onUserInteraction();
      parama = paramView.getWindow();
      if (parama.hasFeature(8))
      {
        paramCallback = paramView.getActionBar();
        if ((paramKeyEvent.getKeyCode() == 82) && (paramCallback != null) && (a(paramCallback, paramKeyEvent)))
        {
          AppMethodBeat.o(251445);
          return true;
        }
      }
      if (parama.superDispatchKeyEvent(paramKeyEvent))
      {
        AppMethodBeat.o(251445);
        return true;
      }
      paramCallback = parama.getDecorView();
      if (w.c(paramCallback, paramKeyEvent))
      {
        AppMethodBeat.o(251445);
        return true;
      }
      parama = localObject1;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      bool = paramKeyEvent.dispatch(paramView, parama, paramView);
      AppMethodBeat.o(251445);
      return bool;
    }
    if ((paramCallback instanceof Dialog))
    {
      paramView = (Dialog)paramCallback;
      parama = a(paramView);
      if ((parama != null) && (parama.onKey(paramView, paramKeyEvent.getKeyCode(), paramKeyEvent)))
      {
        AppMethodBeat.o(251445);
        return true;
      }
      parama = paramView.getWindow();
      if (parama.superDispatchKeyEvent(paramKeyEvent))
      {
        AppMethodBeat.o(251445);
        return true;
      }
      paramCallback = parama.getDecorView();
      if (w.c(paramCallback, paramKeyEvent))
      {
        AppMethodBeat.o(251445);
        return true;
      }
      parama = localObject2;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      bool = paramKeyEvent.dispatch(paramView, parama, paramView);
      AppMethodBeat.o(251445);
      return bool;
    }
    if (((paramView != null) && (w.c(paramView, paramKeyEvent))) || (parama.superDispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(251445);
      return true;
    }
    AppMethodBeat.o(251445);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.f
 * JD-Core Version:    0.7.0.1
 */