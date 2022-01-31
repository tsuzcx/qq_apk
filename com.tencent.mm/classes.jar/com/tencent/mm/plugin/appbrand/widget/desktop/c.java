package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.q;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.f.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.ar;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c
  extends ar
{
  private static TimeInterpolator abu;
  ArrayList<ArrayList<c.b>> abA = new ArrayList();
  ArrayList<ArrayList<c.a>> abB = new ArrayList();
  ArrayList<RecyclerView.v> abC = new ArrayList();
  ArrayList<RecyclerView.v> abD = new ArrayList();
  ArrayList<RecyclerView.v> abE = new ArrayList();
  ArrayList<RecyclerView.v> abF = new ArrayList();
  private ArrayList<RecyclerView.v> abv = new ArrayList();
  private ArrayList<RecyclerView.v> abw = new ArrayList();
  private ArrayList<c.b> abx = new ArrayList();
  private ArrayList<c.a> aby = new ArrayList();
  ArrayList<ArrayList<RecyclerView.v>> abz = new ArrayList();
  boolean hpS = false;
  public boolean hpT = false;
  ConversationAppBrandRecentView hpU;
  private RecyclerView.f.a hpV = new c.1(this);
  
  public c(ConversationAppBrandRecentView paramConversationAppBrandRecentView, boolean paramBoolean)
  {
    this.hpU = paramConversationAppBrandRecentView;
    this.hpS = paramBoolean;
  }
  
  private void a(c.a parama)
  {
    if (parama.abS != null) {
      a(parama, parama.abS);
    }
    if (parama.abT != null) {
      a(parama, parama.abT);
    }
  }
  
  private void a(List<c.a> paramList, RecyclerView.v paramv)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      c.a locala = (c.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.abS == null) && (locala.abT == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(c.a parama, RecyclerView.v paramv)
  {
    if (parama.abT == paramv) {
      parama.abT = null;
    }
    for (;;)
    {
      paramv.aie.setAlpha(1.0F);
      paramv.aie.setTranslationX(0.0F);
      paramv.aie.setTranslationY(0.0F);
      l(paramv);
      return true;
      if (parama.abS != paramv) {
        break;
      }
      parama.abS = null;
    }
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    if (abu == null) {
      abu = new ValueAnimator().getInterpolator();
    }
    paramv.aie.animate().setInterpolator(abu);
    d(paramv);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aie.animate().cancel();
      i -= 1;
    }
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.aie;
    paramInt1 = (int)paramv.aie.getTranslationX() + paramInt1;
    paramInt2 = (int)paramv.aie.getTranslationY() + paramInt2;
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMove holder %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).eXr.getText() });
    paramv.aie.setScaleX(1.0F);
    paramv.aie.setScaleY(1.0F);
    this.abx.add(new c.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    int i = ConversationAppBrandRecentView.bg(paramv1.aie);
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateChange %s, pos: %d", new Object[] { ((BaseAppBrandRecentView.c)paramv2).eXr.getText(), Integer.valueOf(i) });
    float f1 = paramv1.aie.getTranslationX();
    float f2 = paramv1.aie.getTranslationY();
    float f3 = paramv1.aie.getAlpha();
    e(paramv1);
    i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.aie.setTranslationX(f1);
    paramv1.aie.setTranslationY(f2);
    paramv1.aie.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.aie.setTranslationX(-i);
      paramv2.aie.setTranslationY(-j);
      paramv2.aie.setAlpha(0.0F);
    }
    this.aby.add(new c.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemove %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).eXr.getText() });
    e(paramv);
    this.abv.add(paramv);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd holder %s", new Object[] { ((BaseAppBrandRecentView.c)paramv).eXr.getText() });
    int j = ConversationAppBrandRecentView.bg(paramv.aie);
    if (j < this.hpU.getDataCount()) {}
    for (int i = 1; i == 0; i = 0)
    {
      y.v("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd not valid item");
      ((BaseAppBrandRecentView.c)paramv).aie.setVisibility(4);
      return true;
    }
    if (this.hpU.nj(j))
    {
      y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateAdd last position %d of currentPage: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.hpU.getCurrentPage()) });
      i = (int)paramv.aie.getX();
      j = d.cI(ae.getContext());
      i = d.c(ae.getContext(), b.getShowCountPerPage()) + (i + j);
      j = (int)paramv.aie.getY();
      int k = (int)paramv.aie.getX();
      int m = (int)paramv.aie.getY();
      y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateLastItemOfPage fromX: %d, toX: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
      paramv.aie.setVisibility(0);
      paramv.aie.animate().alpha(0.3F).setDuration(0L).setListener(null).start();
      return a(paramv, i, j, k, m);
    }
    paramv.aie.setAlpha(0.0F);
    paramv.aie.setScaleX(0.8F);
    paramv.aie.setScaleY(0.8F);
    this.abw.add(paramv);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    View localView = paramv.aie;
    localView.animate().cancel();
    int i = this.abx.size() - 1;
    while (i >= 0)
    {
      if (((c.b)this.abx.get(i)).abY == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramv);
        this.abx.remove(i);
      }
      i -= 1;
    }
    a(this.aby, paramv);
    if (this.abv.remove(paramv))
    {
      localView.setAlpha(1.0F);
      w(paramv);
    }
    if (this.abw.remove(paramv))
    {
      localView.setAlpha(1.0F);
      l(paramv);
    }
    i = this.abB.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.abB.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.abB.remove(i);
      }
      i -= 1;
    }
    i = this.abA.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.abA.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((c.b)localArrayList.get(j)).abY != paramv) {
            break label293;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.abA.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = this.abz.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.abz.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        l(paramv);
        if (localArrayList.isEmpty()) {
          this.abz.remove(i);
        }
      }
      i -= 1;
    }
    this.abE.remove(paramv);
    this.abC.remove(paramv);
    this.abF.remove(paramv);
    this.abD.remove(paramv);
    gB();
  }
  
  public final void gA()
  {
    a(this.hpV);
    int i;
    int j;
    label33:
    int k;
    if (!this.abv.isEmpty())
    {
      i = 1;
      if (this.abx.isEmpty()) {
        break label83;
      }
      j = 1;
      if (this.aby.isEmpty()) {
        break label88;
      }
      k = 1;
      label46:
      if (this.abw.isEmpty()) {
        break label94;
      }
    }
    label83:
    label88:
    label94:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label100;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label33;
      k = 0;
      break label46;
    }
    label100:
    Object localObject1 = this.abv.iterator();
    label109:
    Object localObject2;
    View localView;
    ViewPropertyAnimator localViewPropertyAnimator;
    int n;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      localView = ((RecyclerView.v)localObject2).aie;
      localViewPropertyAnimator = localView.animate();
      this.abE.add(localObject2);
      n = ConversationAppBrandRecentView.bg(((RecyclerView.v)localObject2).aie);
      if (n - 1 != e.no(this.hpU.getCurrentPage())) {
        break label608;
      }
    }
    label433:
    label572:
    label580:
    label582:
    label588:
    label594:
    label600:
    label608:
    for (float f = 0.3F;; f = 0.0F)
    {
      y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateRemoveImpl %s, pos: %d, targetAlpha: %f", new Object[] { ((BaseAppBrandRecentView.c)localObject2).eXr.getText(), Integer.valueOf(n), Float.valueOf(f) });
      localViewPropertyAnimator.setDuration(this.agQ).alpha(f).setListener(new c.7(this, (RecyclerView.v)localObject2, n, localViewPropertyAnimator, localView)).start();
      break label109;
      this.abv.clear();
      label352:
      long l1;
      label509:
      long l2;
      if (j != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.abx);
        this.abA.add(localObject1);
        this.abx.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            Iterator localIterator = this.abG.iterator();
            if (localIterator.hasNext())
            {
              Object localObject = (c.b)localIterator.next();
              c localc = c.this;
              RecyclerView.v localv = ((c.b)localObject).abY;
              int k = ((c.b)localObject).abU;
              int i = ((c.b)localObject).abV;
              int m = ((c.b)localObject).abW;
              int j = ((c.b)localObject).abX;
              localObject = localv.aie;
              k = m - k;
              i = j - i;
              if (k != 0) {
                ((View)localObject).animate().translationX(0.0F);
              }
              if (i != 0) {
                ((View)localObject).animate().translationY(0.0F);
              }
              ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
              localc.abD.add(localv);
              j = ConversationAppBrandRecentView.bg(localv.aie);
              float f2 = 1.0F;
              boolean bool;
              label165:
              float f1;
              if (j < localc.hpU.getDataCount())
              {
                bool = true;
                if (bool) {
                  break label305;
                }
                f1 = 0.0F;
                localv.aie.setVisibility(4);
              }
              for (;;)
              {
                y.d("MicroMsg.AppBrandDesktopRecyclerItemAnimator", "alvinluo animateMoveImpl position: %d, %s, isValid: %b, targetAlpha: %f, deltaX: %d, lastPosOfPage: %d", new Object[] { Integer.valueOf(j), ((BaseAppBrandRecentView.c)localv).eXr.getText(), Boolean.valueOf(bool), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(e.no(localc.hpU.getCurrentPage())) });
                localViewPropertyAnimator.alpha(f1).setDuration(localc.agR).setListener(new c.11(localc, localv, k, (View)localObject, i, bool, f1, localViewPropertyAnimator)).start();
                break;
                bool = false;
                break label165;
                label305:
                if ((e.no(localc.hpU.getCurrentPage()) == j) && (k > 0))
                {
                  localv.aie.setVisibility(0);
                  f1 = 0.3F;
                }
                else
                {
                  f1 = f2;
                  if (e.no(localc.hpU.getCurrentPage()) == j)
                  {
                    f1 = f2;
                    if (k < 0)
                    {
                      localv.aie.setVisibility(0);
                      f1 = 0.3F;
                    }
                  }
                }
              }
            }
            this.abG.clear();
            c.this.abA.remove(this.abG);
          }
        };
        if (i != 0) {
          q.a(((c.b)((ArrayList)localObject1).get(0)).abY.aie, (Runnable)localObject2, this.agQ);
        }
      }
      else
      {
        if (k != 0)
        {
          localObject1 = new ArrayList();
          ((ArrayList)localObject1).addAll(this.aby);
          this.abB.add(localObject1);
          this.aby.clear();
          localObject2 = new c.5(this, (ArrayList)localObject1);
          if (i == 0) {
            break label572;
          }
          q.a(((c.a)((ArrayList)localObject1).get(0)).abS.aie, (Runnable)localObject2, this.agQ);
        }
        if (m == 0) {
          break label580;
        }
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.abw);
        this.abz.add(localObject1);
        this.abw.clear();
        localObject2 = new c.6(this, (ArrayList)localObject1);
        if ((i == 0) && (j == 0) && (k == 0)) {
          break label600;
        }
        if (i == 0) {
          break label582;
        }
        l1 = this.agQ;
        if (j == 0) {
          break label588;
        }
        l2 = this.agR;
        if (k == 0) {
          break label594;
        }
      }
      for (long l3 = this.agS;; l3 = 0L)
      {
        l2 = Math.max(l2, l3);
        q.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aie, (Runnable)localObject2, l1 + l2);
        return;
        ((Runnable)localObject2).run();
        break label352;
        ((Runnable)localObject2).run();
        break label433;
        break;
        l1 = 0L;
        break label509;
        l2 = 0L;
        break label519;
      }
      ((Runnable)localObject2).run();
      return;
    }
  }
  
  final void gB()
  {
    if (!isRunning()) {
      hP();
    }
  }
  
  public final void gC()
  {
    int i = this.abx.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c.b)this.abx.get(i);
      localObject2 = ((c.b)localObject1).abY.aie;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((c.b)localObject1).abY);
      this.abx.remove(i);
      i -= 1;
    }
    i = this.abv.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.v)this.abv.get(i));
      this.abv.remove(i);
      i -= 1;
    }
    i = this.abw.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.abw.get(i);
      ((RecyclerView.v)localObject1).aie.setAlpha(1.0F);
      l((RecyclerView.v)localObject1);
      this.abw.remove(i);
      i -= 1;
    }
    i = this.aby.size() - 1;
    while (i >= 0)
    {
      a((c.a)this.aby.get(i));
      i -= 1;
    }
    this.aby.clear();
    if (!isRunning()) {
      return;
    }
    i = this.abA.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abA.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (c.b)((ArrayList)localObject1).get(j);
        View localView = ((c.b)localObject2).abY.aie;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((c.b)localObject2).abY);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.abA.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.abz.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abz.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).aie.setAlpha(1.0F);
        l((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.abz.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.abB.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abB.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((c.a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.abB.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    o(this.abE);
    o(this.abD);
    o(this.abC);
    o(this.abF);
    hP();
  }
  
  public final boolean isRunning()
  {
    return (!this.abw.isEmpty()) || (!this.aby.isEmpty()) || (!this.abx.isEmpty()) || (!this.abv.isEmpty()) || (!this.abD.isEmpty()) || (!this.abE.isEmpty()) || (!this.abC.isEmpty()) || (!this.abF.isEmpty()) || (!this.abA.isEmpty()) || (!this.abz.isEmpty()) || (!this.abB.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */