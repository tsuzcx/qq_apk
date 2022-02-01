package com.tencent.mm.plugin.calcwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvideo.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class e
  extends a
{
  protected final List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc)
  {
    AppMethodBeat.i(22732);
    if (paramcc == null)
    {
      AppMethodBeat.o(22732);
      return null;
    }
    v.bOh();
    Object localObject1 = aa.PX(paramcc.field_imgPath);
    long l1 = y.bEl((String)localObject1);
    com.tencent.mm.plugin.calcwx.b.a locala2 = aH(paramcc);
    locala2.field_msgSubType = 1;
    locala2.field_path = aja((String)localObject1);
    locala2.field_size = l1;
    v.bOh();
    localObject1 = aa.PY(paramcc.field_imgPath);
    l1 = y.bEl((String)localObject1);
    com.tencent.mm.plugin.calcwx.b.a locala3 = aH(paramcc);
    locala3.field_msgSubType = 2;
    locala3.field_path = aja((String)localObject1);
    locala3.field_size = l1;
    ArrayList localArrayList = null;
    long l3 = 0L;
    com.tencent.mm.plugin.calcwx.b.a locala1 = null;
    long l4 = 0L;
    z localz = ab.Qo(paramcc.field_imgPath);
    long l2 = l4;
    localObject1 = locala1;
    Object localObject2 = localArrayList;
    l1 = l3;
    if (localz != null)
    {
      l2 = l4;
      localObject1 = locala1;
      localObject2 = localArrayList;
      l1 = l3;
      if (!Util.isNullOrNil(localz.oYk))
      {
        v.bOh();
        localObject2 = aa.PX(localz.oYk);
        l1 = y.bEl((String)localObject2);
        v.bOh();
        localObject1 = aa.PY(localz.oYk);
        l2 = y.bEl((String)localObject1);
      }
    }
    if (paramcc.dSI()) {
      locala3.field_path = k.b.aP(paramcc.field_content, paramcc.field_reserved).thumburl;
    }
    Log.i("MicroMsg.VideoMsgHandler", "%s create video wx file index video[%s] thumb[%s]", new Object[] { info(), locala2, locala3 });
    localArrayList = new ArrayList();
    localArrayList.add(locala2);
    localArrayList.add(locala3);
    locala1 = aH(paramcc);
    locala1.field_msgSubType = 3;
    locala1.field_path = aja((String)localObject2);
    locala1.field_size = l1;
    localArrayList.add(locala1);
    Log.d("MicroMsg.VideoMsgHandler", info() + " create origin video wx file index " + locala1);
    paramcc = aH(paramcc);
    paramcc.field_msgSubType = 4;
    paramcc.field_path = aja((String)localObject1);
    paramcc.field_size = l2;
    localArrayList.add(paramcc);
    Log.d("MicroMsg.VideoMsgHandler", info() + " create origin video wx file index " + paramcc);
    AppMethodBeat.o(22732);
    return localArrayList;
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
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.e
 * JD-Core Version:    0.7.0.1
 */