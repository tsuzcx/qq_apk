package com.tencent.matrix.resource.processor;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.matrix.resource.analyzer.model.DestroyedActivityInfo;
import com.tencent.matrix.resource.b.a.b;

public final class g
  extends b
{
  private boolean fcK;
  private boolean fcL;
  private final BroadcastReceiver mReceiver;
  
  public g(com.tencent.matrix.resource.f.b paramb)
  {
    super(paramb);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    this.mReceiver = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousIntent.getAction()))
        {
          g.a(g.this, true);
          com.tencent.matrix.e.c.i("Matrix.LeakProcessor.SilenceAnalyse", "[ACTION_SCREEN_OFF]", new Object[0]);
        }
        while (!"android.intent.action.SCREEN_ON".equals(paramAnonymousIntent.getAction())) {
          return;
        }
        g.a(g.this, false);
        com.tencent.matrix.e.c.i("Matrix.LeakProcessor.SilenceAnalyse", "[ACTION_SCREEN_ON]", new Object[0]);
      }
    };
    try
    {
      paramb.fcO.getApplication().registerReceiver(this.mReceiver, localIntentFilter);
      return;
    }
    finally
    {
      com.tencent.matrix.e.c.printErrStackTrace("Matrix.LeakProcessor.SilenceAnalyse", paramb, "", new Object[0]);
    }
  }
  
  /* Error */
  private boolean V(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: invokevirtual 78	com/tencent/matrix/resource/processor/g:azs	()Lcom/tencent/matrix/resource/c/a;
    //   8: iconst_0
    //   9: invokevirtual 84	com/tencent/matrix/resource/c/a:dK	(Z)Ljava/io/File;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnull +13 -> 29
    //   19: aload 7
    //   21: invokevirtual 89	java/io/File:length	()J
    //   24: lconst_0
    //   25: lcmp
    //   26: ifgt +27 -> 53
    //   29: aload_0
    //   30: iconst_2
    //   31: aload_1
    //   32: aload_2
    //   33: ldc 91
    //   35: ldc 93
    //   37: invokespecial 97	com/tencent/matrix/resource/processor/g:b	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   40: ldc 53
    //   42: ldc 99
    //   44: iconst_0
    //   45: anewarray 57	java/lang/Object
    //   48: invokestatic 103	com/tencent/matrix/e/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: iconst_1
    //   52: ireturn
    //   53: ldc 53
    //   55: ldc 105
    //   57: iconst_3
    //   58: anewarray 57	java/lang/Object
    //   61: dup
    //   62: iconst_0
    //   63: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   66: lload_3
    //   67: lsub
    //   68: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   71: aastore
    //   72: dup
    //   73: iconst_1
    //   74: aload_2
    //   75: aastore
    //   76: dup
    //   77: iconst_2
    //   78: aload 7
    //   80: invokevirtual 115	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   83: aastore
    //   84: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   87: iconst_0
    //   88: anewarray 57	java/lang/Object
    //   91: invokestatic 124	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   97: lstore 5
    //   99: aload 7
    //   101: aload_2
    //   102: invokestatic 128	com/tencent/matrix/resource/processor/g:g	(Ljava/io/File;Ljava/lang/String;)Lcom/tencent/matrix/resource/analyzer/model/a;
    //   105: astore 8
    //   107: ldc 53
    //   109: ldc 130
    //   111: iconst_2
    //   112: anewarray 57	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   120: lload 5
    //   122: lsub
    //   123: invokestatic 111	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   126: aastore
    //   127: dup
    //   128: iconst_1
    //   129: aload_2
    //   130: aastore
    //   131: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   134: iconst_0
    //   135: anewarray 57	java/lang/Object
    //   138: invokestatic 124	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: aload 8
    //   143: invokevirtual 135	com/tencent/matrix/resource/analyzer/model/a:toString	()Ljava/lang/String;
    //   146: astore 9
    //   148: aload 8
    //   150: getfield 138	com/tencent/matrix/resource/analyzer/model/a:eZt	Z
    //   153: ifeq +39 -> 192
    //   156: aload_0
    //   157: iconst_0
    //   158: aload_1
    //   159: aload_2
    //   160: aload 9
    //   162: invokestatic 74	java/lang/System:currentTimeMillis	()J
    //   165: lload_3
    //   166: lsub
    //   167: invokestatic 141	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   170: invokespecial 97	com/tencent/matrix/resource/processor/g:b	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   173: ldc 53
    //   175: aload 9
    //   177: iconst_0
    //   178: anewarray 57	java/lang/Object
    //   181: invokestatic 124	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload 7
    //   186: invokevirtual 145	java/io/File:delete	()Z
    //   189: pop
    //   190: iconst_1
    //   191: ireturn
    //   192: ldc 53
    //   194: ldc 147
    //   196: iconst_0
    //   197: anewarray 57	java/lang/Object
    //   200: invokestatic 124	com/tencent/matrix/e/c:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: goto -19 -> 184
    //   206: astore 8
    //   208: aload_0
    //   209: iconst_3
    //   210: aload_1
    //   211: aload_2
    //   212: ldc 149
    //   214: ldc 93
    //   216: invokespecial 97	com/tencent/matrix/resource/processor/g:b	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   219: ldc 53
    //   221: aload 8
    //   223: invokevirtual 153	java/lang/OutOfMemoryError:getCause	()Ljava/lang/Throwable;
    //   226: ldc 55
    //   228: iconst_0
    //   229: anewarray 57	java/lang/Object
    //   232: invokestatic 63	com/tencent/matrix/e/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: aload 7
    //   237: invokevirtual 145	java/io/File:delete	()Z
    //   240: pop
    //   241: iconst_1
    //   242: ireturn
    //   243: astore_1
    //   244: aload 7
    //   246: invokevirtual 145	java/io/File:delete	()Z
    //   249: pop
    //   250: aload_1
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	this	g
    //   0	252	1	paramString1	String
    //   0	252	2	paramString2	String
    //   3	163	3	l1	long
    //   97	24	5	l2	long
    //   12	233	7	localFile	java.io.File
    //   105	44	8	locala	com.tencent.matrix.resource.analyzer.model.a
    //   206	16	8	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   146	30	9	str	String
    // Exception table:
    //   from	to	target	type
    //   99	184	206	java/lang/OutOfMemoryError
    //   192	203	206	java/lang/OutOfMemoryError
    //   99	184	243	finally
    //   192	203	243	finally
    //   208	235	243	finally
  }
  
  private void b(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a(paramInt, a.b.fbm, paramString1, paramString2, paramString3, paramString4);
  }
  
  public final boolean a(DestroyedActivityInfo paramDestroyedActivityInfo)
  {
    String str = paramDestroyedActivityInfo.mActivityName;
    paramDestroyedActivityInfo = paramDestroyedActivityInfo.mKey;
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.SilenceAnalyse", "[onLeak] activity=%s isScreenOff=%s isProcessing=%s", new Object[] { str, Boolean.valueOf(this.fcK), Boolean.valueOf(this.fcL) });
    if (azu().gY(str))
    {
      com.tencent.matrix.e.c.i("Matrix.LeakProcessor.SilenceAnalyse", "this activity has been dumped! %s", new Object[] { str });
      return true;
    }
    if ((!this.fcL) && (this.fcK))
    {
      this.fcL = true;
      azu();
      com.tencent.matrix.resource.f.b.azx();
      boolean bool = V(str, paramDestroyedActivityInfo);
      if (bool) {
        azu().m(str, false);
      }
      this.fcL = false;
      return bool;
    }
    return false;
  }
  
  public final void onDestroy()
  {
    com.tencent.matrix.e.c.i("Matrix.LeakProcessor.SilenceAnalyse", "onDestroy: unregister receiver", new Object[0]);
    azu().fcO.getApplication().unregisterReceiver(this.mReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.resource.processor.g
 * JD-Core Version:    0.7.0.1
 */