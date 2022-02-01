package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.i.d;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dae;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.dnm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.util.LinkedList;

public final class e
  extends n
  implements k
{
  private f callback;
  private String clientId;
  private long ist;
  private s isu;
  private d isv;
  private b rr;
  
  public e(long paramLong, s params, d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.ist = -1L;
    this.isu = null;
    this.isv = null;
    this.clientId = "";
    ad.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.ist = paramLong;
    this.isu = params;
    this.isv = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = paramf;
    paramf = new b.a();
    paramf.hNM = new dae();
    paramf.hNN = new daf();
    paramf.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramf.funcId = 245;
    this.rr = paramf.aDC();
    paramf = (dae)this.rr.hNK.hNQ;
    paramf.gjI = this.isv.field_aesKey;
    paramf.zqB = this.clientId;
    paramf.md5 = this.isu.dIs;
    paramf.FNy = this.isu.hHQ;
    o.aMJ();
    Object localObject = t.Hi(this.isu.getFileName());
    BitmapFactory.Options localOptions = g.aQc((String)localObject);
    if (localOptions != null)
    {
      paramf.thumbWidth = localOptions.outWidth;
      paramf.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      paramf.isM = this.isu.iuc;
      localObject = bt.bI(this.isu.ium, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      ad.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.ist) });
      AppMethodBeat.o(126839);
      return -1;
      ad.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      dnm localdnm = new dnm();
      localdnm.username = localOptions;
      paramf.Hqz.add(localdnm);
      i += 1;
    }
    paramf.url = this.isv.field_fileId;
    paramf.hHQ = this.isu.hMP;
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
    ad.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.ist);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */