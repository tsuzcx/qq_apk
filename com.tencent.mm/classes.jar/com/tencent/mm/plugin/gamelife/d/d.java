package com.tencent.mm.plugin.gamelife.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.aa.b;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.b.c;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.am;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.l;
import d.z;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"})
public final class d
  implements aa.b
{
  public static final a uxY;
  
  static
  {
    AppMethodBeat.i(211325);
    uxY = new a((byte)0);
    AppMethodBeat.o(211325);
  }
  
  public final as.b aBu()
  {
    AppMethodBeat.i(211323);
    as.b localb = (as.b)new b();
    AppMethodBeat.o(211323);
    return localb;
  }
  
  public final boolean af(String paramString, int paramInt)
  {
    AppMethodBeat.i(211324);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(211324);
      return false;
    }
    if ((am.aSW(paramString)) || (am.aSV(paramString)))
    {
      AppMethodBeat.o(211324);
      return true;
    }
    AppMethodBeat.o(211324);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$Companion;", "", "()V", "TAG", "", "plugin-gamelife_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"})
  public static final class b
    implements as.b
  {
    public final void AJ(String paramString) {}
    
    public final void AK(String paramString) {}
    
    public final void a(String paramString1, final String paramString2, final as.b.a parama)
    {
      AppMethodBeat.i(211322);
      if (paramString1 != null)
      {
        paramString2 = new y.f();
        paramString2.MLV = paramString1;
        if (am.aSV(paramString1))
        {
          localObject = ((e)g.ab(e.class)).aii(paramString1);
          p.g(localObject, "MMKernel.service(IGameLi…TalkerFromLocal(username)");
          paramString2.MLV = localObject;
        }
        ad.i("GameLife.GetContactInterceptor", "[getContact] username=" + paramString1 + " talker=" + (String)paramString2.MLV);
        if (am.aSW((String)paramString2.MLV))
        {
          ((b)g.ab(b.class)).a((String)paramString2.MLV, (b.c)new a(paramString1, paramString2, parama));
          AppMethodBeat.o(211322);
          return;
        }
        Object localObject = as.a.aBA();
        if ((localObject instanceof aa)) {
          ((aa)localObject).aBr().a(paramString1, "", (as.b.a)new b(paramString2, parama));
        }
        AppMethodBeat.o(211322);
        return;
      }
      AppMethodBeat.o(211322);
    }
    
    public final void aBs() {}
    
    public final void aI(String paramString1, String paramString2) {}
    
    public final void g(String paramString1, int paramInt, String paramString2) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/plugin/gamelife/api/IGameLifeContact;", "", "onDone"})
    static final class a
      implements b.c
    {
      a(String paramString, y.f paramf, as.b.a parama) {}
      
      public final void ab(final Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap)
      {
        AppMethodBeat.i(211320);
        c.g((d.g.a.a)new q(paramMap) {});
        AppMethodBeat.o(211320);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "username", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class b
      implements as.b.a
    {
      b(y.f paramf, as.b.a parama) {}
      
      public final void p(String paramString, boolean paramBoolean)
      {
        AppMethodBeat.i(211321);
        ad.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)this.suh.MLV);
        as.b.a locala = parama;
        if (locala != null)
        {
          locala.p(paramString, paramBoolean);
          AppMethodBeat.o(211321);
          return;
        }
        AppMethodBeat.o(211321);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.d.d
 * JD-Core Version:    0.7.0.1
 */