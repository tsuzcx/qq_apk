package com.tencent.mm.ae;

import android.util.Base64;
import com.tencent.mm.protocal.c.bvm;
import com.tencent.mm.protocal.c.bvo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Map;

public final class f
  extends d
{
  public final d Fk()
  {
    return new f();
  }
  
  public final void a(StringBuilder paramStringBuilder, g.a parama, String paramString, com.tencent.mm.j.d paramd, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte;
    if (!bk.bl(parama.appId))
    {
      paramString = parama.bYN;
      paramd = new bvo();
      if (paramString != null) {
        arrayOfByte = Base64.decode(paramString, 0);
      }
    }
    try
    {
      paramd.aH(arrayOfByte);
      paramd.tMo = new bvm();
      paramd.tMo.kOK = parama.appId;
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
          y.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", paramd, "", new Object[0]);
        }
      }
      parama.bYN = paramString;
      paramStringBuilder.append("<statextstr>" + bk.ZP(parama.bYN) + "</statextstr>");
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.AppContentStatExtStrPiece", localException, "", new Object[0]);
      }
    }
  }
  
  public final void a(Map<String, String> paramMap, g.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ae.f
 * JD-Core Version:    0.7.0.1
 */