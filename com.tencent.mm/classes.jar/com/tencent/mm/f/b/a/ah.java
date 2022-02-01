package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ah
  extends a
{
  public int geN;
  public int ggl;
  public long giA = 0L;
  private int giB;
  private String giC = "";
  private String git = "";
  public int giu;
  private String giv = "";
  private String giw = "";
  public int gix;
  private String giy = "";
  private String giz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(211220);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giC);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(211220);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(211221);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.giu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgId:").append(this.giv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgFromUsername:").append(this.giw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.gix);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatRoomID:").append(this.giy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicMD5:").append(this.giz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampsInMs:").append(this.giA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiRet:").append(this.giB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CgiAction:").append(this.giC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211221);
    return localObject;
  }
  
  public final ah cq(long paramLong)
  {
    this.giA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20511;
  }
  
  public final ah iX(String paramString)
  {
    AppMethodBeat.i(211207);
    this.git = z("RequestId", paramString, true);
    AppMethodBeat.o(211207);
    return this;
  }
  
  public final ah iY(String paramString)
  {
    AppMethodBeat.i(211212);
    this.giv = z("MsgId", paramString, true);
    AppMethodBeat.o(211212);
    return this;
  }
  
  public final ah iZ(String paramString)
  {
    AppMethodBeat.i(211214);
    this.giw = z("MsgFromUsername", paramString, true);
    AppMethodBeat.o(211214);
    return this;
  }
  
  public final ah ja(String paramString)
  {
    AppMethodBeat.i(211217);
    this.giy = z("ChatRoomID", paramString, true);
    AppMethodBeat.o(211217);
    return this;
  }
  
  public final ah jb(String paramString)
  {
    AppMethodBeat.i(211218);
    this.giz = z("PicMD5", paramString, true);
    AppMethodBeat.o(211218);
    return this;
  }
  
  public final ah jc(String paramString)
  {
    AppMethodBeat.i(211219);
    this.giC = z("CgiAction", paramString, true);
    AppMethodBeat.o(211219);
    return this;
  }
  
  public final ah le(int paramInt)
  {
    this.geN = paramInt;
    return this;
  }
  
  public final ah lf(int paramInt)
  {
    this.giu = paramInt;
    return this;
  }
  
  public final ah lg(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final ah lh(int paramInt)
  {
    this.gix = paramInt;
    return this;
  }
  
  public final ah li(int paramInt)
  {
    this.giB = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ah
 * JD-Core Version:    0.7.0.1
 */