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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.contact.a.a.a;
import java.util.regex.Pattern;

public final class c
  extends com.tencent.mm.ui.contact.a.a
{
  private static final Pattern jVK;
  public CharSequence hXr;
  public CharSequence jVL;
  private b jVM;
  a jVN;
  public String username;
  
  static
  {
    AppMethodBeat.i(63528);
    jVK = Pattern.compile(",");
    AppMethodBeat.o(63528);
  }
  
  public c(int paramInt)
  {
    super(2, paramInt);
    AppMethodBeat.i(63526);
    this.jVM = new b();
    this.jVN = new a();
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
    if (Util.isNullOrNil(this.dFl)) {}
    for (parama = ((b)g.af(b.class)).b(this.contact);; parama = ((b)g.af(b.class)).getDisplayName(this.contact.field_username, this.dFl))
    {
      Object localObject = parama;
      if (z.aTY().equals(this.username)) {
        localObject = parama + paramContext.getString(2131755064);
      }
      this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(paramContext, (CharSequence)localObject, com.tencent.mm.cb.a.aG(paramContext, 2131165535));
      AppMethodBeat.o(63527);
      return;
    }
  }
  
  public final com.tencent.mm.ui.contact.a.a.b bmx()
  {
    return this.jVM;
  }
  
  public final class a
    extends a.a
  {
    public View contentView;
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    public TextView jVP;
    public CheckBox jVQ;
    
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
      if (com.tencent.mm.cb.a.jk(paramContext)) {}
      for (paramContext = LayoutInflater.from(paramContext).inflate(2131496221, paramViewGroup, false);; paramContext = LayoutInflater.from(paramContext).inflate(2131496220, paramViewGroup, false))
      {
        paramViewGroup = (c.a)c.this.jVN;
        paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
        paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
        paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
        paramViewGroup.contentView = paramContext.findViewById(2131307533);
        paramViewGroup.jVQ = ((CheckBox)paramContext.findViewById(2131307508));
        paramViewGroup.jVP = ((TextView)paramContext.findViewById(2131309163));
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
        com.tencent.mm.pluginsdk.ui.a.b.a(parama.gvv, parama1.username, 0.1F, false);
        if (Util.isNullOrNil(parama1.jVL)) {
          break label405;
        }
        parama.jVO.setText(parama1.jVL);
        parama.jVO.setVisibility(0);
        if (Util.isNullOrNil(parama1.hXr)) {
          break label417;
        }
        parama.jBR.setText(parama1.hXr);
        parama.jBR.setVisibility(0);
        if (!c.this.PWh) {
          break label457;
        }
        if (!paramBoolean1) {
          break label437;
        }
        parama.jVQ.setChecked(true);
        parama.jVQ.setEnabled(false);
        localObject = parama.jVQ;
        if (!ao.isDarkMode()) {
          break label429;
        }
        i = 2131689955;
        label151:
        ((CheckBox)localObject).setBackgroundResource(i);
        label158:
        parama.jVQ.setVisibility(0);
        label166:
        if (!c.this.poB) {
          break label469;
        }
        parama.contentView.setBackgroundResource(2131231901);
      }
      for (;;)
      {
        if (parama1.contact.field_deleteFlag == 1)
        {
          parama.jBR.setVisibility(0);
          parama.jBR.setText(paramContext.getString(2131755021));
        }
        if (!as.bjp(parama1.username)) {
          break label482;
        }
        parama.jVO.setAlpha(0.3F);
        parama.jBR.setAlpha(0.3F);
        parama.jVQ.setChecked(false);
        parama.jVQ.setEnabled(false);
        parama.jVQ.setOnClickListener(null);
        parama.jVQ.setOnTouchListener(null);
        parama.gvv.setAlpha(0.3F);
        localObject = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(parama1.username));
        parama.jVP.setVisibility(0);
        parama.jVP.setText((CharSequence)localObject);
        parama.jVP.setTextSize(12.0F);
        parama.jVP.setTextColor(paramContext.getResources().getColor(2131100919));
        parama.jVP.setAlpha(0.3F);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", new Object[] { parama1.username, localObject });
        AppMethodBeat.o(63525);
        return;
        parama.gvv.setImageResource(2131231957);
        break;
        label405:
        parama.jVO.setVisibility(8);
        break label75;
        label417:
        parama.jBR.setVisibility(8);
        break label104;
        label429:
        i = 2131689954;
        break label151;
        label437:
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
        break label158;
        label457:
        parama.jVQ.setVisibility(8);
        break label166;
        label469:
        parama.contentView.setBackgroundResource(2131230751);
      }
      label482:
      parama.jVO.setAlpha(1.0F);
      parama.jBR.setAlpha(1.0F);
      if (c.this.PWh) {
        if (paramBoolean1)
        {
          parama.jVQ.setChecked(true);
          parama.jVQ.setEnabled(false);
          paramContext = parama.jVQ;
          if (ao.isDarkMode())
          {
            i = 2131689955;
            paramContext.setBackgroundResource(i);
            label550:
            parama.jVQ.setVisibility(0);
          }
        }
      }
      for (;;)
      {
        parama.gvv.setAlpha(1.0F);
        parama.jVP.setVisibility(4);
        Log.i("MicroMsg.ContactDataItem", "data.username：%s", new Object[] { parama1.username });
        AppMethodBeat.o(63525);
        return;
        i = 2131689954;
        break;
        parama.jVQ.setChecked(paramBoolean2);
        parama.jVQ.setEnabled(true);
        break label550;
        parama.jVQ.setVisibility(8);
      }
    }
    
    public final boolean bmy()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c
 * JD-Core Version:    0.7.0.1
 */