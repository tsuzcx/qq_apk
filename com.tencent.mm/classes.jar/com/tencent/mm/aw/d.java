package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.al.g, h
{
  final List<b> hfY;
  private HashSet<b> hfZ;
  b hga;
  private k hgb;
  public boolean hgc;
  
  public d()
  {
    AppMethodBeat.i(150535);
    this.hga = null;
    this.hgb = null;
    this.hgc = false;
    this.hfY = Collections.synchronizedList(new LinkedList());
    this.hfZ = new HashSet();
    com.tencent.mm.kernel.g.afA().gcy.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.ayg() > 0))
    {
      AppMethodBeat.o(150542);
      return false;
    }
    boolean bool = b(paramb);
    AppMethodBeat.o(150542);
    return bool;
  }
  
  private static void c(b paramb)
  {
    AppMethodBeat.i(150545);
    if (paramb == null)
    {
      ad.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150545);
      return;
    }
    if (paramb.hgg == null)
    {
      ad.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.hgg.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hgh != null) {
        localc.hgh.a(paramb.hgd, paramb.fve, paramb.hge, paramb.hgf, localc.hgi);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void nV(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.hfY)
    {
      if ((this.hga != null) || (this.hfY.size() <= 0) || (true == this.hgc))
      {
        if (this.hga == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.hga.hgd + ", " + this.hga.fve + ", " + this.hga.hge)
        {
          ad.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.hfY.size()), Boolean.valueOf(this.hgc) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.hga = ((b)this.hfY.remove(0));
      if (this.hga == null)
      {
        ad.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.hgb = new k(this.hga.hgd, this.hga.fve, this.hga.hge, this, paramInt);
    this.hgb.hhQ = this.hga.hgf;
    ad.i("ModelImage.DownloadImgService", "do scene, (" + this.hga.hgd + ", " + this.hga.fve + ", " + this.hga.hge + ")");
    com.tencent.mm.kernel.g.afA().gcy.a(this.hgb, 0);
    AppMethodBeat.o(150549);
  }
  
  public final boolean A(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150543);
    boolean bool = b(new b(paramLong1, paramLong2, 1));
    AppMethodBeat.o(150543);
    return bool;
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150538);
    if (parama == null)
    {
      ad.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(150538);
      return -1;
    }
    b localb = new b(paramLong1, paramLong2, paramInt1);
    localb.hgf = paramInt2;
    if (this.hfZ.contains(localb))
    {
      ad.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.hga != null) && (localb.equals(this.hga)))
    {
      if (this.hga.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.hfY.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.hfY.size()))
    {
      if (((b)this.hfY.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.hgc), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.hfY.size() > 0)) {
      this.hfY.add(0, localb);
    }
    for (;;)
    {
      nV(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.hfY.add(localb);
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Object paramObject, a parama)
  {
    AppMethodBeat.i(150537);
    int i = a(paramLong1, paramLong2, 1, paramObject, 2131231564, parama, 0, false);
    AppMethodBeat.o(150537);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(150548);
    if (this.hgb != paramn)
    {
      ad.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.hga != null) && (this.hga.hgg != null))
    {
      Iterator localIterator = new ArrayList(this.hga.hgg).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hgh != null) {
          localc.hgh.a(this.hga.hgd, this.hga.fve, this.hga.hge, this.hga.hgf, localc.hgi, paramInt1, paramInt2, paramn);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.hgc = true;
    if (this.hga != null)
    {
      if (this.hga != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      ad.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.hfY.size()), Boolean.valueOf(this.hgc) });
      b(this.hga);
      Object localObject2 = new LinkedList();
      synchronized (this.hfY)
      {
        ((List)localObject2).addAll(this.hfY);
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (b)((Iterator)???).next();
          if (localObject2 != null)
          {
            ((b)localObject2).b(parama);
            a((b)localObject2);
            continue;
            label188:
            ??? = this.hga.hgd + ", " + this.hga.fve + ", " + this.hga.hge;
          }
        }
      }
    }
    ayf();
    int i = parama.hashCode();
    if (this.hga == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.hga.hgd + ", " + this.hga.fve + ", " + this.hga.hge)
    {
      ad.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(150539);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.hga != null) && (this.hga.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.hfY.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(150539);
      return true;
    }
    AppMethodBeat.o(150539);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama)
  {
    AppMethodBeat.i(150536);
    if (a(paramLong1, paramLong2, paramInt1, paramObject, paramInt2, parama, -1, false) >= 0)
    {
      AppMethodBeat.o(150536);
      return true;
    }
    AppMethodBeat.o(150536);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, a parama)
  {
    AppMethodBeat.i(150540);
    b localb2 = new b(paramLong1, paramLong2, 1);
    b localb1 = null;
    if ((this.hga != null) && (this.hga.equals(localb2))) {
      localb1 = this.hga;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      AppMethodBeat.o(150540);
      return true;
      int i = this.hfY.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.hfY.get(i);
      }
    }
    ad.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    AppMethodBeat.o(150540);
    return false;
  }
  
  public final void ayf()
  {
    AppMethodBeat.i(150546);
    this.hgc = false;
    nV(-1);
    AppMethodBeat.o(150546);
  }
  
  final boolean b(b paramb)
  {
    AppMethodBeat.i(150544);
    if (paramb == null)
    {
      ad.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150544);
      return false;
    }
    ad.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.hgd + ", " + paramb.fve + ", " + paramb.hge + ")");
    if ((this.hga != null) && (this.hga.equals(paramb)))
    {
      com.tencent.mm.kernel.g.afA().gcy.a(this.hgb);
      this.hgb = null;
      ad.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.hgd), Long.valueOf(paramb.fve), Integer.valueOf(paramb.hge) });
      c(this.hga);
      this.hga = null;
      nV(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.hfY.contains(paramb))
    {
      if (this.hfY.remove(paramb)) {
        c(paramb);
      }
      AppMethodBeat.o(150544);
      return true;
    }
    AppMethodBeat.o(150544);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(150547);
    if (this.hgb != paramn)
    {
      ad.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.hga != null) && (this.hga.hgg != null))
    {
      this.hfZ.add(new b(this.hga.hgd, this.hga.fve, this.hga.hge));
      ad.i("ModelImage.DownloadImgService", "scene end, (" + this.hga.hgd + ", " + this.hga.fve + ", " + this.hga.hge + ")");
      Iterator localIterator = new ArrayList(this.hga.hgg).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hgh != null) {
          localc.hgh.a(this.hga.hgd, this.hga.fve, this.hga.hge, this.hga.hgf, localc.hgi, paramInt1, paramInt2, paramString, paramn);
        }
      }
      this.hga = null;
      this.hgb = null;
      nV(-1);
    }
    AppMethodBeat.o(150547);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn);
  }
  
  static final class b
  {
    private int aFj = 0;
    public long fve;
    public long hgd;
    public int hge;
    public int hgf;
    public List<d.c> hgg;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.hgd = paramLong1;
      this.fve = paramLong2;
      this.hge = paramInt;
      this.hgf = 0;
    }
    
    public final boolean a(d.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.hgg == null) {
        this.hgg = Collections.synchronizedList(new LinkedList());
      }
      parama = new d.c(parama, paramObject);
      if (this.hgg.contains(parama))
      {
        ad.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.hgg.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final int ayg()
    {
      AppMethodBeat.i(150533);
      int i = this.hgg.size();
      AppMethodBeat.o(150533);
      return i;
    }
    
    public final boolean b(d.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new d.c(parama, null);
      if (this.hgg.contains(parama))
      {
        this.hgg.remove(parama);
        AppMethodBeat.o(150532);
        return true;
      }
      AppMethodBeat.o(150532);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof b))) {}
      do
      {
        return false;
        paramObject = (b)paramObject;
      } while ((paramObject.hgd != this.hgd) || (paramObject.fve != this.fve) || (paramObject.hge != this.hge));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aFj == 0) {
        this.aFj = (this.hgd + "_" + this.fve + "_" + this.hge).hashCode();
      }
      int i = this.aFj;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    d.a hgh;
    Object hgi;
    
    public c(d.a parama, Object paramObject)
    {
      this.hgh = parama;
      this.hgi = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.hgh != paramObject.hgh);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.d
 * JD-Core Version:    0.7.0.1
 */