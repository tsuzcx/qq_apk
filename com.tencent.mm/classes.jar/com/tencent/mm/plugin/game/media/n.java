package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.api.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.vfs.o;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static int mRetryCount;
  private static final String ujt;
  private String iIu;
  private int retryCount;
  private HashMap<String, String> ujA;
  private boolean ujB;
  private boolean ujC;
  private HashMap<String, Long> ujD;
  private Runnable ujE;
  private f.b ujF;
  private f.a ujG;
  private LinkedList<String> uju;
  private boolean ujv;
  a ujw;
  private Set<String> ujx;
  private Set<String> ujy;
  private Set<String> ujz;
  
  static
  {
    AppMethodBeat.i(41119);
    ujt = com.tencent.mm.plugin.game.commlib.util.b.c(com.tencent.mm.plugin.game.commlib.util.b.a.udV) + "haowan/";
    mRetryCount = 5;
    AppMethodBeat.o(41119);
  }
  
  public n(String paramString, int paramInt, LinkedList<String> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(41106);
    this.uju = new LinkedList();
    this.ujx = new HashSet();
    this.ujy = new HashSet();
    this.ujz = new HashSet();
    this.ujA = new HashMap();
    this.ujB = false;
    this.ujC = false;
    this.ujD = new HashMap();
    this.ujE = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41101);
        if (n.a(n.this))
        {
          AppMethodBeat.o(41101);
          return;
        }
        n.b(n.this);
        if (n.c(n.this) <= n.mRetryCount)
        {
          n.d(n.this).clear();
          n.d(n.this).addAll(n.e(n.this));
          n.e(n.this).clear();
          n.f(n.this);
          AppMethodBeat.o(41101);
          return;
        }
        ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "retry count bigger than 5");
        n.g(n.this);
        AppMethodBeat.o(41101);
      }
    };
    this.ujF = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt, final String paramAnonymousString1, String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4)
      {
        AppMethodBeat.i(41103);
        if (!n.h(n.this).contains(paramAnonymousString1))
        {
          ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramAnonymousString1 });
          AppMethodBeat.o(41103);
          return;
        }
        n.h(n.this).remove(paramAnonymousString1);
        final long l = System.currentTimeMillis() - bu.a((Long)n.i(n.this).remove(paramAnonymousString1), System.currentTimeMillis());
        ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Long.valueOf(l) });
        if (n.a(n.this))
        {
          ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, has cancel");
          AppMethodBeat.o(41103);
          return;
        }
        com.tencent.mm.ch.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41102);
            Object localObject = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp().amG(paramAnonymousString1);
            HashMap localHashMap = new HashMap();
            if (localObject != null)
            {
              localHashMap.put("type", Integer.valueOf(n.Ig(((c)localObject).field_mediaType)));
              if (n.Ig(((c)localObject).field_mediaType) == 2) {
                localHashMap.put("videoid", o.aRh(((c)localObject).field_filePath));
              }
            }
            localHashMap.put("costtime", Long.valueOf(l));
            localHashMap.put("origtime", Integer.valueOf(((c)localObject).field_duration));
            localHashMap.put("origsize", Long.valueOf(((c)localObject).field_size));
            localObject = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZo().amI(n.j(n.this));
            if (localObject != null) {
              localHashMap.put("pushid", ((e)localObject).field_taskId);
            }
            for (int i = ((e)localObject).field_publishSource;; i = 0)
            {
              if (paramAnonymousString3)
              {
                n.e(n.this).remove(paramAnonymousString1);
                localObject = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp();
                String str = paramAnonymousString1;
                str = String.format("update %s set %s=\"%s\", %s=\"%s\", %s=%d where %s=\"%s\"", new Object[] { "GameHaowanMedia", "mediaUrl", paramAnonymousString4, "thumbPicUrl", paramAnonymousInt, "uploadState", Integer.valueOf(2), "localId", str });
                ae.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMediaUrl, sql: ".concat(String.valueOf(str)));
                ((d)localObject).execSQL("GameHaowanMedia", str);
                com.tencent.mm.game.report.b.a.a(ak.getContext(), 8764, 0, 48, com.tencent.mm.game.report.b.a.b(i, localHashMap));
              }
              for (;;)
              {
                ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload list size : %d, hasPushAllUpload: %b", new Object[] { Integer.valueOf(n.h(n.this).size()), Boolean.valueOf(n.k(n.this)) });
                if ((!n.h(n.this).isEmpty()) || (!n.k(n.this))) {
                  break label537;
                }
                if (n.e(n.this).isEmpty()) {
                  break;
                }
                h.MqF.r(n.l(n.this), 60000L);
                AppMethodBeat.o(41102);
                return;
                if (this.val$errCode != -21006)
                {
                  n.e(n.this).add(paramAnonymousString1);
                  localHashMap.put("failid", Integer.valueOf(this.val$errCode));
                  com.tencent.mm.game.report.b.a.a(ak.getContext(), 8764, 0, 56, com.tencent.mm.game.report.b.a.b(i, localHashMap));
                }
              }
              n.m(n.this);
              label537:
              AppMethodBeat.o(41102);
              return;
            }
          }
        });
        AppMethodBeat.o(41103);
      }
    };
    this.ujG = new f.a()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41104);
        if (!n.h(n.this).contains(paramAnonymousString1))
        {
          ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramAnonymousString1 });
          AppMethodBeat.o(41104);
          return;
        }
        paramAnonymousInt1 = n.n(n.this).size();
        int i = n.h(n.this).size() + n.e(n.this).size();
        float f = 0.95F * ((paramAnonymousInt1 - i) / paramAnonymousInt1 + 1.0F / paramAnonymousInt1 * (paramAnonymousInt2 / 100.0F));
        ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "onProgress, localId : %s, percent : %d, initSize : %d, uploadingSize : %d, uploadProgress : %f", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Float.valueOf(f) });
        n.a(n.this, f);
        AppMethodBeat.o(41104);
      }
    };
    this.iIu = paramString;
    this.ujv = paramBoolean;
    if (bu.ht(paramLinkedList))
    {
      AppMethodBeat.o(41106);
      return;
    }
    if (paramInt == 2)
    {
      this.uju.add(paramLinkedList.get(0));
      paramLinkedList = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp();
      if (paramString != null) {
        break label233;
      }
      paramInt = i;
    }
    label233:
    do
    {
      if (paramInt == 0) {
        daO();
      }
      com.tencent.mm.plugin.webview.modeltools.g.eUF().a(this.ujF);
      com.tencent.mm.plugin.webview.modeltools.g.eUF().a(this.ujG);
      AppMethodBeat.o(41106);
      return;
      this.uju.addAll(paramLinkedList);
      break;
      paramString = paramLinkedList.rawQuery(String.format("select * from %s where %s=\"%s\"", new Object[] { "GameHaowanMedia", "hostTaskId", paramString }), new String[0]);
      paramInt = i;
    } while (paramString == null);
    if (paramString.getCount() != 0) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramString.close();
      break;
    }
  }
  
  private boolean al(final String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41110);
    this.ujD.put(paramString, Long.valueOf(System.currentTimeMillis()));
    ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, localId : %s", new Object[] { paramString });
    com.tencent.mm.ch.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41105);
        HashMap localHashMap = new HashMap();
        Object localObject = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp().amG(paramString);
        if (localObject != null)
        {
          localHashMap.put("type", Integer.valueOf(n.Ig(((c)localObject).field_mediaType)));
          if (n.Ig(((c)localObject).field_mediaType) == 2) {
            localHashMap.put("videoid", o.aRh(((c)localObject).field_filePath));
          }
        }
        localObject = ((f)com.tencent.mm.kernel.g.ab(f.class)).cZo().amI(n.j(n.this));
        if (localObject != null) {
          localHashMap.put("pushid", ((e)localObject).field_taskId);
        }
        for (int i = ((e)localObject).field_publishSource;; i = 0)
        {
          com.tencent.mm.game.report.b.a.a(ak.getContext(), 8764, 0, 20, com.tencent.mm.game.report.b.a.b(i, localHashMap));
          AppMethodBeat.o(41105);
          return;
        }
      }
    });
    boolean bool = com.tencent.mm.plugin.webview.modeltools.g.eUF().a("", paramString, paramInt1, paramInt2, 2, null);
    AppMethodBeat.o(41110);
    return bool;
  }
  
  private void daO()
  {
    AppMethodBeat.i(41107);
    Iterator localIterator = this.uju.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.g.eUG().aIN(str);
      if (localWebViewJSSDKFileItem != null)
      {
        c localc = new c();
        localc.field_localId = localWebViewJSSDKFileItem.dsN;
        localc.field_mediaId = localWebViewJSSDKFileItem.mediaId;
        localc.field_filePath = localWebViewJSSDKFileItem.jXT;
        localc.field_thumbPath = localWebViewJSSDKFileItem.kKQ;
        localc.field_mediaType = localWebViewJSSDKFileItem.mediaType;
        localc.field_size = localWebViewJSSDKFileItem.size;
        localc.field_width = localWebViewJSSDKFileItem.width;
        localc.field_height = localWebViewJSSDKFileItem.height;
        localc.field_editFlag = localWebViewJSSDKFileItem.ioY.getInt("mark_edit_flag", 0);
        if ((localWebViewJSSDKFileItem instanceof WebViewJSSDKVideoItem)) {
          localc.field_duration = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).duration;
        }
        if ((localWebViewJSSDKFileItem instanceof WebViewJSSDKImageItem)) {
          localc.field_isGif = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).tUF;
        }
        localc.field_hostTaskId = this.iIu;
        if (localWebViewJSSDKFileItem.mediaType == 1)
        {
          str = ujt + "microMsg.compress." + System.currentTimeMillis() + (bu.nullAsNil(str).hashCode() & 0xFFFF);
          if ((!this.ujv) || (!gY(str, localWebViewJSSDKFileItem.jXT))) {
            break label329;
          }
          localc.field_compressPath = str;
          ae.i("MicroMsg.Haowan.GameUploadMediaEngine", "compress, originSize: %d, dstSize: %d", new Object[] { Long.valueOf(o.aZR(localWebViewJSSDKFileItem.jXT)), Long.valueOf(o.aZR(localc.field_compressPath)) });
          localWebViewJSSDKFileItem.jXT = str;
          com.tencent.mm.plugin.webview.modeltools.g.eUG().a(localWebViewJSSDKFileItem);
        }
        for (;;)
        {
          ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp().insert(localc);
          break;
          label329:
          localc.field_compressPath = localWebViewJSSDKFileItem.jXT;
        }
      }
    }
    AppMethodBeat.o(41107);
  }
  
  /* Error */
  private void daQ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 424
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 118	com/tencent/mm/plugin/game/media/n:ujC	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 424
    //   18: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   28: aload_0
    //   29: getfield 105	com/tencent/mm/plugin/game/media/n:ujx	Ljava/util/Set;
    //   32: invokeinterface 427 2 0
    //   37: pop
    //   38: ldc 244
    //   40: ldc_w 429
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   53: invokevirtual 430	java/lang/Object:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 251	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 116	com/tencent/mm/plugin/game/media/n:ujB	Z
    //   65: aload_0
    //   66: getfield 105	com/tencent/mm/plugin/game/media/n:ujx	Ljava/util/Set;
    //   69: astore_1
    //   70: aload_1
    //   71: monitorenter
    //   72: aload_0
    //   73: getfield 105	com/tencent/mm/plugin/game/media/n:ujx	Ljava/util/Set;
    //   76: invokeinterface 431 1 0
    //   81: astore_2
    //   82: aload_2
    //   83: invokeinterface 282 1 0
    //   88: ifeq +548 -> 636
    //   91: aload_2
    //   92: invokeinterface 286 1 0
    //   97: checkcast 190	java/lang/String
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 118	com/tencent/mm/plugin/game/media/n:ujC	Z
    //   105: ifeq +19 -> 124
    //   108: aload_1
    //   109: monitorexit
    //   110: ldc_w 424
    //   113: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: ldc 151
    //   126: invokestatic 157	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   129: checkcast 151	com/tencent/mm/plugin/game/api/f
    //   132: invokeinterface 161 1 0
    //   137: aload_3
    //   138: invokevirtual 435	com/tencent/mm/plugin/game/media/d:amG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/game/media/c;
    //   141: astore 4
    //   143: aload 4
    //   145: ifnull +22 -> 167
    //   148: aload 4
    //   150: getfield 307	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   153: ifnull +14 -> 167
    //   156: aload 4
    //   158: getfield 438	com/tencent/mm/plugin/game/media/c:field_mediaUrl	Ljava/lang/String;
    //   161: invokestatic 442	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   164: ifne +44 -> 208
    //   167: ldc 244
    //   169: ldc_w 444
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_3
    //   179: aastore
    //   180: invokestatic 251	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   187: aload_3
    //   188: invokeinterface 447 2 0
    //   193: pop
    //   194: goto -112 -> 82
    //   197: astore_2
    //   198: aload_1
    //   199: monitorexit
    //   200: ldc_w 424
    //   203: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: athrow
    //   208: invokestatic 290	com/tencent/mm/plugin/webview/modeltools/g:eUG	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   211: aload_3
    //   212: invokevirtual 296	com/tencent/mm/plugin/webview/model/ao:aIN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;
    //   215: ifnonnull +151 -> 366
    //   218: aload 4
    //   220: getfield 331	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   223: iconst_1
    //   224: if_icmpne +246 -> 470
    //   227: new 375	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem
    //   230: dup
    //   231: invokespecial 448	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem:<init>	()V
    //   234: astore 5
    //   236: aload 5
    //   238: aload 4
    //   240: getfield 307	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   243: putfield 304	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:dsN	Ljava/lang/String;
    //   246: aload 5
    //   248: aload 4
    //   250: getfield 313	com/tencent/mm/plugin/game/media/c:field_mediaId	Ljava/lang/String;
    //   253: putfield 310	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:mediaId	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 135	com/tencent/mm/plugin/game/media/n:ujv	Z
    //   260: ifeq +197 -> 457
    //   263: aload 4
    //   265: getfield 407	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   268: invokestatic 451	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   271: ifne +186 -> 457
    //   274: new 59	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   281: getstatic 86	com/tencent/mm/plugin/game/media/n:ujt	Ljava/lang/String;
    //   284: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 386
    //   290: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   296: invokevirtual 389	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: aload_3
    //   300: invokestatic 393	com/tencent/mm/sdk/platformtools/bu:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 396	java/lang/String:hashCode	()I
    //   306: ldc_w 397
    //   309: iand
    //   310: invokevirtual 400	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 6
    //   318: aload 6
    //   320: aload 4
    //   322: getfield 319	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   325: invokestatic 404	com/tencent/mm/plugin/game/media/n:gY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   328: ifeq +116 -> 444
    //   331: aload 4
    //   333: aload 6
    //   335: putfield 407	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   338: aload 5
    //   340: aload 4
    //   342: getfield 407	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   345: putfield 316	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:jXT	Ljava/lang/String;
    //   348: aload 5
    //   350: aload 4
    //   352: getfield 325	com/tencent/mm/plugin/game/media/c:field_thumbPath	Ljava/lang/String;
    //   355: putfield 322	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:kKQ	Ljava/lang/String;
    //   358: invokestatic 290	com/tencent/mm/plugin/webview/modeltools/g:eUG	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   361: aload 5
    //   363: invokevirtual 418	com/tencent/mm/plugin/webview/model/ao:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   366: aload 4
    //   368: getfield 331	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   371: tableswitch	default:+297 -> 668, 1:+29->400, 2:+297->668, 3:+297->668, 4:+221->592
    //   401: aload_3
    //   402: getstatic 456	com/tencent/mm/i/a:fKI	I
    //   405: sipush 215
    //   408: invokespecial 458	com/tencent/mm/plugin/game/media/n:al	(Ljava/lang/String;II)Z
    //   411: ifne -329 -> 82
    //   414: ldc 244
    //   416: ldc_w 460
    //   419: iconst_1
    //   420: anewarray 4	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload_3
    //   426: aastore
    //   427: invokestatic 251	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: aload_0
    //   431: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   434: aload_3
    //   435: invokeinterface 447 2 0
    //   440: pop
    //   441: goto -359 -> 82
    //   444: aload 4
    //   446: aload 4
    //   448: getfield 319	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   451: putfield 407	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   454: goto -116 -> 338
    //   457: aload 5
    //   459: aload 4
    //   461: getfield 319	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   464: putfield 316	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:jXT	Ljava/lang/String;
    //   467: goto -119 -> 348
    //   470: aload 4
    //   472: getfield 331	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   475: iconst_4
    //   476: if_icmpne -110 -> 366
    //   479: new 367	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   482: dup
    //   483: invokespecial 461	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:<init>	()V
    //   486: astore 5
    //   488: aload 5
    //   490: aload 4
    //   492: getfield 307	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   495: putfield 304	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:dsN	Ljava/lang/String;
    //   498: aload 5
    //   500: aload 4
    //   502: getfield 313	com/tencent/mm/plugin/game/media/c:field_mediaId	Ljava/lang/String;
    //   505: putfield 310	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:mediaId	Ljava/lang/String;
    //   508: aload 5
    //   510: aload 4
    //   512: getfield 319	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   515: putfield 316	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:jXT	Ljava/lang/String;
    //   518: aload 5
    //   520: aload 4
    //   522: getfield 325	com/tencent/mm/plugin/game/media/c:field_thumbPath	Ljava/lang/String;
    //   525: putfield 322	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:kKQ	Ljava/lang/String;
    //   528: aload 5
    //   530: checkcast 367	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   533: aload 4
    //   535: getfield 373	com/tencent/mm/plugin/game/media/c:field_duration	I
    //   538: putfield 370	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:duration	I
    //   541: aload 5
    //   543: checkcast 367	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   546: aload 4
    //   548: getfield 344	com/tencent/mm/plugin/game/media/c:field_width	I
    //   551: putfield 462	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:width	I
    //   554: aload 5
    //   556: checkcast 367	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   559: aload 4
    //   561: getfield 350	com/tencent/mm/plugin/game/media/c:field_height	I
    //   564: putfield 463	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:height	I
    //   567: aload 5
    //   569: checkcast 367	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   572: aload 4
    //   574: getfield 338	com/tencent/mm/plugin/game/media/c:field_size	J
    //   577: l2i
    //   578: putfield 464	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:size	I
    //   581: invokestatic 290	com/tencent/mm/plugin/webview/modeltools/g:eUG	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   584: aload 5
    //   586: invokevirtual 418	com/tencent/mm/plugin/webview/model/ao:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   589: goto -223 -> 366
    //   592: aload_0
    //   593: aload_3
    //   594: getstatic 467	com/tencent/mm/i/a:fKJ	I
    //   597: sipush 214
    //   600: invokespecial 458	com/tencent/mm/plugin/game/media/n:al	(Ljava/lang/String;II)Z
    //   603: ifne -521 -> 82
    //   606: ldc 244
    //   608: ldc_w 460
    //   611: iconst_1
    //   612: anewarray 4	java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: aload_3
    //   618: aastore
    //   619: invokestatic 251	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   622: aload_0
    //   623: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   626: aload_3
    //   627: invokeinterface 447 2 0
    //   632: pop
    //   633: goto -551 -> 82
    //   636: aload_0
    //   637: iconst_1
    //   638: putfield 116	com/tencent/mm/plugin/game/media/n:ujB	Z
    //   641: aload_1
    //   642: monitorexit
    //   643: aload_0
    //   644: getfield 107	com/tencent/mm/plugin/game/media/n:ujy	Ljava/util/Set;
    //   647: invokeinterface 470 1 0
    //   652: ifeq +7 -> 659
    //   655: aload_0
    //   656: invokespecial 473	com/tencent/mm/plugin/game/media/n:daS	()V
    //   659: ldc_w 424
    //   662: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: goto -644 -> 21
    //   668: goto -586 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	671	0	this	n
    //   119	523	1	localObject1	Object
    //   81	11	2	localIterator	Iterator
    //   197	10	2	localObject2	Object
    //   100	527	3	str1	String
    //   141	432	4	localc	c
    //   234	351	5	localObject3	Object
    //   316	18	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	119	finally
    //   24	72	119	finally
    //   110	116	119	finally
    //   200	208	119	finally
    //   643	659	119	finally
    //   659	665	119	finally
    //   72	82	197	finally
    //   82	110	197	finally
    //   124	143	197	finally
    //   148	167	197	finally
    //   167	194	197	finally
    //   198	200	197	finally
    //   208	338	197	finally
    //   338	348	197	finally
    //   348	366	197	finally
    //   366	400	197	finally
    //   400	441	197	finally
    //   444	454	197	finally
    //   457	467	197	finally
    //   470	589	197	finally
    //   592	633	197	finally
    //   636	643	197	finally
  }
  
  private void daS()
  {
    AppMethodBeat.i(41113);
    if (this.ujw != null) {
      this.ujw.ng(true);
    }
    AppMethodBeat.o(41113);
  }
  
  private static boolean gY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41114);
    if (u.aRG(paramString2))
    {
      AppMethodBeat.o(41114);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.plugin.appbrand.utils.d.f(paramString1, paramString2, 1440, 1080);
      if (bool) {
        o.deleteFile(paramString2);
      }
      AppMethodBeat.o(41114);
      return bool;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.Haowan.GameUploadMediaEngine", paramString1, "", new Object[0]);
      AppMethodBeat.o(41114);
    }
    return false;
  }
  
  public final void daP()
  {
    try
    {
      AppMethodBeat.i(41108);
      mRetryCount = ((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qwZ, 5);
      this.ujx.clear();
      this.ujx.addAll(this.uju);
      daQ();
      AppMethodBeat.o(41108);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void daR()
  {
    AppMethodBeat.i(41111);
    this.ujC = true;
    Iterator localIterator = this.uju.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.webview.modeltools.g.eUF();
      an.Ny(str);
    }
    ((f)com.tencent.mm.kernel.g.ab(f.class)).cZp().aw(this.uju);
    reset();
    AppMethodBeat.o(41111);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(41112);
    com.tencent.mm.plugin.webview.modeltools.g.eUF().b(this.ujF);
    com.tencent.mm.plugin.webview.modeltools.g.eUF().b(this.ujG);
    this.ujx.clear();
    this.ujz.clear();
    this.ujy.clear();
    this.uju.clear();
    this.ujw = null;
    AppMethodBeat.o(41112);
  }
  
  static abstract interface a
  {
    public abstract void ng(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.n
 * JD-Core Version:    0.7.0.1
 */