package com.tencent.mm.as;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements f, com.tencent.mm.ah.g
{
  List<d.b> ene = new LinkedList();
  private HashSet<d.b> enf = new HashSet();
  d.b eng = null;
  private k enh = null;
  public boolean eni = false;
  
  public d()
  {
    com.tencent.mm.kernel.g.DO().dJT.a(109, this);
  }
  
  private boolean a(d.b paramb)
  {
    if ((paramb == null) || (paramb.enm.size() > 0)) {
      return false;
    }
    return b(paramb);
  }
  
  private static void c(d.b paramb)
  {
    if (paramb == null) {
      y.e("ModelImage.DownloadImgService", "task is null");
    }
    for (;;)
    {
      return;
      if (paramb.enm == null)
      {
        y.e("ModelImage.DownloadImgService", "task callback list is null");
        return;
      }
      Iterator localIterator = paramb.enm.iterator();
      while (localIterator.hasNext())
      {
        d.c localc = (d.c)localIterator.next();
        if (localc.enn != null) {
          localc.enn.a(paramb.enj, paramb.dqO, paramb.enk, paramb.enl, localc.eno);
        }
      }
    }
  }
  
  private void iz(int paramInt)
  {
    if ((this.eng != null) || (this.ene.size() <= 0) || (true == this.eni))
    {
      if (this.eng == null) {}
      for (String str = "mCurTaskInfo is null";; str = this.eng.enj + ", " + this.eng.dqO + ", " + this.eng.enk)
      {
        y.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.ene.size()), Boolean.valueOf(this.eni) });
        return;
      }
    }
    this.eng = ((d.b)this.ene.get(0));
    this.ene.remove(0);
    this.enh = new k(this.eng.enj, this.eng.dqO, this.eng.enk, this, paramInt);
    this.enh.eoU = this.eng.enl;
    y.i("ModelImage.DownloadImgService", "do scene, (" + this.eng.enj + ", " + this.eng.dqO + ", " + this.eng.enk + ")");
    com.tencent.mm.kernel.g.DO().dJT.a(this.enh, 0);
  }
  
  public final void Op()
  {
    this.eni = false;
    iz(-1);
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, d.a parama, int paramInt3)
  {
    if (parama == null)
    {
      y.e("ModelImage.DownloadImgService", "listener is null");
      return -1;
    }
    d.b localb = new d.b(paramLong1, paramLong2, paramInt1);
    localb.enl = paramInt2;
    if (this.enf.contains(localb))
    {
      y.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      return -2;
    }
    if ((this.eng != null) && (localb.equals(this.eng)))
    {
      if (this.eng.a(parama, paramObject)) {
        return 0;
      }
      return -3;
    }
    paramInt2 = this.ene.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.ene.size()))
    {
      if (((d.b)this.ene.get(paramInt2)).a(parama, paramObject)) {
        return 0;
      }
      return -4;
    }
    y.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.eni), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    this.ene.add(localb);
    iz(paramInt3);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    if (this.enh != paramm) {
      y.d("ModelImage.DownloadImgService", "scene changed");
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.eng.enm.iterator();
      while (localIterator.hasNext())
      {
        d.c localc = (d.c)localIterator.next();
        if (localc.enn != null) {
          localc.enn.a(this.eng.enj, this.eng.dqO, this.eng.enk, this.eng.enl, localc.eno, paramInt1, paramInt2, paramm);
        }
      }
    }
  }
  
  public final void a(d.a parama)
  {
    if (parama == null)
    {
      y.e("ModelImage.DownloadImgService", "listener is null");
      return;
    }
    y.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.eni = true;
    if (this.eng != null) {
      if (this.eng != null) {
        break label191;
      }
    }
    Object localObject2;
    label191:
    for (Object localObject1 = "mCurTaskInfo is null";; localObject1 = this.eng.enj + ", " + this.eng.dqO + ", " + this.eng.enk)
    {
      y.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { localObject1, Integer.valueOf(this.ene.size()), Boolean.valueOf(this.eni) });
      this.eng.b(parama);
      localObject1 = this.eng;
      if (((d.b)localObject1).enm != null) {
        ((d.b)localObject1).enm.clear();
      }
      a(this.eng);
      localObject1 = new LinkedList();
      localObject2 = this.ene.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((d.b)((Iterator)localObject2).next());
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (d.b)((Iterator)localObject1).next();
      ((d.b)localObject2).b(parama);
      a((d.b)localObject2);
    }
    Op();
    int i = parama.hashCode();
    if (this.eng == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.eng.enj + ", " + this.eng.dqO + ", " + this.eng.enk)
    {
      y.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    d.b localb = new d.b(paramLong1, paramLong2, paramInt);
    if ((this.eng != null) && (this.eng.equals(localb))) {}
    while (this.ene.indexOf(localb) >= 0) {
      return true;
    }
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, d.a parama)
  {
    return a(paramLong1, paramLong2, paramInt1, paramObject, paramInt2, parama, -1) >= 0;
  }
  
  public final boolean a(long paramLong1, long paramLong2, d.a parama)
  {
    if (parama == null)
    {
      y.e("ModelImage.DownloadImgService", "listener is null");
      return false;
    }
    d.b localb2 = new d.b(paramLong1, paramLong2, 1);
    d.b localb1 = null;
    if ((this.eng != null) && (this.eng.equals(localb2))) {
      localb1 = this.eng;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      y.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      return true;
      int i = this.ene.indexOf(localb2);
      if (-1 != i) {
        localb1 = (d.b)this.ene.get(i);
      }
    }
    y.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    return false;
  }
  
  final boolean b(d.b paramb)
  {
    if (paramb == null) {
      y.e("ModelImage.DownloadImgService", "task is null");
    }
    do
    {
      return false;
      y.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.enj + ", " + paramb.dqO + ", " + paramb.enk + ")");
      if ((this.eng != null) && (this.eng.equals(paramb)))
      {
        com.tencent.mm.kernel.g.DO().dJT.c(this.enh);
        this.enh = null;
        y.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.enj), Long.valueOf(paramb.dqO), Integer.valueOf(paramb.enk) });
        c(this.eng);
        this.eng = null;
        iz(-1);
        return true;
      }
    } while (!this.ene.contains(paramb));
    int i = this.ene.indexOf(paramb);
    paramb = (d.b)this.ene.get(i);
    if (paramb != null)
    {
      this.ene.remove(paramb);
      c(paramb);
    }
    return true;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if (this.enh != paramm)
    {
      y.d("ModelImage.DownloadImgService", "scene changed");
      return;
    }
    this.enf.add(new d.b(this.eng.enj, this.eng.dqO, this.eng.enk));
    y.i("ModelImage.DownloadImgService", "scene end, (" + this.eng.enj + ", " + this.eng.dqO + ", " + this.eng.enk + ")");
    Iterator localIterator = this.eng.enm.iterator();
    while (localIterator.hasNext())
    {
      d.c localc = (d.c)localIterator.next();
      if (localc.enn != null) {
        localc.enn.a(this.eng.enj, this.eng.dqO, this.eng.enk, this.eng.enl, localc.eno, paramInt1, paramInt2, paramString, paramm);
      }
    }
    this.eng = null;
    this.enh = null;
    iz(-1);
  }
  
  public final boolean q(long paramLong1, long paramLong2)
  {
    return b(new d.b(paramLong1, paramLong2, 1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.d
 * JD-Core Version:    0.7.0.1
 */