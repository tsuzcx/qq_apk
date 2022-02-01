package com.tencent.mm.plugin.game;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xn;
import com.tencent.mm.sdk.event.IListener;

class GameEventListener$20
  extends IListener<xn>
{
  GameEventListener$20(c paramc, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(275283);
    this.__eventId = xn.class.getName().hashCode();
    AppMethodBeat.o(275283);
  }
  
  /* Error */
  private boolean fCd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 48
    //   4: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   10: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   13: astore 8
    //   15: aload 8
    //   17: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifle +211 -> 233
    //   25: aload 8
    //   27: getfield 69	com/tencent/mm/plugin/game/d/a$b:IXX	J
    //   30: lconst_0
    //   31: lcmp
    //   32: ifle +201 -> 233
    //   35: iconst_1
    //   36: istore_1
    //   37: iload_1
    //   38: ifeq +177 -> 215
    //   41: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   44: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   47: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   50: putfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
    //   53: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   56: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   59: astore 8
    //   61: aload 8
    //   63: aload 8
    //   65: getfield 81	com/tencent/mm/plugin/game/d/a$b:zIy	J
    //   68: invokestatic 75	java/lang/System:currentTimeMillis	()J
    //   71: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   74: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   77: getfield 69	com/tencent/mm/plugin/game/d/a$b:IXX	J
    //   80: lsub
    //   81: ladd
    //   82: putfield 81	com/tencent/mm/plugin/game/d/a$b:zIy	J
    //   85: ldc 83
    //   87: ldc 85
    //   89: iconst_3
    //   90: anewarray 87	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   98: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   101: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
    //   104: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: dup
    //   109: iconst_1
    //   110: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   113: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   116: getfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
    //   119: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   122: aastore
    //   123: dup
    //   124: iconst_2
    //   125: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   128: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   131: getfield 81	com/tencent/mm/plugin/game/d/a$b:zIy	J
    //   134: invokestatic 93	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   137: aastore
    //   138: invokestatic 98	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   141: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   144: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   147: getfield 66	com/tencent/mm/plugin/game/d/a$b:startTimeMs	J
    //   150: ldc2_w 99
    //   153: ldiv
    //   154: lstore_2
    //   155: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   158: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   161: getfield 78	com/tencent/mm/plugin/game/d/a$b:endTimeMs	J
    //   164: ldc2_w 99
    //   167: ldiv
    //   168: lstore 4
    //   170: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   173: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   176: getfield 81	com/tencent/mm/plugin/game/d/a$b:zIy	J
    //   179: ldc2_w 99
    //   182: ldiv
    //   183: lstore 6
    //   185: invokestatic 106	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   188: bipush 35
    //   190: iconst_0
    //   191: iconst_0
    //   192: bipush 91
    //   194: iconst_0
    //   195: ldc 108
    //   197: sipush 901
    //   200: iconst_0
    //   201: ldc 108
    //   203: ldc 108
    //   205: ldc 108
    //   207: lload_2
    //   208: lload 4
    //   210: lload 6
    //   212: invokestatic 114	com/tencent/mm/game/report/g:a	(Landroid/content/Context;IIIIILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V
    //   215: invokestatic 54	com/tencent/mm/plugin/game/d/a$a:fHX	()Lcom/tencent/mm/plugin/game/d/a;
    //   218: getfield 60	com/tencent/mm/plugin/game/d/a:IXU	Lcom/tencent/mm/plugin/game/d/a$b;
    //   221: invokevirtual 118	com/tencent/mm/plugin/game/d/a$b:fHY	()V
    //   224: ldc 48
    //   226: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: aload_0
    //   230: monitorexit
    //   231: iconst_0
    //   232: ireturn
    //   233: iconst_0
    //   234: istore_1
    //   235: goto -198 -> 37
    //   238: astore 8
    //   240: aload_0
    //   241: monitorexit
    //   242: aload 8
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	20
    //   36	199	1	i	int
    //   154	54	2	l1	long
    //   168	41	4	l2	long
    //   183	28	6	l3	long
    //   13	51	8	localb	com.tencent.mm.plugin.game.d.a.b
    //   238	5	8	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   2	35	238	finally
    //   41	215	238	finally
    //   215	229	238	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.GameEventListener.20
 * JD-Core Version:    0.7.0.1
 */