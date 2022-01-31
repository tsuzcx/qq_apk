package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

public final class ai
{
  /* Error */
  private static String T(LinkedList<o.h> paramLinkedList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 14	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   4: ifeq +6 -> 10
    //   7: ldc 16
    //   9: areturn
    //   10: new 18	java/io/StringWriter
    //   13: dup
    //   14: invokespecial 22	java/io/StringWriter:<init>	()V
    //   17: astore_1
    //   18: invokestatic 28	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   21: invokevirtual 32	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   24: astore_2
    //   25: aload_2
    //   26: aload_1
    //   27: invokeinterface 38 2 0
    //   32: aload_0
    //   33: invokevirtual 44	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   36: astore_0
    //   37: aload_0
    //   38: invokeinterface 50 1 0
    //   43: ifeq +312 -> 355
    //   46: aload_0
    //   47: invokeinterface 54 1 0
    //   52: checkcast 56	com/tencent/mm/plugin/game/model/o$h
    //   55: astore_3
    //   56: aload_2
    //   57: aconst_null
    //   58: ldc 58
    //   60: invokeinterface 62 3 0
    //   65: pop
    //   66: aload_2
    //   67: aconst_null
    //   68: ldc 64
    //   70: aload_3
    //   71: getfield 68	com/tencent/mm/plugin/game/model/o$h:kQe	Ljava/lang/String;
    //   74: invokeinterface 72 4 0
    //   79: pop
    //   80: aload_2
    //   81: aconst_null
    //   82: ldc 74
    //   84: invokeinterface 62 3 0
    //   89: pop
    //   90: aload_2
    //   91: aload_3
    //   92: getfield 77	com/tencent/mm/plugin/game/model/o$h:userName	Ljava/lang/String;
    //   95: ldc 16
    //   97: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: invokeinterface 85 2 0
    //   105: pop
    //   106: aload_2
    //   107: aconst_null
    //   108: ldc 74
    //   110: invokeinterface 88 3 0
    //   115: pop
    //   116: aload_2
    //   117: aconst_null
    //   118: ldc 90
    //   120: invokeinterface 62 3 0
    //   125: pop
    //   126: aload_2
    //   127: aload_3
    //   128: getfield 93	com/tencent/mm/plugin/game/model/o$h:aVr	Ljava/lang/String;
    //   131: ldc 16
    //   133: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   136: invokeinterface 85 2 0
    //   141: pop
    //   142: aload_2
    //   143: aconst_null
    //   144: ldc 90
    //   146: invokeinterface 88 3 0
    //   151: pop
    //   152: aload_2
    //   153: aconst_null
    //   154: ldc 95
    //   156: invokeinterface 62 3 0
    //   161: pop
    //   162: aload_2
    //   163: aload_3
    //   164: getfield 98	com/tencent/mm/plugin/game/model/o$h:kQb	Ljava/lang/String;
    //   167: ldc 16
    //   169: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   172: invokeinterface 85 2 0
    //   177: pop
    //   178: aload_2
    //   179: aconst_null
    //   180: ldc 95
    //   182: invokeinterface 88 3 0
    //   187: pop
    //   188: aload_2
    //   189: aconst_null
    //   190: ldc 100
    //   192: invokeinterface 62 3 0
    //   197: pop
    //   198: aload_2
    //   199: aload_3
    //   200: getfield 103	com/tencent/mm/plugin/game/model/o$h:kQc	Ljava/lang/String;
    //   203: ldc 16
    //   205: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   208: invokeinterface 85 2 0
    //   213: pop
    //   214: aload_2
    //   215: aconst_null
    //   216: ldc 100
    //   218: invokeinterface 88 3 0
    //   223: pop
    //   224: aload_2
    //   225: aconst_null
    //   226: ldc 105
    //   228: invokeinterface 62 3 0
    //   233: pop
    //   234: aload_2
    //   235: aload_3
    //   236: getfield 108	com/tencent/mm/plugin/game/model/o$h:kQd	Ljava/lang/String;
    //   239: ldc 16
    //   241: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   244: invokeinterface 85 2 0
    //   249: pop
    //   250: aload_2
    //   251: aconst_null
    //   252: ldc 105
    //   254: invokeinterface 88 3 0
    //   259: pop
    //   260: aload_2
    //   261: aconst_null
    //   262: ldc 58
    //   264: invokeinterface 88 3 0
    //   269: pop
    //   270: goto -233 -> 37
    //   273: astore_0
    //   274: ldc 110
    //   276: aload_0
    //   277: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokestatic 120	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc 16
    //   285: areturn
    //   286: astore 4
    //   288: aload_2
    //   289: ldc 16
    //   291: invokeinterface 85 2 0
    //   296: pop
    //   297: goto -191 -> 106
    //   300: astore 4
    //   302: aload_2
    //   303: ldc 16
    //   305: invokeinterface 85 2 0
    //   310: pop
    //   311: goto -169 -> 142
    //   314: astore 4
    //   316: aload_2
    //   317: ldc 16
    //   319: invokeinterface 85 2 0
    //   324: pop
    //   325: goto -147 -> 178
    //   328: astore 4
    //   330: aload_2
    //   331: ldc 16
    //   333: invokeinterface 85 2 0
    //   338: pop
    //   339: goto -125 -> 214
    //   342: astore_3
    //   343: aload_2
    //   344: ldc 16
    //   346: invokeinterface 85 2 0
    //   351: pop
    //   352: goto -102 -> 250
    //   355: aload_2
    //   356: invokeinterface 123 1 0
    //   361: aload_1
    //   362: invokevirtual 126	java/io/StringWriter:flush	()V
    //   365: aload_1
    //   366: invokevirtual 129	java/io/StringWriter:close	()V
    //   369: aload_1
    //   370: invokevirtual 133	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   373: invokevirtual 138	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   376: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramLinkedList	LinkedList<o.h>
    //   17	353	1	localStringWriter	java.io.StringWriter
    //   24	332	2	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   55	181	3	localh	o.h
    //   342	1	3	localException1	Exception
    //   286	1	4	localException2	Exception
    //   300	1	4	localException3	Exception
    //   314	1	4	localException4	Exception
    //   328	1	4	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   18	37	273	java/lang/Exception
    //   37	90	273	java/lang/Exception
    //   106	126	273	java/lang/Exception
    //   142	162	273	java/lang/Exception
    //   178	198	273	java/lang/Exception
    //   214	234	273	java/lang/Exception
    //   250	270	273	java/lang/Exception
    //   288	297	273	java/lang/Exception
    //   302	311	273	java/lang/Exception
    //   316	325	273	java/lang/Exception
    //   330	339	273	java/lang/Exception
    //   343	352	273	java/lang/Exception
    //   355	369	273	java/lang/Exception
    //   90	106	286	java/lang/Exception
    //   126	142	300	java/lang/Exception
    //   162	178	314	java/lang/Exception
    //   198	214	328	java/lang/Exception
    //   234	250	342	java/lang/Exception
  }
  
  public static String a(String paramString, LinkedList<o.h> paramLinkedList, HashMap<String, o.d> paramHashMap)
  {
    if ((bk.bl(paramString)) || (bk.dk(paramLinkedList))) {}
    String str1;
    do
    {
      return paramString;
      str1 = T(paramLinkedList);
    } while (bk.bl(str1));
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
      if ((paramHashMap.lastIndexOf("</jump>") != -1) && (!bk.bl(str2))) {
        paramHashMap.insert(paramHashMap.lastIndexOf("</jump>") + 7, str2);
      }
    }
    catch (Exception paramLinkedList)
    {
      for (;;)
      {
        y.e("MicroMsg.GameXmlProcess", paramLinkedList.getMessage());
        y.e("MicroMsg.GameXmlProcess", "xml is invalid : " + paramString);
      }
    }
    return paramHashMap.toString();
  }
  
  /* Error */
  private static String a(LinkedList<o.h> paramLinkedList, HashMap<String, o.d> paramHashMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 14	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   4: ifne +10 -> 14
    //   7: aload_1
    //   8: invokevirtual 198	java/util/HashMap:isEmpty	()Z
    //   11: ifeq +6 -> 17
    //   14: ldc 16
    //   16: areturn
    //   17: new 18	java/io/StringWriter
    //   20: dup
    //   21: invokespecial 22	java/io/StringWriter:<init>	()V
    //   24: astore_2
    //   25: invokestatic 28	org/xmlpull/v1/XmlPullParserFactory:newInstance	()Lorg/xmlpull/v1/XmlPullParserFactory;
    //   28: invokevirtual 32	org/xmlpull/v1/XmlPullParserFactory:newSerializer	()Lorg/xmlpull/v1/XmlSerializer;
    //   31: astore_3
    //   32: aload_3
    //   33: aload_2
    //   34: invokeinterface 38 2 0
    //   39: aload_0
    //   40: invokevirtual 44	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   43: astore_0
    //   44: aload_0
    //   45: invokeinterface 50 1 0
    //   50: ifeq +184 -> 234
    //   53: aload_0
    //   54: invokeinterface 54 1 0
    //   59: checkcast 56	com/tencent/mm/plugin/game/model/o$h
    //   62: astore 5
    //   64: aload_1
    //   65: aload 5
    //   67: getfield 68	com/tencent/mm/plugin/game/model/o$h:kQe	Ljava/lang/String;
    //   70: invokevirtual 202	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   73: checkcast 204	com/tencent/mm/plugin/game/model/o$d
    //   76: astore 4
    //   78: aload 4
    //   80: ifnull -36 -> 44
    //   83: aload_3
    //   84: aconst_null
    //   85: ldc 206
    //   87: invokeinterface 62 3 0
    //   92: pop
    //   93: aload_3
    //   94: aconst_null
    //   95: ldc 208
    //   97: aload 5
    //   99: getfield 68	com/tencent/mm/plugin/game/model/o$h:kQe	Ljava/lang/String;
    //   102: invokeinterface 72 4 0
    //   107: pop
    //   108: aload_3
    //   109: aconst_null
    //   110: ldc 210
    //   112: invokeinterface 62 3 0
    //   117: pop
    //   118: aload_3
    //   119: aload 4
    //   121: getfield 214	com/tencent/mm/plugin/game/model/o$d:kPV	I
    //   124: invokestatic 220	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   127: invokeinterface 85 2 0
    //   132: pop
    //   133: aload_3
    //   134: aconst_null
    //   135: ldc 210
    //   137: invokeinterface 88 3 0
    //   142: pop
    //   143: aload_3
    //   144: aconst_null
    //   145: ldc 222
    //   147: invokeinterface 62 3 0
    //   152: pop
    //   153: aload_3
    //   154: aload 4
    //   156: getfield 225	com/tencent/mm/plugin/game/model/o$d:jCY	Ljava/lang/String;
    //   159: ldc 16
    //   161: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   164: invokeinterface 85 2 0
    //   169: pop
    //   170: aload_3
    //   171: aconst_null
    //   172: ldc 222
    //   174: invokeinterface 88 3 0
    //   179: pop
    //   180: aload_3
    //   181: aconst_null
    //   182: ldc 206
    //   184: invokeinterface 88 3 0
    //   189: pop
    //   190: goto -146 -> 44
    //   193: astore_0
    //   194: ldc 110
    //   196: aload_0
    //   197: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokestatic 120	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: ldc 16
    //   205: areturn
    //   206: astore 5
    //   208: aload_3
    //   209: ldc 16
    //   211: invokeinterface 85 2 0
    //   216: pop
    //   217: goto -84 -> 133
    //   220: astore 4
    //   222: aload_3
    //   223: ldc 16
    //   225: invokeinterface 85 2 0
    //   230: pop
    //   231: goto -61 -> 170
    //   234: aload_3
    //   235: invokeinterface 123 1 0
    //   240: aload_2
    //   241: invokevirtual 126	java/io/StringWriter:flush	()V
    //   244: aload_2
    //   245: invokevirtual 129	java/io/StringWriter:close	()V
    //   248: aload_2
    //   249: invokevirtual 133	java/io/StringWriter:getBuffer	()Ljava/lang/StringBuffer;
    //   252: invokevirtual 138	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   255: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramLinkedList	LinkedList<o.h>
    //   0	256	1	paramHashMap	HashMap<String, o.d>
    //   24	225	2	localStringWriter	java.io.StringWriter
    //   31	204	3	localXmlSerializer	org.xmlpull.v1.XmlSerializer
    //   76	79	4	locald	o.d
    //   220	1	4	localException1	Exception
    //   62	36	5	localh	o.h
    //   206	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   25	44	193	java/lang/Exception
    //   44	78	193	java/lang/Exception
    //   83	118	193	java/lang/Exception
    //   133	153	193	java/lang/Exception
    //   170	190	193	java/lang/Exception
    //   208	217	193	java/lang/Exception
    //   222	231	193	java/lang/Exception
    //   234	248	193	java/lang/Exception
    //   118	133	206	java/lang/Exception
    //   153	170	220	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ai
 * JD-Core Version:    0.7.0.1
 */