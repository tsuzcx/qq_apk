package com.tencent.mm.plugin.finder.video.reporter;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.gk;
import com.tencent.mm.plugin.finder.video.plugin.a;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BasePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.editor.EditorAudioView;
import com.tencent.mm.plugin.recordvideo.ui.editor.audio.EditorAudioSelectFinderVideoView;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.report.d;
import com.tencent.mm.plugin.vlog.ui.timelineeditor.report.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/reporter/FinderRecordReport21875;", "Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/report/TimelineEditorReport21875;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BasePluginLayout;)V", "init", "", "intent", "Landroid/content/Intent;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends d
{
  public b(BasePluginLayout paramBasePluginLayout)
  {
    super(paramBasePluginLayout);
    AppMethodBeat.i(335097);
    AppMethodBeat.o(335097);
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    boolean bool2 = false;
    AppMethodBeat.i(335108);
    s.u(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    label103:
    do
    {
      do
      {
        AppMethodBeat.o(335108);
        return;
        paramc = (a)hUD().bZ(a.class);
      } while (paramc == null);
      if (w.hQS())
      {
        paramc = paramc.Gso;
        if (paramc != null) {
          break label103;
        }
      }
      for (bool1 = false;; bool1 = paramc.bZY())
      {
        Gc(bool1);
        AppMethodBeat.o(335108);
        return;
      }
      paramc = (a)hUD().bZ(a.class);
    } while (paramc == null);
    paramBundle = paramc.Gso;
    if (paramBundle == null)
    {
      bool1 = false;
      label139:
      if (!bool1) {
        break label172;
      }
      paramc = paramc.Gso;
      if (paramc != null) {
        break label174;
      }
    }
    label172:
    label174:
    for (boolean bool1 = bool2;; bool1 = paramc.NVr)
    {
      Gd(bool1);
      break;
      bool1 = paramBundle.getSelectFinderVideoPanel().cvt();
      break label139;
      break;
    }
  }
  
  public final void ak(Intent paramIntent)
  {
    AppMethodBeat.i(335101);
    s.u(paramIntent, "intent");
    super.ak(paramIntent);
    paramIntent = (gk)this.UqZ;
    if (paramIntent != null) {
      paramIntent.qW("99");
    }
    AppMethodBeat.o(335101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.reporter.b
 * JD-Core Version:    0.7.0.1
 */