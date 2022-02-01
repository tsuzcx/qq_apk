package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.cxw;
import com.tencent.mm.protocal.protobuf.cxx;
import com.tencent.mm.protocal.protobuf.cxz;
import com.tencent.mm.protocal.protobuf.doy;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private String mAppId;
  private f ymY;
  
  public c(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(196779);
    this.mAppId = paramString1;
    this.ymY = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.ymP = paramString2;
    this.ymQ = paramString3;
    this.mScene = 0;
    this.ymR.addAll(e.dZe());
    AppMethodBeat.o(196779);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196780);
    Log.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cxw)((d)params).iLL.iLR;
      Object localObject = paramArrayOfByte.MCM;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      params = new g();
      if (localObject != null)
      {
        if (((cxz)localObject).MCT != null)
        {
          params.pkL = ((cxz)localObject).MCT.MD5;
          params.pkK = ((cxz)localObject).MCT.Url;
          params.fileSize = ((cxz)localObject).MCT.FileSize;
        }
        params.pkH = Integer.valueOf(((cxz)localObject).state);
        params.pkJ = Integer.valueOf(((cxz)localObject).MCS);
        params.pkI = Integer.valueOf(((cxz)localObject).MCR);
        params.cri = ((cxz)localObject).APx;
        params.appId = this.mAppId;
        if (((cxz)localObject).MCV != null)
        {
          localObject = ((cxz)localObject).MCV.iterator();
          while (((Iterator)localObject).hasNext())
          {
            cxx localcxx = (cxx)((Iterator)localObject).next();
            if ("signature_key".equals(localcxx.key)) {
              params.crh = localcxx.value;
            }
          }
        }
      }
    }
    for (params.errorCode = paramArrayOfByte.MCO;; params.errorCode = -1)
    {
      this.ymY.a(params);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(196780);
      return;
      Log.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      params = new g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */