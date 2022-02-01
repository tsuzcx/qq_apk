package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa.b;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.i.a.f.a;
import com.tencent.mm.plugin.i.a.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.a.a;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"})
public final class c
  implements aa.b
{
  public static final a sug;
  private final d.f rLJ;
  
  static
  {
    AppMethodBeat.i(203522);
    sug = new a((byte)0);
    AppMethodBeat.o(203522);
  }
  
  public c()
  {
    AppMethodBeat.i(203521);
    this.rLJ = d.g.O((a)c.sun);
    AppMethodBeat.o(203521);
  }
  
  public final as.b aBu()
  {
    AppMethodBeat.i(203519);
    as.b localb = (as.b)new b();
    AppMethodBeat.o(203519);
    return localb;
  }
  
  public final boolean af(String paramString, int paramInt)
  {
    AppMethodBeat.i(203520);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(203520);
      return false;
    }
    if ((paramInt == 2) || (am.aSU(paramString)) || (am.ail(paramString)) || (am.aST(paramString)))
    {
      AppMethodBeat.o(203520);
      return true;
    }
    AppMethodBeat.o(203520);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"})
  public static final class b
    implements as.b
  {
    public final void AJ(String paramString) {}
    
    public final void AK(String paramString) {}
    
    public final void a(String paramString1, String paramString2, final as.b.a parama)
    {
      AppMethodBeat.i(203516);
      if (paramString1 != null)
      {
        final y.f localf = new y.f();
        localf.MLV = paramString1;
        if (am.ail(paramString1))
        {
          paramString2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aii(paramString1);
          d.g.b.p.g(paramString2, "MMKernel.service(IFinder…TalkerFromLocal(username)");
          localf.MLV = paramString2;
          paramString2 = paramString1;
        }
        for (;;)
        {
          ad.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.MLV);
          if (!am.aSU((String)localf.MLV)) {
            break;
          }
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a((String)localf.MLV, (f.a)new a(paramString1, localf, parama));
          AppMethodBeat.o(203516);
          return;
          paramString2 = ((com.tencent.mm.plugin.i.a.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.p.class)).aij(paramString1);
          d.g.b.p.g(paramString2, "MMKernel.service(IFinder…sionIdFromLocal(username)");
        }
        if (am.aST((String)localf.MLV)) {
          ((com.tencent.mm.plugin.i.a.f)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.f.class)).a((String)localf.MLV, paramString2, (f.a)new b(paramString1, localf, parama));
        }
        AppMethodBeat.o(203516);
        return;
      }
      AppMethodBeat.o(203516);
    }
    
    public final void aBs() {}
    
    public final void aI(String paramString1, String paramString2) {}
    
    public final void g(String paramString1, int paramInt, String paramString2) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class a
      implements f.a
    {
      a(String paramString, y.f paramf, as.b.a parama) {}
      
      public final void c(final r paramr)
      {
        AppMethodBeat.i(203513);
        com.tencent.mm.ad.c.g((a)new q(paramr) {});
        AppMethodBeat.o(203513);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class b
      implements f.a
    {
      b(String paramString, y.f paramf, as.b.a parama) {}
      
      public final void c(final r paramr)
      {
        AppMethodBeat.i(203515);
        com.tencent.mm.ad.c.g((a)new q(paramr) {});
        AppMethodBeat.o(203515);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements a<w>
  {
    public static final c sun;
    
    static
    {
      AppMethodBeat.i(203518);
      sun = new c();
      AppMethodBeat.o(203518);
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