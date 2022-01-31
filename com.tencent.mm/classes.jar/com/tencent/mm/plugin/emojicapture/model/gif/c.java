package com.tencent.mm.plugin.emojicapture.model.gif;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  implements a
{
  private final String TAG = "MicroMsg.GIF.MMWXGFDecoder";
  private int currFrame = -1;
  private final int[] jkB = new int[4];
  private long jkC = MMWXGFJNI.nativeInitWxAMDecoder();
  private final int[] jkD = new int[4];
  private int jkE = 100;
  
  public c(byte[] paramArrayOfByte)
  {
    if ((this.jkC == 0L) || (this.jkC == -901L))
    {
      y.w(this.TAG, "Cpan init wxam decoder failed. gifHandle:%d", new Object[] { Long.valueOf(this.jkC) });
      if (this.jkC == -901L) {
        h.nFQ.a(711L, 5L, 1L, false);
      }
      h.nFQ.a(711L, 4L, 1L, false);
      throw ((Throwable)new MMGIFException(201));
    }
    int i = MMWXGFJNI.nativeDecodeBufferHeader(this.jkC, paramArrayOfByte, paramArrayOfByte.length);
    if (i != 0)
    {
      y.w(this.TAG, "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -904) {
        h.nFQ.a(711L, 8L, 1L, false);
      }
      for (;;)
      {
        throw ((Throwable)new MMGIFException(i));
        h.nFQ.a(711L, 3L, 1L, false);
      }
    }
    i = MMWXGFJNI.nativeGetOption(this.jkC, paramArrayOfByte, paramArrayOfByte.length, this.jkB);
    if (i != 0)
    {
      y.w(this.TAG, "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(i) });
      if (i == -903) {
        h.nFQ.a(711L, 7L, 1L, false);
      }
      for (;;)
      {
        throw ((Throwable)new MMGIFException(i));
        h.nFQ.a(711L, 3L, 1L, false);
      }
    }
  }
  
  public final int aKg()
  {
    return this.jkE;
  }
  
  public final int aKh()
  {
    return this.jkB[1];
  }
  
  public final int aKi()
  {
    return this.jkB[2];
  }
  
  public final void destroy()
  {
    long l = this.jkC;
    this.jkC = 0L;
    int i = MMWXGFJNI.nativeUninit(l);
    if (i == -906) {
      h.nFQ.a(401L, 10L, 1L, false);
    }
    y.d(this.TAG, "nativeUninit result:%d gifHandle:%s", new Object[] { Integer.valueOf(i), Long.valueOf(l) });
  }
  
  public final boolean x(Bitmap paramBitmap)
  {
    int i = MMWXGFJNI.nativeDecodeBufferFrame(this.jkC, null, 0, paramBitmap, this.jkD);
    boolean bool = true;
    if (i == -904)
    {
      y.i(this.TAG, "nativeDecodeBufferFrame failed. func is null.");
      h.nFQ.a(401L, 8L, 1L, false);
      bool = false;
      this.currFrame += 1;
      if ((this.currFrame >= this.jkB[0]) || (i == 1))
      {
        this.currFrame = -1;
        if (MMWXGFJNI.nativeRewindBuffer(this.jkC) == -905)
        {
          h.nFQ.a(711L, 9L, 1L, false);
          y.w(this.TAG, "Cpan Rewind buffer failed.");
        }
      }
      if (this.jkD[0] <= 0) {
        break label193;
      }
    }
    label193:
    for (i = this.jkD[0];; i = 100)
    {
      this.jkE = i;
      return bool;
      if (i == -909)
      {
        y.i(this.TAG, "nativeDecodeBufferFrame failed. frame is null.");
        h.nFQ.a(401L, 11L, 1L, false);
        break;
      }
      if (i != -1) {
        break;
      }
      y.i(this.TAG, "nativeDecodeBufferFrame failed.");
      bool = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.gif.c
 * JD-Core Version:    0.7.0.1
 */