package com.tencent.mm.live.c;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveKickedPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "updateBgByUsername", "", "username", "plugin-logic_release"})
public final class ab
  extends a
{
  private final String TAG;
  private final View gBO;
  final b gzb;
  
  public ab(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190203);
    this.gzb = paramb;
    this.TAG = "MicroMsg.LiveKickedPlugin";
    this.gBO = paramViewGroup.findViewById(2131307645);
    this.gBO.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190201);
        b.b.a(this.gBP.gzb, b.c.gxL);
        AppMethodBeat.o(190201);
      }
    });
    AppMethodBeat.o(190203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.ab
 * JD-Core Version:    0.7.0.1
 */