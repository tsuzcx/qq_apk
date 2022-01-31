package com.tencent.mm.bt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.f;
import com.tencent.mm.api.j;
import com.tencent.mm.api.m;
import com.tencent.mm.api.p;
import com.tencent.mm.api.q.a;

public abstract interface b
{
  public abstract boolean A(MotionEvent paramMotionEvent);
  
  public abstract com.tencent.mm.cache.d a(com.tencent.mm.e.a parama);
  
  public abstract void a(Editable paramEditable, int paramInt1, int paramInt2);
  
  public abstract void a(m paramm, boolean paramBoolean);
  
  public abstract void a(q.a parama);
  
  public abstract void a(com.tencent.mm.view.a parama);
  
  public abstract <T extends com.tencent.mm.e.b> T b(com.tencent.mm.api.d paramd);
  
  public abstract void coG();
  
  public abstract com.tencent.mm.view.a coH();
  
  public abstract <T extends com.tencent.mm.e.b> T coI();
  
  public abstract Bitmap coJ();
  
  public abstract boolean coK();
  
  public abstract void d(j paramj);
  
  public abstract q.a getConfig();
  
  public abstract Context getContext();
  
  public abstract float getCurScale();
  
  public abstract com.tencent.mm.api.d[] getFeatures();
  
  public abstract float getInitScale();
  
  public abstract p getSelectedFeatureListener();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestroy();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void onFinish();
  
  public abstract boolean rG();
  
  public abstract void rX();
  
  public abstract void setActionBarCallback(f paramf);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */