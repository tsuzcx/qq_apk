package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.protocal.protobuf.daw;

public final class t$a
  extends n.b
{
  public t$a(t paramt)
  {
    super(paramt);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(152162);
    paramContext = new so();
    paramContext.cIQ.userName = this.nad.nab.Username;
    paramContext.cIQ.appId = this.nad.nab.woB;
    paramContext.cIQ.cIT = this.nad.nab.yhf;
    paramContext.cIQ.cIS = this.nad.nab.nuv;
    paramContext.cIQ.scene = 1027;
    com.tencent.mm.sdk.b.a.ymk.l(paramContext);
    AppMethodBeat.o(152162);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.t.a
 * JD-Core Version:    0.7.0.1
 */