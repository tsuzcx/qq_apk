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
import com.google.android.exoplayer2.source.b.a;
import com.google.android.exoplayer2.source.b.a.a.a;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.m.b;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.o.a;
import com.google.android.exoplayer2.source.q;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.LinkedList;

final class j
  implements g, t.a<com.google.android.exoplayer2.source.a.a>, t.d, m.b, o
{
  r aLQ;
  boolean aMy;
  long bfC;
  private long bfD;
  boolean bfF;
  private final int bfg;
  private final b bfj;
  final t bfm;
  private final Runnable bfp;
  m[] bfs;
  private int[] bft;
  boolean bfu;
  boolean bfv;
  int bfx;
  final b.a bhN;
  private final a bhX;
  final c bhY;
  private final Format bhZ;
  private final c.b bia;
  final LinkedList<f> bib;
  Format bic;
  int bid;
  int bie;
  private boolean bif;
  boolean[] big;
  private boolean[] bih;
  boolean bii;
  final Handler handler;
  boolean released;
  final int trackType;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, b.a parama1)
  {
    AppMethodBeat.i(62866);
    this.trackType = paramInt1;
    this.bhX = parama;
    this.bhY = paramc;
    this.bfj = paramb;
    this.bhZ = paramFormat;
    this.bfg = paramInt2;
    this.bhN = parama1;
    this.bfm = new t("Loader:HlsSampleStreamWrapper");
    this.bia = new c.b();
    this.bft = new int[0];
    this.bfs = new m[0];
    this.bib = new LinkedList();
    this.bfp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.tT();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.bfC = paramLong;
    this.bfD = paramLong;
    AppMethodBeat.o(62866);
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
    int i = com.google.android.exoplayer2.i.j.bM(paramFormat2.aMQ);
    if (i == 1) {
      str = o(paramFormat1.aMN, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.aNd, paramFormat1.language);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = o(paramFormat1.aMN, 2);
      }
    }
  }
  
  private boolean ac(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.bfs.length;
    int i = 0;
    while (i < j)
    {
      m localm = this.bfs[i];
      localm.ax();
      if ((!localm.f(paramLong, false)) && ((this.bih[i] != 0) || (!this.bif)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      localm.tI();
      i += 1;
    }
    AppMethodBeat.o(62880);
    return true;
  }
  
  private static String o(String paramString, int paramInt)
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
      if (paramInt == com.google.android.exoplayer2.i.j.bM(com.google.android.exoplayer2.i.j.bL(str)))
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
  
  public final void a(com.google.android.exoplayer2.c.l paraml) {}
  
  public final void aR(boolean paramBoolean)
  {
    this.bhY.bhe = paramBoolean;
  }
  
  public final boolean aa(long paramLong)
  {
    AppMethodBeat.i(62872);
    if ((this.bfF) || (this.bfm.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.bhY;
    if (this.bib.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.bib.getLast())
    {
      if (this.bfD != -9223372036854775807L) {
        paramLong = this.bfD;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.bia);
      boolean bool = this.bia.bhp;
      localObject1 = this.bia.bho;
      localObject2 = this.bia.bhq;
      this.bia.clear();
      if (!bool) {
        break;
      }
      this.bfD = -9223372036854775807L;
      this.bfF = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.bhX.a((a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.bfD = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.bib.add(localObject2);
    }
    paramLong = this.bfm.a((t.c)localObject1, this, this.bfg);
    this.bhN.a(((com.google.android.exoplayer2.source.a.a)localObject1).bgL, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.trackType, ((com.google.android.exoplayer2.source.a.a)localObject1).bgM, ((com.google.android.exoplayer2.source.a.a)localObject1).bgN, ((com.google.android.exoplayer2.source.a.a)localObject1).bgO, ((com.google.android.exoplayer2.source.a.a)localObject1).bgP, ((com.google.android.exoplayer2.source.a.a)localObject1).bgQ, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final m eW(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.bfs.length;
    int i = 0;
    while (i < j)
    {
      if (this.bft[i] == paramInt)
      {
        localm = this.bfs[i];
        AppMethodBeat.o(62874);
        return localm;
      }
      i += 1;
    }
    m localm = new m(this.bfj);
    localm.bgA = this;
    this.bft = Arrays.copyOf(this.bft, j + 1);
    this.bft[j] = paramInt;
    this.bfs = ((m[])Arrays.copyOf(this.bfs, j + 1));
    this.bfs[j] = localm;
    AppMethodBeat.o(62874);
    return localm;
  }
  
  public final boolean i(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.bfC = paramLong;
    if ((!paramBoolean) && (!tx()) && (ac(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.bfD = paramLong;
    this.bfF = false;
    this.bib.clear();
    if (this.bfm.isLoading()) {
      this.bfm.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      tS();
    }
  }
  
  final void o(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.big[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.big[paramInt] = paramBoolean;
      j = this.bfx;
      if (!paramBoolean) {
        break label66;
      }
    }
    label66:
    for (paramInt = i;; paramInt = -1)
    {
      this.bfx = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void st()
  {
    AppMethodBeat.i(62875);
    this.bfu = true;
    this.handler.post(this.bfp);
    AppMethodBeat.o(62875);
  }
  
  public final void tR()
  {
    AppMethodBeat.i(62867);
    if (!this.aMy) {
      aa(this.bfC);
    }
    AppMethodBeat.o(62867);
  }
  
  final void tS()
  {
    AppMethodBeat.i(62871);
    m[] arrayOfm = this.bfs;
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].reset(this.bii);
      i += 1;
    }
    this.bii = false;
    AppMethodBeat.o(62871);
  }
  
  final void tT()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.aMy) || (!this.bfu))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.bfs;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].bgq.tE() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.bfs.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.bfs[k].bgq.tE().aMQ;
      if (com.google.android.exoplayer2.i.j.bJ((String)localObject))
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
      if (com.google.android.exoplayer2.i.j.bI((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.bK((String)localObject))
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
        q localq = this.bhY.bhc;
        int i1 = localq.length;
        this.bie = -1;
        this.big = new boolean[n];
        this.bih = new boolean[n];
        q[] arrayOfq = new q[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.bfs[i].bgq.tE();
          localObject = localFormat.aMQ;
          if ((com.google.android.exoplayer2.i.j.bJ((String)localObject)) || (com.google.android.exoplayer2.i.j.bI((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.bih[i] = i2;
            this.bif = (i2 | this.bif);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localq.bgf[k], localFormat);
              k += 1;
            }
          }
          arrayOfq[i] = new q((Format[])localObject);
          this.bie = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.bI(localFormat.aMQ))) {}
          for (localObject = this.bhZ;; localObject = null)
          {
            arrayOfq[i] = new q(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.aLQ = new r(arrayOfq);
        this.aMy = true;
        this.bhX.qX();
        AppMethodBeat.o(62877);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public final long to()
  {
    AppMethodBeat.i(62869);
    if (this.bfF)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (tx())
    {
      l = this.bfD;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.bfC;
    Object localObject = (f)this.bib.getLast();
    if (((f)localObject).bhL)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).bgQ);
    }
    label171:
    for (;;)
    {
      localObject = this.bfs;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].bgq.tw());
          i += 1;
          continue;
          if (this.bib.size() > 1)
          {
            localObject = (f)this.bib.get(this.bib.size() - 2);
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
  
  public final long tp()
  {
    AppMethodBeat.i(62873);
    if (tx())
    {
      l = this.bfD;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.bfF)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.bib.getLast()).bgQ;
    AppMethodBeat.o(62873);
    return l;
  }
  
  final void tq()
  {
    AppMethodBeat.i(210917);
    this.bfm.uO();
    this.bhY.tq();
    AppMethodBeat.o(210917);
  }
  
  public final void tt()
  {
    AppMethodBeat.i(62870);
    tS();
    AppMethodBeat.o(62870);
  }
  
  public final void tu()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.bfp);
    AppMethodBeat.o(62876);
  }
  
  final boolean tx()
  {
    return this.bfD != -9223372036854775807L;
  }
  
  public static abstract interface a
    extends o.a<j>
  {
    public abstract void a(a.a parama);
    
    public abstract void qX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */