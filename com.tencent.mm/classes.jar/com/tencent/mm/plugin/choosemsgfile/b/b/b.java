package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.bo;

public final class b
  extends g
{
  private k.b ooK;
  private String ooL;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bo parambo)
  {
    super(paramg, parambo);
  }
  
  private k.b bUP()
  {
    AppMethodBeat.i(123259);
    if (this.ooK == null) {
      this.ooK = k.b.vA(this.ooz.field_content);
    }
    k.b localb = this.ooK;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String azl()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.ooL == null) && (bUP() != null) && (bUP().cZa != null) && (bUP().cZa.length() > 0))
    {
      localObject = com.tencent.mm.plugin.s.a.bEO().aGd(bUP().cZa);
      if (localObject != null) {
        this.ooL = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.ooL != null)
    {
      localObject = this.ooL;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final String bUI()
  {
    AppMethodBeat.i(123260);
    if (bUP() != null)
    {
      String str = bUP().hhG;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final int bUJ()
  {
    AppMethodBeat.i(123262);
    if (bUP() != null)
    {
      int i = bUP().hhF;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (bUP() != null)
    {
      String str = bUP().title;
      AppMethodBeat.o(123261);
      return str;
    }
    AppMethodBeat.o(123261);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.b.b
 * JD-Core Version:    0.7.0.1
 */