package com.tencent.mm.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class f
{
  private static boolean bWI = false;
  
  /* Error */
  public static Map<String, String> F(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +24 -> 30
    //   9: iconst_m1
    //   10: istore_2
    //   11: iload_2
    //   12: ifge +28 -> 40
    //   15: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   18: ldc 38
    //   20: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   23: ldc 24
    //   25: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: aload_0
    //   31: bipush 60
    //   33: invokevirtual 53	java/lang/String:indexOf	(I)I
    //   36: istore_2
    //   37: goto -26 -> 11
    //   40: aload_0
    //   41: astore_3
    //   42: iload_2
    //   43: ifle +24 -> 67
    //   46: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   49: ldc 55
    //   51: iload_2
    //   52: invokestatic 59	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   55: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   61: aload_0
    //   62: iload_2
    //   63: invokevirtual 66	java/lang/String:substring	(I)Ljava/lang/String;
    //   66: astore_3
    //   67: aload_3
    //   68: ifnull +10 -> 78
    //   71: aload_3
    //   72: invokevirtual 70	java/lang/String:length	()I
    //   75: ifgt +10 -> 85
    //   78: ldc 24
    //   80: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aconst_null
    //   84: areturn
    //   85: new 72	java/util/HashMap
    //   88: dup
    //   89: invokespecial 75	java/util/HashMap:<init>	()V
    //   92: astore 4
    //   94: invokestatic 81	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   97: astore_0
    //   98: aload_0
    //   99: invokevirtual 85	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   102: astore_0
    //   103: aload_0
    //   104: ifnonnull +26 -> 130
    //   107: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   110: ldc 87
    //   112: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   115: ldc 24
    //   117: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: aconst_null
    //   121: areturn
    //   122: astore_0
    //   123: ldc 24
    //   125: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aconst_null
    //   129: areturn
    //   130: aload_0
    //   131: new 89	org/xml/sax/InputSource
    //   134: dup
    //   135: new 91	java/io/ByteArrayInputStream
    //   138: dup
    //   139: aload_3
    //   140: invokevirtual 95	java/lang/String:getBytes	()[B
    //   143: invokespecial 98	java/io/ByteArrayInputStream:<init>	([B)V
    //   146: invokespecial 101	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   149: invokevirtual 107	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   152: astore_0
    //   153: aload_0
    //   154: invokeinterface 112 1 0
    //   159: aload_0
    //   160: ifnonnull +42 -> 202
    //   163: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   166: ldc 114
    //   168: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   171: ldc 24
    //   173: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aconst_null
    //   177: areturn
    //   178: astore_0
    //   179: ldc 24
    //   181: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aconst_null
    //   185: areturn
    //   186: astore_0
    //   187: ldc 24
    //   189: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_0
    //   195: ldc 24
    //   197: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aconst_null
    //   201: areturn
    //   202: aload_0
    //   203: invokeinterface 118 1 0
    //   208: astore_0
    //   209: aload_0
    //   210: ifnonnull +18 -> 228
    //   213: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   216: ldc 120
    //   218: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   221: ldc 24
    //   223: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aconst_null
    //   227: areturn
    //   228: aload_1
    //   229: aload_0
    //   230: invokeinterface 126 1 0
    //   235: invokevirtual 130	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   238: ifeq +33 -> 271
    //   241: aload 4
    //   243: ldc 132
    //   245: ldc 132
    //   247: aload_0
    //   248: iconst_0
    //   249: invokestatic 136	com/tencent/mm/c/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   252: getstatic 10	com/tencent/mm/c/f:bWI	Z
    //   255: ifeq +8 -> 263
    //   258: aload 4
    //   260: invokestatic 140	com/tencent/mm/c/f:e	(Ljava/util/Map;)V
    //   263: ldc 24
    //   265: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aload 4
    //   270: areturn
    //   271: aload_0
    //   272: aload_1
    //   273: invokeinterface 144 2 0
    //   278: astore_0
    //   279: aload_0
    //   280: invokeinterface 149 1 0
    //   285: ifgt +18 -> 303
    //   288: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   291: ldc 151
    //   293: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   296: ldc 24
    //   298: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aconst_null
    //   302: areturn
    //   303: aload_0
    //   304: invokeinterface 149 1 0
    //   309: iconst_1
    //   310: if_icmple +11 -> 321
    //   313: getstatic 36	java/lang/System:err	Ljava/io/PrintStream;
    //   316: ldc 153
    //   318: invokevirtual 44	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   321: aload 4
    //   323: ldc 132
    //   325: ldc 132
    //   327: aload_0
    //   328: iconst_0
    //   329: invokeinterface 157 2 0
    //   334: iconst_0
    //   335: invokestatic 136	com/tencent/mm/c/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   338: goto -86 -> 252
    //   341: astore_0
    //   342: aconst_null
    //   343: astore_0
    //   344: goto -185 -> 159
    //   347: astore_3
    //   348: goto -189 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramString1	String
    //   0	351	1	paramString2	String
    //   10	53	2	i	int
    //   41	99	3	str	String
    //   347	1	3	localDOMException	org.w3c.dom.DOMException
    //   92	230	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   98	103	122	javax/xml/parsers/ParserConfigurationException
    //   130	153	178	org/xml/sax/SAXException
    //   153	159	178	org/xml/sax/SAXException
    //   130	153	186	java/io/IOException
    //   153	159	186	java/io/IOException
    //   130	153	194	java/lang/Exception
    //   153	159	194	java/lang/Exception
    //   130	153	341	org/w3c/dom/DOMException
    //   153	159	347	org/w3c/dom/DOMException
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2, Node paramNode, int paramInt)
  {
    AppMethodBeat.i(125708);
    if (paramNode.getNodeName().equals("#text"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      AppMethodBeat.o(125708);
      return;
    }
    if (paramNode.getNodeName().equals("#cdata-section"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      AppMethodBeat.o(125708);
      return;
    }
    Object localObject = paramString1 + "." + paramNode.getNodeName();
    paramString1 = paramString2 + "." + paramNode.getNodeName();
    if (paramInt > 0)
    {
      paramString2 = localObject + paramInt;
      paramMap.put(paramString2, paramNode.getNodeValue());
      paramString1 = paramString1 + "#" + paramInt;
      paramMap.put(paramString1, paramNode.getNodeValue());
      localObject = paramNode.getAttributes();
      if (localObject != null) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (paramInt >= ((NamedNodeMap)localObject).getLength())
      {
        localObject = new HashMap();
        paramNode = paramNode.getChildNodes();
        paramInt = 0;
        if (paramInt < paramNode.getLength()) {
          break label444;
        }
        AppMethodBeat.o(125708);
        return;
        paramMap.put(localObject, paramNode.getNodeValue());
        paramMap.put(paramString1, paramNode.getNodeValue());
        paramString2 = (String)localObject;
        break;
      }
      localNode = ((NamedNodeMap)localObject).item(paramInt);
      paramMap.put(paramString2 + ".$" + localNode.getNodeName(), localNode.getNodeValue());
      paramMap.put(paramString1 + ".$" + localNode.getNodeName(), localNode.getNodeValue());
      paramInt += 1;
    }
    label444:
    Node localNode = paramNode.item(paramInt);
    Integer localInteger = (Integer)((HashMap)localObject).get(localNode.getNodeName());
    if (localInteger == null) {}
    for (int i = 0;; i = localInteger.intValue())
    {
      a(paramMap, paramString2, paramString1, localNode, i);
      ((HashMap)localObject).put(localNode.getNodeName(), Integer.valueOf(i + 1));
      paramInt += 1;
      break;
    }
  }
  
  private static void e(Map<String, String> paramMap)
  {
    AppMethodBeat.i(125709);
    if (paramMap.size() <= 0)
    {
      System.err.println("empty values");
      AppMethodBeat.o(125709);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        AppMethodBeat.o(125709);
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      System.err.println("key=" + (String)localEntry.getKey() + " value=" + (String)localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.c.f
 * JD-Core Version:    0.7.0.1
 */