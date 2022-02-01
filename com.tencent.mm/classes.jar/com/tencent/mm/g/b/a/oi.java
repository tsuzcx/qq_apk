package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oi
  extends a
{
  private String eJA = "";
  private String eJC = "";
  private String eJK = "";
  private String eJu = "";
  private String eJv = "";
  private String eJw = "";
  private String eJz = "";
  private long enl;
  private String eoz = "";
  private String etI = "";
  private String huc = "";
  private long kRP;
  private long kRQ;
  private long kRR;
  private String kRS = "";
  private String opX = "";
  
  public final oi Qi(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final oi Qj(long paramLong)
  {
    this.kRP = paramLong;
    return this;
  }
  
  public final oi Qk(long paramLong)
  {
    this.kRQ = paramLong;
    return this;
  }
  
  public final oi Ql(long paramLong)
  {
    this.kRR = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258819);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.huc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.kRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258819);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258820);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongName:").append(this.eJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SongId:").append(this.eJC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WebUrl:").append(this.eJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataUrl:").append(this.eJw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvObjectId:").append(this.eJz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvNonceId:").append(this.eJA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MvUserId:").append(this.huc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicLength:").append(this.kRP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMusicTime:").append(this.kRQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayMvTime:").append(this.kRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentId:").append(this.etI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentMessage:").append(this.kRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentUser:").append(this.opX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Singer:").append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258820);
    return localObject;
  }
  
  public final oi bwg(String paramString)
  {
    AppMethodBeat.i(258809);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(258809);
    return this;
  }
  
  public final oi bwh(String paramString)
  {
    AppMethodBeat.i(258810);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(258810);
    return this;
  }
  
  public final oi bwi(String paramString)
  {
    AppMethodBeat.i(258811);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(258811);
    return this;
  }
  
  public final oi bwj(String paramString)
  {
    AppMethodBeat.i(258812);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(258812);
    return this;
  }
  
  public final oi bwk(String paramString)
  {
    AppMethodBeat.i(258813);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(258813);
    return this;
  }
  
  public final oi bwl(String paramString)
  {
    AppMethodBeat.i(258814);
    this.eJz = x("MvObjectId", paramString, true);
    AppMethodBeat.o(258814);
    return this;
  }
  
  public final oi bwm(String paramString)
  {
    AppMethodBeat.i(258815);
    this.eJA = x("MvNonceId", paramString, true);
    AppMethodBeat.o(258815);
    return this;
  }
  
  public final oi bwn(String paramString)
  {
    AppMethodBeat.i(258816);
    this.huc = x("MvUserId", paramString, true);
    AppMethodBeat.o(258816);
    return this;
  }
  
  public final oi bwo(String paramString)
  {
    AppMethodBeat.i(258817);
    this.etI = x("CommentId", paramString, true);
    AppMethodBeat.o(258817);
    return this;
  }
  
  public final oi bwp(String paramString)
  {
    AppMethodBeat.i(258818);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258818);
    return this;
  }
  
  public final int getId()
  {
    return 22230;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oi
 * JD-Core Version:    0.7.0.1
 */