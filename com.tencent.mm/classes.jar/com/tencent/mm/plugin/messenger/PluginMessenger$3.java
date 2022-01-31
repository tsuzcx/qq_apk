package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.ui.e.b;

final class PluginMessenger$3
  implements View.OnClickListener
{
  PluginMessenger$3(PluginMessenger paramPluginMessenger, String paramString1, String paramString2, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136877);
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.fwC);
    paramView.putExtra(e.b.yUZ, this.oCL);
    d.b(this.val$context, "profile", ".ui.ContactInfoUI", paramView, 0);
    AppMethodBeat.o(136877);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.3
 * JD-Core Version:    0.7.0.1
 */