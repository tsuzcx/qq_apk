package com.tencent.mm.plugin.finder.video.reporter;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ew;
import com.tencent.mm.plugin.finder.video.plugin.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioSelectFinderVideoView;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.report.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderRecordReport21875;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "init", "", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class b
  extends e
{
  public b(BasePluginLayout paramBasePluginLayout)
  {
    super(paramBasePluginLayout);
    AppMethodBeat.i(286675);
    AppMethodBeat.o(286675);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(286673);
    p.k(paramc, "status");
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label106:
    do
    {
      AppMethodBeat.o(286673);
      return;
      paramc = (a)gwF().bp(a.class);
      if (paramc != null)
      {
        if (w.gts())
        {
          paramc = paramc.AQb;
          if (paramc == null) {
            break label106;
          }
        }
        for (bool1 = paramc.fyo();; bool1 = false)
        {
          AD(bool1);
          AppMethodBeat.o(286673);
          return;
        }
      }
      AppMethodBeat.o(286673);
      return;
      paramc = (a)gwF().bp(a.class);
    } while (paramc == null);
    paramBundle = paramc.AQb;
    if (paramBundle != null) {}
    for (boolean bool1 = paramBundle.getSelectFinderVideoPanel().bVd();; bool1 = false)
    {
      if (bool1)
      {
        paramc = paramc.AQb;
        bool1 = bool2;
        if (paramc != null) {
          bool1 = paramc.HYI;
        }
        AE(bool1);
      }
      AppMethodBeat.o(286673);
      return;
    }
  }
  
  public final void init()
  {
    AppMethodBeat.i(286671);
    super.init();
    ew localew = (ew)this.NEK;
    if (localew != null)
    {
      localew.tj("99");
      AppMethodBeat.o(286671);
      return;
    }
    AppMethodBeat.o(286671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.b
 * JD-Core Version:    0.7.0.1
 */