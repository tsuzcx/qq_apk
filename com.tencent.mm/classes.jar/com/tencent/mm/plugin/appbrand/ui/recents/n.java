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
  boolean mLH;
  boolean mLI;
  private final RecyclerView.f.a mLJ;
  final Set<RecyclerView.f.a> mLK;
  private final Interpolator mLL;
  private final ArrayList<b> mLM;
  final ArrayList<RecyclerView.w> mLN;
  private final ArrayList<d> mLO;
  final ArrayList<RecyclerView.w> mLP;
  private final ArrayList<AppBrandLauncherRecentsList.e> mLQ;
  final ArrayList<AppBrandLauncherRecentsList.e> mLR;
  private final ArrayList<AppBrandLauncherRecentsList.e> mLS;
  final ArrayList<AppBrandLauncherRecentsList.e> mLT;
  private final ArrayList<f> mLU;
  final ArrayList<AppBrandLauncherRecentsList.e> mLV;
  private final ArrayList<RecyclerView.w> mLW;
  private final ArrayList<AppBrandLauncherRecentsList.e> mLX;
  final ArrayList<AppBrandLauncherRecentsList.e> mLY;
  final ArrayList<AppBrandLauncherRecentsList.e> mLZ;
  boolean mMa;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.mLH = false;
    this.mLI = true;
    this.mLJ = new RecyclerView.f.a()
    {
      public final void lv()
      {
        AppMethodBeat.i(49231);
        synchronized (n.this.mLK)
        {
          Iterator localIterator = new HashSet(n.this.mLK).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).lv();
          }
        }
        n.this.mMa = false;
        AppMethodBeat.o(49231);
      }
    };
    this.mLK = new HashSet();
    this.mLL = new AccelerateDecelerateInterpolator();
    this.mLM = new ArrayList();
    this.mLN = new ArrayList();
    this.mLO = new ArrayList();
    this.mLP = new ArrayList();
    this.mLQ = new ArrayList();
    this.mLR = new ArrayList();
    this.mLS = new ArrayList();
    this.mLT = new ArrayList();
    this.mLU = new ArrayList();
    this.mLV = new ArrayList();
    this.mLW = new ArrayList();
    this.mLX = new ArrayList();
    this.mLY = new ArrayList();
    this.mLZ = new ArrayList();
    this.mMa = false;
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
    if (!this.mLV.contains(paramw)) {
      this.mMa = true;
    }
    AppMethodBeat.o(49253);
  }
  
  public final void C(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49263);
    super.C(paramw);
    if (this.mLW.contains(paramw)) {
      ((RecentsRecyclerView)paramw.auu.getParent()).cR(paramw.auu);
    }
    AppMethodBeat.o(49263);
  }
  
  public final void D(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49264);
    super.D(paramw);
    if (this.mLW.contains(paramw))
    {
      this.mLW.remove(paramw);
      ((RecentsRecyclerView)paramw.auu.getParent()).cS(paramw.auu);
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
    if (!this.mLI)
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
    if (!this.mLI)
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
      synchronized (this.mLK)
      {
        this.mLK.add(parama);
        AppMethodBeat.o(49248);
        return;
      }
    }
    AppMethodBeat.o(49248);
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49259);
    if (!this.mLI)
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
      synchronized (this.mLK)
      {
        this.mLK.remove(parama);
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
    if (((paramw instanceof AppBrandLauncherRecentsList.e)) && (this.mLX.remove(paramw)))
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
    if (!this.mLI)
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
        bool = ((AppBrandLauncherRecentsList.e)paramw).bAJ().jPn;
        if (!bool)
        {
          e(paramw);
          this.mLU.add(new f((AppBrandLauncherRecentsList.e)paramw, paramc1.left, paramc1.top, (byte)0));
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
    if (!this.mLI)
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
    if ((this.mLH) && ((paramw.auu.getParent() instanceof RecyclerView)) && ((paramw instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramw.auu.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.auu, paramw.auu.getHeight());
          this.mLX.add(paramw);
          AppMethodBeat.o(49257);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramw = (AppBrandLauncherRecentsList.e)paramw;
          t.e(paramw.auu, -paramw.auu.getHeight());
          this.mLX.add(paramw);
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
    if (!this.mLI)
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
    if ((!this.mLM.isEmpty()) || (!this.mLN.isEmpty()) || (!this.mLO.isEmpty()) || (!this.mLP.isEmpty()) || (!this.mLQ.isEmpty()) || (!this.mLR.isEmpty()) || (!this.mLS.isEmpty()) || (!this.mLT.isEmpty()) || (!this.mLU.isEmpty()) || (!this.mLV.isEmpty()) || (!this.mLX.isEmpty()) || (!this.mLY.isEmpty()) || (!this.mLZ.isEmpty()) || (super.isRunning()))
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
    a(this.mLJ);
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!this.mLM.isEmpty())
    {
      localObject1 = this.mLM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b)((Iterator)localObject1).next();
        this.mLN.add(((b)localObject2).mMe);
        localObject3 = ((b)localObject2).mMe;
        localObject4 = ((b)localObject2).mMe.auu;
        ((b)localObject2).mMe.mKY.setVisibility(0);
        t.e((View)localObject4, 0.0F);
        localObject5 = t.ag((View)localObject4);
        double d1 = ((b)localObject2).amy / ((b)localObject2).mMe.auu.getHeight();
        double d2 = this.ate;
        ((x)localObject5).j(Math.max(this.ate, Math.min(Math.round(d1 * d2) + this.ate, 400L)));
        ((x)localObject5).a(this.mLL);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49232);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cR(paramAnonymousView);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cS(paramAnonymousView);
            this.mMc.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.amn);
            n.this.mLN.remove(this.amn);
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
      this.mLM.clear();
    }
    if (!this.mLO.isEmpty())
    {
      localObject1 = this.mLO.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (d)((Iterator)localObject1).next();
        this.mLP.add(((d)localObject2).mMe);
        localObject3 = ((d)localObject2).mMe;
        localObject5 = ((d)localObject2).mMe.auu;
        localObject4 = (RecentsRecyclerView)((View)localObject5).getParent();
        ((d)localObject2).mMe.mKY.setVisibility(8);
        t.e((View)localObject5, 0.0F);
        localObject5 = t.ag((View)localObject5);
        ((x)localObject5).j(this.ate);
        ((x)localObject5).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49235);
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cR(paramAnonymousView);
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
            ((RecentsRecyclerView)paramAnonymousView.getParent()).cS(paramAnonymousView);
            this.mMc.a(null);
            t.e(paramAnonymousView, 0.0F);
            n.this.w(this.amn);
            n.this.mLP.remove(this.amn);
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
      this.mLO.clear();
    }
    if (!this.mLQ.isEmpty())
    {
      localObject1 = this.mLQ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mLR.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mKY, 0.1F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mKY, 0.1F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mKY, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mKY.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mKY);
        ((x)localObject3).j(this.atf);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.mMc.a(null);
            n.this.n(this.mMd);
            n.this.mLR.remove(this.mMd);
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
      this.mLQ.clear();
    }
    if (!this.mLS.isEmpty())
    {
      localObject1 = this.mLS.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.mLT.add(localObject2);
        t.g(((AppBrandLauncherRecentsList.e)localObject2).mKY, 1.0F);
        t.h(((AppBrandLauncherRecentsList.e)localObject2).mKY, 1.0F);
        t.f(((AppBrandLauncherRecentsList.e)localObject2).mKY, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).mKY.setVisibility(0);
        localObject3 = t.ag(((AppBrandLauncherRecentsList.e)localObject2).mKY);
        ((x)localObject3).j(this.atf);
        ((x)localObject3).a(new z()
        {
          public final void aH(View paramAnonymousView) {}
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            t.g(this.mMd.mKY, 1.0F);
            t.h(this.mMd.mKY, 1.0F);
            t.f(this.mMd.mKY, 1.0F);
            this.mMd.mKY.setVisibility(8);
            n.this.n(this.mMd);
            n.this.mLT.remove(this.mMd);
            n.a(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((x)localObject3).y(0.0F).A(0.1F).B(0.1F).start();
      }
      this.mLS.clear();
    }
    if (!this.mLU.isEmpty())
    {
      localObject1 = this.mLU.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (f)((Iterator)localObject1).next();
        this.mLV.add(((f)localObject3).mMe);
        localObject2 = ((f)localObject3).mMe.auu;
        t.e((View)localObject2, 0.0F);
        t.f((View)localObject2, 1.0F);
        localObject3 = ((f)localObject3).mMe;
        localObject4 = t.ag((View)localObject2);
        ((x)localObject4).j(this.ate);
        ((x)localObject4).a(new z()
        {
          public final void aH(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.A(this.mMd);
            AppMethodBeat.o(49241);
          }
          
          public final void aI(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            t.e(paramAnonymousView, 0.0F);
            t.f(paramAnonymousView, 1.0F);
            n.this.w(this.mMd);
            n.this.mLV.remove(this.mMd);
            n.a(n.this);
            AppMethodBeat.o(49242);
          }
        });
        ((x)localObject4).y(0.0F).z(-((View)localObject2).getHeight()).start();
      }
      this.mLU.clear();
    }
    super.ju();
    if (!this.mLX.isEmpty())
    {
      this.mLY.addAll(this.mLX);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.this.mLY.iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n localn = n.this;
            x localx = t.ag(locale.auu);
            localn.mLZ.add(locale);
            localx.z(0.0F).j(localn.ate).a(new n.8(localn, locale, localx)).start();
          }
          n.this.mLY.clear();
          AppMethodBeat.o(49243);
        }
      };
      this.mLX.clear();
      if (this.mMa)
      {
        t.a(((AppBrandLauncherRecentsList.e)this.mLY.get(0)).auu, (Runnable)localObject1, lq());
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
      ((RecentsRecyclerView)localViewParent).cS(paramw.auu);
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
    AppBrandLauncherRecentsList.e mMe;
    
    private f(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.mMe = parame;
      this.amx = paramInt1;
      this.amy = paramInt2;
    }
  }
  
  static class g
  {
    int amy;
    AppBrandLauncherRecentsList.e mMe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */