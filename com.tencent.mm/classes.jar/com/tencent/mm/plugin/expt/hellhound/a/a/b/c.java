package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "samplingStrategy", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "stagety", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "sendOnScroll", "", "listView", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "STRATEGY", "plugin-expt_release"})
public final class c
{
  private final e whP;
  private f wiq;
  
  public c(e parame, String paramString, a parama)
  {
    AppMethodBeat.i(253291);
    this.whP = parame;
    int i = a.dcn();
    if (i <= a.wir.wiu)
    {
      parama = a.wir;
      switch (d.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(253291);
      return;
      if (i < a.wis.wiu) {
        break;
      }
      parama = a.wis;
      break;
      this.wiq = ((f)new d(this.whP, paramString));
      AppMethodBeat.o(253291);
      return;
      this.wiq = ((f)new b(this.whP, i));
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(253287);
    f localf = this.wiq;
    if (localf != null)
    {
      localf.a(paramAbsListView, paramInt);
      AppMethodBeat.o(253287);
      return;
    }
    AppMethodBeat.o(253287);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253289);
    f localf = this.wiq;
    if (localf != null)
    {
      localf.a(paramAbsListView, paramInt1, paramInt2);
      AppMethodBeat.o(253289);
      return;
    }
    AppMethodBeat.o(253289);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "", "stagety", "", "(Ljava/lang/String;II)V", "getStagety", "()I", "STRATEGY_SPEED", "STRATEGY_SAMPLING", "plugin-expt_release"})
  public static enum a
  {
    final int wiu;
    
    static
    {
      AppMethodBeat.i(256283);
      a locala1 = new a("STRATEGY_SPEED", 0, 0);
      wir = locala1;
      a locala2 = new a("STRATEGY_SAMPLING", 1, 1);
      wis = locala2;
      wit = new a[] { locala1, locala2 };
      AppMethodBeat.o(256283);
    }
    
    private a(int paramInt)
    {
      this.wiu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */