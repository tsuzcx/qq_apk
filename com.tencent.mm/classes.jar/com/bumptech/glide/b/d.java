package com.bumptech.glide.b;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.List;

public final class d
{
  public final byte[] aBF;
  public ByteBuffer aBG;
  public c aBH;
  public int blockSize;
  
  public d()
  {
    AppMethodBeat.i(3468);
    this.aBF = new byte[256];
    this.blockSize = 0;
    AppMethodBeat.o(3468);
  }
  
  private int[] dn(int paramInt)
  {
    AppMethodBeat.i(3472);
    localObject = null;
    byte[] arrayOfByte = new byte[paramInt * 3];
    try
    {
      this.aBG.get(arrayOfByte);
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
      this.aBH.status = 1;
      AppMethodBeat.o(3472);
    }
  }
  
  private void nD()
  {
    AppMethodBeat.i(3470);
    do
    {
      nG();
      if (this.aBF[0] == 1)
      {
        int i = this.aBF[1];
        int j = this.aBF[2];
        this.aBH.loopCount = (i & 0xFF | (j & 0xFF) << 8);
      }
    } while ((this.blockSize > 0) && (!nH()));
    AppMethodBeat.o(3470);
  }
  
  private void nF()
  {
    AppMethodBeat.i(3473);
    int i;
    do
    {
      i = read();
      int j = Math.min(this.aBG.position() + i, this.aBG.limit());
      this.aBG.position(j);
    } while (i > 0);
    AppMethodBeat.o(3473);
  }
  
  private void nG()
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
            this.aBG.get(this.aBF, j, i);
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
          this.aBH.status = 1;
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
      int j = this.aBG.get();
      i = j & 0xFF;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.aBH.status = 1;
      }
    }
    AppMethodBeat.o(3475);
    return i;
  }
  
  public final void nC()
  {
    AppMethodBeat.i(3469);
    int i = 0;
    while ((i == 0) && (!nH()) && (this.aBH.frameCount <= 2147483647))
    {
      int k;
      int j;
      label186:
      Object localObject;
      boolean bool;
      switch (read())
      {
      default: 
        this.aBH.status = 1;
        break;
      case 44: 
        if (this.aBH.aBy == null) {
          this.aBH.aBy = new b();
        }
        this.aBH.aBy.aBn = this.aBG.getShort();
        this.aBH.aBy.aBo = this.aBG.getShort();
        this.aBH.aBy.aBp = this.aBG.getShort();
        this.aBH.aBy.aBq = this.aBG.getShort();
        k = read();
        int m;
        if ((k & 0x80) != 0)
        {
          j = 1;
          m = (int)Math.pow(2.0D, (k & 0x7) + 1);
          localObject = this.aBH.aBy;
          if ((k & 0x40) == 0) {
            break label327;
          }
          bool = true;
          ((b)localObject).aBr = bool;
          if (j == 0) {
            break label333;
          }
        }
        for (this.aBH.aBy.aBw = dn(m);; this.aBH.aBy.aBw = null)
        {
          this.aBH.aBy.aBv = this.aBG.position();
          read();
          nF();
          if (nH()) {
            break;
          }
          localObject = this.aBH;
          ((c)localObject).frameCount += 1;
          this.aBH.aBz.add(this.aBH.aBy);
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
          nF();
          break;
        case 249: 
          this.aBH.aBy = new b();
          read();
          j = read();
          this.aBH.aBy.aBt = ((j & 0x1C) >> 2);
          if (this.aBH.aBy.aBt == 0) {
            this.aBH.aBy.aBt = 1;
          }
          localObject = this.aBH.aBy;
          if ((j & 0x1) != 0) {}
          for (bool = true;; bool = false)
          {
            ((b)localObject).aBs = bool;
            k = this.aBG.getShort();
            j = k;
            if (k < 2) {
              j = 10;
            }
            this.aBH.aBy.delay = (j * 10);
            this.aBH.aBy.aBu = read();
            read();
            break;
          }
        case 255: 
          nG();
          localObject = new StringBuilder();
          j = 0;
          while (j < 11)
          {
            ((StringBuilder)localObject).append((char)this.aBF[j]);
            j += 1;
          }
          if (((StringBuilder)localObject).toString().equals("NETSCAPE2.0")) {
            nD();
          } else {
            nF();
          }
          break;
        case 254: 
          nF();
          break;
        case 1: 
          nF();
        }
        break;
      case 59: 
        label221:
        i = 1;
      }
    }
    AppMethodBeat.o(3469);
  }
  
  public final void nE()
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
      this.aBH.status = 1;
      AppMethodBeat.o(3471);
      return;
    }
    this.aBH.width = this.aBG.getShort();
    this.aBH.height = this.aBG.getShort();
    i = read();
    localObject = this.aBH;
    if ((i & 0x80) != 0) {}
    for (;;)
    {
      ((c)localObject).aBA = bool;
      this.aBH.aBB = ((int)Math.pow(2.0D, (i & 0x7) + 1));
      this.aBH.aBC = read();
      this.aBH.aBD = read();
      if ((this.aBH.aBA) && (!nH()))
      {
        this.aBH.aBx = dn(this.aBH.aBB);
        this.aBH.bgColor = this.aBH.aBx[this.aBH.aBC];
      }
      AppMethodBeat.o(3471);
      return;
      bool = false;
    }
  }
  
  public final boolean nH()
  {
    return this.aBH.status != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.b.d
 * JD-Core Version:    0.7.0.1
 */