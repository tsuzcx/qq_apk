package com.tencent.mm.plugin.h.a;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends a
{
  protected final List<com.tencent.mm.plugin.h.b.a> M(bi parambi)
  {
    long l = 0L;
    b localb2 = null;
    Object localObject2 = null;
    b localb1 = null;
    if (parambi == null) {
      return null;
    }
    Object localObject1 = bk.ZQ(parambi.field_content);
    if (localObject1 != null) {}
    for (localObject1 = g.a.gp((String)localObject1);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        y.e("MicroMsg.AppMsgMsgHandler", "content is null");
        return null;
      }
      com.tencent.mm.plugin.h.b.a locala = N(parambi);
      int i;
      switch (((g.a)localObject1).type)
      {
      case 3: 
      case 4: 
      case 5: 
      default: 
        return null;
      case 2: 
        localb2 = ap.avh().VQ(((g.a)localObject1).bFE);
        localObject1 = localb1;
        if (localb2 != null)
        {
          localObject1 = localb2.field_fileFullPath;
          l = e.aeQ((String)localObject1);
        }
        locala.field_msgSubType = 30;
        locala.field_path = xV((String)localObject1);
        locala.field_size = l;
        i = 31;
      }
      for (;;)
      {
        localObject1 = o.OJ().F(parambi.field_imgPath, true);
        l = e.aeQ((String)localObject1);
        parambi = N(parambi);
        parambi.field_msgSubType = i;
        parambi.field_path = xV((String)localObject1);
        parambi.field_size = l;
        y.i("MicroMsg.AppMsgMsgHandler", "%s create app msg wx file index app[%s] thumb[%s]", new Object[] { ayN(), locala, parambi });
        localObject1 = new ArrayList();
        ((List)localObject1).add(locala);
        ((List)localObject1).add(parambi);
        return localObject1;
        localb1 = ap.avh().VQ(((g.a)localObject1).bFE);
        localObject1 = localb2;
        if (localb1 != null)
        {
          localObject1 = localb1.field_fileFullPath;
          l = e.aeQ((String)localObject1);
        }
        locala.field_msgSubType = 32;
        locala.field_path = xV((String)localObject1);
        locala.field_size = l;
        i = 33;
        continue;
        localb1 = ap.avh().VQ(((g.a)localObject1).bFE);
        localObject1 = localObject2;
        if (localb1 != null)
        {
          localObject1 = localb1.field_fileFullPath;
          l = e.aeQ((String)localObject1);
        }
        locala.field_msgSubType = 34;
        locala.field_path = xV((String)localObject1);
        locala.field_size = l;
        i = 35;
      }
    }
  }
  
  protected final String ayN()
  {
    return "AppMsg_" + hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.h.a.c
 * JD-Core Version:    0.7.0.1
 */