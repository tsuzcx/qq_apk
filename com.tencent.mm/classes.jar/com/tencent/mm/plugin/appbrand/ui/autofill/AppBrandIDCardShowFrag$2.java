package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AppBrandIDCardShowFrag$2
  implements CompoundButton.OnCheckedChangeListener
{
  AppBrandIDCardShowFrag$2(AppBrandIDCardShowFrag paramAppBrandIDCardShowFrag) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(133203);
    if (AppBrandIDCardShowFrag.b(this.iQn) != null) {
      AppBrandIDCardShowFrag.b(this.iQn).setEnabled(paramBoolean);
    }
    AppMethodBeat.o(133203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag.2
 * JD-Core Version:    0.7.0.1
 */