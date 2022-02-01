package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.activity.a;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/edit/FinderPhotoEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "operationLayoutPlugin", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "initLogic", "", "navigator", "Lcom/tencent/mm/plugin/recordvideo/activity/IRecordUINavigation;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "loadCurrentPage", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "plugin-finder_release"})
public final class FinderPhotoEditPluginLayout
  extends EditPhotoPluginLayout
{
  private final WxCropOperationLayout KLF;
  
  public FinderPhotoEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(165504);
    this.KLF = new WxCropOperationLayout(paramContext);
    this.KLF.setStyle(WxCropOperationLayout.j.LpL);
    ((ViewGroup)findViewById(2131303249)).addView((View)this.KLF, new ViewGroup.LayoutParams(-1, -1));
    AppMethodBeat.o(165504);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(165503);
    super.a(paramb);
    paramb = getEditPhotoWrapper().vjU;
    if (paramb != null) {
      paramb.eBr();
    }
    this.KLF.bringToFront();
    AppMethodBeat.o(165503);
  }
  
  public final void a(a parama, RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(165502);
    k.h(parama, "navigator");
    k.h(paramRecordConfigProvider, "configProvider");
    super.a(parama, paramRecordConfigProvider);
    parama = paramRecordConfigProvider.hsl;
    if (parama != null)
    {
      parama = (Rect)parama.getParcelable("cropRect");
      if (parama != null)
      {
        this.KLF.getVisibilityRect().set(parama);
        AppMethodBeat.o(165502);
        return;
      }
      AppMethodBeat.o(165502);
      return;
    }
    AppMethodBeat.o(165502);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderPhotoEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */