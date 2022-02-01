package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a pUr;
  
  public a(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.pUr = parama;
  }
  
  public final void onClick(final View paramView)
  {
    AppMethodBeat.i(131173);
    Object localObject = new b();
    ((b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
    localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).pUt;
    final int j = ((b)localObject).position;
    localObject = ((n)h.ax(n.class)).bzA().JE(paramView);
    if (Util.isNullOrNil(((az)localObject).field_username)) {
      ((au)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a()
    {
      public final void canAddContact(boolean paramAnonymousBoolean1, boolean paramAnonymousBoolean2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(131172);
        if (paramAnonymousBoolean1)
        {
          a.Z(this.lMP);
          a.a(a.this).Ti(paramView);
          AppMethodBeat.o(131172);
          return;
        }
        a.a(a.this).al(paramView, paramAnonymousBoolean2);
        AppMethodBeat.o(131172);
      }
    });
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).i(paramView, localLinkedList);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/AddContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(131173);
  }
  
  public static abstract interface a
  {
    public abstract void Ti(String paramString);
    
    public abstract void al(String paramString, boolean paramBoolean);
  }
  
  public static final class b
  {
    public int pUt;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */