package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

public class SearchView$SearchAutoComplete
  extends AppCompatAutoCompleteTextView
{
  private SearchView amo;
  boolean amp;
  final Runnable amq = new SearchView.SearchAutoComplete.1(this);
  private int mThreshold = getThreshold();
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772224);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int getSearchViewTextMinWidthDp()
  {
    Configuration localConfiguration = getResources().getConfiguration();
    int i = localConfiguration.screenWidthDp;
    int j = localConfiguration.screenHeightDp;
    if ((i >= 960) && (j >= 720) && (localConfiguration.orientation == 2)) {
      return 256;
    }
    if ((i >= 600) || ((i >= 640) && (j >= 480))) {
      return 192;
    }
    return 160;
  }
  
  public boolean enoughToFilter()
  {
    return (this.mThreshold <= 0) || (super.enoughToFilter());
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo = super.onCreateInputConnection(paramEditorInfo);
    if (this.amp)
    {
      removeCallbacks(this.amq);
      post(this.amq);
    }
    return paramEditorInfo;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    setMinWidth((int)TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), localDisplayMetrics));
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.amo.kn();
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.handleUpEvent(paramKeyEvent);
        }
        if ((paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()))
        {
          this.amo.clearFocus();
          setImeVisibility(false);
          return true;
        }
      }
    }
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.amo.hasFocus()) && (getVisibility() == 0))
    {
      this.amp = true;
      if (SearchView.Y(getContext())) {
        SearchView.amb.c(this);
      }
    }
  }
  
  public void performCompletion() {}
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  void setImeVisibility(boolean paramBoolean)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (!paramBoolean)
    {
      this.amp = false;
      removeCallbacks(this.amq);
      localInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    }
    if (localInputMethodManager.isActive(this))
    {
      this.amp = false;
      removeCallbacks(this.amq);
      localInputMethodManager.showSoftInput(this, 0);
      return;
    }
    this.amp = true;
  }
  
  void setSearchView(SearchView paramSearchView)
  {
    this.amo = paramSearchView;
  }
  
  public void setThreshold(int paramInt)
  {
    super.setThreshold(paramInt);
    this.mThreshold = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.SearchView.SearchAutoComplete
 * JD-Core Version:    0.7.0.1
 */