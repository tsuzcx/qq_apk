package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.protocal.protobuf.bhq;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends com.tencent.mm.al.a<bhr>
{
  public String vsz;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new bhq();
    b.a locala = new b.a();
    locala.hNM = ((com.tencent.mm.bx.a)localObject);
    locala.hNN = new bhr();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((bhq)localObject).hzA = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.aDC();
    ((b)localObject).setIsUserCmd(paramBoolean);
    c((b)localObject);
    this.vsz = paramString;
    ad.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */