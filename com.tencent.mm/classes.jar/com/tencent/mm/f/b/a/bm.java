package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class bm
  extends a
{
  private String gdR;
  private String gdS;
  private String gdT;
  private long gdU;
  private long gdV;
  private long gdW;
  private String gmW;
  private String gmX;
  private String gmY;
  private String gmZ;
  private String gna;
  private String gnb;
  private String gnc;
  private String gnd;
  private String gne;
  private String gnf;
  private String gng;
  private String gnh;
  private String gni;
  
  public bm()
  {
    this.gdR = "";
    this.gdS = "";
    this.gdT = "";
    this.gmW = "";
    this.gmX = "";
    this.gmY = "";
    this.gmZ = "";
    this.gna = "";
    this.gnb = "";
    this.gnc = "";
    this.gnd = "";
    this.gne = "";
    this.gnf = "";
    this.gng = "";
    this.gnh = "";
    this.gni = "";
  }
  
  public bm(String paramString)
  {
    AppMethodBeat.i(239945);
    this.gdR = "";
    this.gdS = "";
    this.gdT = "";
    this.gmW = "";
    this.gmX = "";
    this.gmY = "";
    this.gmZ = "";
    this.gna = "";
    this.gnb = "";
    this.gnc = "";
    this.gnd = "";
    this.gne = "";
    this.gnf = "";
    this.gng = "";
    this.gnh = "";
    this.gni = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 19) {
          break label429;
        }
        String[] arrayOfString = new String[19];
        Arrays.fill(arrayOfString, 0, 19, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label429:
    for (;;)
    {
      this.gdR = z("lastSessionId", paramString[0], true);
      this.gdS = z("currSessionId", paramString[1], true);
      this.gdT = z("nextSessionId", paramString[2], true);
      this.gdU = Util.getLong(paramString[3], 0L);
      this.gdV = Util.getLong(paramString[4], 0L);
      this.gdW = Util.getLong(paramString[5], 0L);
      this.gmW = z("Sns", paramString[6], true);
      this.gmX = z("SeePeopleNearBy", paramString[7], true);
      this.gmY = z("Shake", paramString[8], true);
      this.gmZ = z("Scan", paramString[9], true);
      this.gna = z("Game", paramString[10], true);
      this.gnb = z("JDStore", paramString[11], true);
      this.gnc = z("AppBrand", paramString[12], true);
      this.gnd = z("WCO", paramString[13], true);
      this.gne = z("Browse", paramString[14], true);
      this.gnf = z("Search", paramString[15], true);
      this.gng = z("Nearby", paramString[16], true);
      this.gnh = z("Finder", paramString[17], true);
      this.gni = z("FinderLive", paramString[18], true);
      AppMethodBeat.o(239945);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(239951);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gna);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gne);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gng);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gni);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(239951);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(239955);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastSessionId:").append(this.gdR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionId:").append(this.gdS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nextSessionId:").append(this.gdT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionEnterMs:").append(this.gdU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionQuitMs:").append(this.gdV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionStayTime:").append(this.gdW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sns:").append(this.gmW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeePeopleNearBy:").append(this.gmX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Shake:").append(this.gmY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scan:").append(this.gmZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Game:").append(this.gna);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JDStore:").append(this.gnb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppBrand:").append(this.gnc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WCO:").append(this.gnd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Browse:").append(this.gne);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Search:").append(this.gnf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Nearby:").append(this.gng);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Finder:").append(this.gnh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderLive:").append(this.gni);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(239955);
    return localObject;
  }
  
  public final int getId()
  {
    return 22376;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bm
 * JD-Core Version:    0.7.0.1
 */