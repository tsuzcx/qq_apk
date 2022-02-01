package com.tencent.mm.al;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.storage.bv;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/modelbiz/BizChattingItemReportHelper;", "", "()V", "TAG", "", "doReportChattingItemClick", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "reportChattingItemClick", "BizKFReportMsgType", "plugin-biz_release"})
public final class b
{
  public static final b hSy;
  
  static
  {
    AppMethodBeat.i(188752);
    hSy = new b();
    AppMethodBeat.o(188752);
  }
  
  public static final void b(bv parambv, final k.b paramb)
  {
    AppMethodBeat.i(188751);
    if (parambv == null)
    {
      AppMethodBeat.o(188751);
      return;
    }
    if (parambv.VZ() == 1)
    {
      AppMethodBeat.o(188751);
      return;
    }
    h.MqF.aQ((Runnable)new a(parambv, paramb));
    AppMethodBeat.o(188751);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bv parambv, k.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(188750);
      b localb = b.hSy;
      b.c(this.hSz, paramb);
      AppMethodBeat.o(188750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.b
 * JD-Core Version:    0.7.0.1
 */