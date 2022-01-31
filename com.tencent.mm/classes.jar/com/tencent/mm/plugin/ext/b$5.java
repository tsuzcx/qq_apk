package com.tencent.mm.plugin.ext;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bp;
import java.util.ArrayList;
import java.util.HashMap;

final class b$5
  implements h.a
{
  b$5(b paramb) {}
  
  public final void a(h arg1, h.c paramc)
  {
    AppMethodBeat.i(20263);
    if ((??? == null) || (paramc == null) || (paramc.oDQ == null))
    {
      ab.e("MicroMsg.SubCoreExt", "onMsgChange, wrong args");
      AppMethodBeat.o(20263);
      return;
    }
    for (;;)
    {
      int i;
      synchronized (this.mdJ)
      {
        Object localObject = b.bts().dyD();
        if (localObject == null)
        {
          ab.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange getValidOpenMsgListener cu == null");
          AppMethodBeat.o(20263);
          return;
        }
        ab.d("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange listener count = %s", new Object[] { Integer.valueOf(((Cursor)localObject).getCount()) });
        if (((Cursor)localObject).getCount() <= 0)
        {
          ((Cursor)localObject).close();
          ab.i("MicroMsg.SubCoreExt", "onMsgChange onNotifyChange cu.getCount() <= 0");
          AppMethodBeat.o(20263);
          return;
        }
        ((Cursor)localObject).close();
        i = 0;
        if (i < paramc.oDQ.size())
        {
          localObject = (bi)paramc.oDQ.get(i);
          if ((localObject == null) || (((dd)localObject).field_isSend != 0) || (((dd)localObject).field_status == 4) || (((bi)localObject).getType() == 9999) || (((bi)localObject).getType() == 10000) || (t.oE(((dd)localObject).field_talker)) || (t.oI(((dd)localObject).field_talker))) {
            break label412;
          }
          Integer localInteger = (Integer)b.a(this.mdJ).get(((dd)localObject).field_talker);
          if (localInteger == null)
          {
            b.a(this.mdJ).put(((dd)localObject).field_talker, Integer.valueOf(1));
            ab.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((dd)localObject).field_talker, Integer.valueOf(1) });
          }
          else
          {
            b.a(this.mdJ).put(((dd)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1));
            ab.d("MicroMsg.SubCoreExt", "onMsgChange %s, %d", new Object[] { ((dd)localObject).field_talker, Integer.valueOf(localInteger.intValue() + 1) });
          }
        }
      }
      if (b.a(this.mdJ).size() > 0) {
        this.mdJ.btx();
      }
      for (;;)
      {
        AppMethodBeat.o(20263);
        return;
        ab.i("MicroMsg.SubCoreExt", "notifyMsgUsers.size < 1");
      }
      label412:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.b.5
 * JD-Core Version:    0.7.0.1
 */