package com.tencent.mm.plugin.messenger;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.ui.e.a;

final class PluginMessenger$2
  implements View.OnClickListener
{
  PluginMessenger$2(PluginMessenger paramPluginMessenger, String paramString1, String paramString2, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("Contact_User", this.egy);
    paramView.putExtra(e.a.uHO, this.mcj);
    d.b(this.val$context, "profile", ".ui.ContactInfoUI", paramView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.PluginMessenger.2
 * JD-Core Version:    0.7.0.1
 */