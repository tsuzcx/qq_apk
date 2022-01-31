package com.tencent.mm.plugin.a;

import com.tencent.mm.sdk.platformtools.y;
import java.io.RandomAccessFile;

public final class e
  extends a
{
  public static final int eUs = c.aG("vide");
  public static final int eUt = c.aG("soun");
  public static final int eUu = c.aG("hint");
  long duration = 0L;
  long eUv = 0L;
  long eUw = 0L;
  long eUx = 0L;
  
  public e(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  public final boolean a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte)
  {
    int m = 0;
    int k = 0;
    int j = 0;
    int n = paramRandomAccessFile.read(paramArrayOfByte);
    while (n >= 8)
    {
      i1 = c.readInt(paramArrayOfByte, 0);
      int i = c.readInt(paramArrayOfByte, 4);
      long l;
      if (i == a.aAB)
      {
        byte[] arrayOfByte = new byte[4];
        i = paramRandomAccessFile.read(arrayOfByte);
        if (i < 4) {
          i = -1;
        }
        while (i <= 0)
        {
          y.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
          return false;
          i += 0;
          if (arrayOfByte[0] == 0)
          {
            if (!c.a(paramRandomAccessFile, 8L))
            {
              i = -1;
            }
            else
            {
              m = paramRandomAccessFile.read(paramArrayOfByte);
              if (m < 8)
              {
                i = -1;
              }
              else
              {
                i = i + 8 + m;
                this.eUv = c.z(paramArrayOfByte, 0);
                this.duration = c.z(paramArrayOfByte, 4);
              }
            }
          }
          else if (!c.a(paramRandomAccessFile, 16L))
          {
            i = -1;
          }
          else
          {
            m = paramRandomAccessFile.read(arrayOfByte);
            if (m < 4)
            {
              i = -1;
            }
            else
            {
              this.eUv = c.z(arrayOfByte, 0);
              int i2 = paramRandomAccessFile.read(paramArrayOfByte);
              if (i2 < 8)
              {
                i = -1;
              }
              else
              {
                i = i2 + (i + 16 + m);
                this.duration = c.K(paramArrayOfByte);
              }
            }
          }
        }
        m = 1;
        l = i1 - n - i;
        i = j;
      }
      for (;;)
      {
        if ((m != 0) && (k != 0))
        {
          i1 = i;
          n = k;
          j = m;
          if (i != 0) {
            break label444;
          }
        }
        if (c.a(paramRandomAccessFile, l)) {
          break;
        }
        return false;
        if (i == a.aAC)
        {
          if (!c.a(paramRandomAccessFile, 8L)) {
            i = -1;
          }
          while (i <= 0)
          {
            y.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
            return false;
            i = paramRandomAccessFile.read(paramArrayOfByte, 0, 4);
            if (i < 4)
            {
              i = -1;
            }
            else
            {
              this.eUw = c.readInt(paramArrayOfByte, 0);
              i += 8;
            }
          }
          k = 1;
          l = i1 - n - i;
          i = j;
        }
        else if (i == a.aAp)
        {
          this.eUx = (paramRandomAccessFile.getFilePointer() - n);
          l = i1 - n;
          i = 1;
        }
        else
        {
          l = i1 - 8;
          i = j;
        }
      }
      n = paramRandomAccessFile.read(paramArrayOfByte);
      j = i;
    }
    int i1 = j;
    j = m;
    n = k;
    label444:
    return (j != 0) && (n != 0) && (i1 != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */