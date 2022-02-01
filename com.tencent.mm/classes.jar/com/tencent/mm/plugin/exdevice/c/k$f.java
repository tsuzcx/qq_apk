package com.tencent.mm.plugin.exdevice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class k$f
{
  private static f oTx = null;
  private long oTw;
  
  public k$f()
  {
    AppMethodBeat.i(23169);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences != null)
    {
      l = localSharedPreferences.getLong("local_message_seq", 0L);
      ad.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
    }
    this.oTw = l;
    AppMethodBeat.o(23169);
  }
  
  public static long bZj()
  {
    AppMethodBeat.i(23170);
    if (oTx == null) {
      oTx = new f();
    }
    Object localObject = oTx;
    if (9223372036854775807L == ((f)localObject).oTw)
    {
      ad.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
      ((f)localObject).oTw = 0L;
    }
    long l = ((f)localObject).oTw + 1L;
    ((f)localObject).oTw = l;
    localObject = aj.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject != null)
    {
      ad.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
      ((SharedPreferences)localObject).edit().putLong("local_message_seq", l).commit();
    }
    AppMethodBeat.o(23170);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.c.k.f
 * JD-Core Version:    0.7.0.1
 */