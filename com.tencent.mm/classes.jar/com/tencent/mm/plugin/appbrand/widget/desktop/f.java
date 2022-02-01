package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends as
{
  private static TimeInterpolator ajm;
  RecyclerView.a aaj;
  private ArrayList<RecyclerView.v> ajn;
  private ArrayList<RecyclerView.v> ajo;
  private ArrayList<b> ajp;
  private ArrayList<a> ajq;
  ArrayList<ArrayList<RecyclerView.v>> ajr;
  ArrayList<ArrayList<b>> ajs;
  ArrayList<ArrayList<a>> ajt;
  ArrayList<RecyclerView.v> aju;
  ArrayList<RecyclerView.v> ajv;
  ArrayList<RecyclerView.v> ajw;
  ArrayList<RecyclerView.v> ajx;
  private boolean lVX;
  
  f()
  {
    AppMethodBeat.i(49662);
    this.lVX = false;
    this.aaj = null;
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
    this.aqp = 200L;
    this.aqs = 200L;
    this.aqr = 200L;
    this.aqq = 200L;
    AppMethodBeat.o(49662);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49669);
    if (parama.ajK != null) {
      a(parama, parama.ajK);
    }
    if (parama.ajL != null) {
      a(parama, parama.ajL);
    }
    AppMethodBeat.o(49669);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(49668);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.ajK == null) && (locala.ajL == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49668);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(49670);
    if (parama.ajL == paramv) {
      parama.ajL = null;
    }
    for (;;)
    {
      paramv.arI.setAlpha(1.0F);
      paramv.arI.setTranslationX(0.0F);
      paramv.arI.setTranslationY(0.0F);
      n(paramv);
      AppMethodBeat.o(49670);
      return true;
      if (parama.ajK != paramv) {
        break;
      }
      parama.ajK = null;
    }
    AppMethodBeat.o(49670);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49672);
    if (ajm == null) {
      ajm = new ValueAnimator().getInterpolator();
    }
    paramv.arI.animate().setInterpolator(ajm);
    d(paramv);
    AppMethodBeat.o(49672);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(49676);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).arI.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49676);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49666);
    View localView = paramv.arI;
    paramInt1 += (int)paramv.arI.getTranslationX();
    paramInt2 += (int)paramv.arI.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      AppMethodBeat.o(49666);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.ajp.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49666);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49667);
    ad.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", new Object[] { Integer.valueOf(paramv1.ln()) });
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49667);
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
    paramv1 = new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.ajq.add(paramv1);
    AppMethodBeat.o(49667);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(49677);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(49677);
      return true;
    }
    AppMethodBeat.o(49677);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49664);
    ad.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", new Object[] { Integer.valueOf(paramv.ln()) });
    e(paramv);
    this.ajn.add(paramv);
    AppMethodBeat.o(49664);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49665);
    e(paramv);
    paramv.arI.setAlpha(0.0F);
    paramv.arI.setScaleX(0.75F);
    paramv.arI.setScaleY(0.75F);
    this.ajo.add(paramv);
    AppMethodBeat.o(49665);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49671);
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
    AppMethodBeat.o(49671);
  }
  
  public final void iW()
  {
    AppMethodBeat.i(49663);
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
    Object localObject1 = this.ajn.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.v)localObject2).arI;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.ajw.add(localObject2);
      localViewPropertyAnimator.setDuration(kQ()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49653);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          f.this.w(this.ajC);
          f.this.ajw.remove(this.ajC);
          f.this.iX();
          AppMethodBeat.o(49653);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49652);
          f.this.A(this.ajC);
          AppMethodBeat.o(49652);
        }
      }).start();
    }
    this.ajn.clear();
    label358:
    long l1;
    label433:
    long l2;
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
          AppMethodBeat.i(49649);
          Iterator localIterator = this.ajy.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (f.b)localIterator.next();
            f localf = f.this;
            RecyclerView.v localv = ((f.b)localObject).ajQ;
            int k = ((f.b)localObject).ajM;
            int i = ((f.b)localObject).ajN;
            int m = ((f.b)localObject).ajO;
            int j = ((f.b)localObject).ajP;
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
            localf.ajv.add(localv);
            localViewPropertyAnimator.setDuration(localf.aqr).setListener(new f.6(localf, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.ajy.clear();
          f.this.ajs.remove(this.ajy);
          AppMethodBeat.o(49649);
        }
      };
      if (i != 0) {
        t.a(((b)((ArrayList)localObject1).get(0)).ajQ.arI, (Runnable)localObject2, kQ());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.ajq);
        this.ajt.add(localObject1);
        this.ajq.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(49650);
            Iterator localIterator = this.ajA.iterator();
            if (localIterator.hasNext())
            {
              f.a locala = (f.a)localIterator.next();
              f localf = f.this;
              Object localObject1 = locala.ajK;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.ajL;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).arI;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localf.aqs);
                  localf.ajx.add(locala.ajK);
                  localViewPropertyAnimator.translationX(locala.ajO - locala.ajM);
                  localViewPropertyAnimator.translationY(locala.ajP - locala.ajN);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new f.7(localf, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localf.ajx.add(locala.ajL);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localf.aqs).alpha(1.0F).setListener(new f.8(localf, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).arI;
                break label51;
              }
            }
            this.ajA.clear();
            f.this.ajt.remove(this.ajA);
            AppMethodBeat.o(49650);
          }
        };
        if (i == 0) {
          break label501;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).ajK.arI, (Runnable)localObject2, kQ());
      }
      if (m == 0) {
        break label536;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ajo);
      this.ajr.add(localObject1);
      this.ajo.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49651);
          Iterator localIterator = this.ajB.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            f localf = f.this;
            View localView = localv.arI;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localf.aju.add(localv);
            localView.setAlpha(1.0F);
            localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F).setDuration(localf.kP()).setListener(new f.5(localf, localv, localView, localViewPropertyAnimator)).start();
          }
          this.ajB.clear();
          f.this.ajr.remove(this.ajB);
          AppMethodBeat.o(49651);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label529;
      }
      if (i == 0) {
        break label511;
      }
      l1 = kQ();
      if (j == 0) {
        break label517;
      }
      l2 = this.aqr;
      label443:
      if (k == 0) {
        break label523;
      }
    }
    label517:
    label523:
    for (long l3 = this.aqs;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).arI, (Runnable)localObject2, l1 + l2);
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
  
  final void iX()
  {
    AppMethodBeat.i(49674);
    if (!isRunning()) {
      kU();
    }
    AppMethodBeat.o(49674);
  }
  
  public final void iY()
  {
    AppMethodBeat.i(49675);
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
      a((a)this.ajq.get(i));
      i -= 1;
    }
    this.ajq.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(49675);
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
        a((a)((ArrayList)localObject1).get(j));
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
    AppMethodBeat.o(49675);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49673);
    if ((!this.ajo.isEmpty()) || (!this.ajq.isEmpty()) || (!this.ajp.isEmpty()) || (!this.ajn.isEmpty()) || (!this.ajv.isEmpty()) || (!this.ajw.isEmpty()) || (!this.aju.isEmpty()) || (!this.ajx.isEmpty()) || (!this.ajs.isEmpty()) || (!this.ajr.isEmpty()) || (!this.ajt.isEmpty()))
    {
      AppMethodBeat.o(49673);
      return true;
    }
    AppMethodBeat.o(49673);
    return false;
  }
  
  static final class a
  {
    public RecyclerView.v ajK;
    public RecyclerView.v ajL;
    public int ajM;
    public int ajN;
    public int ajO;
    public int ajP;
    public boolean lWa = false;
    
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
      AppMethodBeat.i(49661);
      String str = "ChangeInfo{oldHolder=" + this.ajK + ", newHolder=" + this.ajL + ", fromX=" + this.ajM + ", fromY=" + this.ajN + ", toX=" + this.ajO + ", toY=" + this.ajP + '}';
      AppMethodBeat.o(49661);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */