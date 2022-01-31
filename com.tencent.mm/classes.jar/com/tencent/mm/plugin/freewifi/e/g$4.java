package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class g$4
  implements Runnable
{
  g$4(g paramg, String paramString, gm paramgm) {}
  
  public final void run()
  {
    AppMethodBeat.i(20816);
    Object localObject1 = g.OG(this.mLo);
    ab.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", new Object[] { localObject1, this.mLo });
    if (!bo.isNullOrNil((String)localObject1))
    {
      Object localObject2 = g.ew((String)localObject1, "res=");
      ab.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", new Object[] { localObject2, localObject1 });
      if ((!bo.isNullOrNil((String)localObject2)) && ((((String)localObject2).startsWith("success")) || (((String)localObject2).startsWith("already"))))
      {
        localObject1 = this.mLn.mLf;
        localObject2 = FreeWifiFrontPageUI.d.mNK;
        FreeWifiFrontPageUI.b localb = new FreeWifiFrontPageUI.b();
        localb.mNG = this.mLp;
        ((FreeWifiFrontPageUI)localObject1).a((FreeWifiFrontPageUI.d)localObject2, localb);
        AppMethodBeat.o(20816);
        return;
      }
    }
    g.c(this.mLn);
    AppMethodBeat.o(20816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.e.g.4
 * JD-Core Version:    0.7.0.1
 */