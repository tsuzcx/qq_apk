package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private String ekB = "";
  private String ekG = "";
  private int eql;
  private int exm;
  private int exn;
  private long exo;
  private int exp;
  private String exq = "";
  private String exr = "";
  private int exs;
  private int exu;
  private String exv = "";
  private String exw = "";
  private String exx = "";
  private long exy;
  private String exz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209053);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eql);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209053);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209054);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("isFirstOpen:").append(this.exm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.exn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appId:").append(this.ekB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appVersion:").append(this.exo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appType:").append(this.exp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.eql);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.exq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("preWarmPath:").append(this.exr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPresend:").append(this.exs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreload:").append(this.exu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.exv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderId:").append(this.exw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("shopwindowId:").append(this.exx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.ekG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventTime:").append(this.exy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickId:").append(this.exz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209054);
    return localObject;
  }
  
  public final cs aek()
  {
    this.exo = 0L;
    return this;
  }
  
  public final cs ael()
  {
    this.exp = 10;
    return this;
  }
  
  public final int getId()
  {
    return 21188;
  }
  
  public final cs hN(long paramLong)
  {
    this.exy = paramLong;
    return this;
  }
  
  public final cs kf(int paramInt)
  {
    this.exm = paramInt;
    return this;
  }
  
  public final cs kg(int paramInt)
  {
    this.exn = paramInt;
    return this;
  }
  
  public final cs kh(int paramInt)
  {
    this.eql = paramInt;
    return this;
  }
  
  public final cs ki(int paramInt)
  {
    this.exs = paramInt;
    return this;
  }
  
  public final cs kj(int paramInt)
  {
    this.exu = paramInt;
    return this;
  }
  
  public final cs nm(String paramString)
  {
    AppMethodBeat.i(209045);
    this.ekB = x("appId", paramString, true);
    AppMethodBeat.o(209045);
    return this;
  }
  
  public final cs nn(String paramString)
  {
    AppMethodBeat.i(209046);
    this.exq = x("networkType", paramString, true);
    AppMethodBeat.o(209046);
    return this;
  }
  
  public final cs no(String paramString)
  {
    AppMethodBeat.i(209047);
    this.exr = x("preWarmPath", paramString, true);
    AppMethodBeat.o(209047);
    return this;
  }
  
  public final cs np(String paramString)
  {
    AppMethodBeat.i(209048);
    this.exv = x("liveId", paramString, true);
    AppMethodBeat.o(209048);
    return this;
  }
  
  public final cs nq(String paramString)
  {
    AppMethodBeat.i(209049);
    this.exw = x("finderId", paramString, true);
    AppMethodBeat.o(209049);
    return this;
  }
  
  public final cs nr(String paramString)
  {
    AppMethodBeat.i(209050);
    this.exx = x("shopwindowId", paramString, true);
    AppMethodBeat.o(209050);
    return this;
  }
  
  public final cs ns(String paramString)
  {
    AppMethodBeat.i(209051);
    this.ekG = x("sessionId", paramString, true);
    AppMethodBeat.o(209051);
    return this;
  }
  
  public final cs nt(String paramString)
  {
    AppMethodBeat.i(209052);
    this.exz = x("clickId", paramString, true);
    AppMethodBeat.o(209052);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs
 * JD-Core Version:    0.7.0.1
 */