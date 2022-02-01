package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fb
  extends a
{
  private long dDB = 0L;
  private long dHy = 0L;
  private long dII = 0L;
  private String dUW = "";
  private long dUZ = 0L;
  private long dVa = 0L;
  private long dVg = 0L;
  private long dVh = 0L;
  private long dVi = 0L;
  private long dVj = 2L;
  private long dVk = 0L;
  private long dVm = 0L;
  private long dVn = 0L;
  private long dWA = 0L;
  private long dWB = 0L;
  private long dWC = 0L;
  private long dWD = 0L;
  private long dWE = 0L;
  private String dWF = "";
  private long dWz = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dII);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVn);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.dUW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dII);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dHy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.dWz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.dWA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.dWB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.dUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.dWC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.dWD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.dWE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.dWF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.dVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.dVh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.dVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.dVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.dVk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.dVm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.dVn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final fb RJ()
  {
    this.dWA = 1L;
    return this;
  }
  
  public final fb RK()
  {
    this.dWB = 1L;
    return this;
  }
  
  public final fb RL()
  {
    this.dWD = 1L;
    return this;
  }
  
  public final fb RM()
  {
    this.dVh = 1L;
    return this;
  }
  
  public final fb RN()
  {
    this.dVm = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final fb jC(long paramLong)
  {
    this.dDB = paramLong;
    return this;
  }
  
  public final fb jD(long paramLong)
  {
    this.dII = paramLong;
    return this;
  }
  
  public final fb jE(long paramLong)
  {
    this.dHy = paramLong;
    return this;
  }
  
  public final fb jF(long paramLong)
  {
    this.dWz = paramLong;
    return this;
  }
  
  public final fb jG(long paramLong)
  {
    this.dUZ = paramLong;
    return this;
  }
  
  public final fb jH(long paramLong)
  {
    this.dVa = paramLong;
    return this;
  }
  
  public final fb jI(long paramLong)
  {
    this.dWC = paramLong;
    return this;
  }
  
  public final fb jJ(long paramLong)
  {
    this.dVg = paramLong;
    return this;
  }
  
  public final fb jK(long paramLong)
  {
    this.dVi = paramLong;
    return this;
  }
  
  public final fb jL(long paramLong)
  {
    this.dVj = paramLong;
    return this;
  }
  
  public final fb jM(long paramLong)
  {
    this.dVk = paramLong;
    return this;
  }
  
  public final fb mE(String paramString)
  {
    AppMethodBeat.i(74984);
    this.dUW = t("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final fb mF(String paramString)
  {
    AppMethodBeat.i(74985);
    this.dWF = t("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fb
 * JD-Core Version:    0.7.0.1
 */