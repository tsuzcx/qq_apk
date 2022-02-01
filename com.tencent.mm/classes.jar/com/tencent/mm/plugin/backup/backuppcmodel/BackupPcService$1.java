package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class BackupPcService$1
  implements Runnable
{
  BackupPcService$1(BackupPcService paramBackupPcService, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21622);
    Object localObject = b.bEa().bEb();
    String str = this.val$url;
    ac.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    d.wK(1);
    com.tencent.mm.plugin.backup.g.b.bEx();
    az.ayM();
    ((c)localObject).mXB = ((Integer)com.tencent.mm.model.c.agA().get(ah.a.GKJ, Integer.valueOf(0))).intValue();
    b.bEa();
    SharedPreferences.Editor localEditor = b.bCU().edit();
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    localEditor.commit();
    ((c)localObject).mXC = true;
    az.agi().a(595, ((c)localObject).mVb);
    localObject = new e(str);
    az.agi().a((n)localObject, 0);
    AppMethodBeat.o(21622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService.1
 * JD-Core Version:    0.7.0.1
 */