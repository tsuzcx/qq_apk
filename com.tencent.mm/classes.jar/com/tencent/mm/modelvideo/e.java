package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private g callback;
  private String clientId;
  private long hYX;
  private s hYY;
  private d hYZ;
  private b rr;
  
  public e(long paramLong, s params, d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.hYX = -1L;
    this.hYY = null;
    this.hYZ = null;
    this.clientId = "";
    ac.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.hYX = paramLong;
    this.hYY = params;
    this.hYZ = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = paramg;
    paramg = new b.a();
    paramg.hvt = new cuu();
    paramg.hvu = new cuv();
    paramg.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramg.funcId = 245;
    this.rr = paramg.aAz();
    paramg = (cuu)this.rr.hvr.hvw;
    paramg.fQi = this.hYZ.field_aesKey;
    paramg.yaF = this.clientId;
    paramg.md5 = this.hYY.dwi;
    paramg.FFZ = this.hYY.hpy;
    o.aJy();
    Object localObject = t.DW(this.hYY.getFileName());
    BitmapFactory.Options localOptions = f.aKw((String)localObject);
    if (localOptions != null)
    {
      paramg.thumbWidth = localOptions.outWidth;
      paramg.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      paramg.hZq = this.hYY.iaG;
      localObject = bs.bG(this.hYY.iaQ, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      ac.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.hYX) });
      AppMethodBeat.o(126839);
      return -1;
      ac.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      dhx localdhx = new dhx();
      localdhx.username = localOptions;
      paramg.FFY.add(localdhx);
      i += 1;
    }
    paramg.url = this.hYZ.field_fileId;
    paramg.hpy = this.hYY.hux;
    i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(126839);
    return i;
  }
  
  public final int getType()
  {
    return 245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126840);
    ac.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.hYX);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */