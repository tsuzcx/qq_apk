package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bl parambl)
  {
    AppMethodBeat.i(22734);
    if (parambl == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.f.b.a locala = ad(parambl);
    parambl = s.getFullPath(parambl.field_imgPath);
    long l = i.aMN(parambl);
    locala.field_msgSubType = 10;
    locala.field_path = aUM(parambl);
    locala.field_size = l;
    ad.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    parambl = new ArrayList();
    parambl.add(locala);
    AppMethodBeat.o(22734);
    return parambl;
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