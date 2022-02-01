package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldPrepare10UI;", "Lcom/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI;", "()V", "plugin-hld_release"})
public final class HldPrepare10UI
  extends HldInitKeyboardSettingUI
{
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldPrepare10UI
 * JD-Core Version:    0.7.0.1
 */