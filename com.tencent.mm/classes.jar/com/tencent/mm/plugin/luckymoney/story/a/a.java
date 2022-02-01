package com.tencent.mm.plugin.luckymoney.story.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.cby;
import com.tencent.mm.protocal.protobuf.cbz;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<cbz>
{
  public String EDQ;
  
  public a(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(163688);
    Object localObject = new cby();
    d.a locala = new d.a();
    locala.lBU = ((com.tencent.mm.cd.a)localObject);
    locala.lBV = new cbz();
    locala.funcId = 3634;
    locala.uri = "/cgi-bin/micromsg-bin/getredpacketstory";
    ((cby)localObject).llH = paramString;
    if (!paramBoolean) {
      locala.timeout = 5000;
    }
    localObject = locala.bgN();
    ((d)localObject).setIsUserCmd(paramBoolean);
    c((d)localObject);
    this.EDQ = paramString;
    Log.i("MicroMsg.CgiRedPacketStoryInfo", "packet id: %s", new Object[] { paramString });
    AppMethodBeat.o(163688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.a.a
 * JD-Core Version:    0.7.0.1
 */