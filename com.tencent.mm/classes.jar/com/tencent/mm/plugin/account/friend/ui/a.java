package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.LinkedList;

public final class a
  implements View.OnClickListener
{
  private Context context;
  private a fhh;
  
  public a(Context paramContext, a parama)
  {
    this.context = paramContext;
    this.fhh = parama;
  }
  
  public final void onClick(View paramView)
  {
    Object localObject = (b)paramView.getTag();
    paramView = ((b)localObject).username;
    int i = ((b)localObject).fhj;
    int j = ((b)localObject).position;
    localObject = ((j)g.r(j.class)).Fw().abl(paramView);
    if (bk.bl(((ao)localObject).field_username)) {
      ((ad)localObject).setUsername(paramView);
    }
    localObject = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new a.1(this, (ad)localObject, j, paramView));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(i));
    ((com.tencent.mm.pluginsdk.ui.applet.a)localObject).e(paramView, localLinkedList);
  }
  
  public static abstract interface a
  {
    public abstract void T(String paramString, boolean paramBoolean);
    
    public abstract void pS(String paramString);
  }
  
  public static final class b
  {
    public int fhj;
    public int position;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.a
 * JD-Core Version:    0.7.0.1
 */