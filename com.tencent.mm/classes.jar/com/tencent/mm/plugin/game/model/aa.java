package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.cw;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  public String mAppId;
  public List<aa.a> now;
  
  public aa(String paramString)
  {
    AppMethodBeat.i(111366);
    this.mAppId = "";
    this.now = new LinkedList();
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111366);
      return;
    }
    this.mAppId = paramString;
    this.now.addAll(bGI());
    AppMethodBeat.o(111366);
  }
  
  public aa(String paramString, List<cw> paramList)
  {
    AppMethodBeat.i(111367);
    this.mAppId = "";
    this.now = new LinkedList();
    if ((bo.isNullOrNil(paramString)) || (paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(111367);
      return;
    }
    this.mAppId = paramString;
    this.now.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (cw)paramString.next();
      aa.a locala = new aa.a();
      locala.nox = paramList.ntX;
      locala.cDt = paramList.jJA;
      locala.tag = paramList.Label;
      locala.mSY = paramList.ntY;
      locala.noz = paramList.ntZ;
      locala.noy = paramList.nua;
      locala.noA = paramList.nub;
      this.now.add(locala);
    }
    bGJ();
    AppMethodBeat.o(111367);
  }
  
  /* Error */
  private List<aa.a> bGI()
  {
    // Byte code:
    //   0: ldc 136
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 138	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 27	com/tencent/mm/plugin/game/model/aa:mAppId	Ljava/lang/String;
    //   16: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 145
    //   21: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_1
    //   28: new 29	java/util/LinkedList
    //   31: dup
    //   32: invokespecial 30	java/util/LinkedList:<init>	()V
    //   35: astore 4
    //   37: ldc 151
    //   39: invokestatic 157	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   42: checkcast 151	com/tencent/mm/plugin/game/api/e
    //   45: invokeinterface 161 1 0
    //   50: aload_1
    //   51: invokevirtual 167	com/tencent/mm/plugin/game/model/w:PN	(Ljava/lang/String;)[B
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +11 -> 67
    //   59: ldc 136
    //   61: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload 4
    //   66: areturn
    //   67: new 169	java/io/ByteArrayInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 172	java/io/ByteArrayInputStream:<init>	([B)V
    //   75: astore 5
    //   77: new 174	java/io/ObjectInputStream
    //   80: dup
    //   81: aload 5
    //   83: invokespecial 177	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_2
    //   87: aload_2
    //   88: astore_1
    //   89: aload 4
    //   91: aload_2
    //   92: invokeinterface 182 1 0
    //   97: checkcast 47	java/util/List
    //   100: invokeinterface 51 2 0
    //   105: pop
    //   106: aload 5
    //   108: invokevirtual 185	java/io/ByteArrayInputStream:close	()V
    //   111: aload_2
    //   112: invokeinterface 186 1 0
    //   117: ldc 136
    //   119: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 4
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 188
    //   132: aload_3
    //   133: ldc 25
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 194	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 5
    //   144: invokevirtual 185	java/io/ByteArrayInputStream:close	()V
    //   147: aload_2
    //   148: ifnull -31 -> 117
    //   151: aload_2
    //   152: invokeinterface 186 1 0
    //   157: goto -40 -> 117
    //   160: astore_1
    //   161: goto -44 -> 117
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 185	java/io/ByteArrayInputStream:close	()V
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 186 1 0
    //   182: ldc 136
    //   184: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_2
    //   188: athrow
    //   189: astore_1
    //   190: goto -79 -> 111
    //   193: astore_1
    //   194: goto -77 -> 117
    //   197: astore_1
    //   198: goto -51 -> 147
    //   201: astore_3
    //   202: goto -30 -> 172
    //   205: astore_1
    //   206: goto -24 -> 182
    //   209: astore_2
    //   210: goto -43 -> 167
    //   213: astore_3
    //   214: goto -86 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	aa
    //   27	103	1	localObject1	Object
    //   160	1	1	localIOException1	java.io.IOException
    //   166	11	1	localObject2	Object
    //   189	1	1	localIOException2	java.io.IOException
    //   193	1	1	localIOException3	java.io.IOException
    //   197	1	1	localIOException4	java.io.IOException
    //   205	1	1	localIOException5	java.io.IOException
    //   86	66	2	localObjectInputStream	java.io.ObjectInputStream
    //   164	24	2	localObject3	Object
    //   209	1	2	localObject4	Object
    //   125	8	3	localException1	java.lang.Exception
    //   201	1	3	localIOException6	java.io.IOException
    //   213	1	3	localException2	java.lang.Exception
    //   35	88	4	localLinkedList	LinkedList
    //   75	93	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   77	87	125	java/lang/Exception
    //   151	157	160	java/io/IOException
    //   77	87	164	finally
    //   106	111	189	java/io/IOException
    //   111	117	193	java/io/IOException
    //   142	147	197	java/io/IOException
    //   167	172	201	java/io/IOException
    //   176	182	205	java/io/IOException
    //   89	106	209	finally
    //   130	142	209	finally
    //   89	106	213	java/lang/Exception
  }
  
  /* Error */
  public final void bGJ()
  {
    // Byte code:
    //   0: ldc 196
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 138	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 27	com/tencent/mm/plugin/game/model/aa:mAppId	Ljava/lang/String;
    //   16: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 145
    //   21: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_3
    //   28: new 198	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 199	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore 4
    //   37: new 201	java/io/ObjectOutputStream
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 204	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 32	com/tencent/mm/plugin/game/model/aa:now	Ljava/util/List;
    //   54: invokeinterface 210 2 0
    //   59: aload_2
    //   60: astore_1
    //   61: aload 4
    //   63: invokevirtual 214	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore 5
    //   68: aload_2
    //   69: astore_1
    //   70: ldc 151
    //   72: invokestatic 157	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   75: checkcast 151	com/tencent/mm/plugin/game/api/e
    //   78: invokeinterface 161 1 0
    //   83: aload_3
    //   84: aload 5
    //   86: invokevirtual 218	com/tencent/mm/plugin/game/model/w:w	(Ljava/lang/String;[B)Z
    //   89: pop
    //   90: aload_2
    //   91: invokeinterface 219 1 0
    //   96: aload 4
    //   98: invokevirtual 220	java/io/ByteArrayOutputStream:close	()V
    //   101: ldc 196
    //   103: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc 196
    //   110: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 188
    //   121: aload_3
    //   122: ldc 25
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 194	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: ifnull +9 -> 141
    //   135: aload_2
    //   136: invokeinterface 219 1 0
    //   141: aload 4
    //   143: invokevirtual 220	java/io/ByteArrayOutputStream:close	()V
    //   146: ldc 196
    //   148: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore_1
    //   153: ldc 196
    //   155: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +9 -> 172
    //   166: aload_1
    //   167: invokeinterface 219 1 0
    //   172: aload 4
    //   174: invokevirtual 220	java/io/ByteArrayOutputStream:close	()V
    //   177: ldc 196
    //   179: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_2
    //   183: athrow
    //   184: astore_1
    //   185: goto -89 -> 96
    //   188: astore_1
    //   189: goto -48 -> 141
    //   192: astore_1
    //   193: goto -21 -> 172
    //   196: astore_1
    //   197: goto -20 -> 177
    //   200: astore_2
    //   201: goto -39 -> 162
    //   204: astore_3
    //   205: goto -88 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	this	aa
    //   48	22	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   107	1	1	localIOException1	java.io.IOException
    //   118	1	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   152	1	1	localIOException2	java.io.IOException
    //   161	6	1	localObject1	Object
    //   184	1	1	localIOException3	java.io.IOException
    //   188	1	1	localIOException4	java.io.IOException
    //   192	1	1	localIOException5	java.io.IOException
    //   196	1	1	localIOException6	java.io.IOException
    //   46	90	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   159	24	2	localObject2	Object
    //   200	1	2	localObject3	Object
    //   27	57	3	str	String
    //   114	8	3	localException1	java.lang.Exception
    //   204	1	3	localException2	java.lang.Exception
    //   35	138	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   66	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   96	101	107	java/io/IOException
    //   37	47	114	java/lang/Exception
    //   141	146	152	java/io/IOException
    //   37	47	159	finally
    //   90	96	184	java/io/IOException
    //   135	141	188	java/io/IOException
    //   166	172	192	java/io/IOException
    //   172	177	196	java/io/IOException
    //   49	59	200	finally
    //   61	68	200	finally
    //   70	90	200	finally
    //   119	131	200	finally
    //   49	59	204	java/lang/Exception
    //   61	68	204	java/lang/Exception
    //   70	90	204	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aa
 * JD-Core Version:    0.7.0.1
 */