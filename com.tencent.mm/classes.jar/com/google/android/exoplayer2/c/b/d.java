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
  public static final com.google.android.exoplayer2.c.h aBP;
  private static final byte[] aCq;
  private static final byte[] aCr;
  private static long aCs;
  static final byte[] aCt;
  private static final byte[] aCu;
  private static long aCv;
  private static final byte[] aCw;
  private static final UUID aCx;
  final com.google.android.exoplayer2.i.m aBR;
  g aBV;
  final boolean aCA;
  private final com.google.android.exoplayer2.i.m aCB;
  final com.google.android.exoplayer2.i.m aCC;
  private final com.google.android.exoplayer2.i.m aCD;
  private final com.google.android.exoplayer2.i.m aCE;
  private final com.google.android.exoplayer2.i.m aCF;
  private final com.google.android.exoplayer2.i.m aCG;
  private ByteBuffer aCH;
  long aCI;
  long aCJ;
  long aCK;
  long aCL;
  b aCM;
  boolean aCN;
  int aCO;
  long aCP;
  boolean aCQ;
  long aCR;
  private long aCS;
  long aCT;
  com.google.android.exoplayer2.i.h aCU;
  com.google.android.exoplayer2.i.h aCV;
  boolean aCW;
  int aCX;
  long aCY;
  long aCZ;
  private final com.google.android.exoplayer2.i.m aCf;
  private final com.google.android.exoplayer2.i.m aCg;
  final f aCk;
  private final b aCy;
  final SparseArray<b> aCz;
  int aDa;
  int aDb;
  int[] aDc;
  int aDd;
  int aDe;
  int aDf;
  private int aDg;
  private boolean aDh;
  private boolean aDi;
  private boolean aDj;
  private boolean aDk;
  private byte aDl;
  private int aDm;
  private int aDn;
  private int aDo;
  private boolean aDp;
  boolean aDq;
  long axh;
  
  static
  {
    AppMethodBeat.i(94914);
    aBP = new d.1();
    aCq = new byte[] { 49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10 };
    aCr = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aCs = 1000L;
    aCt = x.aP("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    aCu = new byte[] { 68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44 };
    aCv = 10000L;
    aCw = new byte[] { 32, 32, 32, 32, 32, 32, 32, 32, 32, 32 };
    aCx = new UUID(72057594037932032L, -9223371306706625679L);
    AppMethodBeat.o(94914);
  }
  
  public d()
  {
    this(0);
  }
  
  public d(int paramInt)
  {
    this(new a(), paramInt);
    AppMethodBeat.i(94899);
    AppMethodBeat.o(94899);
  }
  
  private d(b paramb, int paramInt)
  {
    AppMethodBeat.i(94900);
    this.aCJ = -1L;
    this.aCK = -9223372036854775807L;
    this.aCL = -9223372036854775807L;
    this.axh = -9223372036854775807L;
    this.aCR = -1L;
    this.aCS = -1L;
    this.aCT = -9223372036854775807L;
    this.aCy = paramb;
    this.aCy.a(new a((byte)0));
    if ((paramInt & 0x1) == 0) {
      bool = true;
    }
    this.aCA = bool;
    this.aCk = new f();
    this.aCz = new SparseArray();
    this.aBR = new com.google.android.exoplayer2.i.m(4);
    this.aCB = new com.google.android.exoplayer2.i.m(ByteBuffer.allocate(4).putInt(-1).array());
    this.aCC = new com.google.android.exoplayer2.i.m(4);
    this.aCf = new com.google.android.exoplayer2.i.m(com.google.android.exoplayer2.i.k.baF);
    this.aCg = new com.google.android.exoplayer2.i.m(4);
    this.aCD = new com.google.android.exoplayer2.i.m();
    this.aCE = new com.google.android.exoplayer2.i.m();
    this.aCF = new com.google.android.exoplayer2.i.m(8);
    this.aCG = new com.google.android.exoplayer2.i.m();
    AppMethodBeat.o(94900);
  }
  
  private int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.m paramm, int paramInt)
  {
    AppMethodBeat.i(94911);
    int i = this.aCD.qM();
    if (i > 0)
    {
      paramInt = Math.min(paramInt, i);
      paramm.a(this.aCD, paramInt);
    }
    for (;;)
    {
      this.aDg += paramInt;
      this.aDo += paramInt;
      AppMethodBeat.o(94911);
      return paramInt;
      paramInt = paramm.a(paramf, paramInt, false);
    }
  }
  
  private void a(b paramb, String paramString, int paramInt, long paramLong, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(94909);
    a(this.aCE.data, this.aCZ, paramString, paramInt, paramLong, paramArrayOfByte);
    paramb.aCe.a(this.aCE, this.aCE.limit);
    this.aDo += this.aCE.limit;
    AppMethodBeat.o(94909);
  }
  
  private void a(com.google.android.exoplayer2.c.f paramf, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(94908);
    int i = paramArrayOfByte.length + paramInt;
    if (this.aCE.capacity() < i) {
      this.aCE.data = Arrays.copyOf(paramArrayOfByte, i + paramInt);
    }
    for (;;)
    {
      paramf.readFully(this.aCE.data, paramArrayOfByte.length, paramInt);
      this.aCE.reset(i);
      AppMethodBeat.o(94908);
      return;
      System.arraycopy(paramArrayOfByte, 0, this.aCE.data, 0, paramArrayOfByte.length);
    }
  }
  
  private static void a(byte[] paramArrayOfByte1, long paramLong1, String paramString, int paramInt, long paramLong2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(94910);
    if (paramLong1 == -9223372036854775807L) {}
    int i;
    int j;
    int k;
    int m;
    for (paramString = paramArrayOfByte2;; paramString = x.aP(String.format(Locale.US, paramString, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m) })))
    {
      System.arraycopy(paramString, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
      AppMethodBeat.o(94910);
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
    AppMethodBeat.i(94913);
    if (paramArrayOfInt == null)
    {
      paramArrayOfInt = new int[paramInt];
      AppMethodBeat.o(94913);
      return paramArrayOfInt;
    }
    if (paramArrayOfInt.length >= paramInt)
    {
      AppMethodBeat.o(94913);
      return paramArrayOfInt;
    }
    paramArrayOfInt = new int[Math.max(paramArrayOfInt.length * 2, paramInt)];
    AppMethodBeat.o(94913);
    return paramArrayOfInt;
  }
  
  static int jdMethod_do(int paramInt)
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
  
  static boolean dp(int paramInt)
  {
    return (paramInt == 357149030) || (paramInt == 524531317) || (paramInt == 475249515) || (paramInt == 374648427);
  }
  
  private void ob()
  {
    AppMethodBeat.i(94905);
    this.aDg = 0;
    this.aDo = 0;
    this.aDn = 0;
    this.aDh = false;
    this.aDi = false;
    this.aDk = false;
    this.aDm = 0;
    this.aDl = 0;
    this.aDj = false;
    this.aCD.reset();
    AppMethodBeat.o(94905);
  }
  
  final long F(long paramLong)
  {
    AppMethodBeat.i(94912);
    if (this.aCK == -9223372036854775807L)
    {
      o localo = new o("Can't scale timecode prior to timecodeScale being set.");
      AppMethodBeat.o(94912);
      throw localo;
    }
    paramLong = x.b(paramLong, this.aCK, 1000L);
    AppMethodBeat.o(94912);
    return paramLong;
  }
  
  public final int a(com.google.android.exoplayer2.c.f paramf, com.google.android.exoplayer2.c.k paramk)
  {
    AppMethodBeat.i(94903);
    this.aDp = false;
    boolean bool = true;
    label155:
    for (;;)
    {
      int i;
      if ((bool) && (!this.aDp))
      {
        bool = this.aCy.c(paramf);
        if (!bool) {
          break label155;
        }
        long l = paramf.getPosition();
        if (this.aCQ)
        {
          this.aCS = l;
          paramk.position = this.aCR;
          this.aCQ = false;
          i = 1;
        }
      }
      while (i != 0)
      {
        AppMethodBeat.o(94903);
        return 1;
        if ((this.aCN) && (this.aCS != -1L))
        {
          paramk.position = this.aCS;
          this.aCS = -1L;
          i = 1;
        }
        else
        {
          i = 0;
          continue;
          if (bool)
          {
            AppMethodBeat.o(94903);
            return 0;
          }
          AppMethodBeat.o(94903);
          return -1;
        }
      }
    }
  }
  
  final void a(b paramb, long paramLong)
  {
    AppMethodBeat.i(94904);
    if ("S_TEXT/UTF8".equals(paramb.aDs)) {
      a(paramb, "%02d:%02d:%02d,%03d", 19, aCs, aCr);
    }
    for (;;)
    {
      paramb.aCe.a(paramLong, this.aDf, this.aDo, 0, paramb.aDw);
      this.aDp = true;
      ob();
      AppMethodBeat.o(94904);
      return;
      if ("S_TEXT/ASS".equals(paramb.aDs)) {
        a(paramb, "%01d:%02d:%02d:%02d", 21, aCv, aCw);
      }
    }
  }
  
  final void a(com.google.android.exoplayer2.c.f paramf, b paramb, int paramInt)
  {
    AppMethodBeat.i(94907);
    if ("S_TEXT/UTF8".equals(paramb.aDs))
    {
      a(paramf, aCq, paramInt);
      AppMethodBeat.o(94907);
      return;
    }
    if ("S_TEXT/ASS".equals(paramb.aDs))
    {
      a(paramf, aCu, paramInt);
      AppMethodBeat.o(94907);
      return;
    }
    com.google.android.exoplayer2.c.m localm = paramb.aCe;
    int i;
    label215:
    byte[] arrayOfByte;
    int j;
    label285:
    int k;
    if (!this.aDh)
    {
      if (!paramb.aDu) {
        break label922;
      }
      this.aDf &= 0xBFFFFFFF;
      if (!this.aDi)
      {
        paramf.readFully(this.aBR.data, 0, 1);
        this.aDg += 1;
        if ((this.aBR.data[0] & 0x80) == 128)
        {
          paramf = new o("Extension bit is set in signal byte");
          AppMethodBeat.o(94907);
          throw paramf;
        }
        this.aDl = this.aBR.data[0];
        this.aDi = true;
      }
      int m;
      if ((this.aDl & 0x1) == 1)
      {
        i = 1;
        if (i == 0) {
          break label692;
        }
        if ((this.aDl & 0x2) != 2) {
          break label593;
        }
        i = 1;
        this.aDf |= 0x40000000;
        if (!this.aDj)
        {
          paramf.readFully(this.aCF.data, 0, 8);
          this.aDg += 8;
          this.aDj = true;
          arrayOfByte = this.aBR.data;
          if (i == 0) {
            break label599;
          }
          j = 128;
          arrayOfByte[0] = ((byte)(j | 0x8));
          this.aBR.setPosition(0);
          localm.a(this.aBR, 1);
          this.aDo += 1;
          this.aCF.setPosition(0);
          localm.a(this.aCF, 8);
          this.aDo += 8;
        }
        if (i == 0) {
          break label692;
        }
        if (!this.aDk)
        {
          paramf.readFully(this.aBR.data, 0, 1);
          this.aDg += 1;
          this.aBR.setPosition(0);
          this.aDm = this.aBR.readUnsignedByte();
          this.aDk = true;
        }
        i = this.aDm * 4;
        this.aBR.reset(i);
        paramf.readFully(this.aBR.data, 0, i);
        this.aDg = (i + this.aDg);
        short s = (short)(this.aDm / 2 + 1);
        m = s * 6 + 2;
        if ((this.aCH == null) || (this.aCH.capacity() < m)) {
          this.aCH = ByteBuffer.allocate(m);
        }
        this.aCH.position(0);
        this.aCH.putShort(s);
        i = 0;
        j = 0;
        label535:
        if (j >= this.aDm) {
          break label621;
        }
        k = this.aBR.qT();
        if (j % 2 != 0) {
          break label605;
        }
        this.aCH.putShort((short)(k - i));
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
        this.aCH.putInt(k - i);
      }
      label621:
      i = paramInt - this.aDg - i;
      if (this.aDm % 2 == 1)
      {
        this.aCH.putInt(i);
        this.aCG.l(this.aCH.array(), m);
        localm.a(this.aCG, m);
        this.aDo += m;
        label692:
        this.aDh = true;
      }
    }
    else
    {
      paramInt = this.aCD.limit + paramInt;
      if ((!"V_MPEG4/ISO/AVC".equals(paramb.aDs)) && (!"V_MPEGH/ISO/HEVC".equals(paramb.aDs))) {
        break label971;
      }
      arrayOfByte = this.aCg.data;
      arrayOfByte[0] = 0;
      arrayOfByte[1] = 0;
      arrayOfByte[2] = 0;
      i = paramb.aCh;
      j = 4 - paramb.aCh;
    }
    for (;;)
    {
      if (this.aDg < paramInt)
      {
        if (this.aDn == 0)
        {
          k = Math.min(i, this.aCD.qM());
          paramf.readFully(arrayOfByte, j + k, i - k);
          if (k > 0) {
            this.aCD.readBytes(arrayOfByte, j, k);
          }
          this.aDg += i;
          this.aCg.setPosition(0);
          this.aDn = this.aCg.qT();
          this.aCf.setPosition(0);
          localm.a(this.aCf, 4);
          this.aDo += 4;
          continue;
          this.aCH.putShort((short)i);
          this.aCH.putInt(0);
          break;
          label922:
          if (paramb.aDv == null) {
            break label692;
          }
          this.aCD.l(paramb.aDv, paramb.aDv.length);
          break label692;
        }
        this.aDn -= a(paramf, localm, this.aDn);
        continue;
        label971:
        while (this.aDg < paramInt) {
          a(paramf, localm, paramInt - this.aDg);
        }
      }
    }
    if ("A_VORBIS".equals(paramb.aDs))
    {
      this.aCB.setPosition(0);
      localm.a(this.aCB, 4);
      this.aDo += 4;
    }
    AppMethodBeat.o(94907);
  }
  
  public final void a(g paramg)
  {
    this.aBV = paramg;
  }
  
  public final boolean a(com.google.android.exoplayer2.c.f paramf)
  {
    AppMethodBeat.i(94901);
    e locale = new e();
    long l2 = paramf.getLength();
    if ((l2 == -1L) || (l2 > 1024L)) {}
    for (long l1 = 1024L;; l1 = l2)
    {
      int i = (int)l1;
      paramf.b(locale.aBR.data, 0, 4);
      l1 = locale.aBR.cc();
      locale.aDW = 4;
      while (l1 != 440786851L)
      {
        int j = locale.aDW + 1;
        locale.aDW = j;
        if (j == i) {
          break label330;
        }
        paramf.b(locale.aBR.data, 0, 1);
        l1 = l1 << 8 & 0xFFFFFF00 | locale.aBR.data[0] & 0xFF;
      }
    }
    l1 = locale.d(paramf);
    long l3 = locale.aDW;
    if ((l1 == -9223372036854775808L) || ((l2 != -1L) && (l3 + l1 >= l2)))
    {
      AppMethodBeat.o(94901);
      return false;
    }
    do
    {
      if (l2 != 0L)
      {
        paramf.dh((int)l2);
        locale.aDW = ((int)(l2 + locale.aDW));
      }
      if (locale.aDW >= l3 + l1) {
        break;
      }
      if (locale.d(paramf) == -9223372036854775808L) {
        break label330;
      }
      l2 = locale.d(paramf);
    } while ((l2 >= 0L) && (l2 <= 2147483647L));
    AppMethodBeat.o(94901);
    return false;
    if (locale.aDW == l1 + l3)
    {
      AppMethodBeat.o(94901);
      return true;
    }
    label330:
    AppMethodBeat.o(94901);
    return false;
  }
  
  final void b(com.google.android.exoplayer2.c.f paramf, int paramInt)
  {
    AppMethodBeat.i(94906);
    if (this.aBR.limit >= paramInt)
    {
      AppMethodBeat.o(94906);
      return;
    }
    if (this.aBR.capacity() < paramInt) {
      this.aBR.l(Arrays.copyOf(this.aBR.data, Math.max(this.aBR.data.length * 2, paramInt)), this.aBR.limit);
    }
    paramf.readFully(this.aBR.data, this.aBR.limit, paramInt - this.aBR.limit);
    this.aBR.em(paramInt);
    AppMethodBeat.o(94906);
  }
  
  public final void g(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(94902);
    this.aCT = -9223372036854775807L;
    this.aCX = 0;
    this.aCy.reset();
    this.aCk.reset();
    ob();
    AppMethodBeat.o(94902);
  }
  
  final class a
    implements c
  {
    private a() {}
    
    public final void a(int paramInt1, int paramInt2, com.google.android.exoplayer2.c.f paramf)
    {
      AppMethodBeat.i(94895);
      d locald = d.this;
      switch (paramInt1)
      {
      default: 
        paramf = new o("Unexpected id: ".concat(String.valueOf(paramInt1)));
        AppMethodBeat.o(94895);
        throw paramf;
      case 21419: 
        Arrays.fill(locald.aCC.data, (byte)0);
        paramf.readFully(locald.aCC.data, 4 - paramInt2, paramInt2);
        locald.aCC.setPosition(0);
        locald.aCO = ((int)locald.aCC.cc());
        AppMethodBeat.o(94895);
        return;
      case 25506: 
        locald.aCM.aDx = new byte[paramInt2];
        paramf.readFully(locald.aCM.aDx, 0, paramInt2);
        AppMethodBeat.o(94895);
        return;
      case 30322: 
        locald.aCM.awS = new byte[paramInt2];
        paramf.readFully(locald.aCM.awS, 0, paramInt2);
        AppMethodBeat.o(94895);
        return;
      case 16981: 
        locald.aCM.aDv = new byte[paramInt2];
        paramf.readFully(locald.aCM.aDv, 0, paramInt2);
        AppMethodBeat.o(94895);
        return;
      case 18402: 
        localObject1 = new byte[paramInt2];
        paramf.readFully((byte[])localObject1, 0, paramInt2);
        locald.aCM.aDw = new m.a(1, (byte[])localObject1, 0, 0);
        AppMethodBeat.o(94895);
        return;
      }
      if (locald.aCX == 0)
      {
        locald.aDd = ((int)locald.aCk.a(paramf, false, true, 8));
        locald.aDe = locald.aCk.length;
        locald.aCZ = -9223372036854775807L;
        locald.aCX = 1;
        locald.aBR.reset();
      }
      Object localObject1 = (d.b)locald.aCz.get(locald.aDd);
      if (localObject1 == null)
      {
        paramf.dg(paramInt2 - locald.aDe);
        locald.aCX = 0;
        AppMethodBeat.o(94895);
        return;
      }
      int i;
      if (locald.aCX == 1)
      {
        locald.b(paramf, 3);
        i = (locald.aBR.data[2] & 0x6) >> 1;
        if (i != 0) {
          break label716;
        }
        locald.aDb = 1;
        locald.aDc = d.d(locald.aDc, 1);
        locald.aDc[0] = (paramInt2 - locald.aDe - 3);
        paramInt2 = locald.aBR.data[0];
        i = locald.aBR.data[1];
        locald.aCY = (locald.aCT + locald.F(paramInt2 << 8 | i & 0xFF));
        if ((locald.aBR.data[2] & 0x8) != 8) {
          break label1404;
        }
        paramInt2 = 1;
        label558:
        if ((((d.b)localObject1).type != 2) && ((paramInt1 != 163) || ((locald.aBR.data[2] & 0x80) != 128))) {
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
        locald.aDf = (paramInt2 | i);
        locald.aCX = 2;
        locald.aDa = 0;
        if (paramInt1 != 163) {
          break label1438;
        }
        while (locald.aDa < locald.aDb)
        {
          locald.a(paramf, (d.b)localObject1, locald.aDc[locald.aDa]);
          locald.a((d.b)localObject1, locald.aCY + locald.aDa * ((d.b)localObject1).aDt / 1000);
          locald.aDa += 1;
        }
        label716:
        if (paramInt1 != 163)
        {
          paramf = new o("Lacing only supported in SimpleBlocks.");
          AppMethodBeat.o(94895);
          throw paramf;
        }
        locald.b(paramf, 4);
        locald.aDb = ((locald.aBR.data[3] & 0xFF) + 1);
        locald.aDc = d.d(locald.aDc, locald.aDb);
        if (i == 2)
        {
          paramInt2 = (paramInt2 - locald.aDe - 4) / locald.aDb;
          Arrays.fill(locald.aDc, 0, locald.aDb, paramInt2);
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
          while (k < locald.aDb - 1)
          {
            locald.aDc[k] = 0;
            m = i;
            do
            {
              i = m + 1;
              locald.b(paramf, i);
              n = locald.aBR.data[(i - 1)] & 0xFF;
              localObject2 = locald.aDc;
              localObject2[k] += n;
              m = i;
            } while (n == 255);
            j += locald.aDc[k];
            k += 1;
          }
          locald.aDc[(locald.aDb - 1)] = (paramInt2 - locald.aDe - i - j);
          break;
        }
        if (i == 3)
        {
          j = 0;
          i = 4;
          k = 0;
          if (k < locald.aDb - 1)
          {
            locald.aDc[k] = 0;
            n = i + 1;
            locald.b(paramf, n);
            if (locald.aBR.data[(n - 1)] == 0)
            {
              paramf = new o("No valid varint length mask found");
              AppMethodBeat.o(94895);
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
                if ((locald.aBR.data[(n - 1)] & i1) == 0) {
                  break label1277;
                }
                int i2 = n - 1;
                n += m;
                locald.b(paramf, n);
                localObject2 = locald.aBR.data;
                i = i2 + 1;
                l2 = localObject2[i2] & 0xFF & (i1 ^ 0xFFFFFFFF);
                while (i < n)
                {
                  l2 = l2 << 8 | locald.aBR.data[i] & 0xFF;
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
              AppMethodBeat.o(94895);
              throw paramf;
              label1277:
              m += 1;
            }
            m = (int)l1;
            localObject2 = locald.aDc;
            if (k == 0) {}
            for (;;)
            {
              localObject2[k] = m;
              j += locald.aDc[k];
              k += 1;
              break;
              m += locald.aDc[(k - 1)];
            }
          }
          locald.aDc[(locald.aDb - 1)] = (paramInt2 - locald.aDe - i - j);
          break;
        }
        paramf = new o("Unexpected lacing value: ".concat(String.valueOf(i)));
        AppMethodBeat.o(94895);
        throw paramf;
        label1404:
        paramInt2 = 0;
        break label558;
        i = 0;
        break label597;
        i = 0;
        break label605;
      }
      locald.aCX = 0;
      AppMethodBeat.o(94895);
      return;
      label1438:
      locald.a(paramf, (d.b)localObject1, locald.aDc[0]);
      AppMethodBeat.o(94895);
    }
    
    public final void c(int paramInt, double paramDouble)
    {
      d locald = d.this;
      switch (paramInt)
      {
      default: 
        return;
      case 17545: 
        locald.aCL = (paramDouble);
        return;
      case 181: 
        locald.aCM.sampleRate = ((int)paramDouble);
        return;
      case 21969: 
        locald.aCM.aDH = ((float)paramDouble);
        return;
      case 21970: 
        locald.aCM.aDI = ((float)paramDouble);
        return;
      case 21971: 
        locald.aCM.aDJ = ((float)paramDouble);
        return;
      case 21972: 
        locald.aCM.aDK = ((float)paramDouble);
        return;
      case 21973: 
        locald.aCM.aDL = ((float)paramDouble);
        return;
      case 21974: 
        locald.aCM.aDM = ((float)paramDouble);
        return;
      case 21975: 
        locald.aCM.aDN = ((float)paramDouble);
        return;
      case 21976: 
        locald.aCM.aDO = ((float)paramDouble);
        return;
      case 21977: 
        locald.aCM.aDP = ((float)paramDouble);
        return;
      }
      locald.aCM.aDQ = ((float)paramDouble);
    }
    
    public final void d(int paramInt, String paramString)
    {
      AppMethodBeat.i(94894);
      d locald = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94894);
        return;
        if ((!"webm".equals(paramString)) && (!"matroska".equals(paramString)))
        {
          paramString = new o("DocType " + paramString + " not supported");
          AppMethodBeat.o(94894);
          throw paramString;
          locald.aCM.aDs = paramString;
          AppMethodBeat.o(94894);
          return;
          locald.aCM.axa = paramString;
        }
      }
    }
    
    public final int jdMethod_do(int paramInt)
    {
      AppMethodBeat.i(94889);
      paramInt = d.jdMethod_do(paramInt);
      AppMethodBeat.o(94889);
      return paramInt;
    }
    
    public final boolean dp(int paramInt)
    {
      AppMethodBeat.i(94890);
      boolean bool = d.dp(paramInt);
      AppMethodBeat.o(94890);
      return bool;
    }
    
    public final void dq(int paramInt)
    {
      AppMethodBeat.i(94892);
      d locald = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94892);
        return;
        if (locald.aCK == -9223372036854775807L) {
          locald.aCK = 1000000L;
        }
        if (locald.aCL != -9223372036854775807L)
        {
          locald.axh = locald.F(locald.aCL);
          AppMethodBeat.o(94892);
          return;
          Object localObject1;
          if ((locald.aCO == -1) || (locald.aCP == -1L))
          {
            localObject1 = new o("Mandatory element SeekID or SeekPosition not found");
            AppMethodBeat.o(94892);
            throw ((Throwable)localObject1);
          }
          if (locald.aCO == 475249515)
          {
            locald.aCR = locald.aCP;
            AppMethodBeat.o(94892);
            return;
            if (!locald.aCN)
            {
              Object localObject2 = locald.aBV;
              if ((locald.aCJ == -1L) || (locald.axh == -9223372036854775807L) || (locald.aCU == null) || (locald.aCU.size == 0) || (locald.aCV == null) || (locald.aCV.size != locald.aCU.size))
              {
                locald.aCU = null;
                locald.aCV = null;
              }
              int i;
              Object localObject3;
              Object localObject4;
              Object localObject5;
              for (localObject1 = new l.a(locald.axh);; localObject1 = new com.google.android.exoplayer2.c.a((int[])localObject1, (long[])localObject3, (long[])localObject4, (long[])localObject5))
              {
                ((g)localObject2).a((l)localObject1);
                locald.aCN = true;
                AppMethodBeat.o(94892);
                return;
                i = locald.aCU.size;
                localObject1 = new int[i];
                localObject3 = new long[i];
                localObject4 = new long[i];
                localObject5 = new long[i];
                paramInt = 0;
                while (paramInt < i)
                {
                  localObject5[paramInt] = locald.aCU.get(paramInt);
                  localObject3[paramInt] = (locald.aCJ + locald.aCV.get(paramInt));
                  paramInt += 1;
                }
                paramInt = 0;
                while (paramInt < i - 1)
                {
                  localObject1[paramInt] = ((int)(localObject3[(paramInt + 1)] - localObject3[paramInt]));
                  localObject4[paramInt] = (localObject5[(paramInt + 1)] - localObject5[paramInt]);
                  paramInt += 1;
                }
                localObject1[(i - 1)] = ((int)(locald.aCJ + locald.aCI - localObject3[(i - 1)]));
                localObject4[(i - 1)] = (locald.axh - localObject5[(i - 1)]);
                locald.aCU = null;
                locald.aCV = null;
              }
              if (locald.aCX == 2)
              {
                if (!locald.aDq) {
                  locald.aDf |= 0x1;
                }
                locald.a((d.b)locald.aCz.get(locald.aDd), locald.aCY);
                locald.aCX = 0;
                AppMethodBeat.o(94892);
                return;
                if (locald.aCM.aDu)
                {
                  if (locald.aCM.aDw == null)
                  {
                    localObject1 = new o("Encrypted Track found but ContentEncKeyID was not found");
                    AppMethodBeat.o(94892);
                    throw ((Throwable)localObject1);
                  }
                  locald.aCM.awN = new DrmInitData(new DrmInitData.SchemeData[] { new DrmInitData.SchemeData(com.google.android.exoplayer2.b.avd, "video/webm", locald.aCM.aDw.aBL) });
                  AppMethodBeat.o(94892);
                  return;
                  if ((locald.aCM.aDu) && (locald.aCM.aDv != null))
                  {
                    localObject1 = new o("Combining encryption and compression is not supported");
                    AppMethodBeat.o(94892);
                    throw ((Throwable)localObject1);
                    localObject1 = locald.aCM.aDs;
                    label1098:
                    int m;
                    int j;
                    if (("V_VP8".equals(localObject1)) || ("V_VP9".equals(localObject1)) || ("V_MPEG2".equals(localObject1)) || ("V_MPEG4/ISO/SP".equals(localObject1)) || ("V_MPEG4/ISO/ASP".equals(localObject1)) || ("V_MPEG4/ISO/AP".equals(localObject1)) || ("V_MPEG4/ISO/AVC".equals(localObject1)) || ("V_MPEGH/ISO/HEVC".equals(localObject1)) || ("V_MS/VFW/FOURCC".equals(localObject1)) || ("V_THEORA".equals(localObject1)) || ("A_OPUS".equals(localObject1)) || ("A_VORBIS".equals(localObject1)) || ("A_AAC".equals(localObject1)) || ("A_MPEG/L2".equals(localObject1)) || ("A_MPEG/L3".equals(localObject1)) || ("A_AC3".equals(localObject1)) || ("A_EAC3".equals(localObject1)) || ("A_TRUEHD".equals(localObject1)) || ("A_DTS".equals(localObject1)) || ("A_DTS/EXPRESS".equals(localObject1)) || ("A_DTS/LOSSLESS".equals(localObject1)) || ("A_FLAC".equals(localObject1)) || ("A_MS/ACM".equals(localObject1)) || ("A_PCM/INT/LIT".equals(localObject1)) || ("S_TEXT/UTF8".equals(localObject1)) || ("S_TEXT/ASS".equals(localObject1)) || ("S_VOBSUB".equals(localObject1)) || ("S_HDMV/PGS".equals(localObject1)) || ("S_DVBSUB".equals(localObject1)))
                    {
                      paramInt = 1;
                      if (paramInt == 0) {
                        break label2178;
                      }
                      localObject4 = locald.aCM;
                      localObject5 = locald.aBV;
                      m = locald.aCM.number;
                      j = -1;
                      i = -1;
                      localObject3 = null;
                      localObject1 = ((d.b)localObject4).aDs;
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
                        AppMethodBeat.o(94892);
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
                    if (((d.b)localObject4).aDV)
                    {
                      j = 1;
                      if (!((d.b)localObject4).aDU) {
                        break label3003;
                      }
                      k = 2;
                      label2071:
                      j = j | 0x0 | k;
                      if (!j.aG((String)localObject1)) {
                        break label3009;
                      }
                      localObject1 = Format.a(Integer.toString(m), (String)localObject1, -1, paramInt, ((d.b)localObject4).awU, ((d.b)localObject4).sampleRate, i, (List)localObject2, ((d.b)localObject4).awN, j, ((d.b)localObject4).axa);
                    }
                    for (;;)
                    {
                      ((d.b)localObject4).aCe = ((g)localObject5).dm(((d.b)localObject4).number);
                      ((d.b)localObject4).aCe.f((Format)localObject1);
                      locald.aCz.put(locald.aCM.number, locald.aCM);
                      label2178:
                      locald.aCM = null;
                      AppMethodBeat.o(94892);
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
                      if (((d.b)localObject4).aDx == null) {}
                      for (localObject1 = null;; localObject1 = Collections.singletonList(((d.b)localObject4).aDx))
                      {
                        localObject2 = localObject1;
                        localObject1 = localObject3;
                        paramInt = j;
                        break;
                      }
                      localObject1 = "video/avc";
                      localObject3 = com.google.android.exoplayer2.video.a.K(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aDx));
                      localObject2 = ((com.google.android.exoplayer2.video.a)localObject3).awM;
                      ((d.b)localObject4).aCh = ((com.google.android.exoplayer2.video.a)localObject3).aCh;
                      paramInt = j;
                      break;
                      localObject1 = "video/hevc";
                      localObject3 = com.google.android.exoplayer2.video.b.M(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aDx));
                      localObject2 = ((com.google.android.exoplayer2.video.b)localObject3).awM;
                      ((d.b)localObject4).aCh = ((com.google.android.exoplayer2.video.b)localObject3).aCh;
                      paramInt = j;
                      break;
                      localObject2 = d.b.i(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aDx));
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
                      localObject2 = d.b.l(((d.b)localObject4).aDx);
                      break;
                      localObject1 = "audio/opus";
                      paramInt = 5760;
                      localObject2 = new ArrayList(3);
                      ((List)localObject2).add(((d.b)localObject4).aDx);
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aDS).array());
                      ((List)localObject2).add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(((d.b)localObject4).aDT).array());
                      break;
                      localObject1 = "audio/mp4a-latm";
                      localObject2 = Collections.singletonList(((d.b)localObject4).aDx);
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aDx);
                      paramInt = j;
                      break;
                      localObject1 = "audio/raw";
                      if (d.b.j(new com.google.android.exoplayer2.i.m(((d.b)localObject4).aDx)))
                      {
                        k = x.es(((d.b)localObject4).aDR);
                        paramInt = j;
                        i = k;
                        localObject2 = localObject3;
                        if (k != 0) {
                          break;
                        }
                        i = -1;
                        localObject1 = "audio/x-unknown";
                        new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aDR).append(". Setting mimeType to ").append("audio/x-unknown");
                        paramInt = j;
                        localObject2 = localObject3;
                        break;
                      }
                      localObject1 = "audio/x-unknown";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "audio/raw";
                      k = x.es(((d.b)localObject4).aDR);
                      paramInt = j;
                      i = k;
                      localObject2 = localObject3;
                      if (k != 0) {
                        break;
                      }
                      i = -1;
                      localObject1 = "audio/x-unknown";
                      new StringBuilder("Unsupported PCM bit depth: ").append(((d.b)localObject4).aDR).append(". Setting mimeType to ").append("audio/x-unknown");
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
                      localObject2 = Collections.singletonList(((d.b)localObject4).aDx);
                      paramInt = j;
                      break;
                      localObject1 = "application/pgs";
                      paramInt = j;
                      localObject2 = localObject3;
                      break;
                      localObject1 = "application/dvbsubs";
                      localObject2 = Collections.singletonList(new byte[] { localObject4.aDx[0], localObject4.aDx[1], localObject4.aDx[2], localObject4.aDx[3] });
                      paramInt = j;
                      break;
                      j = 0;
                      break label2060;
                      label3003:
                      k = 0;
                      break label2071;
                      label3009:
                      if (j.aH((String)localObject1))
                      {
                        label3041:
                        label3064:
                        float f1;
                        if (((d.b)localObject4).aDA == 0)
                        {
                          if (((d.b)localObject4).aDy == -1)
                          {
                            i = ((d.b)localObject4).width;
                            ((d.b)localObject4).aDy = i;
                            if (((d.b)localObject4).aDz != -1) {
                              break label3340;
                            }
                            i = ((d.b)localObject4).height;
                            ((d.b)localObject4).aDz = i;
                          }
                        }
                        else
                        {
                          float f2 = -1.0F;
                          f1 = f2;
                          if (((d.b)localObject4).aDy != -1)
                          {
                            f1 = f2;
                            if (((d.b)localObject4).aDz != -1) {
                              f1 = ((d.b)localObject4).height * ((d.b)localObject4).aDy / (((d.b)localObject4).width * ((d.b)localObject4).aDz);
                            }
                          }
                          localObject3 = null;
                          if (((d.b)localObject4).aDB)
                          {
                            if ((((d.b)localObject4).aDH != -1.0F) && (((d.b)localObject4).aDI != -1.0F) && (((d.b)localObject4).aDJ != -1.0F) && (((d.b)localObject4).aDK != -1.0F) && (((d.b)localObject4).aDL != -1.0F) && (((d.b)localObject4).aDM != -1.0F) && (((d.b)localObject4).aDN != -1.0F) && (((d.b)localObject4).aDO != -1.0F) && (((d.b)localObject4).aDP != -1.0F) && (((d.b)localObject4).aDQ != -1.0F)) {
                              break label3350;
                            }
                            localObject3 = null;
                          }
                        }
                        for (;;)
                        {
                          localObject3 = new ColorInfo(((d.b)localObject4).aDC, ((d.b)localObject4).aDE, ((d.b)localObject4).aDD, (byte[])localObject3);
                          localObject1 = Format.a(Integer.toString(m), (String)localObject1, paramInt, ((d.b)localObject4).width, ((d.b)localObject4).height, (List)localObject2, -1, f1, ((d.b)localObject4).awS, ((d.b)localObject4).awR, (ColorInfo)localObject3, ((d.b)localObject4).awN);
                          break;
                          i = ((d.b)localObject4).aDy;
                          break label3041;
                          i = ((d.b)localObject4).aDz;
                          break label3064;
                          localObject3 = new byte[25];
                          ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject3);
                          localByteBuffer.put((byte)0);
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDH * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDI * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDJ * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDK * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDL * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDM * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDN * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDO * 50000.0F + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDP + 0.5F));
                          localByteBuffer.putShort((short)(int)(((d.b)localObject4).aDQ + 0.5F));
                          localByteBuffer.putShort((short)((d.b)localObject4).aDF);
                          localByteBuffer.putShort((short)((d.b)localObject4).aDG);
                        }
                      }
                      label3340:
                      label3350:
                      if ("application/x-subrip".equals(localObject1))
                      {
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).axa, ((d.b)localObject4).awN);
                      }
                      else if ("text/x-ssa".equals(localObject1))
                      {
                        localObject2 = new ArrayList(2);
                        ((List)localObject2).add(d.aCt);
                        ((List)localObject2).add(((d.b)localObject4).aDx);
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, j, ((d.b)localObject4).axa, -1, ((d.b)localObject4).awN, 9223372036854775807L, (List)localObject2);
                      }
                      else
                      {
                        if ((!"application/vobsub".equals(localObject1)) && (!"application/pgs".equals(localObject1)) && (!"application/dvbsubs".equals(localObject1))) {
                          break label3775;
                        }
                        localObject1 = Format.a(Integer.toString(m), (String)localObject1, (List)localObject2, ((d.b)localObject4).axa, ((d.b)localObject4).awN);
                      }
                    }
                    label3775:
                    localObject1 = new o("Unexpected MIME type.");
                    AppMethodBeat.o(94892);
                    throw ((Throwable)localObject1);
                    if (locald.aCz.size() == 0)
                    {
                      localObject1 = new o("No valid tracks were found");
                      AppMethodBeat.o(94892);
                      throw ((Throwable)localObject1);
                    }
                    locald.aBV.nZ();
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public final void e(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(94891);
      Object localObject = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94891);
        return;
        if ((((d)localObject).aCJ != -1L) && (((d)localObject).aCJ != paramLong1))
        {
          localObject = new o("Multiple Segment elements not supported");
          AppMethodBeat.o(94891);
          throw ((Throwable)localObject);
        }
        ((d)localObject).aCJ = paramLong1;
        ((d)localObject).aCI = paramLong2;
        AppMethodBeat.o(94891);
        return;
        ((d)localObject).aCO = -1;
        ((d)localObject).aCP = -1L;
        AppMethodBeat.o(94891);
        return;
        ((d)localObject).aCU = new com.google.android.exoplayer2.i.h();
        ((d)localObject).aCV = new com.google.android.exoplayer2.i.h();
        AppMethodBeat.o(94891);
        return;
        ((d)localObject).aCW = false;
        AppMethodBeat.o(94891);
        return;
        if (!((d)localObject).aCN)
        {
          if ((((d)localObject).aCA) && (((d)localObject).aCR != -1L))
          {
            ((d)localObject).aCQ = true;
            AppMethodBeat.o(94891);
            return;
          }
          ((d)localObject).aBV.a(new l.a(((d)localObject).axh));
          ((d)localObject).aCN = true;
          AppMethodBeat.o(94891);
          return;
          ((d)localObject).aDq = false;
          AppMethodBeat.o(94891);
          return;
          AppMethodBeat.o(94891);
          return;
          ((d)localObject).aCM.aDu = true;
          AppMethodBeat.o(94891);
          return;
          ((d)localObject).aCM = new d.b((byte)0);
          AppMethodBeat.o(94891);
          return;
          ((d)localObject).aCM.aDB = true;
        }
      }
    }
    
    public final void i(int paramInt, long paramLong)
    {
      boolean bool2 = true;
      boolean bool1 = true;
      AppMethodBeat.i(94893);
      Object localObject = d.this;
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(94893);
        return;
        if (paramLong != 1L)
        {
          localObject = new o("EBMLReadVersion " + paramLong + " not supported");
          AppMethodBeat.o(94893);
          throw ((Throwable)localObject);
          if ((paramLong < 1L) || (paramLong > 2L))
          {
            localObject = new o("DocTypeReadVersion " + paramLong + " not supported");
            AppMethodBeat.o(94893);
            throw ((Throwable)localObject);
            ((d)localObject).aCP = (((d)localObject).aCJ + paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCK = paramLong;
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.width = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.height = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDy = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDz = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDA = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.number = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            localObject = ((d)localObject).aCM;
            if (paramLong == 1L) {}
            for (;;)
            {
              ((d.b)localObject).aDU = bool1;
              AppMethodBeat.o(94893);
              return;
              bool1 = false;
            }
            localObject = ((d)localObject).aCM;
            if (paramLong == 1L) {}
            for (bool1 = bool2;; bool1 = false)
            {
              ((d.b)localObject).aDV = bool1;
              AppMethodBeat.o(94893);
              return;
            }
            ((d)localObject).aCM.type = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDt = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDS = paramLong;
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDT = paramLong;
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.awU = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aCM.aDR = ((int)paramLong);
            AppMethodBeat.o(94893);
            return;
            ((d)localObject).aDq = true;
            AppMethodBeat.o(94893);
            return;
            if (paramLong != 0L)
            {
              localObject = new o("ContentEncodingOrder " + paramLong + " not supported");
              AppMethodBeat.o(94893);
              throw ((Throwable)localObject);
              if (paramLong != 1L)
              {
                localObject = new o("ContentEncodingScope " + paramLong + " not supported");
                AppMethodBeat.o(94893);
                throw ((Throwable)localObject);
                if (paramLong != 3L)
                {
                  localObject = new o("ContentCompAlgo " + paramLong + " not supported");
                  AppMethodBeat.o(94893);
                  throw ((Throwable)localObject);
                  if (paramLong != 5L)
                  {
                    localObject = new o("ContentEncAlgo " + paramLong + " not supported");
                    AppMethodBeat.o(94893);
                    throw ((Throwable)localObject);
                    if (paramLong != 1L)
                    {
                      localObject = new o("AESSettingsCipherMode " + paramLong + " not supported");
                      AppMethodBeat.o(94893);
                      throw ((Throwable)localObject);
                      ((d)localObject).aCU.add(((d)localObject).F(paramLong));
                      AppMethodBeat.o(94893);
                      return;
                      if (!((d)localObject).aCW)
                      {
                        ((d)localObject).aCV.add(paramLong);
                        ((d)localObject).aCW = true;
                        AppMethodBeat.o(94893);
                        return;
                        ((d)localObject).aCT = ((d)localObject).F(paramLong);
                        AppMethodBeat.o(94893);
                        return;
                        ((d)localObject).aCZ = ((d)localObject).F(paramLong);
                        AppMethodBeat.o(94893);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(94893);
                          return;
                        case 0: 
                          ((d)localObject).aCM.awR = 0;
                          AppMethodBeat.o(94893);
                          return;
                        case 1: 
                          ((d)localObject).aCM.awR = 2;
                          AppMethodBeat.o(94893);
                          return;
                        case 3: 
                          ((d)localObject).aCM.awR = 1;
                          AppMethodBeat.o(94893);
                          return;
                        }
                        ((d)localObject).aCM.awR = 3;
                        AppMethodBeat.o(94893);
                        return;
                        ((d)localObject).aCM.aDB = true;
                        switch ((int)paramLong)
                        {
                        case 2: 
                        case 3: 
                        case 8: 
                        default: 
                          AppMethodBeat.o(94893);
                          return;
                        case 1: 
                          ((d)localObject).aCM.aDC = 1;
                          AppMethodBeat.o(94893);
                          return;
                        case 4: 
                        case 5: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aCM.aDC = 2;
                          AppMethodBeat.o(94893);
                          return;
                        }
                        ((d)localObject).aCM.aDC = 6;
                        AppMethodBeat.o(94893);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(94893);
                          return;
                        case 1: 
                        case 6: 
                        case 7: 
                          ((d)localObject).aCM.aDD = 3;
                          AppMethodBeat.o(94893);
                          return;
                        case 16: 
                          ((d)localObject).aCM.aDD = 6;
                          AppMethodBeat.o(94893);
                          return;
                        }
                        ((d)localObject).aCM.aDD = 7;
                        AppMethodBeat.o(94893);
                        return;
                        switch ((int)paramLong)
                        {
                        default: 
                          AppMethodBeat.o(94893);
                          return;
                        case 1: 
                          ((d)localObject).aCM.aDE = 2;
                          AppMethodBeat.o(94893);
                          return;
                        }
                        ((d)localObject).aCM.aDE = 1;
                        AppMethodBeat.o(94893);
                        return;
                        ((d)localObject).aCM.aDF = ((int)paramLong);
                        AppMethodBeat.o(94893);
                        return;
                        ((d)localObject).aCM.aDG = ((int)paramLong);
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
    public com.google.android.exoplayer2.c.m aCe;
    public int aCh;
    public int aDA = 0;
    public boolean aDB = false;
    public int aDC = -1;
    public int aDD = -1;
    public int aDE = -1;
    public int aDF = 1000;
    public int aDG = 200;
    public float aDH = -1.0F;
    public float aDI = -1.0F;
    public float aDJ = -1.0F;
    public float aDK = -1.0F;
    public float aDL = -1.0F;
    public float aDM = -1.0F;
    public float aDN = -1.0F;
    public float aDO = -1.0F;
    public float aDP = -1.0F;
    public float aDQ = -1.0F;
    public int aDR = -1;
    public long aDS = 0L;
    public long aDT = 0L;
    public boolean aDU;
    public boolean aDV = true;
    public String aDs;
    public int aDt;
    public boolean aDu;
    public byte[] aDv;
    public m.a aDw;
    public byte[] aDx;
    public int aDy = -1;
    public int aDz = -1;
    public DrmInitData awN;
    public int awR = -1;
    public byte[] awS = null;
    public int awU = 1;
    String axa = "eng";
    public int height = -1;
    public int number;
    public int sampleRate = 8000;
    public int type;
    public int width = -1;
    
    static List<byte[]> i(com.google.android.exoplayer2.i.m paramm)
    {
      AppMethodBeat.i(94896);
      try
      {
        paramm.en(16);
        long l = paramm.qP();
        if (l != 826496599L)
        {
          AppMethodBeat.o(94896);
          return null;
        }
        int i = paramm.position + 20;
        paramm = paramm.data;
        while (i < paramm.length - 4)
        {
          if ((paramm[i] == 0) && (paramm[(i + 1)] == 0) && (paramm[(i + 2)] == 1) && (paramm[(i + 3)] == 15))
          {
            paramm = Collections.singletonList(Arrays.copyOfRange(paramm, i, paramm.length));
            AppMethodBeat.o(94896);
            return paramm;
          }
          i += 1;
        }
        paramm = new o("Failed to find FourCC VC1 initialization data");
        AppMethodBeat.o(94896);
        throw paramm;
      }
      catch (ArrayIndexOutOfBoundsException paramm)
      {
        paramm = new o("Error parsing FourCC VC1 codec private");
        AppMethodBeat.o(94896);
        throw paramm;
      }
    }
    
    static boolean j(com.google.android.exoplayer2.i.m paramm)
    {
      AppMethodBeat.i(94898);
      try
      {
        int i = paramm.qN();
        if (i == 1)
        {
          AppMethodBeat.o(94898);
          return true;
        }
        if (i != 65534) {
          break label94;
        }
        paramm.setPosition(24);
        if ((paramm.readLong() == d.oc().getMostSignificantBits()) && (paramm.readLong() == d.oc().getLeastSignificantBits()))
        {
          AppMethodBeat.o(94898);
          return true;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramm)
      {
        paramm = new o("Error parsing MS/ACM codec private");
        AppMethodBeat.o(94898);
        throw paramm;
      }
      AppMethodBeat.o(94898);
      return false;
      label94:
      AppMethodBeat.o(94898);
      return false;
    }
    
    static List<byte[]> l(byte[] paramArrayOfByte)
    {
      int k = 0;
      AppMethodBeat.i(94897);
      if (paramArrayOfByte[0] != 2) {
        try
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(94897);
          throw paramArrayOfByte;
        }
        catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(94897);
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
          AppMethodBeat.o(94897);
          throw paramArrayOfByte;
        }
        byte[] arrayOfByte1 = new byte[n];
        System.arraycopy(paramArrayOfByte, k, arrayOfByte1, 0, n);
        k = n + k;
        if (paramArrayOfByte[k] != 3)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(94897);
          throw paramArrayOfByte;
        }
        i = i + j + k;
        if (paramArrayOfByte[i] != 5)
        {
          paramArrayOfByte = new o("Error parsing vorbis codec private");
          AppMethodBeat.o(94897);
          throw paramArrayOfByte;
        }
        byte[] arrayOfByte2 = new byte[paramArrayOfByte.length - i];
        System.arraycopy(paramArrayOfByte, i, arrayOfByte2, 0, paramArrayOfByte.length - i);
        paramArrayOfByte = new ArrayList(2);
        paramArrayOfByte.add(arrayOfByte1);
        paramArrayOfByte.add(arrayOfByte2);
        AppMethodBeat.o(94897);
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