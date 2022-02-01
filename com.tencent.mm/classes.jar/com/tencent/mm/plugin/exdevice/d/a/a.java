package com.tencent.mm.plugin.exdevice.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.zb;
import com.tencent.mm.protocal.protobuf.zc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.exdevice.b.a<zb, zc>
{
  String appId;
  String cIZ;
  String dda;
  String pwJ;
  private WeakReference<b<a>> pwK;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, b<a> paramb)
  {
    AppMethodBeat.i(23175);
    this.cIZ = bs.nullAsNil(paramString1);
    this.dda = bs.nullAsNil(paramString2);
    this.pwJ = bs.nullAsNil(paramString3);
    this.appId = bs.nullAsNil(paramString4);
    this.pwK = new WeakReference(paramb);
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
    ac.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.pwK.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23176);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.d.a.a
 * JD-Core Version:    0.7.0.1
 */