package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class o
  extends v
{
  boolean iVc;
  boolean iVd;
  private final RecyclerView.f.a iVe;
  final Set<RecyclerView.f.a> iVf;
  private final Interpolator iVg;
  private final ArrayList<o.b> iVh;
  final ArrayList<RecyclerView.v> iVi;
  private final ArrayList<o.d> iVj;
  final ArrayList<RecyclerView.v> iVk;
  private final ArrayList<AppBrandLauncherRecentsList.e> iVl;
  final ArrayList<AppBrandLauncherRecentsList.e> iVm;
  private final ArrayList<AppBrandLauncherRecentsList.e> iVn;
  final ArrayList<AppBrandLauncherRecentsList.e> iVo;
  private final ArrayList<o.f> iVp;
  final ArrayList<AppBrandLauncherRecentsList.e> iVq;
  private final ArrayList<RecyclerView.v> iVr;
  private final ArrayList<AppBrandLauncherRecentsList.e> iVs;
  final ArrayList<AppBrandLauncherRecentsList.e> iVt;
  final ArrayList<AppBrandLauncherRecentsList.e> iVu;
  boolean iVv;
  
  o()
  {
    AppMethodBeat.i(133519);
    this.iVc = false;
    this.iVd = true;
    this.iVe = new o.1(this);
    this.iVf = new HashSet();
    this.iVg = new AccelerateDecelerateInterpolator();
    this.iVh = new ArrayList();
    this.iVi = new ArrayList();
    this.iVj = new ArrayList();
    this.iVk = new ArrayList();
    this.iVl = new ArrayList();
    this.iVm = new ArrayList();
    this.iVn = new ArrayList();
    this.iVo = new ArrayList();
    this.iVp = new ArrayList();
    this.iVq = new ArrayList();
    this.iVr = new ArrayList();
    this.iVs = new ArrayList();
    this.iVt = new ArrayList();
    this.iVu = new ArrayList();
    this.iVv = false;
    AppMethodBeat.o(133519);
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133522);
    paramv.aku.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramv);
    t.e(paramv.aku, 0.0F);
    t.f(paramv.aku, 1.0F);
    AppMethodBeat.o(133522);
  }
  
  public final void D(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133525);
    super.D(paramv);
    if (!this.iVq.contains(paramv)) {
      this.iVv = true;
    }
    AppMethodBeat.o(133525);
  }
  
  public final void F(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133535);
    super.F(paramv);
    if (this.iVr.contains(paramv)) {
      ((RecentsRecyclerView)paramv.aku.getParent()).cC(paramv.aku);
    }
    AppMethodBeat.o(133535);
  }
  
  public final void G(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133536);
    super.G(paramv);
    if (this.iVr.contains(paramv))
    {
      this.iVr.remove(paramv);
      ((RecentsRecyclerView)paramv.aku.getParent()).cD(paramv.aku);
    }
    AppMethodBeat.o(133536);
  }
  
  public final RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(133537);
    if ((paramInt & 0x2) > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof Bundle))
        {
          localObject = (Boolean)((Bundle)localObject).get("star");
          if ((localObject != null) && (((Boolean)localObject).booleanValue()))
          {
            params = new o.c((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(133537);
            return params;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            params = new o.e((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(133537);
            return params;
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.ajj = paramInt;
    AppMethodBeat.o(133537);
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133526);
    if ((!(paramv instanceof AppBrandLauncherRecentsList.e)) || (!this.iVd))
    {
      e(paramv);
      C(paramv);
      AppMethodBeat.o(133526);
      return false;
    }
    boolean bool = super.a(paramv, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(133526);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133532);
    if (t.ab(paramv1.aku) == null)
    {
      t.f(paramv1.aku, 1.0F);
      t.e(paramv1.aku, 0.0F);
    }
    if (t.ab(paramv2.aku) == null)
    {
      t.f(paramv2.aku, 1.0F);
      t.e(paramv2.aku, 0.0F);
    }
    m(paramv1);
    m(paramv2);
    AppMethodBeat.o(133532);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(133538);
    if (!this.iVd)
    {
      m(paramv1);
      m(paramv2);
      AppMethodBeat.o(133538);
      return false;
    }
    if ((paramc1 instanceof o.c))
    {
      if (((o.c)paramc1).aNv())
      {
        ((AppBrandLauncherRecentsList.e)paramv2).iTI.setVisibility(0);
        ((AppBrandLauncherRecentsList.e)paramv2).iTI.invalidate();
        ((RecentsRecyclerView)paramv2.aku.getParent()).cC(paramv2.aku);
        this.iVr.add(paramv2);
        bool = super.a(paramv2, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
        AppMethodBeat.o(133538);
        return bool;
      }
      e(paramv2);
      this.iVl.add((AppBrandLauncherRecentsList.e)paramv2);
      AppMethodBeat.o(133538);
      return true;
    }
    if ((paramc1 instanceof o.e))
    {
      if (!((o.e)paramc1).aNv())
      {
        e(paramv2);
        this.iVn.add((AppBrandLauncherRecentsList.e)paramv2);
        AppMethodBeat.o(133538);
        return true;
      }
      ((AppBrandLauncherRecentsList.e)paramv2).iTI.setVisibility(8);
      bool = super.a(paramv2, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(133538);
      return bool;
    }
    boolean bool = super.a(paramv1, paramv2, paramc1, paramc2);
    AppMethodBeat.o(133538);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(133539);
    boolean bool = super.a(paramv, paramList);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) || (bool))
    {
      AppMethodBeat.o(133539);
      return true;
    }
    AppMethodBeat.o(133539);
    return false;
  }
  
  final void b(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(133520);
    if (parama != null) {
      this.iVf.add(parama);
    }
    AppMethodBeat.o(133520);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133531);
    if (!this.iVd)
    {
      e(paramv);
      B(paramv);
      AppMethodBeat.o(133531);
      return false;
    }
    boolean bool = super.b(paramv);
    AppMethodBeat.o(133531);
    return bool;
  }
  
  final void c(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(133521);
    if (parama != null) {
      this.iVf.remove(parama);
    }
    AppMethodBeat.o(133521);
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133527);
    e(paramv);
    m(paramv);
    AppMethodBeat.o(133527);
    return false;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133528);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) && (this.iVs.remove(paramv)))
    {
      t.e(paramv.aku, 0.0F);
      m(paramv);
    }
    super.d(paramv);
    AppMethodBeat.o(133528);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(133530);
    if (!this.iVd)
    {
      e(paramv);
      B(paramv);
      AppMethodBeat.o(133530);
      return false;
    }
    if ((paramc1 instanceof o.c))
    {
      e(paramv);
      this.iVh.add(new o.b((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top));
      AppMethodBeat.o(133530);
      return true;
    }
    if ((paramc1 instanceof o.e))
    {
      e(paramv);
      this.iVj.add(new o.d((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top));
      AppMethodBeat.o(133530);
      return true;
    }
    if (((paramc1.ajj & 0x800) > 0) && ((paramv instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramv).aNn().hcd;
        if (!bool)
        {
          e(paramv);
          this.iVp.add(new o.f((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top, (byte)0));
          AppMethodBeat.o(133530);
          return true;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          bool = false;
        }
      }
    }
    boolean bool = super.d(paramv, paramc1, paramc2);
    AppMethodBeat.o(133530);
    return bool;
  }
  
  public final boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(133529);
    if (!this.iVd)
    {
      bool = c(paramv);
      AppMethodBeat.o(133529);
      return bool;
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)))
    {
      bool = super.a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(133529);
      return bool;
    }
    if ((this.iVc) && ((paramv.aku.getParent() instanceof RecyclerView)) && ((paramv instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramv.aku.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          t.e(paramv.aku, paramv.aku.getHeight());
          this.iVs.add(paramv);
          AppMethodBeat.o(133529);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          t.e(paramv.aku, -paramv.aku.getHeight());
          this.iVs.add(paramv);
          AppMethodBeat.o(133529);
          return true;
        }
      }
    }
    boolean bool = c(paramv);
    AppMethodBeat.o(133529);
    return bool;
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(133533);
    if (!this.iVd)
    {
      e(paramv);
      C(paramv);
      AppMethodBeat.o(133533);
      return false;
    }
    boolean bool = super.f(paramv, paramc1, paramc2);
    AppMethodBeat.o(133533);
    return bool;
  }
  
  public final void hA()
  {
    AppMethodBeat.i(133524);
    a(this.iVe);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.iVh.isEmpty())
    {
      localObject1 = this.iVh.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o.b)((Iterator)localObject1).next();
        this.iVi.add(((o.b)localObject2).iVz);
        localObject3 = ((o.b)localObject2).iVz;
        localObject4 = ((o.b)localObject2).iVz.aku;
        ((o.b)localObject2).iVz.iTI.setVisibility(0);
        t.e((View)localObject4, 0.0F);
        localObject5 = t.ab((View)localObject4);
        double d1 = ((o.b)localObject2).acG / ((o.b)localObject2).iVz.aku.getHeight();
        double d2 = this.ajh;
        ((x)localObject5).h(Math.max(this.ajh, Math.min(Math.round(d1 * d2) + this.ajh, 400L)));
        ((x)localObject5).c(this.iVg);
        ((x)localObject5).a(new o.2(this, (RecyclerView.v)localObject3, (x)localObject5));
        ((x)localObject5).t(-((o.b)localObject2).acG - ((View)localObject4).getHeight()).start();
      }
      this.iVh.clear();
    }
    if (!this.iVj.isEmpty())
    {
      localObject1 = this.iVj.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (o.d)((Iterator)localObject1).next();
        this.iVk.add(((o.d)localObject2).iVz);
        localObject3 = ((o.d)localObject2).iVz;
        localObject5 = ((o.d)localObject2).iVz.aku;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((o.d)localObject2).iVz.iTI.setVisibility(8);
        t.e((View)localObject5, 0.0F);
        localObject5 = t.ab((View)localObject5);
        ((x)localObject5).h(this.ajh);
        ((x)localObject5).a(new o.3(this, (RecyclerView.v)localObject3, (x)localObject5));
        ((x)localObject5).t(((RecentsRecyclerView)localObject4).getHeight() - ((o.d)localObject2).acG).start();
      }
      this.iVj.clear();
    }
    if (!this.iVl.isEmpty())
    {
      localObject1 = this.iVl.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.iVm.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).iTI, 0.1F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).iTI, 0.1F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).iTI, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).iTI.setVisibility(0);
        localObject3 = t.ab(((AppBrandLauncherRecentsList.e)localObject2).iTI);
        ((x)localObject3).h(this.aji);
        ((x)localObject3).a(new o.4(this, (AppBrandLauncherRecentsList.e)localObject2, (x)localObject3));
        ((x)localObject3).s(1.0F).u(1.0F).v(1.0F).start();
      }
      this.iVl.clear();
    }
    if (!this.iVn.isEmpty())
    {
      localObject1 = this.iVn.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.iVo.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).iTI, 1.0F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).iTI, 1.0F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).iTI, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).iTI.setVisibility(0);
        localObject3 = t.ab(((AppBrandLauncherRecentsList.e)localObject2).iTI);
        ((x)localObject3).h(this.aji);
        ((x)localObject3).a(new o.5(this, (AppBrandLauncherRecentsList.e)localObject2));
        ((x)localObject3).s(0.0F).u(0.1F).v(0.1F).start();
      }
      this.iVn.clear();
    }
    if (!this.iVp.isEmpty())
    {
      localObject1 = this.iVp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (o.f)((Iterator)localObject1).next();
        this.iVq.add(((o.f)localObject3).iVz);
        localObject2 = ((o.f)localObject3).iVz.aku;
        t.e((View)localObject2, 0.0F);
        t.f((View)localObject2, 1.0F);
        localObject3 = ((o.f)localObject3).iVz;
        localObject4 = t.ab((View)localObject2);
        ((x)localObject4).h(this.ajh);
        ((x)localObject4).a(new o.6(this, (AppBrandLauncherRecentsList.e)localObject3));
        ((x)localObject4).s(0.0F).t(-((View)localObject2).getHeight()).start();
      }
      this.iVp.clear();
    }
    super.hA();
    if (!this.iVs.isEmpty())
    {
      this.iVt.addAll(this.iVs);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133515);
          Iterator localIterator = o.this.iVt.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            o localo = o.this;
            x localx = t.ab(locale.aku);
            localo.iVu.add(locale);
            localx.t(0.0F).h(localo.ajh).a(new o.8(localo, locale, localx)).start();
          }
          o.this.iVt.clear();
          AppMethodBeat.o(133515);
        }
      };
      this.iVs.clear();
      if (this.iVv)
      {
        t.a(((AppBrandLauncherRecentsList.e)this.iVt.get(0)).aku, (Runnable)localObject1, this.ajg);
        AppMethodBeat.o(133524);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(133524);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(133523);
    if ((!this.iVh.isEmpty()) || (!this.iVi.isEmpty()) || (!this.iVj.isEmpty()) || (!this.iVk.isEmpty()) || (!this.iVl.isEmpty()) || (!this.iVm.isEmpty()) || (!this.iVn.isEmpty()) || (!this.iVo.isEmpty()) || (!this.iVp.isEmpty()) || (!this.iVq.isEmpty()) || (!this.iVs.isEmpty()) || (!this.iVt.isEmpty()) || (!this.iVu.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(133523);
      return true;
    }
    AppMethodBeat.o(133523);
    return false;
  }
  
  public final void n(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133534);
    super.n(paramv);
    ViewParent localViewParent = paramv.aku.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).cD(paramv.aku);
    }
    AppMethodBeat.o(133534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.o
 * JD-Core Version:    0.7.0.1
 */