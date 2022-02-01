package com.tencent.widget.widget.adapters;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractWheelAdapter
  implements WheelViewAdapter
{
  private List a;
  
  public View a(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  protected void a()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((DataSetObserver)localIterator.next()).onChanged();
      }
    }
  }
  
  public void a(DataSetObserver paramDataSetObserver)
  {
    if (this.a == null) {
      this.a = new LinkedList();
    }
    this.a.add(paramDataSetObserver);
  }
  
  protected void b()
  {
    if (this.a != null)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((DataSetObserver)localIterator.next()).onInvalidated();
      }
    }
  }
  
  public void b(DataSetObserver paramDataSetObserver)
  {
    if (this.a != null) {
      this.a.remove(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.widget.adapters.AbstractWheelAdapter
 * JD-Core Version:    0.7.0.1
 */