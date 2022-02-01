package com.tencent.mm.ag;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;

public class g
  extends f
{
  public String iwl;
  public String iwm;
  public String iwn;
  public String iwo;
  public String iwp;
  public String iwq;
  public String iwr;
  public String iws;
  public String iwt;
  public String iwu;
  public String iwv;
  public String iww;
  public boolean iwx;
  public int iwy;
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2) {}
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(169181);
    paramb = Util.nullAsNil((String)paramMap.get(".msg.appmsg.wcpayinfo.coverinfo"));
    paramMap = new dlr();
    try
    {
      if (!Util.isNullOrNil(paramb)) {
        paramMap.parseFrom(Base64.decode(paramb, 0));
      }
      this.iwl = paramMap.iwl;
      this.iwm = paramMap.iwm;
      this.iwn = paramMap.iwn;
      this.iwo = paramMap.iwo;
      this.iwp = paramMap.iwp;
      this.iwq = paramMap.iwq;
      this.iwr = paramMap.iwr;
      this.iws = paramMap.iws;
      this.iwt = paramMap.iwt;
      this.iwu = paramMap.iwu;
      this.iwv = paramMap.iwv;
      this.iww = paramMap.iww;
      this.iwx = paramMap.iwx;
      this.iwy = paramMap.iwy;
      AppMethodBeat.o(169181);
      return;
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AppContentRedPacketCoverInfoPiece", paramb, "", new Object[0]);
      }
    }
  }
  
  public final f aHj()
  {
    AppMethodBeat.i(169180);
    g localg = new g();
    AppMethodBeat.o(169180);
    return localg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.g
 * JD-Core Version:    0.7.0.1
 */