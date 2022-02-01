package com.tencent.d.a.b.a.a.a;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.storage.config.base.c;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/plugin/finder/nearby/api/config/red/NearbyLiveConfig;", "", "()V", "FIND_NEARBY_INDEPENDENT_LIVE_ROOM", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "getFIND_NEARBY_INDEPENDENT_LIVE_ROOM", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderSimpleClickConfig;", "FIND_NEARBY_INDEPENDENT_LIVE_SQUARE", "getFIND_NEARBY_INDEPENDENT_LIVE_SQUARE", "FIND_NEARBY_LIVE_ROOM", "getFIND_NEARBY_LIVE_ROOM", "FIND_NEARBY_LIVE_SQUARE", "getFIND_NEARBY_LIVE_SQUARE", "FIND_NEARBY_LIVE_SQUARE_ENABLE_VOICE", "Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "", "getFIND_NEARBY_LIVE_SQUARE_ENABLE_VOICE", "()Lcom/tencent/mm/plugin/findersdk/storage/config/base/FinderFakeConfig;", "doIfIsExperienceVersion", "", "block", "Lkotlin/Function0;", "returnDebugBlock", "Block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "plugin-finder-nearby-api_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ahqb;
  private static final c ahqc;
  private static final c ahqd;
  private static final c ahqe;
  private static final c ahqf;
  private static final com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> ahqg;
  
  static
  {
    AppMethodBeat.i(216535);
    ahqb = new a();
    ahqc = new c("生成 - 直播入口 - 直达直播间红点", (kotlin.g.a.b)a.ahqh);
    ahqd = new c("生成 - 直播入口 - 直达直播广场红点", (kotlin.g.a.b)b.ahqi);
    ahqe = new c("生成 - 附近直播 - 直达直播间红点", (kotlin.g.a.b)c.ahqj);
    ahqf = new c("生成 - 附近直播 - 直达直播广场红点", (kotlin.g.a.b)d.ahqk);
    ahqg = new com.tencent.mm.plugin.findersdk.storage.config.a.b.a(0, "直播广场是否开启声音").c("FIND_NEARBY_LIVE_SQUARE_ENABLE_VOICE", p.listOf(new Integer[] { Integer.valueOf(0), Integer.valueOf(1) }), p.listOf(new String[] { "默认", "开启" }));
    AppMethodBeat.o(216535);
  }
  
  public static void cl(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(216525);
    s.u(parama, "block");
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (CrashReportFactory.hasDebuger())) {
      parama.invoke();
    }
    AppMethodBeat.o(216525);
  }
  
  public static com.tencent.mm.plugin.findersdk.storage.config.base.b<Integer> jWA()
  {
    return ahqg;
  }
  
  public static c jWw()
  {
    return ahqc;
  }
  
  public static c jWx()
  {
    return ahqd;
  }
  
  public static c jWy()
  {
    return ahqe;
  }
  
  public static c jWz()
  {
    return ahqf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final a ahqh;
    
    static
    {
      AppMethodBeat.i(216501);
      ahqh = new a();
      AppMethodBeat.o(216501);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final b ahqi;
    
    static
    {
      AppMethodBeat.i(216493);
      ahqi = new b();
      AppMethodBeat.o(216493);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final c ahqj;
    
    static
    {
      AppMethodBeat.i(216516);
      ahqj = new c();
      AppMethodBeat.o(216516);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroid/app/Activity;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Activity, ah>
  {
    public static final d ahqk;
    
    static
    {
      AppMethodBeat.i(216498);
      ahqk = new d();
      AppMethodBeat.o(216498);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.d.a.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */