package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class d
  implements h
{
  protected static long hrA;
  protected static Object hrB;
  protected static long hrz;
  protected byte[][] hrC;
  protected i hrD;
  protected String hrl;
  protected i hro;
  protected int hrp;
  protected int hrq;
  protected int hrr;
  protected int hrs;
  protected int hrt;
  protected int hru;
  protected boolean hrv;
  protected boolean hrw;
  protected boolean hrx;
  protected String hry;
  
  static
  {
    AppMethodBeat.i(136766);
    hrz = 0L;
    hrA = 0L;
    hrB = new Object();
    AppMethodBeat.o(136766);
  }
  
  public d()
  {
    AppMethodBeat.i(136761);
    this.hrp = 0;
    this.hrq = 0;
    this.hrr = 0;
    this.hrs = 44100;
    this.hrt = 2;
    this.hru = 2;
    this.hrv = false;
    this.hrw = false;
    this.hrx = false;
    this.hrC = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void Z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.hrp;
    this.hrp = paramInt1;
    this.hrq = paramInt2;
    this.hrr = paramInt3;
    if (this.hrs != this.hrp) {
      if (this.hro == null)
      {
        this.hro = aFw();
        this.hro.p(this.hry, this.hrp, this.hrs);
        if ((this.hrq == 2) && (this.hrt == 2))
        {
          if (this.hrD != null) {
            break label247;
          }
          this.hrD = aFw();
          this.hrD.p(this.hry + "RResample", this.hrp, this.hrs);
        }
        label145:
        this.hrx = true;
      }
    }
    for (;;)
    {
      if (this.hru != this.hrr) {
        this.hrw = true;
      }
      if (this.hrt != this.hrq) {
        this.hrv = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.hro == null) || (i == this.hrp)) {
        break;
      }
      this.hro.release();
      this.hro = aFw();
      this.hro.p(this.hry, this.hrp, this.hrs);
      break;
      label247:
      if ((this.hrD == null) || (i == this.hrp)) {
        break label145;
      }
      this.hrD.release();
      this.hrD = aFw();
      this.hrD.p(this.hry + "RResample", this.hrp, this.hrs);
      break label145;
      this.hrx = false;
      if (this.hro != null)
      {
        this.hro.release();
        this.hro = null;
      }
    }
  }
  
  public i aFw()
  {
    AppMethodBeat.i(136762);
    j localj = new j();
    AppMethodBeat.o(136762);
    return localj;
  }
  
  public void aFx() {}
  
  public e aFy()
  {
    return null;
  }
  
  public void aFz() {}
  
  public byte[] ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136764);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136764);
      return paramArrayOfByte;
    }
    if (this.hrw)
    {
      ??? = c.a(this.hrr, this.hru, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.hrq == 1) && (this.hrt == 2) && (this.hrx))
        {
          paramArrayOfByte = this.hro.ae((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = c.b(this.hrq, this.hrt, this.hru, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.hrq == 2) && (this.hrt == 2) && (this.hrx))
        {
          if ((this.hro instanceof j)) {
            if (this.hrt == 2)
            {
              int i = ???.length / 2;
              if ((this.hrC == null) || (i != this.hrC.length)) {
                this.hrC = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              c.a(this.hru, (byte[])???, this.hrC);
              paramArrayOfByte = this.hro.ae(this.hrC[0]);
              arrayOfByte = this.hrD.ae(this.hrC[1]);
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
            paramArrayOfByte = c.a(this.hru, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.hro.ae((byte[])???);
            continue;
            paramArrayOfByte = this.hro.ae((byte[])???);
          }
        }
        if (this.hrv)
        {
          arrayOfByte = c.b(this.hrq, this.hrt, this.hru, (byte[])???);
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
            if (this.hrx) {}
            synchronized (hrB)
            {
              hrz += 1L;
              System.nanoTime();
              ??? = this.hro.ae(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              ??? = hrB;
              ??? = paramArrayOfByte;
              AppMethodBeat.o(136764);
              return ???;
            }
            paramArrayOfByte = (byte[])???;
          }
        }
      }
      ??? = null;
    }
  }
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.hro != null)
    {
      this.hro.release();
      this.hro = null;
    }
    if (this.hrD != null)
    {
      this.hrD.release();
      this.hrD = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.d
 * JD-Core Version:    0.7.0.1
 */