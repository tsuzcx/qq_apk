package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern ibV;
  public CharSequence ibW;
  public CharSequence ibX;
  private b ibY;
  a ibZ;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    ibV = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.ibY = new b();
    this.ibZ = new a();
    AppMethodBeat.o(63526);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(63527);
    if (this.contact == null)
    {
      ad.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(63527);
      return;
    }
    this.username = this.contact.field_username;
    if (bt.isNullOrNil(this.dec)) {}
    for (parama = ((b)g.ab(b.class)).b(this.contact);; parama = ((b)g.ab(b.class)).getDisplayName(this.contact.field_username, this.dec))
    {
      Object localObject = parama;
      if (u.aqG().equals(this.username)) {
        localObject = parama + paramContext.getString(2131755057);
      }
      this.ibW = k.b(paramContext, (CharSequence)localObject, com.tencent.mm.cd.a.ao(paramContext, 2131165517));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aHr()
  {
    return this.ibY;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public CheckBox icb;
    
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
      if (com.tencent.mm.cd.a.hS(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.ibZ;
        paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.icb = ((CheckBox)paramContext.findViewById(2131304502));
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
      int i;
      if ((parama1.username != null) && (parama1.username.length() > 0))
      {
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.frr, parama1.username, 0.1F, false);
        if (bt.ai(parama1.ibW)) {
          break label235;
        }
        parama.ica.setText(parama1.ibW);
        parama.ica.setVisibility(0);
        if (bt.ai(parama1.ibX)) {
          break label247;
        }
        parama.hJe.setText(parama1.ibX);
        parama.hJe.setVisibility(0);
        if (!c.this.GVT) {
          break label286;
        }
        if (!paramBoolean1) {
          break label266;
        }
        parama.icb.setChecked(true);
        parama.icb.setEnabled(false);
        CheckBox localCheckBox = parama.icb;
        if (!ai.Eq()) {
          break label259;
        }
        i = 2131689939;
        label151:
        localCheckBox.setBackgroundResource(i);
        label158:
        parama.icb.setVisibility(0);
        label166:
        if (!c.this.mUe) {
          break label298;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.hJe.setVisibility(0);
          parama.hJe.setText(paramContext.getString(2131755020));
        }
        AppMethodBeat.o(63525);
        return;
        parama.frr.setImageResource(2131231875);
        break;
        label235:
        parama.ica.setVisibility(8);
        break label75;
        label247:
        parama.hJe.setVisibility(8);
        break label104;
        label259:
        i = 2131689938;
        break label151;
        label266:
        parama.icb.setChecked(paramBoolean2);
        parama.icb.setEnabled(true);
        break label158;
        label286:
        parama.icb.setVisibility(8);
        break label166;
        label298:
        parama.contentView.setBackgroundResource(2131231818);
      }
    }
    
    public final boolean aHs()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */