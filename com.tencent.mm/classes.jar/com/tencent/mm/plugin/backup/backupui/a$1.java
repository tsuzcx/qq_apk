package com.tencent.mm.plugin.backup.backupui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.z;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

final class a$1
  implements Runnable
{
  a$1(a parama, MultiProcessMMKV paramMultiProcessMMKV, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(284398);
    Object localObject = this.rSN.getString("MMKV_BACKUP_ERROR_CACHE", "");
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = new z();
      ((z)localObject).ggn = this.rSO;
      ((z)localObject).bpa();
    }
    for (;;)
    {
      this.rSN.encode("MMKV_BACKUP_NEED_REPORT", false);
      AppMethodBeat.o(284398);
      return;
      new z((String)localObject).bpa();
      this.rSN.encode("MMKV_BACKUP_ERROR_CACHE", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.1
 * JD-Core Version:    0.7.0.1
 */