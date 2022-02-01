package com.tencent.mm.plugin.image;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.ImageGCFileSystem;
import com.tencent.mm.vfs.ImageGCFileSystem.a;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.k.a;
import java.util.Map;

public class PluginImageBase
  extends f
  implements a
{
  public void configure(g paramg)
  {
    AppMethodBeat.i(177298);
    if (paramg.bbA())
    {
      af.aR("image", "image", 17);
      af.aR("image2", "image2", 1427);
      paramg = k.kMs().kMv();
      ImageGCFileSystem localImageGCFileSystem = new ImageGCFileSystem((FileSystem)k.kMs().jKz().get("image2"));
      localImageGCFileSystem.a("image2", new ImageGCFileSystem.a());
      paramg.a("image2", localImageGCFileSystem).commit();
    }
    AppMethodBeat.o(177298);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(177299);
    if (paramg.bbA()) {
      pin(d.fQC());
    }
    AppMethodBeat.o(177299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.image.PluginImageBase
 * JD-Core Version:    0.7.0.1
 */