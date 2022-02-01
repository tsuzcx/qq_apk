package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.protocal.protobuf.crf;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.z;

public final class a
  extends z<crg>
{
  public String KwU;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new crf();
    c.a locala = new c.a();
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = new crg();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((crf)localObject).nQE = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.bEF();
    ((c)localObject).setIsUserCmd(paramBoolean);
    c((c)localObject);
    this.KwU = paramString;
    Log.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */