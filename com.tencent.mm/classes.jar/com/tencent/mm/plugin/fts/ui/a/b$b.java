package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.m;

public abstract class b$b
  extends com.tencent.mm.plugin.fts.a.d.a.a.b
{
  public b$b(b paramb)
  {
    super(paramb);
  }
  
  public final View a(Context paramContext, ViewGroup paramViewGroup)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2130969650, paramViewGroup, false);
    paramViewGroup = (b.a)this.mYx.mYv;
    paramViewGroup.egq = ((ImageView)paramContext.findViewById(2131821210));
    paramViewGroup.gpL = ((TextView)paramContext.findViewById(2131821212));
    paramViewGroup.gpM = ((TextView)paramContext.findViewById(2131821007));
    paramViewGroup.mYw = ((TextView)paramContext.findViewById(2131824337));
    paramViewGroup.hrR = paramContext.findViewById(2131821148);
    paramContext.setTag(paramViewGroup);
    return paramContext;
  }
  
  public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
  {
    paramContext = (b.a)parama;
    parama = (b)parama1;
    m.p(paramContext.hrR, this.mYx.mTH);
    com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.egq, parama.username);
    m.a(parama.jVn, paramContext.gpL);
    m.a(parama.jVo, paramContext.gpM);
    m.a(parama.mYu, paramContext.mYw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b.b
 * JD-Core Version:    0.7.0.1
 */