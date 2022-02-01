package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.appbrand.ui.a.a;
import com.tencent.mm.protocal.protobuf.gng;
import com.tencent.mm.protocal.protobuf.hu;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandAuthorizeScopeModifyObserver$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/plugin/appbrand/ui/authrize/OnWxaAuthorizeScopeModifyEvent;", "callback", "", "event", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandAuthorizeScopeModifyObserver$listener$1
  extends IListener<a>
{
  AppBrandAuthorizeScopeModifyObserver$listener$1(b paramb, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(323034);
    AppMethodBeat.o(323034);
  }
  
  private static final void a(b paramb, a parama)
  {
    AppMethodBeat.i(323049);
    s.u(paramb, "this$0");
    s.u(parama, "$event");
    paramb = b.a(paramb);
    String str = parama.username;
    Object localObject = (Iterable)parama.ugF;
    parama = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    if (((Iterator)localObject).hasNext())
    {
      hu localhu = (hu)((Iterator)localObject).next();
      gng localgng = new gng();
      localgng.scope = localhu.scope;
      localgng.desc = localhu.YJc;
      ah localah = ah.aiuX;
      if (1 == localhu.state) {}
      for (boolean bool = true;; bool = false)
      {
        parama.add(new e(localgng, bool));
        break;
      }
    }
    paramb.invoke(new i(str, (List)parama));
    AppMethodBeat.o(323049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.AppBrandAuthorizeScopeModifyObserver.listener.1
 * JD-Core Version:    0.7.0.1
 */