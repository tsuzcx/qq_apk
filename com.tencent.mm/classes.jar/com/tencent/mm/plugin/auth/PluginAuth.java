package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;

public class PluginAuth
  extends f
  implements com.tencent.mm.plugin.auth.a.b
{
  private static int owp = -1;
  private final a omU;
  
  public PluginAuth()
  {
    AppMethodBeat.i(134223);
    this.omU = new a((byte)0);
    AppMethodBeat.o(134223);
  }
  
  public static int getUserInfoPluginSwitch()
  {
    return owp;
  }
  
  public static void setUserInfoPluginSwitch(int paramInt)
  {
    owp = paramInt;
  }
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a parama)
  {
    AppMethodBeat.i(134227);
    parama = this.omU.bu(parama);
    AppMethodBeat.o(134227);
    return parama;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(134226);
    bd.a(new bd.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi)
      {
        AppMethodBeat.i(134218);
        af.a(paramAnonymousi.FGl, true);
        PluginAuth.this.getHandleAuthResponseCallbacks().a(paramAnonymoush, paramAnonymousi, true);
        AppMethodBeat.o(134218);
      }
    });
    AppMethodBeat.o(134226);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(134225);
    dependsOn(s.class);
    AppMethodBeat.o(134225);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks()
  {
    return this.omU;
  }
  
  public void installed()
  {
    AppMethodBeat.i(134224);
    alias(com.tencent.mm.plugin.auth.a.b.class);
    AppMethodBeat.o(134224);
  }
  
  public String toString()
  {
    return "plugin-auth";
  }
  
  static final class a
    extends com.tencent.mm.cm.a<com.tencent.mm.plugin.auth.a.a>
    implements com.tencent.mm.plugin.auth.a.a
  {
    public final void a(final j.h paramh, final j.i parami, final boolean paramBoolean)
    {
      AppMethodBeat.i(134221);
      a(new a.a() {});
      AppMethodBeat.o(134221);
    }
    
    public final void a(final x.b paramb, final String paramString1, final int paramInt1, final String paramString2, final String paramString3, final int paramInt2)
    {
      AppMethodBeat.i(134222);
      a(new a.a() {});
      AppMethodBeat.o(134222);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */