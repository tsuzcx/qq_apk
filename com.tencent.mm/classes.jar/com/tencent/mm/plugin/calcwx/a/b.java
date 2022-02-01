package com.tencent.mm.plugin.calcwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc)
  {
    Object localObject2 = null;
    AppMethodBeat.i(22726);
    if (paramcc == null)
    {
      AppMethodBeat.o(22726);
      return null;
    }
    Object localObject1 = Util.processXml(paramcc.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.Hf((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        AppMethodBeat.o(22726);
        return null;
      }
      com.tencent.mm.plugin.calcwx.b.a locala = aH(paramcc);
      c localc = as.cWJ().bpI(((k.b)localObject1).hzM);
      long l = 0L;
      localObject1 = localObject2;
      if (localc != null)
      {
        localObject1 = localc.field_fileFullPath;
        l = y.bEl((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = aja((String)localObject1);
      locala.field_size = l;
      localObject1 = r.bKa().X(paramcc.field_imgPath, true);
      l = y.bEl((String)localObject1);
      paramcc = aH(paramcc);
      paramcc.field_msgSubType = 31;
      paramcc.field_path = aja((String)localObject1);
      paramcc.field_size = l;
      Log.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { info(), locala, paramcc });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(paramcc);
      AppMethodBeat.o(22726);
      return localObject1;
    }
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22727);
    String str = "AppMsgImg_" + hashCode();
    AppMethodBeat.o(22727);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.b
 * JD-Core Version:    0.7.0.1
 */