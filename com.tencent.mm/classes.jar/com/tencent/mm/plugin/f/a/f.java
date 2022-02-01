package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> af(bu parambu)
  {
    AppMethodBeat.i(22734);
    if (parambu == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.f.b.a locala = ag(parambu);
    parambu = s.getFullPath(parambu.field_imgPath);
    long l = i.aYo(parambu);
    locala.field_msgSubType = 10;
    locala.field_path = ahL(parambu);
    locala.field_size = l;
    ad.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    parambu = new ArrayList();
    parambu.add(locala);
    AppMethodBeat.o(22734);
    return parambu;
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22735);
    String str = "voice_" + hashCode();
    AppMethodBeat.o(22735);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.f
 * JD-Core Version:    0.7.0.1
 */