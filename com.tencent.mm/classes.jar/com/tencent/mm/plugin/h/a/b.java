package com.tencent.mm.plugin.h.a;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class b
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> M(bi parambi)
  {
    Object localObject2 = null;
    if (parambi == null) {
      return null;
    }
    Object localObject1 = bk.ZQ(parambi.field_content);
    if (localObject1 != null) {}
    for (localObject1 = g.a.gp((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.AppMsgImgMsgHandler", "content is null");
        return null;
      }
      com.tencent.mm.plugin.h.b.a locala = N(parambi);
      com.tencent.mm.pluginsdk.model.app.b localb = ap.avh().VQ(((g.a)localObject1).bFE);
      long l = 0L;
      localObject1 = localObject2;
      if (localb != null)
      {
        localObject1 = localb.field_fileFullPath;
        l = e.aeQ((String)localObject1);
      }
      locala.field_msgSubType = 30;
      locala.field_path = xV((String)localObject1);
      locala.field_size = l;
      localObject1 = o.OJ().F(parambi.field_imgPath, true);
      l = e.aeQ((String)localObject1);
      parambi = N(parambi);
      parambi.field_msgSubType = 31;
      parambi.field_path = xV((String)localObject1);
      parambi.field_size = l;
      y.i("MicroMsg.AppMsgImgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { ayN(), locala, parambi });
      localObject1 = new ArrayList();
      ((List)localObject1).add(locala);
      ((List)localObject1).add(parambi);
      return localObject1;
    }
  }
  
  protected final String ayN()
  {
    return "AppMsgImg_" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.b
 * JD-Core Version:    0.7.0.1
 */