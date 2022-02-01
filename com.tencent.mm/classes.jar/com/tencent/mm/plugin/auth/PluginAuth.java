package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cn.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ba.a;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.x.b;

public class PluginAuth
  extends f
  implements com.tencent.mm.plugin.auth.a.b
{
  private static int rvt = -1;
  private final a qkj;
  
  public PluginAuth()
  {
    AppMethodBeat.i(134223);
    this.qkj = new a((byte)0);
    AppMethodBeat.o(134223);
  }
  
  public static int getUserInfoPluginSwitch()
  {
    return rvt;
  }
  
  public static void setUserInfoPluginSwitch(int paramInt)
  {
    rvt = paramInt;
  }
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a parama)
  {
    AppMethodBeat.i(134227);
    parama = this.qkj.bs(parama);
    AppMethodBeat.o(134227);
    return parama;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(134226);
    ba.a(new ba.a()
    {
      public final void a(j.h paramAnonymoush, j.i paramAnonymousi)
      {
        AppMethodBeat.i(134218);
        ad.a(paramAnonymousi.DIG, true);
        PluginAuth.this.getHandleAuthResponseCallbacks().a(paramAnonymoush, paramAnonymousi, true);
        AppMethodBeat.o(134218);
      }
    });
    AppMethodBeat.o(134226);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(134225);
    dependsOn(q.class);
    AppMethodBeat.o(134225);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks()
  {
    return this.qkj;
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
    extends com.tencent.mm.cn.a<com.tencent.mm.plugin.auth.a.a>
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */