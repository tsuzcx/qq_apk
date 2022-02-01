package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"})
public final class d
  implements ab.b
{
  public static final d.a uJB;
  
  static
  {
    AppMethodBeat.i(212094);
    uJB = new d.a((byte)0);
    AppMethodBeat.o(212094);
  }
  
  public final au.b aBK()
  {
    AppMethodBeat.i(212092);
    au.b localb = (au.b)new b();
    AppMethodBeat.o(212092);
    return localb;
  }
  
  public final boolean ag(String paramString, int paramInt)
  {
    AppMethodBeat.i(212093);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(212093);
      return false;
    }
    if ((an.aUw(paramString)) || (an.aUv(paramString)))
    {
      AppMethodBeat.o(212093);
      return true;
    }
    AppMethodBeat.o(212093);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"})
  public static final class b
    implements au.b
  {
    public final void Bt(String paramString) {}
    
    public final void Bu(String paramString) {}
    
    public final void a(String paramString1, final String paramString2, final au.b.a parama)
    {
      AppMethodBeat.i(212091);
      if (paramString1 != null)
      {
        paramString2 = new y.f();
        paramString2.NiY = paramString1;
        if (an.aUv(paramString1))
        {
          localObject = ((f)g.ab(f.class)).ajf(paramString1);
          p.g(localObject, "MMKernel.service(IGameLi…TalkerFromLocal(username)");
          paramString2.NiY = localObject;
        }
        ae.i("GameLife.GetContactInterceptor", "[getContact] username=" + paramString1 + " talker=" + (String)paramString2.NiY);
        if (an.aUw((String)paramString2.NiY))
        {
          ((b)g.ab(b.class)).a((String)paramString2.NiY, (b.c)new a(paramString1, paramString2, parama));
          AppMethodBeat.o(212091);
          return;
        }
        Object localObject = au.a.aBQ();
        if ((localObject instanceof ab)) {
          ((ab)localObject).aBH().a(paramString1, "", (au.b.a)new b(paramString2, parama));
        }
        AppMethodBeat.o(212091);
        return;
      }
      AppMethodBeat.o(212091);
    }
    
    public final void aBI() {}
    
    public final void aJ(String paramString1, String paramString2) {}
    
    public final void g(String paramString1, int paramInt, String paramString2) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class a
      implements b.c
    {
      a(String paramString, y.f paramf, au.b.a parama) {}
      
      public final void ah(final Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(212089);
        c.h((d.g.a.a)new q(paramMap) {});
        AppMethodBeat.o(212089);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class b
      implements au.b.a
    {
      b(y.f paramf, au.b.a parama) {}
      
      public final void p(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(212090);
        ae.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)this.sEs.NiY);
        au.b.a locala = parama;
        if (locala != null)
        {
          locala.p(paramString, paramBoolean);
          AppMethodBeat.o(212090);
          return;
        }
        AppMethodBeat.o(212090);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.d
 * JD-Core Version:    0.7.0.1
 */