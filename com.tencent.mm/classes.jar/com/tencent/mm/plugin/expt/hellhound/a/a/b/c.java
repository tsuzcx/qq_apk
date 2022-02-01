package com.tencent.mm.plugin.expt.hellhound.a.a.b;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "samplingStrategy", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "stagety", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "sendOnScroll", "", "listView", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "STRATEGY", "plugin-expt_release"})
public final class c
{
  private final e sBU;
  private f sCw;
  
  public c(e parame, String paramString, a parama)
  {
    AppMethodBeat.i(220808);
    this.sBU = parame;
    int i = a.cNv();
    if (i <= a.sCx.sCA)
    {
      parama = a.sCx;
      switch (d.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(220808);
      return;
      if (i < a.sCy.sCA) {
        break;
      }
      parama = a.sCy;
      break;
      this.sCw = ((f)new d(this.sBU, paramString));
      AppMethodBeat.o(220808);
      return;
      this.sCw = ((f)new b(this.sBU, i));
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(220806);
    f localf = this.sCw;
    if (localf != null)
    {
      localf.a(paramAbsListView, paramInt);
      AppMethodBeat.o(220806);
      return;
    }
    AppMethodBeat.o(220806);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220807);
    f localf = this.sCw;
    if (localf != null)
    {
      localf.a(paramAbsListView, paramInt1, paramInt2);
      AppMethodBeat.o(220807);
      return;
    }
    AppMethodBeat.o(220807);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "", "stagety", "", "(Ljava/lang/String;II)V", "getStagety", "()I", "STRATEGY_SPEED", "STRATEGY_SAMPLING", "plugin-expt_release"})
  public static enum a
  {
    final int sCA;
    
    static
    {
      AppMethodBeat.i(220802);
      a locala1 = new a("STRATEGY_SPEED", 0, 0);
      sCx = locala1;
      a locala2 = new a("STRATEGY_SAMPLING", 1, 1);
      sCy = locala2;
      sCz = new a[] { locala1, locala2 };
      AppMethodBeat.o(220802);
    }
    
    private a(int paramInt)
    {
      this.sCA = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */