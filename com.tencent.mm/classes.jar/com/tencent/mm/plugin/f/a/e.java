package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> Q(bi parambi)
  {
    AppMethodBeat.i(18623);
    if (parambi == null)
    {
      AppMethodBeat.o(18623);
      return null;
    }
    o.alE();
    Object localObject = t.vf(parambi.field_imgPath);
    long l = com.tencent.mm.vfs.e.avI((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = R(parambi);
    locala.field_msgSubType = 1;
    locala.field_path = Hw((String)localObject);
    locala.field_size = l;
    o.alE();
    localObject = t.vg(parambi.field_imgPath);
    l = com.tencent.mm.vfs.e.avI((String)localObject);
    parambi = R(parambi);
    parambi.field_msgSubType = 2;
    parambi.field_path = Hw((String)localObject);
    parambi.field_size = l;
    ab.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { bau(), locala, parambi });
    localObject = new ArrayList();
    ((List)localObject).add(locala);
    ((List)localObject).add(parambi);
    AppMethodBeat.o(18623);
    return localObject;
  }
  
  protected final String bau()
  {
    AppMethodBeat.i(18624);
    String str = "video_" + hashCode();
    AppMethodBeat.o(18624);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.e
 * JD-Core Version:    0.7.0.1
 */