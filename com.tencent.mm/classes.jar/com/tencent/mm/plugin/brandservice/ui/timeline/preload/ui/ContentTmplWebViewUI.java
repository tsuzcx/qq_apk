package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ContentTmplWebViewUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "()V", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContentTmplWebViewUI
  extends TmplWebViewToolUI
{
  public final void _$_clearFindViewByIdCache() {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.ContentTmplWebViewUI
 * JD-Core Version:    0.7.0.1
 */