package com.tencent.i.a.c.c.a.a.a;

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

abstract class b
  implements Window.Callback
{
  final Window.Callback aeD;
  
  public b(Window.Callback paramCallback)
  {
    if (paramCallback == null) {
      throw new IllegalArgumentException("Window callback may not be null");
    }
    this.aeD = paramCallback;
  }
  
  abstract void aC(MotionEvent paramMotionEvent);
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return this.aeD.dispatchGenericMotionEvent(paramMotionEvent);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return this.aeD.dispatchKeyEvent(paramKeyEvent);
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return this.aeD.dispatchKeyShortcutEvent(paramKeyEvent);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return this.aeD.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    aC(paramMotionEvent);
    return this.aeD.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return this.aeD.dispatchTrackballEvent(paramMotionEvent);
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    this.aeD.onActionModeFinished(paramActionMode);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    this.aeD.onActionModeStarted(paramActionMode);
  }
  
  public void onAttachedToWindow()
  {
    this.aeD.onAttachedToWindow();
  }
  
  public void onContentChanged()
  {
    this.aeD.onContentChanged();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    return this.aeD.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  public View onCreatePanelView(int paramInt)
  {
    return this.aeD.onCreatePanelView(paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    this.aeD.onDetachedFromWindow();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    return this.aeD.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return this.aeD.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    this.aeD.onPanelClosed(paramInt, paramMenu);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    this.aeD.onPointerCaptureChanged(paramBoolean);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    return this.aeD.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    this.aeD.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
  }
  
  public boolean onSearchRequested()
  {
    return this.aeD.onSearchRequested();
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    return this.aeD.onSearchRequested(paramSearchEvent);
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    this.aeD.onWindowAttributesChanged(paramLayoutParams);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    this.aeD.onWindowFocusChanged(paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    return this.aeD.onWindowStartingActionMode(paramCallback);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    return this.aeD.onWindowStartingActionMode(paramCallback, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */