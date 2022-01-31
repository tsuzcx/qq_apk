package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> Q(bi parambi)
  {
    AppMethodBeat.i(18625);
    if (parambi == null)
    {
      AppMethodBeat.o(18625);
      return null;
    }
    com.tencent.mm.plugin.f.b.a locala = R(parambi);
    parambi = s.getFullPath(parambi.field_imgPath);
    long l = e.cM(parambi);
    locala.field_msgSubType = 10;
    locala.field_path = Hw(parambi);
    locala.field_size = l;
    ab.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { bau(), locala });
    parambi = new ArrayList();
    parambi.add(locala);
    AppMethodBeat.o(18625);
    return parambi;
  }
  
  protected final String bau()
  {
    AppMethodBeat.i(18626);
    String str = "voice_" + hashCode();
    AppMethodBeat.o(18626);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.f
 * JD-Core Version:    0.7.0.1
 */