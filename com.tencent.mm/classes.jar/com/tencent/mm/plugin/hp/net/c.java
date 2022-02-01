package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzq;
import com.tencent.mm.protocal.protobuf.dzr;
import com.tencent.mm.protocal.protobuf.dzt;
import com.tencent.mm.protocal.protobuf.ery;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private f JEo;
  private String mAppId;
  
  public c(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(261830);
    this.mAppId = paramString1;
    this.JEo = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.JEf = paramString2;
    this.JEg = paramString3;
    this.mScene = 0;
    this.JEh.addAll(e.fPU());
    paramString2 = this.JEh;
    paramString3 = new dzo();
    paramString3.key = "package_id";
    paramString3.value = "wechat-android";
    paramString2.add(paramString3);
    com.tencent.mm.plugin.report.service.h.OAn.b(24470, new Object[] { this.type, paramString1, Integer.valueOf(this.mScene), Boolean.FALSE });
    com.tencent.mm.plugin.report.service.h.OAn.kJ(1821, 2);
    AppMethodBeat.o(261830);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(261840);
    Log.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (dzq)c.c.b(((com.tencent.mm.am.c)params).otC);
      Object localObject = paramArrayOfByte.abeO;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      params = new g();
      if (localObject != null)
      {
        if (((dzt)localObject).abeV != null)
        {
          params.vyS = ((dzt)localObject).abeV.MD5;
          params.mOI = ((dzt)localObject).abeV.Url;
          params.fileSize = ((dzt)localObject).abeV.Nju;
        }
        params.vyP = Integer.valueOf(((dzt)localObject).state);
        params.vyR = Integer.valueOf(((dzt)localObject).abeU);
        params.vyQ = Integer.valueOf(((dzt)localObject).abeT);
        params.egJ = ((dzt)localObject).ycW;
        params.appId = this.mAppId;
        if (((dzt)localObject).abeX != null)
        {
          localObject = ((dzt)localObject).abeX.iterator();
          while (((Iterator)localObject).hasNext())
          {
            dzr localdzr = (dzr)((Iterator)localObject).next();
            if ("signature_key".equals(localdzr.key)) {
              params.egI = localdzr.value;
            }
          }
        }
      }
    }
    for (params.errorCode = paramArrayOfByte.abeQ;; params.errorCode = -1)
    {
      this.JEo.a(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(261840);
      return;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      params = new g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */