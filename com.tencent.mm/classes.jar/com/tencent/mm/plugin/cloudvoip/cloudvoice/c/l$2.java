package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.aeg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class l$2
  implements b.a
{
  l$2(l paraml, l.a parama, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.ecF.ecN == null))
    {
      y.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramInt1 + ",errCode:" + paramInt2);
      l.a(this.iGC, paramInt1, paramInt2, paramString, null, false, this.iGA);
      return;
    }
    paramString = (aeg)paramb.ecF.ecN;
    paramb = new k();
    paramb.iGw = paramString.tcq;
    paramb.iGy = bk.UZ();
    paramb.iGx = paramString.tcr;
    y.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramb });
    this.iGC.iGz.put(this.gge, paramb);
    l.a(this.iGC, 0, 0, "", paramb, true, this.iGA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l.2
 * JD-Core Version:    0.7.0.1
 */