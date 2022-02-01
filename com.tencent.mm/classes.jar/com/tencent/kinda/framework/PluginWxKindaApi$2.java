package com.tencent.kinda.framework;

class PluginWxKindaApi$2
  implements Runnable
{
  PluginWxKindaApi$2(PluginWxKindaApi paramPluginWxKindaApi) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 26
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 38	com/tencent/mm/kernel/h:aHD	()Lcom/tencent/mm/kernel/e;
    //   8: invokevirtual 44	com/tencent/mm/kernel/e:aHf	()Lcom/tencent/mm/kernel/b/g;
    //   11: checkcast 46	com/tencent/mm/kernel/b/h
    //   14: invokevirtual 50	com/tencent/mm/kernel/b/h:aIE	()Z
    //   17: ifeq +61 -> 78
    //   20: invokestatic 55	com/tencent/kinda/framework/boot/KindaApp:isEnabled	()Z
    //   23: ifeq +55 -> 78
    //   26: invokestatic 61	com/tencent/kinda/gen/ITransmitKvData:create	()Lcom/tencent/kinda/gen/ITransmitKvData;
    //   29: astore_2
    //   30: new 63	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: getstatic 70	com/tencent/mm/app/AppForegroundDelegate:fby	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   41: getfield 74	com/tencent/mm/app/AppForegroundDelegate:cQt	Z
    //   44: ifeq +40 -> 84
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_2
    //   50: ldc 76
    //   52: aload_3
    //   53: iload_1
    //   54: invokevirtual 80	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 88	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_2
    //   64: ldc 90
    //   66: ldc 92
    //   68: invokevirtual 88	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: invokestatic 96	com/tencent/kinda/framework/boot/KindaApp:appKinda	()Lcom/tencent/kinda/gen/IAppKinda;
    //   74: aload_2
    //   75: invokevirtual 102	com/tencent/kinda/gen/IAppKinda:applicationReceiveMemoryWarning	(Lcom/tencent/kinda/gen/ITransmitKvData;)V
    //   78: ldc 26
    //   80: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: iconst_0
    //   85: istore_1
    //   86: goto -37 -> 49
    //   89: astore_2
    //   90: ldc 107
    //   92: aload_2
    //   93: ldc 109
    //   95: iconst_0
    //   96: anewarray 4	java/lang/Object
    //   99: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   102: ldc 26
    //   104: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_2
    //   109: goto -19 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	2
    //   48	38	1	i	int
    //   29	46	2	localITransmitKvData	com.tencent.kinda.gen.ITransmitKvData
    //   89	4	2	localException	java.lang.Exception
    //   108	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   37	16	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	47	89	java/lang/Exception
    //   49	78	89	java/lang/Exception
    //   5	47	108	java/lang/UnsatisfiedLinkError
    //   49	78	108	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi.2
 * JD-Core Version:    0.7.0.1
 */