package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v4.view.aa;
import android.support.v4.view.u;
import android.support.v4.view.y;
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
  boolean odN;
  boolean odO;
  private final RecyclerView.f.a odP;
  final Set<RecyclerView.f.a> odQ;
  private final Interpolator odR;
  private final ArrayList<b> odS;
  final ArrayList<RecyclerView.v> odT;
  private final ArrayList<d> odU;
  final ArrayList<RecyclerView.v> odV;
  private final ArrayList<AppBrandLauncherRecentsList.e> odW;
  final ArrayList<AppBrandLauncherRecentsList.e> odX;
  private final ArrayList<AppBrandLauncherRecentsList.e> odY;
  final ArrayList<AppBrandLauncherRecentsList.e> odZ;
  private final ArrayList<f> oea;
  final ArrayList<AppBrandLauncherRecentsList.e> oeb;
  private final ArrayList<RecyclerView.v> oec;
  private final ArrayList<AppBrandLauncherRecentsList.e> oed;
  final ArrayList<AppBrandLauncherRecentsList.e> oee;
  final ArrayList<AppBrandLauncherRecentsList.e> oef;
  boolean oeg;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.odN = false;
    this.odO = true;
    this.odP = new RecyclerView.f.a()
    {
      public final void lD()
      {
        AppMethodBeat.i(49231);
        synchronized (n.this.odQ)
        {
          Iterator localIterator = new HashSet(n.this.odQ).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).lD();
          }
        }
        n.this.oeg = false;
        AppMethodBeat.o(49231);
      }
    };
    this.odQ = new HashSet();
    this.odR = new AccelerateDecelerateInterpolator();
    this.odS = new ArrayList();
    this.odT = new ArrayList();
    this.odU = new ArrayList();
    this.odV = new ArrayList();
    this.odW = new ArrayList();
    this.odX = new ArrayList();
    this.odY = new ArrayList();
    this.odZ = new ArrayList();
    this.oea = new ArrayList();
    this.oeb = new ArrayList();
    this.oec = new ArrayList();
    this.oed = new ArrayList();
    this.oee = new ArrayList();
    this.oef = new ArrayList();
    this.oeg = false;
    AppMethodBeat.o(49247);
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49250);
    paramv.aus.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramv);
    u.f(paramv.aus, 0.0F);
    u.g(paramv.aus, 1.0F);
    AppMethodBeat.o(49250);
  }
  
  public final void C(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49253);
    super.C(paramv);
    if (!this.oeb.contains(paramv)) {
      this.oeg = true;
    }
    AppMethodBeat.o(49253);
  }
  
  public final void E(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49263);
    super.E(paramv);
    if (this.oec.contains(paramv)) {
      ((RecentsRecyclerView)paramv.aus.getParent()).cJ(paramv.aus);
    }
    AppMethodBeat.o(49263);
  }
  
  public final void F(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49264);
    super.F(paramv);
    if (this.oec.contains(paramv))
    {
      this.oec.remove(paramv);
      ((RecentsRecyclerView)paramv.aus.getParent()).cK(paramv.aus);
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
            params = new n.c((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(49265);
            return params;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            params = new n.e((byte)0).c(paramv, paramInt);
            AppMethodBeat.o(49265);
            return params;
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.atr = paramInt;
    AppMethodBeat.o(49265);
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49254);
    if (!this.odO)
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
    if (u.ah(paramv1.aus) == null)
    {
      u.g(paramv1.aus, 1.0F);
      u.f(paramv1.aus, 0.0F);
    }
    if (u.ah(paramv2.aus) == null)
    {
      u.g(paramv2.aus, 1.0F);
      u.f(paramv2.aus, 0.0F);
    }
    n(paramv1);
    n(paramv2);
    AppMethodBeat.o(49260);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49266);
    if (!this.odO)
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
      synchronized (this.odQ)
      {
        this.odQ.add(parama);
        AppMethodBeat.o(49248);
        return;
      }
    }
    AppMethodBeat.o(49248);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49259);
    if (!this.odO)
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
      synchronized (this.odQ)
      {
        this.odQ.remove(parama);
        AppMethodBeat.o(49249);
        return;
      }
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
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) && (this.oed.remove(paramv)))
    {
      u.f(paramv.aus, 0.0F);
      n(paramv);
    }
    super.d(paramv);
    AppMethodBeat.o(49256);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49258);
    if (!this.odO)
    {
      e(paramv);
      w(paramv);
      AppMethodBeat.o(49258);
      return false;
    }
    if ((paramc1 instanceof n.c))
    {
      e(paramv);
      AppMethodBeat.o(49258);
      return true;
    }
    if ((paramc1 instanceof n.e))
    {
      e(paramv);
      AppMethodBeat.o(49258);
      return true;
    }
    if (((paramc1.atr & 0x800) > 0) && ((paramv instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramv).bYC().kVp;
        if (!bool)
        {
          e(paramv);
          this.oea.add(new f((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top, (byte)0));
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
    if (!this.odO)
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
    if ((this.odN) && ((paramv.aus.getParent() instanceof RecyclerView)) && ((paramv instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramv.aus.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          u.f(paramv.aus, paramv.aus.getHeight());
          this.oed.add(paramv);
          AppMethodBeat.o(49257);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          u.f(paramv.aus, -paramv.aus.getHeight());
          this.oed.add(paramv);
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
    if (!this.odO)
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
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49251);
    if ((!this.odS.isEmpty()) || (!this.odT.isEmpty()) || (!this.odU.isEmpty()) || (!this.odV.isEmpty()) || (!this.odW.isEmpty()) || (!this.odX.isEmpty()) || (!this.odY.isEmpty()) || (!this.odZ.isEmpty()) || (!this.oea.isEmpty()) || (!this.oeb.isEmpty()) || (!this.oed.isEmpty()) || (!this.oee.isEmpty()) || (!this.oef.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void jD()
  {
    AppMethodBeat.i(49252);
    a(this.odP);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.odS.isEmpty())
    {
      localObject1 = this.odS.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.odT.add(((b)localObject2).oek);
        localObject3 = ((b)localObject2).oek;
        localObject4 = ((b)localObject2).oek.aus;
        ((b)localObject2).oek.odd.setVisibility(0);
        u.f((View)localObject4, 0.0F);
        localObject5 = u.ah((View)localObject4);
        double d1 = ((b)localObject2).amL / ((b)localObject2).oek.aus.getHeight();
        double d2 = this.atp;
        ((y)localObject5).j(Math.max(this.atp, Math.min(Math.round(d1 * d2) + this.atp, 400L)));
        ((y)localObject5).a(this.odR);
        ((y)localObject5).a(new aa()
        {
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49232);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cJ(paramAnonymousView);
            n.this.C(this.amA);
            AppMethodBeat.o(49232);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49233);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49233);
              return;
            }
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cK(paramAnonymousView);
            this.oei.a(null);
            u.f(paramAnonymousView, 0.0F);
            n.this.w(this.amA);
            n.this.odT.remove(this.amA);
            n.a(n.this);
            AppMethodBeat.o(49233);
          }
          
          public final void aK(View paramAnonymousView)
          {
            AppMethodBeat.i(49234);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49234);
              return;
            }
            u.f(paramAnonymousView, 0.0F);
            u.g(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49234);
          }
        });
        ((y)localObject5).z(-((b)localObject2).amL - ((View)localObject4).getHeight()).start();
      }
      this.odS.clear();
    }
    if (!this.odU.isEmpty())
    {
      localObject1 = this.odU.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        this.odV.add(((d)localObject2).oek);
        localObject3 = ((d)localObject2).oek;
        localObject5 = ((d)localObject2).oek.aus;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((d)localObject2).oek.odd.setVisibility(8);
        u.f((View)localObject5, 0.0F);
        localObject5 = u.ah((View)localObject5);
        ((y)localObject5).j(this.atp);
        ((y)localObject5).a(new aa()
        {
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49235);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cJ(paramAnonymousView);
            n.this.C(this.amA);
            AppMethodBeat.o(49235);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49236);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49236);
              return;
            }
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cK(paramAnonymousView);
            this.oei.a(null);
            u.f(paramAnonymousView, 0.0F);
            n.this.w(this.amA);
            n.this.odV.remove(this.amA);
            n.a(n.this);
            AppMethodBeat.o(49236);
          }
          
          public final void aK(View paramAnonymousView)
          {
            AppMethodBeat.i(49237);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49237);
              return;
            }
            u.f(paramAnonymousView, 0.0F);
            u.g(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49237);
          }
        });
        ((y)localObject5).z(((RecentsRecyclerView)localObject4).getHeight() - ((d)localObject2).amL).start();
      }
      this.odU.clear();
    }
    if (!this.odW.isEmpty())
    {
      localObject1 = this.odW.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.odX.add(localObject2);
        u.h(((AppBrandLauncherRecentsList.e)localObject2).odd, 0.1F);
        u.i(((AppBrandLauncherRecentsList.e)localObject2).odd, 0.1F);
        u.g(((AppBrandLauncherRecentsList.e)localObject2).odd, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).odd.setVisibility(0);
        localObject3 = u.ah(((AppBrandLauncherRecentsList.e)localObject2).odd);
        ((y)localObject3).j(this.atq);
        ((y)localObject3).a(new aa()
        {
          public final void aI(View paramAnonymousView) {}
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.oei.a(null);
            n.this.n(this.oej);
            n.this.odX.remove(this.oej);
            n.a(n.this);
            AppMethodBeat.o(49238);
          }
          
          public final void aK(View paramAnonymousView)
          {
            AppMethodBeat.i(49239);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49239);
              return;
            }
            u.f(paramAnonymousView, 0.0F);
            u.g(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49239);
          }
        });
        ((y)localObject3).y(1.0F).A(1.0F).B(1.0F).start();
      }
      this.odW.clear();
    }
    if (!this.odY.isEmpty())
    {
      localObject1 = this.odY.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.odZ.add(localObject2);
        u.h(((AppBrandLauncherRecentsList.e)localObject2).odd, 1.0F);
        u.i(((AppBrandLauncherRecentsList.e)localObject2).odd, 1.0F);
        u.g(((AppBrandLauncherRecentsList.e)localObject2).odd, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).odd.setVisibility(0);
        localObject3 = u.ah(((AppBrandLauncherRecentsList.e)localObject2).odd);
        ((y)localObject3).j(this.atq);
        ((y)localObject3).a(new aa()
        {
          public final void aI(View paramAnonymousView) {}
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            u.h(this.oej.odd, 1.0F);
            u.i(this.oej.odd, 1.0F);
            u.g(this.oej.odd, 1.0F);
            this.oej.odd.setVisibility(8);
            n.this.n(this.oej);
            n.this.odZ.remove(this.oej);
            n.a(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((y)localObject3).y(0.0F).A(0.1F).B(0.1F).start();
      }
      this.odY.clear();
    }
    if (!this.oea.isEmpty())
    {
      localObject1 = this.oea.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        this.oeb.add(((f)localObject3).oek);
        localObject2 = ((f)localObject3).oek.aus;
        u.f((View)localObject2, 0.0F);
        u.g((View)localObject2, 1.0F);
        localObject3 = ((f)localObject3).oek;
        localObject4 = u.ah((View)localObject2);
        ((y)localObject4).j(this.atp);
        ((y)localObject4).a(new aa()
        {
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.C(this.oej);
            AppMethodBeat.o(49241);
          }
          
          public final void aJ(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            u.f(paramAnonymousView, 0.0F);
            u.g(paramAnonymousView, 1.0F);
            n.this.w(this.oej);
            n.this.oeb.remove(this.oej);
            n.a(n.this);
            AppMethodBeat.o(49242);
          }
        });
        ((y)localObject4).y(0.0F).z(-((View)localObject2).getHeight()).start();
      }
      this.oea.clear();
    }
    super.jD();
    if (!this.oed.isEmpty())
    {
      this.oee.addAll(this.oed);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.this.oee.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n localn = n.this;
            y localy = u.ah(locale.aus);
            localn.oef.add(locale);
            localy.z(0.0F).j(localn.atp).a(new n.8(localn, locale, localy)).start();
          }
          n.this.oee.clear();
          AppMethodBeat.o(49243);
        }
      };
      this.oed.clear();
      if (this.oeg)
      {
        u.a(((AppBrandLauncherRecentsList.e)this.oee.get(0)).aus, (Runnable)localObject1, ly());
        AppMethodBeat.o(49252);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(49252);
  }
  
  public final void o(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49262);
    super.o(paramv);
    ViewParent localViewParent = paramv.aus.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).cK(paramv.aus);
    }
    AppMethodBeat.o(49262);
  }
  
  static final class b
    extends n.g
  {}
  
  static final class d
    extends n.g
  {}
  
  static final class f
  {
    int amK;
    int amL;
    AppBrandLauncherRecentsList.e oek;
    
    private f(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.oek = parame;
      this.amK = paramInt1;
      this.amL = paramInt2;
    }
  }
  
  static class g
  {
    int amL;
    AppBrandLauncherRecentsList.e oek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */