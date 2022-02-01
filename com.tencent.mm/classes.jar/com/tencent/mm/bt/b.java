package com.tencent.mm.bt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.g;
import com.tencent.mm.api.i;
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y.a;
import com.tencent.mm.cache.f;

public abstract interface b
{
  public abstract boolean Kc();
  
  public abstract boolean N(MotionEvent paramMotionEvent);
  
  public abstract f a(com.tencent.mm.e.a parama);
  
  public abstract void a(Editable paramEditable, int paramInt1, int paramInt2);
  
  public abstract void a(s params, boolean paramBoolean);
  
  public abstract void a(y.a parama);
  
  public abstract void a(com.tencent.mm.view.a parama);
  
  public abstract <T extends com.tencent.mm.e.b> T c(g paramg);
  
  public abstract void c(p paramp);
  
  public abstract boolean fjE();
  
  public abstract void fjF();
  
  public abstract void fjG();
  
  public abstract com.tencent.mm.view.a fjH();
  
  public abstract <T extends com.tencent.mm.e.b> T fjI();
  
  public abstract void fjJ();
  
  public abstract Bitmap fjK();
  
  public abstract boolean fjL();
  
  public abstract y.a getConfig();
  
  public abstract float getCurScale();
  
  public abstract g[] getFeatures();
  
  public abstract float getInitScale();
  
  public abstract w getSelectedFeatureListener();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestroy();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void onExit();
  
  public abstract void onFinish();
  
  public abstract void setActionBarCallback(i parami);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setInitScale(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */