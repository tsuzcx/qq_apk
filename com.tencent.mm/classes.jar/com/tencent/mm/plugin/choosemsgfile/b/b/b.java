package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.bl;

public final class b
  extends g
{
  private k.b nLK;
  private String nLL;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bl parambl)
  {
    super(paramg, parambl);
  }
  
  private k.b bNE()
  {
    AppMethodBeat.i(123259);
    if (this.nLK == null) {
      this.nLK = k.b.rx(this.nLz.field_content);
    }
    k.b localb = this.nLK;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String asu()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.nLL == null) && (bNE() != null) && (bNE().dbA != null) && (bNE().dbA.length() > 0))
    {
      localObject = com.tencent.mm.plugin.s.a.bxS().aAL(bNE().dbA);
      if (localObject != null) {
        this.nLL = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.nLL != null)
    {
      localObject = this.nLL;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final String bNx()
  {
    AppMethodBeat.i(123260);
    if (bNE() != null)
    {
      String str = bNE().gHf;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final int bNy()
  {
    AppMethodBeat.i(123262);
    if (bNE() != null)
    {
      int i = bNE().gHe;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (bNE() != null)
    {
      String str = bNE().title;
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