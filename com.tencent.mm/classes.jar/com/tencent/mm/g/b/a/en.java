package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class en
  extends a
{
  private String dXm = "";
  public long egV = 0L;
  public int eij = 0;
  public long eik = 0L;
  public long eil = 0L;
  private String eim = "";
  
  public final String RD()
  {
    AppMethodBeat.i(121773);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eij);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.egV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eik);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eil);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eim);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121773);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121774);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PId:").append(this.eij);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.egV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeq:").append(this.eik);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SubSeqSum:").append(this.eil);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataContent:").append(this.eim);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121774);
    return localObject;
  }
  
  public final int getId()
  {
    return 16976;
  }
  
  public final en nQ(String paramString)
  {
    AppMethodBeat.i(121771);
    this.dXm = t("PName", paramString, true);
    AppMethodBeat.o(121771);
    return this;
  }
  
  public final en nR(String paramString)
  {
    AppMethodBeat.i(121772);
    this.eim = t("DataContent", paramString, false);
    AppMethodBeat.o(121772);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.en
 * JD-Core Version:    0.7.0.1
 */