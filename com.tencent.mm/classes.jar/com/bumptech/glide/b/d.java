package com.bumptech.glide.b;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

public final class d
{
  public final byte[] aCx;
  public ByteBuffer aCy;
  public c aCz;
  public int blockSize;
  
  public d()
  {
    AppMethodBeat.i(3468);
    this.aCx = new byte[256];
    this.blockSize = 0;
    AppMethodBeat.o(3468);
  }
  
  private int[] dm(int paramInt)
  {
    AppMethodBeat.i(3472);
    localObject = null;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.aCy.get(arrayOfByte);
      int[] arrayOfInt = new int[256];
      int j = 0;
      int i = 0;
      for (;;)
      {
        localObject = arrayOfInt;
        if (i >= paramInt) {
          break;
        }
        int n = j + 1;
        int k = arrayOfByte[j];
        int m = n + 1;
        n = arrayOfByte[n];
        j = m + 1;
        arrayOfInt[i] = ((k & 0xFF) << 16 | 0xFF000000 | (n & 0xFF) << 8 | arrayOfByte[m] & 0xFF);
        i += 1;
      }
      return localObject;
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      Log.isLoggable("GifHeaderParser", 3);
      this.aCz.status = 1;
      AppMethodBeat.o(3472);
    }
  }
  
  private void nN()
  {
    AppMethodBeat.i(3470);
    do
    {
      nQ();
      if (this.aCx[0] == 1)
      {
        int i = this.aCx[1];
        int j = this.aCx[2];
        this.aCz.loopCount = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.blockSize > 0) && (!nR()));
    AppMethodBeat.o(3470);
  }
  
  private void nP()
  {
    AppMethodBeat.i(3473);
    int i;
    do
    {
      i = read();
      int j = Math.min(this.aCy.position() + i, this.aCy.limit());
      this.aCy.position(j);
    } while (i > 0);
    AppMethodBeat.o(3473);
  }
  
  private void nQ()
  {
    AppMethodBeat.i(3474);
    this.blockSize = read();
    if (this.blockSize > 0)
    {
      int i = 0;
      int j = 0;
      for (;;)
      {
        int k = i;
        try
        {
          if (j < this.blockSize)
          {
            k = i;
            i = this.blockSize - j;
            k = i;
            this.aCy.get(this.aCx, j, i);
            j += i;
          }
          else
          {
            AppMethodBeat.o(3474);
            return;
          }
        }
        catch (Exception localException)
        {
          if (Log.isLoggable("GifHeaderParser", 3)) {
            new StringBuilder("Error Reading Block n: ").append(j).append(" count: ").append(k).append(" blockSize: ").append(this.blockSize);
          }
          this.aCz.status = 1;
        }
      }
    }
    AppMethodBeat.o(3474);
  }
  
  private int read()
  {
    AppMethodBeat.i(3475);
    int i = 0;
    try
    {
      int j = this.aCy.get();
      i = j & 0xFF;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.aCz.status = 1;
      }
    }
    AppMethodBeat.o(3475);
    return i;
  }
  
  public final void nM()
  {
    AppMethodBeat.i(3469);
    int i = 0;
    while ((i == 0) && (!nR()) && (this.aCz.frameCount <= 2147483647))
    {
      int k;
      int j;
      label186:
      Object localObject;
      boolean bool;
      switch (read())
      {
      default: 
        this.aCz.status = 1;
        break;
      case 44: 
        if (this.aCz.aCr == null) {
          this.aCz.aCr = new b();
        }
        this.aCz.aCr.aCg = this.aCy.getShort();
        this.aCz.aCr.aCh = this.aCy.getShort();
        this.aCz.aCr.aCi = this.aCy.getShort();
        this.aCz.aCr.aCj = this.aCy.getShort();
        k = read();
        int m;
        if ((k & 0x80) != 0)
        {
          j = 1;
          m = (int)Math.pow(2.0D, (k & 0x7) + 1);
          localObject = this.aCz.aCr;
          if ((k & 0x40) == 0) {
            break label327;
          }
          bool = true;
          ((b)localObject).aCk = bool;
          if (j == 0) {
            break label333;
          }
        }
        for (this.aCz.aCr.aCp = dm(m);; this.aCz.aCr.aCp = null)
        {
          this.aCz.aCr.aCo = this.aCy.position();
          read();
          nP();
          if (nR()) {
            break;
          }
          localObject = this.aCz;
          ((c)localObject).frameCount += 1;
          this.aCz.aCs.add(this.aCz.aCr);
          break;
          j = 0;
          break label186;
          bool = false;
          break label221;
        }
      case 33: 
        label327:
        label333:
        switch (read())
        {
        default: 
          nP();
          break;
        case 249: 
          this.aCz.aCr = new b();
          read();
          j = read();
          this.aCz.aCr.aCm = ((j & 0x1C) >> 2);
          if (this.aCz.aCr.aCm == 0) {
            this.aCz.aCr.aCm = 1;
          }
          localObject = this.aCz.aCr;
          if ((j & 0x1) != 0) {}
          for (bool = true;; bool = false)
          {
            ((b)localObject).aCl = bool;
            k = this.aCy.getShort();
            j = k;
            if (k < 2) {
              j = 10;
            }
            this.aCz.aCr.delay = (j * 10);
            this.aCz.aCr.aCn = read();
            read();
            break;
          }
        case 255: 
          nQ();
          localObject = new StringBuilder();
          j = 0;
          while (j < 11)
          {
            ((StringBuilder)localObject).append((char)this.aCx[j]);
            j += 1;
          }
          if (((StringBuilder)localObject).toString().equals("NETSCAPE2.0")) {
            nN();
          } else {
            nP();
          }
          break;
        case 254: 
          nP();
          break;
        case 1: 
          nP();
        }
        break;
      case 59: 
        label221:
        i = 1;
      }
    }
    AppMethodBeat.o(3469);
  }
  
  public final void nO()
  {
    boolean bool = true;
    AppMethodBeat.i(3471);
    Object localObject = new StringBuilder();
    int i = 0;
    while (i < 6)
    {
      ((StringBuilder)localObject).append((char)read());
      i += 1;
    }
    if (!((StringBuilder)localObject).toString().startsWith("GIF"))
    {
      this.aCz.status = 1;
      AppMethodBeat.o(3471);
      return;
    }
    this.aCz.width = this.aCy.getShort();
    this.aCz.height = this.aCy.getShort();
    i = read();
    localObject = this.aCz;
    if ((i & 0x80) != 0) {}
    for (;;)
    {
      ((c)localObject).aCt = bool;
      this.aCz.aCu = ((int)Math.pow(2.0D, (i & 0x7) + 1));
      this.aCz.aCv = read();
      this.aCz.aCw = read();
      if ((this.aCz.aCt) && (!nR()))
      {
        this.aCz.aCq = dm(this.aCz.aCu);
        this.aCz.bgColor = this.aCz.aCq[this.aCz.aCv];
      }
      AppMethodBeat.o(3471);
      return;
      bool = false;
    }
  }
  
  public final boolean nR()
  {
    return this.aCz.status != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.b.d
 * JD-Core Version:    0.7.0.1
 */