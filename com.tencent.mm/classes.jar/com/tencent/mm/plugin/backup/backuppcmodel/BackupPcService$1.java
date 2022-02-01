package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class BackupPcService$1
  implements Runnable
{
  BackupPcService$1(BackupPcService paramBackupPcService, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21622);
    Object localObject = b.cVW().cVX();
    String str = this.val$url;
    Log.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    d.Fd(1);
    com.tencent.mm.plugin.backup.g.b.cWt();
    bh.bCz();
    ((c)localObject).vbC = ((Integer)com.tencent.mm.model.c.ban().get(at.a.acOW, Integer.valueOf(0))).intValue();
    b.cVW();
    SharedPreferences.Editor localEditor = b.cUO().edit();
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    localEditor.commit();
    ((c)localObject).vbD = true;
    bh.aZW().a(595, ((c)localObject).uYY);
    localObject = new e(str);
    bh.aZW().a((p)localObject, 0);
    AppMethodBeat.o(21622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService.1
 * JD-Core Version:    0.7.0.1
 */