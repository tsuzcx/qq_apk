package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.g.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract interface b
  extends h
{
  public abstract void Ih(String paramString);
  
  public abstract void Ii(String paramString);
  
  public abstract boolean Ij(String paramString);
  
  public abstract boolean Il(String paramString);
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(double paramDouble1, double paramDouble2, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean);
  
  public abstract void a(b paramb);
  
  public abstract void a(j paramj, a parama);
  
  public abstract void a(k paramk);
  
  public abstract void a(l paraml);
  
  public abstract void a(n paramn);
  
  public abstract void a(o paramo);
  
  public abstract void a(q paramq);
  
  public abstract void a(u paramu);
  
  public abstract void a(v paramv);
  
  public abstract void a(x paramx);
  
  public abstract void a(String paramString, int paramInt, h paramh, boolean paramBoolean);
  
  public abstract void a(String paramString, t paramt);
  
  public abstract void a(String paramString, t paramt, a parama);
  
  public abstract void a(String paramString, ArrayList<h> paramArrayList, long paramLong, boolean paramBoolean, p paramp);
  
  public abstract void a(String paramString, LinkedList<g> paramLinkedList, p paramp);
  
  public abstract boolean a(c paramc, b.m paramm, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(y paramy);
  
  public abstract void baA();
  
  public abstract z baq();
  
  public abstract void bar();
  
  public abstract e bas();
  
  public abstract boolean bat();
  
  public abstract h bau();
  
  public abstract void bav();
  
  public abstract void baw();
  
  public abstract void bax();
  
  public abstract void bay();
  
  public abstract void baz();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void cT(String paramString1, String paramString2);
  
  public abstract void f(double paramDouble1, double paramDouble2);
  
  public abstract void fY(boolean paramBoolean);
  
  public abstract void fZ(boolean paramBoolean);
  
  public abstract void g(SurfaceTexture paramSurfaceTexture);
  
  public abstract void ga(boolean paramBoolean);
  
  public abstract void gb(boolean paramBoolean);
  
  public abstract void gc(boolean paramBoolean);
  
  public abstract void gd(boolean paramBoolean);
  
  public abstract void ge(boolean paramBoolean);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void gf(boolean paramBoolean);
  
  public abstract void gg(boolean paramBoolean);
  
  public abstract void gh(boolean paramBoolean);
  
  public abstract void gi(boolean paramBoolean);
  
  public abstract void gj(boolean paramBoolean);
  
  public abstract void h(List<h> paramList, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setMapStyle(int paramInt);
  
  public static final class a
  {
    b.h jUP;
    public float jUQ;
    public float skew;
    public float zoom;
  }
  
  public static final class aa
  {
    public b.i jVv;
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
    public String jUR;
    public boolean jUS;
    public int left;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    public float jUQ;
    public String jUR;
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
    public String buildingId;
    public String buildingName;
    public List<b.f> jUT;
    public int jUU;
  }
  
  public static final class f
  {
    public String floorName;
  }
  
  public static final class g
  {
    public int duration;
    public float jUQ;
    public double jUV;
    public double jUW;
    public double latitude;
    public double longitude;
  }
  
  public static class h
  {
    public double latitude;
    public double longitude;
    
    public h(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class i
  {
    public b.h jUX;
    public b.h jUY;
  }
  
  public static final class j
  {
    public int borderColor;
    public int borderWidth;
    public String buildingId;
    public int color;
    public String floorName;
    public String id;
    public List<b.h> jUZ;
    public boolean jVa;
    public boolean jVb;
    public String jVc;
    public int jVd;
    public int style;
    public int width;
  }
  
  public static abstract interface k
  {
    public abstract void a(b.s params);
  }
  
  public static abstract interface l
  {
    public abstract void e(double paramDouble1, double paramDouble2);
  }
  
  public static abstract interface n
  {
    public abstract boolean c(b.s params);
  }
  
  public static abstract interface o
  {
    public abstract boolean b(b.s params);
  }
  
  public static abstract interface p
  {
    public abstract void bal();
    
    public abstract void fX(boolean paramBoolean);
  }
  
  public static abstract interface q
  {
    public abstract void d(double paramDouble1, double paramDouble2);
  }
  
  public static final class r
  {
    public String buildingId;
    public String floorName;
    public double latitude;
    public double longitude;
    public String name;
  }
  
  public static class s
  {
    public String data;
    public b.t jVe;
  }
  
  public static final class t
  {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public float jUQ;
    public String jUR;
    public float jVf;
    public float jVg;
    public String jVh;
    public a jVi;
    public b jVj;
    public double latitude;
    public double longitude;
    public String title;
    public int zIndex;
    
    public final void E(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int jVs = 0;
      public static int jVt = 1;
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      String iZu;
      int jVk;
      int jVl;
      int jVm;
      int jVn;
      int jVo;
      public int jVp;
      public int jVq;
      public int jVr;
      int padding;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.jVk = paramInt2;
        this.jVl = paramInt3;
        this.borderWidth = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.jVm = paramInt9;
        this.jVn = paramInt10;
        this.jVo = paramInt11;
        this.jVp = paramInt12;
        this.iZu = paramString2;
        this.jVq = paramInt13;
        this.jVr = paramInt14;
      }
    }
    
    public static final class b
    {
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      String iZu;
      int jVk;
      int jVl;
      int padding;
      int x;
      int y;
      
      public b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.jVk = paramInt2;
        this.x = paramInt3;
        this.y = paramInt4;
        this.bgColor = paramInt5;
        this.jVl = paramInt6;
        this.borderWidth = paramInt7;
        this.borderColor = paramInt8;
        this.iZu = paramString2;
        this.padding = paramInt9;
      }
    }
  }
  
  public static abstract interface u
  {
    public abstract void a(b.a parama, boolean paramBoolean);
    
    public abstract void b(b.a parama, boolean paramBoolean);
  }
  
  public static abstract interface v
  {
    public abstract void a(b.e parame);
  }
  
  public static abstract interface w {}
  
  public static abstract interface x
  {
    public abstract void a(b.r paramr);
  }
  
  public static final class y
  {
    public int fillColor;
    public List<b.h> jUZ;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class z
  {
    public b.aa jVu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.b
 * JD-Core Version:    0.7.0.1
 */