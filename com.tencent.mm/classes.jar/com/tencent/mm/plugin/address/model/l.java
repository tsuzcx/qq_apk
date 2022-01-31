package com.tencent.mm.plugin.address.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final Pattern gKY;
  public a gKU;
  public final List<RcptItem> gKV;
  public final HashMap<String, List<RcptItem>> gKW;
  public final HashMap<String, List<RcptItem>> gKX;
  public String path;
  
  static
  {
    AppMethodBeat.i(16777);
    gKY = Pattern.compile("(-|\\s)+");
    AppMethodBeat.o(16777);
  }
  
  public l()
  {
    AppMethodBeat.i(16760);
    this.gKU = new a();
    this.gKV = new ArrayList();
    this.gKW = new HashMap();
    this.gKX = new HashMap();
    AppMethodBeat.o(16760);
  }
  
  private byte[] asq()
  {
    AppMethodBeat.i(16766);
    byte[] arrayOfByte = g.w(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
    AppMethodBeat.o(16766);
    return arrayOfByte;
  }
  
  private static boolean bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16773);
    if (paramString1.substring(6).startsWith(paramString2))
    {
      AppMethodBeat.o(16773);
      return true;
    }
    AppMethodBeat.o(16773);
    return false;
  }
  
  private static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(16768);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(16768);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletAddrMgr", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  private static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(16767);
    try
    {
      paramArrayOfByte2 = new DESKeySpec(paramArrayOfByte2);
      paramArrayOfByte2 = SecretKeyFactory.getInstance("DES").generateSecret(paramArrayOfByte2);
      Cipher localCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec("12345678".getBytes()));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      AppMethodBeat.o(16767);
      return paramArrayOfByte1;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WalletAddrMgr", paramArrayOfByte1, "", new Object[0]);
        paramArrayOfByte1 = null;
      }
    }
  }
  
  private static RcptItem f(List<RcptItem> paramList, String paramString)
  {
    AppMethodBeat.i(16775);
    if ((paramList == null) || (paramList.isEmpty()) || (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(16775);
      return null;
    }
    int i = 0;
    RcptItem localRcptItem;
    if (i < paramList.size())
    {
      localRcptItem = (RcptItem)paramList.get(i);
      if ((localRcptItem == null) || (!paramString.equals(localRcptItem.name))) {}
    }
    for (paramList = localRcptItem;; paramList = null)
    {
      AppMethodBeat.o(16775);
      return paramList;
      i += 1;
      break;
    }
  }
  
  public final boolean A(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(16776);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(16776);
      return false;
    }
    paramString1 = f(this.gKV, paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(16776);
      return false;
    }
    paramString1 = f(xF(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(16776);
      return false;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(16776);
      return true;
    }
    if (f(xG(paramString1.code), paramString3) == null)
    {
      AppMethodBeat.o(16776);
      return false;
    }
    AppMethodBeat.o(16776);
    return true;
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(16763);
    if (this.gKU == null) {
      this.gKU = new a();
    }
    int i = 0;
    while (i < this.gKU.gLc.size())
    {
      if (((b)this.gKU.gLc.get(i)).id == paramb.id)
      {
        this.gKU.gLc.remove(i);
        AppMethodBeat.o(16763);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(16763);
    return false;
  }
  
  /* Error */
  public final void aso()
  {
    // Byte code:
    //   0: sipush 16761
    //   3: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 229	com/tencent/mm/model/aw:aaz	()Lcom/tencent/mm/model/c;
    //   9: pop
    //   10: invokestatic 234	com/tencent/mm/model/c:getAccPath	()Ljava/lang/String;
    //   13: astore 10
    //   15: ldc 146
    //   17: ldc 236
    //   19: iconst_1
    //   20: anewarray 4	java/lang/Object
    //   23: dup
    //   24: iconst_0
    //   25: aload 10
    //   27: aastore
    //   28: invokestatic 239	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: invokestatic 245	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   34: getfield 250	com/tencent/mm/kernel/e:cachePath	Ljava/lang/String;
    //   37: astore 5
    //   39: ldc 146
    //   41: ldc 252
    //   43: invokestatic 256	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: invokestatic 262	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   49: invokevirtual 268	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   52: astore 12
    //   54: aconst_null
    //   55: astore 7
    //   57: aconst_null
    //   58: astore 4
    //   60: aconst_null
    //   61: astore 9
    //   63: new 49	java/util/ArrayList
    //   66: dup
    //   67: invokespecial 50	java/util/ArrayList:<init>	()V
    //   70: astore 11
    //   72: iconst_0
    //   73: istore_3
    //   74: new 270	java/io/FileReader
    //   77: dup
    //   78: new 63	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   85: aload 5
    //   87: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc_w 273
    //   93: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 274	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   102: astore 5
    //   104: aload 5
    //   106: astore 6
    //   108: aload 4
    //   110: astore 7
    //   112: new 276	java/io/BufferedReader
    //   115: dup
    //   116: aload 5
    //   118: invokespecial 279	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   121: astore 4
    //   123: aload 11
    //   125: invokeinterface 282 1 0
    //   130: aload 4
    //   132: invokevirtual 285	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: astore 6
    //   137: aload 6
    //   139: ifnull +389 -> 528
    //   142: aload 11
    //   144: aload 6
    //   146: invokeinterface 288 2 0
    //   151: pop
    //   152: goto -22 -> 130
    //   155: astore 8
    //   157: aload 5
    //   159: astore 6
    //   161: aload 4
    //   163: astore 7
    //   165: ldc 146
    //   167: aload 8
    //   169: ldc 148
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: aload 5
    //   180: ifnull +8 -> 188
    //   183: aload 5
    //   185: invokevirtual 291	java/io/FileReader:close	()V
    //   188: aload 4
    //   190: ifnull +8 -> 198
    //   193: aload 4
    //   195: invokevirtual 292	java/io/BufferedReader:close	()V
    //   198: iload_3
    //   199: ifne +116 -> 315
    //   202: aload 11
    //   204: invokeinterface 282 1 0
    //   209: aload 12
    //   211: ldc_w 273
    //   214: invokevirtual 298	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   217: astore 7
    //   219: new 276	java/io/BufferedReader
    //   222: dup
    //   223: new 300	java/io/InputStreamReader
    //   226: dup
    //   227: aload 7
    //   229: ldc_w 302
    //   232: invokespecial 305	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   235: invokespecial 279	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   238: astore 6
    //   240: aload 6
    //   242: astore 5
    //   244: aload 6
    //   246: invokevirtual 285	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   249: astore 4
    //   251: aload 4
    //   253: ifnull +490 -> 743
    //   256: aload 6
    //   258: astore 5
    //   260: aload 11
    //   262: aload 4
    //   264: invokeinterface 288 2 0
    //   269: pop
    //   270: goto -30 -> 240
    //   273: astore 5
    //   275: aload 6
    //   277: astore 4
    //   279: aload 5
    //   281: astore 6
    //   283: aload 4
    //   285: astore 5
    //   287: ldc 146
    //   289: aload 6
    //   291: ldc 148
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload 4
    //   302: ifnull +8 -> 310
    //   305: aload 4
    //   307: invokevirtual 292	java/io/BufferedReader:close	()V
    //   310: aload 7
    //   312: ifnull +3 -> 315
    //   315: ldc 146
    //   317: ldc_w 307
    //   320: iload_3
    //   321: invokestatic 311	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   324: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   327: invokestatic 256	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   330: aload 11
    //   332: invokeinterface 172 1 0
    //   337: istore_2
    //   338: ldc 148
    //   340: astore 4
    //   342: ldc 148
    //   344: astore 5
    //   346: iconst_0
    //   347: istore_1
    //   348: iload_1
    //   349: iload_2
    //   350: if_icmpge +280 -> 630
    //   353: aload 11
    //   355: iload_1
    //   356: invokeinterface 176 2 0
    //   361: checkcast 80	java/lang/String
    //   364: astore 7
    //   366: iload_1
    //   367: iconst_1
    //   368: iadd
    //   369: iload_2
    //   370: if_icmpge +799 -> 1169
    //   373: aload 11
    //   375: iload_1
    //   376: iconst_1
    //   377: iadd
    //   378: invokeinterface 176 2 0
    //   383: checkcast 80	java/lang/String
    //   386: astore 6
    //   388: aload 7
    //   390: ldc_w 317
    //   393: ldc_w 319
    //   396: invokevirtual 323	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   399: ldc_w 325
    //   402: ldc_w 319
    //   405: invokevirtual 323	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   408: astore 7
    //   410: aload 6
    //   412: ldc_w 317
    //   415: ldc_w 319
    //   418: invokevirtual 323	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   421: ldc_w 325
    //   424: ldc_w 319
    //   427: invokevirtual 323	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   430: astore 8
    //   432: aload 7
    //   434: iconst_0
    //   435: bipush 6
    //   437: invokevirtual 94	java/lang/String:substring	(II)Ljava/lang/String;
    //   440: astore 6
    //   442: aload 7
    //   444: bipush 6
    //   446: invokevirtual 99	java/lang/String:substring	(I)Ljava/lang/String;
    //   449: astore 9
    //   451: ldc_w 319
    //   454: aload 9
    //   456: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   459: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   462: astore 7
    //   464: getstatic 35	com/tencent/mm/plugin/address/model/l:gKY	Ljava/util/regex/Pattern;
    //   467: aload 7
    //   469: invokevirtual 332	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   472: astore 7
    //   474: aload 7
    //   476: arraylength
    //   477: iconst_3
    //   478: if_icmpne +698 -> 1176
    //   481: new 178	com/tencent/mm/plugin/address/model/RcptItem
    //   484: dup
    //   485: aload 7
    //   487: iconst_1
    //   488: aaload
    //   489: aload 6
    //   491: aload 7
    //   493: iconst_2
    //   494: aaload
    //   495: invokespecial 335	com/tencent/mm/plugin/address/model/RcptItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   498: astore 7
    //   500: aload 7
    //   502: ifnonnull +355 -> 857
    //   505: ldc 146
    //   507: ldc_w 337
    //   510: aload 9
    //   512: invokestatic 328	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   515: invokevirtual 315	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   518: invokestatic 339	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   521: iload_1
    //   522: iconst_1
    //   523: iadd
    //   524: istore_1
    //   525: goto -177 -> 348
    //   528: aload 5
    //   530: invokevirtual 291	java/io/FileReader:close	()V
    //   533: aload 4
    //   535: invokevirtual 292	java/io/BufferedReader:close	()V
    //   538: iconst_1
    //   539: istore_3
    //   540: goto -342 -> 198
    //   543: astore 5
    //   545: ldc 146
    //   547: aload 5
    //   549: ldc 148
    //   551: iconst_0
    //   552: anewarray 4	java/lang/Object
    //   555: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   558: iconst_1
    //   559: istore_3
    //   560: goto -362 -> 198
    //   563: astore 5
    //   565: ldc 146
    //   567: aload 5
    //   569: ldc 148
    //   571: iconst_0
    //   572: anewarray 4	java/lang/Object
    //   575: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   578: goto -380 -> 198
    //   581: astore 4
    //   583: aconst_null
    //   584: astore 5
    //   586: aload 5
    //   588: ifnull +8 -> 596
    //   591: aload 5
    //   593: invokevirtual 291	java/io/FileReader:close	()V
    //   596: aload 7
    //   598: ifnull +8 -> 606
    //   601: aload 7
    //   603: invokevirtual 292	java/io/BufferedReader:close	()V
    //   606: sipush 16761
    //   609: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   612: aload 4
    //   614: athrow
    //   615: astore 4
    //   617: ldc 146
    //   619: aload 4
    //   621: ldc 148
    //   623: iconst_0
    //   624: anewarray 4	java/lang/Object
    //   627: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   630: aload_0
    //   631: new 63	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 271	java/lang/StringBuilder:<init>	()V
    //   638: aload 10
    //   640: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc 65
    //   645: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: putfield 70	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   654: new 341	java/io/File
    //   657: dup
    //   658: aload_0
    //   659: getfield 70	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   662: invokespecial 342	java/io/File:<init>	(Ljava/lang/String;)V
    //   665: astore 4
    //   667: aload 4
    //   669: invokevirtual 345	java/io/File:exists	()Z
    //   672: ifne +9 -> 681
    //   675: aload 4
    //   677: invokevirtual 348	java/io/File:mkdir	()Z
    //   680: pop
    //   681: aload_0
    //   682: getfield 70	com/tencent/mm/plugin/address/model/l:path	Ljava/lang/String;
    //   685: iconst_0
    //   686: iconst_m1
    //   687: invokestatic 353	com/tencent/mm/a/e:i	(Ljava/lang/String;II)[B
    //   690: aload_0
    //   691: invokespecial 355	com/tencent/mm/plugin/address/model/l:asq	()[B
    //   694: invokestatic 357	com/tencent/mm/plugin/address/model/l:decrypt	([B[B)[B
    //   697: astore 4
    //   699: aload_0
    //   700: new 44	com/tencent/mm/plugin/address/d/a
    //   703: dup
    //   704: invokespecial 45	com/tencent/mm/plugin/address/d/a:<init>	()V
    //   707: aload 4
    //   709: invokevirtual 361	com/tencent/mm/plugin/address/d/a:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   712: checkcast 44	com/tencent/mm/plugin/address/d/a
    //   715: putfield 47	com/tencent/mm/plugin/address/model/l:gKU	Lcom/tencent/mm/plugin/address/d/a;
    //   718: sipush 16761
    //   721: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   724: return
    //   725: astore 5
    //   727: ldc 146
    //   729: aload 5
    //   731: ldc 148
    //   733: iconst_0
    //   734: anewarray 4	java/lang/Object
    //   737: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: goto -134 -> 606
    //   743: aload 6
    //   745: astore 5
    //   747: aload 6
    //   749: invokevirtual 292	java/io/BufferedReader:close	()V
    //   752: aload 6
    //   754: astore 5
    //   756: aload 7
    //   758: invokevirtual 364	java/io/InputStream:close	()V
    //   761: aload 6
    //   763: invokevirtual 292	java/io/BufferedReader:close	()V
    //   766: aload 7
    //   768: ifnull -453 -> 315
    //   771: goto -456 -> 315
    //   774: astore 4
    //   776: ldc 146
    //   778: aload 4
    //   780: ldc 148
    //   782: iconst_0
    //   783: anewarray 4	java/lang/Object
    //   786: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   789: goto -23 -> 766
    //   792: astore 4
    //   794: ldc 146
    //   796: aload 4
    //   798: ldc 148
    //   800: iconst_0
    //   801: anewarray 4	java/lang/Object
    //   804: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   807: goto -497 -> 310
    //   810: astore 6
    //   812: aload 4
    //   814: astore 5
    //   816: aload 6
    //   818: astore 4
    //   820: aload 5
    //   822: ifnull +8 -> 830
    //   825: aload 5
    //   827: invokevirtual 292	java/io/BufferedReader:close	()V
    //   830: sipush 16761
    //   833: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   836: aload 4
    //   838: athrow
    //   839: astore 5
    //   841: ldc 146
    //   843: aload 5
    //   845: ldc 148
    //   847: iconst_0
    //   848: anewarray 4	java/lang/Object
    //   851: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   854: goto -24 -> 830
    //   857: aload 9
    //   859: ldc_w 366
    //   862: invokevirtual 103	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   865: ifeq +71 -> 936
    //   868: aload_0
    //   869: getfield 59	com/tencent/mm/plugin/address/model/l:gKX	Ljava/util/HashMap;
    //   872: aload 4
    //   874: invokevirtual 369	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   877: ifne +20 -> 897
    //   880: aload_0
    //   881: getfield 59	com/tencent/mm/plugin/address/model/l:gKX	Ljava/util/HashMap;
    //   884: aload 4
    //   886: new 49	java/util/ArrayList
    //   889: dup
    //   890: invokespecial 50	java/util/ArrayList:<init>	()V
    //   893: invokevirtual 373	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   896: pop
    //   897: aload_0
    //   898: getfield 59	com/tencent/mm/plugin/address/model/l:gKX	Ljava/util/HashMap;
    //   901: aload 4
    //   903: invokevirtual 376	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   906: checkcast 159	java/util/List
    //   909: astore 6
    //   911: aload 6
    //   913: aload 7
    //   915: invokeinterface 288 2 0
    //   920: pop
    //   921: aload_0
    //   922: getfield 59	com/tencent/mm/plugin/address/model/l:gKX	Ljava/util/HashMap;
    //   925: aload 4
    //   927: aload 6
    //   929: invokevirtual 373	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   932: pop
    //   933: goto -412 -> 521
    //   936: aload 9
    //   938: ldc_w 378
    //   941: invokevirtual 103	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   944: ifeq +92 -> 1036
    //   947: aload_0
    //   948: getfield 57	com/tencent/mm/plugin/address/model/l:gKW	Ljava/util/HashMap;
    //   951: aload 5
    //   953: invokevirtual 369	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   956: ifne +20 -> 976
    //   959: aload_0
    //   960: getfield 57	com/tencent/mm/plugin/address/model/l:gKW	Ljava/util/HashMap;
    //   963: aload 5
    //   965: new 49	java/util/ArrayList
    //   968: dup
    //   969: invokespecial 50	java/util/ArrayList:<init>	()V
    //   972: invokevirtual 373	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   975: pop
    //   976: aload_0
    //   977: getfield 57	com/tencent/mm/plugin/address/model/l:gKW	Ljava/util/HashMap;
    //   980: aload 5
    //   982: invokevirtual 376	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   985: checkcast 159	java/util/List
    //   988: astore 4
    //   990: aload 8
    //   992: ldc_w 366
    //   995: invokestatic 380	com/tencent/mm/plugin/address/model/l:bp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   998: ifeq +9 -> 1007
    //   1001: aload 7
    //   1003: iconst_1
    //   1004: putfield 384	com/tencent/mm/plugin/address/model/RcptItem:gKT	Z
    //   1007: aload 4
    //   1009: aload 7
    //   1011: invokeinterface 288 2 0
    //   1016: pop
    //   1017: aload_0
    //   1018: getfield 57	com/tencent/mm/plugin/address/model/l:gKW	Ljava/util/HashMap;
    //   1021: aload 5
    //   1023: aload 4
    //   1025: invokevirtual 373	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1028: pop
    //   1029: aload 6
    //   1031: astore 4
    //   1033: goto -512 -> 521
    //   1036: aload 9
    //   1038: ldc_w 319
    //   1041: invokevirtual 103	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1044: ifeq +122 -> 1166
    //   1047: aload 8
    //   1049: ldc_w 378
    //   1052: invokestatic 380	com/tencent/mm/plugin/address/model/l:bp	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1055: ifeq +9 -> 1064
    //   1058: aload 7
    //   1060: iconst_1
    //   1061: putfield 384	com/tencent/mm/plugin/address/model/RcptItem:gKT	Z
    //   1064: aload_0
    //   1065: getfield 52	com/tencent/mm/plugin/address/model/l:gKV	Ljava/util/List;
    //   1068: aload 7
    //   1070: invokeinterface 288 2 0
    //   1075: pop
    //   1076: aload 6
    //   1078: astore 5
    //   1080: goto -559 -> 521
    //   1083: astore 4
    //   1085: ldc 146
    //   1087: aload 4
    //   1089: ldc 148
    //   1091: iconst_0
    //   1092: anewarray 4	java/lang/Object
    //   1095: invokestatic 154	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1098: sipush 16761
    //   1101: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1104: return
    //   1105: astore 4
    //   1107: goto -287 -> 820
    //   1110: astore 6
    //   1112: aconst_null
    //   1113: astore 7
    //   1115: goto -832 -> 283
    //   1118: astore 6
    //   1120: goto -837 -> 283
    //   1123: astore 4
    //   1125: aload 6
    //   1127: astore 5
    //   1129: goto -543 -> 586
    //   1132: astore 6
    //   1134: aload 4
    //   1136: astore 7
    //   1138: aload 6
    //   1140: astore 4
    //   1142: goto -556 -> 586
    //   1145: astore 8
    //   1147: aconst_null
    //   1148: astore 5
    //   1150: aload 9
    //   1152: astore 4
    //   1154: goto -997 -> 157
    //   1157: astore 8
    //   1159: aload 9
    //   1161: astore 4
    //   1163: goto -1006 -> 157
    //   1166: goto -645 -> 521
    //   1169: ldc 148
    //   1171: astore 6
    //   1173: goto -785 -> 388
    //   1176: aconst_null
    //   1177: astore 7
    //   1179: goto -679 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1182	0	this	l
    //   347	178	1	i	int
    //   337	34	2	j	int
    //   73	487	3	bool	boolean
    //   58	476	4	localObject1	Object
    //   581	32	4	localObject2	Object
    //   615	5	4	localException1	Exception
    //   665	43	4	localObject3	Object
    //   774	5	4	localIOException1	java.io.IOException
    //   792	21	4	localIOException2	java.io.IOException
    //   818	214	4	localObject4	Object
    //   1083	5	4	localException2	Exception
    //   1105	1	4	localObject5	Object
    //   1123	12	4	localObject6	Object
    //   1140	22	4	localObject7	Object
    //   37	222	5	localObject8	Object
    //   273	7	5	localIOException3	java.io.IOException
    //   285	244	5	localObject9	Object
    //   543	5	5	localException3	Exception
    //   563	5	5	localException4	Exception
    //   584	8	5	localObject10	Object
    //   725	5	5	localException5	Exception
    //   745	81	5	localObject11	Object
    //   839	183	5	localIOException4	java.io.IOException
    //   1078	71	5	localObject12	Object
    //   106	656	6	localObject13	Object
    //   810	7	6	localObject14	Object
    //   909	168	6	localList	List
    //   1110	1	6	localIOException5	java.io.IOException
    //   1118	8	6	localIOException6	java.io.IOException
    //   1132	7	6	localObject15	Object
    //   1171	1	6	str1	String
    //   55	1123	7	localObject16	Object
    //   155	13	8	localIOException7	java.io.IOException
    //   430	618	8	str2	String
    //   1145	1	8	localIOException8	java.io.IOException
    //   1157	1	8	localIOException9	java.io.IOException
    //   61	1099	9	str3	String
    //   13	626	10	str4	String
    //   70	304	11	localArrayList	ArrayList
    //   52	158	12	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   123	130	155	java/io/IOException
    //   130	137	155	java/io/IOException
    //   142	152	155	java/io/IOException
    //   244	251	273	java/io/IOException
    //   260	270	273	java/io/IOException
    //   747	752	273	java/io/IOException
    //   756	761	273	java/io/IOException
    //   528	538	543	java/lang/Exception
    //   183	188	563	java/lang/Exception
    //   193	198	563	java/lang/Exception
    //   74	104	581	finally
    //   31	54	615	java/lang/Exception
    //   63	72	615	java/lang/Exception
    //   305	310	615	java/lang/Exception
    //   315	338	615	java/lang/Exception
    //   353	366	615	java/lang/Exception
    //   373	388	615	java/lang/Exception
    //   388	500	615	java/lang/Exception
    //   505	521	615	java/lang/Exception
    //   545	558	615	java/lang/Exception
    //   565	578	615	java/lang/Exception
    //   606	615	615	java/lang/Exception
    //   727	740	615	java/lang/Exception
    //   761	766	615	java/lang/Exception
    //   776	789	615	java/lang/Exception
    //   794	807	615	java/lang/Exception
    //   825	830	615	java/lang/Exception
    //   830	839	615	java/lang/Exception
    //   841	854	615	java/lang/Exception
    //   857	897	615	java/lang/Exception
    //   897	933	615	java/lang/Exception
    //   936	976	615	java/lang/Exception
    //   976	1007	615	java/lang/Exception
    //   1007	1029	615	java/lang/Exception
    //   1036	1064	615	java/lang/Exception
    //   1064	1076	615	java/lang/Exception
    //   591	596	725	java/lang/Exception
    //   601	606	725	java/lang/Exception
    //   761	766	774	java/io/IOException
    //   305	310	792	java/io/IOException
    //   202	219	810	finally
    //   219	240	810	finally
    //   825	830	839	java/io/IOException
    //   699	718	1083	java/lang/Exception
    //   244	251	1105	finally
    //   260	270	1105	finally
    //   287	300	1105	finally
    //   747	752	1105	finally
    //   756	761	1105	finally
    //   202	219	1110	java/io/IOException
    //   219	240	1118	java/io/IOException
    //   112	123	1123	finally
    //   165	178	1123	finally
    //   123	130	1132	finally
    //   130	137	1132	finally
    //   142	152	1132	finally
    //   74	104	1145	java/io/IOException
    //   112	123	1157	java/io/IOException
  }
  
  public final void asp()
  {
    AppMethodBeat.i(16765);
    try
    {
      byte[] arrayOfByte = this.gKU.toByteArray();
      long l = System.currentTimeMillis();
      arrayOfByte = encrypt(arrayOfByte, asq());
      e.deleteFile(this.path);
      e.b(this.path, arrayOfByte, arrayOfByte.length);
      ab.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      AppMethodBeat.o(16765);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WalletAddrMgr", localException, "", new Object[0]);
      AppMethodBeat.o(16765);
    }
  }
  
  public final RcptItem bo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(16772);
    paramString1 = xF(paramString1);
    if ((paramString1 == null) || (paramString1.size() == 0))
    {
      AppMethodBeat.o(16772);
      return null;
    }
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)paramString1.next();
      if (localRcptItem.name.startsWith(paramString2))
      {
        AppMethodBeat.o(16772);
        return localRcptItem;
      }
    }
    AppMethodBeat.o(16772);
    return null;
  }
  
  public final b na(int paramInt)
  {
    AppMethodBeat.i(16762);
    int i = 0;
    while (i < this.gKU.gLc.size())
    {
      b localb = (b)this.gKU.gLc.get(i);
      if (localb.id == paramInt)
      {
        AppMethodBeat.o(16762);
        return localb;
      }
      i += 1;
    }
    AppMethodBeat.o(16762);
    return null;
  }
  
  public final boolean s(LinkedList<brp> paramLinkedList)
  {
    AppMethodBeat.i(16764);
    this.gKU.gLc.clear();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      brp localbrp = (brp)paramLinkedList.next();
      b localb = new b();
      localb.id = localbrp.id;
      localb.gLl = localbrp.xFr.xJE;
      localb.gLf = localbrp.xFl.xJE;
      localb.gLi = localbrp.xFo.xJE;
      localb.gLg = localbrp.xFm.xJE;
      localb.gLj = localbrp.xFp.xJE;
      localb.gLk = localbrp.xFq.xJE;
      localb.gLe = localbrp.xFk.xJE;
      localb.gLh = localbrp.xFn.xJE;
      this.gKU.gLc.add(localb);
    }
    AppMethodBeat.o(16764);
    return true;
  }
  
  public final List<RcptItem> xF(String paramString)
  {
    AppMethodBeat.i(16769);
    if (this.gKW.containsKey(paramString))
    {
      paramString = (List)this.gKW.get(paramString);
      AppMethodBeat.o(16769);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(16769);
    return paramString;
  }
  
  public final List<RcptItem> xG(String paramString)
  {
    AppMethodBeat.i(16770);
    if (this.gKX.containsKey(paramString))
    {
      paramString = (List)this.gKX.get(paramString);
      AppMethodBeat.o(16770);
      return paramString;
    }
    paramString = new ArrayList();
    AppMethodBeat.o(16770);
    return paramString;
  }
  
  public final RcptItem xH(String paramString)
  {
    AppMethodBeat.i(16771);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(16771);
      return null;
    }
    Iterator localIterator = this.gKV.iterator();
    while (localIterator.hasNext())
    {
      RcptItem localRcptItem = (RcptItem)localIterator.next();
      if (localRcptItem.name.startsWith(paramString))
      {
        AppMethodBeat.o(16771);
        return localRcptItem;
      }
    }
    AppMethodBeat.o(16771);
    return null;
  }
  
  public final RcptItem z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(16774);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(16774);
      return null;
    }
    paramString1 = f(this.gKV, paramString1);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(16774);
      return null;
    }
    paramString1 = f(xF(paramString1.code), paramString2);
    if ((paramString1 == null) || (TextUtils.isEmpty(paramString1.code)))
    {
      AppMethodBeat.o(16774);
      return null;
    }
    if (TextUtils.isEmpty(paramString3))
    {
      AppMethodBeat.o(16774);
      return paramString1;
    }
    paramString2 = f(xG(paramString1.code), paramString3);
    if (paramString2 == null)
    {
      AppMethodBeat.o(16774);
      return paramString1;
    }
    AppMethodBeat.o(16774);
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.model.l
 * JD-Core Version:    0.7.0.1
 */