package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.du;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bl parambl)
  {
    AppMethodBeat.i(22732);
    if (parambl == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    o.aCI();
    Object localObject = t.zQ(parambl.field_imgPath);
    long l = i.aMN((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = ad(parambl);
    locala.field_msgSubType = 1;
    locala.field_path = aUM((String)localObject);
    locala.field_size = l;
    o.aCI();
    String str = t.zR(parambl.field_imgPath);
    l = i.aMN(str);
    localObject = ad(parambl);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.f.b.a)localObject).field_path = aUM(str);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_size = l;
    if (parambl.cjN()) {
      ((com.tencent.mm.plugin.f.b.a)localObject).field_path = k.b.ar(parambl.field_content, parambl.field_reserved).thumburl;
    }
    ad.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala, localObject });
    parambl = new ArrayList();
    parambl.add(locala);
    parambl.add(localObject);
    AppMethodBeat.o(22732);
    return parambl;
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