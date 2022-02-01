package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public final class c
  implements View.OnClickListener
{
  private Context context;
  private a pUP;
  
  public c(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.pUP = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(131231);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    a.c("com/tencent/mm/plugin/account/friend/ui/InviteContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    paramView = (b)paramView.getTag();
    localObject = paramView.pUR;
    final int i = paramView.position;
    int j = p.hw((String)localObject);
    new g(this.context, new g.a()
    {
      public final void y(boolean paramAnonymousBoolean, String paramAnonymousString)
      {
        AppMethodBeat.i(131230);
        c.a(c.this).hO(paramAnonymousBoolean);
        AppMethodBeat.o(131230);
      }
    }).v(new int[] { j });
    a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131231);
  }
  
  public static abstract interface a
  {
    public abstract void hO(boolean paramBoolean);
  }
  
  public static final class b
  {
    public String pUR;
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.c
 * JD-Core Version:    0.7.0.1
 */