package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.day;
import com.tencent.mm.protocal.protobuf.daz;
import com.tencent.mm.protocal.protobuf.doj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private f callback;
  private String clientId;
  private long ivn;
  private s ivo;
  private d ivp;
  private b rr;
  
  public e(long paramLong, s params, d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.ivn = -1L;
    this.ivo = null;
    this.ivp = null;
    this.clientId = "";
    ae.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.ivn = paramLong;
    this.ivo = params;
    this.ivp = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hQF = new day();
    paramf.hQG = new daz();
    paramf.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramf.funcId = 245;
    this.rr = paramf.aDS();
    paramf = (day)this.rr.hQD.hQJ;
    paramf.gmb = this.ivp.field_aesKey;
    paramf.zHQ = this.clientId;
    paramf.md5 = this.ivo.dJw;
    paramf.GfX = this.ivo.hKI;
    o.aNh();
    Object localObject = t.HK(this.ivo.getFileName());
    BitmapFactory.Options localOptions = h.aRz((String)localObject);
    if (localOptions != null)
    {
      paramf.thumbWidth = localOptions.outWidth;
      paramf.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      paramf.ivG = this.ivo.iwW;
      localObject = bu.bI(this.ivo.ixg, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      ae.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.ivn) });
      AppMethodBeat.o(126839);
      return -1;
      ae.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      doj localdoj = new doj();
      localdoj.username = localOptions;
      paramf.HKb.add(localdoj);
      i += 1;
    }
    paramf.url = this.ivp.field_fileId;
    paramf.hKI = this.ivo.hPI;
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
    ae.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.ivn);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */