package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wj.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class MallIndexUI$10
  extends c<wj>
{
  MallIndexUI$10(MallIndexUI paramMallIndexUI)
  {
    AppMethodBeat.i(43214);
    this.__eventId = wj.class.getName().hashCode();
    AppMethodBeat.o(43214);
  }
  
  private static boolean a(wj paramwj)
  {
    AppMethodBeat.i(43215);
    paramwj = paramwj.cNU.cvF;
    ab.i("MicorMsg.MallIndexUI", "get result %s", new Object[] { paramwj });
    if ("agree_privacy".equals(paramwj))
    {
      g.RM();
      g.RL().Ru().set(ac.a.yKu, Boolean.TRUE);
    }
    AppMethodBeat.o(43215);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.10
 * JD-Core Version:    0.7.0.1
 */