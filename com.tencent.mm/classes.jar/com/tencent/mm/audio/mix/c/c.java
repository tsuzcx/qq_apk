package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.d;
import java.lang.reflect.Array;

public class c
  implements g
{
  protected static long ceW;
  protected static long ceX;
  protected static Object ceY;
  protected h ceK;
  protected int ceL;
  protected int ceM;
  protected int ceN;
  protected int ceO;
  protected int ceP;
  protected int ceQ;
  protected boolean ceR;
  protected boolean ceS;
  protected boolean ceT;
  protected String ceU;
  protected String ceV;
  protected byte[][] ceZ;
  protected h cfa;
  
  static
  {
    AppMethodBeat.i(137018);
    ceW = 0L;
    ceX = 0L;
    ceY = new Object();
    AppMethodBeat.o(137018);
  }
  
  public c()
  {
    AppMethodBeat.i(137013);
    this.ceL = 0;
    this.ceM = 0;
    this.ceN = 0;
    this.ceO = 44100;
    this.ceP = 2;
    this.ceQ = 2;
    this.ceR = false;
    this.ceS = false;
    this.ceT = false;
    this.ceZ = new byte[2][];
    AppMethodBeat.o(137013);
  }
  
  public final void C(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(137015);
    int i = this.ceL;
    this.ceL = paramInt1;
    this.ceM = paramInt2;
    this.ceN = paramInt3;
    if (this.ceO != this.ceL) {
      if (this.ceK == null)
      {
        this.ceK = Dj();
        this.ceK.k(this.ceV, this.ceL, this.ceO);
        if ((this.ceM == 2) && (this.ceP == 2))
        {
          if (this.cfa != null) {
            break label247;
          }
          this.cfa = Dj();
          this.cfa.k(this.ceV + "RResample", this.ceL, this.ceO);
        }
        label145:
        this.ceT = true;
      }
    }
    for (;;)
    {
      if (this.ceQ != this.ceN) {
        this.ceS = true;
      }
      if (this.ceP != this.ceM) {
        this.ceR = true;
      }
      AppMethodBeat.o(137015);
      return;
      if ((this.ceK == null) || (i == this.ceL)) {
        break;
      }
      this.ceK.release();
      this.ceK = Dj();
      this.ceK.k(this.ceV, this.ceL, this.ceO);
      break;
      label247:
      if ((this.cfa == null) || (i == this.ceL)) {
        break label145;
      }
      this.cfa.release();
      this.cfa = Dj();
      this.cfa.k(this.ceV + "RResample", this.ceL, this.ceO);
      break label145;
      this.ceT = false;
      if (this.ceK != null)
      {
        this.ceK.release();
        this.ceK = null;
      }
    }
  }
  
  public h Dj()
  {
    AppMethodBeat.i(137014);
    i locali = new i();
    AppMethodBeat.o(137014);
    return locali;
  }
  
  public void Dk() {}
  
  public d Dl()
  {
    return null;
  }
  
  public byte[] E(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(137016);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(137016);
      return paramArrayOfByte;
    }
    if (this.ceS)
    {
      ??? = b.b(this.ceN, this.ceQ, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.ceM == 1) && (this.ceP == 2) && (this.ceT))
        {
          paramArrayOfByte = this.ceK.E((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = b.c(this.ceM, this.ceP, this.ceQ, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(137016);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.ceM == 2) && (this.ceP == 2) && (this.ceT))
        {
          if ((this.ceK instanceof i)) {
            if (this.ceP == 2)
            {
              int i = ???.length / 2;
              if ((this.ceZ == null) || (i != this.ceZ.length)) {
                this.ceZ = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              b.a(this.ceQ, (byte[])???, this.ceZ);
              paramArrayOfByte = this.ceK.E(this.ceZ[0]);
              arrayOfByte = this.cfa.E(this.ceZ[1]);
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
            AppMethodBeat.o(137016);
            return ???;
            paramArrayOfByte = b.a(this.ceQ, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.ceK.E((byte[])???);
            continue;
            paramArrayOfByte = this.ceK.E((byte[])???);
          }
        }
        if (this.ceR)
        {
          arrayOfByte = b.c(this.ceM, this.ceP, this.ceQ, (byte[])???);
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
            if (this.ceT) {}
            synchronized (ceY)
            {
              ceW += 1L;
              System.nanoTime();
              ??? = this.ceK.E(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (ceY)
              {
                ??? = paramArrayOfByte;
              }
            }
            paramArrayOfByte = finally;
            AppMethodBeat.o(137016);
            throw paramArrayOfByte;
            paramArrayOfByte = (byte[])???;
          }
        }
      }
      ??? = null;
    }
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(137017);
    if (this.ceK != null)
    {
      this.ceK.release();
      this.ceK = null;
    }
    if (this.cfa != null)
    {
      this.cfa.release();
      this.cfa = null;
    }
    AppMethodBeat.o(137017);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.c
 * JD-Core Version:    0.7.0.1
 */