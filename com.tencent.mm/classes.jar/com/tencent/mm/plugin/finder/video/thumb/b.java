package com.tencent.mm.plugin.finder.video.thumb;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.util.LruCache;
import android.view.Surface;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.thumbplayer.e.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vfs.y;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.e;
import kotlin.g.b.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbFetcher;", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbInfo;", "loader", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;", "Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer;", "(Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbInfo;Lcom/tencent/mm/plugin/thumbplayer/player/MMCdnTPPlayer$MMTPResourceLoader;)V", "TAG", "", "cacheKey", "kotlin.jvm.PlatformType", "getCacheKey", "()Ljava/lang/String;", "enableSeekPlayerRequestFrame", "", "isRunning", "player", "requests", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbFetcher$Request;", "thumb", "Landroid/graphics/Bitmap;", "thumbRenderer", "Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbRenderer;", "getTrackInfo", "()Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbInfo;", "cancel", "", "callback", "Lkotlin/Function2;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "time", "destroy", "onFrameGenerated", "bitmap", "timeMs", "onVideoDownloadComplete", "requestFrameAtTimeMs", "requestFrames", "times", "", "requestNext", "scaleAndCreateFirstThumb", "setSize", "width", "", "height", "Companion", "Request", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.videocomposition.c
{
  public static final b.d GvD;
  private static final LruCache<String, Bitmap> GvK;
  private final c GvE;
  private final d GvF;
  private final LinkedList<e> GvG;
  private com.tencent.mm.plugin.thumbplayer.e.b GvH;
  private boolean GvI;
  private Bitmap GvJ;
  private final String TAG;
  private volatile boolean Uz;
  private final String mgR;
  
  static
  {
    AppMethodBeat.i(335886);
    GvD = new b.d((byte)0);
    GvK = new LruCache(200);
    AppMethodBeat.o(335886);
  }
  
  public b(c paramc, com.tencent.mm.plugin.thumbplayer.e.b.b paramb)
  {
    AppMethodBeat.i(335798);
    this.GvE = paramc;
    this.mgR = this.GvE.GvR.url;
    this.TAG = s.X("MicroMsg.TPTrackThumbFetcher@", Integer.valueOf(hashCode()));
    this.GvF = new d(this.GvE.width, this.GvE.height);
    this.GvG = new LinkedList();
    if (y.ZC(this.GvE.GvR.thumbPath))
    {
      fjZ();
      Log.i(this.TAG, "init check first thumb exist");
    }
    for (;;)
    {
      paramc = new Object();
      h.ahAA.bk(new b..ExternalSyntheticLambda1(this, paramb, paramc));
      try
      {
        paramc.wait();
        paramb = ah.aiuX;
        Log.i(this.TAG, "init thumb fetcher finished");
        AppMethodBeat.o(335798);
        return;
        paramc = this.GvE.GvR.thumbPath;
        s.s(paramc, "trackInfo.mediaInfo.thumbPath");
        if (((CharSequence)paramc).length() > 0)
        {
          i = 1;
          label200:
          if (i == 0) {
            continue;
          }
          paramc = this.GvE.GvR.thumbUrl;
          s.s(paramc, "trackInfo.mediaInfo.thumbUrl");
          if (((CharSequence)paramc).length() <= 0) {
            break label308;
          }
        }
        label308:
        for (int i = 1; i != 0; i = 0)
        {
          paramc = new c.a();
          paramc.fullPath = this.GvE.GvR.thumbPath;
          paramc.oKp = true;
          paramc.oKn = true;
          r.bKe().a(this.GvE.GvR.thumbUrl, paramc.bKx(), new b..ExternalSyntheticLambda0(this));
          break;
          i = 0;
          break label200;
        }
      }
      catch (Exception paramb)
      {
        for (;;)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramb, "wait init thumb fetcher error", new Object[0]);
        }
      }
      finally
      {
        AppMethodBeat.o(335798);
      }
    }
  }
  
  private static final void a(b paramb, com.tencent.mm.plugin.thumbplayer.e.b.b paramb1, final Object paramObject)
  {
    AppMethodBeat.i(335849);
    s.u(paramb, "this$0");
    s.u(paramObject, "$lock");
    Object localObject1 = paramb.TAG;
    Object localObject2 = new StringBuilder("create new TPTrackThumbFetcher, mediaInfo:").append(paramb.GvE.GvR).append(", loader.isAllComplete:");
    boolean bool;
    if (paramb1 == null)
    {
      bool = false;
      Log.i((String)localObject1, bool);
      localObject1 = com.tencent.mm.plugin.thumbplayer.e.d.TFK;
      localObject1 = MMApplicationContext.getContext();
      s.s(localObject1, "getContext()");
      paramb.GvH = d.a.ks((Context)localObject1);
      localObject1 = paramb.GvH;
      if (localObject1 != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setMute(true);
      }
      if (paramb1 == null) {
        break label578;
      }
      localObject1 = paramb.GvH;
      if (localObject1 != null)
      {
        localObject2 = paramb.GvE.GvR;
        s.u(paramb1, "loader");
        s.u(localObject2, "mediaInfo");
        Log.i(((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TAG, "setCdnResourceLoader, loader:" + paramb1.hashCode() + ", mediaId:" + paramb1.mediaId + ", isMoovReady:" + paramb1.EUK);
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFd = paramb1;
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFb = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject2);
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).Flw = true;
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).hLk();
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).TFs = true;
      }
      label241:
      if (paramb1 != null) {
        break label604;
      }
      bool = false;
      label247:
      paramb.GvI = bool;
      paramb1 = paramb.GvH;
      if (paramb1 != null) {
        paramb1.Flr = true;
      }
      paramb1 = paramb.GvH;
      if (paramb1 != null) {
        paramb1.TFr = true;
      }
      paramb1 = paramb.GvH;
      if (paramb1 != null) {
        break label612;
      }
    }
    label578:
    label604:
    label612:
    for (paramb1 = null;; paramb1 = paramb1.TFd)
    {
      if (paramb1 != null) {
        paramb1.TFy = ((m)new a(paramb));
      }
      paramb1 = paramb.GvF;
      localObject1 = paramb.GvE.GvR;
      s.u(localObject1, "mediaInfo");
      Log.i(paramb1.TAG, s.X("mediaInfo:", localObject1));
      paramb1.GvR = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1);
      paramb1 = paramb.GvF;
      paramObject = (kotlin.g.a.b)new b(paramb, paramObject);
      s.u(paramObject, "afterSurfaceCreated");
      Log.i(paramb1.TAG, "setup, output size:[" + paramb1.width + ',' + paramb1.height + ']');
      paramb1.GvV = paramObject;
      paramObject = com.tencent.threadpool.c.d.jv(s.X("TPTrackThumbRenderer@", Integer.valueOf(paramb1.hashCode())), 0);
      paramObject.start();
      paramb1.GvU = new MMHandler(paramObject.getLooper());
      localObject1 = ah.aiuX;
      paramb1.GvT = paramObject;
      paramb1.K((kotlin.g.a.a)new d.b(paramb1));
      paramb1.K((kotlin.g.a.a)new d.c(paramb1));
      paramb1.K((kotlin.g.a.a)new d.d(paramb1));
      paramb1.K((kotlin.g.a.a)new d.f(paramb1));
      paramb1 = paramb.GvF;
      paramb = (m)new c();
      s.u(paramb, "callback");
      paramb1.GvZ = paramb;
      AppMethodBeat.o(335849);
      return;
      bool = paramb1.TFw;
      break;
      localObject1 = paramb.GvH;
      if (localObject1 == null) {
        break label241;
      }
      ((com.tencent.mm.plugin.thumbplayer.e.b)localObject1).setMediaInfo(paramb.GvE.GvR);
      break label241;
      bool = paramb1.TFw;
      break label247;
    }
  }
  
  private static final void a(b paramb, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(335831);
    s.u(paramb, "this$0");
    if (paramBoolean)
    {
      paramb.fjZ();
      Log.i(paramb.TAG, "init download first thumb succ");
    }
    AppMethodBeat.o(335831);
  }
  
  private final void aWx()
  {
    AppMethodBeat.i(335818);
    synchronized (this.GvG)
    {
      boolean bool = this.Uz;
      if (bool)
      {
        AppMethodBeat.o(335818);
        return;
      }
      if (!((Collection)this.GvG).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Object localObject1 = this.GvG.get(0);
        s.s(localObject1, "requests[0]");
        qY(((e)localObject1).GvM);
        this.Uz = true;
        localObject1 = ah.aiuX;
        AppMethodBeat.o(335818);
        return;
      }
      Log.i(this.TAG, "finished request all frames");
      destroy();
    }
  }
  
  private final void fjZ()
  {
    AppMethodBeat.i(335806);
    Bitmap localBitmap = MMBitmapFactory.decodeFile(this.GvE.GvR.thumbPath);
    if (localBitmap != null)
    {
      this.GvJ = Bitmap.createScaledBitmap(localBitmap, (int)(120.0F * (localBitmap.getWidth() / localBitmap.getHeight())), 120, true);
      localBitmap.recycle();
    }
    AppMethodBeat.o(335806);
  }
  
  private final void qY(long paramLong)
  {
    AppMethodBeat.i(335826);
    Log.v(this.TAG, "requestFrameAtTimeMs:" + paramLong + ", enableSeek:" + this.GvI);
    this.GvF.Gwa = paramLong;
    if (this.GvI)
    {
      com.tencent.mm.plugin.thumbplayer.e.b localb = this.GvH;
      if (localb != null) {
        com.tencent.mm.plugin.thumbplayer.e.b.a(localb, (int)paramLong, true, 4);
      }
    }
    AppMethodBeat.o(335826);
  }
  
  public final void b(List<Long> arg1, m<? super Long, ? super Bitmap, ah> paramm)
  {
    AppMethodBeat.i(335926);
    s.u(???, "times");
    s.u(paramm, "callback");
    Object localObject1 = (Iterable)???;
    ??? = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    label201:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      long l = ((Number)localObject2).longValue();
      Log.i(this.TAG, s.X("requestFrames: ", Long.valueOf(l)));
      Bitmap localBitmap = (Bitmap)GvK.get(this.mgR + '-' + l);
      if (localBitmap != null) {
        paramm.invoke(Long.valueOf(l), localBitmap);
      }
      for (int i = 0;; i = 1)
      {
        if (i == 0) {
          break label201;
        }
        ???.add(localObject2);
        break;
        if ((this.GvJ != null) && (l == 0L)) {
          paramm.invoke(Long.valueOf(l), this.GvJ);
        }
      }
    }
    localObject1 = (Iterable)p.t((Iterable)???);
    ??? = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ???.add(new e(((Number)((Iterator)localObject1).next()).longValue(), paramm));
    }
    paramm = (List)???;
    if (paramm.isEmpty())
    {
      Log.i(this.TAG, "requestFrames: no new request");
      AppMethodBeat.o(335926);
      return;
    }
    synchronized (this.GvG)
    {
      this.GvG.addAll((Collection)paramm);
      aWx();
      AppMethodBeat.o(335926);
      return;
    }
  }
  
  public final void cancel(long paramLong)
  {
    AppMethodBeat.i(335907);
    synchronized (this.GvG)
    {
      p.e((List)this.GvG, (kotlin.g.a.b)new f(paramLong));
      AppMethodBeat.o(335907);
      return;
    }
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(335913);
    Log.i(this.TAG, "destroy");
    Object localObject = this.GvH;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).TFd)
    {
      if (localObject != null) {
        ((com.tencent.mm.plugin.thumbplayer.e.b.b)localObject).TFy = null;
      }
      localObject = this.GvH;
      if (localObject != null)
      {
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).stopAsync();
        ((com.tencent.mm.plugin.thumbplayer.e.b)localObject).recycle();
      }
      this.GvH = null;
      localObject = this.GvF;
      ((d)localObject).K((kotlin.g.a.a)new d.e((d)localObject));
      AppMethodBeat.o(335913);
      return;
    }
  }
  
  public final void setSize(int paramInt1, int paramInt2)
  {
    d locald = this.GvF;
    if ((locald.width != paramInt1) || (locald.height != paramInt2)) {
      locald.GvY = true;
    }
    locald.width = paramInt1;
    locald.height = paramInt2;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<String, Integer, ah>
  {
    a(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/Surface;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Surface, ah>
  {
    b(b paramb, Object paramObject)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbFetcher$Request;", "", "timeMs", "", "callback", "Lkotlin/Function2;", "Landroid/graphics/Bitmap;", "", "Lcom/tencent/mm/videocomposition/ThumbCallback;", "cmTime", "Lcom/tencent/tav/coremedia/CMTime;", "(JLkotlin/jvm/functions/Function2;Lcom/tencent/tav/coremedia/CMTime;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getCmTime", "()Lcom/tencent/tav/coremedia/CMTime;", "getTimeMs", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
  {
    final long GvM;
    private final CMTime GvN;
    final m<Long, Bitmap, ah> mgM;
    
    private e(long paramLong, m<? super Long, ? super Bitmap, ah> paramm, CMTime paramCMTime)
    {
      AppMethodBeat.i(335738);
      this.GvM = paramLong;
      this.mgM = paramm;
      this.GvN = paramCMTime;
      AppMethodBeat.o(335738);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(335768);
      if (this == paramObject)
      {
        AppMethodBeat.o(335768);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(335768);
        return false;
      }
      paramObject = (e)paramObject;
      if (this.GvM != paramObject.GvM)
      {
        AppMethodBeat.o(335768);
        return false;
      }
      if (!s.p(this.mgM, paramObject.mgM))
      {
        AppMethodBeat.o(335768);
        return false;
      }
      if (!s.p(this.GvN, paramObject.GvN))
      {
        AppMethodBeat.o(335768);
        return false;
      }
      AppMethodBeat.o(335768);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(335759);
      int i = q.a..ExternalSyntheticBackport0.m(this.GvM);
      int j = this.mgM.hashCode();
      int k = this.GvN.hashCode();
      AppMethodBeat.o(335759);
      return (i * 31 + j) * 31 + k;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(335755);
      String str = "Request(timeMs=" + this.GvM + ", callback=" + this.mgM + ", cmTime=" + this.GvN + ')';
      AppMethodBeat.o(335755);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbFetcher$Request;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<b.e, Boolean>
  {
    f(long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/video/thumb/TPTrackThumbFetcher$Request;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<b.e, Boolean>
  {
    g(long paramLong, ah.e parame, Bitmap paramBitmap, b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.thumb.b
 * JD-Core Version:    0.7.0.1
 */