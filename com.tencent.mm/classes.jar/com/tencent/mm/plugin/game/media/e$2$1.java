package com.tencent.mm.plugin.game.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.game.report.b.a;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;
import java.util.Map;

final class e$2$1
  implements b.a
{
  e$2$1(e.2 param2, long paramLong) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(151809);
    ab.i("MicroMsg.GameHaowanPublishImpl", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.nlg.nld.put("costtime", Long.valueOf(System.currentTimeMillis() - this.fET));
    this.nlg.nld.put("topicid", Integer.valueOf(((c)paramb.fsW.fta).niP));
    int i = i.xc(this.nlg.nlf);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bEV();
      paramb = this.nlg.hwk;
      LinkedList localLinkedList = new LinkedList();
      localLinkedList.add(paramb);
      paramString.Y(localLinkedList);
      e.cs(this.nlg.hwk, 0);
      a.a(ah.getContext(), 8765, 0, 48, a.a(i, this.nlg.nld));
      AppMethodBeat.o(151809);
      return;
    }
    ((com.tencent.mm.plugin.game.api.e)g.E(com.tencent.mm.plugin.game.api.e.class)).bEV().PZ(this.nlg.hwk);
    paramString = this.nlg.hwk;
    if (paramInt2 > 0) {}
    for (paramInt1 = -paramInt2;; paramInt1 = paramInt2)
    {
      e.cs(paramString, paramInt1);
      this.nlg.nld.put("failid", Integer.valueOf(paramInt2));
      a.a(ah.getContext(), 8765, 0, 56, a.a(i, this.nlg.nld));
      AppMethodBeat.o(151809);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.e.2.1
 * JD-Core Version:    0.7.0.1
 */