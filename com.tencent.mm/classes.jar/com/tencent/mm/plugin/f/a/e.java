package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ae(bv parambv)
  {
    AppMethodBeat.i(22732);
    if (parambv == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    com.tencent.mm.modelvideo.o.aNh();
    Object localObject = t.HJ(parambv.field_imgPath);
    long l = com.tencent.mm.vfs.o.aZR((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = af(parambv);
    locala.field_msgSubType = 1;
    locala.field_path = aJh((String)localObject);
    locala.field_size = l;
    com.tencent.mm.modelvideo.o.aNh();
    String str = t.HK(parambv.field_imgPath);
    l = com.tencent.mm.vfs.o.aZR(str);
    localObject = af(parambv);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.f.b.a)localObject).field_path = aJh(str);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_size = l;
    if (parambv.cyH()) {
      ((com.tencent.mm.plugin.f.b.a)localObject).field_path = k.b.aB(parambv.field_content, parambv.field_reserved).thumburl;
    }
    ae.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala, localObject });
    parambv = new ArrayList();
    parambv.add(locala);
    parambv.add(localObject);
    AppMethodBeat.o(22732);
    return parambv;
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22733);
    String str = "video_" + hashCode();
    AppMethodBeat.o(22733);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.e
 * JD-Core Version:    0.7.0.1
 */