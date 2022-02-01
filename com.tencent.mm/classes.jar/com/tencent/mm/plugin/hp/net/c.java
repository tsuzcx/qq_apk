package com.tencent.mm.plugin.hp.net;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.boots.a.f;
import com.tencent.mm.protocal.protobuf.cce;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.cch;
import com.tencent.mm.protocal.protobuf.cqg;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  extends a
{
  private String mAppId;
  private f tGb;
  
  public c(String paramString1, String paramString2, String paramString3, f paramf)
  {
    AppMethodBeat.i(189691);
    this.mAppId = paramString1;
    this.tGb = paramf;
    this.type = "liteappconfig_".concat(String.valueOf(paramString1));
    this.tFS = paramString2;
    this.tFT = paramString3;
    this.mScene = 0;
    AppMethodBeat.o(189691);
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(189692);
    ac.i("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "errType:%d errCode:%d errMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramArrayOfByte = (cce)((b)paramq).hvs.hvw;
      Object localObject = paramArrayOfByte.FqE;
      ac.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "node is no empty. try to process");
      paramq = new com.tencent.mm.plugin.boots.a.g();
      if (localObject != null)
      {
        if (((cch)localObject).FqL != null)
        {
          paramq.ntk = ((cch)localObject).FqL.MD5;
          paramq.gnO = ((cch)localObject).FqL.Url;
          paramq.fileSize = ((cch)localObject).FqL.FileSize;
        }
        paramq.nth = Integer.valueOf(((cch)localObject).state);
        paramq.ntj = Integer.valueOf(((cch)localObject).FqK);
        paramq.nti = Integer.valueOf(((cch)localObject).FqJ);
        paramq.ntl = ((cch)localObject).vyz;
        paramq.appId = this.mAppId;
        if (((cch)localObject).FqN != null)
        {
          localObject = ((cch)localObject).FqN.iterator();
          while (((Iterator)localObject).hasNext())
          {
            ccf localccf = (ccf)((Iterator)localObject).next();
            if ("signature_key".equals(localccf.key)) {
              paramq.ntm = localccf.value;
            }
          }
        }
      }
    }
    for (paramq.errorCode = paramArrayOfByte.FqG;; paramq.errorCode = -1)
    {
      this.tGb.a(paramq);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(189692);
      return;
      ac.d("MicroMsg.Tinker.NetSceneCheckLiteAppUpdate", "check tinker update failed.");
      paramq = new com.tencent.mm.plugin.boots.a.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.net.c
 * JD-Core Version:    0.7.0.1
 */