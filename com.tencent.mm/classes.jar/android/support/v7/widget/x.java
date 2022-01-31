package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class x
  extends ar
{
  private static TimeInterpolator abu;
  ArrayList<ArrayList<x.b>> abA = new ArrayList();
  ArrayList<ArrayList<x.a>> abB = new ArrayList();
  ArrayList<RecyclerView.v> abC = new ArrayList();
  ArrayList<RecyclerView.v> abD = new ArrayList();
  ArrayList<RecyclerView.v> abE = new ArrayList();
  ArrayList<RecyclerView.v> abF = new ArrayList();
  private ArrayList<RecyclerView.v> abv = new ArrayList();
  private ArrayList<RecyclerView.v> abw = new ArrayList();
  private ArrayList<x.b> abx = new ArrayList();
  private ArrayList<x.a> aby = new ArrayList();
  ArrayList<ArrayList<RecyclerView.v>> abz = new ArrayList();
  
  private void a(x.a parama)
  {
    if (parama.abS != null) {
      a(parama, parama.abS);
    }
    if (parama.abT != null) {
      a(parama, parama.abT);
    }
  }
  
  private void a(List<x.a> paramList, RecyclerView.v paramv)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      x.a locala = (x.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.abS == null) && (locala.abT == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(x.a parama, RecyclerView.v paramv)
  {
    if (parama.abT == paramv) {
      parama.abT = null;
    }
    for (;;)
    {
      paramv.aie.setAlpha(1.0F);
      paramv.aie.setTranslationX(0.0F);
      paramv.aie.setTranslationY(0.0F);
      l(paramv);
      return true;
      if (parama.abS != paramv) {
        break;
      }
      parama.abS = null;
    }
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    if (abu == null) {
      abu = new ValueAnimator().getInterpolator();
    }
    paramv.aie.animate().setInterpolator(abu);
    d(paramv);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aie.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.aie;
    paramInt1 += (int)paramv.aie.getTranslationX();
    paramInt2 += (int)paramv.aie.getTranslationY();
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
    this.abx.add(new x.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    float f1 = paramv1.aie.getTranslationX();
    float f2 = paramv1.aie.getTranslationY();
    float f3 = paramv1.aie.getAlpha();
    e(paramv1);
    int i = (int)(paramInt3 - paramInt1 - f1);
    int j = (int)(paramInt4 - paramInt2 - f2);
    paramv1.aie.setTranslationX(f1);
    paramv1.aie.setTranslationY(f2);
    paramv1.aie.setAlpha(f3);
    if (paramv2 != null)
    {
      e(paramv2);
      paramv2.aie.setTranslationX(-i);
      paramv2.aie.setTranslationY(-j);
      paramv2.aie.setAlpha(0.0F);
    }
    this.aby.add(new x.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    e(paramv);
    this.abv.add(paramv);
    return true;
  }
  
  public boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    paramv.aie.setAlpha(0.0F);
    this.abw.add(paramv);
    return true;
  }
  
  public void d(RecyclerView.v paramv)
  {
    View localView = paramv.aie;
    localView.animate().cancel();
    int i = this.abx.size() - 1;
    while (i >= 0)
    {
      if (((x.b)this.abx.get(i)).abY == paramv)
      {
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(paramv);
        this.abx.remove(i);
      }
      i -= 1;
    }
    a(this.aby, paramv);
    if (this.abv.remove(paramv))
    {
      localView.setAlpha(1.0F);
      w(paramv);
    }
    if (this.abw.remove(paramv))
    {
      localView.setAlpha(1.0F);
      l(paramv);
    }
    i = this.abB.size() - 1;
    ArrayList localArrayList;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.abB.get(i);
      a(localArrayList, paramv);
      if (localArrayList.isEmpty()) {
        this.abB.remove(i);
      }
      i -= 1;
    }
    i = this.abA.size() - 1;
    if (i >= 0)
    {
      localArrayList = (ArrayList)this.abA.get(i);
      int j = localArrayList.size() - 1;
      for (;;)
      {
        if (j >= 0)
        {
          if (((x.b)localArrayList.get(j)).abY != paramv) {
            break label293;
          }
          localView.setTranslationY(0.0F);
          localView.setTranslationX(0.0F);
          x(paramv);
          localArrayList.remove(j);
          if (localArrayList.isEmpty()) {
            this.abA.remove(i);
          }
        }
        i -= 1;
        break;
        label293:
        j -= 1;
      }
    }
    i = this.abz.size() - 1;
    while (i >= 0)
    {
      localArrayList = (ArrayList)this.abz.get(i);
      if (localArrayList.remove(paramv))
      {
        localView.setAlpha(1.0F);
        l(paramv);
        if (localArrayList.isEmpty()) {
          this.abz.remove(i);
        }
      }
      i -= 1;
    }
    this.abE.remove(paramv);
    this.abC.remove(paramv);
    this.abF.remove(paramv);
    this.abD.remove(paramv);
    gB();
  }
  
  public void gA()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.abv.isEmpty())
    {
      i = 1;
      if (this.abx.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.aby.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.abw.isEmpty()) {
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
    Object localObject1 = this.abv.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      View localView = ((RecyclerView.v)localObject2).aie;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.abE.add(localObject2);
      localViewPropertyAnimator.setDuration(this.agQ).alpha(0.0F).setListener(new x.4(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
    }
    this.abv.clear();
    label266:
    label346:
    long l1;
    label421:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.abx);
      this.abA.add(localObject1);
      this.abx.clear();
      localObject2 = new x.1(this, (ArrayList)localObject1);
      if (i != 0) {
        q.a(((x.b)((ArrayList)localObject1).get(0)).abY.aie, (Runnable)localObject2, this.agQ);
      }
    }
    else
    {
      if (k != 0)
      {
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).addAll(this.aby);
        this.abB.add(localObject1);
        this.aby.clear();
        localObject2 = new x.2(this, (ArrayList)localObject1);
        if (i == 0) {
          break label483;
        }
        q.a(((x.a)((ArrayList)localObject1).get(0)).abS.aie, (Runnable)localObject2, this.agQ);
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.abw);
      this.abz.add(localObject1);
      this.abw.clear();
      localObject2 = new x.3(this, (ArrayList)localObject1);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = this.agQ;
      if (j == 0) {
        break label499;
      }
      l2 = this.agR;
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
    for (long l3 = this.agS;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      q.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aie, (Runnable)localObject2, l1 + l2);
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
  
  final void gB()
  {
    if (!isRunning()) {
      hP();
    }
  }
  
  public final void gC()
  {
    int i = this.abx.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (x.b)this.abx.get(i);
      localObject2 = ((x.b)localObject1).abY.aie;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      x(((x.b)localObject1).abY);
      this.abx.remove(i);
      i -= 1;
    }
    i = this.abv.size() - 1;
    while (i >= 0)
    {
      w((RecyclerView.v)this.abv.get(i));
      this.abv.remove(i);
      i -= 1;
    }
    i = this.abw.size() - 1;
    while (i >= 0)
    {
      localObject1 = (RecyclerView.v)this.abw.get(i);
      ((RecyclerView.v)localObject1).aie.setAlpha(1.0F);
      l((RecyclerView.v)localObject1);
      this.abw.remove(i);
      i -= 1;
    }
    i = this.aby.size() - 1;
    while (i >= 0)
    {
      a((x.a)this.aby.get(i));
      i -= 1;
    }
    this.aby.clear();
    if (!isRunning()) {
      return;
    }
    i = this.abA.size() - 1;
    int j;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abA.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (x.b)((ArrayList)localObject1).get(j);
        View localView = ((x.b)localObject2).abY.aie;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        x(((x.b)localObject2).abY);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.abA.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.abz.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abz.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        localObject2 = (RecyclerView.v)((ArrayList)localObject1).get(j);
        ((RecyclerView.v)localObject2).aie.setAlpha(1.0F);
        l((RecyclerView.v)localObject2);
        ((ArrayList)localObject1).remove(j);
        if (((ArrayList)localObject1).isEmpty()) {
          this.abz.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    i = this.abB.size() - 1;
    while (i >= 0)
    {
      localObject1 = (ArrayList)this.abB.get(i);
      j = ((ArrayList)localObject1).size() - 1;
      while (j >= 0)
      {
        a((x.a)((ArrayList)localObject1).get(j));
        if (((ArrayList)localObject1).isEmpty()) {
          this.abB.remove(localObject1);
        }
        j -= 1;
      }
      i -= 1;
    }
    o(this.abE);
    o(this.abD);
    o(this.abC);
    o(this.abF);
    hP();
  }
  
  public boolean isRunning()
  {
    return (!this.abw.isEmpty()) || (!this.aby.isEmpty()) || (!this.abx.isEmpty()) || (!this.abv.isEmpty()) || (!this.abD.isEmpty()) || (!this.abE.isEmpty()) || (!this.abC.isEmpty()) || (!this.abF.isEmpty()) || (!this.abA.isEmpty()) || (!this.abz.isEmpty()) || (!this.abB.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.x
 * JD-Core Version:    0.7.0.1
 */