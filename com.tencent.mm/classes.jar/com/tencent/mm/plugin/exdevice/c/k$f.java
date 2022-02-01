package com.tencent.mm.plugin.exdevice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k$f
{
  private static f yph = null;
  private long ypg;
  
  public k$f()
  {
    AppMethodBeat.i(23169);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences != null)
    {
      l = localSharedPreferences.getLong("local_message_seq", 0L);
      Log.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
    }
    this.ypg = l;
    AppMethodBeat.o(23169);
  }
  
  public static long dFp()
  {
    AppMethodBeat.i(23170);
    if (yph == null) {
      yph = new f();
    }
    Object localObject = yph;
    if (9223372036854775807L == ((f)localObject).ypg)
    {
      Log.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
      ((f)localObject).ypg = 0L;
    }
    long l = ((f)localObject).ypg + 1L;
    ((f)localObject).ypg = l;
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