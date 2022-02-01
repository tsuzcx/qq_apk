package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.a.ht;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

final class JsApiAddToFavorites$a
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(325592);
    paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
    Object localObject = new arf();
    ((arf)localObject).axy(19);
    ((arf)localObject).bsD(paramProcessRequest.rxr);
    if (Util.isNullOrNil(paramProcessRequest.rxr)) {
      ((arf)localObject).Kk(true);
    }
    ((arf)localObject).bsC(paramProcessRequest.rxr);
    ((arf)localObject).bso(paramProcessRequest.title);
    ((arf)localObject).bsp(paramProcessRequest.title);
    ((arf)localObject).bsB(b.er(localObject.toString(), 19));
    asb localasb = new asb();
    localasb.bto(z.bAM());
    localasb.yu(Util.nowMilliSecond());
    localasb.axH(paramProcessRequest.scene);
    ard localard = new ard();
    localard.appId = paramProcessRequest.appId;
    localard.iconUrl = paramProcessRequest.iconUrl;
    localard.hzy = paramProcessRequest.hzy;
    localard.hJK = paramProcessRequest.euz;
    localard.version = paramProcessRequest.version;
    localard.username = paramProcessRequest.username;
    localard.rxs = paramProcessRequest.rxs;
    localard.nOX = paramProcessRequest.nOX;
    localard.idf = paramProcessRequest.idf;
    localard.subType = paramProcessRequest.subType;
    arv localarv = new arv();
    localarv.vEn.add(localObject);
    localarv.c(localard);
    localarv.a(localasb);
    localObject = new dn();
    localarv.btm(paramProcessRequest.title);
    ((dn)localObject).hDr.desc = paramProcessRequest.title;
    ((dn)localObject).hDr.title = paramProcessRequest.title;
    ((dn)localObject).hDr.hDt = localarv;
    ((dn)localObject).hDr.type = 19;
    ((dn)localObject).publish();
    int i = ((dn)localObject).hDs.ret;
    paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
    paramProcessRequest.ret = i;
    Log.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
    e.a(i, getActivityContext(), new a.c()
    {
      public final void cpT() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(325734);
        JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
        AppMethodBeat.o(325734);
      }
      
      public final void onShow() {}
    }, null, new a.b()
    {
      public final void onMessageClick()
      {
        AppMethodBeat.i(325718);
        ht localht = new ht();
        localht.hIR.type = 35;
        localht.hIR.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
        localht.publish();
        AppMethodBeat.o(325718);
      }
    });
    AppMethodBeat.o(325592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a
 * JD-Core Version:    0.7.0.1
 */