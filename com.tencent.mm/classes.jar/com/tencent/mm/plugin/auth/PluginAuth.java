package com.tencent.mm.plugin.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.v.b;

public class PluginAuth
  extends f
  implements com.tencent.mm.plugin.auth.a.b
{
  private static int jyh = -1;
  private final a jyg;
  
  public PluginAuth()
  {
    AppMethodBeat.i(123491);
    this.jyg = new a((byte)0);
    AppMethodBeat.o(123491);
  }
  
  public static int getUserInfoPluginSwitch()
  {
    return jyh;
  }
  
  public static void setUserInfoPluginSwitch(int paramInt)
  {
    jyh = paramInt;
  }
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a parama)
  {
    AppMethodBeat.i(123495);
    parama = this.jyg.at(parama);
    AppMethodBeat.o(123495);
    return parama;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(123494);
    ax.a(new PluginAuth.1(this));
    AppMethodBeat.o(123494);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(123493);
    dependsOn(p.class);
    AppMethodBeat.o(123493);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks()
  {
    return this.jyg;
  }
  
  public void installed()
  {
    AppMethodBeat.i(123492);
    alias(com.tencent.mm.plugin.auth.a.b.class);
    AppMethodBeat.o(123492);
  }
  
  public String toString()
  {
    return "plugin-auth";
  }
  
  static final class a
    extends com.tencent.mm.cm.a<com.tencent.mm.plugin.auth.a.a>
    implements com.tencent.mm.plugin.auth.a.a
  {
    public final void a(j.h paramh, j.i parami, boolean paramBoolean)
    {
      AppMethodBeat.i(123489);
      a(new PluginAuth.a.1(this, paramh, parami, paramBoolean));
      AppMethodBeat.o(123489);
    }
    
    public final void a(v.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
    {
      AppMethodBeat.i(123490);
      a(new PluginAuth.a.2(this, paramb, paramString1, paramInt1, paramString2, paramString3, paramInt2));
      AppMethodBeat.o(123490);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */