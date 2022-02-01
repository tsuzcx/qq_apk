package com.tencent.mm.plugin.hld.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher$IPCCgiImeGetImeDict;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements d<Bundle, Bundle>
{
  private static final int a(f paramf, int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    AppMethodBeat.i(311483);
    s.u(paramf, "$callback");
    paramp = new Bundle();
    paramp.putInt("errType", paramInt1);
    paramp.putInt("errCode", paramInt2);
    paramp.putString("errMsg", paramString);
    paramp.putByteArray("resp", c.c.b(paramc.otC).toByteArray());
    h.ahAA.bm(new a.a..ExternalSyntheticLambda1(paramf, paramp));
    AppMethodBeat.o(311483);
    return 0;
  }
  
  private static final void c(f paramf, Bundle paramBundle)
  {
    AppMethodBeat.i(311478);
    s.u(paramf, "$callback");
    s.u(paramBundle, "$bundle");
    paramf.onCallback(paramBundle);
    AppMethodBeat.o(311478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.c.a.a
 * JD-Core Version:    0.7.0.1
 */