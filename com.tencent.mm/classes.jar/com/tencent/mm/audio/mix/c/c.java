package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class c
  implements g
{
  protected static long dcI;
  protected static long dcJ;
  protected static Object dcK;
  protected int dcA;
  protected int dcB;
  protected int dcC;
  protected boolean dcD;
  protected boolean dcE;
  protected boolean dcF;
  protected String dcG;
  protected String dcH;
  protected byte[][] dcL;
  protected h dcM;
  protected h dcw;
  protected int dcx;
  protected int dcy;
  protected int dcz;
  
  static
  {
    AppMethodBeat.i(136766);
    dcI = 0L;
    dcJ = 0L;
    dcK = new Object();
    AppMethodBeat.o(136766);
  }
  
  public c()
  {
    AppMethodBeat.i(136761);
    this.dcx = 0;
    this.dcy = 0;
    this.dcz = 0;
    this.dcA = 44100;
    this.dcB = 2;
    this.dcC = 2;
    this.dcD = false;
    this.dcE = false;
    this.dcF = false;
    this.dcL = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.dcx;
    this.dcx = paramInt1;
    this.dcy = paramInt2;
    this.dcz = paramInt3;
    if (this.dcA != this.dcx) {
      if (this.dcw == null)
      {
        this.dcw = Oz();
        this.dcw.l(this.dcH, this.dcx, this.dcA);
        if ((this.dcy == 2) && (this.dcB == 2))
        {
          if (this.dcM != null) {
            break label247;
          }
          this.dcM = Oz();
          this.dcM.l(this.dcH + "RResample", this.dcx, this.dcA);
        }
        label145:
        this.dcF = true;
      }
    }
    for (;;)
    {
      if (this.dcC != this.dcz) {
        this.dcE = true;
      }
      if (this.dcB != this.dcy) {
        this.dcD = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.dcw == null) || (i == this.dcx)) {
        break;
      }
      this.dcw.release();
      this.dcw = Oz();
      this.dcw.l(this.dcH, this.dcx, this.dcA);
      break;
      label247:
      if ((this.dcM == null) || (i == this.dcx)) {
        break label145;
      }
      this.dcM.release();
      this.dcM = Oz();
      this.dcM.l(this.dcH + "RResample", this.dcx, this.dcA);
      break label145;
      this.dcF = false;
      if (this.dcw != null)
      {
        this.dcw.release();
        this.dcw = null;
      }
    }
  }
  
  public byte[] J(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136764);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136764);
      return paramArrayOfByte;
    }
    if (this.dcE)
    {
      ??? = b.a(this.dcz, this.dcC, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.dcy == 1) && (this.dcB == 2) && (this.dcF))
        {
          paramArrayOfByte = this.dcw.J((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = b.b(this.dcy, this.dcB, this.dcC, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.dcy == 2) && (this.dcB == 2) && (this.dcF))
        {
          if ((this.dcw instanceof i)) {
            if (this.dcB == 2)
            {
              int i = ???.length / 2;
              if ((this.dcL == null) || (i != this.dcL.length)) {
                this.dcL = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              b.a(this.dcC, (byte[])???, this.dcL);
              paramArrayOfByte = this.dcw.J(this.dcL[0]);
              arrayOfByte = this.dcM.J(this.dcL[1]);
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
            paramArrayOfByte = b.a(this.dcC, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.dcw.J((byte[])???);
            continue;
            paramArrayOfByte = this.dcw.J((byte[])???);
          }
        }
        if (this.dcD)
        {
          arrayOfByte = b.b(this.dcy, this.dcB, this.dcC, (byte[])???);
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
            if (this.dcF) {}
            synchronized (dcK)
            {
              dcI += 1L;
              System.nanoTime();
              ??? = this.dcw.J(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (dcK)
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
  
  public void OA() {}
  
  public e OB()
  {
    return null;
  }
  
  public h Oz()
  {
    AppMethodBeat.i(136762);
    i locali = new i();
    AppMethodBeat.o(136762);
    return locali;
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.dcw != null)
    {
      this.dcw.release();
      this.dcw = null;
    }
    if (this.dcM != null)
    {
      this.dcM.release();
      this.dcM = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.c
 * JD-Core Version:    0.7.0.1
 */