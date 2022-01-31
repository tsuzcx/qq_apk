package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

final class q$2
  implements b.a
{
  q$2(q paramq, q.a parama, String paramString) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(135590);
    if ((paramInt1 != 0) || (paramInt2 != 0) || (paramb.fsW.fta == null))
    {
      ab.e("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: get sessionkey fail,errType:" + paramInt1 + ",errCode:" + paramInt2);
      q.a(this.kMv, paramInt1, paramInt2, paramString, null, false, this.kMt);
      AppMethodBeat.o(135590);
      return;
    }
    paramString = (aja)paramb.fsW.fta;
    paramb = new p();
    paramb.kMp = paramString.wON;
    paramb.kMr = bo.yB();
    paramb.kMq = paramString.xaJ;
    ab.i("MicroMsg.OpenVoice.OpenVoiceSessionMgr", "hy: getSession sessionKey: %s", new Object[] { paramb });
    this.kMv.kMs.put(this.hye, paramb);
    q.a(this.kMv, 0, 0, "", paramb, true, this.kMt);
    AppMethodBeat.o(135590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.q.2
 * JD-Core Version:    0.7.0.1
 */