package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class d
  implements h
{
  protected static long duG;
  protected static long duH;
  protected static Object duI;
  protected int duA;
  protected int duB;
  protected boolean duC;
  protected boolean duD;
  protected boolean duE;
  protected String duF;
  protected byte[][] duJ;
  protected i duK;
  protected String dus;
  protected i duv;
  protected int duw;
  protected int dux;
  protected int duy;
  protected int duz;
  
  static
  {
    AppMethodBeat.i(136766);
    duG = 0L;
    duH = 0L;
    duI = new Object();
    AppMethodBeat.o(136766);
  }
  
  public d()
  {
    AppMethodBeat.i(136761);
    this.duw = 0;
    this.dux = 0;
    this.duy = 0;
    this.duz = 44100;
    this.duA = 2;
    this.duB = 2;
    this.duC = false;
    this.duD = false;
    this.duE = false;
    this.duJ = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void G(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.duw;
    this.duw = paramInt1;
    this.dux = paramInt2;
    this.duy = paramInt3;
    if (this.duz != this.duw) {
      if (this.duv == null)
      {
        this.duv = YQ();
        this.duv.l(this.duF, this.duw, this.duz);
        if ((this.dux == 2) && (this.duA == 2))
        {
          if (this.duK != null) {
            break label247;
          }
          this.duK = YQ();
          this.duK.l(this.duF + "RResample", this.duw, this.duz);
        }
        label145:
        this.duE = true;
      }
    }
    for (;;)
    {
      if (this.duB != this.duy) {
        this.duD = true;
      }
      if (this.duA != this.dux) {
        this.duC = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.duv == null) || (i == this.duw)) {
        break;
      }
      this.duv.release();
      this.duv = YQ();
      this.duv.l(this.duF, this.duw, this.duz);
      break;
      label247:
      if ((this.duK == null) || (i == this.duw)) {
        break label145;
      }
      this.duK.release();
      this.duK = YQ();
      this.duK.l(this.duF + "RResample", this.duw, this.duz);
      break label145;
      this.duE = false;
      if (this.duv != null)
      {
        this.duv.release();
        this.duv = null;
      }
    }
  }
  
  public byte[] X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136764);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136764);
      return paramArrayOfByte;
    }
    if (this.duD)
    {
      ??? = c.a(this.duy, this.duB, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.dux == 1) && (this.duA == 2) && (this.duE))
        {
          paramArrayOfByte = this.duv.X((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = c.b(this.dux, this.duA, this.duB, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.dux == 2) && (this.duA == 2) && (this.duE))
        {
          if ((this.duv instanceof j)) {
            if (this.duA == 2)
            {
              int i = ???.length / 2;
              if ((this.duJ == null) || (i != this.duJ.length)) {
                this.duJ = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              c.a(this.duB, (byte[])???, this.duJ);
              paramArrayOfByte = this.duv.X(this.duJ[0]);
              arrayOfByte = this.duK.X(this.duJ[1]);
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
            paramArrayOfByte = c.a(this.duB, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.duv.X((byte[])???);
            continue;
            paramArrayOfByte = this.duv.X((byte[])???);
          }
        }
        if (this.duC)
        {
          arrayOfByte = c.b(this.dux, this.duA, this.duB, (byte[])???);
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
            if (this.duE) {}
            synchronized (duI)
            {
              duG += 1L;
              System.nanoTime();
              ??? = this.duv.X(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (duI)
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
  
  public i YQ()
  {
    AppMethodBeat.i(136762);
    j localj = new j();
    AppMethodBeat.o(136762);
    return localj;
  }
  
  public void YR() {}
  
  public e YS()
  {
    return null;
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.duv != null)
    {
      this.duv.release();
      this.duv = null;
    }
    if (this.duK != null)
    {
      this.duK.release();
      this.duK = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.d
 * JD-Core Version:    0.7.0.1
 */