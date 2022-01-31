package com.tencent.mm.plugin.base.stub;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WXEntryActivity$6
  implements View.OnClickListener
{
  WXEntryActivity$6(WXEntryActivity paramWXEntryActivity) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(153509);
    WXEntryActivity.e(this.jMo);
    this.jMo.finish();
    AppMethodBeat.o(153509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXEntryActivity.6
 * JD-Core Version:    0.7.0.1
 */