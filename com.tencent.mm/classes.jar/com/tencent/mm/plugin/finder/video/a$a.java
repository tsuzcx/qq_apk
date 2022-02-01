package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.b.g;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/video/FinderCameraContainerProcess$getEncodeConfig$1", "Lcom/tencent/mm/media/widget/camerarecordview/data/IEncodeConfig;", "getFilePath", "", "getRecordType", "", "getThumbPath", "plugin-finder_release"})
public final class a$a
  implements a
{
  public final int anW()
  {
    AppMethodBeat.i(199692);
    if (ax.eGe().getBoolean("mediacodec_create_error", false))
    {
      AppMethodBeat.o(199692);
      return 1;
    }
    if (g.isInit())
    {
      g localg = g.vgS;
      i = g.dht();
      AppMethodBeat.o(199692);
      return i;
    }
    int i = this.LbC.vcC.vhD;
    AppMethodBeat.o(199692);
    return i;
  }
  
  public final String anX()
  {
    return "";
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(199693);
    Object localObject = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    if (!i.eK(com.tencent.mm.plugin.recordvideo.e.b.fYw())) {
      i.aMF(com.tencent.mm.plugin.recordvideo.e.b.fYw());
    }
    localObject = new StringBuilder();
    k.g(o.aCH(), "SubCoreVideo.getCore()");
    localObject = o.fQN() + "/" + System.currentTimeMillis();
    AppMethodBeat.o(199693);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.a.a
 * JD-Core Version:    0.7.0.1
 */