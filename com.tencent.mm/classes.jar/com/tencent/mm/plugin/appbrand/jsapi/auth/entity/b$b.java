package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b$b
  implements d<IPCInteger, IPCBoolean>
{
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask$invoke$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.am.h
  {
    a(j paramj, f<IPCBoolean> paramf) {}
    
    private static final void a(f paramf, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(326951);
      if (paramf != null) {
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label39;
        }
      }
      label39:
      for (boolean bool = true;; bool = false)
      {
        paramf.onCallback(new IPCBoolean(bool));
        AppMethodBeat.o(326951);
        return;
      }
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(180456);
      MMHandlerThread.postToMainThread(new b.b.a..ExternalSyntheticLambda0(this.mht, paramInt1, paramInt2));
      com.tencent.mm.kernel.h.aZW().b(this.rHt.getType(), (com.tencent.mm.am.h)this);
      AppMethodBeat.o(180456);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.b
 * JD-Core Version:    0.7.0.1
 */