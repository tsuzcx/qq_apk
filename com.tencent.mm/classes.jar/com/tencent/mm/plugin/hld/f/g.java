package com.tencent.mm.plugin.hld.f;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory.Companion;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.emoji.c;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.gjm;
import com.tencent.mm.protocal.protobuf.gjn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.i.c.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/utils/WxImeEmojiUtil;", "", "()V", "TAG", "", "allEmojiMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiData;", "Lkotlin/collections/HashMap;", "allEmojiTypeMap", "Lcom/tencent/mm/protocal/protobuf/WxImeEmojiDataList;", "emojiBitmapMap", "Landroid/graphics/Bitmap;", "emojiSubTypeArrayList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/hld/emoji/ImeEmojiSubTypeData;", "Lkotlin/collections/ArrayList;", "historyListenerMap", "Lkotlin/Function0;", "", "getHistoryListenerMap", "()Ljava/util/HashMap;", "setHistoryListenerMap", "(Ljava/util/HashMap;)V", "historyPath", "kaoemojiSubTypeArrayList", "mIRecentEmojiListenerWr", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/hld/emoji/IRecentEmojiListener;", "recentEmojiMap", "appendHistory", "emojiType", "emojiData", "appendHistoryFromCandidate", "candidate", "clear", "getAllEmojiByType", "context", "Landroid/content/Context;", "typeName", "subTypeName", "getEmojiBitmap", "getEmojiPath", "getEmojiSubType", "index", "", "getEmojiSubTypeData", "getHistory", "getKaoEmojiSubType", "getKaoEmojiSubTypeData", "getLastEmojiSubType", "getLastEmojiType", "getSubTypeByEmojiType", "parseHistory", "saveHistory", "recentEmojiList", "saveLastEmojiSubType", "subType", "saveLastEmojiType", "setIRecentEmojiListener", "listener", "unZipEmojiFile", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g Jyo;
  private static final String Jyp;
  private static final ArrayList<com.tencent.mm.plugin.hld.emoji.k> Jyq;
  private static final ArrayList<com.tencent.mm.plugin.hld.emoji.k> Jyr;
  private static final HashMap<String, gjn> Jys;
  private static final HashMap<String, gjn> Jyt;
  private static final HashMap<String, gjm> Jyu;
  private static final HashMap<String, Bitmap> Jyv;
  private static WeakReference<c> Jyw;
  private static HashMap<String, kotlin.g.a.a<kotlin.ah>> Jyx;
  
  static
  {
    AppMethodBeat.i(311804);
    Jyo = new g();
    StringBuilder localStringBuilder = new StringBuilder();
    l locall = l.JyV;
    localStringBuilder = localStringBuilder.append(l.fOC()).append("/emoji");
    locall = l.JyV;
    Jyp = l.fOI();
    Jyq = new ArrayList();
    Jyr = new ArrayList();
    Jys = new HashMap();
    Jyt = new HashMap();
    Jyu = new HashMap();
    Jyv = new HashMap();
    Jyx = new HashMap();
    aIC("emoji");
    aIC("kaoemoji");
    AppMethodBeat.o(311804);
  }
  
  /* Error */
  public static gjn K(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 181
    //   2: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ldc 182
    //   8: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc 189
    //   14: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   17: aload_2
    //   18: ldc 190
    //   20: invokestatic 188	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   23: aload_2
    //   24: ldc 192
    //   26: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   29: ifeq +36 -> 65
    //   32: new 200	com/tencent/mm/protocal/protobuf/gjn
    //   35: dup
    //   36: invokespecial 201	com/tencent/mm/protocal/protobuf/gjn:<init>	()V
    //   39: astore_0
    //   40: aload_0
    //   41: getfield 205	com/tencent/mm/protocal/protobuf/gjn:Trs	Ljava/util/LinkedList;
    //   44: aload_1
    //   45: invokestatic 209	com/tencent/mm/plugin/hld/f/g:aIB	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/gjn;
    //   48: getfield 205	com/tencent/mm/protocal/protobuf/gjn:Trs	Ljava/util/LinkedList;
    //   51: checkcast 211	java/util/Collection
    //   54: invokevirtual 217	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   57: pop
    //   58: ldc 181
    //   60: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aload_0
    //   64: areturn
    //   65: aload_1
    //   66: aload_2
    //   67: invokestatic 221	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   70: astore_3
    //   71: getstatic 162	com/tencent/mm/plugin/hld/f/g:Jyt	Ljava/util/HashMap;
    //   74: aload_3
    //   75: invokevirtual 225	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   78: ifnull +33 -> 111
    //   81: getstatic 162	com/tencent/mm/plugin/hld/f/g:Jyt	Ljava/util/HashMap;
    //   84: aload_3
    //   85: invokevirtual 225	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   88: astore_0
    //   89: aload_0
    //   90: invokestatic 229	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   93: aload_0
    //   94: ldc 231
    //   96: invokestatic 234	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   99: aload_0
    //   100: checkcast 200	com/tencent/mm/protocal/protobuf/gjn
    //   103: astore_0
    //   104: ldc 181
    //   106: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: areturn
    //   111: aload_1
    //   112: ldc 170
    //   114: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   117: ifeq +249 -> 366
    //   120: ldc 236
    //   122: astore_3
    //   123: aload_0
    //   124: invokevirtual 242	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   127: new 123	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   134: aload_3
    //   135: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload_2
    //   139: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc 244
    //   144: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 250	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   153: astore_0
    //   154: aload_0
    //   155: ldc 252
    //   157: invokestatic 234	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   160: new 254	java/io/BufferedReader
    //   163: dup
    //   164: new 256	java/io/InputStreamReader
    //   167: dup
    //   168: aload_0
    //   169: invokespecial 259	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   172: checkcast 261	java/io/Reader
    //   175: invokespecial 264	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   178: astore_3
    //   179: new 200	com/tencent/mm/protocal/protobuf/gjn
    //   182: dup
    //   183: invokespecial 201	com/tencent/mm/protocal/protobuf/gjn:<init>	()V
    //   186: astore_0
    //   187: aload_3
    //   188: invokevirtual 267	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   191: astore 5
    //   193: aload 5
    //   195: ifnull +289 -> 484
    //   198: aload 5
    //   200: ifnull -13 -> 187
    //   203: new 269	com/tencent/mm/protocal/protobuf/gjm
    //   206: dup
    //   207: invokespecial 270	com/tencent/mm/protocal/protobuf/gjm:<init>	()V
    //   210: astore 4
    //   212: aload_1
    //   213: ldc 170
    //   215: invokestatic 274	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   218: ifeq +247 -> 465
    //   221: aload 5
    //   223: checkcast 276	java/lang/CharSequence
    //   226: iconst_1
    //   227: anewarray 278	java/lang/String
    //   230: dup
    //   231: iconst_0
    //   232: ldc_w 280
    //   235: aastore
    //   236: invokestatic 285	kotlin/n/n:b	(Ljava/lang/CharSequence;[Ljava/lang/String;)Ljava/util/List;
    //   239: astore 7
    //   241: new 123	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   248: astore 6
    //   250: aload 7
    //   252: invokeinterface 291 1 0
    //   257: astore 7
    //   259: aload 7
    //   261: invokeinterface 297 1 0
    //   266: ifeq +107 -> 373
    //   269: aload 6
    //   271: aload 7
    //   273: invokeinterface 301 1 0
    //   278: checkcast 278	java/lang/String
    //   281: bipush 16
    //   283: invokestatic 307	kotlin/n/a:aMy	(I)I
    //   286: invokestatic 313	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   289: invokestatic 319	java/lang/Character:toChars	(I)[C
    //   292: invokevirtual 322	java/lang/StringBuilder:append	([C)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: goto -37 -> 259
    //   299: astore 4
    //   301: ldc_w 324
    //   304: new 123	java/lang/StringBuilder
    //   307: dup
    //   308: ldc_w 326
    //   311: invokespecial 328	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   314: aload_2
    //   315: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: bipush 32
    //   320: invokevirtual 331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   323: aload 4
    //   325: invokevirtual 334	java/io/IOException:getMessage	()Ljava/lang/String;
    //   328: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_3
    //   338: invokevirtual 346	java/io/BufferedReader:close	()V
    //   341: getstatic 162	com/tencent/mm/plugin/hld/f/g:Jyt	Ljava/util/HashMap;
    //   344: checkcast 348	java/util/Map
    //   347: aload_1
    //   348: aload_2
    //   349: invokestatic 221	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   352: aload_0
    //   353: invokeinterface 352 3 0
    //   358: pop
    //   359: ldc 181
    //   361: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   364: aload_0
    //   365: areturn
    //   366: ldc_w 354
    //   369: astore_3
    //   370: goto -247 -> 123
    //   373: aload 4
    //   375: aload 6
    //   377: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: putfield 357	com/tencent/mm/protocal/protobuf/gjm:content	Ljava/lang/String;
    //   383: aload 4
    //   385: aload 5
    //   387: putfield 360	com/tencent/mm/protocal/protobuf/gjm:Trr	Ljava/lang/String;
    //   390: getstatic 164	com/tencent/mm/plugin/hld/f/g:Jyu	Ljava/util/HashMap;
    //   393: checkcast 348	java/util/Map
    //   396: astore 5
    //   398: aload 4
    //   400: getfield 357	com/tencent/mm/protocal/protobuf/gjm:content	Ljava/lang/String;
    //   403: astore 6
    //   405: aload 6
    //   407: ldc_w 362
    //   410: invokestatic 234	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   413: aload 6
    //   415: invokevirtual 365	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   418: astore 6
    //   420: aload 6
    //   422: ldc_w 367
    //   425: invokestatic 234	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   428: aload 5
    //   430: aload 6
    //   432: aload 4
    //   434: invokeinterface 352 3 0
    //   439: pop
    //   440: aload_0
    //   441: getfield 205	com/tencent/mm/protocal/protobuf/gjn:Trs	Ljava/util/LinkedList;
    //   444: aload 4
    //   446: invokevirtual 371	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   449: pop
    //   450: goto -263 -> 187
    //   453: astore_0
    //   454: aload_3
    //   455: invokevirtual 346	java/io/BufferedReader:close	()V
    //   458: ldc 181
    //   460: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   463: aload_0
    //   464: athrow
    //   465: aload_1
    //   466: ldc 175
    //   468: invokestatic 274	kotlin/g/b/s:p	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   471: ifeq -31 -> 440
    //   474: aload 4
    //   476: aload 5
    //   478: putfield 357	com/tencent/mm/protocal/protobuf/gjm:content	Ljava/lang/String;
    //   481: goto -41 -> 440
    //   484: aload_3
    //   485: invokevirtual 346	java/io/BufferedReader:close	()V
    //   488: goto -147 -> 341
    //   491: astore_3
    //   492: ldc_w 324
    //   495: new 123	java/lang/StringBuilder
    //   498: dup
    //   499: ldc_w 326
    //   502: invokespecial 328	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   505: aload_2
    //   506: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: bipush 32
    //   511: invokevirtual 331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   514: aload_3
    //   515: invokevirtual 334	java/io/IOException:getMessage	()Ljava/lang/String;
    //   518: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   527: goto -186 -> 341
    //   530: astore_3
    //   531: ldc_w 324
    //   534: new 123	java/lang/StringBuilder
    //   537: dup
    //   538: ldc_w 326
    //   541: invokespecial 328	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   544: aload_2
    //   545: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: bipush 32
    //   550: invokevirtual 331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   553: aload_3
    //   554: invokevirtual 334	java/io/IOException:getMessage	()Ljava/lang/String;
    //   557: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   560: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   563: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   566: goto -225 -> 341
    //   569: astore_1
    //   570: ldc_w 324
    //   573: new 123	java/lang/StringBuilder
    //   576: dup
    //   577: ldc_w 326
    //   580: invokespecial 328	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: aload_2
    //   584: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: bipush 32
    //   589: invokevirtual 331	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   592: aload_1
    //   593: invokevirtual 334	java/io/IOException:getMessage	()Ljava/lang/String;
    //   596: invokevirtual 337	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 343	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: goto -147 -> 458
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	608	0	paramContext	Context
    //   0	608	1	paramString1	String
    //   0	608	2	paramString2	String
    //   70	415	3	localObject1	Object
    //   491	24	3	localIOException1	java.io.IOException
    //   530	24	3	localIOException2	java.io.IOException
    //   210	1	4	localgjm	gjm
    //   299	176	4	localIOException3	java.io.IOException
    //   191	286	5	localObject2	Object
    //   248	183	6	localObject3	Object
    //   239	33	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   187	193	299	java/io/IOException
    //   203	259	299	java/io/IOException
    //   259	296	299	java/io/IOException
    //   373	440	299	java/io/IOException
    //   440	450	299	java/io/IOException
    //   465	481	299	java/io/IOException
    //   187	193	453	finally
    //   203	259	453	finally
    //   259	296	453	finally
    //   301	337	453	finally
    //   373	440	453	finally
    //   440	450	453	finally
    //   465	481	453	finally
    //   484	488	491	java/io/IOException
    //   337	341	530	java/io/IOException
    //   454	458	569	java/io/IOException
  }
  
  public static String YF(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "recent";
    case 1: 
      return "emotion";
    case 2: 
      return "limbs";
    case 3: 
      return "person";
    case 4: 
      return "animal";
    case 5: 
      return "botany";
    case 6: 
      return "nature";
    case 7: 
      return "food";
    case 8: 
      return "place";
    case 9: 
      return "traffic";
    case 10: 
      return "exercise";
    case 11: 
      return "goods";
    case 12: 
      return "symbol";
    }
    return "flag";
  }
  
  public static String YG(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "recent";
    case 1: 
      return "happy";
    case 2: 
      return "acting_cute";
    case 3: 
      return "anger";
    case 4: 
      return "sad";
    case 5: 
      return "speechless";
    }
    return "amazed";
  }
  
  public static void a(c paramc)
  {
    AppMethodBeat.i(311562);
    s.u(paramc, "listener");
    Jyw = new WeakReference(paramc);
    AppMethodBeat.o(311562);
  }
  
  public static void a(String paramString, gjm paramgjm)
  {
    AppMethodBeat.i(311749);
    s.u(paramString, "emojiType");
    if (paramgjm == null)
    {
      AppMethodBeat.o(311749);
      return;
    }
    gjn localgjn = aIB(paramString);
    Object localObject = localgjn.Trs;
    s.s(localObject, "recentEmojiList.emojiDataList");
    localObject = ((List)localObject).iterator();
    int i = 0;
    if (((Iterator)localObject).hasNext()) {
      if (!s.p(((gjm)((Iterator)localObject).next()).content, paramgjm.content)) {}
    }
    for (;;)
    {
      if ((i >= 0) && (i < localgjn.Trs.size())) {
        localgjn.Trs.remove(i);
      }
      localgjn.Trs.add(0, paramgjm);
      if (localgjn.Trs.size() > 10) {
        localgjn.Trs.remove(localgjn.Trs.size() - 1);
      }
      a(paramString, localgjn);
      AppMethodBeat.o(311749);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  private static void a(String paramString, gjn paramgjn)
  {
    AppMethodBeat.i(311776);
    Object localObject = (kotlin.g.a.a)Jyx.get(paramString);
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    localObject = paramgjn.toByteArray();
    y.bDX(Jyp);
    y.f(Jyp + paramString + ".proto", (byte[])localObject, localObject.length);
    Log.i("WxIme.WxImeEmojiUtil", "saveHistory: " + paramString + ' ' + paramgjn.Trs.size());
    AppMethodBeat.o(311776);
  }
  
  public static void aIA(String paramString)
  {
    AppMethodBeat.i(311714);
    s.u(paramString, "emojiType");
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putString("emoji_last_type", paramString);
      }
    }
    AppMethodBeat.o(311714);
  }
  
  public static gjn aIB(String paramString)
  {
    AppMethodBeat.i(311723);
    s.u(paramString, "emojiType");
    paramString = (gjn)Jys.get(paramString);
    if (paramString == null)
    {
      paramString = new gjn();
      AppMethodBeat.o(311723);
      return paramString;
    }
    AppMethodBeat.o(311723);
    return paramString;
  }
  
  private static void aIC(String paramString)
  {
    int j = 1;
    AppMethodBeat.i(311768);
    byte[] arrayOfByte = y.bi(Jyp + paramString + ".proto", 0, -1);
    gjn localgjn = new gjn();
    if (arrayOfByte != null)
    {
      int i;
      if (arrayOfByte.length == 0) {
        i = 1;
      }
      for (;;)
      {
        if (i == 0)
        {
          i = j;
          if (i == 0) {}
        }
        else
        {
          try
          {
            localgjn.parseFrom(arrayOfByte);
            Jys.put(paramString, localgjn);
            Log.i("WxIme.WxImeEmojiUtil", "parseHistory: " + paramString + ' ' + localgjn.Trs.size());
            AppMethodBeat.o(311768);
            return;
            i = 0;
            continue;
            i = 0;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Log.printErrStackTrace("WxIme.WxImeEmojiUtil", (Throwable)localException, "", new Object[0]);
            }
          }
        }
      }
    }
    Jys.put(paramString, localgjn);
    AppMethodBeat.o(311768);
  }
  
  private static final void aID(String paramString)
  {
    AppMethodBeat.i(311796);
    s.u(paramString, "$cdd");
    Object localObject2 = b.c(MMApplicationContext.getContext(), (CharSequence)paramString, 20.0F);
    Object localObject1;
    if ((localObject2 instanceof Spanned)) {
      localObject1 = (Spanned)localObject2;
    }
    while (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.smiley.k[])((Spanned)localObject1).getSpans(0, ((CharSequence)localObject2).length(), com.tencent.mm.smiley.k.class);
      if (localObject1 != null)
      {
        localObject2 = MMApplicationContext.getContext();
        s.s(localObject2, "getContext()");
        localObject2 = ((Iterable)ip((Context)localObject2)).iterator();
        Object localObject3;
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (com.tencent.mm.plugin.hld.emoji.k)((Iterator)localObject2).next();
            if (!s.p(((com.tencent.mm.plugin.hld.emoji.k)localObject3).typeName, "recent"))
            {
              Context localContext = MMApplicationContext.getContext();
              s.s(localContext, "getContext()");
              K(localContext, "emoji", ((com.tencent.mm.plugin.hld.emoji.k)localObject3).typeName);
              continue;
              localObject1 = null;
              break;
            }
          }
        }
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          localObject3 = localObject1[i];
          localObject2 = Jyu;
          localObject3 = paramString.subSequence(((com.tencent.mm.smiley.k)localObject3).start, ((com.tencent.mm.smiley.k)localObject3).end).toString();
          if (localObject3 == null)
          {
            paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(311796);
            throw paramString;
          }
          localObject3 = ((String)localObject3).toLowerCase();
          s.s(localObject3, "(this as java.lang.String).toLowerCase()");
          localObject2 = (gjm)((HashMap)localObject2).get(localObject3);
          if (localObject2 != null)
          {
            localObject3 = Jyw;
            if (localObject3 != null)
            {
              localObject3 = (c)((WeakReference)localObject3).get();
              if (localObject3 != null) {
                h.ahAA.bk(new g..ExternalSyntheticLambda0((c)localObject3));
              }
            }
            a("emoji", (gjm)localObject2);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(311796);
  }
  
  public static String aIz(String paramString)
  {
    AppMethodBeat.i(311681);
    s.u(paramString, "emojiType");
    if (s.p(paramString, "emoji")) {}
    Object localObject;
    for (String str = "emotion";; str = "happy")
    {
      localObject = l.JyV;
      localObject = l.getKV();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(311681);
      return str;
    }
    paramString = ((MultiProcessMMKV)localObject).getString(paramString, str);
    if (paramString == null)
    {
      AppMethodBeat.o(311681);
      return str;
    }
    AppMethodBeat.o(311681);
    return paramString;
  }
  
  public static Bitmap b(gjm paramgjm)
  {
    AppMethodBeat.i(311591);
    s.u(paramgjm, "emojiData");
    if (Jyv.containsKey(paramgjm.Trr))
    {
      paramgjm = (Bitmap)Jyv.get(paramgjm.Trr);
      AppMethodBeat.o(311591);
      return paramgjm;
    }
    try
    {
      s.u(paramgjm, "emojiData");
      localObject1 = new StringBuilder();
      localObject2 = l.JyV;
      localObject1 = ((StringBuilder)localObject1).append(l.fOF()).append('/');
      localObject2 = paramgjm.Trr;
      s.s(localObject2, "emojiData.oriContent");
      localObject2 = n.bV((String)localObject2, " ", "_");
      if (localObject2 == null)
      {
        paramgjm = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(311591);
        throw paramgjm;
      }
    }
    catch (Exception paramgjm)
    {
      Log.e("WxIme.WxImeEmojiUtil", s.X("getEmojiBitmap ", paramgjm.getMessage()));
      AppMethodBeat.o(311591);
      return null;
    }
    Object localObject2 = ((String)localObject2).toLowerCase();
    s.s(localObject2, "(this as java.lang.String).toLowerCase()");
    Object localObject1 = (String)localObject2 + ".wxam";
    Log.d("WxIme.WxImeEmojiUtil", s.X("imgPath:", localObject1));
    if (y.ZC((String)localObject1))
    {
      localObject1 = MMGIFJNIFactory.Companion.decodeThumb(y.bi((String)localObject1, 0, -1));
      localObject2 = (Map)Jyv;
      paramgjm = paramgjm.Trr;
      s.s(paramgjm, "emojiData.oriContent");
      ((Map)localObject2).put(paramgjm, localObject1);
    }
    for (paramgjm = (gjm)localObject1;; paramgjm = null)
    {
      AppMethodBeat.o(311591);
      return paramgjm;
    }
  }
  
  private static final void b(c paramc)
  {
    AppMethodBeat.i(311786);
    s.u(paramc, "$listener");
    paramc.fLj();
    AppMethodBeat.o(311786);
  }
  
  public static ArrayList<com.tencent.mm.plugin.hld.emoji.k> bg(Context paramContext, String paramString)
  {
    AppMethodBeat.i(311645);
    s.u(paramContext, "context");
    s.u(paramString, "typeName");
    if (s.p(paramString, "emoji"))
    {
      paramContext = ip(paramContext);
      AppMethodBeat.o(311645);
      return paramContext;
    }
    if (s.p(paramString, "kaoemoji"))
    {
      if (!((Collection)Jyr).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramContext = Jyr;
        AppMethodBeat.o(311645);
        return paramContext;
      }
      paramString = Jyr;
      String str = paramContext.getString(a.j.ime_kaoemoji_subtype_recent);
      s.s(str, "context.getString(R.stri…_kaoemoji_subtype_recent)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "recent"));
      paramString = Jyr;
      str = paramContext.getString(a.j.ime_kaoemoji_subtype_happy);
      s.s(str, "context.getString(R.stri…e_kaoemoji_subtype_happy)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "happy"));
      paramString = Jyr;
      str = paramContext.getString(a.j.ime_kaoemoji_subtype_acting_cute);
      s.s(str, "context.getString(R.stri…moji_subtype_acting_cute)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "acting_cute"));
      paramString = Jyr;
      str = paramContext.getString(a.j.ime_kaoemoji_subtype_anger);
      s.s(str, "context.getString(R.stri…e_kaoemoji_subtype_anger)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "anger"));
      paramString = Jyr;
      str = paramContext.getString(a.j.ime_kaoemoji_subtype_sad);
      s.s(str, "context.getString(R.stri…ime_kaoemoji_subtype_sad)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "sad"));
      paramString = Jyr;
      str = paramContext.getString(a.j.ime_kaoemoji_subtype_speechless);
      s.s(str, "context.getString(R.stri…emoji_subtype_speechless)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(str, "speechless"));
      paramString = Jyr;
      paramContext = paramContext.getString(a.j.ime_kaoemoji_subtype_amazed);
      s.s(paramContext, "context.getString(R.stri…_kaoemoji_subtype_amazed)");
      paramString.add(new com.tencent.mm.plugin.hld.emoji.k(paramContext, "amazed"));
      paramContext = Jyr;
      AppMethodBeat.o(311645);
      return paramContext;
    }
    paramContext = new ArrayList();
    AppMethodBeat.o(311645);
    return paramContext;
  }
  
  public static void clear(String paramString)
  {
    AppMethodBeat.i(311757);
    gjn localgjn = aIB(paramString);
    localgjn.Trs.clear();
    a(paramString, localgjn);
    AppMethodBeat.o(311757);
  }
  
  public static HashMap<String, kotlin.g.a.a<kotlin.ah>> fOl()
  {
    return Jyx;
  }
  
  public static void fOm()
  {
    AppMethodBeat.i(311577);
    Object localObject = l.JyV;
    u localu = new u(l.fOF());
    localObject = localu.jKX();
    if (localObject == null) {}
    for (int i = 0; i > 0; i = localObject.length)
    {
      Log.i("WxIme.WxImeEmojiUtil", "has emoji img!");
      AppMethodBeat.o(311577);
      return;
    }
    for (;;)
    {
      try
      {
        localObject = l.JyV;
        s.u("ime_emoji.zip", "name");
        localObject = com.tencent.mm.plugin.hld.c.a.JoL;
        localObject = com.tencent.mm.plugin.hld.c.a.fLa().iterator();
        if (((Iterator)localObject).hasNext())
        {
          dbp localdbp = (dbp)((Iterator)localObject).next();
          if (!Util.isEqual(localdbp.name, "ime_emoji.zip")) {
            continue;
          }
          if (l.m(localdbp))
          {
            localObject = localdbp.path;
            s.s(localObject, "dict.path");
            i = t.a(new ZipInputStream(y.Lh((String)localObject)), com.tencent.mm.vfs.ah.v(localu.jKT()));
            Log.i("WxIme.WxImeEmojiUtil", "unzip file from assets, path:" + (String)localObject + " result:" + i);
            AppMethodBeat.o(311577);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("WxIme.WxImeEmojiUtil", s.X("unZipEmojiFile ", localException.getMessage()));
        AppMethodBeat.o(311577);
        return;
      }
      String str = "";
    }
  }
  
  public static String fOn()
  {
    AppMethodBeat.i(311706);
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject == null)
    {
      AppMethodBeat.o(311706);
      return "emoji";
    }
    localObject = ((MultiProcessMMKV)localObject).getString("emoji_last_type", "emoji");
    if (localObject == null)
    {
      AppMethodBeat.o(311706);
      return "emoji";
    }
    AppMethodBeat.o(311706);
    return localObject;
  }
  
  private static ArrayList<com.tencent.mm.plugin.hld.emoji.k> ip(Context paramContext)
  {
    AppMethodBeat.i(311659);
    if (!((Collection)Jyq).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramContext = Jyq;
      AppMethodBeat.o(311659);
      return paramContext;
    }
    Object localObject = l.JyV;
    if (!l.fKH())
    {
      localObject = Jyq;
      str = paramContext.getString(a.j.ime_emoji_subtype_recent);
      s.s(str, "context.getString(R.stri…ime_emoji_subtype_recent)");
      ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "recent"));
    }
    localObject = Jyq;
    String str = paramContext.getString(a.j.ime_emoji_subtype_emotion);
    s.s(str, "context.getString(R.stri…me_emoji_subtype_emotion)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "emotion"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_limbs);
    s.s(str, "context.getString(R.stri….ime_emoji_subtype_limbs)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "limbs"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_person);
    s.s(str, "context.getString(R.stri…ime_emoji_subtype_person)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "person"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_animal);
    s.s(str, "context.getString(R.stri…ime_emoji_subtype_animal)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "animal"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_botany);
    s.s(str, "context.getString(R.stri…ime_emoji_subtype_botany)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "botany"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_nature);
    s.s(str, "context.getString(R.stri…ime_emoji_subtype_nature)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "nature"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_food);
    s.s(str, "context.getString(R.string.ime_emoji_subtype_food)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "food"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_place);
    s.s(str, "context.getString(R.stri….ime_emoji_subtype_place)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "place"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_traffic);
    s.s(str, "context.getString(R.stri…me_emoji_subtype_traffic)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "traffic"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_exercise);
    s.s(str, "context.getString(R.stri…e_emoji_subtype_exercise)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "exercise"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_goods);
    s.s(str, "context.getString(R.stri….ime_emoji_subtype_goods)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "goods"));
    localObject = Jyq;
    str = paramContext.getString(a.j.ime_emoji_subtype_symbol);
    s.s(str, "context.getString(R.stri…ime_emoji_subtype_symbol)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(str, "symbol"));
    localObject = Jyq;
    paramContext = paramContext.getString(a.j.ime_emoji_subtype_flag);
    s.s(paramContext, "context.getString(R.string.ime_emoji_subtype_flag)");
    ((ArrayList)localObject).add(new com.tencent.mm.plugin.hld.emoji.k(paramContext, "flag"));
    paramContext = Jyq;
    AppMethodBeat.o(311659);
    return paramContext;
  }
  
  public static void jA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(311694);
    s.u(paramString1, "emojiType");
    s.u(paramString2, "subType");
    Object localObject = l.JyV;
    localObject = l.getKV();
    if (localObject != null)
    {
      localObject = ((MultiProcessMMKV)localObject).edit();
      if (localObject != null) {
        ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      }
    }
    AppMethodBeat.o(311694);
  }
  
  public static void jB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(311733);
    s.u(paramString1, "emojiType");
    if (!s.p(paramString1, "emoji"))
    {
      AppMethodBeat.o(311733);
      return;
    }
    if (paramString2 != null) {
      h.ahAA.bm(new g..ExternalSyntheticLambda1(paramString2));
    }
    AppMethodBeat.o(311733);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.f.g
 * JD-Core Version:    0.7.0.1
 */