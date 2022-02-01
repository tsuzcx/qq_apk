package com.tencent.mm.plugin.backup.backupui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ad;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;

final class a$1
  implements Runnable
{
  a$1(a parama, MultiProcessMMKV paramMultiProcessMMKV, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(300668);
    Object localObject = this.vec.getString("MMKV_BACKUP_ERROR_CACHE", "");
    if (Util.isNullOrNil((String)localObject))
    {
      localObject = new ad();
      ((ad)localObject).ink = this.ved;
      ((ad)localObject).bMH();
    }
    for (;;)
    {
      this.vec.encode("MMKV_BACKUP_NEED_REPORT", false);
      AppMethodBeat.o(300668);
      return;
      new ad((String)localObject).bMH();
      this.vec.encode("MMKV_BACKUP_ERROR_CACHE", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backupui.a.1
 * JD-Core Version:    0.7.0.1
 */