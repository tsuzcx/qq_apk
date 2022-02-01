package com.bumptech.glide.b;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

public final class d
{
  public final byte[] aEo;
  public ByteBuffer aEp;
  public c aEq;
  public int blockSize;
  
  public d()
  {
    AppMethodBeat.i(3468);
    this.aEo = new byte[256];
    this.blockSize = 0;
    AppMethodBeat.o(3468);
  }
  
  private int[] dg(int paramInt)
  {
    AppMethodBeat.i(3472);
    localObject = null;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.aEp.get(arrayOfByte);
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
      this.aEq.status = 1;
      AppMethodBeat.o(3472);
    }
  }
  
  private void ol()
  {
    AppMethodBeat.i(3470);
    do
    {
      oo();
      if (this.aEo[0] == 1)
      {
        int i = this.aEo[1];
        int j = this.aEo[2];
        this.aEq.loopCount = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.blockSize > 0) && (!op()));
    AppMethodBeat.o(3470);
  }
  
  private void on()
  {
    AppMethodBeat.i(3473);
    int i;
    do
    {
      i = read();
      int j = Math.min(this.aEp.position() + i, this.aEp.limit());
      this.aEp.position(j);
    } while (i > 0);
    AppMethodBeat.o(3473);
  }
  
  private void oo()
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
            this.aEp.get(this.aEo, j, i);
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
          this.aEq.status = 1;
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
      int j = this.aEp.get();
      i = j & 0xFF;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.aEq.status = 1;
      }
    }
    AppMethodBeat.o(3475);
    return i;
  }
  
  public final void ok()
  {
    AppMethodBeat.i(3469);
    int i = 0;
    while ((i == 0) && (!op()) && (this.aEq.frameCount <= 2147483647))
    {
      int k;
      int j;
      label186:
      Object localObject;
      boolean bool;
      switch (read())
      {
      default: 
        this.aEq.status = 1;
        break;
      case 44: 
        if (this.aEq.aEi == null) {
          this.aEq.aEi = new b();
        }
        this.aEq.aEi.aDX = this.aEp.getShort();
        this.aEq.aEi.aDY = this.aEp.getShort();
        this.aEq.aEi.aDZ = this.aEp.getShort();
        this.aEq.aEi.aEa = this.aEp.getShort();
        k = read();
        int m;
        if ((k & 0x80) != 0)
        {
          j = 1;
          m = (int)Math.pow(2.0D, (k & 0x7) + 1);
          localObject = this.aEq.aEi;
          if ((k & 0x40) == 0) {
            break label327;
          }
          bool = true;
          ((b)localObject).aEb = bool;
          if (j == 0) {
            break label333;
          }
        }
        for (this.aEq.aEi.aEg = dg(m);; this.aEq.aEi.aEg = null)
        {
          this.aEq.aEi.aEf = this.aEp.position();
          read();
          on();
          if (op()) {
            break;
          }
          localObject = this.aEq;
          ((c)localObject).frameCount += 1;
          this.aEq.aEj.add(this.aEq.aEi);
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
          on();
          break;
        case 249: 
          this.aEq.aEi = new b();
          read();
          j = read();
          this.aEq.aEi.aEd = ((j & 0x1C) >> 2);
          if (this.aEq.aEi.aEd == 0) {
            this.aEq.aEi.aEd = 1;
          }
          localObject = this.aEq.aEi;
          if ((j & 0x1) != 0) {}
          for (bool = true;; bool = false)
          {
            ((b)localObject).aEc = bool;
            k = this.aEp.getShort();
            j = k;
            if (k < 2) {
              j = 10;
            }
            this.aEq.aEi.delay = (j * 10);
            this.aEq.aEi.aEe = read();
            read();
            break;
          }
        case 255: 
          oo();
          localObject = new StringBuilder();
          j = 0;
          while (j < 11)
          {
            ((StringBuilder)localObject).append((char)this.aEo[j]);
            j += 1;
          }
          if (((StringBuilder)localObject).toString().equals("NETSCAPE2.0")) {
            ol();
          } else {
            on();
          }
          break;
        case 254: 
          on();
          break;
        case 1: 
          on();
        }
        break;
      case 59: 
        label221:
        i = 1;
      }
    }
    AppMethodBeat.o(3469);
  }
  
  public final void om()
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
      this.aEq.status = 1;
      AppMethodBeat.o(3471);
      return;
    }
    this.aEq.width = this.aEp.getShort();
    this.aEq.height = this.aEp.getShort();
    i = read();
    localObject = this.aEq;
    if ((i & 0x80) != 0) {}
    for (;;)
    {
      ((c)localObject).aEk = bool;
      this.aEq.aEl = ((int)Math.pow(2.0D, (i & 0x7) + 1));
      this.aEq.aEm = read();
      this.aEq.aEn = read();
      if ((this.aEq.aEk) && (!op()))
      {
        this.aEq.aEh = dg(this.aEq.aEl);
        this.aEq.bgColor = this.aEq.aEh[this.aEq.aEm];
      }
      AppMethodBeat.o(3471);
      return;
      bool = false;
    }
  }
  
  public final boolean op()
  {
    return this.aEq.status != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.b.d
 * JD-Core Version:    0.7.0.1
 */