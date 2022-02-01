package com.tencent.mm.plugin.appbrand.jsapi.i.a;

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
  public abstract void Qq(String paramString);
  
  public abstract void Qr(String paramString);
  
  public abstract boolean Qs(String paramString);
  
  public abstract boolean Qu(String paramString);
  
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
  
  public abstract void a(String paramString, LinkedList<h> paramLinkedList, r paramr);
  
  public abstract boolean a(int paramInt, e parame, a parama);
  
  public abstract boolean a(ab paramab);
  
  public abstract boolean a(c paramc, b.n paramn, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, q paramq);
  
  public abstract boolean b(int paramInt, e parame, a parama);
  
  public abstract f blA();
  
  public abstract boolean blB();
  
  public abstract i blC();
  
  public abstract void blD();
  
  public abstract void blE();
  
  public abstract void blF();
  
  public abstract void blG();
  
  public abstract void blH();
  
  public abstract void blI();
  
  public abstract boolean blK();
  
  public abstract ac bly();
  
  public abstract void blz();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract i d(Point paramPoint);
  
  public abstract void dj(String paramString1, String paramString2);
  
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
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void gz(boolean paramBoolean);
  
  public abstract void h(List<i> paramList, int paramInt);
  
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
  
  public abstract boolean tj(int paramInt);
  
  public static final class a
  {
    b.i kVk;
    public float kVl;
    public float skew;
    public float zoom;
  }
  
  public static final class aa
  {
    public String id;
    public b.i kVU;
  }
  
  public static final class ab
  {
    public int fillColor;
    public String kVm;
    public List<b.i> kVx;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class ac
  {
    public b.ad kVV;
  }
  
  public static final class ad
  {
    public b.j kVW;
  }
  
  public static final class b
  {
    public int fillColor;
    public String kVm;
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
    public String kVn;
    public boolean kVo;
    public int left;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    public float kVl;
    public String kVn;
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
    public String kVn;
    public b.i kVp;
    public b.i kVq;
    public boolean visible;
    public int zIndex;
  }
  
  public static final class f
  {
    public String buildingId;
    public String buildingName;
    public List<b.g> kVr;
    public int kVs;
  }
  
  public static final class g
  {
    public String floorName;
  }
  
  public static final class h
  {
    public int duration;
    public float kVl;
    public double kVt;
    public double kVu;
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
    public b.i kVv;
    public b.i kVw;
  }
  
  public static final class k
  {
    public int borderColor;
    public int borderWidth;
    public String buildingId;
    public int color;
    public String floorName;
    public String id;
    public String kVA;
    public int kVB;
    public List<Integer> kVC;
    public String kVm;
    public List<b.i> kVx;
    public boolean kVy;
    public boolean kVz;
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
    public abstract void R(JSONObject paramJSONObject);
    
    public abstract void p(JSONArray paramJSONArray);
  }
  
  public static abstract interface r
  {
    public abstract void blt();
    
    public abstract void gy(boolean paramBoolean);
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
    public b.v kVD;
  }
  
  public static final class v
  {
    public float alpha;
    public float anchorX;
    public float anchorY;
    public String buildingId;
    public String data;
    public String floorName;
    public boolean kVE = false;
    public float kVF;
    public float kVG;
    public String kVH;
    public a kVI;
    public b kVJ;
    public int kVh = -1;
    public float kVl;
    public String kVn;
    public double latitude;
    public double longitude;
    public String title;
    public int zIndex;
    
    public final void I(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int kVS = 0;
      public static int kVT = 1;
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      String jWV;
      int kVK;
      int kVL;
      int kVM;
      int kVN;
      int kVO;
      public int kVP;
      public int kVQ;
      public int kVR;
      int padding;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.kVK = paramInt2;
        this.kVL = paramInt3;
        this.borderWidth = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.kVM = paramInt9;
        this.kVN = paramInt10;
        this.kVO = paramInt11;
        this.kVP = paramInt12;
        this.jWV = paramString2;
        this.kVQ = paramInt13;
        this.kVR = paramInt14;
      }
    }
    
    public static final class b
    {
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      public int height;
      String jWV;
      int kVK;
      int kVL;
      int padding;
      public int width;
      int x;
      int y;
      
      public b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.kVK = paramInt2;
        this.x = paramInt3;
        this.y = paramInt4;
        this.bgColor = paramInt5;
        this.kVL = paramInt6;
        this.borderWidth = paramInt7;
        this.borderColor = paramInt8;
        this.jWV = paramString2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.b
 * JD-Core Version:    0.7.0.1
 */