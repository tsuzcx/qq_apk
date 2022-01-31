package com.tencent.mm.plugin.ext;

import android.database.Cursor;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashMap;

final class b$5
  implements g.a
{
  b$5(b paramb) {}
  
  public final void a(g arg1, g.c paramc)
  {
    if ((??? == null) || (paramc == null) || (paramc.mdu == null))
    {
      y.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
      return;
    }
    Object localObject;
    synchronized (this.jJF)
    {
      localObject = b.aNp().cvU();
      if (localObject == null)
      {
        y.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
        return;
      }
    }
    y.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
    if (((Cursor)localObject).getCount() <= 0)
    {
      ((Cursor)localObject).close();
      y.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
      return;
    }
    ((Cursor)localObject).close();
    int i = 0;
    for (;;)
    {
      if (i < paramc.mdu.size())
      {
        localObject = (bi)paramc.mdu.get(i);
        if ((localObject != null) && (((cs)localObject).field_isSend == 0) && (((cs)localObject).field_status != 4) && (((bi)localObject).getType() != 9999) && (((bi)localObject).getType() != 10000) && (!s.hV(((cs)localObject).field_talker)) && (!s.hZ(((cs)localObject).field_talker)))
        {
          Integer localInteger = (Integer)b.a(this.jJF).get(((cs)localObject).field_talker);
          if (localInteger == null)
          {
            b.a(this.jJF).put(((cs)localObject).field_talker, Integer.valueOf(1));
            y.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((cs)localObject).field_talker, Integer.valueOf(1) });
          }
          else
          {
            b.a(this.jJF).put(((cs)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
            y.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((cs)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
          }
        }
      }
      else
      {
        if (b.a(this.jJF).size() > 0) {
          this.jJF.aNu();
        }
        for (;;)
        {
          return;
          y.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.5
 * JD-Core Version:    0.7.0.1
 */