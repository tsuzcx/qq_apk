package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.ViewGroup;

abstract class s<_Data, _ViewHolder extends RecyclerView.w>
{
  public abstract _ViewHolder a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public boolean b(_ViewHolder param_ViewHolder, Object paramObject)
  {
    return false;
  }
  
  public abstract void c(_ViewHolder param_ViewHolder, _Data param_Data);
  
  public abstract long cE(_Data param_Data);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.s
 * JD-Core Version:    0.7.0.1
 */