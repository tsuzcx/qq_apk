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
  private List<com.google.android.exoplayer2.f.a> bAD;
  private List<com.google.android.exoplayer2.f.a> bAE;
  private final l bAS;
  private final int bAT;
  private final a[] bAU;
  private a bAV;
  private b bAW;
  private int bAX;
  private final m bAy;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.bAy = new m();
    this.bAS = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.bAT = i;
    this.bAU = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.bAU[paramInt] = new a();
      paramInt += 1;
    }
    this.bAV = this.bAU[0];
    wc();
    AppMethodBeat.o(92763);
  }
  
  private void eK(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.bAS.et(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.bAD = wb();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.bAV.wf();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      wc();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.bAV.append('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.bAS.et(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void eL(int paramInt)
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
      } while (this.bAX == paramInt);
      this.bAX = paramInt;
      this.bAV = this.bAU[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAS.uD()) {
          this.bAU[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAS.uD()) {
          this.bAU[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAS.uD()) {
          this.bAU[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.bAS.uD())
        {
          locala = this.bAU[(8 - paramInt)];
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
        if (this.bAS.uD()) {
          this.bAU[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.bAS.et(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      wc();
      AppMethodBeat.o(92770);
      return;
      if (!this.bAV.bBj)
      {
        this.bAS.et(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bAS.es(4);
      this.bAS.es(2);
      this.bAS.es(2);
      boolean bool1 = this.bAS.uD();
      boolean bool2 = this.bAS.uD();
      this.bAS.es(3);
      this.bAS.es(3);
      this.bAV.h(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.bAV.bBj)
      {
        this.bAS.et(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bAS.es(2);
      paramInt = a.m(this.bAS.es(2), this.bAS.es(2), this.bAS.es(2), paramInt);
      int i = this.bAS.es(2);
      i = a.m(this.bAS.es(2), this.bAS.es(2), this.bAS.es(2), i);
      this.bAS.et(2);
      a.t(this.bAS.es(2), this.bAS.es(2), this.bAS.es(2));
      this.bAV.bl(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.bAV.bBj)
      {
        this.bAS.et(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bAS.et(4);
      paramInt = this.bAS.es(4);
      this.bAS.et(2);
      this.bAS.es(6);
      a locala = this.bAV;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.bAV.bBj)
      {
        this.bAS.et(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bAS.es(2);
      paramInt = a.m(this.bAS.es(2), this.bAS.es(2), this.bAS.es(2), paramInt);
      this.bAS.es(2);
      a.t(this.bAS.es(2), this.bAS.es(2), this.bAS.es(2));
      this.bAS.uD();
      this.bAS.uD();
      this.bAS.es(2);
      this.bAS.es(2);
      i = this.bAS.es(2);
      this.bAS.et(8);
      this.bAV.bk(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.bAU[paramInt];
      this.bAS.et(2);
      bool1 = this.bAS.uD();
      bool2 = this.bAS.uD();
      this.bAS.uD();
      int j = this.bAS.es(3);
      boolean bool3 = this.bAS.uD();
      int k = this.bAS.es(7);
      int m = this.bAS.es(8);
      int n = this.bAS.es(4);
      int i1 = this.bAS.es(4);
      this.bAS.et(2);
      this.bAS.es(6);
      this.bAS.et(2);
      int i2 = this.bAS.es(3);
      i = this.bAS.es(3);
      locala.bBj = true;
      locala.visible = bool1;
      locala.bBo = bool2;
      locala.priority = j;
      locala.bBk = bool3;
      locala.bBl = k;
      locala.bBm = m;
      locala.bBn = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.bAM.size() >= locala.rowCount)) || (locala.bAM.size() >= 15)) {
          locala.bAM.remove(0);
        }
      }
      if ((i2 != 0) && (locala.bBp != i2))
      {
        locala.bBp = i2;
        j = i2 - 1;
        locala.bk(a.bBf[j], a.bBb[j]);
      }
      if ((i != 0) && (locala.bBq != i))
      {
        locala.bBq = i;
        locala.h(false, false);
        locala.bl(a.bAY, a.bBi[(i - 1)]);
      }
    } while (this.bAX == paramInt);
    this.bAX = paramInt;
    this.bAV = this.bAU[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void eM(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.bAS.et(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.bAS.et(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.bAS.et(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void eN(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.bAS.et(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.bAS.et(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.bAS.et(2);
      paramInt = this.bAS.es(6);
      this.bAS.et(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void eO(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.bAV.append('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.bAV.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void eP(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.bAV.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void eQ(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.bAV.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.bAV.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.bAV.append('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.bAV.append('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.bAV.append('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.bAV.append('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.bAV.append('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.bAV.append('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.bAV.append('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.bAV.append('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.bAV.append('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.bAV.append('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.bAV.append('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.bAV.append('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.bAV.append('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.bAV.append('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.bAV.append('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.bAV.append('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.bAV.append('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.bAV.append('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.bAV.append('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.bAV.append('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.bAV.append('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.bAV.append('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.bAV.append('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.bAV.append('┌');
    AppMethodBeat.o(92775);
  }
  
  private void eR(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.bAV.append('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.bAV.append('_');
    AppMethodBeat.o(92776);
  }
  
  private List<com.google.android.exoplayer2.f.a> wb()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.bAU[i].isEmpty()) && (this.bAU[i].visible)) {
        ((List)localObject).add(this.bAU[i].wl());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void wc()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.bAU[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void wj()
  {
    AppMethodBeat.i(92767);
    if (this.bAW == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    wk();
    this.bAW = null;
    AppMethodBeat.o(92767);
  }
  
  private void wk()
  {
    AppMethodBeat.i(92768);
    if (this.bAW.currentIndex != this.bAW.bBw * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.bAW.bBw * 2 - 1).append(", but current index is ").append(this.bAW.currentIndex).append(" (sequence number ").append(this.bAW.bBv).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.bAS.n(this.bAW.bBx, this.bAW.currentIndex);
    int j = this.bAS.es(3);
    int k = this.bAS.es(5);
    int i = j;
    if (j == 7)
    {
      this.bAS.et(2);
      i = j + this.bAS.es(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.bAT)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.bAS.wR() > 0)
    {
      j = this.bAS.es(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          eK(j);
        }
        else if (j <= 127)
        {
          eO(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eL(j);
          i = 1;
        }
        else if (j <= 255)
        {
          eP(j);
          i = 1;
        }
      }
      else
      {
        j = this.bAS.es(8);
        if (j <= 31)
        {
          eM(j);
        }
        else if (j <= 127)
        {
          eQ(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eN(j);
        }
        else if (j <= 255)
        {
          eR(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.bAD = wb();
    }
    AppMethodBeat.o(92768);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.bAy.n(paramh.aKX.array(), paramh.aKX.limit());
    if (this.bAy.wV() >= 3)
    {
      int k = this.bAy.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.bAy.readUnsignedByte();
        j = (byte)this.bAy.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        wj();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.bAW = new b((i & 0xC0) >> 6, k);
        paramh = this.bAW.bBx;
        localb = this.bAW;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.bAW.currentIndex != this.bAW.bBw * 2 - 1) {
          break label313;
        }
        wj();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.bAW == null) {
          break;
        }
        paramh = this.bAW.bBx;
        localb = this.bAW;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.bAW.bBx;
        localb = this.bAW;
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
    this.bAD = null;
    this.bAE = null;
    this.bAX = 0;
    this.bAV = this.bAU[this.bAX];
    wc();
    this.bAW = null;
    AppMethodBeat.o(92764);
  }
  
  protected final boolean vZ()
  {
    return this.bAD != this.bAE;
  }
  
  protected final com.google.android.exoplayer2.f.d wa()
  {
    AppMethodBeat.i(92765);
    this.bAE = this.bAD;
    f localf = new f(this.bAD);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  static final class a
  {
    public static final int bAY;
    public static final int bAZ;
    public static final int bBa;
    static final int[] bBb;
    private static final int[] bBc;
    private static final int[] bBd;
    private static final boolean[] bBe;
    static final int[] bBf;
    private static final int[] bBg;
    private static final int[] bBh;
    static final int[] bBi;
    final List<SpannableString> bAM;
    private final SpannableStringBuilder bAN;
    private int bAP;
    boolean bBj;
    boolean bBk;
    int bBl;
    int bBm;
    int bBn;
    boolean bBo;
    int bBp;
    int bBq;
    private int bBr;
    private int bBs;
    private int bBt;
    private int bBu;
    private int backgroundColor;
    private int foregroundColor;
    private int justification;
    int priority;
    int row;
    int rowCount;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(92761);
      bAY = m(2, 2, 2, 0);
      bAZ = m(0, 0, 0, 0);
      bBa = m(0, 0, 0, 3);
      bBb = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      bBc = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      bBd = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      bBe = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      bBf = new int[] { bAZ, bBa, bAZ, bAZ, bBa, bAZ, bAZ };
      bBg = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      bBh = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      bBi = new int[] { bAZ, bAZ, bAZ, bAZ, bAZ, bBa, bBa };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.bAM = new LinkedList();
      this.bAN = new SpannableStringBuilder();
      reset();
      AppMethodBeat.o(92749);
    }
    
    public static int m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      AppMethodBeat.i(92760);
      com.google.android.exoplayer2.i.a.bn(paramInt1, 4);
      com.google.android.exoplayer2.i.a.bn(paramInt2, 4);
      com.google.android.exoplayer2.i.a.bn(paramInt3, 4);
      com.google.android.exoplayer2.i.a.bn(paramInt4, 4);
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
    
    private SpannableString wh()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.bAN);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.bBs != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.bBs, i, 33);
        }
        if (this.bAP != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.bAP, i, 33);
        }
        if (this.bBt != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBt, i, 33);
        }
        if (this.bBu != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBu, i, 33);
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
        this.bAM.add(wh());
        this.bAN.clear();
        if (this.bBs != -1) {
          this.bBs = 0;
        }
        if (this.bAP != -1) {
          this.bAP = 0;
        }
        if (this.bBt != -1) {
          this.bBt = 0;
        }
        if (this.bBu != -1) {
          this.bBu = 0;
        }
        while (((this.bBo) && (this.bAM.size() >= this.rowCount)) || (this.bAM.size() >= 15)) {
          this.bAM.remove(0);
        }
      }
      this.bAN.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final void bk(int paramInt1, int paramInt2)
    {
      this.bBr = paramInt1;
      this.justification = paramInt2;
    }
    
    public final void bl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.bBt != -1) && (this.foregroundColor != paramInt1)) {
        this.bAN.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBt, this.bAN.length(), 33);
      }
      if (paramInt1 != bAY)
      {
        this.bBt = this.bAN.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.bBu != -1) && (this.backgroundColor != paramInt2)) {
        this.bAN.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBu, this.bAN.length(), 33);
      }
      if (paramInt2 != bAZ)
      {
        this.bBu = this.bAN.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.bAM.clear();
      this.bAN.clear();
      this.bBs = -1;
      this.bAP = -1;
      this.bBt = -1;
      this.bBu = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void h(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.bBs != -1) {
        if (!paramBoolean1)
        {
          this.bAN.setSpan(new StyleSpan(2), this.bBs, this.bAN.length(), 33);
          this.bBs = -1;
        }
      }
      while (this.bAP != -1)
      {
        if (paramBoolean2) {
          break label133;
        }
        this.bAN.setSpan(new UnderlineSpan(), this.bAP, this.bAN.length(), 33);
        this.bAP = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.bBs = this.bAN.length();
        }
      }
      if (paramBoolean2) {
        this.bAP = this.bAN.length();
      }
      label133:
      AppMethodBeat.o(92753);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.bBj) || ((this.bAM.isEmpty()) && (this.bAN.length() == 0)))
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
      this.bBj = false;
      this.visible = false;
      this.priority = 4;
      this.bBk = false;
      this.bBl = 0;
      this.bBm = 0;
      this.bBn = 0;
      this.rowCount = 15;
      this.bBo = true;
      this.justification = 0;
      this.bBp = 0;
      this.bBq = 0;
      this.bBr = bAZ;
      this.foregroundColor = bAY;
      this.backgroundColor = bAZ;
      AppMethodBeat.o(92751);
    }
    
    public final void wf()
    {
      AppMethodBeat.i(92755);
      int i = this.bAN.length();
      if (i > 0) {
        this.bAN.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b wl()
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
      while (i < this.bAM.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.bAM.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(wh());
      Object localObject;
      float f2;
      float f1;
      label192:
      label203:
      int j;
      switch (this.justification)
      {
      default: 
        localObject = new IllegalArgumentException("Unexpected justification value: " + this.justification);
        AppMethodBeat.o(92758);
        throw ((Throwable)localObject);
      case 0: 
      case 3: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        if (this.bBk)
        {
          f2 = this.bBm / 99.0F;
          f1 = this.bBl / 99.0F;
          if (this.bBn % 3 != 0) {
            break label319;
          }
          i = 0;
          if (this.bBn / 3 != 0) {
            break label339;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.bBr != bAZ) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.bBr, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.bBm / 209.0F;
        f1 = this.bBl / 74.0F;
        break label192;
        label319:
        if (this.bBn % 3 == 1)
        {
          i = 1;
          break label203;
        }
        i = 2;
        break label203;
        label339:
        if (this.bBn / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
  }
  
  static final class b
  {
    public final int bBv;
    public final int bBw;
    public final byte[] bBx;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.bBv = paramInt1;
      this.bBw = paramInt2;
      this.bBx = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */