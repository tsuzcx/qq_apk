package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e
{
  private final boolean Cri;
  private boolean Crj;
  private int Crk;
  private e.a Crl;
  private int bgQ;
  int bgR;
  private int bgS;
  private int bgT;
  int bgU;
  int bgV;
  private int bgW;
  final byte[] buffer;
  int bufferSize;
  private final InputStream input;
  
  private e(p paramp)
  {
    AppMethodBeat.i(121440);
    this.Crj = false;
    this.bgT = 2147483647;
    this.bgV = 64;
    this.bgW = 67108864;
    this.Crl = null;
    this.buffer = paramp.pW;
    this.bgR = paramp.eml();
    this.bufferSize = (this.bgR + paramp.size());
    this.Crk = (-this.bgR);
    this.input = null;
    this.Cri = true;
    AppMethodBeat.o(121440);
  }
  
  private e(InputStream paramInputStream)
  {
    AppMethodBeat.i(121439);
    this.Crj = false;
    this.bgT = 2147483647;
    this.bgV = 64;
    this.bgW = 67108864;
    this.Crl = null;
    this.buffer = new byte[4096];
    this.bufferSize = 0;
    this.bgR = 0;
    this.Crk = 0;
    this.input = paramInputStream;
    this.Cri = false;
    AppMethodBeat.o(121439);
  }
  
  public static e P(InputStream paramInputStream)
  {
    AppMethodBeat.i(121426);
    paramInputStream = new e(paramInputStream);
    AppMethodBeat.o(121426);
    return paramInputStream;
  }
  
  private void VC(int paramInt)
  {
    AppMethodBeat.i(121444);
    if (!VD(paramInt))
    {
      k localk = k.emN();
      AppMethodBeat.o(121444);
      throw localk;
    }
    AppMethodBeat.o(121444);
  }
  
  private boolean VD(int paramInt)
  {
    AppMethodBeat.i(121445);
    do
    {
      Object localObject;
      if (this.bgR + paramInt <= this.bufferSize)
      {
        localObject = new IllegalStateException(77 + "refillBuffer() called when " + paramInt + " bytes were already available in buffer");
        AppMethodBeat.o(121445);
        throw ((Throwable)localObject);
      }
      if (this.Crk + this.bgR + paramInt > this.bgT)
      {
        AppMethodBeat.o(121445);
        return false;
      }
      if (this.input == null) {
        break;
      }
      int i = this.bgR;
      if (i > 0)
      {
        if (this.bufferSize > i)
        {
          localObject = this.buffer;
          System.arraycopy(localObject, i, localObject, 0, this.bufferSize - i);
        }
        this.Crk += i;
        this.bufferSize -= i;
        this.bgR = 0;
      }
      i = this.input.read(this.buffer, this.bufferSize, this.buffer.length - this.bufferSize);
      if ((i == 0) || (i < -1) || (i > this.buffer.length))
      {
        localObject = new IllegalStateException(102 + "InputStream#read(byte[]) returned invalid result: " + i + "\nThe InputStream implementation is buggy.");
        AppMethodBeat.o(121445);
        throw ((Throwable)localObject);
      }
      if (i <= 0) {
        break;
      }
      this.bufferSize = (i + this.bufferSize);
      if (this.Crk + paramInt - this.bgW > 0)
      {
        localObject = k.emU();
        AppMethodBeat.o(121445);
        throw ((Throwable)localObject);
      }
      sn();
    } while (this.bufferSize < paramInt);
    AppMethodBeat.o(121445);
    return true;
    AppMethodBeat.o(121445);
    return false;
  }
  
  private void VF(int paramInt)
  {
    AppMethodBeat.i(121449);
    k localk;
    if (paramInt < 0)
    {
      localk = k.emO();
      AppMethodBeat.o(121449);
      throw localk;
    }
    if (this.Crk + this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.Crk - this.bgR);
      localk = k.emN();
      AppMethodBeat.o(121449);
      throw localk;
    }
    int i = this.bufferSize - this.bgR;
    this.bgR = this.bufferSize;
    VC(1);
    while (paramInt - i > this.bufferSize)
    {
      i += this.bufferSize;
      this.bgR = this.bufferSize;
      VC(1);
    }
    this.bgR = (paramInt - i);
    AppMethodBeat.o(121449);
  }
  
  static e a(p paramp)
  {
    AppMethodBeat.i(121427);
    e locale = new e(paramp);
    try
    {
      locale.eP(paramp.size());
      AppMethodBeat.o(121427);
      return locale;
    }
    catch (k paramp)
    {
      paramp = new IllegalArgumentException(paramp);
      AppMethodBeat.o(121427);
      throw paramp;
    }
  }
  
  private void eT(int paramInt)
  {
    AppMethodBeat.i(121448);
    if ((paramInt <= this.bufferSize - this.bgR) && (paramInt >= 0))
    {
      this.bgR += paramInt;
      AppMethodBeat.o(121448);
      return;
    }
    VF(paramInt);
    AppMethodBeat.o(121448);
  }
  
  private long emw()
  {
    AppMethodBeat.i(121436);
    long l = 0L;
    int i = 0;
    while (i < 64)
    {
      int j = sp();
      l |= (j & 0x7F) << i;
      if ((j & 0x80) == 0)
      {
        AppMethodBeat.o(121436);
        return l;
      }
      i += 7;
    }
    k localk = k.emP();
    AppMethodBeat.o(121436);
    throw localk;
  }
  
  private boolean emz()
  {
    AppMethodBeat.i(121443);
    if ((this.bgR == this.bufferSize) && (!VD(1)))
    {
      AppMethodBeat.o(121443);
      return true;
    }
    AppMethodBeat.o(121443);
    return false;
  }
  
  public static long pp(long paramLong)
  {
    return paramLong >>> 1 ^ -(1L & paramLong);
  }
  
  private void sn()
  {
    this.bufferSize += this.bgQ;
    int i = this.Crk + this.bufferSize;
    if (i > this.bgT)
    {
      this.bgQ = (i - this.bgT);
      this.bufferSize -= this.bgQ;
      return;
    }
    this.bgQ = 0;
  }
  
  private byte sp()
  {
    AppMethodBeat.i(121446);
    if (this.bgR == this.bufferSize) {
      VC(1);
    }
    byte[] arrayOfByte = this.buffer;
    int i = this.bgR;
    this.bgR = (i + 1);
    byte b = arrayOfByte[i];
    AppMethodBeat.o(121446);
    return b;
  }
  
  final byte[] VE(int paramInt)
  {
    AppMethodBeat.i(121447);
    if (paramInt <= 0)
    {
      if (paramInt == 0)
      {
        localObject1 = j.EMPTY_BYTE_ARRAY;
        AppMethodBeat.o(121447);
        return localObject1;
      }
      localObject1 = k.emO();
      AppMethodBeat.o(121447);
      throw ((Throwable)localObject1);
    }
    if (this.Crk + this.bgR + paramInt > this.bgT)
    {
      eT(this.bgT - this.Crk - this.bgR);
      localObject1 = k.emN();
      AppMethodBeat.o(121447);
      throw ((Throwable)localObject1);
    }
    int j;
    if (paramInt < 4096)
    {
      localObject1 = new byte[paramInt];
      i = this.bufferSize - this.bgR;
      System.arraycopy(this.buffer, this.bgR, localObject1, 0, i);
      this.bgR = this.bufferSize;
      j = paramInt - i;
      if (this.bufferSize - this.bgR < j) {
        VC(j);
      }
      System.arraycopy(this.buffer, 0, localObject1, i, paramInt - i);
      this.bgR = (paramInt - i);
      AppMethodBeat.o(121447);
      return localObject1;
    }
    int m = this.bgR;
    int n = this.bufferSize;
    this.Crk += this.bufferSize;
    this.bgR = 0;
    this.bufferSize = 0;
    Object localObject2 = new ArrayList();
    int i = paramInt - (n - m);
    while (i > 0)
    {
      localObject1 = new byte[Math.min(i, 4096)];
      j = 0;
      while (j < localObject1.length)
      {
        if (this.input == null) {}
        for (int k = -1; k == -1; k = this.input.read((byte[])localObject1, j, localObject1.length - j))
        {
          localObject1 = k.emN();
          AppMethodBeat.o(121447);
          throw ((Throwable)localObject1);
        }
        this.Crk += k;
        j += k;
      }
      j = localObject1.length;
      ((List)localObject2).add(localObject1);
      i -= j;
    }
    Object localObject1 = new byte[paramInt];
    paramInt = n - m;
    System.arraycopy(this.buffer, m, localObject1, 0, paramInt);
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      byte[] arrayOfByte = (byte[])((Iterator)localObject2).next();
      System.arraycopy(arrayOfByte, 0, localObject1, paramInt, arrayOfByte.length);
      paramInt = arrayOfByte.length + paramInt;
    }
    AppMethodBeat.o(121447);
    return localObject1;
  }
  
  public final <T extends q> T a(s<T> params, g paramg)
  {
    AppMethodBeat.i(121432);
    int i = sl();
    if (this.bgU >= this.bgV)
    {
      params = k.emT();
      AppMethodBeat.o(121432);
      throw params;
    }
    i = eP(i);
    this.bgU += 1;
    params = (q)params.a(this, paramg);
    eN(0);
    this.bgU -= 1;
    eQ(i);
    AppMethodBeat.o(121432);
    return params;
  }
  
  public final boolean a(int paramInt, f paramf)
  {
    AppMethodBeat.i(121430);
    long l;
    switch (z.eZ(paramInt))
    {
    default: 
      paramf = k.emS();
      AppMethodBeat.o(121430);
      throw paramf;
    case 0: 
      l = sm();
      paramf.eX(paramInt);
      paramf.ao(l);
      AppMethodBeat.o(121430);
      return true;
    case 1: 
      l = emy();
      paramf.eX(paramInt);
      paramf.ps(l);
      AppMethodBeat.o(121430);
      return true;
    case 2: 
      d locald = emv();
      paramf.eX(paramInt);
      paramf.b(locald);
      AppMethodBeat.o(121430);
      return true;
    case 3: 
      paramf.eX(paramInt);
      do
      {
        i = sk();
      } while ((i != 0) && (a(i, paramf)));
      paramInt = z.bo(z.fa(paramInt), 4);
      eN(paramInt);
      paramf.eX(paramInt);
      AppMethodBeat.o(121430);
      return true;
    case 4: 
      AppMethodBeat.o(121430);
      return false;
    }
    int i = emx();
    paramf.eX(paramInt);
    paramf.VI(i);
    AppMethodBeat.o(121430);
    return true;
  }
  
  public final void eN(int paramInt)
  {
    AppMethodBeat.i(121429);
    if (this.bgS != paramInt)
    {
      k localk = k.emR();
      AppMethodBeat.o(121429);
      throw localk;
    }
    AppMethodBeat.o(121429);
  }
  
  public final int eP(int paramInt)
  {
    AppMethodBeat.i(121441);
    k localk;
    if (paramInt < 0)
    {
      localk = k.emO();
      AppMethodBeat.o(121441);
      throw localk;
    }
    paramInt = this.Crk + this.bgR + paramInt;
    int i = this.bgT;
    if (paramInt > i)
    {
      localk = k.emN();
      AppMethodBeat.o(121441);
      throw localk;
    }
    this.bgT = paramInt;
    sn();
    AppMethodBeat.o(121441);
    return i;
  }
  
  public final void eQ(int paramInt)
  {
    AppMethodBeat.i(121442);
    this.bgT = paramInt;
    sn();
    AppMethodBeat.o(121442);
  }
  
  public final boolean emu()
  {
    AppMethodBeat.i(121431);
    if (sm() != 0L)
    {
      AppMethodBeat.o(121431);
      return true;
    }
    AppMethodBeat.o(121431);
    return false;
  }
  
  public final d emv()
  {
    AppMethodBeat.i(121433);
    int i = sl();
    if ((i <= this.bufferSize - this.bgR) && (i > 0))
    {
      if ((this.Cri) && (this.Crj)) {}
      for (localObject = new c(this.buffer, this.bgR, i);; localObject = d.B(this.buffer, this.bgR, i))
      {
        this.bgR = (i + this.bgR);
        AppMethodBeat.o(121433);
        return localObject;
      }
    }
    if (i == 0)
    {
      localObject = d.Cre;
      AppMethodBeat.o(121433);
      return localObject;
    }
    Object localObject = new p(VE(i));
    AppMethodBeat.o(121433);
    return localObject;
  }
  
  public final int emx()
  {
    AppMethodBeat.i(121437);
    int j = this.bgR;
    int i = j;
    if (this.bufferSize - j < 4)
    {
      VC(4);
      i = this.bgR;
    }
    byte[] arrayOfByte = this.buffer;
    this.bgR = (i + 4);
    j = arrayOfByte[i];
    int k = arrayOfByte[(i + 1)];
    int m = arrayOfByte[(i + 2)];
    i = arrayOfByte[(i + 3)];
    AppMethodBeat.o(121437);
    return (i & 0xFF) << 24 | j & 0xFF | (k & 0xFF) << 8 | (m & 0xFF) << 16;
  }
  
  public final long emy()
  {
    AppMethodBeat.i(121438);
    int j = this.bgR;
    int i = j;
    if (this.bufferSize - j < 8)
    {
      VC(8);
      i = this.bgR;
    }
    byte[] arrayOfByte = this.buffer;
    this.bgR = (i + 8);
    long l1 = arrayOfByte[i];
    long l2 = arrayOfByte[(i + 1)];
    long l3 = arrayOfByte[(i + 2)];
    long l4 = arrayOfByte[(i + 3)];
    long l5 = arrayOfByte[(i + 4)];
    long l6 = arrayOfByte[(i + 5)];
    long l7 = arrayOfByte[(i + 6)];
    long l8 = arrayOfByte[(i + 7)];
    AppMethodBeat.o(121438);
    return (l8 & 0xFF) << 56 | l1 & 0xFF | (l2 & 0xFF) << 8 | (l3 & 0xFF) << 16 | (l4 & 0xFF) << 24 | (l5 & 0xFF) << 32 | (l6 & 0xFF) << 40 | (l7 & 0xFF) << 48;
  }
  
  public final int sk()
  {
    AppMethodBeat.i(121428);
    if (emz())
    {
      this.bgS = 0;
      AppMethodBeat.o(121428);
      return 0;
    }
    this.bgS = sl();
    if (z.fa(this.bgS) == 0)
    {
      k localk = k.emQ();
      AppMethodBeat.o(121428);
      throw localk;
    }
    int i = this.bgS;
    AppMethodBeat.o(121428);
    return i;
  }
  
  public final int sl()
  {
    AppMethodBeat.i(121434);
    int i = this.bgR;
    byte[] arrayOfByte;
    int j;
    int k;
    if (this.bufferSize != i)
    {
      arrayOfByte = this.buffer;
      j = i + 1;
      k = arrayOfByte[i];
      if (k >= 0)
      {
        this.bgR = j;
        AppMethodBeat.o(121434);
        return k;
      }
      if (this.bufferSize - j >= 9)
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 7;
        if (k < 0L) {
          j = (int)(k ^ 0xFFFFFF80);
        }
      }
    }
    for (;;)
    {
      this.bgR = i;
      AppMethodBeat.o(121434);
      return j;
      j = i + 1;
      k ^= arrayOfByte[i] << 14;
      if (k >= 0L)
      {
        k = (int)(k ^ 0x3F80);
        i = j;
        j = k;
      }
      else
      {
        i = j + 1;
        k ^= arrayOfByte[j] << 21;
        if (k < 0L)
        {
          j = (int)(k ^ 0xFFE03F80);
        }
        else
        {
          int m = i + 1;
          j = arrayOfByte[i];
          k = (int)(k ^ j << 28 ^ 0xFE03F80);
          i = m;
          if (j < 0)
          {
            int n = m + 1;
            j = k;
            i = n;
            if (arrayOfByte[m] >= 0) {
              continue;
            }
            m = n + 1;
            i = m;
            if (arrayOfByte[n] < 0)
            {
              n = m + 1;
              j = k;
              i = n;
              if (arrayOfByte[m] >= 0) {
                continue;
              }
              m = n + 1;
              i = m;
              if (arrayOfByte[n] < 0)
              {
                i = m + 1;
                j = k;
                if (arrayOfByte[m] >= 0) {
                  continue;
                }
                i = (int)emw();
                AppMethodBeat.o(121434);
                return i;
              }
            }
          }
          j = k;
        }
      }
    }
  }
  
  public final long sm()
  {
    AppMethodBeat.i(121435);
    int i = this.bgR;
    byte[] arrayOfByte;
    int j;
    long l;
    if (this.bufferSize != i)
    {
      arrayOfByte = this.buffer;
      j = i + 1;
      int k = arrayOfByte[i];
      if (k >= 0)
      {
        this.bgR = j;
        l = k;
        AppMethodBeat.o(121435);
        return l;
      }
      if (this.bufferSize - j >= 9)
      {
        i = j + 1;
        l = k ^ arrayOfByte[j] << 7;
        if (l < 0L) {
          l ^= 0xFFFFFF80;
        }
      }
    }
    for (;;)
    {
      this.bgR = i;
      AppMethodBeat.o(121435);
      return l;
      j = i + 1;
      l ^= arrayOfByte[i] << 14;
      if (l >= 0L)
      {
        l ^= 0x3F80;
        i = j;
      }
      else
      {
        i = j + 1;
        l ^= arrayOfByte[j] << 21;
        if (l < 0L)
        {
          l ^= 0xFFE03F80;
        }
        else
        {
          j = i + 1;
          l ^= arrayOfByte[i] << 28;
          if (l >= 0L)
          {
            l ^= 0xFE03F80;
            i = j;
          }
          else
          {
            i = j + 1;
            l ^= arrayOfByte[j] << 35;
            if (l < 0L)
            {
              l ^= 0xFE03F80;
            }
            else
            {
              j = i + 1;
              l ^= arrayOfByte[i] << 42;
              if (l >= 0L)
              {
                l ^= 0xFE03F80;
                i = j;
              }
              else
              {
                i = j + 1;
                l ^= arrayOfByte[j] << 49;
                if (l < 0L)
                {
                  l ^= 0xFE03F80;
                }
                else
                {
                  j = i + 1;
                  l = l ^ arrayOfByte[i] << 56 ^ 0xFE03F80;
                  if (l < 0L)
                  {
                    i = j + 1;
                    if (arrayOfByte[j] < 0L)
                    {
                      l = emw();
                      AppMethodBeat.o(121435);
                      return l;
                    }
                  }
                  else
                  {
                    i = j;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final int so()
  {
    if (this.bgT == 2147483647) {
      return -1;
    }
    int i = this.Crk;
    int j = this.bgR;
    return this.bgT - (i + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.g.e
 * JD-Core Version:    0.7.0.1
 */