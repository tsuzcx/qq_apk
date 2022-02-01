package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback;", "", "()V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "mRLBeginListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class h
{
  public static final a qWt;
  final HashMap<String, List<Pair<String, String>>> qVC;
  final b qWs;
  
  static
  {
    AppMethodBeat.i(210804);
    qWt = new a((byte)0);
    AppMethodBeat.o(210804);
  }
  
  public h()
  {
    AppMethodBeat.i(210803);
    this.qVC = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onRefreshBegin", "(I)V"));
    localArrayList.add(Pair.create("onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    localArrayList.add(Pair.create("onLoadMoreBegin", "()V"));
    localArrayList.add(Pair.create("onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    ((Map)this.qVC).put("com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", localArrayList);
    this.qWs = new b();
    AppMethodBeat.o(210803);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$Companion;", "", "()V", "DESC_onLoadMoreBegin", "", "DESC_onLoadMoreEnd", "DESC_onRefreshBegin", "DESC_onRefreshEnd", "NAME_onLoadMoreBegin", "NAME_onLoadMoreEnd", "NAME_onRefreshBegin", "NAME_onRefreshEnd", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(210802);
      if ((p.i(paramString2, "onRefreshBegin")) && (p.i(paramString3, "(I)V")))
      {
        j.qWF.coJ();
        AppMethodBeat.o(210802);
        return;
      }
      if ((p.i(paramString2, "onLoadMoreBegin")) && (p.i(paramString3, "()V"))) {
        j.qWF.bYl();
      }
      AppMethodBeat.o(210802);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.h
 * JD-Core Version:    0.7.0.1
 */