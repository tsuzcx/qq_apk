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
  private static final int[] PN = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] brY = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] brZ = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] bsa = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] bsb = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] bsc = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] bsd = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m bse;
  private final int bsf;
  private final int bsg;
  private final LinkedList<a> bsh;
  private a bsi;
  private List<com.google.android.exoplayer2.f.a> bsj;
  private List<com.google.android.exoplayer2.f.a> bsk;
  private int bsl;
  private int bsm;
  private boolean bsn;
  private byte bso;
  private byte bsp;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.bse = new m();
    this.bsh = new LinkedList();
    this.bsi = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.bsf = i;
      switch (paramInt)
      {
      }
    }
    for (this.bsg = 1;; this.bsg = 2)
    {
      eS(0);
      uJ();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private static char a(byte paramByte)
  {
    return (char)bsa[((paramByte & 0x7F) - 32)];
  }
  
  private void eS(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.bsl == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.bsl;
    this.bsl = paramInt;
    uJ();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.bsj = null;
    }
    AppMethodBeat.o(92743);
  }
  
  private List<com.google.android.exoplayer2.f.a> uI()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.bsh.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.bsh.get(i)).uP();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void uJ()
  {
    AppMethodBeat.i(92744);
    this.bsi.reset(this.bsl, this.bsm);
    this.bsh.clear();
    this.bsh.add(this.bsi);
    AppMethodBeat.o(92744);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.bse.q(paramh.aIq.array(), paramh.aIq.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.bse.vJ() >= this.bsf)
    {
      if (this.bsf == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.bse.readUnsignedByte())
      {
        i = (byte)(this.bse.readUnsignedByte() & 0x7F);
        j = (byte)(this.bse.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.bsg == 1) && ((n & 0x1) != 0)) || ((this.bsg == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.bsi.append((char)bsb[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.bsi.uM();
        if ((i & 0x1) == 0)
        {
          this.bsi.append((char)bsc[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.bsi.append((char)bsd[(j & 0x1F)]);
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
              if ((this.bsn) && (this.bso == i) && (this.bsp == j))
              {
                this.bsn = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.bsn = true;
              this.bso = i;
              this.bsp = j;
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
            paramh = this.bsi;
            if (m == 0) {
              break label475;
            }
            paramh.bsv = paramh.bst.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.bsi.a(new StyleSpan(2), 2);
            this.bsi.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.bsv == -1) {
              break label413;
            }
            paramh.bst.setSpan(new UnderlineSpan(), paramh.bsv, paramh.bst.length(), 33);
            paramh.bsv = -1;
            break label413;
            this.bsi.a(new ForegroundColorSpan(PN[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = brY[(i & 0x7)];
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
              if (n != this.bsi.row)
              {
                if ((this.bsl != 1) && (!this.bsi.isEmpty()))
                {
                  this.bsi = new a(this.bsl, this.bsm);
                  this.bsh.add(this.bsi);
                }
                this.bsi.row = n;
              }
              if ((j & 0x1) == 1) {
                this.bsi.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.bsi.a(new StyleSpan(2));
              this.bsi.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.bsi.a(new ForegroundColorSpan(PN[m]));
            continue;
            this.bsi.aPc = brZ[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.bsi.bsu = (j - 32);
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
                if (this.bsl == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.bsi.uM();
                  break;
                }
                break;
              }
            }
            this.bsm = 2;
            eS(1);
            continue;
            this.bsm = 3;
            eS(1);
            continue;
            this.bsm = 4;
            eS(1);
            continue;
            eS(2);
            continue;
            eS(3);
            continue;
            this.bsj = null;
            if ((this.bsl == 1) || (this.bsl == 3))
            {
              uJ();
              continue;
              uJ();
              continue;
              this.bsj = uI();
              uJ();
              continue;
              if ((this.bsl == 1) && (!this.bsi.isEmpty())) {
                this.bsi.uN();
              }
            }
          }
        }
        this.bsi.append(a(i));
        if ((j & 0xE0) != 0) {
          this.bsi.append(a(j));
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
        this.bsn = false;
      }
      if ((this.bsl == 1) || (this.bsl == 3)) {
        this.bsj = uI();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.bsj = null;
    this.bsk = null;
    eS(0);
    uJ();
    this.bsm = 4;
    this.bsn = false;
    this.bso = 0;
    this.bsp = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  protected final boolean uG()
  {
    return this.bsj != this.bsk;
  }
  
  protected final com.google.android.exoplayer2.f.d uH()
  {
    AppMethodBeat.i(92740);
    this.bsk = this.bsj;
    f localf = new f(this.bsj);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  static final class a
  {
    int aPc;
    private int bsl;
    private int bsm;
    private final List<CharacterStyle> bsq;
    private final List<a> bsr;
    private final List<SpannableString> bss;
    final SpannableStringBuilder bst;
    int bsu;
    int bsv;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.bsq = new ArrayList();
      this.bsr = new ArrayList();
      this.bss = new LinkedList();
      this.bst = new SpannableStringBuilder();
      reset(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString uO()
    {
      AppMethodBeat.i(92735);
      int k = this.bst.length();
      int i = 0;
      while (i < this.bsq.size())
      {
        this.bst.setSpan(this.bsq.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.bsr.size())
      {
        localObject = (a)this.bsr.get(i);
        if (i < this.bsr.size() - ((a)localObject).bsx) {}
        for (int j = ((a)this.bsr.get(((a)localObject).bsx + i)).start;; j = k)
        {
          this.bst.setSpan(((a)localObject).bsw, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.bsv != -1) {
        this.bst.setSpan(new UnderlineSpan(), this.bsv, k, 33);
      }
      Object localObject = new SpannableString(this.bst);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.bsq.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.bsr.add(new a(paramCharacterStyle, this.bst.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.bst.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.bsq.isEmpty()) && (this.bsr.isEmpty()) && (this.bss.isEmpty()) && (this.bst.length() == 0))
      {
        AppMethodBeat.o(92729);
        return true;
      }
      AppMethodBeat.o(92729);
      return false;
    }
    
    public final void reset(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92728);
      this.bsq.clear();
      this.bsr.clear();
      this.bss.clear();
      this.bst.clear();
      this.row = 15;
      this.aPc = 0;
      this.bsu = 0;
      this.bsl = paramInt1;
      this.bsm = paramInt2;
      this.bsv = -1;
      AppMethodBeat.o(92728);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92737);
      String str = this.bst.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    public final void uM()
    {
      AppMethodBeat.i(92730);
      int i = this.bst.length();
      if (i > 0) {
        this.bst.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void uN()
    {
      AppMethodBeat.i(92731);
      this.bss.add(uO());
      this.bst.clear();
      this.bsq.clear();
      this.bsr.clear();
      this.bsv = -1;
      int i = Math.min(this.bsm, this.row);
      while (this.bss.size() >= i) {
        this.bss.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a uP()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bss.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.bss.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(uO());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.aPc + this.bsu;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.bsl == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.bsl != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.bsl == 2) && (m > 0))
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
    
    static final class a
    {
      public final CharacterStyle bsw;
      public final int bsx;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.bsw = paramCharacterStyle;
        this.start = paramInt1;
        this.bsx = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */