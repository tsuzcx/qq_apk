package com.google.android.exoplayer2.f.a;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.j;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a
  extends d
{
  private static final int[] Jf = { -1, -16711936, -16776961, -16711681, -65536, -256, -65281 };
  private static final int[] aMB = { 11, 1, 3, 12, 14, 5, 7, 9 };
  private static final int[] aMC = { 0, 4, 8, 12, 16, 20, 24, 28 };
  private static final int[] aMD = { 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632 };
  private static final int[] aME = { 174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251 };
  private static final int[] aMF = { 193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187 };
  private static final int[] aMG = { 195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496 };
  private final j aMH = new j();
  private final int aMI;
  private final int aMJ;
  private final LinkedList<a.a> aMK = new LinkedList();
  private a.a aML = new a.a(0, 4);
  private List<com.google.android.exoplayer2.f.a> aMM;
  private List<com.google.android.exoplayer2.f.a> aMN;
  private int aMO;
  private int aMP;
  private boolean aMQ;
  private byte aMR;
  private byte aMS;
  
  public a(String paramString, int paramInt)
  {
    int i;
    if ("application/x-mp4-cea-608".equals(paramString))
    {
      i = 2;
      this.aMI = i;
      switch (paramInt)
      {
      }
    }
    for (this.aMJ = 1;; this.aMJ = 2)
    {
      jdMethod_do(0);
      ns();
      return;
      i = 3;
      break;
    }
  }
  
  private static char b(byte paramByte)
  {
    return (char)aMD[((paramByte & 0x7F) - 32)];
  }
  
  private void jdMethod_do(int paramInt)
  {
    if (this.aMO == paramInt) {}
    int i;
    do
    {
      return;
      i = this.aMO;
      this.aMO = paramInt;
      ns();
    } while ((i != 3) && (paramInt != 1) && (paramInt != 0));
    this.aMM = null;
  }
  
  private List<com.google.android.exoplayer2.f.a> nr()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.aMK.size())
    {
      com.google.android.exoplayer2.f.a locala = ((a.a)this.aMK.get(i)).ny();
      if (locala != null) {
        localArrayList.add(locala);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private void ns()
  {
    this.aML.reset(this.aMO, this.aMP);
    this.aMK.clear();
    this.aMK.add(this.aML);
  }
  
  protected final void a(h paramh)
  {
    this.aMH.m(paramh.ayD.array(), paramh.ayD.limit());
    int m = 0;
    int k = 0;
    label387:
    label408:
    label537:
    label560:
    while (this.aMH.oe() >= this.aMI)
    {
      if (this.aMI == 2) {}
      int i;
      int j;
      for (int n = -4;; n = (byte)this.aMH.readUnsignedByte())
      {
        i = (byte)(this.aMH.readUnsignedByte() & 0x7F);
        j = (byte)(this.aMH.readUnsignedByte() & 0x7F);
        if (((n & 0x6) != 4) || ((this.aMJ == 1) && ((n & 0x1) != 0)) || ((this.aMJ == 2) && ((n & 0x1) != 1)) || ((i == 0) && (j == 0))) {
          break;
        }
        if (((i & 0xF7) != 17) || ((j & 0xF0) != 48)) {
          break label180;
        }
        this.aML.append((char)aME[(j & 0xF)]);
        k = 1;
        break;
      }
      label180:
      if (((i & 0xF6) == 18) && ((j & 0xE0) == 32))
      {
        this.aML.nv();
        if ((i & 0x1) == 0)
        {
          this.aML.append((char)aMF[(j & 0x1F)]);
          k = 1;
        }
        else
        {
          this.aML.append((char)aMG[(j & 0x1F)]);
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
              if ((this.aMQ) && (this.aMR == i) && (this.aMS == j))
              {
                this.aMQ = false;
                k = 1;
                n = 1;
                m = k;
                k = n;
                break;
                k = 0;
                continue;
              }
              this.aMQ = true;
              this.aMR = i;
              this.aMS = j;
            }
          }
          if (((i & 0xF7) == 17) && ((j & 0xF0) == 32))
          {
            m = 1;
            label372:
            if (m == 0) {
              break label537;
            }
            if ((j & 0x1) != 1) {
              break label464;
            }
            m = 1;
            paramh = this.aML;
            if (m == 0) {
              break label470;
            }
            paramh.aMY = paramh.aMW.length();
            m = j >> 1 & 0xF;
            if (m != 7) {
              break label513;
            }
            this.aML.a(new StyleSpan(2), 2);
            this.aML.a(new ForegroundColorSpan(-1), 1);
          }
          for (;;)
          {
            label455:
            break;
            m = 0;
            break label372;
            label464:
            m = 0;
            break label387;
            label470:
            if (paramh.aMY == -1) {
              break label408;
            }
            paramh.aMW.setSpan(new UnderlineSpan(), paramh.aMY, paramh.aMW.length(), 33);
            paramh.aMY = -1;
            break label408;
            this.aML.a(new ForegroundColorSpan(Jf[m]), 1);
            continue;
            int i1;
            if (((i & 0xF0) == 16) && ((j & 0xC0) == 64))
            {
              m = 1;
              if (m == 0) {
                break label800;
              }
              i1 = aMB[(i & 0x7)];
              if ((j & 0x20) == 0) {
                break label752;
              }
            }
            label752:
            for (m = 1;; m = 0)
            {
              n = i1;
              if (m != 0) {
                n = i1 + 1;
              }
              if (n != this.aML.row)
              {
                if ((this.aMO != 1) && (!this.aML.isEmpty()))
                {
                  this.aML = new a.a(this.aMO, this.aMP);
                  this.aMK.add(this.aML);
                }
                this.aML.row = n;
              }
              if ((j & 0x1) == 1) {
                this.aML.a(new UnderlineSpan());
              }
              m = j >> 1 & 0xF;
              if (m > 7) {
                break label781;
              }
              if (m != 7) {
                break label758;
              }
              this.aML.a(new StyleSpan(2));
              this.aML.a(new ForegroundColorSpan(-1));
              break;
              m = 0;
              break label560;
            }
            label758:
            this.aML.a(new ForegroundColorSpan(Jf[m]));
            continue;
            this.aML.asa = aMC[(m & 0x7)];
            continue;
            if (((i & 0xF7) == 23) && (j >= 33) && (j <= 35)) {}
            for (m = 1;; m = 0)
            {
              if (m == 0) {
                break label850;
              }
              this.aML.aMX = (j - 32);
              break;
            }
            label850:
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
                if (this.aMO == 0) {
                  break label455;
                }
                switch (j)
                {
                default: 
                  break;
                case 33: 
                  this.aML.nv();
                  break;
                }
                break;
              }
            }
            this.aMP = 2;
            jdMethod_do(1);
            continue;
            this.aMP = 3;
            jdMethod_do(1);
            continue;
            this.aMP = 4;
            jdMethod_do(1);
            continue;
            jdMethod_do(2);
            continue;
            jdMethod_do(3);
            continue;
            this.aMM = null;
            if ((this.aMO == 1) || (this.aMO == 3))
            {
              ns();
              continue;
              ns();
              continue;
              this.aMM = nr();
              ns();
              continue;
              if ((this.aMO == 1) && (!this.aML.isEmpty())) {
                this.aML.nw();
              }
            }
          }
        }
        this.aML.append(b(i));
        if ((j & 0xE0) != 0) {
          this.aML.append(b(j));
        }
        k = 1;
      }
    }
    label513:
    label781:
    label800:
    if (k != 0)
    {
      if (m == 0) {
        this.aMQ = false;
      }
      if ((this.aMO == 1) || (this.aMO == 3)) {
        this.aMM = nr();
      }
    }
  }
  
  public final void flush()
  {
    super.flush();
    this.aMM = null;
    this.aMN = null;
    jdMethod_do(0);
    ns();
    this.aMP = 4;
    this.aMQ = false;
    this.aMR = 0;
    this.aMS = 0;
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
  
  public final void release() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.f.a.a
 * JD-Core Version:    0.7.0.1
 */