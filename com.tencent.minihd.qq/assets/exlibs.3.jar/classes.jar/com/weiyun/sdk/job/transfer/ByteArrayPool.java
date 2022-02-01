package com.weiyun.sdk.job.transfer;

import com.weiyun.sdk.log.Log;
import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class ByteArrayPool
{
  private static final boolean DEBUG = false;
  static final int MAX = 10;
  private static final String TAG = "ByteArrayPool";
  static ByteArrayPool gInstance;
  int hitCount = 0;
  public ArrayList<SoftReference<ByteArrayBuffer>> list = new ArrayList();
  int newCount = 0;
  int sucCount = 0;
  
  public static ByteArrayPool getInstance()
  {
    try
    {
      if (gInstance == null) {
        gInstance = new ByteArrayPool();
      }
      ByteArrayPool localByteArrayPool = gInstance;
      return localByteArrayPool;
    }
    finally {}
  }
  
  public ByteArrayBuffer createBuffer()
  {
    for (;;)
    {
      int i;
      ByteArrayBuffer localByteArrayBuffer;
      try
      {
        i = this.list.size();
        if (i <= 0) {
          break label77;
        }
        localByteArrayBuffer = (ByteArrayBuffer)((SoftReference)this.list.remove(i - 1)).get();
        if (localByteArrayBuffer != null) {
          if (localByteArrayBuffer != null) {
            break label74;
          }
        }
      }
      finally {}
      try
      {
        localByteArrayBuffer = new ByteArrayBuffer(new byte[40960]);
        return localByteArrayBuffer;
      }
      finally {}
      i -= 1;
      continue;
      label74:
      continue;
      label77:
      Object localObject3 = null;
    }
  }
  
  public void dumpInf()
  {
    int i = this.hitCount + this.newCount;
    Log.d("ByteArrayPool", "new count:" + this.newCount + " all:" + i + " hitCount:" + this.hitCount + " suc:" + this.sucCount);
    Log.d("ByteArrayPool", "hit percent:" + this.hitCount * 100 / i + "% suc percent:" + this.sucCount * 100 / i + "%");
  }
  
  /* Error */
  public void freeBuffer(ByteArrayBuffer paramByteArrayBuffer, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/weiyun/sdk/job/transfer/ByteArrayPool:list	Ljava/util/ArrayList;
    //   6: invokevirtual 52	java/util/ArrayList:size	()I
    //   9: bipush 10
    //   11: if_icmple +13 -> 24
    //   14: ldc 17
    //   16: ldc 105
    //   18: invokestatic 95	com/weiyun/sdk/log/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 40	com/weiyun/sdk/job/transfer/ByteArrayPool:list	Ljava/util/ArrayList;
    //   28: new 58	java/lang/ref/SoftReference
    //   31: dup
    //   32: aload_1
    //   33: invokespecial 108	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   36: invokevirtual 112	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   39: pop
    //   40: goto -19 -> 21
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ByteArrayPool
    //   0	48	1	paramByteArrayBuffer	ByteArrayBuffer
    //   0	48	2	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   2	21	43	finally
    //   24	40	43	finally
  }
  
  static final class ByteArrayBuffer
  {
    public final byte[] backingArray;
    
    ByteArrayBuffer(byte[] paramArrayOfByte)
    {
      this.backingArray = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.transfer.ByteArrayPool
 * JD-Core Version:    0.7.0.1
 */