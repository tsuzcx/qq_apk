package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TmplWebViewMMUI
  extends TmplWebViewToolUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewMMUI
 * JD-Core Version:    0.7.0.1
 */