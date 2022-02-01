package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends com.tencent.mm.ak.a<bih>
{
  public String vEE;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new big();
    b.a locala = new b.a();
    locala.hQF = ((com.tencent.mm.bw.a)localObject);
    locala.hQG = new bih();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((big)localObject).hCo = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.aDS();
    ((b)localObject).setIsUserCmd(paramBoolean);
    c((b)localObject);
    this.vEE = paramString;
    ae.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */