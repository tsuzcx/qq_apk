package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.f.c;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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

final class n
  extends v
{
  boolean mlf;
  boolean mlg;
  private final RecyclerView.f.a mlh;
  final Set<RecyclerView.f.a> mli;
  private final Interpolator mlj;
  private final ArrayList<b> mlk;
  final ArrayList<RecyclerView.w> mll;
  private final ArrayList<d> mlm;
  final ArrayList<RecyclerView.w> mln;
  private final ArrayList<AppBrandLauncherRecentsList.e> mlo;
  final ArrayList<AppBrandLauncherRecentsList.e> mlp;
  private final ArrayList<AppBrandLauncherRecentsList.e> mlq;
  final ArrayList<AppBrandLauncherRecentsList.e> mlr;
  private final ArrayList<f> mls;
  final ArrayList<AppBrandLauncherRecentsList.e> mlt;
  private final ArrayList<RecyclerView.w> mlu;
  private final ArrayList<AppBrandLauncherRecentsList.e> mlv;
  final ArrayList<AppBrandLauncherRecentsList.e> mlw;
  final ArrayList<AppBrandLauncherRecentsList.e> mlx;
  boolean mly;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.mlf = false;
    this.mlg = true;
    this.mlh = new RecyclerView.f.a()
    {
      public final void ld()
      {
        AppMethodBeat.i(49231);
        synchronized (n.this.mli)
        {
          Iterator localIterator = new HashSet(n.this.mli).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).ld();
          }
        }
        n.this.mly = false;
        AppMethodBeat.o(49231);
      }
    };
    this.mli = new HashSet();
    this.mlj = new AccelerateDecelerateInterpolator();
    this.mlk = new ArrayList();
    this.mll = new ArrayList();
    this.mlm = new ArrayList();
    this.mln = new ArrayList();
    this.mlo = new ArrayList();
    this.mlp = new ArrayList();
    this.mlq = new ArrayList();
    this.mlr = new ArrayList();
    this.mls = new ArrayList();
    this.mlt = new ArrayList();
    this.mlu = new ArrayList();
    this.mlv = new ArrayList();
    this.mlw = new ArrayList();
    this.mlx = new ArrayList();
    this.mly = false;
    AppMethodBeat.o(49247);
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49250);
    paramw.asD.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramw);
    t.e(paramw.asD, 0.0F);
    t.f(paramw.asD, 1.0F);
    AppMethodBeat.o(49250);
  }
  
  public final void A(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49253);
    super.A(paramw);
    if (!this.mlt.contains(paramw)) {
      this.mly = true;
    }
    AppMethodBeat.o(49253);
  }
  
  public final void C(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49263);
    super.C(paramw);
    if (this.mlu.contains(paramw)) {
      ((RecentsRecyclerView)paramw.asD.getParent()).cP(paramw.asD);
    }
    AppMethodBeat.o(49263);
  }
  
  public final void D(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49264);
    super.D(paramw);
    if (this.mlu.contains(paramw))
    {
      this.mlu.remove(paramw);
      ((RecentsRecyclerView)paramw.asD.getParent()).cQ(paramw.asD);
    }
    AppMethodBeat.o(49264);
  }
  
  public final RecyclerView.f.c a(RecyclerView.t paramt, RecyclerView.w paramw, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(49265);
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
            paramt = new c((byte)0).c(paramw, paramInt);
            AppMethodBeat.o(49265);
            return paramt;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            paramt = new e((byte)0).c(paramw, paramInt);
            AppMethodBeat.o(49265);
            return paramt;
          }
        }
      }
    }
    paramt = super.a(paramt, paramw, paramInt, paramList);
    paramt.aro = paramInt;
    AppMethodBeat.o(49265);
    return paramt;
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49254);
    if (!this.mlg)
    {
      e(paramw);
      x(paramw);
      AppMethodBeat.o(49254);
      return false;
    }
    boolean bool = super.a(paramw, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(49254);
    return bool;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49260);
    if (t.ag(paramw1.asD) == null)
    {
      t.f(paramw1.asD, 1.0F);
      t.e(paramw1.asD, 0.0F);
    }
    if (t.ag(paramw2.asD) == null)
    {
      t.f(paramw2.asD, 1.0F);
      t.e(paramw2.asD, 0.0F);
    }
    n(paramw1);
    n(paramw2);
    AppMethodBeat.o(49260);
    return false;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49266);
    if (!this.mlg)
    {
      n(paramw1);
      n(paramw2);
      AppMethodBeat.o(49266);
      return false;
    }
    boolean bool = super.a(paramw1, paramw2, paramc1, paramc2);
    AppMethodBeat.o(49266);
    return bool;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(49267);
    boolean bool = super.a(paramw, paramList);
    if (((paramw instanceof AppBrandLauncherRecentsList.e)) || (bool))
    {
      AppMethodBeat.o(49267);
      return true;
    }
    AppMethodBeat.o(49267);
    return false;
  }
  
  final void b(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(49248);
    if (parama != null) {
      synchronized (this.mli)
      {
        this.mli.add(parama);
        AppMethodBeat.o(49248);
        return;
      }
    }
    AppMethodBeat.o(49248);
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49259);
    if (!this.mlg)
    {
      e(paramw);
      w(paramw);
      AppMethodBeat.o(49259);
      return false;
    }
    boolean bool = super.b(paramw);
    AppMethodBeat.o(49259);
    return bool;
  }
  
  final void c(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(49249);
    if (parama != null) {
      synchronized (this.mli)
      {
        this.mli.remove(parama);
        AppMethodBeat.o(49249);
        return;
      }
    }
    AppMethodBeat.o(49249);
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49255);
    e(paramw);
    n(paramw);
    AppMethodBeat.o(49255);
    return false;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49256);
    if (((paramw instanceof AppBrandLauncherRecentsList.e)) && (this.mlv.remove(paramw)))
    {
      t.e(paramw.asD, 0.0F);
      n(paramw);
    }
    super.d(paramw);
    AppMethodBeat.o(49256);
  }
  
  public final boolean d(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49258);
    if (!this.mlg)
    {
      e(paramw);
      w(paramw);
      AppMethodBeat.o(49258);
      return false;
    }
    if ((paramc1 instanceof c))
    {
      e(paramw);
      AppMethodBeat.o(49258);
      return true;
    }
    if ((paramc1 instanceof e))
    {
      e(paramw);
      AppMethodBeat.o(49258);
      return true;
    }
    if (((paramc1.aro & 0x800) > 0) && ((paramw instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramw).bwD().jvu;
        if (!bool)
        {
          e(paramw);
          this.mls.add(new f((AppBrandLauncherRecentsList.e)paramw, paramc1.left, paramc1.top, (byte)0));
          AppMethodBeat.o(49258);
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
    boolean bool = super.d(paramw, paramc1, paramc2);
    AppMethodBeat.o(49258);
    return bool;
  }
  
  public final boolean e(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49257);
    if (!this.mlg)
    {
      bool = c(paramw);
      AppMethodBeat.o(49257);
      return bool;
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)))
    {
      bool = super.a(paramw, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(49257);
      return bool;
    }
    if ((this.mlf) && ((paramw.asD.getParent() instanceof RecyclerView)) && ((paramw instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramw.asD.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.asD, paramw.asD.getHeight());
          this.mlv.add(paramw);
          AppMethodBeat.o(49257);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.asD, -paramw.asD.getHeight());
          this.mlv.add(paramw);
          AppMethodBeat.o(49257);
          return true;
        }
      }
    }
    boolean bool = c(paramw);
    AppMethodBeat.o(49257);
    return bool;
  }
  
  public final boolean f(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49261);
    if (!this.mlg)
    {
      e(paramw);
      x(paramw);
      AppMethodBeat.o(49261);
      return false;
    }
    boolean bool = super.f(paramw, paramc1, paramc2);
    AppMethodBeat.o(49261);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49251);
    if ((!this.mlk.isEmpty()) || (!this.mll.isEmpty()) || (!this.mlm.isEmpty()) || (!this.mln.isEmpty()) || (!this.mlo.isEmpty()) || (!this.mlp.isEmpty()) || (!this.mlq.isEmpty()) || (!this.mlr.isEmpty()) || (!this.mls.isEmpty()) || (!this.mlt.isEmpty()) || (!this.mlv.isEmpty()) || (!this.mlw.isEmpty()) || (!this.mlx.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void je()
  {
    AppMethodBeat.i(49252);
    a(this.mlh);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.mlk.isEmpty())
    {
      localObject1 = this.mlk.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.mll.add(((b)localObject2).mlC);
        localObject3 = ((b)localObject2).mlC;
        localObject4 = ((b)localObject2).mlC.asD;
        ((b)localObject2).mlC.mkx.setVisibility(0);
        t.e((View)localObject4, 0.0F);
        localObject5 = t.ag((View)localObject4);
        double d1 = ((b)localObject2).akH / ((b)localObject2).mlC.asD.getHeight();
        double d2 = this.arm;
        ((x)localObject5).j(Math.max(this.arm, Math.min(Math.round(d1 * d2) + this.arm, 400L)));
        ((x)localObject5).a(this.mlj);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49232);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cP(paramAnonymousView);
            n.this.A(this.akw);
            AppMethodBeat.o(49232);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49233);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49233);
              return;
            }
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cQ(paramAnonymousView);
            this.mlA.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.akw);
            n.this.mll.remove(this.akw);
            n.a(n.this);
            AppMethodBeat.o(49233);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49234);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49234);
              return;
            }
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49234);
          }
        });
        ((x)localObject5).B(-((b)localObject2).akH - ((View)localObject4).getHeight()).start();
      }
      this.mlk.clear();
    }
    if (!this.mlm.isEmpty())
    {
      localObject1 = this.mlm.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        this.mln.add(((d)localObject2).mlC);
        localObject3 = ((d)localObject2).mlC;
        localObject5 = ((d)localObject2).mlC.asD;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((d)localObject2).mlC.mkx.setVisibility(8);
        t.e((View)localObject5, 0.0F);
        localObject5 = t.ag((View)localObject5);
        ((x)localObject5).j(this.arm);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49235);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cP(paramAnonymousView);
            n.this.A(this.akw);
            AppMethodBeat.o(49235);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49236);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49236);
              return;
            }
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cQ(paramAnonymousView);
            this.mlA.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.akw);
            n.this.mln.remove(this.akw);
            n.a(n.this);
            AppMethodBeat.o(49236);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49237);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49237);
              return;
            }
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49237);
          }
        });
        ((x)localObject5).B(((RecentsRecyclerView)localObject4).getHeight() - ((d)localObject2).akH).start();
      }
      this.mlm.clear();
    }
    if (!this.mlo.isEmpty())
    {
      localObject1 = this.mlo.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mlp.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mkx, 0.1F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mkx, 0.1F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mkx, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mkx.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mkx);
        ((x)localObject3).j(this.arn);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.mlA.a(null);
            n.this.n(this.mlB);
            n.this.mlp.remove(this.mlB);
            n.a(n.this);
            AppMethodBeat.o(49238);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49239);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49239);
              return;
            }
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49239);
          }
        });
        ((x)localObject3).A(1.0F).C(1.0F).D(1.0F).start();
      }
      this.mlo.clear();
    }
    if (!this.mlq.isEmpty())
    {
      localObject1 = this.mlq.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mlr.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mkx, 1.0F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mkx, 1.0F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mkx, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mkx.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mkx);
        ((x)localObject3).j(this.arn);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            t.g(this.mlB.mkx, 1.0F);
            t.h(this.mlB.mkx, 1.0F);
            t.f(this.mlB.mkx, 1.0F);
            this.mlB.mkx.setVisibility(8);
            n.this.n(this.mlB);
            n.this.mlr.remove(this.mlB);
            n.a(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((x)localObject3).A(0.0F).C(0.1F).D(0.1F).start();
      }
      this.mlq.clear();
    }
    if (!this.mls.isEmpty())
    {
      localObject1 = this.mls.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        this.mlt.add(((f)localObject3).mlC);
        localObject2 = ((f)localObject3).mlC.asD;
        t.e((View)localObject2, 0.0F);
        t.f((View)localObject2, 1.0F);
        localObject3 = ((f)localObject3).mlC;
        localObject4 = t.ag((View)localObject2);
        ((x)localObject4).j(this.arm);
        ((x)localObject4).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.A(this.mlB);
            AppMethodBeat.o(49241);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            n.this.w(this.mlB);
            n.this.mlt.remove(this.mlB);
            n.a(n.this);
            AppMethodBeat.o(49242);
          }
        });
        ((x)localObject4).A(0.0F).B(-((View)localObject2).getHeight()).start();
      }
      this.mls.clear();
    }
    super.je();
    if (!this.mlv.isEmpty())
    {
      this.mlw.addAll(this.mlv);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.this.mlw.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n localn = n.this;
            x localx = t.ag(locale.asD);
            localn.mlx.add(locale);
            localx.B(0.0F).j(localn.arm).a(new n.8(localn, locale, localx)).start();
          }
          n.this.mlw.clear();
          AppMethodBeat.o(49243);
        }
      };
      this.mlv.clear();
      if (this.mly)
      {
        t.a(((AppBrandLauncherRecentsList.e)this.mlw.get(0)).asD, (Runnable)localObject1, kY());
        AppMethodBeat.o(49252);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(49252);
  }
  
  public final void o(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49262);
    super.o(paramw);
    ViewParent localViewParent = paramw.asD.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).cQ(paramw.asD);
    }
    AppMethodBeat.o(49262);
  }
  
  static class a
    extends RecyclerView.f.c
  {
    public final RecyclerView.f.c c(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(49246);
      super.c(paramw, paramInt);
      this.aro = paramInt;
      AppMethodBeat.o(49246);
      return this;
    }
  }
  
  static final class b
    extends n.g
  {}
  
  static final class c
    extends n.a
  {
    private c()
    {
      super();
    }
  }
  
  static final class d
    extends n.g
  {}
  
  static final class e
    extends n.a
  {
    private e()
    {
      super();
    }
  }
  
  static final class f
  {
    int akG;
    int akH;
    AppBrandLauncherRecentsList.e mlC;
    
    private f(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.mlC = parame;
      this.akG = paramInt1;
      this.akH = paramInt2;
    }
  }
  
  static class g
  {
    int akH;
    AppBrandLauncherRecentsList.e mlC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */