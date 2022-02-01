package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.btu;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class h
  extends c<kd>
{
  final d rr;
  
  public h(kc paramkc)
  {
    this(paramkc, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private h(kc paramkc, String paramString)
  {
    AppMethodBeat.i(174705);
    d.a locala = new d.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.lBU = paramkc;
    locala.lBV = new kd();
    if ((paramkc.RPD == null) || (paramkc.RPD.fOu == 0))
    {
      paramString = paramkc.RPC.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (btu)paramString.next();
        localObject = (Integer)t.oaj.get(((btu)localObject).TdO.appid);
        if ((localObject != null) && (((Integer)localObject).intValue() > 0))
        {
          if (paramkc.RPD == null)
          {
            paramkc.RPD = new ack();
            paramkc.RPD.SnY = false;
            paramkc.RPD.SnZ = 1;
          }
          paramkc.RPD.fOu = ((Integer)localObject).intValue();
        }
      }
    }
    paramkc = locala.bgN();
    this.rr = paramkc;
    c(paramkc);
    AppMethodBeat.o(174705);
  }
  
  public final f<c.a<kd>> bhW()
  {
    AppMethodBeat.i(268698);
    Object localObject3 = (kc)d.b.b(this.rr.lBR);
    int i = ((kc)localObject3).scene;
    Object localObject1 = a.a((ack)Objects.requireNonNull(((kc)localObject3).RPD));
    Object localObject4 = ((kc)localObject3).RPC;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[");
    localObject4 = ((List)localObject4).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      btu localbtu = (btu)((Iterator)localObject4).next();
      ((StringBuilder)localObject3).append("{");
      if (!TextUtils.isEmpty(localbtu.TdO.appid)) {
        ((StringBuilder)localObject3).append("appId:").append(localbtu.TdO.appid);
      }
      for (;;)
      {
        ((StringBuilder)localObject3).append(", module:").append(localbtu.TdO.TnI);
        ((StringBuilder)localObject3).append(", package_type:").append(localbtu.TdO.TnG);
        ((StringBuilder)localObject3).append(", version_type:").append(localbtu.TdO.RYL);
        if ((j.a.vB(localbtu.TdO.RYL)) && (localbtu.TdT != 0)) {
          ((StringBuilder)localObject3).append(", dev_uin:").append(p.getString(localbtu.TdT));
        }
        if (localbtu.RYM > 0) {
          ((StringBuilder)localObject3).append(", version:").append(localbtu.RYM);
        }
        if ((localbtu.TdP != null) && (localbtu.TdP.RYM > 0)) {
          ((StringBuilder)localObject3).append(", local_version:").append(localbtu.TdP.RYM);
        }
        if (localbtu.TdS) {
          ((StringBuilder)localObject3).append(", need_zstd:true");
        }
        ((StringBuilder)localObject3).append("},");
        break;
        if (!TextUtils.isEmpty(localbtu.TdO.username)) {
          ((StringBuilder)localObject3).append("username:").append(localbtu.TdO.username);
        }
      }
    }
    ((StringBuilder)localObject3).append("]");
    Log.i("MicroMsg.AppBrand.CgiBatchGetPkgDownloadInfo", "run(), scene:%d, source:%s, req_list:%s", new Object[] { Integer.valueOf(i), localObject1, ((StringBuilder)localObject3).toString() });
    try
    {
      localObject1 = super.bhW();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(268698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h
 * JD-Core Version:    0.7.0.1
 */