package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.v;

abstract class r<_Data, _ViewHolder extends RecyclerView.v>
{
  public boolean a(_ViewHolder param_ViewHolder, Object paramObject)
  {
    return false;
  }
  
  public abstract _ViewHolder b(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public abstract void b(_ViewHolder param_ViewHolder, _Data param_Data);
  
  public abstract long ei(_Data param_Data);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.r
 * JD-Core Version:    0.7.0.1
 */