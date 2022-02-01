package com.tencent.liteav.basic;

import com.tencent.liteav.TXLiteAVExternalDecoderFactoryInterface;

public class a
{
  private static TXLiteAVExternalDecoderFactoryInterface a;
  
  public static void a(TXLiteAVExternalDecoderFactoryInterface paramTXLiteAVExternalDecoderFactoryInterface)
  {
    try
    {
      a = paramTXLiteAVExternalDecoderFactoryInterface;
      return;
    }
    finally
    {
      paramTXLiteAVExternalDecoderFactoryInterface = finally;
      throw paramTXLiteAVExternalDecoderFactoryInterface;
    }
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 9	com/tencent/liteav/basic/a:a	Lcom/tencent/liteav/TXLiteAVExternalDecoderFactoryInterface;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localTXLiteAVExternalDecoderFactoryInterface	TXLiteAVExternalDecoderFactoryInterface
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public static TXLiteAVExternalDecoderFactoryInterface b()
  {
    try
    {
      TXLiteAVExternalDecoderFactoryInterface localTXLiteAVExternalDecoderFactoryInterface = a;
      return localTXLiteAVExternalDecoderFactoryInterface;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.a
 * JD-Core Version:    0.7.0.1
 */