package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.c;
import com.tencent.mm.protocal.protobuf.bdk;
import com.tencent.mm.protocal.protobuf.bdl;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends c<bdl>
{
  public String upV;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new bdk();
    b.a locala = new b.a();
    locala.hvt = ((com.tencent.mm.bw.a)localObject);
    locala.hvu = new bdl();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((bdk)localObject).hhr = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.aAz();
    ((b)localObject).setIsUserCmd(paramBoolean);
    this.rr = ((b)localObject);
    this.upV = paramString;
    ac.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */