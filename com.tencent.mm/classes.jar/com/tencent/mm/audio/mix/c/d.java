package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.a.e;
import java.lang.reflect.Array;

public class d
  implements h
{
  protected static long fno;
  protected static long fnp;
  protected static Object fnq;
  protected String fna;
  protected i fnd;
  protected int fne;
  protected int fnf;
  protected int fng;
  protected int fnh;
  protected int fni;
  protected int fnj;
  protected boolean fnk;
  protected boolean fnl;
  protected boolean fnm;
  protected String fnn;
  protected byte[][] fnr;
  protected i fns;
  
  static
  {
    AppMethodBeat.i(136766);
    fno = 0L;
    fnp = 0L;
    fnq = new Object();
    AppMethodBeat.o(136766);
  }
  
  public d()
  {
    AppMethodBeat.i(136761);
    this.fne = 0;
    this.fnf = 0;
    this.fng = 0;
    this.fnh = 44100;
    this.fni = 2;
    this.fnj = 2;
    this.fnk = false;
    this.fnl = false;
    this.fnm = false;
    this.fnr = new byte[2][];
    AppMethodBeat.o(136761);
  }
  
  public final void J(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(136763);
    int i = this.fne;
    this.fne = paramInt1;
    this.fnf = paramInt2;
    this.fng = paramInt3;
    if (this.fnh != this.fne) {
      if (this.fnd == null)
      {
        this.fnd = adx();
        this.fnd.m(this.fnn, this.fne, this.fnh);
        if ((this.fnf == 2) && (this.fni == 2))
        {
          if (this.fns != null) {
            break label247;
          }
          this.fns = adx();
          this.fns.m(this.fnn + "RResample", this.fne, this.fnh);
        }
        label145:
        this.fnm = true;
      }
    }
    for (;;)
    {
      if (this.fnj != this.fng) {
        this.fnl = true;
      }
      if (this.fni != this.fnf) {
        this.fnk = true;
      }
      AppMethodBeat.o(136763);
      return;
      if ((this.fnd == null) || (i == this.fne)) {
        break;
      }
      this.fnd.adB();
      this.fnd = adx();
      this.fnd.m(this.fnn, this.fne, this.fnh);
      break;
      label247:
      if ((this.fns == null) || (i == this.fne)) {
        break label145;
      }
      this.fns.adB();
      this.fns = adx();
      this.fns.m(this.fnn + "RResample", this.fne, this.fnh);
      break label145;
      this.fnm = false;
      if (this.fnd != null)
      {
        this.fnd.adB();
        this.fnd = null;
      }
    }
  }
  
  public void adA() {}
  
  public i adx()
  {
    AppMethodBeat.i(136762);
    j localj = new j();
    AppMethodBeat.o(136762);
    return localj;
  }
  
  public void ady() {}
  
  public e adz()
  {
    return null;
  }
  
  public byte[] ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(136764);
    if (paramArrayOfByte == null)
    {
      AppMethodBeat.o(136764);
      return paramArrayOfByte;
    }
    if (this.fnl)
    {
      ??? = c.a(this.fng, this.fnj, paramArrayOfByte);
      if (??? == null) {}
    }
    for (;;)
    {
      if (??? == null) {
        ??? = paramArrayOfByte;
      }
      for (;;)
      {
        if ((this.fnf == 1) && (this.fni == 2) && (this.fnm))
        {
          paramArrayOfByte = this.fnd.ae((byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          paramArrayOfByte = c.b(this.fnf, this.fni, this.fnj, (byte[])???);
          if (paramArrayOfByte != null) {
            ??? = paramArrayOfByte;
          }
          AppMethodBeat.o(136764);
          return ???;
        }
        byte[] arrayOfByte;
        if ((this.fnf == 2) && (this.fni == 2) && (this.fnm))
        {
          if ((this.fnd instanceof j)) {
            if (this.fni == 2)
            {
              int i = ???.length / 2;
              if ((this.fnr == null) || (i != this.fnr.length)) {
                this.fnr = ((byte[][])Array.newInstance(Byte.TYPE, new int[] { 2, i }));
              }
              c.a(this.fnj, (byte[])???, this.fnr);
              paramArrayOfByte = this.fnd.ae(this.fnr[0]);
              arrayOfByte = this.fns.ae(this.fnr[1]);
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
            paramArrayOfByte = c.a(this.fnj, paramArrayOfByte, arrayOfByte);
            continue;
            paramArrayOfByte = this.fnd.ae((byte[])???);
            continue;
            paramArrayOfByte = this.fnd.ae((byte[])???);
          }
        }
        if (this.fnk)
        {
          arrayOfByte = c.b(this.fnf, this.fni, this.fnj, (byte[])???);
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
            if (this.fnm) {}
            synchronized (fnq)
            {
              fno += 1L;
              System.nanoTime();
              ??? = this.fnd.ae(paramArrayOfByte);
              if (??? != null) {
                paramArrayOfByte = (byte[])???;
              }
              ??? = fnq;
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
    if (this.fnd != null)
    {
      this.fnd.adB();
      this.fnd = null;
    }
    if (this.fns != null)
    {
      this.fns.adB();
      this.fns = null;
    }
    AppMethodBeat.o(136765);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.c.d
 * JD-Core Version:    0.7.0.1
 */