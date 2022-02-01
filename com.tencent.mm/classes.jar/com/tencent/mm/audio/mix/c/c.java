package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class c
  implements g
{
  protected static long cRs;
  protected static long cRt;
  protected static Object cRu;
  protected h cRg;
  protected int cRh;
  protected int cRi;
  protected int cRj;
  protected int cRk;
  protected int cRl;
  protected int cRm;
  protected boolean cRn;
  protected boolean cRo;
  protected boolean cRp;
  protected String cRq;
  protected String cRr;
  protected byte[][] cRv;
  protected h cRw;
  
  static
  {
    AppMethodBeat.i(136766);
    cRs = 0L;
    cRt = 0L;
    cRu = new Object();
    AppMethodBeat.o(136766);
  }
  
  public c()
  {
    AppMethodBeat.i(136761);
    this.cRh = 0;
    this.cRi = 0;
    this.cRj = 0;
    this.cRk = 44100;
    this.cRl = 2;
    this.cRm = 2;
    this.cRn = false;
    this.cRo = false;
    this.cRp = false;
    this.cRv = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void F(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.cRh;
    this.cRh = paramInt1;
    this.cRi = paramInt2;
    this.cRj = paramInt3;
    if (this.cRk != this.cRh) {
      if (this.cRg == null)
      {
        this.cRg = MQ();
        this.cRg.j(this.cRr, this.cRh, this.cRk);
        if ((this.cRi == 2) && (this.cRl == 2))
        {
          if (this.cRw != null) {
            break label247;
          }
          this.cRw = MQ();
          this.cRw.j(this.cRr + "RResample", this.cRh, this.cRk);
        }
        label145:
        this.cRp = true;
      }
    }
    for (;;)
    {
      if (this.cRm != this.cRj) {
        this.cRo = true;
      }
      if (this.cRl != this.cRi) {
        this.cRn = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.cRg == null) || (i == this.cRh)) {
        break;
      }
      this.cRg.release();
      this.cRg = MQ();
      this.cRg.j(this.cRr, this.cRh, this.cRk);
      break;
      label247:
      if ((this.cRw == null) || (i == this.cRh)) {
        break label145;
      }
      this.cRw.release();
      this.cRw = MQ();
      this.cRw.j(this.cRr + "RResample", this.cRh, this.cRk);
      break label145;
      this.cRp = false;
      if (this.cRg != null)
      {
        this.cRg.release();
        this.cRg = null;
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
    if (this.cRo)
    {
      ??? = b.a(this.cRj, this.cRm, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.cRi == 1) && (this.cRl == 2) && (this.cRp))
        {
          paramArrayOfByte = this.cRg.J((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = b.b(this.cRi, this.cRl, this.cRm, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.cRi == 2) && (this.cRl == 2) && (this.cRp))
        {
          if ((this.cRg instanceof i)) {
            if (this.cRl == 2)
            {
              int i = ???.length / 2;
              if ((this.cRv == null) || (i != this.cRv.length)) {
                this.cRv = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              b.a(this.cRm, (byte[])???, this.cRv);
              paramArrayOfByte = this.cRg.J(this.cRv[0]);
              arrayOfByte = this.cRw.J(this.cRv[1]);
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
            paramArrayOfByte = b.a(this.cRm, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.cRg.J((byte[])???);
            continue;
            paramArrayOfByte = this.cRg.J((byte[])???);
          }
        }
        if (this.cRn)
        {
          arrayOfByte = b.b(this.cRi, this.cRl, this.cRm, (byte[])???);
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
            if (this.cRp) {}
            synchronized (cRu)
            {
              cRs += 1L;
              System.nanoTime();
              ??? = this.cRg.J(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              synchronized (cRu)
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
  
  public h MQ()
  {
    AppMethodBeat.i(136762);
    i locali = new i();
    AppMethodBeat.o(136762);
    return locali;
  }
  
  public void MR() {}
  
  public e MS()
  {
    return null;
  }
  
  public void flushCache() {}
  
  public void release()
  {
    AppMethodBeat.i(136765);
    if (this.cRg != null)
    {
      this.cRg.release();
      this.cRg = null;
    }
    if (this.cRw != null)
    {
      this.cRw.release();
      this.cRw = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.c
 * JD-Core Version:    0.7.0.1
 */