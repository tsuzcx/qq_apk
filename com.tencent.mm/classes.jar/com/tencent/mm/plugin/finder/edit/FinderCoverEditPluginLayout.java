package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.e;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/edit/FinderCoverEditPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/MultiVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setupImageEditPlugins", "", "selectFirst", "", "plugin-finder_release"})
public final class FinderCoverEditPluginLayout
  extends MultiVideoPluginLayout
{
  public FinderCoverEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243394);
    AppMethodBeat.o(243394);
  }
  
  public final void setupImageEditPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(243393);
    super.setupImageEditPlugins(paramBoolean);
    getMultiPreviewPlugin().GHe.setStyle(WxCropOperationLayout.j.BZJ);
    setCurrentStyle(WxCropOperationLayout.j.BZJ);
    AppMethodBeat.o(243393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderCoverEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */