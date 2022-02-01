package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import java.util.Map;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"})
public final class d
  implements af.b
{
  public static final d.a Dhx;
  
  static
  {
    AppMethodBeat.i(204325);
    Dhx = new d.a((byte)0);
    AppMethodBeat.o(204325);
  }
  
  public final boolean aB(String paramString, int paramInt)
  {
    AppMethodBeat.i(204323);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(204323);
      return false;
    }
    if ((as.bvR(paramString)) || (as.bvQ(paramString)))
    {
      AppMethodBeat.o(204323);
      return true;
    }
    AppMethodBeat.o(204323);
    return false;
  }
  
  public final az.b bel()
  {
    AppMethodBeat.i(204322);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(204322);
    return localb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"})
  public static final class b
    implements az.b
  {
    public final void Rr(String paramString) {}
    
    public final void Rs(String paramString) {}
    
    public final void a(String paramString1, final String paramString2, final az.b.a parama)
    {
      AppMethodBeat.i(203625);
      if (paramString1 != null)
      {
        paramString2 = new aa.f();
        paramString2.aaBC = paramString1;
        if (as.bvQ(paramString1))
        {
          localObject = ((f)h.ae(f.class)).aED(paramString1);
          p.j(localObject, "MMKernel.service(IGameLi…TalkerFromLocal(username)");
          paramString2.aaBC = localObject;
        }
        Log.i("GameLife.GetContactInterceptor", "[getContact] username=" + paramString1 + " talker=" + (String)paramString2.aaBC);
        if (as.bvR((String)paramString2.aaBC))
        {
          ((b)h.ae(b.class)).a((String)paramString2.aaBC, (b.c)new a(paramString1, paramString2, parama));
          AppMethodBeat.o(203625);
          return;
        }
        Object localObject = az.a.ber();
        if ((localObject instanceof af)) {
          ((af)localObject).bei().a(paramString1, "", (az.b.a)new b(paramString2, parama));
        }
        AppMethodBeat.o(203625);
        return;
      }
      AppMethodBeat.o(203625);
    }
    
    public final void aP(String paramString1, String paramString2) {}
    
    public final void bej() {}
    
    public final void h(String paramString1, int paramInt, String paramString2) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class a
      implements b.c
    {
      a(String paramString, aa.f paramf, az.b.a parama) {}
      
      public final void ac(final Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(203809);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramMap) {});
        AppMethodBeat.o(203809);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class b
      implements az.b.a
    {
      b(aa.f paramf, az.b.a parama) {}
      
      public final void s(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(204111);
        Log.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)this.Ado.aaBC);
        az.b.a locala = parama;
        if (locala != null)
        {
          locala.s(paramString, paramBoolean);
          AppMethodBeat.o(204111);
          return;
        }
        AppMethodBeat.o(204111);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.d
 * JD-Core Version:    0.7.0.1
 */