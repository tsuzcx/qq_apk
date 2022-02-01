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
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern iCc;
  public CharSequence gIg;
  public CharSequence iCd;
  private b iCe;
  a iCf;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    iCc = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.iCe = new b();
    this.iCf = new a();
    AppMethodBeat.o(63526);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(63527);
    if (this.contact == null)
    {
      ac.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", new Object[] { Integer.valueOf(this.position) });
      AppMethodBeat.o(63527);
      return;
    }
    this.username = this.contact.field_username;
    if (bs.isNullOrNil(this.dby)) {}
    for (parama = ((b)g.ab(b.class)).b(this.contact);; parama = ((b)g.ab(b.class)).getDisplayName(this.contact.field_username, this.dby))
    {
      Object localObject = parama;
      if (u.axw().equals(this.username)) {
        localObject = parama + paramContext.getString(2131755057);
      }
      this.iCd = com.tencent.mm.pluginsdk.ui.span.k.b(paramContext, (CharSequence)localObject, com.tencent.mm.cc.a.au(paramContext, 2131165517));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b aOg()
  {
    return this.iCe;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView fuY;
    public TextView iCg;
    public TextView iCh;
    public CheckBox iCi;
    public TextView ijE;
    
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
      if (com.tencent.mm.cc.a.id(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131495360, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131495359, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.iCf;
        paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
        paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
        paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
        paramViewGroup.contentView = paramContext.findViewById(2131304518);
        paramViewGroup.iCi = ((CheckBox)paramContext.findViewById(2131304502));
        paramViewGroup.iCh = ((TextView)paramContext.findViewById(2131305880));
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.fuY, parama1.username, 0.1F, false);
        if (bs.aj(parama1.iCd)) {
          break label405;
        }
        parama.iCg.setText(parama1.iCd);
        parama.iCg.setVisibility(0);
        if (bs.aj(parama1.gIg)) {
          break label417;
        }
        parama.ijE.setText(parama1.gIg);
        parama.ijE.setVisibility(0);
        if (!c.this.Iwh) {
          break label457;
        }
        if (!paramBoolean1) {
          break label437;
        }
        parama.iCi.setChecked(true);
        parama.iCi.setEnabled(false);
        localObject = parama.iCi;
        if (!aj.DT()) {
          break label429;
        }
        i = 2131689939;
        label151:
        ((CheckBox)localObject).setBackgroundResource(i);
        label158:
        parama.iCi.setVisibility(0);
        label166:
        if (!c.this.nww) {
          break label469;
        }
        parama.contentView.setBackgroundResource(2131231820);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.ijE.setVisibility(0);
          parama.ijE.setText(paramContext.getString(2131755020));
        }
        if (!ai.aNc(parama1.username)) {
          break label482;
        }
        parama.iCg.setAlpha(0.3F);
        parama.ijE.setAlpha(0.3F);
        parama.iCi.setChecked(false);
        parama.iCi.setEnabled(false);
        parama.iCi.setOnClickListener(null);
        parama.iCi.setOnTouchListener(null);
        parama.fuY.setAlpha(0.3F);
        localObject = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(parama1.username));
        parama.iCh.setVisibility(0);
        parama.iCh.setText((CharSequence)localObject);
        parama.iCh.setTextSize(12.0F);
        parama.iCh.setTextColor(paramContext.getResources().getColor(2131100725));
        parama.iCh.setAlpha(0.3F);
        ac.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", new Object[] { parama1.username, localObject });
        AppMethodBeat.o(63525);
        return;
        parama.fuY.setImageResource(2131231875);
        break;
        label405:
        parama.iCg.setVisibility(8);
        break label75;
        label417:
        parama.ijE.setVisibility(8);
        break label104;
        label429:
        i = 2131689938;
        break label151;
        label437:
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
        break label158;
        label457:
        parama.iCi.setVisibility(8);
        break label166;
        label469:
        parama.contentView.setBackgroundResource(2131231137);
      }
      label482:
      parama.iCg.setAlpha(1.0F);
      parama.ijE.setAlpha(1.0F);
      if (c.this.Iwh) {
        if (paramBoolean1)
        {
          parama.iCi.setChecked(true);
          parama.iCi.setEnabled(false);
          paramContext = parama.iCi;
          if (aj.DT())
          {
            i = 2131689939;
            paramContext.setBackgroundResource(i);
            label550:
            parama.iCi.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama.fuY.setAlpha(1.0F);
        parama.iCh.setVisibility(4);
        ac.i("MicroMsg.ContactDataItem", "data.username：%s", new Object[] { parama1.username });
        AppMethodBeat.o(63525);
        return;
        i = 2131689938;
        break;
        parama.iCi.setChecked(paramBoolean2);
        parama.iCi.setEnabled(true);
        break label550;
        parama.iCi.setVisibility(8);
      }
    }
    
    public final boolean aOh()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */