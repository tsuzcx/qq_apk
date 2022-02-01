package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<buh>
{
  public String yZF;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new bug();
    d.a locala = new d.a();
    locala.iLN = ((com.tencent.mm.bw.a)localObject);
    locala.iLO = new buh();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((bug)localObject).iwu = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.aXF();
    ((d)localObject).setIsUserCmd(paramBoolean);
    c((d)localObject);
    this.yZF = paramString;
    Log.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */