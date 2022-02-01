package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback;", "", "()V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "mRLBeginListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class h
{
  public static final a KHh;
  final HashMap<String, List<Pair<String, String>>> KGr;
  final b KHg;
  
  static
  {
    AppMethodBeat.i(205198);
    KHh = new a((byte)0);
    AppMethodBeat.o(205198);
  }
  
  public h()
  {
    AppMethodBeat.i(205197);
    this.KGr = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onRefreshBegin", "(I)V"));
    localArrayList.add(Pair.create("onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    localArrayList.add(Pair.create("onLoadMoreBegin", "()V"));
    localArrayList.add(Pair.create("onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    ((Map)this.KGr).put("com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", localArrayList);
    this.KHg = new b();
    AppMethodBeat.o(205197);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$Companion;", "", "()V", "DESC_onLoadMoreBegin", "", "DESC_onLoadMoreEnd", "DESC_onRefreshBegin", "DESC_onRefreshEnd", "NAME_onLoadMoreBegin", "NAME_onLoadMoreEnd", "NAME_onRefreshBegin", "NAME_onRefreshEnd", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(205196);
      if ((k.g(paramString2, "onRefreshBegin")) && (k.g(paramString3, "(I)V")))
      {
        j.KHt.fRs();
        AppMethodBeat.o(205196);
        return;
      }
      if ((k.g(paramString2, "onLoadMoreBegin")) && (k.g(paramString3, "()V"))) {
        j.KHt.bMu();
      }
      AppMethodBeat.o(205196);
    }
    
    public final void g(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.h
 * JD-Core Version:    0.7.0.1
 */