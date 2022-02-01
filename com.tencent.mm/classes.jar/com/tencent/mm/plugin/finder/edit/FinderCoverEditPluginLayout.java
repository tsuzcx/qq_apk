package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.ui.MultiVideoPluginLayout;
import com.tencent.mm.plugin.vlog.ui.plugin.d;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/edit/FinderCoverEditPluginLayout;", "Lcom/tencent/mm/plugin/vlog/ui/MultiVideoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setupImageEditPlugins", "", "selectFirst", "", "plugin-finder_release"})
public final class FinderCoverEditPluginLayout
  extends MultiVideoPluginLayout
{
  public FinderCoverEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(290228);
    AppMethodBeat.o(290228);
  }
  
  public final void setupImageEditPlugins(boolean paramBoolean)
  {
    AppMethodBeat.i(290227);
    super.setupImageEditPlugins(paramBoolean);
    getMultiPreviewPlugin().NuR.setStyle(WxCropOperationLayout.j.HWy);
    setCurrentStyle(WxCropOperationLayout.j.HWy);
    AppMethodBeat.o(290227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderCoverEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */