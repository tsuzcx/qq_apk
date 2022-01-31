package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class AddrEditView$4
  implements View.OnClickListener
{
  AddrEditView$4(AddrEditView paramAddrEditView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(16808);
    if (AddrEditView.f(this.gLX).getVisibility() == 0)
    {
      if ((this.gLX.gLP) && (AddrEditView.d(this.gLX) != 2) && (!bo.isNullOrNil(this.gLX.getText())))
      {
        this.gLX.gLJ.setText("");
        AddrEditView.b(this.gLX, AddrEditView.e(this.gLX).isFocused());
        AppMethodBeat.o(16808);
        return;
      }
      if (AddrEditView.g(this.gLX) != null) {
        AddrEditView.g(this.gLX).onClick();
      }
    }
    AppMethodBeat.o(16808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView.4
 * JD-Core Version:    0.7.0.1
 */