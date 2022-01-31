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
  private static final int[] IN = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] aTV = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] aTW = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] aTX = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] aTY = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] aTZ = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] aUa = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final m aUb;
  private final int aUc;
  private final int aUd;
  private final LinkedList<a> aUe;
  private a aUf;
  private List<com.google.android.exoplayer2.f.a> aUg;
  private List<com.google.android.exoplayer2.f.a> aUh;
  private int aUi;
  private int aUj;
  private boolean aUk;
  private byte aUl;
  private byte aUm;
  
  public a(String paramString, int paramInt)
  {
    AppMethodBeat.i(95570);
    this.aUb = new m();
    this.aUe = new LinkedList();
    this.aUf = new a(0, 4);
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.aUc = i;
      switch (paramInt)
      {
      }
    }
    for (this.aUd = 1;; this.aUd = 2)
    {
      dU(0);
      pP();
      AppMethodBeat.o(95570);
      return;
      i = 3;
      break;
    }
  }
  
  private static char b(byte paramByte)
  {
    return (char)aTX[((paramByte & 0x7F) - 32)];
  }
  
  private void dU(int paramInt)
  {
    AppMethodBeat.i(95575);
    if (this.aUi == paramInt)
    {
      AppMethodBeat.o(95575);
      return;
    }
    int i = this.aUi;
    this.aUi = paramInt;
    pP();
    if ((i == 3) || (paramInt == 1) || (paramInt == 0)) {
      this.aUg = null;
    }
    AppMethodBeat.o(95575);
  }
  
  private List<com.google.android.exoplayer2.f.a> pO()
  {
    AppMethodBeat.i(95574);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aUe.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a)this.aUe.get(i)).pV();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(95574);
    return localArrayList;
  }
  
  private void pP()
  {
    AppMethodBeat.i(95576);
    this.aUf.reset(this.aUi, this.aUj);
    this.aUe.clear();
    this.aUe.add(this.aUf);
    AppMethodBeat.o(95576);
  }
  
  protected final void a(h paramh)
  {
    AppMethodBeat.i(95573);
    this.aUb.l(paramh.aAS.array(), paramh.aAS.limit());
    int m = 0;
    int k = 0;
    label392:
    label413:
    label542:
    label565:
    while (this.aUb.qM() >= this.aUc)
    {
      if (this.aUc == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.aUb.readUnsignedByte())
      {
        i = (byte)(this.aUb.readUnsignedByte() & 0x7F);
        j = (byte)(this.aUb.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.aUd == 1) && ((n & 0x1) != 0)) || ((this.aUd == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label185;
        }
        this.aUf.append((char)aTY[(j & 0xF)]);
        k = 1;
        break;
      }
      label185:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.aUf.pS();
        if ((i & 0x1) == 0)
        {
          this.aUf.append((char)aTZ[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.aUf.append((char)aUa[(j & 0x1F)]);
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
              if ((this.aUk) && (this.aUl == i) && (this.aUm == j))
              {
                this.aUk = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.aUk = true;
              this.aUl = i;
              this.aUm = j;
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
            paramh = this.aUf;
            if (m == 0) {
              break label475;
            }
            paramh.aUs = paramh.aUq.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label518;
            }
            this.aUf.a(new StyleSpan(2), 2);
            this.aUf.a(new ForegroundColorSpan(-1), 1);
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
            if (paramh.aUs == -1) {
              break label413;
            }
            paramh.aUq.setSpan(new UnderlineSpan(), paramh.aUs, paramh.aUq.length(), 33);
            paramh.aUs = -1;
            break label413;
            this.aUf.a(new ForegroundColorSpan(IN[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label805;
              }
              i1 = aTV[(i & 0x7)];
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
              if (n != this.aUf.row)
              {
                if ((this.aUi != 1) && (!this.aUf.isEmpty()))
                {
                  this.aUf = new a(this.aUi, this.aUj);
                  this.aUe.add(this.aUf);
                }
                this.aUf.row = n;
              }
              if ((j & 0x1) == 1) {
                this.aUf.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label786;
              }
              if (m != 7) {
                break label763;
              }
              this.aUf.a(new StyleSpan(2));
              this.aUf.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label565;
            }
            label763:
            this.aUf.a(new ForegroundColorSpan(IN[m]));
            continue;
            this.aUf.aur = aTW[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label855;
              }
              this.aUf.aUr = (j - 32);
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
                if (this.aUi == 0) {
                  break label460;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.aUf.pS();
                  break;
                }
                break;
              }
            }
            this.aUj = 2;
            dU(1);
            continue;
            this.aUj = 3;
            dU(1);
            continue;
            this.aUj = 4;
            dU(1);
            continue;
            dU(2);
            continue;
            dU(3);
            continue;
            this.aUg = null;
            if ((this.aUi == 1) || (this.aUi == 3))
            {
              pP();
              continue;
              pP();
              continue;
              this.aUg = pO();
              pP();
              continue;
              if ((this.aUi == 1) && (!this.aUf.isEmpty())) {
                this.aUf.pT();
              }
            }
          }
        }
        this.aUf.append(b(i));
        if ((j & 0xE0) != 0) {
          this.aUf.append(b(j));
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
        this.aUk = false;
      }
      if ((this.aUi == 1) || (this.aUi == 3)) {
        this.aUg = pO();
      }
    }
    AppMethodBeat.o(95573);
  }
  
  public final void flush()
  {
    AppMethodBeat.i(95571);
    super.flush();
    this.aUg = null;
    this.aUh = null;
    dU(0);
    pP();
    this.aUj = 4;
    this.aUk = false;
    this.aUl = 0;
    this.aUm = 0;
    AppMethodBeat.o(95571);
  }
  
  protected final boolean pM()
  {
    return this.aUg != this.aUh;
  }
  
  protected final com.google.android.exoplayer2.f.d pN()
  {
    AppMethodBeat.i(95572);
    this.aUh = this.aUg;
    f localf = new f(this.aUg);
    AppMethodBeat.o(95572);
    return localf;
  }
  
  public final void release() {}
  
  static final class a
  {
    private int aUi;
    private int aUj;
    private final List<CharacterStyle> aUn;
    private final List<a.a.a> aUo;
    private final List<SpannableString> aUp;
    final SpannableStringBuilder aUq;
    int aUr;
    int aUs;
    int aur;
    int row;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(95559);
      this.aUn = new ArrayList();
      this.aUo = new ArrayList();
      this.aUp = new LinkedList();
      this.aUq = new SpannableStringBuilder();
      reset(paramInt1, paramInt2);
      AppMethodBeat.o(95559);
    }
    
    private SpannableString pU()
    {
      AppMethodBeat.i(95567);
      int k = this.aUq.length();
      int i = 0;
      while (i < this.aUn.size())
      {
        this.aUq.setSpan(this.aUn.get(i), 0, k, 33);
        i += 1;
      }
      i = 0;
      if (i < this.aUo.size())
      {
        localObject = (a.a.a)this.aUo.get(i);
        if (i < this.aUo.size() - ((a.a.a)localObject).aUu) {}
        for (int j = ((a.a.a)this.aUo.get(((a.a.a)localObject).aUu + i)).start;; j = k)
        {
          this.aUq.setSpan(((a.a.a)localObject).aUt, ((a.a.a)localObject).start, j, 33);
          i += 1;
          break;
        }
      }
      if (this.aUs != -1) {
        this.aUq.setSpan(new UnderlineSpan(), this.aUs, k, 33);
      }
      Object localObject = new SpannableString(this.aUq);
      AppMethodBeat.o(95567);
      return localObject;
    }
    
    public final void a(CharacterStyle paramCharacterStyle)
    {
      AppMethodBeat.i(95564);
      this.aUn.add(paramCharacterStyle);
      AppMethodBeat.o(95564);
    }
    
    public final void a(CharacterStyle paramCharacterStyle, int paramInt)
    {
      AppMethodBeat.i(95565);
      this.aUo.add(new a.a.a(paramCharacterStyle, this.aUq.length(), paramInt));
      AppMethodBeat.o(95565);
    }
    
    public final void append(char paramChar)
    {
      AppMethodBeat.i(95566);
      this.aUq.append(paramChar);
      AppMethodBeat.o(95566);
    }
    
    public final boolean isEmpty()
    {
      AppMethodBeat.i(95561);
      if ((this.aUn.isEmpty()) && (this.aUo.isEmpty()) && (this.aUp.isEmpty()) && (this.aUq.length() == 0))
      {
        AppMethodBeat.o(95561);
        return true;
      }
      AppMethodBeat.o(95561);
      return false;
    }
    
    public final void pS()
    {
      AppMethodBeat.i(95562);
      int i = this.aUq.length();
      if (i > 0) {
        this.aUq.delete(i - 1, i);
      }
      AppMethodBeat.o(95562);
    }
    
    public final void pT()
    {
      AppMethodBeat.i(95563);
      this.aUp.add(pU());
      this.aUq.clear();
      this.aUn.clear();
      this.aUo.clear();
      this.aUs = -1;
      int i = Math.min(this.aUj, this.row);
      while (this.aUp.size() >= i) {
        this.aUp.remove(0);
      }
      AppMethodBeat.o(95563);
    }
    
    public final com.google.android.exoplayer2.f.a pV()
    {
      int j = 2;
      AppMethodBeat.i(95568);
      Object localObject = new SpannableStringBuilder();
      int i = 0;
      while (i < this.aUp.size())
      {
        ((SpannableStringBuilder)localObject).append((CharSequence)this.aUp.get(i));
        ((SpannableStringBuilder)localObject).append('\n');
        i += 1;
      }
      ((SpannableStringBuilder)localObject).append(pU());
      if (((SpannableStringBuilder)localObject).length() == 0)
      {
        AppMethodBeat.o(95568);
        return null;
      }
      i = this.aur + this.aUr;
      int k = 32 - i - ((SpannableStringBuilder)localObject).length();
      int m = i - k;
      float f;
      if ((this.aUi == 2) && (Math.abs(m) < 3))
      {
        f = 0.5F;
        i = 1;
        if ((this.aUi != 1) && (this.row <= 7)) {
          break label250;
        }
        k = this.row - 15 - 2;
      }
      for (;;)
      {
        localObject = new com.google.android.exoplayer2.f.a((CharSequence)localObject, Layout.Alignment.ALIGN_NORMAL, k, 1, j, f, i, 1.4E-45F);
        AppMethodBeat.o(95568);
        return localObject;
        if ((this.aUi == 2) && (m > 0))
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
    
    public final void reset(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(95560);
      this.aUn.clear();
      this.aUo.clear();
      this.aUp.clear();
      this.aUq.clear();
      this.row = 15;
      this.aur = 0;
      this.aUr = 0;
      this.aUi = paramInt1;
      this.aUj = paramInt2;
      this.aUs = -1;
      AppMethodBeat.o(95560);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(95569);
      String str = this.aUq.toString();
      AppMethodBeat.o(95569);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */