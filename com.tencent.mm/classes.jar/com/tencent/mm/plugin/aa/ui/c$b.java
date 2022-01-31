package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.contact.a.a.a;

public final class c$b
  extends com.tencent.mm.ui.contact.a.a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final boolean VB()
  {
    return false;
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    if (com.tencent.mm.cb.a.fh(paramContext)) {}
    for (paramViewGroup = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem_large, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem, paramViewGroup, false))
    {
      c.a locala = (c.a)this.eXR.eXN;
      locala.doU = ((ImageView)paramViewGroup.findViewById(a.f.avatar_iv));
      locala.eXO = ((TextView)paramViewGroup.findViewById(a.f.title_tv));
      locala.eXP = ((TextView)paramViewGroup.findViewById(a.f.desc_tv));
      locala.contentView = paramViewGroup.findViewById(a.f.select_item_content_layout);
      locala.eXQ = ((CheckBox)paramViewGroup.findViewById(a.f.select_cb));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)locala.eXQ.getLayoutParams();
      localLayoutParams.leftMargin = paramContext.getResources().getDimensionPixelSize(a.d.aa_select_contact_cb_left_margin);
      localLayoutParams.rightMargin = paramContext.getResources().getDimensionPixelSize(a.d.aa_select_contact_cb_right_margin);
      locala.eXQ.setLayoutParams(localLayoutParams);
      paramViewGroup.setTag(locala);
      return paramViewGroup;
    }
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    parama = (c.a)parama;
    parama1 = (c)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.doU, parama1.username);
      if (bk.L(parama1.eXK)) {
        break label202;
      }
      parama.eXO.setText(parama1.eXK);
      parama.eXO.setVisibility(0);
      label67:
      if (bk.L(parama1.eXL)) {
        break label214;
      }
      parama.eXP.setText(parama1.eXL);
      parama.eXP.setVisibility(0);
      label96:
      if (!this.eXR.vLJ) {
        break label246;
      }
      if (!paramBoolean1) {
        break label226;
      }
      parama.eXQ.setChecked(true);
      parama.eXQ.setEnabled(false);
      label127:
      parama.eXQ.setVisibility(0);
      label135:
      if (!this.eXR.icY) {
        break label258;
      }
      parama.contentView.setBackgroundResource(a.e.comm_list_item_selector_no_divider);
    }
    for (;;)
    {
      if (parama1.dnp.field_deleteFlag == 1)
      {
        parama.eXP.setVisibility(0);
        parama.eXP.setText(paramContext.getString(a.i.aa_address_account_deleted));
      }
      return;
      parama.doU.setImageResource(a.e.default_avatar);
      break;
      label202:
      parama.eXO.setVisibility(8);
      break label67;
      label214:
      parama.eXP.setVisibility(8);
      break label96;
      label226:
      parama.eXQ.setChecked(paramBoolean2);
      parama.eXQ.setEnabled(true);
      break label127;
      label246:
      parama.eXQ.setVisibility(8);
      break label135;
      label258:
      parama.contentView.setBackgroundResource(a.e.comm_list_item_selector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c.b
 * JD-Core Version:    0.7.0.1
 */