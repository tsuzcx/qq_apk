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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback;", "", "()V", "mMethodMap", "Ljava/util/HashMap;", "", "", "Landroid/util/Pair;", "mRLBeginListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1;", "startMonitor", "", "Companion", "plugin-expt_release"})
public final class h
{
  public static final a qnv;
  final HashMap<String, List<Pair<String, String>>> qmF;
  final b qnu;
  
  static
  {
    AppMethodBeat.i(195457);
    qnv = new a((byte)0);
    AppMethodBeat.o(195457);
  }
  
  public h()
  {
    AppMethodBeat.i(195456);
    this.qmF = new HashMap();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onRefreshBegin", "(I)V"));
    localArrayList.add(Pair.create("onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    localArrayList.add(Pair.create("onLoadMoreBegin", "()V"));
    localArrayList.add(Pair.create("onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V"));
    ((Map)this.qmF).put("com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", localArrayList);
    this.qnu = new b();
    AppMethodBeat.o(195456);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$Companion;", "", "()V", "DESC_onLoadMoreBegin", "", "DESC_onLoadMoreEnd", "DESC_onRefreshBegin", "DESC_onRefreshEnd", "NAME_onLoadMoreBegin", "NAME_onLoadMoreEnd", "NAME_onRefreshBegin", "NAME_onRefreshEnd", "SUPER_NAME", "TAG", "plugin-expt_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
  public static final class b
    implements c
  {
    public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
    {
      AppMethodBeat.i(195455);
      if ((k.g(paramString2, "onRefreshBegin")) && (k.g(paramString3, "(I)V")))
      {
        j.qnH.cjx();
        AppMethodBeat.o(195455);
        return;
      }
      if ((k.g(paramString2, "onLoadMoreBegin")) && (k.g(paramString3, "()V"))) {
        j.qnH.bTG();
      }
      AppMethodBeat.o(195455);
    }
    
    public final void f(String paramString, Object paramObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.h
 * JD-Core Version:    0.7.0.1
 */