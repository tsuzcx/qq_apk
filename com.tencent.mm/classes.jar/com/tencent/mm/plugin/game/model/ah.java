package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public final class ah
{
  public static String a(String paramString, LinkedList<o.j> paramLinkedList, HashMap<String, o.f> paramHashMap)
  {
    AppMethodBeat.i(41573);
    if ((bt.isNullOrNil(paramString)) || (bt.hj(paramLinkedList)))
    {
      AppMethodBeat.o(41573);
      return paramString;
    }
    String str1 = ay(paramLinkedList);
    if (bt.isNullOrNil(str1))
    {
      AppMethodBeat.o(41573);
      return paramString;
    }
    String str2 = b(paramLinkedList, paramHashMap);
    paramHashMap = new StringBuilder(paramString);
    try
    {
      if (paramHashMap.indexOf("<userinfo>") != -1) {
        paramHashMap.insert(paramHashMap.indexOf("<userinfo>"), "<usercount>" + paramLinkedList.size() + 1 + "</usercount>");
      }
      if (paramHashMap.lastIndexOf("</userinfo>") != -1) {
        paramHashMap.insert(paramHashMap.lastIndexOf("</userinfo>") + 11, str1);
      }
      if ((paramHashMap.lastIndexOf("</jump>") != -1) && (!bt.isNullOrNil(str2))) {
        paramHashMap.insert(paramHashMap.lastIndexOf("</jump>") + 7, str2);
      }
    }
    catch (Exception paramLinkedList)
    {
      for (;;)
      {
        ad.e("MicroMsg.GameXmlProcess", paramLinkedList.getMessage());
        ad.e("MicroMsg.GameXmlProcess", "xml is invalid : ".concat(String.valueOf(paramString)));
      }
    }
    paramString = paramHashMap.toString();
    AppMethodBeat.o(41573);
    return paramString;
  }
  
  /* Error */
  private static String ay(LinkedList<o.j> paramLinkedList)
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 25	com/tencent/mm/sdk/platformtools/bt:hj	(Ljava/util/List;)Z
    //   9: ifeq +11 -> 20
    //   12: ldc 107
    //   14: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: ldc 109
    //   19: areturn
    //   20: new 111	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 114	java/io/StringWriter:<init>	()V
    //   27: astore_1
    //   28: invokestatic 120	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   31: invokevirtual 124	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   34: astore_2
    //   35: aload_2
    //   36: aload_1
    //   37: invokeinterface 130 2 0
    //   42: aload_0
    //   43: invokevirtual 134	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   46: astore_0
    //   47: aload_0
    //   48: invokeinterface 140 1 0
    //   53: ifeq +317 -> 370
    //   56: aload_0
    //   57: invokeinterface 144 1 0
    //   62: checkcast 146	com/tencent/mm/plugin/game/model/o$j
    //   65: astore_3
    //   66: aload_2
    //   67: aconst_null
    //   68: ldc 148
    //   70: invokeinterface 152 3 0
    //   75: pop
    //   76: aload_2
    //   77: aconst_null
    //   78: ldc 154
    //   80: aload_3
    //   81: getfield 158	com/tencent/mm/plugin/game/model/o$j:ucW	Ljava/lang/String;
    //   84: invokeinterface 162 4 0
    //   89: pop
    //   90: aload_2
    //   91: aconst_null
    //   92: ldc 164
    //   94: invokeinterface 152 3 0
    //   99: pop
    //   100: aload_2
    //   101: aload_3
    //   102: getfield 167	com/tencent/mm/plugin/game/model/o$j:userName	Ljava/lang/String;
    //   105: ldc 109
    //   107: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: invokeinterface 175 2 0
    //   115: pop
    //   116: aload_2
    //   117: aconst_null
    //   118: ldc 164
    //   120: invokeinterface 178 3 0
    //   125: pop
    //   126: aload_2
    //   127: aconst_null
    //   128: ldc 180
    //   130: invokeinterface 152 3 0
    //   135: pop
    //   136: aload_2
    //   137: aload_3
    //   138: getfield 183	com/tencent/mm/plugin/game/model/o$j:bVF	Ljava/lang/String;
    //   141: ldc 109
    //   143: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   146: invokeinterface 175 2 0
    //   151: pop
    //   152: aload_2
    //   153: aconst_null
    //   154: ldc 180
    //   156: invokeinterface 178 3 0
    //   161: pop
    //   162: aload_2
    //   163: aconst_null
    //   164: ldc 185
    //   166: invokeinterface 152 3 0
    //   171: pop
    //   172: aload_2
    //   173: aload_3
    //   174: getfield 188	com/tencent/mm/plugin/game/model/o$j:ucT	Ljava/lang/String;
    //   177: ldc 109
    //   179: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   182: invokeinterface 175 2 0
    //   187: pop
    //   188: aload_2
    //   189: aconst_null
    //   190: ldc 185
    //   192: invokeinterface 178 3 0
    //   197: pop
    //   198: aload_2
    //   199: aconst_null
    //   200: ldc 190
    //   202: invokeinterface 152 3 0
    //   207: pop
    //   208: aload_2
    //   209: aload_3
    //   210: getfield 193	com/tencent/mm/plugin/game/model/o$j:ucU	Ljava/lang/String;
    //   213: ldc 109
    //   215: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   218: invokeinterface 175 2 0
    //   223: pop
    //   224: aload_2
    //   225: aconst_null
    //   226: ldc 190
    //   228: invokeinterface 178 3 0
    //   233: pop
    //   234: aload_2
    //   235: aconst_null
    //   236: ldc 195
    //   238: invokeinterface 152 3 0
    //   243: pop
    //   244: aload_2
    //   245: aload_3
    //   246: getfield 198	com/tencent/mm/plugin/game/model/o$j:ucV	Ljava/lang/String;
    //   249: ldc 109
    //   251: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   254: invokeinterface 175 2 0
    //   259: pop
    //   260: aload_2
    //   261: aconst_null
    //   262: ldc 195
    //   264: invokeinterface 178 3 0
    //   269: pop
    //   270: aload_2
    //   271: aconst_null
    //   272: ldc 148
    //   274: invokeinterface 178 3 0
    //   279: pop
    //   280: goto -233 -> 47
    //   283: astore_0
    //   284: ldc 82
    //   286: aload_0
    //   287: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   290: invokestatic 91	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: ldc 107
    //   295: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: ldc 109
    //   300: areturn
    //   301: astore 4
    //   303: aload_2
    //   304: ldc 109
    //   306: invokeinterface 175 2 0
    //   311: pop
    //   312: goto -196 -> 116
    //   315: astore 4
    //   317: aload_2
    //   318: ldc 109
    //   320: invokeinterface 175 2 0
    //   325: pop
    //   326: goto -174 -> 152
    //   329: astore 4
    //   331: aload_2
    //   332: ldc 109
    //   334: invokeinterface 175 2 0
    //   339: pop
    //   340: goto -152 -> 188
    //   343: astore 4
    //   345: aload_2
    //   346: ldc 109
    //   348: invokeinterface 175 2 0
    //   353: pop
    //   354: goto -130 -> 224
    //   357: astore_3
    //   358: aload_2
    //   359: ldc 109
    //   361: invokeinterface 175 2 0
    //   366: pop
    //   367: goto -107 -> 260
    //   370: aload_2
    //   371: invokeinterface 201 1 0
    //   376: aload_1
    //   377: invokevirtual 204	java/io/StringWriter:flush	()V
    //   380: aload_1
    //   381: invokevirtual 207	java/io/StringWriter:close	()V
    //   384: aload_1
    //   385: invokevirtual 211	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   388: invokevirtual 214	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   391: astore_0
    //   392: ldc 107
    //   394: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   397: aload_0
    //   398: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	paramLinkedList	LinkedList<o.j>
    //   27	358	1	localStringWriter	java.io.StringWriter
    //   34	337	2	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   65	181	3	localj	o.j
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
  
  /* Error */
  private static String b(LinkedList<o.j> paramLinkedList, HashMap<String, o.f> paramHashMap)
  {
    // Byte code:
    //   0: ldc 216
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 25	com/tencent/mm/sdk/platformtools/bt:hj	(Ljava/util/List;)Z
    //   9: ifne +10 -> 19
    //   12: aload_1
    //   13: invokevirtual 221	java/util/HashMap:isEmpty	()Z
    //   16: ifeq +11 -> 27
    //   19: ldc 216
    //   21: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: ldc 109
    //   26: areturn
    //   27: new 111	java/io/StringWriter
    //   30: dup
    //   31: invokespecial 114	java/io/StringWriter:<init>	()V
    //   34: astore_2
    //   35: invokestatic 120	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   38: invokevirtual 124	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   41: astore_3
    //   42: aload_3
    //   43: aload_2
    //   44: invokeinterface 130 2 0
    //   49: aload_0
    //   50: invokevirtual 134	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   53: astore_0
    //   54: aload_0
    //   55: invokeinterface 140 1 0
    //   60: ifeq +189 -> 249
    //   63: aload_0
    //   64: invokeinterface 144 1 0
    //   69: checkcast 146	com/tencent/mm/plugin/game/model/o$j
    //   72: astore 5
    //   74: aload_1
    //   75: aload 5
    //   77: getfield 158	com/tencent/mm/plugin/game/model/o$j:ucW	Ljava/lang/String;
    //   80: invokevirtual 225	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   83: checkcast 227	com/tencent/mm/plugin/game/model/o$f
    //   86: astore 4
    //   88: aload 4
    //   90: ifnull -36 -> 54
    //   93: aload_3
    //   94: aconst_null
    //   95: ldc 229
    //   97: invokeinterface 152 3 0
    //   102: pop
    //   103: aload_3
    //   104: aconst_null
    //   105: ldc 231
    //   107: aload 5
    //   109: getfield 158	com/tencent/mm/plugin/game/model/o$j:ucW	Ljava/lang/String;
    //   112: invokeinterface 162 4 0
    //   117: pop
    //   118: aload_3
    //   119: aconst_null
    //   120: ldc 233
    //   122: invokeinterface 152 3 0
    //   127: pop
    //   128: aload_3
    //   129: aload 4
    //   131: getfield 237	com/tencent/mm/plugin/game/model/o$f:mJumpType	I
    //   134: invokestatic 240	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   137: invokeinterface 175 2 0
    //   142: pop
    //   143: aload_3
    //   144: aconst_null
    //   145: ldc 233
    //   147: invokeinterface 178 3 0
    //   152: pop
    //   153: aload_3
    //   154: aconst_null
    //   155: ldc 242
    //   157: invokeinterface 152 3 0
    //   162: pop
    //   163: aload_3
    //   164: aload 4
    //   166: getfield 245	com/tencent/mm/plugin/game/model/o$f:qjX	Ljava/lang/String;
    //   169: ldc 109
    //   171: invokestatic 171	com/tencent/mm/sdk/platformtools/bt:bI	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   174: invokeinterface 175 2 0
    //   179: pop
    //   180: aload_3
    //   181: aconst_null
    //   182: ldc 242
    //   184: invokeinterface 178 3 0
    //   189: pop
    //   190: aload_3
    //   191: aconst_null
    //   192: ldc 229
    //   194: invokeinterface 178 3 0
    //   199: pop
    //   200: goto -146 -> 54
    //   203: astore_0
    //   204: ldc 82
    //   206: aload_0
    //   207: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   210: invokestatic 91	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: ldc 216
    //   215: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: ldc 109
    //   220: areturn
    //   221: astore 5
    //   223: aload_3
    //   224: ldc 109
    //   226: invokeinterface 175 2 0
    //   231: pop
    //   232: goto -89 -> 143
    //   235: astore 4
    //   237: aload_3
    //   238: ldc 109
    //   240: invokeinterface 175 2 0
    //   245: pop
    //   246: goto -66 -> 180
    //   249: aload_3
    //   250: invokeinterface 201 1 0
    //   255: aload_2
    //   256: invokevirtual 204	java/io/StringWriter:flush	()V
    //   259: aload_2
    //   260: invokevirtual 207	java/io/StringWriter:close	()V
    //   263: aload_2
    //   264: invokevirtual 211	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   267: invokevirtual 214	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   270: astore_0
    //   271: ldc 216
    //   273: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_0
    //   277: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramLinkedList	LinkedList<o.j>
    //   0	278	1	paramHashMap	HashMap<String, o.f>
    //   34	230	2	localStringWriter	java.io.StringWriter
    //   41	209	3	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   86	79	4	localf	o.f
    //   235	1	4	localException1	Exception
    //   72	36	5	localj	o.j
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ah
 * JD-Core Version:    0.7.0.1
 */