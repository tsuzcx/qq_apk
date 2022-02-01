package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  private String eiB = "";
  private String err = "";
  private long ers;
  private long ert;
  private long erz;
  private long etK;
  private long etM;
  private long etT;
  private String etU = "";
  private long etV;
  private String etW = "";
  private long etX;
  
  public final String abV()
  {
    AppMethodBeat.i(184158);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ers);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ert);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184158);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184159);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickAvatarScene:").append(this.etT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderUsername:").append(this.etU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderRole:").append(this.etV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.etW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.etK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedLikeCount:").append(this.ers);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedCommentCount:").append(this.ert);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedScene:").append(this.etM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewAvatarClickScene:").append(this.etX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.erz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184159);
    return localObject;
  }
  
  public final bv eI(long paramLong)
  {
    this.etV = paramLong;
    return this;
  }
  
  public final bv eJ(long paramLong)
  {
    this.etK = paramLong;
    return this;
  }
  
  public final bv eK(long paramLong)
  {
    this.ers = paramLong;
    return this;
  }
  
  public final bv eL(long paramLong)
  {
    this.ert = paramLong;
    return this;
  }
  
  public final bv eM(long paramLong)
  {
    this.etM = paramLong;
    return this;
  }
  
  public final bv eN(long paramLong)
  {
    this.etX = paramLong;
    return this;
  }
  
  public final bv eO(long paramLong)
  {
    this.erz = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19405;
  }
  
  public final bv kk(String paramString)
  {
    AppMethodBeat.i(184154);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(184154);
    return this;
  }
  
  public final bv kl(String paramString)
  {
    AppMethodBeat.i(184155);
    this.etU = x("FinderUsername", paramString, true);
    AppMethodBeat.o(184155);
    return this;
  }
  
  public final bv km(String paramString)
  {
    AppMethodBeat.i(184156);
    this.etW = x("Username", paramString, true);
    AppMethodBeat.o(184156);
    return this;
  }
  
  public final bv kn(String paramString)
  {
    AppMethodBeat.i(184157);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(184157);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bv
 * JD-Core Version:    0.7.0.1
 */