package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class BackupPcService$1
  implements Runnable
{
  BackupPcService$1(BackupPcService paramBackupPcService, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(21622);
    Object localObject = b.cga().cgb();
    String str = this.val$url;
    Log.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", new Object[] { str });
    d.Bb(1);
    com.tencent.mm.plugin.backup.g.b.cgx();
    bg.aVF();
    ((c)localObject).oOq = ((Integer)com.tencent.mm.model.c.azQ().get(ar.a.NZB, Integer.valueOf(0))).intValue();
    b.cga();
    SharedPreferences.Editor localEditor = b.ceR().edit();
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
    localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
    localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
    localEditor.commit();
    ((c)localObject).oOr = true;
    bg.azz().a(595, ((c)localObject).oLS);
    localObject = new e(str);
    bg.azz().a((q)localObject, 0);
    AppMethodBeat.o(21622);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService.1
 * JD-Core Version:    0.7.0.1
 */