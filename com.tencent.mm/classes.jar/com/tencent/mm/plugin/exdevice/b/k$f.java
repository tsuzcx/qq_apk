package com.tencent.mm.plugin.exdevice.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;

public final class k$f
{
  private static f jtm = null;
  private long jtl;
  
  public k$f()
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localSharedPreferences != null)
    {
      l = localSharedPreferences.getLong("local_message_seq", 0L);
      y.i("MicroMsg.exdevice.Util", "lasted seq id is %d", new Object[] { Long.valueOf(l) });
    }
    this.jtl = l;
  }
  
  public static long aLp()
  {
    if (jtm == null) {
      jtm = new f();
    }
    Object localObject = jtm;
    if (9223372036854775807L == ((f)localObject).jtl)
    {
      y.w("MicroMsg.MMSendDataToManufacturerLogic", "Sequence Data-overrun!!!");
      ((f)localObject).jtl = 0L;
    }
    long l = ((f)localObject).jtl + 1L;
    ((f)localObject).jtl = l;
    localObject = ae.getContext().getSharedPreferences("exdevice_pref", 0);
    if (localObject != null)
    {
      y.i("MicroMsg.exdevice.Util", "save locall seq id : %d", new Object[] { Long.valueOf(l) });
      ((SharedPreferences)localObject).edit().putLong("local_message_seq", l).commit();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.b.k.f
 * JD-Core Version:    0.7.0.1
 */