package com.tencent.mm.emoji.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bs;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/report/EmojiResReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;)V", "load", "", "success", "", "setVersion", "oldVersion", "", "newVersion", "unzip", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public bs mmv;
  
  public f()
  {
    AppMethodBeat.i(242728);
    this.mmv = new bs();
    AppMethodBeat.o(242728);
  }
  
  public final void dR(int paramInt1, int paramInt2)
  {
    this.mmv.ius = paramInt1;
    this.mmv.iut = paramInt2;
  }
  
  public final void fm(boolean paramBoolean)
  {
    this.mmv.iuv = 1;
    if (paramBoolean)
    {
      this.mmv.iuq = 1L;
      this.mmv.ijg = 0L;
      return;
    }
    this.mmv.iuq = 2L;
    this.mmv.ijg = 1L;
  }
  
  public final void fn(boolean paramBoolean)
  {
    this.mmv.iuv = 2;
    if (paramBoolean)
    {
      this.mmv.iuq = 1L;
      this.mmv.ijg = 0L;
      return;
    }
    this.mmv.iuq = 2L;
    this.mmv.ijg = 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.d.f
 * JD-Core Version:    0.7.0.1
 */