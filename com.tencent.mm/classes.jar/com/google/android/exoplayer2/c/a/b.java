package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a.a;
import com.google.android.exoplayer2.o;
import java.io.EOFException;

public final class b
  implements com.google.android.exoplayer2.c.d
{
  public static final g azq = new g() {};
  private static final int azr = t.aG("Xing");
  private static final int azs = t.aG("Info");
  private static final int azt = t.aG("VBRI");
  private Metadata auq;
  private int azA;
  private b.a azB;
  private long azC;
  private long azD;
  private int azE;
  private final long azu;
  private final j azv;
  private final i azw;
  private final h azx;
  private f azy;
  private k azz;
  private final int flags = 0;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    this(-9223372036854775807L);
  }
  
  public b(long paramLong)
  {
    this.azu = paramLong;
    this.azv = new j(10);
    this.azw = new i();
    this.azx = new h();
    this.azC = -9223372036854775807L;
  }
  
  private b.a b(e parame)
  {
    parame.b(this.azv.data, 0, 4);
    this.azv.setPosition(0);
    i.a(this.azv.readInt(), this.azw);
    return new a(parame.getPosition(), this.azw.bitrate, parame.getLength());
  }
  
  private static boolean f(int paramInt, long paramLong)
  {
    return (0xFFFE0C00 & paramInt) == (0xFFFE0C00 & paramLong);
  }
  
  public final int a(e parame)
  {
    int m;
    int n;
    int i1;
    if (this.azA == 0)
    {
      m = 0;
      n = 0;
      i1 = 0;
    }
    for (;;)
    {
      int j;
      try
      {
        parame.lT();
        int i = n;
        int k = i1;
        j = m;
        Object localObject2;
        Object localObject3;
        if (parame.getPosition() == 0L)
        {
          i = 0;
          parame.b(this.azv.data, 0, 10);
          this.azv.setPosition(0);
          if (this.azv.of() == com.google.android.exoplayer2.metadata.id3.a.aDc)
          {
            this.azv.dB(3);
            j = this.azv.og();
            k = j + 10;
            if (this.auq == null)
            {
              localObject2 = new byte[k];
              System.arraycopy(this.azv.data, 0, localObject2, 0, 10);
              parame.b((byte[])localObject2, 10, j);
              if ((this.flags & 0x2) == 0) {
                continue;
              }
              localObject1 = h.aze;
              this.auq = new com.google.android.exoplayer2.metadata.id3.a((a.a)localObject1).c((byte[])localObject2, k);
              if (this.auq == null) {
                continue;
              }
              localObject1 = this.azx;
              localObject2 = this.auq;
              j = 0;
              if (j >= ((Metadata)localObject2).aGI.length) {
                continue;
              }
              localObject3 = localObject2.aGI[j];
              if ((localObject3 instanceof CommentFrame))
              {
                localObject3 = (CommentFrame)localObject3;
                if (((h)localObject1).k(((CommentFrame)localObject3).description, ((CommentFrame)localObject3).text)) {
                  continue;
                }
              }
            }
            else
            {
              parame.cM(j);
              continue;
            }
          }
          else
          {
            parame.lT();
            parame.cM(i);
            parame.cL((int)parame.lU());
            j = m;
            k = i1;
            i = n;
          }
        }
        else
        {
          localObject1 = this.azv.data;
          if (j <= 0) {
            break label1836;
          }
          bool = true;
          if (parame.b((byte[])localObject1, 0, 4, bool))
          {
            this.azv.setPosition(0);
            m = this.azv.readInt();
            if ((i == 0) || (f(m, i)))
            {
              n = i.cR(m);
              if (n != -1) {}
            }
            else
            {
              if (k == 131072) {
                throw new o("Searched too many bytes.");
              }
              j = 0;
              i = 0;
              parame.cL(1);
              k += 1;
              continue;
            }
            j += 1;
            if (j != 1) {
              break label1842;
            }
            i.a(m, this.azw);
            i = m;
            parame.cM(n - 4);
            continue;
          }
          parame.lT();
          this.azA = i;
          if (this.azB == null)
          {
            localObject1 = new j(this.azw.avQ);
            parame.b(((j)localObject1).data, 0, this.azw.avQ);
            if ((this.azw.version & 0x1) == 0) {
              continue;
            }
            if (this.azw.channels != 1)
            {
              i = 36;
              if (((j)localObject1).limit < i + 4) {
                continue;
              }
              ((j)localObject1).setPosition(i);
              j = ((j)localObject1).readInt();
              if ((j != azr) && (j != azs)) {
                continue;
              }
              if ((j != azr) && (j != azs)) {
                continue;
              }
              localObject2 = this.azw;
              l2 = parame.getPosition();
              l1 = parame.getLength();
              k = ((i)localObject2).azn;
              m = ((i)localObject2).sampleRate;
              l2 += ((i)localObject2).avQ;
              n = ((j)localObject1).readInt();
              if ((n & 0x1) == 1)
              {
                i1 = ((j)localObject1).oh();
                if (i1 != 0) {
                  continue;
                }
              }
              localObject1 = null;
              if (localObject1 != null)
              {
                localObject2 = this.azx;
                if ((((h)localObject2).auE == -1) || (((h)localObject2).auF == -1)) {
                  continue;
                }
                k = 1;
                if (k == 0)
                {
                  parame.lT();
                  parame.cM(i + 141);
                  parame.b(this.azv.data, 0, 3);
                  this.azv.setPosition(0);
                  localObject2 = this.azx;
                  k = this.azv.of();
                  i = k >> 12;
                  k &= 0xFFF;
                  if ((i > 0) || (k > 0))
                  {
                    ((h)localObject2).auE = i;
                    ((h)localObject2).auF = k;
                  }
                }
              }
              parame.cL(this.azw.avQ);
              localObject2 = localObject1;
              if (localObject1 != null)
              {
                localObject2 = localObject1;
                if (!((b.a)localObject1).lS())
                {
                  localObject2 = localObject1;
                  if (j == azs) {
                    localObject2 = b(parame);
                  }
                }
              }
              this.azB = ((b.a)localObject2);
              if ((this.azB == null) || ((!this.azB.lS()) && ((this.flags & 0x1) != 0))) {
                this.azB = b(parame);
              }
              localObject2 = this.azz;
              localObject3 = this.azw.mimeType;
              i = this.azw.channels;
              j = this.azw.sampleRate;
              k = this.azx.auE;
              m = this.azx.auF;
              if ((this.flags & 0x2) == 0) {
                continue;
              }
              localObject1 = null;
              ((k)localObject2).f(Format.a(null, (String)localObject3, -1, 4096, i, j, -1, k, m, null, null, null, (Metadata)localObject1));
            }
          }
          else
          {
            if (this.azE != 0) {
              continue;
            }
            parame.lT();
            if (parame.b(this.azv.data, 0, 4, true)) {
              continue;
            }
            return -1;
          }
          i = 21;
          continue;
          if (this.azw.channels != 1)
          {
            i = 21;
            continue;
          }
          i = 13;
          continue;
          if (((j)localObject1).limit >= 40)
          {
            ((j)localObject1).setPosition(36);
            if (((j)localObject1).readInt() == azt)
            {
              j = azt;
              continue;
            }
          }
          j = 0;
          continue;
          long l3 = t.b(i1, k * 1000000L, m);
          if ((n & 0x6) != 6)
          {
            localObject1 = new d(l2, l3, l1);
            continue;
          }
          long l4 = ((j)localObject1).oh();
          ((j)localObject1).dB(1);
          localObject3 = new long[99];
          k = 0;
          if (k < 99)
          {
            localObject3[k] = ((j)localObject1).readUnsignedByte();
            k += 1;
            continue;
          }
          localObject1 = new d(l2, l3, l1, (long[])localObject3, l4, ((i)localObject2).avQ);
          continue;
          k = 0;
          continue;
          if (j == azt)
          {
            localObject2 = this.azw;
            l1 = parame.getPosition();
            l3 = parame.getLength();
            ((j)localObject1).dB(10);
            i = ((j)localObject1).readInt();
            if (i <= 0)
            {
              localObject2 = null;
              parame.cL(this.azw.avQ);
              continue;
            }
            j = ((i)localObject2).sampleRate;
            l2 = i;
            if (j >= 32000)
            {
              i = 1152;
              l4 = t.b(l2, i * 1000000L, j);
              k = ((j)localObject1).readUnsignedShort();
              m = ((j)localObject1).readUnsignedShort();
              n = ((j)localObject1).readUnsignedShort();
              ((j)localObject1).dB(2);
              l1 += ((i)localObject2).avQ;
              localObject2 = new long[k + 1];
              localObject3 = new long[k + 1];
              localObject2[0] = 0L;
              localObject3[0] = l1;
              j = 1;
              if (j >= localObject2.length) {}
            }
            else
            {
              switch (n)
              {
              default: 
                localObject2 = null;
                continue;
                i = 576;
                break;
              case 1: 
                i = ((j)localObject1).readUnsignedByte();
                l1 += i * m;
                localObject2[j] = (j * l4 / k);
                if (l3 == -1L)
                {
                  l2 = l1;
                  localObject3[j] = l2;
                  j += 1;
                }
                break;
              case 2: 
                i = ((j)localObject1).readUnsignedShort();
                break;
              case 3: 
                i = ((j)localObject1).of();
                break;
              case 4: 
                i = ((j)localObject1).oh();
                continue;
                l2 = Math.min(l3, l1);
                break;
              }
            }
            localObject2 = new c((long[])localObject2, (long[])localObject3, l4);
            continue;
          }
          localObject2 = null;
          parame.lT();
          continue;
          localObject1 = this.auq;
          continue;
          this.azv.setPosition(0);
          i = this.azv.readInt();
          if ((!f(i, this.azA)) || (i.cR(i) == -1))
          {
            parame.cL(1);
            this.azA = 0;
            return 0;
          }
          i.a(i, this.azw);
          if (this.azC == -9223372036854775807L)
          {
            this.azC = this.azB.F(parame.getPosition());
            if (this.azu != -9223372036854775807L)
            {
              l1 = this.azB.F(0L);
              l2 = this.azC;
              this.azC = (this.azu - l1 + l2);
            }
          }
          this.azE = this.azw.avQ;
          i = this.azz.a(parame, this.azE, true);
          if (i == -1) {
            return -1;
          }
          this.azE -= i;
          if (this.azE > 0) {
            return 0;
          }
          long l1 = this.azC;
          long l2 = this.azD * 1000000L / this.azw.sampleRate;
          this.azz.a(l2 + l1, 1, this.azw.avQ, 0, null);
          this.azD += this.azw.azn;
          this.azE = 0;
          return 0;
        }
        j += 1;
        continue;
        Object localObject1 = null;
        continue;
        i += k;
        continue;
        boolean bool = false;
      }
      catch (EOFException parame)
      {
        return -1;
      }
      label1836:
      continue;
      label1842:
      if (j == 4) {}
    }
  }
  
  public final void a(f paramf)
  {
    this.azy = paramf;
    this.azz = this.azy.cQ(0);
    this.azy.lV();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.a.b
 * JD-Core Version:    0.7.0.1
 */