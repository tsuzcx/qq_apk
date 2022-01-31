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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.a.a.a;

public final class c$b
  extends com.tencent.mm.ui.contact.a.a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(40743);
    if (com.tencent.mm.cb.a.gt(paramContext)) {}
    for (paramViewGroup = LayoutInflater.from(paramContext).inflate(2130970665, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramContext).inflate(2130970664, paramViewGroup, false))
    {
      c.a locala = (c.a)this.gpO.gpK;
      locala.egq = ((ImageView)paramViewGroup.findViewById(2131821210));
      locala.gpL = ((TextView)paramViewGroup.findViewById(2131821212));
      locala.gpM = ((TextView)paramViewGroup.findViewById(2131821007));
      locala.contentView = paramViewGroup.findViewById(2131826406);
      locala.gpN = ((CheckBox)paramViewGroup.findViewById(2131821631));
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)locala.gpN.getLayoutParams();
      localLayoutParams.leftMargin = paramContext.getResources().getDimensionPixelSize(2131427914);
      localLayoutParams.rightMargin = paramContext.getResources().getDimensionPixelSize(2131427915);
      locala.gpN.setLayoutParams(localLayoutParams);
      paramViewGroup.setTag(locala);
      AppMethodBeat.o(40743);
      return paramViewGroup;
    }
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.ui.contact.a.a parama1, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(40744);
    parama = (c.a)parama;
    parama1 = (c)parama1;
    if ((parama1.username != null) && (parama1.username.length() > 0))
    {
      com.tencent.mm.pluginsdk.ui.a.b.a(parama.egq, parama1.username, 0.1F, false);
      if (bo.aa(parama1.gpH)) {
        break label212;
      }
      parama.gpL.setText(parama1.gpH);
      parama.gpL.setVisibility(0);
      label75:
      if (bo.aa(parama1.gpI)) {
        break label224;
      }
      parama.gpM.setText(parama1.gpI);
      parama.gpM.setVisibility(0);
      label104:
      if (!this.gpO.Adl) {
        break label256;
      }
      if (!paramBoolean1) {
        break label236;
      }
      parama.gpN.setChecked(true);
      parama.gpN.setEnabled(false);
      label135:
      parama.gpN.setVisibility(0);
      label143:
      if (!this.gpO.jTN) {
        break label268;
      }
      parama.contentView.setBackgroundResource(2130838447);
    }
    for (;;)
    {
      if (parama1.contact.field_deleteFlag == 1)
      {
        parama.gpM.setVisibility(0);
        parama.gpM.setText(paramContext.getString(2131296340));
      }
      AppMethodBeat.o(40744);
      return;
      parama.egq.setImageResource(2130838493);
      break;
      label212:
      parama.gpL.setVisibility(8);
      break label75;
      label224:
      parama.gpM.setVisibility(8);
      break label104;
      label236:
      parama.gpN.setChecked(paramBoolean2);
      parama.gpN.setEnabled(true);
      break label135;
      label256:
      parama.gpN.setVisibility(8);
      break label143;
      label268:
      parama.contentView.setBackgroundResource(2130838445);
    }
  }
  
  public final boolean aoZ()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.c.b
 * JD-Core Version:    0.7.0.1
 */