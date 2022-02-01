package com.tencent.mm.plugin.exdevice.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.yg;
import com.tencent.mm.protocal.protobuf.yh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.exdevice.b.a<yg, yh>
{
  String appId;
  String cLR;
  String dfF;
  String oTy;
  private WeakReference<b<a>> oTz;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, b<a> paramb)
  {
    AppMethodBeat.i(23175);
    this.cLR = bt.nullAsNil(paramString1);
    this.dfF = bt.nullAsNil(paramString2);
    this.oTy = bt.nullAsNil(paramString3);
    this.appId = bt.nullAsNil(paramString4);
    this.oTz = new WeakReference(paramb);
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
    ad.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.oTz.get();
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