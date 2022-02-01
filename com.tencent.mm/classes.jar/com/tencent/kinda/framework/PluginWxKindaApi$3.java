package com.tencent.kinda.framework;

class PluginWxKindaApi$3
  implements Runnable
{
  PluginWxKindaApi$3(PluginWxKindaApi paramPluginWxKindaApi, int paramInt) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc 31
    //   2: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 42	com/tencent/mm/kernel/h:aHD	()Lcom/tencent/mm/kernel/e;
    //   8: invokevirtual 48	com/tencent/mm/kernel/e:aHf	()Lcom/tencent/mm/kernel/b/g;
    //   11: checkcast 50	com/tencent/mm/kernel/b/h
    //   14: invokevirtual 54	com/tencent/mm/kernel/b/h:aIE	()Z
    //   17: ifeq +84 -> 101
    //   20: invokestatic 59	com/tencent/kinda/framework/boot/KindaApp:isEnabled	()Z
    //   23: ifeq +78 -> 101
    //   26: invokestatic 65	com/tencent/kinda/gen/ITransmitKvData:create	()Lcom/tencent/kinda/gen/ITransmitKvData;
    //   29: astore_2
    //   30: new 67	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   37: astore_3
    //   38: getstatic 74	com/tencent/mm/app/AppForegroundDelegate:fby	Lcom/tencent/mm/app/AppForegroundDelegate;
    //   41: getfield 78	com/tencent/mm/app/AppForegroundDelegate:cQt	Z
    //   44: ifeq +63 -> 107
    //   47: iconst_1
    //   48: istore_1
    //   49: aload_2
    //   50: ldc 80
    //   52: aload_3
    //   53: iload_1
    //   54: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_2
    //   64: ldc 94
    //   66: ldc 96
    //   68: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_2
    //   72: ldc 98
    //   74: new 67	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   81: aload_0
    //   82: getfield 21	com/tencent/kinda/framework/PluginWxKindaApi$3:val$level	I
    //   85: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   88: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 92	com/tencent/kinda/gen/ITransmitKvData:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: invokestatic 102	com/tencent/kinda/framework/boot/KindaApp:appKinda	()Lcom/tencent/kinda/gen/IAppKinda;
    //   97: aload_2
    //   98: invokevirtual 108	com/tencent/kinda/gen/IAppKinda:applicationReceiveMemoryWarning	(Lcom/tencent/kinda/gen/ITransmitKvData;)V
    //   101: ldc 31
    //   103: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: iconst_0
    //   108: istore_1
    //   109: goto -60 -> 49
    //   112: astore_2
    //   113: ldc 113
    //   115: aload_2
    //   116: ldc 115
    //   118: iconst_0
    //   119: anewarray 4	java/lang/Object
    //   122: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: ldc 31
    //   127: invokestatic 111	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: return
    //   131: astore_2
    //   132: goto -19 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	3
    //   48	61	1	i	int
    //   29	69	2	localITransmitKvData	com.tencent.kinda.gen.ITransmitKvData
    //   112	4	2	localException	java.lang.Exception
    //   131	1	2	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   37	16	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   5	47	112	java/lang/Exception
    //   49	101	112	java/lang/Exception
    //   5	47	131	java/lang/UnsatisfiedLinkError
    //   49	101	131	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.PluginWxKindaApi.3
 * JD-Core Version:    0.7.0.1
 */