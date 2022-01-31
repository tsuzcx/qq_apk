package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.bzg;
import com.tencent.mm.protocal.protobuf.ckl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class e
  extends m
  implements k
{
  private f callback;
  private String clientId;
  private long fVM;
  private s fVN;
  private com.tencent.mm.i.d fVO;
  private b rr;
  
  public e(long paramLong, s params, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(50679);
    this.fVM = -1L;
    this.fVN = null;
    this.fVO = null;
    this.clientId = "";
    ab.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.fVM = paramLong;
    this.fVN = params;
    this.fVO = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(50679);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 0;
    AppMethodBeat.i(50680);
    this.callback = paramf;
    paramf = new b.a();
    paramf.fsX = new bzf();
    paramf.fsY = new bzg();
    paramf.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramf.funcId = 245;
    this.rr = paramf.ado();
    paramf = (bzf)this.rr.fsV.fta;
    paramf.ewj = this.fVO.field_aesKey;
    paramf.rlS = this.clientId;
    paramf.cqq = this.fVN.cHH;
    paramf.xLj = this.fVN.fXx;
    o.alE();
    Object localObject = t.vg(this.fVN.getFileName());
    BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.d.aoT((String)localObject);
    if (localOptions != null)
    {
      paramf.fgR = localOptions.outWidth;
      paramf.fgQ = localOptions.outHeight;
    }
    for (;;)
    {
      paramf.fWd = this.fVN.fXu;
      localObject = bo.bf(this.fVN.fXF, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      ab.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.fVM) });
      AppMethodBeat.o(50680);
      return -1;
      ab.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      ckl localckl = new ckl();
      localckl.username = localOptions;
      paramf.xLi.add(localckl);
      i += 1;
    }
    paramf.url = this.fVO.field_fileId;
    paramf.fXx = this.fVN.fsd;
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(50680);
    return i;
  }
  
  public final int getType()
  {
    return 245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50681);
    ab.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.fVM);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(50681);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */