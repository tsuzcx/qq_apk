package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class dd
  extends a
{
  private String ggA;
  private String ggB;
  private long giq;
  private String gjB;
  private String gjm;
  private long grA;
  private String gse;
  private String gsi;
  private long gsj;
  private String gsk;
  private String gsl;
  private long gsm;
  private String gsn;
  private long gso;
  private long gsp;
  private long gsq;
  private long gsr;
  private long gss;
  private long gst;
  private String gsu;
  private String gsv;
  
  public dd()
  {
    this.ggA = "";
    this.ggB = "";
    this.gse = "";
    this.gsl = "";
    this.gsi = "";
    this.gsk = "";
    this.gsn = "";
    this.gjm = "";
    this.gjB = "";
    this.gsu = "";
    this.gsv = "";
  }
  
  public dd(String paramString)
  {
    AppMethodBeat.i(208359);
    this.ggA = "";
    this.ggB = "";
    this.gse = "";
    this.gsl = "";
    this.gsi = "";
    this.gsk = "";
    this.gsn = "";
    this.gjm = "";
    this.gjB = "";
    this.gsu = "";
    this.gsv = "";
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
      oF(paramString[0]);
      oG(paramString[1]);
      oH(paramString[2]);
      oI(paramString[3]);
      this.giq = Util.getLong(paramString[4], 0L);
      oJ(paramString[5]);
      this.gsm = Util.getLong(paramString[6], 0L);
      this.gsj = Util.getLong(paramString[7], 0L);
      oK(paramString[8]);
      oL(paramString[9]);
      this.gso = Util.getLong(paramString[10], 0L);
      this.gsp = Util.getLong(paramString[11], 0L);
      this.gsq = Util.getLong(paramString[12], 0L);
      oM(paramString[13]);
      this.grA = Util.getLong(paramString[14], 0L);
      this.gsr = Util.getLong(paramString[15], 0L);
      this.gss = Util.getLong(paramString[16], 0L);
      this.gst = Util.getLong(paramString[17], 0L);
      oN(paramString[18]);
      oO(paramString[19]);
      oP(paramString[20]);
      AppMethodBeat.o(208359);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(208384);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gse);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gso);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gss);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gst);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208384);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208385);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.gse);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.gsl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.gsi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIndex:").append(this.gsm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.gsj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.gsk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStatus:").append(this.gsn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardExposeTime:").append(this.gso);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStartExposeTime:").append(this.gsp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardEndExposeTime:").append(this.gsq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.gjm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.grA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedExposeTime:").append(this.gsr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedStartExposeTime:").append(this.gss);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedEndExposeTime:").append(this.gst);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.gjB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lat:").append(this.gsu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lng:").append(this.gsv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208385);
    return localObject;
  }
  
  public final dd ahX()
  {
    this.giq = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21567;
  }
  
  public final dd hA(long paramLong)
  {
    this.gst = paramLong;
    return this;
  }
  
  public final dd hs(long paramLong)
  {
    this.gsm = paramLong;
    return this;
  }
  
  public final dd ht(long paramLong)
  {
    this.gsj = paramLong;
    return this;
  }
  
  public final dd hu(long paramLong)
  {
    this.gso = paramLong;
    return this;
  }
  
  public final dd hv(long paramLong)
  {
    this.gsp = paramLong;
    return this;
  }
  
  public final dd hw(long paramLong)
  {
    this.gsq = paramLong;
    return this;
  }
  
  public final dd hx(long paramLong)
  {
    this.grA = paramLong;
    return this;
  }
  
  public final dd hy(long paramLong)
  {
    this.gsr = paramLong;
    return this;
  }
  
  public final dd hz(long paramLong)
  {
    this.gss = paramLong;
    return this;
  }
  
  public final dd oF(String paramString)
  {
    AppMethodBeat.i(208361);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(208361);
    return this;
  }
  
  public final dd oG(String paramString)
  {
    AppMethodBeat.i(208363);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(208363);
    return this;
  }
  
  public final dd oH(String paramString)
  {
    AppMethodBeat.i(208365);
    this.gse = z("clickTabContextId", paramString, true);
    AppMethodBeat.o(208365);
    return this;
  }
  
  public final dd oI(String paramString)
  {
    AppMethodBeat.i(208367);
    this.gsl = z("refreshTime", paramString, true);
    AppMethodBeat.o(208367);
    return this;
  }
  
  public final dd oJ(String paramString)
  {
    AppMethodBeat.i(208371);
    this.gsi = z("cardid", paramString, true);
    AppMethodBeat.o(208371);
    return this;
  }
  
  public final dd oK(String paramString)
  {
    AppMethodBeat.i(208373);
    this.gsk = z("cardTag", paramString, true);
    AppMethodBeat.o(208373);
    return this;
  }
  
  public final dd oL(String paramString)
  {
    AppMethodBeat.i(208374);
    this.gsn = z("cardStatus", paramString, true);
    AppMethodBeat.o(208374);
    return this;
  }
  
  public final dd oM(String paramString)
  {
    AppMethodBeat.i(208375);
    this.gjm = z("feedid", paramString, true);
    AppMethodBeat.o(208375);
    return this;
  }
  
  public final dd oN(String paramString)
  {
    AppMethodBeat.i(208378);
    this.gjB = z("SessionBuffer", paramString, true);
    AppMethodBeat.o(208378);
    return this;
  }
  
  public final dd oO(String paramString)
  {
    AppMethodBeat.i(208380);
    this.gsu = z("lat", paramString, true);
    AppMethodBeat.o(208380);
    return this;
  }
  
  public final dd oP(String paramString)
  {
    AppMethodBeat.i(208381);
    this.gsv = z("lng", paramString, true);
    AppMethodBeat.o(208381);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dd
 * JD-Core Version:    0.7.0.1
 */