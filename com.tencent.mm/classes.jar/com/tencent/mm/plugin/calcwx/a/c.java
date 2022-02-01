package com.tencent.mm.plugin.calcwx.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.calcwx.b.a> aG(cc paramcc)
  {
    long l = 0L;
    com.tencent.mm.plugin.calcwx.b.a locala = null;
    Object localObject2 = null;
    com.tencent.mm.pluginsdk.model.app.c localc = null;
    Object localObject3 = null;
    Object localObject4 = null;
    AppMethodBeat.i(22728);
    if (paramcc == null)
    {
      AppMethodBeat.o(22728);
      return null;
    }
    Object localObject1 = Util.processXml(paramcc.field_content);
    if (localObject1 != null) {}
    for (localObject1 = k.b.Hf((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        Log.e("MicroMsg.AppMsgMsgHandler", "content is null");
        AppMethodBeat.o(22728);
        return null;
      }
      int i;
      switch (((k.b)localObject1).type)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        if (!Util.isNullOrNil(paramcc.field_imgPath))
        {
          i = 38;
          localObject1 = localObject4;
          localObject2 = r.bKa().X(paramcc.field_imgPath, true);
          l = y.bEl((String)localObject2);
          locala = aH(paramcc);
          locala.field_msgSubType = i;
          locala.field_path = aja((String)localObject2);
          locala.field_size = l;
          localObject2 = info();
          if (localObject1 != null) {
            break label575;
          }
        }
        break;
      }
      label575:
      for (paramcc = "null";; paramcc = (cc)localObject1)
      {
        Log.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { localObject2, paramcc, locala });
        paramcc = new ArrayList();
        if (localObject1 != null) {
          paramcc.add(localObject1);
        }
        paramcc.add(locala);
        AppMethodBeat.o(22728);
        return paramcc;
        localc = as.cWJ().bpI(((k.b)localObject1).hzM);
        localObject2 = aH(paramcc);
        localObject1 = locala;
        if (localc != null)
        {
          localObject1 = localc.field_fileFullPath;
          l = y.bEl((String)localObject1);
        }
        ((com.tencent.mm.plugin.calcwx.b.a)localObject2).field_msgSubType = 30;
        ((com.tencent.mm.plugin.calcwx.b.a)localObject2).field_path = aja((String)localObject1);
        ((com.tencent.mm.plugin.calcwx.b.a)localObject2).field_size = l;
        i = 31;
        localObject1 = localObject2;
        break;
        localc = as.cWJ().bpI(((k.b)localObject1).hzM);
        locala = aH(paramcc);
        localObject1 = localObject2;
        if (localc != null)
        {
          localObject1 = localc.field_fileFullPath;
          l = y.bEl((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = aja((String)localObject1);
        locala.field_size = l;
        i = 33;
        localObject1 = locala;
        break;
        localObject2 = as.cWJ().bpI(((k.b)localObject1).hzM);
        locala = aH(paramcc);
        localObject1 = localc;
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          l = y.bEl((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = aja((String)localObject1);
        locala.field_size = l;
        i = 35;
        localObject1 = locala;
        break;
        localObject2 = as.cWJ().bpI(((k.b)localObject1).hzM);
        locala = aH(paramcc);
        localObject1 = localObject3;
        if (localObject2 != null)
        {
          localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject2).field_fileFullPath;
          l = y.bEl((String)localObject1);
        }
        locala.field_msgSubType = 36;
        locala.field_path = aja((String)localObject1);
        locala.field_size = l;
        i = 37;
        localObject1 = locala;
        break;
        AppMethodBeat.o(22728);
        return null;
      }
    }
  }
  
  protected final String info()
  {
    AppMethodBeat.i(22729);
    String str = "AppMsg_" + hashCode();
    AppMethodBeat.o(22729);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.calcwx.a.c
 * JD-Core Version:    0.7.0.1
 */