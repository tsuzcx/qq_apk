package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends d
{
  private int aUA;
  private final m aUb;
  private List<com.google.android.exoplayer2.f.a> aUg;
  private List<com.google.android.exoplayer2.f.a> aUh;
  private final l aUv;
  private final int aUw;
  private final c.a[] aUx;
  private c.a aUy;
  private b aUz;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(95595);
    this.aUb = new m();
    this.aUv = new l();
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.aUw = i;
    this.aUx = new c.a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.aUx[paramInt] = new c.a();
      paramInt += 1;
    }
    this.aUy = this.aUx[0];
    pP();
    AppMethodBeat.o(95595);
  }
  
  private void dV(int paramInt)
  {
    AppMethodBeat.i(95601);
    switch (paramInt)
    {
    default: 
      if ((paramInt >= 17) && (paramInt <= 23))
      {
        this.aUv.dE(8);
        AppMethodBeat.o(95601);
        return;
      }
      break;
    case 0: 
      AppMethodBeat.o(95601);
      return;
    case 3: 
      this.aUg = pO();
      AppMethodBeat.o(95601);
      return;
    case 8: 
      this.aUy.pS();
      AppMethodBeat.o(95601);
      return;
    case 12: 
      pP();
      AppMethodBeat.o(95601);
      return;
    case 13: 
      this.aUy.append('\n');
      AppMethodBeat.o(95601);
      return;
    case 14: 
      AppMethodBeat.o(95601);
      return;
    }
    if ((paramInt >= 24) && (paramInt <= 31))
    {
      this.aUv.dE(16);
      AppMethodBeat.o(95601);
      return;
    }
    AppMethodBeat.o(95601);
  }
  
  private void dW(int paramInt)
  {
    AppMethodBeat.i(95602);
    switch (paramInt)
    {
    }
    label374:
    do
    {
      do
      {
        AppMethodBeat.o(95602);
        return;
        paramInt -= 128;
      } while (this.aUA == paramInt);
      this.aUA = paramInt;
      this.aUy = this.aUx[paramInt];
      AppMethodBeat.o(95602);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.aUv.oj()) {
          this.aUx[(8 - paramInt)].clear();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(95602);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.aUv.oj()) {
          this.aUx[(8 - paramInt)].arf = true;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(95602);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.aUv.oj()) {
          this.aUx[(8 - paramInt)].arf = false;
        }
        paramInt += 1;
      }
      AppMethodBeat.o(95602);
      return;
      paramInt = 1;
      if (paramInt <= 8)
      {
        if (this.aUv.oj())
        {
          locala = this.aUx[(8 - paramInt)];
          if (locala.arf) {
            break label374;
          }
        }
        for (bool1 = true;; bool1 = false)
        {
          locala.arf = bool1;
          paramInt += 1;
          break;
        }
      }
      AppMethodBeat.o(95602);
      return;
      paramInt = 1;
      while (paramInt <= 8)
      {
        if (this.aUv.oj()) {
          this.aUx[(8 - paramInt)].reset();
        }
        paramInt += 1;
      }
      AppMethodBeat.o(95602);
      return;
      this.aUv.dE(8);
      AppMethodBeat.o(95602);
      return;
      AppMethodBeat.o(95602);
      return;
      pP();
      AppMethodBeat.o(95602);
      return;
      if (!this.aUy.aUM)
      {
        this.aUv.dE(16);
        AppMethodBeat.o(95602);
        return;
      }
      this.aUv.dD(4);
      this.aUv.dD(2);
      this.aUv.dD(2);
      boolean bool1 = this.aUv.oj();
      boolean bool2 = this.aUv.oj();
      this.aUv.dD(3);
      this.aUv.dD(3);
      this.aUy.h(bool1, bool2);
      AppMethodBeat.o(95602);
      return;
      if (!this.aUy.aUM)
      {
        this.aUv.dE(24);
        AppMethodBeat.o(95602);
        return;
      }
      paramInt = this.aUv.dD(2);
      paramInt = c.a.l(this.aUv.dD(2), this.aUv.dD(2), this.aUv.dD(2), paramInt);
      int i = this.aUv.dD(2);
      i = c.a.l(this.aUv.dD(2), this.aUv.dD(2), this.aUv.dD(2), i);
      this.aUv.dE(2);
      c.a.r(this.aUv.dD(2), this.aUv.dD(2), this.aUv.dD(2));
      this.aUy.aY(paramInt, i);
      AppMethodBeat.o(95602);
      return;
      if (!this.aUy.aUM)
      {
        this.aUv.dE(16);
        AppMethodBeat.o(95602);
        return;
      }
      this.aUv.dE(4);
      paramInt = this.aUv.dD(4);
      this.aUv.dE(2);
      this.aUv.dD(6);
      c.a locala = this.aUy;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      AppMethodBeat.o(95602);
      return;
      if (!this.aUy.aUM)
      {
        this.aUv.dE(32);
        AppMethodBeat.o(95602);
        return;
      }
      paramInt = this.aUv.dD(2);
      paramInt = c.a.l(this.aUv.dD(2), this.aUv.dD(2), this.aUv.dD(2), paramInt);
      this.aUv.dD(2);
      c.a.r(this.aUv.dD(2), this.aUv.dD(2), this.aUv.dD(2));
      this.aUv.oj();
      this.aUv.oj();
      this.aUv.dD(2);
      this.aUv.dD(2);
      i = this.aUv.dD(2);
      this.aUv.dE(8);
      this.aUy.aX(paramInt, i);
      AppMethodBeat.o(95602);
      return;
      paramInt -= 152;
      locala = this.aUx[paramInt];
      this.aUv.dE(2);
      bool1 = this.aUv.oj();
      bool2 = this.aUv.oj();
      this.aUv.oj();
      int j = this.aUv.dD(3);
      boolean bool3 = this.aUv.oj();
      int k = this.aUv.dD(7);
      int m = this.aUv.dD(8);
      int n = this.aUv.dD(4);
      int i1 = this.aUv.dD(4);
      this.aUv.dE(2);
      this.aUv.dD(6);
      this.aUv.dE(2);
      int i2 = this.aUv.dD(3);
      i = this.aUv.dD(3);
      locala.aUM = true;
      locala.arf = bool1;
      locala.aUR = bool2;
      locala.priority = j;
      locala.aUN = bool3;
      locala.aUO = k;
      locala.aUP = m;
      locala.aUQ = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.aUp.size() >= locala.rowCount)) || (locala.aUp.size() >= 15)) {
          locala.aUp.remove(0);
        }
      }
      if ((i2 != 0) && (locala.aUT != i2))
      {
        locala.aUT = i2;
        j = i2 - 1;
        locala.aX(c.a.aUI[j], c.a.aUE[j]);
      }
      if ((i != 0) && (locala.aUU != i))
      {
        locala.aUU = i;
        locala.h(false, false);
        locala.aY(c.a.aUB, c.a.aUL[(i - 1)]);
      }
    } while (this.aUA == paramInt);
    this.aUA = paramInt;
    this.aUy = this.aUx[paramInt];
    AppMethodBeat.o(95602);
  }
  
  private void dX(int paramInt)
  {
    AppMethodBeat.i(95603);
    if (paramInt > 7)
    {
      if (paramInt <= 15)
      {
        this.aUv.dE(8);
        AppMethodBeat.o(95603);
        return;
      }
      if (paramInt <= 23)
      {
        this.aUv.dE(16);
        AppMethodBeat.o(95603);
        return;
      }
      if (paramInt <= 31) {
        this.aUv.dE(24);
      }
    }
    AppMethodBeat.o(95603);
  }
  
  private void dY(int paramInt)
  {
    AppMethodBeat.i(95604);
    if (paramInt <= 135)
    {
      this.aUv.dE(32);
      AppMethodBeat.o(95604);
      return;
    }
    if (paramInt <= 143)
    {
      this.aUv.dE(40);
      AppMethodBeat.o(95604);
      return;
    }
    if (paramInt <= 159)
    {
      this.aUv.dE(2);
      paramInt = this.aUv.dD(6);
      this.aUv.dE(paramInt * 8);
    }
    AppMethodBeat.o(95604);
  }
  
  private void dZ(int paramInt)
  {
    AppMethodBeat.i(95605);
    if (paramInt == 127)
    {
      this.aUy.append('♫');
      AppMethodBeat.o(95605);
      return;
    }
    this.aUy.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(95605);
  }
  
  private void ea(int paramInt)
  {
    AppMethodBeat.i(95606);
    this.aUy.append((char)(paramInt & 0xFF));
    AppMethodBeat.o(95606);
  }
  
  private void eb(int paramInt)
  {
    AppMethodBeat.i(95607);
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(95607);
      return;
    case 32: 
      this.aUy.append(' ');
      AppMethodBeat.o(95607);
      return;
    case 33: 
      this.aUy.append(' ');
      AppMethodBeat.o(95607);
      return;
    case 37: 
      this.aUy.append('…');
      AppMethodBeat.o(95607);
      return;
    case 42: 
      this.aUy.append('Š');
      AppMethodBeat.o(95607);
      return;
    case 44: 
      this.aUy.append('Œ');
      AppMethodBeat.o(95607);
      return;
    case 48: 
      this.aUy.append('█');
      AppMethodBeat.o(95607);
      return;
    case 49: 
      this.aUy.append('‘');
      AppMethodBeat.o(95607);
      return;
    case 50: 
      this.aUy.append('’');
      AppMethodBeat.o(95607);
      return;
    case 51: 
      this.aUy.append('“');
      AppMethodBeat.o(95607);
      return;
    case 52: 
      this.aUy.append('”');
      AppMethodBeat.o(95607);
      return;
    case 53: 
      this.aUy.append('•');
      AppMethodBeat.o(95607);
      return;
    case 57: 
      this.aUy.append('™');
      AppMethodBeat.o(95607);
      return;
    case 58: 
      this.aUy.append('š');
      AppMethodBeat.o(95607);
      return;
    case 60: 
      this.aUy.append('œ');
      AppMethodBeat.o(95607);
      return;
    case 61: 
      this.aUy.append('℠');
      AppMethodBeat.o(95607);
      return;
    case 63: 
      this.aUy.append('Ÿ');
      AppMethodBeat.o(95607);
      return;
    case 118: 
      this.aUy.append('⅛');
      AppMethodBeat.o(95607);
      return;
    case 119: 
      this.aUy.append('⅜');
      AppMethodBeat.o(95607);
      return;
    case 120: 
      this.aUy.append('⅝');
      AppMethodBeat.o(95607);
      return;
    case 121: 
      this.aUy.append('⅞');
      AppMethodBeat.o(95607);
      return;
    case 122: 
      this.aUy.append('│');
      AppMethodBeat.o(95607);
      return;
    case 123: 
      this.aUy.append('┐');
      AppMethodBeat.o(95607);
      return;
    case 124: 
      this.aUy.append('└');
      AppMethodBeat.o(95607);
      return;
    case 125: 
      this.aUy.append('─');
      AppMethodBeat.o(95607);
      return;
    case 126: 
      this.aUy.append('┘');
      AppMethodBeat.o(95607);
      return;
    }
    this.aUy.append('┌');
    AppMethodBeat.o(95607);
  }
  
  private void ec(int paramInt)
  {
    AppMethodBeat.i(95608);
    if (paramInt == 160)
    {
      this.aUy.append('㏄');
      AppMethodBeat.o(95608);
      return;
    }
    this.aUy.append('_');
    AppMethodBeat.o(95608);
  }
  
  private List<com.google.android.exoplayer2.f.a> pO()
  {
    AppMethodBeat.i(95609);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.aUx[i].isEmpty()) && (this.aUx[i].arf)) {
        ((List)localObject).add(this.aUx[i].pY());
      }
      i += 1;
    }
    Collections.sort((List)localObject);
    localObject = Collections.unmodifiableList((List)localObject);
    AppMethodBeat.o(95609);
    return localObject;
  }
  
  private void pP()
  {
    AppMethodBeat.i(95610);
    int i = 0;
    while (i < 8)
    {
      this.aUx[i].reset();
      i += 1;
    }
    AppMethodBeat.o(95610);
  }
  
  private void pW()
  {
    AppMethodBeat.i(95599);
    if (this.aUz == null)
    {
      AppMethodBeat.o(95599);
      return;
    }
    pX();
    this.aUz = null;
    AppMethodBeat.o(95599);
  }
  
  private void pX()
  {
    AppMethodBeat.i(95600);
    if (this.aUz.currentIndex != this.aUz.aVa * 2 - 1)
    {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.aUz.aVa * 2 - 1).append(", but current index is ").append(this.aUz.currentIndex).append(" (sequence number ").append(this.aUz.aUZ).append("); ignoring packet");
      AppMethodBeat.o(95600);
      return;
    }
    this.aUv.l(this.aUz.aVb, this.aUz.currentIndex);
    int j = this.aUv.dD(3);
    int k = this.aUv.dD(5);
    int i = j;
    if (j == 7)
    {
      this.aUv.dE(2);
      i = j + this.aUv.dD(6);
    }
    if (k == 0)
    {
      if (i != 0) {
        new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
      }
      AppMethodBeat.o(95600);
      return;
    }
    if (i != this.aUw)
    {
      AppMethodBeat.o(95600);
      return;
    }
    i = 0;
    while (this.aUv.qI() > 0)
    {
      j = this.aUv.dD(8);
      if (j != 16)
      {
        if (j <= 31)
        {
          dV(j);
        }
        else if (j <= 127)
        {
          dZ(j);
          i = 1;
        }
        else if (j <= 159)
        {
          dW(j);
          i = 1;
        }
        else if (j <= 255)
        {
          ea(j);
          i = 1;
        }
      }
      else
      {
        j = this.aUv.dD(8);
        if (j <= 31)
        {
          dX(j);
        }
        else if (j <= 127)
        {
          eb(j);
          i = 1;
        }
        else if (j <= 159)
        {
          dY(j);
        }
        else if (j <= 255)
        {
          ec(j);
          i = 1;
        }
      }
    }
    if (i != 0) {
      this.aUg = pO();
    }
    AppMethodBeat.o(95600);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(95598);
    this.aUb.l(paramh.aAS.array(), paramh.aAS.limit());
    if (this.aUb.qM() >= 3)
    {
      int k = this.aUb.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.aUb.readUnsignedByte();
        j = (byte)this.aUb.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label221;
        }
        pW();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.aUz = new b((i & 0xC0) >> 6, k);
        paramh = this.aUz.aVb;
        localb = this.aUz;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label187:
        if (this.aUz.currentIndex != this.aUz.aVa * 2 - 1) {
          break label313;
        }
        pW();
        break;
      }
      label221:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkArgument(bool);
        if (this.aUz == null) {
          break;
        }
        paramh = this.aUz.aVb;
        localb = this.aUz;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.aUz.aVb;
        localb = this.aUz;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        break label187;
        label313:
        break;
      }
    }
    AppMethodBeat.o(95598);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(95596);
    super.flush();
    this.aUg = null;
    this.aUh = null;
    this.aUA = 0;
    this.aUy = this.aUx[this.aUA];
    pP();
    this.aUz = null;
    AppMethodBeat.o(95596);
  }
  
  protected final boolean pM()
  {
    return this.aUg != this.aUh;
  }
  
  protected final com.google.android.exoplayer2.f.d pN()
  {
    AppMethodBeat.i(95597);
    this.aUh = this.aUg;
    f localf = new f(this.aUg);
    AppMethodBeat.o(95597);
    return localf;
  }
  
  static final class b
  {
    public final int aUZ;
    public final int aVa;
    public final byte[] aVb;
    int currentIndex;
    
    public b(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(95594);
      this.aUZ = paramInt1;
      this.aVa = paramInt2;
      this.aVb = new byte[paramInt2 * 2 - 1];
      this.currentIndex = 0;
      AppMethodBeat.o(95594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */