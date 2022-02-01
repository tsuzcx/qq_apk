package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mk
  extends a
{
  private String eJx = "";
  private String eWb = "";
  private long eXc = 0L;
  private long eYW = 0L;
  private String ekG = "";
  private String eoK = "";
  private long erW = 0L;
  private String exq = "";
  private long fac = 0L;
  private long fad = 0L;
  private long fae = 0L;
  private long fbM;
  private String fbm = "";
  private a fcb;
  private long fcc = 0L;
  private long fcd = 0L;
  private String fce = "";
  private String fcf = "";
  private String fcg = "";
  private int fch;
  private long fci;
  private long fcj;
  private String fck = "";
  
  public final mk a(a parama)
  {
    this.fcb = parama;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(43609);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eXc);
    ((StringBuffer)localObject).append(",");
    if (this.fcb != null) {}
    for (int i = this.fcb.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eYW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fac);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.erW);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fad);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fae);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.exq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eoK);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fce);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbM);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fbm);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcg);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fch);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fci);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fcj);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.fck);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ekG);
      localObject = ((StringBuffer)localObject).toString();
      aMq((String)localObject);
      AppMethodBeat.o(43609);
      return localObject;
    }
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43610);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eWb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eJx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.eXc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.fcb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.fac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.fad);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.fae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLaunch:").append(this.fcc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadingType:").append(this.fcd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene_data:").append(this.fce);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("runningState:").append(this.fbM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.fbm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_referrer:").append(this.fcf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reload_reason:").append(this.fcg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("user_type:").append(this.fch);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("launchMode:").append(this.fci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("coldStartMode:").append(this.fcj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shortLink:").append(this.fck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43610);
    return localObject;
  }
  
  public final String aiv()
  {
    return this.eWb;
  }
  
  public final int getId()
  {
    return 16367;
  }
  
  public final String getSessionId()
  {
    return this.ekG;
  }
  
  public final mk mv(int paramInt)
  {
    this.fch = paramInt;
    return this;
  }
  
  public final mk we(long paramLong)
  {
    this.eXc = paramLong;
    return this;
  }
  
  public final mk wf(long paramLong)
  {
    this.eYW = paramLong;
    return this;
  }
  
  public final mk wg(long paramLong)
  {
    this.erW = paramLong;
    return this;
  }
  
  public final mk wh(long paramLong)
  {
    AppMethodBeat.i(43606);
    this.fad = paramLong;
    super.bj("StartTimeStampMs", this.fad);
    AppMethodBeat.o(43606);
    return this;
  }
  
  public final mk wi(long paramLong)
  {
    this.fcc = paramLong;
    return this;
  }
  
  public final mk wj(long paramLong)
  {
    this.fcd = paramLong;
    return this;
  }
  
  public final mk wk(long paramLong)
  {
    this.fbM = paramLong;
    return this;
  }
  
  public final mk wl(long paramLong)
  {
    this.fci = paramLong;
    return this;
  }
  
  public final mk wm(long paramLong)
  {
    this.fcj = paramLong;
    return this;
  }
  
  public final mk zB(String paramString)
  {
    AppMethodBeat.i(43604);
    this.eWb = x("InstanceId", paramString, true);
    AppMethodBeat.o(43604);
    return this;
  }
  
  public final mk zC(String paramString)
  {
    AppMethodBeat.i(43605);
    this.eJx = x("AppId", paramString, true);
    AppMethodBeat.o(43605);
    return this;
  }
  
  public final mk zD(String paramString)
  {
    AppMethodBeat.i(226082);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(226082);
    return this;
  }
  
  public final mk zE(String paramString)
  {
    AppMethodBeat.i(43608);
    this.eoK = x("UserName", paramString, true);
    AppMethodBeat.o(43608);
    return this;
  }
  
  public final mk zF(String paramString)
  {
    AppMethodBeat.i(226083);
    this.fbm = x("path", paramString, true);
    AppMethodBeat.o(226083);
    return this;
  }
  
  public final mk zG(String paramString)
  {
    AppMethodBeat.i(226084);
    this.fcf = x("reload_referrer", paramString, true);
    AppMethodBeat.o(226084);
    return this;
  }
  
  public final mk zH(String paramString)
  {
    AppMethodBeat.i(226085);
    this.fcg = x("reload_reason", paramString, true);
    AppMethodBeat.o(226085);
    return this;
  }
  
  public final mk zI(String paramString)
  {
    AppMethodBeat.i(226086);
    this.fck = x("shortLink", paramString, true);
    AppMethodBeat.o(226086);
    return this;
  }
  
  public final mk zJ(String paramString)
  {
    AppMethodBeat.i(226087);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(226087);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43603);
      fcl = new a("release", 0, 1);
      fcm = new a("debug", 1, 2);
      fcn = new a("demo", 2, 3);
      fco = new a[] { fcl, fcm, fcn };
      AppMethodBeat.o(43603);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a mw(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return fcl;
      case 2: 
        return fcm;
      }
      return fcn;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.mk
 * JD-Core Version:    0.7.0.1
 */