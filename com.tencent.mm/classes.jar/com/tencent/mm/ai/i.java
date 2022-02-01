package com.tencent.mm.ai;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cxg;
import com.tencent.mm.protocal.protobuf.cxi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Map;

public final class i
  extends f
{
  public final void a(Map<String, String> paramMap, k.b paramb) {}
  
  public final f apu()
  {
    AppMethodBeat.i(20237);
    i locali = new i();
    AppMethodBeat.o(20237);
    return locali;
  }
  
  public final void b(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20238);
    byte[] arrayOfByte;
    if (!bt.isNullOrNil(paramb.appId))
    {
      paramString = paramb.dxG;
      paramd = new cxi();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.Epv = new cxg();
      paramd.Epv.rVL = paramb.appId;
      try
      {
        paramd = Base64.encodeToString(paramd.toByteArray(), 0);
        paramString = paramd;
        paramd = paramd.replace("\n", "");
        paramString = paramd;
      }
      catch (IOException paramd)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      paramb.dxG = paramString;
      paramStringBuilder.append("<statextstr>" + bt.aGf(paramb.dxG) + "</statextstr>");
      AppMethodBeat.o(20238);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ai.i
 * JD-Core Version:    0.7.0.1
 */