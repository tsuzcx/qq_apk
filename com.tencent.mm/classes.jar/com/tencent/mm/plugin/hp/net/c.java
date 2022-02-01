package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.g;
import com.tencent.mm.protocal.protobuf.cgv;
import com.tencent.mm.protocal.protobuf.cgw;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.cvl;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private String mAppId;
  private com.tencent.mm.plugin.boots.a.f uIK;
  
  public c(String paramString1, String paramString2, String paramString3, com.tencent.mm.plugin.boots.a.f paramf)
  {
    AppMethodBeat.i(218904);
    this.mAppId = paramString1;
    this.uIK = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.uIB = paramString2;
    this.uIC = paramString3;
    this.mScene = 0;
    AppMethodBeat.o(218904);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(218905);
    ad.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cgv)((b)paramq).hNL.hNQ;
      Object localObject = paramArrayOfByte.Hao;
      ad.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      paramq = new g();
      if (localObject != null)
      {
        if (((cgy)localObject).Hav != null)
        {
          paramq.nUg = ((cgy)localObject).Hav.MD5;
          paramq.gHx = ((cgy)localObject).Hav.Url;
          paramq.fileSize = ((cgy)localObject).Hav.FileSize;
        }
        paramq.nUd = Integer.valueOf(((cgy)localObject).state);
        paramq.nUf = Integer.valueOf(((cgy)localObject).Hau);
        paramq.nUe = Integer.valueOf(((cgy)localObject).Hat);
        paramq.nUh = ((cgy)localObject).wDT;
        paramq.appId = this.mAppId;
        if (((cgy)localObject).Hax != null)
        {
          localObject = ((cgy)localObject).Hax.iterator();
          while (((Iterator)localObject).hasNext())
          {
            cgw localcgw = (cgw)((Iterator)localObject).next();
            if ("signature_key".equals(localcgw.key)) {
              paramq.nUi = localcgw.value;
            }
          }
        }
      }
    }
    for (paramq.errorCode = paramArrayOfByte.Haq;; paramq.errorCode = -1)
    {
      this.uIK.a(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(218905);
      return;
      ad.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      paramq = new g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */