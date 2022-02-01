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
  private static TimeInterpolator alX;
  private ArrayList<RecyclerView.w> alY = new ArrayList();
  private ArrayList<RecyclerView.w> alZ = new ArrayList();
  private ArrayList<b> ama = new ArrayList();
  private ArrayList<a> amb = new ArrayList();
  ArrayList<ArrayList<RecyclerView.w>> amc = new ArrayList();
  ArrayList<ArrayList<b>> amd = new ArrayList();
  ArrayList<ArrayList<a>> ame = new ArrayList();
  ArrayList<RecyclerView.w> amf = new ArrayList();
  ArrayList<RecyclerView.w> amg = new ArrayList();
  ArrayList<RecyclerView.w> amh = new ArrayList();
  ArrayList<RecyclerView.w> ami = new ArrayList();
  
  private void a(a parama)
  {
    if (parama.amv != null) {
      a(parama, parama.amv);
    }
    if (parama.amw != null) {
      a(parama, parama.amw);
    }
  }
  
  private void a(List<a> paramList, RecyclerView.w paramw)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      a locala = (a)paramList.get(i);
      if ((a(locala, paramw)) && (locala.amv == null) && (locala.amw == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(a parama, RecyclerView.w paramw)
  {
    if (parama.amw == paramw) {
      parama.amw = null;
    }
    for (;;)
    {
      paramw.auu.setAlpha(1.0F);
      paramw.auu.setTranslationX(0.0F);
      paramw.auu.setTranslationY(0.0F);
      n(paramw);
      return true;
      if (parama.amv != paramw) {
        break;
      }
      parama.amv = null;
    }
    return false;
  }
  
  private void e(RecyclerView.w paramw)
  {
    if (alX == null) {
      alX = new ValueAnimator().getInterpolator();
    }
    paramw.auu.animate().setInterpolator(alX);
    d(paramw);
  }
  
  private static void n(List<RecyclerView.w> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.w)paramList.get(i)).auu.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.w paramw, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramw.auu;
    paramInt1 += (int)paramw.auu.getTranslationX();
    paramInt2 += (int)paramw.auu.getTranslationY();
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
    this.ama.add(new b(paramw, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.w paramw1, RecyclerView.w paramw2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramw1 == paramw2) {
      return a(paramw1, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.amb.add(new a(paramw1, paramw2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.w paramw, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramw, paramList));
  }
  
  public boolean b(RecyclerView.w paramw)
  {
    e(paramw);
    this.alY.add(paramw);
    return true;
  }
  
  public boolean c(RecyclerView.w paramw)
  {
    e(paramw);
    paramw.auu.setAlpha(0.0F);
    this.alZ.add(paramw);
    return true;
  }
  
  public void d(RecyclerView.w paramw)
  {
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
            break label293;
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
        label293:
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
  }
  
  public boolean isRunning()
  {
    return (!this.alZ.isEmpty()) || (!this.amb.isEmpty()) || (!this.ama.isEmpty()) || (!this.alY.isEmpty()) || (!this.amg.isEmpty()) || (!this.amh.isEmpty()) || (!this.amf.isEmpty()) || (!this.ami.isEmpty()) || (!this.amd.isEmpty()) || (!this.amc.isEmpty()) || (!this.ame.isEmpty());
  }
  
  public void ju()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.alY.isEmpty())
    {
      i = 1;
      if (this.ama.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.amb.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.alZ.isEmpty()) {
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
          localViewPropertyAnimator.setListener(null);
          localView.setAlpha(1.0F);
          v.this.w(this.amn);
          v.this.amh.remove(this.amn);
          v.this.jv();
        }
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          v.this.A(this.amn);
        }
      }).start();
    }
    this.alY.clear();
    label266:
    label346:
    long l1;
    label421:
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
          Iterator localIterator = this.amj.iterator();
          while (localIterator.hasNext())
          {
            Object localObject = (v.b)localIterator.next();
            v localv = v.this;
            RecyclerView.w localw = ((v.b)localObject).amB;
            int k = ((v.b)localObject).amx;
            int i = ((v.b)localObject).amy;
            int m = ((v.b)localObject).amz;
            int j = ((v.b)localObject).amA;
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
            localv.amg.add(localw);
            localViewPropertyAnimator.setDuration(localv.ate).setListener(new v.6(localv, localw, k, (View)localObject, i, localViewPropertyAnimator)).start();
          }
          this.amj.clear();
          v.this.amd.remove(this.amj);
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
            Iterator localIterator = this.aml.iterator();
            if (localIterator.hasNext())
            {
              v.a locala = (v.a)localIterator.next();
              v localv = v.this;
              Object localObject1 = locala.amv;
              if (localObject1 == null)
              {
                localObject1 = null;
                label46:
                localObject2 = locala.amw;
                if (localObject2 == null) {
                  break label229;
                }
              }
              label229:
              for (Object localObject2 = ((RecyclerView.w)localObject2).auu;; localObject2 = null)
              {
                if (localObject1 != null)
                {
                  ViewPropertyAnimator localViewPropertyAnimator = ((View)localObject1).animate().setDuration(localv.atf);
                  localv.ami.add(locala.amv);
                  localViewPropertyAnimator.translationX(locala.amz - locala.amx);
                  localViewPropertyAnimator.translationY(locala.amA - locala.amy);
                  localViewPropertyAnimator.alpha(0.0F).setListener(new v.7(localv, locala, localViewPropertyAnimator, (View)localObject1)).start();
                }
                if (localObject2 == null) {
                  break;
                }
                localObject1 = ((View)localObject2).animate();
                localv.ami.add(locala.amw);
                ((ViewPropertyAnimator)localObject1).translationX(0.0F).translationY(0.0F).setDuration(localv.atf).alpha(1.0F).setListener(new v.8(localv, locala, (ViewPropertyAnimator)localObject1, (View)localObject2)).start();
                break;
                localObject1 = ((RecyclerView.w)localObject1).auu;
                break label46;
              }
            }
            this.aml.clear();
            v.this.ame.remove(this.aml);
          }
        };
        if (i == 0) {
          break label483;
        }
        t.a(((a)((ArrayList)localObject1).get(0)).amv.auu, (Runnable)localObject2, lq());
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.alZ);
      this.amc.add(localObject1);
      this.alZ.clear();
      localObject2 = new Runnable()
      {
        public final void run()
        {
          Iterator localIterator = this.amm.iterator();
          while (localIterator.hasNext())
          {
            RecyclerView.w localw = (RecyclerView.w)localIterator.next();
            v localv = v.this;
            View localView = localw.auu;
            ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
            localv.amf.add(localw);
            localViewPropertyAnimator.alpha(1.0F).setDuration(localv.lp()).setListener(new v.5(localv, localw, localView, localViewPropertyAnimator)).start();
          }
          this.amm.clear();
          v.this.amc.remove(this.amm);
        }
      };
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = lq();
      if (j == 0) {
        break label499;
      }
      l2 = this.ate;
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
    for (long l3 = this.atf;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.w)((ArrayList)localObject1).get(0)).auu, (Runnable)localObject2, l1 + l2);
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
  
  final void jv()
  {
    if (!isRunning()) {
      lu();
    }
  }
  
  public final void jw()
  {
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
    if (!isRunning()) {
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
  }
  
  static final class a
  {
    public int amA;
    public RecyclerView.w amv;
    public RecyclerView.w amw;
    public int amx;
    public int amy;
    public int amz;
    
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
      return "ChangeInfo{oldHolder=" + this.amv + ", newHolder=" + this.amw + ", fromX=" + this.amx + ", fromY=" + this.amy + ", toX=" + this.amz + ", toY=" + this.amA + '}';
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.v
 * JD-Core Version:    0.7.0.1
 */