package android.support.v7.app;

import android.content.Context;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

final class f
  extends h
{
  f(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
  }
  
  final Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  final class a
    extends h.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public final void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
    {
      AppCompatDelegateImplV9.PanelFeatureState localPanelFeatureState = f.this.aV(0);
      if ((localPanelFeatureState != null) && (localPanelFeatureState.PQ != null))
      {
        super.onProvideKeyboardShortcuts(paramList, localPanelFeatureState.PQ, paramInt);
        return;
      }
      super.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.f
 * JD-Core Version:    0.7.0.1
 */