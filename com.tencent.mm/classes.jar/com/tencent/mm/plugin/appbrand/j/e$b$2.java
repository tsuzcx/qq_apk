package com.tencent.mm.plugin.appbrand.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class e$b$2
  implements w.a
{
  e$b$2(e.b paramb) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, b paramb, m paramm)
  {
    AppMethodBeat.i(132280);
    paramString = (aqw)paramb.fsW.fta;
    ab.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg errType:%d errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramString.xgc != null) && (paramString.xgc.size() > 0))
    {
      ab.i("MicroMsg.WxaUpdateableMsgService", "getUpdateableMsg response.updatable_msg_list.size:%d", new Object[] { Integer.valueOf(paramString.xgc.size()) });
      e.b.a(this.irK, paramString);
      e.b.a(paramString);
      e.b.b(this.irK, paramString);
      e.b.b(this.irK);
    }
    AppMethodBeat.o(132280);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.j.e.b.2
 * JD-Core Version:    0.7.0.1
 */