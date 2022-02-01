package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.duc;
import com.tencent.mm.protocal.protobuf.dud;
import com.tencent.mm.protocal.protobuf.eif;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
  extends q
  implements m
{
  private i callback;
  private String clientId;
  private s jqA;
  private com.tencent.mm.i.d jqB;
  private long jqz;
  private com.tencent.mm.ak.d rr;
  
  public e(long paramLong, s params, com.tencent.mm.i.d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.jqz = -1L;
    this.jqA = null;
    this.jqB = null;
    this.clientId = "";
    Log.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.jqz = paramLong;
    this.jqA = params;
    this.jqB = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(g paramg, i parami)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = parami;
    parami = new d.a();
    parami.iLN = new duc();
    parami.iLO = new dud();
    parami.uri = "/cgi-bin/micromsg-bin/sendsight";
    parami.funcId = 245;
    this.rr = parami.aXF();
    parami = (duc)this.rr.iLK.iLR;
    parami.aesKey = this.jqB.field_aesKey;
    parami.DRR = this.clientId;
    parami.md5 = this.jqA.ebj;
    parami.LaB = this.jqA.iFw;
    o.bhj();
    Object localObject = t.Qx(this.jqA.getFileName());
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions((String)localObject);
    if (localOptions != null)
    {
      parami.thumbWidth = localOptions.outWidth;
      parami.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      parami.jqS = this.jqA.jsl;
      localObject = Util.nullAs(this.jqA.jsv, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      Log.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.jqz) });
      AppMethodBeat.o(126839);
      return -1;
      Log.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      eif localeif = new eif();
      localeif.username = localOptions;
      parami.MVN.add(localeif);
      i += 1;
    }
    parami.url = this.jqB.field_fileId;
    parami.iFw = this.jqA.iKP;
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
    Log.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.jqz);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.e
 * JD-Core Version:    0.7.0.1
 */