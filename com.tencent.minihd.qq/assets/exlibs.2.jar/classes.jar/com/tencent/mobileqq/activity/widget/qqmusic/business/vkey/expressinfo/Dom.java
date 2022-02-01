package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.expressinfo;

import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Dom
  implements ParseService
{
  private static final String jdField_a_of_type_JavaLangString = "DOM";
  private ExpressInfo jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyExpressinfoExpressInfo;
  private DocumentBuilder jdField_a_of_type_JavaxXmlParsersDocumentBuilder;
  private String b = "";
  
  public Dom(String paramString)
  {
    this.b = paramString;
    paramString = DocumentBuilderFactory.newInstance();
    try
    {
      this.jdField_a_of_type_JavaxXmlParsersDocumentBuilder = paramString.newDocumentBuilder();
      return;
    }
    catch (ParserConfigurationException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null)
    {
      i = paramInt;
      if (paramString.length() <= 0) {}
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
  
  private String a(Element paramElement, String paramString)
  {
    return ((Element)paramElement.getElementsByTagName(paramString).item(0)).getTextContent();
  }
  
  private void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("updataUserInfo:").append(paramInt1).append("||");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      MLog.b("DOM", paramInt1 + "||" + paramInt2);
      return;
    }
  }
  
  /* Error */
  public ExpressInfo a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:jdField_a_of_type_JavaxXmlParsersDocumentBuilder	Ljavax/xml/parsers/DocumentBuilder;
    //   4: aload_1
    //   5: invokevirtual 106	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   8: invokeinterface 112 1 0
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 114
    //   17: invokeinterface 62 2 0
    //   22: iconst_0
    //   23: invokeinterface 68 2 0
    //   28: checkcast 58	org/w3c/dom/Element
    //   31: ldc 116
    //   33: invokeinterface 62 2 0
    //   38: astore 4
    //   40: new 118	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 119	java/util/ArrayList:<init>	()V
    //   47: astore 5
    //   49: iconst_0
    //   50: istore_2
    //   51: iload_2
    //   52: aload 4
    //   54: invokeinterface 122 1 0
    //   59: if_icmpge +37 -> 96
    //   62: aload 5
    //   64: aload 4
    //   66: iload_2
    //   67: invokeinterface 68 2 0
    //   72: checkcast 58	org/w3c/dom/Element
    //   75: invokeinterface 126 1 0
    //   80: invokeinterface 131 1 0
    //   85: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   88: pop
    //   89: iload_2
    //   90: iconst_1
    //   91: iadd
    //   92: istore_2
    //   93: goto -42 -> 51
    //   96: aload_0
    //   97: getfield 24	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:b	Ljava/lang/String;
    //   100: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   103: ifne +49 -> 152
    //   106: aload_0
    //   107: aload_1
    //   108: ldc 143
    //   110: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   113: iconst_0
    //   114: invokestatic 147	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Ljava/lang/String;I)I
    //   117: istore_2
    //   118: aload_0
    //   119: aload_1
    //   120: ldc 149
    //   122: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   125: iconst_0
    //   126: invokestatic 147	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Ljava/lang/String;I)I
    //   129: iconst_1
    //   130: if_icmpne +70 -> 200
    //   133: iconst_1
    //   134: istore_3
    //   135: aload_0
    //   136: iload_2
    //   137: iload_3
    //   138: aload_0
    //   139: aload_1
    //   140: ldc 151
    //   142: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   145: iconst_0
    //   146: invokestatic 147	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Ljava/lang/String;I)I
    //   149: invokespecial 153	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(IZI)V
    //   152: aload_0
    //   153: new 155	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo
    //   156: dup
    //   157: aload_0
    //   158: aload_1
    //   159: ldc 157
    //   161: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   164: aload_0
    //   165: aload_1
    //   166: ldc 159
    //   168: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   171: aload_0
    //   172: aload_1
    //   173: ldc 161
    //   175: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   178: aload_0
    //   179: aload_1
    //   180: ldc 162
    //   182: invokespecial 145	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:a	(Lorg/w3c/dom/Element;Ljava/lang/String;)Ljava/lang/String;
    //   185: aload 5
    //   187: invokespecial 165	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   190: putfield 167	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyExpressinfoExpressInfo	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   193: aload_0
    //   194: getfield 167	com/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/Dom:jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyExpressinfoExpressInfo	Lcom/tencent/mobileqq/activity/widget/qqmusic/business/vkey/expressinfo/ExpressInfo;
    //   197: astore_1
    //   198: aload_1
    //   199: areturn
    //   200: iconst_0
    //   201: istore_3
    //   202: goto -67 -> 135
    //   205: astore_1
    //   206: ldc 10
    //   208: aload_1
    //   209: invokevirtual 168	org/xml/sax/SAXException:toString	()Ljava/lang/String;
    //   212: invokestatic 171	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aconst_null
    //   216: areturn
    //   217: astore_1
    //   218: ldc 10
    //   220: aload_1
    //   221: invokevirtual 172	java/io/IOException:toString	()Ljava/lang/String;
    //   224: invokestatic 171	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: goto -12 -> 215
    //   230: astore_1
    //   231: ldc 10
    //   233: aload_1
    //   234: invokevirtual 173	java/lang/Exception:toString	()Ljava/lang/String;
    //   237: invokestatic 171	com/tencent/mobileqq/activity/widget/qqmusic/utils/MLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -25 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	Dom
    //   0	243	1	paramInputStream	java.io.InputStream
    //   50	87	2	i	int
    //   134	68	3	bool	boolean
    //   38	27	4	localNodeList	NodeList
    //   47	139	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   0	49	205	org/xml/sax/SAXException
    //   51	89	205	org/xml/sax/SAXException
    //   96	133	205	org/xml/sax/SAXException
    //   135	152	205	org/xml/sax/SAXException
    //   152	198	205	org/xml/sax/SAXException
    //   0	49	217	java/io/IOException
    //   51	89	217	java/io/IOException
    //   96	133	217	java/io/IOException
    //   135	152	217	java/io/IOException
    //   152	198	217	java/io/IOException
    //   0	49	230	java/lang/Exception
    //   51	89	230	java/lang/Exception
    //   96	133	230	java/lang/Exception
    //   135	152	230	java/lang/Exception
    //   152	198	230	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.expressinfo.Dom
 * JD-Core Version:    0.7.0.1
 */