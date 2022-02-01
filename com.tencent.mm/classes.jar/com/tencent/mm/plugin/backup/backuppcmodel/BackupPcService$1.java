package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class BackupPcService$1
  implements Runnable
{
  BackupPcService$1(BackupPcService paramBackupPcService, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21622);
    Object localObject = b.bIj().bIk();
    String str = this.val$url;
    ad.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    d.xq(1);
    com.tencent.mm.plugin.backup.g.b.bIG();
    ba.aBQ();
    ((c)localObject).nxY = ((Integer)com.tencent.mm.model.c.ajl().get(al.a.Ixb, Integer.valueOf(0))).intValue();
    b.bIj();
    SharedPreferences.Editor localEditor = b.bHc().edit();
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    localEditor.commit();
    ((c)localObject).nxZ = true;
    ba.aiU().a(595, ((c)localObject).nvy);
    localObject = new e(str);
    ba.aiU().a((n)localObject, 0);
    AppMethodBeat.o(21622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService.1
 * JD-Core Version:    0.7.0.1
 */