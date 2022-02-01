package com.tencent.mm.plugin.appbrand.ui.recents;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.core.g.aa;
import androidx.core.g.ac;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.f.a;
import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.g;
import androidx.recyclerview.widget.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class n
  extends g
{
  boolean rfA;
  private final RecyclerView.f.a rfB;
  private final Set<RecyclerView.f.a> rfC;
  private final Interpolator rfD;
  private final ArrayList<Object> rfE;
  private final ArrayList<RecyclerView.v> rfF;
  private final ArrayList<Object> rfG;
  private final ArrayList<RecyclerView.v> rfH;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfI;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfJ;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfK;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfL;
  private final ArrayList<d> rfM;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfN;
  private final ArrayList<RecyclerView.v> rfO;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfP;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfQ;
  private final ArrayList<AppBrandLauncherRecentsList.e> rfR;
  private boolean rfS;
  boolean rfz;
  
  n()
  {
    AppMethodBeat.i(49247);
    this.rfz = false;
    this.rfA = true;
    this.rfB = new RecyclerView.f.a()
    {
      public final void lO()
      {
        AppMethodBeat.i(49231);
        synchronized (n.a(n.this))
        {
          Iterator localIterator = new HashSet(n.a(n.this)).iterator();
          if (localIterator.hasNext()) {
            ((RecyclerView.f.a)localIterator.next()).lO();
          }
        }
        n.b(n.this);
        AppMethodBeat.o(49231);
      }
    };
    this.rfC = new HashSet();
    this.rfD = new AccelerateDecelerateInterpolator();
    this.rfE = new ArrayList();
    this.rfF = new ArrayList();
    this.rfG = new ArrayList();
    this.rfH = new ArrayList();
    this.rfI = new ArrayList();
    this.rfJ = new ArrayList();
    this.rfK = new ArrayList();
    this.rfL = new ArrayList();
    this.rfM = new ArrayList();
    this.rfN = new ArrayList();
    this.rfO = new ArrayList();
    this.rfP = new ArrayList();
    this.rfQ = new ArrayList();
    this.rfR = new ArrayList();
    this.rfS = false;
    AppMethodBeat.o(49247);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273821);
    paramv.amk.animate().setInterpolator(new ValueAnimator().getInterpolator());
    c(paramv);
    w.d(paramv.amk, 0.0F);
    w.e(paramv.amk, 1.0F);
    AppMethodBeat.o(273821);
  }
  
  public final void F(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273822);
    super.F(paramv);
    if (!this.rfN.contains(paramv)) {
      this.rfS = true;
    }
    AppMethodBeat.o(273822);
  }
  
  public final void H(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273833);
    super.H(paramv);
    if (this.rfO.contains(paramv))
    {
      RecentsRecyclerView localRecentsRecyclerView = (RecentsRecyclerView)paramv.amk.getParent();
      paramv = paramv.amk;
      if (paramv.getParent() == localRecentsRecyclerView)
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramv.setZ(1.0F);
          AppMethodBeat.o(273833);
          return;
        }
        localRecentsRecyclerView.rga = paramv;
      }
    }
    AppMethodBeat.o(273833);
  }
  
  public final void I(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273835);
    super.I(paramv);
    if (this.rfO.contains(paramv))
    {
      this.rfO.remove(paramv);
      ((RecentsRecyclerView)paramv.amk.getParent()).dd(paramv.amk);
    }
    AppMethodBeat.o(273835);
  }
  
  public final RecyclerView.f.c a(RecyclerView.s params, RecyclerView.v paramv, int paramInt, List<Object> paramList)
  {
    AppMethodBeat.i(273836);
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
            params = new n.b((byte)0).e(paramv, paramInt);
            AppMethodBeat.o(273836);
            return params;
          }
          if ((localObject != null) && (!((Boolean)localObject).booleanValue()))
          {
            params = new n.c((byte)0).e(paramv, paramInt);
            AppMethodBeat.o(273836);
            return params;
          }
        }
      }
    }
    params = super.a(params, paramv, paramInt, paramList);
    params.alk = paramInt;
    AppMethodBeat.o(273836);
    return params;
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273829);
    if (!this.rfA)
    {
      d(paramv);
      z(paramv);
      AppMethodBeat.o(273829);
      return false;
    }
    boolean bool = super.a(paramv);
    AppMethodBeat.o(273829);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(273823);
    if (!this.rfA)
    {
      d(paramv);
      A(paramv);
      AppMethodBeat.o(273823);
      return false;
    }
    boolean bool = super.a(paramv, paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(273823);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(273830);
    if (w.Q(paramv1.amk) == null)
    {
      w.e(paramv1.amk, 1.0F);
      w.d(paramv1.amk, 0.0F);
    }
    if (w.Q(paramv2.amk) == null)
    {
      w.e(paramv2.amk, 1.0F);
      w.d(paramv2.amk, 0.0F);
    }
    q(paramv1);
    q(paramv2);
    AppMethodBeat.o(273830);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(273837);
    if (!this.rfA)
    {
      q(paramv1);
      q(paramv2);
      AppMethodBeat.o(273837);
      return false;
    }
    boolean bool = super.a(paramv1, paramv2, paramc1, paramc2);
    AppMethodBeat.o(273837);
    return bool;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(273838);
    boolean bool = super.a(paramv, paramList);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) || (bool))
    {
      AppMethodBeat.o(273838);
      return true;
    }
    AppMethodBeat.o(273838);
    return false;
  }
  
  final void b(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(273819);
    if (parama != null) {
      synchronized (this.rfC)
      {
        this.rfC.add(parama);
        AppMethodBeat.o(273819);
        return;
      }
    }
    AppMethodBeat.o(273819);
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273825);
    d(paramv);
    q(paramv);
    AppMethodBeat.o(273825);
    return false;
  }
  
  final void c(RecyclerView.f.a parama)
  {
    AppMethodBeat.i(273820);
    if (parama != null) {
      synchronized (this.rfC)
      {
        this.rfC.remove(parama);
        AppMethodBeat.o(273820);
        return;
      }
    }
    AppMethodBeat.o(273820);
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273826);
    if (((paramv instanceof AppBrandLauncherRecentsList.e)) && (this.rfP.remove(paramv)))
    {
      w.d(paramv.amk, 0.0F);
      q(paramv);
    }
    super.c(paramv);
    AppMethodBeat.o(273826);
  }
  
  public final boolean d(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(273828);
    if (!this.rfA)
    {
      d(paramv);
      z(paramv);
      AppMethodBeat.o(273828);
      return false;
    }
    if ((paramc1 instanceof n.b))
    {
      d(paramv);
      AppMethodBeat.o(273828);
      return true;
    }
    if ((paramc1 instanceof n.c))
    {
      d(paramv);
      AppMethodBeat.o(273828);
      return true;
    }
    if (((paramc1.alk & 0x800) > 0) && ((paramv instanceof AppBrandLauncherRecentsList.e)) && (paramc2 == null)) {
      try
      {
        bool = ((AppBrandLauncherRecentsList.e)paramv).cln().nPC;
        if (!bool)
        {
          d(paramv);
          this.rfM.add(new d((AppBrandLauncherRecentsList.e)paramv, paramc1.left, paramc1.top, (byte)0));
          AppMethodBeat.o(273828);
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
    AppMethodBeat.o(273828);
    return bool;
  }
  
  public final boolean e(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(273827);
    if (!this.rfA)
    {
      bool = b(paramv);
      AppMethodBeat.o(273827);
      return bool;
    }
    if ((paramc1 != null) && ((paramc1.left != paramc2.left) || (paramc1.top != paramc2.top)))
    {
      bool = super.a(paramv, paramc1.left, paramc1.top, paramc2.left, paramc2.top);
      AppMethodBeat.o(273827);
      return bool;
    }
    if ((this.rfz) && ((paramv.amk.getParent() instanceof RecyclerView)) && ((paramv instanceof AppBrandLauncherRecentsList.e)))
    {
      paramc1 = (RecyclerView)paramv.amk.getParent();
      if (paramc1.getHeight() > 0)
      {
        if (paramc2.bottom >= paramc1.getHeight())
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          w.d(paramv.amk, paramv.amk.getHeight());
          this.rfP.add(paramv);
          AppMethodBeat.o(273827);
          return true;
        }
        if (paramc2.top <= 0)
        {
          paramv = (AppBrandLauncherRecentsList.e)paramv;
          w.d(paramv.amk, -paramv.amk.getHeight());
          this.rfP.add(paramv);
          AppMethodBeat.o(273827);
          return true;
        }
      }
    }
    boolean bool = b(paramv);
    AppMethodBeat.o(273827);
    return bool;
  }
  
  public final boolean f(RecyclerView.v paramv, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(273831);
    if (!this.rfA)
    {
      d(paramv);
      A(paramv);
      AppMethodBeat.o(273831);
      return false;
    }
    boolean bool = super.f(paramv, paramc1, paramc2);
    AppMethodBeat.o(273831);
    return bool;
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49251);
    if ((!this.rfE.isEmpty()) || (!this.rfF.isEmpty()) || (!this.rfG.isEmpty()) || (!this.rfH.isEmpty()) || (!this.rfI.isEmpty()) || (!this.rfJ.isEmpty()) || (!this.rfK.isEmpty()) || (!this.rfL.isEmpty()) || (!this.rfM.isEmpty()) || (!this.rfN.isEmpty()) || (!this.rfP.isEmpty()) || (!this.rfQ.isEmpty()) || (!this.rfR.isEmpty()) || (super.isRunning()))
    {
      AppMethodBeat.o(49251);
      return true;
    }
    AppMethodBeat.o(49251);
    return false;
  }
  
  public final void kl()
  {
    AppMethodBeat.i(49252);
    a(this.rfB);
    Object localObject1;
    if (!this.rfE.isEmpty())
    {
      localObject1 = this.rfE.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        AppMethodBeat.o(49252);
        throw null;
      }
      this.rfE.clear();
    }
    if (!this.rfG.isEmpty())
    {
      localObject1 = this.rfG.iterator();
      if (((Iterator)localObject1).hasNext())
      {
        ((Iterator)localObject1).next();
        AppMethodBeat.o(49252);
        throw null;
      }
      this.rfG.clear();
    }
    Object localObject2;
    Object localObject3;
    if (!this.rfI.isEmpty())
    {
      localObject1 = this.rfI.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.rfJ.add(localObject2);
        w.f(((AppBrandLauncherRecentsList.e)localObject2).reP, 0.1F);
        w.g(((AppBrandLauncherRecentsList.e)localObject2).reP, 0.1F);
        w.e(((AppBrandLauncherRecentsList.e)localObject2).reP, 0.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).reP.setVisibility(0);
        localObject3 = w.Q(((AppBrandLauncherRecentsList.e)localObject2).reP);
        ((aa)localObject3).f(this.alj);
        ((aa)localObject3).b(new ac()
        {
          public final void e(View paramAnonymousView) {}
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49238);
            this.rfV.b(null);
            n.this.q(this.rfU);
            n.d(n.this).remove(this.rfU);
            n.c(n.this);
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
            w.d(paramAnonymousView, 0.0F);
            w.e(paramAnonymousView, 1.0F);
            AppMethodBeat.o(49239);
          }
        });
        ((aa)localObject3).i(1.0F).k(1.0F).l(1.0F).start();
      }
      this.rfI.clear();
    }
    if (!this.rfK.isEmpty())
    {
      localObject1 = this.rfK.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (AppBrandLauncherRecentsList.e)((Iterator)localObject1).next();
        this.rfL.add(localObject2);
        w.f(((AppBrandLauncherRecentsList.e)localObject2).reP, 1.0F);
        w.g(((AppBrandLauncherRecentsList.e)localObject2).reP, 1.0F);
        w.e(((AppBrandLauncherRecentsList.e)localObject2).reP, 1.0F);
        ((AppBrandLauncherRecentsList.e)localObject2).reP.setVisibility(0);
        localObject3 = w.Q(((AppBrandLauncherRecentsList.e)localObject2).reP);
        ((aa)localObject3).f(this.alj);
        ((aa)localObject3).b(new ac()
        {
          public final void e(View paramAnonymousView) {}
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49240);
            w.f(this.rfU.reP, 1.0F);
            w.g(this.rfU.reP, 1.0F);
            w.e(this.rfU.reP, 1.0F);
            this.rfU.reP.setVisibility(8);
            n.this.q(this.rfU);
            n.e(n.this).remove(this.rfU);
            n.c(n.this);
            AppMethodBeat.o(49240);
          }
        });
        ((aa)localObject3).i(0.0F).k(0.1F).l(0.1F).start();
      }
      this.rfK.clear();
    }
    if (!this.rfM.isEmpty())
    {
      localObject1 = this.rfM.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (d)((Iterator)localObject1).next();
        this.rfN.add(((d)localObject3).rfW);
        localObject2 = ((d)localObject3).rfW.amk;
        w.d((View)localObject2, 0.0F);
        w.e((View)localObject2, 1.0F);
        localObject3 = ((d)localObject3).rfW;
        aa localaa = w.Q((View)localObject2);
        localaa.f(this.ali);
        localaa.b(new ac()
        {
          public final void e(View paramAnonymousView)
          {
            AppMethodBeat.i(49241);
            n.this.F(this.rfU);
            AppMethodBeat.o(49241);
          }
          
          public final void f(View paramAnonymousView)
          {
            AppMethodBeat.i(49242);
            w.d(paramAnonymousView, 0.0F);
            w.e(paramAnonymousView, 1.0F);
            n.this.z(this.rfU);
            n.f(n.this).remove(this.rfU);
            n.c(n.this);
            AppMethodBeat.o(49242);
          }
        });
        localaa.i(0.0F).j(-((View)localObject2).getHeight()).start();
      }
      this.rfM.clear();
    }
    super.kl();
    if (!this.rfP.isEmpty())
    {
      this.rfQ.addAll(this.rfP);
      localObject1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49243);
          Iterator localIterator = n.g(n.this).iterator();
          while (localIterator.hasNext())
          {
            AppBrandLauncherRecentsList.e locale = (AppBrandLauncherRecentsList.e)localIterator.next();
            n.a(n.this, locale);
          }
          n.g(n.this).clear();
          AppMethodBeat.o(49243);
        }
      };
      this.rfP.clear();
      if (this.rfS)
      {
        w.a(((AppBrandLauncherRecentsList.e)this.rfQ.get(0)).amk, (Runnable)localObject1, lK());
        AppMethodBeat.o(49252);
        return;
      }
      ((Runnable)localObject1).run();
    }
    AppMethodBeat.o(49252);
  }
  
  public final void r(RecyclerView.v paramv)
  {
    AppMethodBeat.i(273832);
    super.r(paramv);
    ViewParent localViewParent = paramv.amk.getParent();
    if ((localViewParent instanceof RecentsRecyclerView)) {
      ((RecentsRecyclerView)localViewParent).dd(paramv.amk);
    }
    AppMethodBeat.o(273832);
  }
  
  static final class d
  {
    int agy;
    int agz;
    AppBrandLauncherRecentsList.e rfW;
    
    private d(AppBrandLauncherRecentsList.e parame, int paramInt1, int paramInt2)
    {
      this.rfW = parame;
      this.agy = paramInt1;
      this.agz = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recents.n
 * JD-Core Version:    0.7.0.1
 */