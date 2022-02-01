package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpn;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private g callback;
  private String clientId;
  private long hyw;
  private s hyx;
  private d hyy;
  private b rr;
  
  public e(long paramLong, s params, d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.hyw = -1L;
    this.hyx = null;
    this.hyy = null;
    this.clientId = "";
    ad.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.hyw = paramLong;
    this.hyx = params;
    this.hyy = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = paramg;
    paramg = new b.a();
    paramg.gUU = new cpn();
    paramg.gUV = new cpo();
    paramg.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramg.funcId = 245;
    this.rr = paramg.atI();
    paramg = (cpn)this.rr.gUS.gUX;
    paramg.fMw = this.hyy.field_aesKey;
    paramg.wNY = this.clientId;
    paramg.md5 = this.hyx.dyw;
    paramg.Ejb = this.hyx.gOY;
    o.aCI();
    Object localObject = t.zR(this.hyx.getFileName());
    BitmapFactory.Options localOptions = f.aFf((String)localObject);
    if (localOptions != null)
    {
      paramg.thumbWidth = localOptions.outWidth;
      paramg.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      paramg.hyP = this.hyx.hAf;
      localObject = bt.by(this.hyx.hAp, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      ad.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.hyw) });
      AppMethodBeat.o(126839);
      return -1;
      ad.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      dck localdck = new dck();
      localdck.username = localOptions;
      paramg.Eja.add(localdck);
      i += 1;
    }
    paramg.url = this.hyy.field_fileId;
    paramg.gOY = this.hyx.gTY;
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
    ad.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.hyw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */