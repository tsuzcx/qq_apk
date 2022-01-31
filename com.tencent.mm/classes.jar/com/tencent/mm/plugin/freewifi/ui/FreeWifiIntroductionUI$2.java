package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.z;

final class FreeWifiIntroductionUI$2
  implements View.OnClickListener
{
  FreeWifiIntroductionUI$2(FreeWifiIntroductionUI paramFreeWifiIntroductionUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20999);
    aw.aaz();
    c.Ru().set(303104, Integer.valueOf(1));
    paramView = this.mNV.getIntent();
    paramView.setClass(this.mNV, FreeWifiEntryUI.class);
    this.mNV.startActivity(paramView);
    this.mNV.finish();
    AppMethodBeat.o(20999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiIntroductionUI.2
 * JD-Core Version:    0.7.0.1
 */