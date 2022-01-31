package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.sw;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public final class h
  extends com.tencent.mm.plugin.exdevice.a.a<sw, sx>
{
  private final WeakReference<b<h>> jto;
  String username;
  
  public h(String paramString, b<h> paramb)
  {
    this.username = paramString;
    this.jto = new WeakReference(paramb);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    super.a(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    if ((paramInt2 == 0) && (paramInt3 == 0)) {
      ad.aLN().BB(this.username);
    }
    paramq = (b)this.jto.get();
    if (paramq != null) {
      paramq.a(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1792;
  }
  
  protected final String getUri()
  {
    return "/cgi-bin/mmoc-bin/hardware/delfollow";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.f.a.h
 * JD-Core Version:    0.7.0.1
 */