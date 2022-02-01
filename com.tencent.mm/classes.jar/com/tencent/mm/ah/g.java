package com.tencent.mm.ah;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Map;

public class g
  extends f
{
  public String hhi;
  public String hhj;
  public String hhk;
  public String hhl;
  public String hhm;
  public String hhn;
  public String hho;
  public String hhp;
  public String hhq;
  public String hhr;
  public String hhs;
  public String hht;
  public boolean hhu;
  public int hhv;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = bs.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new cne();
    try
    {
      if (!bs.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.hhi = paramMap.hhi;
      this.hhj = paramMap.hhj;
      this.hhk = paramMap.hhk;
      this.hhl = paramMap.hhl;
      this.hhm = paramMap.hhm;
      this.hhn = paramMap.hhn;
      this.hho = paramMap.hho;
      this.hhp = paramMap.hhp;
      this.hhq = paramMap.hhq;
      this.hhr = paramMap.hhr;
      this.hhs = paramMap.hhs;
      this.hht = paramMap.hht;
      this.hhu = paramMap.hhu;
      this.hhv = paramMap.hhv;
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f alG()
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