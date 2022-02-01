package com.google.d;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public abstract class c<MessageType extends ce>
  implements cs<MessageType>
{
  private static final at EMPTY_REGISTRY = ;
  
  private MessageType checkMessageInitialized(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized()))
    {
      bk localbk = new bk(newUninitializedMessageException(paramMessageType).getMessage());
      localbk.dST = paramMessageType;
      throw localbk;
    }
    return paramMessageType;
  }
  
  private dl newUninitializedMessageException(MessageType paramMessageType)
  {
    if ((paramMessageType instanceof b)) {
      return ((b)paramMessageType).newUninitializedMessageException();
    }
    return new dl();
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream)
  {
    return parseDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseDelimitedFrom(InputStream paramInputStream, at paramat)
  {
    return checkMessageInitialized(parsePartialDelimitedFrom(paramInputStream, paramat));
  }
  
  public MessageType parseFrom(h paramh)
  {
    return parseFrom(paramh, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(h paramh, at paramat)
  {
    return checkMessageInitialized(parsePartialFrom(paramh, paramat));
  }
  
  public MessageType parseFrom(i parami)
  {
    return parseFrom(parami, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(i parami, at paramat)
  {
    return checkMessageInitialized((ce)parsePartialFrom(parami, paramat));
  }
  
  public MessageType parseFrom(InputStream paramInputStream)
  {
    return parseFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(InputStream paramInputStream, at paramat)
  {
    return checkMessageInitialized(parsePartialFrom(paramInputStream, paramat));
  }
  
  public MessageType parseFrom(ByteBuffer paramByteBuffer)
  {
    return parseFrom(paramByteBuffer, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parseFrom(ByteBuffer paramByteBuffer, at paramat)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 109	com/google/d/i:i	(Ljava/nio/ByteBuffer;)Lcom/google/d/i;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 93	com/google/d/c:parsePartialFrom	(Lcom/google/d/i;Lcom/google/d/at;)Ljava/lang/Object;
    //   11: checkcast 27	com/google/d/ce
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 113	com/google/d/i:jM	(I)V
    //   20: aload_0
    //   21: aload_2
    //   22: invokespecial 70	com/google/d/c:checkMessageInitialized	(Lcom/google/d/ce;)Lcom/google/d/ce;
    //   25: areturn
    //   26: astore_1
    //   27: aload_1
    //   28: aload_2
    //   29: putfield 50	com/google/d/bk:dST	Lcom/google/d/ce;
    //   32: aload_1
    //   33: athrow
    //   34: astore_1
    //   35: aload_1
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	c
    //   0	37	1	paramByteBuffer	ByteBuffer
    //   0	37	2	paramat	at
    // Exception table:
    //   from	to	target	type
    //   15	20	26	com/google/d/bk
    //   0	15	34	com/google/d/bk
    //   27	34	34	com/google/d/bk
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte)
  {
    return parseFrom(paramArrayOfByte, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parseFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, at paramat)
  {
    return checkMessageInitialized(parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, paramat));
  }
  
  public MessageType parseFrom(byte[] paramArrayOfByte, at paramat)
  {
    return parseFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramat);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream)
  {
    return parsePartialDelimitedFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialDelimitedFrom(InputStream paramInputStream, at paramat)
  {
    try
    {
      int i = paramInputStream.read();
      if (i == -1) {
        return null;
      }
      i = i.b(i, paramInputStream);
      return parsePartialFrom(new b.a.a(paramInputStream, i), paramat);
    }
    catch (IOException paramInputStream)
    {
      throw new bk(paramInputStream);
    }
  }
  
  public MessageType parsePartialFrom(h paramh)
  {
    return parsePartialFrom(paramh, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(h paramh, at paramat)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 177	com/google/d/h:ZX	()Lcom/google/d/i;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 93	com/google/d/c:parsePartialFrom	(Lcom/google/d/i;Lcom/google/d/at;)Ljava/lang/Object;
    //   11: checkcast 27	com/google/d/ce
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 113	com/google/d/i:jM	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: putfield 50	com/google/d/bk:dST	Lcom/google/d/ce;
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   0	33	1	paramh	h
    //   0	33	2	paramat	at
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/d/bk
    //   0	15	30	com/google/d/bk
    //   23	30	30	com/google/d/bk
  }
  
  public MessageType parsePartialFrom(i parami)
  {
    return (ce)parsePartialFrom(parami, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream)
  {
    return parsePartialFrom(paramInputStream, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(InputStream paramInputStream, at paramat)
  {
    paramInputStream = i.u(paramInputStream);
    paramat = (ce)parsePartialFrom(paramInputStream, paramat);
    try
    {
      paramInputStream.jM(0);
      return paramat;
    }
    catch (bk paramInputStream)
    {
      paramInputStream.dST = paramat;
      throw paramInputStream;
    }
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, EMPTY_REGISTRY);
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return parsePartialFrom(paramArrayOfByte, paramInt1, paramInt2, EMPTY_REGISTRY);
  }
  
  /* Error */
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2, at paramat)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: iload_3
    //   3: invokestatic 185	com/google/d/i:r	([BII)Lcom/google/d/i;
    //   6: astore_1
    //   7: aload_0
    //   8: aload_1
    //   9: aload 4
    //   11: invokevirtual 93	com/google/d/c:parsePartialFrom	(Lcom/google/d/i;Lcom/google/d/at;)Ljava/lang/Object;
    //   14: checkcast 27	com/google/d/ce
    //   17: astore 4
    //   19: aload_1
    //   20: iconst_0
    //   21: invokevirtual 113	com/google/d/i:jM	(I)V
    //   24: aload 4
    //   26: areturn
    //   27: astore_1
    //   28: aload_1
    //   29: aload 4
    //   31: putfield 50	com/google/d/bk:dST	Lcom/google/d/ce;
    //   34: aload_1
    //   35: athrow
    //   36: astore_1
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	c
    //   0	39	1	paramArrayOfByte	byte[]
    //   0	39	2	paramInt1	int
    //   0	39	3	paramInt2	int
    //   0	39	4	paramat	at
    // Exception table:
    //   from	to	target	type
    //   19	24	27	com/google/d/bk
    //   0	19	36	com/google/d/bk
    //   28	36	36	com/google/d/bk
  }
  
  public MessageType parsePartialFrom(byte[] paramArrayOfByte, at paramat)
  {
    return parsePartialFrom(paramArrayOfByte, 0, paramArrayOfByte.length, paramat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.c
 * JD-Core Version:    0.7.0.1
 */