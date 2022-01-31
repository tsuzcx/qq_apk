package com.tencent.mm.plugin.appbrand.widget.desktop;

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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends as
{
  private static TimeInterpolator acf;
  RecyclerView.a Tg;
  private ArrayList<RecyclerView.v> acg;
  private ArrayList<RecyclerView.v> ach;
  private ArrayList<f.b> aci;
  private ArrayList<f.a> acj;
  ArrayList<ArrayList<RecyclerView.v>> ack;
  ArrayList<ArrayList<f.b>> acl;
  ArrayList<ArrayList<f.a>> acm;
  ArrayList<RecyclerView.v> acn;
  ArrayList<RecyclerView.v> aco;
  ArrayList<RecyclerView.v> acp;
  ArrayList<RecyclerView.v> acq;
  private boolean jfR;
  
  f()
  {
    AppMethodBeat.i(133915);
    this.jfR = false;
    this.Tg = null;
    this.acg = new ArrayList();
    this.ach = new ArrayList();
    this.aci = new ArrayList();
    this.acj = new ArrayList();
    this.ack = new ArrayList();
    this.acl = new ArrayList();
    this.acm = new ArrayList();
    this.acn = new ArrayList();
    this.aco = new ArrayList();
    this.acp = new ArrayList();
    this.acq = new ArrayList();
    this.ajf = 200L;
    this.aji = 200L;
    this.ajh = 200L;
    this.ajg = 200L;
    AppMethodBeat.o(133915);
  }
  
  private void a(f.a parama)
  {
    AppMethodBeat.i(133922);
    if (parama.acD != null) {
      a(parama, parama.acD);
    }
    if (parama.acE != null) {
      a(parama, parama.acE);
    }
    AppMethodBeat.o(133922);
  }
  
  private void a(List<f.a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133921);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      f.a locala = (f.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.acD == null) && (locala.acE == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(133921);
  }
  
  private boolean a(f.a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(133923);
    if (parama.acE == paramv) {
      parama.acE = null;
    }
    for (;;)
    {
      paramv.aku.setAlpha(1.0F);
      paramv.aku.setTranslationX(0.0F);
      paramv.aku.setTranslationY(0.0F);
      m(paramv);
      AppMethodBeat.o(133923);
      return true;
      if (parama.acD != paramv) {
        break;
      }
      parama.acD = null;
    }
    AppMethodBeat.o(133923);
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133925);
    if (acf == null) {
      acf = new ValueAnimator().getInterpolator();
    }
    paramv.aku.animate().setInterpolator(acf);
    d(paramv);
    AppMethodBeat.o(133925);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(133929);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aku.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(133929);
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133919);
    View localView = paramv.aku;
    paramInt1 += (int)paramv.aku.getTranslationX();
    paramInt2 += (int)paramv.aku.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      C(paramv);
      AppMethodBeat.o(133919);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.aci.add(new f.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(133919);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133920);
    ab.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateChange lastPos: %d", new Object[] { Integer.valueOf(paramv1.jN()) });
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(133920);
      return bool;
    }
    float f1 = paramv1.aku.getTranslationX();
    float f2 = paramv1.aku.getTranslationY();
    float f3 = paramv1.aku.getAlpha();
    e(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.aku.setTranslationX(f1);
    paramv1.aku.setTranslationY(f2);
    paramv1.aku.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.aku.setTranslationX(-i);
      paramv2.aku.setTranslationY(-j);
      paramv2.aku.setAlpha(0.0F);
    }
    paramv1 = new f.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4);
    this.acj.add(paramv1);
    AppMethodBeat.o(133920);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(133930);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(133930);
      return true;
    }
    AppMethodBeat.o(133930);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133917);
    ab.i("MicroMsg.RecentAppBrandItemAnimator", "alvinluo animateRemove %d", new Object[] { Integer.valueOf(paramv.jN()) });
    e(paramv);
    this.acg.add(paramv);
    AppMethodBeat.o(133917);
    return true;
  }
  
  public final boolean c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133918);
    e(paramv);
    paramv.aku.setAlpha(0.0F);
    paramv.aku.setScaleX(0.75F);
    paramv.aku.setScaleY(0.75F);
    this.ach.add(paramv);
    AppMethodBeat.o(133918);
    return true;
  }
  
  public final void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133924);
    View localView = paramv.aku;
    localView.animate().cancel();
    int i = this.aci.size() - 1;
    while (i >= 0)
    {
      if (((f.b)this.aci.get(i)).acJ == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        C(paramv);
        this.aci.remove(i);
      }
      i -= 1;
    }
    a(this.acj, paramv);
    if (this.acg.remove(paramv))
    {
      localView.setAlpha(1.0F);
      B(paramv);
    }
    if (this.ach.remove(paramv))
    {
      localView.setAlpha(1.0F);
      m(paramv);
    }
    i = this.acm.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.acm.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.acm.remove(i);
      }
      i -= 1;
    }
    i = this.acl.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.acl.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((f.b)localArrayList.get(j)).acJ != paramv) {
            break label298;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          C(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.acl.remove(i);
          }
        }
        i -= 1;
        break;
        label298:
        j -= 1;
      }
    }
    i = this.ack.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.ack.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        m(paramv);
        if (localArrayList.isEmpty()) {
          this.ack.remove(i);
        }
      }
      i -= 1;
    }
    this.acp.remove(paramv);
    this.acn.remove(paramv);
    this.acq.remove(paramv);
    this.aco.remove(paramv);
    hB();
    AppMethodBeat.o(133924);
  }
  
  public final void hA()
  {
    AppMethodBeat.i(133916);
    int i;
    int j;
    label30:
    int k;
    if (!this.acg.isEmpty())
    {
      i = 1;
      if (this.aci.isEmpty()) {
        break label84;
      }
      j = 1;
      if (this.acj.isEmpty()) {
        break label89;
      }
      k = 1;
      label42:
      if (this.ach.isEmpty()) {
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
      AppMethodBeat.o(133916);
      return;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label42;
    }
    label100:
    Object localObject1 = this.acg.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      View localView = ((RecyclerView.v)localObject2).aku;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.acp.add(localObject2);
      localViewPropertyAnimator.setDuration(this.ajg).alpha(0.0F).setListener(new f.4(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
    }
    this.acg.clear();
    label358:
    long l1;
    label433:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aci);
      this.acl.add(localObject1);
      this.aci.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(133902);
          Iterator localIterator = this.acr.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (f.b)localIterator.next();
            f localf = f.this;
            RecyclerView.v localv = ((f.b)localObject).acJ;
            int k = ((f.b)localObject).acF;
            int i = ((f.b)localObject).acG;
            int m = ((f.b)localObject).acH;
            int j = ((f.b)localObject).acI;
            localObject = localv.aku;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localf.aco.add(localv);
            localViewPropertyAnimator.setDuration(localf.ajh).setListener(new f.6(localf, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.acr.clear();
          f.this.acl.remove(this.acr);
          AppMethodBeat.o(133902);
        }
      };
      if (i != 0) {
        t.a(((f.b)((ArrayList)localObject1).get(0)).acJ.aku, (Runnable)localObject2, this.ajg);
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.acj);
        this.acm.add(localObject1);
        this.acj.clear();
        localObject2 = new f.2(this, (ArrayList)localObject1);
        if (i == 0) {
          break label501;
        }
        t.a(((f.a)((ArrayList)localObject1).get(0)).acD.aku, (Runnable)localObject2, this.ajg);
      }
      if (m == 0) {
        break label536;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ach);
      this.ack.add(localObject1);
      this.ach.clear();
      localObject2 = new f.3(this, (ArrayList)localObject1);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label529;
      }
      if (i == 0) {
        break label511;
      }
      l1 = this.ajg;
      if (j == 0) {
        break label517;
      }
      l2 = this.ajh;
      label443:
      if (k == 0) {
        break label523;
      }
    }
    label517:
    label523:
    for (long l3 = this.aji;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aku, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(133916);
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
    AppMethodBeat.o(133916);
  }
  
  final void hB()
  {
    AppMethodBeat.i(133927);
    if (!isRunning()) {
      jw();
    }
    AppMethodBeat.o(133927);
  }
  
  public final void hC()
  {
    AppMethodBeat.i(133928);
    int i = this.aci.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (f.b)this.aci.get(i);
      localObject2 = ((f.b)localObject1).acJ.aku;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      C(((f.b)localObject1).acJ);
      this.aci.remove(i);
      i -= 1;
    }
    i = this.acg.size() - 1;
    while (i >= 0)
    {
      B((RecyclerView.v)this.acg.get(i));
      this.acg.remove(i);
      i -= 1;
    }
    i = this.ach.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.ach.get(i);
      ((RecyclerView.v)localObject1).aku.setAlpha(1.0F);
      m((RecyclerView.v)localObject1);
      this.ach.remove(i);
      i -= 1;
    }
    i = this.acj.size() - 1;
    while (i >= 0)
    {
      a((f.a)this.acj.get(i));
      i -= 1;
    }
    this.acj.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(133928);
      return;
    }
    i = this.acl.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.acl.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (f.b)((ArrayList)localObject1).get(j);
        View localView = ((f.b)localObject2).acJ.aku;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        C(((f.b)localObject2).acJ);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.acl.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.ack.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.ack.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).aku.setAlpha(1.0F);
        m((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.ack.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.acm.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.acm.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((f.a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.acm.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    o(this.acp);
    o(this.aco);
    o(this.acn);
    o(this.acq);
    jw();
    AppMethodBeat.o(133928);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(133926);
    if ((!this.ach.isEmpty()) || (!this.acj.isEmpty()) || (!this.aci.isEmpty()) || (!this.acg.isEmpty()) || (!this.aco.isEmpty()) || (!this.acp.isEmpty()) || (!this.acn.isEmpty()) || (!this.acq.isEmpty()) || (!this.acl.isEmpty()) || (!this.ack.isEmpty()) || (!this.acm.isEmpty()))
    {
      AppMethodBeat.o(133926);
      return true;
    }
    AppMethodBeat.o(133926);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.f
 * JD-Core Version:    0.7.0.1
 */