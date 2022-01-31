package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.al;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.d.a;
import com.tencent.mm.plugin.webview.model.d.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class g
{
  private static int mRetryCount = 5;
  private String hwp;
  private LinkedList<String> nlh;
  private boolean nli;
  g.a nlj;
  private Set<String> nlk;
  private Set<String> nll;
  private Set<String> nlm;
  private HashMap<String, String> nln;
  private boolean nlo;
  private boolean nlp;
  private HashMap<String, Long> nlq;
  private Runnable nlr;
  private d.b nls;
  private d.a nlt;
  private int retryCount;
  
  public g(String paramString, int paramInt, LinkedList<String> paramLinkedList, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(151832);
    this.nlh = new LinkedList();
    this.nlk = new HashSet();
    this.nll = new HashSet();
    this.nlm = new HashSet();
    this.nln = new HashMap();
    this.nlo = false;
    this.nlp = false;
    this.nlq = new HashMap();
    this.nlr = new g.1(this);
    this.nls = new g.2(this);
    this.nlt = new g.3(this);
    this.hwp = paramString;
    this.nli = paramBoolean1;
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(151832);
      return;
    }
    if (paramInt == 2) {
      this.nlh.add(paramLinkedList.get(0));
    }
    for (;;)
    {
      if (!paramBoolean2) {
        bFH();
      }
      paramString = com.tencent.mm.plugin.webview.modeltools.g.dcD();
      paramLinkedList = this.nls;
      if ((paramString.uWf != null) && (paramLinkedList != null) && (!paramString.uWf.contains(paramLinkedList))) {
        paramString.uWf.add(paramLinkedList);
      }
      com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this.nlt);
      AppMethodBeat.o(151832);
      return;
      this.nlh.addAll(paramLinkedList);
    }
  }
  
  private boolean ai(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(151836);
    this.nlq.put(paramString, Long.valueOf(System.currentTimeMillis()));
    ab.i("MicroMsg.GameUploadMediaEngine", "uploadMediaFile, localId : %s", new Object[] { paramString });
    a.post(new g.4(this, paramString));
    boolean bool = com.tencent.mm.plugin.webview.modeltools.g.dcD().a("", paramString, paramInt1, paramInt2, 2, null);
    AppMethodBeat.o(151836);
    return bool;
  }
  
  private void bFH()
  {
    AppMethodBeat.i(151833);
    Iterator localIterator = this.nlh.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = com.tencent.mm.plugin.webview.modeltools.g.dcE().ahh((String)localObject);
      if (localObject != null)
      {
        b localb = new b();
        localb.field_localId = ((WebViewJSSDKFileItem)localObject).ctV;
        localb.field_mediaId = ((WebViewJSSDKFileItem)localObject).cBO;
        localb.field_filePath = ((WebViewJSSDKFileItem)localObject).hgj;
        localb.field_thumbPath = ((WebViewJSSDKFileItem)localObject).hII;
        localb.field_mediaType = ((WebViewJSSDKFileItem)localObject).cth;
        localb.field_size = ((WebViewJSSDKFileItem)localObject).size;
        localb.field_width = ((WebViewJSSDKFileItem)localObject).width;
        localb.field_height = ((WebViewJSSDKFileItem)localObject).height;
        if ((localObject instanceof WebViewJSSDKVideoItem)) {
          localb.field_duration = ((WebViewJSSDKVideoItem)localObject).duration;
        }
        if ((localObject instanceof WebViewJSSDKImageItem)) {
          localb.field_isGif = ((WebViewJSSDKImageItem)localObject).uXp;
        }
        if (((WebViewJSSDKFileItem)localObject).cth == 1)
        {
          String str = com.tencent.mm.compatible.util.e.esr + "microMsg.tmp." + System.currentTimeMillis();
          if ((!this.nli) || (!eB(str, ((WebViewJSSDKFileItem)localObject).hgj))) {
            break label289;
          }
          localb.field_compressPath = str;
          ab.i("MicroMsg.GameUploadMediaEngine", "compress, originSize: %d, dstSize: %d", new Object[] { Long.valueOf(com.tencent.mm.vfs.e.avI(((WebViewJSSDKFileItem)localObject).hgj)), Long.valueOf(com.tencent.mm.vfs.e.avI(localb.field_compressPath)) });
          ((WebViewJSSDKFileItem)localObject).hgj = str;
          com.tencent.mm.plugin.webview.modeltools.g.dcE().a((WebViewJSSDKFileItem)localObject);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().insert(localb);
          break;
          label289:
          localb.field_compressPath = ((WebViewJSSDKFileItem)localObject).hgj;
        }
      }
    }
    AppMethodBeat.o(151833);
  }
  
  /* Error */
  private void bFJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 361
    //   5: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 75	com/tencent/mm/plugin/game/media/g:nlp	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 361
    //   18: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   28: aload_0
    //   29: getfield 62	com/tencent/mm/plugin/game/media/g:nlk	Ljava/util/Set;
    //   32: invokeinterface 364 2 0
    //   37: pop
    //   38: ldc 178
    //   40: ldc_w 366
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   53: invokevirtual 367	java/lang/Object:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 73	com/tencent/mm/plugin/game/media/g:nlo	Z
    //   65: aload_0
    //   66: getfield 62	com/tencent/mm/plugin/game/media/g:nlk	Ljava/util/Set;
    //   69: astore_1
    //   70: aload_1
    //   71: monitorenter
    //   72: aload_0
    //   73: getfield 62	com/tencent/mm/plugin/game/media/g:nlk	Ljava/util/Set;
    //   76: invokeinterface 368 1 0
    //   81: astore_2
    //   82: aload_2
    //   83: invokeinterface 216 1 0
    //   88: ifeq +536 -> 624
    //   91: aload_2
    //   92: invokeinterface 220 1 0
    //   97: checkcast 222	java/lang/String
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 75	com/tencent/mm/plugin/game/media/g:nlp	Z
    //   105: ifeq +19 -> 124
    //   108: aload_1
    //   109: monitorexit
    //   110: ldc_w 361
    //   113: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: ldc_w 343
    //   127: invokestatic 349	com/tencent/mm/kernel/g:E	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   130: checkcast 343	com/tencent/mm/plugin/game/api/e
    //   133: invokeinterface 353 1 0
    //   138: aload_3
    //   139: invokevirtual 372	com/tencent/mm/plugin/game/media/c:PX	(Ljava/lang/String;)Lcom/tencent/mm/plugin/game/media/b;
    //   142: astore 4
    //   144: aload 4
    //   146: ifnull +22 -> 168
    //   149: aload 4
    //   151: getfield 243	com/tencent/mm/plugin/game/media/b:field_localId	Ljava/lang/String;
    //   154: ifnull +14 -> 168
    //   157: aload 4
    //   159: getfield 375	com/tencent/mm/plugin/game/media/b:field_mediaUrl	Ljava/lang/String;
    //   162: invokestatic 379	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   165: ifne +44 -> 209
    //   168: ldc 178
    //   170: ldc_w 381
    //   173: iconst_1
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_3
    //   180: aastore
    //   181: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: aload_0
    //   185: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   188: aload_3
    //   189: invokeinterface 384 2 0
    //   194: pop
    //   195: goto -113 -> 82
    //   198: astore_2
    //   199: aload_1
    //   200: monitorexit
    //   201: ldc_w 361
    //   204: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: aload_2
    //   208: athrow
    //   209: invokestatic 226	com/tencent/mm/plugin/webview/modeltools/g:dcE	()Lcom/tencent/mm/plugin/webview/model/am;
    //   212: aload_3
    //   213: invokevirtual 232	com/tencent/mm/plugin/webview/model/am:ahh	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;
    //   216: ifnonnull +137 -> 353
    //   219: aload 4
    //   221: getfield 267	com/tencent/mm/plugin/game/media/b:field_mediaType	I
    //   224: iconst_1
    //   225: if_icmpne +233 -> 458
    //   228: new 296	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem
    //   231: dup
    //   232: invokespecial 385	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem:<init>	()V
    //   235: astore 5
    //   237: aload 5
    //   239: aload 4
    //   241: getfield 243	com/tencent/mm/plugin/game/media/b:field_localId	Ljava/lang/String;
    //   244: putfield 240	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:ctV	Ljava/lang/String;
    //   247: aload 5
    //   249: aload 4
    //   251: getfield 249	com/tencent/mm/plugin/game/media/b:field_mediaId	Ljava/lang/String;
    //   254: putfield 246	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:cBO	Ljava/lang/String;
    //   257: aload_0
    //   258: getfield 98	com/tencent/mm/plugin/game/media/g:nli	Z
    //   261: ifeq +184 -> 445
    //   264: aload 4
    //   266: getfield 330	com/tencent/mm/plugin/game/media/b:field_compressPath	Ljava/lang/String;
    //   269: invokestatic 388	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   272: ifne +173 -> 445
    //   275: new 304	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 305	java/lang/StringBuilder:<init>	()V
    //   282: getstatic 310	com/tencent/mm/compatible/util/e:esr	Ljava/lang/String;
    //   285: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 316
    //   291: invokevirtual 314	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokestatic 166	java/lang/System:currentTimeMillis	()J
    //   297: invokevirtual 319	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 323	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 6
    //   305: aload 6
    //   307: aload 4
    //   309: getfield 255	com/tencent/mm/plugin/game/media/b:field_filePath	Ljava/lang/String;
    //   312: invokestatic 327	com/tencent/mm/plugin/game/media/g:eB	(Ljava/lang/String;Ljava/lang/String;)Z
    //   315: ifeq +117 -> 432
    //   318: aload 4
    //   320: aload 6
    //   322: putfield 330	com/tencent/mm/plugin/game/media/b:field_compressPath	Ljava/lang/String;
    //   325: aload 5
    //   327: aload 4
    //   329: getfield 330	com/tencent/mm/plugin/game/media/b:field_compressPath	Ljava/lang/String;
    //   332: putfield 252	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:hgj	Ljava/lang/String;
    //   335: aload 5
    //   337: aload 4
    //   339: getfield 261	com/tencent/mm/plugin/game/media/b:field_thumbPath	Ljava/lang/String;
    //   342: putfield 258	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:hII	Ljava/lang/String;
    //   345: invokestatic 226	com/tencent/mm/plugin/webview/modeltools/g:dcE	()Lcom/tencent/mm/plugin/webview/model/am;
    //   348: aload 5
    //   350: invokevirtual 341	com/tencent/mm/plugin/webview/model/am:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   353: aload 4
    //   355: getfield 267	com/tencent/mm/plugin/game/media/b:field_mediaType	I
    //   358: tableswitch	default:+298 -> 656, 1:+30->388, 2:+298->656, 3:+298->656, 4:+222->580
    //   389: aload_3
    //   390: getstatic 393	com/tencent/mm/i/a:ecM	I
    //   393: sipush 215
    //   396: invokespecial 395	com/tencent/mm/plugin/game/media/g:ai	(Ljava/lang/String;II)Z
    //   399: ifne -317 -> 82
    //   402: ldc 178
    //   404: ldc_w 397
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload_3
    //   414: aastore
    //   415: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   418: aload_0
    //   419: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   422: aload_3
    //   423: invokeinterface 384 2 0
    //   428: pop
    //   429: goto -347 -> 82
    //   432: aload 4
    //   434: aload 4
    //   436: getfield 255	com/tencent/mm/plugin/game/media/b:field_filePath	Ljava/lang/String;
    //   439: putfield 330	com/tencent/mm/plugin/game/media/b:field_compressPath	Ljava/lang/String;
    //   442: goto -117 -> 325
    //   445: aload 5
    //   447: aload 4
    //   449: getfield 255	com/tencent/mm/plugin/game/media/b:field_filePath	Ljava/lang/String;
    //   452: putfield 252	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:hgj	Ljava/lang/String;
    //   455: goto -120 -> 335
    //   458: aload 4
    //   460: getfield 267	com/tencent/mm/plugin/game/media/b:field_mediaType	I
    //   463: iconst_4
    //   464: if_icmpne -111 -> 353
    //   467: new 288	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   470: dup
    //   471: invokespecial 398	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:<init>	()V
    //   474: astore 5
    //   476: aload 5
    //   478: aload 4
    //   480: getfield 243	com/tencent/mm/plugin/game/media/b:field_localId	Ljava/lang/String;
    //   483: putfield 240	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:ctV	Ljava/lang/String;
    //   486: aload 5
    //   488: aload 4
    //   490: getfield 249	com/tencent/mm/plugin/game/media/b:field_mediaId	Ljava/lang/String;
    //   493: putfield 246	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:cBO	Ljava/lang/String;
    //   496: aload 5
    //   498: aload 4
    //   500: getfield 255	com/tencent/mm/plugin/game/media/b:field_filePath	Ljava/lang/String;
    //   503: putfield 252	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:hgj	Ljava/lang/String;
    //   506: aload 5
    //   508: aload 4
    //   510: getfield 261	com/tencent/mm/plugin/game/media/b:field_thumbPath	Ljava/lang/String;
    //   513: putfield 258	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:hII	Ljava/lang/String;
    //   516: aload 5
    //   518: checkcast 288	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   521: aload 4
    //   523: getfield 294	com/tencent/mm/plugin/game/media/b:field_duration	I
    //   526: putfield 291	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:duration	I
    //   529: aload 5
    //   531: checkcast 288	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   534: aload 4
    //   536: getfield 280	com/tencent/mm/plugin/game/media/b:field_width	I
    //   539: putfield 399	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:width	I
    //   542: aload 5
    //   544: checkcast 288	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   547: aload 4
    //   549: getfield 286	com/tencent/mm/plugin/game/media/b:field_height	I
    //   552: putfield 400	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:height	I
    //   555: aload 5
    //   557: checkcast 288	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   560: aload 4
    //   562: getfield 274	com/tencent/mm/plugin/game/media/b:field_size	J
    //   565: l2i
    //   566: putfield 401	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:size	I
    //   569: invokestatic 226	com/tencent/mm/plugin/webview/modeltools/g:dcE	()Lcom/tencent/mm/plugin/webview/model/am;
    //   572: aload 5
    //   574: invokevirtual 341	com/tencent/mm/plugin/webview/model/am:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   577: goto -224 -> 353
    //   580: aload_0
    //   581: aload_3
    //   582: getstatic 404	com/tencent/mm/i/a:ecN	I
    //   585: sipush 214
    //   588: invokespecial 395	com/tencent/mm/plugin/game/media/g:ai	(Ljava/lang/String;II)Z
    //   591: ifne -509 -> 82
    //   594: ldc 178
    //   596: ldc_w 397
    //   599: iconst_1
    //   600: anewarray 4	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: aload_3
    //   606: aastore
    //   607: invokestatic 185	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload_0
    //   611: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   614: aload_3
    //   615: invokeinterface 384 2 0
    //   620: pop
    //   621: goto -539 -> 82
    //   624: aload_0
    //   625: iconst_1
    //   626: putfield 73	com/tencent/mm/plugin/game/media/g:nlo	Z
    //   629: aload_1
    //   630: monitorexit
    //   631: aload_0
    //   632: getfield 64	com/tencent/mm/plugin/game/media/g:nll	Ljava/util/Set;
    //   635: invokeinterface 407 1 0
    //   640: ifeq +7 -> 647
    //   643: aload_0
    //   644: invokespecial 410	com/tencent/mm/plugin/game/media/g:bFL	()V
    //   647: ldc_w 361
    //   650: invokestatic 107	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: goto -632 -> 21
    //   656: goto -574 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	g
    //   119	511	1	localObject1	Object
    //   81	11	2	localIterator	Iterator
    //   198	10	2	localObject2	Object
    //   100	515	3	str1	String
    //   142	419	4	localb	b
    //   235	338	5	localObject3	Object
    //   303	18	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	119	finally
    //   24	72	119	finally
    //   110	116	119	finally
    //   201	209	119	finally
    //   631	647	119	finally
    //   647	653	119	finally
    //   72	82	198	finally
    //   82	110	198	finally
    //   124	144	198	finally
    //   149	168	198	finally
    //   168	195	198	finally
    //   199	201	198	finally
    //   209	325	198	finally
    //   325	335	198	finally
    //   335	353	198	finally
    //   353	388	198	finally
    //   388	429	198	finally
    //   432	442	198	finally
    //   445	455	198	finally
    //   458	577	198	finally
    //   580	621	198	finally
    //   624	631	198	finally
  }
  
  private void bFL()
  {
    AppMethodBeat.i(151839);
    if (this.nlj != null) {
      this.nlj.id(true);
    }
    AppMethodBeat.o(151839);
  }
  
  private static boolean eB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(151840);
    if (r.aoY(paramString2))
    {
      AppMethodBeat.o(151840);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.plugin.appbrand.t.c.g(paramString1, paramString2, 1440, 1080);
      AppMethodBeat.o(151840);
      return bool;
    }
    catch (Exception paramString1)
    {
      ab.printErrStackTrace("MicroMsg.GameUploadMediaEngine", paramString1, "", new Object[0]);
      AppMethodBeat.o(151840);
    }
    return false;
  }
  
  public final void bFI()
  {
    try
    {
      AppMethodBeat.i(151834);
      mRetryCount = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.game.report.a.b.class)).a(a.a.lRU);
      this.nlk.clear();
      this.nlk.addAll(this.nlh);
      bFJ();
      AppMethodBeat.o(151834);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bFK()
  {
    AppMethodBeat.i(151837);
    this.nlp = true;
    Iterator localIterator = this.nlh.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.webview.modeltools.g.dcD();
      al.zE(str);
    }
    ((com.tencent.mm.plugin.game.api.e)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.game.api.e.class)).bEW().Y(this.nlh);
    reset();
    AppMethodBeat.o(151837);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(151838);
    com.tencent.mm.plugin.webview.modeltools.g.dcD().a(this.nls);
    com.tencent.mm.plugin.webview.modeltools.g.dcD().b(this.nlt);
    this.nlk.clear();
    this.nlm.clear();
    this.nll.clear();
    this.nlh.clear();
    this.nlj = null;
    AppMethodBeat.o(151838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.g
 * JD-Core Version:    0.7.0.1
 */