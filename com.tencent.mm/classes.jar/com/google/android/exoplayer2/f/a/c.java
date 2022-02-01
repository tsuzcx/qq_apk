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
  private b bkA;
  private int bkB;
  private final m bkc;
  private List<com.google.android.exoplayer2.f.a> bkh;
  private List<com.google.android.exoplayer2.f.a> bki;
  private final l bkw;
  private final int bkx;
  private final a[] bky;
  private a bkz;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.bkc = new m();
    this.bkw = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.bkx = i;
    this.bky = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.bky[paramInt] = new a();
      paramInt += 1;
    }
    this.bkz = this.bky[0];
    uh();
    AppMethodBeat.o(92763);
  }
  
  private void eZ(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.bkw.eB(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.bkh = ug();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.bkz.uk();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      uh();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.bkz.g('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.bkw.eB(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void fa(int paramInt)
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
      } while (this.bkB == paramInt);
      this.bkB = paramInt;
      this.bkz = this.bky[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bkw.sD()) {
          this.bky[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bkw.sD()) {
          this.bky[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.bkw.sD()) {
          this.bky[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.bkw.sD())
        {
          locala = this.bky[(8 - paramInt)];
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
        if (this.bkw.sD()) {
          this.bky[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.bkw.eB(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      uh();
      AppMethodBeat.o(92770);
      return;
      if (!this.bkz.bkN)
      {
        this.bkw.eB(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bkw.eA(4);
      this.bkw.eA(2);
      this.bkw.eA(2);
      boolean bool1 = this.bkw.sD();
      boolean bool2 = this.bkw.sD();
      this.bkw.eA(3);
      this.bkw.eA(3);
      this.bkz.g(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.bkz.bkN)
      {
        this.bkw.eB(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bkw.eA(2);
      paramInt = a.k(this.bkw.eA(2), this.bkw.eA(2), this.bkw.eA(2), paramInt);
      int i = this.bkw.eA(2);
      i = a.k(this.bkw.eA(2), this.bkw.eA(2), this.bkw.eA(2), i);
      this.bkw.eB(2);
      a.n(this.bkw.eA(2), this.bkw.eA(2), this.bkw.eA(2));
      this.bkz.bm(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.bkz.bkN)
      {
        this.bkw.eB(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.bkw.eB(4);
      paramInt = this.bkw.eA(4);
      this.bkw.eB(2);
      this.bkw.eA(6);
      a locala = this.bkz;
      if (locala.row != paramInt) {
        locala.g('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.bkz.bkN)
      {
        this.bkw.eB(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.bkw.eA(2);
      paramInt = a.k(this.bkw.eA(2), this.bkw.eA(2), this.bkw.eA(2), paramInt);
      this.bkw.eA(2);
      a.n(this.bkw.eA(2), this.bkw.eA(2), this.bkw.eA(2));
      this.bkw.sD();
      this.bkw.sD();
      this.bkw.eA(2);
      this.bkw.eA(2);
      i = this.bkw.eA(2);
      this.bkw.eB(8);
      this.bkz.bl(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.bky[paramInt];
      this.bkw.eB(2);
      bool1 = this.bkw.sD();
      bool2 = this.bkw.sD();
      this.bkw.sD();
      int j = this.bkw.eA(3);
      boolean bool3 = this.bkw.sD();
      int k = this.bkw.eA(7);
      int m = this.bkw.eA(8);
      int n = this.bkw.eA(4);
      int i1 = this.bkw.eA(4);
      this.bkw.eB(2);
      this.bkw.eA(6);
      this.bkw.eB(2);
      int i2 = this.bkw.eA(3);
      i = this.bkw.eA(3);
      locala.bkN = true;
      locala.visible = bool1;
      locala.bkS = bool2;
      locala.priority = j;
      locala.bkO = bool3;
      locala.bkP = k;
      locala.bkQ = m;
      locala.bkR = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.bkq.size() >= locala.rowCount)) || (locala.bkq.size() >= 15)) {
          locala.bkq.remove(0);
        }
      }
      if ((i2 != 0) && (locala.bkT != i2))
      {
        locala.bkT = i2;
        j = i2 - 1;
        locala.bl(a.bkJ[j], a.bkF[j]);
      }
      if ((i != 0) && (locala.bkU != i))
      {
        locala.bkU = i;
        locala.g(false, false);
        locala.bm(a.bkC, a.bkM[(i - 1)]);
      }
    } while (this.bkB == paramInt);
    this.bkB = paramInt;
    this.bkz = this.bky[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void fb(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.bkw.eB(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.bkw.eB(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.bkw.eB(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void fc(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.bkw.eB(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.bkw.eB(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.bkw.eB(2);
      paramInt = this.bkw.eA(6);
      this.bkw.eB(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void fd(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.bkz.g('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.bkz.g((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void fg(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.bkz.g((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void fh(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.bkz.g(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.bkz.g(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.bkz.g('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.bkz.g('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.bkz.g('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.bkz.g('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.bkz.g('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.bkz.g('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.bkz.g('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.bkz.g('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.bkz.g('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.bkz.g('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.bkz.g('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.bkz.g('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.bkz.g('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.bkz.g('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.bkz.g('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.bkz.g('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.bkz.g('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.bkz.g('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.bkz.g('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.bkz.g('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.bkz.g('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.bkz.g('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.bkz.g('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.bkz.g('┌');
    AppMethodBeat.o(92775);
  }
  
  private void fi(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.bkz.g('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.bkz.g('_');
    AppMethodBeat.o(92776);
  }
  
  private List<com.google.android.exoplayer2.f.a> ug()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.bky[i].isEmpty()) && (this.bky[i].visible)) {
        ((List)localObject).add(this.bky[i].uq());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void uh()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.bky[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void uo()
  {
    AppMethodBeat.i(92767);
    if (this.bkA == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    up();
    this.bkA = null;
    AppMethodBeat.o(92767);
  }
  
  private void up()
  {
    AppMethodBeat.i(92768);
    if (this.bkA.currentIndex != this.bkA.bla * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.bkA.bla * 2 - 1).append(", but current index is ").append(this.bkA.currentIndex).append(" (sequence number ").append(this.bkA.bkZ).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.bkw.n(this.bkA.blb, this.bkA.currentIndex);
    int j = this.bkw.eA(3);
    int k = this.bkw.eA(5);
    int i = j;
    if (j == 7)
    {
      this.bkw.eB(2);
      i = j + this.bkw.eA(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.bkx)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.bkw.vc() > 0)
    {
      j = this.bkw.eA(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          eZ(j);
        }
        else if (j <= 127)
        {
          fd(j);
          i = 1;
        }
        else if (j <= 159)
        {
          fa(j);
          i = 1;
        }
        else if (j <= 255)
        {
          fg(j);
          i = 1;
        }
      }
      else
      {
        j = this.bkw.eA(8);
        if (j <= 31)
        {
          fb(j);
        }
        else if (j <= 127)
        {
          fh(j);
          i = 1;
        }
        else if (j <= 159)
        {
          fc(j);
        }
        else if (j <= 255)
        {
          fi(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.bkh = ug();
    }
    AppMethodBeat.o(92768);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.bkc.n(paramh.aQU.array(), paramh.aQU.limit());
    if (this.bkc.vg() >= 3)
    {
      int k = this.bkc.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.bkc.readUnsignedByte();
        j = (byte)this.bkc.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        uo();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.bkA = new b((i & 0xC0) >> 6, k);
        paramh = this.bkA.blb;
        localb = this.bkA;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.bkA.currentIndex != this.bkA.bla * 2 - 1) {
          break label313;
        }
        uo();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.bkA == null) {
          break;
        }
        paramh = this.bkA.blb;
        localb = this.bkA;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.bkA.blb;
        localb = this.bkA;
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
    this.bkh = null;
    this.bki = null;
    this.bkB = 0;
    this.bkz = this.bky[this.bkB];
    uh();
    this.bkA = null;
    AppMethodBeat.o(92764);
  }
  
  protected final boolean ue()
  {
    return this.bkh != this.bki;
  }
  
  protected final com.google.android.exoplayer2.f.d uf()
  {
    AppMethodBeat.i(92765);
    this.bki = this.bkh;
    f localf = new f(this.bkh);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  static final class a
  {
    public static final int bkC;
    public static final int bkD;
    public static final int bkE;
    static final int[] bkF;
    private static final int[] bkG;
    private static final int[] bkH;
    private static final boolean[] bkI;
    static final int[] bkJ;
    private static final int[] bkK;
    private static final int[] bkL;
    static final int[] bkM;
    private int backgroundColor;
    boolean bkN;
    boolean bkO;
    int bkP;
    int bkQ;
    int bkR;
    boolean bkS;
    int bkT;
    int bkU;
    private int bkV;
    private int bkW;
    private int bkX;
    private int bkY;
    final List<SpannableString> bkq;
    private final SpannableStringBuilder bkr;
    private int bkt;
    private int foregroundColor;
    private int justification;
    int priority;
    int row;
    int rowCount;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(92761);
      bkC = k(2, 2, 2, 0);
      bkD = k(0, 0, 0, 0);
      bkE = k(0, 0, 0, 3);
      bkF = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      bkG = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      bkH = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      bkI = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      bkJ = new int[] { bkD, bkE, bkD, bkD, bkE, bkD, bkD };
      bkK = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      bkL = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      bkM = new int[] { bkD, bkD, bkD, bkD, bkD, bkE, bkE };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.bkq = new LinkedList();
      this.bkr = new SpannableStringBuilder();
      reset();
      AppMethodBeat.o(92749);
    }
    
    public static int k(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      AppMethodBeat.i(92760);
      com.google.android.exoplayer2.i.a.bp(paramInt1, 4);
      com.google.android.exoplayer2.i.a.bp(paramInt2, 4);
      com.google.android.exoplayer2.i.a.bp(paramInt3, 4);
      com.google.android.exoplayer2.i.a.bp(paramInt4, 4);
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
    
    public static int n(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92759);
      paramInt1 = k(paramInt1, paramInt2, paramInt3, 0);
      AppMethodBeat.o(92759);
      return paramInt1;
    }
    
    private SpannableString um()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.bkr);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.bkW != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.bkW, i, 33);
        }
        if (this.bkt != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.bkt, i, 33);
        }
        if (this.bkX != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.foregroundColor), this.bkX, i, 33);
        }
        if (this.bkY != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.bkY, i, 33);
        }
      }
      localObject = new SpannableString((CharSequence)localObject);
      AppMethodBeat.o(92757);
      return localObject;
    }
    
    public final void bl(int paramInt1, int paramInt2)
    {
      this.bkV = paramInt1;
      this.justification = paramInt2;
    }
    
    public final void bm(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.bkX != -1) && (this.foregroundColor != paramInt1)) {
        this.bkr.setSpan(new ForegroundColorSpan(this.foregroundColor), this.bkX, this.bkr.length(), 33);
      }
      if (paramInt1 != bkC)
      {
        this.bkX = this.bkr.length();
        this.foregroundColor = paramInt1;
      }
      if ((this.bkY != -1) && (this.backgroundColor != paramInt2)) {
        this.bkr.setSpan(new BackgroundColorSpan(this.backgroundColor), this.bkY, this.bkr.length(), 33);
      }
      if (paramInt2 != bkD)
      {
        this.bkY = this.bkr.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.bkq.clear();
      this.bkr.clear();
      this.bkW = -1;
      this.bkt = -1;
      this.bkX = -1;
      this.bkY = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void g(char paramChar)
    {
      AppMethodBeat.i(92756);
      if (paramChar == '\n')
      {
        this.bkq.add(um());
        this.bkr.clear();
        if (this.bkW != -1) {
          this.bkW = 0;
        }
        if (this.bkt != -1) {
          this.bkt = 0;
        }
        if (this.bkX != -1) {
          this.bkX = 0;
        }
        if (this.bkY != -1) {
          this.bkY = 0;
        }
        while (((this.bkS) && (this.bkq.size() >= this.rowCount)) || (this.bkq.size() >= 15)) {
          this.bkq.remove(0);
        }
      }
      this.bkr.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final void g(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.bkW != -1) {
        if (!paramBoolean1)
        {
          this.bkr.setSpan(new StyleSpan(2), this.bkW, this.bkr.length(), 33);
          this.bkW = -1;
        }
      }
      while (this.bkt != -1)
      {
        if (paramBoolean2) {
          break label133;
        }
        this.bkr.setSpan(new UnderlineSpan(), this.bkt, this.bkr.length(), 33);
        this.bkt = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.bkW = this.bkr.length();
        }
      }
      if (paramBoolean2) {
        this.bkt = this.bkr.length();
      }
      label133:
      AppMethodBeat.o(92753);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.bkN) || ((this.bkq.isEmpty()) && (this.bkr.length() == 0)))
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
      this.bkN = false;
      this.visible = false;
      this.priority = 4;
      this.bkO = false;
      this.bkP = 0;
      this.bkQ = 0;
      this.bkR = 0;
      this.rowCount = 15;
      this.bkS = true;
      this.justification = 0;
      this.bkT = 0;
      this.bkU = 0;
      this.bkV = bkD;
      this.foregroundColor = bkC;
      this.backgroundColor = bkD;
      AppMethodBeat.o(92751);
    }
    
    public final void uk()
    {
      AppMethodBeat.i(92755);
      int i = this.bkr.length();
      if (i > 0) {
        this.bkr.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b uq()
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
      while (i < this.bkq.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.bkq.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(um());
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
        if (this.bkO)
        {
          f2 = this.bkQ / 99.0F;
          f1 = this.bkP / 99.0F;
          if (this.bkR % 3 != 0) {
            break label319;
          }
          i = 0;
          if (this.bkR / 3 != 0) {
            break label339;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.bkV != bkD) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.bkV, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.bkQ / 209.0F;
        f1 = this.bkP / 74.0F;
        break label192;
        label319:
        if (this.bkR % 3 == 1)
        {
          i = 1;
          break label203;
        }
        i = 2;
        break label203;
        label339:
        if (this.bkR / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
  }
  
  static final class b
  {
    public final int bkZ;
    public final int bla;
    public final byte[] blb;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.bkZ = paramInt1;
      this.bla = paramInt2;
      this.blb = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */