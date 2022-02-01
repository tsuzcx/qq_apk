package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  extends as
{
  private static TimeInterpolator akg;
  protected ArrayList<RecyclerView.w> akh;
  protected ArrayList<RecyclerView.w> aki;
  private ArrayList<b> akj;
  private ArrayList<a.a> akk;
  ArrayList<ArrayList<RecyclerView.w>> akl;
  ArrayList<ArrayList<b>> akm;
  ArrayList<ArrayList<a.a>> akn;
  ArrayList<RecyclerView.w> ako;
  ArrayList<RecyclerView.w> akp;
  ArrayList<RecyclerView.w> akq;
  protected ArrayList<RecyclerView.w> akr;
  
  public a()
  {
    AppMethodBeat.i(168662);
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
    AppMethodBeat.o(168662);
  }
  
  private void a(List<a.a> paramList, RecyclerView.w paramw)
  {
    AppMethodBeat.i(168672);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a.a locala = (a.a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.akE == null) && (locala.akF == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(168672);
  }
  
  private boolean a(a.a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(168674);
    if (parama.akF == paramw) {
      parama.akF = null;
    }
    for (;;)
    {
      paramw.asD.setAlpha(1.0F);
      paramw.asD.setTranslationX(0.0F);
      paramw.asD.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(168674);
      return true;
      if (parama.akE != paramw) {
        break;
      }
      parama.akE = null;
    }
    AppMethodBeat.o(168674);
    return false;
  }
  
  private void b(a.a parama)
  {
    AppMethodBeat.i(168673);
    if (parama.akE != null) {
      a(parama, parama.akE);
    }
    if (parama.akF != null) {
      a(parama, parama.akF);
    }
    AppMethodBeat.o(168673);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(168680);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).asD.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(168680);
  }
  
  protected void V(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168666);
    View localView = paramw.asD;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.akq.add(paramw);
    localViewPropertyAnimator.setDuration(kY()).alpha(0.0F).setListener(new a.4(this, paramw, localViewPropertyAnimator, localView)).start();
    AppMethodBeat.o(168666);
  }
  
  void W(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168668);
    View localView = paramw.asD;
    ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.ako.add(paramw);
    localViewPropertyAnimator.alpha(1.0F).setDuration(kX()).setListener(new a.5(this, paramw, localView, localViewPropertyAnimator)).start();
    AppMethodBeat.o(168668);
  }
  
  protected final void a(final a.a parama)
  {
    final View localView = null;
    AppMethodBeat.i(168671);
    Object localObject1 = parama.akE;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((RecyclerView.w)localObject1).asD)
    {
      Object localObject2 = parama.akF;
      if (localObject2 != null) {
        localView = ((RecyclerView.w)localObject2).asD;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(this.arn);
        this.akr.add(parama.akE);
        ((ViewPropertyAnimator)localObject2).translationX(parama.akI - parama.akG);
        ((ViewPropertyAnimator)localObject2).translationY(parama.akJ - parama.akH);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(168659);
            this.akB.setListener(null);
            this.val$view.setAlpha(1.0F);
            this.val$view.setTranslationX(0.0F);
            this.val$view.setTranslationY(0.0F);
            a.this.n(parama.akE);
            a.this.akr.remove(parama.akE);
            a.this.jf();
            AppMethodBeat.o(168659);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.akr.add(parama.akF);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(this.arn).alpha(1.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(168660);
            this.akC.setListener(null);
            localView.setAlpha(1.0F);
            localView.setTranslationX(0.0F);
            localView.setTranslationY(0.0F);
            a.this.n(parama.akF);
            a.this.akr.remove(parama.akF);
            a.this.jf();
            AppMethodBeat.o(168660);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      AppMethodBeat.o(168671);
      return;
    }
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(168669);
    View localView = paramw.asD;
    paramInt1 += (int)paramw.asD.getTranslationX();
    paramInt2 += (int)paramw.asD.getTranslationY();
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      AppMethodBeat.o(168669);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.akj.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(168669);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(168670);
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(168670);
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
    this.akk.add(new a.a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(168670);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    AppMethodBeat.i(168681);
    if ((!paramList.isEmpty()) || (super.a(paramw, paramList)))
    {
      AppMethodBeat.o(168681);
      return true;
    }
    AppMethodBeat.o(168681);
    return false;
  }
  
  public boolean b(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168665);
    e(paramw);
    this.akh.add(paramw);
    AppMethodBeat.o(168665);
    return true;
  }
  
  public boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168667);
    e(paramw);
    paramw.asD.setAlpha(0.0F);
    this.aki.add(paramw);
    AppMethodBeat.o(168667);
    return true;
  }
  
  protected long cFl()
  {
    AppMethodBeat.i(168663);
    long l = kY();
    AppMethodBeat.o(168663);
    return l;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168675);
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
    AppMethodBeat.o(168675);
  }
  
  protected final void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(168676);
    if (akg == null) {
      akg = new ValueAnimator().getInterpolator();
    }
    paramw.asD.animate().setInterpolator(akg);
    d(paramw);
    AppMethodBeat.o(168676);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(168677);
    if ((!this.aki.isEmpty()) || (!this.akk.isEmpty()) || (!this.akj.isEmpty()) || (!this.akh.isEmpty()) || (!this.akp.isEmpty()) || (!this.akq.isEmpty()) || (!this.ako.isEmpty()) || (!this.akr.isEmpty()) || (!this.akm.isEmpty()) || (!this.akl.isEmpty()) || (!this.akn.isEmpty()))
    {
      AppMethodBeat.o(168677);
      return true;
    }
    AppMethodBeat.o(168677);
    return false;
  }
  
  public final void je()
  {
    AppMethodBeat.i(168664);
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
      AppMethodBeat.o(168664);
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
    while (((Iterator)localObject1).hasNext()) {
      V((RecyclerView.w)((Iterator)localObject1).next());
    }
    this.akh.clear();
    Object localObject2;
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
          AppMethodBeat.i(168649);
          Iterator localIterator = this.aks.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (a.b)localIterator.next();
            a locala = a.this;
            RecyclerView.w localw = ((a.b)localObject).akK;
            int k = ((a.b)localObject).akG;
            int i = ((a.b)localObject).akH;
            int m = ((a.b)localObject).akI;
            int j = ((a.b)localObject).akJ;
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
            locala.akp.add(localw);
            localViewPropertyAnimator.setDuration(locala.arm).setListener(new a.6(locala, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.aks.clear();
          a.this.akm.remove(this.aks);
          AppMethodBeat.o(168649);
        }
      };
      if (i != 0) {
        t.a(((b)((ArrayList)localObject1).get(0)).akK.asD, (Runnable)localObject2, kY());
      }
    }
    else if (k != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.akk);
      this.akn.add(localObject1);
      this.akk.clear();
      localObject2 = new a.2(this, (ArrayList)localObject1);
      if (i == 0) {
        break label406;
      }
      t.a(((a.a)((ArrayList)localObject1).get(0)).akE.asD, (Runnable)localObject2, kY());
    }
    for (;;)
    {
      if (m != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.aki);
        this.akl.add(localObject1);
        this.aki.clear();
        localObject2 = new a.3(this, (ArrayList)localObject1);
        if ((i != 0) || (j != 0) || (k != 0))
        {
          t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).asD, (Runnable)localObject2, cFl());
          AppMethodBeat.o(168664);
          return;
          ((Runnable)localObject2).run();
          break;
          label406:
          ((Runnable)localObject2).run();
          continue;
        }
        ((Runnable)localObject2).run();
      }
    }
    AppMethodBeat.o(168664);
  }
  
  final void jf()
  {
    AppMethodBeat.i(168678);
    if (!isRunning()) {
      lc();
    }
    AppMethodBeat.o(168678);
  }
  
  public final void jg()
  {
    AppMethodBeat.i(168679);
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
      b((a.a)this.akk.get(i));
      i -= 1;
    }
    this.akk.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(168679);
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
        b((a.a)((ArrayList)localObject1).get(j));
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
    AppMethodBeat.o(168679);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a
 * JD-Core Version:    0.7.0.1
 */