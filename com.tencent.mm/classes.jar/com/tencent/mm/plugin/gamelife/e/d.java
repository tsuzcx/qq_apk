package com.tencent.mm.plugin.gamelife.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.af.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor;", "Lcom/tencent/mm/model/GetContactServiceProxy$GetContactInterceptor;", "()V", "getContactImpl", "Lcom/tencent/mm/model/IMainService$GetContact;", "isIntercept", "", "user", "", "getScene", "", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements af.b
{
  public static final d.a Jbp;
  
  static
  {
    AppMethodBeat.i(268045);
    Jbp = new d.a((byte)0);
    AppMethodBeat.o(268045);
  }
  
  public final boolean aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(268060);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      AppMethodBeat.o(268060);
      return false;
    }
    if ((au.bwX(paramString)) || (au.bwW(paramString)))
    {
      AppMethodBeat.o(268060);
      return true;
    }
    AppMethodBeat.o(268060);
    return false;
  }
  
  public final az.b bCe()
  {
    AppMethodBeat.i(268052);
    az.b localb = (az.b)new b();
    AppMethodBeat.o(268052);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/gamelife/contact/GameLifeGetContactInterceptor$getContactImpl$1", "Lcom/tencent/mm/model/IMainService$GetContact;", "addContact", "", "user", "", "chatroom", "addContactExtra", "scene", "", "tick", "checkPendingGetContact", "clearMapRecentDown", "username", "getContact", "callback", "Lcom/tencent/mm/model/IMainService$GetContact$GetContactCallBack;", "getNow", "removeCallBack", "sourceUsername", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements az.b
  {
    private static final void a(final String paramString, final ah.f paramf, final az.b.a parama, Map paramMap)
    {
      AppMethodBeat.i(268057);
      s.u(paramString, "$username");
      s.u(paramf, "$talker");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramMap, paramString, paramf, parama));
      AppMethodBeat.o(268057);
    }
    
    private static final void a(ah.f paramf, az.b.a parama, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(268065);
      s.u(paramf, "$talker");
      Log.i("GameLife.GetContactInterceptor", "[getContact] callback! succ=" + paramBoolean + ", username=" + paramString + " talker=" + (String)paramf.aqH);
      if (parama != null) {
        parama.getContactCallBack(paramString, paramBoolean);
      }
      AppMethodBeat.o(268065);
    }
    
    public final void Jq(String paramString) {}
    
    public final void Jr(String paramString) {}
    
    public final void a(String paramString1, String paramString2, az.b.a parama)
    {
      AppMethodBeat.i(268100);
      if (paramString1 != null)
      {
        paramString2 = new ah.f();
        paramString2.aqH = paramString1;
        if (au.bwW(paramString1))
        {
          localObject = ((f)h.ax(f.class)).aAw(paramString1);
          s.s(localObject, "service(IGameLifeSession…TalkerFromLocal(username)");
          paramString2.aqH = localObject;
        }
        Log.i("GameLife.GetContactInterceptor", "[getContact] username=" + paramString1 + " talker=" + (String)paramString2.aqH);
        if (au.bwX((String)paramString2.aqH))
        {
          ((b)h.ax(b.class)).a((String)paramString2.aqH, new d.b..ExternalSyntheticLambda1(paramString1, paramString2, parama));
          AppMethodBeat.o(268100);
          return;
        }
        Object localObject = az.a.okP;
        if ((localObject instanceof af)) {
          ((af)localObject).okv.a(paramString1, "", new d.b..ExternalSyntheticLambda0(paramString2, parama));
        }
      }
      AppMethodBeat.o(268100);
    }
    
    public final void aZ(String paramString1, String paramString2) {}
    
    public final void bCc() {}
    
    public final void j(String paramString1, int paramInt, String paramString2) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(Map<String, com.tencent.mm.plugin.gamelife.a.a> paramMap, String paramString, ah.f<String> paramf, az.b.a parama)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.e.d
 * JD-Core Version:    0.7.0.1
 */