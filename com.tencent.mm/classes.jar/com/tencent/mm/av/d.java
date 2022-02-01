package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements com.tencent.mm.ak.g, h
{
  final List<b> hGB;
  private HashSet<b> hGC;
  b hGD;
  private k hGE;
  public boolean hGF;
  
  public d()
  {
    AppMethodBeat.i(150535);
    this.hGD = null;
    this.hGE = null;
    this.hGF = false;
    this.hGB = Collections.synchronizedList(new LinkedList());
    this.hGC = new HashSet();
    com.tencent.mm.kernel.g.agQ().ghe.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.aEY() > 0))
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
      ac.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150545);
      return;
    }
    if (paramb.hGJ == null)
    {
      ac.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.hGJ.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hGK != null) {
        localc.hGK.a(paramb.hGG, paramb.fyL, paramb.hGH, paramb.hGI, localc.hGL);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void oJ(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.hGB)
    {
      if ((this.hGD != null) || (this.hGB.size() <= 0) || (true == this.hGF))
      {
        if (this.hGD == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.hGD.hGG + ", " + this.hGD.fyL + ", " + this.hGD.hGH)
        {
          ac.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.hGB.size()), Boolean.valueOf(this.hGF) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.hGD = ((b)this.hGB.remove(0));
      if (this.hGD == null)
      {
        ac.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.hGE = new k(this.hGD.hGG, this.hGD.fyL, this.hGD.hGH, this, paramInt);
    this.hGE.hIt = this.hGD.hGI;
    ac.i("ModelImage.DownloadImgService", "do scene, (" + this.hGD.hGG + ", " + this.hGD.fyL + ", " + this.hGD.hGH + ")");
    com.tencent.mm.kernel.g.agQ().ghe.a(this.hGE, 0);
    AppMethodBeat.o(150549);
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150538);
    if (parama == null)
    {
      ac.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(150538);
      return -1;
    }
    b localb = new b(paramLong1, paramLong2, paramInt1);
    localb.hGI = paramInt2;
    if (this.hGC.contains(localb))
    {
      ac.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.hGD != null) && (localb.equals(this.hGD)))
    {
      if (this.hGD.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.hGB.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.hGB.size()))
    {
      if (((b)this.hGB.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    ac.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.hGF), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.hGB.size() > 0)) {
      this.hGB.add(0, localb);
    }
    for (;;)
    {
      oJ(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.hGB.add(localb);
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
    if (this.hGE != paramn)
    {
      ac.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.hGD != null) && (this.hGD.hGJ != null))
    {
      Iterator localIterator = new ArrayList(this.hGD.hGJ).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hGK != null) {
          localc.hGK.a(this.hGD.hGG, this.hGD.fyL, this.hGD.hGH, this.hGD.hGI, localc.hGL, paramInt1, paramInt2, paramn);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    ac.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.hGF = true;
    if (this.hGD != null)
    {
      if (this.hGD != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      ac.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.hGB.size()), Boolean.valueOf(this.hGF) });
      b(this.hGD);
      Object localObject2 = new LinkedList();
      synchronized (this.hGB)
      {
        ((List)localObject2).addAll(this.hGB);
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
            ??? = this.hGD.hGG + ", " + this.hGD.fyL + ", " + this.hGD.hGH;
          }
        }
      }
    }
    aEX();
    int i = parama.hashCode();
    if (this.hGD == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.hGD.hGG + ", " + this.hGD.fyL + ", " + this.hGD.hGH)
    {
      ac.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(150539);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.hGD != null) && (this.hGD.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.hGB.indexOf(localb) >= 0)
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
    if ((this.hGD != null) && (this.hGD.equals(localb2))) {
      localb1 = this.hGD;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      ac.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      AppMethodBeat.o(150540);
      return true;
      int i = this.hGB.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.hGB.get(i);
      }
    }
    ac.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    AppMethodBeat.o(150540);
    return false;
  }
  
  public final void aEX()
  {
    AppMethodBeat.i(150546);
    this.hGF = false;
    oJ(-1);
    AppMethodBeat.o(150546);
  }
  
  final boolean b(b paramb)
  {
    AppMethodBeat.i(150544);
    if (paramb == null)
    {
      ac.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150544);
      return false;
    }
    ac.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.hGG + ", " + paramb.fyL + ", " + paramb.hGH + ")");
    if ((this.hGD != null) && (this.hGD.equals(paramb)))
    {
      com.tencent.mm.kernel.g.agQ().ghe.a(this.hGE);
      this.hGE = null;
      ac.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.hGG), Long.valueOf(paramb.fyL), Integer.valueOf(paramb.hGH) });
      c(this.hGD);
      this.hGD = null;
      oJ(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.hGB.contains(paramb))
    {
      if (this.hGB.remove(paramb)) {
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
    if (this.hGE != paramn)
    {
      ac.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.hGD != null) && (this.hGD.hGJ != null))
    {
      this.hGC.add(new b(this.hGD.hGG, this.hGD.fyL, this.hGD.hGH));
      ac.i("ModelImage.DownloadImgService", "scene end, (" + this.hGD.hGG + ", " + this.hGD.fyL + ", " + this.hGD.hGH + ")");
      Iterator localIterator = new ArrayList(this.hGD.hGJ).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.hGK != null) {
          localc.hGK.a(this.hGD.hGG, this.hGD.fyL, this.hGD.hGH, this.hGD.hGI, localc.hGL, paramInt1, paramInt2, paramString, paramn);
        }
      }
      this.hGD = null;
      this.hGE = null;
      oJ(-1);
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
    private int aFZ = 0;
    public long fyL;
    public long hGG;
    public int hGH;
    public int hGI;
    public List<d.c> hGJ;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.hGG = paramLong1;
      this.fyL = paramLong2;
      this.hGH = paramInt;
      this.hGI = 0;
    }
    
    public final boolean a(d.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.hGJ == null) {
        this.hGJ = Collections.synchronizedList(new LinkedList());
      }
      parama = new d.c(parama, paramObject);
      if (this.hGJ.contains(parama))
      {
        ac.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.hGJ.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final int aEY()
    {
      AppMethodBeat.i(150533);
      int i = this.hGJ.size();
      AppMethodBeat.o(150533);
      return i;
    }
    
    public final boolean b(d.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new d.c(parama, null);
      if (this.hGJ.contains(parama))
      {
        this.hGJ.remove(parama);
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
      } while ((paramObject.hGG != this.hGG) || (paramObject.fyL != this.fyL) || (paramObject.hGH != this.hGH));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aFZ == 0) {
        this.aFZ = (this.hGG + "_" + this.fyL + "_" + this.hGH).hashCode();
      }
      int i = this.aFZ;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    d.a hGK;
    Object hGL;
    
    public c(d.a parama, Object paramObject)
    {
      this.hGK = parama;
      this.hGL = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.hGK != paramObject.hGK);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.d
 * JD-Core Version:    0.7.0.1
 */