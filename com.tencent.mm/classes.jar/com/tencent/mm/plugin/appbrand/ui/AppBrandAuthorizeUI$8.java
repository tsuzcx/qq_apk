package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yj.a;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandAuthorizeUI$8
  implements aa.a
{
  AppBrandAuthorizeUI$8(AppBrandAuthorizeUI paramAppBrandAuthorizeUI) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
  {
    boolean bool2 = true;
    AppMethodBeat.i(227567);
    Log.d("MicroMsg.AppBrandAuthorizeUI", "getNotifyMsgInfo errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(227567);
      return 0;
    }
    paramd = (bzh)paramd.iLL.iLR;
    paramString = null;
    if (paramd.MeZ == null)
    {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "wxa_msg_config_list not exist");
      AppMethodBeat.o(227567);
      return 0;
    }
    paramq = paramd.MeZ.iterator();
    while (paramq.hasNext())
    {
      paramd = (fdy)paramq.next();
      if (paramd == null)
      {
        Log.w("MicroMsg.AppBrandAuthorizeUI", "scene end, item is null");
      }
      else
      {
        if (AppBrandAuthorizeUI.c(this.nRR).equals(paramd.dNI)) {
          paramString = paramd;
        }
        yj localyj = new yj();
        localyj.eeG.appId = paramd.dNI;
        yj.a locala = localyj.eeG;
        if (paramd.status == 0) {}
        for (bool1 = true;; bool1 = false)
        {
          locala.dCs = bool1;
          EventCenter.instance.publish(localyj);
          break;
        }
      }
    }
    if (paramString == null)
    {
      Log.e("MicroMsg.AppBrandAuthorizeUI", "currentConfigItem not found, appId: %s", new Object[] { AppBrandAuthorizeUI.c(this.nRR) });
      AppMethodBeat.o(227567);
      return 0;
    }
    AppBrandAuthorizeUI.j(this.nRR);
    paramd = this.nRR;
    if (paramString.status == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AppBrandAuthorizeUI.c(paramd, bool1);
      AppBrandAuthorizeUI.a(this.nRR, this.nRR.nRu, AppBrandAuthorizeUI.a(this.nRR));
      AppMethodBeat.o(227567);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandAuthorizeUI.8
 * JD-Core Version:    0.7.0.1
 */