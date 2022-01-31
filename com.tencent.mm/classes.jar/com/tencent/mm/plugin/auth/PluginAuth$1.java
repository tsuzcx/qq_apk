package com.tencent.mm.plugin.auth;

import com.tencent.mm.model.av.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;

final class PluginAuth$1
  implements av.a
{
  PluginAuth$1(PluginAuth paramPluginAuth) {}
  
  public final void a(i.f paramf, i.g paramg)
  {
    z.a(paramg.spz, true);
    this.hEP.getHandleAuthResponseCallbacks().a(paramf, paramg, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.auth.PluginAuth.1
 * JD-Core Version:    0.7.0.1
 */