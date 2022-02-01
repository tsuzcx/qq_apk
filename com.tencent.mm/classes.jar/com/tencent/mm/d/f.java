package com.tencent.mm.d;

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
  private static boolean cKf = false;
  
  /* Error */
  public static Map<String, String> K(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 967
    //   3: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: ifnonnull +25 -> 32
    //   10: iconst_m1
    //   11: istore_2
    //   12: iload_2
    //   13: ifge +29 -> 42
    //   16: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   19: ldc 37
    //   21: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   24: sipush 967
    //   27: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: aconst_null
    //   31: areturn
    //   32: aload_0
    //   33: bipush 60
    //   35: invokevirtual 52	java/lang/String:indexOf	(I)I
    //   38: istore_2
    //   39: goto -27 -> 12
    //   42: aload_0
    //   43: astore_3
    //   44: iload_2
    //   45: ifle +24 -> 69
    //   48: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   51: ldc 54
    //   53: iload_2
    //   54: invokestatic 58	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   57: invokevirtual 62	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   63: aload_0
    //   64: iload_2
    //   65: invokevirtual 65	java/lang/String:substring	(I)Ljava/lang/String;
    //   68: astore_3
    //   69: aload_3
    //   70: ifnull +10 -> 80
    //   73: aload_3
    //   74: invokevirtual 69	java/lang/String:length	()I
    //   77: ifgt +11 -> 88
    //   80: sipush 967
    //   83: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: aconst_null
    //   87: areturn
    //   88: new 71	java/util/HashMap
    //   91: dup
    //   92: invokespecial 74	java/util/HashMap:<init>	()V
    //   95: astore 4
    //   97: invokestatic 80	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 84	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   105: astore_0
    //   106: aload_0
    //   107: ifnonnull +28 -> 135
    //   110: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   113: ldc 86
    //   115: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   118: sipush 967
    //   121: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_0
    //   127: sipush 967
    //   130: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aconst_null
    //   134: areturn
    //   135: aload_0
    //   136: new 88	org/xml/sax/InputSource
    //   139: dup
    //   140: new 90	java/io/ByteArrayInputStream
    //   143: dup
    //   144: aload_3
    //   145: invokevirtual 94	java/lang/String:getBytes	()[B
    //   148: invokespecial 97	java/io/ByteArrayInputStream:<init>	([B)V
    //   151: invokespecial 100	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   154: invokevirtual 106	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   157: astore_0
    //   158: aload_0
    //   159: invokeinterface 111 1 0
    //   164: aload_0
    //   165: ifnonnull +46 -> 211
    //   168: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   171: ldc 113
    //   173: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   176: sipush 967
    //   179: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: sipush 967
    //   188: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: sipush 967
    //   197: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aconst_null
    //   201: areturn
    //   202: astore_0
    //   203: sipush 967
    //   206: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   209: aconst_null
    //   210: areturn
    //   211: aload_0
    //   212: invokeinterface 117 1 0
    //   217: astore_0
    //   218: aload_0
    //   219: ifnonnull +19 -> 238
    //   222: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   225: ldc 119
    //   227: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   230: sipush 967
    //   233: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: aconst_null
    //   237: areturn
    //   238: aload_1
    //   239: aload_0
    //   240: invokeinterface 125 1 0
    //   245: invokevirtual 129	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   248: ifeq +34 -> 282
    //   251: aload 4
    //   253: ldc 131
    //   255: ldc 131
    //   257: aload_0
    //   258: iconst_0
    //   259: invokestatic 135	com/tencent/mm/d/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   262: getstatic 10	com/tencent/mm/d/f:cKf	Z
    //   265: ifeq +8 -> 273
    //   268: aload 4
    //   270: invokestatic 138	com/tencent/mm/d/f:i	(Ljava/util/Map;)V
    //   273: sipush 967
    //   276: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aload 4
    //   281: areturn
    //   282: aload_0
    //   283: aload_1
    //   284: invokeinterface 142 2 0
    //   289: astore_0
    //   290: aload_0
    //   291: invokeinterface 147 1 0
    //   296: ifgt +19 -> 315
    //   299: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   302: ldc 149
    //   304: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   307: sipush 967
    //   310: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aconst_null
    //   314: areturn
    //   315: aload_0
    //   316: invokeinterface 147 1 0
    //   321: iconst_1
    //   322: if_icmple +11 -> 333
    //   325: getstatic 35	java/lang/System:err	Ljava/io/PrintStream;
    //   328: ldc 151
    //   330: invokevirtual 43	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   333: aload 4
    //   335: ldc 131
    //   337: ldc 131
    //   339: aload_0
    //   340: iconst_0
    //   341: invokeinterface 155 2 0
    //   346: iconst_0
    //   347: invokestatic 135	com/tencent/mm/d/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   350: goto -88 -> 262
    //   353: astore_0
    //   354: aconst_null
    //   355: astore_0
    //   356: goto -192 -> 164
    //   359: astore_3
    //   360: goto -196 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramString1	String
    //   0	363	1	paramString2	String
    //   11	54	2	i	int
    //   43	102	3	str	String
    //   359	1	3	localDOMException	org.w3c.dom.DOMException
    //   95	239	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   101	106	126	javax/xml/parsers/ParserConfigurationException
    //   135	158	184	org/xml/sax/SAXException
    //   158	164	184	org/xml/sax/SAXException
    //   135	158	193	java/io/IOException
    //   158	164	193	java/io/IOException
    //   135	158	202	java/lang/Exception
    //   158	164	202	java/lang/Exception
    //   135	158	353	org/w3c/dom/DOMException
    //   158	164	359	org/w3c/dom/DOMException
  }
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2, Node paramNode, int paramInt)
  {
    AppMethodBeat.i(968);
    if (paramNode.getNodeName().equals("#text"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      AppMethodBeat.o(968);
      return;
    }
    if (paramNode.getNodeName().equals("#cdata-section"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      AppMethodBeat.o(968);
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
          break label448;
        }
        AppMethodBeat.o(968);
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
    label448:
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
  
  private static void i(Map<String, String> paramMap)
  {
    AppMethodBeat.i(969);
    if (paramMap.size() <= 0)
    {
      System.err.println("empty values");
      AppMethodBeat.o(969);
      return;
    }
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (!paramMap.hasNext())
      {
        AppMethodBeat.o(969);
        return;
      }
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      System.err.println("key=" + (String)localEntry.getKey() + " value=" + (String)localEntry.getValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.d.f
 * JD-Core Version:    0.7.0.1
 */