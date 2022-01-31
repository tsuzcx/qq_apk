package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class m$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public m$b(m paramm)
  {
    super(paramm);
  }
  
  public View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62013);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969672, paramViewGroup, false);
    paramViewGroup = (m.a)this.mZC.mZB;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.egr = ((TextView)paramContext.findViewById(2131823254));
    paramViewGroup.ekg = ((TextView)paramContext.findViewById(2131822982));
    paramViewGroup.ekh = ((TextView)paramContext.findViewById(2131821004));
    paramViewGroup.hrR = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62013);
    return paramContext;
  }
  
  public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62014);
    parama1 = (m)parama1;
    parama = (m.a)parama;
    com.tencent.mm.plugin.fts.ui.m.p(parama.hrR, this.mZC.mTH);
    com.tencent.mm.pluginsdk.ui.a.b.c(parama.egq, parama1.username);
    com.tencent.mm.plugin.fts.ui.m.a(parama1.gpI, parama.ekg);
    com.tencent.mm.plugin.fts.ui.m.a(parama1.mZz, parama.ekh);
    if (t.nK(parama1.username))
    {
      com.tencent.mm.plugin.fts.ui.m.a(((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(paramContext, parama1.gpH), parama.egr);
      AppMethodBeat.o(62014);
      return;
    }
    if (ad.arf(parama1.username))
    {
      g.RM();
      paramContext = ((j)g.E(j.class)).YA().arw(parama1.username);
      ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(parama.egr.getContext(), parama.egr, parama1.gpH, paramContext.field_openImAppid, paramContext.field_descWordingId, (int)parama.egr.getTextSize());
      AppMethodBeat.o(62014);
      return;
    }
    com.tencent.mm.plugin.fts.ui.m.a(parama1.gpH, parama.egr);
    AppMethodBeat.o(62014);
  }
  
  public boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(62015);
    boolean bool = ((n)g.G(n.class)).getItemClickHandler(this.mZC.kwo).a(paramContext, paramVarArgs);
    AppMethodBeat.o(62015);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.m.b
 * JD-Core Version:    0.7.0.1
 */