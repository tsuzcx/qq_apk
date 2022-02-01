package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bo parambo)
  {
    AppMethodBeat.i(22734);
    if (parambo == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.f.b.a locala = ad(parambo);
    parambo = s.getFullPath(parambo.field_imgPath);
    long l = i.aSp(parambo);
    locala.field_msgSubType = 10;
    locala.field_path = aBR(parambo);
    locala.field_size = l;
    ac.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    parambo = new ArrayList();
    parambo.add(locala);
    AppMethodBeat.o(22734);
    return parambo;
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