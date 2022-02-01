package com.tencent.mm.plugin.finder.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.findersdk.a.bp;
import com.tencent.mm.plugin.findersdk.a.ch;
import com.tencent.mm.plugin.findersdk.a.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "scene", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements af.b
{
  public static final a Fza;
  private final j AFU;
  
  static
  {
    AppMethodBeat.i(330048);
    Fza = new a((byte)0);
    AppMethodBeat.o(330048);
  }
  
  public f()
  {
    AppMethodBeat.i(330040);
    this.AFU = k.cm((a)c.Fzd);
    AppMethodBeat.o(330040);
  }
  
  public final boolean aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(330065);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(330065);
      return false;
    }
    if ((paramInt == 2) || (au.bwV(paramString)) || (au.aAy(paramString)) || (au.bwT(paramString)))
    {
      AppMethodBeat.o(330065);
      return true;
    }
    AppMethodBeat.o(330065);
    return false;
  }
  
  public final az.b bCe()
  {
    AppMethodBeat.i(330055);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(330055);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/service/FinderGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements az.b
  {
    private static final void a(final String paramString, final ah.f paramf, final az.b.a parama, ch paramch)
    {
      AppMethodBeat.i(330202);
      s.u(paramString, "$username");
      s.u(paramf, "$talker");
      d.uiThread((a)new a(paramch, paramString, paramf, parama));
      AppMethodBeat.o(330202);
    }
    
    private static final void b(final String paramString, final ah.f paramf, final az.b.a parama, ch paramch)
    {
      AppMethodBeat.i(330210);
      s.u(paramString, "$username");
      s.u(paramf, "$talker");
      d.uiThread((a)new b(paramch, paramString, paramf, parama));
      AppMethodBeat.o(330210);
    }
    
    private static final void c(final String paramString, final ah.f paramf, final az.b.a parama, ch paramch)
    {
      AppMethodBeat.i(330218);
      s.u(paramString, "$username");
      s.u(paramf, "$talker");
      d.uiThread((a)new c(paramch, paramString, paramf, parama));
      AppMethodBeat.o(330218);
    }
    
    public final void Jq(String paramString) {}
    
    public final void Jr(String paramString) {}
    
    public final void a(String paramString1, String paramString2, az.b.a parama)
    {
      AppMethodBeat.i(330265);
      if (paramString1 != null)
      {
        ah.f localf = new ah.f();
        localf.aqH = paramString1;
        paramString2 = "";
        if (au.aAy(paramString1))
        {
          paramString2 = ((bp)h.ax(bp.class)).aAw(paramString1);
          s.s(paramString2, "service(IFinderSessionIn…TalkerFromLocal(username)");
          localf.aqH = paramString2;
          paramString2 = paramString1;
        }
        Log.i("Finder.GetContactInterceptor", "[getContact] sessionId=" + paramString2 + " talker=" + (String)localf.aqH);
        if (au.bwV((String)localf.aqH))
        {
          ((y)h.ax(y.class)).a((String)localf.aqH, new f.b..ExternalSyntheticLambda1(paramString1, localf, parama));
          AppMethodBeat.o(330265);
          return;
        }
        if (au.bwT((String)localf.aqH))
        {
          paramString2 = ((bp)h.ax(bp.class)).eI(paramString1, 3);
          s.s(paramString2, "service(IFinderSessionIn…E_ALIAS_ROLE_TYPE_FINDER)");
          ((y)h.ax(y.class)).a((String)localf.aqH, paramString2, new f.b..ExternalSyntheticLambda2(paramString1, localf, parama));
          AppMethodBeat.o(330265);
          return;
        }
        if (au.bwU((String)localf.aqH))
        {
          paramString2 = ((bp)h.ax(bp.class)).eI(paramString1, 2);
          s.s(paramString2, "service(IFinderSessionIn…VE_ALIAS_ROLE_TYPE_ALIAS)");
          ((y)h.ax(y.class)).c((String)localf.aqH, paramString2, new f.b..ExternalSyntheticLambda0(paramString1, localf, parama));
        }
      }
      AppMethodBeat.o(330265);
    }
    
    public final void aZ(String paramString1, String paramString2) {}
    
    public final void bCc() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(ch paramch, String paramString, ah.f<String> paramf, az.b.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements a<ah>
    {
      b(ch paramch, String paramString, ah.f<String> paramf, az.b.a parama)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements a<ah>
    {
      c(ch paramch, String paramString, ah.f<String> paramf, az.b.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ak>
  {
    public static final c Fzd;
    
    static
    {
      AppMethodBeat.i(330208);
      Fzd = new c();
      AppMethodBeat.o(330208);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.f
 * JD-Core Version:    0.7.0.1
 */