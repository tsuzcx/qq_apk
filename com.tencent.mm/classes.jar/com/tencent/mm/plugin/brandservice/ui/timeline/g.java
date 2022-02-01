package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.qa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineResortHelper;", "", "()V", "TAG", "", "articleClickOpen", "", "getArticleClickOpen", "()Z", "articleClickOpen$delegate", "Lkotlin/Lazy;", "enterBizTimeLineOpen", "getEnterBizTimeLineOpen", "enterBizTimeLineOpen$delegate", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "oftenReadClickOpen", "getOftenReadClickOpen", "oftenReadClickOpen$delegate", "getItem", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "list", "", "pos", "", "getResortContext", "Lcom/tencent/mm/protocal/protobuf/BizMsgReSortContext;", "sessionItemCache", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportHashMap;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport$ReportBrandExposeItem;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineReport;", "posInCard", "fromScene", "onClick", "", "info", "onEnter", "onOftenReadClick", "userName", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static final j exj;
  private static final j vHA;
  public static final g vHx;
  private static final j vHy;
  private static final j vHz;
  
  static
  {
    AppMethodBeat.i(301881);
    vHx = new g();
    exj = k.cm((a)g.c.vHD);
    vHy = k.cm((a)b.vHC);
    vHz = k.cm((a)d.vHE);
    vHA = k.cm((a)a.vHB);
    AppMethodBeat.o(301881);
  }
  
  private static final void a(ab paramab, final int paramInt1, final List paramList, final f.c paramc, final int paramInt2)
  {
    AppMethodBeat.i(301868);
    s.u(paramab, "$info");
    s.u(paramc, "$sessionItemCache");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new e(paramab, paramInt1, paramList, paramc, paramInt2));
    AppMethodBeat.o(301868);
  }
  
  public static void a(ab paramab, List<? extends ab> paramList, f.c<String, f.b> paramc)
  {
    AppMethodBeat.i(301843);
    s.u(paramab, "info");
    s.u(paramc, "sessionItemCache");
    if (!((Boolean)vHy.getValue()).booleanValue())
    {
      AppMethodBeat.o(301843);
      return;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(301843);
      return;
    }
    h.ahAA.o(new g..ExternalSyntheticLambda1(paramab, paramList, paramc), 1000L);
    AppMethodBeat.o(301843);
  }
  
  public static void a(ab paramab, List<? extends ab> paramList, f.c<String, f.b> paramc, int paramInt)
  {
    AppMethodBeat.i(301853);
    s.u(paramab, "info");
    s.u(paramc, "sessionItemCache");
    if (!((Boolean)vHA.getValue()).booleanValue())
    {
      AppMethodBeat.o(301853);
      return;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(301853);
      return;
    }
    int i = paramList.indexOf(paramab);
    if (i < 0)
    {
      AppMethodBeat.o(301853);
      return;
    }
    h.ahAA.bk(new g..ExternalSyntheticLambda0(paramab, i, paramList, paramc, paramInt));
    AppMethodBeat.o(301853);
  }
  
  public static void a(ab paramab, List<? extends ab> paramList, f.c<String, f.b> paramc, String paramString)
  {
    AppMethodBeat.i(301847);
    s.u(paramab, "info");
    s.u(paramc, "sessionItemCache");
    if (!((Boolean)vHz.getValue()).booleanValue())
    {
      AppMethodBeat.o(301847);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(301847);
      return;
    }
    if (paramList == null)
    {
      AppMethodBeat.o(301847);
      return;
    }
    h.ahAA.bk(new g..ExternalSyntheticLambda2(paramab, paramList, paramc, paramString));
    AppMethodBeat.o(301847);
  }
  
  private static MultiProcessMMKV atj()
  {
    AppMethodBeat.i(301837);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)exj.getValue();
    AppMethodBeat.o(301837);
    return localMultiProcessMMKV;
  }
  
  private static final void b(ab paramab, final List paramList, final f.c paramc)
  {
    AppMethodBeat.i(301858);
    s.u(paramab, "$info");
    s.u(paramc, "$sessionItemCache");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new f(paramab, paramList, paramc));
    AppMethodBeat.o(301858);
  }
  
  private static final void b(ab paramab, final List paramList, final f.c paramc, final String paramString)
  {
    AppMethodBeat.i(301863);
    s.u(paramab, "$info");
    s.u(paramc, "$sessionItemCache");
    Looper.myQueue().addIdleHandler((MessageQueue.IdleHandler)new g(paramab, paramList, paramc, paramString));
    AppMethodBeat.o(301863);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<Boolean>
  {
    public static final a vHB;
    
    static
    {
      AppMethodBeat.i(301748);
      vHB = new a();
      AppMethodBeat.o(301748);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Boolean>
  {
    public static final b vHC;
    
    static
    {
      AppMethodBeat.i(301737);
      vHC = new b();
      AppMethodBeat.o(301737);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Boolean>
  {
    public static final d vHE;
    
    static
    {
      AppMethodBeat.i(301756);
      vHE = new d();
      AppMethodBeat.o(301756);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MessageQueue.IdleHandler
  {
    public e(ab paramab, int paramInt1, List paramList, f.c paramc, int paramInt2) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(301753);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      int i = com.tencent.mm.an.af.bHl().yJ(this.vHF.field_orderFlag);
      Object localObject;
      if (i < 0)
      {
        Log.d("MicroMsg.BizTimeLineResortHelper", "onClick maxWeight < 0");
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(47);
      }
      for (;;)
      {
        AppMethodBeat.o(301753);
        return false;
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(36);
        localObject = g.vHx;
        localObject = g.a(paramInt1, paramList, paramc, paramInt2, 5);
        ((qa)localObject).YUy = i;
        com.tencent.mm.storage.af localaf = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.a(5, (qa)localObject, this.vHF.field_orderFlag);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements MessageQueue.IdleHandler
  {
    public f(ab paramab, List paramList, f.c paramc) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(301752);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      int i = com.tencent.mm.an.af.bHl().yJ(this.vHF.field_orderFlag);
      Object localObject;
      if (i < 0)
      {
        Log.d("MicroMsg.BizTimeLineResortHelper", "onEnter maxWeight < 0");
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(46);
      }
      for (;;)
      {
        AppMethodBeat.o(301752);
        return false;
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(35);
        localObject = g.vHx;
        localObject = g.a(0, paramList, paramc, -1, 3);
        ((qa)localObject).YUy = i;
        com.tencent.mm.storage.af localaf = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.a(3, (qa)localObject, this.vHF.field_orderFlag);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements MessageQueue.IdleHandler
  {
    public g(ab paramab, List paramList, f.c paramc, String paramString) {}
    
    public final boolean queueIdle()
    {
      AppMethodBeat.i(302419);
      Looper.myQueue().removeIdleHandler((MessageQueue.IdleHandler)this);
      int i = com.tencent.mm.an.af.bHl().yJ(this.vHF.field_orderFlag);
      Object localObject;
      if (i < 0)
      {
        Log.d("MicroMsg.BizTimeLineResortHelper", "onOftenReadClick maxWeight < 0");
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(48);
      }
      for (;;)
      {
        AppMethodBeat.o(302419);
        return false;
        localObject = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.ayF(37);
        localObject = g.vHx;
        localObject = g.a(0, paramList, paramc, -1, 4);
        ((qa)localObject).YUx = paramString;
        ((qa)localObject).YUy = i;
        com.tencent.mm.storage.af localaf = com.tencent.mm.storage.af.acGt;
        com.tencent.mm.storage.af.a(4, (qa)localObject, this.vHF.field_orderFlag);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.g
 * JD-Core Version:    0.7.0.1
 */