package com.tencent.mm.plugin.expt.hellhound.ext.a.b;

import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy;", "", "callback", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "pageName", "", "samplingStrategy", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "(Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;Ljava/lang/String;Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;)V", "getCallback", "()Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingCallback;", "stagety", "Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/IHellSamplingStagety;", "sendOnScroll", "", "listView", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "sendOnScrollStateChanged", "scrollState", "STRATEGY", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final d zDM;
  private e zEt;
  
  public c(d paramd, String paramString, a parama)
  {
    AppMethodBeat.i(300137);
    this.zDM = paramd;
    int i = a.dIQ();
    if (i <= a.zEv.zEu)
    {
      parama = a.zEv;
      switch (b.$EnumSwitchMapping$0[parama.ordinal()])
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(300137);
      return;
      if (i < a.zEw.zEu) {
        break;
      }
      parama = a.zEw;
      break;
      this.zEt = ((e)new com.tencent.mm.plugin.expt.hellhound.ext.a.d(this.zDM, paramString));
      AppMethodBeat.o(300137);
      return;
      this.zEt = ((e)new b(this.zDM, i));
    }
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(300142);
    e locale = this.zEt;
    if (locale != null) {
      locale.a(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(300142);
  }
  
  public final void a(AbsListView paramAbsListView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(300145);
    e locale = this.zEt;
    if (locale != null) {
      locale.a(paramAbsListView, paramInt1, paramInt2);
    }
    AppMethodBeat.o(300145);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/feed/report/HellScrollSamplingStrategy$STRATEGY;", "", "stagety", "", "(Ljava/lang/String;II)V", "getStagety", "()I", "STRATEGY_SPEED", "STRATEGY_SAMPLING", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    final int zEu;
    
    static
    {
      AppMethodBeat.i(300167);
      zEv = new a("STRATEGY_SPEED", 0, 0);
      zEw = new a("STRATEGY_SAMPLING", 1, 1);
      zEx = new a[] { zEv, zEw };
      AppMethodBeat.o(300167);
    }
    
    private a(int paramInt)
    {
      this.zEu = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.a.b.c
 * JD-Core Version:    0.7.0.1
 */