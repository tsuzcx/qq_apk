package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class cj
  extends a
{
  public String ijk;
  private String ikl;
  private String ikm;
  private String ikn;
  private long iko;
  private long ikp;
  private long ikq;
  public String iwA;
  public String iwB;
  public String iwC;
  private String iwg;
  private String iwh;
  private String iwi;
  private String iwj;
  private String iwk;
  private String iwl;
  private String iwm;
  private String iwn;
  private String iwo;
  private String iwp;
  private String iwq;
  public String iwr;
  public String iws;
  private String iwt;
  private String iwu;
  private String iwv;
  private String iww;
  private String iwx;
  private String iwy;
  public String iwz;
  
  public cj()
  {
    this.ikl = "";
    this.ikm = "";
    this.ikn = "";
    this.iwg = "";
    this.iwh = "";
    this.iwi = "";
    this.iwj = "";
    this.iwk = "";
    this.iwl = "";
    this.iwm = "";
    this.iwn = "";
    this.iwo = "";
    this.iwp = "";
    this.iwq = "";
    this.iwr = "";
    this.iws = "";
    this.iwt = "";
    this.iwu = "";
    this.iwv = "";
    this.iww = "";
    this.iwx = "";
    this.iwy = "";
    this.ijk = "";
    this.iwz = "";
    this.iwA = "";
    this.iwB = "";
    this.iwC = "";
  }
  
  public cj(String paramString)
  {
    AppMethodBeat.i(368199);
    this.ikl = "";
    this.ikm = "";
    this.ikn = "";
    this.iwg = "";
    this.iwh = "";
    this.iwi = "";
    this.iwj = "";
    this.iwk = "";
    this.iwl = "";
    this.iwm = "";
    this.iwn = "";
    this.iwo = "";
    this.iwp = "";
    this.iwq = "";
    this.iwr = "";
    this.iws = "";
    this.iwt = "";
    this.iwu = "";
    this.iwv = "";
    this.iww = "";
    this.iwx = "";
    this.iwy = "";
    this.ijk = "";
    this.iwz = "";
    this.iwA = "";
    this.iwB = "";
    this.iwC = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 30) {
          break label594;
        }
        String[] arrayOfString = new String[30];
        Arrays.fill(arrayOfString, 0, 30, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label594:
    for (;;)
    {
      this.ikl = F("lastSessionId", paramString[0], true);
      this.ikm = F("currSessionId", paramString[1], true);
      this.ikn = F("nextSessionId", paramString[2], true);
      this.iko = Util.getLong(paramString[3], 0L);
      this.ikp = Util.getLong(paramString[4], 0L);
      this.ikq = Util.getLong(paramString[5], 0L);
      this.iwg = F("Sns", paramString[6], true);
      this.iwh = F("SeePeopleNearBy", paramString[7], true);
      this.iwi = F("Shake", paramString[8], true);
      this.iwj = F("Scan", paramString[9], true);
      this.iwk = F("Game", paramString[10], true);
      this.iwl = F("JDStore", paramString[11], true);
      this.iwm = F("AppBrand", paramString[12], true);
      this.iwn = F("WCO", paramString[13], true);
      this.iwo = F("Browse", paramString[14], true);
      this.iwp = F("Search", paramString[15], true);
      this.iwq = F("Nearby", paramString[16], true);
      this.iwr = F("Finder", paramString[17], true);
      this.iws = F("FinderLive", paramString[18], true);
      lz(paramString[19]);
      lA(paramString[20]);
      lB(paramString[21]);
      lC(paramString[22]);
      lD(paramString[23]);
      lE(paramString[24]);
      lF(paramString[25]);
      lG(paramString[26]);
      lH(paramString[27]);
      lI(paramString[28]);
      lJ(paramString[29]);
      AppMethodBeat.o(368199);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368331);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iws);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iww);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368331);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368348);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("lastSessionId:").append(this.ikl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionId:").append(this.ikm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nextSessionId:").append(this.ikn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionEnterMs:").append(this.iko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionQuitMs:").append(this.ikp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("currSessionStayTime:").append(this.ikq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sns:").append(this.iwg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SeePeopleNearBy:").append(this.iwh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Shake:").append(this.iwi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scan:").append(this.iwj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Game:").append(this.iwk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JDStore:").append(this.iwl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppBrand:").append(this.iwm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WCO:").append(this.iwn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Browse:").append(this.iwo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Search:").append(this.iwp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Nearby:").append(this.iwq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Finder:").append(this.iwr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderLive:").append(this.iws);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Reserved1:").append(this.iwt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Reserved2:").append(this.iwu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Reserved3:").append(this.iwv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FindFriendsTab:").append(this.iww);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderJson:").append(this.iwx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderLiveJson:").append(this.iwy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowFinderEntrance:").append(this.iwz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowFinderRedDot:").append(this.iwA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowFinderLiveEntrance:").append(this.iwB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsShowFinderLiveRedDot:").append(this.iwC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368348);
    return localObject;
  }
  
  public final int getId()
  {
    return 22376;
  }
  
  public final cj lA(String paramString)
  {
    AppMethodBeat.i(368235);
    this.iwu = F("Reserved2", paramString, true);
    AppMethodBeat.o(368235);
    return this;
  }
  
  public final cj lB(String paramString)
  {
    AppMethodBeat.i(368248);
    this.iwv = F("Reserved3", paramString, true);
    AppMethodBeat.o(368248);
    return this;
  }
  
  public final cj lC(String paramString)
  {
    AppMethodBeat.i(368255);
    this.iww = F("FindFriendsTab", paramString, true);
    AppMethodBeat.o(368255);
    return this;
  }
  
  public final cj lD(String paramString)
  {
    AppMethodBeat.i(368265);
    this.iwx = F("FinderJson", paramString, true);
    AppMethodBeat.o(368265);
    return this;
  }
  
  public final cj lE(String paramString)
  {
    AppMethodBeat.i(368272);
    this.iwy = F("FinderLiveJson", paramString, true);
    AppMethodBeat.o(368272);
    return this;
  }
  
  public final cj lF(String paramString)
  {
    AppMethodBeat.i(368278);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(368278);
    return this;
  }
  
  public final cj lG(String paramString)
  {
    AppMethodBeat.i(368286);
    this.iwz = F("IsShowFinderEntrance", paramString, true);
    AppMethodBeat.o(368286);
    return this;
  }
  
  public final cj lH(String paramString)
  {
    AppMethodBeat.i(368293);
    this.iwA = F("IsShowFinderRedDot", paramString, true);
    AppMethodBeat.o(368293);
    return this;
  }
  
  public final cj lI(String paramString)
  {
    AppMethodBeat.i(368302);
    this.iwB = F("IsShowFinderLiveEntrance", paramString, true);
    AppMethodBeat.o(368302);
    return this;
  }
  
  public final cj lJ(String paramString)
  {
    AppMethodBeat.i(368308);
    this.iwC = F("IsShowFinderLiveRedDot", paramString, true);
    AppMethodBeat.o(368308);
    return this;
  }
  
  public final cj lz(String paramString)
  {
    AppMethodBeat.i(368222);
    this.iwt = F("Reserved1", paramString, true);
    AppMethodBeat.o(368222);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.cj
 * JD-Core Version:    0.7.0.1
 */