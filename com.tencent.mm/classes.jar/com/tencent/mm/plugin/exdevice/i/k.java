package com.tencent.mm.plugin.exdevice.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.s;
import com.tencent.mm.sdk.platformtools.ab;

public final class k
  extends ae
  implements f
{
  private String lEk = null;
  private String lEl = null;
  private String lJz = null;
  private int lio = -1;
  
  public k(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.lEk = paramString1;
    this.lJz = paramString2;
    this.lEl = paramString3;
    this.lio = paramInt;
  }
  
  public final boolean a(com.tencent.mm.plugin.exdevice.service.m paramm, d paramd)
  {
    AppMethodBeat.i(19744);
    ab.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "execute MMWifiStatusSubscribeTaskExcuter. brandName=" + this.lEk + ",deviceType=" + this.lJz + ",deviceId=" + this.lEl + ",reqType=" + this.lio);
    aw.Rc().a(1090, this);
    paramm = new s(this.lEk, this.lJz, this.lEl, this.lio);
    aw.Rc().a(paramm, 0);
    AppMethodBeat.o(19744);
    return false;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(19743);
    ab.i("MicroMsg.exdevice.MMWifiStatusSubscribeTaskExcuter", "onSceneEnd. errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    aw.Rc().b(1090, this);
    AppMethodBeat.o(19743);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.i.k
 * JD-Core Version:    0.7.0.1
 */