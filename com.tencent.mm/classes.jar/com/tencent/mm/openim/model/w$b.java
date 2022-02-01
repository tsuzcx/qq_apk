package com.tencent.mm.openim.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/openim/model/OpenIMKefuConfirmController$addKefuConversation$request$1$2", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "onOpFailed", "", "opType", "", "errType", "errCode", "errMsg", "", "data", "Landroid/os/Bundle;", "onOpSuccess", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w$b
  implements c.b
{
  w$b(w paramw) {}
  
  public final void bRY()
  {
    AppMethodBeat.i(235791);
    Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo createOpenImKfConversation success cancelled: %s", new Object[] { Boolean.valueOf(w.e(this.psU)) });
    w.h(this.psU);
    AppMethodBeat.o(235791);
  }
  
  public final void o(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(235795);
    Log.e("MicroMsg.OpenIMKefuConfirmController", "alvinluo createOpenImKfConversation failed errType: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
    w.i(this.psU);
    AppMethodBeat.o(235795);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.model.w.b
 * JD-Core Version:    0.7.0.1
 */