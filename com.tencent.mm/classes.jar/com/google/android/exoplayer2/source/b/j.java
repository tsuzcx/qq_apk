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
  r cFN;
  boolean cGv;
  private final int cYZ;
  private final b cZc;
  final t cZf;
  private final Runnable cZi;
  m[] cZl;
  private int[] cZm;
  boolean cZn;
  boolean cZo;
  int cZq;
  long cZv;
  private long cZw;
  boolean cZy;
  final b.a dbH;
  private final a dbR;
  final c dbS;
  private final Format dbT;
  private final c.b dbU;
  final LinkedList<f> dbV;
  Format dbW;
  int dbX;
  int dbY;
  private boolean dbZ;
  boolean[] dca;
  private boolean[] dcb;
  boolean dcc;
  final Handler handler;
  boolean released;
  final int trackType;
  
  public j(int paramInt1, a parama, c paramc, b paramb, long paramLong, Format paramFormat, int paramInt2, b.a parama1)
  {
    AppMethodBeat.i(62866);
    this.trackType = paramInt1;
    this.dbR = parama;
    this.dbS = paramc;
    this.cZc = paramb;
    this.dbT = paramFormat;
    this.cYZ = paramInt2;
    this.dbH = parama1;
    this.cZf = new t("Loader:HlsSampleStreamWrapper");
    this.dbU = new c.b();
    this.cZm = new int[0];
    this.cZl = new m[0];
    this.dbV = new LinkedList();
    this.cZi = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62865);
        j.this.Tw();
        AppMethodBeat.o(62865);
      }
    };
    this.handler = new Handler();
    this.cZv = paramLong;
    this.cZw = paramLong;
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
    int i = com.google.android.exoplayer2.i.j.dm(paramFormat2.cGN);
    if (i == 1) {
      str = x(paramFormat1.cGK, 1);
    }
    for (;;)
    {
      paramFormat1 = paramFormat2.a(paramFormat1.id, str, paramFormat1.bitrate, paramFormat1.width, paramFormat1.height, paramFormat1.cGZ, paramFormat1.language);
      AppMethodBeat.o(62879);
      return paramFormat1;
      if (i == 2) {
        str = x(paramFormat1.cGK, 2);
      }
    }
  }
  
  private boolean cq(long paramLong)
  {
    AppMethodBeat.i(62880);
    int j = this.cZl.length;
    int i = 0;
    while (i < j)
    {
      m localm = this.cZl[i];
      localm.bh();
      if ((!localm.k(paramLong, false)) && ((this.dcb[i] != 0) || (!this.dbZ)))
      {
        AppMethodBeat.o(62880);
        return false;
      }
      localm.Tl();
      i += 1;
    }
    AppMethodBeat.o(62880);
    return true;
  }
  
  private static String x(String paramString, int paramInt)
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
      if (paramInt == com.google.android.exoplayer2.i.j.dm(com.google.android.exoplayer2.i.j.dl(str)))
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
  
  final void C(int paramInt, boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(62878);
    boolean bool;
    int j;
    if (this.dca[paramInt] != paramBoolean)
    {
      bool = true;
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.dca[paramInt] = paramBoolean;
      j = this.cZq;
      if (!paramBoolean) {
        break label64;
      }
    }
    label64:
    for (paramInt = i;; paramInt = -1)
    {
      this.cZq = (j + paramInt);
      AppMethodBeat.o(62878);
      return;
      bool = false;
      break;
    }
  }
  
  public final void RW()
  {
    AppMethodBeat.i(62875);
    this.cZn = true;
    this.handler.post(this.cZi);
    AppMethodBeat.o(62875);
  }
  
  public final long SR()
  {
    AppMethodBeat.i(62869);
    if (this.cZy)
    {
      AppMethodBeat.o(62869);
      return -9223372036854775808L;
    }
    if (Ta())
    {
      l = this.cZw;
      AppMethodBeat.o(62869);
      return l;
    }
    long l = this.cZv;
    Object localObject = (f)this.dbV.getLast();
    if (((f)localObject).dbF)
    {
      if (localObject == null) {
        break label171;
      }
      l = Math.max(l, ((f)localObject).daK);
    }
    label171:
    for (;;)
    {
      localObject = this.cZl;
      int j = localObject.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          l = Math.max(l, localObject[i].daj.SZ());
          i += 1;
          continue;
          if (this.dbV.size() > 1)
          {
            localObject = (f)this.dbV.get(this.dbV.size() - 2);
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
  
  public final long SS()
  {
    AppMethodBeat.i(62873);
    if (Ta())
    {
      l = this.cZw;
      AppMethodBeat.o(62873);
      return l;
    }
    if (this.cZy)
    {
      AppMethodBeat.o(62873);
      return -9223372036854775808L;
    }
    long l = ((f)this.dbV.getLast()).daK;
    AppMethodBeat.o(62873);
    return l;
  }
  
  final void ST()
  {
    AppMethodBeat.i(210363);
    this.cZf.Un();
    this.dbS.ST();
    AppMethodBeat.o(210363);
  }
  
  public final void SW()
  {
    AppMethodBeat.i(62870);
    Tv();
    AppMethodBeat.o(62870);
  }
  
  public final void SX()
  {
    AppMethodBeat.i(62876);
    this.handler.post(this.cZi);
    AppMethodBeat.o(62876);
  }
  
  final boolean Ta()
  {
    return this.cZw != -9223372036854775807L;
  }
  
  public final void Tu()
  {
    AppMethodBeat.i(62867);
    if (!this.cGv) {
      co(this.cZv);
    }
    AppMethodBeat.o(62867);
  }
  
  final void Tv()
  {
    AppMethodBeat.i(62871);
    m[] arrayOfm = this.cZl;
    int j = arrayOfm.length;
    int i = 0;
    while (i < j)
    {
      arrayOfm[i].reset(this.dcc);
      i += 1;
    }
    this.dcc = false;
    AppMethodBeat.o(62871);
  }
  
  final void Tw()
  {
    AppMethodBeat.i(62877);
    if ((this.released) || (this.cGv) || (!this.cZn))
    {
      AppMethodBeat.o(62877);
      return;
    }
    Object localObject = this.cZl;
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      if (localObject[i].daj.Th() == null)
      {
        AppMethodBeat.o(62877);
        return;
      }
      i += 1;
    }
    int n = this.cZl.length;
    int k = 0;
    int m = -1;
    j = 0;
    if (k < n)
    {
      localObject = this.cZl[k].daj.Th().cGN;
      if (com.google.android.exoplayer2.i.j.isVideo((String)localObject))
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
      if (com.google.android.exoplayer2.i.j.df((String)localObject))
      {
        i = 2;
        break label125;
      }
      if (com.google.android.exoplayer2.i.j.dg((String)localObject))
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
        q localq = this.dbS.daW;
        int i1 = localq.length;
        this.dbY = -1;
        this.dca = new boolean[n];
        this.dcb = new boolean[n];
        q[] arrayOfq = new q[n];
        i = 0;
        while (i < n)
        {
          Format localFormat = this.cZl[i].daj.Th();
          localObject = localFormat.cGN;
          if ((com.google.android.exoplayer2.i.j.isVideo((String)localObject)) || (com.google.android.exoplayer2.i.j.df((String)localObject))) {}
          for (int i2 = 1;; i2 = 0)
          {
            this.dcb[i] = i2;
            this.dbZ = (i2 | this.dbZ);
            if (i != m) {
              break label383;
            }
            localObject = new Format[i1];
            k = 0;
            while (k < i1)
            {
              localObject[k] = a(localq.cZY[k], localFormat);
              k += 1;
            }
          }
          arrayOfq[i] = new q((Format[])localObject);
          this.dbY = i;
          i += 1;
          continue;
          label383:
          if ((j == 3) && (com.google.android.exoplayer2.i.j.df(localFormat.cGN))) {}
          for (localObject = this.dbT;; localObject = null)
          {
            arrayOfq[i] = new q(new Format[] { a((Format)localObject, localFormat) });
            break;
          }
        }
        this.cFN = new r(arrayOfq);
        this.cGv = true;
        this.dbR.Qz();
        AppMethodBeat.o(62877);
      }
      else
      {
        i = j;
        j = m;
      }
    }
  }
  
  public final void a(com.google.android.exoplayer2.c.l paraml) {}
  
  public final void bz(boolean paramBoolean)
  {
    this.dbS.daY = paramBoolean;
  }
  
  public final boolean co(long paramLong)
  {
    AppMethodBeat.i(62872);
    if ((this.cZy) || (this.cZf.isLoading()))
    {
      AppMethodBeat.o(62872);
      return false;
    }
    Object localObject2 = this.dbS;
    if (this.dbV.isEmpty()) {}
    for (Object localObject1 = null;; localObject1 = (f)this.dbV.getLast())
    {
      if (this.cZw != -9223372036854775807L) {
        paramLong = this.cZw;
      }
      ((c)localObject2).a((f)localObject1, paramLong, this.dbU);
      boolean bool = this.dbU.dbi;
      localObject1 = this.dbU.dbh;
      localObject2 = this.dbU.dbj;
      this.dbU.clear();
      if (!bool) {
        break;
      }
      this.cZw = -9223372036854775807L;
      this.cZy = true;
      AppMethodBeat.o(62872);
      return true;
    }
    if (localObject1 == null)
    {
      if (localObject2 != null) {
        this.dbR.a((a.a)localObject2);
      }
      AppMethodBeat.o(62872);
      return false;
    }
    if ((localObject1 instanceof f))
    {
      this.cZw = -9223372036854775807L;
      localObject2 = (f)localObject1;
      ((f)localObject2).a(this);
      this.dbV.add(localObject2);
    }
    paramLong = this.cZf.a((t.c)localObject1, this, this.cYZ);
    this.dbH.a(((com.google.android.exoplayer2.source.a.a)localObject1).daF, ((com.google.android.exoplayer2.source.a.a)localObject1).type, this.trackType, ((com.google.android.exoplayer2.source.a.a)localObject1).daG, ((com.google.android.exoplayer2.source.a.a)localObject1).daH, ((com.google.android.exoplayer2.source.a.a)localObject1).daI, ((com.google.android.exoplayer2.source.a.a)localObject1).daJ, ((com.google.android.exoplayer2.source.a.a)localObject1).daK, paramLong);
    AppMethodBeat.o(62872);
    return true;
  }
  
  public final m im(int paramInt)
  {
    AppMethodBeat.i(62874);
    int j = this.cZl.length;
    int i = 0;
    while (i < j)
    {
      if (this.cZm[i] == paramInt)
      {
        localm = this.cZl[i];
        AppMethodBeat.o(62874);
        return localm;
      }
      i += 1;
    }
    m localm = new m(this.cZc);
    localm.dat = this;
    this.cZm = Arrays.copyOf(this.cZm, j + 1);
    this.cZm[j] = paramInt;
    this.cZl = ((m[])Arrays.copyOf(this.cZl, j + 1));
    this.cZl[j] = localm;
    AppMethodBeat.o(62874);
    return localm;
  }
  
  public final boolean n(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(62868);
    this.cZv = paramLong;
    if ((!paramBoolean) && (!Ta()) && (cq(paramLong)))
    {
      AppMethodBeat.o(62868);
      return false;
    }
    this.cZw = paramLong;
    this.cZy = false;
    this.dbV.clear();
    if (this.cZf.isLoading()) {
      this.cZf.cancelLoading();
    }
    for (;;)
    {
      AppMethodBeat.o(62868);
      return true;
      Tv();
    }
  }
  
  public static abstract interface a
    extends o.a<j>
  {
    public abstract void Qz();
    
    public abstract void a(a.a parama);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.j
 * JD-Core Version:    0.7.0.1
 */