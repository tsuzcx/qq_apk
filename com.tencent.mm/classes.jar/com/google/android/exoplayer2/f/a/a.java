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
  private static final int[] SK = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] bAu = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] bAv = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] bAw = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] bAx = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] bAy = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] bAz = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m bAA;
  private final int bAB;
  private final int bAC;
  private final LinkedList<a> bAD;
  private a bAE;
  private List<com.google.android.exoplayer2.f.a> bAF;
  private List<com.google.android.exoplayer2.f.a> bAG;
  private int bAH;
  private int bAI;
  private boolean bAJ;
  private byte bAK;
  private byte bAL;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.bAA = new m();
    this.bAD = new LinkedList();
    this.bAE = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.bAB = i;
      switch (paramInt)
      {
      }
    }
    for (this.bAC = 1;; this.bAC = 2)
    {
      eI(0);
      wh();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private static char b(byte paramByte)
  {
    return (char)bAw[((paramByte & 0x7F) - 32)];
  }
  
  private void eI(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.bAH == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.bAH;
    this.bAH = paramInt;
    wh();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.bAF = null;
    }
    AppMethodBeat.o(92743);
  }
  
  private List<com.google.android.exoplayer2.f.a> wg()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.bAD.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.bAD.get(i)).wn();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void wh()
  {
    AppMethodBeat.i(92744);
    this.bAE.reset(this.bAH, this.bAI);
    this.bAD.clear();
    this.bAD.add(this.bAE);
    AppMethodBeat.o(92744);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.bAA.n(paramh.aKP.array(), paramh.aKP.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.bAA.xd() >= this.bAB)
    {
      if (this.bAB == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.bAA.readUnsignedByte())
      {
        i = (byte)(this.bAA.readUnsignedByte() & 0x7F);
        j = (byte)(this.bAA.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.bAC == 1) && ((n & 0x1) != 0)) || ((this.bAC == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.bAE.append((char)bAx[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.bAE.wk();
        if ((i & 0x1) == 0)
        {
          this.bAE.append((char)bAy[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.bAE.append((char)bAz[(j & 0x1F)]);
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
              if ((this.bAJ) && (this.bAK == i) && (this.bAL == j))
              {
                this.bAJ = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.bAJ = true;
              this.bAK = i;
              this.bAL = j;
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
            paramh = this.bAE;
            if (m == 0) {
              break label475;
            }
            paramh.bAR = paramh.bAP.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.bAE.a(new StyleSpan(2), 2);
            this.bAE.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.bAR == -1) {
              break label413;
            }
            paramh.bAP.setSpan(new UnderlineSpan(), paramh.bAR, paramh.bAP.length(), 33);
            paramh.bAR = -1;
            break label413;
            this.bAE.a(new ForegroundColorSpan(SK[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = bAu[(i & 0x7)];
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
              if (n != this.bAE.row)
              {
                if ((this.bAH != 1) && (!this.bAE.isEmpty()))
                {
                  this.bAE = new a(this.bAH, this.bAI);
                  this.bAD.add(this.bAE);
                }
                this.bAE.row = n;
              }
              if ((j & 0x1) == 1) {
                this.bAE.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.bAE.a(new StyleSpan(2));
              this.bAE.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.bAE.a(new ForegroundColorSpan(SK[m]));
            continue;
            this.bAE.bai = bAv[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.bAE.bAQ = (j - 32);
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
                if (this.bAH == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.bAE.wk();
                  break;
                }
                break;
              }
            }
            this.bAI = 2;
            eI(1);
            continue;
            this.bAI = 3;
            eI(1);
            continue;
            this.bAI = 4;
            eI(1);
            continue;
            eI(2);
            continue;
            eI(3);
            continue;
            this.bAF = null;
            if ((this.bAH == 1) || (this.bAH == 3))
            {
              wh();
              continue;
              wh();
              continue;
              this.bAF = wg();
              wh();
              continue;
              if ((this.bAH == 1) && (!this.bAE.isEmpty())) {
                this.bAE.wl();
              }
            }
          }
        }
        this.bAE.append(b(i));
        if ((j & 0xE0) != 0) {
          this.bAE.append(b(j));
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
        this.bAJ = false;
      }
      if ((this.bAH == 1) || (this.bAH == 3)) {
        this.bAF = wg();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.bAF = null;
    this.bAG = null;
    eI(0);
    wh();
    this.bAI = 4;
    this.bAJ = false;
    this.bAK = 0;
    this.bAL = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  protected final boolean we()
  {
    return this.bAF != this.bAG;
  }
  
  protected final com.google.android.exoplayer2.f.d wf()
  {
    AppMethodBeat.i(92740);
    this.bAG = this.bAF;
    f localf = new f(this.bAF);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  static final class a
  {
    private int bAH;
    private int bAI;
    private final List<CharacterStyle> bAM;
    private final List<a> bAN;
    private final List<SpannableString> bAO;
    final SpannableStringBuilder bAP;
    int bAQ;
    int bAR;
    int bai;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.bAM = new ArrayList();
      this.bAN = new ArrayList();
      this.bAO = new LinkedList();
      this.bAP = new SpannableStringBuilder();
      reset(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString wm()
    {
      AppMethodBeat.i(92735);
      int k = this.bAP.length();
      int i = 0;
      while (i < this.bAM.size())
      {
        this.bAP.setSpan(this.bAM.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.bAN.size())
      {
        localObject = (a)this.bAN.get(i);
        if (i < this.bAN.size() - ((a)localObject).bAT) {}
        for (int j = ((a)this.bAN.get(((a)localObject).bAT + i)).start;; j = k)
        {
          this.bAP.setSpan(((a)localObject).bAS, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.bAR != -1) {
        this.bAP.setSpan(new UnderlineSpan(), this.bAR, k, 33);
      }
      Object localObject = new SpannableString(this.bAP);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.bAM.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.bAN.add(new a(paramCharacterStyle, this.bAP.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.bAP.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.bAM.isEmpty()) && (this.bAN.isEmpty()) && (this.bAO.isEmpty()) && (this.bAP.length() == 0))
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
      this.bAM.clear();
      this.bAN.clear();
      this.bAO.clear();
      this.bAP.clear();
      this.row = 15;
      this.bai = 0;
      this.bAQ = 0;
      this.bAH = paramInt1;
      this.bAI = paramInt2;
      this.bAR = -1;
      AppMethodBeat.o(92728);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92737);
      String str = this.bAP.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    public final void wk()
    {
      AppMethodBeat.i(92730);
      int i = this.bAP.length();
      if (i > 0) {
        this.bAP.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void wl()
    {
      AppMethodBeat.i(92731);
      this.bAO.add(wm());
      this.bAP.clear();
      this.bAM.clear();
      this.bAN.clear();
      this.bAR = -1;
      int i = Math.min(this.bAI, this.row);
      while (this.bAO.size() >= i) {
        this.bAO.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a wn()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bAO.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.bAO.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(wm());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.bai + this.bAQ;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.bAH == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.bAH != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.bAH == 2) && (m > 0))
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
      public final CharacterStyle bAS;
      public final int bAT;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.bAS = paramCharacterStyle;
        this.start = paramInt1;
        this.bAT = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */