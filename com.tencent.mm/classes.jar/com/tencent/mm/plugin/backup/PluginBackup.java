package com.tencent.mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.o;

public class PluginBackup
  extends f
  implements com.tencent.mm.plugin.backup.a.a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(21164);
    if (paramg.ahL())
    {
      o.b("msgsynchronize", "msgsynchronize", 2592000000L, 107);
      ac.i("VFS.Debug", "msgsynchronize FS registered");
      o.b("backupRecover", "backupRecover", 2592000000L, 99);
      ac.i("VFS.Debug", "backupRecover FS registered");
    }
    AppMethodBeat.o(21164);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(21165);
    if (paramg.ahL())
    {
      ac.i("MicroMsg.PluginBackup", "PluginMonitor execute PluginMonitor new BackupCore");
      pin(new t(com.tencent.mm.plugin.backup.j.a.class));
    }
    AppMethodBeat.o(21165);
  }
  
  public String name()
  {
    return "plugin-backup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.PluginBackup
 * JD-Core Version:    0.7.0.1
 */