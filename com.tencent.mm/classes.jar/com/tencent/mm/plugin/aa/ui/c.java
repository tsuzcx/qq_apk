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
import com.tencent.mm.f.c.ax;
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
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern mMX;
  public CharSequence kLX;
  public CharSequence mMY;
  private b mMZ;
  a mNa;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    mMX = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.mMZ = new b();
    this.mNa = new a();
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
    if (Util.isNullOrNil(this.fxT)) {}
    for (parama = ((b)h.ae(b.class)).b(this.contact);; parama = ((b)h.ae(b.class)).aL(this.contact.field_username, this.fxT))
    {
      Object localObject = parama;
      if (z.bcZ().equals(this.username)) {
        localObject = parama + paramContext.getString(a.i.aa_myself_note);
      }
      this.mMY = l.d(paramContext, (CharSequence)localObject, com.tencent.mm.ci.a.aY(paramContext, a.d.NormalTextSize));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bwF()
  {
    return this.mMZ;
  }
  
  public final a.a bwG()
  {
    return this.mNa;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView iZG;
    public TextView mNb;
    public TextView mNc;
    public CheckBox mNd;
    public TextView mrM;
    
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
      if (com.tencent.mm.ci.a.ko(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem_large, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(a.g.select_ui_listcontactitem, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.mNa;
        paramViewGroup.iZG = ((ImageView)paramContext.findViewById(a.f.avatar_iv));
        paramViewGroup.mNb = ((TextView)paramContext.findViewById(a.f.title_tv));
        paramViewGroup.mrM = ((TextView)paramContext.findViewById(a.f.desc_tv));
        paramViewGroup.contentView = paramContext.findViewById(a.f.select_item_content_layout);
        paramViewGroup.mNd = ((CheckBox)paramContext.findViewById(a.f.select_cb));
        paramViewGroup.mNc = ((TextView)paramContext.findViewById(a.f.tip_tv));
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.iZG, parama1.username, 0.1F, false);
        if (Util.isNullOrNil(parama1.mMY)) {
          break label421;
        }
        parama.mNb.setText(parama1.mMY);
        parama.mNb.setVisibility(0);
        parama.mNb.setSingleLine(false);
        if (Util.isNullOrNil(parama1.kLX)) {
          break label433;
        }
        parama.mrM.setText(parama1.kLX);
        parama.mrM.setVisibility(0);
        if (!c.this.XsX) {
          break label473;
        }
        if (!paramBoolean1) {
          break label453;
        }
        parama.mNd.setChecked(true);
        parama.mNd.setEnabled(false);
        localObject = parama.mNd;
        if (!ar.isDarkMode()) {
          break label445;
        }
        i = a.h.checkbox_selected_grey_dark;
        label160:
        ((CheckBox)localObject).setBackgroundResource(i);
        label167:
        parama.mNd.setVisibility(0);
        label175:
        if (!c.this.sxA) {
          break label485;
        }
        parama.contentView.setBackgroundResource(a.e.comm_list_item_selector_no_divider);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.mrM.setVisibility(0);
          parama.mrM.setText(paramContext.getString(a.i.aa_address_account_deleted));
        }
        if (!as.bvK(parama1.username)) {
          break label498;
        }
        parama.mNb.setAlpha(0.3F);
        parama.mrM.setAlpha(0.3F);
        parama.mNd.setChecked(false);
        parama.mNd.setEnabled(false);
        parama.mNd.setOnClickListener(null);
        parama.mNd.setOnTouchListener(null);
        parama.iZG.setAlpha(0.3F);
        localObject = com.tencent.mm.openim.room.a.a.V(((n)h.ae(n.class)).bbL().RG(parama1.username));
        parama.mNc.setVisibility(0);
        parama.mNc.setText((CharSequence)localObject);
        parama.mNc.setTextSize(12.0F);
        parama.mNc.setTextColor(paramContext.getResources().getColor(a.c.orange_100));
        parama.mNc.setAlpha(0.3F);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", new Object[] { parama1.username, localObject });
        AppMethodBeat.o(63525);
        return;
        parama.iZG.setImageResource(a.e.default_avatar);
        break;
        label421:
        parama.mNb.setVisibility(8);
        break label83;
        label433:
        parama.mrM.setVisibility(8);
        break label112;
        label445:
        i = a.h.checkbox_selected_grey;
        break label160;
        label453:
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
        break label167;
        label473:
        parama.mNd.setVisibility(8);
        break label175;
        label485:
        parama.contentView.setBackgroundResource(a.e.aa_seletct_contact_ui_item_selector);
      }
      label498:
      parama.mNb.setAlpha(1.0F);
      parama.mrM.setAlpha(1.0F);
      if (c.this.XsX) {
        if (paramBoolean1)
        {
          parama.mNd.setChecked(true);
          parama.mNd.setEnabled(false);
          paramContext = parama.mNd;
          if (ar.isDarkMode())
          {
            i = a.h.checkbox_selected_grey_dark;
            paramContext.setBackgroundResource(i);
            label567:
            parama.mNd.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama.iZG.setAlpha(1.0F);
        parama.mNc.setVisibility(4);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s", new Object[] { parama1.username });
        AppMethodBeat.o(63525);
        return;
        i = a.h.checkbox_selected_grey;
        break;
        parama.mNd.setChecked(paramBoolean2);
        parama.mNd.setEnabled(true);
        break label567;
        parama.mNd.setVisibility(8);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, com.tencent.mm.ui.contact.a.a parama)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */