package com.tencent.mm.aw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
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

public final class e
  implements f, com.tencent.mm.al.g
{
  final List<b> hZl;
  private HashSet<b> hZm;
  b hZn;
  private m hZo;
  public boolean hZp;
  
  public e()
  {
    AppMethodBeat.i(150535);
    this.hZn = null;
    this.hZo = null;
    this.hZp = false;
    this.hZl = Collections.synchronizedList(new LinkedList());
    this.hZm = new HashSet();
    com.tencent.mm.kernel.g.ajB().gAO.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.aIe() > 0))
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
    if (paramb.hZt == null)
    {
      ad.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.hZt.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hZu != null) {
        localc.hZu.a(paramb.hZq, paramb.fRY, paramb.hZr, paramb.hZs, localc.hZv);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void pl(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.hZl)
    {
      if ((this.hZn != null) || (this.hZl.size() <= 0) || (true == this.hZp))
      {
        if (this.hZn == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.hZn.hZq + ", " + this.hZn.fRY + ", " + this.hZn.hZr)
        {
          ad.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.hZl.size()), Boolean.valueOf(this.hZp) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.hZn = ((b)this.hZl.remove(0));
      if (this.hZn == null)
      {
        ad.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.hZo = new m(this.hZn.hZq, this.hZn.fRY, this.hZn.hZr, this, paramInt);
    this.hZo.ibh = this.hZn.hZs;
    ad.i("ModelImage.DownloadImgService", "do scene, (" + this.hZn.hZq + ", " + this.hZn.fRY + ", " + this.hZn.hZr + ")");
    com.tencent.mm.kernel.g.ajB().gAO.a(this.hZo, 0);
    AppMethodBeat.o(150549);
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
    localb.hZs = paramInt2;
    if (this.hZm.contains(localb))
    {
      ad.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.hZn != null) && (localb.equals(this.hZn)))
    {
      if (this.hZn.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.hZl.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.hZl.size()))
    {
      if (((b)this.hZl.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.hZp), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.hZl.size() > 0)) {
      this.hZl.add(0, localb);
    }
    for (;;)
    {
      pl(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.hZl.add(localb);
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
    if (this.hZo != paramn)
    {
      ad.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.hZn != null) && (this.hZn.hZt != null))
    {
      Iterator localIterator = new ArrayList(this.hZn.hZt).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hZu != null) {
          localc.hZu.a(this.hZn.hZq, this.hZn.fRY, this.hZn.hZr, this.hZn.hZs, localc.hZv, paramInt1, paramInt2, paramn);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.hZp = true;
    if (this.hZn != null)
    {
      if (this.hZn != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      ad.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.hZl.size()), Boolean.valueOf(this.hZp) });
      b(this.hZn);
      Object localObject2 = new LinkedList();
      synchronized (this.hZl)
      {
        ((List)localObject2).addAll(this.hZl);
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
            ??? = this.hZn.hZq + ", " + this.hZn.fRY + ", " + this.hZn.hZr;
          }
        }
      }
    }
    aId();
    int i = parama.hashCode();
    if (this.hZn == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.hZn.hZq + ", " + this.hZn.fRY + ", " + this.hZn.hZr)
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
    if ((this.hZn != null) && (this.hZn.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.hZl.indexOf(localb) >= 0)
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
    if ((this.hZn != null) && (this.hZn.equals(localb2))) {
      localb1 = this.hZn;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      ad.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      AppMethodBeat.o(150540);
      return true;
      int i = this.hZl.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.hZl.get(i);
      }
    }
    ad.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    AppMethodBeat.o(150540);
    return false;
  }
  
  public final void aId()
  {
    AppMethodBeat.i(150546);
    this.hZp = false;
    pl(-1);
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
    ad.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.hZq + ", " + paramb.fRY + ", " + paramb.hZr + ")");
    if ((this.hZn != null) && (this.hZn.equals(paramb)))
    {
      com.tencent.mm.kernel.g.ajB().gAO.a(this.hZo);
      this.hZo = null;
      ad.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.hZq), Long.valueOf(paramb.fRY), Integer.valueOf(paramb.hZr) });
      c(this.hZn);
      this.hZn = null;
      pl(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.hZl.contains(paramb))
    {
      if (this.hZl.remove(paramb)) {
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
    if (this.hZo != paramn)
    {
      ad.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.hZn != null) && (this.hZn.hZt != null))
    {
      this.hZm.add(new b(this.hZn.hZq, this.hZn.fRY, this.hZn.hZr));
      ad.i("ModelImage.DownloadImgService", "scene end, (" + this.hZn.hZq + ", " + this.hZn.fRY + ", " + this.hZn.hZr + ")");
      Iterator localIterator = new ArrayList(this.hZn.hZt).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hZu != null) {
          localc.hZu.a(this.hZn.hZq, this.hZn.fRY, this.hZn.hZr, this.hZn.hZs, localc.hZv, paramInt1, paramInt2, paramString, paramn);
        }
      }
      this.hZn = null;
      this.hZo = null;
      pl(-1);
    }
    AppMethodBeat.o(150547);
  }
  
  public final boolean x(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(150543);
    boolean bool = b(new b(paramLong1, paramLong2, 1));
    AppMethodBeat.o(150543);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, n paramn);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, n paramn);
  }
  
  static final class b
  {
    private int aHQ = 0;
    public long fRY;
    public long hZq;
    public int hZr;
    public int hZs;
    public List<e.c> hZt;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.hZq = paramLong1;
      this.fRY = paramLong2;
      this.hZr = paramInt;
      this.hZs = 0;
    }
    
    public final boolean a(e.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.hZt == null) {
        this.hZt = Collections.synchronizedList(new LinkedList());
      }
      parama = new e.c(parama, paramObject);
      if (this.hZt.contains(parama))
      {
        ad.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.hZt.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final int aIe()
    {
      AppMethodBeat.i(150533);
      int i = this.hZt.size();
      AppMethodBeat.o(150533);
      return i;
    }
    
    public final boolean b(e.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new e.c(parama, null);
      if (this.hZt.contains(parama))
      {
        this.hZt.remove(parama);
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
      } while ((paramObject.hZq != this.hZq) || (paramObject.fRY != this.fRY) || (paramObject.hZr != this.hZr));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aHQ == 0) {
        this.aHQ = (this.hZq + "_" + this.fRY + "_" + this.hZr).hashCode();
      }
      int i = this.aHQ;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    e.a hZu;
    Object hZv;
    
    public c(e.a parama, Object paramObject)
    {
      this.hZu = parama;
      this.hZv = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.hZu != paramObject.hZu);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.e
 * JD-Core Version:    0.7.0.1
 */