package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.dhf;
import com.tencent.mm.protocal.protobuf.dhh;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dyu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private f DNa;
  private String mAppId;
  
  public c(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(195503);
    this.mAppId = paramString1;
    this.DNa = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.DMR = paramString2;
    this.DMS = paramString3;
    this.mScene = 0;
    this.DMT.addAll(e.eIb());
    paramString1 = this.DMT;
    paramString2 = new dhf();
    paramString2.key = "package_id";
    paramString2.value = "wechat-android";
    paramString1.add(paramString2);
    AppMethodBeat.o(195503);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(195506);
    Log.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (dhh)d.c.b(((d)params).lBS);
      Object localObject = paramArrayOfByte.TOs;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      params = new g();
      if (localObject != null)
      {
        if (((dhk)localObject).TOz != null)
        {
          params.smU = ((dhk)localObject).TOz.MD5;
          params.smT = ((dhk)localObject).TOz.Url;
          params.fileSize = ((dhk)localObject).TOz.HlG;
        }
        params.smQ = Integer.valueOf(((dhk)localObject).state);
        params.smS = Integer.valueOf(((dhk)localObject).TOy);
        params.smR = Integer.valueOf(((dhk)localObject).TOx);
        params.coY = ((dhk)localObject).GIL;
        params.appId = this.mAppId;
        if (((dhk)localObject).TOB != null)
        {
          localObject = ((dhk)localObject).TOB.iterator();
          while (((Iterator)localObject).hasNext())
          {
            dhi localdhi = (dhi)((Iterator)localObject).next();
            if ("signature_key".equals(localdhi.key)) {
              params.coX = localdhi.value;
            }
          }
        }
      }
    }
    for (params.errorCode = paramArrayOfByte.TOu;; params.errorCode = -1)
    {
      this.DNa.a(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(195506);
      return;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      params = new g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */