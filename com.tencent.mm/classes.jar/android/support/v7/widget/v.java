package android.support.v7.widget;

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
  private static TimeInterpolator acf;
  private ArrayList<RecyclerView.v> acg = new ArrayList();
  private ArrayList<RecyclerView.v> ach = new ArrayList();
  private ArrayList<v.b> aci = new ArrayList();
  private ArrayList<v.a> acj = new ArrayList();
  ArrayList<ArrayList<RecyclerView.v>> ack = new ArrayList();
  ArrayList<ArrayList<v.b>> acl = new ArrayList();
  ArrayList<ArrayList<v.a>> acm = new ArrayList();
  ArrayList<RecyclerView.v> acn = new ArrayList();
  ArrayList<RecyclerView.v> aco = new ArrayList();
  ArrayList<RecyclerView.v> acp = new ArrayList();
  ArrayList<RecyclerView.v> acq = new ArrayList();
  
  private void a(v.a parama)
  {
    if (parama.acD != null) {
      a(parama, parama.acD);
    }
    if (parama.acE != null) {
      a(parama, parama.acE);
    }
  }
  
  private void a(List<v.a> paramList, RecyclerView.v paramv)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      v.a locala = (v.a)paramList.get(i);
      if ((a(locala, paramv)) && (locala.acD == null) && (locala.acE == null)) {
        paramList.remove(locala);
      }
      i -= 1;
    }
  }
  
  private boolean a(v.a parama, RecyclerView.v paramv)
  {
    if (parama.acE == paramv) {
      parama.acE = null;
    }
    for (;;)
    {
      paramv.aku.setAlpha(1.0F);
      paramv.aku.setTranslationX(0.0F);
      paramv.aku.setTranslationY(0.0F);
      m(paramv);
      return true;
      if (parama.acD != paramv) {
        break;
      }
      parama.acD = null;
    }
    return false;
  }
  
  private void e(RecyclerView.v paramv)
  {
    if (acf == null) {
      acf = new ValueAnimator().getInterpolator();
    }
    paramv.aku.animate().setInterpolator(acf);
    d(paramv);
  }
  
  private static void o(List<RecyclerView.v> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      ((RecyclerView.v)paramList.get(i)).aku.animate().cancel();
      i -= 1;
    }
  }
  
  public boolean a(RecyclerView.v paramv, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = paramv.aku;
    paramInt1 += (int)paramv.aku.getTranslationX();
    paramInt2 += (int)paramv.aku.getTranslationY();
    e(paramv);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if ((i == 0) && (j == 0))
    {
      C(paramv);
      return false;
    }
    if (i != 0) {
      localView.setTranslationX(-i);
    }
    if (j != 0) {
      localView.setTranslationY(-j);
    }
    this.aci.add(new v.b(paramv, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramv1 == paramv2) {
      return a(paramv1, paramInt1, paramInt2, paramInt3, paramInt4);
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
    this.acj.add(new v.a(paramv1, paramv2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    return (!paramList.isEmpty()) || (super.a(paramv, paramList));
  }
  
  public boolean b(RecyclerView.v paramv)
  {
    e(paramv);
    this.acg.add(paramv);
    return true;
  }
  
  public boolean c(RecyclerView.v paramv)
  {
    e(paramv);
    paramv.aku.setAlpha(0.0F);
    this.ach.add(paramv);
    return true;
  }
  
  public void d(RecyclerView.v paramv)
  {
    View localView = paramv.aku;
    localView.animate().cancel();
    int i = this.aci.size() - 1;
    while (i >= 0)
    {
      if (((v.b)this.aci.get(i)).acJ == paramv)
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
          if (((v.b)localArrayList.get(j)).acJ != paramv) {
            break label293;
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
        label293:
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
  }
  
  public void hA()
  {
    int i;
    int j;
    label24:
    int k;
    if (!this.acg.isEmpty())
    {
      i = 1;
      if (this.aci.isEmpty()) {
        break label72;
      }
      j = 1;
      if (this.acj.isEmpty()) {
        break label77;
      }
      k = 1;
      label36:
      if (this.ach.isEmpty()) {
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
    Object localObject1 = this.acg.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
      View localView = ((RecyclerView.v)localObject2).aku;
      ViewPropertyAnimator localViewPropertyAnimator = localView.animate();
      this.acp.add(localObject2);
      localViewPropertyAnimator.setDuration(this.ajg).alpha(0.0F).setListener(new v.4(this, (RecyclerView.v)localObject2, localViewPropertyAnimator, localView)).start();
    }
    this.acg.clear();
    label266:
    label346:
    long l1;
    label421:
    long l2;
    if (j != 0)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.aci);
      this.acl.add(localObject1);
      this.aci.clear();
      localObject2 = new v.1(this, (ArrayList)localObject1);
      if (i != 0) {
        t.a(((v.b)((ArrayList)localObject1).get(0)).acJ.aku, (Runnable)localObject2, this.ajg);
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
        localObject2 = new v.2(this, (ArrayList)localObject1);
        if (i == 0) {
          break label483;
        }
        t.a(((v.a)((ArrayList)localObject1).get(0)).acD.aku, (Runnable)localObject2, this.ajg);
      }
      if (m == 0) {
        break label491;
      }
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).addAll(this.ach);
      this.ack.add(localObject1);
      this.ach.clear();
      localObject2 = new v.3(this, (ArrayList)localObject1);
      if ((i == 0) && (j == 0) && (k == 0)) {
        break label511;
      }
      if (i == 0) {
        break label493;
      }
      l1 = this.ajg;
      if (j == 0) {
        break label499;
      }
      l2 = this.ajh;
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
    for (long l3 = this.aji;; l3 = 0L)
    {
      l2 = Math.max(l2, l3);
      t.a(((RecyclerView.v)((ArrayList)localObject1).get(0)).aku, (Runnable)localObject2, l1 + l2);
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
  
  final void hB()
  {
    if (!isRunning()) {
      jw();
    }
  }
  
  public final void hC()
  {
    int i = this.aci.size() - 1;
    Object localObject1;
    Object localObject2;
    while (i >= 0)
    {
      localObject1 = (v.b)this.aci.get(i);
      localObject2 = ((v.b)localObject1).acJ.aku;
      ((View)localObject2).setTranslationY(0.0F);
      ((View)localObject2).setTranslationX(0.0F);
      C(((v.b)localObject1).acJ);
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
      a((v.a)this.acj.get(i));
      i -= 1;
    }
    this.acj.clear();
    if (!isRunning()) {
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
        localObject2 = (v.b)((ArrayList)localObject1).get(j);
        View localView = ((v.b)localObject2).acJ.aku;
        localView.setTranslationY(0.0F);
        localView.setTranslationX(0.0F);
        C(((v.b)localObject2).acJ);
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
        a((v.a)((ArrayList)localObject1).get(j));
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
  }
  
  public boolean isRunning()
  {
    return (!this.ach.isEmpty()) || (!this.acj.isEmpty()) || (!this.aci.isEmpty()) || (!this.acg.isEmpty()) || (!this.aco.isEmpty()) || (!this.acp.isEmpty()) || (!this.acn.isEmpty()) || (!this.acq.isEmpty()) || (!this.acl.isEmpty()) || (!this.ack.isEmpty()) || (!this.acm.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.v
 * JD-Core Version:    0.7.0.1
 */