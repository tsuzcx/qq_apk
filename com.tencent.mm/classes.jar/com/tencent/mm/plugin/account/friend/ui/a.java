package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a iMe;
  
  public a(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.iMe = parama;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(131173);
    Object localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).iMg;
    final int j = ((b)localObject).position;
    localObject = ((k)g.ab(k.class)).awB().aNt(paramView);
    if (bs.isNullOrNil(((av)localObject).field_username)) {
      ((ai)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(131172);
        if (paramAnonymousBoolean1)
        {
          a.I(this.fzF);
          a.a(a.this).Gx(paramView);
          AppMethodBeat.o(131172);
          return;
        }
        a.a(a.this).ab(paramView, paramAnonymousBoolean2);
        AppMethodBeat.o(131172);
      }
    });
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).i(paramView, localLinkedList);
    AppMethodBeat.o(131173);
  }
  
  public static abstract interface a
  {
    public abstract void Gx(String paramString);
    
    public abstract void ab(String paramString, boolean paramBoolean);
  }
  
  public static final class b
  {
    public int iMg;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */