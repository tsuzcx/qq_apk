package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;

public final class p$a
  extends m.b
{
  public p$a(p paramp)
  {
    super(paramp);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62026);
    paramViewGroup = LayoutInflater.from(paramContext).inflate(2130969672, paramViewGroup, false);
    m.a locala = (m.a)this.mZK.mZB;
    locala.egq = ((ImageView)paramViewGroup.findViewById(2131821210));
    locala.egr = ((TextView)paramViewGroup.findViewById(2131823254));
    locala.ekg = ((TextView)paramViewGroup.findViewById(2131822982));
    locala.hrR = paramViewGroup.findViewById(2131821148);
    locala.ekh = ((TextView)paramViewGroup.findViewById(2131821004));
    locala.egq.getLayoutParams().width = com.tencent.mm.cb.a.ao(paramContext, 2131427844);
    locala.egq.getLayoutParams().height = com.tencent.mm.cb.a.ao(paramContext, 2131427844);
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(62026);
    return paramViewGroup;
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(62027);
    boolean bool = ((n)g.G(n.class)).getItemClickHandler(this.mZK.kwo).a(paramContext, paramVarArgs);
    AppMethodBeat.o(62027);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.p.a
 * JD-Core Version:    0.7.0.1
 */