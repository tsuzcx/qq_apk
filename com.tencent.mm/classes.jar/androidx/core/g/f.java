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
  private static boolean bti = false;
  private static Method btj = null;
  private static boolean btk = false;
  private static Field btl = null;
  
  private static DialogInterface.OnKeyListener a(Dialog paramDialog)
  {
    AppMethodBeat.i(195765);
    if (!btk) {}
    try
    {
      Field localField = Dialog.class.getDeclaredField("mOnKeyListener");
      btl = localField;
      localField.setAccessible(true);
      label28:
      btk = true;
      if (btl != null) {
        try
        {
          paramDialog = (DialogInterface.OnKeyListener)btl.get(paramDialog);
          AppMethodBeat.o(195765);
          return paramDialog;
        }
        catch (IllegalAccessException paramDialog) {}
      }
      AppMethodBeat.o(195765);
      return null;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label28;
    }
  }
  
  private static boolean a(ActionBar paramActionBar, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(195747);
    if (!bti) {}
    try
    {
      btj = paramActionBar.getClass().getMethod("onMenuKeyEvent", new Class[] { KeyEvent.class });
      label32:
      bti = true;
      if (btj != null) {}
      try
      {
        boolean bool = ((Boolean)btj.invoke(paramActionBar, new Object[] { paramKeyEvent })).booleanValue();
        AppMethodBeat.o(195747);
        return bool;
      }
      catch (InvocationTargetException paramActionBar)
      {
        AppMethodBeat.o(195747);
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
    AppMethodBeat.i(195724);
    boolean bool = z.b(paramView, paramKeyEvent);
    AppMethodBeat.o(195724);
    return bool;
  }
  
  public static boolean a(a parama, View paramView, Window.Callback paramCallback, KeyEvent paramKeyEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(195736);
    if (parama == null)
    {
      AppMethodBeat.o(195736);
      return false;
    }
    boolean bool;
    if (Build.VERSION.SDK_INT >= 28)
    {
      bool = parama.superDispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(195736);
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
          AppMethodBeat.o(195736);
          return true;
        }
      }
      if (parama.superDispatchKeyEvent(paramKeyEvent))
      {
        AppMethodBeat.o(195736);
        return true;
      }
      paramCallback = parama.getDecorView();
      if (z.c(paramCallback, paramKeyEvent))
      {
        AppMethodBeat.o(195736);
        return true;
      }
      parama = localObject1;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      bool = paramKeyEvent.dispatch(paramView, parama, paramView);
      AppMethodBeat.o(195736);
      return bool;
    }
    if ((paramCallback instanceof Dialog))
    {
      paramView = (Dialog)paramCallback;
      parama = a(paramView);
      if ((parama != null) && (parama.onKey(paramView, paramKeyEvent.getKeyCode(), paramKeyEvent)))
      {
        AppMethodBeat.o(195736);
        return true;
      }
      parama = paramView.getWindow();
      if (parama.superDispatchKeyEvent(paramKeyEvent))
      {
        AppMethodBeat.o(195736);
        return true;
      }
      paramCallback = parama.getDecorView();
      if (z.c(paramCallback, paramKeyEvent))
      {
        AppMethodBeat.o(195736);
        return true;
      }
      parama = localObject2;
      if (paramCallback != null) {
        parama = paramCallback.getKeyDispatcherState();
      }
      bool = paramKeyEvent.dispatch(paramView, parama, paramView);
      AppMethodBeat.o(195736);
      return bool;
    }
    if (((paramView != null) && (z.c(paramView, paramKeyEvent))) || (parama.superDispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(195736);
      return true;
    }
    AppMethodBeat.o(195736);
    return false;
  }
  
  public static abstract interface a
  {
    public abstract boolean superDispatchKeyEvent(KeyEvent paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.f
 * JD-Core Version:    0.7.0.1
 */