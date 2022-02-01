package com.tencent.mm.plugin.ball.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public abstract interface f
{
  public abstract void a(a parama);
  
  public abstract void a(b paramb);
  
  public abstract boolean aGg();
  
  public abstract boolean bCI();
  
  public abstract ViewGroup chG();
  
  public abstract int chH();
  
  public abstract Activity getActivity();
  
  public abstract Bitmap getBitmap();
  
  public abstract View getContentView();
  
  public abstract Intent getIntent();
  
  public abstract View getMaskView();
  
  public abstract void hb(boolean paramBoolean);
  
  public static abstract interface a
  {
    public abstract void aY(float paramFloat);
    
    public abstract int jJ(boolean paramBoolean);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  public static abstract interface b
  {
    public abstract void ei(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.f
 * JD-Core Version:    0.7.0.1
 */