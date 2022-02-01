package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

final class JsApiAddToFavorites$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(188259);
    paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
    Object localObject = new ajn();
    ((ajn)localObject).ZI(19);
    ((ajn)localObject).aOu(paramProcessRequest.krn);
    if (bt.isNullOrNil(paramProcessRequest.krn)) {
      ((ajn)localObject).wl(true);
    }
    ((ajn)localObject).aOt(paramProcessRequest.krn);
    ((ajn)localObject).aOf(paramProcessRequest.title);
    ((ajn)localObject).aOg(paramProcessRequest.title);
    ((ajn)localObject).aOs(com.tencent.mm.plugin.fav.a.b.di(localObject.toString(), 19));
    akj localakj = new akj();
    localakj.aPf(u.aAm());
    localakj.CM(bt.flT());
    localakj.ZR(paramProcessRequest.scene);
    ajl localajl = new ajl();
    localajl.appId = paramProcessRequest.appId;
    localajl.iconUrl = paramProcessRequest.iconUrl;
    localajl.dki = paramProcessRequest.dki;
    localajl.dtF = paramProcessRequest.hQh;
    localajl.version = paramProcessRequest.version;
    localajl.username = paramProcessRequest.username;
    localajl.kro = paramProcessRequest.kro;
    localajl.jXI = paramProcessRequest.jXI;
    localajl.dJW = paramProcessRequest.dJW;
    localajl.subType = paramProcessRequest.subType;
    akd localakd = new akd();
    localakd.nZa.add(localObject);
    localakd.c(localajl);
    localakd.a(localakj);
    localObject = new cv();
    localakd.aPd(paramProcessRequest.title);
    ((cv)localObject).dnG.desc = paramProcessRequest.title;
    ((cv)localObject).dnG.title = paramProcessRequest.title;
    ((cv)localObject).dnG.dnI = localakd;
    ((cv)localObject).dnG.type = 19;
    a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
    int i = ((cv)localObject).dnH.ret;
    paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
    paramProcessRequest.ret = i;
    ad.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
    e.a(-1, i, bhJ(), null, new a.c()
    {
      public final void bio() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(188257);
        JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
        AppMethodBeat.o(188257);
      }
      
      public final void onShow() {}
    }, null, new a.b()
    {
      public final void bip()
      {
        AppMethodBeat.i(188258);
        gw localgw = new gw();
        localgw.dsV.type = 35;
        localgw.dsV.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
        a.IbL.l(localgw);
        AppMethodBeat.o(188258);
      }
    });
    AppMethodBeat.o(188259);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a
 * JD-Core Version:    0.7.0.1
 */