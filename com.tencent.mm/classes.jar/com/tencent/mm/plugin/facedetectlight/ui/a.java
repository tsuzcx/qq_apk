package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class a
{
  protected ViewGroup Bf;
  public String TAG = "FaceReflectBaseUI";
  protected com.tencent.mm.plugin.facedetectlight.ui.container.a pYb;
  
  public a(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    this.Bf = paramViewGroup;
    this.pYb = parama;
    this.TAG = getClass().getSimpleName();
    LayoutInflater.from(this.Bf.getContext()).inflate(chg(), this.Bf, true);
    initView();
  }
  
  public abstract int chg();
  
  public final View findViewById(int paramInt)
  {
    return this.Bf.findViewById(paramInt);
  }
  
  public abstract void initView();
  
  public final void setVisibility(int paramInt)
  {
    this.Bf.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.a
 * JD-Core Version:    0.7.0.1
 */