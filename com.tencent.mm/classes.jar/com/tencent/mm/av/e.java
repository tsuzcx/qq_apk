package com.tencent.mm.av;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  implements f, com.tencent.mm.ak.g
{
  final List<b> icd;
  private HashSet<b> ice;
  b icf;
  private m icg;
  public boolean ich;
  
  public e()
  {
    AppMethodBeat.i(150535);
    this.icf = null;
    this.icg = null;
    this.ich = false;
    this.icd = Collections.synchronizedList(new LinkedList());
    this.ice = new HashSet();
    com.tencent.mm.kernel.g.ajQ().gDv.a(109, this);
    AppMethodBeat.o(150535);
  }
  
  private boolean a(b paramb)
  {
    AppMethodBeat.i(150542);
    if ((paramb == null) || (paramb.aIv() > 0))
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
      ae.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150545);
      return;
    }
    if (paramb.icl == null)
    {
      ae.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(150545);
      return;
    }
    Iterator localIterator = paramb.icl.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.icm != null) {
        localc.icm.a(paramb.ici, paramb.fUe, paramb.icj, paramb.ick, localc.icn);
      }
    }
    AppMethodBeat.o(150545);
  }
  
  private void po(int paramInt)
  {
    AppMethodBeat.i(150549);
    synchronized (this.icd)
    {
      if ((this.icf != null) || (this.icd.size() <= 0) || (true == this.ich))
      {
        if (this.icf == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.icf.ici + ", " + this.icf.fUe + ", " + this.icf.icj)
        {
          ae.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.icd.size()), Boolean.valueOf(this.ich) });
          AppMethodBeat.o(150549);
          return;
        }
      }
      this.icf = ((b)this.icd.remove(0));
      if (this.icf == null)
      {
        ae.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(150549);
        return;
      }
    }
    this.icg = new m(this.icf.ici, this.icf.fUe, this.icf.icj, this, paramInt);
    this.icg.iea = this.icf.ick;
    ae.i("ModelImage.DownloadImgService", "do scene, (" + this.icf.ici + ", " + this.icf.fUe + ", " + this.icf.icj + ")");
    com.tencent.mm.kernel.g.ajQ().gDv.a(this.icg, 0);
    AppMethodBeat.o(150549);
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(150538);
    if (parama == null)
    {
      ae.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(150538);
      return -1;
    }
    b localb = new b(paramLong1, paramLong2, paramInt1);
    localb.ick = paramInt2;
    if (this.ice.contains(localb))
    {
      ae.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(150538);
      return -2;
    }
    if ((this.icf != null) && (localb.equals(this.icf)))
    {
      if (this.icf.a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -3;
    }
    paramInt2 = this.icd.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.icd.size()))
    {
      if (((b)this.icd.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(150538);
        return 0;
      }
      AppMethodBeat.o(150538);
      return -4;
    }
    ae.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.ich), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if ((paramBoolean) && (this.icd.size() > 0)) {
      this.icd.add(0, localb);
    }
    for (;;)
    {
      po(paramInt3);
      AppMethodBeat.o(150538);
      return 0;
      this.icd.add(localb);
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
    if (this.icg != paramn)
    {
      ae.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150548);
      return;
    }
    if ((this.icf != null) && (this.icf.icl != null))
    {
      Iterator localIterator = new ArrayList(this.icf.icl).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.icm != null) {
          localc.icm.a(this.icf.ici, this.icf.fUe, this.icf.icj, this.icf.ick, localc.icn, paramInt1, paramInt2, paramn);
        }
      }
    }
    AppMethodBeat.o(150548);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(150541);
    ae.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.ich = true;
    if (this.icf != null)
    {
      if (this.icf != null) {
        break label188;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      ae.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.icd.size()), Boolean.valueOf(this.ich) });
      b(this.icf);
      Object localObject2 = new LinkedList();
      synchronized (this.icd)
      {
        ((List)localObject2).addAll(this.icd);
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
            ??? = this.icf.ici + ", " + this.icf.fUe + ", " + this.icf.icj;
          }
        }
      }
    }
    aIu();
    int i = parama.hashCode();
    if (this.icf == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.icf.ici + ", " + this.icf.fUe + ", " + this.icf.icj)
    {
      ae.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(150541);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(150539);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.icf != null) && (this.icf.equals(localb)))
    {
      AppMethodBeat.o(150539);
      return true;
    }
    if (this.icd.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(150539);
      return true;
    }
    AppMethodBeat.o(150539);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt, a parama)
  {
    AppMethodBeat.i(224406);
    if (parama == null)
    {
      ae.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(224406);
      return false;
    }
    b localb2 = new b(paramLong1, paramLong2, paramInt);
    b localb1 = null;
    if ((this.icf != null) && (this.icf.equals(localb2))) {
      localb1 = this.icf;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      ae.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
      AppMethodBeat.o(224406);
      return true;
      int i = this.icd.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.icd.get(i);
      }
    }
    ae.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", " + paramInt + ")");
    AppMethodBeat.o(224406);
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
  
  public final void aIu()
  {
    AppMethodBeat.i(150546);
    this.ich = false;
    po(-1);
    AppMethodBeat.o(150546);
  }
  
  final boolean b(b paramb)
  {
    AppMethodBeat.i(150544);
    if (paramb == null)
    {
      ae.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(150544);
      return false;
    }
    ae.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.ici + ", " + paramb.fUe + ", " + paramb.icj + ")");
    if ((this.icf != null) && (this.icf.equals(paramb)))
    {
      com.tencent.mm.kernel.g.ajQ().gDv.a(this.icg);
      this.icg = null;
      ae.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.ici), Long.valueOf(paramb.fUe), Integer.valueOf(paramb.icj) });
      c(this.icf);
      this.icf = null;
      po(-1);
      AppMethodBeat.o(150544);
      return true;
    }
    if (this.icd.contains(paramb))
    {
      if (this.icd.remove(paramb)) {
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
    if (this.icg != paramn)
    {
      ae.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(150547);
      return;
    }
    if ((this.icf != null) && (this.icf.icl != null))
    {
      this.ice.add(new b(this.icf.ici, this.icf.fUe, this.icf.icj));
      ae.i("ModelImage.DownloadImgService", "scene end, (" + this.icf.ici + ", " + this.icf.fUe + ", " + this.icf.icj + ")");
      Iterator localIterator = new ArrayList(this.icf.icl).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        if (localc.icm != null) {
          localc.icm.a(this.icf.ici, this.icf.fUe, this.icf.icj, this.icf.ick, localc.icn, paramInt1, paramInt2, paramString, paramn);
        }
      }
      this.icf = null;
      this.icg = null;
      po(-1);
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
    public long fUe;
    public long ici;
    public int icj;
    public int ick;
    public List<e.c> icl;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      this.ici = paramLong1;
      this.fUe = paramLong2;
      this.icj = paramInt;
      this.ick = 0;
    }
    
    public final boolean a(e.a parama, Object paramObject)
    {
      AppMethodBeat.i(150531);
      if (this.icl == null) {
        this.icl = Collections.synchronizedList(new LinkedList());
      }
      parama = new e.c(parama, paramObject);
      if (this.icl.contains(parama))
      {
        ae.d("ModelImage.DownloadImgService.Task", "task item already exists");
        AppMethodBeat.o(150531);
        return false;
      }
      this.icl.add(parama);
      AppMethodBeat.o(150531);
      return true;
    }
    
    public final int aIv()
    {
      AppMethodBeat.i(150533);
      int i = this.icl.size();
      AppMethodBeat.o(150533);
      return i;
    }
    
    public final boolean b(e.a parama)
    {
      AppMethodBeat.i(150532);
      parama = new e.c(parama, null);
      if (this.icl.contains(parama))
      {
        this.icl.remove(parama);
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
      } while ((paramObject.ici != this.ici) || (paramObject.fUe != this.fUe) || (paramObject.icj != this.icj));
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(150534);
      if (this.aHQ == 0) {
        this.aHQ = (this.ici + "_" + this.fUe + "_" + this.icj).hashCode();
      }
      int i = this.aHQ;
      AppMethodBeat.o(150534);
      return i;
    }
  }
  
  static final class c
  {
    e.a icm;
    Object icn;
    
    public c(e.a parama, Object paramObject)
    {
      this.icm = parama;
      this.icn = paramObject;
    }
    
    public final boolean equals(Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof c))) {}
      do
      {
        return false;
        paramObject = (c)paramObject;
      } while (this.icm != paramObject.icm);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.e
 * JD-Core Version:    0.7.0.1
 */