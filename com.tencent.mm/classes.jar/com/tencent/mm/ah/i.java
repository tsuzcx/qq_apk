package com.tencent.mm.ah;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dja;
import com.tencent.mm.protocal.protobuf.djc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.IOException;
import java.util.Map;

public final class i
  extends f
{
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20238);
    byte[] arrayOfByte;
    if (!bu.isNullOrNil(paramb.appId))
    {
      paramString = paramb.dIA;
      paramd = new djc();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.HQL = new dja();
      paramd.HQL.umv = paramb.appId;
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
          ae.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      paramb.dIA = paramString;
      paramStringBuilder.append("<statextstr>" + bu.aSz(paramb.dIA) + "</statextstr>");
      AppMethodBeat.o(20238);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb) {}
  
  public final f aoI()
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