package com.tencent.mm.plugin.hld.c;

import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/dict/WxImeDictFetcher$IPCGetImeDictListConfig;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-hld_release"})
public final class a$c
  implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class a
    implements aa.a
  {
    a(f paramf) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, final q paramq)
    {
      AppMethodBeat.i(214633);
      paramq = new Bundle();
      paramq.putInt("errType", paramInt1);
      paramq.putInt("errCode", paramInt2);
      paramq.putString("errMsg", paramString);
      p.j(paramd, "rr");
      paramq.putByteArray("resp", paramd.bhY().toByteArray());
      h.ZvG.be((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209602);
          this.DvK.nyL.aH(paramq);
          AppMethodBeat.o(209602);
        }
      });
      AppMethodBeat.o(214633);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.c.a.c
 * JD-Core Version:    0.7.0.1
 */