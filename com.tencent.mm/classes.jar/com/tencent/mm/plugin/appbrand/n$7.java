package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.permission.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.AuthStateChangedByUserEvent;

final class n$7
  implements MMToClientEvent.c
{
  n$7(n paramn) {}
  
  public final void aG(Object paramObject)
  {
    if ((paramObject instanceof AppBrandAuthorizeUI.AuthStateChangedByUserEvent)) {
      c.vW(this.fzM.mAppId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.n.7
 * JD-Core Version:    0.7.0.1
 */