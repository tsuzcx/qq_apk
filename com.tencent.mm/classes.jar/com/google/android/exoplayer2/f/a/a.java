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
  private static final int[] Sx = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] bAs = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] bAt = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] bAu = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] bAv = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] bAw = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] bAx = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final int bAA;
  private final LinkedList<a> bAB;
  private a bAC;
  private List<com.google.android.exoplayer2.f.a> bAD;
  private List<com.google.android.exoplayer2.f.a> bAE;
  private int bAF;
  private int bAG;
  private boolean bAH;
  private byte bAI;
  private byte bAJ;
  private final m bAy;
  private final int bAz;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.bAy = new m();
    this.bAB = new LinkedList();
    this.bAC = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.bAz = i;
      switch (paramInt)
      {
      }
    }
    for (this.bAA = 1;; this.bAA = 2)
    {
      eJ(0);
      wc();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private static char b(byte paramByte)
  {
    return (char)bAu[((paramByte & 0x7F) - 32)];
  }
  
  private void eJ(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.bAF == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.bAF;
    this.bAF = paramInt;
    wc();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.bAD = null;
    }
    AppMethodBeat.o(92743);
  }
  
  private List<com.google.android.exoplayer2.f.a> wb()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.bAB.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.bAB.get(i)).wi();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void wc()
  {
    AppMethodBeat.i(92744);
    this.bAC.reset(this.bAF, this.bAG);
    this.bAB.clear();
    this.bAB.add(this.bAC);
    AppMethodBeat.o(92744);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.bAy.n(paramh.aKX.array(), paramh.aKX.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.bAy.wV() >= this.bAz)
    {
      if (this.bAz == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.bAy.readUnsignedByte())
      {
        i = (byte)(this.bAy.readUnsignedByte() & 0x7F);
        j = (byte)(this.bAy.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.bAA == 1) && ((n & 0x1) != 0)) || ((this.bAA == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.bAC.append((char)bAv[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.bAC.wf();
        if ((i & 0x1) == 0)
        {
          this.bAC.append((char)bAw[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.bAC.append((char)bAx[(j & 0x1F)]);
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
              if ((this.bAH) && (this.bAI == i) && (this.bAJ == j))
              {
                this.bAH = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.bAH = true;
              this.bAI = i;
              this.bAJ = j;
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
            paramh = this.bAC;
            if (m == 0) {
              break label475;
            }
            paramh.bAP = paramh.bAN.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.bAC.a(new StyleSpan(2), 2);
            this.bAC.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.bAP == -1) {
              break label413;
            }
            paramh.bAN.setSpan(new UnderlineSpan(), paramh.bAP, paramh.bAN.length(), 33);
            paramh.bAP = -1;
            break label413;
            this.bAC.a(new ForegroundColorSpan(Sx[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = bAs[(i & 0x7)];
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
              if (n != this.bAC.row)
              {
                if ((this.bAF != 1) && (!this.bAC.isEmpty()))
                {
                  this.bAC = new a(this.bAF, this.bAG);
                  this.bAB.add(this.bAC);
                }
                this.bAC.row = n;
              }
              if ((j & 0x1) == 1) {
                this.bAC.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.bAC.a(new StyleSpan(2));
              this.bAC.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.bAC.a(new ForegroundColorSpan(Sx[m]));
            continue;
            this.bAC.bam = bAt[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.bAC.bAO = (j - 32);
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
                if (this.bAF == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.bAC.wf();
                  break;
                }
                break;
              }
            }
            this.bAG = 2;
            eJ(1);
            continue;
            this.bAG = 3;
            eJ(1);
            continue;
            this.bAG = 4;
            eJ(1);
            continue;
            eJ(2);
            continue;
            eJ(3);
            continue;
            this.bAD = null;
            if ((this.bAF == 1) || (this.bAF == 3))
            {
              wc();
              continue;
              wc();
              continue;
              this.bAD = wb();
              wc();
              continue;
              if ((this.bAF == 1) && (!this.bAC.isEmpty())) {
                this.bAC.wg();
              }
            }
          }
        }
        this.bAC.append(b(i));
        if ((j & 0xE0) != 0) {
          this.bAC.append(b(j));
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
        this.bAH = false;
      }
      if ((this.bAF == 1) || (this.bAF == 3)) {
        this.bAD = wb();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.bAD = null;
    this.bAE = null;
    eJ(0);
    wc();
    this.bAG = 4;
    this.bAH = false;
    this.bAI = 0;
    this.bAJ = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  protected final boolean vZ()
  {
    return this.bAD != this.bAE;
  }
  
  protected final com.google.android.exoplayer2.f.d wa()
  {
    AppMethodBeat.i(92740);
    this.bAE = this.bAD;
    f localf = new f(this.bAD);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  static final class a
  {
    private int bAF;
    private int bAG;
    private final List<CharacterStyle> bAK;
    private final List<a> bAL;
    private final List<SpannableString> bAM;
    final SpannableStringBuilder bAN;
    int bAO;
    int bAP;
    int bam;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.bAK = new ArrayList();
      this.bAL = new ArrayList();
      this.bAM = new LinkedList();
      this.bAN = new SpannableStringBuilder();
      reset(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString wh()
    {
      AppMethodBeat.i(92735);
      int k = this.bAN.length();
      int i = 0;
      while (i < this.bAK.size())
      {
        this.bAN.setSpan(this.bAK.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.bAL.size())
      {
        localObject = (a)this.bAL.get(i);
        if (i < this.bAL.size() - ((a)localObject).bAR) {}
        for (int j = ((a)this.bAL.get(((a)localObject).bAR + i)).start;; j = k)
        {
          this.bAN.setSpan(((a)localObject).bAQ, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.bAP != -1) {
        this.bAN.setSpan(new UnderlineSpan(), this.bAP, k, 33);
      }
      Object localObject = new SpannableString(this.bAN);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.bAK.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.bAL.add(new a(paramCharacterStyle, this.bAN.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.bAN.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.bAK.isEmpty()) && (this.bAL.isEmpty()) && (this.bAM.isEmpty()) && (this.bAN.length() == 0))
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
      this.bAK.clear();
      this.bAL.clear();
      this.bAM.clear();
      this.bAN.clear();
      this.row = 15;
      this.bam = 0;
      this.bAO = 0;
      this.bAF = paramInt1;
      this.bAG = paramInt2;
      this.bAP = -1;
      AppMethodBeat.o(92728);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92737);
      String str = this.bAN.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    public final void wf()
    {
      AppMethodBeat.i(92730);
      int i = this.bAN.length();
      if (i > 0) {
        this.bAN.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void wg()
    {
      AppMethodBeat.i(92731);
      this.bAM.add(wh());
      this.bAN.clear();
      this.bAK.clear();
      this.bAL.clear();
      this.bAP = -1;
      int i = Math.min(this.bAG, this.row);
      while (this.bAM.size() >= i) {
        this.bAM.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a wi()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bAM.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.bAM.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(wh());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.bam + this.bAO;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.bAF == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.bAF != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.bAF == 2) && (m > 0))
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
      public final CharacterStyle bAQ;
      public final int bAR;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.bAQ = paramCharacterStyle;
        this.start = paramInt1;
        this.bAR = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */