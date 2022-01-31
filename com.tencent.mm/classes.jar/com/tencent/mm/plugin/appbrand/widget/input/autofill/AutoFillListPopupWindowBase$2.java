package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class AutoFillListPopupWindowBase$2
  implements AdapterView.OnItemSelectedListener
{
  AutoFillListPopupWindowBase$2(AutoFillListPopupWindowBase paramAutoFillListPopupWindowBase) {}
  
  public final void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(123908);
    if (paramInt != -1)
    {
      paramAdapterView = AutoFillListPopupWindowBase.a(this.jpu);
      if (paramAdapterView != null) {
        AutoFillListPopupWindowBase.a.a(paramAdapterView, false);
      }
    }
    AppMethodBeat.o(123908);
  }
  
  public final void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase.2
 * JD-Core Version:    0.7.0.1
 */