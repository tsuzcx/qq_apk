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
  private static final int[] QI = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] bpX = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] bpY = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] bpZ = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] bqa = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] bqb = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] bqc = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m bqd;
  private final int bqe;
  private final int bqf;
  private final LinkedList<a> bqg;
  private a bqh;
  private List<com.google.android.exoplayer2.f.a> bqi;
  private List<com.google.android.exoplayer2.f.a> bqj;
  private int bqk;
  private int bql;
  private boolean bqm;
  private byte bqn;
  private byte bqo;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(92738);
    this.bqd = new m();
    this.bqg = new LinkedList();
    this.bqh = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.bqe = i;
      switch (paramInt)
      {
      }
    }
    for (this.bqf = 1;; this.bqf = 2)
    {
      eF(0);
      uD();
      AppMethodBeat.o(92738);
      return;
      i = 3;
      break;
    }
  }
  
  private static char a(byte paramByte)
  {
    return (char)bpZ[((paramByte & 0x7F) - 32)];
  }
  
  private void eF(int paramInt)
  {
    AppMethodBeat.i(92743);
    if (this.bqk == paramInt)
    {
      AppMethodBeat.o(92743);
      return;
    }
    int i = this.bqk;
    this.bqk = paramInt;
    uD();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.bqi = null;
    }
    AppMethodBeat.o(92743);
  }
  
  private List<com.google.android.exoplayer2.f.a> uC()
  {
    AppMethodBeat.i(92742);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.bqg.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.bqg.get(i)).uJ();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(92742);
    return localArrayList;
  }
  
  private void uD()
  {
    AppMethodBeat.i(92744);
    this.bqh.reset(this.bqk, this.bql);
    this.bqg.clear();
    this.bqg.add(this.bqh);
    AppMethodBeat.o(92744);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(92741);
    this.bqd.n(paramh.aJg.array(), paramh.aJg.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.bqd.vy() >= this.bqe)
    {
      if (this.bqe == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.bqd.readUnsignedByte())
      {
        i = (byte)(this.bqd.readUnsignedByte() & 0x7F);
        j = (byte)(this.bqd.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.bqf == 1) && ((n & 0x1) != 0)) || ((this.bqf == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.bqh.append((char)bqa[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.bqh.uG();
        if ((i & 0x1) == 0)
        {
          this.bqh.append((char)bqb[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.bqh.append((char)bqc[(j & 0x1F)]);
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
              if ((this.bqm) && (this.bqn == i) && (this.bqo == j))
              {
                this.bqm = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.bqm = true;
              this.bqn = i;
              this.bqo = j;
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
            paramh = this.bqh;
            if (m == 0) {
              break label475;
            }
            paramh.bqu = paramh.bqs.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.bqh.a(new StyleSpan(2), 2);
            this.bqh.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.bqu == -1) {
              break label413;
            }
            paramh.bqs.setSpan(new UnderlineSpan(), paramh.bqu, paramh.bqs.length(), 33);
            paramh.bqu = -1;
            break label413;
            this.bqh.a(new ForegroundColorSpan(QI[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = bpX[(i & 0x7)];
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
              if (n != this.bqh.row)
              {
                if ((this.bqk != 1) && (!this.bqh.isEmpty()))
                {
                  this.bqh = new a(this.bqk, this.bql);
                  this.bqg.add(this.bqh);
                }
                this.bqh.row = n;
              }
              if ((j & 0x1) == 1) {
                this.bqh.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.bqh.a(new StyleSpan(2));
              this.bqh.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.bqh.a(new ForegroundColorSpan(QI[m]));
            continue;
            this.bqh.aPS = bpY[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.bqh.bqt = (j - 32);
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
                if (this.bqk == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.bqh.uG();
                  break;
                }
                break;
              }
            }
            this.bql = 2;
            eF(1);
            continue;
            this.bql = 3;
            eF(1);
            continue;
            this.bql = 4;
            eF(1);
            continue;
            eF(2);
            continue;
            eF(3);
            continue;
            this.bqi = null;
            if ((this.bqk == 1) || (this.bqk == 3))
            {
              uD();
              continue;
              uD();
              continue;
              this.bqi = uC();
              uD();
              continue;
              if ((this.bqk == 1) && (!this.bqh.isEmpty())) {
                this.bqh.uH();
              }
            }
          }
        }
        this.bqh.append(a(i));
        if ((j & 0xE0) != 0) {
          this.bqh.append(a(j));
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
        this.bqm = false;
      }
      if ((this.bqk == 1) || (this.bqk == 3)) {
        this.bqi = uC();
      }
    }
    AppMethodBeat.o(92741);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(92739);
    super.flush();
    this.bqi = null;
    this.bqj = null;
    eF(0);
    uD();
    this.bql = 4;
    this.bqm = false;
    this.bqn = 0;
    this.bqo = 0;
    AppMethodBeat.o(92739);
  }
  
  public final void release() {}
  
  protected final boolean uA()
  {
    return this.bqi != this.bqj;
  }
  
  protected final com.google.android.exoplayer2.f.d uB()
  {
    AppMethodBeat.i(92740);
    this.bqj = this.bqi;
    f localf = new f(this.bqi);
    AppMethodBeat.o(92740);
    return localf;
  }
  
  static final class a
  {
    int aPS;
    private int bqk;
    private int bql;
    private final List<CharacterStyle> bqp;
    private final List<a> bqq;
    private final List<SpannableString> bqr;
    final SpannableStringBuilder bqs;
    int bqt;
    int bqu;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(92727);
      this.bqp = new ArrayList();
      this.bqq = new ArrayList();
      this.bqr = new LinkedList();
      this.bqs = new SpannableStringBuilder();
      reset(paramInt1, paramInt2);
      AppMethodBeat.o(92727);
    }
    
    private SpannableString uI()
    {
      AppMethodBeat.i(92735);
      int k = this.bqs.length();
      int i = 0;
      while (i < this.bqp.size())
      {
        this.bqs.setSpan(this.bqp.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.bqq.size())
      {
        localObject = (a)this.bqq.get(i);
        if (i < this.bqq.size() - ((a)localObject).bqw) {}
        for (int j = ((a)this.bqq.get(((a)localObject).bqw + i)).start;; j = k)
        {
          this.bqs.setSpan(((a)localObject).bqv, ((a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.bqu != -1) {
        this.bqs.setSpan(new UnderlineSpan(), this.bqu, k, 33);
      }
      Object localObject = new SpannableString(this.bqs);
      AppMethodBeat.o(92735);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(92732);
      this.bqp.add(paramCharacterStyle);
      AppMethodBeat.o(92732);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(92733);
      this.bqq.add(new a(paramCharacterStyle, this.bqs.length(), paramInt));
      AppMethodBeat.o(92733);
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(92734);
      this.bqs.append(paramChar);
      AppMethodBeat.o(92734);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(92729);
      if ((this.bqp.isEmpty()) && (this.bqq.isEmpty()) && (this.bqr.isEmpty()) && (this.bqs.length() == 0))
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
      this.bqp.clear();
      this.bqq.clear();
      this.bqr.clear();
      this.bqs.clear();
      this.row = 15;
      this.aPS = 0;
      this.bqt = 0;
      this.bqk = paramInt1;
      this.bql = paramInt2;
      this.bqu = -1;
      AppMethodBeat.o(92728);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92737);
      String str = this.bqs.toString();
      AppMethodBeat.o(92737);
      return str;
    }
    
    public final void uG()
    {
      AppMethodBeat.i(92730);
      int i = this.bqs.length();
      if (i > 0) {
        this.bqs.delete(i - 1, i);
      }
      AppMethodBeat.o(92730);
    }
    
    public final void uH()
    {
      AppMethodBeat.i(92731);
      this.bqr.add(uI());
      this.bqs.clear();
      this.bqp.clear();
      this.bqq.clear();
      this.bqu = -1;
      int i = Math.min(this.bql, this.row);
      while (this.bqr.size() >= i) {
        this.bqr.remove(0);
      }
      AppMethodBeat.o(92731);
    }
    
    public final com.google.android.exoplayer2.f.a uJ()
    {
      int j = 2;
      AppMethodBeat.i(92736);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.bqr.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.bqr.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(uI());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(92736);
        return null;
      }
      i = this.aPS + this.bqt;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.bqk == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.bqk != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(92736);
        return localObject;
        if ((this.bqk == 2) && (m > 0))
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
      public final CharacterStyle bqv;
      public final int bqw;
      public final int start;
      
      public a(CharacterStyle paramCharacterStyle, int paramInt1, int paramInt2)
      {
        this.bqv = paramCharacterStyle;
        this.start = paramInt1;
        this.bqw = paramInt2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */