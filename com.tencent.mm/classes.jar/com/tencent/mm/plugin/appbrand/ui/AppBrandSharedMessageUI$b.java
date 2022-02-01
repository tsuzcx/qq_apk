package com.tencent.mm.plugin.appbrand.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandSharedMessageUI$b
  extends BaseAdapter
{
  private LayoutInflater mInflater;
  
  public AppBrandSharedMessageUI$b(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
  }
  
  public final int getCount()
  {
    return 0;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(48787);
    paramInt = super.getItemViewType(paramInt);
    AppMethodBeat.o(48787);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandSharedMessageUI.b
 * JD-Core Version:    0.7.0.1
 */