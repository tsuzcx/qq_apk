package com.google.b;

public abstract class c<MessageType extends bw>
  implements ci<MessageType>
{
  private static final ap bPb = ;
  
  private static MessageType a(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized()))
    {
      if ((paramMessageType instanceof b)) {}
      for (Object localObject = ((b)paramMessageType).Ae();; localObject = new cy())
      {
        localObject = new bf(((cy)localObject).getMessage());
        ((bf)localObject).bZj = paramMessageType;
        throw ((Throwable)localObject);
      }
    }
    return paramMessageType;
  }
  
  /* Error */
  private MessageType a(g paramg, ap paramap)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 62	com/google/b/g:Ar	()Lcom/google/b/h;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 66	com/google/b/c:d	(Lcom/google/b/h;Lcom/google/b/ap;)Ljava/lang/Object;
    //   11: checkcast 27	com/google/b/bw
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 72	com/google/b/h:gy	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: putfield 52	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   0	33	1	paramg	g
    //   0	33	2	paramap	ap
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/b/bf
    //   0	15	30	com/google/b/bf
    //   23	30	30	com/google/b/bf
  }
  
  /* Error */
  private MessageType a(byte[] paramArrayOfByte, int paramInt, ap paramap)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: iload_2
    //   3: iconst_0
    //   4: invokestatic 78	com/google/b/h:c	([BIIZ)Lcom/google/b/h;
    //   7: astore_1
    //   8: aload_0
    //   9: aload_1
    //   10: aload_3
    //   11: invokevirtual 66	com/google/b/c:d	(Lcom/google/b/h;Lcom/google/b/ap;)Ljava/lang/Object;
    //   14: checkcast 27	com/google/b/bw
    //   17: astore_3
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 72	com/google/b/h:gy	(I)V
    //   23: aload_3
    //   24: areturn
    //   25: astore_1
    //   26: aload_1
    //   27: aload_3
    //   28: putfield 52	com/google/b/bf:bZj	Lcom/google/b/bw;
    //   31: aload_1
    //   32: athrow
    //   33: astore_1
    //   34: aload_1
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	c
    //   0	36	1	paramArrayOfByte	byte[]
    //   0	36	2	paramInt	int
    //   0	36	3	paramap	ap
    // Exception table:
    //   from	to	target	type
    //   18	23	25	com/google/b/bf
    //   0	18	33	com/google/b/bf
    //   26	33	33	com/google/b/bf
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.c
 * JD-Core Version:    0.7.0.1
 */