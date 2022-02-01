package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class cm
  extends a
{
  private String els;
  private String elt;
  private long enl;
  private String eoo;
  private String euI;
  private String evX;
  private long evt;
  private String ewb;
  private long ewc;
  private String ewd;
  private String ewe;
  private long ewf;
  private String ewg;
  private long ewh;
  private long ewi;
  private long ewj;
  private long ewk;
  private long ewl;
  private long ewm;
  private String ewn;
  private String ewo;
  
  public cm()
  {
    this.els = "";
    this.elt = "";
    this.evX = "";
    this.ewe = "";
    this.ewb = "";
    this.ewd = "";
    this.ewg = "";
    this.euI = "";
    this.eoo = "";
    this.ewn = "";
    this.ewo = "";
  }
  
  public cm(String paramString)
  {
    AppMethodBeat.i(209031);
    this.els = "";
    this.elt = "";
    this.evX = "";
    this.ewe = "";
    this.ewb = "";
    this.ewd = "";
    this.ewg = "";
    this.euI = "";
    this.eoo = "";
    this.ewn = "";
    this.ewo = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 21) {
          break label342;
        }
        String[] arrayOfString = new String[21];
        Arrays.fill(arrayOfString, 0, 21, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label342:
    for (;;)
    {
      mm(paramString[0]);
      mn(paramString[1]);
      mo(paramString[2]);
      mp(paramString[3]);
      this.enl = Util.getLong(paramString[4], 0L);
      mq(paramString[5]);
      this.ewf = Util.getLong(paramString[6], 0L);
      this.ewc = Util.getLong(paramString[7], 0L);
      mr(paramString[8]);
      ms(paramString[9]);
      this.ewh = Util.getLong(paramString[10], 0L);
      this.ewi = Util.getLong(paramString[11], 0L);
      this.ewj = Util.getLong(paramString[12], 0L);
      mt(paramString[13]);
      this.evt = Util.getLong(paramString[14], 0L);
      this.ewk = Util.getLong(paramString[15], 0L);
      this.ewl = Util.getLong(paramString[16], 0L);
      this.ewm = Util.getLong(paramString[17], 0L);
      mu(paramString[18]);
      mv(paramString[19]);
      mw(paramString[20]);
      AppMethodBeat.o(209031);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(209043);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209043);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209044);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.evX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.ewe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.ewb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIndex:").append(this.ewf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.ewc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.ewd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStatus:").append(this.ewg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardExposeTime:").append(this.ewh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStartExposeTime:").append(this.ewi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardEndExposeTime:").append(this.ewj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.euI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.evt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedExposeTime:").append(this.ewk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedStartExposeTime:").append(this.ewl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedEndExposeTime:").append(this.ewm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.eoo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lat:").append(this.ewn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lng:").append(this.ewo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209044);
    return localObject;
  }
  
  public final cm adi()
  {
    this.enl = 1L;
    return this;
  }
  
  public final cm gA(long paramLong)
  {
    this.ewf = paramLong;
    return this;
  }
  
  public final cm gB(long paramLong)
  {
    this.ewc = paramLong;
    return this;
  }
  
  public final cm gC(long paramLong)
  {
    this.ewh = paramLong;
    return this;
  }
  
  public final cm gD(long paramLong)
  {
    this.ewi = paramLong;
    return this;
  }
  
  public final cm gE(long paramLong)
  {
    this.ewj = paramLong;
    return this;
  }
  
  public final cm gF(long paramLong)
  {
    this.evt = paramLong;
    return this;
  }
  
  public final cm gG(long paramLong)
  {
    this.ewk = paramLong;
    return this;
  }
  
  public final cm gH(long paramLong)
  {
    this.ewl = paramLong;
    return this;
  }
  
  public final cm gI(long paramLong)
  {
    this.ewm = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21567;
  }
  
  public final cm mm(String paramString)
  {
    AppMethodBeat.i(209032);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209032);
    return this;
  }
  
  public final cm mn(String paramString)
  {
    AppMethodBeat.i(209033);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(209033);
    return this;
  }
  
  public final cm mo(String paramString)
  {
    AppMethodBeat.i(209034);
    this.evX = x("clickTabContextId", paramString, true);
    AppMethodBeat.o(209034);
    return this;
  }
  
  public final cm mp(String paramString)
  {
    AppMethodBeat.i(209035);
    this.ewe = x("refreshTime", paramString, true);
    AppMethodBeat.o(209035);
    return this;
  }
  
  public final cm mq(String paramString)
  {
    AppMethodBeat.i(209036);
    this.ewb = x("cardid", paramString, true);
    AppMethodBeat.o(209036);
    return this;
  }
  
  public final cm mr(String paramString)
  {
    AppMethodBeat.i(209037);
    this.ewd = x("cardTag", paramString, true);
    AppMethodBeat.o(209037);
    return this;
  }
  
  public final cm ms(String paramString)
  {
    AppMethodBeat.i(209038);
    this.ewg = x("cardStatus", paramString, true);
    AppMethodBeat.o(209038);
    return this;
  }
  
  public final cm mt(String paramString)
  {
    AppMethodBeat.i(209039);
    this.euI = x("feedid", paramString, true);
    AppMethodBeat.o(209039);
    return this;
  }
  
  public final cm mu(String paramString)
  {
    AppMethodBeat.i(209040);
    this.eoo = x("SessionBuffer", paramString, true);
    AppMethodBeat.o(209040);
    return this;
  }
  
  public final cm mv(String paramString)
  {
    AppMethodBeat.i(209041);
    this.ewn = x("lat", paramString, true);
    AppMethodBeat.o(209041);
    return this;
  }
  
  public final cm mw(String paramString)
  {
    AppMethodBeat.i(209042);
    this.ewo = x("lng", paramString, true);
    AppMethodBeat.o(209042);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cm
 * JD-Core Version:    0.7.0.1
 */