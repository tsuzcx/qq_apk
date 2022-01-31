package com.tencent.mm.plugin.h.a;

import com.tencent.mm.a.e;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> M(bi parambi)
  {
    if (parambi == null) {
      return null;
    }
    com.tencent.mm.plugin.h.b.a locala = N(parambi);
    parambi = q.getFullPath(parambi.field_imgPath);
    long l = e.bJ(parambi);
    locala.field_msgSubType = 10;
    locala.field_path = xV(parambi);
    locala.field_size = l;
    y.i("MicroMsg.VoiceMsgHandler", "%s create voice wx file index voice[%s]", new Object[] { ayN(), locala });
    parambi = new ArrayList();
    parambi.add(locala);
    return parambi;
  }
  
  protected final String ayN()
  {
    return "voice_" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.f
 * JD-Core Version:    0.7.0.1
 */