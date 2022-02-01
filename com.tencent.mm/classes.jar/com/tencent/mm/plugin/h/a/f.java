package com.tencent.mm.plugin.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> ax(ca paramca)
  {
    AppMethodBeat.i(22734);
    if (paramca == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.h.b.a locala = ay(paramca);
    paramca = s.getFullPath(paramca.field_imgPath);
    long l = u.bBQ(paramca);
    locala.field_msgSubType = 10;
    locala.field_path = bAT(paramca);
    locala.field_size = l;
    Log.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    paramca = new ArrayList();
    paramca.add(locala);
    AppMethodBeat.o(22734);
    return paramca;
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
 * Qualified Name:     com.tencent.mm.plugin.h.a.f
 * JD-Core Version:    0.7.0.1
 */