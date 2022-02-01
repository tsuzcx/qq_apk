package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cp.a;
import com.tencent.mm.cp.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bj.a;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;

public class PluginAuth
  extends f
  implements c
{
  private static int Crw = -1;
  private final a Cpv;
  
  public PluginAuth()
  {
    AppMethodBeat.i(134223);
    this.Cpv = new a((byte)0);
    AppMethodBeat.o(134223);
  }
  
  public static int getUserInfoPluginSwitch()
  {
    return Crw;
  }
  
  public static void setUserInfoPluginSwitch(int paramInt)
  {
    Crw = paramInt;
  }
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.b paramb)
  {
    AppMethodBeat.i(134227);
    paramb = this.Cpv.add(paramb);
    AppMethodBeat.o(134227);
    return paramb;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(134226);
    bj.a(new bj.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi)
      {
        AppMethodBeat.i(134218);
        aj.a(paramAnonymousi.YxP, true);
        PluginAuth.this.getHandleAuthResponseCallbacks().onAuthResponse(paramAnonymoush, paramAnonymousi, true);
        AppMethodBeat.o(134218);
      }
    });
    AppMethodBeat.o(134226);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(134225);
    dependsOn(v.class);
    AppMethodBeat.o(134225);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.auth.a.b getHandleAuthResponseCallbacks()
  {
    return this.Cpv;
  }
  
  public void installed()
  {
    AppMethodBeat.i(134224);
    alias(c.class);
    AppMethodBeat.o(134224);
  }
  
  public String toString()
  {
    return "plugin-auth";
  }
  
  static final class a
    extends a<com.tencent.mm.plugin.auth.a.b>
    implements com.tencent.mm.plugin.auth.a.b
  {
    public final void onAuthResponse(final j.h paramh, final j.i parami, final boolean paramBoolean)
    {
      AppMethodBeat.i(134221);
      a(new a.a() {});
      AppMethodBeat.o(134221);
    }
    
    public final void onRegResponse(final x.b paramb, final String paramString1, final int paramInt1, final String paramString2, final String paramString3, final int paramInt2)
    {
      AppMethodBeat.i(134222);
      a(new a.a() {});
      AppMethodBeat.o(134222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */