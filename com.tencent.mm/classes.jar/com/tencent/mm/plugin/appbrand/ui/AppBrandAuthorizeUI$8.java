package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z.a;
import com.tencent.mm.autogen.a.abl;
import com.tencent.mm.autogen.a.abl.a;
import com.tencent.mm.protocal.protobuf.cxc;
import com.tencent.mm.protocal.protobuf.glz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$8
  implements z.a
{
  AppBrandAuthorizeUI$8(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final int callback(int paramInt1, int paramInt2, String paramString, c paramc, p paramp)
  {
    boolean bool2 = true;
    AppMethodBeat.i(322237);
    Log.d("MicroMsg.AppBrandAuthorizeUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(322237);
      return 0;
    }
    paramc = (cxc)c.c.b(paramc.otC);
    paramString = null;
    if (paramc.aaCI == null)
    {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "wxa_msg_config_list not exist");
      AppMethodBeat.o(322237);
      return 0;
    }
    paramp = paramc.aaCI.iterator();
    while (paramp.hasNext())
    {
      paramc = (glz)paramp.next();
      if (paramc == null)
      {
        Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
      }
      else
      {
        if (AppBrandAuthorizeUI.d(this.tYl).equals(paramc.appid)) {
          paramString = paramc;
        }
        abl localabl = new abl();
        localabl.ieZ.appId = paramc.appid;
        abl.a locala = localabl.ieZ;
        if (paramc.status == 0) {}
        for (bool1 = true;; bool1 = false)
        {
          locala.hzt = bool1;
          localabl.publish();
          break;
        }
      }
    }
    if (paramString == null)
    {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "currentConfigItem not found, appId: %s", new Object[] { AppBrandAuthorizeUI.d(this.tYl) });
      AppMethodBeat.o(322237);
      return 0;
    }
    AppBrandAuthorizeUI.l(this.tYl);
    paramc = this.tYl;
    if (paramString.status == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AppBrandAuthorizeUI.d(paramc, bool1);
      AppBrandAuthorizeUI.a(this.tYl, this.tYl.tXD, AppBrandAuthorizeUI.b(this.tYl), AppBrandAuthorizeUI.a(this.tYl));
      AppMethodBeat.o(322237);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.8
 * JD-Core Version:    0.7.0.1
 */