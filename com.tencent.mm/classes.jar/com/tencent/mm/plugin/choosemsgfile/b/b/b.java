package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.ca;

public final class b
  extends g
{
  private k.b tMt;
  private String tMu;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  private k.b cMU()
  {
    AppMethodBeat.i(123259);
    if (this.tMt == null) {
      this.tMt = k.b.OQ(this.tMi.field_content);
    }
    k.b localb = this.tMt;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String bfg()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.tMu == null) && (cMU() != null) && (cMU().fvr != null) && (cMU().fvr.length() > 0))
    {
      localObject = com.tencent.mm.plugin.ab.a.ctZ().bpR(cMU().fvr);
      if (localObject != null) {
        this.tMu = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.tMu != null)
    {
      localObject = this.tMu;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final int cMO()
  {
    AppMethodBeat.i(123262);
    if (cMU() != null)
    {
      int i = cMU().llX;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileExt()
  {
    AppMethodBeat.i(123260);
    if (cMU() != null)
    {
      String str = cMU().llY;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (cMU() != null)
    {
      String str = cMU().title;
      AppMethodBeat.o(123261);
      return str;
    }
    AppMethodBeat.o(123261);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.b
 * JD-Core Version:    0.7.0.1
 */