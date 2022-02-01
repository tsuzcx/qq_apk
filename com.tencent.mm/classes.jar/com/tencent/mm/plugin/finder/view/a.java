package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.report.t;
import com.tencent.mm.plugin.finder.report.t.a;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.textstatus.proto.d;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.emr;
import com.tencent.mm.protocal.protobuf.ezq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.e.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "context", "Landroid/content/Context;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderObject;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;)V", "isCheckingValid", "", "isFeedValid", "()Z", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPullDownParam", "()Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "record", "Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "getRecord", "()Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "setRecord", "(Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;)V", "checkFeedValidFromServer", "", "checkShowValidLayout", "isReplaceFinderObject", "onDestroy", "onPostClose", "onPreOpen", "reportStat", "feed", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "resetFinderObject", "Companion", "StatRecord", "plugin-finder_release"})
public abstract class a
  extends com.tencent.mm.ui.widget.b
{
  private static final HashMap<Long, Boolean> ATX = new HashMap();
  public static final a ATY = new a((byte)0);
  private boolean ATV;
  b ATW;
  private final Context context;
  private final c<com.tencent.mm.vending.e.a> xbq;
  private final FinderObject xcx;
  final d yNR;
  
  public a(Context paramContext, FinderObject paramFinderObject, d paramd)
  {
    this.context = paramContext;
    this.xcx = paramFinderObject;
    this.yNR = paramd;
    this.xbq = new c();
    this.xbq.keep((com.tencent.mm.vending.e.a)1.ATZ);
    this.ATW = new b();
  }
  
  public void G(FinderObject paramFinderObject)
  {
    p.k(paramFinderObject, "finderObject");
  }
  
  public void dDB() {}
  
  public final boolean eib()
  {
    return a.Nt(this.xcx.id);
  }
  
  public final void eic()
  {
    if (this.ATV) {
      return;
    }
    this.ATV = true;
    Log.i(getTag(), "checkFeedValidFromServer...");
    new ag(this.xcx.id, this.xcx.objectNonceId, 106, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280).bhW().b((com.tencent.mm.vending.c.a)new c(this)).a((com.tencent.mm.vending.e.b)this.xbq);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.ATV = false;
    this.xbq.dead();
  }
  
  public void onPostClose()
  {
    super.onPostClose();
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
    localObject1 = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.xcx.objectDesc;
      if (localObject2 == null) {
        break label613;
      }
      localObject2 = ((FinderObjectDesc)localObject2).media;
      if (localObject2 == null) {
        break label613;
      }
      localObject2 = (FinderMedia)j.lp((List)localObject2);
      if (localObject2 == null) {
        break label613;
      }
      i = ((FinderMedia)localObject2).videoDuration;
      if (i > 0) {
        this.ATW.AUa = ((int)(((com.tencent.mm.plugin.textstatus.proto.f)localObject1).MFd / i + 1L));
      }
    }
    Context localContext = this.context;
    FinderObject localFinderObject = this.xcx;
    b localb = this.ATW;
    p.k(localContext, "context");
    p.k(localFinderObject, "feed");
    p.k(localb, "record");
    Object localObject3 = new emr();
    ((emr)localObject3).xbk = localFinderObject.id;
    ((emr)localObject3).objectNonceId = localFinderObject.objectNonceId;
    ((emr)localObject3).Upk = new ezq();
    ((emr)localObject3).Upl = new dhb();
    localObject1 = localFinderObject.objectDesc;
    if (localObject1 != null)
    {
      i = ((FinderObjectDesc)localObject1).mediaType;
      label212:
      ((emr)localObject3).mediaType = i;
      localObject2 = localFinderObject.username;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((emr)localObject3).finderUsername = ((String)localObject1);
      ((emr)localObject3).Upm = localb.oiL;
      localObject2 = localFinderObject.sessionBuffer;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((emr)localObject3).sessionBuffer = ((String)localObject1);
      ((emr)localObject3).Upt = localb.oiL;
      long l = cm.bfE();
      localObject1 = ((emr)localObject3).Upk;
      if (localObject1 != null)
      {
        localObject2 = localFinderObject.objectDesc;
        if (localObject2 == null) {
          break label623;
        }
        localObject2 = ((FinderObjectDesc)localObject2).media;
        if (localObject2 == null) {
          break label623;
        }
        localObject2 = (FinderMedia)j.lp((List)localObject2);
        if (localObject2 == null) {
          break label623;
        }
        i = ((FinderMedia)localObject2).videoDuration;
        label356:
        ((ezq)localObject1).UzT = i;
        ((ezq)localObject1).KyZ = ((int)((l - localb.oiL) / 1000L));
        ((ezq)localObject1).wmw = (l - localb.oiL);
        ((ezq)localObject1).UzU = ((ezq)localObject1).wmw;
        ((ezq)localObject1).UzV = ((ezq)localObject1).wmw;
        ((ezq)localObject1).UzW = ((ezq)localObject1).wmw;
        ((ezq)localObject1).lzJ = localb.oiL;
        ((ezq)localObject1).UzX = l;
      }
      localObject1 = ((emr)localObject3).Upl;
      if (localObject1 != null)
      {
        ((dhb)localObject1).TNL = localb.zXg;
        localObject2 = ((emr)localObject3).Upk;
        if (localObject2 == null) {
          break label628;
        }
      }
    }
    label613:
    label623:
    label628:
    for (int i = (int)((ezq)localObject2).wmw;; i = 0)
    {
      ((dhb)localObject1).TNM = i;
      ((dhb)localObject1).TNW = localb.zXf;
      ((dhb)localObject1).TNN = localb.AUa;
      localObject1 = t.zXK;
      t.a.a((emr)localObject3, getTag());
      localObject1 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)com.tencent.mm.plugin.secdata.ui.a.a.a(localContext, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      localObject1 = new bid();
      if (localObject2 != null)
      {
        ((bid)localObject1).wmL = ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).sessionId;
        ((bid)localObject1).xkX = 106;
      }
      localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(localObject3);
      localObject3 = w.zYO;
      w.a((List)localObject2, (bid)localObject1, 0);
      this.ATW = new b();
      return;
      i = 0;
      break;
      i = 0;
      break label212;
      i = 0;
      break label356;
    }
  }
  
  public abstract void rm(boolean paramBoolean);
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$Companion;", "", "()V", "feedValidCache", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getFeedValidCache", "()Ljava/util/HashMap;", "isFeedValid", "id", "plugin-finder_release"})
  public static final class a
  {
    public static boolean Nt(long paramLong)
    {
      AppMethodBeat.i(274430);
      Boolean localBoolean = (Boolean)a.eid().get(Long.valueOf(paramLong));
      if (localBoolean != null)
      {
        boolean bool = localBoolean.booleanValue();
        AppMethodBeat.o(274430);
        return bool;
      }
      AppMethodBeat.o(274430);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "", "index", "", "(I)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "getIndex", "()I", "setIndex", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "retryPlayTimes", "getRetryPlayTimes", "setRetryPlayTimes", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"})
  public static final class b
  {
    int AUa;
    private int index;
    private boolean isAutoPlay;
    long oiL;
    int zXf;
    int zXg;
    
    public b()
    {
      AppMethodBeat.i(273716);
      this.index = 0;
      this.oiL = cm.bfE();
      this.isAutoPlay = true;
      AppMethodBeat.o(273716);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if (this.index != paramObject.index) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return this.index;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(273717);
      String str = "StatRecord(index=" + this.index + ")";
      AppMethodBeat.o(273717);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "cgiBack", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetCommentDetailResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(a parama) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$checkFeedValidFromServer$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(a.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */