package com.tencent.mm.modelimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.i;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f
  implements com.tencent.mm.am.h, i
{
  final List<b> oGg;
  private HashSet<b> oGh;
  b oGi;
  private n oGj;
  public boolean oGk;
  
  public f()
  {
    AppMethodBeat.i(150535);
    this.oGi = null;
    this.oGj = null;
    this.oGk = false;
    this.oGg = Collections.synchronizedList(new LinkedList());
    this.oGh = new HashSet();
    com.tencent.mm.kernel.h.baD().mCm.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.bJC() > 0))
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
    if (paramb.oGo == null)
    {
      Log.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.oGo.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.oGp != null) {
        localc.oGp.a(paramb.oGl, paramb.lLT, paramb.oGm, paramb.oGn, localc.oGq);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void wh(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.oGg)
    {
      if ((this.oGi != null) || (this.oGg.size() <= 0) || (true == this.oGk))
      {
        if (this.oGi == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.oGi.oGl + ", " + this.oGi.lLT + ", " + this.oGi.oGm)
        {
          Log.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.oGg.size()), Boolean.valueOf(this.oGk) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.oGi = ((b)this.oGg.remove(0));
      if (this.oGi == null)
      {
        Log.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.oGj = new n(this.oGi.oGl, this.oGi.lLT, this.oGi.oGm, this, paramInt);
    this.oGj.oIb = this.oGi.oGn;
    Log.i("ModelImage.DownloadImgService", "do scene, (" + this.oGi.oGl + ", " + this.oGi.lLT + ", " + this.oGi.oGm + ")");
    com.tencent.mm.kernel.h.baD().mCm.a(this.oGj, 0);
    AppMethodBeat.o(150549);
  }
  
  public final boolean Y(long paramLong1, long paramLong2)
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
    localb.oGn = paramInt2;
    if (this.oGh.contains(localb))
    {
      Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.oGi != null) && (localb.equals(this.oGi)))
    {
      if (this.oGi.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.oGg.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.oGg.size()))
    {
      if (((b)this.oGg.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.oGk), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.oGg.size() > 0)) {
      this.oGg.add(0, localb);
    }
    for (;;)
    {
      wh(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.oGg.add(localb);
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Object paramObject, int paramInt, a parama)
  {
    AppMethodBeat.i(238974);
    paramInt = a(paramLong1, paramLong2, 1, paramObject, paramInt, parama, 0, false);
    AppMethodBeat.o(238974);
    return paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, p paramp)
  {
    AppMethodBeat.i(150548);
    if (this.oGj != paramp)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.oGi != null) && (this.oGi.oGo != null))
    {
      Iterator localIterator = new ArrayList(this.oGi.oGo).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.oGp != null) {
          localc.oGp.a(this.oGi.oGl, this.oGi.lLT, this.oGi.oGm, this.oGi.oGn, localc.oGq, paramInt1, paramInt2, paramp);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.oGk = true;
    if (this.oGi != null)
    {
      if (this.oGi != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    label188:
    int i;
    for (;;)
    {
      Log.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.oGg.size()), Boolean.valueOf(this.oGk) });
      b(this.oGi);
      Object localObject2 = new LinkedList();
      synchronized (this.oGg)
      {
        ((List)localObject2).addAll(this.oGg);
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (b)((Iterator)???).next();
          if (localObject2 != null)
          {
            ((b)localObject2).b(parama);
            a((b)localObject2);
            continue;
            ??? = this.oGi.oGl + ", " + this.oGi.lLT + ", " + this.oGi.oGm;
          }
        }
      }
    }
    if (this.oGi == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.oGi.oGl + ", " + this.oGi.lLT + ", " + this.oGi.oGm)
    {
      Log.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt, a parama)
  {
    AppMethodBeat.i(238978);
    if (parama == null)
    {
      Log.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(238978);
      return false;
    }
    b localb2 = new b(paramLong1, paramLong2, paramInt);
    b localb1 = null;
    if ((this.oGi != null) && (this.oGi.equals(localb2))) {
      localb1 = this.oGi;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
      AppMethodBeat.o(238978);
      return true;
      int i = this.oGg.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.oGg.get(i);
      }
    }
    Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
    AppMethodBeat.o(238978);
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
    Log.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.oGl + ", " + paramb.lLT + ", " + paramb.oGm + ")");
    if ((this.oGi != null) && (this.oGi.equals(paramb)))
    {
      com.tencent.mm.kernel.h.baD().mCm.a(this.oGj);
      this.oGj = null;
      Log.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.oGl), Long.valueOf(paramb.lLT), Integer.valueOf(paramb.oGm) });
      c(this.oGi);
      this.oGi = null;
      wh(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.oGg.contains(paramb))
    {
      if (this.oGg.remove(paramb)) {
        c(paramb);
      }
      AppMethodBeat.o(150544);
      return true;
    }
    AppMethodBeat.o(150544);
    return false;
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(150546);
    this.oGk = false;
    wh(-1);
    AppMethodBeat.o(150546);
  }
  
  public final boolean c(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(150539);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.oGi != null) && (this.oGi.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.oGg.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(150539);
      return true;
    }
    AppMethodBeat.o(150539);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(150547);
    if (this.oGj != paramp)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.oGi != null) && (this.oGi.oGo != null))
    {
      this.oGh.add(new b(this.oGi.oGl, this.oGi.lLT, this.oGi.oGm));
      Log.i("ModelImage.DownloadImgService", "scene end, (" + this.oGi.oGl + ", " + this.oGi.lLT + ", " + this.oGi.oGm + ")");
      Iterator localIterator = new ArrayList(this.oGi.oGo).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.oGp != null) {
          localc.oGp.a(this.oGi.oGl, this.oGi.lLT, this.oGi.oGm, this.oGi.oGn, localc.oGq, paramInt1, paramInt2, paramString, paramp);
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        this.oGh.remove(this.oGi);
      }
      this.oGi = null;
      this.oGj = null;
      wh(-1);
    }
    AppMethodBeat.o(150547);
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, p paramp);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, p paramp);
  }
  
  static final class b
  {
    private int cHb = 0;
    public long lLT;
    public long oGl;
    public int oGm;
    public int oGn;
    public List<f.c> oGo;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.oGl = paramLong1;
      this.lLT = paramLong2;
      this.oGm = paramInt;
      this.oGn = 0;
    }
    
    public final boolean a(f.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.oGo == null) {
        this.oGo = Collections.synchronizedList(new LinkedList());
      }
      parama = new f.c(parama, paramObject);
      if (this.oGo.contains(parama))
      {
        Log.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.oGo.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final boolean b(f.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new f.c(parama, null);
      if (this.oGo.contains(parama))
      {
        this.oGo.remove(parama);
        AppMethodBeat.o(150532);
        return true;
      }
      AppMethodBeat.o(150532);
      return false;
    }
    
    public final int bJC()
    {
      AppMethodBeat.i(150533);
      int i = this.oGo.size();
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
      } while ((paramObject.oGl != this.oGl) || (paramObject.lLT != this.lLT) || (paramObject.oGm != this.oGm));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.cHb == 0) {
        this.cHb = (this.oGl + "_" + this.lLT + "_" + this.oGm).hashCode();
      }
      int i = this.cHb;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    f.a oGp;
    Object oGq;
    
    public c(f.a parama, Object paramObject)
    {
      this.oGp = parama;
      this.oGq = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.oGp != paramObject.oGp);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.f
 * JD-Core Version:    0.7.0.1
 */