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
  private static final byte[] biP;
  private static final byte[] biQ;
  private static long biR;
  static final byte[] biS;
  private static final byte[] biT;
  private static long biU;
  private static final byte[] biV;
  private static final UUID biW;
  public static final com.google.android.exoplayer2.c.h bio;
  long bdM;
  private final com.google.android.exoplayer2.i.m biE;
  private final com.google.android.exoplayer2.i.m biF;
  final f biJ;
  private final b biX;
  final SparseArray<b> biY;
  final boolean biZ;
  final com.google.android.exoplayer2.i.m biq;
  g biu;
  int bjA;
  int[] bjB;
  int bjC;
  int bjD;
  int bjE;
  private int bjF;
  private boolean bjG;
  private boolean bjH;
  private boolean bjI;
  private boolean bjJ;
  private byte bjK;
  private int bjL;
  private int bjM;
  private int bjN;
  private boolean bjO;
  boolean bjP;
  private final com.google.android.exoplayer2.i.m bja;
  final com.google.android.exoplayer2.i.m bjb;
  private final com.google.android.exoplayer2.i.m bjc;
  private final com.google.android.exoplayer2.i.m bjd;
  private final com.google.android.exoplayer2.i.m bje;
  private final com.google.android.exoplayer2.i.m bjf;
  private ByteBuffer bjg;
  long bjh;
  long bji;
  long bjj;
  long bjk;
  b bjl;
  boolean bjm;
  int bjn;
  long bjo;
  boolean bjp;
  long bjq;
  private long bjr;
  long bjs;
  com.google.android.exoplayer2.i.h bjt;
  com.google.android.exoplayer2.i.h bju;
  boolean bjv;
  int bjw;
  long bjx;
  long bjy;
  int bjz;
  
  static
  {
    AppMethodBeat.i(92029);
    bio = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] us()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    biP = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    biQ = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    biR = 1000L;
    biS = x.bG("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    biT = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    biU = 10000L;
    biV = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    biW = new UUID(72057594037932032L, -9223371306706625679L);
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
    this.bji = -1L;
    this.bjj = -9223372036854775807L;
    this.bjk = -9223372036854775807L;
    this.bdM = -9223372036854775807L;
    this.bjq = -1L;
    this.bjr = -1L;
    this.bjs = -9223372036854775807L;
    this.biX = paramb;
    this.biX.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.biZ = bool;
    this.biJ = new f();
    this.biY = new SparseArray();
    this.biq = new com.google.android.exoplayer2.i.m(4);
    this.bja = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.bjb = new com.google.android.exoplayer2.i.m(4);
    this.biE = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGC);
    this.biF = new com.google.android.exoplayer2.i.m(4);
    this.bjc = new com.google.android.exoplayer2.i.m();
    this.bjd = new com.google.android.exoplayer2.i.m();
    this.bje = new com.google.android.exoplayer2.i.m(8);
    this.bjf = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.bjc.wV();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.bjc, paramInt);
    }
    for (;;)
    {
      this.bjF += paramInt;
      this.bjN += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.bjd.data, this.bjy, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.biD.a(this.bjd, this.bjd.limit);
    this.bjN += this.bjd.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.bjd.capacity() < i) {
      this.bjd.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.bjd.data, paramArrayOfByte.length, paramInt);
      this.bjd.reset(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.bjd.data, 0, paramArrayOfByte.length);
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
    for (paramString = paramArrayOfByte2;; paramString = x.bG(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
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
  
  static int ed(int paramInt)
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
  
  static boolean ee(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  private void uv()
  {
    AppMethodBeat.i(92020);
    this.bjF = 0;
    this.bjN = 0;
    this.bjM = 0;
    this.bjG = false;
    this.bjH = false;
    this.bjJ = false;
    this.bjL = 0;
    this.bjK = 0;
    this.bjI = false;
    this.bjc.reset();
    AppMethodBeat.o(92020);
  }
  
  final long M(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.bjj == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.b(paramLong, this.bjj, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.bjO = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.bjO))
      {
        bool = this.biX.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.bjp)
        {
          this.bjr = l;
          paramk.position = this.bjq;
          this.bjp = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.bjm) && (this.bjr != -1L))
        {
          paramk.position = this.bjr;
          this.bjr = -1L;
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
    if ("S_TEXT/UTF8".equals(paramb.bjR)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, biR, biQ);
    }
    for (;;)
    {
      paramb.biD.a(paramLong, this.bjE, this.bjN, 0, paramb.bjV);
      this.bjO = true;
      uv();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.bjR)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, biU, biV);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.bjR))
    {
      a(paramf, biP, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.bjR))
    {
      a(paramf, biT, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.biD;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.bjG)
    {
      if (!paramb.bjT) {
        break label922;
      }
      this.bjE &= 0xBFFFFFFF;
      if (!this.bjH)
      {
        paramf.readFully(this.biq.data, 0, 1);
        this.bjF += 1;
        if ((this.biq.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.bjK = this.biq.data[0];
        this.bjH = true;
      }
      int m;
      if ((this.bjK & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.bjK & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.bjE |= 0x40000000;
        if (!this.bjI)
        {
          paramf.readFully(this.bje.data, 0, 8);
          this.bjF += 8;
          this.bjI = true;
          arrayOfByte = this.biq.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.biq.setPosition(0);
          localm.a(this.biq, 1);
          this.bjN += 1;
          this.bje.setPosition(0);
          localm.a(this.bje, 8);
          this.bjN += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.bjJ)
        {
          paramf.readFully(this.biq.data, 0, 1);
          this.bjF += 1;
          this.biq.setPosition(0);
          this.bjL = this.biq.readUnsignedByte();
          this.bjJ = true;
        }
        i = this.bjL * 4;
        this.biq.reset(i);
        paramf.readFully(this.biq.data, 0, i);
        this.bjF = (i + this.bjF);
        short s = (short)(this.bjL / 2 + 1);
        m = s * 6 + 2;
        if ((this.bjg == null) || (this.bjg.capacity() < m)) {
          this.bjg = ByteBuffer.allocate(m);
        }
        this.bjg.position(0);
        this.bjg.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.bjL) {
          break label621;
        }
        k = this.biq.xc();
        if (j % 2 != 0) {
          break label605;
        }
        this.bjg.putShort((short)(k - i));
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
        this.bjg.putInt(k - i);
      }
      label621:
      i = paramInt - this.bjF - i;
      if (this.bjL % 2 == 1)
      {
        this.bjg.putInt(i);
        this.bjf.n(this.bjg.array(), m);
        localm.a(this.bjf, m);
        this.bjN += m;
        label692:
        this.bjG = true;
      }
    }
    else
    {
      paramInt = this.bjc.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.bjR)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.bjR))) {
        break label971;
      }
      arrayOfByte = this.biF.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.biG;
      j = 4 - paramb.biG;
    }
    for (;;)
    {
      if (this.bjF < paramInt)
      {
        if (this.bjM == 0)
        {
          k = Math.min(i, this.bjc.wV());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.bjc.readBytes(arrayOfByte, j, k);
          }
          this.bjF += i;
          this.biF.setPosition(0);
          this.bjM = this.biF.xc();
          this.biE.setPosition(0);
          localm.a(this.biE, 4);
          this.bjN += 4;
          continue;
          this.bjg.putShort((short)i);
          this.bjg.putInt(0);
          break;
          label922:
          if (paramb.bjU == null) {
            break label692;
          }
          this.bjc.n(paramb.bjU, paramb.bjU.length);
          break label692;
        }
        this.bjM -= a(paramf, localm, this.bjM);
        continue;
        label971:
        while (this.bjF < paramInt) {
          a(paramf, localm, paramInt - this.bjF);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.bjR))
    {
      this.bja.setPosition(0);
      localm.a(this.bja, 4);
      this.bjN += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.biu = paramg;
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92016);
    e locale = new e();
    long l2 = paramf.getLength();
    if ((l2 == -1L) || (l2 > 1024L)) {}
    for (long l1 = 1024L;; l1 = l2)
    {
      int i = (int)l1;
      paramf.b(locale.biq.data, 0, 4);
      l1 = locale.biq.dB();
      locale.bkv = 4;
      while (l1 != 440786851L)
      {
        int j = locale.bkv + 1;
        locale.bkv = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.biq.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.biq.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.bkv;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.dV((int)l2);
        locale.bkv = ((int)(l2 + locale.bkv));
      }
      if (locale.bkv >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.bkv == l1 + l3)
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
    if (this.biq.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.biq.capacity() < paramInt) {
      this.biq.n(Arrays.copyOf(this.biq.data, Math.max(this.biq.data.length * 2, paramInt)), this.biq.limit);
    }
    paramf.readFully(this.biq.data, this.biq.limit, paramInt - this.biq.limit);
    this.biq.eZ(paramInt);
    AppMethodBeat.o(92021);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.bjs = -9223372036854775807L;
    this.bjw = 0;
    this.biX.reset();
    this.biJ.reset();
    uv();
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
        Arrays.fill(locald.bjb.data, (byte)0);
        paramf.readFully(locald.bjb.data, 4 - paramInt2, paramInt2);
        locald.bjb.setPosition(0);
        locald.bjn = ((int)locald.bjb.dB());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.bjl.bjW = new byte[paramInt2];
        paramf.readFully(locald.bjl.bjW, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.bjl.bdB = new byte[paramInt2];
        paramf.readFully(locald.bjl.bdB, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.bjl.bjU = new byte[paramInt2];
        paramf.readFully(locald.bjl.bjU, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.bjl.bjV = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.bjw == 0)
      {
        locald.bjC = ((int)locald.biJ.a(paramf, false, true, 8));
        locald.bjD = locald.biJ.length;
        locald.bjy = -9223372036854775807L;
        locald.bjw = 1;
        locald.biq.reset();
      }
      Object localObject1 = (d.b)locald.biY.get(locald.bjC);
      if (localObject1 == null)
      {
        paramf.dU(paramInt2 - locald.bjD);
        locald.bjw = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.bjw == 1)
      {
        locald.b(paramf, 3);
        i = (locald.biq.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.bjA = 1;
        locald.bjB = d.d(locald.bjB, 1);
        locald.bjB[0] = (paramInt2 - locald.bjD - 3);
        paramInt2 = locald.biq.data[0];
        i = locald.biq.data[1];
        locald.bjx = (locald.bjs + locald.M(paramInt2 << 8 | i & 0xFF));
        if ((locald.biq.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.biq.data[2] & 0x80) != 128))) {
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
        locald.bjE = (paramInt2 | i);
        locald.bjw = 2;
        locald.bjz = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.bjz < locald.bjA)
        {
          locald.a(paramf, (d.b)localObject1, locald.bjB[locald.bjz]);
          locald.a((d.b)localObject1, locald.bjx + locald.bjz * ((d.b)localObject1).bjS / 1000);
          locald.bjz += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.bjA = ((locald.biq.data[3] & 0xFF) + 1);
        locald.bjB = d.d(locald.bjB, locald.bjA);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.bjD - 4) / locald.bjA;
          Arrays.fill(locald.bjB, 0, locald.bjA, paramInt2);
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
          while (k < locald.bjA - 1)
          {
            locald.bjB[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.biq.data[(i - 1)] & 0xFF;
              localObject2 = locald.bjB;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.bjB[k];
            k += 1;
          }
          locald.bjB[(locald.bjA - 1)] = (paramInt2 - locald.bjD - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.bjA - 1)
          {
            locald.bjB[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.biq.data[(n - 1)] == 0)
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
                if ((locald.biq.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.biq.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.biq.data[i] & 0xFF;
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
            localObject2 = locald.bjB;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.bjB[k];
              k += 1;
              break;
              m += locald.bjB[(k - 1)];
            }
          }
          locald.bjB[(locald.bjA - 1)] = (paramInt2 - locald.bjD - i - j);
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
      locald.bjw = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.bjB[0]);
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
        locald.bjk = (paramDouble);
        return;
      case 181: 
        locald.bjl.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.bjl.bkg = ((float)paramDouble);
        return;
      case 21970: 
        locald.bjl.bkh = ((float)paramDouble);
        return;
      case 21971: 
        locald.bjl.bki = ((float)paramDouble);
        return;
      case 21972: 
        locald.bjl.bkj = ((float)paramDouble);
        return;
      case 21973: 
        locald.bjl.bkk = ((float)paramDouble);
        return;
      case 21974: 
        locald.bjl.bkl = ((float)paramDouble);
        return;
      case 21975: 
        locald.bjl.bkm = ((float)paramDouble);
        return;
      case 21976: 
        locald.bjl.bkn = ((float)paramDouble);
        return;
      case 21977: 
        locald.bjl.bko = ((float)paramDouble);
        return;
      }
      locald.bjl.bkp = ((float)paramDouble);
    }
    
    public final void b(int paramInt, String paramString)
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
          locald.bjl.bjR = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.bjl.language = paramString;
        }
      }
    }
    
    public final void e(int paramInt, long paramLong1, long paramLong2)
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
        if ((((d)localObject).bji != -1L) && (((d)localObject).bji != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).bji = paramLong1;
        ((d)localObject).bjh = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjn = -1;
        ((d)localObject).bjo = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjt = new com.google.android.exoplayer2.i.h();
        ((d)localObject).bju = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjv = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).bjm)
        {
          if ((((d)localObject).biZ) && (((d)localObject).bjq != -1L))
          {
            ((d)localObject).bjp = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).biu.a(new l.a(((d)localObject).bdM));
          ((d)localObject).bjm = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bjP = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bjl.bjT = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bjl = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bjl.bka = true;
        }
      }
    }
    
    public final int ed(int paramInt)
    {
      AppMethodBeat.i(92004);
      paramInt = d.ed(paramInt);
      AppMethodBeat.o(92004);
      return paramInt;
    }
    
    public final boolean ee(int paramInt)
    {
      AppMethodBeat.i(92005);
      boolean bool = d.ee(paramInt);
      AppMethodBeat.o(92005);
      return bool;
    }
    
    public final void ef(int paramInt)
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
        if (locald.bjj == -9223372036854775807L) {
          locald.bjj = 1000000L;
        }
        if (locald.bjk != -9223372036854775807L)
        {
          locald.bdM = locald.M(locald.bjk);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.bjn == -1) || (locald.bjo == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.bjn == 475249515)
          {
            locald.bjq = locald.bjo;
            AppMethodBeat.o(92007);
            return;
            if (!locald.bjm)
            {
              Object localObject2 = locald.biu;
              if ((locald.bji == -1L) || (locald.bdM == -9223372036854775807L) || (locald.bjt == null) || (locald.bjt.size == 0) || (locald.bju == null) || (locald.bju.size != locald.bjt.size))
              {
                locald.bjt = null;
                locald.bju = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.bdM);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.bjm = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.bjt.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.bjt.get(paramInt);
                  localObject3[paramInt] = (locald.bji + locald.bju.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.bji + locald.bjh - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.bdM - localObject5[(i - 1)]);
                locald.bjt = null;
                locald.bju = null;
              }
              if (locald.bjw == 2)
              {
                if (!locald.bjP) {
                  locald.bjE |= 0x1;
                }
                locald.a((d.b)locald.biY.get(locald.bjC), locald.bjx);
                locald.bjw = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.bjl.bjT)
                {
                  if (locald.bjl.bjV == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.bjl.bdw = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.bbM, "video/webm", locald.bjl.bjV.bik) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.bjl.bjT) && (locald.bjl.bjU != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.bjl.bjR;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.bjl;
                      localObject5 = locald.biu;
                      m = locald.bjl.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).bjR;
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
                    if (((d.b)localObject4).bku)
                    {
                      j = 1;
                      if (!((d.b)localObject4).bkt) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.bx((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).bdw, j, ((d.b)localObject4).language);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).biD = ((g)localObject5).eb(((d.b)localObject4).number);
                      ((d.b)localObject4).biD.f((Format)localObject1);
                      locald.biY.put(locald.bjl.number, locald.bjl);
                      label2178:
                      locald.bjl = null;
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
                      if (((d.b)localObject4).bjW == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).bjW))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjW));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).bdv;
                      ((d.b)localObject4).biG = ((com.google.android.exoplayer2.video.a)localObject3).biG;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjW));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).bdv;
                      ((d.b)localObject4).biG = ((com.google.android.exoplayer2.video.b)localObject3).biG;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjW));
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
                      localObject2 = d.b.q(((d.b)localObject4).bjW);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).bjW);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).bkr).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).bks).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjW);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjW);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjW)))
                      {
                        k = x.ff(((d.b)localObject4).bkq);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).bkq).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.ff(((d.b)localObject4).bkq);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).bkq).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjW);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.bjW[0], localObject4.bjW[1], localObject4.bjW[2], localObject4.bjW[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3003:
                      k = 0;
                      break label2071;
                      label3009:
                      if (j.by((String)localObject1))
                      {
                        label3041:
                        label3064:
                        float f1;
                        if (((d.b)localObject4).bjZ == 0)
                        {
                          if (((d.b)localObject4).bjX == -1)
                          {
                            i = ((d.b)localObject4).width;
                            ((d.b)localObject4).bjX = i;
                            if (((d.b)localObject4).bjY != -1) {
                              break label3340;
                            }
                            i = ((d.b)localObject4).height;
                            ((d.b)localObject4).bjY = i;
                          }
                        }
                        else
                        {
                          float f2 = -1.0F;
                          f1 = f2;
                          if (((d.b)localObject4).bjX != -1)
                          {
                            f1 = f2;
                            if (((d.b)localObject4).bjY != -1) {
                              f1 = ((d.b)localObject4).height * ((d.b)localObject4).bjX / (((d.b)localObject4).width * ((d.b)localObject4).bjY);
                            }
                          }
                          localObject3 = null;
                          if (((d.b)localObject4).bka)
                          {
                            if ((((d.b)localObject4).bkg != -1.0F) && (((d.b)localObject4).bkh != -1.0F) && (((d.b)localObject4).bki != -1.0F) && (((d.b)localObject4).bkj != -1.0F) && (((d.b)localObject4).bkk != -1.0F) && (((d.b)localObject4).bkl != -1.0F) && (((d.b)localObject4).bkm != -1.0F) && (((d.b)localObject4).bkn != -1.0F) && (((d.b)localObject4).bko != -1.0F) && (((d.b)localObject4).bkp != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).bkb, ((d.b)localObject4).bkd, ((d.b)localObject4).bkc, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).bdB, ((d.b)localObject4).bdA, (ColorInfo)localObject3, ((d.b)localObject4).bdw);
                          break;
                          i = ((d.b)localObject4).bjX;
                          break label3041;
                          i = ((d.b)localObject4).bjY;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkg * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkh * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bki * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkj * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkk * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkl * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkm * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkn * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bko + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkp + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).bke);
                          localByteBuffer.putShort((short)((d.b)localObject4).bkf);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, ((d.b)localObject4).bdw);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.biS);
                        ((List)localObject2).add(((d.b)localObject4).bjW);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, -1, ((d.b)localObject4).bdw, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).language, ((d.b)localObject4).bdw);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.biY.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.biu.ut();
                  }
                }
              }
            }
          }
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
            ((d)localObject).bjo = (((d)localObject).bji + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjj = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bjX = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bjY = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bjZ = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).bjl;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).bkt = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).bjl;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).bku = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).bjl.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bjS = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bkr = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bks = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjl.bkq = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjP = true;
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
                      ((d)localObject).bjt.add(((d)localObject).M(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).bjv)
                      {
                        ((d)localObject).bju.add(paramLong);
                        ((d)localObject).bjv = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjs = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjy = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).bjl.bdA = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bjl.bdA = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).bjl.bdA = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bjl.bdA = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjl.bka = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bjl.bkb = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).bjl.bkb = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bjl.bkb = 6;
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
                          ((d)localObject).bjl.bkc = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).bjl.bkc = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bjl.bkc = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bjl.bkd = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bjl.bkd = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjl.bke = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjl.bkf = ((int)paramLong);
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
    public int bdA = -1;
    public byte[] bdB = null;
    public DrmInitData bdw;
    public com.google.android.exoplayer2.c.m biD;
    public int biG;
    public String bjR;
    public int bjS;
    public boolean bjT;
    public byte[] bjU;
    public m.a bjV;
    public byte[] bjW;
    public int bjX = -1;
    public int bjY = -1;
    public int bjZ = 0;
    public boolean bka = false;
    public int bkb = -1;
    public int bkc = -1;
    public int bkd = -1;
    public int bke = 1000;
    public int bkf = 200;
    public float bkg = -1.0F;
    public float bkh = -1.0F;
    public float bki = -1.0F;
    public float bkj = -1.0F;
    public float bkk = -1.0F;
    public float bkl = -1.0F;
    public float bkm = -1.0F;
    public float bkn = -1.0F;
    public float bko = -1.0F;
    public float bkp = -1.0F;
    public int bkq = -1;
    public long bkr = 0L;
    public long bks = 0L;
    public boolean bkt;
    public boolean bku = true;
    public int channelCount = 1;
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
        paramm.fa(16);
        long l = paramm.wY();
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
        int i = paramm.wW();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.uw().getMostSignificantBits()) && (paramm.readLong() == d.uw().getLeastSignificantBits()))
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
    
    static List<byte[]> q(byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d
 * JD-Core Version:    0.7.0.1
 */