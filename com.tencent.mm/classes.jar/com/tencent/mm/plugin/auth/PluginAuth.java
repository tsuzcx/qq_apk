package com.tencent.mm.plugin.auth;

import com.tencent.mm.ck.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.av;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.u.b;

public class PluginAuth
  extends f
  implements com.tencent.mm.plugin.auth.a.b
{
  private final a hEO = new a((byte)0);
  
  public com.tencent.mm.vending.b.b addHandleAuthResponse(com.tencent.mm.plugin.auth.a.a parama)
  {
    return this.hEO.aj(parama);
  }
  
  public void configure(g paramg)
  {
    av.a(new PluginAuth.1(this));
  }
  
  public void dependency()
  {
    dependsOn(p.class);
  }
  
  public void execute(g paramg) {}
  
  public com.tencent.mm.plugin.auth.a.a getHandleAuthResponseCallbacks()
  {
    return this.hEO;
  }
  
  public void installed()
  {
    alias(com.tencent.mm.plugin.auth.a.b.class);
  }
  
  public String toString()
  {
    return "plugin-auth";
  }
  
  private static final class a
    extends com.tencent.mm.ck.a<com.tencent.mm.plugin.auth.a.a>
    implements com.tencent.mm.plugin.auth.a.a
  {
    public final void a(final i.f paramf, final i.g paramg, final boolean paramBoolean)
    {
      a(new a.a() {});
    }
    
    public final void a(u.b paramb, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
    {
      a(new PluginAuth.a.2(this, paramb, paramString1, paramInt1, paramString2, paramString3, paramInt2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth
 * JD-Core Version:    0.7.0.1
 */