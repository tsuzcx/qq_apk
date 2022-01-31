package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class a
{
  public String TAG = "FaceReflectBaseUI";
  protected com.tencent.mm.plugin.facedetectlight.ui.container.a mrz;
  protected ViewGroup uR;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    this.uR = paramViewGroup;
    this.mrz = parama;
    this.TAG = getClass().getSimpleName();
    LayoutInflater.from(this.uR.getContext()).inflate(bvM(), this.uR, true);
    initView();
  }
  
  public abstract int bvM();
  
  public final View findViewById(int paramInt)
  {
    return this.uR.findViewById(paramInt);
  }
  
  public abstract void initView();
  
  public final void setVisibility(int paramInt)
  {
    this.uR.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */