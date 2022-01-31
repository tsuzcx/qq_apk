package com.tencent.mm.c;

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
  private static boolean bvx = false;
  
  private static void a(Map<String, String> paramMap, String paramString1, String paramString2, Node paramNode, int paramInt)
  {
    if (paramNode.getNodeName().equals("#text"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      return;
    }
    if (paramNode.getNodeName().equals("#cdata-section"))
    {
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramMap.put(paramString2, paramNode.getNodeValue());
      return;
    }
    Object localObject = paramString1 + "." + paramNode.getNodeName();
    paramString1 = paramString2 + "." + paramNode.getNodeName();
    label224:
    label240:
    Node localNode;
    label271:
    Integer localInteger;
    if (paramInt > 0)
    {
      paramString2 = localObject + paramInt;
      paramMap.put(paramString2, paramNode.getNodeValue());
      paramString1 = paramString1 + "#" + paramInt;
      paramMap.put(paramString1, paramNode.getNodeValue());
      localObject = paramNode.getAttributes();
      if (localObject != null)
      {
        paramInt = 0;
        if (paramInt < ((NamedNodeMap)localObject).getLength()) {
          break label391;
        }
      }
      localObject = new HashMap();
      paramNode = paramNode.getChildNodes();
      paramInt = 0;
      if (paramInt < paramNode.getLength())
      {
        localNode = paramNode.item(paramInt);
        localInteger = (Integer)((HashMap)localObject).get(localNode.getNodeName());
        if (localInteger != null) {
          break label497;
        }
      }
    }
    label391:
    label497:
    for (int i = 0;; i = localInteger.intValue())
    {
      a(paramMap, paramString2, paramString1, localNode, i);
      ((HashMap)localObject).put(localNode.getNodeName(), Integer.valueOf(i + 1));
      paramInt += 1;
      break label271;
      break;
      paramMap.put(localObject, paramNode.getNodeValue());
      paramMap.put(paramString1, paramNode.getNodeValue());
      paramString2 = (String)localObject;
      break label224;
      localNode = ((NamedNodeMap)localObject).item(paramInt);
      paramMap.put(paramString2 + ".$" + localNode.getNodeName(), localNode.getNodeValue());
      paramMap.put(paramString1 + ".$" + localNode.getNodeName(), localNode.getNodeValue());
      paramInt += 1;
      break label240;
    }
  }
  
  private static void d(Map<String, String> paramMap)
  {
    if (paramMap.size() <= 0) {
      System.err.println("empty values");
    }
    for (;;)
    {
      return;
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        System.err.println("key=" + (String)localEntry.getKey() + " value=" + (String)localEntry.getValue());
      }
    }
  }
  
  /* Error */
  public static Map<String, String> s(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +19 -> 20
    //   4: iconst_m1
    //   5: istore_2
    //   6: iload_2
    //   7: ifge +23 -> 30
    //   10: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   13: ldc 172
    //   15: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   18: aconst_null
    //   19: areturn
    //   20: aload_0
    //   21: bipush 60
    //   23: invokevirtual 176	java/lang/String:indexOf	(I)I
    //   26: istore_2
    //   27: goto -21 -> 6
    //   30: aload_0
    //   31: astore_3
    //   32: iload_2
    //   33: ifle +31 -> 64
    //   36: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   39: new 40	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 178
    //   45: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: iload_2
    //   49: invokevirtual 60	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   58: aload_0
    //   59: iload_2
    //   60: invokevirtual 182	java/lang/String:substring	(I)Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull -47 -> 18
    //   68: aload_3
    //   69: invokevirtual 185	java/lang/String:length	()I
    //   72: ifle -54 -> 18
    //   75: new 74	java/util/HashMap
    //   78: dup
    //   79: invokespecial 76	java/util/HashMap:<init>	()V
    //   82: astore 4
    //   84: invokestatic 191	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   87: astore_0
    //   88: aload_0
    //   89: invokevirtual 195	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   92: astore_0
    //   93: aload_0
    //   94: ifnonnull +13 -> 107
    //   97: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   100: ldc 197
    //   102: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   105: aconst_null
    //   106: areturn
    //   107: aload_0
    //   108: new 199	org/xml/sax/InputSource
    //   111: dup
    //   112: new 201	java/io/ByteArrayInputStream
    //   115: dup
    //   116: aload_3
    //   117: invokevirtual 205	java/lang/String:getBytes	()[B
    //   120: invokespecial 208	java/io/ByteArrayInputStream:<init>	([B)V
    //   123: invokespecial 211	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   126: invokevirtual 217	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   129: astore_0
    //   130: aload_0
    //   131: invokeinterface 222 1 0
    //   136: aload_0
    //   137: ifnonnull +13 -> 150
    //   140: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   143: ldc 224
    //   145: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   148: aconst_null
    //   149: areturn
    //   150: aload_0
    //   151: invokeinterface 228 1 0
    //   156: astore_0
    //   157: aload_0
    //   158: ifnonnull +13 -> 171
    //   161: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   164: ldc 230
    //   166: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   169: aconst_null
    //   170: areturn
    //   171: aload_1
    //   172: aload_0
    //   173: invokeinterface 233 1 0
    //   178: invokevirtual 27	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   181: ifeq +28 -> 209
    //   184: aload 4
    //   186: ldc 235
    //   188: ldc 235
    //   190: aload_0
    //   191: iconst_0
    //   192: invokestatic 95	com/tencent/mm/c/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   195: getstatic 10	com/tencent/mm/c/f:bvx	Z
    //   198: ifeq +8 -> 206
    //   201: aload 4
    //   203: invokestatic 237	com/tencent/mm/c/f:d	(Ljava/util/Map;)V
    //   206: aload 4
    //   208: areturn
    //   209: aload_0
    //   210: aload_1
    //   211: invokeinterface 241 2 0
    //   216: astore_0
    //   217: aload_0
    //   218: invokeinterface 83 1 0
    //   223: ifgt +13 -> 236
    //   226: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   229: ldc 243
    //   231: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   234: aconst_null
    //   235: areturn
    //   236: aload_0
    //   237: invokeinterface 83 1 0
    //   242: iconst_1
    //   243: if_icmple +11 -> 254
    //   246: getstatic 118	java/lang/System:err	Ljava/io/PrintStream;
    //   249: ldc 245
    //   251: invokevirtual 125	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   254: aload 4
    //   256: ldc 235
    //   258: ldc 235
    //   260: aload_0
    //   261: iconst_0
    //   262: invokeinterface 87 2 0
    //   267: iconst_0
    //   268: invokestatic 95	com/tencent/mm/c/f:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   271: goto -76 -> 195
    //   274: astore_0
    //   275: aconst_null
    //   276: areturn
    //   277: astore_0
    //   278: aconst_null
    //   279: areturn
    //   280: astore_0
    //   281: aconst_null
    //   282: areturn
    //   283: astore_0
    //   284: aconst_null
    //   285: areturn
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_0
    //   289: goto -153 -> 136
    //   292: astore_3
    //   293: goto -157 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString1	String
    //   0	296	1	paramString2	String
    //   5	55	2	i	int
    //   31	86	3	str	String
    //   292	1	3	localDOMException	org.w3c.dom.DOMException
    //   82	173	4	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   88	93	274	javax/xml/parsers/ParserConfigurationException
    //   107	130	277	java/lang/Exception
    //   130	136	277	java/lang/Exception
    //   107	130	280	java/io/IOException
    //   130	136	280	java/io/IOException
    //   107	130	283	org/xml/sax/SAXException
    //   130	136	283	org/xml/sax/SAXException
    //   107	130	286	org/w3c/dom/DOMException
    //   130	136	292	org/w3c/dom/DOMException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.c.f
 * JD-Core Version:    0.7.0.1
 */