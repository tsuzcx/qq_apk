package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class fz
  extends a
{
  public long dKe;
  public long dON;
  public long dYT;
  private String dYa;
  private String eag;
  public long eai;
  private long ebp;
  private long ebq;
  private long ebr;
  private String ecf;
  public a efc;
  public b efd;
  private long efe;
  private long eff;
  
  public fz()
  {
    this.dYa = "";
    this.eag = "";
    this.dYT = 0L;
    this.eai = 0L;
    this.ebp = 0L;
    this.dKe = 0L;
    this.ebq = 0L;
    this.ebr = 0L;
    this.dON = 0L;
    this.efe = 0L;
  }
  
  public fz(String paramString)
  {
    AppMethodBeat.i(43676);
    this.dYa = "";
    this.eag = "";
    this.dYT = 0L;
    this.eai = 0L;
    this.ebp = 0L;
    this.dKe = 0L;
    this.ebq = 0L;
    this.ebr = 0L;
    this.dON = 0L;
    this.efe = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label277;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label277:
    for (;;)
    {
      lJ(paramString[0]);
      lK(paramString[1]);
      this.dYT = bt.getLong(paramString[2], 0L);
      this.efc = a.jf(bt.getInt(paramString[3], 0));
      this.eai = bt.getLong(paramString[4], 0L);
      jr(bt.getLong(paramString[5], 0L));
      this.dKe = bt.getLong(paramString[6], 0L);
      jt(bt.getLong(paramString[7], 0L));
      ju(bt.getLong(paramString[8], 0L));
      this.efd = b.jg(bt.getInt(paramString[9], 0));
      this.dON = bt.getLong(paramString[10], 0L);
      lL(paramString[11]);
      this.efe = bt.getLong(paramString[12], 0L);
      this.eff = bt.getLong(paramString[13], 0L);
      AppMethodBeat.o(43676);
      return;
    }
  }
  
  public final String PV()
  {
    int j = -1;
    AppMethodBeat.i(43683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYT);
    ((StringBuffer)localObject).append(",");
    if (this.efc != null) {}
    for (int i = this.efc.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eai);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebp);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dKe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebq);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ebr);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.efd != null) {
        i = this.efd.value;
      }
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.dON);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.ecf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.efe);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.eff);
      localObject = ((StringBuffer)localObject).toString();
      ams((String)localObject);
      AppMethodBeat.o(43683);
      return localObject;
    }
  }
  
  public final String PW()
  {
    AppMethodBeat.i(43684);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.dYT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.efc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTimeMs:").append(this.ebp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStampMs:").append(this.ebq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStampMs:").append(this.ebr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ret:").append(this.efd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetworkType:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isParallel:").append(this.efe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isUesd:").append(this.eff);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43684);
    return localObject;
  }
  
  public final long RR()
  {
    return this.ebq;
  }
  
  public final long RS()
  {
    return this.ebr;
  }
  
  public final fz Sg()
  {
    this.efe = 1L;
    return this;
  }
  
  public final fz a(a parama)
  {
    this.efc = parama;
    return this;
  }
  
  public final fz a(b paramb)
  {
    this.efd = paramb;
    return this;
  }
  
  public final String getAppId()
  {
    return this.eag;
  }
  
  public final int getId()
  {
    return 15798;
  }
  
  public final fz jp(long paramLong)
  {
    this.dYT = paramLong;
    return this;
  }
  
  public final fz jq(long paramLong)
  {
    this.eai = paramLong;
    return this;
  }
  
  public final fz jr(long paramLong)
  {
    AppMethodBeat.i(43679);
    this.ebp = paramLong;
    super.ba("CostTimeMs", this.ebp);
    AppMethodBeat.o(43679);
    return this;
  }
  
  public final fz js(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final fz jt(long paramLong)
  {
    AppMethodBeat.i(43680);
    this.ebq = paramLong;
    super.bb("StartTimeStampMs", this.ebq);
    AppMethodBeat.o(43680);
    return this;
  }
  
  public final fz ju(long paramLong)
  {
    AppMethodBeat.i(43681);
    this.ebr = paramLong;
    super.bb("EndTimeStampMs", this.ebr);
    AppMethodBeat.o(43681);
    return this;
  }
  
  public final fz jv(long paramLong)
  {
    this.dON = paramLong;
    return this;
  }
  
  public final fz jw(long paramLong)
  {
    this.eff = paramLong;
    return this;
  }
  
  public final fz lJ(String paramString)
  {
    AppMethodBeat.i(43677);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(43677);
    return this;
  }
  
  public final fz lK(String paramString)
  {
    AppMethodBeat.i(43678);
    this.eag = t("AppId", paramString, true);
    AppMethodBeat.o(43678);
    return this;
  }
  
  public final fz lL(String paramString)
  {
    AppMethodBeat.i(43682);
    this.ecf = t("username", paramString, true);
    AppMethodBeat.o(43682);
    return this;
  }
  
  public static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43672);
      efg = new a("release", 0, 1);
      efh = new a("debug", 1, 2);
      efi = new a("demo", 2, 3);
      efj = new a[] { efg, efh, efi };
      AppMethodBeat.o(43672);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static a jf(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 1: 
        return efg;
      case 2: 
        return efh;
      }
      return efi;
    }
  }
  
  public static enum b
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(43675);
      efk = new b("ok", 0, 0);
      efl = new b("common_fail", 1, 1);
      efm = new b[] { efk, efl };
      AppMethodBeat.o(43675);
    }
    
    private b(int paramInt)
    {
      this.value = paramInt;
    }
    
    public static b jg(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 0: 
        return efk;
      }
      return efl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fz
 * JD-Core Version:    0.7.0.1
 */