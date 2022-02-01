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
  private final a[] bsA;
  private a bsB;
  private b bsC;
  private int bsD;
  private final m bse;
  private List<com.google.android.exoplayer2.f.a> bsj;
  private List<com.google.android.exoplayer2.f.a> bsk;
  private final l bsy;
  private final int bsz;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.bse = new m();
    this.bsy = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.bsz = i;
    this.bsA = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.bsA[paramInt] = new a();
      paramInt += 1;
    }
    this.bsB = this.bsA[0];
    uJ();
    AppMethodBeat.o(92763);
  }
  
  private void eT(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.bsy.ep(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.bsj = uI();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.bsB.uM();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      uJ();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.bsB.append('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.bsy.ep(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void eU(int paramInt)
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
      } while (this.bsD == paramInt);
      this.bsD = paramInt;
      this.bsB = this.bsA[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bsy.sV()) {
          this.bsA[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bsy.sV()) {
          this.bsA[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bsy.sV()) {
          this.bsA[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.bsy.sV())
        {
          locala = this.bsA[(8 - paramInt)];
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
        if (this.bsy.sV()) {
          this.bsA[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.bsy.ep(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      uJ();
      AppMethodBeat.o(92770);
      return;
      if (!this.bsB.bsP)
      {
        this.bsy.ep(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bsy.eo(4);
      this.bsy.eo(2);
      this.bsy.eo(2);
      boolean bool1 = this.bsy.sV();
      boolean bool2 = this.bsy.sV();
      this.bsy.eo(3);
      this.bsy.eo(3);
      this.bsB.h(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.bsB.bsP)
      {
        this.bsy.ep(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bsy.eo(2);
      paramInt = a.m(this.bsy.eo(2), this.bsy.eo(2), this.bsy.eo(2), paramInt);
      int i = this.bsy.eo(2);
      i = a.m(this.bsy.eo(2), this.bsy.eo(2), this.bsy.eo(2), i);
      this.bsy.ep(2);
      a.t(this.bsy.eo(2), this.bsy.eo(2), this.bsy.eo(2));
      this.bsB.bl(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.bsB.bsP)
      {
        this.bsy.ep(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bsy.ep(4);
      paramInt = this.bsy.eo(4);
      this.bsy.ep(2);
      this.bsy.eo(6);
      a locala = this.bsB;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.bsB.bsP)
      {
        this.bsy.ep(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bsy.eo(2);
      paramInt = a.m(this.bsy.eo(2), this.bsy.eo(2), this.bsy.eo(2), paramInt);
      this.bsy.eo(2);
      a.t(this.bsy.eo(2), this.bsy.eo(2), this.bsy.eo(2));
      this.bsy.sV();
      this.bsy.sV();
      this.bsy.eo(2);
      this.bsy.eo(2);
      i = this.bsy.eo(2);
      this.bsy.ep(8);
      this.bsB.bk(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.bsA[paramInt];
      this.bsy.ep(2);
      bool1 = this.bsy.sV();
      bool2 = this.bsy.sV();
      this.bsy.sV();
      int j = this.bsy.eo(3);
      boolean bool3 = this.bsy.sV();
      int k = this.bsy.eo(7);
      int m = this.bsy.eo(8);
      int n = this.bsy.eo(4);
      int i1 = this.bsy.eo(4);
      this.bsy.ep(2);
      this.bsy.eo(6);
      this.bsy.ep(2);
      int i2 = this.bsy.eo(3);
      i = this.bsy.eo(3);
      locala.bsP = true;
      locala.visible = bool1;
      locala.bsU = bool2;
      locala.priority = j;
      locala.bsQ = bool3;
      locala.bsR = k;
      locala.bsS = m;
      locala.bsT = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.bss.size() >= locala.rowCount)) || (locala.bss.size() >= 15)) {
          locala.bss.remove(0);
        }
      }
      if ((i2 != 0) && (locala.bsW != i2))
      {
        locala.bsW = i2;
        j = i2 - 1;
        locala.bk(a.bsL[j], a.bsH[j]);
      }
      if ((i != 0) && (locala.bsX != i))
      {
        locala.bsX = i;
        locala.h(false, false);
        locala.bl(a.bsE, a.bsO[(i - 1)]);
      }
    } while (this.bsD == paramInt);
    this.bsD = paramInt;
    this.bsB = this.bsA[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void eV(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.bsy.ep(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.bsy.ep(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.bsy.ep(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void eW(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.bsy.ep(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.bsy.ep(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.bsy.ep(2);
      paramInt = this.bsy.eo(6);
      this.bsy.ep(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void eX(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.bsB.append('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.bsB.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void eY(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.bsB.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void eZ(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.bsB.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.bsB.append(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.bsB.append('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.bsB.append('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.bsB.append('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.bsB.append('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.bsB.append('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.bsB.append('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.bsB.append('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.bsB.append('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.bsB.append('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.bsB.append('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.bsB.append('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.bsB.append('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.bsB.append('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.bsB.append('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.bsB.append('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.bsB.append('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.bsB.append('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.bsB.append('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.bsB.append('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.bsB.append('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.bsB.append('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.bsB.append('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.bsB.append('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.bsB.append('┌');
    AppMethodBeat.o(92775);
  }
  
  private void fa(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.bsB.append('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.bsB.append('_');
    AppMethodBeat.o(92776);
  }
  
  private List<com.google.android.exoplayer2.f.a> uI()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.bsA[i].isEmpty()) && (this.bsA[i].visible)) {
        ((List)localObject).add(this.bsA[i].uS());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void uJ()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.bsA[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void uQ()
  {
    AppMethodBeat.i(92767);
    if (this.bsC == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    uR();
    this.bsC = null;
    AppMethodBeat.o(92767);
  }
  
  private void uR()
  {
    AppMethodBeat.i(92768);
    if (this.bsC.currentIndex != this.bsC.btd * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.bsC.btd * 2 - 1).append(", but current index is ").append(this.bsC.currentIndex).append(" (sequence number ").append(this.bsC.btc).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.bsy.q(this.bsC.bte, this.bsC.currentIndex);
    int j = this.bsy.eo(3);
    int k = this.bsy.eo(5);
    int i = j;
    if (j == 7)
    {
      this.bsy.ep(2);
      i = j + this.bsy.eo(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.bsz)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.bsy.vF() > 0)
    {
      j = this.bsy.eo(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          eT(j);
        }
        else if (j <= 127)
        {
          eX(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eU(j);
          i = 1;
        }
        else if (j <= 255)
        {
          eY(j);
          i = 1;
        }
      }
      else
      {
        j = this.bsy.eo(8);
        if (j <= 31)
        {
          eV(j);
        }
        else if (j <= 127)
        {
          eZ(j);
          i = 1;
        }
        else if (j <= 159)
        {
          eW(j);
        }
        else if (j <= 255)
        {
          fa(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.bsj = uI();
    }
    AppMethodBeat.o(92768);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.bse.q(paramh.aIq.array(), paramh.aIq.limit());
    if (this.bse.vJ() >= 3)
    {
      int k = this.bse.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.bse.readUnsignedByte();
        j = (byte)this.bse.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        uQ();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.bsC = new b((i & 0xC0) >> 6, k);
        paramh = this.bsC.bte;
        localb = this.bsC;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.bsC.currentIndex != this.bsC.btd * 2 - 1) {
          break label313;
        }
        uQ();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.bsC == null) {
          break;
        }
        paramh = this.bsC.bte;
        localb = this.bsC;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.bsC.bte;
        localb = this.bsC;
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
    this.bsj = null;
    this.bsk = null;
    this.bsD = 0;
    this.bsB = this.bsA[this.bsD];
    uJ();
    this.bsC = null;
    AppMethodBeat.o(92764);
  }
  
  protected final boolean uG()
  {
    return this.bsj != this.bsk;
  }
  
  protected final com.google.android.exoplayer2.f.d uH()
  {
    AppMethodBeat.i(92765);
    this.bsk = this.bsj;
    f localf = new f(this.bsj);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  static final class a
  {
    public static final int bsE;
    public static final int bsF;
    public static final int bsG;
    static final int[] bsH;
    private static final int[] bsI;
    private static final int[] bsJ;
    private static final boolean[] bsK;
    static final int[] bsL;
    private static final int[] bsM;
    private static final int[] bsN;
    static final int[] bsO;
    private int backgroundColor;
    boolean bsP;
    boolean bsQ;
    int bsR;
    int bsS;
    int bsT;
    boolean bsU;
    private int bsV;
    int bsW;
    int bsX;
    private int bsY;
    private int bsZ;
    final List<SpannableString> bss;
    private final SpannableStringBuilder bst;
    private int bsv;
    private int bta;
    private int btb;
    private int foregroundColor;
    int priority;
    int row;
    int rowCount;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(92761);
      bsE = m(2, 2, 2, 0);
      bsF = m(0, 0, 0, 0);
      bsG = m(0, 0, 0, 3);
      bsH = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      bsI = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      bsJ = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      bsK = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      bsL = new int[] { bsF, bsG, bsF, bsF, bsG, bsF, bsF };
      bsM = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      bsN = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      bsO = new int[] { bsF, bsF, bsF, bsF, bsF, bsG, bsG };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.bss = new LinkedList();
      this.bst = new SpannableStringBuilder();
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
    
    private SpannableString uO()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.bst);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.bsZ != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.bsZ, i, 33);
        }
        if (this.bsv != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.bsv, i, 33);
        }
        if (this.bta != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.bta, i, 33);
        }
        if (this.btb != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.btb, i, 33);
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
        this.bss.add(uO());
        this.bst.clear();
        if (this.bsZ != -1) {
          this.bsZ = 0;
        }
        if (this.bsv != -1) {
          this.bsv = 0;
        }
        if (this.bta != -1) {
          this.bta = 0;
        }
        if (this.btb != -1) {
          this.btb = 0;
        }
        while (((this.bsU) && (this.bss.size() >= this.rowCount)) || (this.bss.size() >= 15)) {
          this.bss.remove(0);
        }
      }
      this.bst.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final void bk(int paramInt1, int paramInt2)
    {
      this.bsY = paramInt1;
      this.bsV = paramInt2;
    }
    
    public final void bl(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.bta != -1) && (this.foregroundColor != paramInt1)) {
        this.bst.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bta, this.bst.length(), 33);
      }
      if (paramInt1 != bsE)
      {
        this.bta = this.bst.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.btb != -1) && (this.backgroundColor != paramInt2)) {
        this.bst.setSpan(new BackgroundColorSpan(this.backgroundColor), this.btb, this.bst.length(), 33);
      }
      if (paramInt2 != bsF)
      {
        this.btb = this.bst.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.bss.clear();
      this.bst.clear();
      this.bsZ = -1;
      this.bsv = -1;
      this.bta = -1;
      this.btb = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void h(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.bsZ != -1) {
        if (!paramBoolean1)
        {
          this.bst.setSpan(new StyleSpan(2), this.bsZ, this.bst.length(), 33);
          this.bsZ = -1;
        }
      }
      while (this.bsv != -1)
      {
        if (paramBoolean2) {
          break label133;
        }
        this.bst.setSpan(new UnderlineSpan(), this.bsv, this.bst.length(), 33);
        this.bsv = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.bsZ = this.bst.length();
        }
      }
      if (paramBoolean2) {
        this.bsv = this.bst.length();
      }
      label133:
      AppMethodBeat.o(92753);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.bsP) || ((this.bss.isEmpty()) && (this.bst.length() == 0)))
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
      this.bsP = false;
      this.visible = false;
      this.priority = 4;
      this.bsQ = false;
      this.bsR = 0;
      this.bsS = 0;
      this.bsT = 0;
      this.rowCount = 15;
      this.bsU = true;
      this.bsV = 0;
      this.bsW = 0;
      this.bsX = 0;
      this.bsY = bsF;
      this.foregroundColor = bsE;
      this.backgroundColor = bsF;
      AppMethodBeat.o(92751);
    }
    
    public final void uM()
    {
      AppMethodBeat.i(92755);
      int i = this.bst.length();
      if (i > 0) {
        this.bst.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b uS()
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
      while (i < this.bss.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.bss.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(uO());
      Object localObject;
      float f2;
      float f1;
      label192:
      label203:
      int j;
      switch (this.bsV)
      {
      default: 
        localObject = new IllegalArgumentException("Unexpected justification value: " + this.bsV);
        AppMethodBeat.o(92758);
        throw ((Throwable)localObject);
      case 0: 
      case 3: 
        localObject = Layout.Alignment.ALIGN_NORMAL;
        if (this.bsQ)
        {
          f2 = this.bsS / 99.0F;
          f1 = this.bsR / 99.0F;
          if (this.bsT % 3 != 0) {
            break label319;
          }
          i = 0;
          if (this.bsT / 3 != 0) {
            break label339;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.bsY != bsF) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.bsY, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.bsS / 209.0F;
        f1 = this.bsR / 74.0F;
        break label192;
        label319:
        if (this.bsT % 3 == 1)
        {
          i = 1;
          break label203;
        }
        i = 2;
        break label203;
        label339:
        if (this.bsT / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
  }
  
  static final class b
  {
    public final int btc;
    public final int btd;
    public final byte[] bte;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.btc = paramInt1;
      this.btd = paramInt2;
      this.bte = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */