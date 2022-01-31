package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.c.bix;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l
{
  private static final Pattern ftw = Pattern.compile("(-|\\s)+");
  public a fts = new a();
  public final List<RcptItem> ftt = new ArrayList();
  public final HashMap<String, List<RcptItem>> ftu = new HashMap();
  public final HashMap<String, List<RcptItem>> ftv = new HashMap();
  public String path;
  
  private byte[] YG()
  {
    return g.o(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
  }
  
  private static boolean aU(String paramString1, String paramString2)
  {
    return paramString1.substring(6).startsWith(paramString2);
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      y.printErrStackTrace("MicroMsg.WalletAddrMgr", paramArrayOfByte1, "", new Object[0]);
    }
    return null;
  }
  
  private static RcptItem e(List<RcptItem> paramList, String paramString)
  {
    Object localObject;
    if ((paramList == null) || (paramList.isEmpty()) || (TextUtils.isEmpty(paramString)))
    {
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramList.size()) {
        break label75;
      }
      RcptItem localRcptItem = (RcptItem)paramList.get(i);
      if (localRcptItem != null)
      {
        localObject = localRcptItem;
        if (paramString.equals(localRcptItem.name)) {
          break;
        }
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      y.printErrStackTrace("MicroMsg.WalletAddrMgr", paramArrayOfByte1, "", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public final void YE()
  {
    // Byte code:
    //   0: ldc 137
    //   2: ldc 183
    //   4: invokestatic 187	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 193	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   10: pop
    //   11: invokestatic 198	com/tencent/mm/model/c:FU	()Ljava/lang/String;
    //   14: astore 10
    //   16: ldc 137
    //   18: ldc 200
    //   20: invokestatic 203	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: invokestatic 209	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   26: invokevirtual 215	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   29: astore 12
    //   31: aconst_null
    //   32: astore 7
    //   34: aconst_null
    //   35: astore 4
    //   37: aconst_null
    //   38: astore 9
    //   40: new 40	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 41	java/util/ArrayList:<init>	()V
    //   47: astore 11
    //   49: iconst_0
    //   50: istore_3
    //   51: new 217	java/io/FileReader
    //   54: dup
    //   55: new 54	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   62: aload 10
    //   64: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 220
    //   69: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokespecial 221	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   78: astore 5
    //   80: aload 5
    //   82: astore 6
    //   84: aload 4
    //   86: astore 7
    //   88: new 223	java/io/BufferedReader
    //   91: dup
    //   92: aload 5
    //   94: invokespecial 226	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   97: astore 4
    //   99: aload 11
    //   101: invokeinterface 229 1 0
    //   106: aload 4
    //   108: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   111: astore 6
    //   113: aload 6
    //   115: ifnull +407 -> 522
    //   118: aload 11
    //   120: aload 6
    //   122: invokeinterface 235 2 0
    //   127: pop
    //   128: goto -22 -> 106
    //   131: astore 8
    //   133: aload 5
    //   135: astore 6
    //   137: aload 4
    //   139: astore 7
    //   141: ldc 137
    //   143: aload 8
    //   145: ldc 139
    //   147: iconst_0
    //   148: anewarray 4	java/lang/Object
    //   151: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload 5
    //   156: ifnull +8 -> 164
    //   159: aload 5
    //   161: invokevirtual 238	java/io/FileReader:close	()V
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 239	java/io/BufferedReader:close	()V
    //   174: iload_3
    //   175: ifne +114 -> 289
    //   178: aload 11
    //   180: invokeinterface 229 1 0
    //   185: aload 12
    //   187: ldc 220
    //   189: invokevirtual 245	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   192: astore 7
    //   194: new 223	java/io/BufferedReader
    //   197: dup
    //   198: new 247	java/io/InputStreamReader
    //   201: dup
    //   202: aload 7
    //   204: ldc 249
    //   206: invokespecial 252	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   209: invokespecial 226	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   212: astore 6
    //   214: aload 6
    //   216: astore 5
    //   218: aload 6
    //   220: invokevirtual 232	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 4
    //   225: aload 4
    //   227: ifnull +394 -> 621
    //   230: aload 6
    //   232: astore 5
    //   234: aload 11
    //   236: aload 4
    //   238: invokeinterface 235 2 0
    //   243: pop
    //   244: goto -30 -> 214
    //   247: astore 5
    //   249: aload 6
    //   251: astore 4
    //   253: aload 5
    //   255: astore 6
    //   257: aload 4
    //   259: astore 5
    //   261: ldc 137
    //   263: aload 6
    //   265: ldc 139
    //   267: iconst_0
    //   268: anewarray 4	java/lang/Object
    //   271: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: aload 4
    //   276: ifnull +8 -> 284
    //   279: aload 4
    //   281: invokevirtual 239	java/io/BufferedReader:close	()V
    //   284: aload 7
    //   286: ifnull +3 -> 289
    //   289: ldc 137
    //   291: new 54	java/lang/StringBuilder
    //   294: dup
    //   295: ldc 254
    //   297: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: iload_3
    //   301: invokevirtual 257	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   304: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   307: invokestatic 203	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload 11
    //   312: invokeinterface 162 1 0
    //   317: istore_2
    //   318: ldc 139
    //   320: astore 4
    //   322: ldc 139
    //   324: astore 5
    //   326: iconst_0
    //   327: istore_1
    //   328: iload_1
    //   329: iload_2
    //   330: if_icmpge +638 -> 968
    //   333: aload 11
    //   335: iload_1
    //   336: invokeinterface 166 2 0
    //   341: checkcast 71	java/lang/String
    //   344: astore 7
    //   346: iload_1
    //   347: iconst_1
    //   348: iadd
    //   349: iload_2
    //   350: if_icmpge +379 -> 729
    //   353: aload 11
    //   355: iload_1
    //   356: iconst_1
    //   357: iadd
    //   358: invokeinterface 166 2 0
    //   363: checkcast 71	java/lang/String
    //   366: astore 6
    //   368: aload 7
    //   370: ldc_w 259
    //   373: ldc_w 261
    //   376: invokevirtual 265	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   379: ldc_w 267
    //   382: ldc_w 261
    //   385: invokevirtual 265	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   388: astore 7
    //   390: aload 6
    //   392: ldc_w 259
    //   395: ldc_w 261
    //   398: invokevirtual 265	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   401: ldc_w 267
    //   404: ldc_w 261
    //   407: invokevirtual 265	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   410: astore 8
    //   412: aload 7
    //   414: iconst_0
    //   415: bipush 6
    //   417: invokevirtual 85	java/lang/String:substring	(II)Ljava/lang/String;
    //   420: astore 6
    //   422: aload 7
    //   424: bipush 6
    //   426: invokevirtual 90	java/lang/String:substring	(I)Ljava/lang/String;
    //   429: astore 9
    //   431: new 54	java/lang/StringBuilder
    //   434: dup
    //   435: ldc_w 261
    //   438: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   441: aload 9
    //   443: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: astore 7
    //   451: getstatic 29	com/tencent/mm/plugin/address/model/l:ftw	Ljava/util/regex/Pattern;
    //   454: aload 7
    //   456: invokevirtual 271	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   459: astore 7
    //   461: aload 7
    //   463: arraylength
    //   464: iconst_3
    //   465: if_icmpne +271 -> 736
    //   468: new 168	com/tencent/mm/plugin/address/model/RcptItem
    //   471: dup
    //   472: aload 7
    //   474: iconst_1
    //   475: aaload
    //   476: aload 6
    //   478: aload 7
    //   480: iconst_2
    //   481: aaload
    //   482: invokespecial 274	com/tencent/mm/plugin/address/model/RcptItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   485: astore 7
    //   487: aload 7
    //   489: ifnonnull +253 -> 742
    //   492: ldc 137
    //   494: new 54	java/lang/StringBuilder
    //   497: dup
    //   498: ldc_w 276
    //   501: invokespecial 59	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   504: aload 9
    //   506: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 279	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   515: iload_1
    //   516: iconst_1
    //   517: iadd
    //   518: istore_1
    //   519: goto -191 -> 328
    //   522: aload 5
    //   524: invokevirtual 238	java/io/FileReader:close	()V
    //   527: aload 4
    //   529: invokevirtual 239	java/io/BufferedReader:close	()V
    //   532: iconst_1
    //   533: istore_3
    //   534: goto -360 -> 174
    //   537: astore 5
    //   539: ldc 137
    //   541: aload 5
    //   543: ldc 139
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: iconst_1
    //   553: istore_3
    //   554: goto -380 -> 174
    //   557: astore 5
    //   559: ldc 137
    //   561: aload 5
    //   563: ldc 139
    //   565: iconst_0
    //   566: anewarray 4	java/lang/Object
    //   569: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: goto -398 -> 174
    //   575: astore 4
    //   577: aconst_null
    //   578: astore 5
    //   580: aload 5
    //   582: ifnull +8 -> 590
    //   585: aload 5
    //   587: invokevirtual 238	java/io/FileReader:close	()V
    //   590: aload 7
    //   592: ifnull +8 -> 600
    //   595: aload 7
    //   597: invokevirtual 239	java/io/BufferedReader:close	()V
    //   600: aload 4
    //   602: athrow
    //   603: astore 5
    //   605: ldc 137
    //   607: aload 5
    //   609: ldc 139
    //   611: iconst_0
    //   612: anewarray 4	java/lang/Object
    //   615: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   618: goto -18 -> 600
    //   621: aload 6
    //   623: astore 5
    //   625: aload 6
    //   627: invokevirtual 239	java/io/BufferedReader:close	()V
    //   630: aload 6
    //   632: astore 5
    //   634: aload 7
    //   636: invokevirtual 282	java/io/InputStream:close	()V
    //   639: aload 6
    //   641: invokevirtual 239	java/io/BufferedReader:close	()V
    //   644: aload 7
    //   646: ifnull -357 -> 289
    //   649: goto -360 -> 289
    //   652: astore 4
    //   654: ldc 137
    //   656: aload 4
    //   658: ldc 139
    //   660: iconst_0
    //   661: anewarray 4	java/lang/Object
    //   664: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   667: goto -23 -> 644
    //   670: astore 4
    //   672: ldc 137
    //   674: aload 4
    //   676: ldc 139
    //   678: iconst_0
    //   679: anewarray 4	java/lang/Object
    //   682: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   685: goto -401 -> 284
    //   688: astore 6
    //   690: aload 4
    //   692: astore 5
    //   694: aload 6
    //   696: astore 4
    //   698: aload 5
    //   700: ifnull +8 -> 708
    //   703: aload 5
    //   705: invokevirtual 239	java/io/BufferedReader:close	()V
    //   708: aload 4
    //   710: athrow
    //   711: astore 5
    //   713: ldc 137
    //   715: aload 5
    //   717: ldc 139
    //   719: iconst_0
    //   720: anewarray 4	java/lang/Object
    //   723: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   726: goto -18 -> 708
    //   729: ldc 139
    //   731: astore 6
    //   733: goto -365 -> 368
    //   736: aconst_null
    //   737: astore 7
    //   739: goto -252 -> 487
    //   742: aload 9
    //   744: ldc_w 284
    //   747: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   750: ifeq +71 -> 821
    //   753: aload_0
    //   754: getfield 50	com/tencent/mm/plugin/address/model/l:ftv	Ljava/util/HashMap;
    //   757: aload 4
    //   759: invokevirtual 287	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   762: ifne +20 -> 782
    //   765: aload_0
    //   766: getfield 50	com/tencent/mm/plugin/address/model/l:ftv	Ljava/util/HashMap;
    //   769: aload 4
    //   771: new 40	java/util/ArrayList
    //   774: dup
    //   775: invokespecial 41	java/util/ArrayList:<init>	()V
    //   778: invokevirtual 291	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   781: pop
    //   782: aload_0
    //   783: getfield 50	com/tencent/mm/plugin/address/model/l:ftv	Ljava/util/HashMap;
    //   786: aload 4
    //   788: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   791: checkcast 149	java/util/List
    //   794: astore 6
    //   796: aload 6
    //   798: aload 7
    //   800: invokeinterface 235 2 0
    //   805: pop
    //   806: aload_0
    //   807: getfield 50	com/tencent/mm/plugin/address/model/l:ftv	Ljava/util/HashMap;
    //   810: aload 4
    //   812: aload 6
    //   814: invokevirtual 291	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   817: pop
    //   818: goto -303 -> 515
    //   821: aload 9
    //   823: ldc_w 296
    //   826: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   829: ifeq +92 -> 921
    //   832: aload_0
    //   833: getfield 48	com/tencent/mm/plugin/address/model/l:ftu	Ljava/util/HashMap;
    //   836: aload 5
    //   838: invokevirtual 287	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   841: ifne +20 -> 861
    //   844: aload_0
    //   845: getfield 48	com/tencent/mm/plugin/address/model/l:ftu	Ljava/util/HashMap;
    //   848: aload 5
    //   850: new 40	java/util/ArrayList
    //   853: dup
    //   854: invokespecial 41	java/util/ArrayList:<init>	()V
    //   857: invokevirtual 291	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   860: pop
    //   861: aload_0
    //   862: getfield 48	com/tencent/mm/plugin/address/model/l:ftu	Ljava/util/HashMap;
    //   865: aload 5
    //   867: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   870: checkcast 149	java/util/List
    //   873: astore 4
    //   875: aload 8
    //   877: ldc_w 284
    //   880: invokestatic 298	com/tencent/mm/plugin/address/model/l:aU	(Ljava/lang/String;Ljava/lang/String;)Z
    //   883: ifeq +9 -> 892
    //   886: aload 7
    //   888: iconst_1
    //   889: putfield 302	com/tencent/mm/plugin/address/model/RcptItem:ftr	Z
    //   892: aload 4
    //   894: aload 7
    //   896: invokeinterface 235 2 0
    //   901: pop
    //   902: aload_0
    //   903: getfield 48	com/tencent/mm/plugin/address/model/l:ftu	Ljava/util/HashMap;
    //   906: aload 5
    //   908: aload 4
    //   910: invokevirtual 291	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   913: pop
    //   914: aload 6
    //   916: astore 4
    //   918: goto -403 -> 515
    //   921: aload 9
    //   923: ldc_w 261
    //   926: invokevirtual 94	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   929: ifeq +205 -> 1134
    //   932: aload 8
    //   934: ldc_w 296
    //   937: invokestatic 298	com/tencent/mm/plugin/address/model/l:aU	(Ljava/lang/String;Ljava/lang/String;)Z
    //   940: ifeq +9 -> 949
    //   943: aload 7
    //   945: iconst_1
    //   946: putfield 302	com/tencent/mm/plugin/address/model/RcptItem:ftr	Z
    //   949: aload_0
    //   950: getfield 43	com/tencent/mm/plugin/address/model/l:ftt	Ljava/util/List;
    //   953: aload 7
    //   955: invokeinterface 235 2 0
    //   960: pop
    //   961: aload 6
    //   963: astore 5
    //   965: goto -450 -> 515
    //   968: aload_0
    //   969: new 54	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   976: aload 10
    //   978: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   981: ldc 56
    //   983: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   989: putfield 61	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   992: new 304	java/io/File
    //   995: dup
    //   996: aload_0
    //   997: getfield 61	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   1000: invokespecial 305	java/io/File:<init>	(Ljava/lang/String;)V
    //   1003: astore 4
    //   1005: aload 4
    //   1007: invokevirtual 308	java/io/File:exists	()Z
    //   1010: ifne +9 -> 1019
    //   1013: aload 4
    //   1015: invokevirtual 311	java/io/File:mkdir	()Z
    //   1018: pop
    //   1019: aload_0
    //   1020: getfield 61	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   1023: iconst_0
    //   1024: iconst_m1
    //   1025: invokestatic 317	com/tencent/mm/a/e:c	(Ljava/lang/String;II)[B
    //   1028: aload_0
    //   1029: invokespecial 319	com/tencent/mm/plugin/address/model/l:YG	()[B
    //   1032: invokestatic 321	com/tencent/mm/plugin/address/model/l:decrypt	([B[B)[B
    //   1035: astore 4
    //   1037: aload_0
    //   1038: new 35	com/tencent/mm/plugin/address/d/a
    //   1041: dup
    //   1042: invokespecial 36	com/tencent/mm/plugin/address/d/a:<init>	()V
    //   1045: aload 4
    //   1047: invokevirtual 325	com/tencent/mm/plugin/address/d/a:aH	([B)Lcom/tencent/mm/bv/a;
    //   1050: checkcast 35	com/tencent/mm/plugin/address/d/a
    //   1053: putfield 38	com/tencent/mm/plugin/address/model/l:fts	Lcom/tencent/mm/plugin/address/d/a;
    //   1056: return
    //   1057: astore 4
    //   1059: ldc 137
    //   1061: aload 4
    //   1063: ldc 139
    //   1065: iconst_0
    //   1066: anewarray 4	java/lang/Object
    //   1069: invokestatic 145	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1072: return
    //   1073: astore 4
    //   1075: goto -377 -> 698
    //   1078: astore 6
    //   1080: aconst_null
    //   1081: astore 7
    //   1083: goto -826 -> 257
    //   1086: astore 6
    //   1088: goto -831 -> 257
    //   1091: astore 4
    //   1093: aload 6
    //   1095: astore 5
    //   1097: goto -517 -> 580
    //   1100: astore 6
    //   1102: aload 4
    //   1104: astore 7
    //   1106: aload 6
    //   1108: astore 4
    //   1110: goto -530 -> 580
    //   1113: astore 8
    //   1115: aconst_null
    //   1116: astore 5
    //   1118: aload 9
    //   1120: astore 4
    //   1122: goto -989 -> 133
    //   1125: astore 8
    //   1127: aload 9
    //   1129: astore 4
    //   1131: goto -998 -> 133
    //   1134: goto -619 -> 515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1137	0	this	l
    //   327	192	1	i	int
    //   317	34	2	j	int
    //   50	504	3	bool	boolean
    //   35	493	4	localObject1	Object
    //   575	26	4	localObject2	Object
    //   652	5	4	localIOException1	java.io.IOException
    //   670	21	4	localIOException2	java.io.IOException
    //   696	350	4	localObject3	Object
    //   1057	5	4	localException1	Exception
    //   1073	1	4	localObject4	Object
    //   1091	12	4	localObject5	Object
    //   1108	22	4	localObject6	Object
    //   78	155	5	localObject7	Object
    //   247	7	5	localIOException3	java.io.IOException
    //   259	264	5	localObject8	Object
    //   537	5	5	localException2	Exception
    //   557	5	5	localException3	Exception
    //   578	8	5	localObject9	Object
    //   603	5	5	localException4	Exception
    //   623	81	5	localObject10	Object
    //   711	196	5	localIOException4	java.io.IOException
    //   963	154	5	localObject11	Object
    //   82	558	6	localObject12	Object
    //   688	7	6	localObject13	Object
    //   731	231	6	localObject14	Object
    //   1078	1	6	localIOException5	java.io.IOException
    //   1086	8	6	localIOException6	java.io.IOException
    //   1100	7	6	localObject15	Object
    //   32	1073	7	localObject16	Object
    //   131	13	8	localIOException7	java.io.IOException
    //   410	523	8	str1	String
    //   1113	1	8	localIOException8	java.io.IOException
    //   1125	1	8	localIOException9	java.io.IOException
    //   38	1090	9	str2	String
    //   14	963	10	str3	String
    //   47	307	11	localArrayList	ArrayList
    //   29	157	12	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   99	106	131	java/io/IOException
    //   106	113	131	java/io/IOException
    //   118	128	131	java/io/IOException
    //   218	225	247	java/io/IOException
    //   234	244	247	java/io/IOException
    //   625	630	247	java/io/IOException
    //   634	639	247	java/io/IOException
    //   522	532	537	java/lang/Exception
    //   159	164	557	java/lang/Exception
    //   169	174	557	java/lang/Exception
    //   51	80	575	finally
    //   585	590	603	java/lang/Exception
    //   595	600	603	java/lang/Exception
    //   639	644	652	java/io/IOException
    //   279	284	670	java/io/IOException
    //   178	194	688	finally
    //   194	214	688	finally
    //   703	708	711	java/io/IOException
    //   1037	1056	1057	java/lang/Exception
    //   218	225	1073	finally
    //   234	244	1073	finally
    //   261	274	1073	finally
    //   625	630	1073	finally
    //   634	639	1073	finally
    //   178	194	1078	java/io/IOException
    //   194	214	1086	java/io/IOException
    //   88	99	1091	finally
    //   141	154	1091	finally
    //   99	106	1100	finally
    //   106	113	1100	finally
    //   118	128	1100	finally
    //   51	80	1113	java/io/IOException
    //   88	99	1125	java/io/IOException
  }
  
  public final void YF()
  {
    try
    {
      byte[] arrayOfByte = this.fts.toByteArray();
      long l = System.currentTimeMillis();
      arrayOfByte = encrypt(arrayOfByte, YG());
      e.deleteFile(this.path);
      e.b(this.path, arrayOfByte, arrayOfByte.length);
      y.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WalletAddrMgr", localException, "", new Object[0]);
    }
  }
  
  public final boolean a(b paramb)
  {
    boolean bool2 = false;
    if (this.fts == null) {
      this.fts = new a();
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.fts.ftA.size())
      {
        if (((b)this.fts.ftA.get(i)).id == paramb.id)
        {
          this.fts.ftA.remove(i);
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public final b kg(int paramInt)
  {
    int i = 0;
    while (i < this.fts.ftA.size())
    {
      b localb = (b)this.fts.ftA.get(i);
      if (localb.id == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
  
  public final List<RcptItem> ql(String paramString)
  {
    if (this.ftu.containsKey(paramString)) {
      return (List)this.ftu.get(paramString);
    }
    return new ArrayList();
  }
  
  public final List<RcptItem> qm(String paramString)
  {
    if (this.ftv.containsKey(paramString)) {
      return (List)this.ftv.get(paramString);
    }
    return new ArrayList();
  }
  
  public final boolean s(LinkedList<bix> paramLinkedList)
  {
    this.fts.ftA.clear();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      bix localbix = (bix)paramLinkedList.next();
      b localb = new b();
      localb.id = localbix.id;
      localb.ftJ = localbix.tDb.tFO;
      localb.ftD = localbix.tCV.tFO;
      localb.ftG = localbix.tCY.tFO;
      localb.ftE = localbix.tCW.tFO;
      localb.ftH = localbix.tCZ.tFO;
      localb.ftI = localbix.tDa.tFO;
      localb.ftC = localbix.tCU.tFO;
      localb.ftF = localbix.tCX.tFO;
      this.fts.ftA.add(localb);
    }
    return true;
  }
  
  public final RcptItem v(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString1 = null;
    }
    do
    {
      do
      {
        return paramString1;
        paramString1 = e(this.ftt, paramString1);
        if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code))) {
          return null;
        }
        paramString2 = e(ql(paramString1.code), paramString2);
        if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.code))) {
          return null;
        }
        paramString1 = paramString2;
      } while (TextUtils.isEmpty(paramString3));
      paramString3 = e(qm(paramString2.code), paramString3);
      paramString1 = paramString2;
    } while (paramString3 == null);
    return paramString3;
  }
  
  public final boolean w(String paramString1, String paramString2, String paramString3)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        paramString1 = e(this.ftt, paramString1);
        if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code))) {
          return false;
        }
        paramString1 = e(ql(paramString1.code), paramString2);
        if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code))) {
          return false;
        }
        bool1 = bool2;
      } while (TextUtils.isEmpty(paramString3));
      bool1 = bool2;
    } while (e(qm(paramString1.code), paramString3) != null);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.l
 * JD-Core Version:    0.7.0.1
 */