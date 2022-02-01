package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.storage.bv;

public final class b
  extends g
{
  private k.b oYH;
  private String oYI;
  
  public b(com.tencent.mm.plugin.choosemsgfile.b.c.g paramg, bv parambv)
  {
    super(paramg, parambv);
  }
  
  private k.b caJ()
  {
    AppMethodBeat.i(123259);
    if (this.oYH == null) {
      this.oYH = k.b.zb(this.oYw.field_content);
    }
    k.b localb = this.oYH;
    AppMethodBeat.o(123259);
    return localb;
  }
  
  protected final String aCF()
  {
    AppMethodBeat.i(123263);
    Object localObject;
    if ((this.oYI == null) && (caJ() != null) && (caJ().dlu != null) && (caJ().dlu.length() > 0))
    {
      localObject = com.tencent.mm.plugin.s.a.bJV().aMZ(caJ().dlu);
      if (localObject != null) {
        this.oYI = ((c)localObject).field_fileFullPath;
      }
    }
    if (this.oYI != null)
    {
      localObject = this.oYI;
      AppMethodBeat.o(123263);
      return localObject;
    }
    AppMethodBeat.o(123263);
    return "";
  }
  
  public final String caC()
  {
    AppMethodBeat.i(123260);
    if (caJ() != null)
    {
      String str = caJ().hCD;
      AppMethodBeat.o(123260);
      return str;
    }
    AppMethodBeat.o(123260);
    return "";
  }
  
  public final int caD()
  {
    AppMethodBeat.i(123262);
    if (caJ() != null)
    {
      int i = caJ().hCC;
      AppMethodBeat.o(123262);
      return i;
    }
    AppMethodBeat.o(123262);
    return 0;
  }
  
  public final String getFileName()
  {
    AppMethodBeat.i(123261);
    if (caJ() != null)
    {
      String str = caJ().title;
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