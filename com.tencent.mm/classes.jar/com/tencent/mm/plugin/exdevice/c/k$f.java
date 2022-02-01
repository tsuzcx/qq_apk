package com.tencent.mm.plugin.exdevice.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;

public final class k$f
{
  private static f qgS = null;
  private long qgR;
  
  public k$f()
  {
    AppMethodBeat.i(23169);
    SharedPreferences localSharedPreferences = ak.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences != null)
    {
      l = localSharedPreferences.getLong("local_message_seq", 0L);
      ae.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
    }
    this.qgR = l;
    AppMethodBeat.o(23169);
  }
  
  public static long cmm()
  {
    AppMethodBeat.i(23170);
    if (qgS == null) {
      qgS = new f();
    }
    Object localObject = qgS;
    if (9223372036854775807L == ((f)localObject).qgR)
    {
      ae.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
      ((f)localObject).qgR = 0L;
    }
    long l = ((f)localObject).qgR + 1L;
    ((f)localObject).qgR = l;
    localObject = ak.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject != null)
    {
      ae.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
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