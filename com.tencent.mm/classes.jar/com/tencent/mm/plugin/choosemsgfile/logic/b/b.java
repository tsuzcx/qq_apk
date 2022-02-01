package com.tencent.mm.plugin.choosemsgfile.logic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.cc;

public final class b
  extends g
{
  private k.b wPJ;
  private String wPK;
  
  public b(com.tencent.mm.plugin.choosemsgfile.logic.ui.g paramg, cc paramcc)
  {
    super(paramg, paramcc);
  }
  
  private k.b dqz()
  {
    AppMethodBeat.i(123259);
    if (this.wPJ == null) {
      this.wPJ = k.b.Hf(this.wPy.field_content);
    }
    k.b localb = this.wPJ;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String bCX()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.wPK == null) && (dqz() != null) && (dqz().hzM != null) && (dqz().hzM.length() > 0))
    {
      localObject = com.tencent.mm.plugin.openapi.a.cWJ().bpI(dqz().hzM);
      if (localObject != null) {
        this.wPK = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.wPK != null)
    {
      localObject = this.wPK;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final int dqt()
  {
    AppMethodBeat.i(123262);
    if (dqz() != null)
    {
      int i = dqz().nRd;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileExt()
  {
    AppMethodBeat.i(123260);
    if (dqz() != null)
    {
      String str = dqz().nRe;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (dqz() != null)
    {
      String str = dqz().title;
      AppMethodBeat.o(123261);
      return str;
    }
    AppMethodBeat.o(123261);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.b.b
 * JD-Core Version:    0.7.0.1
 */