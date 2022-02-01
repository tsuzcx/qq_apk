package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.eeg;
import com.tencent.mm.protocal.protobuf.eeh;
import com.tencent.mm.protocal.protobuf.esh;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private String clientId;
  private long mga;
  private w mgb;
  private com.tencent.mm.i.d mgc;
  private com.tencent.mm.an.d rr;
  
  public i(long paramLong, w paramw, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.mga = -1L;
    this.mgb = null;
    this.mgc = null;
    this.clientId = "";
    Log.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.mga = paramLong;
    this.mgb = paramw;
    this.mgc = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(g paramg, com.tencent.mm.an.i parami)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = parami;
    parami = new d.a();
    parami.lBU = new eeg();
    parami.lBV = new eeh();
    parami.uri = "/cgi-bin/micromsg-bin/sendsight";
    parami.funcId = 245;
    this.rr = parami.bgN();
    parami = (eeg)d.b.b(this.rr.lBR);
    parami.aesKey = this.mgc.field_aesKey;
    parami.KeY = this.clientId;
    parami.md5 = this.mgb.fVg;
    parami.SbK = this.mgb.lvw;
    s.bqB();
    Object localObject = x.XU(this.mgb.getFileName());
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions((String)localObject);
    if (localOptions != null)
    {
      parami.thumbWidth = localOptions.outWidth;
      parami.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      parami.mgu = this.mgb.mhO;
      localObject = Util.nullAs(this.mgb.mhY, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      Log.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.mga) });
      AppMethodBeat.o(126839);
      return -1;
      Log.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      esh localesh = new esh();
      localesh.username = localOptions;
      parami.Uii.add(localesh);
      i += 1;
    }
    parami.url = this.mgc.field_fileId;
    parami.lvw = this.mgb.lAW;
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(126839);
    return i;
  }
  
  public final int getType()
  {
    return 245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126840);
    Log.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.mga);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */