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
  boolean mQJ;
  boolean mQK;
  private final RecyclerView.f.a mQL;
  final Set<RecyclerView.f.a> mQM;
  private final Interpolator mQN;
  private final ArrayList<b> mQO;
  final ArrayList<RecyclerView.w> mQP;
  private final ArrayList<d> mQR;
  final ArrayList<RecyclerView.w> mQS;
  private final ArrayList<AppBrandLauncherRecentsList.e> mQT;
  final ArrayList<AppBrandLauncherRecentsList.e> mQU;
  private final ArrayList<AppBrandLauncherRecentsList.e> mQV;
  final ArrayList<AppBrandLauncherRecentsList.e> mQW;
  private final ArrayList<f> mQX;
  final ArrayList<AppBrandLauncherRecentsList.e> mQY;
  private final ArrayList<RecyclerView.w> mQZ;
  private final ArrayList<AppBrandLauncherRecentsList.e> mRa;
  final ArrayList<AppBrandLauncherRecentsList.e> mRb;
  final ArrayList<AppBrandLauncherRecentsList.e> mRc;
  boolean mRd;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.mQJ = false;
    this.mQK = true;
    this.mQL = new RecyclerView.f.a()
    {
      public final void lv()
      {
        AppMethodBeat.i(49231);
        synchronized (n.this.mQM)
        {
          Iterator localIterator = new HashSet(n.this.mQM).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).lv();
          }
        }
        n.this.mRd = false;
        AppMethodBeat.o(49231);
      }
    };
    this.mQM = new HashSet();
    this.mQN = new AccelerateDecelerateInterpolator();
    this.mQO = new ArrayList();
    this.mQP = new ArrayList();
    this.mQR = new ArrayList();
    this.mQS = new ArrayList();
    this.mQT = new ArrayList();
    this.mQU = new ArrayList();
    this.mQV = new ArrayList();
    this.mQW = new ArrayList();
    this.mQX = new ArrayList();
    this.mQY = new ArrayList();
    this.mQZ = new ArrayList();
    this.mRa = new ArrayList();
    this.mRb = new ArrayList();
    this.mRc = new ArrayList();
    this.mRd = false;
    AppMethodBeat.o(49247);
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49250);
    paramw.auu.animate().setInterpolator(new ValueAnimator().getInterpolator());
    d(paramw);
    t.e(paramw.auu, 0.0F);
    t.f(paramw.auu, 1.0F);
    AppMethodBeat.o(49250);
  }
  
  public final void A(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49253);
    super.A(paramw);
    if (!this.mQY.contains(paramw)) {
      this.mRd = true;
    }
    AppMethodBeat.o(49253);
  }
  
  public final void C(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49263);
    super.C(paramw);
    if (this.mQZ.contains(paramw)) {
      ((RecentsRecyclerView)paramw.auu.getParent()).cS(paramw.auu);
    }
    AppMethodBeat.o(49263);
  }
  
  public final void D(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49264);
    super.D(paramw);
    if (this.mQZ.contains(paramw))
    {
      this.mQZ.remove(paramw);
      ((RecentsRecyclerView)paramw.auu.getParent()).cT(paramw.auu);
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
    paramt.atg = paramInt;
    AppMethodBeat.o(49265);
    return paramt;
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49254);
    if (!this.mQK)
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
    if (t.ag(paramw1.auu) == null)
    {
      t.f(paramw1.auu, 1.0F);
      t.e(paramw1.auu, 0.0F);
    }
    if (t.ag(paramw2.auu) == null)
    {
      t.f(paramw2.auu, 1.0F);
      t.e(paramw2.auu, 0.0F);
    }
    n(paramw1);
    n(paramw2);
    AppMethodBeat.o(49260);
    return false;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49266);
    if (!this.mQK)
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
      synchronized (this.mQM)
      {
        this.mQM.add(parama);
        AppMethodBeat.o(49248);
        return;
      }
    }
    AppMethodBeat.o(49248);
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49259);
    if (!this.mQK)
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
      synchronized (this.mQM)
      {
        this.mQM.remove(parama);
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
    if (((paramw instanceof AppBrandLauncherRecentsList.e)) && (this.mRa.remove(paramw)))
    {
      t.e(paramw.auu, 0.0F);
      n(paramw);
    }
    super.d(paramw);
    AppMethodBeat.o(49256);
  }
  
  public final boolean d(RecyclerView.w paramw, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(49258);
    if (!this.mQK)
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
    if (((paramc1.atg & 0x800) > 0) && ((paramw instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramw).bBD().jSF;
        if (!bool)
        {
          e(paramw);
          this.mQX.add(new f((AppBrandLauncherRecentsList.e)paramw, paramc1.left, paramc1.top, (byte)0));
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
    if (!this.mQK)
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
    if ((this.mQJ) && ((paramw.auu.getParent() instanceof RecyclerView)) && ((paramw instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramw.auu.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.auu, paramw.auu.getHeight());
          this.mRa.add(paramw);
          AppMethodBeat.o(49257);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.auu, -paramw.auu.getHeight());
          this.mRa.add(paramw);
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
    if (!this.mQK)
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
    if ((!this.mQO.isEmpty()) || (!this.mQP.isEmpty()) || (!this.mQR.isEmpty()) || (!this.mQS.isEmpty()) || (!this.mQT.isEmpty()) || (!this.mQU.isEmpty()) || (!this.mQV.isEmpty()) || (!this.mQW.isEmpty()) || (!this.mQX.isEmpty()) || (!this.mQY.isEmpty()) || (!this.mRa.isEmpty()) || (!this.mRb.isEmpty()) || (!this.mRc.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void ju()
  {
    AppMethodBeat.i(49252);
    a(this.mQL);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.mQO.isEmpty())
    {
      localObject1 = this.mQO.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.mQP.add(((b)localObject2).mRh);
        localObject3 = ((b)localObject2).mRh;
        localObject4 = ((b)localObject2).mRh.auu;
        ((b)localObject2).mRh.mQa.setVisibility(0);
        t.e((View)localObject4, 0.0F);
        localObject5 = t.ag((View)localObject4);
        double d1 = ((b)localObject2).amy / ((b)localObject2).mRh.auu.getHeight();
        double d2 = this.ate;
        ((x)localObject5).j(Math.max(this.ate, Math.min(Math.round(d1 * d2) + this.ate, 400L)));
        ((x)localObject5).a(this.mQN);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49232);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cS(paramAnonymousView);
            n.this.A(this.amn);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cT(paramAnonymousView);
            this.mRf.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.amn);
            n.this.mQP.remove(this.amn);
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
        ((x)localObject5).z(-((b)localObject2).amy - ((View)localObject4).getHeight()).start();
      }
      this.mQO.clear();
    }
    if (!this.mQR.isEmpty())
    {
      localObject1 = this.mQR.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        this.mQS.add(((d)localObject2).mRh);
        localObject3 = ((d)localObject2).mRh;
        localObject5 = ((d)localObject2).mRh.auu;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((d)localObject2).mRh.mQa.setVisibility(8);
        t.e((View)localObject5, 0.0F);
        localObject5 = t.ag((View)localObject5);
        ((x)localObject5).j(this.ate);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49235);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cS(paramAnonymousView);
            n.this.A(this.amn);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cT(paramAnonymousView);
            this.mRf.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.amn);
            n.this.mQS.remove(this.amn);
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
        ((x)localObject5).z(((RecentsRecyclerView)localObject4).getHeight() - ((d)localObject2).amy).start();
      }
      this.mQR.clear();
    }
    if (!this.mQT.isEmpty())
    {
      localObject1 = this.mQT.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mQU.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mQa, 0.1F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mQa, 0.1F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mQa, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mQa.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mQa);
        ((x)localObject3).j(this.atf);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.mRf.a(null);
            n.this.n(this.mRg);
            n.this.mQU.remove(this.mRg);
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
        ((x)localObject3).y(1.0F).A(1.0F).B(1.0F).start();
      }
      this.mQT.clear();
    }
    if (!this.mQV.isEmpty())
    {
      localObject1 = this.mQV.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mQW.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mQa, 1.0F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mQa, 1.0F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mQa, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mQa.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mQa);
        ((x)localObject3).j(this.atf);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            t.g(this.mRg.mQa, 1.0F);
            t.h(this.mRg.mQa, 1.0F);
            t.f(this.mRg.mQa, 1.0F);
            this.mRg.mQa.setVisibility(8);
            n.this.n(this.mRg);
            n.this.mQW.remove(this.mRg);
            n.a(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((x)localObject3).y(0.0F).A(0.1F).B(0.1F).start();
      }
      this.mQV.clear();
    }
    if (!this.mQX.isEmpty())
    {
      localObject1 = this.mQX.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        this.mQY.add(((f)localObject3).mRh);
        localObject2 = ((f)localObject3).mRh.auu;
        t.e((View)localObject2, 0.0F);
        t.f((View)localObject2, 1.0F);
        localObject3 = ((f)localObject3).mRh;
        localObject4 = t.ag((View)localObject2);
        ((x)localObject4).j(this.ate);
        ((x)localObject4).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.A(this.mRg);
            AppMethodBeat.o(49241);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            n.this.w(this.mRg);
            n.this.mQY.remove(this.mRg);
            n.a(n.this);
            AppMethodBeat.o(49242);
          }
        });
        ((x)localObject4).y(0.0F).z(-((View)localObject2).getHeight()).start();
      }
      this.mQX.clear();
    }
    super.ju();
    if (!this.mRa.isEmpty())
    {
      this.mRb.addAll(this.mRa);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.this.mRb.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n localn = n.this;
            x localx = t.ag(locale.auu);
            localn.mRc.add(locale);
            localx.z(0.0F).j(localn.ate).a(new n.8(localn, locale, localx)).start();
          }
          n.this.mRb.clear();
          AppMethodBeat.o(49243);
        }
      };
      this.mRa.clear();
      if (this.mRd)
      {
        t.a(((AppBrandLauncherRecentsList.e)this.mRb.get(0)).auu, (Runnable)localObject1, lq());
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
    ViewParent localViewParent = paramw.auu.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).cT(paramw.auu);
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
      this.atg = paramInt;
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
    int amx;
    int amy;
    AppBrandLauncherRecentsList.e mRh;
    
    private f(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.mRh = parame;
      this.amx = paramInt1;
      this.amy = paramInt2;
    }
  }
  
  static class g
  {
    int amy;
    AppBrandLauncherRecentsList.e mRh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */