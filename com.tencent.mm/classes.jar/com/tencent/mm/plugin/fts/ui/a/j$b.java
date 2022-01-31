package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.d.a.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.m;

public final class j$b
  extends a.b
{
  public j$b(j paramj)
  {
    super(paramj);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62000);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969650, paramViewGroup, false);
    paramViewGroup = (j.a)this.mZp.mZo;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62000);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62001);
    parama = (j.a)parama;
    parama1 = (j)parama1;
    m.q(parama.contentView, this.mZp.mTH);
    m.a(this.mZp.mBF, parama.gpL);
    m.a(this.mZp.mZk, parama.gpM);
    m.a(paramContext, parama.egq, null, parama1.mBI, 2131231371);
    AppMethodBeat.o(62001);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    AppMethodBeat.i(62002);
    boolean bool = ((n)g.G(n.class)).getItemClickHandler(this.mZp.kwo).a(paramContext, paramVarArgs);
    AppMethodBeat.o(62002);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j.b
 * JD-Core Version:    0.7.0.1
 */