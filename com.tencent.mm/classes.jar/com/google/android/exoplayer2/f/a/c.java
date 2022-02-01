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
  private final m bAA;
  private List<com.google.android.exoplayer2.f.a> bAF;
  private List<com.google.android.exoplayer2.f.a> bAG;
  private final l bAU;
  private final int bAV;
  private final a[] bAW;
  private a bAX;
  private b bAY;
  private int bAZ;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.bAA = new m();
    this.bAU = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.bAV = i;
    this.bAW = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.bAW[paramInt] = new a();
      paramInt += 1;
    }
    this.bAX = this.bAW[0];
    wh();
    AppMethodBeat.o(92763);
  }
  
  private void eJ(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.bAU.en(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.bAF = wg();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.bAX.wk();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      wh();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.bAX.append('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.bAU.en(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void eK(int paramInt)
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
      } while (this.bAZ == paramInt);
      this.bAZ = paramInt;
      this.bAX = this.bAW[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAU.uI()) {
          this.bAW[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAU.uI()) {
          this.bAW[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bAU.uI()) {
          this.bAW[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.bAU.uI())
        {
          locala = this.bAW[(8 - paramInt)];
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
        if (this.bAU.uI()) {
          this.bAW[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.bAU.en(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      wh();
      AppMethodBeat.o(92770);
      return;
      if (!this.bAX.bBl)
      {
        this.bAU.en(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bAU.em(4);
      this.bAU.em(2);
      this.bAU.em(2);
      boolean bool1 = this.bAU.uI();
      boolean bool2 = this.bAU.uI();
      this.bAU.em(3);
      this.bAU.em(3);
      this.bAX.h(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.bAX.bBl)
      {
        this.bAU.en(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bAU.em(2);
      paramInt = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), paramInt);
      int i = this.bAU.em(2);
      i = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), i);
      this.bAU.en(2);
      a.q(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
      this.bAX.bf(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.bAX.bBl)
      {
        this.bAU.en(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bAU.en(4);
      paramInt = this.bAU.em(4);
      this.bAU.en(2);
      this.bAU.em(6);
      a locala = this.bAX;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.bAX.bBl)
      {
        this.bAU.en(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bAU.em(2);
      paramInt = a.m(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2), paramInt);
      this.bAU.em(2);
      a.q(this.bAU.em(2), this.bAU.em(2), this.bAU.em(2));
      this.bAU.uI();
      this.bAU.uI();
      this.bAU.em(2);
      this.bAU.em(2);
      i = this.bAU.em(2);
      this.bAU.en(8);
      this.bAX.be(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.bAW[paramInt];
      this.bAU.en(2);
      bool1 = this.bAU.uI();
      bool2 = this.bAU.uI();
      this.bAU.uI();
      int j = this.bAU.em(3);
      boolean bool3 = this.bAU.uI();
      int k = this.bAU.em(7);
      int m = this.bAU.em(8);
      int n = this.bAU.em(4);
      int i1 = this.bAU.em(4);
      this.bAU.en(2);
      this.bAU.em(6);
      this.bAU.en(2);
      int i2 = this.bAU.em(3);
      i = this.bAU.em(3);
      locala.bBl = true;
      locala.visible = bool1;
      locala.bBq = bool2;
      locala.priority = j;
      locala.bBm = bool3;
      locala.bBn = k;
      locala.bBo = m;
      locala.bBp = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.bAO.size() >= locala.rowCount)) || (locala.bAO.size() >= 15)) {
          locala.bAO.remove(0);
        }
      }
      if ((i2 != 0) && (locala.bBr != i2))
      {
        locala.bBr = i2;
        j = i2 - 1;
        locala.be(a.bBh[j], a.bBd[j]);
      }
      if ((i != 0) && (locala.bBs != i))
      {
        locala.bBs = i;
        locala.h(false, false);
        locala.bf(a.bBa, a.bBk[(i - 1)]);
      }
    } while (this.bAZ == paramInt);
    this.bAZ = paramInt;
    this.bAX = this.bAW[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void eL(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.bAU.en(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.bAU.en(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.bAU.en(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void eM(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.bAU.en(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.bAU.en(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.bAU.en(2);
      paramInt = this.bAU.em(6);
      this.bAU.en(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void eN(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.bAX.append('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.bAX.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void eO(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.bAX.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void eP(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.bAX.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.bAX.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.bAX.append('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.bAX.append('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.bAX.append('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.bAX.append('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.bAX.append('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.bAX.append('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.bAX.append('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.bAX.append('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.bAX.append('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.bAX.append('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.bAX.append('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.bAX.append('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.bAX.append('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.bAX.append('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.bAX.append('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.bAX.append('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.bAX.append('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.bAX.append('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.bAX.append('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.bAX.append('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.bAX.append('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.bAX.append('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.bAX.append('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.bAX.append('┌');
    AppMethodBeat.o(92775);
  }
  
  private void eQ(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.bAX.append('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.bAX.append('_');
    AppMethodBeat.o(92776);
  }
  
  private List<com.google.android.exoplayer2.f.a> wg()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.bAW[i].isEmpty()) && (this.bAW[i].visible)) {
        ((List)localObject).add(this.bAW[i].wq());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void wh()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.bAW[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void wo()
  {
    AppMethodBeat.i(92767);
    if (this.bAY == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    wp();
    this.bAY = null;
    AppMethodBeat.o(92767);
  }
  
  private void wp()
  {
    AppMethodBeat.i(92768);
    if (this.bAY.currentIndex != this.bAY.bBy * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.bAY.bBy * 2 - 1).append(", but current index is ").append(this.bAY.currentIndex).append(" (sequence number ").append(this.bAY.bBx).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.bAU.n(this.bAY.bBz, this.bAY.currentIndex);
    int j = this.bAU.em(3);
    int k = this.bAU.em(5);
    int i = j;
    if (j == 7)
    {
      this.bAU.en(2);
      i = j + this.bAU.em(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.bAV)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.bAU.wZ() > 0)
    {
      j = this.bAU.em(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          eJ(j);
        }
        else if (j <= 127)
        {
          eN(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eK(j);
          i = 1;
        }
        else if (j <= 255)
        {
          eO(j);
          i = 1;
        }
      }
      else
      {
        j = this.bAU.em(8);
        if (j <= 31)
        {
          eL(j);
        }
        else if (j <= 127)
        {
          eP(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eM(j);
        }
        else if (j <= 255)
        {
          eQ(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.bAF = wg();
    }
    AppMethodBeat.o(92768);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.bAA.n(paramh.aKP.array(), paramh.aKP.limit());
    if (this.bAA.xd() >= 3)
    {
      int k = this.bAA.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.bAA.readUnsignedByte();
        j = (byte)this.bAA.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        wo();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.bAY = new b((i & 0xC0) >> 6, k);
        paramh = this.bAY.bBz;
        localb = this.bAY;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.bAY.currentIndex != this.bAY.bBy * 2 - 1) {
          break label313;
        }
        wo();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.bAY == null) {
          break;
        }
        paramh = this.bAY.bBz;
        localb = this.bAY;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.bAY.bBz;
        localb = this.bAY;
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
    this.bAF = null;
    this.bAG = null;
    this.bAZ = 0;
    this.bAX = this.bAW[this.bAZ];
    wh();
    this.bAY = null;
    AppMethodBeat.o(92764);
  }
  
  protected final boolean we()
  {
    return this.bAF != this.bAG;
  }
  
  protected final com.google.android.exoplayer2.f.d wf()
  {
    AppMethodBeat.i(92765);
    this.bAG = this.bAF;
    f localf = new f(this.bAF);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  static final class a
  {
    public static final int bBa;
    public static final int bBb;
    public static final int bBc;
    static final int[] bBd;
    private static final int[] bBe;
    private static final int[] bBf;
    private static final boolean[] bBg;
    static final int[] bBh;
    private static final int[] bBi;
    private static final int[] bBj;
    static final int[] bBk;
    final List<SpannableString> bAO;
    private final SpannableStringBuilder bAP;
    private int bAR;
    boolean bBl;
    boolean bBm;
    int bBn;
    int bBo;
    int bBp;
    boolean bBq;
    int bBr;
    int bBs;
    private int bBt;
    private int bBu;
    private int bBv;
    private int bBw;
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
      bBa = m(2, 2, 2, 0);
      bBb = m(0, 0, 0, 0);
      bBc = m(0, 0, 0, 3);
      bBd = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      bBe = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      bBf = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      bBg = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      bBh = new int[] { bBb, bBc, bBb, bBb, bBc, bBb, bBb };
      bBi = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      bBj = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      bBk = new int[] { bBb, bBb, bBb, bBb, bBb, bBc, bBc };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.bAO = new LinkedList();
      this.bAP = new SpannableStringBuilder();
      reset();
      AppMethodBeat.o(92749);
    }
    
    public static int m(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      AppMethodBeat.i(92760);
      com.google.android.exoplayer2.i.a.bh(paramInt1, 4);
      com.google.android.exoplayer2.i.a.bh(paramInt2, 4);
      com.google.android.exoplayer2.i.a.bh(paramInt3, 4);
      com.google.android.exoplayer2.i.a.bh(paramInt4, 4);
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
    
    public static int q(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92759);
      paramInt1 = m(paramInt1, paramInt2, paramInt3, 0);
      AppMethodBeat.o(92759);
      return paramInt1;
    }
    
    private SpannableString wm()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.bAP);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.bBu != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.bBu, i, 33);
        }
        if (this.bAR != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.bAR, i, 33);
        }
        if (this.bBv != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBv, i, 33);
        }
        if (this.bBw != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBw, i, 33);
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
        this.bAO.add(wm());
        this.bAP.clear();
        if (this.bBu != -1) {
          this.bBu = 0;
        }
        if (this.bAR != -1) {
          this.bAR = 0;
        }
        if (this.bBv != -1) {
          this.bBv = 0;
        }
        if (this.bBw != -1) {
          this.bBw = 0;
        }
        while (((this.bBq) && (this.bAO.size() >= this.rowCount)) || (this.bAO.size() >= 15)) {
          this.bAO.remove(0);
        }
      }
      this.bAP.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final void be(int paramInt1, int paramInt2)
    {
      this.bBt = paramInt1;
      this.justification = paramInt2;
    }
    
    public final void bf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.bBv != -1) && (this.foregroundColor != paramInt1)) {
        this.bAP.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bBv, this.bAP.length(), 33);
      }
      if (paramInt1 != bBa)
      {
        this.bBv = this.bAP.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.bBw != -1) && (this.backgroundColor != paramInt2)) {
        this.bAP.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bBw, this.bAP.length(), 33);
      }
      if (paramInt2 != bBb)
      {
        this.bBw = this.bAP.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.bAO.clear();
      this.bAP.clear();
      this.bBu = -1;
      this.bAR = -1;
      this.bBv = -1;
      this.bBw = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void h(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.bBu != -1) {
        if (!paramBoolean1)
        {
          this.bAP.setSpan(new StyleSpan(2), this.bBu, this.bAP.length(), 33);
          this.bBu = -1;
        }
      }
      while (this.bAR != -1)
      {
        if (paramBoolean2) {
          break label133;
        }
        this.bAP.setSpan(new UnderlineSpan(), this.bAR, this.bAP.length(), 33);
        this.bAR = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.bBu = this.bAP.length();
        }
      }
      if (paramBoolean2) {
        this.bAR = this.bAP.length();
      }
      label133:
      AppMethodBeat.o(92753);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.bBl) || ((this.bAO.isEmpty()) && (this.bAP.length() == 0)))
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
      this.bBl = false;
      this.visible = false;
      this.priority = 4;
      this.bBm = false;
      this.bBn = 0;
      this.bBo = 0;
      this.bBp = 0;
      this.rowCount = 15;
      this.bBq = true;
      this.justification = 0;
      this.bBr = 0;
      this.bBs = 0;
      this.bBt = bBb;
      this.foregroundColor = bBa;
      this.backgroundColor = bBb;
      AppMethodBeat.o(92751);
    }
    
    public final void wk()
    {
      AppMethodBeat.i(92755);
      int i = this.bAP.length();
      if (i > 0) {
        this.bAP.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b wq()
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
      while (i < this.bAO.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.bAO.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(wm());
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
        if (this.bBm)
        {
          f2 = this.bBo / 99.0F;
          f1 = this.bBn / 99.0F;
          if (this.bBp % 3 != 0) {
            break label319;
          }
          i = 0;
          if (this.bBp / 3 != 0) {
            break label339;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.bBt != bBb) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.bBt, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.bBo / 209.0F;
        f1 = this.bBn / 74.0F;
        break label192;
        label319:
        if (this.bBp % 3 == 1)
        {
          i = 1;
          break label203;
        }
        i = 2;
        break label203;
        label339:
        if (this.bBp / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
  }
  
  static final class b
  {
    public final int bBx;
    public final int bBy;
    public final byte[] bBz;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.bBx = paramInt1;
      this.bBy = paramInt2;
      this.bBz = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */