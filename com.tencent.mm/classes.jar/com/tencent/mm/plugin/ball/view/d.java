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
  private static TimeInterpolator alX;
  private ArrayList<RecyclerView.w> alY;
  private ArrayList<RecyclerView.w> alZ;
  private ArrayList<c> ama;
  private ArrayList<a> amb;
  ArrayList<ArrayList<RecyclerView.w>> amc;
  ArrayList<ArrayList<c>> amd;
  ArrayList<ArrayList<a>> ame;
  ArrayList<RecyclerView.w> amf;
  ArrayList<RecyclerView.w> amg;
  ArrayList<RecyclerView.w> amh;
  ArrayList<RecyclerView.w> ami;
  d.b nKy;
  
  public d()
  {
    AppMethodBeat.i(209565);
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
    AppMethodBeat.o(209565);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(209572);
    if (parama.amv != null) {
      a(parama, parama.amv);
    }
    if (parama.amw != null) {
      a(parama, parama.amw);
    }
    AppMethodBeat.o(209572);
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    AppMethodBeat.i(209571);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.amv == null) && (locala.amw == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(209571);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(209573);
    if (parama.amw == paramw) {
      parama.amw = null;
    }
    for (;;)
    {
      paramw.auu.setAlpha(1.0F);
      paramw.auu.setTranslationX(0.0F);
      paramw.auu.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(209573);
      return true;
      if (parama.amv != paramw) {
        break;
      }
      parama.amv = null;
    }
    AppMethodBeat.o(209573);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(209575);
    if (alX == null) {
      alX = new ValueAnimator().getInterpolator();
    }
    paramw.auu.animate().setInterpolator(alX);
    d(paramw);
    AppMethodBeat.o(209575);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(209579);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).auu.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(209579);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209569);
    View localView = paramw.auu;
    paramInt1 += (int)paramw.auu.getTranslationX();
    paramInt2 += (int)paramw.auu.getTranslationY();
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      AppMethodBeat.o(209569);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.ama.add(new c(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(209569);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209570);
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(209570);
      return bool;
    }
    float f1 = paramw1.auu.getTranslationX();
    float f2 = paramw1.auu.getTranslationY();
    float f3 = paramw1.auu.getAlpha();
    e(paramw1);
    int i = (int)(paramInt3 - paramInt1 - f1);
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
    AppMethodBeat.o(209570);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(209580);
    if ((!paramList.isEmpty()) || (super.a(paramw, paramList)))
    {
      AppMethodBeat.o(209580);
      return true;
    }
    AppMethodBeat.o(209580);
    return false;
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(209567);
    e(paramw);
    this.alY.add(paramw);
    AppMethodBeat.o(209567);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(209568);
    e(paramw);
    paramw.auu.setAlpha(0.0F);
    this.alZ.add(paramw);
    AppMethodBeat.o(209568);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(209574);
    View localView = paramw.auu;
    localView.animate().cancel();
    int i = this.ama.size() - 1;
    while (i >= 0)
    {
      if (((c)this.ama.get(i)).amB == paramw)
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
      localView.setTranslationX(0.0F);
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
          if (((c)localArrayList.get(j)).amB != paramw) {
            break label304;
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
        label304:
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
    AppMethodBeat.o(209574);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(209576);
    if ((!this.alZ.isEmpty()) || (!this.amb.isEmpty()) || (!this.ama.isEmpty()) || (!this.alY.isEmpty()) || (!this.amg.isEmpty()) || (!this.amh.isEmpty()) || (!this.amf.isEmpty()) || (!this.ami.isEmpty()) || (!this.amd.isEmpty()) || (!this.amc.isEmpty()) || (!this.ame.isEmpty()))
    {
      AppMethodBeat.o(209576);
      return true;
    }
    AppMethodBeat.o(209576);
    return false;
  }
  
  public final void ju()
  {
    AppMethodBeat.i(209566);
    int i;
    int j;
    label29:
    int k;
    if (!this.alY.isEmpty())
    {
      i = 1;
      if (this.ama.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.amb.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.alZ.isEmpty()) {
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
      AppMethodBeat.o(209566);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.alY.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      Object localObject3 = ((RecyclerView.w)localObject2).auu;
      this.amh.add(localObject2);
      final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
      localObject3 = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209556);
          localViewPropertyAnimator.setListener(null);
          this.val$view.setAlpha(1.0F);
          d.this.w(this.amn);
          d.this.amh.remove(this.amn);
          d.this.jv();
          AppMethodBeat.o(209556);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209555);
          d.this.A(this.amn);
          AppMethodBeat.o(209555);
        }
      };
      if ((this.nKy == null) || (!this.nKy.a((RecyclerView.w)localObject2, (Animator.AnimatorListener)localObject3))) {
        localViewPropertyAnimator.setDuration(lq()).alpha(0.0F).setListener((Animator.AnimatorListener)localObject3).start();
      }
    }
    this.alY.clear();
    label383:
    long l1;
    label458:
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
          AppMethodBeat.i(209552);
          Iterator localIterator = this.amj.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (d.c)localIterator.next();
            d locald = d.this;
            RecyclerView.w localw = ((d.c)localObject).amB;
            int k = ((d.c)localObject).amx;
            int i = ((d.c)localObject).amy;
            int m = ((d.c)localObject).amz;
            int j = ((d.c)localObject).amA;
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
            locald.amg.add(localw);
            localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(locald.ate).setListener(new d.6(locald, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amj.clear();
          d.this.amd.remove(this.amj);
          AppMethodBeat.o(209552);
        }
      };
      if (i != 0) {
        t.a(((c)((ArrayList)localObject1).get(0)).amB.auu, (Runnable)localObject2, lq());
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
            AppMethodBeat.i(209553);
            Iterator localIterator = this.aml.iterator();
            if (localIterator.hasNext())
            {
              d.a locala = (d.a)localIterator.next();
              d locald = d.this;
              Object localObject1 = locala.amv;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.amw;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.w)localObject2).auu;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locald.atf);
                  locald.ami.add(locala.amv);
                  localViewPropertyAnimator.translationX(locala.amz - locala.amx);
                  localViewPropertyAnimator.translationY(locala.amA - locala.amy);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new d.7(locald, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locald.ami.add(locala.amw);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locald.atf).alpha(1.0F).setListener(new d.8(locald, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).auu;
                break label51;
              }
            }
            this.aml.clear();
            d.this.ame.remove(this.aml);
            AppMethodBeat.o(209553);
          }
        };
        if (i == 0) {
          break label525;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).amv.auu, (Runnable)localObject2, lq());
      }
      if (m == 0) {
        break label560;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.alZ);
      this.amc.add(localObject1);
      this.alZ.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209554);
          Iterator localIterator = this.amm.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            d locald = d.this;
            View localView = localw.auu;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locald.amf.add(localw);
            localViewPropertyAnimator.alpha(1.0F).setDuration(locald.lp()).setListener(new d.5(locald, localw, localView, localViewPropertyAnimator)).start();
          }
          this.amm.clear();
          d.this.amc.remove(this.amm);
          AppMethodBeat.o(209554);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label553;
      }
      if (i == 0) {
        break label535;
      }
      l1 = lq();
      if (j == 0) {
        break label541;
      }
      l2 = this.ate;
      label468:
      if (k == 0) {
        break label547;
      }
    }
    label525:
    label535:
    label541:
    label547:
    for (long l3 = this.atf;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).auu, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(209566);
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
    AppMethodBeat.o(209566);
  }
  
  final void jv()
  {
    AppMethodBeat.i(209577);
    if (!isRunning()) {
      lu();
    }
    AppMethodBeat.o(209577);
  }
  
  public final void jw()
  {
    AppMethodBeat.i(209578);
    int i = this.ama.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c)this.ama.get(i);
      localObject2 = ((c)localObject1).amB.auu;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((c)localObject1).amB);
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
      AppMethodBeat.o(209578);
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
        localObject2 = (c)((ArrayList)localObject1).get(j);
        View localView = ((c)localObject2).amB.auu;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((c)localObject2).amB);
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
    AppMethodBeat.o(209578);
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
      AppMethodBeat.i(209564);
      String str = "ChangeInfo{oldHolder=" + this.amv + ", newHolder=" + this.amw + ", fromX=" + this.amx + ", fromY=" + this.amy + ", toX=" + this.amz + ", toY=" + this.amA + '}';
      AppMethodBeat.o(209564);
      return str;
    }
  }
  
  static final class c
  {
    public int amA;
    public RecyclerView.w amB;
    public int amx;
    public int amy;
    public int amz;
    
    c(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */