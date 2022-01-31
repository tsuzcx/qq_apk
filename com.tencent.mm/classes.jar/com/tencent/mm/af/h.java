package com.tencent.mm.af;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.Map;

public final class h
  extends f
{
  public final f Yk()
  {
    AppMethodBeat.i(16194);
    h localh = new h();
    AppMethodBeat.o(16194);
    return localh;
  }
  
  public final void a(Map<String, String> paramMap, j.b paramb) {}
  
  public final void b(StringBuilder paramStringBuilder, j.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16195);
    byte[] arrayOfByte;
    if (!bo.isNullOrNil(paramb.appId))
    {
      paramString = paramb.cGU;
      paramd = new cgh();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.xRa = new cgf();
      paramd.xRa.nmH = paramb.appId;
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
          ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      paramb.cGU = paramString;
      paramStringBuilder.append("<statextstr>" + bo.apT(paramb.cGU) + "</statextstr>");
      AppMethodBeat.o(16195);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.af.h
 * JD-Core Version:    0.7.0.1
 */