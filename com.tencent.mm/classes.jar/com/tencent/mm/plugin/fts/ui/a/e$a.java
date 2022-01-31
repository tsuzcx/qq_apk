package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;

public final class e$a
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public e$a(e parame)
  {
    super(parame);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61978);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969651, paramViewGroup, false);
    paramViewGroup = (e.b)this.mYJ.mYI;
    paramViewGroup.kHN = ((TextView)paramContext.findViewById(2131822836));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramViewGroup.mYK = paramContext.findViewById(2131820910);
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(61978);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61979);
    paramContext = (e.b)parama;
    m.a(this.mYJ.mZq, paramContext.kHN);
    paramContext.contentView.setBackgroundResource(2130839285);
    com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.egq, this.mYJ.talker);
    if (this.mYJ.position == 0)
    {
      paramContext.mYK.setVisibility(8);
      AppMethodBeat.o(61979);
      return;
    }
    paramContext.mYK.setVisibility(0);
    AppMethodBeat.o(61979);
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.e.a
 * JD-Core Version:    0.7.0.1
 */