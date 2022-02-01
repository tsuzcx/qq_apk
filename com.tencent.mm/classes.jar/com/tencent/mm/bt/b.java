package com.tencent.mm.bt;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.h;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.cache.f;

public abstract interface b
{
  public abstract boolean R(MotionEvent paramMotionEvent);
  
  public abstract boolean Ul();
  
  public abstract f a(com.tencent.mm.e.a parama);
  
  public abstract void a(Editable paramEditable, int paramInt1, int paramInt2);
  
  public abstract void a(ab.a parama);
  
  public abstract void a(u paramu, boolean paramBoolean);
  
  public abstract void a(com.tencent.mm.view.a parama);
  
  public abstract void ate();
  
  public abstract <T extends com.tencent.mm.e.b> T c(h paramh);
  
  public abstract void c(r paramr);
  
  public abstract ab.a getConfig();
  
  public abstract float getCurScale();
  
  public abstract h[] getFeatures();
  
  public abstract float getInitScale();
  
  public abstract z getSelectedFeatureListener();
  
  public abstract boolean gte();
  
  public abstract void gtf();
  
  public abstract void gtg();
  
  public abstract com.tencent.mm.view.a gth();
  
  public abstract <T extends com.tencent.mm.e.b> T gti();
  
  public abstract void gtj();
  
  public abstract float gtk();
  
  public abstract void gtl();
  
  public abstract Bitmap gtm();
  
  public abstract boolean gtn();
  
  public abstract void onAttachedToWindow();
  
  public abstract void onDestroy();
  
  public abstract void onDraw(Canvas paramCanvas);
  
  public abstract void onExit();
  
  public abstract void onFinish();
  
  public abstract void setActionBarCallback(j paramj);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setInitScale(float paramFloat);
  
  public abstract void setOutputSize(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bt.b
 * JD-Core Version:    0.7.0.1
 */