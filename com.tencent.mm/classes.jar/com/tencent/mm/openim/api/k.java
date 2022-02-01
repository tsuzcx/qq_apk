package com.tencent.mm.openim.api;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/api/OpenIMKefuOpContactRequest;", "", "username", "", "(Ljava/lang/String;)V", "callback", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "getCallback", "()Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;", "setCallback", "(Lcom/tencent/mm/openim/api/IOpenIMKefuService$OpContactCallback;)V", "data", "Landroid/os/Bundle;", "getData", "()Landroid/os/Bundle;", "setData", "(Landroid/os/Bundle;)V", "opType", "", "getOpType", "()I", "setOpType", "(I)V", "getUsername", "()Ljava/lang/String;", "Companion", "OpContactType", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k.a prs;
  private static final String pru;
  private static final String prv;
  public Bundle hPH;
  public int opType;
  public c.b prt;
  public final String username;
  
  static
  {
    AppMethodBeat.i(235775);
    prs = new k.a((byte)0);
    pru = "key_url";
    prv = "key_add_contact_context";
    AppMethodBeat.o(235775);
  }
  
  public k(String paramString)
  {
    AppMethodBeat.i(235772);
    this.username = paramString;
    AppMethodBeat.o(235772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.api.k
 * JD-Core Version:    0.7.0.1
 */