package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dn
  extends a
{
  private long dFO = 0L;
  private long dJw = 0L;
  private long dSY = 0L;
  private long dTA = 0L;
  private long dTB = 0L;
  private String dTk = "";
  private long dTn = 0L;
  private long dTo = 0L;
  private long dTu = 0L;
  private long dTv = 0L;
  private long dTw = 0L;
  private long dTx = 2L;
  private long dTy = 0L;
  private long dUN = 0L;
  private long dUO = 0L;
  private long dUP = 0L;
  private long dUQ = 0L;
  private long dUR = 0L;
  private long dUS = 0L;
  private String dUT = "";
  
  public final String PV()
  {
    AppMethodBeat.i(74986);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTB);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(74986);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(74987);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishObjectId:").append(this.dTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.dSY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QuitTime:").append(this.dUN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasRecordVideo:").append(this.dUO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterAllbum:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EmojiWidgetCount:").append(this.dTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TextWidgetCount:").append(this.dTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddMusic:").append(this.dUQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAddPosition:").append(this.dUR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTrace:").append(this.dUS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewActionTrace:").append(this.dUT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoObjectId:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsClickSearchMusic:").append(this.dTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPublicTimeLine:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishVideoType:").append(this.dTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PhotoCount:").append(this.dTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsAddTextIntro:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddTextIntroWordCount:").append(this.dTB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(74987);
    return localObject;
  }
  
  public final dn Rh()
  {
    this.dUO = 1L;
    return this;
  }
  
  public final dn Ri()
  {
    this.dUP = 1L;
    return this;
  }
  
  public final dn Rj()
  {
    this.dUR = 1L;
    return this;
  }
  
  public final dn Rk()
  {
    this.dTv = 1L;
    return this;
  }
  
  public final dn Rl()
  {
    this.dTA = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 16639;
  }
  
  public final dn gp(long paramLong)
  {
    this.dFO = paramLong;
    return this;
  }
  
  public final dn gq(long paramLong)
  {
    this.dSY = paramLong;
    return this;
  }
  
  public final dn gr(long paramLong)
  {
    this.dJw = paramLong;
    return this;
  }
  
  public final dn gs(long paramLong)
  {
    this.dUN = paramLong;
    return this;
  }
  
  public final dn gt(long paramLong)
  {
    this.dTn = paramLong;
    return this;
  }
  
  public final dn gu(long paramLong)
  {
    this.dTo = paramLong;
    return this;
  }
  
  public final dn gv(long paramLong)
  {
    this.dUQ = paramLong;
    return this;
  }
  
  public final dn gw(long paramLong)
  {
    this.dTu = paramLong;
    return this;
  }
  
  public final dn gx(long paramLong)
  {
    this.dTw = paramLong;
    return this;
  }
  
  public final dn gy(long paramLong)
  {
    this.dTx = paramLong;
    return this;
  }
  
  public final dn gz(long paramLong)
  {
    this.dTy = paramLong;
    return this;
  }
  
  public final dn jO(String paramString)
  {
    AppMethodBeat.i(74984);
    this.dTk = t("PublishObjectId", paramString, true);
    AppMethodBeat.o(74984);
    return this;
  }
  
  public final dn jP(String paramString)
  {
    AppMethodBeat.i(74985);
    this.dUT = t("NewActionTrace", paramString, true);
    AppMethodBeat.o(74985);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dn
 * JD-Core Version:    0.7.0.1
 */