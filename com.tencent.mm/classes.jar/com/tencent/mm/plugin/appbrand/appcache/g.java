package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.b.p;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.appbrand.config.t;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.doo;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class g
  extends c<kn>
{
  final d rr;
  
  public g(km paramkm)
  {
    this(paramkm, "/cgi-bin/mmbiz-bin/wxaapp/batchgetwxadownloadurl");
  }
  
  private g(km paramkm, String paramString)
  {
    AppMethodBeat.i(174705);
    d.a locala = new d.a();
    locala.funcId = 1713;
    locala.uri = paramString;
    locala.iLN = paramkm;
    locala.iLO = new kn();
    if ((paramkm.KOF == null) || (paramkm.KOF.dUS == 0))
    {
      paramString = paramkm.KOE.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (bml)paramString.next();
        localObject = (Integer)t.lfK.get(((bml)localObject).LVf.dNI);
        if ((localObject != null) && (((Integer)localObject).intValue() > 0))
        {
          if (paramkm.KOF == null)
          {
            paramkm.KOF = new acc();
            paramkm.KOF.LmF = false;
            paramkm.KOF.LmG = 1;
          }
          paramkm.KOF.dUS = ((Integer)localObject).intValue();
        }
      }
    }
    paramkm = locala.aXF();
    this.rr = paramkm;
    c(paramkm);
    AppMethodBeat.o(174705);
  }
  
  public final f<c.a<kn>> aYI()
  {
    AppMethodBeat.i(226350);
    Object localObject3 = (km)this.rr.iLK.iLR;
    int i = ((km)localObject3).scene;
    Object localObject1 = a.a((acc)Objects.requireNonNull(((km)localObject3).KOF));
    Object localObject4 = ((km)localObject3).KOE;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("[");
    localObject4 = ((List)localObject4).iterator();
    if (((Iterator)localObject4).hasNext())
    {
      bml localbml = (bml)((Iterator)localObject4).next();
      ((StringBuilder)localObject3).append("{");
      if (!TextUtils.isEmpty(localbml.LVf.dNI)) {
        ((StringBuilder)localObject3).append("appId:").append(localbml.LVf.dNI);
      }
      for (;;)
      {
        ((StringBuilder)localObject3).append(", module:").append(localbml.LVf.MbW);
        ((StringBuilder)localObject3).append(", package_type:").append(localbml.LVf.MbZ);
        ((StringBuilder)localObject3).append(", version_type:").append(localbml.LVf.KXC);
        if ((j.a.sE(localbml.LVf.KXC)) && (localbml.LVk != 0)) {
          ((StringBuilder)localObject3).append(", dev_uin:").append(p.getString(localbml.LVk));
        }
        if (localbml.KXD > 0) {
          ((StringBuilder)localObject3).append(", version:").append(localbml.KXD);
        }
        if ((localbml.LVg != null) && (localbml.LVg.KXD > 0)) {
          ((StringBuilder)localObject3).append(", local_version:").append(localbml.LVg.KXD);
        }
        if (localbml.LVj) {
          ((StringBuilder)localObject3).append(", need_zstd:true");
        }
        ((StringBuilder)localObject3).append("},");
        break;
        if (!TextUtils.isEmpty(localbml.LVf.username)) {
          ((StringBuilder)localObject3).append("username:").append(localbml.LVf.username);
        }
      }
    }
    ((StringBuilder)localObject3).append("]");
    Log.i("MicroMsg.AppBrand.CgiBatchGetPkgDownloadInfo", "run(), scene:%d, source:%s, req_list:%s", new Object[] { Integer.valueOf(i), localObject1, ((StringBuilder)localObject3).toString() });
    try
    {
      localObject1 = super.aYI();
      return localObject1;
    }
    finally
    {
      AppMethodBeat.o(226350);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.g
 * JD-Core Version:    0.7.0.1
 */