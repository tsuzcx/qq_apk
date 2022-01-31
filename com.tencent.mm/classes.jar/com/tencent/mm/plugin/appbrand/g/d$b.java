package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.so;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.sdk.platformtools.bo;

public final class d$b
  extends a.b
{
  public d$b(d paramd)
  {
    super(paramd);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(129970);
    paramContext = LayoutInflater.from(paramContext).inflate(2130968684, paramViewGroup, false);
    paramViewGroup = (d.a)this.hrS.hrO;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramViewGroup.hrP = ((TextView)paramContext.findViewById(2131821213));
    paramViewGroup.hrQ = ((TextView)paramContext.findViewById(2131821171));
    paramViewGroup.hrR = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(129970);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(129971);
    paramContext = (d)parama1;
    parama = (d.a)parama;
    m.p(parama.hrR, this.hrS.mTH);
    if (paramContext.hrM == null)
    {
      parama.contentView.setVisibility(8);
      AppMethodBeat.o(129971);
      return;
    }
    parama.contentView.setVisibility(0);
    parama.gpL.setText(this.hrS.elh);
    parama1 = com.tencent.mm.plugin.appbrand.appcache.b.nj(this.hrS.hrM.gXd);
    if (bo.isNullOrNil(parama1)) {
      parama.hrQ.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.acD().a(parama.egq, paramContext.hrM.hcc, com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
      AppMethodBeat.o(129971);
      return;
      parama.hrQ.setText(parama1);
      parama.hrQ.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(129972);
    paramContext = (d)paramVarArgs;
    paramVarArgs = new so();
    paramVarArgs.cIQ.userName = paramContext.hrM.cmx;
    paramVarArgs.cIQ.cIT = paramContext.hrM.gXd;
    paramVarArgs.cIQ.cIW = true;
    paramVarArgs.cIQ.scene = 1027;
    com.tencent.mm.sdk.b.a.ymk.l(paramVarArgs);
    AppMethodBeat.o(129972);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.d.b
 * JD-Core Version:    0.7.0.1
 */