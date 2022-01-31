package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.View.OnClickListener;

final class v$2
  implements View.OnClickListener
{
  v$2(v paramv) {}
  
  public final void onClick(View paramView)
  {
    if (paramView.isSelected())
    {
      v.asi().o(this.hvf);
      paramView.setSelected(false);
      return;
    }
    v.asi().p(this.hvf);
    paramView.setSelected(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.v.2
 * JD-Core Version:    0.7.0.1
 */