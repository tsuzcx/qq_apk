package com.tencent.mm.plugin.h.a;

import com.tencent.mm.h.c.cs;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> M(bi parambi)
  {
    if (parambi == null) {
      return null;
    }
    o.Sr();
    Object localObject = t.nS(parambi.field_imgPath);
    long l = com.tencent.mm.vfs.e.aeQ((String)localObject);
    com.tencent.mm.plugin.h.b.a locala = N(parambi);
    locala.field_msgSubType = 1;
    locala.field_path = xV((String)localObject);
    locala.field_size = l;
    o.Sr();
    localObject = t.nT(parambi.field_imgPath);
    l = com.tencent.mm.vfs.e.aeQ((String)localObject);
    parambi = N(parambi);
    parambi.field_msgSubType = 2;
    parambi.field_path = xV((String)localObject);
    parambi.field_size = l;
    y.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { ayN(), locala, parambi });
    localObject = new ArrayList();
    ((List)localObject).add(locala);
    ((List)localObject).add(parambi);
    return localObject;
  }
  
  protected final String ayN()
  {
    return "video_" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.e
 * JD-Core Version:    0.7.0.1
 */