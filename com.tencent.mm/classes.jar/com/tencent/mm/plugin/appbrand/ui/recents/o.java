package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.support.v7.widget.x;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class o
  extends x
{
  private final ArrayList<o.b> hjA = new ArrayList();
  final ArrayList<RecyclerView.v> hjB = new ArrayList();
  private final ArrayList<o.d> hjC = new ArrayList();
  final ArrayList<RecyclerView.v> hjD = new ArrayList();
  private final ArrayList<e.d> hjE = new ArrayList();
  final ArrayList<e.d> hjF = new ArrayList();
  private final ArrayList<e.d> hjG = new ArrayList();
  final ArrayList<e.d> hjH = new ArrayList();
  private final ArrayList<o.f> hjI = new ArrayList();
  final ArrayList<e.d> hjJ = new ArrayList();
  private final ArrayList<RecyclerView.v> hjK = new ArrayList();
  private final ArrayList<e.d> hjL = new ArrayList();
  final ArrayList<e.d> hjM = new ArrayList();
  final ArrayList<e.d> hjN = new ArrayList();
  boolean hjO = false;
  boolean hjv = false;
  boolean hjw = true;
  private final RecyclerView.f.a hjx = new o.1(this);
  final Set<RecyclerView.f.a> hjy = new HashSet();
  private final Interpolator hjz = new AccelerateDecelerateInterpolator();
  
  private void e(RecyclerView.v paramv)
  {
    paramv.aie.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramv);
    q.d(paramv.aie, 0.0F);
    q.e(paramv.aie, 1.0F);
  }
  
  public final void A(RecyclerView.v paramv)
  {
    super.A(paramv);
    if (this.hjK.contains(paramv)) {
      ((RecentsRecyclerView)paramv.aie.getParent()).bZ(paramv.aie);
    }
  }
  
  public final void B(RecyclerView.v paramv)
  {
    super.B(paramv);
    if (this.hjK.contains(paramv))
    {
      this.hjK.remove(paramv);
      ((RecentsRecyclerView)paramv.aie.getParent()).ca(paramv.aie);
    }
  }
  
  public final RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    if ((paramInt & 0x2) > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof Bundle))
        {
          localObject = (Boolean)((Bundle)localObject).get("star");
          if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
            return new o.c((byte)0).c(paramv, paramInt);
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue())) {
            return new e((byte)0).c(paramv, paramInt);
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.agT = paramInt;
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!(paramv instanceof e.d)) || (!this.hjw))
    {
      e(paramv);
      x(paramv);
      return false;
    }
    return super.a(paramv, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (q.Y(paramv1.aie) == null)
    {
      q.e(paramv1.aie, 1.0F);
      q.d(paramv1.aie, 0.0F);
    }
    if (q.Y(paramv2.aie) == null)
    {
      q.e(paramv2.aie, 1.0F);
      q.d(paramv2.aie, 0.0F);
    }
    l(paramv1);
    l(paramv2);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if (!this.hjw)
    {
      l(paramv1);
      l(paramv2);
      return false;
    }
    if ((paramc1 instanceof o.c))
    {
      if (((o.c)paramc1).apZ())
      {
        ((e.d)paramv2).hid.setVisibility(0);
        ((e.d)paramv2).hid.invalidate();
        ((RecentsRecyclerView)paramv2.aie.getParent()).bZ(paramv2.aie);
        this.hjK.add(paramv2);
        return super.a(paramv2, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      }
      e(paramv2);
      this.hjE.add((e.d)paramv2);
      return true;
    }
    if ((paramc1 instanceof e))
    {
      if (!((e)paramc1).apZ())
      {
        e(paramv2);
        this.hjG.add((e.d)paramv2);
        return true;
      }
      ((e.d)paramv2).hid.setVisibility(8);
      return super.a(paramv2, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    return super.a(paramv1, paramv2, paramc1, paramc2);
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    boolean bool = super.a(paramv, paramList);
    return ((paramv instanceof e.d)) || (bool);
  }
  
  final void b(RecyclerView.f.a parama)
  {
    if (parama != null) {
      this.hjy.add(parama);
    }
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    if (!this.hjw)
    {
      e(paramv);
      w(paramv);
      return false;
    }
    return super.b(paramv);
  }
  
  final void c(RecyclerView.f.a parama)
  {
    if (parama != null) {
      this.hjy.remove(parama);
    }
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    l(paramv);
    return false;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    if (((paramv instanceof e.d)) && (this.hjL.remove(paramv)))
    {
      q.d(paramv.aie, 0.0F);
      l(paramv);
    }
    super.d(paramv);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if (!this.hjw)
    {
      e(paramv);
      w(paramv);
      return false;
    }
    if ((paramc1 instanceof o.c))
    {
      e(paramv);
      this.hjA.add(new o.b((e.d)paramv, paramc1.left, paramc1.top));
      return true;
    }
    if ((paramc1 instanceof e))
    {
      e(paramv);
      this.hjC.add(new o.d((e.d)paramv, paramc1.left, paramc1.top));
      return true;
    }
    if (((paramc1.agT & 0x800) > 0) && ((paramv instanceof e.d)) && (paramc2 == null)) {
      try
      {
        bool = ((e.d)paramv).apR().fJl;
        if (!bool)
        {
          e(paramv);
          this.hjI.add(new o.f((e.d)paramv, paramc1.left, paramc1.top, (byte)0));
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool = false;
        }
      }
    }
    return super.d(paramv, paramc1, paramc2);
  }
  
  public final boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if (!this.hjw) {
      return c(paramv);
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top))) {
      return super.a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
    }
    if ((this.hjv) && ((paramv.aie.getParent() instanceof RecyclerView)) && ((paramv instanceof e.d)))
    {
      paramc1 = (RecyclerView)paramv.aie.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (e.d)paramv;
          q.d(paramv.aie, paramv.aie.getHeight());
          this.hjL.add(paramv);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (e.d)paramv;
          q.d(paramv.aie, -paramv.aie.getHeight());
          this.hjL.add(paramv);
          return true;
        }
      }
    }
    return c(paramv);
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    if (!this.hjw)
    {
      e(paramv);
      x(paramv);
      return false;
    }
    return super.f(paramv, paramc1, paramc2);
  }
  
  public final void gA()
  {
    a(this.hjx);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.hjA.isEmpty())
    {
      localObject1 = this.hjA.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o.b)((Iterator)localObject1).next();
        this.hjB.add(((o.b)localObject2).hjS);
        localObject3 = ((o.b)localObject2).hjS;
        localObject4 = ((o.b)localObject2).hjS.aie;
        ((o.b)localObject2).hjS.hid.setVisibility(0);
        q.d((View)localObject4, 0.0F);
        localObject5 = q.Y((View)localObject4);
        double d1 = ((o.b)localObject2).abV / ((o.b)localObject2).hjS.aie.getHeight();
        double d2 = this.agR;
        ((u)localObject5).k(Math.max(this.agR, Math.min(Math.round(d1 * d2) + this.agR, 400L)));
        ((u)localObject5).c(this.hjz);
        ((u)localObject5).a(new o.2(this, (RecyclerView.v)localObject3, (u)localObject5));
        ((u)localObject5).t(-((o.b)localObject2).abV - ((View)localObject4).getHeight()).start();
      }
      this.hjA.clear();
    }
    if (!this.hjC.isEmpty())
    {
      localObject1 = this.hjC.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o.d)((Iterator)localObject1).next();
        this.hjD.add(((o.d)localObject2).hjS);
        localObject3 = ((o.d)localObject2).hjS;
        localObject5 = ((o.d)localObject2).hjS.aie;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((o.d)localObject2).hjS.hid.setVisibility(8);
        q.d((View)localObject5, 0.0F);
        localObject5 = q.Y((View)localObject5);
        ((u)localObject5).k(this.agR);
        ((u)localObject5).a(new o.3(this, (RecyclerView.v)localObject3, (u)localObject5));
        ((u)localObject5).t(((RecentsRecyclerView)localObject4).getHeight() - ((o.d)localObject2).abV).start();
      }
      this.hjC.clear();
    }
    if (!this.hjE.isEmpty())
    {
      localObject1 = this.hjE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e.d)((Iterator)localObject1).next();
        this.hjF.add(localObject2);
        q.f(((e.d)localObject2).hid, 0.1F);
        q.g(((e.d)localObject2).hid, 0.1F);
        q.e(((e.d)localObject2).hid, 0.0F);
        ((e.d)localObject2).hid.setVisibility(0);
        localObject3 = q.Y(((e.d)localObject2).hid);
        ((u)localObject3).k(this.agS);
        ((u)localObject3).a(new o.4(this, (e.d)localObject2, (u)localObject3));
        ((u)localObject3).s(1.0F).u(1.0F).v(1.0F).start();
      }
      this.hjE.clear();
    }
    if (!this.hjG.isEmpty())
    {
      localObject1 = this.hjG.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (e.d)((Iterator)localObject1).next();
        this.hjH.add(localObject2);
        q.f(((e.d)localObject2).hid, 1.0F);
        q.g(((e.d)localObject2).hid, 1.0F);
        q.e(((e.d)localObject2).hid, 1.0F);
        ((e.d)localObject2).hid.setVisibility(0);
        localObject3 = q.Y(((e.d)localObject2).hid);
        ((u)localObject3).k(this.agS);
        ((u)localObject3).a(new o.5(this, (e.d)localObject2));
        ((u)localObject3).s(0.0F).u(0.1F).v(0.1F).start();
      }
      this.hjG.clear();
    }
    if (!this.hjI.isEmpty())
    {
      localObject1 = this.hjI.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (o.f)((Iterator)localObject1).next();
        this.hjJ.add(((o.f)localObject3).hjS);
        localObject2 = ((o.f)localObject3).hjS.aie;
        q.d((View)localObject2, 0.0F);
        q.e((View)localObject2, 1.0F);
        localObject3 = ((o.f)localObject3).hjS;
        localObject4 = q.Y((View)localObject2);
        ((u)localObject4).k(this.agR);
        ((u)localObject4).a(new o.6(this, (e.d)localObject3));
        ((u)localObject4).s(0.0F).t(-((View)localObject2).getHeight()).start();
      }
      this.hjI.clear();
    }
    super.gA();
    if (!this.hjL.isEmpty())
    {
      this.hjM.addAll(this.hjL);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = o.this.hjM.iterator();
          while (localIterator.hasNext())
          {
            e.d locald = (e.d)localIterator.next();
            o localo = o.this;
            u localu = q.Y(locald.aie);
            localo.hjN.add(locald);
            localu.t(0.0F).k(localo.agR).a(new o.8(localo, locald, localu)).start();
          }
          o.this.hjM.clear();
        }
      };
      this.hjL.clear();
      if (this.hjO) {
        q.a(((e.d)this.hjM.get(0)).aie, (Runnable)localObject1, this.agQ);
      }
    }
    else
    {
      return;
    }
    ((Runnable)localObject1).run();
  }
  
  public final boolean isRunning()
  {
    return (!this.hjA.isEmpty()) || (!this.hjB.isEmpty()) || (!this.hjC.isEmpty()) || (!this.hjD.isEmpty()) || (!this.hjE.isEmpty()) || (!this.hjF.isEmpty()) || (!this.hjG.isEmpty()) || (!this.hjH.isEmpty()) || (!this.hjI.isEmpty()) || (!this.hjJ.isEmpty()) || (!this.hjL.isEmpty()) || (!this.hjM.isEmpty()) || (!this.hjN.isEmpty()) || (super.isRunning());
  }
  
  public final void m(RecyclerView.v paramv)
  {
    super.m(paramv);
    ViewParent localViewParent = paramv.aie.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).ca(paramv.aie);
    }
  }
  
  public final void y(RecyclerView.v paramv)
  {
    super.y(paramv);
    if (!this.hjJ.contains(paramv)) {
      this.hjO = true;
    }
  }
  
  private static final class e
    extends o.a
  {
    private e()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */