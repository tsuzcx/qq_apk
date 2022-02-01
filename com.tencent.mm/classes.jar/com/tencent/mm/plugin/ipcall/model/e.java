package com.tencent.mm.plugin.ipcall.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;

public final class e
{
  private static e JFU = null;
  public ArrayList<com.tencent.mm.plugin.ipcall.model.h.f> JFV;
  IListener pWI;
  
  private e()
  {
    AppMethodBeat.i(25356);
    this.JFV = null;
    this.pWI = new IPCallFeedbackConfigUpdater.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(25356);
  }
  
  public static e fRi()
  {
    AppMethodBeat.i(25357);
    if (JFU == null) {
      JFU = new e();
    }
    e locale = JFU;
    AppMethodBeat.o(25357);
    return locale;
  }
  
  /* Error */
  public final boolean bX(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 25358
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 52	java/lang/String
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 55	java/lang/String:<init>	([B)V
    //   14: astore_1
    //   15: aload_1
    //   16: ldc 57
    //   18: aconst_null
    //   19: invokestatic 63	com/tencent/mm/sdk/platformtools/XmlParser:parseXml	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +436 -> 462
    //   29: new 65	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 66	java/util/ArrayList:<init>	()V
    //   36: astore 5
    //   38: iconst_0
    //   39: istore_2
    //   40: new 68	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   47: ldc 71
    //   49: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: astore 6
    //   54: iload_2
    //   55: ifne +307 -> 362
    //   58: ldc 77
    //   60: astore_1
    //   61: aload 6
    //   63: aload_1
    //   64: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload 4
    //   73: new 68	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   80: aload_1
    //   81: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 86
    //   86: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokeinterface 92 2 0
    //   97: checkcast 52	java/lang/String
    //   100: astore 7
    //   102: aload 7
    //   104: ifnull +322 -> 426
    //   107: new 94	com/tencent/mm/plugin/ipcall/model/h/f
    //   110: dup
    //   111: invokespecial 95	com/tencent/mm/plugin/ipcall/model/h/f:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: aload 7
    //   120: putfield 99	com/tencent/mm/plugin/ipcall/model/h/f:JJU	Ljava/lang/String;
    //   123: aload 6
    //   125: new 65	java/util/ArrayList
    //   128: dup
    //   129: invokespecial 66	java/util/ArrayList:<init>	()V
    //   132: putfield 102	com/tencent/mm/plugin/ipcall/model/h/f:JJV	Ljava/util/ArrayList;
    //   135: new 68	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   142: aload_1
    //   143: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 104
    //   148: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: astore 7
    //   156: iconst_0
    //   157: istore_3
    //   158: new 106	com/tencent/mm/plugin/ipcall/model/h/e
    //   161: dup
    //   162: invokespecial 107	com/tencent/mm/plugin/ipcall/model/h/e:<init>	()V
    //   165: astore 8
    //   167: new 68	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   174: aload 7
    //   176: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: astore 9
    //   181: iload_3
    //   182: ifne +188 -> 370
    //   185: ldc 77
    //   187: astore_1
    //   188: aload 9
    //   190: aload_1
    //   191: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: astore 9
    //   199: aload 4
    //   201: aload 9
    //   203: invokeinterface 92 2 0
    //   208: checkcast 52	java/lang/String
    //   211: astore_1
    //   212: aload_1
    //   213: ifnull +165 -> 378
    //   216: aload 4
    //   218: new 68	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   225: aload 9
    //   227: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: ldc 109
    //   232: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokeinterface 92 2 0
    //   243: checkcast 52	java/lang/String
    //   246: astore 9
    //   248: aload 9
    //   250: ifnull +128 -> 378
    //   253: iload_3
    //   254: iconst_1
    //   255: iadd
    //   256: istore_3
    //   257: aload 8
    //   259: aload 9
    //   261: putfield 112	com/tencent/mm/plugin/ipcall/model/h/e:Id	Ljava/lang/String;
    //   264: aload 8
    //   266: aload_1
    //   267: putfield 115	com/tencent/mm/plugin/ipcall/model/h/e:IHZ	Ljava/lang/String;
    //   270: aload 6
    //   272: getfield 102	com/tencent/mm/plugin/ipcall/model/h/f:JJV	Ljava/util/ArrayList;
    //   275: aload 8
    //   277: invokevirtual 119	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   280: pop
    //   281: goto -123 -> 158
    //   284: astore_1
    //   285: ldc 121
    //   287: aload_1
    //   288: ldc 77
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: ldc 121
    //   299: ldc 129
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: aload_1
    //   308: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   311: aastore
    //   312: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: sipush 25358
    //   318: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: iconst_0
    //   322: ireturn
    //   323: astore_1
    //   324: ldc 121
    //   326: aload_1
    //   327: ldc 77
    //   329: iconst_0
    //   330: anewarray 4	java/lang/Object
    //   333: invokestatic 127	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: ldc 121
    //   338: ldc 138
    //   340: iconst_1
    //   341: anewarray 4	java/lang/Object
    //   344: dup
    //   345: iconst_0
    //   346: aload_1
    //   347: invokevirtual 132	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   350: aastore
    //   351: invokestatic 136	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: sipush 25358
    //   357: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: iconst_0
    //   361: ireturn
    //   362: iload_2
    //   363: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   366: astore_1
    //   367: goto -306 -> 61
    //   370: iload_3
    //   371: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   374: astore_1
    //   375: goto -187 -> 188
    //   378: ldc 121
    //   380: ldc 146
    //   382: iconst_2
    //   383: anewarray 4	java/lang/Object
    //   386: dup
    //   387: iconst_0
    //   388: aload 6
    //   390: getfield 99	com/tencent/mm/plugin/ipcall/model/h/f:JJU	Ljava/lang/String;
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: aload 6
    //   398: getfield 102	com/tencent/mm/plugin/ipcall/model/h/f:JJV	Ljava/util/ArrayList;
    //   401: invokevirtual 150	java/util/ArrayList:size	()I
    //   404: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: aload 5
    //   413: aload 6
    //   415: invokevirtual 119	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: iload_2
    //   420: iconst_1
    //   421: iadd
    //   422: istore_2
    //   423: goto -383 -> 40
    //   426: ldc 121
    //   428: ldc 155
    //   430: iconst_1
    //   431: anewarray 4	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload 5
    //   438: invokevirtual 150	java/util/ArrayList:size	()I
    //   441: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: aastore
    //   445: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   448: aload_0
    //   449: aload 5
    //   451: putfield 29	com/tencent/mm/plugin/ipcall/model/e:JFV	Ljava/util/ArrayList;
    //   454: sipush 25358
    //   457: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: iconst_1
    //   461: ireturn
    //   462: ldc 121
    //   464: ldc 159
    //   466: invokestatic 162	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   469: sipush 25358
    //   472: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: iconst_0
    //   476: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	this	e
    //   0	477	1	paramArrayOfByte	byte[]
    //   39	384	2	i	int
    //   157	214	3	j	int
    //   22	195	4	localMap	java.util.Map
    //   36	414	5	localArrayList	ArrayList
    //   52	362	6	localObject1	Object
    //   100	75	7	str	java.lang.String
    //   165	111	8	locale	com.tencent.mm.plugin.ipcall.model.h.e
    //   179	81	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	24	284	java/lang/Exception
    //   29	38	284	java/lang/Exception
    //   40	54	284	java/lang/Exception
    //   61	102	284	java/lang/Exception
    //   107	156	284	java/lang/Exception
    //   158	181	284	java/lang/Exception
    //   188	212	284	java/lang/Exception
    //   216	248	284	java/lang/Exception
    //   257	281	284	java/lang/Exception
    //   362	367	284	java/lang/Exception
    //   370	375	284	java/lang/Exception
    //   378	419	284	java/lang/Exception
    //   426	454	284	java/lang/Exception
    //   462	469	284	java/lang/Exception
    //   6	15	323	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.e
 * JD-Core Version:    0.7.0.1
 */