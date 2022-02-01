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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g
  extends as
{
  private static TimeInterpolator alX;
  RecyclerView.a acW;
  private ArrayList<RecyclerView.w> alY;
  private ArrayList<RecyclerView.w> alZ;
  private ArrayList<b> ama;
  private ArrayList<a> amb;
  ArrayList<ArrayList<RecyclerView.w>> amc;
  ArrayList<ArrayList<b>> amd;
  ArrayList<ArrayList<a>> ame;
  ArrayList<RecyclerView.w> amf;
  ArrayList<RecyclerView.w> amg;
  ArrayList<RecyclerView.w> amh;
  ArrayList<RecyclerView.w> ami;
  private boolean ndO;
  
  g()
  {
    AppMethodBeat.i(49662);
    this.ndO = false;
    this.acW = null;
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
    this.atc = 200L;
    this.atf = 200L;
    this.ate = 200L;
    this.atd = 200L;
    AppMethodBeat.o(49662);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(49669);
    if (parama.amv != null) {
      a(parama, parama.amv);
    }
    if (parama.amw != null) {
      a(parama, parama.amw);
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
      if ((a(locala, paramw)) && (locala.amv == null) && (locala.amw == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(49668);
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    AppMethodBeat.i(49670);
    if (parama.amw == paramw) {
      parama.amw = null;
    }
    for (;;)
    {
      paramw.auu.setAlpha(1.0F);
      paramw.auu.setTranslationX(0.0F);
      paramw.auu.setTranslationY(0.0F);
      n(paramw);
      AppMethodBeat.o(49670);
      return true;
      if (parama.amv != paramw) {
        break;
      }
      parama.amv = null;
    }
    AppMethodBeat.o(49670);
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49672);
    if (alX == null) {
      alX = new ValueAnimator().getInterpolator();
    }
    paramw.auu.animate().setInterpolator(alX);
    d(paramw);
    AppMethodBeat.o(49672);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    AppMethodBeat.i(49676);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).auu.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(49676);
  }
  
  public final boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49666);
    View localView = paramw.auu;
    paramInt1 += (int)paramw.auu.getTranslationX();
    paramInt2 += (int)paramw.auu.getTranslationY();
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
    this.ama.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(49666);
    return true;
  }
  
  public final boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49667);
    ae.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", new Object[] { Integer.valueOf(paramw1.lN()) });
    if (paramw1 == paramw2)
    {
      boolean bool = a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49667);
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
    paramw1 = new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.amb.add(paramw1);
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
    ae.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", new Object[] { Integer.valueOf(paramw.lN()) });
    e(paramw);
    this.alY.add(paramw);
    AppMethodBeat.o(49664);
    return true;
  }
  
  public final boolean c(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49665);
    e(paramw);
    paramw.auu.setAlpha(0.0F);
    paramw.auu.setScaleX(0.75F);
    paramw.auu.setScaleY(0.75F);
    this.alZ.add(paramw);
    AppMethodBeat.o(49665);
    return true;
  }
  
  public final void d(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49671);
    View localView = paramw.auu;
    localView.animate().cancel();
    int i = this.ama.size() - 1;
    while (i >= 0)
    {
      if (((b)this.ama.get(i)).amB == paramw)
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
          if (((b)localArrayList.get(j)).amB != paramw) {
            break label299;
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
        label299:
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
    AppMethodBeat.o(49671);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(49673);
    if ((!this.alZ.isEmpty()) || (!this.amb.isEmpty()) || (!this.ama.isEmpty()) || (!this.alY.isEmpty()) || (!this.amg.isEmpty()) || (!this.amh.isEmpty()) || (!this.amf.isEmpty()) || (!this.ami.isEmpty()) || (!this.amd.isEmpty()) || (!this.amc.isEmpty()) || (!this.ame.isEmpty()))
    {
      AppMethodBeat.o(49673);
      return true;
    }
    AppMethodBeat.o(49673);
    return false;
  }
  
  public final void ju()
  {
    AppMethodBeat.i(49663);
    int i;
    int j;
    label30:
    int k;
    if (!this.alY.isEmpty())
    {
      i = 1;
      if (this.ama.isEmpty()) {
        break label84;
      }
      j = 1;
      if (this.amb.isEmpty()) {
        break label89;
      }
      k = 1;
      label42:
      if (this.alZ.isEmpty()) {
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
    Object localObject1 = this.alY.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.w)((Iterator)localObject1).next();
      final View localView = ((RecyclerView.w)localObject2).auu;
      final ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.amh.add(localObject2);
      localViewPropertyAnimator.setDuration(lq()).alpha(0.0F).setListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49653);
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          g.this.w(this.amn);
          g.this.amh.remove(this.amn);
          g.this.jv();
          AppMethodBeat.o(49653);
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49652);
          g.this.A(this.amn);
          AppMethodBeat.o(49652);
        }
      }).start();
    }
    this.alY.clear();
    label358:
    long l1;
    label433:
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
          AppMethodBeat.i(49649);
          Iterator localIterator = this.amj.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (g.b)localIterator.next();
            g localg = g.this;
            RecyclerView.w localw = ((g.b)localObject).amB;
            int k = ((g.b)localObject).amx;
            int i = ((g.b)localObject).amy;
            int m = ((g.b)localObject).amz;
            int j = ((g.b)localObject).amA;
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
            localg.amg.add(localw);
            localViewPropertyAnimator.setDuration(localg.ate).setListener(new g.6(localg, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amj.clear();
          g.this.amd.remove(this.amj);
          AppMethodBeat.o(49649);
        }
      };
      if (i != 0) {
        t.a(((b)((ArrayList)localObject1).get(0)).amB.auu, (Runnable)localObject2, lq());
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
            AppMethodBeat.i(49650);
            Iterator localIterator = this.aml.iterator();
            if (localIterator.hasNext())
            {
              g.a locala = (g.a)localIterator.next();
              g localg = g.this;
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
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localg.atf);
                  localg.ami.add(locala.amv);
                  localViewPropertyAnimator.translationX(locala.amz - locala.amx);
                  localViewPropertyAnimator.translationY(locala.amA - locala.amy);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new g.7(localg, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localg.ami.add(locala.amw);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localg.atf).alpha(1.0F).setListener(new g.8(localg, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).auu;
                break label51;
              }
            }
            this.aml.clear();
            g.this.ame.remove(this.aml);
            AppMethodBeat.o(49650);
          }
        };
        if (i == 0) {
          break label501;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).amv.auu, (Runnable)localObject2, lq());
      }
      if (m == 0) {
        break label536;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.alZ);
      this.amc.add(localObject1);
      this.alZ.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(49651);
          Iterator localIterator = this.amm.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            g localg = g.this;
            View localView = localw.auu;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localg.amf.add(localw);
            localView.setAlpha(1.0F);
            localViewPropertyAnimator.scaleX(1.0F).scaleY(1.0F).setDuration(localg.lp()).setListener(new g.5(localg, localw, localView, localViewPropertyAnimator)).start();
          }
          this.amm.clear();
          g.this.amc.remove(this.amm);
          AppMethodBeat.o(49651);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label529;
      }
      if (i == 0) {
        break label511;
      }
      l1 = lq();
      if (j == 0) {
        break label517;
      }
      l2 = this.ate;
      label443:
      if (k == 0) {
        break label523;
      }
    }
    label517:
    label523:
    for (long l3 = this.atf;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).auu, (Runnable)localObject2, l1 + l2);
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
  
  final void jv()
  {
    AppMethodBeat.i(49674);
    if (!isRunning()) {
      lu();
    }
    AppMethodBeat.o(49674);
  }
  
  public final void jw()
  {
    AppMethodBeat.i(49675);
    int i = this.ama.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (b)this.ama.get(i);
      localObject2 = ((b)localObject1).amB.auu;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((b)localObject1).amB);
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
      AppMethodBeat.o(49675);
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
        localObject2 = (b)((ArrayList)localObject1).get(j);
        View localView = ((b)localObject2).amB.auu;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((b)localObject2).amB);
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
    AppMethodBeat.o(49675);
  }
  
  static final class a
  {
    public int amA;
    public RecyclerView.w amv;
    public RecyclerView.w amw;
    public int amx;
    public int amy;
    public int amz;
    public boolean ndR = false;
    
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
      AppMethodBeat.i(49661);
      String str = "ChangeInfo{oldHolder=" + this.amv + ", newHolder=" + this.amw + ", fromX=" + this.amx + ", fromY=" + this.amy + ", toX=" + this.amz + ", toY=" + this.amA + '}';
      AppMethodBeat.o(49661);
      return str;
    }
  }
  
  static final class b
  {
    public int amA;
    public RecyclerView.w amB;
    public int amx;
    public int amy;
    public int amz;
    
    b(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.g
 * JD-Core Version:    0.7.0.1
 */