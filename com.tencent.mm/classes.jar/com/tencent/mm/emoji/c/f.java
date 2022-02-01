package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/report/EmojiResReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;)V", "load", "", "success", "", "setVersion", "oldVersion", "", "newVersion", "unzip", "plugin-emojisdk_release"})
public final class f
{
  public ap hcm;
  
  public f()
  {
    AppMethodBeat.i(200002);
    this.hcm = new ap();
    AppMethodBeat.o(200002);
  }
  
  public final void cK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200001);
    this.hcm.jP(paramInt1);
    this.hcm.jQ(paramInt2);
    AppMethodBeat.o(200001);
  }
  
  public final void ee(boolean paramBoolean)
  {
    AppMethodBeat.i(199999);
    this.hcm.jR(1);
    if (paramBoolean)
    {
      this.hcm.cV(1L);
      this.hcm.cW(0L);
      AppMethodBeat.o(199999);
      return;
    }
    this.hcm.cV(2L);
    this.hcm.cW(1L);
    AppMethodBeat.o(199999);
  }
  
  public final void ef(boolean paramBoolean)
  {
    AppMethodBeat.i(200000);
    this.hcm.jR(2);
    if (paramBoolean)
    {
      this.hcm.cV(1L);
      this.hcm.cW(0L);
      AppMethodBeat.o(200000);
      return;
    }
    this.hcm.cV(2L);
    this.hcm.cW(1L);
    AppMethodBeat.o(200000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.c.f
 * JD-Core Version:    0.7.0.1
 */