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
import android.widget.RelativeLayout;
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
  private static TimeInterpolator alX;
  private ArrayList<RecyclerView.w> alY;
  private ArrayList<RecyclerView.w> alZ;
  private ArrayList<b> ama;
  private ArrayList<a> amb;
  ArrayList<ArrayList<RecyclerView.w>> amc;
  ArrayList<ArrayList<b>> amd;
  ArrayList<ArrayList<a>> ame;
  ArrayList<RecyclerView.w> amf;
  ArrayList<RecyclerView.w> amg;
  ArrayList<RecyclerView.w> amh;
  ArrayList<RecyclerView.w> ami;
  boolean mWG;
  public boolean mWH;
  ConversationAppBrandRecentView mWI;
  private RecyclerView.f.a mWJ;
  
  public c(ConversationAppBrandRecentView paramConversationAppBrandRecentView, boolean paramBoolean)
  {
    AppMethodBeat.i(49539);
    this.mWG = false;
    this.mWH = false;
    this.alY = new ArrayList();
    this.alZ = new ArrayList();
    this.ama = new ArrayList();
    this.amb = new ArrayList();
    this.amc = new ArrayList();
    this.amd = new ArrayList();
    this.ame = new ArrayList();
    this.amf = new ArrayList();
    this.amg = new ArrayList();
    this.amh = new ArrayList();
    this.ami = new ArrayList();
    this.mWJ = new RecyclerView.f.a()
    {
      public final void lv()
      {
        AppMethodBeat.i(49517);
        if (c.this.mWI != null)
        {
          ConversationAppBrandRecentView localConversationAppBrandRecentView = c.this.mWI;
          c.this.mWI.getCurrentPage();
          Object localObject = (LinearLayoutManager)localConversationAppBrandRecentView.getLayoutManager();
          int i = ((LinearLayoutManager)localObject).km();
          int j = ((LinearLayoutManager)localObject).ko();
          ad.i("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo checkAlphaChange firstPos: %d, lastPos: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          if (i <= j)
          {
            localObject = localConversationAppBrandRecentView.ci(i);
            if ((localObject != null) && (((RecyclerView.w)localObject).auu != null))
            {
              ((RecyclerView.w)localObject).auu.setScaleX(1.0F);
              ((RecyclerView.w)localObject).auu.setScaleY(1.0F);
              if (i != j) {
                break label145;
              }
              ((RecyclerView.w)localObject).auu.setAlpha(0.3F);
            }
            for (;;)
            {
              i += 1;
              break;
              label145:
              ((RecyclerView.w)localObject).auu.setAlpha(1.0F);
            }
          }
        }
        AppMethodBeat.o(49517);
      }
    };
    this.mWI = paramConversationAppBrandRecentView;
    this.mWG = paramBoolean;
    AppMethodBeat.o(49539);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49546);
    if (parama.amv != null) {
      a(parama, parama.amv);
    }
    if (parama.amw != null) {
      a(parama, parama.amw);
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
      if ((a(locala, paramw)) && (locala.amv == null) && (locala.amw == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49545);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49547);
    if (parama.amw == paramw) {
      parama.amw = null;
    }
    for (;;)
    {
      paramw.auu.setAlpha(1.0F);
      paramw.auu.setTranslationX(0.0F);
      paramw.auu.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(49547);
      return true;
      if (parama.amv != paramw) {
        break;
      }
      parama.amv = null;
    }
    AppMethodBeat.o(49547);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49549);
    if (alX == null) {
      alX = new ValueAnimator().getInterpolator();
    }
    paramw.auu.animate().setInterpolator(alX);
    d(paramw);
    AppMethodBeat.o(49549);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(49553);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).auu.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49553);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49543);
    View localView = paramw.auu;
    paramInt1 = (int)paramw.auu.getTranslationX() + paramInt1;
    paramInt2 = (int)paramw.auu.getTranslationY() + paramInt2;
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
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    paramw.auu.setScaleX(1.0F);
    paramw.auu.setScaleY(1.0F);
    this.ama.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
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
    int i = ConversationAppBrandRecentView.bw(paramw1.auu);
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", new Object[] { ((BaseAppBrandRecentView.b)paramw2).titleTv.getText(), Integer.valueOf(i) });
    float f1 = paramw1.auu.getTranslationX();
    float f2 = paramw1.auu.getTranslationY();
    float f3 = paramw1.auu.getAlpha();
    e(paramw1);
    i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramw1.auu.setTranslationX(f1);
    paramw1.auu.setTranslationY(f2);
    paramw1.auu.setAlpha(f3);
    if (paramw2 != null)
    {
      e(paramw2);
      paramw2.auu.setTranslationX(-i);
      paramw2.auu.setTranslationY(-j);
      paramw2.auu.setAlpha(0.0F);
    }
    this.amb.add(new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4));
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
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    e(paramw);
    this.alY.add(paramw);
    AppMethodBeat.o(49541);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49542);
    e(paramw);
    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", new Object[] { ((BaseAppBrandRecentView.b)paramw).titleTv.getText() });
    int j = ConversationAppBrandRecentView.bw(paramw.auu);
    if (j < this.mWI.getDataCount()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
      ((BaseAppBrandRecentView.b)paramw).auu.setVisibility(4);
      AppMethodBeat.o(49542);
      return true;
    }
    if (this.mWI.wQ(j))
    {
      ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mWI.getCurrentPage()) });
      i = (int)paramw.auu.getX();
      j = (int)d.ea(aj.getContext());
      i = d.dY(aj.getContext()) + (i + j);
      j = (int)paramw.auu.getY();
      int k = (int)paramw.auu.getX();
      int m = (int)paramw.auu.getY();
      ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      paramw.auu.setVisibility(0);
      paramw.auu.animate().alpha(0.3F).setDuration(0L).setListener(null).start();
      boolean bool = a(paramw, i, j, k, m);
      AppMethodBeat.o(49542);
      return bool;
    }
    paramw.auu.setAlpha(0.0F);
    paramw.auu.setScaleX(0.8F);
    paramw.auu.setScaleY(0.8F);
    this.alZ.add(paramw);
    AppMethodBeat.o(49542);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49548);
    View localView = paramw.auu;
    localView.animate().cancel();
    int i = this.ama.size() - 1;
    while (i >= 0)
    {
      if (((b)this.ama.get(i)).amB == paramw)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramw);
        this.ama.remove(i);
      }
      i -= 1;
    }
    a(this.amb, paramw);
    if (this.alY.remove(paramw))
    {
      localView.setAlpha(1.0F);
      w(paramw);
    }
    if (this.alZ.remove(paramw))
    {
      localView.setAlpha(1.0F);
      n(paramw);
    }
    i = this.ame.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ame.get(i);
      a(localArrayList, paramw);
      if (localArrayList.isEmpty()) {
        this.ame.remove(i);
      }
      i -= 1;
    }
    i = this.amd.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.amd.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((b)localArrayList.get(j)).amB != paramw) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramw);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.amd.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.amc.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.amc.get(i);
      if (localArrayList.remove(paramw))
      {
        localView.setAlpha(1.0F);
        n(paramw);
        if (localArrayList.isEmpty()) {
          this.amc.remove(i);
        }
      }
      i -= 1;
    }
    this.amh.remove(paramw);
    this.amf.remove(paramw);
    this.ami.remove(paramw);
    this.amg.remove(paramw);
    jv();
    AppMethodBeat.o(49548);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49550);
    if ((!this.alZ.isEmpty()) || (!this.amb.isEmpty()) || (!this.ama.isEmpty()) || (!this.alY.isEmpty()) || (!this.amg.isEmpty()) || (!this.amh.isEmpty()) || (!this.amf.isEmpty()) || (!this.ami.isEmpty()) || (!this.amd.isEmpty()) || (!this.amc.isEmpty()) || (!this.ame.isEmpty()))
    {
      AppMethodBeat.o(49550);
      return true;
    }
    AppMethodBeat.o(49550);
    return false;
  }
  
  public final void ju()
  {
    AppMethodBeat.i(49540);
    a(this.mWJ);
    int i;
    int j;
    label39:
    int k;
    if (!this.alY.isEmpty())
    {
      i = 1;
      if (this.ama.isEmpty()) {
        break label95;
      }
      j = 1;
      if (this.amb.isEmpty()) {
        break label100;
      }
      k = 1;
      label52:
      if (this.alZ.isEmpty()) {
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
    Object localObject1 = this.alY.iterator();
    Object localObject2;
    final View localView;
    final ViewPropertyAnimator localViewPropertyAnimator;
    final int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      localView = ((RecyclerView.w)localObject2).auu;
      localViewPropertyAnimator = localView.animate();
      this.amh.add(localObject2);
      n = ConversationAppBrandRecentView.bw(((RecyclerView.w)localObject2).auu);
      if (n - 1 != e.wV(this.mWI.getCurrentPage())) {
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
      localViewPropertyAnimator.setDuration(lq()).alpha(f).setListener(new AnimatorListenerAdapter()
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
          c.this.w(this.amn);
          c.this.amh.remove(this.amn);
          c.this.jv();
          AppMethodBeat.o(49525);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49524);
          c.this.A(this.amn);
          AppMethodBeat.o(49524);
        }
      }).start();
      break;
      this.alY.clear();
      long l1;
      long l2;
      if (j != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ama);
        this.amd.add(localObject1);
        this.ama.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49521);
            Iterator localIterator = this.amj.iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (c.b)localIterator.next();
              c localc = c.this;
              RecyclerView.w localw = ((c.b)localObject).amB;
              int k = ((c.b)localObject).amx;
              int i = ((c.b)localObject).amy;
              int m = ((c.b)localObject).amz;
              int j = ((c.b)localObject).amA;
              localObject = localw.auu;
              k = m - k;
              i = j - i;
              if (k != 0) {
                ((View)localObject).animate().translationX(0.0F);
              }
              if (i != 0) {
                ((View)localObject).animate().translationY(0.0F);
              }
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
              localc.amg.add(localw);
              j = ConversationAppBrandRecentView.bw(localw.auu);
              float f2 = 1.0F;
              boolean bool;
              label170:
              float f1;
              if (j < localc.mWI.getDataCount())
              {
                bool = true;
                if (bool) {
                  break label310;
                }
                f1 = 0.0F;
                localw.auu.setVisibility(4);
              }
              for (;;)
              {
                ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", new Object[] { Integer.valueOf(j), ((BaseAppBrandRecentView.b)localw).titleTv.getText(), Boolean.valueOf(bool), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(e.wV(localc.mWI.getCurrentPage())) });
                localViewPropertyAnimator.alpha(f1).setDuration(localc.ate).setListener(new c.11(localc, localw, k, (View)localObject, i, bool, f1, localViewPropertyAnimator)).start();
                break;
                bool = false;
                break label170;
                label310:
                if ((e.wV(localc.mWI.getCurrentPage()) == j) && (k > 0))
                {
                  localw.auu.setVisibility(0);
                  f1 = 0.3F;
                }
                else
                {
                  f1 = f2;
                  if (e.wV(localc.mWI.getCurrentPage()) == j)
                  {
                    f1 = f2;
                    if (k < 0)
                    {
                      localw.auu.setVisibility(0);
                      f1 = 0.3F;
                    }
                  }
                }
              }
            }
            this.amj.clear();
            c.this.amd.remove(this.amj);
            AppMethodBeat.o(49521);
          }
        };
        if (i != 0) {
          t.a(((b)((ArrayList)localObject1).get(0)).amB.auu, (Runnable)localObject2, lq());
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.amb);
          this.ame.add(localObject1);
          this.amb.clear();
          localObject2 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(49522);
              Iterator localIterator = this.aml.iterator();
              while (localIterator.hasNext())
              {
                c.a locala = (c.a)localIterator.next();
                if (locala != null)
                {
                  c localc = c.this;
                  Object localObject3 = locala.amv;
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
                    localObject2 = locala.amw;
                    if (localObject2 == null) {
                      break label318;
                    }
                    localObject2 = ((RecyclerView.w)localObject2).auu;
                    ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", new Object[] { ((BaseAppBrandRecentView.b)localObject3).titleTv.getText() });
                    if (localObject1 != null)
                    {
                      localObject3 = ((View)localObject1).animate().setDuration(localc.atf);
                      localc.ami.add(locala.amv);
                      ((ViewPropertyAnimator)localObject3).translationX(locala.amz - locala.amx);
                      ((ViewPropertyAnimator)localObject3).translationY(locala.amA - locala.amy);
                      ((ViewPropertyAnimator)localObject3).alpha(0.0F).setListener(new c.2(localc, locala, (ViewPropertyAnimator)localObject3, (View)localObject1)).start();
                    }
                    if (localObject2 == null) {
                      continue;
                    }
                    i = ConversationAppBrandRecentView.bw((View)localObject2);
                    f = 1.0F;
                    if (i >= localc.mWI.getDataCount()) {
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
                    localc.ami.add(locala.amw);
                    ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).alpha(f).setDuration(localc.atf).setListener(new c.3(localc, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f, bool)).start();
                    break;
                    localObject1 = ((RecyclerView.w)localObject3).auu;
                    break label62;
                    label318:
                    localObject2 = null;
                    break label81;
                    label324:
                    bool = false;
                    break label231;
                    label330:
                    int j = ((LinearLayoutManager)localc.mWI.getLayoutManager()).ko();
                    ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                    if (j == i) {
                      f = 0.3F;
                    }
                  }
                }
              }
              this.aml.clear();
              c.this.ame.remove(this.aml);
              AppMethodBeat.o(49522);
            }
          };
          if (i == 0) {
            break label590;
          }
          t.a(((a)((ArrayList)localObject1).get(0)).amv.auu, (Runnable)localObject2, lq());
        }
        if (m == 0) {
          break label625;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.alZ);
        this.amc.add(localObject1);
        this.alZ.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49523);
            Iterator localIterator = this.amm.iterator();
            while (localIterator.hasNext())
            {
              RecyclerView.w localw = (RecyclerView.w)localIterator.next();
              c localc = c.this;
              ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
              View localView = localw.auu;
              ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
              localc.amf.add(localw);
              int i = ConversationAppBrandRecentView.bw(localView);
              if ((localc.mWH) && (i == 1))
              {
                ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
                localView = localw.auu;
                localViewPropertyAnimator = localView.animate();
                if (ConversationAppBrandRecentView.bw(localw.auu) < localc.mWI.getDataCount()) {}
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
                ((BaseAppBrandRecentView.b)localw).noe.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).noe.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localw).noe.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localw).noe.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.8(localc, localw, localView, localViewPropertyAnimator)).start();
              }
              else if ((localc.mWG) && (i == localc.mWI.getDataCount() - 1))
              {
                ad.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.b)localw).titleTv.getText() });
                localView = localw.auu;
                localViewPropertyAnimator = localView.animate();
                localView.setVisibility(0);
                localView.setAlpha(1.0F);
                localView.setScaleX(1.0F);
                localView.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).noe.setAlpha(0.0F);
                ((BaseAppBrandRecentView.b)localw).noe.setScaleX(1.0F);
                ((BaseAppBrandRecentView.b)localw).noe.setScaleY(1.0F);
                ((BaseAppBrandRecentView.b)localw).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.b)localw).noe.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.10(localc, localw, localView, localViewPropertyAnimator)).start();
              }
              else
              {
                boolean bool;
                label574:
                float f;
                if (i < localc.mWI.getDataCount())
                {
                  bool = true;
                  if (bool) {
                    break label695;
                  }
                  localw.auu.setVisibility(4);
                  f = 0.0F;
                }
                for (;;)
                {
                  ad.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", new Object[] { Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(localc.mWI.getCustomItemCount()), Integer.valueOf(localc.mWI.getDataCount()) });
                  localViewPropertyAnimator.alpha(f).scaleX(1.0F).scaleY(1.0F).setDuration(localc.lp()).setListener(new c.9(localc, localw, localView, i, bool, localViewPropertyAnimator)).start();
                  break;
                  bool = false;
                  break label574;
                  label695:
                  if (localc.mWI.wQ(i))
                  {
                    localw.auu.setVisibility(0);
                    f = 0.3F;
                  }
                  else
                  {
                    localw.auu.setVisibility(0);
                    f = 1.0F;
                  }
                }
              }
            }
            this.amm.clear();
            c.this.amc.remove(this.amm);
            AppMethodBeat.o(49523);
          }
        };
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label618;
        }
        if (i == 0) {
          break label600;
        }
        l1 = lq();
        if (j == 0) {
          break label606;
        }
        l2 = this.ate;
        if (k == 0) {
          break label612;
        }
      }
      for (long l3 = this.atf;; l3 = 0L)
      {
        l2 = Math.max(l2, l3);
        t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).auu, (Runnable)localObject2, l1 + l2);
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
  
  final void jv()
  {
    AppMethodBeat.i(49551);
    if (!isRunning()) {
      lu();
    }
    AppMethodBeat.o(49551);
  }
  
  public final void jw()
  {
    AppMethodBeat.i(49552);
    int i = this.ama.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.ama.get(i);
      localObject2 = ((b)localObject1).amB.auu;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((b)localObject1).amB);
      this.ama.remove(i);
      i -= 1;
    }
    i = this.alY.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.w)this.alY.get(i));
      this.alY.remove(i);
      i -= 1;
    }
    i = this.alZ.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.w)this.alZ.get(i);
      ((RecyclerView.w)localObject1).auu.setAlpha(1.0F);
      n((RecyclerView.w)localObject1);
      this.alZ.remove(i);
      i -= 1;
    }
    i = this.amb.size() - 1;
    while (i >= 0)
    {
      a((a)this.amb.get(i));
      i -= 1;
    }
    this.amb.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(49552);
      return;
    }
    i = this.amd.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.amd.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).amB.auu;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((b)localObject2).amB);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amd.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.amc.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.amc.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.w)((ArrayList)localObject1).get(j);
        ((RecyclerView.w)localObject2).auu.setAlpha(1.0F);
        n((RecyclerView.w)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amc.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ame.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ame.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.ame.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    n(this.amh);
    n(this.amg);
    n(this.amf);
    n(this.ami);
    lu();
    AppMethodBeat.o(49552);
  }
  
  static final class a
  {
    public int amA;
    public RecyclerView.w amv;
    public RecyclerView.w amw;
    public int amx;
    public int amy;
    public int amz;
    
    private a(RecyclerView.w paramw1, RecyclerView.w paramw2)
    {
      this.amv = paramw1;
      this.amw = paramw2;
    }
    
    a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramw1, paramw2);
      this.amx = paramInt1;
      this.amy = paramInt2;
      this.amz = paramInt3;
      this.amA = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(49538);
      String str = "ChangeInfo{oldHolder=" + this.amv + ", newHolder=" + this.amw + ", fromX=" + this.amx + ", fromY=" + this.amy + ", toX=" + this.amz + ", toY=" + this.amA + '}';
      AppMethodBeat.o(49538);
      return str;
    }
  }
  
  static final class b
  {
    public int amA;
    public RecyclerView.w amB;
    public int amx;
    public int amy;
    public int amz;
    
    b(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.amB = paramw;
      this.amx = paramInt1;
      this.amy = paramInt2;
      this.amz = paramInt3;
      this.amA = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */