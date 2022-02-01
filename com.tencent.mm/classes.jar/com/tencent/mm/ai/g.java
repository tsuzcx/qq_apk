package com.tencent.mm.ai;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Map;

public class g
  extends f
{
  public String hzA;
  public String hzB;
  public String hzC;
  public boolean hzD;
  public int hzE;
  public String hzr;
  public String hzs;
  public String hzt;
  public String hzu;
  public String hzv;
  public String hzw;
  public String hzx;
  public String hzy;
  public String hzz;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = bt.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new csh();
    try
    {
      if (!bt.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.hzr = paramMap.hzr;
      this.hzs = paramMap.hzs;
      this.hzt = paramMap.hzt;
      this.hzu = paramMap.hzu;
      this.hzv = paramMap.hzv;
      this.hzw = paramMap.hzw;
      this.hzx = paramMap.hzx;
      this.hzy = paramMap.hzy;
      this.hzz = paramMap.hzz;
      this.hzA = paramMap.hzA;
      this.hzB = paramMap.hzB;
      this.hzC = paramMap.hzC;
      this.hzD = paramMap.hzD;
      this.hzE = paramMap.hzE;
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f aot()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ai.g
 * JD-Core Version:    0.7.0.1
 */