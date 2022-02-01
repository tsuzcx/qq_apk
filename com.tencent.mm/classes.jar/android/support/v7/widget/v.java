package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v
  extends as
{
  private static TimeInterpolator amk;
  private ArrayList<RecyclerView.v> aml = new ArrayList();
  private ArrayList<RecyclerView.v> amm = new ArrayList();
  private ArrayList<b> amn = new ArrayList();
  private ArrayList<a> amo = new ArrayList();
  ArrayList<ArrayList<RecyclerView.v>> amp = new ArrayList();
  ArrayList<ArrayList<b>> amq = new ArrayList();
  ArrayList<ArrayList<a>> amr = new ArrayList();
  ArrayList<RecyclerView.v> ams = new ArrayList();
  ArrayList<RecyclerView.v> amt = new ArrayList();
  ArrayList<RecyclerView.v> amu = new ArrayList();
  ArrayList<RecyclerView.v> amv = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.amI != null) {
      a(parama, parama.amI);
    }
    if (parama.amJ != null) {
      a(parama, parama.amJ);
    }
  }
  
  private void a(List<a> paramList, RecyclerView.v paramv)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.amI == null) && (locala.amJ == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.v paramv)
  {
    if (parama.amJ == paramv) {
      parama.amJ = null;
    }
    for (;;)
    {
      paramv.aus.setAlpha(1.0F);
      paramv.aus.setTranslationX(0.0F);
      paramv.aus.setTranslationY(0.0F);
      n(paramv);
      return true;
      if (parama.amI != paramv) {
        break;
      }
      parama.amI = null;
    }
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    if (amk == null) {
      amk = new ValueAnimator().getInterpolator();
    }
    paramv.aus.animate().setInterpolator(amk);
    d(paramv);
  }
  
  private static void n(List<RecyclerView.v> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aus.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.aus;
    paramInt1 += (int)paramv.aus.getTranslationX();
    paramInt2 += (int)paramv.aus.getTranslationY();
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
    this.amn.add(new b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.amo.add(new a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    e(paramv);
    this.aml.add(paramv);
    return true;
  }
  
  public boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    paramv.aus.setAlpha(0.0F);
    this.amm.add(paramv);
    return true;
  }
  
  public void d(RecyclerView.v paramv)
  {
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
            break label293;
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
        label293:
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
  }
  
  public boolean isRunning()
  {
    return (!this.amm.isEmpty()) || (!this.amo.isEmpty()) || (!this.amn.isEmpty()) || (!this.aml.isEmpty()) || (!this.amt.isEmpty()) || (!this.amu.isEmpty()) || (!this.ams.isEmpty()) || (!this.amv.isEmpty()) || (!this.amq.isEmpty()) || (!this.amp.isEmpty()) || (!this.amr.isEmpty());
  }
  
  public void jD()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.aml.isEmpty())
    {
      i = 1;
      if (this.amn.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.amo.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.amm.isEmpty()) {
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
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          v.this.w(this.amA);
          v.this.amu.remove(this.amA);
          v.this.jE();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          v.this.C(this.amA);
        }
      }).start();
    }
    this.aml.clear();
    label266:
    label346:
    long l1;
    label421:
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
          Iterator localIterator = this.amw.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (v.b)localIterator.next();
            v localv = v.this;
            RecyclerView.v localv1 = ((v.b)localObject).amO;
            int k = ((v.b)localObject).amK;
            int i = ((v.b)localObject).amL;
            int m = ((v.b)localObject).amM;
            int j = ((v.b)localObject).amN;
            localObject = localv1.aus;
            k = m - k;
            i = j - i;
            if (k != 0) {
              ((View)localObject).animate().translationX(0.0F);
            }
            if (i != 0) {
              ((View)localObject).animate().translationY(0.0F);
            }
            ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject).animate();
            localv.amt.add(localv1);
            localViewPropertyAnimator.setDuration(localv.atp).setListener(new v.6(localv, localv1, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amw.clear();
          v.this.amq.remove(this.amw);
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
            Iterator localIterator = this.amy.iterator();
            if (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v localv = v.this;
              Object localObject1 = locala.amI;
              if (localObject1 == null)
              {
                localObject1 = null;
                label46:
                localObject2 = locala.amJ;
                if (localObject2 == null) {
                  break label229;
                }
              }
              label229:
              for (Object localObject2 = ((RecyclerView.v)localObject2).aus;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localv.atq);
                  localv.amv.add(locala.amI);
                  localViewPropertyAnimator.translationX(locala.amM - locala.amK);
                  localViewPropertyAnimator.translationY(locala.amN - locala.amL);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new v.7(localv, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localv.amv.add(locala.amJ);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localv.atq).alpha(1.0F).setListener(new v.8(localv, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.v)localObject1).aus;
                break label46;
              }
            }
            this.amy.clear();
            v.this.amr.remove(this.amy);
          }
        };
        if (i == 0) {
          break label483;
        }
        u.a(((a)((ArrayList)localObject1).get(0)).amI.aus, (Runnable)localObject2, ly());
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.amm);
      this.amp.add(localObject1);
      this.amm.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.amz.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.v localv = (RecyclerView.v)localIterator.next();
            v localv1 = v.this;
            View localView = localv.aus;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localv1.ams.add(localv);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localv1.lx()).setListener(new v.5(localv1, localv, localView, localViewPropertyAnimator)).start();
          }
          this.amz.clear();
          v.this.amp.remove(this.amz);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = ly();
      if (j == 0) {
        break label499;
      }
      l2 = this.atp;
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
    for (long l3 = this.atq;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      u.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aus, (Runnable)localObject2, l1 + l2);
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
  
  final void jE()
  {
    if (!isRunning()) {
      lC();
    }
  }
  
  public final void jF()
  {
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
    if (!isRunning()) {
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
  }
  
  static final class a
  {
    public RecyclerView.v amI;
    public RecyclerView.v amJ;
    public int amK;
    public int amL;
    public int amM;
    public int amN;
    
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
      return "ChangeInfo{oldHolder=" + this.amI + ", newHolder=" + this.amJ + ", fromX=" + this.amK + ", fromY=" + this.amL + ", toX=" + this.amM + ", toY=" + this.amN + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.v
 * JD-Core Version:    0.7.0.1
 */