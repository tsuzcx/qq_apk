package com.google.a;

public abstract class c<MessageType extends aw>
  implements bj<MessageType>
{
  private static final r bNc = ;
  
  /* Error */
  private MessageType a(byte[] paramArrayOfByte, int paramInt, r paramr)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: iload_2
    //   3: iconst_0
    //   4: invokestatic 33	com/google/a/h:c	([BIIZ)Lcom/google/a/h;
    //   7: astore_1
    //   8: aload_0
    //   9: aload_1
    //   10: aload_3
    //   11: invokevirtual 37	com/google/a/c:d	(Lcom/google/a/h;Lcom/google/a/r;)Ljava/lang/Object;
    //   14: checkcast 39	com/google/a/aw
    //   17: astore_3
    //   18: aload_1
    //   19: iconst_0
    //   20: invokevirtual 43	com/google/a/h:fF	(I)V
    //   23: aload_3
    //   24: areturn
    //   25: astore_1
    //   26: aload_1
    //   27: aload_3
    //   28: putfield 47	com/google/a/af:bXr	Lcom/google/a/aw;
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
    //   0	36	3	paramr	r
    // Exception table:
    //   from	to	target	type
    //   18	23	25	com/google/a/af
    //   0	18	33	com/google/a/af
    //   26	33	33	com/google/a/af
  }
  
  private static MessageType b(MessageType paramMessageType)
  {
    if ((paramMessageType != null) && (!paramMessageType.isInitialized()))
    {
      if ((paramMessageType instanceof b)) {}
      for (Object localObject = ((b)paramMessageType).yD();; localObject = new ca())
      {
        localObject = new af(((ca)localObject).getMessage());
        ((af)localObject).bXr = paramMessageType;
        throw ((Throwable)localObject);
      }
    }
    return paramMessageType;
  }
  
  /* Error */
  private MessageType d(g paramg, r paramr)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 79	com/google/a/g:yQ	()Lcom/google/a/h;
    //   4: astore_1
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 37	com/google/a/c:d	(Lcom/google/a/h;Lcom/google/a/r;)Ljava/lang/Object;
    //   11: checkcast 39	com/google/a/aw
    //   14: astore_2
    //   15: aload_1
    //   16: iconst_0
    //   17: invokevirtual 43	com/google/a/h:fF	(I)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_1
    //   23: aload_1
    //   24: aload_2
    //   25: putfield 47	com/google/a/af:bXr	Lcom/google/a/aw;
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	c
    //   0	33	1	paramg	g
    //   0	33	2	paramr	r
    // Exception table:
    //   from	to	target	type
    //   15	20	22	com/google/a/af
    //   0	15	30	com/google/a/af
    //   23	30	30	com/google/a/af
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.c
 * JD-Core Version:    0.7.0.1
 */