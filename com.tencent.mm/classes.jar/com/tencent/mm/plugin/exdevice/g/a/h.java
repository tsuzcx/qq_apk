package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.protocal.protobuf.aab;
import com.tencent.mm.protocal.protobuf.aac;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.plugin.exdevice.b.a<aab, aac>
{
  private final WeakReference<b<h>> oTz;
  String username;
  
  public h(String paramString, b<h> paramb)
  {
    AppMethodBeat.i(23518);
    this.username = paramString;
    this.oTz = new WeakReference(paramb);
    AppMethodBeat.o(23518);
  }
  
  public final int getType()
  {
    return 1792;
  }
  
  public final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/delfollow";
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23519);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      com.tencent.mm.plugin.exdevice.model.ad.bZI().UM(this.username);
    }
    paramq = (b)this.oTz.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.h
 * JD-Core Version:    0.7.0.1
 */