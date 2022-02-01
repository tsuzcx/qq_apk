package com.tencent.mm.plugin.appbrand.jsapi.f.a;

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
  public abstract void Mm(String paramString);
  
  public abstract void Mn(String paramString);
  
  public abstract boolean Mo(String paramString);
  
  public abstract boolean Mq(String paramString);
  
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
  
  public abstract void a(String paramString, ArrayList<h> paramArrayList, long paramLong, boolean paramBoolean, b.p paramp);
  
  public abstract void a(String paramString, LinkedList<g> paramLinkedList, b.p paramp);
  
  public abstract boolean a(c paramc, m paramm, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(y paramy);
  
  public abstract z bhj();
  
  public abstract void bhk();
  
  public abstract e bhl();
  
  public abstract boolean bhm();
  
  public abstract h bhn();
  
  public abstract void bho();
  
  public abstract void bhp();
  
  public abstract void bhq();
  
  public abstract void bhr();
  
  public abstract void bhs();
  
  public abstract void bht();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void de(String paramString1, String paramString2);
  
  public abstract void f(double paramDouble1, double paramDouble2);
  
  public abstract void g(SurfaceTexture paramSurfaceTexture);
  
  public abstract void gA(boolean paramBoolean);
  
  public abstract void gB(boolean paramBoolean);
  
  public abstract void gC(boolean paramBoolean);
  
  public abstract void gD(boolean paramBoolean);
  
  public abstract void gE(boolean paramBoolean);
  
  public abstract void gF(boolean paramBoolean);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void gu(boolean paramBoolean);
  
  public abstract void gv(boolean paramBoolean);
  
  public abstract void gw(boolean paramBoolean);
  
  public abstract void gx(boolean paramBoolean);
  
  public abstract void gy(boolean paramBoolean);
  
  public abstract void gz(boolean paramBoolean);
  
  public abstract void h(List<h> paramList, int paramInt);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public static final class a
  {
    b.h kvA;
    public float kvB;
    public float skew;
    public float zoom;
  }
  
  public static final class aa
  {
    public b.i kwh;
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
    public String kvC;
    public boolean kvD;
    public int left;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    public float kvB;
    public String kvC;
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
    public List<b.f> kvE;
    public int kvF;
  }
  
  public static final class f
  {
    public String floorName;
  }
  
  public static final class g
  {
    public int duration;
    public float kvB;
    public double kvG;
    public double kvH;
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
    public b.h kvI;
    public b.h kvJ;
  }
  
  public static final class j
  {
    public int borderColor;
    public int borderWidth;
    public String buildingId;
    public int color;
    public String floorName;
    public String id;
    public List<b.h> kvK;
    public boolean kvL;
    public boolean kvM;
    public String kvN;
    public int kvO;
    public List<Integer> kvP;
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
  
  public static abstract interface m
  {
    public abstract void Ml(String paramString);
  }
  
  public static abstract interface n
  {
    public abstract boolean c(b.s params);
  }
  
  public static abstract interface o
  {
    public abstract boolean b(b.s params);
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
    public b.t kvQ;
  }
  
  public static final class t
  {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public float kvB;
    public String kvC;
    public float kvR;
    public float kvS;
    public String kvT;
    public a kvU;
    public b.t.b kvV;
    public double latitude;
    public double longitude;
    public String title;
    public int zIndex;
    
    public final void H(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int kwe = 0;
      public static int kwf = 1;
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      String jzJ;
      int kvW;
      int kvX;
      int kvY;
      int kvZ;
      int kwa;
      public int kwb;
      public int kwc;
      public int kwd;
      int padding;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.kvW = paramInt2;
        this.kvX = paramInt3;
        this.borderWidth = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.kvY = paramInt9;
        this.kvZ = paramInt10;
        this.kwa = paramInt11;
        this.kwb = paramInt12;
        this.jzJ = paramString2;
        this.kwc = paramInt13;
        this.kwd = paramInt14;
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
  
  public static abstract interface x
  {
    public abstract void a(b.r paramr);
  }
  
  public static final class y
  {
    public int fillColor;
    public List<b.h> kvK;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class z
  {
    public b.aa kwg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.f.a.b
 * JD-Core Version:    0.7.0.1
 */