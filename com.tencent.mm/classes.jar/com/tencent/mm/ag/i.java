package com.tencent.mm.ag;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.Map;

public final class i
  extends f
{
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20238);
    byte[] arrayOfByte;
    if (!Util.isNullOrNil(paramb.appId))
    {
      paramString = paramb.ean;
      paramd = new eco();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.NcJ = new ecm();
      paramd.NcJ.xEN = paramb.appId;
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
          Log.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      paramb.ean = paramString;
      paramStringBuilder.append("<statextstr>" + Util.escapeStringForXml(paramb.ean) + "</statextstr>");
      AppMethodBeat.o(20238);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb) {}
  
  public final f aHj()
  {
    AppMethodBeat.i(20237);
    i locali = new i();
    AppMethodBeat.o(20237);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.i
 * JD-Core Version:    0.7.0.1
 */