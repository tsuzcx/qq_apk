package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ae(bv parambv)
  {
    AppMethodBeat.i(22734);
    if (parambv == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.f.b.a locala = af(parambv);
    parambv = s.getFullPath(parambv.field_imgPath);
    long l = o.aZR(parambv);
    locala.field_msgSubType = 10;
    locala.field_path = aJh(parambv);
    locala.field_size = l;
    ae.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    parambv = new ArrayList();
    parambv.add(locala);
    AppMethodBeat.o(22734);
    return parambv;
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22735);
    String str = "voice_" + hashCode();
    AppMethodBeat.o(22735);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.f
 * JD-Core Version:    0.7.0.1
 */