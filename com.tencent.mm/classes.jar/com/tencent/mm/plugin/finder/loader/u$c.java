package com.tencent.mm.plugin.finder.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.video.aa;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader$VideoProxy;", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "callback", "Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "(Lcom/tencent/mm/plugin/finder/loader/FinderVideoDownloader;Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/VideoDownloaderCallback;", "engineCallback", "Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "getEngineCallback", "()Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;", "setEngineCallback", "(Lcom/tencent/mm/modelvideo/IOnlineVideoProxy$IEngineCallback;)V", "isHasStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lock", "", "mediaCache", "Lcom/tencent/mm/plugin/finder/model/FinderMediaCache;", "getVideo", "()Lcom/tencent/mm/plugin/finder/loader/FinderVideoLoadData;", "isVideoDataAvailable", "", "mediaId", "", "offset", "", "length", "requestVideoData", "", "setIEngineCallback", "startHttpStream", "filePath", "url", "stop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
final class u$c
  implements com.tencent.mm.modelvideo.f
{
  final aa EyW;
  final v EyX;
  private final AtomicBoolean Ezh;
  private az Ezi;
  private final Object lock;
  private f.a xFC;
  
  public u$c(v paramv, aa paramaa)
  {
    AppMethodBeat.i(331829);
    this.EyX = paramaa;
    Object localObject;
    this.EyW = localObject;
    this.Ezh = new AtomicBoolean(false);
    this.lock = new Object();
    AppMethodBeat.o(331829);
  }
  
  private static final void a(u paramu, c paramc, int paramInt, final h paramh, final d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(331832);
    s.u(paramu, "this$0");
    s.u(paramc, "this$1");
    u.bt((a)new b(paramc, paramh, paramd));
    AppMethodBeat.o(331832);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(166359);
    s.u(parama, "callback");
    this.xFC = parama;
    AppMethodBeat.o(166359);
  }
  
  public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166358);
    s.u(paramString, "mediaId");
    synchronized (this.lock)
    {
      StringBuilder localStringBuilder = new StringBuilder("[isVideoDataAvailable] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
      Object localObject1 = this.Ezi;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("Finder.VideoDownloader", localObject1);
        localObject1 = this.EyW;
        if (localObject1 != null) {
          ((aa)localObject1).aj(paramString, paramInt1, paramInt2);
        }
        boolean bool = com.tencent.mm.modelvideo.v.bOi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(166358);
        return bool;
      }
      long l = ((az)localObject1).field_cacheSize;
      localObject1 = Long.valueOf(l);
    }
  }
  
  /* Error */
  public final void js(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: ldc 204
    //   6: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getfield 116	com/tencent/mm/plugin/finder/loader/u$c:lock	Ljava/lang/Object;
    //   13: astore 4
    //   15: aload_0
    //   16: getfield 99	com/tencent/mm/plugin/finder/loader/u$c:EyZ	Lcom/tencent/mm/plugin/finder/loader/u;
    //   19: astore 5
    //   21: aload 4
    //   23: monitorenter
    //   24: aload_0
    //   25: getfield 114	com/tencent/mm/plugin/finder/loader/u$c:Ezh	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   28: iconst_0
    //   29: iconst_1
    //   30: invokevirtual 208	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   33: pop
    //   34: ldc 162
    //   36: ldc 210
    //   38: aload_1
    //   39: invokestatic 214	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   42: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_1
    //   46: ifnull +117 -> 163
    //   49: invokestatic 186	com/tencent/mm/modelvideo/v:bOi	()Lcom/tencent/mm/modelcdntran/j;
    //   52: astore 6
    //   54: new 216	com/tencent/mm/plugin/finder/loader/u$c$$ExternalSyntheticLambda0
    //   57: dup
    //   58: aload 5
    //   60: aload_0
    //   61: invokespecial 219	com/tencent/mm/plugin/finder/loader/u$c$$ExternalSyntheticLambda0:<init>	(Lcom/tencent/mm/plugin/finder/loader/u;Lcom/tencent/mm/plugin/finder/loader/u$c;)V
    //   64: astore 7
    //   66: aload_1
    //   67: invokestatic 225	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   70: ifne +38 -> 108
    //   73: aload 6
    //   75: getfield 229	com/tencent/mm/modelcdntran/j:oAr	Ljava/util/Map;
    //   78: aload_1
    //   79: invokeinterface 235 2 0
    //   84: ifeq +88 -> 172
    //   87: iconst_1
    //   88: istore_2
    //   89: invokestatic 241	com/tencent/mm/kernel/h:baH	()Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;
    //   92: new 243	com/tencent/mm/modelcdntran/j$9
    //   95: dup
    //   96: aload 6
    //   98: aload_1
    //   99: aload 7
    //   101: invokespecial 246	com/tencent/mm/modelcdntran/j$9:<init>	(Lcom/tencent/mm/modelcdntran/j;Ljava/lang/String;Lcom/tencent/mm/modelcdntran/j$a;)V
    //   104: invokevirtual 252	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToWorker	(Ljava/lang/Runnable;)I
    //   107: pop
    //   108: ldc 254
    //   110: new 140	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 256
    //   117: invokespecial 145	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 258
    //   127: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload_2
    //   131: invokevirtual 261	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload 5
    //   142: getfield 265	com/tencent/mm/plugin/finder/loader/u:EyV	Lcom/tencent/mm/plugin/finder/preload/f;
    //   145: astore 5
    //   147: aload 5
    //   149: ifnull +14 -> 163
    //   152: aload 5
    //   154: aload_1
    //   155: iconst_0
    //   156: invokevirtual 271	com/tencent/mm/plugin/finder/preload/f:bH	(Ljava/lang/String;Z)V
    //   159: getstatic 277	kotlin/ah:aiuX	Lkotlin/ah;
    //   162: astore_1
    //   163: aload 4
    //   165: monitorexit
    //   166: ldc 204
    //   168: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: return
    //   172: invokestatic 283	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   175: aload_1
    //   176: invokevirtual 288	com/tencent/mm/modelcdntran/g:Nz	(Ljava/lang/String;)Z
    //   179: pop
    //   180: iload_3
    //   181: istore_2
    //   182: goto -93 -> 89
    //   185: astore_1
    //   186: aload 4
    //   188: monitorexit
    //   189: ldc 204
    //   191: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_1
    //   195: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	c
    //   0	196	1	paramString	String
    //   1	181	2	bool1	boolean
    //   3	178	3	bool2	boolean
    //   13	174	4	localObject1	Object
    //   19	134	5	localObject2	Object
    //   52	45	6	localj	j
    //   64	36	7	localExternalSyntheticLambda0	u.c..ExternalSyntheticLambda0
    // Exception table:
    //   from	to	target	type
    //   24	45	185	finally
    //   49	66	185	finally
    //   66	87	185	finally
    //   89	108	185	finally
    //   108	147	185	finally
    //   152	163	185	finally
    //   172	180	185	finally
  }
  
  public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(166357);
    s.u(paramString, "mediaId");
    synchronized (this.lock)
    {
      StringBuilder localStringBuilder = new StringBuilder("[requestVideoData] mediaId=").append(paramString).append(" offset=").append(paramInt1).append(" length=").append(paramInt2).append(" cacheSize=");
      Object localObject1 = this.Ezi;
      if (localObject1 == null)
      {
        localObject1 = null;
        Log.i("Finder.VideoDownloader", localObject1);
        com.tencent.mm.modelvideo.v.bOi();
        j.v(paramString, paramInt1, paramInt2);
        AppMethodBeat.o(166357);
        return;
      }
      long l = ((az)localObject1).field_cacheSize;
      localObject1 = Long.valueOf(l);
    }
  }
  
  public final void w(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(166355);
    s.u(paramString1, "mediaId");
    s.u(paramString2, "filePath");
    s.u(paramString3, "url");
    Object localObject3 = this.lock;
    u localu = this.EyZ;
    for (;;)
    {
      try
      {
        this.Ezh.set(false);
        Object localObject1 = e.FNF;
        az localaz = e.aAN(paramString1);
        localaz.field_reqFormat = this.EyX.Ezm;
        if (localaz.field_fileFormat == null)
        {
          localObject1 = this.EyX.ExF.detail;
          localaz.field_fileFormat = ((String)localObject1);
          localObject1 = e.FNF;
          Object localObject2 = this.EyX.ExE.mediaId;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          int i = this.EyX.Ezm;
          localObject2 = localaz.field_fileFormat;
          s.s(localObject2, "this.field_fileFormat");
          e.a(paramString1, (String)localObject1, paramString3, i, (String)localObject2, localaz.field_cacheSize, localaz.field_totalSize, 1, this.EyX.ExE.videoDuration, this.EyX.eCf(), this.EyX.eCe());
          localObject1 = av.GiL;
          i = localaz.field_reqFormat;
          localObject1 = localaz.field_fileFormat;
          s.s(localObject1, "videoCache.field_fileFormat");
          localObject2 = this.EyX.eCf();
          String str = this.EyX.eCe();
          if (this.EyX.ExE.hot_flag != 1) {
            break label631;
          }
          bool = true;
          localObject1 = av.a(paramString1, paramString3, paramString2, i, (String)localObject1, (String)localObject2, str, bool, (h.a)new u.a(localu, this.EyW, this.xFC, this.EyX, this.Ezh, this.lock), "Finder.VideoDownloader");
          this.Ezi = localaz;
          localObject2 = localu.EyV;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.finder.preload.f)localObject2).bH(paramString1, true);
          }
          Log.i("Finder.VideoDownloader", "[startHttpStream] fallback cancel mediaId=" + paramString1 + " isPreLoadCompleted=" + localaz.eDx() + " isAllCompleted=" + localaz.eDw() + " file=" + paramString2 + ", " + paramString3 + " isMoovReady=" + localaz.field_moovReady);
          if (localaz.eDw())
          {
            Log.i("Finder.VideoDownloader", "[finish] mediaId=" + paramString1 + " cacheSize=" + localaz.field_cacheSize + " totalSize=" + localaz.field_totalSize + '}');
            ((h)localObject1).lxs.a(paramString1, localaz.field_cacheSize, localaz.field_totalSize, localaz.field_fileFormat);
            ((h)localObject1).lxs.h(paramString1, localaz.field_cacheSize, localaz.field_totalSize);
            ((h)localObject1).lxs.a(paramString1, 0, null);
            paramString2 = localu.EyV;
            if (paramString2 != null) {
              paramString2.bH(paramString1, false);
            }
          }
        }
        else
        {
          localObject1 = localaz.field_fileFormat;
          continue;
        }
        com.tencent.mm.modelvideo.v.bOi().e((h)localObject1);
        u.bt((a)new a(this));
        paramString1 = ah.aiuX;
        return;
      }
      finally
      {
        AppMethodBeat.o(166355);
      }
      label631:
      boolean bool = false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements a<ah>
  {
    a(u.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements a<ah>
  {
    b(u.c paramc, h paramh, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.loader.u.c
 * JD-Core Version:    0.7.0.1
 */