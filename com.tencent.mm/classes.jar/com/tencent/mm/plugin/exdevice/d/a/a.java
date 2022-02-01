package com.tencent.mm.plugin.exdevice.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.protocal.protobuf.abl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.exdevice.b.a<abk, abl>
{
  String appId;
  String cVh;
  String dpB;
  String qgT;
  private WeakReference<b<a>> qgU;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, b<a> paramb)
  {
    AppMethodBeat.i(23175);
    this.cVh = bu.nullAsNil(paramString1);
    this.dpB = bu.nullAsNil(paramString2);
    this.qgT = bu.nullAsNil(paramString3);
    this.appId = bu.nullAsNil(paramString4);
    this.qgU = new WeakReference(paramb);
    AppMethodBeat.o(23175);
  }
  
  public final int getType()
  {
    return 1799;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23176);
    ae.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.qgU.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.d.a.a
 * JD-Core Version:    0.7.0.1
 */