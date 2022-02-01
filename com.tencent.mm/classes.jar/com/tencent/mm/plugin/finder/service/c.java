package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.finder.storage.ag;
import com.tencent.mm.plugin.i.a.aa;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.plugin.i.a.m;
import com.tencent.mm.plugin.i.a.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"})
public final class c
  implements af.b
{
  public static final a vvO;
  private final f tyR;
  
  static
  {
    AppMethodBeat.i(251461);
    vvO = new a((byte)0);
    AppMethodBeat.o(251461);
  }
  
  public c()
  {
    AppMethodBeat.i(251460);
    this.tyR = kotlin.g.ah((a)c.vvU);
    AppMethodBeat.o(251460);
  }
  
  public final ay.b aVi()
  {
    AppMethodBeat.i(251458);
    ay.b localb = (ay.b)new b();
    AppMethodBeat.o(251458);
    return localb;
  }
  
  public final boolean aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(251459);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251459);
      return false;
    }
    if ((paramInt == 2) || (as.bjt(paramString)) || (as.avl(paramString)) || (as.bjs(paramString)))
    {
      AppMethodBeat.o(251459);
      return true;
    }
    AppMethodBeat.o(251459);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"})
  public static final class b
    implements ay.b
  {
    public final void JZ(String paramString) {}
    
    public final void Ka(String paramString) {}
    
    public final void a(String paramString1, String paramString2, final ay.b.a parama)
    {
      AppMethodBeat.i(251455);
      if (paramString1 != null)
      {
        final z.f localf = new z.f();
        localf.SYG = paramString1;
        if (as.avl(paramString1))
        {
          paramString2 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avi(paramString1);
          p.g(paramString2, "MMKernel.service(IFinder…TalkerFromLocal(username)");
          localf.SYG = paramString2;
          paramString2 = paramString1;
        }
        for (;;)
        {
          Log.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.SYG);
          if (!as.bjt((String)localf.SYG)) {
            break;
          }
          ((m)com.tencent.mm.kernel.g.af(m.class)).a((String)localf.SYG, (m.a)new a(paramString1, localf, parama));
          AppMethodBeat.o(251455);
          return;
          paramString2 = ((aa)com.tencent.mm.kernel.g.af(aa.class)).avj(paramString1);
          p.g(paramString2, "MMKernel.service(IFinder…sionIdFromLocal(username)");
        }
        if (as.bjs((String)localf.SYG)) {
          ((m)com.tencent.mm.kernel.g.af(m.class)).a((String)localf.SYG, paramString2, (m.a)new b(paramString1, localf, parama));
        }
        AppMethodBeat.o(251455);
        return;
      }
      AppMethodBeat.o(251455);
    }
    
    public final void aL(String paramString1, String paramString2) {}
    
    public final void aVg() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class a
      implements m.a
    {
      a(String paramString, z.f paramf, ay.b.a parama) {}
      
      public final void c(final ah paramah)
      {
        AppMethodBeat.i(251452);
        d.h((a)new q(paramah) {});
        AppMethodBeat.o(251452);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "kotlin.jvm.PlatformType", "onDone"})
    static final class b
      implements m.a
    {
      b(String paramString, z.f paramf, ay.b.a parama) {}
      
      public final void c(final ah paramah)
      {
        AppMethodBeat.i(251454);
        d.h((a)new q(paramah) {});
        AppMethodBeat.o(251454);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "invoke"})
  static final class c
    extends q
    implements a<ag>
  {
    public static final c vvU;
    
    static
    {
      AppMethodBeat.i(251457);
      vvU = new c();
      AppMethodBeat.o(251457);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.c
 * JD-Core Version:    0.7.0.1
 */