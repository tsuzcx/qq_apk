package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.ViewGroup;

abstract class s<_Data, _ViewHolder extends RecyclerView.v>
{
  public abstract _ViewHolder a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public boolean a(_ViewHolder param_ViewHolder, Object paramObject)
  {
    return false;
  }
  
  public abstract void b(_ViewHolder param_ViewHolder, _Data param_Data);
  
  public abstract long cL(_Data param_Data);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.s
 * JD-Core Version:    0.7.0.1
 */