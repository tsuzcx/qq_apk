package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.protobuf.ve;
import com.tencent.mm.protocal.protobuf.vf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.exdevice.a.a<ve, vf>
{
  String appId;
  String bYu;
  String cqJ;
  String lCM;
  private WeakReference<b<a>> lCN;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, b<a> paramb)
  {
    AppMethodBeat.i(19067);
    this.bYu = bo.nullAsNil(paramString1);
    this.cqJ = bo.nullAsNil(paramString2);
    this.lCM = bo.nullAsNil(paramString3);
    this.appId = bo.nullAsNil(paramString4);
    this.lCN = new WeakReference(paramb);
    AppMethodBeat.o(19067);
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
    AppMethodBeat.i(19068);
    ab.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.lCN.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(19068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a.a
 * JD-Core Version:    0.7.0.1
 */