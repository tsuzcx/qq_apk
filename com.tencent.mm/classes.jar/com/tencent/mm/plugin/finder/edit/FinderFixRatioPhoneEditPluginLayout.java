package com.tencent.mm.plugin.finder.edit;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.plugin.j;
import com.tencent.mm.plugin.recordvideo.plugin.parent.EditPhotoPluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/edit/FinderFixRatioPhoneEditPluginLayout;", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/EditPhotoPluginLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loadCurrentPage", "", "info", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class FinderFixRatioPhoneEditPluginLayout
  extends EditPhotoPluginLayout
{
  public FinderFixRatioPhoneEditPluginLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(243399);
    AppMethodBeat.o(243399);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb)
  {
    AppMethodBeat.i(243397);
    super.a(paramb);
    paramb = getEditPhotoWrapper().zQp;
    if (paramb != null) {
      paramb.gtj();
    }
    post((Runnable)new a(this));
    AppMethodBeat.o(243397);
  }
  
  public final void a(d.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(243398);
    p.h(paramc, "status");
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      super.a(paramc, paramBundle);
      AppMethodBeat.o(243398);
      return;
    }
    getEditPhotoWrapper().eKA();
    getEditPhotoWrapper().dJF();
    AppMethodBeat.o(243398);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderFixRatioPhoneEditPluginLayout paramFinderFixRatioPhoneEditPluginLayout) {}
    
    public final void run()
    {
      AppMethodBeat.i(243396);
      d.b.a(this.tHk, d.c.BVB);
      AppMethodBeat.o(243396);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.edit.FinderFixRatioPhoneEditPluginLayout
 * JD-Core Version:    0.7.0.1
 */