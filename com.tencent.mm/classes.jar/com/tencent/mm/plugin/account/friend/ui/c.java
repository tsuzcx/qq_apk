package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;

public final class c
  implements View.OnClickListener
{
  private Context context;
  private c.a gzo;
  
  public c(Context paramContext, c.a parama)
  {
    this.context = paramContext;
    this.gzo = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108570);
    paramView = (c.b)paramView.getTag();
    String str = paramView.gzq;
    int i = paramView.position;
    int j = p.cU(str);
    new g(this.context, new c.1(this, i)).o(new int[] { j });
    AppMethodBeat.o(108570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.c
 * JD-Core Version:    0.7.0.1
 */