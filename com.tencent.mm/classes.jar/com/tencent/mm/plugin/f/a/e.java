package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ac(bo parambo)
  {
    AppMethodBeat.i(22732);
    if (parambo == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    o.aJy();
    Object localObject = t.DV(parambo.field_imgPath);
    long l = i.aSp((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = ad(parambo);
    locala.field_msgSubType = 1;
    locala.field_path = aBR((String)localObject);
    locala.field_size = l;
    o.aJy();
    String str = t.DW(parambo.field_imgPath);
    l = i.aSp(str);
    localObject = ad(parambo);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.f.b.a)localObject).field_path = aBR(str);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_size = l;
    if (parambo.cru()) {
      ((com.tencent.mm.plugin.f.b.a)localObject).field_path = k.b.az(parambo.field_content, parambo.field_reserved).thumburl;
    }
    ac.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala, localObject });
    parambo = new ArrayList();
    parambo.add(locala);
    parambo.add(localObject);
    AppMethodBeat.o(22732);
    return parambo;
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