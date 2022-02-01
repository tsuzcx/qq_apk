package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.a;
import com.tencent.mm.co.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bh.a;
import com.tencent.mm.plugin.auth.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;

public class PluginAuth
  extends f
  implements c
{
  private static int PLq = -1;
  private final a PLp;
  
  public PluginAuth()
  {
    AppMethodBeat.i(134223);
    this.PLp = new a((byte)0);
    AppMethodBeat.o(134223);
  }
  
  public static int getUserInfoPluginSwitch()
  {
    return PLq;
  }
  
  public static void setUserInfoPluginSwitch(int paramInt)
  {
    PLq = paramInt;
  }
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.b paramb)
  {
    AppMethodBeat.i(134227);
    paramb = this.PLp.add(paramb);
    AppMethodBeat.o(134227);
    return paramb;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(134226);
    bh.a(new bh.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi)
      {
        AppMethodBeat.i(134218);
        aj.a(paramAnonymousi.Kzw, true);
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
  
  public com.tencent.mm.plugin.auth.a.b getHandleAuthResponseCallbacks()
  {
    return this.PLp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */