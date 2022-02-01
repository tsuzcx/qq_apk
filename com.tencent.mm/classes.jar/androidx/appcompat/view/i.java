package androidx.appcompat.view;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class i
  implements Window.Callback
{
  final Window.Callback kL;
  
  public i(Window.Callback paramCallback)
  {
    AppMethodBeat.i(239014);
    if (paramCallback == null)
    {
      paramCallback = new IllegalArgumentException("Window callback may not be null");
      AppMethodBeat.o(239014);
      throw paramCallback;
    }
    this.kL = paramCallback;
    AppMethodBeat.o(239014);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239019);
    boolean bool = this.kL.dispatchGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(239019);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239015);
    boolean bool = this.kL.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(239015);
    return bool;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239016);
    boolean bool = this.kL.dispatchKeyShortcutEvent(paramKeyEvent);
    AppMethodBeat.o(239016);
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(239020);
    boolean bool = this.kL.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(239020);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239017);
    boolean bool = this.kL.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(239017);
    return bool;
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(239018);
    boolean bool = this.kL.dispatchTrackballEvent(paramMotionEvent);
    AppMethodBeat.o(239018);
    return bool;
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    AppMethodBeat.i(239039);
    this.kL.onActionModeFinished(paramActionMode);
    AppMethodBeat.o(239039);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    AppMethodBeat.i(239038);
    this.kL.onActionModeStarted(paramActionMode);
    AppMethodBeat.o(239038);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(239031);
    this.kL.onAttachedToWindow();
    AppMethodBeat.o(239031);
  }
  
  public void onContentChanged()
  {
    AppMethodBeat.i(239029);
    this.kL.onContentChanged();
    AppMethodBeat.o(239029);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(239023);
    boolean bool = this.kL.onCreatePanelMenu(paramInt, paramMenu);
    AppMethodBeat.o(239023);
    return bool;
  }
  
  public View onCreatePanelView(int paramInt)
  {
    AppMethodBeat.i(239021);
    View localView = this.kL.onCreatePanelView(paramInt);
    AppMethodBeat.o(239021);
    return localView;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(239032);
    this.kL.onDetachedFromWindow();
    AppMethodBeat.o(239032);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(239027);
    boolean bool = this.kL.onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(239027);
    return bool;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(239026);
    boolean bool = this.kL.onMenuOpened(paramInt, paramMenu);
    AppMethodBeat.o(239026);
    return bool;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(239033);
    this.kL.onPanelClosed(paramInt, paramMenu);
    AppMethodBeat.o(239033);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(239042);
    this.kL.onPointerCaptureChanged(paramBoolean);
    AppMethodBeat.o(239042);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(239025);
    boolean bool = this.kL.onPreparePanel(paramInt, paramView, paramMenu);
    AppMethodBeat.o(239025);
    return bool;
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    AppMethodBeat.i(239041);
    this.kL.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    AppMethodBeat.o(239041);
  }
  
  public boolean onSearchRequested()
  {
    AppMethodBeat.i(239035);
    boolean bool = this.kL.onSearchRequested();
    AppMethodBeat.o(239035);
    return bool;
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    AppMethodBeat.i(239034);
    boolean bool = this.kL.onSearchRequested(paramSearchEvent);
    AppMethodBeat.o(239034);
    return bool;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(239028);
    this.kL.onWindowAttributesChanged(paramLayoutParams);
    AppMethodBeat.o(239028);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(239030);
    this.kL.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(239030);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(239036);
    paramCallback = this.kL.onWindowStartingActionMode(paramCallback);
    AppMethodBeat.o(239036);
    return paramCallback;
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    AppMethodBeat.i(239037);
    paramCallback = this.kL.onWindowStartingActionMode(paramCallback, paramInt);
    AppMethodBeat.o(239037);
    return paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.i
 * JD-Core Version:    0.7.0.1
 */