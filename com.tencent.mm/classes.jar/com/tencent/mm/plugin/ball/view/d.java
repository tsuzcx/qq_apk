package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends as
{
  private static TimeInterpolator akg;
  private ArrayList<RecyclerView.w> akh;
  private ArrayList<RecyclerView.w> aki;
  private ArrayList<c> akj;
  private ArrayList<a> akk;
  ArrayList<ArrayList<RecyclerView.w>> akl;
  ArrayList<ArrayList<c>> akm;
  ArrayList<ArrayList<a>> akn;
  ArrayList<RecyclerView.w> ako;
  ArrayList<RecyclerView.w> akp;
  ArrayList<RecyclerView.w> akq;
  ArrayList<RecyclerView.w> akr;
  d.b neH;
  
  public d()
  {
    AppMethodBeat.i(208071);
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
    AppMethodBeat.o(208071);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(208078);
    if (parama.akE != null) {
      a(parama, parama.akE);
    }
    if (parama.akF != null) {
      a(parama, parama.akF);
    }
    AppMethodBeat.o(208078);
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    AppMethodBeat.i(208077);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.akE == null) && (locala.akF == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(208077);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(208079);
    if (parama.akF == paramw) {
      parama.akF = null;
    }
    for (;;)
    {
      paramw.asD.setAlpha(1.0F);
      paramw.asD.setTranslationX(0.0F);
      paramw.asD.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(208079);
      return true;
      if (parama.akE != paramw) {
        break;
      }
      parama.akE = null;
    }
    AppMethodBeat.o(208079);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(208081);
    if (akg == null) {
      akg = new ValueAnimator().getInterpolator();
    }
    paramw.asD.animate().setInterpolator(akg);
    d(paramw);
    AppMethodBeat.o(208081);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(208085);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).asD.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(208085);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208075);
    View localView = paramw.asD;
    paramInt1 += (int)paramw.asD.getTranslationX();
    paramInt2 += (int)paramw.asD.getTranslationY();
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      AppMethodBeat.o(208075);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.akj.add(new c(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(208075);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208076);
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(208076);
      return bool;
    }
    float f1 = paramw1.asD.getTranslationX();
    float f2 = paramw1.asD.getTranslationY();
    float f3 = paramw1.asD.getAlpha();
    e(paramw1);
    int i = (int)(paramInt3 - paramInt1 - f1);
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
    AppMethodBeat.o(208076);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(208086);
    if ((!paramList.isEmpty()) || (super.a(paramw, paramList)))
    {
      AppMethodBeat.o(208086);
      return true;
    }
    AppMethodBeat.o(208086);
    return false;
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(208073);
    e(paramw);
    this.akh.add(paramw);
    AppMethodBeat.o(208073);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(208074);
    e(paramw);
    paramw.asD.setAlpha(0.0F);
    this.aki.add(paramw);
    AppMethodBeat.o(208074);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(208080);
    View localView = paramw.asD;
    localView.animate().cancel();
    int i = this.akj.size() - 1;
    while (i >= 0)
    {
      if (((c)this.akj.get(i)).akK == paramw)
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
      localView.setTranslationX(0.0F);
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
          if (((c)localArrayList.get(j)).akK != paramw) {
            break label304;
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
        label304:
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
    AppMethodBeat.o(208080);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(208082);
    if ((!this.aki.isEmpty()) || (!this.akk.isEmpty()) || (!this.akj.isEmpty()) || (!this.akh.isEmpty()) || (!this.akp.isEmpty()) || (!this.akq.isEmpty()) || (!this.ako.isEmpty()) || (!this.akr.isEmpty()) || (!this.akm.isEmpty()) || (!this.akl.isEmpty()) || (!this.akn.isEmpty()))
    {
      AppMethodBeat.o(208082);
      return true;
    }
    AppMethodBeat.o(208082);
    return false;
  }
  
  public final void je()
  {
    AppMethodBeat.i(208072);
    int i;
    int j;
    label29:
    int k;
    if (!this.akh.isEmpty())
    {
      i = 1;
      if (this.akj.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.akk.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.aki.isEmpty()) {
        break label92;
      }
    }
    label82:
    label87:
    label92:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label98;
      }
      AppMethodBeat.o(208072);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.akh.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      Object localObject3 = ((RecyclerView.w)localObject2).asD;
      this.akq.add(localObject2);
      final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
      localObject3 = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(208062);
          localViewPropertyAnimator.setListener(null);
          this.val$view.setAlpha(1.0F);
          d.this.w(this.akw);
          d.this.akq.remove(this.akw);
          d.this.jf();
          AppMethodBeat.o(208062);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(208061);
          d.this.A(this.akw);
          AppMethodBeat.o(208061);
        }
      };
      if ((this.neH == null) || (!this.neH.a((RecyclerView.w)localObject2, (Animator.AnimatorListener)localObject3))) {
        localViewPropertyAnimator.setDuration(kY()).alpha(0.0F).setListener((Animator.AnimatorListener)localObject3).start();
      }
    }
    this.akh.clear();
    label383:
    long l1;
    label458:
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
          AppMethodBeat.i(208058);
          Iterator localIterator = this.aks.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (d.c)localIterator.next();
            d locald = d.this;
            RecyclerView.w localw = ((d.c)localObject).akK;
            int k = ((d.c)localObject).akG;
            int i = ((d.c)localObject).akH;
            int m = ((d.c)localObject).akI;
            int j = ((d.c)localObject).akJ;
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
            locald.akp.add(localw);
            localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(locald.arm).setListener(new d.6(locald, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.aks.clear();
          d.this.akm.remove(this.aks);
          AppMethodBeat.o(208058);
        }
      };
      if (i != 0) {
        t.a(((c)((ArrayList)localObject1).get(0)).akK.asD, (Runnable)localObject2, kY());
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
            AppMethodBeat.i(208059);
            Iterator localIterator = this.aku.iterator();
            if (localIterator.hasNext())
            {
              d.a locala = (d.a)localIterator.next();
              d locald = d.this;
              Object localObject1 = locala.akE;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.akF;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.w)localObject2).asD;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locald.arn);
                  locald.akr.add(locala.akE);
                  localViewPropertyAnimator.translationX(locala.akI - locala.akG);
                  localViewPropertyAnimator.translationY(locala.akJ - locala.akH);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new d.7(locald, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locald.akr.add(locala.akF);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locald.arn).alpha(1.0F).setListener(new d.8(locald, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).asD;
                break label51;
              }
            }
            this.aku.clear();
            d.this.akn.remove(this.aku);
            AppMethodBeat.o(208059);
          }
        };
        if (i == 0) {
          break label525;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).akE.asD, (Runnable)localObject2, kY());
      }
      if (m == 0) {
        break label560;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aki);
      this.akl.add(localObject1);
      this.aki.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208060);
          Iterator localIterator = this.akv.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            d locald = d.this;
            View localView = localw.asD;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locald.ako.add(localw);
            localViewPropertyAnimator.alpha(1.0F).setDuration(locald.kX()).setListener(new d.5(locald, localw, localView, localViewPropertyAnimator)).start();
          }
          this.akv.clear();
          d.this.akl.remove(this.akv);
          AppMethodBeat.o(208060);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label553;
      }
      if (i == 0) {
        break label535;
      }
      l1 = kY();
      if (j == 0) {
        break label541;
      }
      l2 = this.arm;
      label468:
      if (k == 0) {
        break label547;
      }
    }
    label525:
    label535:
    label541:
    label547:
    for (long l3 = this.arn;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).asD, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(208072);
      return;
      ((Runnable)localObject2).run();
      break;
      ((Runnable)localObject2).run();
      break label383;
      l1 = 0L;
      break label458;
      l2 = 0L;
      break label468;
    }
    label553:
    ((Runnable)localObject2).run();
    label560:
    AppMethodBeat.o(208072);
  }
  
  final void jf()
  {
    AppMethodBeat.i(208083);
    if (!isRunning()) {
      lc();
    }
    AppMethodBeat.o(208083);
  }
  
  public final void jg()
  {
    AppMethodBeat.i(208084);
    int i = this.akj.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c)this.akj.get(i);
      localObject2 = ((c)localObject1).akK.asD;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((c)localObject1).akK);
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
      AppMethodBeat.o(208084);
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
        localObject2 = (c)((ArrayList)localObject1).get(j);
        View localView = ((c)localObject2).akK.asD;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((c)localObject2).akK);
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
    AppMethodBeat.o(208084);
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
      AppMethodBeat.i(208070);
      String str = "ChangeInfo{oldHolder=" + this.akE + ", newHolder=" + this.akF + ", fromX=" + this.akG + ", fromY=" + this.akH + ", toX=" + this.akI + ", toY=" + this.akJ + '}';
      AppMethodBeat.o(208070);
      return str;
    }
  }
  
  static final class c
  {
    public int akG;
    public int akH;
    public int akI;
    public int akJ;
    public RecyclerView.w akK;
    
    c(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */