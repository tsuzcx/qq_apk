package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.af.a;
import com.tencent.mm.plugin.finder.report.ai;
import com.tencent.mm.plugin.textstatus.proto.l;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.ayl;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.dzj;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.protocal.protobuf.fvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vending.e.c;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView;", "Lcom/tencent/mm/ui/widget/IPullDownView;", "context", "Landroid/content/Context;", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "pullDownParam", "Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/FinderObject;Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;)V", "isCheckingValid", "", "isFeedValid", "()Z", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getPullDownParam", "()Lcom/tencent/mm/plugin/textstatus/proto/PullDownParam;", "record", "Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "getRecord", "()Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "setRecord", "(Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;)V", "checkFeedValidFromServer", "", "checkShowValidLayout", "isReplaceFinderObject", "onDestroy", "onPostClose", "onPreOpen", "reportStat", "feed", "stats", "Lcom/tencent/mm/protocal/protobuf/Stats;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "resetFinderObject", "Companion", "StatRecord", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a
  extends com.tencent.mm.ui.widget.b
{
  public static final a Gwp = new a((byte)0);
  private static final HashMap<Long, Boolean> Gws = new HashMap();
  private final c<com.tencent.mm.vending.e.a> AAh;
  private final FinderObject ABJ;
  final l DGY;
  private boolean Gwq;
  b Gwr;
  private final Context context;
  
  public a(Context paramContext, FinderObject paramFinderObject, l paraml)
  {
    this.context = paramContext;
    this.ABJ = paramFinderObject;
    this.DGY = paraml;
    this.AAh = new c();
    this.AAh.keep(a..ExternalSyntheticLambda1.INSTANCE);
    this.Gwr = new b();
  }
  
  private static final ah a(a parama, b.a parama1)
  {
    s.u(parama, "this$0");
    Log.i(parama.getTag(), "[checkFeedValid] errType=" + parama1.errType + " errCode=" + parama1.errCode + " requestId=" + parama.ABJ.id + ' ');
    boolean bool;
    if ((parama1.errType == 0) && (parama1.errCode == 0))
    {
      ((Map)Gws).put(Long.valueOf(parama.ABJ.id), Boolean.TRUE);
      FinderObject localFinderObject = parama.ABJ;
      s.u(localFinderObject, "finderObject");
      if (cn.getSyncServerTimeSecond() >= parama.DGY.ToQ + localFinderObject.urlValidDuration)
      {
        bool = true;
        Log.i(parama.getTag(), "[isReplaceFinderObject] result=" + bool + " feedId=" + d.hF(localFinderObject.id) + " statusCreateTime=" + parama.DGY.ToQ + " urlValidDuration=" + localFinderObject.urlValidDuration + " current=" + cn.getSyncServerTimeSecond());
        if (bool)
        {
          parama1 = ((ayl)parama1.ott).feedObject;
          if (parama1 != null)
          {
            parama.ABJ.parseFrom(parama1.toByteArray());
            d.uiThread((kotlin.g.a.a)new c(parama));
          }
        }
      }
    }
    for (;;)
    {
      parama.uN(parama.fkb());
      parama.Gwq = false;
      return ah.aiuX;
      bool = false;
      break;
      if ((parama1.errCode == -4011) || (parama1.errCode == -4033) || (parama1.errCode == -4036))
      {
        ((Map)Gws).put(Long.valueOf(parama.ABJ.id), Boolean.FALSE);
        h.baE().ban().set(at.a.adaR, parama1.errMsg);
      }
    }
  }
  
  private static final void bvy() {}
  
  public void H(FinderObject paramFinderObject)
  {
    s.u(paramFinderObject, "finderObject");
  }
  
  public void etL() {}
  
  public final boolean fkb()
  {
    return a.qZ(this.ABJ.id);
  }
  
  public final void fkc()
  {
    if (this.Gwq) {
      return;
    }
    this.Gwq = true;
    Log.i(getTag(), "checkFeedValidFromServer...");
    az localaz = new az(this.ABJ.id, this.ABJ.objectNonceId, 106, 2, "", true, null, null, 0L, null, false, false, null, null, 0, null, 57280);
    localaz.HcI = false;
    localaz.bFJ().b(new a..ExternalSyntheticLambda0(this)).a((com.tencent.mm.vending.e.b)this.AAh);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.Gwq = false;
    this.AAh.dead();
  }
  
  public void onPostClose()
  {
    super.onPostClose();
    Object localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
    Object localObject2 = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(this.context, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
    int i;
    if (localObject2 != null)
    {
      if (this.ABJ.objectDesc == null) {
        break label694;
      }
      localObject1 = this.ABJ.objectDesc;
      if (localObject1 != null) {
        break label607;
      }
      localObject1 = null;
      if (localObject1 == null) {
        break label694;
      }
      localObject1 = this.ABJ.objectDesc;
      s.checkNotNull(localObject1);
      localObject1 = ((FinderObjectDesc)localObject1).media;
      s.s(localObject1, "finderObject.objectDesc!!.media");
      localObject1 = (FinderMedia)kotlin.a.p.oL((List)localObject1);
      if (localObject1 != null) {
        break label617;
      }
      i = 0;
    }
    for (;;)
    {
      label112:
      if (i > 0) {
        this.Gwr.Gwt = ((int)(((com.tencent.mm.plugin.textstatus.proto.p)localObject2).Tpk / i + 1L));
      }
      Context localContext = this.context;
      FinderObject localFinderObject = this.ABJ;
      b localb = this.Gwr;
      s.u(localContext, "context");
      s.u(localFinderObject, "feed");
      s.u(localb, "record");
      Object localObject3 = new fhp();
      ((fhp)localObject3).hKN = localFinderObject.id;
      ((fhp)localObject3).objectNonceId = localFinderObject.objectNonceId;
      ((fhp)localObject3).abIi = new fvu();
      ((fhp)localObject3).abIj = new dzj();
      localObject1 = localFinderObject.objectDesc;
      if (localObject1 == null)
      {
        i = 0;
        label242:
        ((fhp)localObject3).mediaType = i;
        localObject2 = localFinderObject.username;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((fhp)localObject3).finderUsername = ((String)localObject1);
        ((fhp)localObject3).abIk = localb.rmn;
        localObject2 = localFinderObject.sessionBuffer;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        ((fhp)localObject3).sessionBuffer = ((String)localObject1);
        ((fhp)localObject3).abIr = localb.rmn;
        long l = cn.bDw();
        localObject1 = ((fhp)localObject3).abIi;
        if (localObject1 != null)
        {
          localObject2 = localFinderObject.objectDesc;
          if (localObject2 != null) {
            break label635;
          }
          i = 0;
          label354:
          ((fvu)localObject1).abTW = i;
          ((fvu)localObject1).QXQ = ((int)((l - localb.rmn) / 1000L));
          ((fvu)localObject1).zIy = (l - localb.rmn);
          ((fvu)localObject1).abTX = ((fvu)localObject1).zIy;
          ((fvu)localObject1).abTY = ((fvu)localObject1).zIy;
          ((fvu)localObject1).abTZ = ((fvu)localObject1).zIy;
          ((fvu)localObject1).ork = localb.rmn;
          ((fvu)localObject1).abUa = l;
        }
        localObject1 = ((fhp)localObject3).abIj;
        if (localObject1 != null)
        {
          ((dzj)localObject1).abeg = localb.FsM;
          localObject2 = ((fhp)localObject3).abIi;
          if (localObject2 != null) {
            break label684;
          }
        }
      }
      label684:
      for (i = 0;; i = (int)((fvu)localObject2).zIy)
      {
        ((dzj)localObject1).abeh = i;
        ((dzj)localObject1).abeq = localb.FsL;
        ((dzj)localObject1).abei = localb.Gwt;
        localObject1 = af.FsA;
        af.a.a((fhp)localObject3, getTag());
        localObject1 = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject2 = (com.tencent.mm.plugin.textstatus.proto.p)com.tencent.mm.plugin.secdata.ui.a.a.a(localContext, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
        localObject1 = new bui();
        if (localObject2 != null)
        {
          ((bui)localObject1).zIO = ((com.tencent.mm.plugin.textstatus.proto.p)localObject2).sessionId;
          ((bui)localObject1).AJo = 106;
        }
        localObject2 = new LinkedList();
        ((LinkedList)localObject2).add(localObject3);
        localObject3 = ai.FtE;
        ai.a((List)localObject2, (bui)localObject1, 0);
        this.Gwr = new b();
        return;
        label607:
        localObject1 = ((FinderObjectDesc)localObject1).media;
        break;
        label617:
        i = ((FinderMedia)localObject1).videoDuration;
        break label112;
        i = ((FinderObjectDesc)localObject1).mediaType;
        break label242;
        label635:
        localObject2 = ((FinderObjectDesc)localObject2).media;
        if (localObject2 == null)
        {
          i = 0;
          break label354;
        }
        localObject2 = (FinderMedia)kotlin.a.p.oL((List)localObject2);
        if (localObject2 == null)
        {
          i = 0;
          break label354;
        }
        i = ((FinderMedia)localObject2).videoDuration;
        break label354;
      }
      label694:
      i = 0;
    }
  }
  
  public abstract void uN(boolean paramBoolean);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$Companion;", "", "()V", "feedValidCache", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getFeedValidCache", "()Ljava/util/HashMap;", "isFeedValid", "id", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static boolean qZ(long paramLong)
    {
      AppMethodBeat.i(344649);
      Boolean localBoolean = (Boolean)a.fkd().get(Long.valueOf(paramLong));
      if (localBoolean == null)
      {
        AppMethodBeat.o(344649);
        return true;
      }
      boolean bool = localBoolean.booleanValue();
      AppMethodBeat.o(344649);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/BaseFinderTextStatusView$StatRecord;", "", "index", "", "(I)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "getIndex", "()I", "setIndex", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "retryPlayTimes", "getRetryPlayTimes", "setRetryPlayTimes", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    int FsL;
    int FsM;
    int Gwt;
    private int index;
    private boolean isAutoPlay;
    long rmn;
    
    public b()
    {
      AppMethodBeat.i(344638);
      this.index = 0;
      this.rmn = cn.bDw();
      this.isAutoPlay = true;
      AppMethodBeat.o(344638);
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof b)) {
          return false;
        }
        paramObject = (b)paramObject;
      } while (this.index == paramObject.index);
      return false;
    }
    
    public final int hashCode()
    {
      return this.index;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(344646);
      String str = "StatRecord(index=" + this.index + ')';
      AppMethodBeat.o(344646);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.a
 * JD-Core Version:    0.7.0.1
 */