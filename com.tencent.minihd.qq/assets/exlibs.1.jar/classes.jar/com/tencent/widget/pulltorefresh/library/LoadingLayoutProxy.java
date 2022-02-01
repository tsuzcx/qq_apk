package com.tencent.widget.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import com.tencent.widget.pulltorefresh.library.internal.LoadingLayout;
import java.util.HashSet;
import java.util.Iterator;

public class LoadingLayoutProxy
  implements ILoadingLayout
{
  private final HashSet a = new HashSet();
  
  public void a(LoadingLayout paramLoadingLayout)
  {
    if (paramLoadingLayout != null) {
      this.a.add(paramLoadingLayout);
    }
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLastUpdatedLabel(paramCharSequence);
    }
  }
  
  public void setLoadingDrawable(Drawable paramDrawable)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setLoadingDrawable(paramDrawable);
    }
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setPullLabel(paramCharSequence);
    }
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setRefreshingLabel(paramCharSequence);
    }
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setReleaseLabel(paramCharSequence);
    }
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((LoadingLayout)localIterator.next()).setTextTypeface(paramTypeface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.LoadingLayoutProxy
 * JD-Core Version:    0.7.0.1
 */