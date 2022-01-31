package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;

public final class ah
{
  public static String a(String paramString, LinkedList<n.i> paramLinkedList, HashMap<String, n.e> paramHashMap)
  {
    AppMethodBeat.i(111408);
    if ((bo.isNullOrNil(paramString)) || (bo.es(paramLinkedList)))
    {
      AppMethodBeat.o(111408);
      return paramString;
    }
    String str1 = aa(paramLinkedList);
    if (bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(111408);
      return paramString;
    }
    String str2 = a(paramLinkedList, paramHashMap);
    paramHashMap = new StringBuilder(paramString);
    try
    {
      if (paramHashMap.indexOf("<userinfo>") != -1) {
        paramHashMap.insert(paramHashMap.indexOf("<userinfo>"), "<usercount>" + paramLinkedList.size() + 1 + "</usercount>");
      }
      if (paramHashMap.lastIndexOf("</userinfo>") != -1) {
        paramHashMap.insert(paramHashMap.lastIndexOf("</userinfo>") + 11, str1);
      }
      if ((paramHashMap.lastIndexOf("</jump>") != -1) && (!bo.isNullOrNil(str2))) {
        paramHashMap.insert(paramHashMap.lastIndexOf("</jump>") + 7, str2);
      }
    }
    catch (Exception paramLinkedList)
    {
      for (;;)
      {
        ab.e("MicroMsg.GameXmlProcess", paramLinkedList.getMessage());
        ab.e("MicroMsg.GameXmlProcess", "xml is invalid : ".concat(String.valueOf(paramString)));
      }
    }
    paramString = paramHashMap.toString();
    AppMethodBeat.o(111408);
    return paramString;
  }
  
  /* Error */
  private static String a(LinkedList<n.i> paramLinkedList, HashMap<String, n.e> paramHashMap)
  {
    // Byte code:
    //   0: ldc 106
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 25	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokevirtual 112	java/util/HashMap:isEmpty	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 106
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 114
    //   26: areturn
    //   27: new 116	java/io/StringWriter
    //   30: dup
    //   31: invokespecial 119	java/io/StringWriter:<init>	()V
    //   34: astore_2
    //   35: invokestatic 125	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   38: invokevirtual 129	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   41: astore_3
    //   42: aload_3
    //   43: aload_2
    //   44: invokeinterface 135 2 0
    //   49: aload_0
    //   50: invokevirtual 139	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   53: astore_0
    //   54: aload_0
    //   55: invokeinterface 144 1 0
    //   60: ifeq +189 -> 249
    //   63: aload_0
    //   64: invokeinterface 148 1 0
    //   69: checkcast 150	com/tencent/mm/plugin/game/model/n$i
    //   72: astore 5
    //   74: aload_1
    //   75: aload 5
    //   77: getfield 154	com/tencent/mm/plugin/game/model/n$i:nof	Ljava/lang/String;
    //   80: invokevirtual 158	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 160	com/tencent/mm/plugin/game/model/n$e
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull -36 -> 54
    //   93: aload_3
    //   94: aconst_null
    //   95: ldc 162
    //   97: invokeinterface 166 3 0
    //   102: pop
    //   103: aload_3
    //   104: aconst_null
    //   105: ldc 168
    //   107: aload 5
    //   109: getfield 154	com/tencent/mm/plugin/game/model/n$i:nof	Ljava/lang/String;
    //   112: invokeinterface 172 4 0
    //   117: pop
    //   118: aload_3
    //   119: aconst_null
    //   120: ldc 174
    //   122: invokeinterface 166 3 0
    //   127: pop
    //   128: aload_3
    //   129: aload 4
    //   131: getfield 178	com/tencent/mm/plugin/game/model/n$e:mJumpType	I
    //   134: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   137: invokeinterface 185 2 0
    //   142: pop
    //   143: aload_3
    //   144: aconst_null
    //   145: ldc 174
    //   147: invokeinterface 188 3 0
    //   152: pop
    //   153: aload_3
    //   154: aconst_null
    //   155: ldc 190
    //   157: invokeinterface 166 3 0
    //   162: pop
    //   163: aload_3
    //   164: aload 4
    //   166: getfield 193	com/tencent/mm/plugin/game/model/n$e:lMw	Ljava/lang/String;
    //   169: ldc 114
    //   171: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: invokeinterface 185 2 0
    //   179: pop
    //   180: aload_3
    //   181: aconst_null
    //   182: ldc 190
    //   184: invokeinterface 188 3 0
    //   189: pop
    //   190: aload_3
    //   191: aconst_null
    //   192: ldc 162
    //   194: invokeinterface 188 3 0
    //   199: pop
    //   200: goto -146 -> 54
    //   203: astore_0
    //   204: ldc 81
    //   206: aload_0
    //   207: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   210: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: ldc 106
    //   215: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: ldc 114
    //   220: areturn
    //   221: astore 5
    //   223: aload_3
    //   224: ldc 114
    //   226: invokeinterface 185 2 0
    //   231: pop
    //   232: goto -89 -> 143
    //   235: astore 4
    //   237: aload_3
    //   238: ldc 114
    //   240: invokeinterface 185 2 0
    //   245: pop
    //   246: goto -66 -> 180
    //   249: aload_3
    //   250: invokeinterface 200 1 0
    //   255: aload_2
    //   256: invokevirtual 203	java/io/StringWriter:flush	()V
    //   259: aload_2
    //   260: invokevirtual 206	java/io/StringWriter:close	()V
    //   263: aload_2
    //   264: invokevirtual 210	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   267: invokevirtual 213	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   270: astore_0
    //   271: ldc 106
    //   273: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_0
    //   277: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramLinkedList	LinkedList<n.i>
    //   0	278	1	paramHashMap	HashMap<String, n.e>
    //   34	230	2	localStringWriter	java.io.StringWriter
    //   41	209	3	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   86	79	4	locale	n.e
    //   235	1	4	localException1	Exception
    //   72	36	5	locali	n.i
    //   221	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   35	54	203	java/lang/Exception
    //   54	88	203	java/lang/Exception
    //   93	128	203	java/lang/Exception
    //   143	163	203	java/lang/Exception
    //   180	200	203	java/lang/Exception
    //   223	232	203	java/lang/Exception
    //   237	246	203	java/lang/Exception
    //   249	263	203	java/lang/Exception
    //   128	143	221	java/lang/Exception
    //   163	180	235	java/lang/Exception
  }
  
  /* Error */
  private static String aa(LinkedList<n.i> paramLinkedList)
  {
    // Byte code:
    //   0: ldc 215
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 25	com/tencent/mm/sdk/platformtools/bo:es	(Ljava/util/List;)Z
    //   9: ifeq +11 -> 20
    //   12: ldc 215
    //   14: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc 114
    //   19: areturn
    //   20: new 116	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 119	java/io/StringWriter:<init>	()V
    //   27: astore_1
    //   28: invokestatic 125	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   31: invokevirtual 129	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   34: astore_2
    //   35: aload_2
    //   36: aload_1
    //   37: invokeinterface 135 2 0
    //   42: aload_0
    //   43: invokevirtual 139	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   46: astore_0
    //   47: aload_0
    //   48: invokeinterface 144 1 0
    //   53: ifeq +317 -> 370
    //   56: aload_0
    //   57: invokeinterface 148 1 0
    //   62: checkcast 150	com/tencent/mm/plugin/game/model/n$i
    //   65: astore_3
    //   66: aload_2
    //   67: aconst_null
    //   68: ldc 217
    //   70: invokeinterface 166 3 0
    //   75: pop
    //   76: aload_2
    //   77: aconst_null
    //   78: ldc 219
    //   80: aload_3
    //   81: getfield 154	com/tencent/mm/plugin/game/model/n$i:nof	Ljava/lang/String;
    //   84: invokeinterface 172 4 0
    //   89: pop
    //   90: aload_2
    //   91: aconst_null
    //   92: ldc 221
    //   94: invokeinterface 166 3 0
    //   99: pop
    //   100: aload_2
    //   101: aload_3
    //   102: getfield 224	com/tencent/mm/plugin/game/model/n$i:userName	Ljava/lang/String;
    //   105: ldc 114
    //   107: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: invokeinterface 185 2 0
    //   115: pop
    //   116: aload_2
    //   117: aconst_null
    //   118: ldc 221
    //   120: invokeinterface 188 3 0
    //   125: pop
    //   126: aload_2
    //   127: aconst_null
    //   128: ldc 226
    //   130: invokeinterface 166 3 0
    //   135: pop
    //   136: aload_2
    //   137: aload_3
    //   138: getfield 229	com/tencent/mm/plugin/game/model/n$i:blZ	Ljava/lang/String;
    //   141: ldc 114
    //   143: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: invokeinterface 185 2 0
    //   151: pop
    //   152: aload_2
    //   153: aconst_null
    //   154: ldc 226
    //   156: invokeinterface 188 3 0
    //   161: pop
    //   162: aload_2
    //   163: aconst_null
    //   164: ldc 231
    //   166: invokeinterface 166 3 0
    //   171: pop
    //   172: aload_2
    //   173: aload_3
    //   174: getfield 234	com/tencent/mm/plugin/game/model/n$i:noc	Ljava/lang/String;
    //   177: ldc 114
    //   179: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: invokeinterface 185 2 0
    //   187: pop
    //   188: aload_2
    //   189: aconst_null
    //   190: ldc 231
    //   192: invokeinterface 188 3 0
    //   197: pop
    //   198: aload_2
    //   199: aconst_null
    //   200: ldc 236
    //   202: invokeinterface 166 3 0
    //   207: pop
    //   208: aload_2
    //   209: aload_3
    //   210: getfield 239	com/tencent/mm/plugin/game/model/n$i:nod	Ljava/lang/String;
    //   213: ldc 114
    //   215: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: invokeinterface 185 2 0
    //   223: pop
    //   224: aload_2
    //   225: aconst_null
    //   226: ldc 236
    //   228: invokeinterface 188 3 0
    //   233: pop
    //   234: aload_2
    //   235: aconst_null
    //   236: ldc 241
    //   238: invokeinterface 166 3 0
    //   243: pop
    //   244: aload_2
    //   245: aload_3
    //   246: getfield 244	com/tencent/mm/plugin/game/model/n$i:noe	Ljava/lang/String;
    //   249: ldc 114
    //   251: invokestatic 197	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: invokeinterface 185 2 0
    //   259: pop
    //   260: aload_2
    //   261: aconst_null
    //   262: ldc 241
    //   264: invokeinterface 188 3 0
    //   269: pop
    //   270: aload_2
    //   271: aconst_null
    //   272: ldc 217
    //   274: invokeinterface 188 3 0
    //   279: pop
    //   280: goto -233 -> 47
    //   283: astore_0
    //   284: ldc 81
    //   286: aload_0
    //   287: invokevirtual 84	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: ldc 215
    //   295: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: ldc 114
    //   300: areturn
    //   301: astore 4
    //   303: aload_2
    //   304: ldc 114
    //   306: invokeinterface 185 2 0
    //   311: pop
    //   312: goto -196 -> 116
    //   315: astore 4
    //   317: aload_2
    //   318: ldc 114
    //   320: invokeinterface 185 2 0
    //   325: pop
    //   326: goto -174 -> 152
    //   329: astore 4
    //   331: aload_2
    //   332: ldc 114
    //   334: invokeinterface 185 2 0
    //   339: pop
    //   340: goto -152 -> 188
    //   343: astore 4
    //   345: aload_2
    //   346: ldc 114
    //   348: invokeinterface 185 2 0
    //   353: pop
    //   354: goto -130 -> 224
    //   357: astore_3
    //   358: aload_2
    //   359: ldc 114
    //   361: invokeinterface 185 2 0
    //   366: pop
    //   367: goto -107 -> 260
    //   370: aload_2
    //   371: invokeinterface 200 1 0
    //   376: aload_1
    //   377: invokevirtual 203	java/io/StringWriter:flush	()V
    //   380: aload_1
    //   381: invokevirtual 206	java/io/StringWriter:close	()V
    //   384: aload_1
    //   385: invokevirtual 210	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   388: invokevirtual 213	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   391: astore_0
    //   392: ldc 215
    //   394: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   397: aload_0
    //   398: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramLinkedList	LinkedList<n.i>
    //   27	358	1	localStringWriter	java.io.StringWriter
    //   34	337	2	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   65	181	3	locali	n.i
    //   357	1	3	localException1	Exception
    //   301	1	4	localException2	Exception
    //   315	1	4	localException3	Exception
    //   329	1	4	localException4	Exception
    //   343	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   28	47	283	java/lang/Exception
    //   47	100	283	java/lang/Exception
    //   116	136	283	java/lang/Exception
    //   152	172	283	java/lang/Exception
    //   188	208	283	java/lang/Exception
    //   224	244	283	java/lang/Exception
    //   260	280	283	java/lang/Exception
    //   303	312	283	java/lang/Exception
    //   317	326	283	java/lang/Exception
    //   331	340	283	java/lang/Exception
    //   345	354	283	java/lang/Exception
    //   358	367	283	java/lang/Exception
    //   370	384	283	java/lang/Exception
    //   100	116	301	java/lang/Exception
    //   136	152	315	java/lang/Exception
    //   172	188	329	java/lang/Exception
    //   208	224	343	java/lang/Exception
    //   244	260	357	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ah
 * JD-Core Version:    0.7.0.1
 */