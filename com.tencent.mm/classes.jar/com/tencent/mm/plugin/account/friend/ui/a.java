package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a.a gyP;
  
  public a(Context paramContext, a.a parama)
  {
    this.context = paramContext;
    this.gyP = parama;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(108512);
    Object localObject = (a.b)paramView.getTag();
    paramView = ((a.b)localObject).username;
    int i = ((a.b)localObject).gyR;
    int j = ((a.b)localObject).position;
    localObject = ((j)g.E(j.class)).YA().arw(paramView);
    if (bo.isNullOrNil(((aq)localObject).field_username)) {
      ((ad)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new a.1(this, (ad)localObject, j, paramView));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).e(paramView, localLinkedList);
    AppMethodBeat.o(108512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */