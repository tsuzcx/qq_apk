package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ContentTmplWebViewUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "()V", "plugin-brandservice_release"})
public final class ContentTmplWebViewUI
  extends TmplWebViewToolUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.ContentTmplWebViewUI
 * JD-Core Version:    0.7.0.1
 */