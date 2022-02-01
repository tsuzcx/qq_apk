package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends as
{
  private static TimeInterpolator akg;
  RecyclerView.a abe;
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
  private boolean mxZ;
  
  f()
  {
    AppMethodBeat.i(49662);
    this.mxZ = false;
    this.abe = null;
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
    this.ark = 200L;
    this.arn = 200L;
    this.arm = 200L;
    this.arl = 200L;
    AppMethodBeat.o(49662);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49669);
    if (parama.akE != null) {
      a(parama, parama.akE);
    }
    if (parama.akF != null) {
      a(parama, parama.akF);
    }
    AppMethodBeat.o(49669);
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49668);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.akE == null) && (locala.akF == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49668);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49670);
    if (parama.akF == paramw) {
      parama.akF = null;
    }
    for (;;)
    {
      paramw.asD.setAlpha(1.0F);
      paramw.asD.setTranslationX(0.0F);
      paramw.asD.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(49670);
      return true;
      if (parama.akE != paramw) {
        break;
      }
      parama.akE = null;
    }
    AppMethodBeat.o(49670);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49672);
    if (akg == null) {
      akg = new ValueAnimator().getInterpolator();
    }
    paramw.asD.animate().setInterpolator(akg);
    d(paramw);
    AppMethodBeat.o(49672);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(49676);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).asD.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49676);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49666);
    View localView = paramw.asD;
    paramInt1 += (int)paramw.asD.getTranslationX();
    paramInt2 += (int)paramw.asD.getTranslationY();
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      AppMethodBeat.o(49666);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.akj.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49666);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49667);
    ac.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", new Object[] { Integer.valueOf(paramw1.lv()) });
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49667);
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
    paramw1 = new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.akk.add(paramw1);
    AppMethodBeat.o(49667);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(49677);
    if ((!paramList.isEmpty()) || (super.a(paramw, paramList)))
    {
      AppMethodBeat.o(49677);
      return true;
    }
    AppMethodBeat.o(49677);
    return false;
  }
  
  public final boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49664);
    ac.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", new Object[] { Integer.valueOf(paramw.lv()) });
    e(paramw);
    this.akh.add(paramw);
    AppMethodBeat.o(49664);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49665);
    e(paramw);
    paramw.asD.setAlpha(0.0F);
    paramw.asD.setScaleX(0.75F);
    paramw.asD.setScaleY(0.75F);
    this.aki.add(paramw);
    AppMethodBeat.o(49665);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49671);
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
    AppMethodBeat.o(49671);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49673);
    if ((!this.aki.isEmpty()) || (!this.akk.isEmpty()) || (!this.akj.isEmpty()) || (!this.akh.isEmpty()) || (!this.akp.isEmpty()) || (!this.akq.isEmpty()) || (!this.ako.isEmpty()) || (!this.akr.isEmpty()) || (!this.akm.isEmpty()) || (!this.akl.isEmpty()) || (!this.akn.isEmpty()))
    {
      AppMethodBeat.o(49673);
      return true;
    }
    AppMethodBeat.o(49673);
    return false;
  }
  
  public final void je()
  {
    AppMethodBeat.i(49663);
    int i;
    int j;
    label30:
    int k;
    if (!this.akh.isEmpty())
    {
      i = 1;
      if (this.akj.isEmpty()) {
        break label84;
      }
      j = 1;
      if (this.akk.isEmpty()) {
        break label89;
      }
      k = 1;
      label42:
      if (this.aki.isEmpty()) {
        break label94;
      }
    }
    label84:
    label89:
    label94:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label100;
      }
      AppMethodBeat.o(49663);
      return;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label42;
    }
    label100:
    Object localObject1 = this.akh.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.w)localObject2).asD;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.akq.add(localObject2);
      localViewPropertyAnimator.setDuration(kY()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49653);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          f.this.w(this.akw);
          f.this.akq.remove(this.akw);
          f.this.jf();
          AppMethodBeat.o(49653);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49652);
          f.this.A(this.akw);
          AppMethodBeat.o(49652);
        }
      }).start();
    }
    this.akh.clear();
    label358:
    long l1;
    label433:
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
          AppMethodBeat.i(49649);
          Iterator localIterator = this.aks.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (f.b)localIterator.next();
            f localf = f.this;
            RecyclerView.w localw = ((f.b)localObject).akK;
            int k = ((f.b)localObject).akG;
            int i = ((f.b)localObject).akH;
            int m = ((f.b)localObject).akI;
            int j = ((f.b)localObject).akJ;
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
            localf.akp.add(localw);
            localViewPropertyAnimator.setDuration(localf.arm).setListener(new f.6(localf, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.aks.clear();
          f.this.akm.remove(this.aks);
          AppMethodBeat.o(49649);
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
            AppMethodBeat.i(49650);
            Iterator localIterator = this.aku.iterator();
            if (localIterator.hasNext())
            {
              f.a locala = (f.a)localIterator.next();
              f localf = f.this;
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
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localf.arn);
                  localf.akr.add(locala.akE);
                  localViewPropertyAnimator.translationX(locala.akI - locala.akG);
                  localViewPropertyAnimator.translationY(locala.akJ - locala.akH);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new f.7(localf, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localf.akr.add(locala.akF);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localf.arn).alpha(1.0F).setListener(new f.8(localf, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).asD;
                break label51;
              }
            }
            this.aku.clear();
            f.this.akn.remove(this.aku);
            AppMethodBeat.o(49650);
          }
        };
        if (i == 0) {
          break label501;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).akE.asD, (Runnable)localObject2, kY());
      }
      if (m == 0) {
        break label536;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aki);
      this.akl.add(localObject1);
      this.aki.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49651);
          Iterator localIterator = this.akv.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            f localf = f.this;
            View localView = localw.asD;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localf.ako.add(localw);
            localView.setAlpha(1.0F);
            localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F).setDuration(localf.kX()).setListener(new f.5(localf, localw, localView, localViewPropertyAnimator)).start();
          }
          this.akv.clear();
          f.this.akl.remove(this.akv);
          AppMethodBeat.o(49651);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label529;
      }
      if (i == 0) {
        break label511;
      }
      l1 = kY();
      if (j == 0) {
        break label517;
      }
      l2 = this.arm;
      label443:
      if (k == 0) {
        break label523;
      }
    }
    label517:
    label523:
    for (long l3 = this.arn;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).asD, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(49663);
      return;
      ((Runnable)localObject2).run();
      break;
      label501:
      ((Runnable)localObject2).run();
      break label358;
      label511:
      l1 = 0L;
      break label433;
      l2 = 0L;
      break label443;
    }
    label529:
    ((Runnable)localObject2).run();
    label536:
    AppMethodBeat.o(49663);
  }
  
  final void jf()
  {
    AppMethodBeat.i(49674);
    if (!isRunning()) {
      lc();
    }
    AppMethodBeat.o(49674);
  }
  
  public final void jg()
  {
    AppMethodBeat.i(49675);
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
      AppMethodBeat.o(49675);
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
    AppMethodBeat.o(49675);
  }
  
  static final class a
  {
    public RecyclerView.w akE;
    public RecyclerView.w akF;
    public int akG;
    public int akH;
    public int akI;
    public int akJ;
    public boolean myc = false;
    
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
      AppMethodBeat.i(49661);
      String str = "ChangeInfo{oldHolder=" + this.akE + ", newHolder=" + this.akF + ", fromX=" + this.akG + ", fromY=" + this.akH + ", toX=" + this.akI + ", toY=" + this.akJ + '}';
      AppMethodBeat.o(49661);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */