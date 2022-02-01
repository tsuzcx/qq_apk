package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements i, j
{
  final List<b> iXb;
  private HashSet<b> iXc;
  b iXd;
  private m iXe;
  public boolean iXf;
  
  public e()
  {
    AppMethodBeat.i(150535);
    this.iXd = null;
    this.iXe = null;
    this.iXf = false;
    this.iXb = Collections.synchronizedList(new LinkedList());
    this.iXc = new HashSet();
    g.aAg().hqi.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.bcp() > 0))
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
      Log.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150545);
      return;
    }
    if (paramb.iXj == null)
    {
      Log.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.iXj.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.iXk != null) {
        localc.iXk.a(paramb.iXg, paramb.gzl, paramb.iXh, paramb.iXi, localc.iXl);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void td(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.iXb)
    {
      if ((this.iXd != null) || (this.iXb.size() <= 0) || (true == this.iXf))
      {
        if (this.iXd == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh)
        {
          Log.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.iXb.size()), Boolean.valueOf(this.iXf) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.iXd = ((b)this.iXb.remove(0));
      if (this.iXd == null)
      {
        Log.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.iXe = new m(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh, this, paramInt);
    this.iXe.iYW = this.iXd.iXi;
    Log.i("ModelImage.DownloadImgService", "do scene, (" + this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh + ")");
    g.aAg().hqi.a(this.iXe, 0);
    AppMethodBeat.o(150549);
  }
  
  public final boolean C(long paramLong1, long paramLong2)
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
      Log.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(150538);
      return -1;
    }
    b localb = new b(paramLong1, paramLong2, paramInt1);
    localb.iXi = paramInt2;
    if (this.iXc.contains(localb))
    {
      Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.iXd != null) && (localb.equals(this.iXd)))
    {
      if (this.iXd.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.iXb.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.iXb.size()))
    {
      if (((b)this.iXb.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.iXf), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.iXb.size() > 0)) {
      this.iXb.add(0, localb);
    }
    for (;;)
    {
      td(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.iXb.add(localb);
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Object paramObject, a parama)
  {
    AppMethodBeat.i(150537);
    int i = a(paramLong1, paramLong2, 1, paramObject, 2131231628, parama, 0, false);
    AppMethodBeat.o(150537);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(150548);
    if (this.iXe != paramq)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.iXd != null) && (this.iXd.iXj != null))
    {
      Iterator localIterator = new ArrayList(this.iXd.iXj).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.iXk != null) {
          localc.iXk.a(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh, this.iXd.iXi, localc.iXl, paramInt1, paramInt2, paramq);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.iXf = true;
    if (this.iXd != null)
    {
      if (this.iXd != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      Log.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.iXb.size()), Boolean.valueOf(this.iXf) });
      b(this.iXd);
      Object localObject2 = new LinkedList();
      synchronized (this.iXb)
      {
        ((List)localObject2).addAll(this.iXb);
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
            ??? = this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh;
          }
        }
      }
    }
    bco();
    int i = parama.hashCode();
    if (this.iXd == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh)
    {
      Log.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(150539);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.iXd != null) && (this.iXd.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.iXb.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(150539);
      return true;
    }
    AppMethodBeat.o(150539);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt, a parama)
  {
    AppMethodBeat.i(223572);
    if (parama == null)
    {
      Log.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(223572);
      return false;
    }
    b localb2 = new b(paramLong1, paramLong2, paramInt);
    b localb1 = null;
    if ((this.iXd != null) && (this.iXd.equals(localb2))) {
      localb1 = this.iXd;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
      AppMethodBeat.o(223572);
      return true;
      int i = this.iXb.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.iXb.get(i);
      }
    }
    Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
    AppMethodBeat.o(223572);
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
  
  final boolean b(b paramb)
  {
    AppMethodBeat.i(150544);
    if (paramb == null)
    {
      Log.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150544);
      return false;
    }
    Log.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.iXg + ", " + paramb.gzl + ", " + paramb.iXh + ")");
    if ((this.iXd != null) && (this.iXd.equals(paramb)))
    {
      g.aAg().hqi.a(this.iXe);
      this.iXe = null;
      Log.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.iXg), Long.valueOf(paramb.gzl), Integer.valueOf(paramb.iXh) });
      c(this.iXd);
      this.iXd = null;
      td(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.iXb.contains(paramb))
    {
      if (this.iXb.remove(paramb)) {
        c(paramb);
      }
      AppMethodBeat.o(150544);
      return true;
    }
    AppMethodBeat.o(150544);
    return false;
  }
  
  public final void bco()
  {
    AppMethodBeat.i(150546);
    this.iXf = false;
    td(-1);
    AppMethodBeat.o(150546);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150547);
    if (this.iXe != paramq)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.iXd != null) && (this.iXd.iXj != null))
    {
      this.iXc.add(new b(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh));
      Log.i("ModelImage.DownloadImgService", "scene end, (" + this.iXd.iXg + ", " + this.iXd.gzl + ", " + this.iXd.iXh + ")");
      Iterator localIterator = new ArrayList(this.iXd.iXj).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.iXk != null) {
          localc.iXk.a(this.iXd.iXg, this.iXd.gzl, this.iXd.iXh, this.iXd.iXi, localc.iXl, paramInt1, paramInt2, paramString, paramq);
        }
      }
      this.iXd = null;
      this.iXe = null;
      td(-1);
    }
    AppMethodBeat.o(150547);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, q paramq);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, q paramq);
  }
  
  static final class b
  {
    private int aHK = 0;
    public long gzl;
    public long iXg;
    public int iXh;
    public int iXi;
    public List<e.c> iXj;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.iXg = paramLong1;
      this.gzl = paramLong2;
      this.iXh = paramInt;
      this.iXi = 0;
    }
    
    public final boolean a(e.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.iXj == null) {
        this.iXj = Collections.synchronizedList(new LinkedList());
      }
      parama = new e.c(parama, paramObject);
      if (this.iXj.contains(parama))
      {
        Log.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.iXj.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final boolean b(e.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new e.c(parama, null);
      if (this.iXj.contains(parama))
      {
        this.iXj.remove(parama);
        AppMethodBeat.o(150532);
        return true;
      }
      AppMethodBeat.o(150532);
      return false;
    }
    
    public final int bcp()
    {
      AppMethodBeat.i(150533);
      int i = this.iXj.size();
      AppMethodBeat.o(150533);
      return i;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof b))) {}
      do
      {
        return false;
        paramObject = (b)paramObject;
      } while ((paramObject.iXg != this.iXg) || (paramObject.gzl != this.gzl) || (paramObject.iXh != this.iXh));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aHK == 0) {
        this.aHK = (this.iXg + "_" + this.gzl + "_" + this.iXh).hashCode();
      }
      int i = this.aHK;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    e.a iXk;
    Object iXl;
    
    public c(e.a parama, Object paramObject)
    {
      this.iXk = parama;
      this.iXl = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.iXk != paramObject.iXk);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.e
 * JD-Core Version:    0.7.0.1
 */