package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern pJF;
  public CharSequence nnT;
  public CharSequence pJG;
  private b pJH;
  a pJI;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    pJF = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.pJH = new b();
    this.pJI = new a();
    AppMethodBeat.o(63526);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(63527);
    if (this.contact == null)
    {
      Log.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(63527);
      return;
    }
    this.username = this.contact.field_username;
    if (Util.isNullOrNil(this.hCy)) {}
    for (parama = ((b)h.ax(b.class)).b(this.contact);; parama = ((b)h.ax(b.class)).aV(this.contact.field_username, this.hCy))
    {
      Object localObject = parama;
      if (z.bAM().equals(this.username)) {
        localObject = parama + paramContext.getString(a.i.aa_myself_note);
      }
      this.pJG = p.d(paramContext, (CharSequence)localObject, com.tencent.mm.cd.a.br(paramContext, a.d.NormalTextSize));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bVv()
  {
    return this.pJH;
  }
  
  public final a.a bVw()
  {
    return this.pJI;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView lBC;
    public TextView pJJ;
    public TextView pJK;
    public CheckBox pJL;
    public TextView plr;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends com.tencent.mm.ui.contact.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(63524);
      if (com.tencent.mm.cd.a.mp(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.pJI;
        paramViewGroup.lBC = ((ImageView)paramContext.findViewById(a.f.avatar_iv));
        paramViewGroup.pJJ = ((TextView)paramContext.findViewById(a.f.title_tv));
        paramViewGroup.plr = ((TextView)paramContext.findViewById(a.f.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(a.f.select_item_content_layout);
        paramViewGroup.pJL = ((CheckBox)paramContext.findViewById(a.f.select_cb));
        paramViewGroup.pJK = ((TextView)paramContext.findViewById(a.f.tip_tv));
        paramViewGroup.lBC.setImportantForAccessibility(2);
        paramContext.setTag(paramViewGroup);
        AppMethodBeat.o(63524);
        return paramContext;
      }
    }
    
    public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(63525);
      parama = (c.a)parama;
      parama1 = (c)parama1;
      label83:
      label112:
      Object localObject;
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.lBC, parama1.username, 0.1F, false);
        if (Util.isNullOrNil(parama1.pJG)) {
          break label421;
        }
        parama.pJJ.setText(parama1.pJG);
        parama.pJJ.setVisibility(0);
        parama.pJJ.setSingleLine(false);
        if (Util.isNullOrNil(parama1.nnT)) {
          break label433;
        }
        parama.plr.setText(parama1.nnT);
        parama.plr.setVisibility(0);
        if (!c.this.afey) {
          break label473;
        }
        if (!paramBoolean1) {
          break label453;
        }
        parama.pJL.setChecked(true);
        parama.pJL.setEnabled(false);
        localObject = parama.pJL;
        if (!aw.isDarkMode()) {
          break label445;
        }
        i = a.h.checkbox_selected_grey_dark;
        label160:
        ((CheckBox)localObject).setBackgroundResource(i);
        label167:
        parama.pJL.setVisibility(0);
        label175:
        if (!c.this.vDh) {
          break label485;
        }
        parama.contentView.setBackgroundResource(a.e.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.plr.setVisibility(0);
          parama.plr.setText(paramContext.getString(a.i.aa_address_account_deleted));
        }
        if (!au.bwO(parama1.username)) {
          break label498;
        }
        parama.pJJ.setAlpha(0.3F);
        parama.plr.setAlpha(0.3F);
        parama.pJL.setChecked(false);
        parama.pJL.setEnabled(false);
        parama.pJL.setOnClickListener(null);
        parama.pJL.setOnTouchListener(null);
        parama.lBC.setAlpha(0.3F);
        localObject = com.tencent.mm.openim.room.a.a.X(((n)h.ax(n.class)).bzA().JE(parama1.username));
        parama.pJK.setVisibility(0);
        parama.pJK.setText((CharSequence)localObject);
        parama.pJK.setTextSize(12.0F);
        parama.pJK.setTextColor(paramContext.getResources().getColor(a.c.orange_100));
        parama.pJK.setAlpha(0.3F);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", new Object[] { parama1.username, localObject });
        AppMethodBeat.o(63525);
        return;
        parama.lBC.setImageResource(a.e.default_avatar);
        break;
        label421:
        parama.pJJ.setVisibility(8);
        break label83;
        label433:
        parama.plr.setVisibility(8);
        break label112;
        label445:
        i = a.h.checkbox_selected_grey;
        break label160;
        label453:
        parama.pJL.setChecked(paramBoolean2);
        parama.pJL.setEnabled(true);
        break label167;
        label473:
        parama.pJL.setVisibility(8);
        break label175;
        label485:
        parama.contentView.setBackgroundResource(a.e.aa_seletct_contact_ui_item_selector);
      }
      label498:
      parama.pJJ.setAlpha(1.0F);
      parama.plr.setAlpha(1.0F);
      if (c.this.afey) {
        if (paramBoolean1)
        {
          parama.pJL.setChecked(true);
          parama.pJL.setEnabled(false);
          paramContext = parama.pJL;
          if (aw.isDarkMode())
          {
            i = a.h.checkbox_selected_grey_dark;
            paramContext.setBackgroundResource(i);
            label567:
            parama.pJL.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama.lBC.setAlpha(1.0F);
        parama.pJK.setVisibility(4);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s", new Object[] { parama1.username });
        AppMethodBeat.o(63525);
        return;
        i = a.h.checkbox_selected_grey;
        break;
        parama.pJL.setChecked(paramBoolean2);
        parama.pJL.setEnabled(true);
        break label567;
        parama.pJL.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */