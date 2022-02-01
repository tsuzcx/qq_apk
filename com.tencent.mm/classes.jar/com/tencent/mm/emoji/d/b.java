package com.tencent.mm.emoji.d;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.tmassistantsdk.util.Base64;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class b
{
  public static int ch(Context paramContext)
  {
    AppMethodBeat.i(177030);
    if (paramContext == null)
    {
      AppMethodBeat.o(177030);
      return 0;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(2130969066, localTypedValue, true);
    int i = localTypedValue.resourceId;
    AppMethodBeat.o(177030);
    return i;
  }
  
  /* Error */
  public static ArrayList<com.tencent.mm.storage.emotion.SmileyInfo> e(e parame)
  {
    // Byte code:
    //   0: ldc 47
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 49	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 50	java/util/ArrayList:<init>	()V
    //   12: astore 7
    //   14: invokestatic 56	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   17: astore 9
    //   19: aload_0
    //   20: invokestatic 62	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   23: astore 8
    //   25: aconst_null
    //   26: astore 6
    //   28: aload 9
    //   30: invokevirtual 66	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   33: aload 8
    //   35: invokevirtual 72	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   38: astore_0
    //   39: aload_0
    //   40: invokeinterface 77 1 0
    //   45: aload_0
    //   46: invokeinterface 81 1 0
    //   51: ldc 83
    //   53: invokeinterface 89 2 0
    //   58: astore_0
    //   59: aload_0
    //   60: ifnull +655 -> 715
    //   63: aload_0
    //   64: invokeinterface 95 1 0
    //   69: ifle +646 -> 715
    //   72: aload_0
    //   73: invokeinterface 95 1 0
    //   78: istore 4
    //   80: iconst_0
    //   81: istore_1
    //   82: iload_1
    //   83: iload 4
    //   85: if_icmpge +630 -> 715
    //   88: aload_0
    //   89: iload_1
    //   90: invokeinterface 99 2 0
    //   95: invokeinterface 105 1 0
    //   100: astore 9
    //   102: aload 9
    //   104: ifnull +655 -> 759
    //   107: aload 9
    //   109: invokeinterface 95 1 0
    //   114: ifle +645 -> 759
    //   117: new 107	com/tencent/mm/storage/emotion/SmileyInfo
    //   120: dup
    //   121: invokespecial 108	com/tencent/mm/storage/emotion/SmileyInfo:<init>	()V
    //   124: astore 10
    //   126: iconst_0
    //   127: istore_2
    //   128: iload_2
    //   129: aload 9
    //   131: invokeinterface 95 1 0
    //   136: if_icmpge +531 -> 667
    //   139: aload 9
    //   141: iload_2
    //   142: invokeinterface 99 2 0
    //   147: astore 11
    //   149: aload 11
    //   151: invokeinterface 112 1 0
    //   156: astore 12
    //   158: aload 12
    //   160: ldc 114
    //   162: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   165: ifeq +18 -> 183
    //   168: aload 10
    //   170: aload 11
    //   172: invokeinterface 123 1 0
    //   177: putfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   180: goto +568 -> 748
    //   183: aload 12
    //   185: ldc 129
    //   187: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   190: ifeq +134 -> 324
    //   193: aload 11
    //   195: invokeinterface 123 1 0
    //   200: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   203: ifne +18 -> 221
    //   206: ldc 136
    //   208: aload 11
    //   210: invokeinterface 123 1 0
    //   215: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   218: ifeq +91 -> 309
    //   221: aload 10
    //   223: aload 10
    //   225: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   228: putfield 139	com/tencent/mm/storage/emotion/SmileyInfo:field_cnValue	Ljava/lang/String;
    //   231: goto +517 -> 748
    //   234: astore 6
    //   236: ldc 47
    //   238: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   241: aload 6
    //   243: athrow
    //   244: astore_0
    //   245: aload 8
    //   247: ifnull +13 -> 260
    //   250: aload 6
    //   252: ifnull +488 -> 740
    //   255: aload 8
    //   257: invokevirtual 144	java/io/InputStream:close	()V
    //   260: ldc 47
    //   262: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   265: aload_0
    //   266: athrow
    //   267: astore_0
    //   268: ldc 146
    //   270: ldc 148
    //   272: iconst_1
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: aload_0
    //   279: invokevirtual 151	java/lang/Exception:toString	()Ljava/lang/String;
    //   282: aastore
    //   283: invokestatic 156	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload 7
    //   288: invokevirtual 159	java/util/ArrayList:size	()I
    //   291: ifne +10 -> 301
    //   294: ldc 146
    //   296: ldc 161
    //   298: invokestatic 165	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: ldc 47
    //   303: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: aload 7
    //   308: areturn
    //   309: aload 10
    //   311: aload 11
    //   313: invokeinterface 123 1 0
    //   318: putfield 139	com/tencent/mm/storage/emotion/SmileyInfo:field_cnValue	Ljava/lang/String;
    //   321: goto +427 -> 748
    //   324: aload 12
    //   326: ldc 167
    //   328: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   331: ifeq +59 -> 390
    //   334: aload 11
    //   336: invokeinterface 123 1 0
    //   341: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   344: ifne +18 -> 362
    //   347: ldc 136
    //   349: aload 11
    //   351: invokeinterface 123 1 0
    //   356: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   359: ifeq +16 -> 375
    //   362: aload 10
    //   364: aload 10
    //   366: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   369: putfield 170	com/tencent/mm/storage/emotion/SmileyInfo:field_qqValue	Ljava/lang/String;
    //   372: goto +376 -> 748
    //   375: aload 10
    //   377: aload 11
    //   379: invokeinterface 123 1 0
    //   384: putfield 170	com/tencent/mm/storage/emotion/SmileyInfo:field_qqValue	Ljava/lang/String;
    //   387: goto +361 -> 748
    //   390: aload 12
    //   392: ldc 172
    //   394: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   397: ifeq +59 -> 456
    //   400: aload 11
    //   402: invokeinterface 123 1 0
    //   407: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   410: ifne +18 -> 428
    //   413: ldc 136
    //   415: aload 11
    //   417: invokeinterface 123 1 0
    //   422: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   425: ifeq +16 -> 441
    //   428: aload 10
    //   430: aload 10
    //   432: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   435: putfield 175	com/tencent/mm/storage/emotion/SmileyInfo:field_enValue	Ljava/lang/String;
    //   438: goto +310 -> 748
    //   441: aload 10
    //   443: aload 11
    //   445: invokeinterface 123 1 0
    //   450: putfield 175	com/tencent/mm/storage/emotion/SmileyInfo:field_enValue	Ljava/lang/String;
    //   453: goto +295 -> 748
    //   456: aload 12
    //   458: ldc 177
    //   460: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   463: ifeq +59 -> 522
    //   466: aload 11
    //   468: invokeinterface 123 1 0
    //   473: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   476: ifne +18 -> 494
    //   479: ldc 136
    //   481: aload 11
    //   483: invokeinterface 123 1 0
    //   488: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   491: ifeq +16 -> 507
    //   494: aload 10
    //   496: aload 10
    //   498: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   501: putfield 180	com/tencent/mm/storage/emotion/SmileyInfo:field_twValue	Ljava/lang/String;
    //   504: goto +244 -> 748
    //   507: aload 10
    //   509: aload 11
    //   511: invokeinterface 123 1 0
    //   516: putfield 180	com/tencent/mm/storage/emotion/SmileyInfo:field_twValue	Ljava/lang/String;
    //   519: goto +229 -> 748
    //   522: aload 12
    //   524: ldc 182
    //   526: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   529: ifeq +59 -> 588
    //   532: aload 11
    //   534: invokeinterface 123 1 0
    //   539: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   542: ifne +18 -> 560
    //   545: ldc 136
    //   547: aload 11
    //   549: invokeinterface 123 1 0
    //   554: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   557: ifeq +16 -> 573
    //   560: aload 10
    //   562: aload 10
    //   564: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   567: putfield 185	com/tencent/mm/storage/emotion/SmileyInfo:field_thValue	Ljava/lang/String;
    //   570: goto +178 -> 748
    //   573: aload 10
    //   575: aload 11
    //   577: invokeinterface 123 1 0
    //   582: putfield 185	com/tencent/mm/storage/emotion/SmileyInfo:field_thValue	Ljava/lang/String;
    //   585: goto +163 -> 748
    //   588: aload 12
    //   590: ldc 187
    //   592: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   595: ifeq +18 -> 613
    //   598: aload 10
    //   600: aload 11
    //   602: invokeinterface 123 1 0
    //   607: putfield 190	com/tencent/mm/storage/emotion/SmileyInfo:field_fileName	Ljava/lang/String;
    //   610: goto +138 -> 748
    //   613: aload 12
    //   615: ldc 192
    //   617: invokevirtual 120	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   620: istore 5
    //   622: iload 5
    //   624: ifeq +124 -> 748
    //   627: aload 11
    //   629: invokeinterface 123 1 0
    //   634: invokestatic 198	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   637: invokevirtual 201	java/lang/Integer:intValue	()I
    //   640: istore_3
    //   641: aload 10
    //   643: iload_3
    //   644: putfield 204	com/tencent/mm/storage/emotion/SmileyInfo:field_eggIndex	I
    //   647: goto +101 -> 748
    //   650: astore 11
    //   652: ldc 146
    //   654: aload 11
    //   656: invokestatic 208	com/tencent/mm/sdk/platformtools/bt:m	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   659: invokestatic 210	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   662: iconst_m1
    //   663: istore_3
    //   664: goto -23 -> 641
    //   667: aload 10
    //   669: iconst_m1
    //   670: putfield 213	com/tencent/mm/storage/emotion/SmileyInfo:field_position	I
    //   673: ldc 146
    //   675: aload 10
    //   677: invokevirtual 214	com/tencent/mm/storage/emotion/SmileyInfo:toString	()Ljava/lang/String;
    //   680: invokestatic 217	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   683: aload 10
    //   685: getfield 127	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   688: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   691: ifeq +13 -> 704
    //   694: ldc 146
    //   696: ldc 219
    //   698: invokestatic 221	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   701: goto +58 -> 759
    //   704: aload 7
    //   706: aload 10
    //   708: invokevirtual 225	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   711: pop
    //   712: goto +47 -> 759
    //   715: aload 8
    //   717: ifnull -431 -> 286
    //   720: aload 8
    //   722: invokevirtual 144	java/io/InputStream:close	()V
    //   725: goto -439 -> 286
    //   728: astore 8
    //   730: aload 6
    //   732: aload 8
    //   734: invokevirtual 229	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   737: goto -477 -> 260
    //   740: aload 8
    //   742: invokevirtual 144	java/io/InputStream:close	()V
    //   745: goto -485 -> 260
    //   748: iload_2
    //   749: iconst_1
    //   750: iadd
    //   751: istore_2
    //   752: goto -624 -> 128
    //   755: astore_0
    //   756: goto -511 -> 245
    //   759: iload_1
    //   760: iconst_1
    //   761: iadd
    //   762: istore_1
    //   763: goto -681 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	766	0	parame	e
    //   81	682	1	i	int
    //   127	625	2	j	int
    //   640	24	3	k	int
    //   78	8	4	m	int
    //   620	3	5	bool	boolean
    //   26	1	6	localObject1	Object
    //   234	497	6	localThrowable1	java.lang.Throwable
    //   12	693	7	localArrayList	ArrayList
    //   23	698	8	localInputStream	InputStream
    //   728	13	8	localThrowable2	java.lang.Throwable
    //   17	123	9	localObject2	Object
    //   124	583	10	localSmileyInfo	com.tencent.mm.storage.emotion.SmileyInfo
    //   147	481	11	localNode	Node
    //   650	5	11	localException	Exception
    //   156	458	12	str	String
    // Exception table:
    //   from	to	target	type
    //   28	59	234	java/lang/Throwable
    //   63	80	234	java/lang/Throwable
    //   88	102	234	java/lang/Throwable
    //   107	126	234	java/lang/Throwable
    //   128	180	234	java/lang/Throwable
    //   183	221	234	java/lang/Throwable
    //   221	231	234	java/lang/Throwable
    //   309	321	234	java/lang/Throwable
    //   324	362	234	java/lang/Throwable
    //   362	372	234	java/lang/Throwable
    //   375	387	234	java/lang/Throwable
    //   390	428	234	java/lang/Throwable
    //   428	438	234	java/lang/Throwable
    //   441	453	234	java/lang/Throwable
    //   456	494	234	java/lang/Throwable
    //   494	504	234	java/lang/Throwable
    //   507	519	234	java/lang/Throwable
    //   522	560	234	java/lang/Throwable
    //   560	570	234	java/lang/Throwable
    //   573	585	234	java/lang/Throwable
    //   588	610	234	java/lang/Throwable
    //   613	622	234	java/lang/Throwable
    //   627	641	234	java/lang/Throwable
    //   641	647	234	java/lang/Throwable
    //   652	662	234	java/lang/Throwable
    //   667	701	234	java/lang/Throwable
    //   704	712	234	java/lang/Throwable
    //   236	244	244	finally
    //   19	25	267	java/lang/Exception
    //   255	260	267	java/lang/Exception
    //   260	267	267	java/lang/Exception
    //   720	725	267	java/lang/Exception
    //   730	737	267	java/lang/Exception
    //   740	745	267	java/lang/Exception
    //   627	641	650	java/lang/Exception
    //   255	260	728	java/lang/Throwable
    //   28	59	755	finally
    //   63	80	755	finally
    //   88	102	755	finally
    //   107	126	755	finally
    //   128	180	755	finally
    //   183	221	755	finally
    //   221	231	755	finally
    //   309	321	755	finally
    //   324	362	755	finally
    //   362	372	755	finally
    //   375	387	755	finally
    //   390	428	755	finally
    //   428	438	755	finally
    //   441	453	755	finally
    //   456	494	755	finally
    //   494	504	755	finally
    //   507	519	755	finally
    //   522	560	755	finally
    //   560	570	755	finally
    //   573	585	755	finally
    //   588	610	755	finally
    //   613	622	755	finally
    //   627	641	755	finally
    //   641	647	755	finally
    //   652	662	755	finally
    //   667	701	755	finally
    //   704	712	755	finally
  }
  
  public static ArrayList<SmileyPanelConfigInfo> f(e parame)
  {
    AppMethodBeat.i(104498);
    localArrayList = new ArrayList();
    Object localObject3 = DocumentBuilderFactory.newInstance();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localInputStream = i.ah(parame);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame = ((DocumentBuilderFactory)localObject3).newDocumentBuilder().parse(localInputStream);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame.normalize();
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      localNodeList = parame.getDocumentElement().getElementsByTagName("item");
      if (localNodeList == null) {
        break label474;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (localNodeList.getLength() <= 0) {
        break label474;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      k = localNodeList.getLength();
      i = 0;
    }
    catch (Exception parame)
    {
      NodeList localNodeList;
      int k;
      char[] arrayOfChar;
      int j;
      localObject2 = localObject1;
      ad.e("MicroMsg.EmojiResHelper", "parseSmileyPanelConfig parseXML exception:%s", new Object[] { parame.toString() });
      if (localObject1 == null) {
        break label466;
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        try
        {
          InputStream localInputStream;
          localObject1.close();
          AppMethodBeat.o(104498);
          return localArrayList;
          if (localInputStream == null) {
            continue;
          }
          try
          {
            localInputStream.close();
          }
          catch (IOException parame) {}
          continue;
          parame = finally;
          if (localObject2 == null) {}
        }
        catch (IOException parame)
        {
          try
          {
            localObject2.close();
            AppMethodBeat.o(104498);
            throw parame;
            parame = parame;
          }
          catch (IOException localIOException)
          {
            continue;
          }
        }
        continue;
        i += 1;
      }
    }
    if (i < k)
    {
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame = localNodeList.item(i);
      if (parame == null) {
        break label521;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (bt.isNullOrNil(parame.getTextContent())) {
        break label521;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame = parame.getTextContent().replaceAll("\"", "");
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (!parame.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
        break label518;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame = new String(Base64.decode(parame, 0));
      localObject3 = parame;
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (parame.startsWith("\\\\u"))
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        arrayOfChar = Character.toChars(Integer.parseInt(parame.substring(3), 16));
        parame = "";
        j = 0;
        for (;;)
        {
          localObject3 = parame;
          localObject1 = localInputStream;
          localObject2 = localInputStream;
          if (j >= arrayOfChar.length) {
            break;
          }
          localObject1 = localInputStream;
          localObject2 = localInputStream;
          parame = parame + String.valueOf(arrayOfChar[j]);
          j += 1;
        }
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      parame = new SmileyPanelConfigInfo(i, (String)localObject3);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (bt.isNullOrNil(parame.field_key))
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        ad.i("MicroMsg.EmojiResHelper", "key is null.");
      }
      for (;;)
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        ad.d("MicroMsg.EmojiResHelper", parame.toString());
        break;
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        localArrayList.add(parame);
      }
    }
  }
  
  /* Error */
  public static com.tencent.mm.bc.f g(e parame)
  {
    // Byte code:
    //   0: ldc_w 303
    //   3: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 305	com/tencent/mm/emoji/a/g
    //   9: dup
    //   10: invokespecial 306	com/tencent/mm/emoji/a/g:<init>	()V
    //   13: astore_3
    //   14: getstatic 312	com/tencent/mm/emoji/a/a:fMz	Lcom/tencent/mm/emoji/a/a$a;
    //   17: astore_1
    //   18: aload_0
    //   19: invokevirtual 318	com/tencent/mm/vfs/e:fhU	()Landroid/net/Uri;
    //   22: invokestatic 324	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   25: astore_0
    //   26: aload_0
    //   27: ldc_w 326
    //   30: invokestatic 332	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   33: aload_3
    //   34: ldc_w 334
    //   37: invokestatic 332	d/g/b/k:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   40: aload_0
    //   41: invokestatic 338	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   44: astore_1
    //   45: aload_1
    //   46: astore_0
    //   47: invokestatic 344	android/util/Xml:newPullParser	()Lorg/xmlpull/v1/XmlPullParser;
    //   50: astore_2
    //   51: aload_1
    //   52: astore_0
    //   53: aload_2
    //   54: ldc_w 346
    //   57: invokestatic 348	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: ldc_w 350
    //   66: iconst_0
    //   67: invokeinterface 356 3 0
    //   72: aload_1
    //   73: astore_0
    //   74: aload_2
    //   75: aload_1
    //   76: aconst_null
    //   77: invokeinterface 360 3 0
    //   82: aload_1
    //   83: astore_0
    //   84: aload_2
    //   85: invokeinterface 363 1 0
    //   90: pop
    //   91: aload_1
    //   92: astore_0
    //   93: aload_3
    //   94: aload_2
    //   95: invokevirtual 367	com/tencent/mm/emoji/a/a:q	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 144	java/io/InputStream:close	()V
    //   106: aload_3
    //   107: getfield 371	com/tencent/mm/emoji/a/g:fMG	Lcom/tencent/mm/bc/f;
    //   110: astore_0
    //   111: ldc 146
    //   113: ldc_w 373
    //   116: iconst_1
    //   117: anewarray 4	java/lang/Object
    //   120: dup
    //   121: iconst_0
    //   122: aload_0
    //   123: getfield 379	com/tencent/mm/bc/f:hph	Ljava/util/LinkedList;
    //   126: invokevirtual 382	java/util/LinkedList:size	()I
    //   129: invokestatic 385	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 387	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: ldc_w 303
    //   139: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: aload_0
    //   143: areturn
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: astore_0
    //   149: invokestatic 390	com/tencent/mm/emoji/a/a:access$getTAG$cp	()Ljava/lang/String;
    //   152: aload_2
    //   153: checkcast 46	java/lang/Throwable
    //   156: ldc_w 392
    //   159: iconst_0
    //   160: anewarray 4	java/lang/Object
    //   163: invokestatic 396	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: aload_1
    //   167: ifnull -61 -> 106
    //   170: aload_1
    //   171: invokevirtual 144	java/io/InputStream:close	()V
    //   174: goto -68 -> 106
    //   177: astore_0
    //   178: ldc 146
    //   180: aload_0
    //   181: ldc 240
    //   183: iconst_0
    //   184: anewarray 4	java/lang/Object
    //   187: invokestatic 396	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   190: ldc_w 303
    //   193: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aconst_null
    //   197: areturn
    //   198: astore_1
    //   199: aconst_null
    //   200: astore_0
    //   201: aload_0
    //   202: ifnull +7 -> 209
    //   205: aload_0
    //   206: invokevirtual 144	java/io/InputStream:close	()V
    //   209: ldc_w 303
    //   212: invokestatic 16	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_1
    //   216: athrow
    //   217: astore_1
    //   218: goto -17 -> 201
    //   221: astore_2
    //   222: goto -75 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	parame	e
    //   17	154	1	localObject1	Object
    //   198	18	1	localObject2	Object
    //   217	1	1	localObject3	Object
    //   50	45	2	localXmlPullParser	org.xmlpull.v1.XmlPullParser
    //   144	9	2	localException1	Exception
    //   221	1	2	localException2	Exception
    //   13	94	3	localg	com.tencent.mm.emoji.a.g
    // Exception table:
    //   from	to	target	type
    //   40	45	144	java/lang/Exception
    //   6	40	177	java/lang/Exception
    //   102	106	177	java/lang/Exception
    //   106	136	177	java/lang/Exception
    //   170	174	177	java/lang/Exception
    //   205	209	177	java/lang/Exception
    //   209	217	177	java/lang/Exception
    //   40	45	198	finally
    //   47	51	217	finally
    //   53	60	217	finally
    //   62	72	217	finally
    //   74	82	217	finally
    //   84	91	217	finally
    //   93	98	217	finally
    //   149	166	217	finally
    //   47	51	221	java/lang/Exception
    //   53	60	221	java/lang/Exception
    //   62	72	221	java/lang/Exception
    //   74	82	221	java/lang/Exception
    //   84	91	221	java/lang/Exception
    //   93	98	221	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.d.b
 * JD-Core Version:    0.7.0.1
 */