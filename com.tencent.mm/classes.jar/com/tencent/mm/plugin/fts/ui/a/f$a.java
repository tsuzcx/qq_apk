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
import com.tencent.mm.sdk.platformtools.bo;

public class f$a
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public f$a(f paramf)
  {
    super(paramf);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(61982);
    paramContext = LayoutInflater.from(paramContext).inflate(2130969652, paramViewGroup, false);
    paramViewGroup = (f.b)this.mYS.mYR;
    paramViewGroup.mYT = ((TextView)paramContext.findViewById(2131824339));
    paramViewGroup.mYU = ((ImageView)paramContext.findViewById(2131824338));
    paramViewGroup.mYV = ((TextView)paramContext.findViewById(2131824342));
    paramViewGroup.mYW = ((ImageView)paramContext.findViewById(2131824341));
    paramViewGroup.mYX = ((TextView)paramContext.findViewById(2131824340));
    paramViewGroup.contentView = paramContext.findViewById(2131821209);
    paramViewGroup.mYK = paramContext.findViewById(2131820910);
    paramContext.setTag(paramViewGroup);
    AppMethodBeat.o(61982);
    return paramContext;
  }
  
  public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    AppMethodBeat.i(61983);
    paramContext = (f.b)parama;
    m.a(this.mYS.mYL, paramContext.mYT);
    com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.mYU, this.mYS.mYM);
    m.a(this.mYS.mYN, paramContext.mYV);
    if (!bo.isNullOrNil(this.mYS.mYO))
    {
      paramContext.mYW.setVisibility(0);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.mYW, this.mYS.mYO);
      m.r(paramContext.contentView, this.mYS.mTH);
      if (this.mYS.position != 0) {
        break label148;
      }
      paramContext.mYK.setVisibility(8);
    }
    for (;;)
    {
      paramContext.mYX.setVisibility(0);
      AppMethodBeat.o(61983);
      return;
      paramContext.mYW.setVisibility(8);
      break;
      label148:
      paramContext.mYK.setVisibility(0);
    }
  }
  
  public final boolean a(Context paramContext, a paramVarArgs)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f.a
 * JD-Core Version:    0.7.0.1
 */