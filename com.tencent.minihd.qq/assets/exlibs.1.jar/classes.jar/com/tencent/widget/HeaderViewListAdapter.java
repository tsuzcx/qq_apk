package com.tencent.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderViewListAdapter
  implements Filterable, WrapperListAdapter
{
  static final ArrayList c = new ArrayList();
  private final ListAdapter jdField_a_of_type_AndroidWidgetListAdapter;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  boolean jdField_a_of_type_Boolean;
  ArrayList jdField_b_of_type_JavaUtilArrayList;
  private final boolean jdField_b_of_type_Boolean;
  
  public HeaderViewListAdapter(ArrayList paramArrayList1, ArrayList paramArrayList2, ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_AndroidWidgetListAdapter = paramListAdapter;
    this.jdField_b_of_type_Boolean = (paramListAdapter instanceof Filterable);
    if (paramArrayList1 == null)
    {
      this.jdField_a_of_type_JavaUtilArrayList = c;
      if (paramArrayList2 != null) {
        break label79;
      }
      this.jdField_b_of_type_JavaUtilArrayList = c;
      label39:
      if ((!a(this.jdField_a_of_type_JavaUtilArrayList)) || (!a(this.jdField_b_of_type_JavaUtilArrayList))) {
        break label87;
      }
    }
    label79:
    label87:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
      break;
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
      break label39;
    }
  }
  
  private boolean a(ArrayList paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!((ListView.FixedViewInfo)paramArrayList.next()).jdField_a_of_type_Boolean) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public boolean a(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((ListView.FixedViewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_AndroidViewView == paramView)
      {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
        boolean bool1 = bool2;
        if (a(this.jdField_a_of_type_JavaUtilArrayList))
        {
          bool1 = bool2;
          if (a(this.jdField_b_of_type_JavaUtilArrayList)) {
            bool1 = true;
          }
        }
        this.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public boolean areAllItemsEnabled()
  {
    return (this.jdField_a_of_type_AndroidWidgetListAdapter == null) || ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidWidgetListAdapter.areAllItemsEnabled()));
  }
  
  public int b()
  {
    return this.jdField_b_of_type_JavaUtilArrayList.size();
  }
  
  public boolean b(View paramView)
  {
    boolean bool2 = false;
    int i = 0;
    while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (((ListView.FixedViewInfo)this.jdField_b_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_AndroidViewView == paramView)
      {
        this.jdField_b_of_type_JavaUtilArrayList.remove(i);
        boolean bool1 = bool2;
        if (a(this.jdField_a_of_type_JavaUtilArrayList))
        {
          bool1 = bool2;
          if (a(this.jdField_b_of_type_JavaUtilArrayList)) {
            bool1 = true;
          }
        }
        this.jdField_a_of_type_Boolean = bool1;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      return b() + a() + this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
    }
    return b() + a();
  }
  
  public Filter getFilter()
  {
    if (this.jdField_b_of_type_Boolean) {
      return ((Filterable)this.jdField_a_of_type_AndroidWidgetListAdapter).getFilter();
    }
    return null;
  }
  
  public Object getItem(int paramInt)
  {
    int i = a();
    if (paramInt < i) {
      return ((ListView.FixedViewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangObject;
    }
    int j = paramInt - i;
    paramInt = 0;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      i = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      paramInt = i;
      if (j < i) {
        return this.jdField_a_of_type_AndroidWidgetListAdapter.getItem(j);
      }
    }
    return ((ListView.FixedViewInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j - paramInt)).jdField_a_of_type_JavaLangObject;
  }
  
  public long getItemId(int paramInt)
  {
    int i = a();
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) {
        return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemId(paramInt);
      }
    }
    return -1L;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = a();
    if ((this.jdField_a_of_type_AndroidWidgetListAdapter != null) && (paramInt >= i))
    {
      paramInt -= i;
      if (paramInt < this.jdField_a_of_type_AndroidWidgetListAdapter.getCount()) {
        return this.jdField_a_of_type_AndroidWidgetListAdapter.getItemViewType(paramInt);
      }
    }
    return -2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = a();
    if (paramInt < i) {
      return ((ListView.FixedViewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_AndroidViewView;
    }
    int j = paramInt - i;
    paramInt = 0;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      i = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      paramInt = i;
      if (j < i) {
        return this.jdField_a_of_type_AndroidWidgetListAdapter.getView(j, paramView, paramViewGroup);
      }
    }
    try
    {
      paramView = ((ListView.FixedViewInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j - paramInt)).jdField_a_of_type_AndroidViewView;
      return paramView;
    }
    catch (Exception paramView)
    {
      throw new RuntimeException("adapter index out of bound. adapter count: " + paramInt + ", footCount: " + this.jdField_b_of_type_JavaUtilArrayList.size() + " , position: " + j + ", Adapter: " + this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public int getViewTypeCount()
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      return this.jdField_a_of_type_AndroidWidgetListAdapter.getViewTypeCount();
    }
    return 1;
  }
  
  public ListAdapter getWrappedAdapter()
  {
    return this.jdField_a_of_type_AndroidWidgetListAdapter;
  }
  
  public boolean hasStableIds()
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      return this.jdField_a_of_type_AndroidWidgetListAdapter.hasStableIds();
    }
    return false;
  }
  
  public boolean isEmpty()
  {
    return (this.jdField_a_of_type_AndroidWidgetListAdapter == null) || (this.jdField_a_of_type_AndroidWidgetListAdapter.isEmpty());
  }
  
  public boolean isEnabled(int paramInt)
  {
    int i = a();
    if (paramInt < i) {
      return ((ListView.FixedViewInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_Boolean;
    }
    int j = paramInt - i;
    paramInt = 0;
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null)
    {
      i = this.jdField_a_of_type_AndroidWidgetListAdapter.getCount();
      paramInt = i;
      if (j < i) {
        return this.jdField_a_of_type_AndroidWidgetListAdapter.isEnabled(j);
      }
    }
    try
    {
      boolean bool = ((ListView.FixedViewInfo)this.jdField_b_of_type_JavaUtilArrayList.get(j - paramInt)).jdField_a_of_type_Boolean;
      return bool;
    }
    catch (Exception localException)
    {
      throw new RuntimeException("adapter index out of bound. adapter count: " + paramInt + ", footCount: " + this.jdField_b_of_type_JavaUtilArrayList.size() + " , position: " + j + ", Adapter: " + this.jdField_a_of_type_AndroidWidgetListAdapter);
    }
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.registerDataSetObserver(paramDataSetObserver);
    }
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver)
  {
    if (this.jdField_a_of_type_AndroidWidgetListAdapter != null) {
      this.jdField_a_of_type_AndroidWidgetListAdapter.unregisterDataSetObserver(paramDataSetObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.HeaderViewListAdapter
 * JD-Core Version:    0.7.0.1
 */