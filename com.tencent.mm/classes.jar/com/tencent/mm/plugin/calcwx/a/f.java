package com.tencent.mm.plugin.calcwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc)
  {
    AppMethodBeat.i(22734);
    if (paramcc == null)
    {
      AppMethodBeat.o(22734);
      return null;
    }
    com.tencent.mm.plugin.calcwx.b.a locala = aH(paramcc);
    paramcc = s.getFullPath(paramcc.field_imgPath);
    long l = y.bEl(paramcc);
    locala.field_msgSubType = 10;
    locala.field_path = aja(paramcc);
    locala.field_size = l;
    Log.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { info(), locala });
    paramcc = new ArrayList();
    paramcc.add(locala);
    AppMethodBeat.o(22734);
    return paramcc;
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
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.f
 * JD-Core Version:    0.7.0.1
 */