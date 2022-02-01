package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class c
  implements g
{
  protected static long cTV;
  protected static long cTW;
  protected static Object cTX;
  protected h cTJ;
  protected int cTK;
  protected int cTL;
  protected int cTM;
  protected int cTN;
  protected int cTO;
  protected int cTP;
  protected boolean cTQ;
  protected boolean cTR;
  protected boolean cTS;
  protected String cTT;
  protected String cTU;
  protected byte[][] cTY;
  protected h cTZ;
  
  static
  {
    AppMethodBeat.i(136766);
    cTV = 0L;
    cTW = 0L;
    cTX = new Object();
    AppMethodBeat.o(136766);
  }
  
  public c()
  {
    AppMethodBeat.i(136761);
    this.cTK = 0;
    this.cTL = 0;
    this.cTM = 0;
    this.cTN = 44100;
    this.cTO = 2;
    this.cTP = 2;
    this.cTQ = false;
    this.cTR = false;
    this.cTS = false;
    this.cTY = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.cTK;
    this.cTK = paramInt1;
    this.cTL = paramInt2;
    this.cTM = paramInt3;
    if (this.cTN != this.cTK) {
      if (this.cTJ == null)
      {
        this.cTJ = MS();
        this.cTJ.j(this.cTU, this.cTK, this.cTN);
        if ((this.cTL == 2) && (this.cTO == 2))
        {
          if (this.cTZ != null) {
            break label247;
          }
          this.cTZ = MS();
          this.cTZ.j(this.cTU + "RResample", this.cTK, this.cTN);
        }
        label145:
        this.cTS = true;
      }
    }
    for (;;)
    {
      if (this.cTP != this.cTM) {
        this.cTR = true;
      }
      if (this.cTO != this.cTL) {
        this.cTQ = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.cTJ == null) || (i == this.cTK)) {
        break;
      }
      this.cTJ.release();
      this.cTJ = MS();
      this.cTJ.j(this.cTU, this.cTK, this.cTN);
      break;
      label247:
      if ((this.cTZ == null) || (i == this.cTK)) {
        break label145;
      }
      this.cTZ.release();
      this.cTZ = MS();
      this.cTZ.j(this.cTU + "RResample", this.cTK, this.cTN);
      break label145;
      this.cTS = false;
      if (this.cTJ != null)
      {
        this.cTJ.release();
        this.cTJ = null;
      }
    }
  }
  
  public byte[] L(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136764);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136764);
      return paramArrayOfByte;
    }
    if (this.cTR)
    {
      ??? = b.a(this.cTM, this.cTP, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.cTL == 1) && (this.cTO == 2) && (this.cTS))
        {
          paramArrayOfByte = this.cTJ.L((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = b.b(this.cTL, this.cTO, this.cTP, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.cTL == 2) && (this.cTO == 2) && (this.cTS))
        {
          if ((this.cTJ instanceof i)) {
            if (this.cTO == 2)
            {
              int i = ???.length / 2;
              if ((this.cTY == null) || (i != this.cTY.length)) {
                this.cTY = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              b.a(this.cTP, (byte[])???, this.cTY);
              paramArrayOfByte = this.cTJ.L(this.cTY[0]);
              arrayOfByte = this.cTZ.L(this.cTY[1]);
              if ((paramArrayOfByte == null) || (arrayOfByte == null)) {
                paramArrayOfByte = (byte[])???;
              }
            }
          }
          for (;;)
          {
            if (paramArrayOfByte != null) {
              ??? = paramArrayOfByte;
            }
            AppMethodBeat.o(136764);
            return ???;
            paramArrayOfByte = b.a(this.cTP, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.cTJ.L((byte[])???);
            continue;
            paramArrayOfByte = this.cTJ.L((byte[])???);
          }
        }
        if (this.cTQ)
        {
          arrayOfByte = b.b(this.cTL, this.cTO, this.cTP, (byte[])???);
          if (arrayOfByte != null) {
            ??? = arrayOfByte;
          }
        }
        for (;;)
        {
          if (??? == null) {}
          for (;;)
          {
            ??? = paramArrayOfByte;
            if (this.cTS) {}
            synchronized (cTX)
            {
              cTV += 1L;
              System.nanoTime();
              ??? = this.cTJ.L(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (cTX)
              {
                ??? = paramArrayOfByte;
              }
            }
            paramArrayOfByte = finally;
            AppMethodBeat.o(136764);
            throw paramArrayOfByte;
            paramArrayOfByte = (byte[])???;
          }
        }
      }
      ??? = null;
    }
  }
  
  public h MS()
  {
    AppMethodBeat.i(136762);
    i locali = new i();
    AppMethodBeat.o(136762);
    return locali;
  }
  
  public void MT() {}
  
  public e MU()
  {
    return null;
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.cTJ != null)
    {
      this.cTJ.release();
      this.cTJ = null;
    }
    if (this.cTZ != null)
    {
      this.cTZ.release();
      this.cTZ = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.c
 * JD-Core Version:    0.7.0.1
 */