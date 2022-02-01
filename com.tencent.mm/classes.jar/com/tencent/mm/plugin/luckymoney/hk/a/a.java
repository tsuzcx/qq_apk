package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends c<bmf>
{
  public a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(273355);
    Object localObject = new bme();
    ((bme)localObject).gbn = paramString1;
    ((bme)localObject).ybP = paramString2;
    ((bme)localObject).limit = 11;
    ((bme)localObject).offset = paramInt1;
    ((bme)localObject).msgType = 1;
    ((bme)localObject).scene = paramInt2;
    d.a locala = new d.a();
    locala.lBU = ((com.tencent.mm.cd.a)localObject);
    locala.lBV = new bmf();
    locala.funcId = 4889;
    locala.uri = "/cgi-bin/mmpay-bin/foreignhbdetail";
    localObject = locala.bgN();
    ((d)localObject).setIsUserCmd(true);
    c((d)localObject);
    Log.i("MicroMsg.CgiHKHbDetail", "nativeurl: %s, sendid: %s, limit: %s, offset: %s, scene: %s", new Object[] { paramString1, paramString2, Integer.valueOf(11), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(273355);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.a.a
 * JD-Core Version:    0.7.0.1
 */