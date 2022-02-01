package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.g.ad;
import androidx.core.g.af;
import androidx.core.g.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.a;
import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class m
  extends f
{
  boolean unA;
  boolean unB;
  private final RecyclerView.f.a unC;
  private final Set<RecyclerView.f.a> unD;
  private final Interpolator unE;
  private final ArrayList<Object> unF;
  private final ArrayList<RecyclerView.v> unG;
  private final ArrayList<Object> unH;
  private final ArrayList<RecyclerView.v> unI;
  private final ArrayList<AppBrandLauncherRecentsList.e> unJ;
  private final ArrayList<AppBrandLauncherRecentsList.e> unK;
  private final ArrayList<AppBrandLauncherRecentsList.e> unL;
  private final ArrayList<AppBrandLauncherRecentsList.e> unM;
  private final ArrayList<d> unN;
  private final ArrayList<AppBrandLauncherRecentsList.e> unO;
  private final ArrayList<RecyclerView.v> unP;
  private final ArrayList<AppBrandLauncherRecentsList.e> unQ;
  private final ArrayList<AppBrandLauncherRecentsList.e> unR;
  private final ArrayList<AppBrandLauncherRecentsList.e> unS;
  private boolean unT;
  
  m()
  {
    AppMethodBeat.i(49247);
    this.unA = false;
    this.unB = true;
    this.unC = new RecyclerView.f.a()
    {
      public final void Kx()
      {
        AppMethodBeat.i(49231);
        synchronized (m.a(m.this))
        {
          Iterator localIterator = new HashSet(m.a(m.this)).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).Kx();
          }
        }
        m.b(m.this);
        AppMethodBeat.o(49231);
      }
    };
    this.unD = new HashSet();
    this.unE = new AccelerateDecelerateInterpolator();
    this.unF = new ArrayList();
    this.unG = new ArrayList();
    this.unH = new ArrayList();
    this.unI = new ArrayList();
    this.unJ = new ArrayList();
    this.unK = new ArrayList();
    this.unL = new ArrayList();
    this.unM = new ArrayList();
    this.unN = new ArrayList();
    this.unO = new ArrayList();
    this.unP = new ArrayList();
    this.unQ = new ArrayList();
    this.unR = new ArrayList();
    this.unS = new ArrayList();
    this.unT = false;
    AppMethodBeat.o(49247);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323085);
    paramv.caK.animate().setInterpolator(new ValueAnimator().getInterpolator());
    c(paramv);
    z.e(paramv.caK, 0.0F);
    z.f(paramv.caK, 1.0F);
    AppMethodBeat.o(323085);
  }
  
  public final void C(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323109);
    super.C(paramv);
    if (!this.unO.contains(paramv)) {
      this.unT = true;
    }
    AppMethodBeat.o(323109);
  }
  
  public final void E(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323121);
    super.E(paramv);
    if (this.unP.contains(paramv))
    {
      RecentsRecyclerView localRecentsRecyclerView = (RecentsRecyclerView)paramv.caK.getParent();
      paramv = paramv.caK;
      if (paramv.getParent() == localRecentsRecyclerView)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramv.setZ(1.0F);
          AppMethodBeat.o(323121);
          return;
        }
        localRecentsRecyclerView.uob = paramv;
      }
    }
    AppMethodBeat.o(323121);
  }
  
  public final void F(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323126);
    super.F(paramv);
    if (this.unP.contains(paramv))
    {
      this.unP.remove(paramv);
      ((RecentsRecyclerView)paramv.caK.getParent()).dM(paramv.caK);
    }
    AppMethodBeat.o(323126);
  }
  
  public final void IW()
  {
    AppMethodBeat.i(49252);
    a(this.unC);
    Object localObject1;
    if (!this.unF.isEmpty())
    {
      localObject1 = this.unF.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        AppMethodBeat.o(49252);
        throw null;
      }
      this.unF.clear();
    }
    if (!this.unH.isEmpty())
    {
      localObject1 = this.unH.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        AppMethodBeat.o(49252);
        throw null;
      }
      this.unH.clear();
    }
    Object localObject2;
    Object localObject3;
    if (!this.unJ.isEmpty())
    {
      localObject1 = this.unJ.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.unK.add(localObject2);
        z.g(((AppBrandLauncherRecentsList.e)localObject2).umR, 0.1F);
        z.h(((AppBrandLauncherRecentsList.e)localObject2).umR, 0.1F);
        z.f(((AppBrandLauncherRecentsList.e)localObject2).umR, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).umR.setVisibility(0);
        localObject3 = z.ac(((AppBrandLauncherRecentsList.e)localObject2).umR);
        ((ad)localObject3).bu(this.bZL);
        ((ad)localObject3).b(new af()
        {
          public final void e(View paramAnonymousView) {}
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.unW.b(null);
            m.this.r(this.unV);
            m.d(m.this).remove(this.unV);
            m.c(m.this);
            AppMethodBeat.o(49238);
          }
          
          public final void k(View paramAnonymousView)
          {
            AppMethodBeat.i(49239);
            if (paramAnonymousView == null)
            {
              AppMethodBeat.o(49239);
              return;
            }
            z.e(paramAnonymousView, 0.0F);
            z.f(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49239);
          }
        });
        ((ad)localObject3).ao(1.0F).aq(1.0F).ar(1.0F).start();
      }
      this.unJ.clear();
    }
    if (!this.unL.isEmpty())
    {
      localObject1 = this.unL.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.unM.add(localObject2);
        z.g(((AppBrandLauncherRecentsList.e)localObject2).umR, 1.0F);
        z.h(((AppBrandLauncherRecentsList.e)localObject2).umR, 1.0F);
        z.f(((AppBrandLauncherRecentsList.e)localObject2).umR, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).umR.setVisibility(0);
        localObject3 = z.ac(((AppBrandLauncherRecentsList.e)localObject2).umR);
        ((ad)localObject3).bu(this.bZL);
        ((ad)localObject3).b(new af()
        {
          public final void e(View paramAnonymousView) {}
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            z.g(this.unV.umR, 1.0F);
            z.h(this.unV.umR, 1.0F);
            z.f(this.unV.umR, 1.0F);
            this.unV.umR.setVisibility(8);
            m.this.r(this.unV);
            m.e(m.this).remove(this.unV);
            m.c(m.this);
            AppMethodBeat.o(49240);
          }
        });
        ((ad)localObject3).ao(0.0F).aq(0.1F).ar(0.1F).start();
      }
      this.unL.clear();
    }
    if (!this.unN.isEmpty())
    {
      localObject1 = this.unN.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (d)((Iterator)localObject1).next();
        this.unO.add(((d)localObject3).unX);
        localObject2 = ((d)localObject3).unX.caK;
        z.e((View)localObject2, 0.0F);
        z.f((View)localObject2, 1.0F);
        localObject3 = ((d)localObject3).unX;
        ad localad = z.ac((View)localObject2);
        localad.bu(this.bZK);
        localad.b(new af()
        {
          public final void e(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            m.this.C(this.unV);
            AppMethodBeat.o(49241);
          }
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            z.e(paramAnonymousView, 0.0F);
            z.f(paramAnonymousView, 1.0F);
            m.this.A(this.unV);
            m.f(m.this).remove(this.unV);
            m.c(m.this);
            AppMethodBeat.o(49242);
          }
        });
        localad.ao(0.0F).ap(-((View)localObject2).getHeight()).start();
      }
      this.unN.clear();
    }
    super.IW();
    if (!this.unQ.isEmpty())
    {
      this.unR.addAll(this.unQ);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = m.g(m.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            m.a(m.this, locale);
          }
          m.g(m.this).clear();
          AppMethodBeat.o(49243);
        }
      };
      this.unQ.clear();
      if (this.unT)
      {
        z.a(((AppBrandLauncherRecentsList.e)this.unR.get(0)).caK, (Runnable)localObject1, Ku());
        AppMethodBeat.o(49252);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(49252);
  }
  
  public final RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(323133);
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
            params = new m.b((byte)0).e(paramv, paramInt);
            AppMethodBeat.o(323133);
            return params;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            params = new m.c((byte)0).e(paramv, paramInt);
            AppMethodBeat.o(323133);
            return params;
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.bZM = paramInt;
    AppMethodBeat.o(323133);
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323115);
    if (!this.unB)
    {
      d(paramv);
      A(paramv);
      AppMethodBeat.o(323115);
      return false;
    }
    boolean bool = super.a(paramv);
    AppMethodBeat.o(323115);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(323110);
    if (!this.unB)
    {
      d(paramv);
      B(paramv);
      AppMethodBeat.o(323110);
      return false;
    }
    boolean bool = super.a(paramv, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(323110);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(323116);
    if (z.ac(paramv1.caK) == null)
    {
      z.f(paramv1.caK, 1.0F);
      z.e(paramv1.caK, 0.0F);
    }
    if (z.ac(paramv2.caK) == null)
    {
      z.f(paramv2.caK, 1.0F);
      z.e(paramv2.caK, 0.0F);
    }
    r(paramv1);
    r(paramv2);
    AppMethodBeat.o(323116);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(323137);
    if (!this.unB)
    {
      r(paramv1);
      r(paramv2);
      AppMethodBeat.o(323137);
      return false;
    }
    boolean bool = super.a(paramv1, paramv2, paramc1, paramc2);
    AppMethodBeat.o(323137);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(323142);
    boolean bool = super.a(paramv, paramList);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) || (bool))
    {
      AppMethodBeat.o(323142);
      return true;
    }
    AppMethodBeat.o(323142);
    return false;
  }
  
  final void b(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(323097);
    if (parama != null) {
      synchronized (this.unD)
      {
        this.unD.add(parama);
        AppMethodBeat.o(323097);
        return;
      }
    }
    AppMethodBeat.o(323097);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323111);
    d(paramv);
    r(paramv);
    AppMethodBeat.o(323111);
    return false;
  }
  
  final void c(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(323099);
    if (parama != null) {
      synchronized (this.unD)
      {
        this.unD.remove(parama);
        AppMethodBeat.o(323099);
        return;
      }
    }
    AppMethodBeat.o(323099);
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323112);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) && (this.unQ.remove(paramv)))
    {
      z.e(paramv.caK, 0.0F);
      r(paramv);
    }
    super.c(paramv);
    AppMethodBeat.o(323112);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(323114);
    if (!this.unB)
    {
      d(paramv);
      A(paramv);
      AppMethodBeat.o(323114);
      return false;
    }
    if ((paramc1 instanceof m.b))
    {
      d(paramv);
      AppMethodBeat.o(323114);
      return true;
    }
    if ((paramc1 instanceof m.c))
    {
      d(paramv);
      AppMethodBeat.o(323114);
      return true;
    }
    if (((paramc1.bZM & 0x800) > 0) && ((paramv instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramv).cMK().qPu;
        if (!bool)
        {
          d(paramv);
          this.unN.add(new d((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top, (byte)0));
          AppMethodBeat.o(323114);
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
    AppMethodBeat.o(323114);
    return bool;
  }
  
  public final boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(323113);
    if (!this.unB)
    {
      bool = b(paramv);
      AppMethodBeat.o(323113);
      return bool;
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)))
    {
      bool = super.a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(323113);
      return bool;
    }
    if ((this.unA) && ((paramv.caK.getParent() instanceof RecyclerView)) && ((paramv instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramv.caK.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          z.e(paramv.caK, paramv.caK.getHeight());
          this.unQ.add(paramv);
          AppMethodBeat.o(323113);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          z.e(paramv.caK, -paramv.caK.getHeight());
          this.unQ.add(paramv);
          AppMethodBeat.o(323113);
          return true;
        }
      }
    }
    boolean bool = b(paramv);
    AppMethodBeat.o(323113);
    return bool;
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(323117);
    if (!this.unB)
    {
      d(paramv);
      B(paramv);
      AppMethodBeat.o(323117);
      return false;
    }
    boolean bool = super.f(paramv, paramc1, paramc2);
    AppMethodBeat.o(323117);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49251);
    if ((!this.unF.isEmpty()) || (!this.unG.isEmpty()) || (!this.unH.isEmpty()) || (!this.unI.isEmpty()) || (!this.unJ.isEmpty()) || (!this.unK.isEmpty()) || (!this.unL.isEmpty()) || (!this.unM.isEmpty()) || (!this.unN.isEmpty()) || (!this.unO.isEmpty()) || (!this.unQ.isEmpty()) || (!this.unR.isEmpty()) || (!this.unS.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void s(RecyclerView.v paramv)
  {
    AppMethodBeat.i(323118);
    super.s(paramv);
    ViewParent localViewParent = paramv.caK.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).dM(paramv.caK);
    }
    AppMethodBeat.o(323118);
  }
  
  static final class d
  {
    int bVe;
    int bVf;
    AppBrandLauncherRecentsList.e unX;
    
    private d(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.unX = parame;
      this.bVe = paramInt1;
      this.bVf = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.m
 * JD-Core Version:    0.7.0.1
 */