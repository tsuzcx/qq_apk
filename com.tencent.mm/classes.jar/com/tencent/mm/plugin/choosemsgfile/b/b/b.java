package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.ca;

public final class b
  extends g
{
  private k.b qnG;
  private String qnH;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, ca paramca)
  {
    super(paramg, paramca);
  }
  
  private k.b cyz()
  {
    AppMethodBeat.i(123259);
    if (this.qnG == null) {
      this.qnG = k.b.HD(this.qnv.field_content);
    }
    k.b localb = this.qnG;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String aWd()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.qnH == null) && (cyz() != null) && (cyz().dCK != null) && (cyz().dCK.length() > 0))
    {
      localObject = com.tencent.mm.plugin.r.a.cgO().bdx(cyz().dCK);
      if (localObject != null) {
        this.qnH = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.qnH != null)
    {
      localObject = this.qnH;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final int cyt()
  {
    AppMethodBeat.i(123262);
    if (cyz() != null)
    {
      int i = cyz().iwI;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileExt()
  {
    AppMethodBeat.i(123260);
    if (cyz() != null)
    {
      String str = cyz().iwJ;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (cyz() != null)
    {
      String str = cyz().title;
      AppMethodBeat.o(123261);
      return str;
    }
    AppMethodBeat.o(123261);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.b
 * JD-Core Version:    0.7.0.1
 */