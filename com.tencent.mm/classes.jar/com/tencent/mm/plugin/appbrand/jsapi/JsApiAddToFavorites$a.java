package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.a.gt;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

final class JsApiAddToFavorites$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(186558);
    paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
    Object localObject = new agx();
    ((agx)localObject).XM(19);
    ((agx)localObject).aIR(paramProcessRequest.jWW);
    if (bs.isNullOrNil(paramProcessRequest.jWW)) {
      ((agx)localObject).vz(true);
    }
    ((agx)localObject).aIQ(paramProcessRequest.jWW);
    ((agx)localObject).aIC(paramProcessRequest.title);
    ((agx)localObject).aID(paramProcessRequest.title);
    ((agx)localObject).aIP(com.tencent.mm.plugin.fav.a.b.cY(localObject.toString(), 19));
    aht localaht = new aht();
    localaht.aJC(u.axw());
    localaht.zY(bs.eWj());
    localaht.XV(paramProcessRequest.scene);
    agv localagv = new agv();
    localagv.appId = paramProcessRequest.appId;
    localagv.iconUrl = paramProcessRequest.iconUrl;
    localagv.cYQ = paramProcessRequest.cYQ;
    localagv.dib = paramProcessRequest.hxM;
    localagv.version = paramProcessRequest.version;
    localagv.username = paramProcessRequest.username;
    localagv.jWX = paramProcessRequest.jWX;
    localagv.ccR = paramProcessRequest.ccR;
    localagv.dxK = paramProcessRequest.dxK;
    localagv.subType = paramProcessRequest.subType;
    ahn localahn = new ahn();
    localahn.nxC.add(localObject);
    localahn.c(localagv);
    localahn.a(localaht);
    localObject = new cs();
    localahn.aJA(paramProcessRequest.title);
    ((cs)localObject).dck.desc = paramProcessRequest.title;
    ((cs)localObject).dck.title = paramProcessRequest.title;
    ((cs)localObject).dck.dcm = localahn;
    ((cs)localObject).dck.type = 19;
    a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((cs)localObject).dcl.ret;
    paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
    paramProcessRequest.ret = i;
    ac.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
    e.a(-1, i, bef(), null, new a.c()
    {
      public final void beK() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(186556);
        JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
        AppMethodBeat.o(186556);
      }
      
      public final void onShow() {}
    }, null, new a.b()
    {
      public final void beL()
      {
        AppMethodBeat.i(186557);
        gt localgt = new gt();
        localgt.dhx.type = 35;
        localgt.dhx.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
        a.GpY.l(localgt);
        AppMethodBeat.o(186557);
      }
    });
    AppMethodBeat.o(186558);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a
 * JD-Core Version:    0.7.0.1
 */