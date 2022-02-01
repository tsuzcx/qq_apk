package com.tencent.mm.plugin.appbrand.jsapi.auth.entity;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.sdk.platformtools.aq;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class b$b
  implements b<IPCInteger, IPCBoolean>
{
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/auth/entity/WxaUserInfoListOperationController$DeleteUserTask$invoke$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-appbrand-integration_release"})
  public static final class a
    implements f
  {
    a(d paramd, com.tencent.mm.modelsimple.g paramg) {}
    
    public final void onSceneEnd(final int paramInt1, final int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(180456);
      aq.f((Runnable)new a(this, paramInt1, paramInt2));
      com.tencent.mm.kernel.g.aiU().b(this.kAf.getType(), (f)this);
      AppMethodBeat.o(180456);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.b.a parama, int paramInt1, int paramInt2) {}
      
      public final void run()
      {
        AppMethodBeat.i(180455);
        d locald = this.kAg.jDK;
        if (locald != null)
        {
          if ((paramInt1 == 0) && (paramInt2 == 0)) {}
          for (boolean bool = true;; bool = false)
          {
            locald.be(new IPCBoolean(bool));
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