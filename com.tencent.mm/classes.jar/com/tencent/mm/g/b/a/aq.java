package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private String dTr = "";
  private String dWh = "";
  private long dWi;
  private long dWj;
  private long dWp;
  private long dXW;
  private long dXY;
  private long dXZ;
  private String dYa = "";
  private long dYb;
  private String dYc = "";
  private long dYd;
  
  public final String RC()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.dXZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.dYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.dXW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.dWi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.dWj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.dWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.dXY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.dYd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.dWp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final aq dA(long paramLong)
  {
    this.dWp = paramLong;
    return this;
  }
  
  public final aq du(long paramLong)
  {
    this.dYb = paramLong;
    return this;
  }
  
  public final aq dv(long paramLong)
  {
    this.dXW = paramLong;
    return this;
  }
  
  public final aq dw(long paramLong)
  {
    this.dWi = paramLong;
    return this;
  }
  
  public final aq dx(long paramLong)
  {
    this.dWj = paramLong;
    return this;
  }
  
  public final aq dy(long paramLong)
  {
    this.dXY = paramLong;
    return this;
  }
  
  public final aq dz(long paramLong)
  {
    this.dYd = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
  
  public final aq ic(String paramString)
  {
    AppMethodBeat.i(184154);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final aq ie(String paramString)
  {
    AppMethodBeat.i(184155);
    this.dYa = t("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final aq jdMethod_if(String paramString)
  {
    AppMethodBeat.i(184156);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final aq ig(String paramString)
  {
    AppMethodBeat.i(184157);
    this.dWh = t("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aq
 * JD-Core Version:    0.7.0.1
 */