package com.tencent.mm.plugin.backup;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.a;
import com.tencent.mm.vfs.RC4EncryptedFileSystem;

public class PluginBackup
  extends f
  implements com.tencent.mm.plugin.backup.a.a
{
  public void configure(g paramg)
  {
    if (paramg.Ex())
    {
      FileSystemManager.cVw().cVy().a("msgsynchronize", new RC4EncryptedFileSystem("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize")).gA("${storage}/tencent/MicroMsg/${account}/msgsynchronize", "msgsynchronize").commit();
      y.i("VFS.Debug", "msgsynchronize FS registered");
    }
  }
  
  public void execute(g paramg)
  {
    if (paramg.Ex())
    {
      y.i("MicroMsg.PluginBackup", "PluginMonitor execute PluginMonitor new BackupCore");
      pin(new p(com.tencent.mm.plugin.backup.j.a.class));
    }
  }
  
  public String name()
  {
    return "plugin-backup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.PluginBackup
 * JD-Core Version:    0.7.0.1
 */