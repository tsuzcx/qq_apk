package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.protocal.c.rk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class a
  extends com.tencent.mm.plugin.exdevice.a.a<rj, rk>
{
  String appId;
  String bJp;
  String bwK;
  String jtn;
  private WeakReference<b<a>> jto;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, b<a> paramb)
  {
    this.bwK = bk.pm(paramString1);
    this.bJp = bk.pm(paramString2);
    this.jtn = bk.pm(paramString3);
    this.appId = bk.pm(paramString4);
    this.jto = new WeakReference(paramb);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramq.toString() });
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    paramq = (b)this.jto.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1799;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.a.a
 * JD-Core Version:    0.7.0.1
 */