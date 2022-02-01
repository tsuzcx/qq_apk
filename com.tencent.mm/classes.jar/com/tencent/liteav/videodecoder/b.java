package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public abstract interface b
{
  public abstract int GetDecodeCost();
  
  public abstract int config(Surface paramSurface);
  
  public abstract void decode(TXSNALPacket paramTXSNALPacket);
  
  public abstract void enableLimitDecCache(boolean paramBoolean);
  
  public abstract boolean isHevc();
  
  public abstract void setListener(f paramf);
  
  public abstract void setNotifyListener(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference);
  
  public abstract int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.b
 * JD-Core Version:    0.7.0.1
 */