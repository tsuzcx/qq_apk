package com.tencent.mm.plugin.appbrand.game.b;

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
import com.tencent.mm.sdk.platformtools.bo;

public final class c$b
  extends a.b
{
  public c$b(c paramc)
  {
    super(paramc);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(130077);
    paramContext = LayoutInflater.from(paramContext).inflate(2130970136, paramViewGroup, false);
    paramViewGroup = (c.a)this.hsJ.hsH;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramViewGroup.hrP = ((TextView)paramContext.findViewById(2131821213));
    paramViewGroup.hsI = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.hrQ = ((TextView)paramContext.findViewById(2131821171));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(130077);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(130078);
    paramContext = (c)parama1;
    parama = (c.a)parama;
    if (paramContext.hsF == null)
    {
      parama.contentView.setVisibility(8);
      AppMethodBeat.o(130078);
      return;
    }
    parama.contentView.setVisibility(0);
    parama.gpL.setText(this.hsJ.elh);
    parama.hrQ.setVisibility(8);
    parama.hsI.setVisibility(8);
    parama.hrP.setVisibility(8);
    if (paramContext.hsE != null)
    {
      parama1 = com.tencent.mm.plugin.appbrand.appcache.b.nj(paramContext.hsE.gXd);
      if (bo.isNullOrNil(parama1)) {
        parama.hrQ.setVisibility(8);
      }
    }
    for (;;)
    {
      com.tencent.mm.modelappbrand.a.b.acD().a(parama.egq, paramContext.hsF.field_IconUrl, com.tencent.mm.modelappbrand.a.a.acC(), f.fqU);
      AppMethodBeat.o(130078);
      return;
      parama.hrQ.setText(parama1);
      parama.hrQ.setVisibility(0);
      continue;
      parama1 = paramContext.hsF.field_BriefIntro;
      if (bo.isNullOrNil(parama1))
      {
        parama.hsI.setVisibility(8);
      }
      else
      {
        parama.hsI.setText(parama1);
        parama.hsI.setVisibility(0);
      }
    }
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(130079);
    paramContext = (c)paramVarArgs;
    paramVarArgs = new so();
    paramVarArgs.cIQ.userName = paramContext.hsF.field_UserName;
    paramVarArgs.cIQ.cIT = 0;
    if (paramContext.hsE != null) {
      paramVarArgs.cIQ.cIT = paramContext.hsE.gXd;
    }
    paramVarArgs.cIQ.cIW = true;
    paramVarArgs.cIQ.scene = 1027;
    com.tencent.mm.sdk.b.a.ymk.l(paramVarArgs);
    AppMethodBeat.o(130079);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.c.b
 * JD-Core Version:    0.7.0.1
 */