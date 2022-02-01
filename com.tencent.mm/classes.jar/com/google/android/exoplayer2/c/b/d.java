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
  public static final com.google.android.exoplayer2.c.h aXT;
  private static final byte[] aYA;
  private static final UUID aYB;
  private static final byte[] aYu;
  private static final byte[] aYv;
  private static long aYw;
  static final byte[] aYx;
  private static final byte[] aYy;
  private static long aYz;
  long aTs;
  final com.google.android.exoplayer2.i.m aXV;
  g aXZ;
  private final b aYC;
  final SparseArray<b> aYD;
  final boolean aYE;
  private final com.google.android.exoplayer2.i.m aYF;
  final com.google.android.exoplayer2.i.m aYG;
  private final com.google.android.exoplayer2.i.m aYH;
  private final com.google.android.exoplayer2.i.m aYI;
  private final com.google.android.exoplayer2.i.m aYJ;
  private final com.google.android.exoplayer2.i.m aYK;
  private ByteBuffer aYL;
  long aYM;
  long aYN;
  long aYO;
  long aYP;
  b aYQ;
  boolean aYR;
  int aYS;
  long aYT;
  boolean aYU;
  long aYV;
  private long aYW;
  long aYX;
  com.google.android.exoplayer2.i.h aYY;
  com.google.android.exoplayer2.i.h aYZ;
  private final com.google.android.exoplayer2.i.m aYj;
  private final com.google.android.exoplayer2.i.m aYk;
  final f aYo;
  boolean aZa;
  int aZb;
  long aZc;
  long aZd;
  int aZe;
  int aZf;
  int[] aZg;
  int aZh;
  int aZi;
  int aZj;
  private int aZk;
  private boolean aZl;
  private boolean aZm;
  private boolean aZn;
  private boolean aZo;
  private byte aZp;
  private int aZq;
  private int aZr;
  private int aZs;
  private boolean aZt;
  boolean aZu;
  
  static
  {
    AppMethodBeat.i(92029);
    aXT = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] sT()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    aYu = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    aYv = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aYw = 1000L;
    aYx = x.aN("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    aYy = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    aYz = 10000L;
    aYA = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aYB = new UUID(72057594037932032L, -9223371306706625679L);
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
    this.aYN = -1L;
    this.aYO = -9223372036854775807L;
    this.aYP = -9223372036854775807L;
    this.aTs = -9223372036854775807L;
    this.aYV = -1L;
    this.aYW = -1L;
    this.aYX = -9223372036854775807L;
    this.aYC = paramb;
    this.aYC.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.aYE = bool;
    this.aYo = new f();
    this.aYD = new SparseArray();
    this.aXV = new com.google.android.exoplayer2.i.m(4);
    this.aYF = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.aYG = new com.google.android.exoplayer2.i.m(4);
    this.aYj = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.bwo);
    this.aYk = new com.google.android.exoplayer2.i.m(4);
    this.aYH = new com.google.android.exoplayer2.i.m();
    this.aYI = new com.google.android.exoplayer2.i.m();
    this.aYJ = new com.google.android.exoplayer2.i.m(8);
    this.aYK = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.aYH.vy();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.aYH, paramInt);
    }
    for (;;)
    {
      this.aZk += paramInt;
      this.aZs += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.aYI.data, this.aZd, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.aYi.a(this.aYI, this.aYI.limit);
    this.aZs += this.aYI.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.aYI.capacity() < i) {
      this.aYI.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.aYI.data, paramArrayOfByte.length, paramInt);
      this.aYI.reset(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.aYI.data, 0, paramArrayOfByte.length);
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
    for (paramString = paramArrayOfByte2;; paramString = x.aN(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
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
  
  private void sW()
  {
    AppMethodBeat.i(92020);
    this.aZk = 0;
    this.aZs = 0;
    this.aZr = 0;
    this.aZl = false;
    this.aZm = false;
    this.aZo = false;
    this.aZq = 0;
    this.aZp = 0;
    this.aZn = false;
    this.aYH.reset();
    AppMethodBeat.o(92020);
  }
  
  final long M(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.aYO == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.b(paramLong, this.aYO, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.aZt = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.aZt))
      {
        bool = this.aYC.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.aYU)
        {
          this.aYW = l;
          paramk.position = this.aYV;
          this.aYU = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.aYR) && (this.aYW != -1L))
        {
          paramk.position = this.aYW;
          this.aYW = -1L;
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
    if ("S_TEXT/UTF8".equals(paramb.aZw)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, aYw, aYv);
    }
    for (;;)
    {
      paramb.aYi.a(paramLong, this.aZj, this.aZs, 0, paramb.aZA);
      this.aZt = true;
      sW();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.aZw)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, aYz, aYA);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.aZw))
    {
      a(paramf, aYu, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.aZw))
    {
      a(paramf, aYy, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.aYi;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.aZl)
    {
      if (!paramb.aZy) {
        break label922;
      }
      this.aZj &= 0xBFFFFFFF;
      if (!this.aZm)
      {
        paramf.readFully(this.aXV.data, 0, 1);
        this.aZk += 1;
        if ((this.aXV.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.aZp = this.aXV.data[0];
        this.aZm = true;
      }
      int m;
      if ((this.aZp & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.aZp & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.aZj |= 0x40000000;
        if (!this.aZn)
        {
          paramf.readFully(this.aYJ.data, 0, 8);
          this.aZk += 8;
          this.aZn = true;
          arrayOfByte = this.aXV.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.aXV.setPosition(0);
          localm.a(this.aXV, 1);
          this.aZs += 1;
          this.aYJ.setPosition(0);
          localm.a(this.aYJ, 8);
          this.aZs += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.aZo)
        {
          paramf.readFully(this.aXV.data, 0, 1);
          this.aZk += 1;
          this.aXV.setPosition(0);
          this.aZq = this.aXV.readUnsignedByte();
          this.aZo = true;
        }
        i = this.aZq * 4;
        this.aXV.reset(i);
        paramf.readFully(this.aXV.data, 0, i);
        this.aZk = (i + this.aZk);
        short s = (short)(this.aZq / 2 + 1);
        m = s * 6 + 2;
        if ((this.aYL == null) || (this.aYL.capacity() < m)) {
          this.aYL = ByteBuffer.allocate(m);
        }
        this.aYL.position(0);
        this.aYL.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.aZq) {
          break label621;
        }
        k = this.aXV.vF();
        if (j % 2 != 0) {
          break label605;
        }
        this.aYL.putShort((short)(k - i));
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
        this.aYL.putInt(k - i);
      }
      label621:
      i = paramInt - this.aZk - i;
      if (this.aZq % 2 == 1)
      {
        this.aYL.putInt(i);
        this.aYK.n(this.aYL.array(), m);
        localm.a(this.aYK, m);
        this.aZs += m;
        label692:
        this.aZl = true;
      }
    }
    else
    {
      paramInt = this.aYH.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.aZw)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.aZw))) {
        break label971;
      }
      arrayOfByte = this.aYk.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.aYl;
      j = 4 - paramb.aYl;
    }
    for (;;)
    {
      if (this.aZk < paramInt)
      {
        if (this.aZr == 0)
        {
          k = Math.min(i, this.aYH.vy());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.aYH.readBytes(arrayOfByte, j, k);
          }
          this.aZk += i;
          this.aYk.setPosition(0);
          this.aZr = this.aYk.vF();
          this.aYj.setPosition(0);
          localm.a(this.aYj, 4);
          this.aZs += 4;
          continue;
          this.aYL.putShort((short)i);
          this.aYL.putInt(0);
          break;
          label922:
          if (paramb.aZz == null) {
            break label692;
          }
          this.aYH.n(paramb.aZz, paramb.aZz.length);
          break label692;
        }
        this.aZr -= a(paramf, localm, this.aZr);
        continue;
        label971:
        while (this.aZk < paramInt) {
          a(paramf, localm, paramInt - this.aZk);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.aZw))
    {
      this.aYF.setPosition(0);
      localm.a(this.aYF, 4);
      this.aZs += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.aXZ = paramg;
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
      paramf.b(locale.aXV.data, 0, 4);
      l1 = locale.aXV.dm();
      locale.baa = 4;
      while (l1 != 440786851L)
      {
        int j = locale.baa + 1;
        locale.baa = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.aXV.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.aXV.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.baa;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.dR((int)l2);
        locale.baa = ((int)(l2 + locale.baa));
      }
      if (locale.baa >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.baa == l1 + l3)
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
    if (this.aXV.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.aXV.capacity() < paramInt) {
      this.aXV.n(Arrays.copyOf(this.aXV.data, Math.max(this.aXV.data.length * 2, paramInt)), this.aXV.limit);
    }
    paramf.readFully(this.aXV.data, this.aXV.limit, paramInt - this.aXV.limit);
    this.aXV.eW(paramInt);
    AppMethodBeat.o(92021);
  }
  
  public final void f(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.aYX = -9223372036854775807L;
    this.aZb = 0;
    this.aYC.reset();
    this.aYo.reset();
    sW();
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
        Arrays.fill(locald.aYG.data, (byte)0);
        paramf.readFully(locald.aYG.data, 4 - paramInt2, paramInt2);
        locald.aYG.setPosition(0);
        locald.aYS = ((int)locald.aYG.dm());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.aYQ.aZB = new byte[paramInt2];
        paramf.readFully(locald.aYQ.aZB, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.aYQ.aTg = new byte[paramInt2];
        paramf.readFully(locald.aYQ.aTg, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.aYQ.aZz = new byte[paramInt2];
        paramf.readFully(locald.aYQ.aZz, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.aYQ.aZA = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.aZb == 0)
      {
        locald.aZh = ((int)locald.aYo.a(paramf, false, true, 8));
        locald.aZi = locald.aYo.length;
        locald.aZd = -9223372036854775807L;
        locald.aZb = 1;
        locald.aXV.reset();
      }
      Object localObject1 = (d.b)locald.aYD.get(locald.aZh);
      if (localObject1 == null)
      {
        paramf.dQ(paramInt2 - locald.aZi);
        locald.aZb = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.aZb == 1)
      {
        locald.b(paramf, 3);
        i = (locald.aXV.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.aZf = 1;
        locald.aZg = d.d(locald.aZg, 1);
        locald.aZg[0] = (paramInt2 - locald.aZi - 3);
        paramInt2 = locald.aXV.data[0];
        i = locald.aXV.data[1];
        locald.aZc = (locald.aYX + locald.M(paramInt2 << 8 | i & 0xFF));
        if ((locald.aXV.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.aXV.data[2] & 0x80) != 128))) {
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
        locald.aZj = (paramInt2 | i);
        locald.aZb = 2;
        locald.aZe = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.aZe < locald.aZf)
        {
          locald.a(paramf, (d.b)localObject1, locald.aZg[locald.aZe]);
          locald.a((d.b)localObject1, locald.aZc + locald.aZe * ((d.b)localObject1).aZx / 1000);
          locald.aZe += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.aZf = ((locald.aXV.data[3] & 0xFF) + 1);
        locald.aZg = d.d(locald.aZg, locald.aZf);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.aZi - 4) / locald.aZf;
          Arrays.fill(locald.aZg, 0, locald.aZf, paramInt2);
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
          while (k < locald.aZf - 1)
          {
            locald.aZg[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.aXV.data[(i - 1)] & 0xFF;
              localObject2 = locald.aZg;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.aZg[k];
            k += 1;
          }
          locald.aZg[(locald.aZf - 1)] = (paramInt2 - locald.aZi - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.aZf - 1)
          {
            locald.aZg[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.aXV.data[(n - 1)] == 0)
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
                if ((locald.aXV.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.aXV.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.aXV.data[i] & 0xFF;
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
            localObject2 = locald.aZg;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.aZg[k];
              k += 1;
              break;
              m += locald.aZg[(k - 1)];
            }
          }
          locald.aZg[(locald.aZf - 1)] = (paramInt2 - locald.aZi - i - j);
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
      locald.aZb = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.aZg[0]);
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
        locald.aYP = (paramDouble);
        return;
      case 181: 
        locald.aYQ.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.aYQ.aZL = ((float)paramDouble);
        return;
      case 21970: 
        locald.aYQ.aZM = ((float)paramDouble);
        return;
      case 21971: 
        locald.aYQ.aZN = ((float)paramDouble);
        return;
      case 21972: 
        locald.aYQ.aZO = ((float)paramDouble);
        return;
      case 21973: 
        locald.aYQ.aZP = ((float)paramDouble);
        return;
      case 21974: 
        locald.aYQ.aZQ = ((float)paramDouble);
        return;
      case 21975: 
        locald.aYQ.aZR = ((float)paramDouble);
        return;
      case 21976: 
        locald.aYQ.aZS = ((float)paramDouble);
        return;
      case 21977: 
        locald.aYQ.aZT = ((float)paramDouble);
        return;
      }
      locald.aYQ.aZU = ((float)paramDouble);
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
          locald.aYQ.aZw = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.aYQ.aTm = paramString;
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
        if ((((d)localObject).aYN != -1L) && (((d)localObject).aYN != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).aYN = paramLong1;
        ((d)localObject).aYM = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aYS = -1;
        ((d)localObject).aYT = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aYY = new com.google.android.exoplayer2.i.h();
        ((d)localObject).aYZ = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).aZa = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).aYR)
        {
          if ((((d)localObject).aYE) && (((d)localObject).aYV != -1L))
          {
            ((d)localObject).aYU = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).aXZ.a(new l.a(((d)localObject).aTs));
          ((d)localObject).aYR = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aZu = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYQ.aZy = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYQ = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).aYQ.aZF = true;
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
        if (locald.aYO == -9223372036854775807L) {
          locald.aYO = 1000000L;
        }
        if (locald.aYP != -9223372036854775807L)
        {
          locald.aTs = locald.M(locald.aYP);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.aYS == -1) || (locald.aYT == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.aYS == 475249515)
          {
            locald.aYV = locald.aYT;
            AppMethodBeat.o(92007);
            return;
            if (!locald.aYR)
            {
              Object localObject2 = locald.aXZ;
              if ((locald.aYN == -1L) || (locald.aTs == -9223372036854775807L) || (locald.aYY == null) || (locald.aYY.size == 0) || (locald.aYZ == null) || (locald.aYZ.size != locald.aYY.size))
              {
                locald.aYY = null;
                locald.aYZ = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.aTs);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.aYR = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.aYY.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.aYY.get(paramInt);
                  localObject3[paramInt] = (locald.aYN + locald.aYZ.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.aYN + locald.aYM - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.aTs - localObject5[(i - 1)]);
                locald.aYY = null;
                locald.aYZ = null;
              }
              if (locald.aZb == 2)
              {
                if (!locald.aZu) {
                  locald.aZj |= 0x1;
                }
                locald.a((d.b)locald.aYD.get(locald.aZh), locald.aZc);
                locald.aZb = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.aYQ.aZy)
                {
                  if (locald.aYQ.aZA == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.aYQ.aTb = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.aRr, "video/webm", locald.aYQ.aZA.aXP) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.aYQ.aZy) && (locald.aYQ.aZz != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.aYQ.aZw;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.aYQ;
                      localObject5 = locald.aXZ;
                      m = locald.aYQ.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).aZw;
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
                    if (((d.b)localObject4).aZZ)
                    {
                      j = 1;
                      if (!((d.b)localObject4).aZY) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.aE((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).aTb, j, ((d.b)localObject4).aTm);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).aYi = ((g)localObject5).dW(((d.b)localObject4).number);
                      ((d.b)localObject4).aYi.f((Format)localObject1);
                      locald.aYD.put(locald.aYQ.number, locald.aYQ);
                      label2178:
                      locald.aYQ = null;
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
                      if (((d.b)localObject4).aZB == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).aZB))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aZB));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).aTa;
                      ((d.b)localObject4).aYl = ((com.google.android.exoplayer2.video.a)localObject3).aYl;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aZB));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).aTa;
                      ((d.b)localObject4).aYl = ((com.google.android.exoplayer2.video.b)localObject3).aYl;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aZB));
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
                      localObject2 = d.b.q(((d.b)localObject4).aZB);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).aZB);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aZW).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aZX).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aZB);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aZB);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aZB)))
                      {
                        k = x.fc(((d.b)localObject4).aZV);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aZV).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.fc(((d.b)localObject4).aZV);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aZV).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aZB);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.aZB[0], localObject4.aZB[1], localObject4.aZB[2], localObject4.aZB[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3003:
                      k = 0;
                      break label2071;
                      label3009:
                      if (j.aF((String)localObject1))
                      {
                        label3041:
                        label3064:
                        float f1;
                        if (((d.b)localObject4).aZE == 0)
                        {
                          if (((d.b)localObject4).aZC == -1)
                          {
                            i = ((d.b)localObject4).width;
                            ((d.b)localObject4).aZC = i;
                            if (((d.b)localObject4).aZD != -1) {
                              break label3340;
                            }
                            i = ((d.b)localObject4).height;
                            ((d.b)localObject4).aZD = i;
                          }
                        }
                        else
                        {
                          float f2 = -1.0F;
                          f1 = f2;
                          if (((d.b)localObject4).aZC != -1)
                          {
                            f1 = f2;
                            if (((d.b)localObject4).aZD != -1) {
                              f1 = ((d.b)localObject4).height * ((d.b)localObject4).aZC / (((d.b)localObject4).width * ((d.b)localObject4).aZD);
                            }
                          }
                          localObject3 = null;
                          if (((d.b)localObject4).aZF)
                          {
                            if ((((d.b)localObject4).aZL != -1.0F) && (((d.b)localObject4).aZM != -1.0F) && (((d.b)localObject4).aZN != -1.0F) && (((d.b)localObject4).aZO != -1.0F) && (((d.b)localObject4).aZP != -1.0F) && (((d.b)localObject4).aZQ != -1.0F) && (((d.b)localObject4).aZR != -1.0F) && (((d.b)localObject4).aZS != -1.0F) && (((d.b)localObject4).aZT != -1.0F) && (((d.b)localObject4).aZU != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).aZG, ((d.b)localObject4).aZI, ((d.b)localObject4).aZH, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).aTg, ((d.b)localObject4).aTf, (ColorInfo)localObject3, ((d.b)localObject4).aTb);
                          break;
                          i = ((d.b)localObject4).aZC;
                          break label3041;
                          i = ((d.b)localObject4).aZD;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZL * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZM * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZN * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZO * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZP * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZQ * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZR * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZS * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZT + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aZU + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).aZJ);
                          localByteBuffer.putShort((short)((d.b)localObject4).aZK);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).aTm, ((d.b)localObject4).aTb);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.aYx);
                        ((List)localObject2).add(((d.b)localObject4).aZB);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).aTm, -1, ((d.b)localObject4).aTb, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).aTm, ((d.b)localObject4).aTb);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.aYD.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.aXZ.sU();
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
            ((d)localObject).aYT = (((d)localObject).aYN + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYO = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZC = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZD = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZE = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).aYQ;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).aZY = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).aYQ;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).aZZ = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).aYQ.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZx = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZW = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZX = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aYQ.aZV = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).aZu = true;
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
                      ((d)localObject).aYY.add(((d)localObject).M(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).aZa)
                      {
                        ((d)localObject).aYZ.add(paramLong);
                        ((d)localObject).aZa = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYX = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aZd = ((d)localObject).M(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).aYQ.aTf = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYQ.aTf = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).aYQ.aTf = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYQ.aTf = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYQ.aZF = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYQ.aZG = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aYQ.aZG = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYQ.aZG = 6;
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
                          ((d)localObject).aYQ.aZH = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).aYQ.aZH = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYQ.aZH = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).aYQ.aZI = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).aYQ.aZI = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYQ.aZJ = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).aYQ.aZK = ((int)paramLong);
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
    public DrmInitData aTb;
    public int aTf = -1;
    public byte[] aTg = null;
    String aTm = "eng";
    public com.google.android.exoplayer2.c.m aYi;
    public int aYl;
    public m.a aZA;
    public byte[] aZB;
    public int aZC = -1;
    public int aZD = -1;
    public int aZE = 0;
    public boolean aZF = false;
    public int aZG = -1;
    public int aZH = -1;
    public int aZI = -1;
    public int aZJ = 1000;
    public int aZK = 200;
    public float aZL = -1.0F;
    public float aZM = -1.0F;
    public float aZN = -1.0F;
    public float aZO = -1.0F;
    public float aZP = -1.0F;
    public float aZQ = -1.0F;
    public float aZR = -1.0F;
    public float aZS = -1.0F;
    public float aZT = -1.0F;
    public float aZU = -1.0F;
    public int aZV = -1;
    public long aZW = 0L;
    public long aZX = 0L;
    public boolean aZY;
    public boolean aZZ = true;
    public String aZw;
    public int aZx;
    public boolean aZy;
    public byte[] aZz;
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
        paramm.eX(16);
        long l = paramm.vB();
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
        int i = paramm.vz();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.sX().getMostSignificantBits()) && (paramm.readLong() == d.sX().getLeastSignificantBits()))
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