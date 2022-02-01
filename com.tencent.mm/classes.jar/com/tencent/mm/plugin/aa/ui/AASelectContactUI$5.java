package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;

final class AASelectContactUI$5
  implements Runnable
{
  AASelectContactUI$5(AASelectContactUI paramAASelectContactUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(268565);
    AASelectContactUI.j(this.pJW).findViewById(a.f.contact_multiselect).findViewById(a.f.mutiselectcontact_edittext).sendAccessibilityEvent(128);
    AppMethodBeat.o(268565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AASelectContactUI.5
 * JD-Core Version:    0.7.0.1
 */