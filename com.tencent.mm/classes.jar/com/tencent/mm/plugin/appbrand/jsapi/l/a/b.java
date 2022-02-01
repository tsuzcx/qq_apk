package com.tencent.mm.plugin.appbrand.jsapi.l.a;

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
  public abstract boolean AB(int paramInt);
  
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
  
  public abstract void a(w paramw);
  
  public abstract void a(x paramx);
  
  public abstract void a(z paramz);
  
  public abstract void a(String paramString, int paramInt, i parami, boolean paramBoolean);
  
  public abstract void a(String paramString, a parama);
  
  public abstract void a(String paramString, v paramv);
  
  public abstract void a(String paramString, v paramv, a parama);
  
  public abstract void a(String paramString, ArrayList<i> paramArrayList, long paramLong, boolean paramBoolean, r paramr);
  
  public abstract void a(String paramString, LinkedList<h> paramLinkedList, r paramr);
  
  public abstract boolean a(int paramInt, e parame, a parama);
  
  public abstract boolean a(ab paramab);
  
  public abstract boolean a(c paramc, b.n paramn, a parama);
  
  public abstract boolean a(d paramd, a parama);
  
  public abstract boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, q paramq);
  
  public abstract void ahH(String paramString);
  
  public abstract void ahI(String paramString);
  
  public abstract boolean ahJ(String paramString);
  
  public abstract boolean ahL(String paramString);
  
  public abstract boolean b(int paramInt, e parame, a parama);
  
  public abstract ac bSC();
  
  public abstract void bSD();
  
  public abstract f bSE();
  
  public abstract boolean bSF();
  
  public abstract i bSG();
  
  public abstract void bSH();
  
  public abstract void bSI();
  
  public abstract void bSJ();
  
  public abstract void bSK();
  
  public abstract void bSL();
  
  public abstract void bSM();
  
  public abstract boolean bSO();
  
  public abstract boolean bSP();
  
  public abstract void c(float paramFloat1, float paramFloat2, boolean paramBoolean);
  
  public abstract void dJ(String paramString1, String paramString2);
  
  public abstract i e(Point paramPoint);
  
  public abstract void e(double paramDouble1, double paramDouble2);
  
  public abstract float getRotate();
  
  public abstract float getSkew();
  
  public abstract View getView();
  
  public abstract float getZoom();
  
  public abstract void h(SurfaceTexture paramSurfaceTexture);
  
  public abstract void h(List<i> paramList, int paramInt);
  
  public abstract void im(boolean paramBoolean);
  
  public abstract void in(boolean paramBoolean);
  
  public abstract void io(boolean paramBoolean);
  
  public abstract void ip(boolean paramBoolean);
  
  public abstract void iq(boolean paramBoolean);
  
  public abstract void ir(boolean paramBoolean);
  
  public abstract void is(boolean paramBoolean);
  
  public abstract void it(boolean paramBoolean);
  
  public abstract void iu(boolean paramBoolean);
  
  public abstract void iv(boolean paramBoolean);
  
  public abstract void iw(boolean paramBoolean);
  
  public abstract void ix(boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2);
  
  public abstract void setBuilding3dEffectEnable(boolean paramBoolean);
  
  public abstract void setIndoorMaskColor(int paramInt);
  
  public abstract void setMapStyle(int paramInt);
  
  public abstract void setMaxZoomLevel(int paramInt);
  
  public abstract void setMinZoomLevel(int paramInt);
  
  public abstract void setPoisEnabled(boolean paramBoolean);
  
  public static final class a
  {
    b.i oYj;
    public float oYk;
    public float skew;
    public float zoom;
  }
  
  public static final class aa
  {
    public String id;
    public b.i oYU;
  }
  
  public static final class ab
  {
    public int fillColor;
    public String oYl;
    public List<b.i> oYw;
    public int strokeColor;
    public int strokeWidth;
    public int zIndex;
  }
  
  public static final class ac
  {
    public b.ad oYV;
  }
  
  public static final class ad
  {
    public b.j oYW;
  }
  
  public static final class b
  {
    public int fillColor;
    public double latitude;
    public double longitude;
    public String oYl;
    public int radius;
    public int strokeColor;
    public int strokeWidth;
  }
  
  public static final class c
  {
    public String data;
    public int height;
    public int left;
    public String oYm;
    public boolean oYn;
    public int top;
    public int width;
  }
  
  public static final class d
  {
    double latitude;
    double longitude;
    public float oYk;
    public String oYm;
    
    public final void f(double paramDouble1, double paramDouble2)
    {
      this.latitude = paramDouble1;
      this.longitude = paramDouble2;
    }
  }
  
  public static final class e
  {
    public float alpha;
    public String oYm;
    public b.i oYo;
    public b.i oYp;
    public boolean visible;
    public int zIndex;
  }
  
  public static final class f
  {
    public String buildingId;
    public String buildingName;
    public List<b.g> oYq;
    public int oYr;
  }
  
  public static final class g
  {
    public String floorName;
  }
  
  public static final class h
  {
    public int duration;
    public double latitude;
    public double longitude;
    public float oYk;
    public double oYs;
    public double oYt;
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
    public b.i oYu;
    public b.i oYv;
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
    public int oYA;
    public List<Integer> oYB;
    public String oYl;
    public List<b.i> oYw;
    public boolean oYx;
    public boolean oYy;
    public String oYz;
    public int style;
    public int width;
  }
  
  public static abstract interface l
  {
    public abstract void a(b.u paramu);
  }
  
  public static abstract interface m
  {
    public abstract void d(double paramDouble1, double paramDouble2);
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
    public abstract void ae(JSONObject paramJSONObject);
    
    public abstract void p(JSONArray paramJSONArray);
  }
  
  public static abstract interface r
  {
    public abstract void bSx();
    
    public abstract void il(boolean paramBoolean);
  }
  
  public static abstract interface s
  {
    public abstract void c(double paramDouble1, double paramDouble2);
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
    public b.v oYC;
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
    public boolean oYD = false;
    public float oYE;
    public float oYF;
    public String oYG;
    public String oYH;
    public a oYI;
    public b oYJ;
    public int oYg = -1;
    public float oYk;
    public String oYm;
    public String title;
    public int zIndex;
    
    public final void N(float paramFloat1, float paramFloat2)
    {
      this.anchorX = paramFloat1;
      this.anchorY = paramFloat2;
    }
    
    public static final class a
    {
      public static int oYS = 0;
      public static int oYT = 1;
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      String content;
      String nUc;
      int oYK;
      int oYL;
      int oYM;
      int oYN;
      int oYO;
      public int oYP;
      public int oYQ;
      public int oYR;
      int padding;
      int shadowColor;
      public View view = null;
      
      public a() {}
      
      public a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, String paramString2, int paramInt13, int paramInt14)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.oYK = paramInt2;
        this.oYL = paramInt3;
        this.borderWidth = paramInt5;
        this.borderColor = paramInt6;
        this.bgColor = paramInt4;
        this.padding = paramInt7;
        this.shadowColor = paramInt8;
        this.oYM = paramInt9;
        this.oYN = paramInt10;
        this.oYO = paramInt11;
        this.oYP = paramInt12;
        this.nUc = paramString2;
        this.oYQ = paramInt13;
        this.oYR = paramInt14;
      }
    }
    
    public static final class b
    {
      int bgColor;
      int borderColor;
      int borderWidth;
      int color;
      public String content;
      public int height;
      String nUc;
      int oYK;
      int oYL;
      int padding;
      public int width;
      int x;
      int y;
      
      public b(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString2, int paramInt9)
      {
        this.content = paramString1;
        this.color = paramInt1;
        this.oYK = paramInt2;
        this.x = paramInt3;
        this.y = paramInt4;
        this.bgColor = paramInt5;
        this.oYL = paramInt6;
        this.borderWidth = paramInt7;
        this.borderColor = paramInt8;
        this.nUc = paramString2;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.l.a.b
 * JD-Core Version:    0.7.0.1
 */