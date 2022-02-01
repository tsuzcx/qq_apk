package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.cwf;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private String mAppId;
  private com.tencent.mm.plugin.boots.a.f uUx;
  
  public c(String paramString1, String paramString2, String paramString3, com.tencent.mm.plugin.boots.a.f paramf)
  {
    AppMethodBeat.i(196771);
    this.mAppId = paramString1;
    this.uUx = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.uUo = paramString2;
    this.uUp = paramString3;
    this.mScene = 0;
    AppMethodBeat.o(196771);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(196772);
    ae.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (chp)((b)paramq).hQE.hQJ;
      Object localObject = paramArrayOfByte.HtO;
      ae.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      paramq = new g();
      if (localObject != null)
      {
        if (((chs)localObject).HtV != null)
        {
          paramq.nZM = ((chs)localObject).HtV.MD5;
          paramq.gKg = ((chs)localObject).HtV.Url;
          paramq.fileSize = ((chs)localObject).HtV.FileSize;
        }
        paramq.nZJ = Integer.valueOf(((chs)localObject).state);
        paramq.nZL = Integer.valueOf(((chs)localObject).HtU);
        paramq.nZK = Integer.valueOf(((chs)localObject).HtT);
        paramq.nZN = ((chs)localObject).wTE;
        paramq.appId = this.mAppId;
        if (((chs)localObject).HtX != null)
        {
          localObject = ((chs)localObject).HtX.iterator();
          while (((Iterator)localObject).hasNext())
          {
            chq localchq = (chq)((Iterator)localObject).next();
            if ("signature_key".equals(localchq.key)) {
              paramq.nZO = localchq.value;
            }
          }
        }
      }
    }
    for (paramq.errorCode = paramArrayOfByte.HtQ;; paramq.errorCode = -1)
    {
      this.uUx.a(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(196772);
      return;
      ae.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      paramq = new g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */