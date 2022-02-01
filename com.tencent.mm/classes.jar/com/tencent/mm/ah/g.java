package com.tencent.mm.ah;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Map;

public class g
  extends f
{
  public String hCf;
  public String hCg;
  public String hCh;
  public String hCi;
  public String hCj;
  public String hCk;
  public String hCl;
  public String hCm;
  public String hCn;
  public String hCo;
  public String hCp;
  public String hCq;
  public boolean hCr;
  public int hCs;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = bu.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new ctb();
    try
    {
      if (!bu.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.hCf = paramMap.hCf;
      this.hCg = paramMap.hCg;
      this.hCh = paramMap.hCh;
      this.hCi = paramMap.hCi;
      this.hCj = paramMap.hCj;
      this.hCk = paramMap.hCk;
      this.hCl = paramMap.hCl;
      this.hCm = paramMap.hCm;
      this.hCn = paramMap.hCn;
      this.hCo = paramMap.hCo;
      this.hCp = paramMap.hCp;
      this.hCq = paramMap.hCq;
      this.hCr = paramMap.hCr;
      this.hCs = paramMap.hCs;
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f aoI()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.g
 * JD-Core Version:    0.7.0.1
 */