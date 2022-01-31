package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;

abstract class t<_Data, _ViewHolder extends RecyclerView.v>
{
  public abstract _ViewHolder a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public boolean b(_ViewHolder param_ViewHolder, Object paramObject)
  {
    return false;
  }
  
  public abstract long bp(_Data param_Data);
  
  public abstract void c(_ViewHolder param_ViewHolder, _Data param_Data);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.t
 * JD-Core Version:    0.7.0.1
 */