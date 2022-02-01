package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bu;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> af(bu parambu)
  {
    AppMethodBeat.i(22732);
    if (parambu == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    o.aMJ();
    Object localObject = t.Hh(parambu.field_imgPath);
    long l = i.aYo((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = ag(parambu);
    locala.field_msgSubType = 1;
    locala.field_path = ahL((String)localObject);
    locala.field_size = l;
    o.aMJ();
    String str = t.Hi(parambu.field_imgPath);
    l = i.aYo(str);
    localObject = ag(parambu);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.f.b.a)localObject).field_path = ahL(str);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_size = l;
    if (parambu.cxg()) {
      ((com.tencent.mm.plugin.f.b.a)localObject).field_path = k.b.aA(parambu.field_content, parambu.field_reserved).thumburl;
    }
    ad.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala, localObject });
    parambu = new ArrayList();
    parambu.add(locala);
    parambu.add(localObject);
    AppMethodBeat.o(22732);
    return parambu;
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22733);
    String str = "video_" + hashCode();
    AppMethodBeat.o(22733);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.e
 * JD-Core Version:    0.7.0.1
 */