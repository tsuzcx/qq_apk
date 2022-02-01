package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oe
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
  
  public final oe PB(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final oe PC(long paramLong)
  {
    this.kRP = paramLong;
    return this;
  }
  
  public final oe PD(long paramLong)
  {
    this.kRQ = paramLong;
    return this;
  }
  
  public final oe PE(long paramLong)
  {
    this.kRR = paramLong;
    return this;
  }
  
  public final oe aTq(String paramString)
  {
    AppMethodBeat.i(258755);
    this.eJC = x("SongId", paramString, true);
    AppMethodBeat.o(258755);
    return this;
  }
  
  public final oe aYJ(String paramString)
  {
    AppMethodBeat.i(258756);
    this.eJv = x("WebUrl", paramString, true);
    AppMethodBeat.o(258756);
    return this;
  }
  
  public final oe aYK(String paramString)
  {
    AppMethodBeat.i(258757);
    this.eJw = x("DataUrl", paramString, true);
    AppMethodBeat.o(258757);
    return this;
  }
  
  public final oe aYL(String paramString)
  {
    AppMethodBeat.i(258758);
    this.eJz = x("MvObjectId", paramString, true);
    AppMethodBeat.o(258758);
    return this;
  }
  
  public final oe aZk(String paramString)
  {
    AppMethodBeat.i(258759);
    this.eJA = x("MvNonceId", paramString, true);
    AppMethodBeat.o(258759);
    return this;
  }
  
  public final oe aZl(String paramString)
  {
    AppMethodBeat.i(258760);
    this.huc = x("MvUserId", paramString, true);
    AppMethodBeat.o(258760);
    return this;
  }
  
  public final oe aZm(String paramString)
  {
    AppMethodBeat.i(258761);
    this.etI = x("CommentId", paramString, true);
    AppMethodBeat.o(258761);
    return this;
  }
  
  public final oe aZn(String paramString)
  {
    AppMethodBeat.i(258762);
    this.eJK = x("Singer", paramString, true);
    AppMethodBeat.o(258762);
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258763);
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
    ((StringBuffer)localObject).append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258763);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258764);
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
    ((StringBuffer)localObject).append("Singer:").append(this.eJK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258764);
    return localObject;
  }
  
  public final oe ahU(String paramString)
  {
    AppMethodBeat.i(258753);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(258753);
    return this;
  }
  
  public final oe amE(String paramString)
  {
    AppMethodBeat.i(258754);
    this.eJu = x("SongName", paramString, true);
    AppMethodBeat.o(258754);
    return this;
  }
  
  public final int getId()
  {
    return 22232;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.oe
 * JD-Core Version:    0.7.0.1
 */