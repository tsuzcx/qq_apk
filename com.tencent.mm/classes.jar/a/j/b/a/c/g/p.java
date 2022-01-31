package a.j.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.OutputStream;

class p
  extends d
{
  private int pJe = 0;
  protected final byte[] pW;
  
  p(byte[] paramArrayOfByte)
  {
    this.pW = paramArrayOfByte;
  }
  
  private static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = paramInt2;
    while (i < paramInt2 + paramInt3)
    {
      paramInt1 = paramInt1 * 31 + paramArrayOfByte[i];
      i += 1;
    }
    return paramInt1;
  }
  
  public byte VA(int paramInt)
  {
    return this.pW[paramInt];
  }
  
  final boolean a(p paramp, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121577);
    if (paramInt2 > paramp.size())
    {
      paramInt1 = size();
      paramp = new IllegalArgumentException(40 + "Length too large: " + paramInt2 + paramInt1);
      AppMethodBeat.o(121577);
      throw paramp;
    }
    if (paramInt1 + paramInt2 > paramp.size())
    {
      i = paramp.size();
      paramp = new IllegalArgumentException(59 + "Ran off end of other: " + paramInt1 + ", " + paramInt2 + ", " + i);
      AppMethodBeat.o(121577);
      throw paramp;
    }
    byte[] arrayOfByte1 = this.pW;
    byte[] arrayOfByte2 = paramp.pW;
    int j = eml();
    int i = eml();
    paramInt1 = paramp.eml() + paramInt1;
    while (i < j + paramInt2)
    {
      if (arrayOfByte1[i] != arrayOfByte2[paramInt1])
      {
        AppMethodBeat.o(121577);
        return false;
      }
      i += 1;
      paramInt1 += 1;
    }
    AppMethodBeat.o(121577);
    return true;
  }
  
  protected final int aQ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121575);
    paramInt2 = eml() + paramInt2;
    byte[] arrayOfByte = this.pW;
    int k = paramInt2 + paramInt3;
    int m;
    int i;
    int j;
    if (paramInt1 != 0)
    {
      if (paramInt2 >= k)
      {
        AppMethodBeat.o(121575);
        return paramInt1;
      }
      m = (byte)paramInt1;
      if (m < -32)
      {
        if (m >= -62)
        {
          paramInt1 = paramInt2 + 1;
          if (arrayOfByte[paramInt2] <= -65) {
            break label331;
          }
        }
        AppMethodBeat.o(121575);
        return -1;
      }
      if (m < -16)
      {
        i = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
        paramInt1 = i;
        paramInt3 = paramInt2;
        if (i == 0)
        {
          paramInt3 = paramInt2 + 1;
          paramInt1 = arrayOfByte[paramInt2];
          if (paramInt3 >= k)
          {
            paramInt1 = y.iI(m, paramInt1);
            AppMethodBeat.o(121575);
            return paramInt1;
          }
        }
        if ((paramInt1 <= -65) && ((m != -32) || (paramInt1 >= -96)) && ((m != -19) || (paramInt1 < -96)))
        {
          paramInt1 = paramInt3 + 1;
          if (arrayOfByte[paramInt3] <= -65) {
            break label331;
          }
        }
        AppMethodBeat.o(121575);
        return -1;
      }
      paramInt3 = (byte)(paramInt1 >> 8 ^ 0xFFFFFFFF);
      i = 0;
      if (paramInt3 == 0)
      {
        j = paramInt2 + 1;
        paramInt3 = arrayOfByte[paramInt2];
        if (j < k) {
          break label347;
        }
        paramInt1 = y.iI(m, paramInt3);
        AppMethodBeat.o(121575);
        return paramInt1;
      }
      paramInt1 = (byte)(paramInt1 >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 0)
      {
        i = paramInt2 + 1;
        j = arrayOfByte[paramInt2];
        paramInt1 = j;
        paramInt2 = i;
        if (i >= k)
        {
          paramInt1 = y.aS(m, paramInt3, j);
          AppMethodBeat.o(121575);
          return paramInt1;
        }
      }
      if ((paramInt3 <= -65) && ((m << 28) + (paramInt3 + 112) >> 30 == 0) && (paramInt1 <= -65))
      {
        paramInt1 = paramInt2 + 1;
        if (arrayOfByte[paramInt2] <= -65) {}
      }
      else
      {
        AppMethodBeat.o(121575);
        return -1;
        paramInt1 = paramInt2;
      }
      label331:
      paramInt1 = y.E(arrayOfByte, paramInt1, k);
      AppMethodBeat.o(121575);
      return paramInt1;
      label347:
      paramInt1 = i;
      paramInt2 = j;
    }
  }
  
  protected final int aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121579);
    paramInt1 = a(paramInt1, this.pW, eml() + paramInt2, paramInt3);
    AppMethodBeat.o(121579);
    return paramInt1;
  }
  
  final void b(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(121572);
    paramOutputStream.write(this.pW, eml() + paramInt1, paramInt2);
    AppMethodBeat.o(121572);
  }
  
  protected int eml()
  {
    return 0;
  }
  
  public d.a emm()
  {
    AppMethodBeat.i(121581);
    p.a locala = new p.a(this, (byte)0);
    AppMethodBeat.o(121581);
    return locala;
  }
  
  public final boolean emn()
  {
    AppMethodBeat.i(121574);
    int i = eml();
    boolean bool = y.D(this.pW, i, size() + i);
    AppMethodBeat.o(121574);
    return bool;
  }
  
  public final e emo()
  {
    AppMethodBeat.i(121580);
    e locale = e.a(this);
    AppMethodBeat.o(121580);
    return locale;
  }
  
  protected final int emq()
  {
    return 0;
  }
  
  protected final boolean emr()
  {
    return true;
  }
  
  protected final int ems()
  {
    return this.pJe;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(121576);
    if (paramObject == this)
    {
      AppMethodBeat.o(121576);
      return true;
    }
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(121576);
      return false;
    }
    if (size() != ((d)paramObject).size())
    {
      AppMethodBeat.o(121576);
      return false;
    }
    if (size() == 0)
    {
      AppMethodBeat.o(121576);
      return true;
    }
    boolean bool;
    if ((paramObject instanceof p))
    {
      bool = a((p)paramObject, 0, size());
      AppMethodBeat.o(121576);
      return bool;
    }
    if ((paramObject instanceof u))
    {
      bool = paramObject.equals(this);
      AppMethodBeat.o(121576);
      return bool;
    }
    paramObject = String.valueOf(String.valueOf(paramObject.getClass()));
    paramObject = new IllegalArgumentException(paramObject.length() + 49 + "Has a new type of ByteString been created? Found " + paramObject);
    AppMethodBeat.o(121576);
    throw paramObject;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(121578);
    int j = this.pJe;
    int i = j;
    if (j == 0)
    {
      i = size();
      j = aR(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      this.pJe = i;
    }
    AppMethodBeat.o(121578);
    return i;
  }
  
  protected void i(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(121571);
    System.arraycopy(this.pW, paramInt1, paramArrayOfByte, paramInt2, paramInt3);
    AppMethodBeat.o(121571);
  }
  
  public int size()
  {
    return this.pW.length;
  }
  
  public final String toString(String paramString)
  {
    AppMethodBeat.i(121573);
    paramString = new String(this.pW, eml(), size(), paramString);
    AppMethodBeat.o(121573);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.g.p
 * JD-Core Version:    0.7.0.1
 */