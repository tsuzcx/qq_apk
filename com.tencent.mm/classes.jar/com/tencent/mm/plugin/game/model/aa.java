package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.df;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
{
  public String mAppId;
  public List<a> udz;
  
  public aa(String paramString)
  {
    AppMethodBeat.i(41531);
    this.mAppId = "";
    this.udz = new LinkedList();
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(41531);
      return;
    }
    this.mAppId = paramString;
    this.udz.addAll(cZt());
    AppMethodBeat.o(41531);
  }
  
  public aa(String paramString, List<df> paramList)
  {
    AppMethodBeat.i(41532);
    this.mAppId = "";
    this.udz = new LinkedList();
    if ((bt.isNullOrNil(paramString)) || (paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(41532);
      return;
    }
    this.mAppId = paramString;
    this.udz.clear();
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (df)paramString.next();
      a locala = new a();
      locala.udA = paramList.ujD;
      locala.dDy = paramList.nDo;
      locala.tag = paramList.Label;
      locala.tvn = paramList.ujE;
      locala.udC = paramList.ujF;
      locala.udB = paramList.ujG;
      locala.udD = paramList.ujH;
      this.udz.add(locala);
    }
    cZu();
    AppMethodBeat.o(41532);
  }
  
  /* Error */
  private List<a> cZt()
  {
    // Byte code:
    //   0: ldc 137
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 139	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 28	com/tencent/mm/plugin/game/model/aa:mAppId	Ljava/lang/String;
    //   16: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 146
    //   21: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_1
    //   28: new 30	java/util/LinkedList
    //   31: dup
    //   32: invokespecial 31	java/util/LinkedList:<init>	()V
    //   35: astore 4
    //   37: ldc 152
    //   39: invokestatic 158	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   42: checkcast 152	com/tencent/mm/plugin/game/api/f
    //   45: invokeinterface 162 1 0
    //   50: aload_1
    //   51: invokevirtual 168	com/tencent/mm/plugin/game/model/w:all	(Ljava/lang/String;)[B
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +11 -> 67
    //   59: ldc 137
    //   61: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   64: aload 4
    //   66: areturn
    //   67: new 170	java/io/ByteArrayInputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 173	java/io/ByteArrayInputStream:<init>	([B)V
    //   75: astore 5
    //   77: new 175	java/io/ObjectInputStream
    //   80: dup
    //   81: aload 5
    //   83: invokespecial 178	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   86: astore_2
    //   87: aload_2
    //   88: astore_1
    //   89: aload 4
    //   91: aload_2
    //   92: invokeinterface 183 1 0
    //   97: checkcast 48	java/util/List
    //   100: invokeinterface 52 2 0
    //   105: pop
    //   106: aload 5
    //   108: invokevirtual 186	java/io/ByteArrayInputStream:close	()V
    //   111: aload_2
    //   112: invokeinterface 187 1 0
    //   117: ldc 137
    //   119: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload 4
    //   124: areturn
    //   125: astore_3
    //   126: aconst_null
    //   127: astore_2
    //   128: aload_2
    //   129: astore_1
    //   130: ldc 189
    //   132: aload_3
    //   133: ldc 26
    //   135: iconst_0
    //   136: anewarray 4	java/lang/Object
    //   139: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: aload 5
    //   144: invokevirtual 186	java/io/ByteArrayInputStream:close	()V
    //   147: aload_2
    //   148: ifnull -31 -> 117
    //   151: aload_2
    //   152: invokeinterface 187 1 0
    //   157: goto -40 -> 117
    //   160: astore_1
    //   161: goto -44 -> 117
    //   164: astore_2
    //   165: aconst_null
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 186	java/io/ByteArrayInputStream:close	()V
    //   172: aload_1
    //   173: ifnull +9 -> 182
    //   176: aload_1
    //   177: invokeinterface 187 1 0
    //   182: ldc 137
    //   184: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public final void cZu()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 139	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   12: aload_0
    //   13: getfield 28	com/tencent/mm/plugin/game/model/aa:mAppId	Ljava/lang/String;
    //   16: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc 146
    //   21: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_3
    //   28: new 199	java/io/ByteArrayOutputStream
    //   31: dup
    //   32: invokespecial 200	java/io/ByteArrayOutputStream:<init>	()V
    //   35: astore 4
    //   37: new 202	java/io/ObjectOutputStream
    //   40: dup
    //   41: aload 4
    //   43: invokespecial 205	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   46: astore_2
    //   47: aload_2
    //   48: astore_1
    //   49: aload_2
    //   50: aload_0
    //   51: getfield 33	com/tencent/mm/plugin/game/model/aa:udz	Ljava/util/List;
    //   54: invokeinterface 211 2 0
    //   59: aload_2
    //   60: astore_1
    //   61: aload 4
    //   63: invokevirtual 215	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   66: astore 5
    //   68: aload_2
    //   69: astore_1
    //   70: ldc 152
    //   72: invokestatic 158	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   75: checkcast 152	com/tencent/mm/plugin/game/api/f
    //   78: invokeinterface 162 1 0
    //   83: aload_3
    //   84: aload 5
    //   86: invokevirtual 219	com/tencent/mm/plugin/game/model/w:r	(Ljava/lang/String;[B)Z
    //   89: pop
    //   90: aload_2
    //   91: invokeinterface 220 1 0
    //   96: aload 4
    //   98: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   101: ldc 197
    //   103: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: return
    //   107: astore_1
    //   108: ldc 197
    //   110: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: astore_3
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: astore_1
    //   119: ldc 189
    //   121: aload_3
    //   122: ldc 26
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 195	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: aload_2
    //   132: ifnull +9 -> 141
    //   135: aload_2
    //   136: invokeinterface 220 1 0
    //   141: aload 4
    //   143: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   146: ldc 197
    //   148: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: return
    //   152: astore_1
    //   153: ldc 197
    //   155: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore_2
    //   160: aconst_null
    //   161: astore_1
    //   162: aload_1
    //   163: ifnull +9 -> 172
    //   166: aload_1
    //   167: invokeinterface 220 1 0
    //   172: aload 4
    //   174: invokevirtual 221	java/io/ByteArrayOutputStream:close	()V
    //   177: ldc 197
    //   179: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static final class a
    implements Serializable
  {
    public String dDy;
    public String tag;
    public long tvn;
    public int udA;
    public int udB;
    public boolean udC;
    public String udD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.aa
 * JD-Core Version:    0.7.0.1
 */