package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.ui.MMActivity;

final class c$b
  implements View.OnClickListener
{
  private String id;
  
  public c$b(c paramc, String paramString)
  {
    this.id = paramString;
  }
  
  public final void onClick(View paramView)
  {
    paramView = h.bhd().GS(this.id);
    Intent localIntent = new Intent(c.a(this.mbl), MassSendMsgUI.class);
    localIntent.putExtra("mass_send_contact_list", paramView.bgY());
    localIntent.putExtra("mass_send_again", true);
    c.a(this.mbl).startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.c.b
 * JD-Core Version:    0.7.0.1
 */