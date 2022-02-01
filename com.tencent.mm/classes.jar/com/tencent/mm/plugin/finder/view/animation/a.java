package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
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
  private static TimeInterpolator ajm;
  protected ArrayList<RecyclerView.v> ajn;
  protected ArrayList<RecyclerView.v> ajo;
  private ArrayList<b> ajp;
  private ArrayList<a> ajq;
  ArrayList<ArrayList<RecyclerView.v>> ajr;
  ArrayList<ArrayList<b>> ajs;
  ArrayList<ArrayList<a>> ajt;
  ArrayList<RecyclerView.v> aju;
  ArrayList<RecyclerView.v> ajv;
  ArrayList<RecyclerView.v> ajw;
  protected ArrayList<RecyclerView.v> ajx;
  
  public a()
  {
    AppMethodBeat.i(168662);
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
    AppMethodBeat.o(168662);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(168672);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.ajK == null) && (locala.ajL == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(168672);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(168674);
    if (parama.ajL == paramv) {
      parama.ajL = null;
    }
    for (;;)
    {
      paramv.arI.setAlpha(1.0F);
      paramv.arI.setTranslationX(0.0F);
      paramv.arI.setTranslationY(0.0F);
      n(paramv);
      AppMethodBeat.o(168674);
      return true;
      if (parama.ajK != paramv) {
        break;
      }
      parama.ajK = null;
    }
    AppMethodBeat.o(168674);
    return false;
  }
  
  private void b(a parama)
  {
    AppMethodBeat.i(168673);
    if (parama.ajK != null) {
      a(parama, parama.ajK);
    }
    if (parama.ajL != null) {
      a(parama, parama.ajL);
    }
    AppMethodBeat.o(168673);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(168680);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).arI.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(168680);
  }
  
  protected void V(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(168666);
    final View localView = paramv.arI;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.ajw.add(paramv);
    localViewPropertyAnimator.setDuration(kQ()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(168653);
        localViewPropertyAnimator.setListener(null);
        localView.setAlpha(1.0F);
        a.this.w(paramv);
        a.this.ajw.remove(paramv);
        a.this.iX();
        AppMethodBeat.o(168653);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(168652);
        a.this.A(paramv);
        AppMethodBeat.o(168652);
      }
    }).start();
    AppMethodBeat.o(168666);
  }
  
  void W(final RecyclerView.v paramv)
  {
    AppMethodBeat.i(168668);
    final View localView = paramv.arI;
    final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
    this.aju.add(paramv);
    localViewPropertyAnimator.alpha(1.0F).setDuration(kP()).setListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(168654);
        localView.setAlpha(1.0F);
        AppMethodBeat.o(168654);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(168655);
        localViewPropertyAnimator.setListener(null);
        a.this.n(paramv);
        a.this.aju.remove(paramv);
        a.this.iX();
        AppMethodBeat.o(168655);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    AppMethodBeat.o(168668);
  }
  
  protected final void a(final a parama)
  {
    final View localView = null;
    AppMethodBeat.i(168671);
    Object localObject1 = parama.ajK;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((RecyclerView.v)localObject1).arI)
    {
      Object localObject2 = parama.ajL;
      if (localObject2 != null) {
        localView = ((RecyclerView.v)localObject2).arI;
      }
      if (localObject1 != null)
      {
        localObject2 = ((View)localObject1).animate().setDuration(this.aqs);
        this.ajx.add(parama.ajK);
        ((ViewPropertyAnimator)localObject2).translationX(parama.ajO - parama.ajM);
        ((ViewPropertyAnimator)localObject2).translationY(parama.ajP - parama.ajN);
        ((ViewPropertyAnimator)localObject2).alpha(0.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(168659);
            this.ajH.setListener(null);
            this.val$view.setAlpha(1.0F);
            this.val$view.setTranslationX(0.0F);
            this.val$view.setTranslationY(0.0F);
            a.this.n(parama.ajK);
            a.this.ajx.remove(parama.ajK);
            a.this.iX();
            AppMethodBeat.o(168659);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      if (localView != null)
      {
        localObject1 = localView.animate();
        this.ajx.add(parama.ajL);
        ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(this.aqs).alpha(1.0F).setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(168660);
            this.ajI.setListener(null);
            localView.setAlpha(1.0F);
            localView.setTranslationX(0.0F);
            localView.setTranslationY(0.0F);
            a.this.n(parama.ajL);
            a.this.ajx.remove(parama.ajL);
            a.this.iX();
            AppMethodBeat.o(168660);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        }).start();
      }
      AppMethodBeat.o(168671);
      return;
    }
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(168669);
    View localView = paramv.arI;
    paramInt1 += (int)paramv.arI.getTranslationX();
    paramInt2 += (int)paramv.arI.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(168669);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.ajp.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(168669);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(168670);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(168670);
      return bool;
    }
    float f1 = paramv1.arI.getTranslationX();
    float f2 = paramv1.arI.getTranslationY();
    float f3 = paramv1.arI.getAlpha();
    e(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
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
    AppMethodBeat.o(168670);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(168681);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(168681);
      return true;
    }
    AppMethodBeat.o(168681);
    return false;
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168665);
    e(paramv);
    this.ajn.add(paramv);
    AppMethodBeat.o(168665);
    return true;
  }
  
  public boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168667);
    e(paramv);
    paramv.arI.setAlpha(0.0F);
    this.ajo.add(paramv);
    AppMethodBeat.o(168667);
    return true;
  }
  
  protected long csU()
  {
    AppMethodBeat.i(168663);
    long l = kQ();
    AppMethodBeat.o(168663);
    return l;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168675);
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
    AppMethodBeat.o(168675);
  }
  
  protected final void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(168676);
    if (ajm == null) {
      ajm = new ValueAnimator().getInterpolator();
    }
    paramv.arI.animate().setInterpolator(ajm);
    d(paramv);
    AppMethodBeat.o(168676);
  }
  
  public final void iW()
  {
    AppMethodBeat.i(168664);
    int i;
    int j;
    label30:
    int k;
    if (!this.ajn.isEmpty())
    {
      i = 1;
      if (this.ajp.isEmpty()) {
        break label84;
      }
      j = 1;
      if (this.ajq.isEmpty()) {
        break label89;
      }
      k = 1;
      label42:
      if (this.ajo.isEmpty()) {
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
    Object localObject1 = this.ajn.iterator();
    while (((Iterator)localObject1).hasNext()) {
      V((RecyclerView.v)((Iterator)localObject1).next());
    }
    this.ajn.clear();
    Object localObject2;
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
          AppMethodBeat.i(168649);
          Iterator localIterator = this.ajy.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (a.b)localIterator.next();
            a locala = a.this;
            RecyclerView.v localv = ((a.b)localObject).ajQ;
            int k = ((a.b)localObject).ajM;
            int i = ((a.b)localObject).ajN;
            int m = ((a.b)localObject).ajO;
            int j = ((a.b)localObject).ajP;
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
            locala.ajv.add(localv);
            localViewPropertyAnimator.setDuration(locala.aqr).setListener(new a.6(locala, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.ajy.clear();
          a.this.ajs.remove(this.ajy);
          AppMethodBeat.o(168649);
        }
      };
      if (i != 0) {
        t.a(((b)((ArrayList)localObject1).get(0)).ajQ.arI, (Runnable)localObject2, kQ());
      }
    }
    else if (k != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ajq);
      this.ajt.add(localObject1);
      this.ajq.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168650);
          Iterator localIterator = this.ajA.iterator();
          while (localIterator.hasNext())
          {
            a.a locala = (a.a)localIterator.next();
            a.this.a(locala);
          }
          this.ajA.clear();
          a.this.ajt.remove(this.ajA);
          AppMethodBeat.o(168650);
        }
      };
      if (i == 0) {
        break label406;
      }
      t.a(((a)((ArrayList)localObject1).get(0)).ajK.arI, (Runnable)localObject2, kQ());
    }
    for (;;)
    {
      if (m != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ajo);
        this.ajr.add(localObject1);
        this.ajo.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(168651);
            Iterator localIterator = this.ajB.iterator();
            while (localIterator.hasNext())
            {
              RecyclerView.v localv = (RecyclerView.v)localIterator.next();
              a.this.W(localv);
            }
            this.ajB.clear();
            a.this.ajr.remove(this.ajB);
            AppMethodBeat.o(168651);
          }
        };
        if ((i != 0) || (j != 0) || (k != 0))
        {
          t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).arI, (Runnable)localObject2, csU());
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
  
  final void iX()
  {
    AppMethodBeat.i(168678);
    if (!isRunning()) {
      kU();
    }
    AppMethodBeat.o(168678);
  }
  
  public final void iY()
  {
    AppMethodBeat.i(168679);
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
      b((a)this.ajq.get(i));
      i -= 1;
    }
    this.ajq.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(168679);
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
        b((a)((ArrayList)localObject1).get(j));
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
    AppMethodBeat.o(168679);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(168677);
    if ((!this.ajo.isEmpty()) || (!this.ajq.isEmpty()) || (!this.ajp.isEmpty()) || (!this.ajn.isEmpty()) || (!this.ajv.isEmpty()) || (!this.ajw.isEmpty()) || (!this.aju.isEmpty()) || (!this.ajx.isEmpty()) || (!this.ajs.isEmpty()) || (!this.ajr.isEmpty()) || (!this.ajt.isEmpty()))
    {
      AppMethodBeat.o(168677);
      return true;
    }
    AppMethodBeat.o(168677);
    return false;
  }
  
  protected static final class a
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
      AppMethodBeat.i(168661);
      String str = "ChangeInfo{oldHolder=" + this.ajK + ", newHolder=" + this.ajL + ", fromX=" + this.ajM + ", fromY=" + this.ajN + ", toX=" + this.ajO + ", toY=" + this.ajP + '}';
      AppMethodBeat.o(168661);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.a
 * JD-Core Version:    0.7.0.1
 */