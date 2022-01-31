package com.tencent.mm.plugin.address.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.bk;

final class AddrEditView$4
  implements View.OnClickListener
{
  AddrEditView$4(AddrEditView paramAddrEditView) {}
  
  public final void onClick(View paramView)
  {
    if (AddrEditView.f(this.fuv).getVisibility() == 0)
    {
      if ((!this.fuv.fun) || (AddrEditView.d(this.fuv) == 2) || (bk.bl(this.fuv.getText()))) {
        break label77;
      }
      this.fuv.fuh.setText("");
      AddrEditView.b(this.fuv, AddrEditView.e(this.fuv).isFocused());
    }
    label77:
    while (AddrEditView.g(this.fuv) == null) {
      return;
    }
    AddrEditView.g(this.fuv).onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView.4
 * JD-Core Version:    0.7.0.1
 */