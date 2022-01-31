package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.e.a;
import java.util.LinkedList;
import java.util.List;

public abstract interface b
  extends h
{
  public abstract boolean Cg(String paramString);
  
  public abstract boolean Ci(String paramString);
  
  public abstract void L(float paramFloat1, float paramFloat2);
  
  public abstract void M(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5);
  
  public abstract void a(b.b paramb);
  
  public abstract void a(b.j paramj, a parama);
  
  public abstract void a(b.k paramk);
  
  public abstract void a(b.l paraml);
  
  public abstract void a(b.n paramn);
  
  public abstract void a(b.s params);
  
  public abstract void a(b.t paramt);
  
  public abstract void a(b.v paramv);
  
  public abstract void a(String paramString, int paramInt, b.h paramh, boolean paramBoolean);
  
  public abstract void a(String paramString, b.r paramr, a parama);
  
  public abstract void a(String paramString, LinkedList<b.g> paramLinkedList, o paramo);
  
  public abstract boolean a(b.c paramc, b.m paramm, a parama);
  
  public abstract boolean a(b.d paramd, a parama);
  
  public abstract boolean a(b.w paramw);
  
  public abstract void aDA();
  
  public abstract void aDB();
  
  public abstract void aDC();
  
  public abstract void aDD();
  
  public abstract void aDE();
  
  public abstract b.x aDt();
  
  public abstract void aDu();
  
  public abstract float aDv();
  
  public abstract b.e aDw();
  
  public abstract boolean aDx();
  
  public abstract b.h aDy();
  
  public abstract void aDz();
  
  public abstract void ar(float paramFloat);
  
  public abstract void as(float paramFloat);
  
  public abstract void at(float paramFloat);
  
  public abstract void ck(String paramString1, String paramString2);
  
  public abstract void ej(boolean paramBoolean);
  
  public abstract void ek(boolean paramBoolean);
  
  public abstract void el(boolean paramBoolean);
  
  public abstract void em(boolean paramBoolean);
  
  public abstract void en(boolean paramBoolean);
  
  public abstract void eo(boolean paramBoolean);
  
  public abstract void ep(boolean paramBoolean);
  
  public abstract void eq(boolean paramBoolean);
  
  public abstract void er(boolean paramBoolean);
  
  public abstract void es(boolean paramBoolean);
  
  public abstract void et(boolean paramBoolean);
  
  public abstract void eu(boolean paramBoolean);
  
  public abstract void g(SurfaceTexture paramSurfaceTexture);
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract int getZoomLevel();
  
  public abstract void h(List<b.h> paramList, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public static abstract interface o
  {
    public abstract void ei(boolean paramBoolean);
  }
  
  public static final class r$b
  {
    int bgColor;
    int borderColor;
    int borderWidth;
    int color;
    String content;
    int hPx;
    int hPy;
    String hfl;
    int padding;
    int x;
    int y;
    
    public r$b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
    {
      this.content = paramString1;
      this.color = paramInt1;
      this.hPx = paramInt2;
      this.x = paramInt3;
      this.y = paramInt4;
      this.bgColor = paramInt5;
      this.hPy = paramInt6;
      this.borderWidth = paramInt7;
      this.borderColor = paramInt8;
      this.hfl = paramString2;
      this.padding = paramInt9;
    }
  }
  
  public static abstract interface u {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.b
 * JD-Core Version:    0.7.0.1
 */