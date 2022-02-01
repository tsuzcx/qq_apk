package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.h;
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
  public boolean lNA;
  final List<b> lNw;
  private HashSet<b> lNx;
  b lNy;
  private m lNz;
  
  public e()
  {
    AppMethodBeat.i(150535);
    this.lNy = null;
    this.lNz = null;
    this.lNA = false;
    this.lNw = Collections.synchronizedList(new LinkedList());
    this.lNx = new HashSet();
    h.aHF().kcd.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.blE() > 0))
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
    if (paramb.lNE == null)
    {
      Log.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.lNE.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.lNF != null) {
        localc.lNF.a(paramb.lNB, paramb.jjo, paramb.lNC, paramb.lND, localc.lNG);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void wc(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.lNw)
    {
      if ((this.lNy != null) || (this.lNw.size() <= 0) || (true == this.lNA))
      {
        if (this.lNy == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.lNy.lNB + ", " + this.lNy.jjo + ", " + this.lNy.lNC)
        {
          Log.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.lNw.size()), Boolean.valueOf(this.lNA) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.lNy = ((b)this.lNw.remove(0));
      if (this.lNy == null)
      {
        Log.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.lNz = new m(this.lNy.lNB, this.lNy.jjo, this.lNy.lNC, this, paramInt);
    this.lNz.lPr = this.lNy.lND;
    Log.i("ModelImage.DownloadImgService", "do scene, (" + this.lNy.lNB + ", " + this.lNy.jjo + ", " + this.lNy.lNC + ")");
    h.aHF().kcd.a(this.lNz, 0);
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
    localb.lND = paramInt2;
    if (this.lNx.contains(localb))
    {
      Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.lNy != null) && (localb.equals(this.lNy)))
    {
      if (this.lNy.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.lNw.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.lNw.size()))
    {
      if (((b)this.lNw.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.lNA), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.lNw.size() > 0)) {
      this.lNw.add(0, localb);
    }
    for (;;)
    {
      wc(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.lNw.add(localb);
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Object paramObject, int paramInt, a parama)
  {
    AppMethodBeat.i(198003);
    paramInt = a(paramLong1, paramLong2, 1, paramObject, paramInt, parama, 0, false);
    AppMethodBeat.o(198003);
    return paramInt;
  }
  
  public final void a(int paramInt1, int paramInt2, q paramq)
  {
    AppMethodBeat.i(150548);
    if (this.lNz != paramq)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.lNy != null) && (this.lNy.lNE != null))
    {
      Iterator localIterator = new ArrayList(this.lNy.lNE).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.lNF != null) {
          localc.lNF.a(this.lNy.lNB, this.lNy.jjo, this.lNy.lNC, this.lNy.lND, localc.lNG, paramInt1, paramInt2, paramq);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.lNA = true;
    if (this.lNy != null)
    {
      if (this.lNy != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    label188:
    int i;
    for (;;)
    {
      Log.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.lNw.size()), Boolean.valueOf(this.lNA) });
      b(this.lNy);
      Object localObject2 = new LinkedList();
      synchronized (this.lNw)
      {
        ((List)localObject2).addAll(this.lNw);
        ??? = ((List)localObject2).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject2 = (b)((Iterator)???).next();
          if (localObject2 != null)
          {
            ((b)localObject2).b(parama);
            a((b)localObject2);
            continue;
            ??? = this.lNy.lNB + ", " + this.lNy.jjo + ", " + this.lNy.lNC;
          }
        }
      }
    }
    if (this.lNy == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.lNy.lNB + ", " + this.lNy.jjo + ", " + this.lNy.lNC)
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
    if ((this.lNy != null) && (this.lNy.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.lNw.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(150539);
      return true;
    }
    AppMethodBeat.o(150539);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt, a parama)
  {
    AppMethodBeat.i(198028);
    if (parama == null)
    {
      Log.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(198028);
      return false;
    }
    b localb2 = new b(paramLong1, paramLong2, paramInt);
    b localb1 = null;
    if ((this.lNy != null) && (this.lNy.equals(localb2))) {
      localb1 = this.lNy;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      Log.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
      AppMethodBeat.o(198028);
      return true;
      int i = this.lNw.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.lNw.get(i);
      }
    }
    Log.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
    AppMethodBeat.o(198028);
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
    Log.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.lNB + ", " + paramb.jjo + ", " + paramb.lNC + ")");
    if ((this.lNy != null) && (this.lNy.equals(paramb)))
    {
      h.aHF().kcd.a(this.lNz);
      this.lNz = null;
      Log.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.lNB), Long.valueOf(paramb.jjo), Integer.valueOf(paramb.lNC) });
      c(this.lNy);
      this.lNy = null;
      wc(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.lNw.contains(paramb))
    {
      if (this.lNw.remove(paramb)) {
        c(paramb);
      }
      AppMethodBeat.o(150544);
      return true;
    }
    AppMethodBeat.o(150544);
    return false;
  }
  
  public final void blD()
  {
    AppMethodBeat.i(150546);
    this.lNA = false;
    wc(-1);
    AppMethodBeat.o(150546);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(150547);
    if (this.lNz != paramq)
    {
      Log.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.lNy != null) && (this.lNy.lNE != null))
    {
      this.lNx.add(new b(this.lNy.lNB, this.lNy.jjo, this.lNy.lNC));
      Log.i("ModelImage.DownloadImgService", "scene end, (" + this.lNy.lNB + ", " + this.lNy.jjo + ", " + this.lNy.lNC + ")");
      Iterator localIterator = new ArrayList(this.lNy.lNE).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.lNF != null) {
          localc.lNF.a(this.lNy.lNB, this.lNy.jjo, this.lNy.lNC, this.lNy.lND, localc.lNG, paramInt1, paramInt2, paramString, paramq);
        }
      }
      this.lNy = null;
      this.lNz = null;
      wc(-1);
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
    private int aNf = 0;
    public long jjo;
    public long lNB;
    public int lNC;
    public int lND;
    public List<e.c> lNE;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.lNB = paramLong1;
      this.jjo = paramLong2;
      this.lNC = paramInt;
      this.lND = 0;
    }
    
    public final boolean a(e.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.lNE == null) {
        this.lNE = Collections.synchronizedList(new LinkedList());
      }
      parama = new e.c(parama, paramObject);
      if (this.lNE.contains(parama))
      {
        Log.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.lNE.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final boolean b(e.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new e.c(parama, null);
      if (this.lNE.contains(parama))
      {
        this.lNE.remove(parama);
        AppMethodBeat.o(150532);
        return true;
      }
      AppMethodBeat.o(150532);
      return false;
    }
    
    public final int blE()
    {
      AppMethodBeat.i(150533);
      int i = this.lNE.size();
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
      } while ((paramObject.lNB != this.lNB) || (paramObject.jjo != this.jjo) || (paramObject.lNC != this.lNC));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aNf == 0) {
        this.aNf = (this.lNB + "_" + this.jjo + "_" + this.lNC).hashCode();
      }
      int i = this.aNf;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    e.a lNF;
    Object lNG;
    
    public c(e.a parama, Object paramObject)
    {
      this.lNF = parama;
      this.lNG = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.lNF != paramObject.lNF);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.e
 * JD-Core Version:    0.7.0.1
 */