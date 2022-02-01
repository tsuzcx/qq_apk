package com.tencent.mm.plugin.finder.video;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.DownloadInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.app.q;
import com.tencent.mm.protocal.protobuf.akz;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.awn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.threadpool.i;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderNetworkStatusStatistic;", "", "()V", "TAG", "", "appForegroundListener", "com/tencent/mm/plugin/finder/video/FinderNetworkStatusStatistic$appForegroundListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderNetworkStatusStatistic$appForegroundListener$1;", "downloadInfoAllList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderDownloadInfo;", "getDownloadInfoAllList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "downloadInfoList", "getDownloadInfoList", "isSupportHevc", "", "preloadInfoList", "getPreloadInfoList", "recentFinderClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "recentFinderNetworkInfoList", "Lcom/tencent/mm/protocal/protobuf/DownloadSpeed;", "getRecentFinderNetworkInfoList", "recentWechatNetworkInfoList", "getRecentWechatNetworkInfoList", "recordNetworkStatusRunnable", "Ljava/lang/Runnable;", "addDownloadNetworkInfo", "", "info", "addDownloadNetworkInfoToFinderState", "addFinderNetworkInfo", "addPreloadNetworkInfo", "addWechatNetworkInfo", "cacheStatusToFile", "generateClientStatus", "recordFinderNetWorkStatus", "recordWechatNetWorkStatus", "release", "resumeStatusFromFile", "setup", "startRecordNetWorkStatus", "stopRecordNetWorkStatus", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f Gog;
  private static final CopyOnWriteArrayList<awn> Goh;
  private static final CopyOnWriteArrayList<awn> Goi;
  private static final CopyOnWriteArrayList<awn> Goj;
  private static final CopyOnWriteArrayList<akz> Gok;
  private static final CopyOnWriteArrayList<akz> Gol;
  private static aur Gom;
  private static Runnable Gon;
  public static a Goo;
  public static boolean ygN;
  
  static
  {
    AppMethodBeat.i(334842);
    Gog = new f();
    Goh = new CopyOnWriteArrayList();
    Goi = new CopyOnWriteArrayList();
    Goj = new CopyOnWriteArrayList();
    Gok = new CopyOnWriteArrayList();
    Gol = new CopyOnWriteArrayList();
    Goo = new a();
    ygN = true;
    AppMethodBeat.o(334842);
  }
  
  public static void a(awn paramawn)
  {
    AppMethodBeat.i(334731);
    s.u(paramawn, "info");
    Log.i("Finder.FinderNetworkStatusStatistic", "addDownloadNetworkInfo info:" + paramawn + " size:" + Goh.size());
    if (Goh.size() > 3) {
      Goh.remove(0);
    }
    Goh.add(paramawn);
    AppMethodBeat.o(334731);
  }
  
  public static void b(awn paramawn)
  {
    AppMethodBeat.i(334745);
    s.u(paramawn, "info");
    Log.i("Finder.FinderNetworkStatusStatistic", "addNetworkInfoToFinderState info:" + paramawn + " size:" + Goi.size());
    Goi.add(paramawn);
    AppMethodBeat.o(334745);
  }
  
  public static aur bTZ()
  {
    AppMethodBeat.i(334805);
    aur localaur1 = new aur();
    localaur1.osName = com.tencent.mm.protocal.d.Yxd;
    localaur1.osVersion = com.tencent.mm.protocal.d.Yxe;
    localaur1.deviceBrand = com.tencent.mm.protocal.d.Yxa;
    localaur1.deviceModel = com.tencent.mm.protocal.d.Yxb;
    localaur1.ZEZ = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
    try
    {
      localaur1.netType = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUg();
      localaur1.ZFa = CdnLogic.getRecentAverageSpeed(2);
      localaur1.ZFb.addAll((Collection)Goh);
      localaur1.ZFh.addAll((Collection)Goj);
      localaur1.ZFc.add("h264");
      if (ygN) {
        localaur1.ZFc.add("h265");
      }
      localaur1.ZFf.addAll((Collection)Gok);
      localaur1.ZFg.addAll((Collection)Gol);
      if ((localaur1.netType == 0) && (localaur1.ZFa == 0) && (Gom != null))
      {
        aur localaur2 = Gom;
        s.checkNotNull(localaur2);
        if (localaur2.netType != 0)
        {
          localaur2 = Gom;
          s.checkNotNull(localaur2);
          if (localaur2.ZFa != 0)
          {
            localaur1 = Gom;
            s.checkNotNull(localaur1);
            Log.w("Finder.FinderNetworkStatusStatistic", "generateClientStatus resume from cache.");
            if (localaur1.netType == 0) {
              e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, "finder_nettype_error", false, null, false, (a)f.c.Goq, 28);
            }
            Log.i("Finder.FinderNetworkStatusStatistic", "generateClientStatus netType: " + localaur1.netType + " bandwidthKbps:" + localaur1.ZFa + " lastVideosDownloadInfo:" + localaur1.ZFb.size() + " last_preload_download_info:" + localaur1.ZFh.size() + " recent_finder_download_speed:" + localaur1.ZFf.size() + " recent_wechat_download_speed:" + localaur1.ZFg.size());
            AppMethodBeat.o(334805);
            return localaur1;
          }
        }
      }
    }
    finally
    {
      for (;;)
      {
        Log.w("Finder.FinderNetworkStatusStatistic", s.X("generateClientStatus e:", localObject));
        continue;
        Gom = localaur1;
      }
    }
  }
  
  public static void c(awn paramawn)
  {
    AppMethodBeat.i(334761);
    s.u(paramawn, "info");
    Log.i("Finder.FinderNetworkStatusStatistic", "addNetworkInfo info:" + paramawn + " size:" + Goh.size());
    if (Goj.size() > 10) {
      Goj.remove(0);
    }
    Goj.add(paramawn);
    AppMethodBeat.o(334761);
  }
  
  public static CopyOnWriteArrayList<awn> fiS()
  {
    return Goh;
  }
  
  public static CopyOnWriteArrayList<awn> fiT()
  {
    return Goi;
  }
  
  public static CopyOnWriteArrayList<awn> fiU()
  {
    return Goj;
  }
  
  public static CopyOnWriteArrayList<akz> fiV()
  {
    return Gok;
  }
  
  public static CopyOnWriteArrayList<akz> fiW()
  {
    return Gol;
  }
  
  public static void fiX()
  {
    AppMethodBeat.i(334785);
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    long l = ((Number)com.tencent.mm.plugin.finder.storage.d.eYq().bmg()).intValue();
    if (Gon != null)
    {
      Log.i("Finder.FinderNetworkStatusStatistic", "startRecordNetWorkStatus return for started.");
      AppMethodBeat.o(334785);
      return;
    }
    Gon = new f..ExternalSyntheticLambda0(l);
    if (l < 0L)
    {
      Log.i("Finder.FinderNetworkStatusStatistic", s.X("startRecordNetWorkStatus return for delayMs:", Long.valueOf(l)));
      AppMethodBeat.o(334785);
      return;
    }
    Log.i("Finder.FinderNetworkStatusStatistic", "startRecordNetWorkStatus delayMs:" + l + " recordNetworkStatusRunnable:" + Gon);
    localObject = Gon;
    if (localObject != null) {
      com.tencent.threadpool.h.ahAA.p((Runnable)localObject, l);
    }
    AppMethodBeat.o(334785);
  }
  
  public static void fiY()
  {
    AppMethodBeat.i(334792);
    Log.i("Finder.FinderNetworkStatusStatistic", s.X("stopRecordNetWorkStatus recordNetworkStatusRunnable:", Gon));
    Gon = null;
    AppMethodBeat.o(334792);
  }
  
  private static final void qV(long paramLong)
  {
    AppMethodBeat.i(334814);
    Runnable localRunnable = Gon;
    if (localRunnable != null)
    {
      Log.i("Finder.FinderNetworkStatusStatistic", "recordFinderNetWorkStatus");
      CdnLogic.DownloadInfo localDownloadInfo = CdnLogic.getRecentDownloadInfo(251, 20302, 5);
      akz localakz;
      long l;
      if (localDownloadInfo.recvedBytes > 0L)
      {
        localakz = new akz();
        localakz.Zsi = localDownloadInfo.recvedBytes;
        localakz.Zsj = localDownloadInfo.transforMS;
        l = System.currentTimeMillis();
        localakz.Rsc = (l - (localDownloadInfo.endTickcount - localDownloadInfo.beginTickcount));
        localakz.wwF = l;
        localakz.Zoz = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUg();
        s.u(localakz, "info");
        Log.i("Finder.FinderNetworkStatusStatistic", "addFinderNetworkInfo info:" + localakz + " size:" + Gok.size());
        if (Gok.size() > 24) {
          Gok.remove(0);
        }
        Gok.add(localakz);
      }
      Log.i("Finder.FinderNetworkStatusStatistic", "recordWechatNetWorkStatus");
      localDownloadInfo = CdnLogic.getRecentDownloadInfo(0, 0, 5);
      if (localDownloadInfo.recvedBytes > 0L)
      {
        localakz = new akz();
        localakz.Zsi = localDownloadInfo.recvedBytes;
        localakz.Zsj = localDownloadInfo.transforMS;
        l = System.currentTimeMillis();
        localakz.Rsc = (l - (localDownloadInfo.endTickcount - localDownloadInfo.beginTickcount));
        localakz.wwF = l;
        localakz.Zoz = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bUg();
        s.u(localakz, "info");
        Log.i("Finder.FinderNetworkStatusStatistic", "addWechatNetworkInfo info:" + localakz + " size:" + Gol.size());
        if (Gol.size() > 24) {
          Gol.remove(0);
        }
        Gol.add(localakz);
      }
      com.tencent.threadpool.h.ahAA.p(localRunnable, paramLong);
    }
    AppMethodBeat.o(334814);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/video/FinderNetworkStatusStatistic$appForegroundListener$1", "Lcom/tencent/mm/app/IAppForegroundListener;", "onAppBackground", "", "activity", "", "onAppForeground", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements q
  {
    public final void onAppBackground(String paramString)
    {
      AppMethodBeat.i(334904);
      paramString = f.Gog;
      f.fjc();
      AppMethodBeat.o(334904);
    }
    
    public final void onAppForeground(String paramString)
    {
      AppMethodBeat.i(334894);
      paramString = f.Gog;
      f.fjb();
      AppMethodBeat.o(334894);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends u
    implements a<ah>
  {
    public static final d Gor;
    
    static
    {
      AppMethodBeat.i(334848);
      Gor = new d();
      AppMethodBeat.o(334848);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements a<ah>
  {
    public static final f Got;
    
    static
    {
      AppMethodBeat.i(334863);
      Got = new f();
      AppMethodBeat.o(334863);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.f
 * JD-Core Version:    0.7.0.1
 */