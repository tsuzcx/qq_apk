package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends c<azt>
{
  public String thF;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new azs();
    b.a locala = new b.a();
    locala.gUU = ((com.tencent.mm.bx.a)localObject);
    locala.gUV = new azt();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((azs)localObject).gGQ = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.atI();
    ((b)localObject).setIsUserCmd(paramBoolean);
    this.rr = ((b)localObject);
    this.thF = paramString;
    ad.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */