package com.tencent.mm.openim.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.openim.api.a;
import com.tencent.mm.openim.api.c.a;
import com.tencent.mm.openim.api.e;
import com.tencent.mm.openim.api.e.a;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/openim/contact/OpenIMKefuContactCardContent$Companion$getShareCardMsgContent$1", "Lcom/tencent/mm/openim/api/IOpenIMKefuService$GetContactCallback;", "onFinish", "", "result", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "onTryFetch", "username", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$a$a
  implements c.a
{
  public e$a$a(PBool paramPBool, b<? super String, ah> paramb, String paramString1, String paramString2) {}
  
  public final void RF(String paramString) {}
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(236026);
    if (paramj == null) {}
    for (paramj = null; paramj == null; paramj = paramj.prp)
    {
      this.prS.value = false;
      Log.e("MicroMsg.OpenIMKefuContactCardContent", "alvinluo kefuCard getShareCardMsgContent contact invalid");
      this.$callback.invoke(null);
      AppMethodBeat.o(236026);
      return;
    }
    String str1 = ((e)h.ax(e.class)).cc(paramj.bRR(), paramj.bRS());
    String str2 = ((e)h.ax(e.class)).a(paramj.bRR(), "openim_desc_icon", e.a.prc, 1);
    am localam = am.aixg;
    paramj = String.format(this.prT, Arrays.copyOf(new Object[] { Util.escapeStringForXml(paramj.bRP()), Util.escapeStringForXml(paramj.bRQ()), Util.escapeStringForXml(paramj.getUsername()), Util.escapeStringForXml(paramj.getNickname()), Util.escapeStringForXml(paramj.bRR()), Util.escapeStringForXml(str1), Util.escapeStringForXml(str2) }, 7));
    s.s(paramj, "java.lang.String.format(format, *args)");
    Log.i("MicroMsg.OpenIMKefuContactCardContent", "alvinluo getShareCardMsgContent toSendUsername: %s, msgContent: %s", new Object[] { this.prU, paramj });
    this.$callback.invoke(paramj);
    this.prS.value = true;
    AppMethodBeat.o(236026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.a.e.a.a
 * JD-Core Version:    0.7.0.1
 */