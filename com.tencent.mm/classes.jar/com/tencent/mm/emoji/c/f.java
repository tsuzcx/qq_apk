package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ax;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/report/EmojiResReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;)V", "load", "", "success", "", "setVersion", "oldVersion", "", "newVersion", "unzip", "plugin-emojisdk_release"})
public final class f
{
  public ax jNw;
  
  public f()
  {
    AppMethodBeat.i(228436);
    this.jNw = new ax();
    AppMethodBeat.o(228436);
  }
  
  public final void de(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228434);
    this.jNw.lj(paramInt1);
    this.jNw.lk(paramInt2);
    AppMethodBeat.o(228434);
  }
  
  public final void eB(boolean paramBoolean)
  {
    AppMethodBeat.i(228431);
    this.jNw.ll(1);
    if (paramBoolean)
    {
      this.jNw.dA(1L);
      this.jNw.dB(0L);
      AppMethodBeat.o(228431);
      return;
    }
    this.jNw.dA(2L);
    this.jNw.dB(1L);
    AppMethodBeat.o(228431);
  }
  
  public final void eC(boolean paramBoolean)
  {
    AppMethodBeat.i(228433);
    this.jNw.ll(2);
    if (paramBoolean)
    {
      this.jNw.dA(1L);
      this.jNw.dB(0L);
      AppMethodBeat.o(228433);
      return;
    }
    this.jNw.dA(2L);
    this.jNw.dB(1L);
    AppMethodBeat.o(228433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */