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
  private static TimeInterpolator ajm;
  private ArrayList<RecyclerView.v> ajn = new ArrayList();
  private ArrayList<RecyclerView.v> ajo = new ArrayList();
  private ArrayList<b> ajp = new ArrayList();
  private ArrayList<a> ajq = new ArrayList();
  ArrayList<ArrayList<RecyclerView.v>> ajr = new ArrayList();
  ArrayList<ArrayList<b>> ajs = new ArrayList();
  ArrayList<ArrayList<a>> ajt = new ArrayList();
  ArrayList<RecyclerView.v> aju = new ArrayList();
  ArrayList<RecyclerView.v> ajv = new ArrayList();
  ArrayList<RecyclerView.v> ajw = new ArrayList();
  ArrayList<RecyclerView.v> ajx = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.ajK != null) {
      a(parama, parama.ajK);
    }
    if (parama.ajL != null) {
      a(parama, parama.ajL);
    }
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.ajK == null) && (locala.ajL == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    if (parama.ajL == paramv) {
      parama.ajL = null;
    }
    for (;;)
    {
      paramv.arI.setAlpha(1.0F);
      paramv.arI.setTranslationX(0.0F);
      paramv.arI.setTranslationY(0.0F);
      n(paramv);
      return true;
      if (parama.ajK != paramv) {
        break;
      }
      parama.ajK = null;
    }
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    if (ajm == null) {
      ajm = new ValueAnimator().getInterpolator();
    }
    paramv.arI.animate().setInterpolator(ajm);
    d(paramv);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).arI.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.arI;
    paramInt1 += (int)paramv.arI.getTranslationX();
    paramInt2 += (int)paramv.arI.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      x(paramv);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.ajp.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
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
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    e(paramv);
    this.ajn.add(paramv);
    return true;
  }
  
  public boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    paramv.arI.setAlpha(0.0F);
    this.ajo.add(paramv);
    return true;
  }
  
  public void d(RecyclerView.v paramv)
  {
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
            break label293;
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
        label293:
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
  }
  
  public void iW()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.ajn.isEmpty())
    {
      i = 1;
      if (this.ajp.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.ajq.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.ajo.isEmpty()) {
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
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          v.this.w(this.ajC);
          v.this.ajw.remove(this.ajC);
          v.this.iX();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          v.this.A(this.ajC);
        }
      }).start();
    }
    this.ajn.clear();
    label266:
    label346:
    long l1;
    label421:
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
          Iterator localIterator = this.ajy.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (v.b)localIterator.next();
            v localv = v.this;
            RecyclerView.v localv1 = ((v.b)localObject).ajQ;
            int k = ((v.b)localObject).ajM;
            int i = ((v.b)localObject).ajN;
            int m = ((v.b)localObject).ajO;
            int j = ((v.b)localObject).ajP;
            localObject = localv1.arI;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localv.ajv.add(localv1);
            localViewPropertyAnimator.setDuration(localv.aqr).setListener(new v.6(localv, localv1, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.ajy.clear();
          v.this.ajs.remove(this.ajy);
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
            Iterator localIterator = this.ajA.iterator();
            if (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v localv = v.this;
              Object localObject1 = locala.ajK;
              if (localObject1 == null)
              {
                localObject1 = null;
                label46:
                localObject2 = locala.ajL;
                if (localObject2 == null) {
                  break label229;
                }
              }
              label229:
              for (Object localObject2 = ((RecyclerView.v)localObject2).arI;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localv.aqs);
                  localv.ajx.add(locala.ajK);
                  localViewPropertyAnimator.translationX(locala.ajO - locala.ajM);
                  localViewPropertyAnimator.translationY(locala.ajP - locala.ajN);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new v.7(localv, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localv.ajx.add(locala.ajL);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localv.aqs).alpha(1.0F).setListener(new v.8(localv, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).arI;
                break label46;
              }
            }
            this.ajA.clear();
            v.this.ajt.remove(this.ajA);
          }
        };
        if (i == 0) {
          break label483;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).ajK.arI, (Runnable)localObject2, kQ());
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ajo);
      this.ajr.add(localObject1);
      this.ajo.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.ajB.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            v localv1 = v.this;
            View localView = localv.arI;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localv1.aju.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localv1.kP()).setListener(new v.5(localv1, localv, localView, localViewPropertyAnimator)).start();
          }
          this.ajB.clear();
          v.this.ajr.remove(this.ajB);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = kQ();
      if (j == 0) {
        break label499;
      }
      l2 = this.aqr;
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
    for (long l3 = this.aqs;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).arI, (Runnable)localObject2, l1 + l2);
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
  
  final void iX()
  {
    if (!isRunning()) {
      kU();
    }
  }
  
  public final void iY()
  {
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
    if (!isRunning()) {
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
  }
  
  public boolean isRunning()
  {
    return (!this.ajo.isEmpty()) || (!this.ajq.isEmpty()) || (!this.ajp.isEmpty()) || (!this.ajn.isEmpty()) || (!this.ajv.isEmpty()) || (!this.ajw.isEmpty()) || (!this.aju.isEmpty()) || (!this.ajx.isEmpty()) || (!this.ajs.isEmpty()) || (!this.ajr.isEmpty()) || (!this.ajt.isEmpty());
  }
  
  static final class a
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
      return "ChangeInfo{oldHolder=" + this.ajK + ", newHolder=" + this.ajL + ", fromX=" + this.ajM + ", fromY=" + this.ajN + ", toX=" + this.ajO + ", toY=" + this.ajP + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.v
 * JD-Core Version:    0.7.0.1
 */