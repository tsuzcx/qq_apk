package com.tencent.mm.ai;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.io.IOException;
import java.util.Map;

public final class i
  extends f
{
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(20238);
    byte[] arrayOfByte;
    if (!bt.isNullOrNil(paramb.appId))
    {
      paramString = paramb.dHv;
      paramd = new dih();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.parseFrom(arrayOfByte);
      paramd.Hxc = new dif();
      paramd.Hxc.ubt = paramb.appId;
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
      paramb.dHv = paramString;
      paramStringBuilder.append("<statextstr>" + bt.aRc(paramb.dHv) + "</statextstr>");
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
  
  public final void a(Map<String, String> paramMap, k.b paramb) {}
  
  public final f aot()
  {
    AppMethodBeat.i(20237);
    i locali = new i();
    AppMethodBeat.o(20237);
    return locali;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.i
 * JD-Core Version:    0.7.0.1
 */