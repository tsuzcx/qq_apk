package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class a
{
  protected ViewGroup Cd;
  public String TAG = "FaceReflectBaseUI";
  protected com.tencent.mm.plugin.facedetectlight.ui.container.a qGI;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    this.Cd = paramViewGroup;
    this.qGI = parama;
    this.TAG = getClass().getSimpleName();
    LayoutInflater.from(this.Cd.getContext()).inflate(coN(), this.Cd, true);
    initView();
  }
  
  public abstract int coN();
  
  public final View findViewById(int paramInt)
  {
    return this.Cd.findViewById(paramInt);
  }
  
  public abstract void initView();
  
  public final void setVisibility(int paramInt)
  {
    this.Cd.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */