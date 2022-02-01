package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a;
import com.tencent.mm.am.b;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.b.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.appbrand.config.w;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.cip;
import com.tencent.mm.protocal.protobuf.djr;
import com.tencent.mm.protocal.protobuf.erm;
import com.tencent.mm.protocal.protobuf.ky;
import com.tencent.mm.protocal.protobuf.kz;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public final class h
  extends b<kz>
{
  final c rr;
  
  public h(ky paramky)
  {
    this(paramky, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private h(ky paramky, String paramString)
  {
    AppMethodBeat.i(174705);
    c.a locala = new c.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.otE = paramky;
    locala.otF = new kz();
    if ((paramky.YMR == null) || (paramky.YMR.hUn == 0))
    {
      paramString = paramky.YMQ.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (cip)paramString.next();
        localObject = (Integer)w.raN.get(((cip)localObject).aard.appid);
        if ((localObject != null) && (((Integer)localObject).intValue() > 0))
        {
          if (paramky.YMR == null)
          {
            paramky.YMR = new aeo();
            paramky.YMR.ZmA = false;
            paramky.YMR.ZmB = 1;
          }
          paramky.YMR.hUn = ((Integer)localObject).intValue();
        }
      }
    }
    paramky = locala.bEF();
    this.rr = paramky;
    c(paramky);
    AppMethodBeat.o(174705);
  }
  
  public final f<b.a<kz>> bFJ()
  {
    AppMethodBeat.i(320303);
    Object localObject3 = (ky)c.b.b(this.rr.otB);
    int i = ((ky)localObject3).scene;
    Object localObject1 = a.b((aeo)Objects.requireNonNull(((ky)localObject3).YMR));
    Object localObject4 = ((ky)localObject3).YMQ;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[");
    localObject4 = ((List)localObject4).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      cip localcip = (cip)((Iterator)localObject4).next();
      ((StringBuilder)localObject3).append("{");
      if (!TextUtils.isEmpty(localcip.aard.appid)) {
        ((StringBuilder)localObject3).append("appId:").append(localcip.aard.appid);
      }
      for (;;)
      {
        ((StringBuilder)localObject3).append(", module:").append(localcip.aard.aazm);
        ((StringBuilder)localObject3).append(", package_type:").append(localcip.aard.aazp);
        ((StringBuilder)localObject3).append(", version_type:").append(localcip.aard.Tqb);
        if ((k.a.vK(localcip.aard.Tqb)) && (localcip.aari != 0)) {
          ((StringBuilder)localObject3).append(", dev_uin:").append(p.getString(localcip.aari));
        }
        if (localcip.YWM > 0) {
          ((StringBuilder)localObject3).append(", version:").append(localcip.YWM);
        }
        if ((localcip.aare != null) && (localcip.aare.YWM > 0)) {
          ((StringBuilder)localObject3).append(", local_version:").append(localcip.aare.YWM);
        }
        if (localcip.aarh) {
          ((StringBuilder)localObject3).append(", need_zstd:true");
        }
        ((StringBuilder)localObject3).append("},");
        break;
        if (!TextUtils.isEmpty(localcip.aard.username)) {
          ((StringBuilder)localObject3).append("username:").append(localcip.aard.username);
        }
      }
    }
    ((StringBuilder)localObject3).append("]");
    Log.i("MicroMsg.AppBrand.CgiBatchGetPkgDownloadInfo", "run(), scene:%d, source:%s, req_list:%s", new Object[] { Integer.valueOf(i), localObject1, ((StringBuilder)localObject3).toString() });
    try
    {
      localObject1 = super.bFJ();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(320303);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.h
 * JD-Core Version:    0.7.0.1
 */