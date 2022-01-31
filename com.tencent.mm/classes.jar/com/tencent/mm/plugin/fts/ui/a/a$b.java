package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.m;

public final class a$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public a$b(a parama)
  {
    super(parama);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61968);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969675, paramViewGroup, false);
    paramViewGroup = new a.a(this.mYt);
    paramViewGroup.ivs = ((ImageView)paramContext.findViewById(2131821253));
    paramViewGroup.mYs = ((TextView)paramContext.findViewById(2131821071));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(61968);
    return paramContext;
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a.a parama, com.tencent.mm.plugin.fts.a.d.a.a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61969);
    paramContext = (a.a)parama;
    m.q(paramContext.contentView, this.mYt.mTH);
    m.a(this.mYt.mYp, paramContext.mYs);
    paramContext.ivs.setImageResource(2131231945);
    AppMethodBeat.o(61969);
  }
  
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */