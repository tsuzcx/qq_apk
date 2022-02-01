package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"})
public final class d
  implements af.b
{
  public static final d.a ybS;
  
  static
  {
    AppMethodBeat.i(241334);
    ybS = new d.a((byte)0);
    AppMethodBeat.o(241334);
  }
  
  public final ay.b aVi()
  {
    AppMethodBeat.i(241332);
    ay.b localb = (ay.b)new b();
    AppMethodBeat.o(241332);
    return localb;
  }
  
  public final boolean aj(String paramString, int paramInt)
  {
    AppMethodBeat.i(241333);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(241333);
      return false;
    }
    if ((as.bjv(paramString)) || (as.bju(paramString)))
    {
      AppMethodBeat.o(241333);
      return true;
    }
    AppMethodBeat.o(241333);
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"})
  public static final class b
    implements ay.b
  {
    public final void JZ(String paramString) {}
    
    public final void Ka(String paramString) {}
    
    public final void a(String paramString1, final String paramString2, final ay.b.a parama)
    {
      AppMethodBeat.i(241331);
      if (paramString1 != null)
      {
        paramString2 = new z.f();
        paramString2.SYG = paramString1;
        if (as.bju(paramString1))
        {
          localObject = ((f)g.af(f.class)).avi(paramString1);
          p.g(localObject, "MMKernel.service(IGameLi…TalkerFromLocal(username)");
          paramString2.SYG = localObject;
        }
        Log.i("GameLife.GetContactInterceptor", "[getContact] username=" + paramString1 + " talker=" + (String)paramString2.SYG);
        if (as.bjv((String)paramString2.SYG))
        {
          ((b)g.af(b.class)).a((String)paramString2.SYG, (b.c)new a(paramString1, paramString2, parama));
          AppMethodBeat.o(241331);
          return;
        }
        Object localObject = ay.a.aVo();
        if ((localObject instanceof af)) {
          ((af)localObject).aVf().a(paramString1, "", (ay.b.a)new b(paramString2, parama));
        }
        AppMethodBeat.o(241331);
        return;
      }
      AppMethodBeat.o(241331);
    }
    
    public final void aL(String paramString1, String paramString2) {}
    
    public final void aVg() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class a
      implements b.c
    {
      a(String paramString, z.f paramf, ay.b.a parama) {}
      
      public final void aj(final Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(241329);
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new q(paramMap) {});
        AppMethodBeat.o(241329);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class b
      implements ay.b.a
    {
      b(z.f paramf, ay.b.a parama) {}
      
      public final void p(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(241330);
        Log.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)this.vvP.SYG);
        ay.b.a locala = parama;
        if (locala != null)
        {
          locala.p(paramString, paramBoolean);
          AppMethodBeat.o(241330);
          return;
        }
        AppMethodBeat.o(241330);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.d
 * JD-Core Version:    0.7.0.1
 */