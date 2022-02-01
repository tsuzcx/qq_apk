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
  private static final byte[] biM;
  private static final byte[] biN;
  private static long biO;
  static final byte[] biP;
  private static final byte[] biQ;
  private static long biR;
  private static final byte[] biS;
  private static final UUID biT;
  public static final com.google.android.exoplayer2.c.h bil;
  long bdJ;
  private final com.google.android.exoplayer2.i.m biB;
  private final com.google.android.exoplayer2.i.m biC;
  final f biG;
  private final b biU;
  final SparseArray<b> biV;
  final boolean biW;
  private final com.google.android.exoplayer2.i.m biX;
  final com.google.android.exoplayer2.i.m biY;
  private final com.google.android.exoplayer2.i.m biZ;
  final com.google.android.exoplayer2.i.m bin;
  g bir;
  int bjA;
  int bjB;
  private int bjC;
  private boolean bjD;
  private boolean bjE;
  private boolean bjF;
  private boolean bjG;
  private byte bjH;
  private int bjI;
  private int bjJ;
  private int bjK;
  private boolean bjL;
  boolean bjM;
  private final com.google.android.exoplayer2.i.m bja;
  private final com.google.android.exoplayer2.i.m bjb;
  private final com.google.android.exoplayer2.i.m bjc;
  private ByteBuffer bjd;
  long bje;
  long bjf;
  long bjg;
  long bjh;
  b bji;
  boolean bjj;
  int bjk;
  long bjl;
  boolean bjm;
  long bjn;
  private long bjo;
  long bjp;
  com.google.android.exoplayer2.i.h bjq;
  com.google.android.exoplayer2.i.h bjr;
  boolean bjs;
  int bjt;
  long bju;
  long bjv;
  int bjw;
  int bjx;
  int[] bjy;
  int bjz;
  
  static
  {
    AppMethodBeat.i(92029);
    bil = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] ux()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    biM = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    biN = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    biO = 1000L;
    biP = x.bG("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    biQ = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    biR = 10000L;
    biS = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    biT = new UUID(72057594037932032L, -9223371306706625679L);
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
    this.bjf = -1L;
    this.bjg = -9223372036854775807L;
    this.bjh = -9223372036854775807L;
    this.bdJ = -9223372036854775807L;
    this.bjn = -1L;
    this.bjo = -1L;
    this.bjp = -9223372036854775807L;
    this.biU = paramb;
    this.biU.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.biW = bool;
    this.biG = new f();
    this.biV = new SparseArray();
    this.bin = new com.google.android.exoplayer2.i.m(4);
    this.biX = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.biY = new com.google.android.exoplayer2.i.m(4);
    this.biB = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bGT);
    this.biC = new com.google.android.exoplayer2.i.m(4);
    this.biZ = new com.google.android.exoplayer2.i.m();
    this.bja = new com.google.android.exoplayer2.i.m();
    this.bjb = new com.google.android.exoplayer2.i.m(8);
    this.bjc = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.biZ.xd();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.biZ, paramInt);
    }
    for (;;)
    {
      this.bjC += paramInt;
      this.bjK += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.bja.data, this.bjv, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.biA.a(this.bja, this.bja.limit);
    this.bjK += this.bja.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.bja.capacity() < i) {
      this.bja.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.bja.data, paramArrayOfByte.length, paramInt);
      this.bja.reset(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.bja.data, 0, paramArrayOfByte.length);
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
  
  static int dX(int paramInt)
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
  
  static boolean dY(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  private void uA()
  {
    AppMethodBeat.i(92020);
    this.bjC = 0;
    this.bjK = 0;
    this.bjJ = 0;
    this.bjD = false;
    this.bjE = false;
    this.bjG = false;
    this.bjI = 0;
    this.bjH = 0;
    this.bjF = false;
    this.biZ.reset();
    AppMethodBeat.o(92020);
  }
  
  final long M(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.bjg == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.b(paramLong, this.bjg, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.bjL = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.bjL))
      {
        bool = this.biU.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.bjm)
        {
          this.bjo = l;
          paramk.position = this.bjn;
          this.bjm = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.bjj) && (this.bjo != -1L))
        {
          paramk.position = this.bjo;
          this.bjo = -1L;
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
    if ("S_TEXT/UTF8".equals(paramb.bjO)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, biO, biN);
    }
    for (;;)
    {
      paramb.biA.a(paramLong, this.bjB, this.bjK, 0, paramb.bjS);
      this.bjL = true;
      uA();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.bjO)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, biR, biS);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.bjO))
    {
      a(paramf, biM, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.bjO))
    {
      a(paramf, biQ, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.biA;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.bjD)
    {
      if (!paramb.bjQ) {
        break label922;
      }
      this.bjB &= 0xBFFFFFFF;
      if (!this.bjE)
      {
        paramf.readFully(this.bin.data, 0, 1);
        this.bjC += 1;
        if ((this.bin.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.bjH = this.bin.data[0];
        this.bjE = true;
      }
      int m;
      if ((this.bjH & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.bjH & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.bjB |= 0x40000000;
        if (!this.bjF)
        {
          paramf.readFully(this.bjb.data, 0, 8);
          this.bjC += 8;
          this.bjF = true;
          arrayOfByte = this.bin.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.bin.setPosition(0);
          localm.a(this.bin, 1);
          this.bjK += 1;
          this.bjb.setPosition(0);
          localm.a(this.bjb, 8);
          this.bjK += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.bjG)
        {
          paramf.readFully(this.bin.data, 0, 1);
          this.bjC += 1;
          this.bin.setPosition(0);
          this.bjI = this.bin.readUnsignedByte();
          this.bjG = true;
        }
        i = this.bjI * 4;
        this.bin.reset(i);
        paramf.readFully(this.bin.data, 0, i);
        this.bjC = (i + this.bjC);
        short s = (short)(this.bjI / 2 + 1);
        m = s * 6 + 2;
        if ((this.bjd == null) || (this.bjd.capacity() < m)) {
          this.bjd = ByteBuffer.allocate(m);
        }
        this.bjd.position(0);
        this.bjd.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.bjI) {
          break label621;
        }
        k = this.bin.xk();
        if (j % 2 != 0) {
          break label605;
        }
        this.bjd.putShort((short)(k - i));
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
        this.bjd.putInt(k - i);
      }
      label621:
      i = paramInt - this.bjC - i;
      if (this.bjI % 2 == 1)
      {
        this.bjd.putInt(i);
        this.bjc.n(this.bjd.array(), m);
        localm.a(this.bjc, m);
        this.bjK += m;
        label692:
        this.bjD = true;
      }
    }
    else
    {
      paramInt = this.biZ.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.bjO)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.bjO))) {
        break label971;
      }
      arrayOfByte = this.biC.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.biD;
      j = 4 - paramb.biD;
    }
    for (;;)
    {
      if (this.bjC < paramInt)
      {
        if (this.bjJ == 0)
        {
          k = Math.min(i, this.biZ.xd());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.biZ.readBytes(arrayOfByte, j, k);
          }
          this.bjC += i;
          this.biC.setPosition(0);
          this.bjJ = this.biC.xk();
          this.biB.setPosition(0);
          localm.a(this.biB, 4);
          this.bjK += 4;
          continue;
          this.bjd.putShort((short)i);
          this.bjd.putInt(0);
          break;
          label922:
          if (paramb.bjR == null) {
            break label692;
          }
          this.biZ.n(paramb.bjR, paramb.bjR.length);
          break label692;
        }
        this.bjJ -= a(paramf, localm, this.bjJ);
        continue;
        label971:
        while (this.bjC < paramInt) {
          a(paramf, localm, paramInt - this.bjC);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.bjO))
    {
      this.biX.setPosition(0);
      localm.a(this.biX, 4);
      this.bjK += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.bir = paramg;
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
      paramf.b(locale.bin.data, 0, 4);
      l1 = locale.bin.dE();
      locale.bkq = 4;
      while (l1 != 440786851L)
      {
        int j = locale.bkq + 1;
        locale.bkq = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.bin.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.bin.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.bkq;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.dQ((int)l2);
        locale.bkq = ((int)(l2 + locale.bkq));
      }
      if (locale.bkq >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.bkq == l1 + l3)
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
    if (this.bin.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.bin.capacity() < paramInt) {
      this.bin.n(Arrays.copyOf(this.bin.data, Math.max(this.bin.data.length * 2, paramInt)), this.bin.limit);
    }
    paramf.readFully(this.bin.data, this.bin.limit, paramInt - this.bin.limit);
    this.bin.eY(paramInt);
    AppMethodBeat.o(92021);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.bjp = -9223372036854775807L;
    this.bjt = 0;
    this.biU.reset();
    this.biG.reset();
    uA();
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
        Arrays.fill(locald.biY.data, (byte)0);
        paramf.readFully(locald.biY.data, 4 - paramInt2, paramInt2);
        locald.biY.setPosition(0);
        locald.bjk = ((int)locald.biY.dE());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.bji.bjT = new byte[paramInt2];
        paramf.readFully(locald.bji.bjT, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.bji.bdy = new byte[paramInt2];
        paramf.readFully(locald.bji.bdy, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.bji.bjR = new byte[paramInt2];
        paramf.readFully(locald.bji.bjR, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.bji.bjS = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.bjt == 0)
      {
        locald.bjz = ((int)locald.biG.a(paramf, false, true, 8));
        locald.bjA = locald.biG.length;
        locald.bjv = -9223372036854775807L;
        locald.bjt = 1;
        locald.bin.reset();
      }
      Object localObject1 = (d.b)locald.biV.get(locald.bjz);
      if (localObject1 == null)
      {
        paramf.dP(paramInt2 - locald.bjA);
        locald.bjt = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.bjt == 1)
      {
        locald.b(paramf, 3);
        i = (locald.bin.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.bjx = 1;
        locald.bjy = d.d(locald.bjy, 1);
        locald.bjy[0] = (paramInt2 - locald.bjA - 3);
        paramInt2 = locald.bin.data[0];
        i = locald.bin.data[1];
        locald.bju = (locald.bjp + locald.M(paramInt2 << 8 | i & 0xFF));
        if ((locald.bin.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.bin.data[2] & 0x80) != 128))) {
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
        locald.bjB = (paramInt2 | i);
        locald.bjt = 2;
        locald.bjw = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.bjw < locald.bjx)
        {
          locald.a(paramf, (d.b)localObject1, locald.bjy[locald.bjw]);
          locald.a((d.b)localObject1, locald.bju + locald.bjw * ((d.b)localObject1).bjP / 1000);
          locald.bjw += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.bjx = ((locald.bin.data[3] & 0xFF) + 1);
        locald.bjy = d.d(locald.bjy, locald.bjx);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.bjA - 4) / locald.bjx;
          Arrays.fill(locald.bjy, 0, locald.bjx, paramInt2);
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
          while (k < locald.bjx - 1)
          {
            locald.bjy[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.bin.data[(i - 1)] & 0xFF;
              localObject2 = locald.bjy;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.bjy[k];
            k += 1;
          }
          locald.bjy[(locald.bjx - 1)] = (paramInt2 - locald.bjA - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.bjx - 1)
          {
            locald.bjy[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.bin.data[(n - 1)] == 0)
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
                if ((locald.bin.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.bin.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.bin.data[i] & 0xFF;
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
            localObject2 = locald.bjy;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.bjy[k];
              k += 1;
              break;
              m += locald.bjy[(k - 1)];
            }
          }
          locald.bjy[(locald.bjx - 1)] = (paramInt2 - locald.bjA - i - j);
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
      locald.bjt = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.bjy[0]);
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
        locald.bjh = (paramDouble);
        return;
      case 181: 
        locald.bji.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.bji.bkb = ((float)paramDouble);
        return;
      case 21970: 
        locald.bji.bkc = ((float)paramDouble);
        return;
      case 21971: 
        locald.bji.bkd = ((float)paramDouble);
        return;
      case 21972: 
        locald.bji.bke = ((float)paramDouble);
        return;
      case 21973: 
        locald.bji.bkf = ((float)paramDouble);
        return;
      case 21974: 
        locald.bji.bkg = ((float)paramDouble);
        return;
      case 21975: 
        locald.bji.bkh = ((float)paramDouble);
        return;
      case 21976: 
        locald.bji.bki = ((float)paramDouble);
        return;
      case 21977: 
        locald.bji.bkj = ((float)paramDouble);
        return;
      }
      locald.bji.bkk = ((float)paramDouble);
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
          locald.bji.bjO = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.bji.language = paramString;
        }
      }
    }
    
    public final int dX(int paramInt)
    {
      AppMethodBeat.i(92004);
      paramInt = d.dX(paramInt);
      AppMethodBeat.o(92004);
      return paramInt;
    }
    
    public final boolean dY(int paramInt)
    {
      AppMethodBeat.i(92005);
      boolean bool = d.dY(paramInt);
      AppMethodBeat.o(92005);
      return bool;
    }
    
    public final void dZ(int paramInt)
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
        if (locald.bjg == -9223372036854775807L) {
          locald.bjg = 1000000L;
        }
        if (locald.bjh != -9223372036854775807L)
        {
          locald.bdJ = locald.M(locald.bjh);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.bjk == -1) || (locald.bjl == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.bjk == 475249515)
          {
            locald.bjn = locald.bjl;
            AppMethodBeat.o(92007);
            return;
            if (!locald.bjj)
            {
              Object localObject2 = locald.bir;
              if ((locald.bjf == -1L) || (locald.bdJ == -9223372036854775807L) || (locald.bjq == null) || (locald.bjq.size == 0) || (locald.bjr == null) || (locald.bjr.size != locald.bjq.size))
              {
                locald.bjq = null;
                locald.bjr = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.bdJ);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.bjj = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.bjq.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.bjq.get(paramInt);
                  localObject3[paramInt] = (locald.bjf + locald.bjr.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.bjf + locald.bje - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.bdJ - localObject5[(i - 1)]);
                locald.bjq = null;
                locald.bjr = null;
              }
              if (locald.bjt == 2)
              {
                if (!locald.bjM) {
                  locald.bjB |= 0x1;
                }
                locald.a((d.b)locald.biV.get(locald.bjz), locald.bju);
                locald.bjt = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.bji.bjQ)
                {
                  if (locald.bji.bjS == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.bji.bdt = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.bbJ, "video/webm", locald.bji.bjS.bih) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.bji.bjQ) && (locald.bji.bjR != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.bji.bjO;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.bji;
                      localObject5 = locald.bir;
                      m = locald.bji.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).bjO;
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
                    if (((d.b)localObject4).bkp)
                    {
                      j = 1;
                      if (!((d.b)localObject4).bko) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.bx((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).bdt, j, ((d.b)localObject4).language);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).biA = ((g)localObject5).dV(((d.b)localObject4).number);
                      ((d.b)localObject4).biA.f((Format)localObject1);
                      locald.biV.put(locald.bji.number, locald.bji);
                      label2178:
                      locald.bji = null;
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
                      if (((d.b)localObject4).bjT == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).bjT))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjT));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).bds;
                      ((d.b)localObject4).biD = ((com.google.android.exoplayer2.video.a)localObject3).biD;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjT));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).bds;
                      ((d.b)localObject4).biD = ((com.google.android.exoplayer2.video.b)localObject3).biD;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjT));
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
                      localObject2 = d.b.q(((d.b)localObject4).bjT);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).bjT);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).bkm).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).bkn).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjT);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjT);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).bjT)))
                      {
                        k = x.fg(((d.b)localObject4).bkl);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).bkl).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.fg(((d.b)localObject4).bkl);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).bkl).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).bjT);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.bjT[0], localObject4.bjT[1], localObject4.bjT[2], localObject4.bjT[3] });
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
                        if (((d.b)localObject4).bjU == 0)
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
                          if (((d.b)localObject4).bjV)
                          {
                            if ((((d.b)localObject4).bkb != -1.0F) && (((d.b)localObject4).bkc != -1.0F) && (((d.b)localObject4).bkd != -1.0F) && (((d.b)localObject4).bke != -1.0F) && (((d.b)localObject4).bkf != -1.0F) && (((d.b)localObject4).bkg != -1.0F) && (((d.b)localObject4).bkh != -1.0F) && (((d.b)localObject4).bki != -1.0F) && (((d.b)localObject4).bkj != -1.0F) && (((d.b)localObject4).bkk != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).bjW, ((d.b)localObject4).bjY, ((d.b)localObject4).bjX, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).bdy, ((d.b)localObject4).bdx, (ColorInfo)localObject3, ((d.b)localObject4).bdt);
                          break;
                          i = ((d.b)localObject4).displayWidth;
                          break label3041;
                          i = ((d.b)localObject4).displayHeight;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkb * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkc * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkd * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bke * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkf * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkg * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkh * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bki * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkj + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).bkk + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).bjZ);
                          localByteBuffer.putShort((short)((d.b)localObject4).bka);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, ((d.b)localObject4).bdt);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.biP);
                        ((List)localObject2).add(((d.b)localObject4).bjT);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, -1, ((d.b)localObject4).bdt, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).language, ((d.b)localObject4).bdt);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.biV.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.bir.uy();
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
        if ((((d)localObject).bjf != -1L) && (((d)localObject).bjf != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).bjf = paramLong1;
        ((d)localObject).bje = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjk = -1;
        ((d)localObject).bjl = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjq = new com.google.android.exoplayer2.i.h();
        ((d)localObject).bjr = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).bjs = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).bjj)
        {
          if ((((d)localObject).biW) && (((d)localObject).bjn != -1L))
          {
            ((d)localObject).bjm = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).bir.a(new l.a(((d)localObject).bdJ));
          ((d)localObject).bjj = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bjM = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bji.bjQ = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bji = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).bji.bjV = true;
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
            ((d)localObject).bjl = (((d)localObject).bjf + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjg = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.displayWidth = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.displayHeight = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.bjU = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).bji;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).bko = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).bji;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).bkp = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).bji.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.bjP = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.bkm = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.bkn = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bji.bkl = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).bjM = true;
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
                      ((d)localObject).bjq.add(((d)localObject).M(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).bjs)
                      {
                        ((d)localObject).bjr.add(paramLong);
                        ((d)localObject).bjs = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjp = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bjv = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).bji.bdx = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bji.bdx = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).bji.bdx = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bji.bdx = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bji.bjV = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bji.bjW = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).bji.bjW = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bji.bjW = 6;
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
                          ((d)localObject).bji.bjX = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).bji.bjX = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bji.bjX = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).bji.bjY = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).bji.bjY = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bji.bjZ = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).bji.bka = ((int)paramLong);
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
    public DrmInitData bdt;
    public int bdx = -1;
    public byte[] bdy = null;
    public com.google.android.exoplayer2.c.m biA;
    public int biD;
    public String bjO;
    public int bjP;
    public boolean bjQ;
    public byte[] bjR;
    public m.a bjS;
    public byte[] bjT;
    public int bjU = 0;
    public boolean bjV = false;
    public int bjW = -1;
    public int bjX = -1;
    public int bjY = -1;
    public int bjZ = 1000;
    public int bka = 200;
    public float bkb = -1.0F;
    public float bkc = -1.0F;
    public float bkd = -1.0F;
    public float bke = -1.0F;
    public float bkf = -1.0F;
    public float bkg = -1.0F;
    public float bkh = -1.0F;
    public float bki = -1.0F;
    public float bkj = -1.0F;
    public float bkk = -1.0F;
    public int bkl = -1;
    public long bkm = 0L;
    public long bkn = 0L;
    public boolean bko;
    public boolean bkp = true;
    public int channelCount = 1;
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
        paramm.eZ(16);
        long l = paramm.xg();
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
        int i = paramm.xe();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.uB().getMostSignificantBits()) && (paramm.readLong() == d.uB().getLeastSignificantBits()))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d
 * JD-Core Version:    0.7.0.1
 */