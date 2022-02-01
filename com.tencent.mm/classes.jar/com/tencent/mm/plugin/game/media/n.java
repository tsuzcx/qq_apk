package com.tencent.mm.plugin.game.media;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.a.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.game.commlib.e.c.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKImageItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class n
{
  private static final String CFN;
  private static int mRetryCount;
  private LinkedList<String> CFO;
  private boolean CFP;
  a CFQ;
  private Set<String> CFR;
  private Set<String> CFS;
  private Set<String> CFT;
  private HashMap<String, String> CFU;
  private boolean CFV;
  private boolean CFW;
  private HashMap<String, Long> CFX;
  private Runnable CFY;
  private f.b CFZ;
  private f.a CGa;
  private String mvB;
  private int retryCount;
  
  static
  {
    AppMethodBeat.i(41119);
    CFN = com.tencent.mm.plugin.game.commlib.e.c.c(c.a.Czx) + "haowan/";
    mRetryCount = 5;
    AppMethodBeat.o(41119);
  }
  
  public n(String paramString, int paramInt, LinkedList<String> paramLinkedList, boolean paramBoolean)
  {
    AppMethodBeat.i(41106);
    this.CFO = new LinkedList();
    this.CFR = new HashSet();
    this.CFS = new HashSet();
    this.CFT = new HashSet();
    this.CFU = new HashMap();
    this.CFV = false;
    this.CFW = false;
    this.CFX = new HashMap();
    this.CFY = new Runnable()
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
        if (n.c(n.this) <= n.Yx())
        {
          n.d(n.this).clear();
          n.d(n.this).addAll(n.e(n.this));
          n.e(n.this).clear();
          n.f(n.this);
          AppMethodBeat.o(41101);
          return;
        }
        Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "retry count bigger than 5");
        n.g(n.this);
        AppMethodBeat.o(41101);
      }
    };
    this.CFZ = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, final int paramAnonymousInt, final String paramAnonymousString1, String paramAnonymousString2, final String paramAnonymousString3, final String paramAnonymousString4)
      {
        AppMethodBeat.i(41103);
        if (!n.h(n.this).contains(paramAnonymousString1))
        {
          Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramAnonymousString1 });
          AppMethodBeat.o(41103);
          return;
        }
        n.h(n.this).remove(paramAnonymousString1);
        final long l = System.currentTimeMillis() - Util.nullAs((Long)n.i(n.this).remove(paramAnonymousString1), System.currentTimeMillis());
        Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Long.valueOf(l) });
        if (n.a(n.this))
        {
          Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, has cancel");
          AppMethodBeat.o(41103);
          return;
        }
        com.tencent.mm.co.a.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41102);
            Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs().aJG(paramAnonymousString1);
            HashMap localHashMap = new HashMap();
            if (localObject != null)
            {
              localHashMap.put("type", Integer.valueOf(n.TA(((c)localObject).field_mediaType)));
              if (n.TA(((c)localObject).field_mediaType) == 2) {
                localHashMap.put("videoid", u.buc(((c)localObject).field_filePath));
              }
            }
            localHashMap.put("costtime", Long.valueOf(l));
            localHashMap.put("origtime", Integer.valueOf(((c)localObject).field_duration));
            localHashMap.put("origsize", Long.valueOf(((c)localObject).field_size));
            localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evr().aJI(n.j(n.this));
            int j;
            int i;
            if (localObject != null)
            {
              localHashMap.put("pushid", ((e)localObject).field_taskId);
              j = ((e)localObject).field_publishSource;
              i = ((e)localObject).field_sourceSceneId;
            }
            for (;;)
            {
              if (paramAnonymousString3)
              {
                n.e(n.this).remove(paramAnonymousString1);
                localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs();
                String str = paramAnonymousString1;
                str = String.format("update %s set %s=\"%s\", %s=\"%s\", %s=%d where %s=\"%s\"", new Object[] { "GameHaowanMedia", "mediaUrl", paramAnonymousString4, "thumbPicUrl", paramAnonymousInt, "uploadState", Integer.valueOf(2), "localId", str });
                Log.i("MicroMsg.Haowan.GameHaowanPublishStorage", "updateMediaUrl, sql: ".concat(String.valueOf(str)));
                ((d)localObject).execSQL("GameHaowanMedia", str);
                com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 48, i, com.tencent.mm.game.report.b.a.b(j, localHashMap));
              }
              for (;;)
              {
                Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "upload list size : %d, hasPushAllUpload: %b", new Object[] { Integer.valueOf(n.h(n.this).size()), Boolean.valueOf(n.k(n.this)) });
                if ((!n.h(n.this).isEmpty()) || (!n.k(n.this))) {
                  break label558;
                }
                if (n.e(n.this).isEmpty()) {
                  break;
                }
                com.tencent.e.h.ZvG.o(n.l(n.this), 60000L);
                AppMethodBeat.o(41102);
                return;
                if (this.val$errCode != -21006)
                {
                  n.e(n.this).add(paramAnonymousString1);
                  localHashMap.put("failid", Integer.valueOf(this.val$errCode));
                  com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 56, i, com.tencent.mm.game.report.b.a.b(j, localHashMap));
                }
              }
              n.m(n.this);
              label558:
              AppMethodBeat.o(41102);
              return;
              i = 0;
              j = 0;
            }
          }
        });
        AppMethodBeat.o(41103);
      }
    };
    this.CGa = new f.a()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41104);
        if (!n.h(n.this).contains(paramAnonymousString1))
        {
          Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onFinish, not in uploadingList, localId: %s", new Object[] { paramAnonymousString1 });
          AppMethodBeat.o(41104);
          return;
        }
        paramAnonymousInt1 = n.n(n.this).size();
        int i = n.h(n.this).size() + n.e(n.this).size();
        float f = 0.95F * ((paramAnonymousInt1 - i) / paramAnonymousInt1 + 1.0F / paramAnonymousInt1 * (paramAnonymousInt2 / 100.0F));
        Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "onProgress, localId : %s, percent : %d, initSize : %d, uploadingSize : %d, uploadProgress : %f", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt2), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(i), Float.valueOf(f) });
        n.a(n.this, f);
        AppMethodBeat.o(41104);
      }
    };
    this.mvB = paramString;
    this.CFP = paramBoolean;
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(41106);
      return;
    }
    if (paramInt == 2)
    {
      this.CFO.add(paramLinkedList.get(0));
      paramLinkedList = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs();
      if (paramString != null) {
        break label233;
      }
      paramInt = i;
    }
    label233:
    do
    {
      if (paramInt == 0) {
        exD();
      }
      com.tencent.mm.plugin.webview.modeltools.f.gWs().a(this.CFZ);
      com.tencent.mm.plugin.webview.modeltools.f.gWs().a(this.CGa);
      AppMethodBeat.o(41106);
      return;
      this.CFO.addAll(paramLinkedList);
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
  
  private boolean aq(final String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(41110);
    this.CFX.put(paramString, Long.valueOf(System.currentTimeMillis()));
    Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "uploadMediaFile, localId : %s", new Object[] { paramString });
    com.tencent.mm.co.a.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(41105);
        HashMap localHashMap = new HashMap();
        Object localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs().aJG(paramString);
        if (localObject != null)
        {
          localHashMap.put("type", Integer.valueOf(n.TA(((c)localObject).field_mediaType)));
          if (n.TA(((c)localObject).field_mediaType) == 2) {
            localHashMap.put("videoid", u.buc(((c)localObject).field_filePath));
          }
        }
        localObject = ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evr().aJI(n.j(n.this));
        int j;
        int i;
        if (localObject != null)
        {
          localHashMap.put("pushid", ((e)localObject).field_taskId);
          j = ((e)localObject).field_publishSource;
          i = ((e)localObject).field_sourceSceneId;
        }
        for (;;)
        {
          com.tencent.mm.game.report.b.a.a(MMApplicationContext.getContext(), 8764, 0, 20, i, com.tencent.mm.game.report.b.a.b(j, localHashMap));
          AppMethodBeat.o(41105);
          return;
          i = 0;
          j = 0;
        }
      }
    });
    boolean bool = com.tencent.mm.plugin.webview.modeltools.f.gWs().a("", paramString, paramInt1, paramInt2, 2, null);
    AppMethodBeat.o(41110);
    return bool;
  }
  
  private void exD()
  {
    AppMethodBeat.i(41107);
    Iterator localIterator = this.CFO.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      WebViewJSSDKFileItem localWebViewJSSDKFileItem = com.tencent.mm.plugin.webview.modeltools.f.gWt().bkI(str);
      if (localWebViewJSSDKFileItem != null)
      {
        c localc = new c();
        localc.field_localId = localWebViewJSSDKFileItem.fCM;
        localc.field_mediaId = localWebViewJSSDKFileItem.mediaId;
        localc.field_filePath = localWebViewJSSDKFileItem.nVa;
        localc.field_thumbPath = localWebViewJSSDKFileItem.oLR;
        localc.field_mediaType = localWebViewJSSDKFileItem.mediaType;
        localc.field_size = localWebViewJSSDKFileItem.size;
        localc.field_width = localWebViewJSSDKFileItem.width;
        localc.field_height = localWebViewJSSDKFileItem.height;
        localc.field_editFlag = localWebViewJSSDKFileItem.mab.getInt("mark_edit_flag", 0);
        if ((localWebViewJSSDKFileItem instanceof WebViewJSSDKVideoItem)) {
          localc.field_duration = ((WebViewJSSDKVideoItem)localWebViewJSSDKFileItem).duration;
        }
        if ((localWebViewJSSDKFileItem instanceof WebViewJSSDKImageItem)) {
          localc.field_isGif = ((WebViewJSSDKImageItem)localWebViewJSSDKFileItem).BYl;
        }
        localc.field_hostTaskId = this.mvB;
        if (localWebViewJSSDKFileItem.mediaType == 1)
        {
          str = CFN + "microMsg.compress." + System.currentTimeMillis() + (Util.nullAsNil(str).hashCode() & 0xFFFF);
          if ((!this.CFP) || (!hO(str, localWebViewJSSDKFileItem.nVa))) {
            break label329;
          }
          localc.field_compressPath = str;
          Log.i("MicroMsg.Haowan.GameUploadMediaEngine", "compress, originSize: %d, dstSize: %d", new Object[] { Long.valueOf(u.bBQ(localWebViewJSSDKFileItem.nVa)), Long.valueOf(u.bBQ(localc.field_compressPath)) });
          localWebViewJSSDKFileItem.nVa = str;
          com.tencent.mm.plugin.webview.modeltools.f.gWt().a(localWebViewJSSDKFileItem);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs().insert(localc);
          break;
          label329:
          localc.field_compressPath = localWebViewJSSDKFileItem.nVa;
        }
      }
    }
    AppMethodBeat.o(41107);
  }
  
  /* Error */
  private void exF()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 425
    //   5: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: getfield 118	com/tencent/mm/plugin/game/media/n:CFW	Z
    //   12: ifeq +12 -> 24
    //   15: ldc_w 425
    //   18: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   28: aload_0
    //   29: getfield 105	com/tencent/mm/plugin/game/media/n:CFR	Ljava/util/Set;
    //   32: invokeinterface 428 2 0
    //   37: pop
    //   38: ldc 244
    //   40: ldc_w 430
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_0
    //   50: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   53: invokevirtual 431	java/lang/Object:toString	()Ljava/lang/String;
    //   56: aastore
    //   57: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: aload_0
    //   61: iconst_0
    //   62: putfield 116	com/tencent/mm/plugin/game/media/n:CFV	Z
    //   65: aload_0
    //   66: getfield 105	com/tencent/mm/plugin/game/media/n:CFR	Ljava/util/Set;
    //   69: astore_1
    //   70: aload_1
    //   71: monitorenter
    //   72: aload_0
    //   73: getfield 105	com/tencent/mm/plugin/game/media/n:CFR	Ljava/util/Set;
    //   76: invokeinterface 432 1 0
    //   81: astore_2
    //   82: aload_2
    //   83: invokeinterface 283 1 0
    //   88: ifeq +548 -> 636
    //   91: aload_2
    //   92: invokeinterface 287 1 0
    //   97: checkcast 190	java/lang/String
    //   100: astore_3
    //   101: aload_0
    //   102: getfield 118	com/tencent/mm/plugin/game/media/n:CFW	Z
    //   105: ifeq +19 -> 124
    //   108: aload_1
    //   109: monitorexit
    //   110: ldc_w 425
    //   113: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: ldc 151
    //   126: invokestatic 157	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   129: checkcast 151	com/tencent/mm/plugin/game/api/f
    //   132: invokeinterface 161 1 0
    //   137: aload_3
    //   138: invokevirtual 436	com/tencent/mm/plugin/game/media/d:aJG	(Ljava/lang/String;)Lcom/tencent/mm/plugin/game/media/c;
    //   141: astore 4
    //   143: aload 4
    //   145: ifnull +22 -> 167
    //   148: aload 4
    //   150: getfield 308	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   153: ifnull +14 -> 167
    //   156: aload 4
    //   158: getfield 439	com/tencent/mm/plugin/game/media/c:field_mediaUrl	Ljava/lang/String;
    //   161: invokestatic 442	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   164: ifne +44 -> 208
    //   167: ldc 244
    //   169: ldc_w 444
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_3
    //   179: aastore
    //   180: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_0
    //   184: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   187: aload_3
    //   188: invokeinterface 447 2 0
    //   193: pop
    //   194: goto -112 -> 82
    //   197: astore_2
    //   198: aload_1
    //   199: monitorexit
    //   200: ldc_w 425
    //   203: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_2
    //   207: athrow
    //   208: invokestatic 291	com/tencent/mm/plugin/webview/modeltools/f:gWt	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   211: aload_3
    //   212: invokevirtual 297	com/tencent/mm/plugin/webview/model/ao:bkI	(Ljava/lang/String;)Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;
    //   215: ifnonnull +151 -> 366
    //   218: aload 4
    //   220: getfield 332	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   223: iconst_1
    //   224: if_icmpne +246 -> 470
    //   227: new 376	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem
    //   230: dup
    //   231: invokespecial 448	com/tencent/mm/plugin/webview/model/WebViewJSSDKImageItem:<init>	()V
    //   234: astore 5
    //   236: aload 5
    //   238: aload 4
    //   240: getfield 308	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   243: putfield 305	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:fCM	Ljava/lang/String;
    //   246: aload 5
    //   248: aload 4
    //   250: getfield 314	com/tencent/mm/plugin/game/media/c:field_mediaId	Ljava/lang/String;
    //   253: putfield 311	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:mediaId	Ljava/lang/String;
    //   256: aload_0
    //   257: getfield 135	com/tencent/mm/plugin/game/media/n:CFP	Z
    //   260: ifeq +197 -> 457
    //   263: aload 4
    //   265: getfield 408	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   268: invokestatic 451	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   271: ifne +186 -> 457
    //   274: new 59	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   281: getstatic 86	com/tencent/mm/plugin/game/media/n:CFN	Ljava/lang/String;
    //   284: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc_w 387
    //   290: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokestatic 232	java/lang/System:currentTimeMillis	()J
    //   296: invokevirtual 390	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   299: aload_3
    //   300: invokestatic 394	com/tencent/mm/sdk/platformtools/Util:nullAsNil	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 397	java/lang/String:hashCode	()I
    //   306: ldc_w 398
    //   309: iand
    //   310: invokevirtual 401	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: astore 6
    //   318: aload 6
    //   320: aload 4
    //   322: getfield 320	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   325: invokestatic 405	com/tencent/mm/plugin/game/media/n:hO	(Ljava/lang/String;Ljava/lang/String;)Z
    //   328: ifeq +116 -> 444
    //   331: aload 4
    //   333: aload 6
    //   335: putfield 408	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   338: aload 5
    //   340: aload 4
    //   342: getfield 408	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   345: putfield 317	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:nVa	Ljava/lang/String;
    //   348: aload 5
    //   350: aload 4
    //   352: getfield 326	com/tencent/mm/plugin/game/media/c:field_thumbPath	Ljava/lang/String;
    //   355: putfield 323	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:oLR	Ljava/lang/String;
    //   358: invokestatic 291	com/tencent/mm/plugin/webview/modeltools/f:gWt	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   361: aload 5
    //   363: invokevirtual 419	com/tencent/mm/plugin/webview/model/ao:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   366: aload 4
    //   368: getfield 332	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   371: tableswitch	default:+297 -> 668, 1:+29->400, 2:+297->668, 3:+297->668, 4:+221->592
    //   401: aload_3
    //   402: getstatic 456	com/tencent/mm/i/a:iUc	I
    //   405: sipush 215
    //   408: invokespecial 458	com/tencent/mm/plugin/game/media/n:aq	(Ljava/lang/String;II)Z
    //   411: ifne -329 -> 82
    //   414: ldc 244
    //   416: ldc_w 460
    //   419: iconst_1
    //   420: anewarray 4	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload_3
    //   426: aastore
    //   427: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: aload_0
    //   431: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   434: aload_3
    //   435: invokeinterface 447 2 0
    //   440: pop
    //   441: goto -359 -> 82
    //   444: aload 4
    //   446: aload 4
    //   448: getfield 320	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   451: putfield 408	com/tencent/mm/plugin/game/media/c:field_compressPath	Ljava/lang/String;
    //   454: goto -116 -> 338
    //   457: aload 5
    //   459: aload 4
    //   461: getfield 320	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   464: putfield 317	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:nVa	Ljava/lang/String;
    //   467: goto -119 -> 348
    //   470: aload 4
    //   472: getfield 332	com/tencent/mm/plugin/game/media/c:field_mediaType	I
    //   475: iconst_4
    //   476: if_icmpne -110 -> 366
    //   479: new 368	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   482: dup
    //   483: invokespecial 461	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:<init>	()V
    //   486: astore 5
    //   488: aload 5
    //   490: aload 4
    //   492: getfield 308	com/tencent/mm/plugin/game/media/c:field_localId	Ljava/lang/String;
    //   495: putfield 305	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:fCM	Ljava/lang/String;
    //   498: aload 5
    //   500: aload 4
    //   502: getfield 314	com/tencent/mm/plugin/game/media/c:field_mediaId	Ljava/lang/String;
    //   505: putfield 311	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:mediaId	Ljava/lang/String;
    //   508: aload 5
    //   510: aload 4
    //   512: getfield 320	com/tencent/mm/plugin/game/media/c:field_filePath	Ljava/lang/String;
    //   515: putfield 317	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:nVa	Ljava/lang/String;
    //   518: aload 5
    //   520: aload 4
    //   522: getfield 326	com/tencent/mm/plugin/game/media/c:field_thumbPath	Ljava/lang/String;
    //   525: putfield 323	com/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem:oLR	Ljava/lang/String;
    //   528: aload 5
    //   530: checkcast 368	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   533: aload 4
    //   535: getfield 374	com/tencent/mm/plugin/game/media/c:field_duration	I
    //   538: putfield 371	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:duration	I
    //   541: aload 5
    //   543: checkcast 368	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   546: aload 4
    //   548: getfield 345	com/tencent/mm/plugin/game/media/c:field_width	I
    //   551: putfield 462	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:width	I
    //   554: aload 5
    //   556: checkcast 368	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   559: aload 4
    //   561: getfield 351	com/tencent/mm/plugin/game/media/c:field_height	I
    //   564: putfield 463	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:height	I
    //   567: aload 5
    //   569: checkcast 368	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem
    //   572: aload 4
    //   574: getfield 339	com/tencent/mm/plugin/game/media/c:field_size	J
    //   577: l2i
    //   578: putfield 464	com/tencent/mm/plugin/webview/model/WebViewJSSDKVideoItem:size	I
    //   581: invokestatic 291	com/tencent/mm/plugin/webview/modeltools/f:gWt	()Lcom/tencent/mm/plugin/webview/model/ao;
    //   584: aload 5
    //   586: invokevirtual 419	com/tencent/mm/plugin/webview/model/ao:a	(Lcom/tencent/mm/plugin/webview/model/WebViewJSSDKFileItem;)V
    //   589: goto -223 -> 366
    //   592: aload_0
    //   593: aload_3
    //   594: getstatic 467	com/tencent/mm/i/a:iUd	I
    //   597: sipush 214
    //   600: invokespecial 458	com/tencent/mm/plugin/game/media/n:aq	(Ljava/lang/String;II)Z
    //   603: ifne -521 -> 82
    //   606: ldc 244
    //   608: ldc_w 460
    //   611: iconst_1
    //   612: anewarray 4	java/lang/Object
    //   615: dup
    //   616: iconst_0
    //   617: aload_3
    //   618: aastore
    //   619: invokestatic 251	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   622: aload_0
    //   623: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   626: aload_3
    //   627: invokeinterface 447 2 0
    //   632: pop
    //   633: goto -551 -> 82
    //   636: aload_0
    //   637: iconst_1
    //   638: putfield 116	com/tencent/mm/plugin/game/media/n:CFV	Z
    //   641: aload_1
    //   642: monitorexit
    //   643: aload_0
    //   644: getfield 107	com/tencent/mm/plugin/game/media/n:CFS	Ljava/util/Set;
    //   647: invokeinterface 470 1 0
    //   652: ifeq +7 -> 659
    //   655: aload_0
    //   656: invokespecial 473	com/tencent/mm/plugin/game/media/n:exH	()V
    //   659: ldc_w 425
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
    //   198	208	119	finally
    //   643	659	119	finally
    //   659	665	119	finally
    //   72	82	197	finally
    //   82	110	197	finally
    //   124	143	197	finally
    //   148	167	197	finally
    //   167	194	197	finally
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
  
  private void exH()
  {
    AppMethodBeat.i(41113);
    if (this.CFQ != null) {
      this.CFQ.sj(true);
    }
    AppMethodBeat.o(41113);
  }
  
  private static boolean hO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(41114);
    if (ImgUtil.isGif(paramString2))
    {
      AppMethodBeat.o(41114);
      return false;
    }
    try
    {
      boolean bool = com.tencent.mm.plugin.appbrand.utils.f.f(paramString1, paramString2, 1440, 1080);
      if (bool) {
        u.deleteFile(paramString2);
      }
      AppMethodBeat.o(41114);
      return bool;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.Haowan.GameUploadMediaEngine", paramString1, "", new Object[0]);
      AppMethodBeat.o(41114);
    }
    return false;
  }
  
  public final void exE()
  {
    try
    {
      AppMethodBeat.i(41108);
      mRetryCount = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vuO, 5);
      this.CFR.clear();
      this.CFR.addAll(this.CFO);
      exF();
      AppMethodBeat.o(41108);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void exG()
  {
    AppMethodBeat.i(41111);
    this.CFW = true;
    Iterator localIterator = this.CFO.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      com.tencent.mm.plugin.webview.modeltools.f.gWs();
      an.aer(str);
    }
    ((com.tencent.mm.plugin.game.api.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.api.f.class)).evs().bk(this.CFO);
    reset();
    AppMethodBeat.o(41111);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(41112);
    com.tencent.mm.plugin.webview.modeltools.f.gWs().b(this.CFZ);
    com.tencent.mm.plugin.webview.modeltools.f.gWs().b(this.CGa);
    this.CFR.clear();
    this.CFT.clear();
    this.CFS.clear();
    this.CFO.clear();
    this.CFQ = null;
    AppMethodBeat.o(41112);
  }
  
  static abstract interface a
  {
    public abstract void sj(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.n
 * JD-Core Version:    0.7.0.1
 */