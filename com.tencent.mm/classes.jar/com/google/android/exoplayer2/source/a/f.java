package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.n.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class f<T extends g>
  implements t.a<c>, t.d, m, n
{
  private final int bkJ;
  private final t bkP;
  long blf;
  private long blg;
  boolean bli;
  private final int[] bmA;
  public final boolean[] bmB;
  public final T bmC;
  private final n.a<f<T>> bmD;
  private final a.a bmE;
  private final e bmF;
  private final LinkedList<a> bmG;
  private final List<a> bmH;
  private final com.google.android.exoplayer2.source.l bmI;
  public final com.google.android.exoplayer2.source.l[] bmJ;
  private final b bmK;
  private Format bmL;
  private final int bmz;
  
  public f(int paramInt1, int[] paramArrayOfInt, T paramT, n.a<f<T>> parama, com.google.android.exoplayer2.h.b paramb, long paramLong, int paramInt2, a.a parama1)
  {
    AppMethodBeat.i(92593);
    this.bmz = paramInt1;
    this.bmA = paramArrayOfInt;
    this.bmC = paramT;
    this.bmD = parama;
    this.bmE = parama1;
    this.bkJ = paramInt2;
    this.bkP = new t("Loader:ChunkSampleStream");
    this.bmF = new e();
    this.bmG = new LinkedList();
    this.bmH = Collections.unmodifiableList(this.bmG);
    if (paramArrayOfInt == null) {}
    for (paramInt2 = 0;; paramInt2 = paramArrayOfInt.length)
    {
      this.bmJ = new com.google.android.exoplayer2.source.l[paramInt2];
      this.bmB = new boolean[paramInt2];
      paramT = new int[paramInt2 + 1];
      parama = new com.google.android.exoplayer2.source.l[paramInt2 + 1];
      this.bmI = new com.google.android.exoplayer2.source.l(paramb);
      paramT[0] = paramInt1;
      parama[0] = this.bmI;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        parama1 = new com.google.android.exoplayer2.source.l(paramb);
        this.bmJ[paramInt1] = parama1;
        parama[(paramInt1 + 1)] = parama1;
        paramT[(paramInt1 + 1)] = paramArrayOfInt[paramInt1];
        paramInt1 += 1;
      }
    }
    this.bmK = new b(paramT, parama);
    this.blg = paramLong;
    this.blf = paramLong;
    AppMethodBeat.o(92593);
  }
  
  private void eG(int paramInt)
  {
    AppMethodBeat.i(92604);
    if (!this.bmG.isEmpty())
    {
      while ((this.bmG.size() > 1) && (((a)this.bmG.get(1)).bmj[0] <= paramInt)) {
        this.bmG.removeFirst();
      }
      a locala = (a)this.bmG.getFirst();
      Format localFormat = locala.bmm;
      if (!localFormat.equals(this.bmL)) {
        this.bmE.a(this.bmz, localFormat, locala.bmn, locala.bmo, locala.bmp);
      }
      this.bmL = localFormat;
    }
    AppMethodBeat.o(92604);
  }
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(92602);
    if ((this.bli) || (this.bkP.isLoading()))
    {
      AppMethodBeat.o(92602);
      return false;
    }
    Object localObject2 = this.bmC;
    if (this.bmG.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (a)this.bmG.getLast())
    {
      if (this.blg != -9223372036854775807L) {
        paramLong = this.blg;
      }
      ((g)localObject2).a((l)localObject1, paramLong, this.bmF);
      boolean bool = this.bmF.bmy;
      localObject1 = this.bmF.bmx;
      localObject2 = this.bmF;
      ((e)localObject2).bmx = null;
      ((e)localObject2).bmy = false;
      if (!bool) {
        break;
      }
      this.blg = -9223372036854775807L;
      this.bli = true;
      AppMethodBeat.o(92602);
      return true;
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(92602);
      return false;
    }
    if ((localObject1 instanceof a))
    {
      this.blg = -9223372036854775807L;
      localObject2 = (a)localObject1;
      b localb = this.bmK;
      ((a)localObject2).bmi = localb;
      int[] arrayOfInt = new int[localb.bkV.length];
      int i = 0;
      while (i < localb.bkV.length)
      {
        if (localb.bkV[i] != null) {
          arrayOfInt[i] = localb.bkV[i].blN.tR();
        }
        i += 1;
      }
      ((a)localObject2).bmj = arrayOfInt;
      this.bmG.add(localObject2);
    }
    paramLong = this.bkP.a((t.c)localObject1, this, this.bkJ);
    this.bmE.a(((c)localObject1).bml, ((c)localObject1).type, this.bmz, ((c)localObject1).bmm, ((c)localObject1).bmn, ((c)localObject1).bmo, ((c)localObject1).bmp, ((c)localObject1).bmq, paramLong);
    AppMethodBeat.o(92602);
    return true;
  }
  
  public final void X(long paramLong)
  {
    AppMethodBeat.i(92601);
    if ((this.bli) && (paramLong > this.bmI.blN.tL())) {
      this.bmI.blN.tV();
    }
    for (;;)
    {
      this.bmI.tY();
      AppMethodBeat.o(92601);
      return;
      this.bmI.f(paramLong, true);
    }
  }
  
  public final void af(long paramLong)
  {
    AppMethodBeat.i(92596);
    this.blf = paramLong;
    boolean bool;
    if (!tM())
    {
      localObject1 = this.bmI;
      if (paramLong < tE())
      {
        bool = true;
        if (!((com.google.android.exoplayer2.source.l)localObject1).f(paramLong, bool)) {
          break label125;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label49:
      if (i != 0)
      {
        eG(this.bmI.blN.tS());
        this.bmI.tY();
        localObject1 = this.bmJ;
        j = localObject1.length;
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            Object localObject2 = localObject1[i];
            localObject2.rewind();
            localObject2.b(paramLong, true, false);
            i += 1;
            continue;
            bool = false;
            break;
            label125:
            i = 0;
            break label49;
          }
        }
        AppMethodBeat.o(92596);
        return;
      }
    }
    this.blg = paramLong;
    this.bli = false;
    this.bmG.clear();
    if (this.bkP.isLoading())
    {
      this.bkP.cancelLoading();
      AppMethodBeat.o(92596);
      return;
    }
    this.bmI.reset(false);
    Object localObject1 = this.bmJ;
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject1[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(92596);
  }
  
  public final int b(com.google.android.exoplayer2.k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
  {
    AppMethodBeat.i(92600);
    if (tM())
    {
      AppMethodBeat.o(92600);
      return -3;
    }
    eG(this.bmI.blN.tS());
    int i = this.bmI.a(paramk, parame, paramBoolean, this.bli, this.blf);
    if (i == -4) {
      this.bmI.tY();
    }
    AppMethodBeat.o(92600);
    return i;
  }
  
  public final f<T>.a b(long paramLong, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(92594);
    int i = 0;
    while (i < this.bmJ.length)
    {
      if (this.bmA[i] == paramInt)
      {
        if (this.bmB[i] == 0) {
          bool = true;
        }
        com.google.android.exoplayer2.i.a.checkState(bool);
        this.bmB[i] = true;
        this.bmJ[i].rewind();
        this.bmJ[i].f(paramLong, true);
        localObject = new a(this, this.bmJ[i], i);
        AppMethodBeat.o(92594);
        return localObject;
      }
      i += 1;
    }
    Object localObject = new IllegalStateException();
    AppMethodBeat.o(92594);
    throw ((Throwable)localObject);
  }
  
  public final boolean isReady()
  {
    AppMethodBeat.i(92599);
    if ((this.bli) || ((!tM()) && (this.bmI.blN.tT())))
    {
      AppMethodBeat.o(92599);
      return true;
    }
    AppMethodBeat.o(92599);
    return false;
  }
  
  public final void release()
  {
    AppMethodBeat.i(92597);
    if (!this.bkP.a(this))
    {
      this.bmI.tZ();
      com.google.android.exoplayer2.source.l[] arrayOfl = this.bmJ;
      int j = arrayOfl.length;
      int i = 0;
      while (i < j)
      {
        arrayOfl[i].tZ();
        i += 1;
      }
    }
    AppMethodBeat.o(92597);
  }
  
  public final long tD()
  {
    AppMethodBeat.i(92595);
    if (this.bli)
    {
      AppMethodBeat.o(92595);
      return -9223372036854775808L;
    }
    if (tM())
    {
      l = this.blg;
      AppMethodBeat.o(92595);
      return l;
    }
    long l = this.blf;
    a locala = (a)this.bmG.getLast();
    if (locala.ud())
    {
      if (locala == null) {
        break label141;
      }
      l = Math.max(l, locala.bmq);
    }
    label141:
    for (;;)
    {
      l = Math.max(l, this.bmI.blN.tL());
      AppMethodBeat.o(92595);
      return l;
      if (this.bmG.size() > 1)
      {
        locala = (a)this.bmG.get(this.bmG.size() - 2);
        break;
      }
      locala = null;
      break;
    }
  }
  
  public final long tE()
  {
    AppMethodBeat.i(92603);
    if (tM())
    {
      l = this.blg;
      AppMethodBeat.o(92603);
      return l;
    }
    if (this.bli)
    {
      AppMethodBeat.o(92603);
      return -9223372036854775808L;
    }
    long l = ((a)this.bmG.getLast()).bmq;
    AppMethodBeat.o(92603);
    return l;
  }
  
  public final void tF() {}
  
  public final void tI()
  {
    AppMethodBeat.i(92598);
    this.bmI.reset(false);
    com.google.android.exoplayer2.source.l[] arrayOfl = this.bmJ;
    int j = arrayOfl.length;
    int i = 0;
    while (i < j)
    {
      arrayOfl[i].reset(false);
      i += 1;
    }
    AppMethodBeat.o(92598);
  }
  
  final boolean tM()
  {
    return this.blg != -9223372036854775807L;
  }
  
  public final class a
    implements m
  {
    public final f<T> bmM;
    private final com.google.android.exoplayer2.source.l bmN;
    private final int index;
    
    public a(com.google.android.exoplayer2.source.l paraml, int paramInt)
    {
      this.bmM = paraml;
      this.bmN = paramInt;
      int i;
      this.index = i;
    }
    
    public final void X(long paramLong)
    {
      AppMethodBeat.i(92590);
      if ((f.this.bli) && (paramLong > this.bmN.blN.tL()))
      {
        this.bmN.blN.tV();
        AppMethodBeat.o(92590);
        return;
      }
      this.bmN.f(paramLong, true);
      AppMethodBeat.o(92590);
    }
    
    public final int b(com.google.android.exoplayer2.k paramk, com.google.android.exoplayer2.b.e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92591);
      if (f.this.tM())
      {
        AppMethodBeat.o(92591);
        return -3;
      }
      int i = this.bmN.a(paramk, parame, paramBoolean, f.this.bli, f.this.blf);
      AppMethodBeat.o(92591);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92589);
      if ((f.this.bli) || ((!f.this.tM()) && (this.bmN.blN.tT())))
      {
        AppMethodBeat.o(92589);
        return true;
      }
      AppMethodBeat.o(92589);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(92592);
      com.google.android.exoplayer2.i.a.checkState(f.this.bmB[this.index]);
      f.this.bmB[this.index] = false;
      AppMethodBeat.o(92592);
    }
    
    public final void tF() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a.f
 * JD-Core Version:    0.7.0.1
 */