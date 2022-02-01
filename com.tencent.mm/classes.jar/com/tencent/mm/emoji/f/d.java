package com.tencent.mm.emoji.f;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.a;
import com.tencent.mm.emoji.c.a.a;
import com.tencent.mm.modelpackage.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.SmileyPanelConfigInfo;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public final class d
{
  public static int Ex(String paramString)
  {
    int j = -1;
    AppMethodBeat.i(242556);
    int i = j;
    if (y.ZC(paramString)) {}
    try
    {
      i = new com.tencent.mm.ad.i(y.bEn(paramString)).optInt("version", -1);
      Log.i("MicroMsg.EmojiResHelper", "readConfigVersion: %s, %s", new Object[] { Integer.valueOf(i), paramString });
      AppMethodBeat.o(242556);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.EmojiResHelper", localException, "readConfigVersion fail", new Object[0]);
        i = j;
      }
    }
  }
  
  /* Error */
  public static ArrayList<com.tencent.mm.storage.emotion.SmileyInfo> d(u paramu)
  {
    // Byte code:
    //   0: ldc 65
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 67	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 70	java/util/ArrayList:<init>	()V
    //   12: astore 6
    //   14: invokestatic 76	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   17: astore 7
    //   19: aload_0
    //   20: invokestatic 80	com/tencent/mm/vfs/y:ao	(Lcom/tencent/mm/vfs/u;)Ljava/io/InputStream;
    //   23: astore_0
    //   24: aload 7
    //   26: invokevirtual 84	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   29: aload_0
    //   30: invokevirtual 90	javax/xml/parsers/DocumentBuilder:parse	(Ljava/io/InputStream;)Lorg/w3c/dom/Document;
    //   33: astore 7
    //   35: aload 7
    //   37: invokeinterface 95 1 0
    //   42: aload 7
    //   44: invokeinterface 99 1 0
    //   49: ldc 101
    //   51: invokeinterface 107 2 0
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +643 -> 703
    //   63: aload 7
    //   65: invokeinterface 113 1 0
    //   70: ifle +633 -> 703
    //   73: aload 7
    //   75: invokeinterface 113 1 0
    //   80: istore 4
    //   82: iconst_0
    //   83: istore_1
    //   84: iload_1
    //   85: iload 4
    //   87: if_icmpge +616 -> 703
    //   90: aload 7
    //   92: iload_1
    //   93: invokeinterface 117 2 0
    //   98: invokeinterface 123 1 0
    //   103: astore 8
    //   105: aload 8
    //   107: ifnull +624 -> 731
    //   110: aload 8
    //   112: invokeinterface 113 1 0
    //   117: ifle +614 -> 731
    //   120: new 125	com/tencent/mm/storage/emotion/SmileyInfo
    //   123: dup
    //   124: invokespecial 126	com/tencent/mm/storage/emotion/SmileyInfo:<init>	()V
    //   127: astore 9
    //   129: iconst_0
    //   130: istore_2
    //   131: iload_2
    //   132: aload 8
    //   134: invokeinterface 113 1 0
    //   139: if_icmpge +516 -> 655
    //   142: aload 8
    //   144: iload_2
    //   145: invokeinterface 117 2 0
    //   150: astore 10
    //   152: aload 10
    //   154: invokeinterface 130 1 0
    //   159: astore 11
    //   161: aload 11
    //   163: ldc 132
    //   165: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   168: ifeq +18 -> 186
    //   171: aload 9
    //   173: aload 10
    //   175: invokeinterface 140 1 0
    //   180: putfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   183: goto +541 -> 724
    //   186: aload 11
    //   188: ldc 146
    //   190: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   193: ifeq +119 -> 312
    //   196: aload 10
    //   198: invokeinterface 140 1 0
    //   203: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   206: ifne +18 -> 224
    //   209: ldc 153
    //   211: aload 10
    //   213: invokeinterface 140 1 0
    //   218: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   221: ifeq +76 -> 297
    //   224: aload 9
    //   226: aload 9
    //   228: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   231: putfield 156	com/tencent/mm/storage/emotion/SmileyInfo:field_cnValue	Ljava/lang/String;
    //   234: goto +490 -> 724
    //   237: astore 7
    //   239: aload_0
    //   240: ifnull +7 -> 247
    //   243: aload_0
    //   244: invokevirtual 161	java/io/InputStream:close	()V
    //   247: ldc 65
    //   249: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload 7
    //   254: athrow
    //   255: astore_0
    //   256: ldc 39
    //   258: ldc 163
    //   260: iconst_1
    //   261: anewarray 4	java/lang/Object
    //   264: dup
    //   265: iconst_0
    //   266: aload_0
    //   267: invokevirtual 166	java/lang/Exception:toString	()Ljava/lang/String;
    //   270: aastore
    //   271: invokestatic 169	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload 6
    //   276: invokevirtual 172	java/util/ArrayList:size	()I
    //   279: ifne +10 -> 289
    //   282: ldc 39
    //   284: ldc 174
    //   286: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: ldc 65
    //   291: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: aload 6
    //   296: areturn
    //   297: aload 9
    //   299: aload 10
    //   301: invokeinterface 140 1 0
    //   306: putfield 156	com/tencent/mm/storage/emotion/SmileyInfo:field_cnValue	Ljava/lang/String;
    //   309: goto +415 -> 724
    //   312: aload 11
    //   314: ldc 180
    //   316: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   319: ifeq +59 -> 378
    //   322: aload 10
    //   324: invokeinterface 140 1 0
    //   329: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   332: ifne +18 -> 350
    //   335: ldc 153
    //   337: aload 10
    //   339: invokeinterface 140 1 0
    //   344: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   347: ifeq +16 -> 363
    //   350: aload 9
    //   352: aload 9
    //   354: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   357: putfield 183	com/tencent/mm/storage/emotion/SmileyInfo:field_qqValue	Ljava/lang/String;
    //   360: goto +364 -> 724
    //   363: aload 9
    //   365: aload 10
    //   367: invokeinterface 140 1 0
    //   372: putfield 183	com/tencent/mm/storage/emotion/SmileyInfo:field_qqValue	Ljava/lang/String;
    //   375: goto +349 -> 724
    //   378: aload 11
    //   380: ldc 185
    //   382: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   385: ifeq +59 -> 444
    //   388: aload 10
    //   390: invokeinterface 140 1 0
    //   395: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   398: ifne +18 -> 416
    //   401: ldc 153
    //   403: aload 10
    //   405: invokeinterface 140 1 0
    //   410: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   413: ifeq +16 -> 429
    //   416: aload 9
    //   418: aload 9
    //   420: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   423: putfield 188	com/tencent/mm/storage/emotion/SmileyInfo:field_enValue	Ljava/lang/String;
    //   426: goto +298 -> 724
    //   429: aload 9
    //   431: aload 10
    //   433: invokeinterface 140 1 0
    //   438: putfield 188	com/tencent/mm/storage/emotion/SmileyInfo:field_enValue	Ljava/lang/String;
    //   441: goto +283 -> 724
    //   444: aload 11
    //   446: ldc 190
    //   448: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   451: ifeq +59 -> 510
    //   454: aload 10
    //   456: invokeinterface 140 1 0
    //   461: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   464: ifne +18 -> 482
    //   467: ldc 153
    //   469: aload 10
    //   471: invokeinterface 140 1 0
    //   476: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   479: ifeq +16 -> 495
    //   482: aload 9
    //   484: aload 9
    //   486: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   489: putfield 193	com/tencent/mm/storage/emotion/SmileyInfo:field_twValue	Ljava/lang/String;
    //   492: goto +232 -> 724
    //   495: aload 9
    //   497: aload 10
    //   499: invokeinterface 140 1 0
    //   504: putfield 193	com/tencent/mm/storage/emotion/SmileyInfo:field_twValue	Ljava/lang/String;
    //   507: goto +217 -> 724
    //   510: aload 11
    //   512: ldc 195
    //   514: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   517: ifeq +59 -> 576
    //   520: aload 10
    //   522: invokeinterface 140 1 0
    //   527: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   530: ifne +18 -> 548
    //   533: ldc 153
    //   535: aload 10
    //   537: invokeinterface 140 1 0
    //   542: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   545: ifeq +16 -> 561
    //   548: aload 9
    //   550: aload 9
    //   552: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   555: putfield 198	com/tencent/mm/storage/emotion/SmileyInfo:field_thValue	Ljava/lang/String;
    //   558: goto +166 -> 724
    //   561: aload 9
    //   563: aload 10
    //   565: invokeinterface 140 1 0
    //   570: putfield 198	com/tencent/mm/storage/emotion/SmileyInfo:field_thValue	Ljava/lang/String;
    //   573: goto +151 -> 724
    //   576: aload 11
    //   578: ldc 200
    //   580: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   583: ifeq +18 -> 601
    //   586: aload 9
    //   588: aload 10
    //   590: invokeinterface 140 1 0
    //   595: putfield 203	com/tencent/mm/storage/emotion/SmileyInfo:field_fileName	Ljava/lang/String;
    //   598: goto +126 -> 724
    //   601: aload 11
    //   603: ldc 205
    //   605: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   608: istore 5
    //   610: iload 5
    //   612: ifeq +112 -> 724
    //   615: aload 10
    //   617: invokeinterface 140 1 0
    //   622: invokestatic 208	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   625: invokevirtual 211	java/lang/Integer:intValue	()I
    //   628: istore_3
    //   629: aload 9
    //   631: iload_3
    //   632: putfield 215	com/tencent/mm/storage/emotion/SmileyInfo:field_eggIndex	I
    //   635: goto +89 -> 724
    //   638: astore 10
    //   640: ldc 39
    //   642: aload 10
    //   644: invokestatic 219	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   647: invokestatic 221	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   650: iconst_m1
    //   651: istore_3
    //   652: goto -23 -> 629
    //   655: aload 9
    //   657: iconst_m1
    //   658: putfield 224	com/tencent/mm/storage/emotion/SmileyInfo:field_position	I
    //   661: ldc 39
    //   663: aload 9
    //   665: invokevirtual 225	com/tencent/mm/storage/emotion/SmileyInfo:toString	()Ljava/lang/String;
    //   668: invokestatic 227	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload 9
    //   673: getfield 144	com/tencent/mm/storage/emotion/SmileyInfo:field_key	Ljava/lang/String;
    //   676: invokestatic 151	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   679: ifeq +13 -> 692
    //   682: ldc 39
    //   684: ldc 229
    //   686: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: goto +42 -> 731
    //   692: aload 6
    //   694: aload 9
    //   696: invokevirtual 235	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   699: pop
    //   700: goto +31 -> 731
    //   703: aload_0
    //   704: ifnull -430 -> 274
    //   707: aload_0
    //   708: invokevirtual 161	java/io/InputStream:close	()V
    //   711: goto -437 -> 274
    //   714: astore_0
    //   715: aload 7
    //   717: aload_0
    //   718: invokevirtual 241	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   721: goto -474 -> 247
    //   724: iload_2
    //   725: iconst_1
    //   726: iadd
    //   727: istore_2
    //   728: goto -597 -> 131
    //   731: iload_1
    //   732: iconst_1
    //   733: iadd
    //   734: istore_1
    //   735: goto -651 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	738	0	paramu	u
    //   83	652	1	i	int
    //   130	598	2	j	int
    //   628	24	3	k	int
    //   80	8	4	m	int
    //   608	3	5	bool	boolean
    //   12	681	6	localArrayList	ArrayList
    //   17	74	7	localObject1	Object
    //   237	479	7	localObject2	Object
    //   103	40	8	localNodeList	NodeList
    //   127	568	9	localSmileyInfo	com.tencent.mm.storage.emotion.SmileyInfo
    //   150	466	10	localNode	Node
    //   638	5	10	localException	Exception
    //   159	443	11	str	String
    // Exception table:
    //   from	to	target	type
    //   24	58	237	finally
    //   63	82	237	finally
    //   90	105	237	finally
    //   110	129	237	finally
    //   131	183	237	finally
    //   186	224	237	finally
    //   224	234	237	finally
    //   297	309	237	finally
    //   312	350	237	finally
    //   350	360	237	finally
    //   363	375	237	finally
    //   378	416	237	finally
    //   416	426	237	finally
    //   429	441	237	finally
    //   444	482	237	finally
    //   482	492	237	finally
    //   495	507	237	finally
    //   510	548	237	finally
    //   548	558	237	finally
    //   561	573	237	finally
    //   576	598	237	finally
    //   601	610	237	finally
    //   615	629	237	finally
    //   629	635	237	finally
    //   640	650	237	finally
    //   655	689	237	finally
    //   692	700	237	finally
    //   19	24	255	java/lang/Exception
    //   247	255	255	java/lang/Exception
    //   707	711	255	java/lang/Exception
    //   715	721	255	java/lang/Exception
    //   615	629	638	java/lang/Exception
    //   243	247	714	finally
  }
  
  public static ArrayList<SmileyPanelConfigInfo> e(u paramu)
  {
    AppMethodBeat.i(104498);
    localArrayList = new ArrayList();
    Object localObject3 = DocumentBuilderFactory.newInstance();
    localObject2 = null;
    localObject1 = null;
    try
    {
      localInputStream = y.ao(paramu);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      paramu = ((DocumentBuilderFactory)localObject3).newDocumentBuilder().parse(localInputStream);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      paramu.normalize();
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      localNodeList = paramu.getDocumentElement().getElementsByTagName("item");
      if (localNodeList == null) {
        break label475;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (localNodeList.getLength() <= 0) {
        break label475;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      k = localNodeList.getLength();
      i = 0;
    }
    catch (Exception paramu)
    {
      NodeList localNodeList;
      int k;
      char[] arrayOfChar;
      int j;
      localObject2 = localObject1;
      Log.e("MicroMsg.EmojiResHelper", "parseSmileyPanelConfig parseXML exception:%s", new Object[] { paramu.toString() });
      if (localObject1 == null) {
        break label467;
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
          catch (IOException paramu) {}
          continue;
          paramu = finally;
          if (localObject2 == null) {}
        }
        catch (IOException paramu)
        {
          try
          {
            localObject2.close();
            AppMethodBeat.o(104498);
            throw paramu;
            paramu = paramu;
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
      paramu = localNodeList.item(i);
      if (paramu == null) {
        break label522;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (Util.isNullOrNil(paramu.getTextContent())) {
        break label522;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      paramu = paramu.getTextContent().replaceAll("\"", "");
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (!paramu.matches("^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=)?$")) {
        break label519;
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      paramu = new String(Base64.decode(paramu, 0));
      localObject3 = paramu;
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (paramu.startsWith("\\\\u"))
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        arrayOfChar = Character.toChars(Integer.parseInt(paramu.substring(3), 16));
        paramu = "";
        j = 0;
        for (;;)
        {
          localObject3 = paramu;
          localObject1 = localInputStream;
          localObject2 = localInputStream;
          if (j >= arrayOfChar.length) {
            break;
          }
          localObject1 = localInputStream;
          localObject2 = localInputStream;
          paramu = paramu + String.valueOf(arrayOfChar[j]);
          j += 1;
        }
      }
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      paramu = new SmileyPanelConfigInfo(i, (String)localObject3);
      localObject1 = localInputStream;
      localObject2 = localInputStream;
      if (Util.isNullOrNil(paramu.field_key))
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        Log.i("MicroMsg.EmojiResHelper", "key is null.");
      }
      for (;;)
      {
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        Log.d("MicroMsg.EmojiResHelper", paramu.toString());
        break;
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        localArrayList.add(paramu);
      }
    }
  }
  
  public static g f(u paramu)
  {
    AppMethodBeat.i(104499);
    try
    {
      com.tencent.mm.emoji.c.i locali = new com.tencent.mm.emoji.c.i();
      a.a locala = a.mhz;
      a.a.a(ah.v(paramu.jKT()), locali);
      paramu = locali.mhI;
      Log.i("MicroMsg.EmojiResHelper", "parserEmojiEggConfig: %s", new Object[] { Integer.valueOf(paramu.oQz.size()) });
      AppMethodBeat.o(104499);
      return paramu;
    }
    catch (Exception paramu)
    {
      Log.printErrStackTrace("MicroMsg.EmojiResHelper", paramu, "", new Object[0]);
      AppMethodBeat.o(104499);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.f.d
 * JD-Core Version:    0.7.0.1
 */