package com.tencent.mm.loader;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.tencent.mm.loader.a.b<TT;TR;>;
import com.tencent.mm.loader.d.b.e.a;
import com.tencent.mm.loader.d.c.b.b;
import com.tencent.mm.loader.g.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/Reaper;", "T", "R", "", "builder", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/builder/RequestBuilder;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "batchFetcher", "Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "getBatchFetcher", "()Lcom/tencent/mm/loader/common/IDataBatchFetcher;", "setBatchFetcher", "(Lcom/tencent/mm/loader/common/IDataBatchFetcher;)V", "getBuilder", "()Lcom/tencent/mm/loader/builder/RequestBuilder;", "debugInfo", "", "getDebugInfo", "()Ljava/lang/String;", "setDebugInfo", "(Ljava/lang/String;)V", "defaultAnimation", "Landroid/view/animation/Animation;", "getDefaultAnimation", "()Landroid/view/animation/Animation;", "setDefaultAnimation", "(Landroid/view/animation/Animation;)V", "defaultBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getDefaultBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "defaultBackgroundResId", "", "getDefaultBackgroundResId", "()I", "setDefaultBackgroundResId", "(I)V", "defaultDrawable", "getDefaultDrawable", "setDefaultDrawable", "defaultResId", "getDefaultResId", "setDefaultResId", "filenameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "getFilenameCreator", "()Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "setFilenameCreator", "(Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;)V", "holder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "getHolder", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setHolder", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "getImageDownloadListener", "()Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageDownloadListener", "(Lcom/tencent/mm/loader/listener/IImageDownloadListener;)V", "imageWorkTask", "Lcom/tencent/mm/loader/loader/LoaderCore;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getImageWorkTask", "()Lcom/tencent/mm/loader/loader/LoaderCore;", "setImageWorkTask", "(Lcom/tencent/mm/loader/loader/LoaderCore;)V", "isShowDefaultBackground", "", "()Z", "isShowDefaultImage", "mDynamicTranscoder", "Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "getMDynamicTranscoder", "()Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;", "setMDynamicTranscoder", "(Lcom/tencent/mm/loader/impr/transcoder/HeadResourceTranscoder;)V", "mEmptyImageLoaderListener", "Lcom/tencent/mm/loader/impr/IDefaultImageLoaderListener;", "mHeadTranscoder", "getMHeadTranscoder", "setMHeadTranscoder", "mImageDiskCache", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "getMImageDiskCache", "()Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "setMImageDiskCache", "(Lcom/tencent/mm/loader/cache/disk/IDiskCache;)V", "mImageDownloader", "Lcom/tencent/mm/loader/common/IDataFetcher;", "getMImageDownloader", "()Lcom/tencent/mm/loader/common/IDataFetcher;", "setMImageDownloader", "(Lcom/tencent/mm/loader/common/IDataFetcher;)V", "mImageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "getMImageFileBrokenCallback", "()Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setMImageFileBrokenCallback", "(Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;)V", "mImageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "getMImageLoadListener", "()Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setMImageLoadListener", "(Lcom/tencent/mm/loader/listener/IImageLoadListener;)V", "mImageLoadReportCallback", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "getMImageLoadReportCallback", "()Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setMImageLoadReportCallback", "(Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;)V", "mImageLoaderAnimation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "getMImageLoaderAnimation", "()Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "mImageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "getMImageLoaderListener", "()Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "mImageLoaderOptions", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "getMImageLoaderOptions", "()Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "mImageMD5Checker", "Lcom/tencent/mm/loader/common/IImageMD5Check;", "getMImageMD5Checker", "()Lcom/tencent/mm/loader/common/IImageMD5Check;", "setMImageMD5Checker", "(Lcom/tencent/mm/loader/common/IImageMD5Check;)V", "mImageMemoryCache", "Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "getMImageMemoryCache", "()Lcom/tencent/mm/loader/cache/memory/IMemoryCache;", "setMImageMemoryCache", "(Lcom/tencent/mm/loader/cache/memory/IMemoryCache;)V", "mImageProducer", "Lcom/tencent/mm/loader/common/IImageResourceProducer;", "getMImageProducer", "()Lcom/tencent/mm/loader/common/IImageResourceProducer;", "setMImageProducer", "(Lcom/tencent/mm/loader/common/IImageResourceProducer;)V", "mImageRetryListener", "Lcom/tencent/mm/loader/common/IImageRetryDownload;", "getMImageRetryListener", "()Lcom/tencent/mm/loader/common/IImageRetryDownload;", "setMImageRetryListener", "(Lcom/tencent/mm/loader/common/IImageRetryDownload;)V", "onlyDownload", "getOnlyDownload", "setOnlyDownload", "(Z)V", "target", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "getTarget", "()Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "setTarget", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;)V", "uriValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "getUriValue", "()Lcom/tencent/mm/loader/model/data/DataItem;", "setUriValue", "(Lcom/tencent/mm/loader/model/data/DataItem;)V", "checkIfNeedInitExecutor", "", "doLoadImage", "task", "Lcom/tencent/mm/loader/task/LoadTask;", "download", "load", "request", "Companion", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<T, R>
{
  private static final String TAG = "MicroMsg.Loader.Reaper";
  public static final f.a noq = new f.a((byte)0);
  public com.tencent.mm.loader.cache.memory.d<T, R> noA;
  public com.tencent.mm.loader.cache.a.d<T, R> noB;
  private com.tencent.mm.loader.c.c noC;
  private com.tencent.mm.loader.e.b noD;
  public com.tencent.mm.loader.c.e noE;
  public com.tencent.mm.loader.c.d<R> noF;
  public com.tencent.mm.loader.d.c.a<R> noG;
  public com.tencent.mm.loader.d.c.a<R> noH;
  public com.tencent.mm.loader.e.a noI;
  private com.tencent.mm.loader.f.d<com.tencent.mm.loader.f.c> noJ;
  private com.tencent.mm.loader.c.a<T> noK;
  public com.tencent.mm.loader.e.g noL;
  public int noM;
  private Animation noN;
  public Drawable noO;
  public com.tencent.mm.loader.g.a.a<T> noP;
  public com.tencent.mm.loader.d.b.d<R> noQ;
  public String noR;
  public boolean noS;
  public final com.tencent.mm.loader.a.b<T, R> nor;
  private final com.tencent.mm.loader.d.g<T, R> nos;
  private com.tencent.mm.loader.d.b.g<?> not;
  public final com.tencent.mm.loader.b.e nou;
  public final com.tencent.mm.loader.e.e<T, R> nov;
  public final com.tencent.mm.loader.e.d now;
  public com.tencent.mm.loader.e.f nox;
  public com.tencent.mm.loader.e.c<T> noy;
  public com.tencent.mm.loader.c.b<T> noz;
  
  public f(com.tencent.mm.loader.a.b<T, R> paramb, com.tencent.mm.loader.b.d<T, R> paramd)
  {
    this.nor = paramb;
    this.nos = new com.tencent.mm.loader.d.g();
    Object localObject = this.nor.nou;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blA();
    }
    this.nou = paramb;
    localObject = this.nor.nov;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = (com.tencent.mm.loader.e.e)this.nos;
    }
    this.nov = paramb;
    this.now = this.nor.now;
    localObject = this.nor.nox;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blB();
    }
    this.nox = paramb;
    this.noy = this.nor.noy;
    localObject = this.nor.noz;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blw();
    }
    this.noz = paramb;
    localObject = this.nor.noA;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blu();
    }
    this.noA = paramb;
    localObject = this.nor.noB;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blv();
    }
    this.noB = paramb;
    localObject = this.nor.noC;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blC();
    }
    this.noC = paramb;
    localObject = this.nor.noD;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blD();
    }
    this.noD = paramb;
    localObject = this.nor.noE;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blE();
    }
    this.noE = paramb;
    localObject = this.nor.noF;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blx();
    }
    this.noF = paramb;
    localObject = this.nor.noG;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blz();
    }
    this.noG = paramb;
    this.noH = this.nor.noH;
    this.noI = this.nor.noI;
    localObject = this.nor.noJ;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.blG();
    }
    this.noJ = paramb;
    this.noK = paramd.blF();
    localObject = this.nor.noL;
    paramb = (com.tencent.mm.loader.a.b<T, R>)localObject;
    if (localObject == null) {
      paramb = paramd.bly();
    }
    this.noL = paramb;
    this.noM = this.nou.noM;
    this.noN = this.nou.noN;
    paramb = this.nou;
    paramd = MMApplicationContext.getResources();
    s.s(paramd, "getResources()");
    s.u(paramd, "resources");
    if (paramb.npY != 0) {
      paramb = (Drawable)new ColorDrawable(paramd.getColor(paramb.npY));
    }
    for (;;)
    {
      this.noO = paramb;
      this.noP = this.nor.noW;
      this.noR = "";
      return;
      if (paramb.noM != 0) {
        paramb = paramd.getDrawable(paramb.noM);
      } else {
        paramb = paramb.noO;
      }
    }
  }
  
  private static final boolean a(f paramf, ah.f paramf1)
  {
    s.u(paramf, "this$0");
    s.u(paramf1, "$resourceBitmap");
    if (paramf1.aqH == null) {
      return true;
    }
    if (((com.tencent.mm.loader.g.e)paramf1.aqH).value == null) {
      return true;
    }
    paramf = ((com.tencent.mm.loader.g.e)paramf1.aqH).nso;
    while (paramf != null)
    {
      if (paramf.value == null) {
        return true;
      }
      paramf1 = paramf.nso;
      paramf = paramf1;
      if (!(paramf1 instanceof com.tencent.mm.loader.g.e)) {
        paramf = null;
      }
    }
    return false;
  }
  
  private final void blk()
  {
    try
    {
      if (this.noJ == null)
      {
        com.tencent.mm.loader.f.a.e locale = com.tencent.mm.loader.f.a.e.nrV;
        this.noJ = com.tencent.mm.loader.f.a.e.blX();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final com.tencent.mm.loader.d.b.d<R> bli()
  {
    com.tencent.mm.loader.d.b.d locald = this.noQ;
    if (locald != null) {
      return locald;
    }
    s.bIx("target");
    return null;
  }
  
  public final void blj()
  {
    Object localObject2 = this.nor.noQ;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (com.tencent.mm.loader.d.b.d)new com.tencent.mm.loader.d.b.a();
    }
    s.u(localObject1, "<set-?>");
    this.noQ = ((com.tencent.mm.loader.d.b.d)localObject1);
    localObject1 = com.tencent.mm.loader.d.b.e.nqH;
    localObject1 = e.a.blM();
    localObject2 = bli();
    Object localObject3 = this.noP;
    s.u(localObject2, "target");
    s.u(localObject3, "data");
    int i = ((com.tencent.mm.loader.d.b.d)localObject2).blK();
    Log.i(com.tencent.mm.loader.d.b.e.TAG, "register code " + i + " data " + localObject3);
    ((com.tencent.mm.loader.d.b.e)localObject1).evG.put(Integer.valueOf(i), new r(localObject3, localObject2));
    localObject1 = this.noP;
    if (this.noP.isLegal())
    {
      if ((this.noP.bmg() instanceof String))
      {
        localObject2 = this.noP.bmg();
        if (localObject2 == null) {
          throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        if (!Util.isNullOrNil((String)localObject2)) {}
      }
    }
    else
    {
      i = 1;
      if (i == 0) {
        break label293;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label298;
      }
      Log.w(TAG, s.X("uri value is isLegal ", this.noP));
      localObject1 = com.tencent.mm.loader.d.b.e.nqH;
      e.a.blM().a(bli(), this.noP, "uri value is isLegal");
      this.nov.onImageLoadComplete(this.noP, this.not, null);
      localObject1 = this.now;
      if (localObject1 != null) {
        ((com.tencent.mm.loader.e.d)localObject1).a(this.not);
      }
      return;
      i = 0;
      break;
      label293:
      localObject1 = null;
    }
    label298:
    localObject2 = new ah.f();
    label333:
    boolean bool;
    if (this.nou.npR)
    {
      localObject1 = this.noA.a(this.noP, this.noG);
      ((ah.f)localObject2).aqH = localObject1;
      bool = a(this, (ah.f)localObject2);
      localObject1 = (com.tencent.mm.loader.g.e)((ah.f)localObject2).aqH;
      if (localObject1 != null) {
        if (!((com.tencent.mm.loader.g.e)localObject1).isValid()) {
          break label713;
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.loader.g.e)localObject1).value;
        if (localObject1 != null)
        {
          Log.d(TAG, "[ImageLoader] load from cache. no need from url: " + this.noP + " value " + localObject1);
          localObject2 = new com.tencent.mm.loader.g.e(localObject1);
          localObject3 = this.noG;
          if (localObject3 != null) {
            ((com.tencent.mm.loader.d.c.a)localObject3).a(bli().nqG, this, (com.tencent.mm.loader.g.e)localObject2, b.b.nqY);
          }
          localObject2 = this.now;
          if (localObject2 != null) {
            ((com.tencent.mm.loader.e.d)localObject2).a(this.not);
          }
          bli().a(localObject1, (com.tencent.mm.loader.d.b.b)new b(this));
          localObject2 = this.noy;
          if (localObject2 != null)
          {
            localObject3 = this.noP;
            c.a locala = com.tencent.mm.loader.g.c.nse;
            i = com.tencent.mm.loader.g.c.bma();
            locala = com.tencent.mm.loader.g.c.nse;
            new com.tencent.mm.loader.g.c(i, com.tencent.mm.loader.g.c.bmd(), localObject1);
            ((com.tencent.mm.loader.e.c)localObject2).b((com.tencent.mm.loader.g.a.a)localObject3);
          }
          this.nov.onImageLoadComplete(this.noP, bli().nqG, localObject1);
          if (!bool) {
            break;
          }
        }
      }
      localObject1 = new com.tencent.mm.loader.j.a(this.noP, bli(), this);
      localObject2 = com.tencent.mm.loader.b.e.npQ;
      if (com.tencent.mm.loader.b.e.access$getDEBUG$cp())
      {
        localObject2 = Util.getStack().toString();
        s.s(localObject2, "getStack().toString()");
        ((com.tencent.mm.loader.j.b)localObject1).noR = ((String)localObject2);
        this.noR = ((String)localObject2);
      }
      Log.d(TAG, "[ImageLoader] load from task:%s", new Object[] { this.noP });
      bli().a(bli().nqG, this);
      localObject2 = (com.tencent.mm.loader.j.b)localObject1;
      blk();
      localObject1 = this.noJ;
      if (localObject1 == null) {
        break;
      }
      localObject2 = (com.tencent.mm.loader.f.c)localObject2;
      s.u(localObject2, "t");
      ((com.tencent.mm.loader.f.d)localObject1).a((com.tencent.mm.loader.f.c)localObject2, null, true);
      return;
      localObject1 = null;
      break label333;
      label713:
      localObject1 = null;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/loader/Reaper$request$5$2", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.loader.d.b.b
  {
    b(f<T, R> paramf) {}
    
    public final void gg(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        e.a locala = com.tencent.mm.loader.d.b.e.nqH;
        e.a.blM().a(this.noT.bli(), this.noT.noP, "may be hit cache");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.f
 * JD-Core Version:    0.7.0.1
 */