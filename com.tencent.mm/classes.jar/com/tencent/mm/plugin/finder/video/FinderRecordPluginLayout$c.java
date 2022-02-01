package com.tencent.mm.plugin.finder.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.vfs.i;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class FinderRecordPluginLayout$c
  implements Runnable
{
  FinderRecordPluginLayout$c(FinderRecordPluginLayout paramFinderRecordPluginLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(199732);
    Object localObject = FinderRecordPluginLayout.a(this.Lcc);
    if (localObject != null) {}
    for (localObject = ((RecordConfigProvider)localObject).vhV;; localObject = null)
    {
      i.deleteFile((String)localObject);
      AppMethodBeat.o(199732);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderRecordPluginLayout.c
 * JD-Core Version:    0.7.0.1
 */