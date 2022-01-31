package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends as
{
  private static TimeInterpolator acf;
  private ArrayList<RecyclerView.v> acg;
  private ArrayList<RecyclerView.v> ach;
  private ArrayList<c.b> aci;
  private ArrayList<c.a> acj;
  ArrayList<ArrayList<RecyclerView.v>> ack;
  ArrayList<ArrayList<c.b>> acl;
  ArrayList<ArrayList<c.a>> acm;
  ArrayList<RecyclerView.v> acn;
  ArrayList<RecyclerView.v> aco;
  ArrayList<RecyclerView.v> acp;
  ArrayList<RecyclerView.v> acq;
  boolean jdZ;
  public boolean jea;
  ConversationAppBrandRecentView jeb;
  private RecyclerView.f.a jec;
  
  public c(ConversationAppBrandRecentView paramConversationAppBrandRecentView, boolean paramBoolean)
  {
    AppMethodBeat.i(133796);
    this.jdZ = false;
    this.jea = false;
    this.acg = new ArrayList();
    this.ach = new ArrayList();
    this.aci = new ArrayList();
    this.acj = new ArrayList();
    this.ack = new ArrayList();
    this.acl = new ArrayList();
    this.acm = new ArrayList();
    this.acn = new ArrayList();
    this.aco = new ArrayList();
    this.acp = new ArrayList();
    this.acq = new ArrayList();
    this.jec = new c.1(this);
    this.jeb = paramConversationAppBrandRecentView;
    this.jdZ = paramBoolean;
    AppMethodBeat.o(133796);
  }
  
  private void a(c.a parama)
  {
    AppMethodBeat.i(133803);
    if (parama.acD != null) {
      a(parama, parama.acD);
    }
    if (parama.acE != null) {
      a(parama, parama.acE);
    }
    AppMethodBeat.o(133803);
  }
  
  private void a(List<c.a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133802);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      c.a locala = (c.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.acD == null) && (locala.acE == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(133802);
  }
  
  private boolean a(c.a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133804);
    if (parama.acE == paramv) {
      parama.acE = null;
    }
    for (;;)
    {
      paramv.aku.setAlpha(1.0F);
      paramv.aku.setTranslationX(0.0F);
      paramv.aku.setTranslationY(0.0F);
      m(paramv);
      AppMethodBeat.o(133804);
      return true;
      if (parama.acD != paramv) {
        break;
      }
      parama.acD = null;
    }
    AppMethodBeat.o(133804);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133806);
    if (acf == null) {
      acf = new ValueAnimator().getInterpolator();
    }
    paramv.aku.animate().setInterpolator(acf);
    d(paramv);
    AppMethodBeat.o(133806);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(133810);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aku.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(133810);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133800);
    View localView = paramv.aku;
    paramInt1 = (int)paramv.aku.getTranslationX() + paramInt1;
    paramInt2 = (int)paramv.aku.getTranslationY() + paramInt2;
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      C(paramv);
      AppMethodBeat.o(133800);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).titleTv.getText() });
    paramv.aku.setScaleX(1.0F);
    paramv.aku.setScaleY(1.0F);
    this.aci.add(new c.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(133800);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133801);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(133801);
      return bool;
    }
    int i = ConversationAppBrandRecentView.bq(paramv1.aku);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", new Object[] { ((BaseAppBrandRecentView.c)paramv2).titleTv.getText(), Integer.valueOf(i) });
    float f1 = paramv1.aku.getTranslationX();
    float f2 = paramv1.aku.getTranslationY();
    float f3 = paramv1.aku.getAlpha();
    e(paramv1);
    i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.aku.setTranslationX(f1);
    paramv1.aku.setTranslationY(f2);
    paramv1.aku.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.aku.setTranslationX(-i);
      paramv2.aku.setTranslationY(-j);
      paramv2.aku.setAlpha(0.0F);
    }
    this.acj.add(new c.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(133801);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(133811);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(133811);
      return true;
    }
    AppMethodBeat.o(133811);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133798);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).titleTv.getText() });
    e(paramv);
    this.acg.add(paramv);
    AppMethodBeat.o(133798);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133799);
    e(paramv);
    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).titleTv.getText() });
    int j = ConversationAppBrandRecentView.bq(paramv.aku);
    if (j < this.jeb.getDataCount()) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
      ((BaseAppBrandRecentView.c)paramv).aku.setVisibility(4);
      AppMethodBeat.o(133799);
      return true;
    }
    if (this.jeb.qQ(j))
    {
      ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.jeb.getCurrentPage()) });
      i = (int)paramv.aku.getX();
      j = (int)d.dq(ah.getContext());
      i = d.jdMethod_do(ah.getContext()) + (i + j);
      j = (int)paramv.aku.getY();
      int k = (int)paramv.aku.getX();
      int m = (int)paramv.aku.getY();
      ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      paramv.aku.setVisibility(0);
      paramv.aku.animate().alpha(0.3F).setDuration(0L).setListener(null).start();
      boolean bool = a(paramv, i, j, k, m);
      AppMethodBeat.o(133799);
      return bool;
    }
    paramv.aku.setAlpha(0.0F);
    paramv.aku.setScaleX(0.8F);
    paramv.aku.setScaleY(0.8F);
    this.ach.add(paramv);
    AppMethodBeat.o(133799);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133805);
    View localView = paramv.aku;
    localView.animate().cancel();
    int i = this.aci.size() - 1;
    while (i >= 0)
    {
      if (((c.b)this.aci.get(i)).acJ == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        C(paramv);
        this.aci.remove(i);
      }
      i -= 1;
    }
    a(this.acj, paramv);
    if (this.acg.remove(paramv))
    {
      localView.setAlpha(1.0F);
      B(paramv);
    }
    if (this.ach.remove(paramv))
    {
      localView.setAlpha(1.0F);
      m(paramv);
    }
    i = this.acm.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.acm.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.acm.remove(i);
      }
      i -= 1;
    }
    i = this.acl.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.acl.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((c.b)localArrayList.get(j)).acJ != paramv) {
            break label299;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          C(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.acl.remove(i);
          }
        }
        i -= 1;
        break;
        label299:
        j -= 1;
      }
    }
    i = this.ack.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ack.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        m(paramv);
        if (localArrayList.isEmpty()) {
          this.ack.remove(i);
        }
      }
      i -= 1;
    }
    this.acp.remove(paramv);
    this.acn.remove(paramv);
    this.acq.remove(paramv);
    this.aco.remove(paramv);
    hB();
    AppMethodBeat.o(133805);
  }
  
  public final void hA()
  {
    AppMethodBeat.i(133797);
    a(this.jec);
    int i;
    int j;
    label39:
    int k;
    if (!this.acg.isEmpty())
    {
      i = 1;
      if (this.aci.isEmpty()) {
        break label95;
      }
      j = 1;
      if (this.acj.isEmpty()) {
        break label100;
      }
      k = 1;
      label52:
      if (this.ach.isEmpty()) {
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
      AppMethodBeat.o(133797);
      return;
      i = 0;
      break;
      j = 0;
      break label39;
      k = 0;
      break label52;
    }
    label112:
    Object localObject1 = this.acg.iterator();
    Object localObject2;
    View localView;
    ViewPropertyAnimator localViewPropertyAnimator;
    int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      localView = ((RecyclerView.v)localObject2).aku;
      localViewPropertyAnimator = localView.animate();
      this.acp.add(localObject2);
      n = ConversationAppBrandRecentView.bq(((RecyclerView.v)localObject2).aku);
      if (n - 1 != e.qV(this.jeb.getCurrentPage())) {
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
      ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", new Object[] { ((BaseAppBrandRecentView.c)localObject2).titleTv.getText(), Integer.valueOf(n), Float.valueOf(f) });
      localViewPropertyAnimator.setDuration(this.ajg).alpha(f).setListener(new c.7(this, (RecyclerView.v)localObject2, n, localViewPropertyAnimator, localView)).start();
      break;
      this.acg.clear();
      long l1;
      long l2;
      if (j != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.aci);
        this.acl.add(localObject1);
        this.aci.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(133778);
            Iterator localIterator = this.acr.iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (c.b)localIterator.next();
              c localc = c.this;
              RecyclerView.v localv = ((c.b)localObject).acJ;
              int k = ((c.b)localObject).acF;
              int i = ((c.b)localObject).acG;
              int m = ((c.b)localObject).acH;
              int j = ((c.b)localObject).acI;
              localObject = localv.aku;
              k = m - k;
              i = j - i;
              if (k != 0) {
                ((View)localObject).animate().translationX(0.0F);
              }
              if (i != 0) {
                ((View)localObject).animate().translationY(0.0F);
              }
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
              localc.aco.add(localv);
              j = ConversationAppBrandRecentView.bq(localv.aku);
              float f2 = 1.0F;
              boolean bool;
              label170:
              float f1;
              if (j < localc.jeb.getDataCount())
              {
                bool = true;
                if (bool) {
                  break label310;
                }
                f1 = 0.0F;
                localv.aku.setVisibility(4);
              }
              for (;;)
              {
                ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", new Object[] { Integer.valueOf(j), ((BaseAppBrandRecentView.c)localv).titleTv.getText(), Boolean.valueOf(bool), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(e.qV(localc.jeb.getCurrentPage())) });
                localViewPropertyAnimator.alpha(f1).setDuration(localc.ajh).setListener(new c.11(localc, localv, k, (View)localObject, i, bool, f1, localViewPropertyAnimator)).start();
                break;
                bool = false;
                break label170;
                label310:
                if ((e.qV(localc.jeb.getCurrentPage()) == j) && (k > 0))
                {
                  localv.aku.setVisibility(0);
                  f1 = 0.3F;
                }
                else
                {
                  f1 = f2;
                  if (e.qV(localc.jeb.getCurrentPage()) == j)
                  {
                    f1 = f2;
                    if (k < 0)
                    {
                      localv.aku.setVisibility(0);
                      f1 = 0.3F;
                    }
                  }
                }
              }
            }
            this.acr.clear();
            c.this.acl.remove(this.acr);
            AppMethodBeat.o(133778);
          }
        };
        if (i != 0) {
          t.a(((c.b)((ArrayList)localObject1).get(0)).acJ.aku, (Runnable)localObject2, this.ajg);
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.acj);
          this.acm.add(localObject1);
          this.acj.clear();
          localObject2 = new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(133779);
              Iterator localIterator = this.act.iterator();
              while (localIterator.hasNext())
              {
                c.a locala = (c.a)localIterator.next();
                if (locala != null)
                {
                  c localc = c.this;
                  Object localObject3 = locala.acD;
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
                    localObject2 = locala.acE;
                    if (localObject2 == null) {
                      break label318;
                    }
                    localObject2 = ((RecyclerView.v)localObject2).aku;
                    ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl %s", new Object[] { ((BaseAppBrandRecentView.c)localObject3).titleTv.getText() });
                    if (localObject1 != null)
                    {
                      localObject3 = ((View)localObject1).animate().setDuration(localc.aji);
                      localc.acq.add(locala.acD);
                      ((ViewPropertyAnimator)localObject3).translationX(locala.acH - locala.acF);
                      ((ViewPropertyAnimator)localObject3).translationY(locala.acI - locala.acG);
                      ((ViewPropertyAnimator)localObject3).alpha(0.0F).setListener(new c.2(localc, locala, (ViewPropertyAnimator)localObject3, (View)localObject1)).start();
                    }
                    if (localObject2 == null) {
                      continue;
                    }
                    i = ConversationAppBrandRecentView.bq((View)localObject2);
                    f = 1.0F;
                    if (i >= localc.jeb.getDataCount()) {
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
                    localc.acq.add(locala.acE);
                    ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).alpha(f).setDuration(localc.aji).setListener(new c.3(localc, locala, (ViewPropertyAnimator)localObject1, (View)localObject2, f, bool)).start();
                    break;
                    localObject1 = ((RecyclerView.v)localObject3).aku;
                    break label62;
                    label318:
                    localObject2 = null;
                    break label81;
                    label324:
                    bool = false;
                    break label231;
                    label330:
                    int j = ((LinearLayoutManager)localc.jeb.getLayoutManager()).iv();
                    ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChangeImpl lastVisiblePos: %d, position: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
                    if (j == i) {
                      f = 0.3F;
                    }
                  }
                }
              }
              this.act.clear();
              c.this.acm.remove(this.act);
              AppMethodBeat.o(133779);
            }
          };
          if (i == 0) {
            break label590;
          }
          t.a(((c.a)((ArrayList)localObject1).get(0)).acD.aku, (Runnable)localObject2, this.ajg);
        }
        if (m == 0) {
          break label625;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ach);
        this.ack.add(localObject1);
        this.ach.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(133780);
            Iterator localIterator = this.acu.iterator();
            while (localIterator.hasNext())
            {
              RecyclerView.v localv = (RecyclerView.v)localIterator.next();
              c localc = c.this;
              ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).titleTv.getText() });
              View localView = localv.aku;
              ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
              localc.acn.add(localv);
              int i = ConversationAppBrandRecentView.bq(localView);
              if ((localc.jea) && (i == 1))
              {
                ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateFirstItemInserted holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).titleTv.getText() });
                localView = localv.aku;
                localViewPropertyAnimator = localView.animate();
                if (ConversationAppBrandRecentView.bq(localv.aku) < localc.jeb.getDataCount()) {}
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
                ((BaseAppBrandRecentView.c)localv).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setAlpha(0.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setScaleX(1.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setScaleY(1.0F);
                ((BaseAppBrandRecentView.c)localv).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.c)localv).jft.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.8(localc, localv, localView, localViewPropertyAnimator)).start();
              }
              else if ((localc.jdZ) && (i == localc.jeb.getDataCount() - 1))
              {
                ab.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo lastItemAnimateAddImpl holder %s", new Object[] { ((BaseAppBrandRecentView.c)localv).titleTv.getText() });
                localView = localv.aku;
                localViewPropertyAnimator = localView.animate();
                localView.setVisibility(0);
                localView.setAlpha(1.0F);
                localView.setScaleX(1.0F);
                localView.setScaleY(1.0F);
                ((BaseAppBrandRecentView.c)localv).titleTv.setAlpha(0.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setAlpha(0.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setScaleX(1.0F);
                ((BaseAppBrandRecentView.c)localv).jft.setScaleY(1.0F);
                ((BaseAppBrandRecentView.c)localv).titleTv.animate().alpha(1.0F).setDuration(150L).setListener(null).start();
                ((BaseAppBrandRecentView.c)localv).jft.animate().alpha(1.0F).scaleX(1.2F).scaleY(1.2F).setDuration(150L).withEndAction(new c.10(localc, localv, localView, localViewPropertyAnimator)).start();
              }
              else
              {
                boolean bool;
                label574:
                float f;
                if (i < localc.jeb.getDataCount())
                {
                  bool = true;
                  if (bool) {
                    break label695;
                  }
                  localv.aku.setVisibility(4);
                  f = 0.0F;
                }
                for (;;)
                {
                  ab.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAddImpl pos: %d, targetAlpha: %f, customItemCount: %d, dataCount: %d", new Object[] { Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(localc.jeb.getCustomItemCount()), Integer.valueOf(localc.jeb.getDataCount()) });
                  localViewPropertyAnimator.alpha(f).scaleX(1.0F).scaleY(1.0F).setDuration(localc.ajf).setListener(new c.9(localc, localv, localView, i, bool, localViewPropertyAnimator)).start();
                  break;
                  bool = false;
                  break label574;
                  label695:
                  if (localc.jeb.qQ(i))
                  {
                    localv.aku.setVisibility(0);
                    f = 0.3F;
                  }
                  else
                  {
                    localv.aku.setVisibility(0);
                    f = 1.0F;
                  }
                }
              }
            }
            this.acu.clear();
            c.this.ack.remove(this.acu);
            AppMethodBeat.o(133780);
          }
        };
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label618;
        }
        if (i == 0) {
          break label600;
        }
        l1 = this.ajg;
        if (j == 0) {
          break label606;
        }
        l2 = this.ajh;
        if (k == 0) {
          break label612;
        }
      }
      for (long l3 = this.aji;; l3 = 0L)
      {
        l2 = Math.max(l2, l3);
        t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aku, (Runnable)localObject2, l1 + l2);
        AppMethodBeat.o(133797);
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
      AppMethodBeat.o(133797);
      return;
    }
  }
  
  final void hB()
  {
    AppMethodBeat.i(133808);
    if (!isRunning()) {
      jw();
    }
    AppMethodBeat.o(133808);
  }
  
  public final void hC()
  {
    AppMethodBeat.i(133809);
    int i = this.aci.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c.b)this.aci.get(i);
      localObject2 = ((c.b)localObject1).acJ.aku;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      C(((c.b)localObject1).acJ);
      this.aci.remove(i);
      i -= 1;
    }
    i = this.acg.size() - 1;
    while (i >= 0)
    {
      B((RecyclerView.v)this.acg.get(i));
      this.acg.remove(i);
      i -= 1;
    }
    i = this.ach.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.ach.get(i);
      ((RecyclerView.v)localObject1).aku.setAlpha(1.0F);
      m((RecyclerView.v)localObject1);
      this.ach.remove(i);
      i -= 1;
    }
    i = this.acj.size() - 1;
    while (i >= 0)
    {
      a((c.a)this.acj.get(i));
      i -= 1;
    }
    this.acj.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(133809);
      return;
    }
    i = this.acl.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.acl.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (c.b)((ArrayList)localObject1).get(j);
        View localView = ((c.b)localObject2).acJ.aku;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        C(((c.b)localObject2).acJ);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.acl.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ack.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ack.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).aku.setAlpha(1.0F);
        m((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.ack.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.acm.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.acm.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((c.a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.acm.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    o(this.acp);
    o(this.aco);
    o(this.acn);
    o(this.acq);
    jw();
    AppMethodBeat.o(133809);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(133807);
    if ((!this.ach.isEmpty()) || (!this.acj.isEmpty()) || (!this.aci.isEmpty()) || (!this.acg.isEmpty()) || (!this.aco.isEmpty()) || (!this.acp.isEmpty()) || (!this.acn.isEmpty()) || (!this.acq.isEmpty()) || (!this.acl.isEmpty()) || (!this.ack.isEmpty()) || (!this.acm.isEmpty()))
    {
      AppMethodBeat.o(133807);
      return true;
    }
    AppMethodBeat.o(133807);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */