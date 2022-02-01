package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a ilY;
  
  public a(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.ilY = parama;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(131173);
    Object localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).ima;
    final int j = ((b)localObject).position;
    localObject = ((k)g.ab(k.class)).apM().aHY(paramView);
    if (bt.isNullOrNil(((au)localObject).field_username)) {
      ((af)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a()
    {
      public final void a(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(131172);
        if (paramAnonymousBoolean1)
        {
          a.H(this.fvY);
          a.a(a.this).Cu(paramView);
          AppMethodBeat.o(131172);
          return;
        }
        a.a(a.this).aa(paramView, paramAnonymousBoolean2);
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
    public abstract void Cu(String paramString);
    
    public abstract void aa(String paramString, boolean paramBoolean);
  }
  
  public static final class b
  {
    public int ima;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */