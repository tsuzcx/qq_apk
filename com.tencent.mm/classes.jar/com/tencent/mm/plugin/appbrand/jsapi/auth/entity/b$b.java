package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class b$b
  implements d<IPCInteger, IPCBoolean>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask$invoke$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements i
  {
    a(f paramf, com.tencent.mm.modelsimple.h paramh) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(180456);
      MMHandlerThread.postToMainThread((Runnable)new a(this, paramInt1, paramInt2));
      com.tencent.mm.kernel.h.aGY().b(this.oEe.getType(), (i)this);
      AppMethodBeat.o(180456);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.a parama, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(180455);
        f localf = this.oEf.nyL;
        if (localf != null)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0)) {}
          for (boolean bool = true;; bool = false)
          {
            localf.aH(new IPCBoolean(bool));
            AppMethodBeat.o(180455);
            return;
          }
        }
        AppMethodBeat.o(180455);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.b
 * JD-Core Version:    0.7.0.1
 */