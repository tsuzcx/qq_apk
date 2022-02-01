package android.support.v7.view;

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
import java.util.List;

public class i
  implements Window.Callback
{
  final Window.Callback aeq;
  
  public i(Window.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("Window callback may not be null");
    }
    this.aeq = paramCallback;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.aeq.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.aeq.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.aeq.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.aeq.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.aeq.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.aeq.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.aeq.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.aeq.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.aeq.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.aeq.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.aeq.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.aeq.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.aeq.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.aeq.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.aeq.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.aeq.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.aeq.onPointerCaptureChanged(paramBoolean);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.aeq.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.aeq.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public boolean onSearchRequested()
  {
    return this.aeq.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.aeq.onSearchRequested(paramSearchEvent);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.aeq.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.aeq.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.aeq.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.aeq.onWindowStartingActionMode(paramCallback, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.i
 * JD-Core Version:    0.7.0.1
 */