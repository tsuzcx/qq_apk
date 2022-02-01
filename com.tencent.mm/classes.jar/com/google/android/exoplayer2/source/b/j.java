package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.b;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.m.a;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, k.b, m
{
  p aRY;
  boolean aSG;
  k[] blA;
  private int[] blB;
  boolean blC;
  boolean blD;
  int blF;
  long blK;
  private long blL;
  boolean blN;
  private final int blo;
  private final b blr;
  final t blu;
  private final Runnable blx;
  final com.google.android.exoplayer2.source.a.a bnO;
  private final a bnZ;
  final c boa;
  private final Format bob;
  private final c.b boc;
  final LinkedList<f> bod;
  Format boe;
  int bof;
  int bog;
  private boolean boh;
  boolean[] boi;
  private boolean[] boj;
  boolean bok;
  final Handler handler;
  boolean released;
  final int trackType;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, com.google.android.exoplayer2.source.a.a parama1)
  {
    AppMethodBeat.i(62866);
    this.trackType = paramInt1;
    this.bnZ = parama;
    this.boa = paramc;
    this.blr = paramb;
    this.bob = paramFormat;
    this.blo = paramInt2;
    this.bnO = parama1;
    this.blu = new t("Loader:HlsSampleStreamWrapper");
    this.boc = new c.b();
    this.blB = new int[0];
    this.blA = new k[0];
    this.bod = new LinkedList();
    this.blx = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.ur();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.blK = paramLong;
    this.blL = paramLong;
    AppMethodBeat.o(62866);
  }
  
  private boolean Z(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.blA.length;
    int i = 0;
    while (i < j)
    {
      k localk = this.blA[i];
      localk.rewind();
      if ((!localk.f(paramLong, false)) && ((this.boj[i] != 0) || (!this.boh)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      localk.ug();
      i += 1;
    }
    AppMethodBeat.o(62880);
    return true;
  }
  
  private static Format a(Format paramFormat1, Format paramFormat2)
  {
    AppMethodBeat.i(62879);
    if (paramFormat1 == null)
    {
      AppMethodBeat.o(62879);
      return paramFormat2;
    }
    String str = null;
    int i = com.google.android.exoplayer2.i.j.aI(paramFormat2.aSY);
    if (i == 1) {
      str = h(paramFormat1.aSV, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.aTl, paramFormat1.aTm);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = h(paramFormat1.aSV, 2);
      }
    }
  }
  
  private static String h(String paramString, int paramInt)
  {
    AppMethodBeat.i(62881);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(62881);
      return null;
    }
    paramString = paramString.split("(\\s*,\\s*)|(\\s*$)");
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (paramInt == com.google.android.exoplayer2.i.j.aI(com.google.android.exoplayer2.i.j.aH(str)))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append(",");
        }
        localStringBuilder.append(str);
      }
      i += 1;
    }
    if (localStringBuilder.length() > 0)
    {
      paramString = localStringBuilder.toString();
      AppMethodBeat.o(62881);
      return paramString;
    }
    AppMethodBeat.o(62881);
    return null;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(62872);
    if ((this.blN) || (this.blu.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.boa;
    if (this.bod.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.bod.getLast())
    {
      if (this.blL != -9223372036854775807L) {
        paramLong = this.blL;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.boc);
      boolean bool = this.boc.bnq;
      localObject1 = this.boc.bnp;
      localObject2 = this.boc.bnr;
      this.boc.clear();
      if (!bool) {
        break;
      }
      this.blL = -9223372036854775807L;
      this.blN = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.bnZ.a((com.google.android.exoplayer2.source.b.a.a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.blL = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.bod.add(localObject2);
    }
    paramLong = this.blu.a((t.c)localObject1, this, this.blo);
    this.bnO.a(((com.google.android.exoplayer2.source.a.a)localObject1).bmN, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.trackType, ((com.google.android.exoplayer2.source.a.a)localObject1).bmO, ((com.google.android.exoplayer2.source.a.a)localObject1).bmP, ((com.google.android.exoplayer2.source.a.a)localObject1).bmQ, ((com.google.android.exoplayer2.source.a.a)localObject1).bmR, ((com.google.android.exoplayer2.source.a.a)localObject1).bmS, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final void a(l paraml) {}
  
  public final void aT(boolean paramBoolean)
  {
    this.boa.bng = paramBoolean;
  }
  
  public final k eD(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.blA.length;
    int i = 0;
    while (i < j)
    {
      if (this.blB[i] == paramInt)
      {
        localk = this.blA[i];
        AppMethodBeat.o(62874);
        return localk;
      }
      i += 1;
    }
    k localk = new k(this.blr);
    localk.bmC = this;
    this.blB = Arrays.copyOf(this.blB, j + 1);
    this.blB[j] = paramInt;
    this.blA = ((k[])Arrays.copyOf(this.blA, j + 1));
    this.blA[j] = localk;
    AppMethodBeat.o(62874);
    return localk;
  }
  
  public final boolean i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.blK = paramLong;
    if ((!paramBoolean) && (!tU()) && (Z(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.blL = paramLong;
    this.blN = false;
    this.bod.clear();
    if (this.blu.isLoading()) {
      this.blu.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      uq();
    }
  }
  
  final void n(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.boi[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.boi[paramInt] = paramBoolean;
      j = this.blF;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.blF = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void sU()
  {
    AppMethodBeat.i(62875);
    this.blC = true;
    this.handler.post(this.blx);
    AppMethodBeat.o(62875);
  }
  
  public final long tL()
  {
    AppMethodBeat.i(62869);
    if (this.blN)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (tU())
    {
      l = this.blL;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.blK;
    Object localObject = (f)this.bod.getLast();
    if (((f)localObject).bnM)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).bmS);
    }
    label171:
    for (;;)
    {
      localObject = this.blA;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].bms.tT());
          i += 1;
          continue;
          if (this.bod.size() > 1)
          {
            localObject = (f)this.bod.get(this.bod.size() - 2);
            break;
          }
          localObject = null;
          break;
        }
      }
      AppMethodBeat.o(62869);
      return l;
    }
  }
  
  public final long tM()
  {
    AppMethodBeat.i(62873);
    if (tU())
    {
      l = this.blL;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.blN)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.bod.getLast()).bmS;
    AppMethodBeat.o(62873);
    return l;
  }
  
  public final void tQ()
  {
    AppMethodBeat.i(62870);
    uq();
    AppMethodBeat.o(62870);
  }
  
  public final void tR()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.blx);
    AppMethodBeat.o(62876);
  }
  
  final boolean tU()
  {
    return this.blL != -9223372036854775807L;
  }
  
  public final void up()
  {
    AppMethodBeat.i(62867);
    if (!this.aSG) {
      X(this.blK);
    }
    AppMethodBeat.o(62867);
  }
  
  final void uq()
  {
    AppMethodBeat.i(62871);
    k[] arrayOfk = this.blA;
    int j = arrayOfk.length;
    int i = 0;
    while (i < j)
    {
      arrayOfk[i].reset(this.bok);
      i += 1;
    }
    this.bok = false;
    AppMethodBeat.o(62871);
  }
  
  final void ur()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.aSG) || (!this.blC))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.blA;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].bms.uc() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.blA.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.blA[k].bms.uc().aSY;
      if (com.google.android.exoplayer2.i.j.aF((String)localObject))
      {
        i = 3;
        label125:
        if (i <= j) {
          break label175;
        }
        j = k;
      }
    }
    for (;;)
    {
      k += 1;
      m = j;
      j = i;
      break;
      if (com.google.android.exoplayer2.i.j.aE((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.aG((String)localObject))
      {
        i = 1;
        break label125;
      }
      i = 0;
      break label125;
      label175:
      if ((i == j) && (m != -1))
      {
        m = -1;
        i = j;
        j = m;
        continue;
        o localo = this.boa.bne;
        int i1 = localo.length;
        this.bog = -1;
        this.boi = new boolean[n];
        this.boj = new boolean[n];
        o[] arrayOfo = new o[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.blA[i].bms.uc();
          localObject = localFormat.aSY;
          if ((com.google.android.exoplayer2.i.j.aF((String)localObject)) || (com.google.android.exoplayer2.i.j.aE((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.boj[i] = i2;
            this.boh = (i2 | this.boh);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localo.bmh[k], localFormat);
              k += 1;
            }
          }
          arrayOfo[i] = new o((Format[])localObject);
          this.bog = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.aE(localFormat.aSY))) {}
          for (localObject = this.bob;; localObject = null)
          {
            arrayOfo[i] = new o(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.aRY = new p(arrayOfo);
        this.aSG = true;
        this.bnZ.rB();
        AppMethodBeat.o(62877);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public static abstract interface a
    extends m.a<j>
  {
    public abstract void a(com.google.android.exoplayer2.source.b.a.a.a parama);
    
    public abstract void rB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */