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
  final Window.Callback lH;
  
  public i(Window.Callback paramCallback)
  {
    AppMethodBeat.i(200649);
    if (paramCallback == null)
    {
      paramCallback = new IllegalArgumentException("Window callback may not be null");
      AppMethodBeat.o(200649);
      throw paramCallback;
    }
    this.lH = paramCallback;
    AppMethodBeat.o(200649);
  }
  
  public boolean dispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200690);
    boolean bool = this.lH.dispatchGenericMotionEvent(paramMotionEvent);
    AppMethodBeat.o(200690);
    return bool;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200656);
    boolean bool = this.lH.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(200656);
    return bool;
  }
  
  public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200662);
    boolean bool = this.lH.dispatchKeyShortcutEvent(paramKeyEvent);
    AppMethodBeat.o(200662);
    return bool;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    AppMethodBeat.i(200700);
    boolean bool = this.lH.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    AppMethodBeat.o(200700);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200672);
    boolean bool = this.lH.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200672);
    return bool;
  }
  
  public boolean dispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200684);
    boolean bool = this.lH.dispatchTrackballEvent(paramMotionEvent);
    AppMethodBeat.o(200684);
    return bool;
  }
  
  public void onActionModeFinished(ActionMode paramActionMode)
  {
    AppMethodBeat.i(200865);
    this.lH.onActionModeFinished(paramActionMode);
    AppMethodBeat.o(200865);
  }
  
  public void onActionModeStarted(ActionMode paramActionMode)
  {
    AppMethodBeat.i(200858);
    this.lH.onActionModeStarted(paramActionMode);
    AppMethodBeat.o(200858);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(200798);
    this.lH.onAttachedToWindow();
    AppMethodBeat.o(200798);
  }
  
  public void onContentChanged()
  {
    AppMethodBeat.i(200776);
    this.lH.onContentChanged();
    AppMethodBeat.o(200776);
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(200721);
    boolean bool = this.lH.onCreatePanelMenu(paramInt, paramMenu);
    AppMethodBeat.o(200721);
    return bool;
  }
  
  public View onCreatePanelView(int paramInt)
  {
    AppMethodBeat.i(200708);
    View localView = this.lH.onCreatePanelView(paramInt);
    AppMethodBeat.o(200708);
    return localView;
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(200807);
    this.lH.onDetachedFromWindow();
    AppMethodBeat.o(200807);
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(200753);
    boolean bool = this.lH.onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(200753);
    return bool;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(200743);
    boolean bool = this.lH.onMenuOpened(paramInt, paramMenu);
    AppMethodBeat.o(200743);
    return bool;
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    AppMethodBeat.i(200817);
    this.lH.onPanelClosed(paramInt, paramMenu);
    AppMethodBeat.o(200817);
  }
  
  public void onPointerCaptureChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(200880);
    this.lH.onPointerCaptureChanged(paramBoolean);
    AppMethodBeat.o(200880);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    AppMethodBeat.i(200733);
    boolean bool = this.lH.onPreparePanel(paramInt, paramView, paramMenu);
    AppMethodBeat.o(200733);
    return bool;
  }
  
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> paramList, Menu paramMenu, int paramInt)
  {
    AppMethodBeat.i(200874);
    this.lH.onProvideKeyboardShortcuts(paramList, paramMenu, paramInt);
    AppMethodBeat.o(200874);
  }
  
  public boolean onSearchRequested()
  {
    AppMethodBeat.i(200833);
    boolean bool = this.lH.onSearchRequested();
    AppMethodBeat.o(200833);
    return bool;
  }
  
  public boolean onSearchRequested(SearchEvent paramSearchEvent)
  {
    AppMethodBeat.i(200823);
    boolean bool = this.lH.onSearchRequested(paramSearchEvent);
    AppMethodBeat.o(200823);
    return bool;
  }
  
  public void onWindowAttributesChanged(WindowManager.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200763);
    this.lH.onWindowAttributesChanged(paramLayoutParams);
    AppMethodBeat.o(200763);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(200790);
    this.lH.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(200790);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(200842);
    paramCallback = this.lH.onWindowStartingActionMode(paramCallback);
    AppMethodBeat.o(200842);
    return paramCallback;
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
  {
    AppMethodBeat.i(200847);
    paramCallback = this.lH.onWindowStartingActionMode(paramCallback, paramInt);
    AppMethodBeat.o(200847);
    return paramCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.view.i
 * JD-Core Version:    0.7.0.1
 */