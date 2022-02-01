package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends d
{
  private static final int[] ccR = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] ddQ = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] ddR = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] ddS = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] ddT = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] ddU = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] ddV = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m ddW;
  private final int ddX;
  private final int ddY;
  private final LinkedList<a> ddZ;
  private a dea;
  private List<com.google.android.exoplayer2.f.a> deb;
  private List<com.google.android.exoplayer2.f.a> dec;
  private int ded;
  private int dee;
  private boolean def;
  private byte deg;
  private byte deh;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.ddW = new m();
    this.ddZ = new LinkedList();
    this.dea = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.ddX = i;
      switch (paramInt)
      {
      }
    }
    for (this.ddY = 1;; this.ddY = 2)
    {
      io(0);
      TK();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private List<com.google.android.exoplayer2.f.a> TJ()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.ddZ.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.ddZ.get(i)).TQ();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void TK()
  {
    AppMethodBeat.i(92744);
    this.dea.cf(this.ded, this.dee);
    this.ddZ.clear();
    this.ddZ.add(this.dea);
    AppMethodBeat.o(92744);
  }
  
  private static char c(byte paramByte)
  {
    return (char)ddS[((paramByte & 0x7F) - 32)];
  }
  
  private void io(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.ded == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.ded;
    this.ded = paramInt;
    TK();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.deb = null;
    }
    AppMethodBeat.o(92743);
  }
  
  protected final boolean TH()
  {
    return this.deb != this.dec;
  }
  
  protected final com.google.android.exoplayer2.f.d TI()
  {
    AppMethodBeat.i(92740);
    this.dec = this.deb;
    f localf = new f(this.deb);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.ddW.n(paramh.cKQ.array(), paramh.cKQ.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.ddW.UF() >= this.ddX)
    {
      if (this.ddX == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.ddW.readUnsignedByte())
      {
        i = (byte)(this.ddW.readUnsignedByte() & 0x7F);
        j = (byte)(this.ddW.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.ddY == 1) && ((n & 0x1) != 0)) || ((this.ddY == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.dea.h((char)ddT[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.dea.TN();
        if ((i & 0x1) == 0)
        {
          this.dea.h((char)ddU[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.dea.h((char)ddV[(j & 0x1F)]);
          k = 1;
        }
      }
      else
      {
        if ((i & 0xE0) == 0)
        {
          if ((i & 0xF0) == 16) {
            k = 1;
          }
          for (;;)
          {
            if (k != 0)
            {
              if ((this.def) && (this.deg == i) && (this.deh == j))
              {
                this.def = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.def = true;
              this.deg = i;
              this.deh = j;
            }
          }
          if (((i & 0xF7) == 17) && ((j & 0xF0) == 32))
          {
            m = 1;
            label377:
            if (m == 0) {
              break label542;
            }
            if ((j & 0x1) != 1) {
              break label469;
            }
            m = 1;
            paramh = this.dea;
            if (m == 0) {
              break label475;
            }
            paramh.den = paramh.del.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.dea.a(new StyleSpan(2), 2);
            this.dea.a(new ForegroundColorSpan(-1), 1);
          }
          for (;;)
          {
            label460:
            break;
            m = 0;
            break label377;
            label469:
            m = 0;
            break label392;
            label475:
            if (paramh.den == -1) {
              break label413;
            }
            paramh.del.setSpan(new UnderlineSpan(), paramh.den, paramh.del.length(), 33);
            paramh.den = -1;
            break label413;
            this.dea.a(new ForegroundColorSpan(ccR[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = ddQ[(i & 0x7)];
              if ((j & 0x20) == 0) {
                break label757;
              }
            }
            label757:
            for (m = 1;; m = 0)
            {
              n = i1;
              if (m != 0) {
                n = i1 + 1;
              }
              if (n != this.dea.row)
              {
                if ((this.ded != 1) && (!this.dea.isEmpty()))
                {
                  this.dea = new a(this.ded, this.dee);
                  this.ddZ.add(this.dea);
                }
                this.dea.row = n;
              }
              if ((j & 0x1) == 1) {
                this.dea.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.dea.a(new StyleSpan(2));
              this.dea.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.dea.a(new ForegroundColorSpan(ccR[m]));
            continue;
            this.dea.cCo = ddR[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.dea.dem = (j - 32);
              break;
            }
            label855:
            if (((i & 0xF7) == 20) && ((j & 0xF0) == 32)) {}
            for (m = 1; m != 0; m = 0) {
              switch (j)
              {
              case 33: 
              case 34: 
              case 35: 
              case 36: 
              case 40: 
              default: 
                if (this.ded == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.dea.TN();
                  break;
                }
                break;
              }
            }
            this.dee = 2;
            io(1);
            continue;
            this.dee = 3;
            io(1);
            continue;
            this.dee = 4;
            io(1);
            continue;
            io(2);
            continue;
            io(3);
            continue;
            this.deb = null;
            if ((this.ded == 1) || (this.ded == 3))
            {
              TK();
              continue;
              TK();
              continue;
              this.deb = TJ();
              TK();
              continue;
              if ((this.ded == 1) && (!this.dea.isEmpty())) {
                this.dea.TO();
              }
            }
          }
        }
        this.dea.h(c(i));
        if ((j & 0xE0) != 0) {
          this.dea.h(c(j));
        }
        k = 1;
      }
    }
    label518:
    label786:
    label805:
    if (k != 0)
    {
      if (m == 0) {
        this.def = false;
      }
      if ((this.ded == 1) || (this.ded == 3)) {
        this.deb = TJ();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.deb = null;
    this.dec = null;
    io(0);
    TK();
    this.dee = 4;
    this.def = false;
    this.deg = 0;
    this.deh = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  static final class a
  {
    int cCo;
    private int ded;
    private int dee;
    private final List<CharacterStyle> dei;
    private final List<a> dej;
    private final List<SpannableString> dek;
    final SpannableStringBuilder del;
    int dem;
    int den;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.dei = new ArrayList();
      this.dej = new ArrayList();
      this.dek = new LinkedList();
      this.del = new SpannableStringBuilder();
      cf(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString TP()
    {
      AppMethodBeat.i(92735);
      int k = this.del.length();
      int i = 0;
      while (i < this.dei.size())
      {
        this.del.setSpan(this.dei.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.dej.size())
      {
        localObject = (a)this.dej.get(i);
        if (i < this.dej.size() - ((a)localObject).dep) {}
        for (int j = ((a)this.dej.get(((a)localObject).dep + i)).start;; j = k)
        {
          this.del.setSpan(((a)localObject).deo, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.den != -1) {
        this.del.setSpan(new UnderlineSpan(), this.den, k, 33);
      }
      Object localObject = new SpannableString(this.del);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void TN()
    {
      AppMethodBeat.i(92730);
      int i = this.del.length();
      if (i > 0) {
        this.del.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void TO()
    {
      AppMethodBeat.i(92731);
      this.dek.add(TP());
      this.del.clear();
      this.dei.clear();
      this.dej.clear();
      this.den = -1;
      int i = Math.min(this.dee, this.row);
      while (this.dek.size() >= i) {
        this.dek.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a TQ()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.dek.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.dek.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(TP());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.cCo + this.dem;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.ded == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.ded != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.ded == 2) && (m > 0))
        {
          f = (32 - k) / 32.0F * 0.8F + 0.1F;
          i = 2;
          break;
        }
        f = i / 32.0F * 0.8F + 0.1F;
        i = 0;
        break;
        label250:
        k = this.row;
        j = 0;
      }
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.dei.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.dej.add(new a(paramCharacterStyle, this.del.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void cf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92728);
      this.dei.clear();
      this.dej.clear();
      this.dek.clear();
      this.del.clear();
      this.row = 15;
      this.cCo = 0;
      this.dem = 0;
      this.ded = paramInt1;
      this.dee = paramInt2;
      this.den = -1;
      AppMethodBeat.o(92728);
    }
    
    public final void h(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.del.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.dei.isEmpty()) && (this.dej.isEmpty()) && (this.dek.isEmpty()) && (this.del.length() == 0))
      {
        AppMethodBeat.o(92729);
        return true;
      }
      AppMethodBeat.o(92729);
      return false;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92737);
      String str = this.del.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    static final class a
    {
      public final CharacterStyle deo;
      public final int dep;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.deo = paramCharacterStyle;
        this.start = paramInt1;
        this.dep = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */