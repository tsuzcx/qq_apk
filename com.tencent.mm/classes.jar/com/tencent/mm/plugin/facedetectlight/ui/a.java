package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class a
{
  protected ViewGroup DV;
  public String TAG = "FaceReflectBaseUI";
  protected com.tencent.mm.plugin.facedetectlight.ui.container.a rqH;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    this.DV = paramViewGroup;
    this.rqH = parama;
    this.TAG = getClass().getSimpleName();
    LayoutInflater.from(this.DV.getContext()).inflate(cus(), this.DV, true);
    initView();
  }
  
  public abstract int cus();
  
  public final View findViewById(int paramInt)
  {
    return this.DV.findViewById(paramInt);
  }
  
  public abstract void initView();
  
  public final void setVisibility(int paramInt)
  {
    this.DV.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */