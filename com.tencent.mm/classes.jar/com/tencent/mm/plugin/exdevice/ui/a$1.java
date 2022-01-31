package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(20002);
    paramView = new Intent();
    paramView.putExtra("Contact_User", a.a(this.lNr));
    d.b(a.b(this.lNr), "profile", ".ui.ContactInfoUI", paramView);
    AppMethodBeat.o(20002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.1
 * JD-Core Version:    0.7.0.1
 */