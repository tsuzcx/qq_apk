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
  private a iMD;
  
  public c(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.iMD = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131231);
    paramView = (b)paramView.getTag();
    String str = paramView.iMF;
    final int i = paramView.position;
    int j = p.dv(str);
    new g(this.context, new g.a()
    {
      public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(131230);
        c.a(c.this).fo(paramAnonymousBoolean);
        AppMethodBeat.o(131230);
      }
    }).r(new int[] { j });
    AppMethodBeat.o(131231);
  }
  
  public static abstract interface a
  {
    public abstract void fo(boolean paramBoolean);
  }
  
  public static final class b
  {
    public String iMF;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.c
 * JD-Core Version:    0.7.0.1
 */