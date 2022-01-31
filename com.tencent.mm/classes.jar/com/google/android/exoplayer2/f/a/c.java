package com.google.android.exoplayer2.f.a;

import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c
  extends d
{
  private final j aMH = new j();
  private List<com.google.android.exoplayer2.f.a> aMM;
  private List<com.google.android.exoplayer2.f.a> aMN;
  private final i aNb = new i();
  private final int aNc;
  private final c.a[] aNd;
  private c.a aNe;
  private c.b aNf;
  private int aNg;
  
  public c(int paramInt)
  {
    int i = paramInt;
    if (paramInt == -1) {
      i = 1;
    }
    this.aNc = i;
    this.aNd = new c.a[8];
    paramInt = 0;
    while (paramInt < 8)
    {
      this.aNd[paramInt] = new c.a();
      paramInt += 1;
    }
    this.aNe = this.aNd[0];
    ns();
  }
  
  private void dp(int paramInt)
  {
    switch (paramInt)
    {
    }
    label290:
    label342:
    do
    {
      for (;;)
      {
        return;
        paramInt -= 128;
        if (this.aNg != paramInt)
        {
          this.aNg = paramInt;
          this.aNe = this.aNd[paramInt];
          return;
          paramInt = 1;
          while (paramInt <= 8)
          {
            if (this.aNb.ob()) {
              this.aNd[(8 - paramInt)].clear();
            }
            paramInt += 1;
          }
          continue;
          paramInt = 1;
          while (paramInt <= 8)
          {
            if (this.aNb.ob()) {
              this.aNd[(8 - paramInt)].aoL = true;
            }
            paramInt += 1;
          }
          continue;
          paramInt = 1;
          while (paramInt <= 8)
          {
            if (this.aNb.ob()) {
              this.aNd[(8 - paramInt)].aoL = false;
            }
            paramInt += 1;
          }
          continue;
          paramInt = 1;
          if (paramInt <= 8) {
            if (this.aNb.ob())
            {
              locala = this.aNd[(8 - paramInt)];
              if (locala.aoL) {
                break label342;
              }
            }
          }
          for (bool1 = true;; bool1 = false)
          {
            locala.aoL = bool1;
            paramInt += 1;
            break label290;
            break;
          }
          paramInt = 1;
          while (paramInt <= 8)
          {
            if (this.aNb.ob()) {
              this.aNd[(8 - paramInt)].reset();
            }
            paramInt += 1;
          }
        }
      }
      this.aNb.dy(8);
      return;
      ns();
      return;
      if (!this.aNe.aNs)
      {
        this.aNb.dy(16);
        return;
      }
      this.aNb.dz(4);
      this.aNb.dz(2);
      this.aNb.dz(2);
      boolean bool1 = this.aNb.ob();
      boolean bool2 = this.aNb.ob();
      this.aNb.dz(3);
      this.aNb.dz(3);
      this.aNe.g(bool1, bool2);
      return;
      if (!this.aNe.aNs)
      {
        this.aNb.dy(24);
        return;
      }
      paramInt = this.aNb.dz(2);
      paramInt = c.a.j(this.aNb.dz(2), this.aNb.dz(2), this.aNb.dz(2), paramInt);
      int i = this.aNb.dz(2);
      i = c.a.j(this.aNb.dz(2), this.aNb.dz(2), this.aNb.dz(2), i);
      this.aNb.dy(2);
      c.a.r(this.aNb.dz(2), this.aNb.dz(2), this.aNb.dz(2));
      this.aNe.aG(paramInt, i);
      return;
      if (!this.aNe.aNs)
      {
        this.aNb.dy(16);
        return;
      }
      this.aNb.dy(4);
      paramInt = this.aNb.dz(4);
      this.aNb.dy(2);
      this.aNb.dz(6);
      c.a locala = this.aNe;
      if (locala.row != paramInt) {
        locala.append('\n');
      }
      locala.row = paramInt;
      return;
      if (!this.aNe.aNs)
      {
        this.aNb.dy(32);
        return;
      }
      paramInt = this.aNb.dz(2);
      paramInt = c.a.j(this.aNb.dz(2), this.aNb.dz(2), this.aNb.dz(2), paramInt);
      this.aNb.dz(2);
      c.a.r(this.aNb.dz(2), this.aNb.dz(2), this.aNb.dz(2));
      this.aNb.ob();
      this.aNb.ob();
      this.aNb.dz(2);
      this.aNb.dz(2);
      i = this.aNb.dz(2);
      this.aNb.dy(8);
      this.aNe.aF(paramInt, i);
      return;
      paramInt -= 152;
      locala = this.aNd[paramInt];
      this.aNb.dy(2);
      bool1 = this.aNb.ob();
      bool2 = this.aNb.ob();
      this.aNb.ob();
      int j = this.aNb.dz(3);
      boolean bool3 = this.aNb.ob();
      int k = this.aNb.dz(7);
      int m = this.aNb.dz(8);
      int n = this.aNb.dz(4);
      int i1 = this.aNb.dz(4);
      this.aNb.dy(2);
      this.aNb.dz(6);
      this.aNb.dy(2);
      int i2 = this.aNb.dz(3);
      i = this.aNb.dz(3);
      locala.aNs = true;
      locala.aoL = bool1;
      locala.aNx = bool2;
      locala.priority = j;
      locala.aNt = bool3;
      locala.aNu = k;
      locala.aNv = m;
      locala.aNw = n;
      if (locala.rowCount != i1 + 1)
      {
        locala.rowCount = (i1 + 1);
        while (((bool2) && (locala.aMV.size() >= locala.rowCount)) || (locala.aMV.size() >= 15)) {
          locala.aMV.remove(0);
        }
      }
      if ((i2 != 0) && (locala.aNz != i2))
      {
        locala.aNz = i2;
        j = i2 - 1;
        locala.aF(c.a.aNo[j], c.a.aNk[j]);
      }
      if ((i != 0) && (locala.aNA != i))
      {
        locala.aNA = i;
        locala.g(false, false);
        locala.aG(c.a.aNh, c.a.aNr[(i - 1)]);
      }
    } while (this.aNg == paramInt);
    this.aNg = paramInt;
    this.aNe = this.aNd[paramInt];
  }
  
  private List<com.google.android.exoplayer2.f.a> nr()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      if ((!this.aNd[i].isEmpty()) && (this.aNd[i].aoL)) {
        localArrayList.add(this.aNd[i].nA());
      }
      i += 1;
    }
    Collections.sort(localArrayList);
    return Collections.unmodifiableList(localArrayList);
  }
  
  private void ns()
  {
    int i = 0;
    while (i < 8)
    {
      this.aNd[i].reset();
      i += 1;
    }
  }
  
  private void nz()
  {
    if (this.aNf == null) {
      return;
    }
    if (this.aNf.currentIndex != this.aNf.aNG * 2 - 1) {
      new StringBuilder("DtvCcPacket ended prematurely; size is ").append(this.aNf.aNG * 2 - 1).append(", but current index is ").append(this.aNf.currentIndex).append(" (sequence number ").append(this.aNf.aNF).append("); ignoring packet");
    }
    for (;;)
    {
      this.aNf = null;
      return;
      this.aNb.m(this.aNf.aNH, this.aNf.currentIndex);
      int j = this.aNb.dz(3);
      int k = this.aNb.dz(5);
      int i = j;
      if (j == 7)
      {
        this.aNb.dy(2);
        i = j + this.aNb.dz(6);
      }
      if (k == 0)
      {
        if (i != 0) {
          new StringBuilder("serviceNumber is non-zero (").append(i).append(") when blockSize is 0");
        }
      }
      else if (i == this.aNc)
      {
        i = 0;
        while (this.aNb.nZ() > 0)
        {
          j = this.aNb.dz(8);
          if (j != 16)
          {
            if (j <= 31)
            {
              switch (j)
              {
              case 0: 
              case 14: 
              default: 
                if ((j >= 17) && (j <= 23)) {
                  this.aNb.dy(8);
                }
                break;
              case 3: 
                this.aMM = nr();
                break;
              case 8: 
                c.a locala = this.aNe;
                j = locala.aMW.length();
                if (j <= 0) {
                  continue;
                }
                locala.aMW.delete(j - 1, j);
                break;
              case 12: 
                ns();
                break;
              case 13: 
                this.aNe.append('\n');
                continue;
                if ((j < 24) || (j > 31)) {
                  continue;
                }
                this.aNb.dy(16);
                break;
              }
            }
            else
            {
              if (j <= 127)
              {
                if (j == 127) {
                  this.aNe.append('♫');
                }
                for (;;)
                {
                  i = 1;
                  break;
                  this.aNe.append((char)(j & 0xFF));
                }
              }
              if (j <= 159)
              {
                dp(j);
                i = 1;
              }
              else if (j <= 255)
              {
                this.aNe.append((char)(j & 0xFF));
                i = 1;
              }
            }
          }
          else
          {
            j = this.aNb.dz(8);
            if (j <= 31)
            {
              if (j > 7) {
                if (j <= 15) {
                  this.aNb.dy(8);
                } else if (j <= 23) {
                  this.aNb.dy(16);
                } else if (j <= 31) {
                  this.aNb.dy(24);
                }
              }
            }
            else
            {
              if (j <= 127)
              {
                switch (j)
                {
                }
                for (;;)
                {
                  i = 1;
                  break;
                  this.aNe.append(' ');
                  continue;
                  this.aNe.append(' ');
                  continue;
                  this.aNe.append('…');
                  continue;
                  this.aNe.append('Š');
                  continue;
                  this.aNe.append('Œ');
                  continue;
                  this.aNe.append('█');
                  continue;
                  this.aNe.append('‘');
                  continue;
                  this.aNe.append('’');
                  continue;
                  this.aNe.append('“');
                  continue;
                  this.aNe.append('”');
                  continue;
                  this.aNe.append('•');
                  continue;
                  this.aNe.append('™');
                  continue;
                  this.aNe.append('š');
                  continue;
                  this.aNe.append('œ');
                  continue;
                  this.aNe.append('℠');
                  continue;
                  this.aNe.append('Ÿ');
                  continue;
                  this.aNe.append('⅛');
                  continue;
                  this.aNe.append('⅜');
                  continue;
                  this.aNe.append('⅝');
                  continue;
                  this.aNe.append('⅞');
                  continue;
                  this.aNe.append('│');
                  continue;
                  this.aNe.append('┐');
                  continue;
                  this.aNe.append('└');
                  continue;
                  this.aNe.append('─');
                  continue;
                  this.aNe.append('┘');
                  continue;
                  this.aNe.append('┌');
                }
              }
              if (j <= 159)
              {
                if (j <= 135)
                {
                  this.aNb.dy(32);
                }
                else if (j <= 143)
                {
                  this.aNb.dy(40);
                }
                else if (j <= 159)
                {
                  this.aNb.dy(2);
                  j = this.aNb.dz(6);
                  this.aNb.dy(j * 8);
                }
              }
              else if (j <= 255)
              {
                if (j == 160) {
                  this.aNe.append('㏄');
                }
                for (;;)
                {
                  i = 1;
                  break;
                  this.aNe.append('_');
                }
              }
            }
          }
        }
        if (i != 0) {
          this.aMM = nr();
        }
      }
    }
  }
  
  protected final void a(h paramh)
  {
    this.aMH.m(paramh.ayD.array(), paramh.ayD.limit());
    if (this.aMH.oe() >= 3)
    {
      int k = this.aMH.readUnsignedByte() & 0x7;
      int m = k & 0x3;
      if ((k & 0x4) == 4) {}
      int i;
      int j;
      c.b localb;
      for (k = 1;; k = 0)
      {
        i = (byte)this.aMH.readUnsignedByte();
        j = (byte)this.aMH.readUnsignedByte();
        if (((m != 2) && (m != 3)) || (k == 0)) {
          break;
        }
        if (m != 3) {
          break label215;
        }
        nz();
        m = i & 0x3F;
        k = m;
        if (m == 0) {
          k = 64;
        }
        this.aNf = new c.b((i & 0xC0) >> 6, k);
        paramh = this.aNf.aNH;
        localb = this.aNf;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        label181:
        if (this.aNf.currentIndex != this.aNf.aNG * 2 - 1) {
          break label307;
        }
        nz();
        break;
      }
      label215:
      if (m == 2) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.aB(bool);
        if (this.aNf == null) {
          break;
        }
        paramh = this.aNf.aNH;
        localb = this.aNf;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = i;
        paramh = this.aNf.aNH;
        localb = this.aNf;
        k = localb.currentIndex;
        localb.currentIndex = (k + 1);
        paramh[k] = j;
        break label181;
        label307:
        break;
      }
    }
  }
  
  public final void flush()
  {
    super.flush();
    this.aMM = null;
    this.aMN = null;
    this.aNg = 0;
    this.aNe = this.aNd[this.aNg];
    ns();
    this.aNf = null;
  }
  
  protected final boolean np()
  {
    return this.aMM != this.aMN;
  }
  
  protected final com.google.android.exoplayer2.f.d nq()
  {
    this.aMN = this.aMM;
    return new f(this.aMM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.c
 * JD-Core Version:    0.7.0.1
 */