package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.ui.base.h;

final class m$1
  implements View.OnClickListener
{
  m$1(m paramm) {}
  
  public final void onClick(View paramView)
  {
    paramView = (String)paramView.getTag();
    if (!TextUtils.isEmpty(paramView))
    {
      if (!paramView.contains(";")) {
        break label88;
      }
      paramView = paramView.substring(0, paramView.indexOf(";"));
    }
    label88:
    for (;;)
    {
      h.a(m.a(this.ixp), true, paramView, "", m.a(this.ixp).getString(a.g.card_contact_info_dial), m.a(this.ixp).getString(a.g.confirm_dialog_cancel), new m.1.1(this, paramView), null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.m.1
 * JD-Core Version:    0.7.0.1
 */