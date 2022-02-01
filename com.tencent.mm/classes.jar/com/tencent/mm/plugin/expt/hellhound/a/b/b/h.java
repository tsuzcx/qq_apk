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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback;", "", "()V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "mRLBeginListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class h
{
  public static final h.a rev;
  final HashMap<String, List<Pair<String, String>>> rdA;
  final b reu;
  
  static
  {
    AppMethodBeat.i(196471);
    rev = new h.a((byte)0);
    AppMethodBeat.o(196471);
  }
  
  public h()
  {
    AppMethodBeat.i(196470);
    this.rdA = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onRefreshBegin", "(I)V"));
    localArrayList.add(Pair.create("onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    localArrayList.add(Pair.create("onLoadMoreBegin", "()V"));
    localArrayList.add(Pair.create("onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    ((Map)this.rdA).put("com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", localArrayList);
    this.reu = new b();
    AppMethodBeat.o(196470);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
    
    public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(196469);
      if ((p.i(paramString2, "onRefreshBegin")) && (p.i(paramString3, "(I)V")))
      {
        j.reI.cql();
        AppMethodBeat.o(196469);
        return;
      }
      if ((p.i(paramString2, "onLoadMoreBegin")) && (p.i(paramString3, "()V"))) {
        j.reI.bZA();
      }
      AppMethodBeat.o(196469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.h
 * JD-Core Version:    0.7.0.1
 */