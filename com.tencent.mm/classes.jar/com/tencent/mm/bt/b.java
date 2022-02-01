package com.tencent.mm.bt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.i;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.api.w;
import com.tencent.mm.cache.f;

public abstract interface b
{
  public abstract boolean Z(MotionEvent paramMotionEvent);
  
  public abstract f a(com.tencent.mm.e.a parama);
  
  public abstract void a(Editable paramEditable, int paramInt1, int paramInt2);
  
  public abstract void a(ac.a parama);
  
  public abstract void a(w paramw, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.view.a parama);
  
  public abstract boolean aAx();
  
  public abstract void aY(String paramString, int paramInt1, int paramInt2);
  
  public abstract <T extends com.tencent.mm.e.b> T c(i parami);
  
  public abstract void d(t paramt);
  
  public abstract void dG(float paramFloat);
  
  public abstract ac.a getConfig();
  
  public abstract float getCurScale();
  
  public abstract i[] getFeatures();
  
  public abstract float getInitScale();
  
  public abstract aa getSelectedFeatureListener();
  
  public abstract boolean iPl();
  
  public abstract void iPm();
  
  public abstract void iPn();
  
  public abstract com.tencent.mm.view.a iPo();
  
  public abstract <T extends com.tencent.mm.e.b> T iPp();
  
  public abstract float iPq();
  
  public abstract void iPr();
  
  public abstract boolean iPs();
  
  public abstract void iPt();
  
  public abstract Bitmap iPu();
  
  public abstract boolean iPv();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestroy();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void onExit();
  
  public abstract void onFinish();
  
  public abstract void r(String paramString1, int paramInt1, int paramInt2, String paramString2);
  
  public abstract void setActionBarCallback(k paramk);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setInitScale(float paramFloat);
  
  public abstract void setOutputSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */