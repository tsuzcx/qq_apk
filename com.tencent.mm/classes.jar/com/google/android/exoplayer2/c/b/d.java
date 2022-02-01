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
  private static final byte[] aXI;
  private static final byte[] aXJ;
  private static long aXK;
  static final byte[] aXL;
  private static final byte[] aXM;
  private static long aXN;
  private static final byte[] aXO;
  private static final UUID aXP;
  public static final com.google.android.exoplayer2.c.h aXh;
  long aSz;
  final f aXC;
  private final b aXQ;
  final SparseArray<b> aXR;
  final boolean aXS;
  private final com.google.android.exoplayer2.i.m aXT;
  final com.google.android.exoplayer2.i.m aXU;
  private final com.google.android.exoplayer2.i.m aXV;
  private final com.google.android.exoplayer2.i.m aXW;
  private final com.google.android.exoplayer2.i.m aXX;
  private final com.google.android.exoplayer2.i.m aXY;
  private ByteBuffer aXZ;
  final com.google.android.exoplayer2.i.m aXj;
  g aXn;
  private final com.google.android.exoplayer2.i.m aXx;
  private final com.google.android.exoplayer2.i.m aXy;
  private boolean aYA;
  private boolean aYB;
  private boolean aYC;
  private byte aYD;
  private int aYE;
  private int aYF;
  private int aYG;
  private boolean aYH;
  boolean aYI;
  long aYa;
  long aYb;
  long aYc;
  long aYd;
  b aYe;
  boolean aYf;
  int aYg;
  long aYh;
  boolean aYi;
  long aYj;
  private long aYk;
  long aYl;
  com.google.android.exoplayer2.i.h aYm;
  com.google.android.exoplayer2.i.h aYn;
  boolean aYo;
  int aYp;
  long aYq;
  long aYr;
  int aYs;
  int aYt;
  int[] aYu;
  int aYv;
  int aYw;
  int aYx;
  private int aYy;
  private boolean aYz;
  
  static
  {
    AppMethodBeat.i(92029);
    aXh = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] sK()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    aXI = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    aXJ = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aXK = 1000L;
    aXL = x.aU("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    aXM = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    aXN = 10000L;
    aXO = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aXP = new UUID(72057594037932032L, -9223371306706625679L);
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
    this.aYb = -1L;
    this.aYc = -9223372036854775807L;
    this.aYd = -9223372036854775807L;
    this.aSz = -9223372036854775807L;
    this.aYj = -1L;
    this.aYk = -1L;
    this.aYl = -9223372036854775807L;
    this.aXQ = paramb;
    this.aXQ.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.aXS = bool;
    this.aXC = new f();
    this.aXR = new SparseArray();
    this.aXj = new com.google.android.exoplayer2.i.m(4);
    this.aXT = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.aXU = new com.google.android.exoplayer2.i.m(4);
    this.aXx = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.byG);
    this.aXy = new com.google.android.exoplayer2.i.m(4);
    this.aXV = new com.google.android.exoplayer2.i.m();
    this.aXW = new com.google.android.exoplayer2.i.m();
    this.aXX = new com.google.android.exoplayer2.i.m(8);
    this.aXY = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.aXV.vJ();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.aXV, paramInt);
    }
    for (;;)
    {
      this.aYy += paramInt;
      this.aYG += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.aXW.data, this.aYr, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.aXw.a(this.aXW, this.aXW.limit);
    this.aYG += this.aXW.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.aXW.capacity() < i) {
      this.aXW.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.aXW.data, paramArrayOfByte.length, paramInt);
      this.aXW.reset(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.aXW.data, 0, paramArrayOfByte.length);
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
    for (paramString = paramArrayOfByte2;; paramString = x.aU(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
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
  
  static int dY(int paramInt)
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
  
  static boolean dZ(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  private void sN()
  {
    AppMethodBeat.i(92020);
    this.aYy = 0;
    this.aYG = 0;
    this.aYF = 0;
    this.aYz = false;
    this.aYA = false;
    this.aYC = false;
    this.aYE = 0;
    this.aYD = 0;
    this.aYB = false;
    this.aXV.reset();
    AppMethodBeat.o(92020);
  }
  
  final long L(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.aYc == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.b(paramLong, this.aYc, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.aYH = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.aYH))
      {
        bool = this.aXQ.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.aYi)
        {
          this.aYk = l;
          paramk.position = this.aYj;
          this.aYi = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.aYf) && (this.aYk != -1L))
        {
          paramk.position = this.aYk;
          this.aYk = -1L;
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
    if ("S_TEXT/UTF8".equals(paramb.aYK)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, aXK, aXJ);
    }
    for (;;)
    {
      paramb.aXw.a(paramLong, this.aYx, this.aYG, 0, paramb.aYO);
      this.aYH = true;
      sN();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.aYK)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, aXN, aXO);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.aYK))
    {
      a(paramf, aXI, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.aYK))
    {
      a(paramf, aXM, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.aXw;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.aYz)
    {
      if (!paramb.aYM) {
        break label922;
      }
      this.aYx &= 0xBFFFFFFF;
      if (!this.aYA)
      {
        paramf.readFully(this.aXj.data, 0, 1);
        this.aYy += 1;
        if ((this.aXj.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.aYD = this.aXj.data[0];
        this.aYA = true;
      }
      int m;
      if ((this.aYD & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.aYD & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.aYx |= 0x40000000;
        if (!this.aYB)
        {
          paramf.readFully(this.aXX.data, 0, 8);
          this.aYy += 8;
          this.aYB = true;
          arrayOfByte = this.aXj.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.aXj.setPosition(0);
          localm.a(this.aXj, 1);
          this.aYG += 1;
          this.aXX.setPosition(0);
          localm.a(this.aXX, 8);
          this.aYG += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.aYC)
        {
          paramf.readFully(this.aXj.data, 0, 1);
          this.aYy += 1;
          this.aXj.setPosition(0);
          this.aYE = this.aXj.readUnsignedByte();
          this.aYC = true;
        }
        i = this.aYE * 4;
        this.aXj.reset(i);
        paramf.readFully(this.aXj.data, 0, i);
        this.aYy = (i + this.aYy);
        short s = (short)(this.aYE / 2 + 1);
        m = s * 6 + 2;
        if ((this.aXZ == null) || (this.aXZ.capacity() < m)) {
          this.aXZ = ByteBuffer.allocate(m);
        }
        this.aXZ.position(0);
        this.aXZ.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.aYE) {
          break label621;
        }
        k = this.aXj.vQ();
        if (j % 2 != 0) {
          break label605;
        }
        this.aXZ.putShort((short)(k - i));
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
        this.aXZ.putInt(k - i);
      }
      label621:
      i = paramInt - this.aYy - i;
      if (this.aYE % 2 == 1)
      {
        this.aXZ.putInt(i);
        this.aXY.q(this.aXZ.array(), m);
        localm.a(this.aXY, m);
        this.aYG += m;
        label692:
        this.aYz = true;
      }
    }
    else
    {
      paramInt = this.aXV.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.aYK)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.aYK))) {
        break label971;
      }
      arrayOfByte = this.aXy.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.aXz;
      j = 4 - paramb.aXz;
    }
    for (;;)
    {
      if (this.aYy < paramInt)
      {
        if (this.aYF == 0)
        {
          k = Math.min(i, this.aXV.vJ());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.aXV.readBytes(arrayOfByte, j, k);
          }
          this.aYy += i;
          this.aXy.setPosition(0);
          this.aYF = this.aXy.vQ();
          this.aXx.setPosition(0);
          localm.a(this.aXx, 4);
          this.aYG += 4;
          continue;
          this.aXZ.putShort((short)i);
          this.aXZ.putInt(0);
          break;
          label922:
          if (paramb.aYN == null) {
            break label692;
          }
          this.aXV.q(paramb.aYN, paramb.aYN.length);
          break label692;
        }
        this.aYF -= a(paramf, localm, this.aYF);
        continue;
        label971:
        while (this.aYy < paramInt) {
          a(paramf, localm, paramInt - this.aYy);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.aYK))
    {
      this.aXT.setPosition(0);
      localm.a(this.aXT, 4);
      this.aYG += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.aXn = paramg;
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
      paramf.b(locale.aXj.data, 0, 4);
      l1 = locale.aXj.df();
      locale.aZo = 4;
      while (l1 != 440786851L)
      {
        int j = locale.aZo + 1;
        locale.aZo = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.aXj.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.aXj.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.aZo;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.dS((int)l2);
        locale.aZo = ((int)(l2 + locale.aZo));
      }
      if (locale.aZo >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.aZo == l1 + l3)
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
    if (this.aXj.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.aXj.capacity() < paramInt) {
      this.aXj.q(Arrays.copyOf(this.aXj.data, Math.max(this.aXj.data.length * 2, paramInt)), this.aXj.limit);
    }
    paramf.readFully(this.aXj.data, this.aXj.limit, paramInt - this.aXj.limit);
    this.aXj.fk(paramInt);
    AppMethodBeat.o(92021);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.aYl = -9223372036854775807L;
    this.aYp = 0;
    this.aXQ.reset();
    this.aXC.reset();
    sN();
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
        Arrays.fill(locald.aXU.data, (byte)0);
        paramf.readFully(locald.aXU.data, 4 - paramInt2, paramInt2);
        locald.aXU.setPosition(0);
        locald.aYg = ((int)locald.aXU.df());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.aYe.aYP = new byte[paramInt2];
        paramf.readFully(locald.aYe.aYP, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.aYe.aSl = new byte[paramInt2];
        paramf.readFully(locald.aYe.aSl, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.aYe.aYN = new byte[paramInt2];
        paramf.readFully(locald.aYe.aYN, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.aYe.aYO = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.aYp == 0)
      {
        locald.aYv = ((int)locald.aXC.a(paramf, false, true, 8));
        locald.aYw = locald.aXC.length;
        locald.aYr = -9223372036854775807L;
        locald.aYp = 1;
        locald.aXj.reset();
      }
      Object localObject1 = (d.b)locald.aXR.get(locald.aYv);
      if (localObject1 == null)
      {
        paramf.dR(paramInt2 - locald.aYw);
        locald.aYp = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.aYp == 1)
      {
        locald.b(paramf, 3);
        i = (locald.aXj.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.aYt = 1;
        locald.aYu = d.d(locald.aYu, 1);
        locald.aYu[0] = (paramInt2 - locald.aYw - 3);
        paramInt2 = locald.aXj.data[0];
        i = locald.aXj.data[1];
        locald.aYq = (locald.aYl + locald.L(paramInt2 << 8 | i & 0xFF));
        if ((locald.aXj.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.aXj.data[2] & 0x80) != 128))) {
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
        locald.aYx = (paramInt2 | i);
        locald.aYp = 2;
        locald.aYs = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.aYs < locald.aYt)
        {
          locald.a(paramf, (d.b)localObject1, locald.aYu[locald.aYs]);
          locald.a((d.b)localObject1, locald.aYq + locald.aYs * ((d.b)localObject1).aYL / 1000);
          locald.aYs += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.aYt = ((locald.aXj.data[3] & 0xFF) + 1);
        locald.aYu = d.d(locald.aYu, locald.aYt);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.aYw - 4) / locald.aYt;
          Arrays.fill(locald.aYu, 0, locald.aYt, paramInt2);
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
          while (k < locald.aYt - 1)
          {
            locald.aYu[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.aXj.data[(i - 1)] & 0xFF;
              localObject2 = locald.aYu;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.aYu[k];
            k += 1;
          }
          locald.aYu[(locald.aYt - 1)] = (paramInt2 - locald.aYw - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.aYt - 1)
          {
            locald.aYu[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.aXj.data[(n - 1)] == 0)
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
                if ((locald.aXj.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.aXj.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.aXj.data[i] & 0xFF;
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
            localObject2 = locald.aYu;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.aYu[k];
              k += 1;
              break;
              m += locald.aYu[(k - 1)];
            }
          }
          locald.aYu[(locald.aYt - 1)] = (paramInt2 - locald.aYw - i - j);
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
      locald.aYp = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.aYu[0]);
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
        locald.aYd = (paramDouble);
        return;
      case 181: 
        locald.aYe.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.aYe.aYZ = ((float)paramDouble);
        return;
      case 21970: 
        locald.aYe.aZa = ((float)paramDouble);
        return;
      case 21971: 
        locald.aYe.aZb = ((float)paramDouble);
        return;
      case 21972: 
        locald.aYe.aZc = ((float)paramDouble);
        return;
      case 21973: 
        locald.aYe.aZd = ((float)paramDouble);
        return;
      case 21974: 
        locald.aYe.aZe = ((float)paramDouble);
        return;
      case 21975: 
        locald.aYe.aZf = ((float)paramDouble);
        return;
      case 21976: 
        locald.aYe.aZg = ((float)paramDouble);
        return;
      case 21977: 
        locald.aYe.aZh = ((float)paramDouble);
        return;
      }
      locald.aYe.aZi = ((float)paramDouble);
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
          locald.aYe.aYK = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.aYe.aSt = paramString;
        }
      }
    }
    
    public final int dY(int paramInt)
    {
      AppMethodBeat.i(92004);
      paramInt = d.dY(paramInt);
      AppMethodBeat.o(92004);
      return paramInt;
    }
    
    public final boolean dZ(int paramInt)
    {
      AppMethodBeat.i(92005);
      boolean bool = d.dZ(paramInt);
      AppMethodBeat.o(92005);
      return bool;
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
        if ((((d)localObject).aYb != -1L) && (((d)localObject).aYb != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).aYb = paramLong1;
        ((d)localObject).aYa = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aYg = -1;
        ((d)localObject).aYh = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aYm = new com.google.android.exoplayer2.i.h();
        ((d)localObject).aYn = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aYo = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).aYf)
        {
          if ((((d)localObject).aXS) && (((d)localObject).aYj != -1L))
          {
            ((d)localObject).aYi = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).aXn.a(new l.a(((d)localObject).aSz));
          ((d)localObject).aYf = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYI = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYe.aYM = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYe = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYe.aYT = true;
        }
      }
    }
    
    public final void eb(int paramInt)
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
        if (locald.aYc == -9223372036854775807L) {
          locald.aYc = 1000000L;
        }
        if (locald.aYd != -9223372036854775807L)
        {
          locald.aSz = locald.L(locald.aYd);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.aYg == -1) || (locald.aYh == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.aYg == 475249515)
          {
            locald.aYj = locald.aYh;
            AppMethodBeat.o(92007);
            return;
            if (!locald.aYf)
            {
              Object localObject2 = locald.aXn;
              if ((locald.aYb == -1L) || (locald.aSz == -9223372036854775807L) || (locald.aYm == null) || (locald.aYm.size == 0) || (locald.aYn == null) || (locald.aYn.size != locald.aYm.size))
              {
                locald.aYm = null;
                locald.aYn = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.aSz);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.aYf = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.aYm.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.aYm.get(paramInt);
                  localObject3[paramInt] = (locald.aYb + locald.aYn.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.aYb + locald.aYa - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.aSz - localObject5[(i - 1)]);
                locald.aYm = null;
                locald.aYn = null;
              }
              if (locald.aYp == 2)
              {
                if (!locald.aYI) {
                  locald.aYx |= 0x1;
                }
                locald.a((d.b)locald.aXR.get(locald.aYv), locald.aYq);
                locald.aYp = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.aYe.aYM)
                {
                  if (locald.aYe.aYO == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.aYe.aSg = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.aQw, "video/webm", locald.aYe.aYO.aXd) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.aYe.aYM) && (locald.aYe.aYN != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.aYe.aYK;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2181;
                      }
                      localObject4 = locald.aYe;
                      localObject5 = locald.aXn;
                      m = locald.aYe.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).aYK;
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
                    if (((d.b)localObject4).aZn)
                    {
                      j = 1;
                      if (!((d.b)localObject4).aZm) {
                        break label3006;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.aJ((String)localObject1)) {
                        break label3012;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).aSg, j, ((d.b)localObject4).aSt);
                      paramInt = 1;
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).aXw = ((g)localObject5).bh(((d.b)localObject4).number, paramInt);
                      ((d.b)localObject4).aXw.f((Format)localObject1);
                      locald.aXR.put(locald.aYe.number, locald.aYe);
                      label2181:
                      locald.aYe = null;
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
                      if (((d.b)localObject4).aYP == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).aYP))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aYP));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).aSf;
                      ((d.b)localObject4).aXz = ((com.google.android.exoplayer2.video.a)localObject3).aXz;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aYP));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).aSf;
                      ((d.b)localObject4).aXz = ((com.google.android.exoplayer2.video.b)localObject3).aXz;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aYP));
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
                      localObject2 = d.b.q(((d.b)localObject4).aYP);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).aYP);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aZk).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aZl).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aYP);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aYP);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aYP)))
                      {
                        k = x.fq(((d.b)localObject4).aZj);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aZj).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.fq(((d.b)localObject4).aZj);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aZj).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aYP);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.aYP[0], localObject4.aYP[1], localObject4.aYP[2], localObject4.aYP[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3006:
                      k = 0;
                      break label2071;
                      label3012:
                      if (j.aK((String)localObject1))
                      {
                        label3044:
                        label3067:
                        float f1;
                        if (((d.b)localObject4).aYS == 0)
                        {
                          if (((d.b)localObject4).aYQ == -1)
                          {
                            i = ((d.b)localObject4).width;
                            ((d.b)localObject4).aYQ = i;
                            if (((d.b)localObject4).aYR != -1) {
                              break label3345;
                            }
                            i = ((d.b)localObject4).height;
                            ((d.b)localObject4).aYR = i;
                          }
                        }
                        else
                        {
                          float f2 = -1.0F;
                          f1 = f2;
                          if (((d.b)localObject4).aYQ != -1)
                          {
                            f1 = f2;
                            if (((d.b)localObject4).aYR != -1) {
                              f1 = ((d.b)localObject4).height * ((d.b)localObject4).aYQ / (((d.b)localObject4).width * ((d.b)localObject4).aYR);
                            }
                          }
                          localObject3 = null;
                          if (((d.b)localObject4).aYT)
                          {
                            if ((((d.b)localObject4).aYZ != -1.0F) && (((d.b)localObject4).aZa != -1.0F) && (((d.b)localObject4).aZb != -1.0F) && (((d.b)localObject4).aZc != -1.0F) && (((d.b)localObject4).aZd != -1.0F) && (((d.b)localObject4).aZe != -1.0F) && (((d.b)localObject4).aZf != -1.0F) && (((d.b)localObject4).aZg != -1.0F) && (((d.b)localObject4).aZh != -1.0F) && (((d.b)localObject4).aZi != -1.0F)) {
                              break label3355;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).aYU, ((d.b)localObject4).aYW, ((d.b)localObject4).aYV, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).aSl, ((d.b)localObject4).aSk, (ColorInfo)localObject3, ((d.b)localObject4).aSg);
                          paramInt = 2;
                          break;
                          i = ((d.b)localObject4).aYQ;
                          break label3044;
                          i = ((d.b)localObject4).aYR;
                          break label3067;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aYZ * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZa * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZb * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZc * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZd * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZe * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZf * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZg * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZh + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZi + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).aYX);
                          localByteBuffer.putShort((short)((d.b)localObject4).aYY);
                        }
                      }
                      label3345:
                      label3355:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        paramInt = 3;
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).aSt, ((d.b)localObject4).aSg);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.aXL);
                        ((List)localObject2).add(((d.b)localObject4).aYP);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).aSt, -1, ((d.b)localObject4).aSg, 9223372036854775807L, (List)localObject2);
                        paramInt = 3;
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3786;
                        }
                        paramInt = 3;
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).aSt, ((d.b)localObject4).aSg);
                      }
                    }
                    label3786:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.aXR.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.aXn.sL();
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
            ((d)localObject).aYh = (((d)localObject).aYb + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYc = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aYQ = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aYR = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aYS = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).aYe;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).aZm = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).aYe;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).aZn = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).aYe.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aYL = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aZk = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aZl = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYe.aZj = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYI = true;
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
                      ((d)localObject).aYm.add(((d)localObject).L(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).aYo)
                      {
                        ((d)localObject).aYn.add(paramLong);
                        ((d)localObject).aYo = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYl = ((d)localObject).L(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYr = ((d)localObject).L(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).aYe.aSk = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYe.aSk = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).aYe.aSk = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYe.aSk = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYe.aYT = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYe.aYU = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aYe.aYU = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYe.aYU = 6;
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
                          ((d)localObject).aYe.aYV = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).aYe.aYV = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYe.aYV = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYe.aYW = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYe.aYW = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYe.aYX = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYe.aYY = ((int)paramLong);
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
    public DrmInitData aSg;
    public int aSk = -1;
    public byte[] aSl = null;
    String aSt = "eng";
    public com.google.android.exoplayer2.c.m aXw;
    public int aXz;
    public String aYK;
    public int aYL;
    public boolean aYM;
    public byte[] aYN;
    public m.a aYO;
    public byte[] aYP;
    public int aYQ = -1;
    public int aYR = -1;
    public int aYS = 0;
    public boolean aYT = false;
    public int aYU = -1;
    public int aYV = -1;
    public int aYW = -1;
    public int aYX = 1000;
    public int aYY = 200;
    public float aYZ = -1.0F;
    public float aZa = -1.0F;
    public float aZb = -1.0F;
    public float aZc = -1.0F;
    public float aZd = -1.0F;
    public float aZe = -1.0F;
    public float aZf = -1.0F;
    public float aZg = -1.0F;
    public float aZh = -1.0F;
    public float aZi = -1.0F;
    public int aZj = -1;
    public long aZk = 0L;
    public long aZl = 0L;
    public boolean aZm;
    public boolean aZn = true;
    public int channelCount = 1;
    public int height = -1;
    public int number;
    public int sampleRate = 8000;
    public int type;
    public int width = -1;
    
    static List<byte[]> i(com.google.android.exoplayer2.i.m paramm)
    {
      AppMethodBeat.i(92011);
      try
      {
        paramm.fl(16);
        long l = paramm.vM();
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
        int i = paramm.vK();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.sO().getMostSignificantBits()) && (paramm.readLong() == d.sO().getLeastSignificantBits()))
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