package com.tencent.mm.ao;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.model.as
{
  public final String getTag()
  {
    return "MicroMsg.DataTransfer.BlackListConvDataTransfer";
  }
  
  public final boolean rT(int paramInt)
  {
    return (paramInt != 0) && (paramInt < 620757033);
  }
  
  public final void transfer(int paramInt)
  {
    AppMethodBeat.i(20478);
    Log.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "the previous version is %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt != 0) && (paramInt < 620757033))
    {
      com.tencent.mm.plugin.report.service.h.CyF.dN(336, 13);
      Object localObject1 = new LinkedList();
      bg.aVF();
      Object localObject2 = com.tencent.mm.model.c.aSN().e("@black.android", "", null);
      Object localObject3;
      if (localObject2 != null)
      {
        ((Cursor)localObject2).moveToFirst();
        while (!((Cursor)localObject2).isAfterLast())
        {
          localObject3 = new com.tencent.mm.storage.as();
          ((com.tencent.mm.storage.as)localObject3).convertFrom((Cursor)localObject2);
          ((List)localObject1).add(((ax)localObject3).field_username);
          ((Cursor)localObject2).moveToNext();
        }
        ((Cursor)localObject2).close();
      }
      if (((List)localObject1).size() > 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Update rconversation");
        ((StringBuilder)localObject2).append(" set parentRef = '@blacklist' where 1 != 1 ");
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          ((StringBuilder)localObject2).append(" or username = '").append((String)localObject3).append("'");
        }
        localObject1 = ((StringBuilder)localObject2).toString();
        Log.d("MicroMsg.DataTransfer.BlackListConvDataTransfer", "update sql: %s", new Object[] { localObject1 });
        bg.aVF();
        com.tencent.mm.model.c.getDataDB().execSQL("rconversation", (String)localObject1);
      }
    }
    AppMethodBeat.o(20478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ao.c
 * JD-Core Version:    0.7.0.1
 */