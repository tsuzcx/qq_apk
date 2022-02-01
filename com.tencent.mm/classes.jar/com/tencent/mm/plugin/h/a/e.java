package com.tencent.mm.plugin.h.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> ax(ca paramca)
  {
    AppMethodBeat.i(22732);
    if (paramca == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    s.bqB();
    Object localObject = x.XT(paramca.field_imgPath);
    long l = u.bBQ((String)localObject);
    com.tencent.mm.plugin.h.b.a locala = ay(paramca);
    locala.field_msgSubType = 1;
    locala.field_path = bAT((String)localObject);
    locala.field_size = l;
    s.bqB();
    String str = x.XU(paramca.field_imgPath);
    l = u.bBQ(str);
    localObject = ay(paramca);
    ((com.tencent.mm.plugin.h.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.h.b.a)localObject).field_path = bAT(str);
    ((com.tencent.mm.plugin.h.b.a)localObject).field_size = l;
    if (paramca.dlS()) {
      ((com.tencent.mm.plugin.h.b.a)localObject).field_path = k.b.aG(paramca.field_content, paramca.field_reserved).thumburl;
    }
    Log.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala, localObject });
    paramca = new ArrayList();
    paramca.add(locala);
    paramca.add(localObject);
    AppMethodBeat.o(22732);
    return paramca;
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
 * Qualified Name:     com.tencent.mm.plugin.h.a.e
 * JD-Core Version:    0.7.0.1
 */