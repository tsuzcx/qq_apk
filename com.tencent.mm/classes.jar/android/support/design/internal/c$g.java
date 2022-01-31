package android.support.design.internal;

import android.support.design.a.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

final class c$g
  extends c.j
{
  public c$g(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
  {
    super(paramLayoutInflater.inflate(a.h.design_navigation_item, paramViewGroup, false));
    this.aie.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.internal.c.g
 * JD-Core Version:    0.7.0.1
 */