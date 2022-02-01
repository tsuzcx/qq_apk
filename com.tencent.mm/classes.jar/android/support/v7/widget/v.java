package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.t;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  extends as
{
  private static TimeInterpolator akg;
  private ArrayList<RecyclerView.w> akh = new ArrayList();
  private ArrayList<RecyclerView.w> aki = new ArrayList();
  private ArrayList<b> akj = new ArrayList();
  private ArrayList<a> akk = new ArrayList();
  ArrayList<ArrayList<RecyclerView.w>> akl = new ArrayList();
  ArrayList<ArrayList<b>> akm = new ArrayList();
  ArrayList<ArrayList<a>> akn = new ArrayList();
  ArrayList<RecyclerView.w> ako = new ArrayList();
  ArrayList<RecyclerView.w> akp = new ArrayList();
  ArrayList<RecyclerView.w> akq = new ArrayList();
  ArrayList<RecyclerView.w> akr = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.akE != null) {
      a(parama, parama.akE);
    }
    if (parama.akF != null) {
      a(parama, parama.akF);
    }
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.akE == null) && (locala.akF == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    if (parama.akF == paramw) {
      parama.akF = null;
    }
    for (;;)
    {
      paramw.asD.setAlpha(1.0F);
      paramw.asD.setTranslationX(0.0F);
      paramw.asD.setTranslationY(0.0F);
      n(paramw);
      return true;
      if (parama.akE != paramw) {
        break;
      }
      parama.akE = null;
    }
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    if (akg == null) {
      akg = new ValueAnimator().getInterpolator();
    }
    paramw.asD.animate().setInterpolator(akg);
    d(paramw);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).asD.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramw.asD;
    paramInt1 += (int)paramw.asD.getTranslationX();
    paramInt2 += (int)paramw.asD.getTranslationY();
    e(paramw);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramw);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.akj.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramw1 == paramw2) {
      return a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.akk.add(new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramw, paramList));
  }
  
  public boolean b(RecyclerView.w paramw)
  {
    e(paramw);
    this.akh.add(paramw);
    return true;
  }
  
  public boolean c(RecyclerView.w paramw)
  {
    e(paramw);
    paramw.asD.setAlpha(0.0F);
    this.aki.add(paramw);
    return true;
  }
  
  public void d(RecyclerView.w paramw)
  {
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
            break label293;
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
        label293:
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
  }
  
  public boolean isRunning()
  {
    return (!this.aki.isEmpty()) || (!this.akk.isEmpty()) || (!this.akj.isEmpty()) || (!this.akh.isEmpty()) || (!this.akp.isEmpty()) || (!this.akq.isEmpty()) || (!this.ako.isEmpty()) || (!this.akr.isEmpty()) || (!this.akm.isEmpty()) || (!this.akl.isEmpty()) || (!this.akn.isEmpty());
  }
  
  public void je()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.akh.isEmpty())
    {
      i = 1;
      if (this.akj.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.akk.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.aki.isEmpty()) {
        break label82;
      }
    }
    label72:
    label77:
    label82:
    for (int m = 1;; m = 0)
    {
      if ((i != 0) || (j != 0) || (m != 0) || (k != 0)) {
        break label88;
      }
      return;
      i = 0;
      break;
      j = 0;
      break label24;
      k = 0;
      break label36;
    }
    label88:
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
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          v.this.w(this.akw);
          v.this.akq.remove(this.akw);
          v.this.jf();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          v.this.A(this.akw);
        }
      }).start();
    }
    this.akh.clear();
    label266:
    label346:
    long l1;
    label421:
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
          Iterator localIterator = this.aks.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (v.b)localIterator.next();
            v localv = v.this;
            RecyclerView.w localw = ((v.b)localObject).akK;
            int k = ((v.b)localObject).akG;
            int i = ((v.b)localObject).akH;
            int m = ((v.b)localObject).akI;
            int j = ((v.b)localObject).akJ;
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
            localv.akp.add(localw);
            localViewPropertyAnimator.setDuration(localv.arm).setListener(new v.6(localv, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.aks.clear();
          v.this.akm.remove(this.aks);
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
            Iterator localIterator = this.aku.iterator();
            if (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v localv = v.this;
              Object localObject1 = locala.akE;
              if (localObject1 == null)
              {
                localObject1 = null;
                label46:
                localObject2 = locala.akF;
                if (localObject2 == null) {
                  break label229;
                }
              }
              label229:
              for (Object localObject2 = ((RecyclerView.w)localObject2).asD;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localv.arn);
                  localv.akr.add(locala.akE);
                  localViewPropertyAnimator.translationX(locala.akI - locala.akG);
                  localViewPropertyAnimator.translationY(locala.akJ - locala.akH);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new v.7(localv, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localv.akr.add(locala.akF);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localv.arn).alpha(1.0F).setListener(new v.8(localv, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).asD;
                break label46;
              }
            }
            this.aku.clear();
            v.this.akn.remove(this.aku);
          }
        };
        if (i == 0) {
          break label483;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).akE.asD, (Runnable)localObject2, kY());
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aki);
      this.akl.add(localObject1);
      this.aki.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.akv.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            v localv = v.this;
            View localView = localw.asD;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localv.ako.add(localw);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localv.kX()).setListener(new v.5(localv, localw, localView, localViewPropertyAnimator)).start();
          }
          this.akv.clear();
          v.this.akl.remove(this.akv);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = kY();
      if (j == 0) {
        break label499;
      }
      l2 = this.arm;
      label431:
      if (k == 0) {
        break label505;
      }
    }
    label483:
    label491:
    label493:
    label499:
    label505:
    for (long l3 = this.arn;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).asD, (Runnable)localObject2, l1 + l2);
      return;
      ((Runnable)localObject2).run();
      break label266;
      ((Runnable)localObject2).run();
      break label346;
      break;
      l1 = 0L;
      break label421;
      l2 = 0L;
      break label431;
    }
    label511:
    ((Runnable)localObject2).run();
  }
  
  final void jf()
  {
    if (!isRunning()) {
      lc();
    }
  }
  
  public final void jg()
  {
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
    if (!isRunning()) {
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
  }
  
  static final class a
  {
    public RecyclerView.w akE;
    public RecyclerView.w akF;
    public int akG;
    public int akH;
    public int akI;
    public int akJ;
    
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
      return "ChangeInfo{oldHolder=" + this.akE + ", newHolder=" + this.akF + ", fromX=" + this.akG + ", fromY=" + this.akH + ", toX=" + this.akI + ", toY=" + this.akJ + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.v
 * JD-Core Version:    0.7.0.1
 */