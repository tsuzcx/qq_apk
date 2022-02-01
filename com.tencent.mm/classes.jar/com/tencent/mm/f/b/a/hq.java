package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hq
  extends a
{
  private long gGI;
  private String gGJ = "";
  private long gGK;
  private long gGL;
  private String ggA = "";
  private String ggB = "";
  private long ggN;
  private String gjk = "";
  private String gqo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209426);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209426);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209427);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OpType:").append(this.ggN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpScene:").append(this.gGI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniSessionId:").append(this.gGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskOrder:").append(this.gGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.gqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ifPictureInPicture:").append(this.gGL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209427);
    return localObject;
  }
  
  public final hq alL()
  {
    this.gGI = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21155;
  }
  
  public final hq rU(long paramLong)
  {
    this.ggN = paramLong;
    return this;
  }
  
  public final hq rV(long paramLong)
  {
    this.gGK = paramLong;
    return this;
  }
  
  public final hq rW(long paramLong)
  {
    this.gGL = paramLong;
    return this;
  }
  
  public final hq wM(String paramString)
  {
    AppMethodBeat.i(209417);
    this.gGJ = z("MiniSessionId", paramString, true);
    AppMethodBeat.o(209417);
    return this;
  }
  
  public final hq wN(String paramString)
  {
    AppMethodBeat.i(209421);
    this.gqo = z("LongVideoId", paramString, true);
    AppMethodBeat.o(209421);
    return this;
  }
  
  public final hq wO(String paramString)
  {
    AppMethodBeat.i(209422);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209422);
    return this;
  }
  
  public final hq wP(String paramString)
  {
    AppMethodBeat.i(209424);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(209424);
    return this;
  }
  
  public final hq wQ(String paramString)
  {
    AppMethodBeat.i(209425);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209425);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hq
 * JD-Core Version:    0.7.0.1
 */