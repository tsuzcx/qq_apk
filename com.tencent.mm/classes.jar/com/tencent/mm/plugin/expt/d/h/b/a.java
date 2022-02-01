package com.tencent.mm.plugin.expt.d.h.b;

public abstract class a
  implements b
{
  private String qYo;
  private String qYp;
  
  public a(String paramString1, String paramString2)
  {
    this.qYo = paramString1;
    this.qYp = paramString2;
  }
  
  /* Error */
  public Object invoke(com.eclipsesource.v8.V8Object paramV8Object, com.eclipsesource.v8.V8Array paramV8Array)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +10 -> 11
    //   4: aload_2
    //   5: invokevirtual 29	com/eclipsesource/v8/V8Array:length	()I
    //   8: ifgt +9 -> 17
    //   11: aconst_null
    //   12: astore 6
    //   14: aload 6
    //   16: areturn
    //   17: aload_2
    //   18: iconst_0
    //   19: invokevirtual 33	com/eclipsesource/v8/V8Array:getString	(I)Ljava/lang/String;
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 16	com/tencent/mm/plugin/expt/d/h/b/a:qYo	Ljava/lang/String;
    //   27: invokestatic 39	org/apache/commons/b/g:ef	(Ljava/lang/String;)Z
    //   30: ifne +14 -> 44
    //   33: aload_1
    //   34: aload_0
    //   35: getfield 16	com/tencent/mm/plugin/expt/d/h/b/a:qYo	Ljava/lang/String;
    //   38: invokestatic 43	org/apache/commons/b/g:equals	(Ljava/lang/String;Ljava/lang/String;)Z
    //   41: ifne +5 -> 46
    //   44: aconst_null
    //   45: areturn
    //   46: aload_2
    //   47: invokevirtual 29	com/eclipsesource/v8/V8Array:length	()I
    //   50: iconst_1
    //   51: if_icmple +357 -> 408
    //   54: aload_2
    //   55: iconst_1
    //   56: invokevirtual 47	com/eclipsesource/v8/V8Array:getArray	(I)Lcom/eclipsesource/v8/V8Array;
    //   59: astore_2
    //   60: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   63: lstore 4
    //   65: aload_0
    //   66: aload_2
    //   67: invokevirtual 57	com/tencent/mm/plugin/expt/d/h/b/a:b	(Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 18	com/tencent/mm/plugin/expt/d/h/b/a:qYp	Ljava/lang/String;
    //   75: astore 6
    //   77: invokestatic 53	android/os/SystemClock:uptimeMillis	()J
    //   80: lload 4
    //   82: lsub
    //   83: lstore 4
    //   85: aload_0
    //   86: invokevirtual 60	com/tencent/mm/plugin/expt/d/h/b/a:getType	()I
    //   89: istore_3
    //   90: lload 4
    //   92: ldc2_w 61
    //   95: lcmp
    //   96: ifgt +67 -> 163
    //   99: getstatic 68	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   102: ldc2_w 69
    //   105: ldc2_w 71
    //   108: lconst_1
    //   109: iconst_0
    //   110: invokevirtual 76	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   113: ldc 78
    //   115: ldc 80
    //   117: iconst_3
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iconst_0
    //   124: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: dup
    //   129: iconst_1
    //   130: lload 4
    //   132: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: aastore
    //   136: dup
    //   137: iconst_2
    //   138: iload_3
    //   139: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: aastore
    //   143: invokestatic 97	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_2
    //   147: ifnull +14 -> 161
    //   150: aload_2
    //   151: invokevirtual 101	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   154: ifne +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 104	com/eclipsesource/v8/V8Array:release	()V
    //   161: aload_1
    //   162: areturn
    //   163: lload 4
    //   165: ldc2_w 105
    //   168: lcmp
    //   169: ifgt +70 -> 239
    //   172: getstatic 68	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   175: ldc2_w 69
    //   178: ldc2_w 107
    //   181: lconst_1
    //   182: iconst_0
    //   183: invokevirtual 76	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   186: goto -73 -> 113
    //   189: astore 6
    //   191: ldc 110
    //   193: new 112	java/lang/StringBuilder
    //   196: dup
    //   197: ldc 114
    //   199: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload 6
    //   204: invokevirtual 121	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   207: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 131	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   216: aload_1
    //   217: astore 6
    //   219: aload_2
    //   220: ifnull -206 -> 14
    //   223: aload_1
    //   224: astore 6
    //   226: aload_2
    //   227: invokevirtual 101	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   230: ifne -216 -> 14
    //   233: aload_2
    //   234: invokevirtual 104	com/eclipsesource/v8/V8Array:release	()V
    //   237: aload_1
    //   238: areturn
    //   239: lload 4
    //   241: ldc2_w 132
    //   244: lcmp
    //   245: ifgt +38 -> 283
    //   248: getstatic 68	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   251: ldc2_w 69
    //   254: ldc2_w 134
    //   257: lconst_1
    //   258: iconst_0
    //   259: invokevirtual 76	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   262: goto -149 -> 113
    //   265: astore_1
    //   266: aload_2
    //   267: ifnull +14 -> 281
    //   270: aload_2
    //   271: invokevirtual 101	com/eclipsesource/v8/V8Array:isReleased	()Z
    //   274: ifne +7 -> 281
    //   277: aload_2
    //   278: invokevirtual 104	com/eclipsesource/v8/V8Array:release	()V
    //   281: aload_1
    //   282: athrow
    //   283: getstatic 68	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   286: ldc2_w 69
    //   289: ldc2_w 136
    //   292: lconst_1
    //   293: iconst_0
    //   294: invokevirtual 76	com/tencent/mm/plugin/report/service/g:idkeyStat	(JJJZ)V
    //   297: getstatic 143	com/tencent/mm/plugin/expt/d/f/a:qYj	Ljava/lang/Boolean;
    //   300: ifnonnull +49 -> 349
    //   303: ldc 145
    //   305: invokestatic 151	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   308: checkcast 145	com/tencent/mm/plugin/expt/b/b
    //   311: getstatic 157	com/tencent/mm/plugin/expt/b/b$a:qPv	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   314: iconst_0
    //   315: invokeinterface 161 3 0
    //   320: invokestatic 166	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   323: putstatic 143	com/tencent/mm/plugin/expt/d/f/a:qYj	Ljava/lang/Boolean;
    //   326: ldc 78
    //   328: new 112	java/lang/StringBuilder
    //   331: dup
    //   332: ldc 168
    //   334: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: getstatic 143	com/tencent/mm/plugin/expt/d/f/a:qYj	Ljava/lang/Boolean;
    //   340: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 174	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: getstatic 143	com/tencent/mm/plugin/expt/d/f/a:qYj	Ljava/lang/Boolean;
    //   352: invokevirtual 177	java/lang/Boolean:booleanValue	()Z
    //   355: ifeq -242 -> 113
    //   358: getstatic 68	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   361: sipush 20176
    //   364: iconst_4
    //   365: anewarray 4	java/lang/Object
    //   368: dup
    //   369: iconst_0
    //   370: aload 6
    //   372: aastore
    //   373: dup
    //   374: iconst_1
    //   375: iconst_5
    //   376: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   379: aastore
    //   380: dup
    //   381: iconst_2
    //   382: lload 4
    //   384: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   387: aastore
    //   388: dup
    //   389: iconst_3
    //   390: iload_3
    //   391: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: aastore
    //   395: invokevirtual 181	com/tencent/mm/plugin/report/service/g:f	(I[Ljava/lang/Object;)V
    //   398: goto -285 -> 113
    //   401: astore 6
    //   403: aconst_null
    //   404: astore_1
    //   405: goto -214 -> 191
    //   408: aconst_null
    //   409: astore_2
    //   410: goto -350 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	a
    //   0	413	1	paramV8Object	com.eclipsesource.v8.V8Object
    //   0	413	2	paramV8Array	com.eclipsesource.v8.V8Array
    //   89	302	3	i	int
    //   63	320	4	l	long
    //   12	64	6	localObject	Object
    //   189	14	6	localException1	java.lang.Exception
    //   217	154	6	localV8Object	com.eclipsesource.v8.V8Object
    //   401	1	6	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   71	90	189	java/lang/Exception
    //   99	113	189	java/lang/Exception
    //   113	146	189	java/lang/Exception
    //   172	186	189	java/lang/Exception
    //   248	262	189	java/lang/Exception
    //   283	349	189	java/lang/Exception
    //   349	398	189	java/lang/Exception
    //   60	71	265	finally
    //   71	90	265	finally
    //   99	113	265	finally
    //   113	146	265	finally
    //   172	186	265	finally
    //   191	216	265	finally
    //   248	262	265	finally
    //   283	349	265	finally
    //   349	398	265	finally
    //   60	71	401	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.h.b.a
 * JD-Core Version:    0.7.0.1
 */