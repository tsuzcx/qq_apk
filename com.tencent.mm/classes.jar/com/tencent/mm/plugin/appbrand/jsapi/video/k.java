package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.view.GestureDetector;
import android.view.View;

public final class k
{
  int Cv = 0;
  float gCn = 0.0F;
  View gES;
  k.a gET = k.a.gFb;
  GestureDetector gEU;
  b gEV;
  float gEW = 0.0F;
  int gEX = -1;
  int gEY = 0;
  Runnable gEZ = new k.1(this);
  Context mContext;
  
  public k(Context paramContext, View paramView, b paramb)
  {
    this.mContext = paramContext;
    this.gEV = paramb;
    this.gES = paramView;
    this.gEU = new GestureDetector(this.mContext, new k.2(this));
    this.gCn = l.cn(paramContext);
  }
  
  public static abstract interface b
  {
    public abstract void ah(float paramFloat);
    
    public abstract void ai(float paramFloat);
    
    public abstract void akl();
    
    public abstract void akm();
    
    public abstract void akn();
    
    public abstract void ako();
    
    public abstract void akp();
    
    public abstract boolean akq();
    
    public abstract boolean akr();
    
    public abstract boolean aks();
    
    public abstract int f(int paramInt, float paramFloat);
    
    public abstract void g(int paramInt, float paramFloat);
    
    public abstract int getCurrentPosition();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.k
 * JD-Core Version:    0.7.0.1
 */