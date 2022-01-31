package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.a.o;

public final class c
  implements View.OnClickListener
{
  private Context context;
  private c.a fhH;
  
  public c(Context paramContext, c.a parama)
  {
    this.context = paramContext;
    this.fhH = parama;
  }
  
  public final void onClick(View paramView)
  {
    paramView = (c.b)paramView.getTag();
    String str = paramView.fhJ;
    int i = paramView.position;
    int j = o.bS(str);
    new g(this.context, new c.1(this, i)).g(new int[] { j });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.c
 * JD-Core Version:    0.7.0.1
 */