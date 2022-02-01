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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern iYf;
  public CharSequence heE;
  public CharSequence iYg;
  private b iYh;
  a iYi;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    iYf = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.iYh = new b();
    this.iYi = new a();
    AppMethodBeat.o(63526);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(63527);
    if (this.contact == null)
    {
      ae.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(63527);
      return;
    }
    this.username = this.contact.field_username;
    if (bu.isNullOrNil(this.dnW)) {}
    for (parama = ((b)g.ab(b.class)).b(this.contact);; parama = ((b)g.ab(b.class)).getDisplayName(this.contact.field_username, this.dnW))
    {
      Object localObject = parama;
      if (v.aAC().equals(this.username)) {
        localObject = parama + paramContext.getString(2131755057);
      }
      this.iYg = k.b(paramContext, (CharSequence)localObject, com.tencent.mm.cb.a.ax(paramContext, 2131165517));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aRR()
  {
    return this.iYh;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    public TextView iYk;
    public CheckBox iYl;
    
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
      if (com.tencent.mm.cb.a.ir(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.iYi;
        paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iYl = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.iYk = ((TextView)paramContext.findViewById(2131305880));
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
      label75:
      label104:
      Object localObject;
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fQl, parama1.username, 0.1F, false);
        if (bu.ah(parama1.iYg)) {
          break label405;
        }
        parama.iYj.setText(parama1.iYg);
        parama.iYj.setVisibility(0);
        if (bu.ah(parama1.heE)) {
          break label417;
        }
        parama.iFO.setText(parama1.heE);
        parama.iFO.setVisibility(0);
        if (!c.this.KJj) {
          break label457;
        }
        if (!paramBoolean1) {
          break label437;
        }
        parama.iYl.setChecked(true);
        parama.iYl.setEnabled(false);
        localObject = parama.iYl;
        if (!al.isDarkMode()) {
          break label429;
        }
        i = 2131689939;
        label151:
        ((CheckBox)localObject).setBackgroundResource(i);
        label158:
        parama.iYl.setVisibility(0);
        label166:
        if (!c.this.odD) {
          break label469;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.iFO.setVisibility(0);
          parama.iFO.setText(paramContext.getString(2131755020));
        }
        if (!an.aUq(parama1.username)) {
          break label482;
        }
        parama.iYj.setAlpha(0.3F);
        parama.iFO.setAlpha(0.3F);
        parama.iYl.setChecked(false);
        parama.iYl.setEnabled(false);
        parama.iYl.setOnClickListener(null);
        parama.iYl.setOnTouchListener(null);
        parama.fQl.setAlpha(0.3F);
        localObject = com.tencent.mm.openim.room.a.a.O(((l)g.ab(l.class)).azF().BH(parama1.username));
        parama.iYk.setVisibility(0);
        parama.iYk.setText((CharSequence)localObject);
        parama.iYk.setTextSize(12.0F);
        parama.iYk.setTextColor(paramContext.getResources().getColor(2131100725));
        parama.iYk.setAlpha(0.3F);
        ae.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", new Object[] { parama1.username, localObject });
        AppMethodBeat.o(63525);
        return;
        parama.fQl.setImageResource(2131231875);
        break;
        label405:
        parama.iYj.setVisibility(8);
        break label75;
        label417:
        parama.iFO.setVisibility(8);
        break label104;
        label429:
        i = 2131689938;
        break label151;
        label437:
        parama.iYl.setChecked(paramBoolean2);
        parama.iYl.setEnabled(true);
        break label158;
        label457:
        parama.iYl.setVisibility(8);
        break label166;
        label469:
        parama.contentView.setBackgroundResource(2131231137);
      }
      label482:
      parama.iYj.setAlpha(1.0F);
      parama.iFO.setAlpha(1.0F);
      if (c.this.KJj) {
        if (paramBoolean1)
        {
          parama.iYl.setChecked(true);
          parama.iYl.setEnabled(false);
          paramContext = parama.iYl;
          if (al.isDarkMode())
          {
            i = 2131689939;
            paramContext.setBackgroundResource(i);
            label550:
            parama.iYl.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama.fQl.setAlpha(1.0F);
        parama.iYk.setVisibility(4);
        ae.i("MicroMsg.ContactDataItem", "data.username：%s", new Object[] { parama1.username });
        AppMethodBeat.o(63525);
        return;
        i = 2131689938;
        break;
        parama.iYl.setChecked(paramBoolean2);
        parama.iYl.setEnabled(true);
        break label550;
        parama.iYl.setVisibility(8);
      }
    }
    
    public final boolean aRS()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */