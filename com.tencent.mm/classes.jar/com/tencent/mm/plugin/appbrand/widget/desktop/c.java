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
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends as
{
  private static TimeInterpolator akg;
  private ArrayList<RecyclerView.w> akh;
  private ArrayList<RecyclerView.w> aki;
  private ArrayList<b> akj;
  private ArrayList<a> akk;
  ArrayList<ArrayList<RecyclerView.w>> akl;
  ArrayList<ArrayList<b>> akm;
  ArrayList<ArrayList<a>> akn;
  ArrayList<RecyclerView.w> ako;
  ArrayList<RecyclerView.w> akp;
  ArrayList<RecyclerView.w> akq;
  ArrayList<RecyclerView.w> akr;
  boolean mwb;
  public boolean mwc;
  ConversationAppBrandRecentView mwd;
  private RecyclerView.f.a mwe;
  
  public c(ConversationAppBrandRecentView paramConversationAppBrandRecentView, boolean paramBoolean)
  {
    AppMethodBeat.i(49539);
    this.mwb = false;
    this.mwc = false;
    this.akh = new ArrayList();
    this.aki = new ArrayList();
    this.akj = new ArrayList();
    this.akk = new ArrayList();
    this.akl = new ArrayList();
    this.akm = new ArrayList();
    this.akn = new ArrayList();
    this.ako = new ArrayList();
    this.akp = new ArrayList();
    this.akq = new ArrayList();
    this.akr = new ArrayList();
    this.mwe = new RecyclerView.f.a()
    {
      public final void ld()
      {
        AppMethodBeat.i(49517);
        if (c.this.mwd != null)
        {
          ConversationAppBrandRecentView localConversationAppBrandRecentView = c.this.mwd;
          c.this.mwd.getCurrentPage();
          Object localObject = (LinearLayoutManager)localConversationAppBrandRecentView.getLayoutManager();
          int i = ((LinearLayoutManager)localObject).jW();
          int j = ((LinearLayoutManager)localObject).jY();
          ac.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j)
          {
            localObject = localConversationAppBrandRecentView.ci(i);
            if ((localObject != null) && (((RecyclerView.w)localObject).asD != null))
            {
              ((RecyclerView.w)localObject).asD.setScaleX(1.0F);
              ((RecyclerView.w)localObject).asD.setScaleY(1.0F);
              if (i != j) {
                break label145;
              }
              ((RecyclerView.w)localObject).asD.setAlpha(0.3F);
            }
            for (;;)
            {
              i += 1;
              break;
              label145:
              ((RecyclerView.w)localObject).asD.setAlpha(1.0F);
            }
          }
        }
        AppMethodBeat.o(49517);
      }
    };
    this.mwd = paramConversationAppBrandRecentView;
    this.mwb = paramBoolean;
    AppMethodBeat.o(49539);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49546);
    if (parama.akE != null) {
      a(parama, parama.akE);
    }
    if (parama.akF != null) {
      a(parama, parama.akF);
    }
    AppMethodBeat.o(49546);
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49545);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.akE == null) && (locala.akF == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49545);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49547);
    if (parama.akF == paramw) {
      parama.akF = null;
    }
    for (;;)
    {
      paramw.asD.setAlpha(1.0F);
      paramw.asD.setTranslationX(0.0F);
      paramw.asD.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(49547);
      return true;
      if (parama.akE != paramw) {
        break;
      }
      parama.akE = null;
    }
    AppMethodBeat.o(49547);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49549);
    if (akg == null) {
      akg = new ValueAnimator().getInterpolator();
    }
    paramw.asD.animate().setInterpolator(akg);
    d(paramw);
    AppMethodBeat.o(49549);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(49553);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).asD.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49553);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49543);
    View localView = paramw.asD;
    paramInt1 = (int)paramw.asD.getTranslationX() + paramInt1;
    paramInt2 = (int)paramw.asD.getTranslationY() + paramInt2;
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      AppMethodBeat.o(49543);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    paramw.asD.setScaleX(1.0F);
    paramw.asD.setScaleY(1.0F);
    this.akj.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49543);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49544);
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49544);
      return bool;
    }
    int i = ConversationAppBrandRecentView.bw(paramw1.asD);
    ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", new Object[] { ((BaseAppBrandRecentView.b)paramw2).titleTv.getText(), Integer.valueOf(i) });
    float f1 = paramw1.asD.getTranslationX();
    float f2 = paramw1.asD.getTranslationY();
    float f3 = paramw1.asD.getAlpha();
    e(paramw1);
    i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramw1.asD.setTranslationX(f1);
    paramw1.asD.setTranslationY(f2);
    paramw1.asD.setAlpha(f3);
    if (paramw2 != null)
    {
      e(paramw2);
      paramw2.asD.setTranslationX(-i);
      paramw2.asD.setTranslationY(-j);
      paramw2.asD.setAlpha(0.0F);
    }
    this.akk.add(new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49544);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(49554);
    if ((!paramList.isEmpty()) || (super.a(paramw, paramList)))
    {
      AppMethodBeat.o(49554);
      return true;
    }
    AppMethodBeat.o(49554);
    return false;
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49541);
    ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    e(paramw);
    this.akh.add(paramw);
    AppMethodBeat.o(49541);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49542);
    e(paramw);
    ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    int j = ConversationAppBrandRecentView.bw(paramw.asD);
    if (j < this.mwd.getDataCount()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
      ((BaseAppBrandRecentView.b)paramw).asD.setVisibility(4);
      AppMethodBeat.o(49542);
      return true;
    }
    if (this.mwd.wl(j))
    {
      ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mwd.getCurrentPage()) });
      i = (int)paramw.asD.getX();
      j = (int)d.ea(ai.getContext());
      i = d.dY(ai.getContext()) + (i + j);
      j = (int)paramw.asD.getY();
      int k = (int)paramw.asD.getX();
      int m = (int)paramw.asD.getY();
      ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      paramw.asD.setVisibility(0);
      paramw.asD.animate().alpha(0.3F).setDuration(0L).setListener(null).start();
      boolean bool = a(paramw, i, j, k, m);
      AppMethodBeat.o(49542);
      return bool;
    }
    paramw.asD.setAlpha(0.0F);
    paramw.asD.setScaleX(0.8F);
    paramw.asD.setScaleY(0.8F);
    this.aki.add(paramw);
    AppMethodBeat.o(49542);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49548);
    View localView = paramw.asD;
    localView.animate().cancel();
    int i = this.akj.size() - 1;
    while (i >= 0)
    {
      if (((b)this.akj.get(i)).akK == paramw)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramw);
        this.akj.remove(i);
      }
      i -= 1;
    }
    a(this.akk, paramw);
    if (this.akh.remove(paramw))
    {
      localView.setAlpha(1.0F);
      w(paramw);
    }
    if (this.aki.remove(paramw))
    {
      localView.setAlpha(1.0F);
      n(paramw);
    }
    i = this.akn.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.akn.get(i);
      a(localArrayList, paramw);
      if (localArrayList.isEmpty()) {
        this.akn.remove(i);
      }
      i -= 1;
    }
    i = this.akm.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.akm.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).akK != paramw) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramw);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.akm.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.akl.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.akl.get(i);
      if (localArrayList.remove(paramw))
      {
        localView.setAlpha(1.0F);
        n(paramw);
        if (localArrayList.isEmpty()) {
          this.akl.remove(i);
        }
      }
      i -= 1;
    }
    this.akq.remove(paramw);
    this.ako.remove(paramw);
    this.akr.remove(paramw);
    this.akp.remove(paramw);
    jf();
    AppMethodBeat.o(49548);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49550);
    if ((!this.aki.isEmpty()) || (!this.akk.isEmpty()) || (!this.akj.isEmpty()) || (!this.akh.isEmpty()) || (!this.akp.isEmpty()) || (!this.akq.isEmpty()) || (!this.ako.isEmpty()) || (!this.akr.isEmpty()) || (!this.akm.isEmpty()) || (!this.akl.isEmpty()) || (!this.akn.isEmpty()))
    {
      AppMethodBeat.o(49550);
      return true;
    }
    AppMethodBeat.o(49550);
    return false;
  }
  
  public final void je()
  {
    AppMethodBeat.i(49540);
    a(this.mwe);
    int i;
    int j;
    label39:
    int k;
    if (!this.akh.isEmpty())
    {
      i = 1;
      if (this.akj.isEmpty()) {
        break label95;
      }
      j = 1;
      if (this.akk.isEmpty()) {
        break label100;
      }
      k = 1;
      label52:
      if (this.aki.isEmpty()) {
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
    Object localObject1 = this.akh.iterator();
    Object localObject2;
    final View localView;
    final ViewPropertyAnimator localViewPropertyAnimator;
    final int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      localView = ((RecyclerView.w)localObject2).asD;
      localViewPropertyAnimator = localView.animate();
      this.akq.add(localObject2);
      n = ConversationAppBrandRecentView.bw(((RecyclerView.w)localObject2).asD);
      if (n - 1 != e.wq(this.mwd.getCurrentPage())) {
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
      ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", new Object[] { ((BaseAppBrandRecentView.b)localObject2).titleTv.getText(), Integer.valueOf(n), Float.valueOf(f) });
      localViewPropertyAnimator.setDuration(kY()).alpha(f).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49526);
          ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationCancel");
          AppMethodBeat.o(49526);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49525);
          ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl onAnimationEnd, pos: %d", new Object[] { Integer.valueOf(n) });
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          c.this.w(this.akw);
          c.this.akq.remove(this.akw);
          c.this.jf();
          AppMethodBeat.o(49525);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49524);
          c.this.A(this.akw);
          AppMethodBeat.o(49524);
        }
      }).start();
      break;
      this.akh.clear();
      long l1;
      long l2;
      if (j != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.akj);
        this.akm.add(localObject1);
        this.akj.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49521);
            Iterator localIterator = this.aks.iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (c.b)localIterator.next();
              c localc = c.this;
              RecyclerView.w localw = ((c.b)localObject).akK;
              int k = ((c.b)localObject).akG;
              int i = ((c.b)localObject).akH;
              int m = ((c.b)localObject).akI;
              int j = ((c.b)localObject).akJ;
              localObject = localw.asD;
              k = m - k;
              i = j - i;
              if (k != 0) {
                ((View)localObject).animate().translationX(0.0F);
              }
              if (i != 0) {
                ((View)localObject).animate().translationY(0.0F);
              }
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
              localc.akp.add(localw);
              j = ConversationAppBrandRecentView.bw(localw.asD);
              float f2 = 1.0F;
              boolean bool;
              label170:
              float f1;
              if (j < localc.mwd.getDataCount())
              {
                bool = true;
                if (bool) {
                  break label310;
                }
                f1 = 0.0F;
                localw.asD.setVisibility(4);
              }
              for (;;)
              {
                ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", new Object[] { Integer.valueOf(j), ((BaseAppBrandRecentView.b)localw).titleTv.getText(), Boolean.valueOf(bool), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(e.wq(localc.mwd.getCurrentPage())) });
                localViewPropertyAnimator.alpha(f1).setDuration(localc.arm).setListener(new c.11(localc, localw, k, (View)localObject, i, bool, f1, localViewPropertyAnimator)).start();
                break;
                bool = false;
                break label170;
                label310:
                if ((e.wq(localc.mwd.getCurrentPage()) == j) && (k > 0))
                {
                  localw.asD.setVisibility(0);
                  f1 = 0.3F;
                }
                else
                {
                  f1 = f2;
                  if (e.wq(localc.mwd.getCurrentPage()) == j)
                  {
                    f1 = f2;
                    if (k < 0)
                    {
                      localw.asD.setVisibility(0);
                      f1 = 0.3F;
                    }
                  }
                }
              }
            }
            this.aks.clear();
            c.this.akm.remove(this.aks);
            AppMethodBeat.o(49521);
          }
        };
        if (i != 0) {
          t.a(((b)((ArrayList)localObject1).get(0)).akK.asD, (Runnable)localObject2, kY());
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.akk);
          this.akn.add(localObject1);
          this.akk.clear();
          localObject2 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49522);
              Iterator localIterator = this.aku.iterator();
              while (localIterator.hasNext())
              {
                c.a locala = (c.a)localIterator.next();
                if (locala != null)
                {
                  c localc = c.this;
                  Object localObject3 = locala.akE;
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
                    localObject2 = locala.akF;
                    if (localObject2 == null) {
                      break label318;
                    }
                    localObject2 = ((RecyclerView.w)localObject2).asD;
                    ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", new Object[] { ((BaseAppBrandRecentView.b)localObject3).titleTv.getText() });
                    if (localObject1 != null)
                    {
                      localObject3 = ((View)localObject1).animate().setDuration(localc.arn);
                      localc.akr.add(locala.akE);
                      ((ViewPropertyAnimator)localObject3).translationX(locala.akI - locala.akG);
                      ((ViewPropertyAnimator)localObject3).translationY(locala.akJ - locala.akH);
                      ((ViewPropertyAnimator)localObject3).alpha(0.0F).setListener(new c.2(localc, locala, (ViewPropertyAnimator)localObject3, (View)localObject1)).start();
                    }
                    if (localObject2 == null) {
                      continue;
                    }
                    i = ConversationAppBrandRecentView.bw((View)localObject2);
                    f = 1.0F;
                    if (i >= localc.mwd.getDataCount()) {
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
                    localc.akr.add(locala.akF);
                    ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).alpha(f).setDuration(localc.arn).setListener(new c.3(localc, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f, bool)).start();
                    break;
                    localObject1 = ((RecyclerView.w)localObject3).asD;
                    break label62;
                    label318:
                    localObject2 = null;
                    break label81;
                    label324:
                    bool = false;
                    break label231;
                    label330:
                    int j = ((LinearLayoutManager)localc.mwd.getLayoutManager()).jY();
                    ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                    if (j == i) {
                      f = 0.3F;
                    }
                  }
                }
              }
              this.aku.clear();
              c.this.akn.remove(this.aku);
              AppMethodBeat.o(49522);
            }
          };
          if (i == 0) {
            break label590;
          }
          t.a(((a)((ArrayList)localObject1).get(0)).akE.asD, (Runnable)localObject2, kY());
        }
        if (m == 0) {
          break label625;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.aki);
        this.akl.add(localObject1);
        this.aki.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49523);
            Iterator localIterator = this.akv.iterator();
            while (localIterator.hasNext())
            {
              RecyclerView.w localw = (RecyclerView.w)localIterator.next();
              c localc = c.this;
              ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
              View localView = localw.asD;
              ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
              localc.ako.add(localw);
              int i = ConversationAppBrandRecentView.bw(localView);
              if ((localc.mwc) && (i == 1))
              {
                ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
                localView = localw.asD;
                localViewPropertyAnimator = localView.animate();
                if (ConversationAppBrandRecentView.bw(localw.asD) < localc.mwd.getDataCount()) {}
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
                ((BaseAppBrandRecentView.b)localw).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localw).mxB.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.8(localc, localw, localView, localViewPropertyAnimator)).start();
              }
              else if ((localc.mwb) && (i == localc.mwd.getDataCount() - 1))
              {
                ac.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
                localView = localw.asD;
                localViewPropertyAnimator = localView.animate();
                localView.setVisibility(0);
                localView.setAlpha(1.0F);
                localView.setScaleX(1.0F);
                localView.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localw).mxB.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localw).mxB.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.10(localc, localw, localView, localViewPropertyAnimator)).start();
              }
              else
              {
                boolean bool;
                label574:
                float f;
                if (i < localc.mwd.getDataCount())
                {
                  bool = true;
                  if (bool) {
                    break label695;
                  }
                  localw.asD.setVisibility(4);
                  f = 0.0F;
                }
                for (;;)
                {
                  ac.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", new Object[] { Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(localc.mwd.getCustomItemCount()), Integer.valueOf(localc.mwd.getDataCount()) });
                  localViewPropertyAnimator.alpha(f).scaleX(1.0F).scaleY(1.0F).setDuration(localc.kX()).setListener(new c.9(localc, localw, localView, i, bool, localViewPropertyAnimator)).start();
                  break;
                  bool = false;
                  break label574;
                  label695:
                  if (localc.mwd.wl(i))
                  {
                    localw.asD.setVisibility(0);
                    f = 0.3F;
                  }
                  else
                  {
                    localw.asD.setVisibility(0);
                    f = 1.0F;
                  }
                }
              }
            }
            this.akv.clear();
            c.this.akl.remove(this.akv);
            AppMethodBeat.o(49523);
          }
        };
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label618;
        }
        if (i == 0) {
          break label600;
        }
        l1 = kY();
        if (j == 0) {
          break label606;
        }
        l2 = this.arm;
        if (k == 0) {
          break label612;
        }
      }
      for (long l3 = this.arn;; l3 = 0L)
      {
        l2 = Math.max(l2, l3);
        t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).asD, (Runnable)localObject2, l1 + l2);
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
  
  final void jf()
  {
    AppMethodBeat.i(49551);
    if (!isRunning()) {
      lc();
    }
    AppMethodBeat.o(49551);
  }
  
  public final void jg()
  {
    AppMethodBeat.i(49552);
    int i = this.akj.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.akj.get(i);
      localObject2 = ((b)localObject1).akK.asD;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((b)localObject1).akK);
      this.akj.remove(i);
      i -= 1;
    }
    i = this.akh.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.w)this.akh.get(i));
      this.akh.remove(i);
      i -= 1;
    }
    i = this.aki.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.w)this.aki.get(i);
      ((RecyclerView.w)localObject1).asD.setAlpha(1.0F);
      n((RecyclerView.w)localObject1);
      this.aki.remove(i);
      i -= 1;
    }
    i = this.akk.size() - 1;
    while (i >= 0)
    {
      a((a)this.akk.get(i));
      i -= 1;
    }
    this.akk.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(49552);
      return;
    }
    i = this.akm.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.akm.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).akK.asD;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((b)localObject2).akK);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.akm.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.akl.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.akl.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.w)((ArrayList)localObject1).get(j);
        ((RecyclerView.w)localObject2).asD.setAlpha(1.0F);
        n((RecyclerView.w)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.akl.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.akn.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.akn.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.akn.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    n(this.akq);
    n(this.akp);
    n(this.ako);
    n(this.akr);
    lc();
    AppMethodBeat.o(49552);
  }
  
  static final class a
  {
    public RecyclerView.w akE;
    public RecyclerView.w akF;
    public int akG;
    public int akH;
    public int akI;
    public int akJ;
    
    private a(RecyclerView.w paramw1, RecyclerView.w paramw2)
    {
      this.akE = paramw1;
      this.akF = paramw2;
    }
    
    a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramw1, paramw2);
      this.akG = paramInt1;
      this.akH = paramInt2;
      this.akI = paramInt3;
      this.akJ = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(49538);
      String str = "ChangeInfo{oldHolder=" + this.akE + ", newHolder=" + this.akF + ", fromX=" + this.akG + ", fromY=" + this.akH + ", toX=" + this.akI + ", toY=" + this.akJ + '}';
      AppMethodBeat.o(49538);
      return str;
    }
  }
  
  static final class b
  {
    public int akG;
    public int akH;
    public int akI;
    public int akJ;
    public RecyclerView.w akK;
    
    b(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.akK = paramw;
      this.akG = paramInt1;
      this.akH = paramInt2;
      this.akI = paramInt3;
      this.akJ = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */