package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.f.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract interface b
  extends h
{
  public abstract void PI(String paramString);
  
  public abstract void PJ(String paramString);
  
  public abstract boolean PK(String paramString);
  
  public abstract boolean PM(String paramString);
  
  public abstract Point a(i parami);
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(k paramk, a parama);
  
  public abstract void a(l paraml);
  
  public abstract void a(m paramm);
  
  public abstract void a(o paramo);
  
  public abstract void a(p paramp);
  
  public abstract void a(s params);
  
  public abstract void a(b.w paramw);
  
  public abstract void a(x paramx);
  
  public abstract void a(z paramz);
  
  public abstract void a(String paramString, int paramInt, i parami, boolean paramBoolean);
  
  public abstract void a(String paramString, v paramv);
  
  public abstract void a(String paramString, v paramv, a parama);
  
  public abstract void a(String paramString, ArrayList<i> paramArrayList, long paramLong, boolean paramBoolean, b.r paramr);
  
  public abstract void a(String paramString, LinkedList<h> paramLinkedList, b.r paramr);
  
  public abstract boolean a(int paramInt, e parame, a parama);
  
  public abstract boolean a(ab paramab);
  
  public abstract boolean a(c paramc, b.n paramn, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, b.q paramq);
  
  public abstract boolean b(int paramInt, e parame, a parama);
  
  public abstract ac bkO();
  
  public abstract void bkP();
  
  public abstract f bkQ();
  
  public abstract boolean bkR();
  
  public abstract i bkS();
  
  public abstract void bkT();
  
  public abstract void bkU();
  
  public abstract void bkV();
  
  public abstract void bkW();
  
  public abstract void bkX();
  
  public abstract void bkY();
  
  public abstract boolean bla();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract i d(Point paramPoint);
  
  public abstract void dh(String paramString1, String paramString2);
  
  public abstract void f(double paramDouble1, double paramDouble2);
  
  public abstract void g(SurfaceTexture paramSurfaceTexture);
  
  public abstract void gA(boolean paramBoolean);
  
  public abstract void gB(boolean paramBoolean);
  
  public abstract void gC(boolean paramBoolean);
  
  public abstract void gD(boolean paramBoolean);
  
  public abstract void gE(boolean paramBoolean);
  
  public abstract void gF(boolean paramBoolean);
  
  public abstract void gG(boolean paramBoolean);
  
  public abstract void gH(boolean paramBoolean);
  
  public abstract void gI(boolean paramBoolean);
  
  public abstract void gJ(boolean paramBoolean);
  
  public abstract void gK(boolean paramBoolean);
  
  public abstract void gL(boolean paramBoolean);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void h(List<i> paramList, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public abstract boolean tg(int paramInt);
  
  public static final class a
  {
    b.i kRC;
    public float kRD;
    public float skew;
    public float zoom;
  }
  
  public static final class ab
  {
    public int fillColor;
    public List<b.i> kRO;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class ac
  {
    public b.ad kSm;
  }
  
  public static final class ad
  {
    public b.j kSn;
  }
  
  public static final class b
  {
    public int fillColor;
    public double latitude;
    public double longitude;
    public int radius;
    public int strokeColor;
    public int strokeWidth;
  }
  
  public static final class c
  {
    public String data;
    public int height;
    public String kRE;
    public boolean kRF;
    public int left;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    public float kRD;
    public String kRE;
    double latitude;
    double longitude;
    
    public final void g(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class e
  {
    public float alpha;
    public String kRE;
    public b.i kRG;
    public b.i kRH;
    public boolean visible;
    public int zIndex;
  }
  
  public static final class f
  {
    public String buildingId;
    public String buildingName;
    public List<b.g> kRI;
    public int kRJ;
  }
  
  public static final class g
  {
    public String floorName;
  }
  
  public static final class h
  {
    public int duration;
    public float kRD;
    public double kRK;
    public double kRL;
    public double latitude;
    public double longitude;
  }
  
  public static class i
  {
    public double latitude;
    public double longitude;
    
    public i(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class j
  {
    public b.i kRM;
    public b.i kRN;
  }
  
  public static final class k
  {
    public int borderColor;
    public int borderWidth;
    public String buildingId;
    public int color;
    public String floorName;
    public String id;
    public List<b.i> kRO;
    public boolean kRP;
    public boolean kRQ;
    public String kRR;
    public int kRS;
    public List<Integer> kRT;
    public int style;
    public int width;
  }
  
  public static abstract interface l
  {
    public abstract void a(b.u paramu);
  }
  
  public static abstract interface m
  {
    public abstract void e(double paramDouble1, double paramDouble2);
  }
  
  public static abstract interface o
  {
    public abstract boolean c(b.u paramu);
  }
  
  public static abstract interface p
  {
    public abstract boolean b(b.u paramu);
  }
  
  public static abstract interface s
  {
    public abstract void d(double paramDouble1, double paramDouble2);
  }
  
  public static final class t
  {
    public String buildingId;
    public String floorName;
    public double latitude;
    public double longitude;
    public String name;
  }
  
  public static class u
  {
    public String data;
    public b.v kRU;
  }
  
  public static final class v
  {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public float kRD;
    public String kRE;
    public boolean kRV = false;
    public float kRW;
    public float kRX;
    public String kRY;
    public b.v.a kRZ;
    public int kRz = -1;
    public b.v.b kSa;
    public double latitude;
    public double longitude;
    public String title;
    public int zIndex;
    
    public final void I(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
  }
  
  public static abstract interface x
  {
    public abstract void a(b.f paramf);
  }
  
  public static abstract interface z
  {
    public abstract void a(b.t paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.b
 * JD-Core Version:    0.7.0.1
 */