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
  private static final int[] aoh = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] bjW = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] bjX = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] bjY = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] bjZ = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] bka = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] bkb = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m bkc;
  private final int bkd;
  private final int bke;
  private final LinkedList<a> bkf;
  private a bkg;
  private List<com.google.android.exoplayer2.f.a> bkh;
  private List<com.google.android.exoplayer2.f.a> bki;
  private int bkj;
  private int bkk;
  private boolean bkl;
  private byte bkm;
  private byte bkn;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.bkc = new m();
    this.bkf = new LinkedList();
    this.bkg = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.bkd = i;
      switch (paramInt)
      {
      }
    }
    for (this.bke = 1;; this.bke = 2)
    {
      eY(0);
      uh();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private static char b(byte paramByte)
  {
    return (char)bjY[((paramByte & 0x7F) - 32)];
  }
  
  private void eY(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.bkj == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.bkj;
    this.bkj = paramInt;
    uh();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.bkh = null;
    }
    AppMethodBeat.o(92743);
  }
  
  private List<com.google.android.exoplayer2.f.a> ug()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.bkf.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.bkf.get(i)).un();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void uh()
  {
    AppMethodBeat.i(92744);
    this.bkg.bk(this.bkj, this.bkk);
    this.bkf.clear();
    this.bkf.add(this.bkg);
    AppMethodBeat.o(92744);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.bkc.n(paramh.aQU.array(), paramh.aQU.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.bkc.vg() >= this.bkd)
    {
      if (this.bkd == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.bkc.readUnsignedByte())
      {
        i = (byte)(this.bkc.readUnsignedByte() & 0x7F);
        j = (byte)(this.bkc.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.bke == 1) && ((n & 0x1) != 0)) || ((this.bke == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.bkg.g((char)bjZ[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.bkg.uk();
        if ((i & 0x1) == 0)
        {
          this.bkg.g((char)bka[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.bkg.g((char)bkb[(j & 0x1F)]);
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
              if ((this.bkl) && (this.bkm == i) && (this.bkn == j))
              {
                this.bkl = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.bkl = true;
              this.bkm = i;
              this.bkn = j;
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
            paramh = this.bkg;
            if (m == 0) {
              break label475;
            }
            paramh.bkt = paramh.bkr.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.bkg.a(new StyleSpan(2), 2);
            this.bkg.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.bkt == -1) {
              break label413;
            }
            paramh.bkr.setSpan(new UnderlineSpan(), paramh.bkt, paramh.bkr.length(), 33);
            paramh.bkt = -1;
            break label413;
            this.bkg.a(new ForegroundColorSpan(aoh[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = bjW[(i & 0x7)];
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
              if (n != this.bkg.row)
              {
                if ((this.bkj != 1) && (!this.bkg.isEmpty()))
                {
                  this.bkg = new a(this.bkj, this.bkk);
                  this.bkf.add(this.bkg);
                }
                this.bkg.row = n;
              }
              if ((j & 0x1) == 1) {
                this.bkg.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.bkg.a(new StyleSpan(2));
              this.bkg.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.bkg.a(new ForegroundColorSpan(aoh[m]));
            continue;
            this.bkg.aJE = bjX[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.bkg.bks = (j - 32);
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
                if (this.bkj == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.bkg.uk();
                  break;
                }
                break;
              }
            }
            this.bkk = 2;
            eY(1);
            continue;
            this.bkk = 3;
            eY(1);
            continue;
            this.bkk = 4;
            eY(1);
            continue;
            eY(2);
            continue;
            eY(3);
            continue;
            this.bkh = null;
            if ((this.bkj == 1) || (this.bkj == 3))
            {
              uh();
              continue;
              uh();
              continue;
              this.bkh = ug();
              uh();
              continue;
              if ((this.bkj == 1) && (!this.bkg.isEmpty())) {
                this.bkg.ul();
              }
            }
          }
        }
        this.bkg.g(b(i));
        if ((j & 0xE0) != 0) {
          this.bkg.g(b(j));
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
        this.bkl = false;
      }
      if ((this.bkj == 1) || (this.bkj == 3)) {
        this.bkh = ug();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.bkh = null;
    this.bki = null;
    eY(0);
    uh();
    this.bkk = 4;
    this.bkl = false;
    this.bkm = 0;
    this.bkn = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  protected final boolean ue()
  {
    return this.bkh != this.bki;
  }
  
  protected final com.google.android.exoplayer2.f.d uf()
  {
    AppMethodBeat.i(92740);
    this.bki = this.bkh;
    f localf = new f(this.bkh);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  static final class a
  {
    int aJE;
    private int bkj;
    private int bkk;
    private final List<CharacterStyle> bko;
    private final List<a> bkp;
    private final List<SpannableString> bkq;
    final SpannableStringBuilder bkr;
    int bks;
    int bkt;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.bko = new ArrayList();
      this.bkp = new ArrayList();
      this.bkq = new LinkedList();
      this.bkr = new SpannableStringBuilder();
      bk(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString um()
    {
      AppMethodBeat.i(92735);
      int k = this.bkr.length();
      int i = 0;
      while (i < this.bko.size())
      {
        this.bkr.setSpan(this.bko.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.bkp.size())
      {
        localObject = (a)this.bkp.get(i);
        if (i < this.bkp.size() - ((a)localObject).bkv) {}
        for (int j = ((a)this.bkp.get(((a)localObject).bkv + i)).start;; j = k)
        {
          this.bkr.setSpan(((a)localObject).bku, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.bkt != -1) {
        this.bkr.setSpan(new UnderlineSpan(), this.bkt, k, 33);
      }
      Object localObject = new SpannableString(this.bkr);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.bko.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.bkp.add(new a(paramCharacterStyle, this.bkr.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void bk(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92728);
      this.bko.clear();
      this.bkp.clear();
      this.bkq.clear();
      this.bkr.clear();
      this.row = 15;
      this.aJE = 0;
      this.bks = 0;
      this.bkj = paramInt1;
      this.bkk = paramInt2;
      this.bkt = -1;
      AppMethodBeat.o(92728);
    }
    
    public final void g(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.bkr.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.bko.isEmpty()) && (this.bkp.isEmpty()) && (this.bkq.isEmpty()) && (this.bkr.length() == 0))
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
      String str = this.bkr.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    public final void uk()
    {
      AppMethodBeat.i(92730);
      int i = this.bkr.length();
      if (i > 0) {
        this.bkr.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void ul()
    {
      AppMethodBeat.i(92731);
      this.bkq.add(um());
      this.bkr.clear();
      this.bko.clear();
      this.bkp.clear();
      this.bkt = -1;
      int i = Math.min(this.bkk, this.row);
      while (this.bkq.size() >= i) {
        this.bkq.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a un()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bkq.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.bkq.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(um());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.aJE + this.bks;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.bkj == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.bkj != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.bkj == 2) && (m > 0))
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
      public final CharacterStyle bku;
      public final int bkv;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.bku = paramCharacterStyle;
        this.start = paramInt1;
        this.bkv = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */