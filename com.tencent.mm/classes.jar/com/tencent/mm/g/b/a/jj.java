package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jj
  extends a
{
  private int eRg = 0;
  private int eRh = 0;
  private int eRi = 0;
  private int eRj = 0;
  private String eRk = "";
  private int eRl = 0;
  private int eRm = 0;
  private String eRn = "";
  private long eRo = 0L;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.eRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.eRh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.eRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.eRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.eRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.eRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.eRm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.eRn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.eRo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int ahr()
  {
    return this.eRg;
  }
  
  public final int ahs()
  {
    return this.eRj;
  }
  
  public final int aht()
  {
    return this.eRm;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final jj lG(int paramInt)
  {
    this.eRg = paramInt;
    return this;
  }
  
  public final jj lH(int paramInt)
  {
    this.eRh = paramInt;
    return this;
  }
  
  public final jj lI(int paramInt)
  {
    this.eRi = paramInt;
    return this;
  }
  
  public final jj lJ(int paramInt)
  {
    this.eRj = paramInt;
    return this;
  }
  
  public final jj lK(int paramInt)
  {
    this.eRl = paramInt;
    return this;
  }
  
  public final jj lL(int paramInt)
  {
    this.eRm = paramInt;
    return this;
  }
  
  public final jj sd(long paramLong)
  {
    this.eRo = paramLong;
    return this;
  }
  
  public final jj wN(String paramString)
  {
    AppMethodBeat.i(118490);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final jj wO(String paramString)
  {
    AppMethodBeat.i(118491);
    this.eRk = x("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final jj wP(String paramString)
  {
    AppMethodBeat.i(118492);
    this.eRn = x("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jj
 * JD-Core Version:    0.7.0.1
 */