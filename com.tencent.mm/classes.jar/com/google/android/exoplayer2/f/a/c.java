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
  private final m ddW;
  private List<com.google.android.exoplayer2.f.a> deb;
  private List<com.google.android.exoplayer2.f.a> dec;
  private final l deq;
  private final int der;
  private final a[] det;
  private a deu;
  private b dev;
  private int dew;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(92763);
    this.ddW = new m();
    this.deq = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.der = i;
    this.det = new a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.det[paramInt] = new a();
      paramInt += 1;
    }
    this.deu = this.det[0];
    TK();
    AppMethodBeat.o(92763);
  }
  
  private List<com.google.android.exoplayer2.f.a> TJ()
  {
    AppMethodBeat.i(92777);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.det[i].isEmpty()) && (this.det[i].visible)) {
        ((List)localObject).add(this.det[i].TT());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(92777);
    return localObject;
  }
  
  private void TK()
  {
    AppMethodBeat.i(92778);
    int i = 0;
    while (i < 8)
    {
      this.det[i].reset();
      i += 1;
    }
    AppMethodBeat.o(92778);
  }
  
  private void TR()
  {
    AppMethodBeat.i(92767);
    if (this.dev == null)
    {
      AppMethodBeat.o(92767);
      return;
    }
    TS();
    this.dev = null;
    AppMethodBeat.o(92767);
  }
  
  private void TS()
  {
    AppMethodBeat.i(92768);
    if (this.dev.currentIndex != this.dev.deW * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.dev.deW * 2 - 1).append(", but current index is ").append(this.dev.currentIndex).append(" (sequence number ").append(this.dev.deV).append("); ignoring packet");
      AppMethodBeat.o(92768);
      return;
    }
    this.deq.n(this.dev.deX, this.dev.currentIndex);
    int j = this.deq.hQ(3);
    int k = this.deq.hQ(5);
    int i = j;
    if (j == 7)
    {
      this.deq.hR(2);
      i = j + this.deq.hQ(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(92768);
      return;
    }
    if (i != this.der)
    {
      AppMethodBeat.o(92768);
      return;
    }
    i = 0;
    while (this.deq.UB() > 0)
    {
      j = this.deq.hQ(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          ip(j);
        }
        else if (j <= 127)
        {
          iu(j);
          i = 1;
        }
        else if (j <= 159)
        {
          iq(j);
          i = 1;
        }
        else if (j <= 255)
        {
          iv(j);
          i = 1;
        }
      }
      else
      {
        j = this.deq.hQ(8);
        if (j <= 31)
        {
          ir(j);
        }
        else if (j <= 127)
        {
          iw(j);
          i = 1;
        }
        else if (j <= 159)
        {
          it(j);
        }
        else if (j <= 255)
        {
          ix(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.deb = TJ();
    }
    AppMethodBeat.o(92768);
  }
  
  private void ip(int paramInt)
  {
    AppMethodBeat.i(92769);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.deq.hR(8);
        AppMethodBeat.o(92769);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(92769);
      return;
    case 3: 
      this.deb = TJ();
      AppMethodBeat.o(92769);
      return;
    case 8: 
      this.deu.TN();
      AppMethodBeat.o(92769);
      return;
    case 12: 
      TK();
      AppMethodBeat.o(92769);
      return;
    case 13: 
      this.deu.h('\n');
      AppMethodBeat.o(92769);
      return;
    case 14: 
      AppMethodBeat.o(92769);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.deq.hR(16);
      AppMethodBeat.o(92769);
      return;
    }
    AppMethodBeat.o(92769);
  }
  
  private void iq(int paramInt)
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
      } while (this.dew == paramInt);
      this.dew = paramInt;
      this.deu = this.det[paramInt];
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.deq.Sg()) {
          this.det[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.deq.Sg()) {
          this.det[(8 - paramInt)].visible = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.deq.Sg()) {
          this.det[(8 - paramInt)].visible = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.deq.Sg())
        {
          locala = this.det[(8 - paramInt)];
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
        if (this.deq.Sg()) {
          this.det[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(92770);
      return;
      this.deq.hR(8);
      AppMethodBeat.o(92770);
      return;
      AppMethodBeat.o(92770);
      return;
      TK();
      AppMethodBeat.o(92770);
      return;
      if (!this.deu.deI)
      {
        this.deq.hR(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.deq.hQ(4);
      this.deq.hQ(2);
      this.deq.hQ(2);
      boolean bool1 = this.deq.Sg();
      boolean bool2 = this.deq.Sg();
      this.deq.hQ(3);
      this.deq.hQ(3);
      this.deu.j(bool1, bool2);
      AppMethodBeat.o(92770);
      return;
      if (!this.deu.deI)
      {
        this.deq.hR(24);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.deq.hQ(2);
      paramInt = a.t(this.deq.hQ(2), this.deq.hQ(2), this.deq.hQ(2), paramInt);
      int i = this.deq.hQ(2);
      i = a.t(this.deq.hQ(2), this.deq.hQ(2), this.deq.hQ(2), i);
      this.deq.hR(2);
      a.D(this.deq.hQ(2), this.deq.hQ(2), this.deq.hQ(2));
      this.deu.ch(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      if (!this.deu.deI)
      {
        this.deq.hR(16);
        AppMethodBeat.o(92770);
        return;
      }
      this.deq.hR(4);
      paramInt = this.deq.hQ(4);
      this.deq.hR(2);
      this.deq.hQ(6);
      a locala = this.deu;
      if (locala.row != paramInt) {
        locala.h('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(92770);
      return;
      if (!this.deu.deI)
      {
        this.deq.hR(32);
        AppMethodBeat.o(92770);
        return;
      }
      paramInt = this.deq.hQ(2);
      paramInt = a.t(this.deq.hQ(2), this.deq.hQ(2), this.deq.hQ(2), paramInt);
      this.deq.hQ(2);
      a.D(this.deq.hQ(2), this.deq.hQ(2), this.deq.hQ(2));
      this.deq.Sg();
      this.deq.Sg();
      this.deq.hQ(2);
      this.deq.hQ(2);
      i = this.deq.hQ(2);
      this.deq.hR(8);
      this.deu.cg(paramInt, i);
      AppMethodBeat.o(92770);
      return;
      paramInt -= 152;
      locala = this.det[paramInt];
      this.deq.hR(2);
      bool1 = this.deq.Sg();
      bool2 = this.deq.Sg();
      this.deq.Sg();
      int j = this.deq.hQ(3);
      boolean bool3 = this.deq.Sg();
      int k = this.deq.hQ(7);
      int m = this.deq.hQ(8);
      int n = this.deq.hQ(4);
      int i1 = this.deq.hQ(4);
      this.deq.hR(2);
      this.deq.hQ(6);
      this.deq.hR(2);
      int i2 = this.deq.hQ(3);
      i = this.deq.hQ(3);
      locala.deI = true;
      locala.visible = bool1;
      locala.deN = bool2;
      locala.priority = j;
      locala.deJ = bool3;
      locala.deK = k;
      locala.deL = m;
      locala.deM = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.dek.size() >= locala.rowCount)) || (locala.dek.size() >= 15)) {
          locala.dek.remove(0);
        }
      }
      if ((i2 != 0) && (locala.deO != i2))
      {
        locala.deO = i2;
        j = i2 - 1;
        locala.cg(a.deE[j], a.deA[j]);
      }
      if ((i != 0) && (locala.deP != i))
      {
        locala.deP = i;
        locala.j(false, false);
        locala.ch(a.dex, a.deH[(i - 1)]);
      }
    } while (this.dew == paramInt);
    this.dew = paramInt;
    this.deu = this.det[paramInt];
    AppMethodBeat.o(92770);
  }
  
  private void ir(int paramInt)
  {
    AppMethodBeat.i(92771);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.deq.hR(8);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 23)
      {
        this.deq.hR(16);
        AppMethodBeat.o(92771);
        return;
      }
      if (paramInt <= 31) {
        this.deq.hR(24);
      }
    }
    AppMethodBeat.o(92771);
  }
  
  private void it(int paramInt)
  {
    AppMethodBeat.i(92772);
    if (paramInt <= 135)
    {
      this.deq.hR(32);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 143)
    {
      this.deq.hR(40);
      AppMethodBeat.o(92772);
      return;
    }
    if (paramInt <= 159)
    {
      this.deq.hR(2);
      paramInt = this.deq.hQ(6);
      this.deq.hR(paramInt * 8);
    }
    AppMethodBeat.o(92772);
  }
  
  private void iu(int paramInt)
  {
    AppMethodBeat.i(92773);
    if (paramInt == 127)
    {
      this.deu.h('♫');
      AppMethodBeat.o(92773);
      return;
    }
    this.deu.h((char)(paramInt & 0xFF));
    AppMethodBeat.o(92773);
  }
  
  private void iv(int paramInt)
  {
    AppMethodBeat.i(92774);
    this.deu.h((char)(paramInt & 0xFF));
    AppMethodBeat.o(92774);
  }
  
  private void iw(int paramInt)
  {
    AppMethodBeat.i(92775);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(92775);
      return;
    case 32: 
      this.deu.h(' ');
      AppMethodBeat.o(92775);
      return;
    case 33: 
      this.deu.h(' ');
      AppMethodBeat.o(92775);
      return;
    case 37: 
      this.deu.h('…');
      AppMethodBeat.o(92775);
      return;
    case 42: 
      this.deu.h('Š');
      AppMethodBeat.o(92775);
      return;
    case 44: 
      this.deu.h('Œ');
      AppMethodBeat.o(92775);
      return;
    case 48: 
      this.deu.h('█');
      AppMethodBeat.o(92775);
      return;
    case 49: 
      this.deu.h('‘');
      AppMethodBeat.o(92775);
      return;
    case 50: 
      this.deu.h('’');
      AppMethodBeat.o(92775);
      return;
    case 51: 
      this.deu.h('“');
      AppMethodBeat.o(92775);
      return;
    case 52: 
      this.deu.h('”');
      AppMethodBeat.o(92775);
      return;
    case 53: 
      this.deu.h('•');
      AppMethodBeat.o(92775);
      return;
    case 57: 
      this.deu.h('™');
      AppMethodBeat.o(92775);
      return;
    case 58: 
      this.deu.h('š');
      AppMethodBeat.o(92775);
      return;
    case 60: 
      this.deu.h('œ');
      AppMethodBeat.o(92775);
      return;
    case 61: 
      this.deu.h('℠');
      AppMethodBeat.o(92775);
      return;
    case 63: 
      this.deu.h('Ÿ');
      AppMethodBeat.o(92775);
      return;
    case 118: 
      this.deu.h('⅛');
      AppMethodBeat.o(92775);
      return;
    case 119: 
      this.deu.h('⅜');
      AppMethodBeat.o(92775);
      return;
    case 120: 
      this.deu.h('⅝');
      AppMethodBeat.o(92775);
      return;
    case 121: 
      this.deu.h('⅞');
      AppMethodBeat.o(92775);
      return;
    case 122: 
      this.deu.h('│');
      AppMethodBeat.o(92775);
      return;
    case 123: 
      this.deu.h('┐');
      AppMethodBeat.o(92775);
      return;
    case 124: 
      this.deu.h('└');
      AppMethodBeat.o(92775);
      return;
    case 125: 
      this.deu.h('─');
      AppMethodBeat.o(92775);
      return;
    case 126: 
      this.deu.h('┘');
      AppMethodBeat.o(92775);
      return;
    }
    this.deu.h('┌');
    AppMethodBeat.o(92775);
  }
  
  private void ix(int paramInt)
  {
    AppMethodBeat.i(92776);
    if (paramInt == 160)
    {
      this.deu.h('㏄');
      AppMethodBeat.o(92776);
      return;
    }
    this.deu.h('_');
    AppMethodBeat.o(92776);
  }
  
  protected final boolean TH()
  {
    return this.deb != this.dec;
  }
  
  protected final com.google.android.exoplayer2.f.d TI()
  {
    AppMethodBeat.i(92765);
    this.dec = this.deb;
    f localf = new f(this.deb);
    AppMethodBeat.o(92765);
    return localf;
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92766);
    this.ddW.n(paramh.cKQ.array(), paramh.cKQ.limit());
    if (this.ddW.UF() >= 3)
    {
      int k = this.ddW.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.ddW.readUnsignedByte();
        j = (byte)this.ddW.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        TR();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.dev = new b((i & 0xC0) >> 6, k);
        paramh = this.dev.deX;
        localb = this.dev;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.dev.currentIndex != this.dev.deW * 2 - 1) {
          break label313;
        }
        TR();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.dev == null) {
          break;
        }
        paramh = this.dev.deX;
        localb = this.dev;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.dev.deX;
        localb = this.dev;
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
    this.deb = null;
    this.dec = null;
    this.dew = 0;
    this.deu = this.det[this.dew];
    TK();
    this.dev = null;
    AppMethodBeat.o(92764);
  }
  
  static final class a
  {
    static final int[] deA;
    private static final int[] deB;
    private static final int[] deC;
    private static final boolean[] deD;
    static final int[] deE;
    private static final int[] deF;
    private static final int[] deG;
    static final int[] deH;
    public static final int dex;
    public static final int dey;
    public static final int dez;
    private int backgroundColor;
    boolean deI;
    boolean deJ;
    int deK;
    int deL;
    int deM;
    boolean deN;
    int deO;
    int deP;
    private int deQ;
    private int deR;
    private int deS;
    private int deT;
    private int deU;
    final List<SpannableString> dek;
    private final SpannableStringBuilder del;
    private int den;
    private int justification;
    int priority;
    int row;
    int rowCount;
    boolean visible;
    
    static
    {
      AppMethodBeat.i(92761);
      dex = t(2, 2, 2, 0);
      dey = t(0, 0, 0, 0);
      dez = t(0, 0, 0, 3);
      deA = new int[] { 0, 0, 0, 0, 0, 2, 0 };
      deB = new int[] { 0, 0, 0, 0, 0, 0, 2 };
      deC = new int[] { 3, 3, 3, 3, 3, 3, 1 };
      deD = new boolean[] { 0, 0, 0, 1, 1, 1, 0 };
      deE = new int[] { dey, dez, dey, dey, dez, dey, dey };
      deF = new int[] { 0, 1, 2, 3, 4, 3, 4 };
      deG = new int[] { 0, 0, 0, 0, 0, 3, 3 };
      deH = new int[] { dey, dey, dey, dey, dey, dez, dez };
      AppMethodBeat.o(92761);
    }
    
    public a()
    {
      AppMethodBeat.i(92749);
      this.dek = new LinkedList();
      this.del = new SpannableStringBuilder();
      reset();
      AppMethodBeat.o(92749);
    }
    
    public static int D(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(92759);
      paramInt1 = t(paramInt1, paramInt2, paramInt3, 0);
      AppMethodBeat.o(92759);
      return paramInt1;
    }
    
    private SpannableString TP()
    {
      AppMethodBeat.i(92757);
      Object localObject = new SpannableStringBuilder(this.del);
      int i = ((SpannableStringBuilder)localObject).length();
      if (i > 0)
      {
        if (this.deR != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(2), this.deR, i, 33);
        }
        if (this.den != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new UnderlineSpan(), this.den, i, 33);
        }
        if (this.deS != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new ForegroundColorSpan(this.deT), this.deS, i, 33);
        }
        if (this.deU != -1) {
          ((SpannableStringBuilder)localObject).setSpan(new BackgroundColorSpan(this.backgroundColor), this.deU, i, 33);
        }
      }
      localObject = new SpannableString((CharSequence)localObject);
      AppMethodBeat.o(92757);
      return localObject;
    }
    
    public static int t(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int i = 255;
      AppMethodBeat.i(92760);
      com.google.android.exoplayer2.i.a.ck(paramInt1, 4);
      com.google.android.exoplayer2.i.a.ck(paramInt2, 4);
      com.google.android.exoplayer2.i.a.ck(paramInt3, 4);
      com.google.android.exoplayer2.i.a.ck(paramInt4, 4);
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
    
    public final void TN()
    {
      AppMethodBeat.i(92755);
      int i = this.del.length();
      if (i > 0) {
        this.del.delete(i - 1, i);
      }
      AppMethodBeat.o(92755);
    }
    
    public final b TT()
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
      while (i < this.dek.size())
      {
        localSpannableStringBuilder.append((CharSequence)this.dek.get(i));
        localSpannableStringBuilder.append('\n');
        i += 1;
      }
      localSpannableStringBuilder.append(TP());
      Object localObject;
      float f2;
      float f1;
      label190:
      label201:
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
        if (this.deJ)
        {
          f2 = this.deL / 99.0F;
          f1 = this.deK / 99.0F;
          if (this.deM % 3 != 0) {
            break label311;
          }
          i = 0;
          if (this.deM / 3 != 0) {
            break label331;
          }
          j = 0;
        }
        break;
      }
      for (;;)
      {
        if (this.deQ != dey) {
          bool = true;
        }
        localObject = new b(localSpannableStringBuilder, (Layout.Alignment)localObject, f1 * 0.9F + 0.05F, i, f2 * 0.9F + 0.05F, j, bool, this.deQ, this.priority);
        AppMethodBeat.o(92758);
        return localObject;
        localObject = Layout.Alignment.ALIGN_OPPOSITE;
        break;
        localObject = Layout.Alignment.ALIGN_CENTER;
        break;
        f2 = this.deL / 209.0F;
        f1 = this.deK / 74.0F;
        break label190;
        label311:
        if (this.deM % 3 == 1)
        {
          i = 1;
          break label201;
        }
        i = 2;
        break label201;
        label331:
        if (this.deM / 3 == 1) {
          j = 1;
        } else {
          j = 2;
        }
      }
    }
    
    public final void cg(int paramInt1, int paramInt2)
    {
      this.deQ = paramInt1;
      this.justification = paramInt2;
    }
    
    public final void ch(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92754);
      if ((this.deS != -1) && (this.deT != paramInt1)) {
        this.del.setSpan(new ForegroundColorSpan(this.deT), this.deS, this.del.length(), 33);
      }
      if (paramInt1 != dex)
      {
        this.deS = this.del.length();
        this.deT = paramInt1;
      }
      if ((this.deU != -1) && (this.backgroundColor != paramInt2)) {
        this.del.setSpan(new BackgroundColorSpan(this.backgroundColor), this.deU, this.del.length(), 33);
      }
      if (paramInt2 != dey)
      {
        this.deU = this.del.length();
        this.backgroundColor = paramInt2;
      }
      AppMethodBeat.o(92754);
    }
    
    public final void clear()
    {
      AppMethodBeat.i(92752);
      this.dek.clear();
      this.del.clear();
      this.deR = -1;
      this.den = -1;
      this.deS = -1;
      this.deU = -1;
      this.row = 0;
      AppMethodBeat.o(92752);
    }
    
    public final void h(char paramChar)
    {
      AppMethodBeat.i(92756);
      if (paramChar == '\n')
      {
        this.dek.add(TP());
        this.del.clear();
        if (this.deR != -1) {
          this.deR = 0;
        }
        if (this.den != -1) {
          this.den = 0;
        }
        if (this.deS != -1) {
          this.deS = 0;
        }
        if (this.deU != -1) {
          this.deU = 0;
        }
        while (((this.deN) && (this.dek.size() >= this.rowCount)) || (this.dek.size() >= 15)) {
          this.dek.remove(0);
        }
      }
      this.del.append(paramChar);
      AppMethodBeat.o(92756);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92750);
      if ((!this.deI) || ((this.dek.isEmpty()) && (this.del.length() == 0)))
      {
        AppMethodBeat.o(92750);
        return true;
      }
      AppMethodBeat.o(92750);
      return false;
    }
    
    public final void j(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(92753);
      if (this.deR != -1) {
        if (!paramBoolean1)
        {
          this.del.setSpan(new StyleSpan(2), this.deR, this.del.length(), 33);
          this.deR = -1;
        }
      }
      while (this.den != -1)
      {
        if (paramBoolean2) {
          break label135;
        }
        this.del.setSpan(new UnderlineSpan(), this.den, this.del.length(), 33);
        this.den = -1;
        AppMethodBeat.o(92753);
        return;
        if (paramBoolean1) {
          this.deR = this.del.length();
        }
      }
      if (paramBoolean2) {
        this.den = this.del.length();
      }
      label135:
      AppMethodBeat.o(92753);
    }
    
    public final void reset()
    {
      AppMethodBeat.i(92751);
      clear();
      this.deI = false;
      this.visible = false;
      this.priority = 4;
      this.deJ = false;
      this.deK = 0;
      this.deL = 0;
      this.deM = 0;
      this.rowCount = 15;
      this.deN = true;
      this.justification = 0;
      this.deO = 0;
      this.deP = 0;
      this.deQ = dey;
      this.deT = dex;
      this.backgroundColor = dey;
      AppMethodBeat.o(92751);
    }
  }
  
  static final class b
  {
    int currentIndex;
    public final int deV;
    public final int deW;
    public final byte[] deX;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92762);
      this.deV = paramInt1;
      this.deW = paramInt2;
      this.deX = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(92762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */