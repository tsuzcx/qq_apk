package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bo;

public final class g$a
  extends m.b
{
  public g$a(g paramg)
  {
    super(paramg);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61986);
    paramViewGroup = LayoutInflater.from(paramContext).inflate(2130969672, paramViewGroup, false);
    m.a locala = (m.a)this.mZa.mZB;
    locala.egq = ((ImageView)paramViewGroup.findViewById(2131821210));
    locala.egr = ((TextView)paramViewGroup.findViewById(2131823254));
    locala.ekg = ((TextView)paramViewGroup.findViewById(2131822982));
    locala.hrR = paramViewGroup.findViewById(2131821148);
    locala.ekh = ((TextView)paramViewGroup.findViewById(2131821004));
    locala.egq.getLayoutParams().width = com.tencent.mm.cb.a.ao(paramContext, 2131427844);
    locala.egq.getLayoutParams().height = com.tencent.mm.cb.a.ao(paramContext, 2131427844);
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(61986);
    return paramViewGroup;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61987);
    paramContext = (g)parama1;
    parama = (m.a)parama;
    com.tencent.mm.plugin.fts.ui.m.p(parama.hrR, this.mZa.mTH);
    if (bo.isNullOrNil(paramContext.hrL.talker)) {
      a.b.c(parama.egq, paramContext.hrL.mRV);
    }
    for (;;)
    {
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.mYZ, parama.egr);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.gpI, parama.ekg);
      com.tencent.mm.plugin.fts.ui.m.a(paramContext.mZz, parama.ekh);
      AppMethodBeat.o(61987);
      return;
      a.b.c(parama.egq, paramContext.hrL.talker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.g.a
 * JD-Core Version:    0.7.0.1
 */