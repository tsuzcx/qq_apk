package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d
  implements f, com.tencent.mm.ai.g
{
  final List<d.b> fDA;
  private HashSet<d.b> fDB;
  d.b fDC;
  private k fDD;
  public boolean fDE;
  
  public d()
  {
    AppMethodBeat.i(78177);
    this.fDC = null;
    this.fDD = null;
    this.fDE = false;
    this.fDA = Collections.synchronizedList(new LinkedList());
    this.fDB = new HashSet();
    com.tencent.mm.kernel.g.RK().eHt.a(109, this);
    AppMethodBeat.o(78177);
  }
  
  private boolean a(d.b paramb)
  {
    AppMethodBeat.i(78184);
    if ((paramb == null) || (paramb.ahf() > 0))
    {
      AppMethodBeat.o(78184);
      return false;
    }
    boolean bool = b(paramb);
    AppMethodBeat.o(78184);
    return bool;
  }
  
  private static void c(d.b paramb)
  {
    AppMethodBeat.i(78187);
    if (paramb == null)
    {
      ab.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(78187);
      return;
    }
    if (paramb.fDI == null)
    {
      ab.e("ModelImage.DownloadImgService", "task callback list is null");
      AppMethodBeat.o(78187);
      return;
    }
    Iterator localIterator = paramb.fDI.iterator();
    while (localIterator.hasNext())
    {
      d.c localc = (d.c)localIterator.next();
      if (localc.fDJ != null) {
        localc.fDJ.a(paramb.fDF, paramb.eiq, paramb.fDG, paramb.fDH, localc.fDK);
      }
    }
    AppMethodBeat.o(78187);
  }
  
  private void ln(int paramInt)
  {
    AppMethodBeat.i(78191);
    synchronized (this.fDA)
    {
      if ((this.fDC != null) || (this.fDA.size() <= 0) || (true == this.fDE))
      {
        if (this.fDC == null) {}
        for (String str = "mCurTaskInfo is null";; str = this.fDC.fDF + ", " + this.fDC.eiq + ", " + this.fDC.fDG)
        {
          ab.i("ModelImage.DownloadImgService", "mCurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { str, Integer.valueOf(this.fDA.size()), Boolean.valueOf(this.fDE) });
          AppMethodBeat.o(78191);
          return;
        }
      }
      this.fDC = ((d.b)this.fDA.remove(0));
      if (this.fDC == null)
      {
        ab.w("ModelImage.DownloadImgService", "null == mCurTaskInfo");
        AppMethodBeat.o(78191);
        return;
      }
    }
    this.fDD = new k(this.fDC.fDF, this.fDC.eiq, this.fDC.fDG, this, paramInt);
    this.fDD.fFs = this.fDC.fDH;
    ab.i("ModelImage.DownloadImgService", "do scene, (" + this.fDC.fDF + ", " + this.fDC.eiq + ", " + this.fDC.fDG + ")");
    com.tencent.mm.kernel.g.RK().eHt.a(this.fDD, 0);
    AppMethodBeat.o(78191);
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, d.a parama, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(78180);
    if (parama == null)
    {
      ab.e("ModelImage.DownloadImgService", "listener is null");
      AppMethodBeat.o(78180);
      return -1;
    }
    d.b localb = new d.b(paramLong1, paramLong2, paramInt1);
    localb.fDH = paramInt2;
    if (this.fDB.contains(localb))
    {
      ab.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      AppMethodBeat.o(78180);
      return -2;
    }
    if ((this.fDC != null) && (localb.equals(this.fDC)))
    {
      if (this.fDC.a(parama, paramObject))
      {
        AppMethodBeat.o(78180);
        return 0;
      }
      AppMethodBeat.o(78180);
      return -3;
    }
    paramInt2 = this.fDA.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.fDA.size()))
    {
      if (((d.b)this.fDA.get(paramInt2)).a(parama, paramObject))
      {
        AppMethodBeat.o(78180);
        return 0;
      }
      AppMethodBeat.o(78180);
      return -4;
    }
    ab.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ") mLockStart: %s callbackDuration %s", new Object[] { Boolean.valueOf(this.fDE), Integer.valueOf(paramInt3) });
    localb.a(parama, paramObject);
    if (((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).biG()) {
      if ((paramBoolean) && (this.fDA.size() > 0)) {
        this.fDA.add(0, localb);
      }
    }
    for (;;)
    {
      ln(paramInt3);
      AppMethodBeat.o(78180);
      return 0;
      this.fDA.add(localb);
      continue;
      this.fDA.add(localb);
    }
  }
  
  public final int a(long paramLong1, long paramLong2, Object paramObject, d.a parama)
  {
    AppMethodBeat.i(78179);
    int i = a(paramLong1, paramLong2, 1, paramObject, 2130838228, parama, 0, false);
    AppMethodBeat.o(78179);
    return i;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(78190);
    if (this.fDD != paramm)
    {
      ab.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(78190);
      return;
    }
    if ((this.fDC != null) && (this.fDC.fDI != null))
    {
      Iterator localIterator = new ArrayList(this.fDC.fDI).iterator();
      while (localIterator.hasNext())
      {
        d.c localc = (d.c)localIterator.next();
        if (localc.fDJ != null) {
          localc.fDJ.a(this.fDC.fDF, this.fDC.eiq, this.fDC.fDG, this.fDC.fDH, localc.fDK, paramInt1, paramInt2, paramm);
        }
      }
    }
    AppMethodBeat.o(78190);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(78183);
    ab.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.fDE = true;
    if (this.fDC != null)
    {
      if (this.fDC != null) {
        break label205;
      }
      ??? = "mCurTaskInfo is null";
    }
    for (;;)
    {
      ab.i("ModelImage.DownloadImgService", "cancelAllTaskByListener CurTaskInfo %s mTodoList %s mLockStart %s", new Object[] { ???, Integer.valueOf(this.fDA.size()), Boolean.valueOf(this.fDE) });
      Object localObject2;
      if (((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.comm.a.b.class)).biG())
      {
        b(this.fDC);
        localObject2 = new LinkedList();
      }
      synchronized (this.fDA)
      {
        ((List)localObject2).addAll(this.fDA);
        ??? = ((List)localObject2).iterator();
        for (;;)
        {
          if (((Iterator)???).hasNext())
          {
            localObject2 = (d.b)((Iterator)???).next();
            if (localObject2 != null)
            {
              ((d.b)localObject2).b(parama);
              a((d.b)localObject2);
              continue;
              label205:
              ??? = this.fDC.fDF + ", " + this.fDC.eiq + ", " + this.fDC.fDG;
              break;
              this.fDC.b(parama);
              ??? = this.fDC;
              if (((d.b)???).fDI != null) {
                ((d.b)???).fDI.clear();
              }
              a(this.fDC);
            }
          }
        }
      }
    }
    ahe();
    int i = parama.hashCode();
    if (this.fDC == null) {}
    for (parama = "mCurTaskInfo is null";; parama = this.fDC.fDF + ", " + this.fDC.eiq + ", " + this.fDC.fDG)
    {
      ab.i("ModelImage.DownloadImgService", "[ %s ] cancelAllTaskByListener done mCurTaskInfo %s", new Object[] { Integer.valueOf(i), parama });
      AppMethodBeat.o(78183);
      return;
    }
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    AppMethodBeat.i(78181);
    d.b localb = new d.b(paramLong1, paramLong2, paramInt);
    if ((this.fDC != null) && (this.fDC.equals(localb)))
    {
      AppMethodBeat.o(78181);
      return true;
    }
    if (this.fDA.indexOf(localb) >= 0)
    {
      AppMethodBeat.o(78181);
      return true;
    }
    AppMethodBeat.o(78181);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, d.a parama)
  {
    AppMethodBeat.i(78178);
    if (a(paramLong1, paramLong2, paramInt1, paramObject, paramInt2, parama, -1, false) >= 0)
    {
      AppMethodBeat.o(78178);
      return true;
    }
    AppMethodBeat.o(78178);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, d.a parama)
  {
    AppMethodBeat.i(78182);
    d.b localb2 = new d.b(paramLong1, paramLong2, 1);
    d.b localb1 = null;
    if ((this.fDC != null) && (this.fDC.equals(localb2))) {
      localb1 = this.fDC;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      ab.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      AppMethodBeat.o(78182);
      return true;
      int i = this.fDA.indexOf(localb2);
      if (-1 != i) {
        localb1 = (d.b)this.fDA.get(i);
      }
    }
    ab.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    AppMethodBeat.o(78182);
    return false;
  }
  
  public final void ahe()
  {
    AppMethodBeat.i(78188);
    this.fDE = false;
    ln(-1);
    AppMethodBeat.o(78188);
  }
  
  final boolean b(d.b paramb)
  {
    AppMethodBeat.i(78186);
    if (paramb == null)
    {
      ab.e("ModelImage.DownloadImgService", "task is null");
      AppMethodBeat.o(78186);
      return false;
    }
    ab.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.fDF + ", " + paramb.eiq + ", " + paramb.fDG + ")");
    if ((this.fDC != null) && (this.fDC.equals(paramb)))
    {
      com.tencent.mm.kernel.g.RK().eHt.a(this.fDD);
      this.fDD = null;
      ab.i("ModelImage.DownloadImgService", "cancelNetScene reset curTaskInfo (%s %s %s)", new Object[] { Long.valueOf(paramb.fDF), Long.valueOf(paramb.eiq), Integer.valueOf(paramb.fDG) });
      c(this.fDC);
      this.fDC = null;
      ln(-1);
      AppMethodBeat.o(78186);
      return true;
    }
    if (this.fDA.contains(paramb))
    {
      if (this.fDA.remove(paramb)) {
        c(paramb);
      }
      AppMethodBeat.o(78186);
      return true;
    }
    AppMethodBeat.o(78186);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(78189);
    if (this.fDD != paramm)
    {
      ab.d("ModelImage.DownloadImgService", "scene changed");
      AppMethodBeat.o(78189);
      return;
    }
    if ((this.fDC != null) && (this.fDC.fDI != null))
    {
      this.fDB.add(new d.b(this.fDC.fDF, this.fDC.eiq, this.fDC.fDG));
      ab.i("ModelImage.DownloadImgService", "scene end, (" + this.fDC.fDF + ", " + this.fDC.eiq + ", " + this.fDC.fDG + ")");
      Iterator localIterator = new ArrayList(this.fDC.fDI).iterator();
      while (localIterator.hasNext())
      {
        d.c localc = (d.c)localIterator.next();
        if (localc.fDJ != null) {
          localc.fDJ.a(this.fDC.fDF, this.fDC.eiq, this.fDC.fDG, this.fDC.fDH, localc.fDK, paramInt1, paramInt2, paramString, paramm);
        }
      }
      this.fDC = null;
      this.fDD = null;
      ln(-1);
    }
    AppMethodBeat.o(78189);
  }
  
  public final boolean z(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(78185);
    boolean bool = b(new d.b(paramLong1, paramLong2, 1));
    AppMethodBeat.o(78185);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.d
 * JD-Core Version:    0.7.0.1
 */