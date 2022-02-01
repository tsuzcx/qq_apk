package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
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
  private static TimeInterpolator amk;
  private ArrayList<RecyclerView.v> aml;
  private ArrayList<RecyclerView.v> amm;
  private ArrayList<c> amn;
  private ArrayList<a> amo;
  ArrayList<ArrayList<RecyclerView.v>> amp;
  ArrayList<ArrayList<c>> amq;
  ArrayList<ArrayList<a>> amr;
  ArrayList<RecyclerView.v> ams;
  ArrayList<RecyclerView.v> amt;
  ArrayList<RecyclerView.v> amu;
  ArrayList<RecyclerView.v> amv;
  b oVt;
  
  public d()
  {
    AppMethodBeat.i(217137);
    this.aml = new ArrayList();
    this.amm = new ArrayList();
    this.amn = new ArrayList();
    this.amo = new ArrayList();
    this.amp = new ArrayList();
    this.amq = new ArrayList();
    this.amr = new ArrayList();
    this.ams = new ArrayList();
    this.amt = new ArrayList();
    this.amu = new ArrayList();
    this.amv = new ArrayList();
    AppMethodBeat.o(217137);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(217144);
    if (parama.amI != null) {
      a(parama, parama.amI);
    }
    if (parama.amJ != null) {
      a(parama, parama.amJ);
    }
    AppMethodBeat.o(217144);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(217143);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.amI == null) && (locala.amJ == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(217143);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(217145);
    if (parama.amJ == paramv) {
      parama.amJ = null;
    }
    for (;;)
    {
      paramv.aus.setAlpha(1.0F);
      paramv.aus.setTranslationX(0.0F);
      paramv.aus.setTranslationY(0.0F);
      n(paramv);
      AppMethodBeat.o(217145);
      return true;
      if (parama.amI != paramv) {
        break;
      }
      parama.amI = null;
    }
    AppMethodBeat.o(217145);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(217147);
    if (amk == null) {
      amk = new ValueAnimator().getInterpolator();
    }
    paramv.aus.animate().setInterpolator(amk);
    d(paramv);
    AppMethodBeat.o(217147);
  }
  
  private static void n(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(217151);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aus.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(217151);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(217141);
    View localView = paramv.aus;
    paramInt1 += (int)paramv.aus.getTranslationX();
    paramInt2 += (int)paramv.aus.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(217141);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.amn.add(new c(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(217141);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(217142);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(217142);
      return bool;
    }
    float f1 = paramv1.aus.getTranslationX();
    float f2 = paramv1.aus.getTranslationY();
    float f3 = paramv1.aus.getAlpha();
    e(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.aus.setTranslationX(f1);
    paramv1.aus.setTranslationY(f2);
    paramv1.aus.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.aus.setTranslationX(-i);
      paramv2.aus.setTranslationY(-j);
      paramv2.aus.setAlpha(0.0F);
    }
    this.amo.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(217142);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(217152);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(217152);
      return true;
    }
    AppMethodBeat.o(217152);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(217139);
    e(paramv);
    this.aml.add(paramv);
    AppMethodBeat.o(217139);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(217140);
    e(paramv);
    paramv.aus.setAlpha(0.0F);
    this.amm.add(paramv);
    AppMethodBeat.o(217140);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(217146);
    View localView = paramv.aus;
    localView.animate().cancel();
    int i = this.amn.size() - 1;
    while (i >= 0)
    {
      if (((c)this.amn.get(i)).amO == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramv);
        this.amn.remove(i);
      }
      i -= 1;
    }
    a(this.amo, paramv);
    if (this.aml.remove(paramv))
    {
      localView.setAlpha(1.0F);
      localView.setTranslationX(0.0F);
      w(paramv);
    }
    if (this.amm.remove(paramv))
    {
      localView.setAlpha(1.0F);
      n(paramv);
    }
    i = this.amr.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.amr.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.amr.remove(i);
      }
      i -= 1;
    }
    i = this.amq.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.amq.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((c)localArrayList.get(j)).amO != paramv) {
            break label304;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.amq.remove(i);
          }
        }
        i -= 1;
        break;
        label304:
        j -= 1;
      }
    }
    i = this.amp.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.amp.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        n(paramv);
        if (localArrayList.isEmpty()) {
          this.amp.remove(i);
        }
      }
      i -= 1;
    }
    this.amu.remove(paramv);
    this.ams.remove(paramv);
    this.amv.remove(paramv);
    this.amt.remove(paramv);
    jE();
    AppMethodBeat.o(217146);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(217148);
    if ((!this.amm.isEmpty()) || (!this.amo.isEmpty()) || (!this.amn.isEmpty()) || (!this.aml.isEmpty()) || (!this.amt.isEmpty()) || (!this.amu.isEmpty()) || (!this.ams.isEmpty()) || (!this.amv.isEmpty()) || (!this.amq.isEmpty()) || (!this.amp.isEmpty()) || (!this.amr.isEmpty()))
    {
      AppMethodBeat.o(217148);
      return true;
    }
    AppMethodBeat.o(217148);
    return false;
  }
  
  public final void jD()
  {
    AppMethodBeat.i(217138);
    int i;
    int j;
    label29:
    int k;
    if (!this.aml.isEmpty())
    {
      i = 1;
      if (this.amn.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.amo.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.amm.isEmpty()) {
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
      AppMethodBeat.o(217138);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.aml.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      Object localObject3 = ((RecyclerView.v)localObject2).aus;
      this.amu.add(localObject2);
      final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
      localObject3 = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(217128);
          localViewPropertyAnimator.setListener(null);
          this.val$view.setAlpha(1.0F);
          d.this.w(this.amA);
          d.this.amu.remove(this.amA);
          d.this.jE();
          AppMethodBeat.o(217128);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(217127);
          d.this.C(this.amA);
          AppMethodBeat.o(217127);
        }
      };
      if ((this.oVt == null) || (!this.oVt.a((RecyclerView.v)localObject2, (Animator.AnimatorListener)localObject3))) {
        localViewPropertyAnimator.setDuration(ly()).alpha(0.0F).setListener((Animator.AnimatorListener)localObject3).start();
      }
    }
    this.aml.clear();
    label383:
    long l1;
    label458:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.amn);
      this.amq.add(localObject1);
      this.amn.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217124);
          Iterator localIterator = this.amw.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (d.c)localIterator.next();
            d locald = d.this;
            RecyclerView.v localv = ((d.c)localObject).amO;
            int k = ((d.c)localObject).amK;
            int i = ((d.c)localObject).amL;
            int m = ((d.c)localObject).amM;
            int j = ((d.c)localObject).amN;
            localObject = localv.aus;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            locald.amt.add(localv);
            localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(locald.atp).setListener(new d.6(locald, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amw.clear();
          d.this.amq.remove(this.amw);
          AppMethodBeat.o(217124);
        }
      };
      if (i != 0) {
        u.a(((c)((ArrayList)localObject1).get(0)).amO.aus, (Runnable)localObject2, ly());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.amo);
        this.amr.add(localObject1);
        this.amo.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217125);
            Iterator localIterator = this.amy.iterator();
            if (localIterator.hasNext())
            {
              d.a locala = (d.a)localIterator.next();
              d locald = d.this;
              Object localObject1 = locala.amI;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.amJ;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).aus;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locald.atq);
                  locald.amv.add(locala.amI);
                  localViewPropertyAnimator.translationX(locala.amM - locala.amK);
                  localViewPropertyAnimator.translationY(locala.amN - locala.amL);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new d.7(locald, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locald.amv.add(locala.amJ);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locald.atq).alpha(1.0F).setListener(new d.8(locald, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).aus;
                break label51;
              }
            }
            this.amy.clear();
            d.this.amr.remove(this.amy);
            AppMethodBeat.o(217125);
          }
        };
        if (i == 0) {
          break label525;
        }
        u.a(((a)((ArrayList)localObject1).get(0)).amI.aus, (Runnable)localObject2, ly());
      }
      if (m == 0) {
        break label560;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.amm);
      this.amp.add(localObject1);
      this.amm.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217126);
          Iterator localIterator = this.amz.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            d locald = d.this;
            View localView = localv.aus;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locald.ams.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(locald.lx()).setListener(new d.5(locald, localv, localView, localViewPropertyAnimator)).start();
          }
          this.amz.clear();
          d.this.amp.remove(this.amz);
          AppMethodBeat.o(217126);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label553;
      }
      if (i == 0) {
        break label535;
      }
      l1 = ly();
      if (j == 0) {
        break label541;
      }
      l2 = this.atp;
      label468:
      if (k == 0) {
        break label547;
      }
    }
    label525:
    label535:
    label541:
    label547:
    for (long l3 = this.atq;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      u.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aus, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(217138);
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
    AppMethodBeat.o(217138);
  }
  
  final void jE()
  {
    AppMethodBeat.i(217149);
    if (!isRunning()) {
      lC();
    }
    AppMethodBeat.o(217149);
  }
  
  public final void jF()
  {
    AppMethodBeat.i(217150);
    int i = this.amn.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c)this.amn.get(i);
      localObject2 = ((c)localObject1).amO.aus;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((c)localObject1).amO);
      this.amn.remove(i);
      i -= 1;
    }
    i = this.aml.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.v)this.aml.get(i));
      this.aml.remove(i);
      i -= 1;
    }
    i = this.amm.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.amm.get(i);
      ((RecyclerView.v)localObject1).aus.setAlpha(1.0F);
      n((RecyclerView.v)localObject1);
      this.amm.remove(i);
      i -= 1;
    }
    i = this.amo.size() - 1;
    while (i >= 0)
    {
      a((a)this.amo.get(i));
      i -= 1;
    }
    this.amo.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(217150);
      return;
    }
    i = this.amq.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.amq.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (c)((ArrayList)localObject1).get(j);
        View localView = ((c)localObject2).amO.aus;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((c)localObject2).amO);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amq.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.amp.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.amp.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).aus.setAlpha(1.0F);
        n((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.amp.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.amr.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.amr.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.amr.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    n(this.amu);
    n(this.amt);
    n(this.ams);
    n(this.amv);
    lC();
    AppMethodBeat.o(217150);
  }
  
  static final class a
  {
    public RecyclerView.v amI;
    public RecyclerView.v amJ;
    public int amK;
    public int amL;
    public int amM;
    public int amN;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.amI = paramv1;
      this.amJ = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.amK = paramInt1;
      this.amL = paramInt2;
      this.amM = paramInt3;
      this.amN = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(217136);
      String str = "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
      AppMethodBeat.o(217136);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(RecyclerView.v paramv, Animator.AnimatorListener paramAnimatorListener);
  }
  
  static final class c
  {
    public int amK;
    public int amL;
    public int amM;
    public int amN;
    public RecyclerView.v amO;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.amO = paramv;
      this.amK = paramInt1;
      this.amL = paramInt2;
      this.amM = paramInt3;
      this.amN = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */