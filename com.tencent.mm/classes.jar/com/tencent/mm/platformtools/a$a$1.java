package com.tencent.mm.platformtools;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.sdk.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import java.util.Iterator;

final class a$a$1
  extends MMHandler
{
  a$a$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(127664);
    if (!h.aHB())
    {
      AppMethodBeat.o(127664);
      return;
    }
    f.a locala = new f.a();
    int i = a.mDt.size();
    boolean bool = Boolean.parseBoolean(paramMessage.obj.toString());
    paramMessage = a.mDt.iterator();
    while (paramMessage.hasNext()) {
      ((b)paramMessage.next()).gr(bool);
    }
    a.mDt.clear();
    Log.i("MicroMsg.AddrBookSyncHelper", "callBackHandler setSize:%d time:%d", new Object[] { Integer.valueOf(i), Long.valueOf(locala.avE()) });
    AppMethodBeat.o(127664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.a.a.1
 * JD-Core Version:    0.7.0.1
 */