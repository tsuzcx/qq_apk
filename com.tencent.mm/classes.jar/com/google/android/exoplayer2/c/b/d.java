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
  public static final com.google.android.exoplayer2.c.h cLL;
  private static final byte[] cMm;
  private static final byte[] cMn;
  private static long cMo;
  static final byte[] cMp;
  private static final byte[] cMq;
  private static long cMr;
  private static final byte[] cMs;
  private static final UUID cMt;
  long cHg;
  final com.google.android.exoplayer2.i.m cLN;
  g cLR;
  private final com.google.android.exoplayer2.i.m cMA;
  private final com.google.android.exoplayer2.i.m cMB;
  private final com.google.android.exoplayer2.i.m cMC;
  private ByteBuffer cMD;
  long cME;
  long cMF;
  long cMG;
  long cMH;
  b cMI;
  boolean cMJ;
  int cMK;
  long cML;
  boolean cMM;
  long cMN;
  private long cMO;
  long cMP;
  com.google.android.exoplayer2.i.h cMQ;
  com.google.android.exoplayer2.i.h cMR;
  boolean cMS;
  int cMT;
  long cMU;
  long cMV;
  int cMW;
  int cMX;
  int[] cMY;
  int cMZ;
  private final com.google.android.exoplayer2.i.m cMb;
  private final com.google.android.exoplayer2.i.m cMc;
  final f cMg;
  private final b cMu;
  final SparseArray<b> cMv;
  final boolean cMw;
  private final com.google.android.exoplayer2.i.m cMx;
  final com.google.android.exoplayer2.i.m cMy;
  private final com.google.android.exoplayer2.i.m cMz;
  int cNa;
  int cNb;
  private int cNc;
  private boolean cNd;
  private boolean cNe;
  private boolean cNf;
  private boolean cNg;
  private byte cNh;
  private int cNi;
  private int cNj;
  private int cNk;
  private boolean cNl;
  boolean cNm;
  
  static
  {
    AppMethodBeat.i(92029);
    cLL = new com.google.android.exoplayer2.c.h()
    {
      public final com.google.android.exoplayer2.c.e[] RV()
      {
        AppMethodBeat.i(92003);
        d locald = new d();
        AppMethodBeat.o(92003);
        return new com.google.android.exoplayer2.c.e[] { locald };
      }
    };
    cMm = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    cMn = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    cMo = 1000L;
    cMp = x.dr("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    cMq = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    cMr = 10000L;
    cMs = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    cMt = new UUID(72057594037932032L, -9223371306706625679L);
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
    this.cMF = -1L;
    this.cMG = -9223372036854775807L;
    this.cMH = -9223372036854775807L;
    this.cHg = -9223372036854775807L;
    this.cMN = -1L;
    this.cMO = -1L;
    this.cMP = -9223372036854775807L;
    this.cMu = paramb;
    this.cMu.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.cMw = bool;
    this.cMg = new f();
    this.cMv = new SparseArray();
    this.cLN = new com.google.android.exoplayer2.i.m(4);
    this.cMx = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.cMy = new com.google.android.exoplayer2.i.m(4);
    this.cMb = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.dkg);
    this.cMc = new com.google.android.exoplayer2.i.m(4);
    this.cMz = new com.google.android.exoplayer2.i.m();
    this.cMA = new com.google.android.exoplayer2.i.m();
    this.cMB = new com.google.android.exoplayer2.i.m(8);
    this.cMC = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(92015);
  }
  
  private void RY()
  {
    AppMethodBeat.i(92020);
    this.cNc = 0;
    this.cNk = 0;
    this.cNj = 0;
    this.cNd = false;
    this.cNe = false;
    this.cNg = false;
    this.cNi = 0;
    this.cNh = 0;
    this.cNf = false;
    this.cMz.reset();
    AppMethodBeat.o(92020);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(92026);
    int i = this.cMz.UF();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.cMz, paramInt);
    }
    for (;;)
    {
      this.cNc += paramInt;
      this.cNk += paramInt;
      AppMethodBeat.o(92026);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(92024);
    a(this.cMA.data, this.cMV, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.cMa.a(this.cMA, this.cMA.limit);
    this.cNk += this.cMA.limit;
    AppMethodBeat.o(92024);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92023);
    int i = paramArrayOfByte.length + paramInt;
    if (this.cMA.UG() < i) {
      this.cMA.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.cMA.data, paramArrayOfByte.length, paramInt);
      this.cMA.iF(i);
      AppMethodBeat.o(92023);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.cMA.data, 0, paramArrayOfByte.length);
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
    for (paramString = paramArrayOfByte2;; paramString = x.dr(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
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
  
  static int hB(int paramInt)
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
  
  static boolean hC(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  static int[] r(int[] paramArrayOfInt, int paramInt)
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
  
  public final void C(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(92017);
    this.cMP = -9223372036854775807L;
    this.cMT = 0;
    this.cMu.reset();
    this.cMg.reset();
    RY();
    AppMethodBeat.o(92017);
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(92018);
    this.cNl = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.cNl))
      {
        bool = this.cMu.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.cMM)
        {
          this.cMO = l;
          paramk.position = this.cMN;
          this.cMM = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(92018);
        return 1;
        if ((this.cMJ) && (this.cMO != -1L))
        {
          paramk.position = this.cMO;
          this.cMO = -1L;
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
    if ("S_TEXT/UTF8".equals(paramb.cNo)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, cMo, cMn);
    }
    for (;;)
    {
      paramb.cMa.a(paramLong, this.cNb, this.cNk, 0, paramb.cNs);
      this.cNl = true;
      RY();
      AppMethodBeat.o(92019);
      return;
      if ("S_TEXT/ASS".equals(paramb.cNo)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, cMr, cMs);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(92022);
    if ("S_TEXT/UTF8".equals(paramb.cNo))
    {
      a(paramf, cMm, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.cNo))
    {
      a(paramf, cMq, paramInt);
      AppMethodBeat.o(92022);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.cMa;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.cNd)
    {
      if (!paramb.cNq) {
        break label922;
      }
      this.cNb &= 0xBFFFFFFF;
      if (!this.cNe)
      {
        paramf.readFully(this.cLN.data, 0, 1);
        this.cNc += 1;
        if ((this.cLN.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(92022);
          throw paramf;
        }
        this.cNh = this.cLN.data[0];
        this.cNe = true;
      }
      int m;
      if ((this.cNh & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.cNh & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.cNb |= 0x40000000;
        if (!this.cNf)
        {
          paramf.readFully(this.cMB.data, 0, 8);
          this.cNc += 8;
          this.cNf = true;
          arrayOfByte = this.cLN.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.cLN.setPosition(0);
          localm.a(this.cLN, 1);
          this.cNk += 1;
          this.cMB.setPosition(0);
          localm.a(this.cMB, 8);
          this.cNk += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.cNg)
        {
          paramf.readFully(this.cLN.data, 0, 1);
          this.cNc += 1;
          this.cLN.setPosition(0);
          this.cNi = this.cLN.readUnsignedByte();
          this.cNg = true;
        }
        i = this.cNi * 4;
        this.cLN.iF(i);
        paramf.readFully(this.cLN.data, 0, i);
        this.cNc = (i + this.cNc);
        short s = (short)(this.cNi / 2 + 1);
        m = s * 6 + 2;
        if ((this.cMD == null) || (this.cMD.capacity() < m)) {
          this.cMD = ByteBuffer.allocate(m);
        }
        this.cMD.position(0);
        this.cMD.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.cNi) {
          break label621;
        }
        k = this.cLN.UN();
        if (j % 2 != 0) {
          break label605;
        }
        this.cMD.putShort((short)(k - i));
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
        this.cMD.putInt(k - i);
      }
      label621:
      i = paramInt - this.cNc - i;
      if (this.cNi % 2 == 1)
      {
        this.cMD.putInt(i);
        this.cMC.n(this.cMD.array(), m);
        localm.a(this.cMC, m);
        this.cNk += m;
        label692:
        this.cNd = true;
      }
    }
    else
    {
      paramInt = this.cMz.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.cNo)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.cNo))) {
        break label971;
      }
      arrayOfByte = this.cMc.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.cMd;
      j = 4 - paramb.cMd;
    }
    for (;;)
    {
      if (this.cNc < paramInt)
      {
        if (this.cNj == 0)
        {
          k = Math.min(i, this.cMz.UF());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.cMz.readBytes(arrayOfByte, j, k);
          }
          this.cNc += i;
          this.cMc.setPosition(0);
          this.cNj = this.cMc.UN();
          this.cMb.setPosition(0);
          localm.a(this.cMb, 4);
          this.cNk += 4;
          continue;
          this.cMD.putShort((short)i);
          this.cMD.putInt(0);
          break;
          label922:
          if (paramb.cNr == null) {
            break label692;
          }
          this.cMz.n(paramb.cNr, paramb.cNr.length);
          break label692;
        }
        this.cNj -= a(paramf, localm, this.cNj);
        continue;
        label971:
        while (this.cNc < paramInt) {
          a(paramf, localm, paramInt - this.cNc);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.cNo))
    {
      this.cMx.setPosition(0);
      localm.a(this.cMx, 4);
      this.cNk += 4;
    }
    AppMethodBeat.o(92022);
  }
  
  public final void a(g paramg)
  {
    this.cLR = paramg;
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(92016);
    e locale = new e();
    long l2 = paramf.RU();
    if ((l2 == -1L) || (l2 > 1024L)) {}
    for (long l1 = 1024L;; l1 = l2)
    {
      int i = (int)l1;
      paramf.b(locale.cLN.data, 0, 4);
      l1 = locale.cLN.FT();
      locale.cNO = 4;
      while (l1 != 440786851L)
      {
        int j = locale.cNO + 1;
        locale.cNO = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.cLN.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.cLN.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.cNO;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(92016);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.hu((int)l2);
        locale.cNO = ((int)(l2 + locale.cNO));
      }
      if (locale.cNO >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(92016);
    return false;
    if (locale.cNO == l1 + l3)
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
    if (this.cLN.limit >= paramInt)
    {
      AppMethodBeat.o(92021);
      return;
    }
    if (this.cLN.UG() < paramInt) {
      this.cLN.n(Arrays.copyOf(this.cLN.data, Math.max(this.cLN.data.length * 2, paramInt)), this.cLN.limit);
    }
    paramf.readFully(this.cLN.data, this.cLN.limit, paramInt - this.cLN.limit);
    this.cLN.iG(paramInt);
    AppMethodBeat.o(92021);
  }
  
  final long cd(long paramLong)
  {
    AppMethodBeat.i(92027);
    if (this.cMG == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(92027);
      throw localo;
    }
    paramLong = x.c(paramLong, this.cMG, 1000L);
    AppMethodBeat.o(92027);
    return paramLong;
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
        Arrays.fill(locald.cMy.data, (byte)0);
        paramf.readFully(locald.cMy.data, 4 - paramInt2, paramInt2);
        locald.cMy.setPosition(0);
        locald.cMK = ((int)locald.cMy.FT());
        AppMethodBeat.o(92010);
        return;
      case 25506: 
        locald.cMI.cNt = new byte[paramInt2];
        paramf.readFully(locald.cMI.cNt, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 30322: 
        locald.cMI.cGU = new byte[paramInt2];
        paramf.readFully(locald.cMI.cGU, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 16981: 
        locald.cMI.cNr = new byte[paramInt2];
        paramf.readFully(locald.cMI.cNr, 0, paramInt2);
        AppMethodBeat.o(92010);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.cMI.cNs = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(92010);
        return;
      }
      if (locald.cMT == 0)
      {
        locald.cMZ = ((int)locald.cMg.a(paramf, false, true, 8));
        locald.cNa = locald.cMg.length;
        locald.cMV = -9223372036854775807L;
        locald.cMT = 1;
        locald.cLN.reset();
      }
      Object localObject1 = (d.b)locald.cMv.get(locald.cMZ);
      if (localObject1 == null)
      {
        paramf.eP(paramInt2 - locald.cNa);
        locald.cMT = 0;
        AppMethodBeat.o(92010);
        return;
      }
      int i;
      if (locald.cMT == 1)
      {
        locald.b(paramf, 3);
        i = (locald.cLN.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.cMX = 1;
        locald.cMY = d.r(locald.cMY, 1);
        locald.cMY[0] = (paramInt2 - locald.cNa - 3);
        paramInt2 = locald.cLN.data[0];
        i = locald.cLN.data[1];
        locald.cMU = (locald.cMP + locald.cd(paramInt2 << 8 | i & 0xFF));
        if ((locald.cLN.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.cLN.data[2] & 0x80) != 128))) {
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
        locald.cNb = (paramInt2 | i);
        locald.cMT = 2;
        locald.cMW = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.cMW < locald.cMX)
        {
          locald.a(paramf, (d.b)localObject1, locald.cMY[locald.cMW]);
          locald.a((d.b)localObject1, locald.cMU + locald.cMW * ((d.b)localObject1).cNp / 1000);
          locald.cMW += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(92010);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.cMX = ((locald.cLN.data[3] & 0xFF) + 1);
        locald.cMY = d.r(locald.cMY, locald.cMX);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.cNa - 4) / locald.cMX;
          Arrays.fill(locald.cMY, 0, locald.cMX, paramInt2);
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
          while (k < locald.cMX - 1)
          {
            locald.cMY[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.cLN.data[(i - 1)] & 0xFF;
              localObject2 = locald.cMY;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.cMY[k];
            k += 1;
          }
          locald.cMY[(locald.cMX - 1)] = (paramInt2 - locald.cNa - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.cMX - 1)
          {
            locald.cMY[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.cLN.data[(n - 1)] == 0)
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
                if ((locald.cLN.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.cLN.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.cLN.data[i] & 0xFF;
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
            localObject2 = locald.cMY;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.cMY[k];
              k += 1;
              break;
              m += locald.cMY[(k - 1)];
            }
          }
          locald.cMY[(locald.cMX - 1)] = (paramInt2 - locald.cNa - i - j);
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
      locald.cMT = 0;
      AppMethodBeat.o(92010);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.cMY[0]);
      AppMethodBeat.o(92010);
    }
    
    public final void c(int paramInt, double paramDouble)
    {
      d locald = d.this;
      switch (paramInt)
      {
      default: 
        return;
      case 17545: 
        locald.cMH = (paramDouble);
        return;
      case 181: 
        locald.cMI.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.cMI.cNz = ((float)paramDouble);
        return;
      case 21970: 
        locald.cMI.cNA = ((float)paramDouble);
        return;
      case 21971: 
        locald.cMI.cNB = ((float)paramDouble);
        return;
      case 21972: 
        locald.cMI.cNC = ((float)paramDouble);
        return;
      case 21973: 
        locald.cMI.cND = ((float)paramDouble);
        return;
      case 21974: 
        locald.cMI.cNE = ((float)paramDouble);
        return;
      case 21975: 
        locald.cMI.cNF = ((float)paramDouble);
        return;
      case 21976: 
        locald.cMI.cNG = ((float)paramDouble);
        return;
      case 21977: 
        locald.cMI.cNH = ((float)paramDouble);
        return;
      }
      locald.cMI.cNI = ((float)paramDouble);
    }
    
    public final void e(int paramInt, String paramString)
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
          locald.cMI.cNo = paramString;
          AppMethodBeat.o(92009);
          return;
          locald.cMI.language = paramString;
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
        if ((((d)localObject).cMF != -1L) && (((d)localObject).cMF != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(92006);
          throw ((Throwable)localObject);
        }
        ((d)localObject).cMF = paramLong1;
        ((d)localObject).cME = paramLong2;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).cMK = -1;
        ((d)localObject).cML = -1L;
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).cMQ = new com.google.android.exoplayer2.i.h();
        ((d)localObject).cMR = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(92006);
        return;
        ((d)localObject).cMS = false;
        AppMethodBeat.o(92006);
        return;
        if (!((d)localObject).cMJ)
        {
          if ((((d)localObject).cMw) && (((d)localObject).cMN != -1L))
          {
            ((d)localObject).cMM = true;
            AppMethodBeat.o(92006);
            return;
          }
          ((d)localObject).cLR.a(new l.a(((d)localObject).cHg));
          ((d)localObject).cMJ = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).cNm = false;
          AppMethodBeat.o(92006);
          return;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).cMI.cNq = true;
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).cMI = new d.b((byte)0);
          AppMethodBeat.o(92006);
          return;
          ((d)localObject).cMI.cNv = true;
        }
      }
    }
    
    public final int hB(int paramInt)
    {
      AppMethodBeat.i(92004);
      paramInt = d.hB(paramInt);
      AppMethodBeat.o(92004);
      return paramInt;
    }
    
    public final boolean hC(int paramInt)
    {
      AppMethodBeat.i(92005);
      boolean bool = d.hC(paramInt);
      AppMethodBeat.o(92005);
      return bool;
    }
    
    public final void hD(int paramInt)
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
        if (locald.cMG == -9223372036854775807L) {
          locald.cMG = 1000000L;
        }
        if (locald.cMH != -9223372036854775807L)
        {
          locald.cHg = locald.cd(locald.cMH);
          AppMethodBeat.o(92007);
          return;
          Object localObject1;
          if ((locald.cMK == -1) || (locald.cML == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(92007);
            throw ((Throwable)localObject1);
          }
          if (locald.cMK == 475249515)
          {
            locald.cMN = locald.cML;
            AppMethodBeat.o(92007);
            return;
            if (!locald.cMJ)
            {
              Object localObject2 = locald.cLR;
              if ((locald.cMF == -1L) || (locald.cHg == -9223372036854775807L) || (locald.cMQ == null) || (locald.cMQ.size == 0) || (locald.cMR == null) || (locald.cMR.size != locald.cMQ.size))
              {
                locald.cMQ = null;
                locald.cMR = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.cHg);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.cMJ = true;
                AppMethodBeat.o(92007);
                return;
                i = locald.cMQ.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.cMQ.get(paramInt);
                  localObject3[paramInt] = (locald.cMF + locald.cMR.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.cMF + locald.cME - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.cHg - localObject5[(i - 1)]);
                locald.cMQ = null;
                locald.cMR = null;
              }
              if (locald.cMT == 2)
              {
                if (!locald.cNm) {
                  locald.cNb |= 0x1;
                }
                locald.a((d.b)locald.cMv.get(locald.cMZ), locald.cMU);
                locald.cMT = 0;
                AppMethodBeat.o(92007);
                return;
                if (locald.cMI.cNq)
                {
                  if (locald.cMI.cNs == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                  }
                  locald.cMI.cGQ = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.cFf, "video/webm", locald.cMI.cNs.cLH) });
                  AppMethodBeat.o(92007);
                  return;
                  if ((locald.cMI.cNq) && (locald.cMI.cNr != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.cMI.cNo;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.cMI;
                      localObject5 = locald.cLR;
                      m = locald.cMI.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).cNo;
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
                    if (((d.b)localObject4).cNN)
                    {
                      j = 1;
                      if (!((d.b)localObject4).cNM) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.df((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).channelCount, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).cGQ, j, ((d.b)localObject4).language);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).cMa = ((g)localObject5).hz(((d.b)localObject4).number);
                      ((d.b)localObject4).cMa.f((Format)localObject1);
                      locald.cMv.put(locald.cMI.number, locald.cMI);
                      label2178:
                      locald.cMI = null;
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
                      if (((d.b)localObject4).cNt == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).cNt))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).cNt));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).cGP;
                      ((d.b)localObject4).cMd = ((com.google.android.exoplayer2.video.a)localObject3).cMd;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).cNt));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).cGP;
                      ((d.b)localObject4).cMd = ((com.google.android.exoplayer2.video.b)localObject3).cMd;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).cNt));
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
                      localObject2 = d.b.u(((d.b)localObject4).cNt);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).cNt);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).cNK).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).cNL).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).cNt);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).cNt);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).cNt)))
                      {
                        k = x.iM(((d.b)localObject4).cNJ);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).cNJ).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.iM(((d.b)localObject4).cNJ);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).cNJ).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).cNt);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.cNt[0], localObject4.cNt[1], localObject4.cNt[2], localObject4.cNt[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3003:
                      k = 0;
                      break label2071;
                      label3009:
                      if (j.isVideo((String)localObject1))
                      {
                        label3041:
                        label3064:
                        float f1;
                        if (((d.b)localObject4).cNu == 0)
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
                          if (((d.b)localObject4).cNv)
                          {
                            if ((((d.b)localObject4).cNz != -1.0F) && (((d.b)localObject4).cNA != -1.0F) && (((d.b)localObject4).cNB != -1.0F) && (((d.b)localObject4).cNC != -1.0F) && (((d.b)localObject4).cND != -1.0F) && (((d.b)localObject4).cNE != -1.0F) && (((d.b)localObject4).cNF != -1.0F) && (((d.b)localObject4).cNG != -1.0F) && (((d.b)localObject4).cNH != -1.0F) && (((d.b)localObject4).cNI != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).cNw, ((d.b)localObject4).colorRange, ((d.b)localObject4).colorTransfer, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).cGU, ((d.b)localObject4).cGT, (ColorInfo)localObject3, ((d.b)localObject4).cGQ);
                          break;
                          i = ((d.b)localObject4).displayWidth;
                          break label3041;
                          i = ((d.b)localObject4).displayHeight;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNz * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNA * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNB * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNC * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cND * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNE * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNF * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNG * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNH + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).cNI + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).cNx);
                          localByteBuffer.putShort((short)((d.b)localObject4).cNy);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, ((d.b)localObject4).cGQ);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.cMp);
                        ((List)localObject2).add(((d.b)localObject4).cNt);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).language, -1, ((d.b)localObject4).cGQ, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).language, ((d.b)localObject4).cGQ);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(92007);
                    throw ((Throwable)localObject1);
                    if (locald.cMv.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(92007);
                      throw ((Throwable)localObject1);
                    }
                    locald.cLR.RW();
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
            ((d)localObject).cML = (((d)localObject).cMF + paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMG = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.width = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.height = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.displayWidth = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.displayHeight = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.cNu = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.number = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            localObject = ((d)localObject).cMI;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).cNM = bool1;
              AppMethodBeat.o(92008);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).cMI;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).cNN = bool1;
              AppMethodBeat.o(92008);
              return;
            }
            ((d)localObject).cMI.type = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.cNp = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.cNK = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.cNL = paramLong;
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.channelCount = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cMI.cNJ = ((int)paramLong);
            AppMethodBeat.o(92008);
            return;
            ((d)localObject).cNm = true;
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
                      ((d)localObject).cMQ.add(((d)localObject).cd(paramLong));
                      AppMethodBeat.o(92008);
                      return;
                      if (!((d)localObject).cMS)
                      {
                        ((d)localObject).cMR.add(paramLong);
                        ((d)localObject).cMS = true;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).cMP = ((d)localObject).cd(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).cMV = ((d)localObject).cd(paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 0: 
                          ((d)localObject).cMI.cGT = 0;
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).cMI.cGT = 2;
                          AppMethodBeat.o(92008);
                          return;
                        case 3: 
                          ((d)localObject).cMI.cGT = 1;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).cMI.cGT = 3;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).cMI.cNv = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).cMI.cNw = 1;
                          AppMethodBeat.o(92008);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).cMI.cNw = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).cMI.cNw = 6;
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
                          ((d)localObject).cMI.colorTransfer = 3;
                          AppMethodBeat.o(92008);
                          return;
                        case 16: 
                          ((d)localObject).cMI.colorTransfer = 6;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).cMI.colorTransfer = 7;
                        AppMethodBeat.o(92008);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(92008);
                          return;
                        case 1: 
                          ((d)localObject).cMI.colorRange = 2;
                          AppMethodBeat.o(92008);
                          return;
                        }
                        ((d)localObject).cMI.colorRange = 1;
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).cMI.cNx = ((int)paramLong);
                        AppMethodBeat.o(92008);
                        return;
                        ((d)localObject).cMI.cNy = ((int)paramLong);
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
    public DrmInitData cGQ;
    public int cGT = -1;
    public byte[] cGU = null;
    public com.google.android.exoplayer2.c.m cMa;
    public int cMd;
    public float cNA = -1.0F;
    public float cNB = -1.0F;
    public float cNC = -1.0F;
    public float cND = -1.0F;
    public float cNE = -1.0F;
    public float cNF = -1.0F;
    public float cNG = -1.0F;
    public float cNH = -1.0F;
    public float cNI = -1.0F;
    public int cNJ = -1;
    public long cNK = 0L;
    public long cNL = 0L;
    public boolean cNM;
    public boolean cNN = true;
    public String cNo;
    public int cNp;
    public boolean cNq;
    public byte[] cNr;
    public m.a cNs;
    public byte[] cNt;
    public int cNu = 0;
    public boolean cNv = false;
    public int cNw = -1;
    public int cNx = 1000;
    public int cNy = 200;
    public float cNz = -1.0F;
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
        paramm.iH(16);
        long l = paramm.UJ();
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
        int i = paramm.UH();
        if (i == 1)
        {
          AppMethodBeat.o(92013);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.RZ().getMostSignificantBits()) && (paramm.readLong() == d.RZ().getLeastSignificantBits()))
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
    
    static List<byte[]> u(byte[] paramArrayOfByte)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.d
 * JD-Core Version:    0.7.0.1
 */