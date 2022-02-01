package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.g.z;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends w
{
  private static TimeInterpolator bUE;
  private ArrayList<RecyclerView.v> bUF;
  private ArrayList<RecyclerView.v> bUG;
  private ArrayList<c> bUH;
  private ArrayList<a> bUI;
  ArrayList<ArrayList<RecyclerView.v>> bUJ;
  ArrayList<ArrayList<c>> bUK;
  ArrayList<ArrayList<a>> bUL;
  ArrayList<RecyclerView.v> bUM;
  ArrayList<RecyclerView.v> bUN;
  ArrayList<RecyclerView.v> bUO;
  ArrayList<RecyclerView.v> bUP;
  d.b viJ;
  
  public d()
  {
    AppMethodBeat.i(288445);
    this.bUF = new ArrayList();
    this.bUG = new ArrayList();
    this.bUH = new ArrayList();
    this.bUI = new ArrayList();
    this.bUJ = new ArrayList();
    this.bUK = new ArrayList();
    this.bUL = new ArrayList();
    this.bUM = new ArrayList();
    this.bUN = new ArrayList();
    this.bUO = new ArrayList();
    this.bUP = new ArrayList();
    AppMethodBeat.o(288445);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(288456);
    if (parama.bVc != null) {
      a(parama, parama.bVc);
    }
    if (parama.bVd != null) {
      a(parama, parama.bVd);
    }
    AppMethodBeat.o(288456);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(288450);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.bVc == null) && (locala.bVd == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(288450);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(288459);
    if (parama.bVd == paramv) {
      parama.bVd = null;
    }
    for (;;)
    {
      paramv.caK.setAlpha(1.0F);
      paramv.caK.setTranslationX(0.0F);
      paramv.caK.setTranslationY(0.0F);
      r(paramv);
      AppMethodBeat.o(288459);
      return true;
      if (parama.bVc != paramv) {
        break;
      }
      parama.bVc = null;
    }
    AppMethodBeat.o(288459);
    return false;
  }
  
  private static void ae(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(288463);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).caK.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(288463);
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(288461);
    if (bUE == null) {
      bUE = new ValueAnimator().getInterpolator();
    }
    paramv.caK.animate().setInterpolator(bUE);
    c(paramv);
    AppMethodBeat.o(288461);
  }
  
  public final void IW()
  {
    AppMethodBeat.i(288467);
    int i;
    int j;
    label29:
    int k;
    if (!this.bUF.isEmpty())
    {
      i = 1;
      if (this.bUH.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.bUI.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.bUG.isEmpty()) {
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
      AppMethodBeat.o(288467);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.bUF.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      Object localObject3 = ((RecyclerView.v)localObject2).caK;
      this.bUO.add(localObject2);
      final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
      localObject3 = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(288501);
          localViewPropertyAnimator.setListener(null);
          this.val$view.setAlpha(1.0F);
          d.this.A(this.bUU);
          d.this.bUO.remove(this.bUU);
          d.this.IX();
          AppMethodBeat.o(288501);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(288492);
          d.this.C(this.bUU);
          AppMethodBeat.o(288492);
        }
      };
      if ((this.viJ == null) || (!this.viJ.a((RecyclerView.v)localObject2, (Animator.AnimatorListener)localObject3))) {
        localViewPropertyAnimator.setDuration(Ku()).alpha(0.0F).setListener((Animator.AnimatorListener)localObject3).start();
      }
    }
    this.bUF.clear();
    label383:
    long l1;
    label458:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUH);
      this.bUK.add(localObject1);
      this.bUH.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(288475);
          Iterator localIterator = this.bUQ.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (d.c)localIterator.next();
            d locald = d.this;
            RecyclerView.v localv = ((d.c)localObject).bVi;
            int k = ((d.c)localObject).bVe;
            int i = ((d.c)localObject).bVf;
            int m = ((d.c)localObject).bVg;
            int j = ((d.c)localObject).bVh;
            localObject = localv.caK;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            locald.bUN.add(localv);
            localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(locald.bZK).setListener(new d.6(locald, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.bUQ.clear();
          d.this.bUK.remove(this.bUQ);
          AppMethodBeat.o(288475);
        }
      };
      if (i != 0) {
        z.a(((c)((ArrayList)localObject1).get(0)).bVi.caK, (Runnable)localObject2, Ku());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.bUI);
        this.bUL.add(localObject1);
        this.bUI.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(288471);
            Iterator localIterator = this.bUS.iterator();
            if (localIterator.hasNext())
            {
              d.a locala = (d.a)localIterator.next();
              d locald = d.this;
              Object localObject1 = locala.bVc;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.bVd;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).caK;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locald.bZL);
                  locald.bUP.add(locala.bVc);
                  localViewPropertyAnimator.translationX(locala.bVg - locala.bVe);
                  localViewPropertyAnimator.translationY(locala.bVh - locala.bVf);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new d.7(locald, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locald.bUP.add(locala.bVd);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locald.bZL).alpha(1.0F).setListener(new d.8(locald, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).caK;
                break label51;
              }
            }
            this.bUS.clear();
            d.this.bUL.remove(this.bUS);
            AppMethodBeat.o(288471);
          }
        };
        if (i == 0) {
          break label525;
        }
        z.a(((a)((ArrayList)localObject1).get(0)).bVc.caK, (Runnable)localObject2, Ku());
      }
      if (m == 0) {
        break label560;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.bUG);
      this.bUJ.add(localObject1);
      this.bUG.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(288484);
          Iterator localIterator = this.bUT.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            d locald = d.this;
            View localView = localv.caK;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locald.bUM.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(locald.Kt()).setListener(new d.5(locald, localv, localView, localViewPropertyAnimator)).start();
          }
          this.bUT.clear();
          d.this.bUJ.remove(this.bUT);
          AppMethodBeat.o(288484);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label553;
      }
      if (i == 0) {
        break label535;
      }
      l1 = Ku();
      if (j == 0) {
        break label541;
      }
      l2 = this.bZK;
      label468:
      if (k == 0) {
        break label547;
      }
    }
    label525:
    label535:
    label541:
    label547:
    for (long l3 = this.bZL;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      z.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).caK, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(288467);
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
    AppMethodBeat.o(288467);
  }
  
  final void IX()
  {
    AppMethodBeat.i(288498);
    if (!isRunning()) {
      Kv();
    }
    AppMethodBeat.o(288498);
  }
  
  public final void IY()
  {
    AppMethodBeat.i(288505);
    int i = this.bUH.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c)this.bUH.get(i);
      localObject2 = ((c)localObject1).bVi.caK;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      B(((c)localObject1).bVi);
      this.bUH.remove(i);
      i -= 1;
    }
    i = this.bUF.size() - 1;
    while (i >= 0)
    {
      A((RecyclerView.v)this.bUF.get(i));
      this.bUF.remove(i);
      i -= 1;
    }
    i = this.bUG.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.bUG.get(i);
      ((RecyclerView.v)localObject1).caK.setAlpha(1.0F);
      r((RecyclerView.v)localObject1);
      this.bUG.remove(i);
      i -= 1;
    }
    i = this.bUI.size() - 1;
    while (i >= 0)
    {
      a((a)this.bUI.get(i));
      i -= 1;
    }
    this.bUI.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(288505);
      return;
    }
    i = this.bUK.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUK.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (c)((ArrayList)localObject1).get(j);
        View localView = ((c)localObject2).bVi.caK;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(((c)localObject2).bVi);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUK.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUJ.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).caK.setAlpha(1.0F);
        r((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUJ.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.bUL.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.bUL.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.bUL.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    ae(this.bUO);
    ae(this.bUN);
    ae(this.bUM);
    ae(this.bUP);
    Kv();
    AppMethodBeat.o(288505);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(288472);
    d(paramv);
    this.bUF.add(paramv);
    AppMethodBeat.o(288472);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(288481);
    View localView = paramv.caK;
    paramInt1 += (int)paramv.caK.getTranslationX();
    paramInt2 += (int)paramv.caK.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      B(paramv);
      AppMethodBeat.o(288481);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.bUH.add(new c(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(288481);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(288482);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(288482);
      return bool;
    }
    float f1 = paramv1.caK.getTranslationX();
    float f2 = paramv1.caK.getTranslationY();
    float f3 = paramv1.caK.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.caK.setTranslationX(f1);
    paramv1.caK.setTranslationY(f2);
    paramv1.caK.setAlpha(f3);
    if (paramv2 != null)
    {
      d(paramv2);
      paramv2.caK.setTranslationX(-i);
      paramv2.caK.setTranslationY(-j);
      paramv2.caK.setAlpha(0.0F);
    }
    this.bUI.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(288482);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(288507);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(288507);
      return true;
    }
    AppMethodBeat.o(288507);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(288478);
    d(paramv);
    paramv.caK.setAlpha(0.0F);
    this.bUG.add(paramv);
    AppMethodBeat.o(288478);
    return true;
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(288489);
    View localView = paramv.caK;
    localView.animate().cancel();
    int i = this.bUH.size() - 1;
    while (i >= 0)
    {
      if (((c)this.bUH.get(i)).bVi == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        B(paramv);
        this.bUH.remove(i);
      }
      i -= 1;
    }
    a(this.bUI, paramv);
    if (this.bUF.remove(paramv))
    {
      localView.setAlpha(1.0F);
      localView.setTranslationX(0.0F);
      A(paramv);
    }
    if (this.bUG.remove(paramv))
    {
      localView.setAlpha(1.0F);
      r(paramv);
    }
    i = this.bUL.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUL.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.bUL.remove(i);
      }
      i -= 1;
    }
    i = this.bUK.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.bUK.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((c)localArrayList.get(j)).bVi != paramv) {
            break label305;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          B(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.bUK.remove(i);
          }
        }
        i -= 1;
        break;
        label305:
        j -= 1;
      }
    }
    i = this.bUJ.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.bUJ.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        r(paramv);
        if (localArrayList.isEmpty()) {
          this.bUJ.remove(i);
        }
      }
      i -= 1;
    }
    this.bUO.remove(paramv);
    this.bUM.remove(paramv);
    this.bUP.remove(paramv);
    this.bUN.remove(paramv);
    IX();
    AppMethodBeat.o(288489);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(288493);
    if ((!this.bUG.isEmpty()) || (!this.bUI.isEmpty()) || (!this.bUH.isEmpty()) || (!this.bUF.isEmpty()) || (!this.bUN.isEmpty()) || (!this.bUO.isEmpty()) || (!this.bUM.isEmpty()) || (!this.bUP.isEmpty()) || (!this.bUK.isEmpty()) || (!this.bUJ.isEmpty()) || (!this.bUL.isEmpty()))
    {
      AppMethodBeat.o(288493);
      return true;
    }
    AppMethodBeat.o(288493);
    return false;
  }
  
  static final class a
  {
    public RecyclerView.v bVc;
    public RecyclerView.v bVd;
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.bVc = paramv1;
      this.bVd = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(288444);
      String str = "ChangeInfo{oldHolder=" + this.bVc + ", newHolder=" + this.bVd + ", fromX=" + this.bVe + ", fromY=" + this.bVf + ", toX=" + this.bVg + ", toY=" + this.bVh + '}';
      AppMethodBeat.o(288444);
      return str;
    }
  }
  
  static final class c
  {
    public int bVe;
    public int bVf;
    public int bVg;
    public int bVh;
    public RecyclerView.v bVi;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.bVi = paramv;
      this.bVe = paramInt1;
      this.bVf = paramInt2;
      this.bVg = paramInt3;
      this.bVh = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */