package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;

public final class c
  implements View.OnClickListener
{
  private Context context;
  private a imx;
  
  public c(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.imx = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131231);
    paramView = (b)paramView.getTag();
    String str = paramView.imz;
    final int i = paramView.position;
    int j = p.dG(str);
    new g(this.context, new g.a()
    {
      public final void f(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(131230);
        c.a(c.this).eU(paramAnonymousBoolean);
        AppMethodBeat.o(131230);
      }
    }).q(new int[] { j });
    AppMethodBeat.o(131231);
  }
  
  public static abstract interface a
  {
    public abstract void eU(boolean paramBoolean);
  }
  
  public static final class b
  {
    public String imz;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.c
 * JD-Core Version:    0.7.0.1
 */