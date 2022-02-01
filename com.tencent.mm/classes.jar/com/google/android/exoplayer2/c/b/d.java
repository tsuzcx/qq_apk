package com.google.android.exoplayer2.c.b;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.l.a;
import com.google.android.exoplayer2.c.m.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public final class d
  implements com.google.android.exoplayer2.c.e
{
  public static final com.google.android.exoplayer2.c.h aRP;
  private static final byte[] aSq;
  private static final byte[] aSr;
  private static long aSs;
  static final byte[] aSt;
  private static final byte[] aSu;
  private static long aSv;
  private static final byte[] aSw;
  private static final UUID aSx;
  long aNk;
  final com.google.android.exoplayer2.i.m aRR;
  g aRV;
  final boolean aSA;
  private final com.google.android.exoplayer2.i.m aSB;
  final com.google.android.exoplayer2.i.m aSC;
  private final com.google.android.exoplayer2.i.m aSD;
  private final com.google.android.exoplayer2.i.m aSE;
  private final com.google.android.exoplayer2.i.m aSF;
  private final com.google.android.exoplayer2.i.m aSG;
  private ByteBuffer aSH;
  long aSI;
  long aSJ;
  long aSK;
  long aSL;
  b aSM;
  boolean aSN;
  int aSO;
  long aSP;
  boolean aSQ;
  long aSR;
  private long aSS;
  long aST;
  com.google.android.exoplayer2.i.h aSU;
  com.google.android.exoplayer2.i.h aSV;
  boolean aSW;
  int aSX;
  long aSY;
  long aSZ;
  private final com.google.android.exoplayer2.i.m aSf;
  private final com.google.android.exoplayer2.i.m aSg;
  final f aSk;
  private final b aSy;
  final SparseArray<b> aSz;
  int aTa;
  int aTb;
  int[] aTc;
  int aTd;
  int aTe;
  int aTf;
  private int aTg;
  private boolean aTh;
  private boolean aTi;
  private boolean aTj;
  private boolean aTk;
  private byte aTl;
  private int aTm;
  private int aTn;
  private int aTo;
  private boolean aTp;
  boolean aTq;
  
  static
  {
    AppMethodBeat.i(92029);
    aRP = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] ss()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    aSq = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    aSr = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aSs = 1000L;
    aSt = x.bR("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    aSu = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    aSv = 10000L;
    aSw = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aSx = new UUID(72057594037932032L, -9223371306706625679L);
    AppMethodBeat.o(92029);
  }
  
  public d()
  {
    this(0);
  }
  
  public d(int paramInt)
  {
    this(new a(), paramInt);
    AppMethodBeat.i(92014);
    AppMethodBeat.o(92014);
  }
  
  private d(b paramb, int paramInt)
  {
    AppMethodBeat.i(92015);
    this.aSJ = -1L;
    this.aSK = -9223372036854775807L;
    this.aSL = -9223372036854775807L;
    this.aNk = -9223372036854775807L;
    this.aSR = -1L;
    this.aSS = -1L;
    this.aST = -9223372036854775807L;
    this.aSy = paramb;
    this.aSy.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.aSA = bool;
    this.aSk = new f();
    this.aSz = new SparseArray();
    this.aRR = new com.google.android.exoplayer2.i.m(4);
    this.aSB = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.aSC = new com.google.android.exoplayer2.i.m(4);
    this.aSf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bqC);
    this.aSg = new com.google.android.exoplayer2.i.m(4);
    this.aSD = new com.google.android.exoplayer2.i.m();
    this.aSE = new com.google.android.exoplayer2.i.m();
    this.aSF = new com.google.android.exoplayer2.i.m(8);
    this.aSG = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.aSD.vg();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.aSD, paramInt);
    }
    for (;;)
    {
      this.aTg += paramInt;
      this.aTo += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.aSE.data, this.aSZ, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.aSe.a(this.aSE, this.aSE.limit);
    this.aTo += this.aSE.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.aSE.vh() < i) {
      this.aSE.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.aSE.data, paramArrayOfByte.length, paramInt);
      this.aSE.fs(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.aSE.data, 0, paramArrayOfByte.length);
    }
  }
  
  private static void a(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(92025);
    if (paramLong1 == -9223372036854775807L) {}
    int i;
    int j;
    int k;
    int m;
    for (paramString = paramArrayOfByte2;; paramString = x.bR(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
    {
      System.arraycopy(paramString, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
      AppMethodBeat.o(92025);
      return;
      i = (int)(paramLong1 / 3600000000L);
      paramLong1 -= i * 3600 * 1000000L;
      j = (int)(paramLong1 / 60000000L);
      paramLong1 -= j * 60 * 1000000L;
      k = (int)(paramLong1 / 1000000L);
      m = (int)((paramLong1 - k * 1000000L) / paramLong2);
    }
  }
  
  static int[] d(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(92028);
    if (paramArrayOfInt == null)
    {
      paramArrayOfInt = new int[paramInt];
      AppMethodBeat.o(92028);
      return paramArrayOfInt;
    }
    if (paramArrayOfInt.length >= paramInt)
    {
      AppMethodBeat.o(92028);
      return paramArrayOfInt;
    }
    paramArrayOfInt = new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
    AppMethodBeat.o(92028);
    return paramArrayOfInt;
  }
  
  static int el(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 160: 
    case 174: 
    case 183: 
    case 187: 
    case 224: 
    case 225: 
    case 18407: 
    case 19899: 
    case 20532: 
    case 20533: 
    case 21936: 
    case 21968: 
    case 25152: 
    case 28032: 
    case 30320: 
    case 290298740: 
    case 357149030: 
    case 374648427: 
    case 408125543: 
    case 440786851: 
    case 475249515: 
    case 524531317: 
      return 1;
    case 131: 
    case 136: 
    case 155: 
    case 159: 
    case 176: 
    case 179: 
    case 186: 
    case 215: 
    case 231: 
    case 241: 
    case 251: 
    case 16980: 
    case 17029: 
    case 17143: 
    case 18401: 
    case 18408: 
    case 20529: 
    case 20530: 
    case 21420: 
    case 21432: 
    case 21680: 
    case 21682: 
    case 21690: 
    case 21930: 
    case 21945: 
    case 21946: 
    case 21947: 
    case 21948: 
    case 21949: 
    case 22186: 
    case 22203: 
    case 25188: 
    case 2352003: 
    case 2807729: 
      return 2;
    case 134: 
    case 17026: 
    case 2274716: 
      return 3;
    case 161: 
    case 163: 
    case 16981: 
    case 18402: 
    case 21419: 
    case 25506: 
    case 30322: 
      return 4;
    }
    return 5;
  }
  
  static boolean em(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  private void sv()
  {
    AppMethodBeat.i(92020);
    this.aTg = 0;
    this.aTo = 0;
    this.aTn = 0;
    this.aTh = false;
    this.aTi = false;
    this.aTk = false;
    this.aTm = 0;
    this.aTl = 0;
    this.aTj = false;
    this.aSD.reset();
    AppMethodBeat.o(92020);
  }
  
  final long P(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.aSK == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.b(paramLong, this.aSK, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.aTp = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.aTp))
      {
        bool = this.aSy.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.aSQ)
        {
          this.aSS = l;
          paramk.position = this.aSR;
          this.aSQ = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.aSN) && (this.aSS != -1L))
        {
          paramk.position = this.aSS;
          this.aSS = -1L;
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          if (bool)
          {
            AppMethodBeat.o(92018);
            return 0;
          }
          AppMethodBeat.o(92018);
          return -1;
        }
      }
    }
  }
  
  final void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(92019);
    if ("S_TEXT/UTF8".equals(paramb.aTs)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, aSs, aSr);
    }
    for (;;)
    {
      paramb.aSe.a(paramLong, this.aTf, this.aTo, 0, paramb.aTw);
      this.aTp = true;
      sv();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.aTs)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, aSv, aSw);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.aTs))
    {
      a(paramf, aSq, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.aTs))
    {
      a(paramf, aSu, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.aSe;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.aTh)
    {
      if (!paramb.aTu) {
        break label922;
      }
      this.aTf &= 0xBFFFFFFF;
      if (!this.aTi)
      {
        paramf.readFully(this.aRR.data, 0, 1);
        this.aTg += 1;
        if ((this.aRR.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.aTl = this.aRR.data[0];
        this.aTi = true;
      }
      int m;
      if ((this.aTl & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.aTl & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.aTf |= 0x40000000;
        if (!this.aTj)
        {
          paramf.readFully(this.aSF.data, 0, 8);
          this.aTg += 8;
          this.aTj = true;
          arrayOfByte = this.aRR.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.aRR.setPosition(0);
          localm.a(this.aRR, 1);
          this.aTo += 1;
          this.aSF.setPosition(0);
          localm.a(this.aSF, 8);
          this.aTo += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.aTk)
        {
          paramf.readFully(this.aRR.data, 0, 1);
          this.aTg += 1;
          this.aRR.setPosition(0);
          this.aTm = this.aRR.readUnsignedByte();
          this.aTk = true;
        }
        i = this.aTm * 4;
        this.aRR.fs(i);
        paramf.readFully(this.aRR.data, 0, i);
        this.aTg = (i + this.aTg);
        short s = (short)(this.aTm / 2 + 1);
        m = s * 6 + 2;
        if ((this.aSH == null) || (this.aSH.capacity() < m)) {
          this.aSH = ByteBuffer.allocate(m);
        }
        this.aSH.position(0);
        this.aSH.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.aTm) {
          break label621;
        }
        k = this.aRR.vo();
        if (j % 2 != 0) {
          break label605;
        }
        this.aSH.putShort((short)(k - i));
      }
      for (;;)
      {
        j += 1;
        i = k;
        break label535;
        i = 0;
        break;
        label593:
        i = 0;
        break label215;
        label599:
        j = 0;
        break label285;
        label605:
        this.aSH.putInt(k - i);
      }
      label621:
      i = paramInt - this.aTg - i;
      if (this.aTm % 2 == 1)
      {
        this.aSH.putInt(i);
        this.aSG.n(this.aSH.array(), m);
        localm.a(this.aSG, m);
        this.aTo += m;
        label692:
        this.aTh = true;
      }
    }
    else
    {
      paramInt = this.aSD.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.aTs)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.aTs))) {
        break label971;
      }
      arrayOfByte = this.aSg.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.aSh;
      j = 4 - paramb.aSh;
    }
    for (;;)
    {
      if (this.aTg < paramInt)
      {
        if (this.aTn == 0)
        {
          k = Math.min(i, this.aSD.vg());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.aSD.readBytes(arrayOfByte, j, k);
          }
          this.aTg += i;
          this.aSg.setPosition(0);
          this.aTn = this.aSg.vo();
          this.aSf.setPosition(0);
          localm.a(this.aSf, 4);
          this.aTo += 4;
          continue;
          this.aSH.putShort((short)i);
          this.aSH.putInt(0);
          break;
          label922:
          if (paramb.aTv == null) {
            break label692;
          }
          this.aSD.n(paramb.aTv, paramb.aTv.length);
          break label692;
        }
        this.aTn -= a(paramf, localm, this.aTn);
        continue;
        label971:
        while (this.aTg < paramInt) {
          a(paramf, localm, paramInt - this.aTg);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.aTs))
    {
      this.aSB.setPosition(0);
      localm.a(this.aSB, 4);
      this.aTo += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.aRV = paramg;
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92016);
    e locale = new e();
    long l2 = paramf.sr();
    if ((l2 == -1L) || (l2 > 1024L)) {}
    for (long l1 = 1024L;; l1 = l2)
    {
      int i = (int)l1;
      paramf.b(locale.aRR.data, 0, 4);
      l1 = locale.aRR.ii();
      locale.aTS = 4;
      while (l1 != 440786851L)
      {
        int j = locale.aTS + 1;
        locale.aTS = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.aRR.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.aRR.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.aTS;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.ee((int)l2);
        locale.aTS = ((int)(l2 + locale.aTS));
      }
      if (locale.aTS >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.aTS == l1 + l3)
    {
      AppMethodBeat.o(92016);
      return true;
    }
    label330:
    AppMethodBeat.o(92016);
    return false;
  }
  
  final void b(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    AppMethodBeat.i(92021);
    if (this.aRR.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.aRR.vh() < paramInt) {
      this.aRR.n(Arrays.copyOf(this.aRR.data, Math.max(this.aRR.data.length * 2, paramInt)), this.aRR.limit);
    }
    paramf.readFully(this.aRR.data, this.aRR.limit, paramInt - this.aRR.limit);
    this.aRR.ft(paramInt);
    AppMethodBeat.o(92021);
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.aST = -9223372036854775807L;
    this.aSX = 0;
    this.aSy.reset();
    this.aSk.reset();
    sv();
    AppMethodBeat.o(92017);
  }
  
  final class a
    implements c
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, com.google.android.exoplayer2.c.f paramf)
    {
      AppMethodBeat.i(92010);
      d locald = d.this;
      switch (paramInt1)
      {
      default: 
        paramf = new o("Unexpected id: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(92010);
        throw paramf;
      case 21419: 
        Arrays.fill(locald.aSC.data, (byte)0);
        paramf.readFully(locald.aSC.data, 4 - paramInt2, paramInt2);
        locald.aSC.setPosition(0);
        locald.aSO = ((int)locald.aSC.ii());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.aSM.aTx = new byte[paramInt2];
        paramf.readFully(locald.aSM.aTx, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.aSM.aMY = new byte[paramInt2];
        paramf.readFully(locald.aSM.aMY, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.aSM.aTv = new byte[paramInt2];
        paramf.readFully(locald.aSM.aTv, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.aSM.aTw = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.aSX == 0)
      {
        locald.aTd = ((int)locald.aSk.a(paramf, false, true, 8));
        locald.aTe = locald.aSk.length;
        locald.aSZ = -9223372036854775807L;
        locald.aSX = 1;
        locald.aRR.reset();
      }
      Object localObject1 = (d.b)locald.aSz.get(locald.aTd);
      if (localObject1 == null)
      {
        paramf.ed(paramInt2 - locald.aTe);
        locald.aSX = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.aSX == 1)
      {
        locald.b(paramf, 3);
        i = (locald.aRR.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.aTb = 1;
        locald.aTc = d.d(locald.aTc, 1);
        locald.aTc[0] = (paramInt2 - locald.aTe - 3);
        paramInt2 = locald.aRR.data[0];
        i = locald.aRR.data[1];
        locald.aSY = (locald.aST + locald.P(paramInt2 << 8 | i & 0xFF));
        if ((locald.aRR.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.aRR.data[2] & 0x80) != 128))) {
          break label1409;
        }
        i = 1;
        label597:
        if (i == 0) {
          break label1415;
        }
        i = 1;
        label605:
        if (paramInt2 == 0) {
          break label1421;
        }
      }
      label1409:
      label1415:
      label1421:
      for (paramInt2 = -2147483648;; paramInt2 = 0)
      {
        locald.aTf = (paramInt2 | i);
        locald.aSX = 2;
        locald.aTa = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.aTa < locald.aTb)
        {
          locald.a(paramf, (d.b)localObject1, locald.aTc[locald.aTa]);
          locald.a((d.b)localObject1, locald.aSY + locald.aTa * ((d.b)localObject1).aTt / 1000);
          locald.aTa += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.aTb = ((locald.aRR.data[3] & 0xFF) + 1);
        locald.aTc = d.d(locald.aTc, locald.aTb);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.aTe - 4) / locald.aTb;
          Arrays.fill(locald.aTc, 0, locald.aTb, paramInt2);
          break;
        }
        int j;
        int k;
        int m;
        int n;
        Object localObject2;
        if (i == 1)
        {
          j = 0;
          i = 4;
          k = 0;
          while (k < locald.aTb - 1)
          {
            locald.aTc[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.aRR.data[(i - 1)] & 0xFF;
              localObject2 = locald.aTc;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.aTc[k];
            k += 1;
          }
          locald.aTc[(locald.aTb - 1)] = (paramInt2 - locald.aTe - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.aTb - 1)
          {
            locald.aTc[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.aRR.data[(n - 1)] == 0)
            {
              paramf = new o("No valid varint length mask found");
              AppMethodBeat.o(92010);
              throw paramf;
            }
            long l2 = 0L;
            m = 0;
            long l1;
            for (;;)
            {
              i = n;
              l1 = l2;
              if (m < 8)
              {
                int i1 = 1 << 7 - m;
                if ((locald.aRR.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.aRR.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.aRR.data[i] & 0xFF;
                  i += 1;
                }
                i = n;
                l1 = l2;
                if (k > 0)
                {
                  l1 = l2 - ((1L << m * 7 + 6) - 1L);
                  i = n;
                }
              }
              if ((l1 >= -2147483648L) && (l1 <= 2147483647L)) {
                break;
              }
              paramf = new o("EBML lacing sample size out of range.");
              AppMethodBeat.o(92010);
              throw paramf;
              label1277:
              m += 1;
            }
            m = (int)l1;
            localObject2 = locald.aTc;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.aTc[k];
              k += 1;
              break;
              m += locald.aTc[(k - 1)];
            }
          }
          locald.aTc[(locald.aTb - 1)] = (paramInt2 - locald.aTe - i - j);
          break;
        }
        paramf = new o("Unexpected lacing value: ".concat(String.valueOf(i)));
        AppMethodBeat.o(92010);
        throw paramf;
        label1404:
        paramInt2 = 0;
        break label558;
        i = 0;
        break label597;
        i = 0;
        break label605;
      }
      locald.aSX = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.aTc[0]);
      AppMethodBeat.o(92010);
    }
    
    public final void b(int paramInt, double paramDouble)
    {
      d locald = d.this;
      switch (paramInt)
      {
      default: 
        return;
      case 17545: 
        locald.aSL = (paramDouble);
        return;
      case 181: 
        locald.aSM.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.aSM.aTD = ((float)paramDouble);
        return;
      case 21970: 
        locald.aSM.aTE = ((float)paramDouble);
        return;
      case 21971: 
        locald.aSM.aTF = ((float)paramDouble);
        return;
      case 21972: 
        locald.aSM.aTG = ((float)paramDouble);
        return;
      case 21973: 
        locald.aSM.aTH = ((float)paramDouble);
        return;
      case 21974: 
        locald.aSM.aTI = ((float)paramDouble);
        return;
      case 21975: 
        locald.aSM.aTJ = ((float)paramDouble);
        return;
      case 21976: 
        locald.aSM.aTK = ((float)paramDouble);
        return;
      case 21977: 
        locald.aSM.aTL = ((float)paramDouble);
        return;
      }
      locald.aSM.aTM = ((float)paramDouble);
    }
    
    public final void d(int paramInt, String paramString)
    {
      AppMethodBeat.i(92009);
      d locald = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(92009);
        return;
        if ((!"webm".equals(paramString)) && (!"matroska".equals(paramString)))
        {
          paramString = new o("DocType " + paramString + " not supported");
          AppMethodBeat.o(92009);
          throw paramString;
          locald.aSM.aTs = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.aSM.language = paramString;
        }
      }
    }
    
    public final int el(int paramInt)
    {
      AppMethodBeat.i(92004);
      paramInt = d.el(paramInt);
      AppMethodBeat.o(92004);
      return paramInt;
    }
    
    public final boolean em(int paramInt)
    {
      AppMethodBeat.i(92005);
      boolean bool = d.em(paramInt);
      AppMethodBeat.o(92005);
      return bool;
    }
    
    public final void en(int paramInt)
    {
      AppMethodBeat.i(92007);
      d locald = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(92007);
        return;
        if (locald.aSK == -9223372036854775807L) {
          locald.aSK = 1000000L;
        }
        if (locald.aSL != -9223372036854775807L)
        {
          locald.aNk = locald.P(locald.aSL);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.aSO == -1) || (locald.aSP == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.aSO == 475249515)
          {
            locald.aSR = locald.aSP;
            AppMethodBeat.o(92007);
            return;
            if (!locald.aSN)
            {
              Object localObject2 = locald.aRV;
              if ((locald.aSJ == -1L) || (locald.aNk == -9223372036854775807L) || (locald.aSU == null) || (locald.aSU.size == 0) || (locald.aSV == null) || (locald.aSV.size != locald.aSU.size))
              {
                locald.aSU = null;
                locald.aSV = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.aNk);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.aSN = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.aSU.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.aSU.get(paramInt);
                  localObject3[paramInt] = (locald.aSJ + locald.aSV.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.aSJ + locald.aSI - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.aNk - localObject5[(i - 1)]);
                locald.aSU = null;
                locald.aSV = null;
              }
              if (locald.aSX == 2)
              {
                if (!locald.aTq) {
                  locald.aTf |= 0x1;
                }
                locald.a((d.b)locald.aSz.get(locald.aTd), locald.aSY);
                locald.aSX = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.aSM.aTu)
                {
                  if (locald.aSM.aTw == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.aSM.aMT = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.aLi, "video/webm", locald.aSM.aTw.aRL) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.aSM.aTu) && (locald.aSM.aTv != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.aSM.aTs;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.aSM;
                      localObject5 = locald.aRV;
                      m = locald.aSM.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).aTs;
                      paramInt = -1;
                      switch (((String)localObject1).hashCode())
                      {
                      }
                    }
                    for (;;)
                    {
                      switch (paramInt)
                      {
                      default: 
                        localObject1 = new o("Unrecognized codec identifier.");
                        AppMethodBeat.o(92007);
                        throw ((Throwable)localObject1);
                        paramInt = 0;
                        break label1098;
                        if (((String)localObject1).equals("V_VP8"))
                        {
                          paramInt = 0;
                          continue;
                          if (((String)localObject1).equals("V_VP9"))
                          {
                            paramInt = 1;
                            continue;
                            if (((String)localObject1).equals("V_MPEG2"))
                            {
                              paramInt = 2;
                              continue;
                              if (((String)localObject1).equals("V_MPEG4/ISO/SP"))
                              {
                                paramInt = 3;
                                continue;
                                if (((String)localObject1).equals("V_MPEG4/ISO/ASP"))
                                {
                                  paramInt = 4;
                                  continue;
                                  if (((String)localObject1).equals("V_MPEG4/ISO/AP"))
                                  {
                                    paramInt = 5;
                                    continue;
                                    if (((String)localObject1).equals("V_MPEG4/ISO/AVC"))
                                    {
                                      paramInt = 6;
                                      continue;
                                      if (((String)localObject1).equals("V_MPEGH/ISO/HEVC"))
                                      {
                                        paramInt = 7;
                                        continue;
                                        if (((String)localObject1).equals("V_MS/VFW/FOURCC"))
                                        {
                                          paramInt = 8;
                                          continue;
                                          if (((String)localObject1).equals("V_THEORA"))
                                          {
                                            paramInt = 9;
                                            continue;
                                            if (((String)localObject1).equals("A_VORBIS"))
                                            {
                                              paramInt = 10;
                                              continue;
                                              if (((String)localObject1).equals("A_OPUS"))
                                              {
                                                paramInt = 11;
                                                continue;
                                                if (((String)localObject1).equals("A_AAC"))
                                                {
                                                  paramInt = 12;
                                                  continue;
                                                  if (((String)localObject1).equals("A_MPEG/L2"))
                                                  {
                                                    paramInt = 13;
                                                    continue;
                                                    if (((String)localObject1).equals("A_MPEG/L3"))
                                                    {
                                                      paramInt = 14;
                                                      continue;
                                                      if (((String)localObject1).equals("A_AC3"))
                                                      {
                                                        paramInt = 15;
                                                        continue;
                                                        if (((String)localObject1).equals("A_EAC3"))
                                                        {
                                                          paramInt = 16;
                                                          continue;
                                                          if (((String)localObject1).equals("A_TRUEHD"))
                                                          {
                                                            paramInt = 17;
                                                            continue;
                                                            if (((String)localObject1).equals("A_DTS"))
                                                            {
                                                              paramInt = 18;
                                                              continue;
                                                              if (((String)localObject1).equals("A_DTS/EXPRESS"))
                                                              {
                                                                paramInt = 19;
                                                                continue;
                                                                if (((String)localObject1).equals("A_DTS/LOSSLESS"))
                                                                {
                                                                  paramInt = 20;
                                                                  continue;
                                                                  if (((String)localObject1).equals("A_FLAC"))
                                                                  {
                                                                    paramInt = 21;
                                                                    continue;
                                                                    if (((String)localObject1).equals("A_MS/ACM"))
                                                                    {
                                                                      paramInt = 22;
                                                                      continue;
                                                                      if (((String)localObject1).equals("A_PCM/INT/LIT"))
                                                                      {
                                                                        paramInt = 23;
                                                                        continue;
                                                                        if (((String)localObject1).equals("S_TEXT/UTF8"))
                                                                        {
                                                                          paramInt = 24;
                                                                          continue;
                                                                          if (((String)localObject1).equals("S_TEXT/ASS"))
                                                                          {
                                                                            paramInt = 25;
                                                                            continue;
                                                                            if (((String)localObject1).equals("S_VOBSUB"))
                                                                            {
                                                                              paramInt = 26;
                                                                              continue;
                                                                              if (((String)localObject1).equals("S_HDMV/PGS"))
                                                                              {
                                                                                paramInt = 27;
                                                                                continue;
                                                                                if (((String)localObject1).equals("S_DVBSUB")) {
                                                                                  paramInt = 28;
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                        break;
                      }
                    }
                    localObject1 = "video/x-vnd.on2.vp8";
                    localObject2 = localObject3;
                    paramInt = j;
                    label2060:
                    int k;
                    if (((d.b)localObject4).aTR)
                    {
                      j = 1;
                      if (!((d.b)localObject4).aTQ) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.bI((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).aMT, j, ((d.b)localObject4).language);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).aSe = ((g)localObject5).ej(((d.b)localObject4).number);
                      ((d.b)localObject4).aSe.f((Format)localObject1);
                      locald.aSz.put(locald.aSM.number, locald.aSM);
                      label2178:
                      locald.aSM = null;
                      AppMethodBeat.o(92007);
                      return;
                      localObject1 = "video/x-vnd.on2.vp9";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "video/mpeg2";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject3 = "video/mp4v-es";
                      if (((d.b)localObject4).aTx == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).aTx))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aTx));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).aMS;
                      ((d.b)localObject4).aSh = ((com.google.android.exoplayer2.video.a)localObject3).aSh;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aTx));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).aMS;
                      ((d.b)localObject4).aSh = ((com.google.android.exoplayer2.video.b)localObject3).aSh;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aTx));
                      if (localObject2 != null)
                      {
                        localObject1 = "video/wvc1";
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/x-unknown";
                      paramInt = j;
                      break;
                      localObject1 = "video/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/vorbis";
                      paramInt = 8192;
                      localObject2 = d.b.o(((d.b)localObject4).aTx);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).aTx);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aTO).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aTP).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aTx);
                      paramInt = j;
                      break;
                      localObject1 = "audio/mpeg-L2";
                      paramInt = 4096;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/mpeg";
                      paramInt = 4096;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/ac3";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/eac3";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/true-hd";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/vnd.dts";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/vnd.dts.hd";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/flac";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aTx);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aTx)))
                      {
                        k = x.fz(((d.b)localObject4).aTN);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aTN).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.fz(((d.b)localObject4).aTN);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aTN).append(". Setting mimeType to ").append("audio/x-unknown");
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/x-subrip";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "text/x-ssa";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/vobsub";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aTx);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.aTx[0], localObject4.aTx[1], localObject4.aTx[2], localObject4.aTx[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3003:
                      k = 0;
                      break label2071;
                      label3009:
                      if (j.bJ((String)localObject1))
                      {
                        label3041:
                        label3064:
                        float f1;
                        if (((d.b)localObject4).aTy == 0)
                        {
                          if (((d.b)localObject4).displayWidth == -1)
                          {
                            i = ((d.b)localObject4).width;
                            ((d.b)localObject4).displayWidth = i;
                            if (((d.b)localObject4).displayHeight != -1) {
                              break label3340;
                            }
                            i = ((d.b)localObject4).height;
                            ((d.b)localObject4).displayHeight = i;
                          }
                        }
                        else
                        {
                          float f2 = -1.0F;
                          f1 = f2;
                          if (((d.b)localObject4).displayWidth != -1)
                          {
                            f1 = f2;
                            if (((d.b)localObject4).displayHeight != -1) {
                              f1 = ((d.b)localObject4).height * ((d.b)localObject4).displayWidth / (((d.b)localObject4).width * ((d.b)localObject4).displayHeight);
                            }
                          }
                          localObject3 = null;
                          if (((d.b)localObject4).aTz)
                          {
                            if ((((d.b)localObject4).aTD != -1.0F) && (((d.b)localObject4).aTE != -1.0F) && (((d.b)localObject4).aTF != -1.0F) && (((d.b)localObject4).aTG != -1.0F) && (((d.b)localObject4).aTH != -1.0F) && (((d.b)localObject4).aTI != -1.0F) && (((d.b)localObject4).aTJ != -1.0F) && (((d.b)localObject4).aTK != -1.0F) && (((d.b)localObject4).aTL != -1.0F) && (((d.b)localObject4).aTM != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).aTA, ((d.b)localObject4).colorRange, ((d.b)localObject4).colorTransfer, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).aMY, ((d.b)localObject4).aMX, (ColorInfo)localObject3, ((d.b)localObject4).aMT);
                          break;
                          i = ((d.b)localObject4).displayWidth;
                          break label3041;
                          i = ((d.b)localObject4).displayHeight;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTD * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTE * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTF * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTG * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTH * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTI * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTJ * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTK * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTL + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aTM + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).aTB);
                          localByteBuffer.putShort((short)((d.b)localObject4).aTC);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, ((d.b)localObject4).aMT);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.aSt);
                        ((List)localObject2).add(((d.b)localObject4).aTx);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, -1, ((d.b)localObject4).aMT, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).language, ((d.b)localObject4).aMT);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.aSz.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.aRV.st();
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public final void f(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(92006);
      Object localObject = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(92006);
        return;
        if ((((d)localObject).aSJ != -1L) && (((d)localObject).aSJ != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).aSJ = paramLong1;
        ((d)localObject).aSI = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aSO = -1;
        ((d)localObject).aSP = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aSU = new com.google.android.exoplayer2.i.h();
        ((d)localObject).aSV = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aSW = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).aSN)
        {
          if ((((d)localObject).aSA) && (((d)localObject).aSR != -1L))
          {
            ((d)localObject).aSQ = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).aRV.a(new l.a(((d)localObject).aNk));
          ((d)localObject).aSN = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aTq = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aSM.aTu = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aSM = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aSM.aTz = true;
        }
      }
    }
    
    public final void i(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(92008);
      Object localObject = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(92008);
        return;
        if (paramLong != 1L)
        {
          localObject = new o("EBMLReadVersion " + paramLong + " not supported");
          AppMethodBeat.o(92008);
          throw ((Throwable)localObject);
          if ((paramLong < 1L) || (paramLong > 2L))
          {
            localObject = new o("DocTypeReadVersion " + paramLong + " not supported");
            AppMethodBeat.o(92008);
            throw ((Throwable)localObject);
            ((d)localObject).aSP = (((d)localObject).aSJ + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSK = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.displayWidth = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.displayHeight = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.aTy = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).aSM;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).aTQ = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).aSM;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).aTR = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).aSM.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.aTt = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.aTO = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.aTP = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aSM.aTN = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aTq = true;
            AppMethodBeat.o(92008);
            return;
            if (paramLong != 0L)
            {
              localObject = new o("ContentEncodingOrder " + paramLong + " not supported");
              AppMethodBeat.o(92008);
              throw ((Throwable)localObject);
              if (paramLong != 1L)
              {
                localObject = new o("ContentEncodingScope " + paramLong + " not supported");
                AppMethodBeat.o(92008);
                throw ((Throwable)localObject);
                if (paramLong != 3L)
                {
                  localObject = new o("ContentCompAlgo " + paramLong + " not supported");
                  AppMethodBeat.o(92008);
                  throw ((Throwable)localObject);
                  if (paramLong != 5L)
                  {
                    localObject = new o("ContentEncAlgo " + paramLong + " not supported");
                    AppMethodBeat.o(92008);
                    throw ((Throwable)localObject);
                    if (paramLong != 1L)
                    {
                      localObject = new o("AESSettingsCipherMode " + paramLong + " not supported");
                      AppMethodBeat.o(92008);
                      throw ((Throwable)localObject);
                      ((d)localObject).aSU.add(((d)localObject).P(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).aSW)
                      {
                        ((d)localObject).aSV.add(paramLong);
                        ((d)localObject).aSW = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aST = ((d)localObject).P(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aSZ = ((d)localObject).P(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).aSM.aMX = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aSM.aMX = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).aSM.aMX = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aSM.aMX = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aSM.aTz = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aSM.aTA = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aSM.aTA = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aSM.aTA = 6;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aSM.colorTransfer = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).aSM.colorTransfer = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aSM.colorTransfer = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aSM.colorRange = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aSM.colorRange = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aSM.aTB = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aSM.aTC = ((int)paramLong);
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  static final class b
  {
    public DrmInitData aMT;
    public int aMX = -1;
    public byte[] aMY = null;
    public com.google.android.exoplayer2.c.m aSe;
    public int aSh;
    public int aTA = -1;
    public int aTB = 1000;
    public int aTC = 200;
    public float aTD = -1.0F;
    public float aTE = -1.0F;
    public float aTF = -1.0F;
    public float aTG = -1.0F;
    public float aTH = -1.0F;
    public float aTI = -1.0F;
    public float aTJ = -1.0F;
    public float aTK = -1.0F;
    public float aTL = -1.0F;
    public float aTM = -1.0F;
    public int aTN = -1;
    public long aTO = 0L;
    public long aTP = 0L;
    public boolean aTQ;
    public boolean aTR = true;
    public String aTs;
    public int aTt;
    public boolean aTu;
    public byte[] aTv;
    public m.a aTw;
    public byte[] aTx;
    public int aTy = 0;
    public boolean aTz = false;
    public int channelCount = 1;
    public int colorRange = -1;
    public int colorTransfer = -1;
    public int displayHeight = -1;
    public int displayWidth = -1;
    public int height = -1;
    String language = "eng";
    public int number;
    public int sampleRate = 8000;
    public int type;
    public int width = -1;
    
    static List<byte[]> i(com.google.android.exoplayer2.i.m paramm)
    {
      AppMethodBeat.i(92011);
      try
      {
        paramm.fu(16);
        long l = paramm.vk();
        if (l != 826496599L)
        {
          AppMethodBeat.o(92011);
          return null;
        }
        int i = paramm.position + 20;
        paramm = paramm.data;
        while (i < paramm.length - 4)
        {
          if ((paramm[i] == 0) && (paramm[(i + 1)] == 0) && (paramm[(i + 2)] == 1) && (paramm[(i + 3)] == 15))
          {
            paramm = Collections.singletonList(Arrays.copyOfRange(paramm, i, paramm.length));
            AppMethodBeat.o(92011);
            return paramm;
          }
          i += 1;
        }
        paramm = new o("Failed to find FourCC VC1 initialization data");
        AppMethodBeat.o(92011);
        throw paramm;
      }
      catch (ArrayIndexOutOfBoundsException paramm)
      {
        paramm = new o("Error parsing FourCC VC1 codec private");
        AppMethodBeat.o(92011);
        throw paramm;
      }
    }
    
    static boolean j(com.google.android.exoplayer2.i.m paramm)
    {
      AppMethodBeat.i(92013);
      try
      {
        int i = paramm.vi();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.sw().getMostSignificantBits()) && (paramm.readLong() == d.sw().getLeastSignificantBits()))
        {
          AppMethodBeat.o(92013);
          return true;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramm)
      {
        paramm = new o("Error parsing MS/ACM codec private");
        AppMethodBeat.o(92013);
        throw paramm;
      }
      AppMethodBeat.o(92013);
      return false;
      label94:
      AppMethodBeat.o(92013);
      return false;
    }
    
    static List<byte[]> o(byte[] paramArrayOfByte)
    {
      int k = 0;
      AppMethodBeat.i(92012);
      if (paramArrayOfByte[0] != 2) {
        try
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(92012);
          throw paramArrayOfByte;
        }
        catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(92012);
          throw paramArrayOfByte;
        }
      }
      int i = 0;
      int j = 1;
      while (paramArrayOfByte[j] == -1)
      {
        j += 1;
        i += 255;
      }
      for (;;)
      {
        k = j + 1;
        j = paramArrayOfByte[j];
        if (paramArrayOfByte[k] != 1)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(92012);
          throw paramArrayOfByte;
        }
        byte[] arrayOfByte1 = new byte[n];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, n);
        k = n + k;
        if (paramArrayOfByte[k] != 3)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(92012);
          throw paramArrayOfByte;
        }
        i = i + j + k;
        if (paramArrayOfByte[i] != 5)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(92012);
          throw paramArrayOfByte;
        }
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
        paramArrayOfByte = new ArrayList(2);
        paramArrayOfByte.add(arrayOfByte1);
        paramArrayOfByte.add(arrayOfByte2);
        AppMethodBeat.o(92012);
        return paramArrayOfByte;
        int m = j + 1;
        int n = i + paramArrayOfByte[j];
        j = m;
        i = k;
        while (paramArrayOfByte[j] == -1)
        {
          i += 255;
          j += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d
 * JD-Core Version:    0.7.0.1
 */