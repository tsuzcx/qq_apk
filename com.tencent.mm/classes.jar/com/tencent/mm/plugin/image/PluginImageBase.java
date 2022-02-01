package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.vfs.AbstractFileSystem;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.ImageGCFileSystem;
import com.tencent.mm.vfs.ImageGCFileSystem.a;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mm.vfs.StatisticsFileSystem;
import com.tencent.mm.vfs.g.a;
import com.tencent.mm.vfs.y;
import java.util.Map;

public class PluginImageBase
  extends f
  implements a
{
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(177298);
    if (paramg.aBb())
    {
      y.at("image", "image", 19);
      y.at("image2", "image2", 1424);
      paramg = com.tencent.mm.vfs.g.hRR().hRT();
      Object localObject = new ImageGCFileSystem((FileSystem)com.tencent.mm.vfs.g.hRR().hec().get("image2"));
      ((ImageGCFileSystem)localObject).a("image2", new ImageGCFileSystem.a());
      paramg.a("image2", (FileSystem)localObject);
      localObject = new StatisticsFileSystem(new MigrationFileSystem(true, true, new NativeFileSystem("${sdTo}/MicroMsg/${accountSd}/image2"), new FileSystem[] { new NativeFileSystem("${sdFrom}/MicroMsg/${accountSalt}/image2"), new NativeFileSystem("${sdFrom}/MicroMsg/${account}/image2") }));
      ((AbstractFileSystem)localObject).a("OldImage2", new com.tencent.mm.vfs.d("${sdTo}/MicroMsg/${accountSd}/image2", 0, 3, 0L, 0L));
      paramg.b("OldImage2", (FileSystem)localObject).commit();
    }
    AppMethodBeat.o(177298);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(177299);
    if (paramg.aBb()) {
      pin(d.dZE());
    }
    AppMethodBeat.o(177299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.image.PluginImageBase
 * JD-Core Version:    0.7.0.1
 */