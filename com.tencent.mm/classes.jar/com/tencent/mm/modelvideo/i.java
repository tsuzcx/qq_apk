package com.tencent.mm.modelvideo;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.g.d;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.exx;
import com.tencent.mm.protocal.protobuf.exy;
import com.tencent.mm.protocal.protobuf.fnq;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class i
  extends p
  implements m
{
  private h callback;
  private String clientId;
  private long oYW;
  private z oYX;
  private d oYY;
  private c rr;
  
  public i(long paramLong, z paramz, d paramd, String paramString)
  {
    AppMethodBeat.i(126838);
    this.oYW = -1L;
    this.oYX = null;
    this.oYY = null;
    this.clientId = "";
    Log.i("MicroMsg.NetSceneMassUploadSight", "massSendId %d, clientId %s", new Object[] { Long.valueOf(paramLong), paramString });
    this.oYW = paramLong;
    this.oYX = paramz;
    this.oYY = paramd;
    this.clientId = paramString;
    AppMethodBeat.o(126838);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    int i = 0;
    AppMethodBeat.i(126839);
    this.callback = paramh;
    paramh = new c.a();
    paramh.otE = new exx();
    paramh.otF = new exy();
    paramh.uri = "/cgi-bin/micromsg-bin/sendsight";
    paramh.funcId = 245;
    this.rr = paramh.bEF();
    paramh = (exx)c.b.b(this.rr.otB);
    paramh.aesKey = this.oYY.field_aesKey;
    paramh.QCC = this.clientId;
    paramh.md5 = this.oYX.ibd;
    paramh.playtime = this.oYX.omT;
    v.bOh();
    Object localObject = aa.PY(this.oYX.getFileName());
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions((String)localObject);
    if (localOptions != null)
    {
      paramh.thumbWidth = localOptions.outWidth;
      paramh.thumbHeight = localOptions.outHeight;
    }
    for (;;)
    {
      paramh.oZp = this.oYX.paZ;
      localObject = Util.nullAs(this.oYX.pbj, "").split(",");
      if ((localObject != null) && (localObject.length > 0)) {
        break;
      }
      Log.e("MicroMsg.NetSceneMassUploadSight", "cdn upload video done, massSendId[%d], split username fail", new Object[] { Long.valueOf(this.oYW) });
      AppMethodBeat.o(126839);
      return -1;
      Log.w("MicroMsg.NetSceneMassUploadSight", "sight send getImageOptions for thumb failed path:%s", new Object[] { localObject });
    }
    int j = localObject.length;
    while (i < j)
    {
      localOptions = localObject[i];
      fnq localfnq = new fnq();
      localfnq.username = localOptions;
      paramh.abzx.add(localfnq);
      i += 1;
    }
    paramh.url = this.oYY.field_fileId;
    paramh.omT = this.oYX.osy;
    i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(126839);
    return i;
  }
  
  public final int getType()
  {
    return 245;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126840);
    Log.i("MicroMsg.NetSceneMassUploadSight", "cdntra onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " useCdnTransClientId:" + this.clientId + " massSendId " + this.oYW);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(126840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.i
 * JD-Core Version:    0.7.0.1
 */