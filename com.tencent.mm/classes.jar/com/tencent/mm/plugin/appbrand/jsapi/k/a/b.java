package com.tencent.mm.plugin.appbrand.jsapi.k.a;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.f.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract interface b
  extends h
{
  public abstract void ZR(String paramString);
  
  public abstract void ZS(String paramString);
  
  public abstract boolean ZT(String paramString);
  
  public abstract boolean ZV(String paramString);
  
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
  
  public abstract void a(w paramw);
  
  public abstract void a(x paramx);
  
  public abstract void a(z paramz);
  
  public abstract void a(String paramString, int paramInt, i parami, boolean paramBoolean);
  
  public abstract void a(String paramString, v paramv);
  
  public abstract void a(String paramString, v paramv, a parama);
  
  public abstract void a(String paramString, ArrayList<i> paramArrayList, long paramLong, boolean paramBoolean, r paramr);
  
  public abstract void a(String paramString, LinkedList<b.h> paramLinkedList, r paramr);
  
  public abstract boolean a(int paramInt, e parame, a parama);
  
  public abstract boolean a(ab paramab);
  
  public abstract boolean a(c paramc, b.n paramn, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, q paramq);
  
  public abstract boolean b(int paramInt, e parame, a parama);
  
  public abstract ac bGU();
  
  public abstract void bGV();
  
  public abstract f bGW();
  
  public abstract boolean bGX();
  
  public abstract i bGY();
  
  public abstract void bGZ();
  
  public abstract void bHa();
  
  public abstract void bHb();
  
  public abstract void bHc();
  
  public abstract void bHd();
  
  public abstract void bHe();
  
  public abstract boolean bHg();
  
  public abstract boolean bHh();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void dy(String paramString1, String paramString2);
  
  public abstract i e(Point paramPoint);
  
  public abstract void f(double paramDouble1, double paramDouble2);
  
  public abstract void g(SurfaceTexture paramSurfaceTexture);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void h(List<i> paramList, int paramInt);
  
  public abstract void hA(boolean paramBoolean);
  
  public abstract void hB(boolean paramBoolean);
  
  public abstract void hC(boolean paramBoolean);
  
  public abstract void hD(boolean paramBoolean);
  
  public abstract void hE(boolean paramBoolean);
  
  public abstract void hF(boolean paramBoolean);
  
  public abstract void hG(boolean paramBoolean);
  
  public abstract void hH(boolean paramBoolean);
  
  public abstract void hw(boolean paramBoolean);
  
  public abstract void hx(boolean paramBoolean);
  
  public abstract void hy(boolean paramBoolean);
  
  public abstract void hz(boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setBuilding3dEffectEnable(boolean paramBoolean);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public abstract boolean xf(int paramInt);
  
  public static final class a
  {
    b.i mas;
    public float mat;
    public float skew;
    public float zoom;
  }
  
  public static final class aa
  {
    public String id;
    public b.i mbd;
  }
  
  public static final class ab
  {
    public int fillColor;
    public List<b.i> maG;
    public String mau;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class ac
  {
    public b.ad mbe;
  }
  
  public static final class ad
  {
    public b.j mbf;
  }
  
  public static final class b
  {
    public int fillColor;
    public double latitude;
    public double longitude;
    public String mau;
    public int radius;
    public int strokeColor;
    public int strokeWidth;
  }
  
  public static final class c
  {
    public String data;
    public int height;
    public int left;
    public String mav;
    public boolean maw;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    double latitude;
    double longitude;
    public float mat;
    public String mav;
    
    public final void g(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class e
  {
    public float alpha;
    public String mav;
    public b.i may;
    public b.i maz;
    public boolean visible;
    public int zIndex;
  }
  
  public static final class f
  {
    public String buildingId;
    public String buildingName;
    public List<b.g> maA;
    public int maB;
  }
  
  public static final class g
  {
    public String floorName;
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
    public b.i maE;
    public b.i maF;
  }
  
  public static final class k
  {
    public int borderColor;
    public String buildingId;
    public int color;
    public String floorName;
    public String id;
    public List<b.i> maG;
    public boolean maH;
    public boolean maI;
    public String maJ;
    public int maK;
    public List<Integer> maL;
    public String mau;
    public int rc;
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
  
  public static abstract interface q
  {
    public abstract void aa(JSONObject paramJSONObject);
    
    public abstract void p(JSONArray paramJSONArray);
  }
  
  public static abstract interface r
  {
    public abstract void bGP();
    
    public abstract void hv(boolean paramBoolean);
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
    public b.v maM;
  }
  
  public static final class v
  {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public double latitude;
    public double longitude;
    public boolean maN = false;
    public float maO;
    public float maP;
    public String maQ;
    public a maR;
    public b maS;
    public int mao = -1;
    public float mat;
    public String mav;
    public String title;
    public int zIndex;
    
    public final void M(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int mbb = 0;
      public static int mbc = 1;
      int bgColor;
      int borderColor;
      int color;
      String content;
      String kZR;
      int maT;
      int maU;
      int maV;
      int maW;
      int maX;
      public int maY;
      public int maZ;
      public int mba;
      int padding;
      int rc;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.maT = paramInt2;
        this.maU = paramInt3;
        this.rc = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.maV = paramInt9;
        this.maW = paramInt10;
        this.maX = paramInt11;
        this.maY = paramInt12;
        this.kZR = paramString2;
        this.maZ = paramInt13;
        this.mba = paramInt14;
      }
    }
    
    public static final class b
    {
      int bgColor;
      int borderColor;
      int color;
      String content;
      public int height;
      String kZR;
      int maT;
      int maU;
      int padding;
      int rc;
      public int width;
      int x;
      int y;
      
      public b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.maT = paramInt2;
        this.x = paramInt3;
        this.y = paramInt4;
        this.bgColor = paramInt5;
        this.maU = paramInt6;
        this.rc = paramInt7;
        this.borderColor = paramInt8;
        this.kZR = paramString2;
        this.padding = paramInt9;
      }
    }
  }
  
  public static abstract interface w
  {
    public abstract void a(b.a parama, boolean paramBoolean);
    
    public abstract void b(b.a parama, boolean paramBoolean);
  }
  
  public static abstract interface x
  {
    public abstract void a(b.f paramf);
  }
  
  public static abstract interface y {}
  
  public static abstract interface z
  {
    public abstract void a(b.t paramt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.a.b
 * JD-Core Version:    0.7.0.1
 */