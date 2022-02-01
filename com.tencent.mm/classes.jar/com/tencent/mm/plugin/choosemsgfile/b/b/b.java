package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.bu;

public final class b
  extends g
{
  private k.b oSf;
  private String oSg;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bu parambu)
  {
    super(paramg, parambu);
  }
  
  private k.b bZu()
  {
    AppMethodBeat.i(123259);
    if (this.oSf == null) {
      this.oSf = k.b.yr(this.oRU.field_content);
    }
    k.b localb = this.oSf;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String aCp()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.oSg == null) && (bZu() != null) && (bZu().dks != null) && (bZu().dks.length() > 0))
    {
      localObject = com.tencent.mm.plugin.s.a.bIX().aLD(bZu().dks);
      if (localObject != null) {
        this.oSg = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.oSg != null)
    {
      localObject = this.oSg;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final String bZn()
  {
    AppMethodBeat.i(123260);
    if (bZu() != null)
    {
      String str = bZu().hzP;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final int bZo()
  {
    AppMethodBeat.i(123262);
    if (bZu() != null)
    {
      int i = bZu().hzO;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (bZu() != null)
    {
      String str = bZu().title;
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