package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.f.a;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"})
public final class c
  implements ab.b
{
  public static final a sEr;
  private final d.f rTW;
  
  static
  {
    AppMethodBeat.i(204082);
    sEr = new a((byte)0);
    AppMethodBeat.o(204082);
  }
  
  public c()
  {
    AppMethodBeat.i(204081);
    this.rTW = d.g.O((a)c.sEx);
    AppMethodBeat.o(204081);
  }
  
  public final au.b aBK()
  {
    AppMethodBeat.i(204079);
    au.b localb = (au.b)new b();
    AppMethodBeat.o(204079);
    return localb;
  }
  
  public final boolean ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(204080);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(204080);
      return false;
    }
    if ((paramInt == 2) || (an.aUu(paramString)) || (an.aji(paramString)) || (an.aUt(paramString)))
    {
      AppMethodBeat.o(204080);
      return true;
    }
    AppMethodBeat.o(204080);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"})
  public static final class b
    implements au.b
  {
    public final void Bt(String paramString) {}
    
    public final void Bu(String paramString) {}
    
    public final void a(String paramString1, String paramString2, final au.b.a parama)
    {
      AppMethodBeat.i(204076);
      if (paramString1 != null)
      {
        final y.f localf = new y.f();
        localf.NiY = paramString1;
        if (an.aji(paramString1))
        {
          paramString2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajf(paramString1);
          d.g.b.p.g(paramString2, "MMKernel.service(IFinder…TalkerFromLocal(username)");
          localf.NiY = paramString2;
          paramString2 = paramString1;
        }
        for (;;)
        {
          ae.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.NiY);
          if (!an.aUu((String)localf.NiY)) {
            break;
          }
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a((String)localf.NiY, (f.a)new a(paramString1, localf, parama));
          AppMethodBeat.o(204076);
          return;
          paramString2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).ajg(paramString1);
          d.g.b.p.g(paramString2, "MMKernel.service(IFinder…sionIdFromLocal(username)");
        }
        if (an.aUt((String)localf.NiY)) {
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a((String)localf.NiY, paramString2, (f.a)new b(paramString1, localf, parama));
        }
        AppMethodBeat.o(204076);
        return;
      }
      AppMethodBeat.o(204076);
    }
    
    public final void aBI() {}
    
    public final void aJ(String paramString1, String paramString2) {}
    
    public final void g(String paramString1, int paramInt, String paramString2) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class a
      implements f.a
    {
      a(String paramString, y.f paramf, au.b.a parama) {}
      
      public final void c(final r paramr)
      {
        AppMethodBeat.i(204073);
        com.tencent.mm.ac.c.h((a)new q(paramr) {});
        AppMethodBeat.o(204073);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class b
      implements f.a
    {
      b(String paramString, y.f paramf, au.b.a parama) {}
      
      public final void c(final r paramr)
      {
        AppMethodBeat.i(204075);
        com.tencent.mm.ac.c.h((a)new q(paramr) {});
        AppMethodBeat.o(204075);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements a<w>
  {
    public static final c sEx;
    
    static
    {
      AppMethodBeat.i(204078);
      sEx = new c();
      AppMethodBeat.o(204078);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.c
 * JD-Core Version:    0.7.0.1
 */