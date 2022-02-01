package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.g.w;
import androidx.recyclerview.widget.RecyclerView.f;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
  extends y
{
  private static TimeInterpolator afY;
  private ArrayList<RecyclerView.v> afZ;
  private ArrayList<RecyclerView.v> aga;
  private ArrayList<c> agb;
  private ArrayList<a> agc;
  ArrayList<ArrayList<RecyclerView.v>> agd;
  ArrayList<ArrayList<c>> age;
  ArrayList<ArrayList<a>> agf;
  ArrayList<RecyclerView.v> agg;
  ArrayList<RecyclerView.v> agh;
  ArrayList<RecyclerView.v> agi;
  ArrayList<RecyclerView.v> agj;
  b rXs;
  
  public d()
  {
    AppMethodBeat.i(186201);
    this.afZ = new ArrayList();
    this.aga = new ArrayList();
    this.agb = new ArrayList();
    this.agc = new ArrayList();
    this.agd = new ArrayList();
    this.age = new ArrayList();
    this.agf = new ArrayList();
    this.agg = new ArrayList();
    this.agh = new ArrayList();
    this.agi = new ArrayList();
    this.agj = new ArrayList();
    AppMethodBeat.o(186201);
  }
  
  private void a(a parama)
  {
    AppMethodBeat.i(186215);
    if (parama.agw != null) {
      a(parama, parama.agw);
    }
    if (parama.agx != null) {
      a(parama, parama.agx);
    }
    AppMethodBeat.o(186215);
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    AppMethodBeat.i(186213);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.agw == null) && (locala.agx == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
    AppMethodBeat.o(186213);
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    AppMethodBeat.i(186217);
    if (parama.agx == paramv) {
      parama.agx = null;
    }
    for (;;)
    {
      paramv.amk.setAlpha(1.0F);
      paramv.amk.setTranslationX(0.0F);
      paramv.amk.setTranslationY(0.0F);
      q(paramv);
      AppMethodBeat.o(186217);
      return true;
      if (parama.agw != paramv) {
        break;
      }
      parama.agw = null;
    }
    AppMethodBeat.o(186217);
    return false;
  }
  
  private void d(RecyclerView.v paramv)
  {
    AppMethodBeat.i(186221);
    if (afY == null) {
      afY = new ValueAnimator().getInterpolator();
    }
    paramv.amk.animate().setInterpolator(afY);
    c(paramv);
    AppMethodBeat.o(186221);
  }
  
  private static void l(List<RecyclerView.v> paramList)
  {
    AppMethodBeat.i(186225);
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).amk.animate().cancel();
      i -= 1;
    }
    AppMethodBeat.o(186225);
  }
  
  public final boolean a(RecyclerView.v paramv)
  {
    AppMethodBeat.i(186206);
    d(paramv);
    this.afZ.add(paramv);
    AppMethodBeat.o(186206);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186208);
    View localView = paramv.amk;
    paramInt1 += (int)paramv.amk.getTranslationX();
    paramInt2 += (int)paramv.amk.getTranslationY();
    d(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      A(paramv);
      AppMethodBeat.o(186208);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.agb.add(new c(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(186208);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(186210);
    if (paramv1 == paramv2)
    {
      boolean bool = a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(186210);
      return bool;
    }
    float f1 = paramv1.amk.getTranslationX();
    float f2 = paramv1.amk.getTranslationY();
    float f3 = paramv1.amk.getAlpha();
    d(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.amk.setTranslationX(f1);
    paramv1.amk.setTranslationY(f2);
    paramv1.amk.setAlpha(f3);
    if (paramv2 != null)
    {
      d(paramv2);
      paramv2.amk.setTranslationX(-i);
      paramv2.amk.setTranslationY(-j);
      paramv2.amk.setAlpha(0.0F);
    }
    this.agc.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(186210);
    return true;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(186227);
    if ((!paramList.isEmpty()) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(186227);
      return true;
    }
    AppMethodBeat.o(186227);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(186207);
    d(paramv);
    paramv.amk.setAlpha(0.0F);
    this.aga.add(paramv);
    AppMethodBeat.o(186207);
    return true;
  }
  
  public final void c(RecyclerView.v paramv)
  {
    AppMethodBeat.i(186219);
    View localView = paramv.amk;
    localView.animate().cancel();
    int i = this.agb.size() - 1;
    while (i >= 0)
    {
      if (((c)this.agb.get(i)).agC == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        A(paramv);
        this.agb.remove(i);
      }
      i -= 1;
    }
    a(this.agc, paramv);
    if (this.afZ.remove(paramv))
    {
      localView.setAlpha(1.0F);
      localView.setTranslationX(0.0F);
      z(paramv);
    }
    if (this.aga.remove(paramv))
    {
      localView.setAlpha(1.0F);
      q(paramv);
    }
    i = this.agf.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.agf.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.agf.remove(i);
      }
      i -= 1;
    }
    i = this.age.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.age.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((c)localArrayList.get(j)).agC != paramv) {
            break label304;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          A(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.age.remove(i);
          }
        }
        i -= 1;
        break;
        label304:
        j -= 1;
      }
    }
    i = this.agd.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.agd.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        q(paramv);
        if (localArrayList.isEmpty()) {
          this.agd.remove(i);
        }
      }
      i -= 1;
    }
    this.agi.remove(paramv);
    this.agg.remove(paramv);
    this.agj.remove(paramv);
    this.agh.remove(paramv);
    km();
    AppMethodBeat.o(186219);
  }
  
  public final boolean isRunning()
  {
    AppMethodBeat.i(186222);
    if ((!this.aga.isEmpty()) || (!this.agc.isEmpty()) || (!this.agb.isEmpty()) || (!this.afZ.isEmpty()) || (!this.agh.isEmpty()) || (!this.agi.isEmpty()) || (!this.agg.isEmpty()) || (!this.agj.isEmpty()) || (!this.age.isEmpty()) || (!this.agd.isEmpty()) || (!this.agf.isEmpty()))
    {
      AppMethodBeat.o(186222);
      return true;
    }
    AppMethodBeat.o(186222);
    return false;
  }
  
  public final void kl()
  {
    AppMethodBeat.i(186203);
    int i;
    int j;
    label29:
    int k;
    if (!this.afZ.isEmpty())
    {
      i = 1;
      if (this.agb.isEmpty()) {
        break label82;
      }
      j = 1;
      if (this.agc.isEmpty()) {
        break label87;
      }
      k = 1;
      label41:
      if (this.aga.isEmpty()) {
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
      AppMethodBeat.o(186203);
      return;
      i = 0;
      break;
      j = 0;
      break label29;
      k = 0;
      break label41;
    }
    label98:
    Object localObject1 = this.afZ.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      Object localObject3 = ((RecyclerView.v)localObject2).amk;
      this.agi.add(localObject2);
      final ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject3).animate();
      localObject3 = new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186709);
          localViewPropertyAnimator.setListener(null);
          this.val$view.setAlpha(1.0F);
          d.this.z(this.ago);
          d.this.agi.remove(this.ago);
          d.this.km();
          AppMethodBeat.o(186709);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(186708);
          d.this.F(this.ago);
          AppMethodBeat.o(186708);
        }
      };
      if ((this.rXs == null) || (!this.rXs.a((RecyclerView.v)localObject2, (Animator.AnimatorListener)localObject3))) {
        localViewPropertyAnimator.setDuration(lK()).alpha(0.0F).setListener((Animator.AnimatorListener)localObject3).start();
      }
    }
    this.afZ.clear();
    label383:
    long l1;
    label458:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.agb);
      this.age.add(localObject1);
      this.agb.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187466);
          Iterator localIterator = this.agk.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (d.c)localIterator.next();
            d locald = d.this;
            RecyclerView.v localv = ((d.c)localObject).agC;
            int k = ((d.c)localObject).agy;
            int i = ((d.c)localObject).agz;
            int m = ((d.c)localObject).agA;
            int j = ((d.c)localObject).agB;
            localObject = localv.amk;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            locald.agh.add(localv);
            localViewPropertyAnimator.setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(locald.ali).setListener(new d.6(locald, localv, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.agk.clear();
          d.this.age.remove(this.agk);
          AppMethodBeat.o(187466);
        }
      };
      if (i != 0) {
        w.a(((c)((ArrayList)localObject1).get(0)).agC.amk, (Runnable)localObject2, lK());
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.agc);
        this.agf.add(localObject1);
        this.agc.clear();
        localObject2 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187601);
            Iterator localIterator = this.agm.iterator();
            if (localIterator.hasNext())
            {
              d.a locala = (d.a)localIterator.next();
              d locald = d.this;
              Object localObject1 = locala.agw;
              if (localObject1 == null)
              {
                localObject1 = null;
                label51:
                localObject2 = locala.agx;
                if (localObject2 == null) {
                  break label234;
                }
              }
              label234:
              for (Object localObject2 = ((RecyclerView.v)localObject2).amk;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(locald.alj);
                  locald.agj.add(locala.agw);
                  localViewPropertyAnimator.translationX(locala.agA - locala.agy);
                  localViewPropertyAnimator.translationY(locala.agB - locala.agz);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new d.7(locald, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                locald.agj.add(locala.agx);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(locald.alj).alpha(1.0F).setListener(new d.8(locald, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).amk;
                break label51;
              }
            }
            this.agm.clear();
            d.this.agf.remove(this.agm);
            AppMethodBeat.o(187601);
          }
        };
        if (i == 0) {
          break label525;
        }
        w.a(((a)((ArrayList)localObject1).get(0)).agw.amk, (Runnable)localObject2, lK());
      }
      if (m == 0) {
        break label560;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aga);
      this.agd.add(localObject1);
      this.aga.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(186900);
          Iterator localIterator = this.agn.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            d locald = d.this;
            View localView = localv.amk;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            locald.agg.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(locald.lJ()).setListener(new d.5(locald, localv, localView, localViewPropertyAnimator)).start();
          }
          this.agn.clear();
          d.this.agd.remove(this.agn);
          AppMethodBeat.o(186900);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label553;
      }
      if (i == 0) {
        break label535;
      }
      l1 = lK();
      if (j == 0) {
        break label541;
      }
      l2 = this.ali;
      label468:
      if (k == 0) {
        break label547;
      }
    }
    label525:
    label535:
    label541:
    label547:
    for (long l3 = this.alj;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      w.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).amk, (Runnable)localObject2, l1 + l2);
      AppMethodBeat.o(186203);
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
    AppMethodBeat.o(186203);
  }
  
  final void km()
  {
    AppMethodBeat.i(186223);
    if (!isRunning()) {
      lM();
    }
    AppMethodBeat.o(186223);
  }
  
  public final void kn()
  {
    AppMethodBeat.i(186224);
    int i = this.agb.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (c)this.agb.get(i);
      localObject2 = ((c)localObject1).agC.amk;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      A(((c)localObject1).agC);
      this.agb.remove(i);
      i -= 1;
    }
    i = this.afZ.size() - 1;
    while (i >= 0)
    {
      z((RecyclerView.v)this.afZ.get(i));
      this.afZ.remove(i);
      i -= 1;
    }
    i = this.aga.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.aga.get(i);
      ((RecyclerView.v)localObject1).amk.setAlpha(1.0F);
      q((RecyclerView.v)localObject1);
      this.aga.remove(i);
      i -= 1;
    }
    i = this.agc.size() - 1;
    while (i >= 0)
    {
      a((a)this.agc.get(i));
      i -= 1;
    }
    this.agc.clear();
    if (!isRunning())
    {
      AppMethodBeat.o(186224);
      return;
    }
    i = this.age.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.age.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (c)((ArrayList)localObject1).get(j);
        View localView = ((c)localObject2).agC.amk;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        A(((c)localObject2).agC);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.age.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.agd.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.agd.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).amk.setAlpha(1.0F);
        q((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.agd.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.agf.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.agf.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.agf.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    l(this.agi);
    l(this.agh);
    l(this.agg);
    l(this.agj);
    lM();
    AppMethodBeat.o(186224);
  }
  
  static final class a
  {
    public int agA;
    public int agB;
    public RecyclerView.v agw;
    public RecyclerView.v agx;
    public int agy;
    public int agz;
    
    private a(RecyclerView.v paramv1, RecyclerView.v paramv2)
    {
      this.agw = paramv1;
      this.agx = paramv2;
    }
    
    a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this(paramv1, paramv2);
      this.agy = paramInt1;
      this.agz = paramInt2;
      this.agA = paramInt3;
      this.agB = paramInt4;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(188329);
      String str = "ChangeInfo{oldHolder=" + this.agw + ", newHolder=" + this.agx + ", fromX=" + this.agy + ", fromY=" + this.agz + ", toX=" + this.agA + ", toY=" + this.agB + '}';
      AppMethodBeat.o(188329);
      return str;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(RecyclerView.v paramv, Animator.AnimatorListener paramAnimatorListener);
  }
  
  static final class c
  {
    public int agA;
    public int agB;
    public RecyclerView.v agC;
    public int agy;
    public int agz;
    
    c(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.agC = paramv;
      this.agy = paramInt1;
      this.agz = paramInt2;
      this.agA = paramInt3;
      this.agB = paramInt4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.d
 * JD-Core Version:    0.7.0.1
 */