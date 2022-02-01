package com.tencent.mm.plugin.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.f.b.a> ap(ca paramca)
  {
    AppMethodBeat.i(22732);
    if (paramca == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    o.bhj();
    Object localObject = t.Qw(paramca.field_imgPath);
    long l = s.boW((String)localObject);
    com.tencent.mm.plugin.f.b.a locala = aq(paramca);
    locala.field_msgSubType = 1;
    locala.field_path = bxb((String)localObject);
    locala.field_size = l;
    o.bhj();
    String str = t.Qx(paramca.field_imgPath);
    l = s.boW(str);
    localObject = aq(paramca);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_msgSubType = 2;
    ((com.tencent.mm.plugin.f.b.a)localObject).field_path = bxb(str);
    ((com.tencent.mm.plugin.f.b.a)localObject).field_size = l;
    if (paramca.cWK()) {
      ((com.tencent.mm.plugin.f.b.a)localObject).field_path = k.b.aD(paramca.field_content, paramca.field_reserved).thumburl;
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
 * Qualified Name:     com.tencent.mm.plugin.f.a.e
 * JD-Core Version:    0.7.0.1
 */