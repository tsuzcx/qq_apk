package com.tencent.mapsdk.internal;

import android.graphics.Color;
import android.graphics.Rect;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Boundable;
import com.tencent.tencentmap.mapsdk.maps.interfaces.Selectable.OnSelectedListener;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public abstract class oo<D extends ao>
  extends au<D>
  implements em
{
  private static final AtomicInteger a = new AtomicInteger(1);
  public final String b_ = String.valueOf(a.incrementAndGet());
  protected IndoorInfo c_;
  protected float d = 1.0F;
  protected int e = Color.argb(17, 0, 163, 255);
  protected int f = Color.argb(255, 0, 163, 255);
  protected float g = 0.0F;
  protected boolean h = true;
  protected boolean i = false;
  protected int j = 2;
  protected int k = -1;
  volatile boolean l;
  private boolean m = false;
  private boolean n;
  private Object o;
  private boolean p;
  private Selectable.OnSelectedListener q;
  private float r;
  private boolean s;
  private boolean t;
  private final az u;
  
  public oo(az paramaz)
  {
    this.u = paramaz;
  }
  
  private void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  private az d()
  {
    return this.u;
  }
  
  private void e()
  {
    this.l = true;
  }
  
  private Selectable.OnSelectedListener f()
  {
    return this.q;
  }
  
  private String g()
  {
    return this.b_;
  }
  
  private static void h() {}
  
  public int a()
  {
    return this.k;
  }
  
  public void a(IndoorBuilding paramIndoorBuilding)
  {
    if (this.c_ != null)
    {
      this.m = this.c_.toString().equals(paramIndoorBuilding.toString());
      q();
    }
    j();
  }
  
  public final void a(IndoorInfo paramIndoorInfo)
  {
    this.c_ = paramIndoorInfo;
  }
  
  public final void a(GL10 paramGL10)
  {
    boolean bool = this.i;
    j_();
    if ((bool) && (this.u != null)) {
      this.u.F();
    }
    this.i = false;
    s();
  }
  
  public Rect b(ep paramep)
  {
    return new Rect();
  }
  
  public int getFillColor()
  {
    return this.e;
  }
  
  public List<Boundable<ep>> getGroupBounds()
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(this);
    return localArrayList;
  }
  
  public String getId()
  {
    return this.b_;
  }
  
  public int getLevel()
  {
    return this.j;
  }
  
  public float getRotation()
  {
    return this.r;
  }
  
  public int getStrokeColor()
  {
    return this.f;
  }
  
  public float getStrokeWidth()
  {
    return this.d;
  }
  
  public Object getTag()
  {
    return this.o;
  }
  
  public int getZIndex()
  {
    return (int)this.g;
  }
  
  protected void h_() {}
  
  public boolean handleOnTap()
  {
    return false;
  }
  
  public boolean isClickable()
  {
    return this.n;
  }
  
  public boolean isDraggable()
  {
    return this.s;
  }
  
  public boolean isRemoved()
  {
    return this.t;
  }
  
  public boolean isSelected()
  {
    return this.p;
  }
  
  public boolean isVisible()
  {
    if (this.c_ != null) {
      return (this.h) && (this.m);
    }
    return this.h;
  }
  
  public void j() {}
  
  public void j_() {}
  
  public boolean k()
  {
    return false;
  }
  
  public final void l() {}
  
  public final IndoorInfo m()
  {
    return this.c_;
  }
  
  public final boolean n()
  {
    return this.m;
  }
  
  public void o()
  {
    if (this.c_ != null)
    {
      this.m = false;
      q();
    }
    j();
  }
  
  public final boolean p()
  {
    return this.i;
  }
  
  public void q()
  {
    if (this.l) {
      return;
    }
    this.i = true;
  }
  
  public final void r()
  {
    this.l = false;
    q();
  }
  
  public void releaseData() {}
  
  public final void remove()
  {
    this.q = null;
    this.u.d(getId());
    h_();
    this.t = true;
  }
  
  protected void s() {}
  
  public void setClickable(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setDraggable(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void setFillColor(int paramInt)
  {
    this.e = paramInt;
    q();
  }
  
  public void setLevel(int paramInt)
  {
    this.j = paramInt;
    q();
  }
  
  public void setRotation(float paramFloat)
  {
    this.r = paramFloat;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setSelectedListener(Selectable.OnSelectedListener paramOnSelectedListener)
  {
    this.q = paramOnSelectedListener;
  }
  
  public void setStrokeColor(int paramInt)
  {
    this.f = paramInt;
    q();
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    this.d = paramFloat;
    q();
  }
  
  public void setTag(Object paramObject)
  {
    this.o = paramObject;
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.h = paramBoolean;
    q();
  }
  
  public void setZIndex(float paramFloat)
  {
    this.g = paramFloat;
    q();
  }
  
  public void setZIndex(int paramInt)
  {
    setZIndex(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.oo
 * JD-Core Version:    0.7.0.1
 */