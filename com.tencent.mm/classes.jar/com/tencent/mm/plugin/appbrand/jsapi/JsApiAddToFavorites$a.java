package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

final class JsApiAddToFavorites$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(222385);
    paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
    Object localObject = new ajx();
    ((ajx)localObject).aao(19);
    ((ajx)localObject).aPR(paramProcessRequest.kuD);
    if (bu.isNullOrNil(paramProcessRequest.kuD)) {
      ((ajx)localObject).wt(true);
    }
    ((ajx)localObject).aPQ(paramProcessRequest.kuD);
    ((ajx)localObject).aPC(paramProcessRequest.title);
    ((ajx)localObject).aPD(paramProcessRequest.title);
    ((ajx)localObject).aPP(com.tencent.mm.plugin.fav.a.b.dm(localObject.toString(), 19));
    akt localakt = new akt();
    localakt.aQC(v.aAC());
    localakt.Dk(bu.fpO());
    localakt.aax(paramProcessRequest.scene);
    ajv localajv = new ajv();
    localajv.appId = paramProcessRequest.appId;
    localajv.iconUrl = paramProcessRequest.iconUrl;
    localajv.dlk = paramProcessRequest.dlk;
    localajv.duK = paramProcessRequest.hSZ;
    localajv.version = paramProcessRequest.version;
    localajv.username = paramProcessRequest.username;
    localajv.kuE = paramProcessRequest.kuE;
    localajv.kaX = paramProcessRequest.kaX;
    localajv.dLl = paramProcessRequest.dLl;
    localajv.subType = paramProcessRequest.subType;
    akn localakn = new akn();
    localakn.oeJ.add(localObject);
    localakn.c(localajv);
    localakn.a(localakt);
    localObject = new cw();
    localakn.aQA(paramProcessRequest.title);
    ((cw)localObject).doL.desc = paramProcessRequest.title;
    ((cw)localObject).doL.title = paramProcessRequest.title;
    ((cw)localObject).doL.doN = localakn;
    ((cw)localObject).doL.type = 19;
    a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((cw)localObject).doM.ret;
    paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
    paramProcessRequest.ret = i;
    ae.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
    e.a(-1, i, bis(), null, new a.c()
    {
      public final void biX() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(222383);
        JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
        AppMethodBeat.o(222383);
      }
      
      public final void onShow() {}
    }, null, new a.b()
    {
      public final void biY()
      {
        AppMethodBeat.i(222384);
        gx localgx = new gx();
        localgx.dub.type = 35;
        localgx.dub.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
        a.IvT.l(localgx);
        AppMethodBeat.o(222384);
      }
    });
    AppMethodBeat.o(222385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a
 * JD-Core Version:    0.7.0.1
 */