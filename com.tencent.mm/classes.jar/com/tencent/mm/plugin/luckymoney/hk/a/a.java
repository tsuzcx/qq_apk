package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<bfb>
{
  public a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(213267);
    Object localObject = new bfa();
    ((bfa)localObject).egX = paramString1;
    ((bfa)localObject).yQE = paramString2;
    ((bfa)localObject).limit = 11;
    ((bfa)localObject).offset = paramInt1;
    ((bfa)localObject).msgType = 1;
    ((bfa)localObject).scene = paramInt2;
    d.a locala = new d.a();
    locala.iLN = ((com.tencent.mm.bw.a)localObject);
    locala.iLO = new bfb();
    locala.funcId = 4889;
    locala.uri = "/cgi-bin/mmpay-bin/foreignhbdetail";
    localObject = locala.aXF();
    ((d)localObject).setIsUserCmd(true);
    c((d)localObject);
    Log.i("MicroMsg.CgiHKHbDetail", "nativeurl: %s, sendid: %s, limit: %s, offset: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(213267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.a
 * JD-Core Version:    0.7.0.1
 */