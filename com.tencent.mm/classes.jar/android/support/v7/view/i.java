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
  final Window.Callback acz;
  
  public i(Window.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("Window callback may not be null");
    }
    this.acz = paramCallback;
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.acz.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.acz.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.acz.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.acz.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.acz.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.acz.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.acz.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.acz.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.acz.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.acz.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.acz.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.acz.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.acz.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.acz.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.acz.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.acz.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.acz.onPointerCaptureChanged(paramBoolean);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.acz.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.acz.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public boolean onSearchRequested()
  {
    return this.acz.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.acz.onSearchRequested(paramSearchEvent);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.acz.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.acz.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.acz.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.acz.onWindowStartingActionMode(paramCallback, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.i
 * JD-Core Version:    0.7.0.1
 */