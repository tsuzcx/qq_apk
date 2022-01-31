package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.a.d.f;
import java.nio.ByteBuffer;
import java.util.Timer;

public class c
{
  protected boolean bkA;
  Timer bkB = null;
  public a bkC;
  final Runnable bkD = new c.1(this);
  protected b bky;
  public long bkz;
  
  public c(b paramb, int paramInt)
  {
    this.bky = paramb;
    this.bkz = JsEngine.createVMContext(paramb.bkx, paramInt);
  }
  
  public c(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.bky = new b(paramString, paramArrayOfByte);
    this.bkA = true;
    this.bkz = JsEngine.createVMContext(this.bky.bkx, paramInt);
    d.f.i("MB.JsVmContext", "hy: context ptr is %d", new Object[] { Long.valueOf(this.bkz) });
  }
  
  public void dispose()
  {
    if (this.bkz == 0L) {}
    do
    {
      return;
      JsEngine.releaseVMContext(this.bkz);
      this.bkz = 0L;
      if ((this.bkA) && (this.bky != null))
      {
        this.bky.dispose();
        this.bky = null;
      }
    } while (this.bkB == null);
    this.bkB.cancel();
    this.bkB = null;
  }
  
  public final ByteBuffer getNativeBuffer(int paramInt)
  {
    ByteBuffer localByteBuffer2 = JsEngine.getNativeBuffer(paramInt, this.bky.bkx);
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(0);
    }
    return localByteBuffer1;
  }
  
  public final b qH()
  {
    return this.bky;
  }
  
  public final void qI()
  {
    if (this.bkB != null) {
      return;
    }
    this.bkB = new Timer();
    this.bkB.schedule(new c.2(this), 2000L, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.magicbrush.engine.c
 * JD-Core Version:    0.7.0.1
 */