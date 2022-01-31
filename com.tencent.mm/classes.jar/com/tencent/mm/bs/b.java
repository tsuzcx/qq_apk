package com.tencent.mm.bs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.g;
import com.tencent.mm.api.k;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s.a;

public abstract interface b
{
  public abstract boolean K(MotionEvent paramMotionEvent);
  
  public abstract com.tencent.mm.cache.e a(com.tencent.mm.e.a parama);
  
  public abstract void a(Editable paramEditable, int paramInt1, int paramInt2);
  
  public abstract void a(n paramn, boolean paramBoolean);
  
  public abstract void a(s.a parama);
  
  public abstract void a(com.tencent.mm.view.a parama);
  
  public abstract <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.e parame);
  
  public abstract void d(k paramk);
  
  public abstract void dqb();
  
  public abstract com.tencent.mm.view.a dqc();
  
  public abstract <T extends com.tencent.mm.e.b> T dqd();
  
  public abstract void dqe();
  
  public abstract Bitmap dqf();
  
  public abstract boolean dqg();
  
  public abstract s.a getConfig();
  
  public abstract Context getContext();
  
  public abstract float getCurScale();
  
  public abstract com.tencent.mm.api.e[] getFeatures();
  
  public abstract float getInitScale();
  
  public abstract r getSelectedFeatureListener();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestroy();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void onExit();
  
  public abstract void onFinish();
  
  public abstract void setActionBarCallback(g paramg);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract boolean zY();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bs.b
 * JD-Core Version:    0.7.0.1
 */