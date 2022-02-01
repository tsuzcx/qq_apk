package com.tencent.mm.am;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.storage.bu;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "doReportChattingItemClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "reportChattingItemClick", "BizKFReportMsgType", "plugin-biz_release"})
public final class b
{
  public static final b hPG;
  
  static
  {
    AppMethodBeat.i(207290);
    hPG = new b();
    AppMethodBeat.o(207290);
  }
  
  public static final void b(bu parambu, final k.b paramb)
  {
    AppMethodBeat.i(207289);
    if (parambu == null)
    {
      AppMethodBeat.o(207289);
      return;
    }
    if (parambu.VR() == 1)
    {
      AppMethodBeat.o(207289);
      return;
    }
    h.LTJ.aT((Runnable)new a(parambu, paramb));
    AppMethodBeat.o(207289);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bu parambu, k.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(207288);
      b localb = b.hPG;
      b.c(this.hPH, paramb);
      AppMethodBeat.o(207288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.am.b
 * JD-Core Version:    0.7.0.1
 */