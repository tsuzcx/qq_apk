package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class c
  implements g
{
  protected static long ddK;
  protected static long ddL;
  protected static Object ddM;
  protected int ddA;
  protected int ddB;
  protected int ddC;
  protected int ddD;
  protected int ddE;
  protected boolean ddF;
  protected boolean ddG;
  protected boolean ddH;
  protected String ddI;
  protected String ddJ;
  protected byte[][] ddN;
  protected h ddO;
  protected h ddy;
  protected int ddz;
  
  static
  {
    AppMethodBeat.i(136766);
    ddK = 0L;
    ddL = 0L;
    ddM = new Object();
    AppMethodBeat.o(136766);
  }
  
  public c()
  {
    AppMethodBeat.i(136761);
    this.ddz = 0;
    this.ddA = 0;
    this.ddB = 0;
    this.ddC = 44100;
    this.ddD = 2;
    this.ddE = 2;
    this.ddF = false;
    this.ddG = false;
    this.ddH = false;
    this.ddN = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.ddz;
    this.ddz = paramInt1;
    this.ddA = paramInt2;
    this.ddB = paramInt3;
    if (this.ddC != this.ddz) {
      if (this.ddy == null)
      {
        this.ddy = Ox();
        this.ddy.l(this.ddJ, this.ddz, this.ddC);
        if ((this.ddA == 2) && (this.ddD == 2))
        {
          if (this.ddO != null) {
            break label247;
          }
          this.ddO = Ox();
          this.ddO.l(this.ddJ + "RResample", this.ddz, this.ddC);
        }
        label145:
        this.ddH = true;
      }
    }
    for (;;)
    {
      if (this.ddE != this.ddB) {
        this.ddG = true;
      }
      if (this.ddD != this.ddA) {
        this.ddF = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.ddy == null) || (i == this.ddz)) {
        break;
      }
      this.ddy.release();
      this.ddy = Ox();
      this.ddy.l(this.ddJ, this.ddz, this.ddC);
      break;
      label247:
      if ((this.ddO == null) || (i == this.ddz)) {
        break label145;
      }
      this.ddO.release();
      this.ddO = Ox();
      this.ddO.l(this.ddJ + "RResample", this.ddz, this.ddC);
      break label145;
      this.ddH = false;
      if (this.ddy != null)
      {
        this.ddy.release();
        this.ddy = null;
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
    if (this.ddG)
    {
      ??? = b.a(this.ddB, this.ddE, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.ddA == 1) && (this.ddD == 2) && (this.ddH))
        {
          paramArrayOfByte = this.ddy.J((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = b.b(this.ddA, this.ddD, this.ddE, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.ddA == 2) && (this.ddD == 2) && (this.ddH))
        {
          if ((this.ddy instanceof i)) {
            if (this.ddD == 2)
            {
              int i = ???.length / 2;
              if ((this.ddN == null) || (i != this.ddN.length)) {
                this.ddN = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              b.a(this.ddE, (byte[])???, this.ddN);
              paramArrayOfByte = this.ddy.J(this.ddN[0]);
              arrayOfByte = this.ddO.J(this.ddN[1]);
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
            paramArrayOfByte = b.a(this.ddE, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.ddy.J((byte[])???);
            continue;
            paramArrayOfByte = this.ddy.J((byte[])???);
          }
        }
        if (this.ddF)
        {
          arrayOfByte = b.b(this.ddA, this.ddD, this.ddE, (byte[])???);
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
            if (this.ddH) {}
            synchronized (ddM)
            {
              ddK += 1L;
              System.nanoTime();
              ??? = this.ddy.J(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (ddM)
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
  
  public h Ox()
  {
    AppMethodBeat.i(136762);
    i locali = new i();
    AppMethodBeat.o(136762);
    return locali;
  }
  
  public void Oy() {}
  
  public e Oz()
  {
    return null;
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.ddy != null)
    {
      this.ddy.release();
      this.ddy = null;
    }
    if (this.ddO != null)
    {
      this.ddO.release();
      this.ddO = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.c
 * JD-Core Version:    0.7.0.1
 */