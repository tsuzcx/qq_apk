package com.google.android.exoplayer2.f.a;

import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends d
{
  private a bqA;
  private b bqB;
  private int bqC;
  private final m bqd;
  private List<com.google.android.exoplayer2.f.a> bqi;
  private List<com.google.android.exoplayer2.f.a> bqj;
  private final l bqx;
  private final int bqy;
  private final a[] bqz;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.bqd = new m();
    this.bqx = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.bqy = i;
    this.bqz = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.bqz[paramInt] = new a();
      paramInt += 1;
    }
    this.bqA = this.bqz[0];
    uD();
    AppMethodBeat.o(92763);
  }
  
  private void eG(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.bqx.ep(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.bqi = uC();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.bqA.uG();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      uD();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.bqA.append('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.bqx.ep(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void eH(int paramInt)
  {
    AppMethodBeat.i(92770);
    switch (paramInt)
    {
    }
    label374:
    do
    {
      do
      {
        AppMethodBeat.o(92770);
        return;
        paramInt -= 128;
      } while (this.bqC == paramInt);
      this.bqC = paramInt;
      this.bqA = this.bqz[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bqx.te()) {
          this.bqz[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bqx.te()) {
          this.bqz[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bqx.te()) {
          this.bqz[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.bqx.te())
        {
          locala = this.bqz[(8 - paramInt)];
          if (locala.visible) {
            break label374;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          locala.visible = bool1;
          paramInt += 1;
          break;
        }
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bqx.te()) {
          this.bqz[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.bqx.ep(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      uD();
      AppMethodBeat.o(92770);
      return;
      if (!this.bqA.bqO)
      {
        this.bqx.ep(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bqx.eo(4);
      this.bqx.eo(2);
      this.bqx.eo(2);
      boolean bool1 = this.bqx.te();
      boolean bool2 = this.bqx.te();
      this.bqx.eo(3);
      this.bqx.eo(3);
      this.bqA.h(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.bqA.bqO)
      {
        this.bqx.ep(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bqx.eo(2);
      paramInt = a.m(this.bqx.eo(2), this.bqx.eo(2), this.bqx.eo(2), paramInt);
      int i = this.bqx.eo(2);
      i = a.m(this.bqx.eo(2), this.bqx.eo(2), this.bqx.eo(2), i);
      this.bqx.ep(2);
      a.t(this.bqx.eo(2), this.bqx.eo(2), this.bqx.eo(2));
      this.bqA.bj(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.bqA.bqO)
      {
        this.bqx.ep(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bqx.ep(4);
      paramInt = this.bqx.eo(4);
      this.bqx.ep(2);
      this.bqx.eo(6);
      a locala = this.bqA;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.bqA.bqO)
      {
        this.bqx.ep(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bqx.eo(2);
      paramInt = a.m(this.bqx.eo(2), this.bqx.eo(2), this.bqx.eo(2), paramInt);
      this.bqx.eo(2);
      a.t(this.bqx.eo(2), this.bqx.eo(2), this.bqx.eo(2));
      this.bqx.te();
      this.bqx.te();
      this.bqx.eo(2);
      this.bqx.eo(2);
      i = this.bqx.eo(2);
      this.bqx.ep(8);
      this.bqA.bi(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.bqz[paramInt];
      this.bqx.ep(2);
      bool1 = this.bqx.te();
      bool2 = this.bqx.te();
      this.bqx.te();
      int j = this.bqx.eo(3);
      boolean bool3 = this.bqx.te();
      int k = this.bqx.eo(7);
      int m = this.bqx.eo(8);
      int n = this.bqx.eo(4);
      int i1 = this.bqx.eo(4);
      this.bqx.ep(2);
      this.bqx.eo(6);
      this.bqx.ep(2);
      int i2 = this.bqx.eo(3);
      i = this.bqx.eo(3);
      locala.bqO = true;
      locala.visible = bool1;
      locala.bqT = bool2;
      locala.priority = j;
      locala.bqP = bool3;
      locala.bqQ = k;
      locala.bqR = m;
      locala.bqS = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.bqr.size() >= locala.rowCount)) || (locala.bqr.size() >= 15)) {
          locala.bqr.remove(0);
        }
      }
      if ((i2 != 0) && (locala.bqV != i2))
      {
        locala.bqV = i2;
        j = i2 - 1;
        locala.bi(a.bqK[j], a.bqG[j]);
      }
      if ((i != 0) && (locala.bqW != i))
      {
        locala.bqW = i;
        locala.h(false, false);
        locala.bj(a.bqD, a.bqN[(i - 1)]);
      }
    } while (this.bqC == paramInt);
    this.bqC = paramInt;
    this.bqA = this.bqz[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void eI(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.bqx.ep(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.bqx.ep(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.bqx.ep(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void eJ(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.bqx.ep(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.bqx.ep(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.bqx.ep(2);
      paramInt = this.bqx.eo(6);
      this.bqx.ep(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void eK(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.bqA.append('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.bqA.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void eL(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.bqA.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void eM(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.bqA.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.bqA.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.bqA.append('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.bqA.append('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.bqA.append('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.bqA.append('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.bqA.append('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.bqA.append('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.bqA.append('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.bqA.append('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.bqA.append('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.bqA.append('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.bqA.append('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.bqA.append('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.bqA.append('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.bqA.append('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.bqA.append('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.bqA.append('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.bqA.append('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.bqA.append('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.bqA.append('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.bqA.append('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.bqA.append('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.bqA.append('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.bqA.append('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.bqA.append('┌');
    AppMethodBeat.o(92775);
  }
  
  private void eN(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.bqA.append('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.bqA.append('_');
    AppMethodBeat.o(92776);
  }
  
  private List<com.google.android.exoplayer2.f.a> uC()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.bqz[i].isEmpty()) && (this.bqz[i].visible)) {
        ((List)localObject).add(this.bqz[i].uM());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void uD()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.bqz[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void uK()
  {
    AppMethodBeat.i(92767);
    if (this.bqB == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    uL();
    this.bqB = null;
    AppMethodBeat.o(92767);
  }
  
  private void uL()
  {
    AppMethodBeat.i(92768);
    if (this.bqB.currentIndex != this.bqB.brc * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.bqB.brc * 2 - 1).append(", but current index is ").append(this.bqB.currentIndex).append(" (sequence number ").append(this.bqB.brb).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.bqx.n(this.bqB.brd, this.bqB.currentIndex);
    int j = this.bqx.eo(3);
    int k = this.bqx.eo(5);
    int i = j;
    if (j == 7)
    {
      this.bqx.ep(2);
      i = j + this.bqx.eo(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.bqy)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.bqx.vu() > 0)
    {
      j = this.bqx.eo(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          eG(j);
        }
        else if (j <= 127)
        {
          eK(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eH(j);
          i = 1;
        }
        else if (j <= 255)
        {
          eL(j);
          i = 1;
        }
      }
      else
      {
        j = this.bqx.eo(8);
        if (j <= 31)
        {
          eI(j);
        }
        else if (j <= 127)
        {
          eM(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eJ(j);
        }
        else if (j <= 255)
        {
          eN(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.bqi = uC();
    }
    AppMethodBeat.o(92768);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.bqd.n(paramh.aJg.array(), paramh.aJg.limit());
    if (this.bqd.vy() >= 3)
    {
      int k = this.bqd.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.bqd.readUnsignedByte();
        j = (byte)this.bqd.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        uK();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.bqB = new b((i & 0xC0) >> 6, k);
        paramh = this.bqB.brd;
        localb = this.bqB;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.bqB.currentIndex != this.bqB.brc * 2 - 1) {
          break label313;
        }
        uK();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.bqB == null) {
          break;
        }
        paramh = this.bqB.brd;
        localb = this.bqB;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.bqB.brd;
        localb = this.bqB;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        break label187;
        label313:
        break;
      }
    }
    AppMethodBeat.o(92766);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92764);
    super.flush();
    this.bqi = null;
    this.bqj = null;
    this.bqC = 0;
    this.bqA = this.bqz[this.bqC];
    uD();
    this.bqB = null;
    AppMethodBeat.o(92764);
  }
  
  protected final boolean uA()
  {
    return this.bqi != this.bqj;
  }
  
  protected final com.google.android.exoplayer2.f.d uB()
  {
    AppMethodBeat.i(92765);
    this.bqj = this.bqi;
    f localf = new f(this.bqi);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  static final class a
  {
    public static final int bqD;
    public static final int bqE;
    public static final int bqF;
    static final int[] bqG;
    private static final int[] bqH;
    private static final int[] bqI;
    private static final boolean[] bqJ;
    static final int[] bqK;
    private static final int[] bqL;
    private static final int[] bqM;
    static final int[] bqN;
    private int backgroundColor;
    boolean bqO;
    boolean bqP;
    int bqQ;
    int bqR;
    int bqS;
    boolean bqT;
    private int bqU;
    int bqV;
    int bqW;
    private int bqX;
    private int bqY;
    private int bqZ;
    final List<SpannableString> bqr;
    private final SpannableStringBuilder bqs;
    private int bqu;
    private int bra;
    private int foregroundColor;
    int priority;
    int row;
    int rowCount;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(92761);
      bqD = m(2, 2, 2, 0);
      bqE = m(0, 0, 0, 0);
      bqF = m(0, 0, 0, 3);
      bqG = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      bqH = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      bqI = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      bqJ = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      bqK = new int[] { bqE, bqF, bqE, bqE, bqF, bqE, bqE };
      bqL = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      bqM = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      bqN = new int[] { bqE, bqE, bqE, bqE, bqE, bqF, bqF };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.bqr = new LinkedList();
      this.bqs = new SpannableStringBuilder();
      reset();
      AppMethodBeat.o(92749);
    }
    
    public static int m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      AppMethodBeat.i(92760);
      com.google.android.exoplayer2.i.a.bl(paramInt1, 4);
      com.google.android.exoplayer2.i.a.bl(paramInt2, 4);
      com.google.android.exoplayer2.i.a.bl(paramInt3, 4);
      com.google.android.exoplayer2.i.a.bl(paramInt4, 4);
      switch (paramInt4)
      {
      default: 
        paramInt4 = 255;
        if (paramInt1 > 1)
        {
          paramInt1 = 255;
          label77:
          if (paramInt2 <= 1) {
            break label132;
          }
          paramInt2 = 255;
          label86:
          if (paramInt3 <= 1) {
            break label137;
          }
        }
        break;
      }
      label132:
      label137:
      for (paramInt3 = i;; paramInt3 = 0)
      {
        paramInt1 = Color.argb(paramInt4, paramInt1, paramInt2, paramInt3);
        AppMethodBeat.o(92760);
        return paramInt1;
        paramInt4 = 255;
        break;
        paramInt4 = 127;
        break;
        paramInt4 = 0;
        break;
        paramInt1 = 0;
        break label77;
        paramInt2 = 0;
        break label86;
      }
    }
    
    public static int t(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92759);
      paramInt1 = m(paramInt1, paramInt2, paramInt3, 0);
      AppMethodBeat.o(92759);
      return paramInt1;
    }
    
    private SpannableString uI()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.bqs);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.bqY != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.bqY, i, 33);
        }
        if (this.bqu != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.bqu, i, 33);
        }
        if (this.bqZ != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.bqZ, i, 33);
        }
        if (this.bra != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.bra, i, 33);
        }
      }
      localObject = new SpannableString((CharSequence)localObject);
      AppMethodBeat.o(92757);
      return localObject;
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(92756);
      if (paramChar == '\n')
      {
        this.bqr.add(uI());
        this.bqs.clear();
        if (this.bqY != -1) {
          this.bqY = 0;
        }
        if (this.bqu != -1) {
          this.bqu = 0;
        }
        if (this.bqZ != -1) {
          this.bqZ = 0;
        }
        if (this.bra != -1) {
          this.bra = 0;
        }
        while (((this.bqT) && (this.bqr.size() >= this.rowCount)) || (this.bqr.size() >= 15)) {
          this.bqr.remove(0);
        }
      }
      this.bqs.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final void bi(int paramInt1, int paramInt2)
    {
      this.bqX = paramInt1;
      this.bqU = paramInt2;
    }
    
    public final void bj(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.bqZ != -1) && (this.foregroundColor != paramInt1)) {
        this.bqs.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bqZ, this.bqs.length(), 33);
      }
      if (paramInt1 != bqD)
      {
        this.bqZ = this.bqs.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.bra != -1) && (this.backgroundColor != paramInt2)) {
        this.bqs.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bra, this.bqs.length(), 33);
      }
      if (paramInt2 != bqE)
      {
        this.bra = this.bqs.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.bqr.clear();
      this.bqs.clear();
      this.bqY = -1;
      this.bqu = -1;
      this.bqZ = -1;
      this.bra = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void h(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.bqY != -1) {
        if (!paramBoolean1)
        {
          this.bqs.setSpan(new StyleSpan(2), this.bqY, this.bqs.length(), 33);
          this.bqY = -1;
        }
      }
      while (this.bqu != -1)
      {
        if (paramBoolean2) {
          break label133;
        }
        this.bqs.setSpan(new UnderlineSpan(), this.bqu, this.bqs.length(), 33);
        this.bqu = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.bqY = this.bqs.length();
        }
      }
      if (paramBoolean2) {
        this.bqu = this.bqs.length();
      }
      label133:
      AppMethodBeat.o(92753);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.bqO) || ((this.bqr.isEmpty()) && (this.bqs.length() == 0)))
      {
        AppMethodBeat.o(92750);
        return true;
      }
      AppMethodBeat.o(92750);
      return false;
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92751);
      clear();
      this.bqO = false;
      this.visible = false;
      this.priority = 4;
      this.bqP = false;
      this.bqQ = 0;
      this.bqR = 0;
      this.bqS = 0;
      this.rowCount = 15;
      this.bqT = true;
      this.bqU = 0;
      this.bqV = 0;
      this.bqW = 0;
      this.bqX = bqE;
      this.foregroundColor = bqD;
      this.backgroundColor = bqE;
      AppMethodBeat.o(92751);
    }
    
    public final void uG()
    {
      AppMethodBeat.i(92755);
      int i = this.bqs.length();
      if (i > 0) {
        this.bqs.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b uM()
    {
      boolean bool = false;
      AppMethodBeat.i(92758);
      if (isEmpty())
      {
        AppMethodBeat.o(92758);
        return null;
      }
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bqr.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.bqr.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(uI());
      Object localObject;
      float f2;
      float f1;
      label192:
      label203:
      int j;
      switch (this.bqU)
      {
      default: 
        localObject = new IllegalArgumentException("Unexpected justification value: " + this.bqU);
        AppMethodBeat.o(92758);
        throw ((Throwable)localObject);
      case 0: 
      case 3: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        if (this.bqP)
        {
          f2 = this.bqR / 99.0F;
          f1 = this.bqQ / 99.0F;
          if (this.bqS % 3 != 0) {
            break label319;
          }
          i = 0;
          if (this.bqS / 3 != 0) {
            break label339;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.bqX != bqE) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.bqX, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.bqR / 209.0F;
        f1 = this.bqQ / 74.0F;
        break label192;
        label319:
        if (this.bqS % 3 == 1)
        {
          i = 1;
          break label203;
        }
        i = 2;
        break label203;
        label339:
        if (this.bqS / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
  }
  
  static final class b
  {
    public final int brb;
    public final int brc;
    public final byte[] brd;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.brb = paramInt1;
      this.brc = paramInt2;
      this.brd = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */