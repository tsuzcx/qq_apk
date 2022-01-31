package com.tencent.mm.plugin.freewifi.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class FreeWifiTestActivity$1
  implements View.OnClickListener
{
  FreeWifiTestActivity$1(FreeWifiTestActivity paramFreeWifiTestActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21108);
    Toast.makeText(ah.getContext(), "test message", 0).show();
    AppMethodBeat.o(21108);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.ui.FreeWifiTestActivity.1
 * JD-Core Version:    0.7.0.1
 */