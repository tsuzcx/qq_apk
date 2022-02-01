package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.RandomAccessFile;

public final class g
  extends a
{
  public static final int iTv;
  public static final int iTw;
  public static final int iTx;
  public long duration = 0L;
  long iTA = 0L;
  public long iTy = 0L;
  public long iTz = 0L;
  
  static
  {
    AppMethodBeat.i(133867);
    iTv = c.bJ("vide");
    iTw = c.bJ("soun");
    iTx = c.bJ("hint");
    AppMethodBeat.o(133867);
  }
  
  public g(int paramInt1, long paramLong, int paramInt2)
  {
    super(paramInt1, paramLong, paramInt2, 0L);
  }
  
  public final boolean a(RandomAccessFile paramRandomAccessFile, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133866);
    int m = 0;
    int k = 0;
    int j = 0;
    int n = paramRandomAccessFile.read(paramArrayOfByte);
    while (n >= 8)
    {
      i1 = c.readInt(paramArrayOfByte, 0);
      int i = c.readInt(paramArrayOfByte, 4);
      long l;
      if (i == a.blF)
      {
        byte[] arrayOfByte = new byte[4];
        i = paramRandomAccessFile.read(arrayOfByte);
        if (i < 4) {
          i = -1;
        }
        while (i <= 0)
        {
          ae.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
          AppMethodBeat.o(133866);
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
                this.iTy = c.B(paramArrayOfByte, 0);
                this.duration = c.B(paramArrayOfByte, 4);
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
              this.iTy = c.B(arrayOfByte, 0);
              int i2 = paramRandomAccessFile.read(paramArrayOfByte);
              if (i2 < 8)
              {
                i = -1;
              }
              else
              {
                i = i2 + (i + 16 + m);
                this.duration = c.an(paramArrayOfByte);
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
            break label464;
          }
        }
        if (c.a(paramRandomAccessFile, l)) {
          break;
        }
        AppMethodBeat.o(133866);
        return false;
        if (i == a.blG)
        {
          if (!c.a(paramRandomAccessFile, 8L)) {
            i = -1;
          }
          while (i <= 0)
          {
            ae.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
            AppMethodBeat.o(133866);
            return false;
            i = paramRandomAccessFile.read(paramArrayOfByte, 0, 4);
            if (i < 4)
            {
              i = -1;
            }
            else
            {
              this.iTz = c.readInt(paramArrayOfByte, 0);
              i += 8;
            }
          }
          k = 1;
          l = i1 - n - i;
          i = j;
        }
        else if (i == a.blt)
        {
          this.iTA = (paramRandomAccessFile.getFilePointer() - n);
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
    label464:
    if ((j != 0) && (n != 0) && (i1 != 0))
    {
      AppMethodBeat.o(133866);
      return true;
    }
    AppMethodBeat.o(133866);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.g
 * JD-Core Version:    0.7.0.1
 */