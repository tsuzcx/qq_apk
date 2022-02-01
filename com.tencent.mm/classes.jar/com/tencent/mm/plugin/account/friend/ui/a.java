package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a jfo;
  
  public a(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.jfo = parama;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(131173);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
    localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).jfq;
    final int j = ((b)localObject).position;
    localObject = ((l)g.ab(l.class)).azp().Bf(paramView);
    if (bt.isNullOrNil(((aw)localObject).field_username)) {
      ((am)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(131172);
        if (paramAnonymousBoolean1)
        {
          a.I(this.fSV);
          a.a(a.this).JM(paramView);
          AppMethodBeat.o(131172);
          return;
        }
        a.a(a.this).ab(paramView, paramAnonymousBoolean2);
        AppMethodBeat.o(131172);
      }
    });
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).h(paramView, localLinkedList);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131173);
  }
  
  public static abstract interface a
  {
    public abstract void JM(String paramString);
    
    public abstract void ab(String paramString, boolean paramBoolean);
  }
  
  public static final class b
  {
    public int jfq;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */