package com.tencent.mm.ah;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dcs;
import com.tencent.mm.protocal.protobuf.dcu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.util.Map;

public final class i
  extends f
{
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20238);
    byte[] arrayOfByte;
    if (!bs.isNullOrNil(paramb.appId))
    {
      paramString = paramb.dvs;
      paramd = new dcu();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.FMu = new dcs();
      paramd.FMu.tdD = paramb.appId;
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
          ac.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      paramb.dvs = paramString;
      paramStringBuilder.append("<statextstr>" + bs.aLw(paramb.dvs) + "</statextstr>");
      AppMethodBeat.o(20238);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb) {}
  
  public final f alG()
  {
    AppMethodBeat.i(20237);
    i locali = new i();
    AppMethodBeat.o(20237);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.i
 * JD-Core Version:    0.7.0.1
 */