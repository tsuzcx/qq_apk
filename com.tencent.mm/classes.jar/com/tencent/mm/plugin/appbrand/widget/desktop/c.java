package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends as
{
  private static TimeInterpolator ajm;
  private ArrayList<RecyclerView.v> ajn;
  private ArrayList<RecyclerView.v> ajo;
  private ArrayList<b> ajp;
  private ArrayList<a> ajq;
  ArrayList<ArrayList<RecyclerView.v>> ajr;
  ArrayList<ArrayList<b>> ajs;
  ArrayList<ArrayList<a>> ajt;
  ArrayList<RecyclerView.v> aju;
  ArrayList<RecyclerView.v> ajv;
  ArrayList<RecyclerView.v> ajw;
  ArrayList<RecyclerView.v> ajx;
  boolean lTZ;
  public boolean lUa;
  ConversationAppBrandRecentView lUb;
  private RecyclerView.f.a lUc;
  
  public c(ConversationAppBrandRecentView paramConversationAppBrandRecentView, boolean paramBoolean)
  {
    AppMethodBeat.i(49539);
    this.lTZ = false;
    this.lUa = false;
    this.ajn = new ArrayList();
    this.ajo = new ArrayList();
    this.ajp = new ArrayList();
    this.ajq = new ArrayList();
    this.ajr = new ArrayList();
    this.ajs = new ArrayList();
    this.ajt = new ArrayList();
    this.aju = new ArrayList();
    this.ajv = new ArrayList();
    this.ajw = new ArrayList();
    this.ajx = new ArrayList();
    this.lUc = new RecyclerView.f.a()
    {
      public final void kV()
      {
        AppMethodBeat.i(49517);
        if (c.this.lUb != null)
        {
          ConversationAppBrandRecentView localConversationAppBrandRecentView = c.this.lUb;
          c.this.lUb.getCurrentPage();
          Object localObject = (LinearLayoutManager)localConversationAppBrandRecentView.getLayoutManager();
          int i = ((LinearLayoutManager)localObject).jO();
          int j = ((LinearLayoutManager)localObject).jQ();
          ad.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j)
          {
            localObject = localConversationAppBrandRecentView.cj(i);
            if ((localObject != null) && (((RecyclerView.v)localObject).arI != null))
            {
              ((RecyclerView.v)localObject).arI.setScaleX(1.0F);
              ((RecyclerView.v)localObject).arI.setScaleY(1.0F);
              if (i != j) {
                break label145;
              }
              ((RecyclerView.v)localObject).arI.setAlpha(0.3F);
            }
            for (;;)
            {
              i += 1;
              break;
              label145:
              ((RecyclerView.v)localObject).arI.setAlpha(1.0F);
            }
          }
        }
        AppMethodBeat.o(49517);
      }
    };
    this.lUb = paramConversationAppBrandRecentView;
    this.lTZ = paramBoolean;
    AppMethodBeat.o(49539);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49546);
    if (parama.ajK != null) {
      a(parama, parama.ajK);
    }
    if (parama.ajL != null) {
      a(parama, parama.ajL);
    }
    AppMethodBeat.o(49546);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(49545);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.ajK == null) && (locala.ajL == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49545);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(49547);
    if (parama.ajL == paramv) {
      parama.ajL = null;
    }
    for (;;)
    {
      paramv.arI.setAlpha(1.0F);
      paramv.arI.setTranslationX(0.0F);
      paramv.arI.setTranslationY(0.0F);
      n(paramv);
      AppMethodBeat.o(49547);
      return true;
      if (parama.ajK != paramv) {
        break;
      }
      parama.ajK = null;
    }
    AppMethodBeat.o(49547);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49549);
    if (ajm == null) {
      ajm = new ValueAnimator().getInterpolator();
    }
    paramv.arI.animate().setInterpolator(ajm);
    d(paramv);
    AppMethodBeat.o(49549);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(49553);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).arI.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49553);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49543);
    View localView = paramv.arI;
    paramInt1 = (int)paramv.arI.getTranslationX() + paramInt1;
    paramInt2 = (int)paramv.arI.getTranslationY() + paramInt2;
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(49543);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramv).titleTv.getText() });
    paramv.arI.setScaleX(1.0F);
    paramv.arI.setScaleY(1.0F);
    this.ajp.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49543);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49544);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49544);
      return bool;
    }
    int i = ConversationAppBrandRecentView.bw(paramv1.arI);
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", new Object[] { ((BaseAppBrandRecentView.b)paramv2).titleTv.getText(), Integer.valueOf(i) });
    float f1 = paramv1.arI.getTranslationX();
    float f2 = paramv1.arI.getTranslationY();
    float f3 = paramv1.arI.getAlpha();
    e(paramv1);
    i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.arI.setTranslationX(f1);
    paramv1.arI.setTranslationY(f2);
    paramv1.arI.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.arI.setTranslationX(-i);
      paramv2.arI.setTranslationY(-j);
      paramv2.arI.setAlpha(0.0F);
    }
    this.ajq.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49544);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(49554);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(49554);
      return true;
    }
    AppMethodBeat.o(49554);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49541);
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", new Object[] { ((BaseAppBrandRecentView.b)paramv).titleTv.getText() });
    e(paramv);
    this.ajn.add(paramv);
    AppMethodBeat.o(49541);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49542);
    e(paramv);
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramv).titleTv.getText() });
    int j = ConversationAppBrandRecentView.bw(paramv.arI);
    if (j < this.lUb.getDataCount()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
      ((BaseAppBrandRecentView.b)paramv).arI.setVisibility(4);
      AppMethodBeat.o(49542);
      return true;
    }
    if (this.lUb.vu(j))
    {
      ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.lUb.getCurrentPage()) });
      i = (int)paramv.arI.getX();
      j = (int)d.dS(aj.getContext());
      i = d.dQ(aj.getContext()) + (i + j);
      j = (int)paramv.arI.getY();
      int k = (int)paramv.arI.getX();
      int m = (int)paramv.arI.getY();
      ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      paramv.arI.setVisibility(0);
      paramv.arI.animate().alpha(0.3F).setDuration(0L).setListener(null).start();
      boolean bool = a(paramv, i, j, k, m);
      AppMethodBeat.o(49542);
      return bool;
    }
    paramv.arI.setAlpha(0.0F);
    paramv.arI.setScaleX(0.8F);
    paramv.arI.setScaleY(0.8F);
    this.ajo.add(paramv);
    AppMethodBeat.o(49542);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49548);
    View localView = paramv.arI;
    localView.animate().cancel();
    int i = this.ajp.size() - 1;
    while (i >= 0)
    {
      if (((b)this.ajp.get(i)).ajQ == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramv);
        this.ajp.remove(i);
      }
      i -= 1;
    }
    a(this.ajq, paramv);
    if (this.ajn.remove(paramv))
    {
      localView.setAlpha(1.0F);
      w(paramv);
    }
    if (this.ajo.remove(paramv))
    {
      localView.setAlpha(1.0F);
      n(paramv);
    }
    i = this.ajt.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ajt.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.ajt.remove(i);
      }
      i -= 1;
    }
    i = this.ajs.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.ajs.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).ajQ != paramv) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.ajs.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.ajr.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ajr.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        n(paramv);
        if (localArrayList.isEmpty()) {
          this.ajr.remove(i);
        }
      }
      i -= 1;
    }
    this.ajw.remove(paramv);
    this.aju.remove(paramv);
    this.ajx.remove(paramv);
    this.ajv.remove(paramv);
    iX();
    AppMethodBeat.o(49548);
  }
  
  public final void iW()
  {
    AppMethodBeat.i(49540);
    a(this.lUc);
    int i;
    int j;
    label39:
    int k;
    if (!this.ajn.isEmpty())
    {
      i = 1;
      if (this.ajp.isEmpty()) {
        break label95;
      }
      j = 1;
      if (this.ajq.isEmpty()) {
        break label100;
      }
      k = 1;
      label52:
      if (this.ajo.isEmpty()) {
        break label106;
      }
    }
    label95:
    label100:
    label106:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label112;
      }
      AppMethodBeat.o(49540);
      return;
      i = 0;
      break;
      j = 0;
      break label39;
      k = 0;
      break label52;
    }
    label112:
    Object localObject1 = this.ajn.iterator();
    Object localObject2;
    final View localView;
    final ViewPropertyAnimator localViewPropertyAnimator;
    final int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      localView = ((RecyclerView.v)localObject2).arI;
      localViewPropertyAnimator = localView.animate();
      this.ajw.add(localObject2);
      n = ConversationAppBrandRecentView.bw(((RecyclerView.v)localObject2).arI);
      if (n - 1 != e.vz(this.lUb.getCurrentPage())) {
        break label632;
      }
    }
    label445:
    label590:
    label600:
    label606:
    label612:
    label618:
    label625:
    label632:
    for (float f = 0.3F;; f = 0.0F)
    {
      ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", new Object[] { ((BaseAppBrandRecentView.b)localObject2).titleTv.getText(), Integer.valueOf(n), Float.valueOf(f) });
      localViewPropertyAnimator.setDuration(kQ()).alpha(f).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49526);
          ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
          AppMethodBeat.o(49526);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49525);
          ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", new Object[] { Integer.valueOf(n) });
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          c.this.w(this.ajC);
          c.this.ajw.remove(this.ajC);
          c.this.iX();
          AppMethodBeat.o(49525);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49524);
          c.this.A(this.ajC);
          AppMethodBeat.o(49524);
        }
      }).start();
      break;
      this.ajn.clear();
      long l1;
      long l2;
      if (j != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ajp);
        this.ajs.add(localObject1);
        this.ajp.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49521);
            Iterator localIterator = this.ajy.iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (c.b)localIterator.next();
              c localc = c.this;
              RecyclerView.v localv = ((c.b)localObject).ajQ;
              int k = ((c.b)localObject).ajM;
              int i = ((c.b)localObject).ajN;
              int m = ((c.b)localObject).ajO;
              int j = ((c.b)localObject).ajP;
              localObject = localv.arI;
              k = m - k;
              i = j - i;
              if (k != 0) {
                ((View)localObject).animate().translationX(0.0F);
              }
              if (i != 0) {
                ((View)localObject).animate().translationY(0.0F);
              }
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
              localc.ajv.add(localv);
              j = ConversationAppBrandRecentView.bw(localv.arI);
              float f2 = 1.0F;
              boolean bool;
              label170:
              float f1;
              if (j < localc.lUb.getDataCount())
              {
                bool = true;
                if (bool) {
                  break label310;
                }
                f1 = 0.0F;
                localv.arI.setVisibility(4);
              }
              for (;;)
              {
                ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", new Object[] { Integer.valueOf(j), ((BaseAppBrandRecentView.b)localv).titleTv.getText(), Boolean.valueOf(bool), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(e.vz(localc.lUb.getCurrentPage())) });
                localViewPropertyAnimator.alpha(f1).setDuration(localc.aqr).setListener(new c.11(localc, localv, k, (View)localObject, i, bool, f1, localViewPropertyAnimator)).start();
                break;
                bool = false;
                break label170;
                label310:
                if ((e.vz(localc.lUb.getCurrentPage()) == j) && (k > 0))
                {
                  localv.arI.setVisibility(0);
                  f1 = 0.3F;
                }
                else
                {
                  f1 = f2;
                  if (e.vz(localc.lUb.getCurrentPage()) == j)
                  {
                    f1 = f2;
                    if (k < 0)
                    {
                      localv.arI.setVisibility(0);
                      f1 = 0.3F;
                    }
                  }
                }
              }
            }
            this.ajy.clear();
            c.this.ajs.remove(this.ajy);
            AppMethodBeat.o(49521);
          }
        };
        if (i != 0) {
          t.a(((b)((ArrayList)localObject1).get(0)).ajQ.arI, (Runnable)localObject2, kQ());
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.ajq);
          this.ajt.add(localObject1);
          this.ajq.clear();
          localObject2 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49522);
              Iterator localIterator = this.ajA.iterator();
              while (localIterator.hasNext())
              {
                c.a locala = (c.a)localIterator.next();
                if (locala != null)
                {
                  c localc = c.this;
                  Object localObject3 = locala.ajK;
                  Object localObject1;
                  label62:
                  Object localObject2;
                  label81:
                  int i;
                  float f;
                  boolean bool;
                  if (localObject3 == null)
                  {
                    localObject1 = null;
                    localObject2 = locala.ajL;
                    if (localObject2 == null) {
                      break label318;
                    }
                    localObject2 = ((RecyclerView.v)localObject2).arI;
                    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", new Object[] { ((BaseAppBrandRecentView.b)localObject3).titleTv.getText() });
                    if (localObject1 != null)
                    {
                      localObject3 = ((View)localObject1).animate().setDuration(localc.aqs);
                      localc.ajx.add(locala.ajK);
                      ((ViewPropertyAnimator)localObject3).translationX(locala.ajO - locala.ajM);
                      ((ViewPropertyAnimator)localObject3).translationY(locala.ajP - locala.ajN);
                      ((ViewPropertyAnimator)localObject3).alpha(0.0F).setListener(new c.2(localc, locala, (ViewPropertyAnimator)localObject3, (View)localObject1)).start();
                    }
                    if (localObject2 == null) {
                      continue;
                    }
                    i = ConversationAppBrandRecentView.bw((View)localObject2);
                    f = 1.0F;
                    if (i >= localc.lUb.getDataCount()) {
                      break label324;
                    }
                    bool = true;
                    label231:
                    if (bool) {
                      break label330;
                    }
                    f = 0.0F;
                  }
                  for (;;)
                  {
                    localObject1 = ((View)localObject2).animate();
                    localc.ajx.add(locala.ajL);
                    ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).alpha(f).setDuration(localc.aqs).setListener(new c.3(localc, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f, bool)).start();
                    break;
                    localObject1 = ((RecyclerView.v)localObject3).arI;
                    break label62;
                    label318:
                    localObject2 = null;
                    break label81;
                    label324:
                    bool = false;
                    break label231;
                    label330:
                    int j = ((LinearLayoutManager)localc.lUb.getLayoutManager()).jQ();
                    ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                    if (j == i) {
                      f = 0.3F;
                    }
                  }
                }
              }
              this.ajA.clear();
              c.this.ajt.remove(this.ajA);
              AppMethodBeat.o(49522);
            }
          };
          if (i == 0) {
            break label590;
          }
          t.a(((a)((ArrayList)localObject1).get(0)).ajK.arI, (Runnable)localObject2, kQ());
        }
        if (m == 0) {
          break label625;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ajo);
        this.ajr.add(localObject1);
        this.ajo.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49523);
            Iterator localIterator = this.ajB.iterator();
            while (localIterator.hasNext())
            {
              RecyclerView.v localv = (RecyclerView.v)localIterator.next();
              c localc = c.this;
              ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localv).titleTv.getText() });
              View localView = localv.arI;
              ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
              localc.aju.add(localv);
              int i = ConversationAppBrandRecentView.bw(localView);
              if ((localc.lUa) && (i == 1))
              {
                ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", new Object[] { ((BaseAppBrandRecentView.b)localv).titleTv.getText() });
                localView = localv.arI;
                localViewPropertyAnimator = localView.animate();
                if (ConversationAppBrandRecentView.bw(localv.arI) < localc.lUb.getDataCount()) {}
                for (i = 1;; i = 0)
                {
                  if (i != 0) {
                    break label189;
                  }
                  localView.setVisibility(4);
                  break;
                }
                label189:
                localView.setVisibility(0);
                localView.setAlpha(1.0F);
                localView.setScaleX(1.0F);
                localView.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localv).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localv).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localv).lVz.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.8(localc, localv, localView, localViewPropertyAnimator)).start();
              }
              else if ((localc.lTZ) && (i == localc.lUb.getDataCount() - 1))
              {
                ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localv).titleTv.getText() });
                localView = localv.arI;
                localViewPropertyAnimator = localView.animate();
                localView.setVisibility(0);
                localView.setAlpha(1.0F);
                localView.setScaleX(1.0F);
                localView.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localv).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localv).lVz.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localv).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localv).lVz.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.10(localc, localv, localView, localViewPropertyAnimator)).start();
              }
              else
              {
                boolean bool;
                label574:
                float f;
                if (i < localc.lUb.getDataCount())
                {
                  bool = true;
                  if (bool) {
                    break label695;
                  }
                  localv.arI.setVisibility(4);
                  f = 0.0F;
                }
                for (;;)
                {
                  ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", new Object[] { Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(localc.lUb.getCustomItemCount()), Integer.valueOf(localc.lUb.getDataCount()) });
                  localViewPropertyAnimator.alpha(f).scaleX(1.0F).scaleY(1.0F).setDuration(localc.kP()).setListener(new c.9(localc, localv, localView, i, bool, localViewPropertyAnimator)).start();
                  break;
                  bool = false;
                  break label574;
                  label695:
                  if (localc.lUb.vu(i))
                  {
                    localv.arI.setVisibility(0);
                    f = 0.3F;
                  }
                  else
                  {
                    localv.arI.setVisibility(0);
                    f = 1.0F;
                  }
                }
              }
            }
            this.ajB.clear();
            c.this.ajr.remove(this.ajB);
            AppMethodBeat.o(49523);
          }
        };
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label618;
        }
        if (i == 0) {
          break label600;
        }
        l1 = kQ();
        if (j == 0) {
          break label606;
        }
        l2 = this.aqr;
        if (k == 0) {
          break label612;
        }
      }
      for (long l3 = this.aqs;; l3 = 0L)
      {
        l2 = Math.max(l2, l3);
        t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).arI, (Runnable)localObject2, l1 + l2);
        AppMethodBeat.o(49540);
        return;
        ((Runnable)localObject2).run();
        break;
        ((Runnable)localObject2).run();
        break label445;
        l1 = 0L;
        break label521;
        l2 = 0L;
        break label531;
      }
      ((Runnable)localObject2).run();
      AppMethodBeat.o(49540);
      return;
    }
  }
  
  final void iX()
  {
    AppMethodBeat.i(49551);
    if (!isRunning()) {
      kU();
    }
    AppMethodBeat.o(49551);
  }
  
  public final void iY()
  {
    AppMethodBeat.i(49552);
    int i = this.ajp.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.ajp.get(i);
      localObject2 = ((b)localObject1).ajQ.arI;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((b)localObject1).ajQ);
      this.ajp.remove(i);
      i -= 1;
    }
    i = this.ajn.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.v)this.ajn.get(i));
      this.ajn.remove(i);
      i -= 1;
    }
    i = this.ajo.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.ajo.get(i);
      ((RecyclerView.v)localObject1).arI.setAlpha(1.0F);
      n((RecyclerView.v)localObject1);
      this.ajo.remove(i);
      i -= 1;
    }
    i = this.ajq.size() - 1;
    while (i >= 0)
    {
      a((a)this.ajq.get(i));
      i -= 1;
    }
    this.ajq.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(49552);
      return;
    }
    i = this.ajs.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ajs.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).ajQ.arI;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((b)localObject2).ajQ);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.ajs.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ajr.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ajr.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).arI.setAlpha(1.0F);
        n((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.ajr.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ajt.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ajt.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.ajt.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    o(this.ajw);
    o(this.ajv);
    o(this.aju);
    o(this.ajx);
    kU();
    AppMethodBeat.o(49552);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49550);
    if ((!this.ajo.isEmpty()) || (!this.ajq.isEmpty()) || (!this.ajp.isEmpty()) || (!this.ajn.isEmpty()) || (!this.ajv.isEmpty()) || (!this.ajw.isEmpty()) || (!this.aju.isEmpty()) || (!this.ajx.isEmpty()) || (!this.ajs.isEmpty()) || (!this.ajr.isEmpty()) || (!this.ajt.isEmpty()))
    {
      AppMethodBeat.o(49550);
      return true;
    }
    AppMethodBeat.o(49550);
    return false;
  }
  
  static final class a
  {
    public RecyclerView.v ajK;
    public RecyclerView.v ajL;
    public int ajM;
    public int ajN;
    public int ajO;
    public int ajP;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.ajK = paramv1;
      this.ajL = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.ajM = paramInt1;
      this.ajN = paramInt2;
      this.ajO = paramInt3;
      this.ajP = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(49538);
      String str = "ChangeInfo{oldHolder=" + this.ajK + ", newHolder=" + this.ajL + ", fromX=" + this.ajM + ", fromY=" + this.ajN + ", toX=" + this.ajO + ", toY=" + this.ajP + '}';
      AppMethodBeat.o(49538);
      return str;
    }
  }
  
  static final class b
  {
    public int ajM;
    public int ajN;
    public int ajO;
    public int ajP;
    public RecyclerView.v ajQ;
    
    b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.ajQ = paramv;
      this.ajM = paramInt1;
      this.ajN = paramInt2;
      this.ajO = paramInt3;
      this.ajP = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */