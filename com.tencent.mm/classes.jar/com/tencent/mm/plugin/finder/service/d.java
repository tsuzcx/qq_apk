package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.finder.storage.af;
import com.tencent.mm.plugin.findersdk.a.ab;
import com.tencent.mm.plugin.findersdk.a.ai;
import com.tencent.mm.plugin.findersdk.a.m;
import com.tencent.mm.plugin.findersdk.a.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"})
public final class d
  implements af.b
{
  public static final a Adn;
  private final f xgB;
  
  static
  {
    AppMethodBeat.i(275796);
    Adn = new a((byte)0);
    AppMethodBeat.o(275796);
  }
  
  public d()
  {
    AppMethodBeat.i(275794);
    this.xgB = g.ar((a)c.Adu);
    AppMethodBeat.o(275794);
  }
  
  public final boolean aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(275793);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(275793);
      return false;
    }
    if ((paramInt == 2) || (as.bvP(paramString)) || (as.aEF(paramString)) || (as.bvN(paramString)))
    {
      AppMethodBeat.o(275793);
      return true;
    }
    AppMethodBeat.o(275793);
    return false;
  }
  
  public final az.b bel()
  {
    AppMethodBeat.i(275792);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(275792);
    return localb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"})
  public static final class b
    implements az.b
  {
    public final void Rr(String paramString) {}
    
    public final void Rs(String paramString) {}
    
    public final void a(String paramString1, String paramString2, final az.b.a parama)
    {
      AppMethodBeat.i(248247);
      if (paramString1 != null)
      {
        final aa.f localf = new aa.f();
        localf.aaBC = paramString1;
        paramString2 = "";
        if (as.aEF(paramString1))
        {
          paramString2 = ((ab)h.ae(ab.class)).aED(paramString1);
          p.j(paramString2, "MMKernel.service(IFinder…TalkerFromLocal(username)");
          localf.aaBC = paramString2;
          paramString2 = paramString1;
        }
        Log.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.aaBC);
        if (as.bvP((String)localf.aaBC))
        {
          ((m)h.ae(m.class)).a((String)localf.aaBC, (m.a)new a(paramString1, localf, parama));
          AppMethodBeat.o(248247);
          return;
        }
        if (as.bvN((String)localf.aaBC))
        {
          paramString2 = ((ab)h.ae(ab.class)).dX(paramString1, 3);
          p.j(paramString2, "MMKernel.service(IFinder…E_ALIAS_ROLE_TYPE_FINDER)");
          ((m)h.ae(m.class)).a((String)localf.aaBC, paramString2, (m.a)new b(paramString1, localf, parama));
          AppMethodBeat.o(248247);
          return;
        }
        if (as.bvO((String)localf.aaBC))
        {
          paramString2 = ((ab)h.ae(ab.class)).dX(paramString1, 2);
          p.j(paramString2, "MMKernel.service(IFinder…VE_ALIAS_ROLE_TYPE_ALIAS)");
          ((m)h.ae(m.class)).b((String)localf.aaBC, paramString2, (m.a)new c(paramString1, localf, parama));
        }
        AppMethodBeat.o(248247);
        return;
      }
      AppMethodBeat.o(248247);
    }
    
    public final void aP(String paramString1, String paramString2) {}
    
    public final void bej() {}
    
    public final void h(String paramString1, int paramInt, String paramString2) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class a
      implements m.a
    {
      a(String paramString, aa.f paramf, az.b.a parama) {}
      
      public final void d(final ai paramai)
      {
        AppMethodBeat.i(273941);
        com.tencent.mm.ae.d.uiThread((a)new q(paramai) {});
        AppMethodBeat.o(273941);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class b
      implements m.a
    {
      b(String paramString, aa.f paramf, az.b.a parama) {}
      
      public final void d(final ai paramai)
      {
        AppMethodBeat.i(289353);
        com.tencent.mm.ae.d.uiThread((a)new q(paramai) {});
        AppMethodBeat.o(289353);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class c
      implements m.a
    {
      c(String paramString, aa.f paramf, az.b.a parama) {}
      
      public final void d(final ai paramai)
      {
        AppMethodBeat.i(288913);
        com.tencent.mm.ae.d.uiThread((a)new q(paramai) {});
        AppMethodBeat.o(288913);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements a<af>
  {
    public static final c Adu;
    
    static
    {
      AppMethodBeat.i(291662);
      Adu = new c();
      AppMethodBeat.o(291662);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.d
 * JD-Core Version:    0.7.0.1
 */