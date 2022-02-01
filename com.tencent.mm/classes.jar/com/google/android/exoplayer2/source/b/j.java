package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.t.c;
import com.google.android.exoplayer2.h.t.d;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l.b;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.c>, t.d, l.b, n
{
  final int aQq;
  boolean aRL;
  q aRd;
  private final int bkJ;
  private final b bkM;
  final t bkP;
  private final Runnable bkS;
  com.google.android.exoplayer2.source.l[] bkV;
  private int[] bkW;
  boolean bkX;
  boolean bkY;
  int bla;
  long blf;
  private long blg;
  boolean bli;
  final com.google.android.exoplayer2.source.a.a bmE;
  final LinkedList<f> bmG;
  int bne;
  final c bpA;
  private final Format bpB;
  private final c.b bpC;
  Format bpD;
  int bpE;
  private boolean bpF;
  boolean[] bpG;
  private boolean[] bpH;
  boolean bpI;
  private final a bpz;
  final Handler handler;
  boolean released;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, com.google.android.exoplayer2.source.a.a parama1)
  {
    AppMethodBeat.i(62866);
    this.aQq = paramInt1;
    this.bpz = parama;
    this.bpA = paramc;
    this.bkM = paramb;
    this.bpB = paramFormat;
    this.bkJ = paramInt2;
    this.bmE = parama1;
    this.bkP = new t("Loader:HlsSampleStreamWrapper");
    this.bpC = new c.b();
    this.bkW = new int[0];
    this.bkV = new com.google.android.exoplayer2.source.l[0];
    this.bmG = new LinkedList();
    this.bkS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.uv();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.blf = paramLong;
    this.blg = paramLong;
    AppMethodBeat.o(62866);
  }
  
  private boolean Y(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.bkV.length;
    int i = 0;
    while (i < j)
    {
      com.google.android.exoplayer2.source.l locall = this.bkV[i];
      locall.rewind();
      if ((!locall.f(paramLong, false)) && ((this.bpH[i] != 0) || (!this.bpF)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      locall.tY();
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
    int i = com.google.android.exoplayer2.i.j.aP(paramFormat2.aSd);
    if (i == 1) {
      str = h(paramFormat1.aSa, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.aSs, paramFormat1.aSt);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = h(paramFormat1.aSa, 2);
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
      if (paramInt == com.google.android.exoplayer2.i.j.aP(com.google.android.exoplayer2.i.j.aO(str)))
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
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(62872);
    if ((this.bli) || (this.bkP.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.bpA;
    if (this.bmG.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.bmG.getLast())
    {
      if (this.blg != -9223372036854775807L) {
        paramLong = this.blg;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.bpC);
      boolean bool = this.bpC.bmy;
      localObject1 = this.bpC.bmx;
      localObject2 = this.bpC.boW;
      this.bpC.clear();
      if (!bool) {
        break;
      }
      this.blg = -9223372036854775807L;
      this.bli = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.bpz.a((com.google.android.exoplayer2.source.b.a.a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.blg = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.bmG.add(localObject2);
    }
    paramLong = this.bkP.a((t.c)localObject1, this, this.bkJ);
    this.bmE.a(((com.google.android.exoplayer2.source.a.c)localObject1).bml, ((com.google.android.exoplayer2.source.a.c)localObject1).type, this.aQq, ((com.google.android.exoplayer2.source.a.c)localObject1).bmm, ((com.google.android.exoplayer2.source.a.c)localObject1).bmn, ((com.google.android.exoplayer2.source.a.c)localObject1).bmo, ((com.google.android.exoplayer2.source.a.c)localObject1).bmp, ((com.google.android.exoplayer2.source.a.c)localObject1).bmq, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml) {}
  
  public final void aU(boolean paramBoolean)
  {
    this.bpA.boO = paramBoolean;
  }
  
  public final com.google.android.exoplayer2.source.l eP(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.bkV.length;
    int i = 0;
    while (i < j)
    {
      if (this.bkW[i] == paramInt)
      {
        locall = this.bkV[i];
        AppMethodBeat.o(62874);
        return locall;
      }
      i += 1;
    }
    com.google.android.exoplayer2.source.l locall = new com.google.android.exoplayer2.source.l(this.bkM);
    locall.blX = this;
    this.bkW = Arrays.copyOf(this.bkW, j + 1);
    this.bkW[j] = paramInt;
    this.bkV = ((com.google.android.exoplayer2.source.l[])Arrays.copyOf(this.bkV, j + 1));
    this.bkV[j] = locall;
    AppMethodBeat.o(62874);
    return locall;
  }
  
  public final boolean g(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.blf = paramLong;
    if ((!paramBoolean) && (!tM()) && (Y(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.blg = paramLong;
    this.bli = false;
    this.bmG.clear();
    if (this.bkP.isLoading()) {
      this.bkP.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      uu();
    }
  }
  
  final void n(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.bpG[paramInt] != paramBoolean)
    {
      bool = true;
      a.checkState(bool);
      this.bpG[paramInt] = paramBoolean;
      j = this.bla;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.bla = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void sL()
  {
    AppMethodBeat.i(62875);
    this.bkX = true;
    this.handler.post(this.bkS);
    AppMethodBeat.o(62875);
  }
  
  public final long tD()
  {
    AppMethodBeat.i(62869);
    if (this.bli)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (tM())
    {
      l = this.blg;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.blf;
    Object localObject = (f)this.bmG.getLast();
    if (((f)localObject).bmS)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).bmq);
    }
    label171:
    for (;;)
    {
      localObject = this.bkV;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].blN.tL());
          i += 1;
          continue;
          if (this.bmG.size() > 1)
          {
            localObject = (f)this.bmG.get(this.bmG.size() - 2);
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
  
  public final long tE()
  {
    AppMethodBeat.i(62873);
    if (tM())
    {
      l = this.blg;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.bli)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.bmG.getLast()).bmq;
    AppMethodBeat.o(62873);
    return l;
  }
  
  public final void tI()
  {
    AppMethodBeat.i(62870);
    uu();
    AppMethodBeat.o(62870);
  }
  
  public final void tJ()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.bkS);
    AppMethodBeat.o(62876);
  }
  
  final boolean tM()
  {
    return this.blg != -9223372036854775807L;
  }
  
  public final void ut()
  {
    AppMethodBeat.i(62867);
    if (!this.aRL) {
      W(this.blf);
    }
    AppMethodBeat.o(62867);
  }
  
  final void uu()
  {
    AppMethodBeat.i(62871);
    com.google.android.exoplayer2.source.l[] arrayOfl = this.bkV;
    int j = arrayOfl.length;
    int i = 0;
    while (i < j)
    {
      arrayOfl[i].reset(this.bpI);
      i += 1;
    }
    this.bpI = false;
    AppMethodBeat.o(62871);
  }
  
  final void uv()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.aRL) || (!this.bkX))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.bkV;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].blN.tU() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.bkV.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.bkV[k].blN.tU().aSd;
      if (com.google.android.exoplayer2.i.j.aK((String)localObject))
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
      if (com.google.android.exoplayer2.i.j.aJ((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.aL((String)localObject))
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
        p localp = this.bpA.boM;
        int i1 = localp.length;
        this.bne = -1;
        this.bpG = new boolean[n];
        this.bpH = new boolean[n];
        p[] arrayOfp = new p[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.bkV[i].blN.tU();
          localObject = localFormat.aSd;
          if ((com.google.android.exoplayer2.i.j.aK((String)localObject)) || (com.google.android.exoplayer2.i.j.aJ((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.bpH[i] = i2;
            this.bpF = (i2 | this.bpF);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localp.blC[k], localFormat);
              k += 1;
            }
          }
          arrayOfp[i] = new p((Format[])localObject);
          this.bne = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.aJ(localFormat.aSd))) {}
          for (localObject = this.bpB;; localObject = null)
          {
            arrayOfp[i] = new p(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.aRd = new q(arrayOfp);
        this.aRL = true;
        this.bpz.rq();
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
    extends n.a<j>
  {
    public abstract void a(com.google.android.exoplayer2.source.b.a.a.a parama);
    
    public abstract void rq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */