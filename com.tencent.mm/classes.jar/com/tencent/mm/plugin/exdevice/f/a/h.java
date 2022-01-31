package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.ww;
import com.tencent.mm.protocal.protobuf.wx;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.plugin.exdevice.a.a<ww, wx>
{
  private final WeakReference<b<h>> lCN;
  String username;
  
  public h(String paramString, b<h> paramb)
  {
    AppMethodBeat.i(19450);
    this.username = paramString;
    this.lCN = new WeakReference(paramb);
    AppMethodBeat.o(19450);
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
    AppMethodBeat.i(19451);
    ab.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.bqa().LD(this.username);
    }
    paramq = (b)this.lCN.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(19451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.h
 * JD-Core Version:    0.7.0.1
 */