package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.launching.LaunchBroadCast;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.p;

final class JsApiLaunchMiniProgram$2
  implements MMToClientEvent.c
{
  JsApiLaunchMiniProgram$2(JsApiLaunchMiniProgram paramJsApiLaunchMiniProgram, String paramString, int paramInt1, p paramp, int paramInt2) {}
  
  public final void aG(Object paramObject)
  {
    p localp;
    int i;
    JsApiLaunchMiniProgram localJsApiLaunchMiniProgram;
    if ((paramObject instanceof LaunchBroadCast))
    {
      paramObject = (LaunchBroadCast)paramObject;
      if ((this.gwL.equals(paramObject.appId)) && (this.gwM == paramObject.fJy))
      {
        MMToClientEvent.b(this.gbW.mAppId, this);
        localp = this.gbW;
        i = this.dIS;
        localJsApiLaunchMiniProgram = this.gwK;
        if (!paramObject.ccp) {
          break label87;
        }
      }
    }
    label87:
    for (paramObject = "ok";; paramObject = "fail")
    {
      localp.C(i, localJsApiLaunchMiniProgram.h(paramObject, null));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram.2
 * JD-Core Version:    0.7.0.1
 */