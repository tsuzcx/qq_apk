package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.mm.plugin.appbrand.f.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract interface b
  extends h
{
  public abstract boolean AO(int paramInt);
  
  public abstract void AP(int paramInt);
  
  public abstract void B(MotionEvent paramMotionEvent);
  
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
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, v paramv);
  
  public abstract void a(String paramString, v paramv, a parama);
  
  public abstract void a(String paramString, ArrayList<i> paramArrayList, long paramLong, boolean paramBoolean, b.r paramr);
  
  public abstract void a(String paramString, LinkedList<h> paramLinkedList, b.r paramr);
  
  public abstract boolean a(int paramInt, e parame, a parama);
  
  public abstract boolean a(int paramInt1, i parami1, i parami2, i parami3, float paramFloat1, float paramFloat2, int paramInt2);
  
  public abstract boolean a(ab paramab);
  
  public abstract boolean a(c paramc, b.n paramn, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(j paramj);
  
  public abstract boolean a(String paramString1, int paramInt1, double paramDouble, int paramInt2, String paramString2);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, b.q paramq);
  
  public abstract void aaE(String paramString);
  
  public abstract void aaF(String paramString);
  
  public abstract boolean aaG(String paramString);
  
  public abstract boolean aaI(String paramString);
  
  public abstract boolean aaN(String paramString);
  
  public abstract boolean b(int paramInt, e parame, a parama);
  
  public abstract ac csJ();
  
  public abstract void csK();
  
  public abstract f csL();
  
  public abstract boolean csM();
  
  public abstract i csN();
  
  public abstract void csO();
  
  public abstract void csP();
  
  public abstract void csQ();
  
  public abstract void csR();
  
  public abstract void csS();
  
  public abstract void csT();
  
  public abstract boolean csV();
  
  public abstract boolean csW();
  
  public abstract void ec(String paramString1, String paramString2);
  
  public abstract i f(Point paramPoint);
  
  public abstract void g(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void i(double paramDouble1, double paramDouble2);
  
  public abstract void jA(boolean paramBoolean);
  
  public abstract void jB(boolean paramBoolean);
  
  public abstract void jq(boolean paramBoolean);
  
  public abstract void jr(boolean paramBoolean);
  
  public abstract void js(boolean paramBoolean);
  
  public abstract void jt(boolean paramBoolean);
  
  public abstract void ju(boolean paramBoolean);
  
  public abstract void jv(boolean paramBoolean);
  
  public abstract void jw(boolean paramBoolean);
  
  public abstract void jx(boolean paramBoolean);
  
  public abstract void jy(boolean paramBoolean);
  
  public abstract void jz(boolean paramBoolean);
  
  public abstract void m(Surface paramSurface);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void q(List<i> paramList, int paramInt);
  
  public abstract void setBuilding3dEffectEnable(boolean paramBoolean);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public static final class a
  {
    public float aBi;
    b.i sdK;
    public float skew;
    public float zoom;
  }
  
  public static final class ab
  {
    public int fillColor;
    public String sdL;
    public List<b.i> sdW;
    public int[] sev;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class ac
  {
    public b.ad sew;
  }
  
  public static final class ad
  {
    public b.j sey;
  }
  
  public static final class b
  {
    public int fillColor;
    public double latitude;
    public double longitude;
    public int radius;
    public String sdL;
    public int strokeColor;
    public int strokeWidth;
  }
  
  public static final class c
  {
    public String data;
    public int height;
    public int left;
    public String sdM;
    public boolean sdN;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    public float aBi;
    double latitude;
    double longitude;
    public String sdM;
    
    public final void j(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class e
  {
    public float alpha;
    public String sdM;
    public b.i sdO;
    public b.i sdP;
    public boolean visible;
    public int zIndex;
  }
  
  public static final class f
  {
    public String buildingId;
    public String buildingName;
    public List<b.g> sdQ;
    public int sdR;
  }
  
  public static final class g
  {
    public String floorName;
  }
  
  public static final class h
  {
    public float aBi;
    public int duration;
    public double latitude;
    public double longitude;
    public double sdS;
    public double sdT;
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
    public b.i sdU;
    public b.i sdV;
  }
  
  public static final class k
  {
    public int borderColor;
    public int borderWidth;
    public String buildingId;
    public int color;
    public boolean enableGradient;
    public String floorName;
    public String id;
    public String sdL;
    public List<b.i> sdW;
    public boolean sdX;
    public boolean sdY;
    public String sdZ;
    public int sea;
    public List<Integer> seb;
    public List<a> segmentTexts;
    public int style;
    public b textStyle;
    public int width;
    
    public static final class a
    {
      public int endIndex;
      public String name;
      public int startIndex;
    }
    
    public static class b
    {
      public int fontSize;
      public int strokeColor;
      public int textColor;
    }
  }
  
  public static abstract interface l
  {
    public abstract void a(b.u paramu);
  }
  
  public static abstract interface m
  {
    public abstract void h(double paramDouble1, double paramDouble2);
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
    public abstract void g(double paramDouble1, double paramDouble2);
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
    public b.v sec;
  }
  
  public static final class v
  {
    public float aBi;
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public double latitude;
    public double longitude;
    public int sdH = -1;
    public String sdM;
    public boolean sed = false;
    public float see;
    public float sef;
    public String seg;
    public String seh;
    public a sei;
    public b sej;
    public String title;
    public int zIndex;
    
    public final void ar(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int ses = 0;
      public static int set = 1;
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      int fontSize;
      int padding;
      String qTN;
      int sek;
      int sel;
      int sem;
      int sen;
      public int seo;
      public int sep;
      public int ser;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.fontSize = paramInt2;
        this.sek = paramInt3;
        this.borderWidth = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.sel = paramInt9;
        this.sem = paramInt10;
        this.sen = paramInt11;
        this.seo = paramInt12;
        this.qTN = paramString2;
        this.sep = paramInt13;
        this.ser = paramInt14;
      }
    }
    
    public static final class b
    {
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      public String content;
      int fontSize;
      public int height;
      int padding;
      String qTN;
      int sek;
      public int width;
      int x;
      int y;
      
      public b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.fontSize = paramInt2;
        this.x = paramInt3;
        this.y = paramInt4;
        this.bgColor = paramInt5;
        this.sek = paramInt6;
        this.borderWidth = paramInt7;
        this.borderColor = paramInt8;
        this.qTN = paramString2;
        this.padding = paramInt9;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.b
 * JD-Core Version:    0.7.0.1
 */