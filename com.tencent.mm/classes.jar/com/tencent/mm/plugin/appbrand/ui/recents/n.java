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

final class n
  extends v
{
  final ArrayList<AppBrandLauncherRecentsList.e> lJA;
  boolean lJB;
  boolean lJi;
  boolean lJj;
  private final RecyclerView.f.a lJk;
  final Set<RecyclerView.f.a> lJl;
  private final Interpolator lJm;
  private final ArrayList<b> lJn;
  final ArrayList<RecyclerView.v> lJo;
  private final ArrayList<d> lJp;
  final ArrayList<RecyclerView.v> lJq;
  private final ArrayList<AppBrandLauncherRecentsList.e> lJr;
  final ArrayList<AppBrandLauncherRecentsList.e> lJs;
  private final ArrayList<AppBrandLauncherRecentsList.e> lJt;
  final ArrayList<AppBrandLauncherRecentsList.e> lJu;
  private final ArrayList<f> lJv;
  final ArrayList<AppBrandLauncherRecentsList.e> lJw;
  private final ArrayList<RecyclerView.v> lJx;
  private final ArrayList<AppBrandLauncherRecentsList.e> lJy;
  final ArrayList<AppBrandLauncherRecentsList.e> lJz;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.lJi = false;
    this.lJj = true;
    this.lJk = new RecyclerView.f.a()
    {
      public final void kV()
      {
        AppMethodBeat.i(49231);
        Iterator localIterator = n.this.lJl.iterator();
        while (localIterator.hasNext()) {
          ((RecyclerView.f.a)localIterator.next()).kV();
        }
        n.this.lJB = false;
        AppMethodBeat.o(49231);
      }
    };
    this.lJl = new HashSet();
    this.lJm = new AccelerateDecelerateInterpolator();
    this.lJn = new ArrayList();
    this.lJo = new ArrayList();
    this.lJp = new ArrayList();
    this.lJq = new ArrayList();
    this.lJr = new ArrayList();
    this.lJs = new ArrayList();
    this.lJt = new ArrayList();
    this.lJu = new ArrayList();
    this.lJv = new ArrayList();
    this.lJw = new ArrayList();
    this.lJx = new ArrayList();
    this.lJy = new ArrayList();
    this.lJz = new ArrayList();
    this.lJA = new ArrayList();
    this.lJB = false;
    AppMethodBeat.o(49247);
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49250);
    paramv.arI.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramv);
    t.e(paramv.arI, 0.0F);
    t.f(paramv.arI, 1.0F);
    AppMethodBeat.o(49250);
  }
  
  public final void A(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49253);
    super.A(paramv);
    if (!this.lJw.contains(paramv)) {
      this.lJB = true;
    }
    AppMethodBeat.o(49253);
  }
  
  public final void C(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49263);
    super.C(paramv);
    if (this.lJx.contains(paramv)) {
      ((RecentsRecyclerView)paramv.arI.getParent()).cN(paramv.arI);
    }
    AppMethodBeat.o(49263);
  }
  
  public final void D(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49264);
    super.D(paramv);
    if (this.lJx.contains(paramv))
    {
      this.lJx.remove(paramv);
      ((RecentsRecyclerView)paramv.arI.getParent()).cO(paramv.arI);
    }
    AppMethodBeat.o(49264);
  }
  
  public final RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
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
            params = new c((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(49265);
            return params;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            params = new e((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(49265);
            return params;
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.aqt = paramInt;
    AppMethodBeat.o(49265);
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49254);
    if ((!(paramv instanceof AppBrandLauncherRecentsList.e)) || (!this.lJj))
    {
      e(paramv);
      x(paramv);
      AppMethodBeat.o(49254);
      return false;
    }
    boolean bool = super.a(paramv, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(49254);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49260);
    if (t.ag(paramv1.arI) == null)
    {
      t.f(paramv1.arI, 1.0F);
      t.e(paramv1.arI, 0.0F);
    }
    if (t.ag(paramv2.arI) == null)
    {
      t.f(paramv2.arI, 1.0F);
      t.e(paramv2.arI, 0.0F);
    }
    n(paramv1);
    n(paramv2);
    AppMethodBeat.o(49260);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49266);
    if (!this.lJj)
    {
      n(paramv1);
      n(paramv2);
      AppMethodBeat.o(49266);
      return false;
    }
    boolean bool = super.a(paramv1, paramv2, paramc1, paramc2);
    AppMethodBeat.o(49266);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(49267);
    boolean bool = super.a(paramv, paramList);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) || (bool))
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
      this.lJl.add(parama);
    }
    AppMethodBeat.o(49248);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49259);
    if (!this.lJj)
    {
      e(paramv);
      w(paramv);
      AppMethodBeat.o(49259);
      return false;
    }
    boolean bool = super.b(paramv);
    AppMethodBeat.o(49259);
    return bool;
  }
  
  final void c(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(49249);
    if (parama != null) {
      this.lJl.remove(parama);
    }
    AppMethodBeat.o(49249);
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49255);
    e(paramv);
    n(paramv);
    AppMethodBeat.o(49255);
    return false;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49256);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) && (this.lJy.remove(paramv)))
    {
      t.e(paramv.arI, 0.0F);
      n(paramv);
    }
    super.d(paramv);
    AppMethodBeat.o(49256);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49258);
    if (!this.lJj)
    {
      e(paramv);
      w(paramv);
      AppMethodBeat.o(49258);
      return false;
    }
    if ((paramc1 instanceof c))
    {
      e(paramv);
      AppMethodBeat.o(49258);
      return true;
    }
    if ((paramc1 instanceof e))
    {
      e(paramv);
      AppMethodBeat.o(49258);
      return true;
    }
    if (((paramc1.aqt & 0x800) > 0) && ((paramv instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramv).bpH().iVe;
        if (!bool)
        {
          e(paramv);
          this.lJv.add(new f((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top, (byte)0));
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
    boolean bool = super.d(paramv, paramc1, paramc2);
    AppMethodBeat.o(49258);
    return bool;
  }
  
  public final boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49257);
    if (!this.lJj)
    {
      bool = c(paramv);
      AppMethodBeat.o(49257);
      return bool;
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)))
    {
      bool = super.a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(49257);
      return bool;
    }
    if ((this.lJi) && ((paramv.arI.getParent() instanceof RecyclerView)) && ((paramv instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramv.arI.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          t.e(paramv.arI, paramv.arI.getHeight());
          this.lJy.add(paramv);
          AppMethodBeat.o(49257);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          t.e(paramv.arI, -paramv.arI.getHeight());
          this.lJy.add(paramv);
          AppMethodBeat.o(49257);
          return true;
        }
      }
    }
    boolean bool = c(paramv);
    AppMethodBeat.o(49257);
    return bool;
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49261);
    if (!this.lJj)
    {
      e(paramv);
      x(paramv);
      AppMethodBeat.o(49261);
      return false;
    }
    boolean bool = super.f(paramv, paramc1, paramc2);
    AppMethodBeat.o(49261);
    return bool;
  }
  
  public final void iW()
  {
    AppMethodBeat.i(49252);
    a(this.lJk);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.lJn.isEmpty())
    {
      localObject1 = this.lJn.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.lJo.add(((b)localObject2).lJF);
        localObject3 = ((b)localObject2).lJF;
        localObject4 = ((b)localObject2).lJF.arI;
        ((b)localObject2).lJF.lIA.setVisibility(0);
        t.e((View)localObject4, 0.0F);
        localObject5 = t.ag((View)localObject4);
        double d1 = ((b)localObject2).ajN / ((b)localObject2).lJF.arI.getHeight();
        double d2 = this.aqr;
        ((x)localObject5).h(Math.max(this.aqr, Math.min(Math.round(d1 * d2) + this.aqr, 400L)));
        ((x)localObject5).a(this.lJm);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49232);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cN(paramAnonymousView);
            n.this.A(this.ajC);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cO(paramAnonymousView);
            this.lJD.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.ajC);
            n.this.lJo.remove(this.ajC);
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
        ((x)localObject5).x(-((b)localObject2).ajN - ((View)localObject4).getHeight()).start();
      }
      this.lJn.clear();
    }
    if (!this.lJp.isEmpty())
    {
      localObject1 = this.lJp.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        this.lJq.add(((d)localObject2).lJF);
        localObject3 = ((d)localObject2).lJF;
        localObject5 = ((d)localObject2).lJF.arI;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((d)localObject2).lJF.lIA.setVisibility(8);
        t.e((View)localObject5, 0.0F);
        localObject5 = t.ag((View)localObject5);
        ((x)localObject5).h(this.aqr);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49235);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cN(paramAnonymousView);
            n.this.A(this.ajC);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cO(paramAnonymousView);
            this.lJD.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.ajC);
            n.this.lJq.remove(this.ajC);
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
        ((x)localObject5).x(((RecentsRecyclerView)localObject4).getHeight() - ((d)localObject2).ajN).start();
      }
      this.lJp.clear();
    }
    if (!this.lJr.isEmpty())
    {
      localObject1 = this.lJr.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.lJs.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).lIA, 0.1F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).lIA, 0.1F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).lIA, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).lIA.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).lIA);
        ((x)localObject3).h(this.aqs);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.lJD.a(null);
            n.this.n(this.lJE);
            n.this.lJs.remove(this.lJE);
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
        ((x)localObject3).w(1.0F).y(1.0F).z(1.0F).start();
      }
      this.lJr.clear();
    }
    if (!this.lJt.isEmpty())
    {
      localObject1 = this.lJt.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.lJu.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).lIA, 1.0F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).lIA, 1.0F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).lIA, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).lIA.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).lIA);
        ((x)localObject3).h(this.aqs);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            t.g(this.lJE.lIA, 1.0F);
            t.h(this.lJE.lIA, 1.0F);
            t.f(this.lJE.lIA, 1.0F);
            this.lJE.lIA.setVisibility(8);
            n.this.n(this.lJE);
            n.this.lJu.remove(this.lJE);
            n.a(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((x)localObject3).w(0.0F).y(0.1F).z(0.1F).start();
      }
      this.lJt.clear();
    }
    if (!this.lJv.isEmpty())
    {
      localObject1 = this.lJv.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        this.lJw.add(((f)localObject3).lJF);
        localObject2 = ((f)localObject3).lJF.arI;
        t.e((View)localObject2, 0.0F);
        t.f((View)localObject2, 1.0F);
        localObject3 = ((f)localObject3).lJF;
        localObject4 = t.ag((View)localObject2);
        ((x)localObject4).h(this.aqr);
        ((x)localObject4).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.A(this.lJE);
            AppMethodBeat.o(49241);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            n.this.w(this.lJE);
            n.this.lJw.remove(this.lJE);
            n.a(n.this);
            AppMethodBeat.o(49242);
          }
        });
        ((x)localObject4).w(0.0F).x(-((View)localObject2).getHeight()).start();
      }
      this.lJv.clear();
    }
    super.iW();
    if (!this.lJy.isEmpty())
    {
      this.lJz.addAll(this.lJy);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.this.lJz.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n localn = n.this;
            x localx = t.ag(locale.arI);
            localn.lJA.add(locale);
            localx.x(0.0F).h(localn.aqr).a(new n.8(localn, locale, localx)).start();
          }
          n.this.lJz.clear();
          AppMethodBeat.o(49243);
        }
      };
      this.lJy.clear();
      if (this.lJB)
      {
        t.a(((AppBrandLauncherRecentsList.e)this.lJz.get(0)).arI, (Runnable)localObject1, kQ());
        AppMethodBeat.o(49252);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(49252);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49251);
    if ((!this.lJn.isEmpty()) || (!this.lJo.isEmpty()) || (!this.lJp.isEmpty()) || (!this.lJq.isEmpty()) || (!this.lJr.isEmpty()) || (!this.lJs.isEmpty()) || (!this.lJt.isEmpty()) || (!this.lJu.isEmpty()) || (!this.lJv.isEmpty()) || (!this.lJw.isEmpty()) || (!this.lJy.isEmpty()) || (!this.lJz.isEmpty()) || (!this.lJA.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void o(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49262);
    super.o(paramv);
    ViewParent localViewParent = paramv.arI.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).cO(paramv.arI);
    }
    AppMethodBeat.o(49262);
  }
  
  static class a
    extends RecyclerView.f.c
  {
    public final RecyclerView.f.c c(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(49246);
      super.c(paramv, paramInt);
      this.aqt = paramInt;
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
    int ajM;
    int ajN;
    AppBrandLauncherRecentsList.e lJF;
    
    private f(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.lJF = parame;
      this.ajM = paramInt1;
      this.ajN = paramInt2;
    }
  }
  
  static class g
  {
    int ajN;
    AppBrandLauncherRecentsList.e lJF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */