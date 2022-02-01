package com.tencent.mm.plugin.exdevice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k$f
{
  private static f vdu = null;
  private long vdt;
  
  public k$f()
  {
    AppMethodBeat.i(23169);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences != null)
    {
      l = localSharedPreferences.getLong("local_message_seq", 0L);
      Log.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
    }
    this.vdt = l;
    AppMethodBeat.o(23169);
  }
  
  public static long cYY()
  {
    AppMethodBeat.i(23170);
    if (vdu == null) {
      vdu = new f();
    }
    Object localObject = vdu;
    if (9223372036854775807L == ((f)localObject).vdt)
    {
      Log.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
      ((f)localObject).vdt = 0L;
    }
    long l = ((f)localObject).vdt + 1L;
    ((f)localObject).vdt = l;
    localObject = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject != null)
    {
      Log.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
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