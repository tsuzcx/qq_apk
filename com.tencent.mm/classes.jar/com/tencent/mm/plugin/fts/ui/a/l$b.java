package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;

public final class l$b
  extends a.b
{
  public l$b(l paraml)
  {
    super(paraml);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62009);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969662, paramViewGroup, false);
    paramViewGroup = (l.a)this.mZx.mZw;
    paramViewGroup.mYX = ((TextView)paramContext.findViewById(2131824340));
    paramViewGroup.mYK = paramContext.findViewById(2131820910);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62009);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62010);
    paramContext = (l.a)parama;
    m.a(this.mZx.mZu, paramContext.mYX);
    if (this.mZx.position == 0)
    {
      paramContext.mYK.setVisibility(8);
      AppMethodBeat.o(62010);
      return;
    }
    paramContext.mYK.setVisibility(0);
    AppMethodBeat.o(62010);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.l.b
 * JD-Core Version:    0.7.0.1
 */