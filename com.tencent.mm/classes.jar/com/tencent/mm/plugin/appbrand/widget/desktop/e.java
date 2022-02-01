package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.f;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
  extends as
{
  private static TimeInterpolator amk;
  RecyclerView.a adj;
  private ArrayList<RecyclerView.v> aml;
  private ArrayList<RecyclerView.v> amm;
  private ArrayList<b> amn;
  private ArrayList<a> amo;
  ArrayList<ArrayList<RecyclerView.v>> amp;
  ArrayList<ArrayList<b>> amq;
  ArrayList<ArrayList<a>> amr;
  ArrayList<RecyclerView.v> ams;
  ArrayList<RecyclerView.v> amt;
  ArrayList<RecyclerView.v> amu;
  ArrayList<RecyclerView.v> amv;
  private boolean opc;
  
  e()
  {
    AppMethodBeat.i(49662);
    this.opc = false;
    this.adj = null;
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
    this.atn = 200L;
    this.atq = 200L;
    this.atp = 200L;
    this.ato = 200L;
    AppMethodBeat.o(49662);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49669);
    if (parama.amI != null) {
      a(parama, parama.amI);
    }
    if (parama.amJ != null) {
      a(parama, parama.amJ);
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
      if ((a(locala, paramv)) && (locala.amI == null) && (locala.amJ == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49668);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(49670);
    if (parama.amJ == paramv) {
      parama.amJ = null;
    }
    for (;;)
    {
      paramv.aus.setAlpha(1.0F);
      paramv.aus.setTranslationX(0.0F);
      paramv.aus.setTranslationY(0.0F);
      n(paramv);
      AppMethodBeat.o(49670);
      return true;
      if (parama.amI != paramv) {
        break;
      }
      parama.amI = null;
    }
    AppMethodBeat.o(49670);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49672);
    if (amk == null) {
      amk = new ValueAnimator().getInterpolator();
    }
    paramv.aus.animate().setInterpolator(amk);
    d(paramv);
    AppMethodBeat.o(49672);
  }
  
  private static void n(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(49676);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aus.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49676);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49666);
    View localView = paramv.aus;
    paramInt1 += (int)paramv.aus.getTranslationX();
    paramInt2 += (int)paramv.aus.getTranslationY();
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
    this.amn.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49666);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49667);
    Log.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", new Object[] { Integer.valueOf(paramv1.lR()) });
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49667);
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
    paramv1 = new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.amo.add(paramv1);
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
    Log.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", new Object[] { Integer.valueOf(paramv.lR()) });
    e(paramv);
    this.aml.add(paramv);
    AppMethodBeat.o(49664);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49665);
    e(paramv);
    paramv.aus.setAlpha(0.0F);
    paramv.aus.setScaleX(0.75F);
    paramv.aus.setScaleY(0.75F);
    this.amm.add(paramv);
    AppMethodBeat.o(49665);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49671);
    View localView = paramv.aus;
    localView.animate().cancel();
    int i = this.amn.size() - 1;
    while (i >= 0)
    {
      if (((b)this.amn.get(i)).amO == paramv)
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
          if (((b)localArrayList.get(j)).amO != paramv) {
            break label299;
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
        label299:
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
    AppMethodBeat.o(49671);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49673);
    if ((!this.amm.isEmpty()) || (!this.amo.isEmpty()) || (!this.amn.isEmpty()) || (!this.aml.isEmpty()) || (!this.amt.isEmpty()) || (!this.amu.isEmpty()) || (!this.ams.isEmpty()) || (!this.amv.isEmpty()) || (!this.amq.isEmpty()) || (!this.amp.isEmpty()) || (!this.amr.isEmpty()))
    {
      AppMethodBeat.o(49673);
      return true;
    }
    AppMethodBeat.o(49673);
    return false;
  }
  
  public final void jD()
  {
    AppMethodBeat.i(49663);
    int i;
    int j;
    label30:
    int k;
    if (!this.aml.isEmpty())
    {
      i = 1;
      if (this.amn.isEmpty()) {
        break label84;
      }
      j = 1;
      if (this.amo.isEmpty()) {
        break label89;
      }
      k = 1;
      label42:
      if (this.amm.isEmpty()) {
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
    Object localObject1 = this.aml.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.v)localObject2).aus;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.amu.add(localObject2);
      localViewPropertyAnimator.setDuration(ly()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49653);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          e.this.w(this.amA);
          e.this.amu.remove(this.amA);
          e.this.jE();
          AppMethodBeat.o(49653);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49652);
          e.this.C(this.amA);
          AppMethodBeat.o(49652);
        }
      }).start();
    }
    this.aml.clear();
    label358:
    long l1;
    label433:
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
          AppMethodBeat.i(49649);
          Iterator localIterator = this.amw.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (e.b)localIterator.next();
            e locale = e.this;
            RecyclerView.v localv = ((e.b)localObject).amO;
            int k = ((e.b)localObject).amK;
            int i = ((e.b)localObject).amL;
            int m = ((e.b)localObject).amM;
            int j = ((e.b)localObject).amN;
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
            locale.amt.add(localv);
            localViewPropertyAnimator.setDuration(locale.atp).setListener(new e.6(locale, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amw.clear();
          e.this.amq.remove(this.amw);
          AppMethodBeat.o(49649);
        }
      };
      if (i != 0) {
        u.a(((b)((ArrayList)localObject1).get(0)).amO.aus, (Runnable)localObject2, ly());
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
            AppMethodBeat.i(49650);
            Iterator localIterator = this.amy.iterator();
            if (localIterator.hasNext())
            {
              e.a locala = (e.a)localIterator.next();
              e locale = e.this;
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
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locale.atq);
                  locale.amv.add(locala.amI);
                  localViewPropertyAnimator.translationX(locala.amM - locala.amK);
                  localViewPropertyAnimator.translationY(locala.amN - locala.amL);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new e.7(locale, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locale.amv.add(locala.amJ);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locale.atq).alpha(1.0F).setListener(new e.8(locale, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).aus;
                break label51;
              }
            }
            this.amy.clear();
            e.this.amr.remove(this.amy);
            AppMethodBeat.o(49650);
          }
        };
        if (i == 0) {
          break label501;
        }
        u.a(((a)((ArrayList)localObject1).get(0)).amI.aus, (Runnable)localObject2, ly());
      }
      if (m == 0) {
        break label536;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.amm);
      this.amp.add(localObject1);
      this.amm.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49651);
          Iterator localIterator = this.amz.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            e locale = e.this;
            View localView = localv.aus;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locale.ams.add(localv);
            localView.setAlpha(1.0F);
            localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F).setDuration(locale.lx()).setListener(new e.5(locale, localv, localView, localViewPropertyAnimator)).start();
          }
          this.amz.clear();
          e.this.amp.remove(this.amz);
          AppMethodBeat.o(49651);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label529;
      }
      if (i == 0) {
        break label511;
      }
      l1 = ly();
      if (j == 0) {
        break label517;
      }
      l2 = this.atp;
      label443:
      if (k == 0) {
        break label523;
      }
    }
    label517:
    label523:
    for (long l3 = this.atq;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      u.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aus, (Runnable)localObject2, l1 + l2);
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
  
  final void jE()
  {
    AppMethodBeat.i(49674);
    if (!isRunning()) {
      lC();
    }
    AppMethodBeat.o(49674);
  }
  
  public final void jF()
  {
    AppMethodBeat.i(49675);
    int i = this.amn.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.amn.get(i);
      localObject2 = ((b)localObject1).amO.aus;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((b)localObject1).amO);
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
      AppMethodBeat.o(49675);
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
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).amO.aus;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((b)localObject2).amO);
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
    AppMethodBeat.o(49675);
  }
  
  static final class a
  {
    public RecyclerView.v amI;
    public RecyclerView.v amJ;
    public int amK;
    public int amL;
    public int amM;
    public int amN;
    public boolean opf = false;
    
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
      AppMethodBeat.i(49661);
      String str = "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
      AppMethodBeat.o(49661);
      return str;
    }
  }
  
  static final class b
  {
    public int amK;
    public int amL;
    public int amM;
    public int amN;
    public RecyclerView.v amO;
    
    b(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */