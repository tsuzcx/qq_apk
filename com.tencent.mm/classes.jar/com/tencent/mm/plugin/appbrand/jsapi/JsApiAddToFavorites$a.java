package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.a.hi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.a.b;
import com.tencent.mm.ui.widget.snackbar.a.c;
import java.util.LinkedList;

final class JsApiAddToFavorites$a
  extends AppBrandProxyUIProcessTask
{
  public final void a(final AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(280942);
    paramProcessRequest = (JsApiAddToFavorites.IPCFavRequest)paramProcessRequest;
    Object localObject = new anm();
    ((anm)localObject).arq(19);
    ((anm)localObject).bsM(paramProcessRequest.otD);
    if (Util.isNullOrNil(paramProcessRequest.otD)) {
      ((anm)localObject).Ey(true);
    }
    ((anm)localObject).bsL(paramProcessRequest.otD);
    ((anm)localObject).bsx(paramProcessRequest.title);
    ((anm)localObject).bsy(paramProcessRequest.title);
    ((anm)localObject).bsK(b.dN(localObject.toString(), 19));
    aoi localaoi = new aoi();
    localaoi.btx(z.bcZ());
    localaoi.Ue(Util.nowMilliSecond());
    localaoi.arz(paramProcessRequest.scene);
    ank localank = new ank();
    localank.appId = paramProcessRequest.appId;
    localank.iconUrl = paramProcessRequest.iconUrl;
    localank.fve = paramProcessRequest.fve;
    localank.fES = paramProcessRequest.cBU;
    localank.version = paramProcessRequest.version;
    localank.username = paramProcessRequest.username;
    localank.otE = paramProcessRequest.otE;
    localank.nYp = paramProcessRequest.nYp;
    localank.fXg = paramProcessRequest.fXg;
    localank.subType = paramProcessRequest.subType;
    aoc localaoc = new aoc();
    localaoc.syG.add(localObject);
    localaoc.c(localank);
    localaoc.a(localaoi);
    localObject = new dd();
    localaoc.btv(paramProcessRequest.title);
    ((dd)localObject).fyI.desc = paramProcessRequest.title;
    ((dd)localObject).fyI.title = paramProcessRequest.title;
    ((dd)localObject).fyI.fyK = localaoc;
    ((dd)localObject).fyI.type = 19;
    EventCenter.instance.publish((IEvent)localObject);
    int i = ((dd)localObject).fyJ.ret;
    paramProcessRequest = new JsApiAddToFavorites.IPCFavResult();
    paramProcessRequest.ret = i;
    Log.i("MicroMsg.JsApiAddToFavorites", "fav result:%d", new Object[] { Integer.valueOf(i) });
    e.a(i, bPf(), new a.c()
    {
      public final void bPL() {}
      
      public final void onHide()
      {
        AppMethodBeat.i(282939);
        JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this, paramProcessRequest);
        AppMethodBeat.o(282939);
      }
      
      public final void onShow() {}
    }, null, new a.b()
    {
      public final void bPM()
      {
        AppMethodBeat.i(271171);
        hi localhi = new hi();
        localhi.fEb.type = 35;
        localhi.fEb.context = JsApiAddToFavorites.a.a(JsApiAddToFavorites.a.this);
        EventCenter.instance.publish(localhi);
        AppMethodBeat.o(271171);
      }
    });
    AppMethodBeat.o(280942);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiAddToFavorites.a
 * JD-Core Version:    0.7.0.1
 */