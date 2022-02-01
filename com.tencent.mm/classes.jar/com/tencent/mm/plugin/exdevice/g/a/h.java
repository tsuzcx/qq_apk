package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.plugin.exdevice.b.a<aba, abb>
{
  private final WeakReference<b<h>> pwK;
  String username;
  
  public h(String paramString, b<h> paramb)
  {
    AppMethodBeat.i(23518);
    this.username = paramString;
    this.pwK = new WeakReference(paramb);
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
    ac.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.cgR().YY(this.username);
    }
    paramq = (b)this.pwK.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
    AppMethodBeat.o(23519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.g.a.h
 * JD-Core Version:    0.7.0.1
 */