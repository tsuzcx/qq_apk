package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  implements View.OnClickListener
{
  c$1(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(21995);
    if ((paramView.getTag() instanceof Integer))
    {
      int i = ((Integer)paramView.getTag()).intValue();
      paramView = this.nRg.xM(i);
      Intent localIntent = new Intent(c.a(this.nRg), IPCallUserProfileUI.class);
      localIntent.putExtra("IPCallProfileUI_contactid", paramView.field_contactId);
      localIntent.putExtra("IPCallProfileUI_systemUsername", paramView.field_systemAddressBookUsername);
      localIntent.putExtra("IPCallProfileUI_wechatUsername", paramView.field_wechatUsername);
      c.b(this.nRg).startActivity(localIntent);
    }
    AppMethodBeat.o(21995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.c.1
 * JD-Core Version:    0.7.0.1
 */