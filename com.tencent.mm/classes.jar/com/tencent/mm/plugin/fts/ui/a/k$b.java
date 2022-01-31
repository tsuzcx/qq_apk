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

public final class k$b
  extends a.b
{
  public k$b(k paramk)
  {
    super(paramk);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(62005);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969661, paramViewGroup, false);
    paramViewGroup = (k.a)this.mZt.bCW();
    paramViewGroup.kHN = ((TextView)paramContext.findViewById(2131822836));
    paramViewGroup.mYK = paramContext.findViewById(2131820910);
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(62005);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(62006);
    paramContext = (k.a)parama;
    m.a(this.mZt.mZq, paramContext.kHN);
    if (this.mZt.position == 0) {
      paramContext.mYK.setVisibility(8);
    }
    for (;;)
    {
      m.r(paramContext.contentView, this.mZt.mTH);
      AppMethodBeat.o(62006);
      return;
      paramContext.mYK.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.k.b
 * JD-Core Version:    0.7.0.1
 */