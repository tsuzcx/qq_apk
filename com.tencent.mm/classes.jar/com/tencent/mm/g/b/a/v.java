package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class v
  extends a
{
  private long ejW;
  private long elA;
  private String elB = "";
  private String elC = "";
  private String elD = "";
  private String els = "";
  private String elt = "";
  private String elu = "";
  private long elv;
  private long elw;
  private String elx = "";
  private long ely;
  private long elz;
  
  public final String abV()
  {
    AppMethodBeat.i(208828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ely);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elD);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208828);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.elu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_uin:").append(this.elv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distance:").append(this.elw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("district:").append(this.elx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_sns:").append(this.ely);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.elz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filterType:").append(this.elA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_username:").append(this.elB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("city:").append(this.elC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("country:").append(this.elD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208829);
    return localObject;
  }
  
  public final v aca()
  {
    this.elv = 0L;
    return this;
  }
  
  public final v bR(long paramLong)
  {
    this.elw = paramLong;
    return this;
  }
  
  public final v bS(long paramLong)
  {
    this.ely = paramLong;
    return this;
  }
  
  public final v bT(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final v bU(long paramLong)
  {
    this.elz = paramLong;
    return this;
  }
  
  public final v bV(long paramLong)
  {
    this.elA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21855;
  }
  
  public final v hU(String paramString)
  {
    AppMethodBeat.i(208821);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(208821);
    return this;
  }
  
  public final v hV(String paramString)
  {
    AppMethodBeat.i(208822);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(208822);
    return this;
  }
  
  public final v hW(String paramString)
  {
    AppMethodBeat.i(208823);
    this.elu = x("clickTabContextid", paramString, true);
    AppMethodBeat.o(208823);
    return this;
  }
  
  public final v hX(String paramString)
  {
    AppMethodBeat.i(208824);
    this.elx = x("district", paramString, true);
    AppMethodBeat.o(208824);
    return this;
  }
  
  public final v hY(String paramString)
  {
    AppMethodBeat.i(208825);
    this.elB = x("nearby_username", paramString, true);
    AppMethodBeat.o(208825);
    return this;
  }
  
  public final v hZ(String paramString)
  {
    AppMethodBeat.i(208826);
    this.elC = x("city", paramString, true);
    AppMethodBeat.o(208826);
    return this;
  }
  
  public final v ia(String paramString)
  {
    AppMethodBeat.i(208827);
    this.elD = x("country", paramString, true);
    AppMethodBeat.o(208827);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */